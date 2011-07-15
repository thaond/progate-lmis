<%@ include file="/html/portlet/cds/init.jsp"%>
<script>
	<%@ include file="/js/cds/libs/base64.js" %>
	<%@ include file="/js/cds/libs/sprintf.js" %>
	<%@ include file="/js/cds/jspdf.js" %>
</script>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<c:choose>
<c:when test="${bean.hasPermission == false}">
<div class="cds-container ">
	<div class="left padding-top" style="font-size: 1.1em; color: #E46C0A">
		<img class="absmiddle" src="/ProGate-portlet/images/cds/statisticalReport.png"
			width="40px" height="40px" />
		<strong>Báo Cáo Thống Kê Level Mapping </strong>
	</div>
	<div class="clear"></div>
	
	<div class="border-radius" style="min-height: 485px; margin-bottom: 20px;">
		<div class="cds-notification">Rất tiếc! Bạn không có quyền truy cập vào liên kết này.<br/>
			Vui lòng nhấp <a href="#">vào đây</a> để trở lại trang chủ.
		</div>
	</div>	
</div>
</c:when>

<c:otherwise>
<c:if test="${bean.periodSize == 0 }">
<div class="cds-container ">
	<div class="left padding-top" style="font-size: 1.1em; color: #E46C0A">
		<img class="absmiddle" src="/ProGate-portlet/images/cds/statisticalReport.png"
			width="40px" height="40px" />
		<strong>Báo Cáo Thống Kê Level Mapping </strong>
	</div>
	<div class="clear"></div>
	
	<div class="border-radius" style="min-height: 485px; margin-bottom: 20px;">
		<div class="cds-notification" style="margin-top: 20px;">
			Hiện tại không có đợt CDS nào có trạng thái "Đóng".<br/>
			Vui lòng nhấp <a href="#">vào đây</a> để trở lại trang chủ.
		</div>
	</div>	
</div>
</c:if>

<c:if test="${bean.periodSize > 0 }">
<script type="text/javascript">
function pagingSubmit() {
    jQuery('#levelMappingReportForm').submit();
}

function demo() {
	var doc = new jsPDF();
	doc.text(20, 20, 'Chao ban!');
	doc.text(20, 30, 'Hien tai chuc nang nay chua duoc thuc hien.');
	doc.addPage();
	doc.text(20, 20, 'Do you like that?');
	doc.setProperties({
		title: 'Báo cáo thống kê theo level mapping',
		subject: 'This is the subject',		
		author: 'James Hall',
		keywords: 'generated, javascript, web 2.0, ajax',
		creator: 'Nguyen Tien Dung'
	});
	
	// Output as Data URI
	doc.output('datauri');
}

jQuery(function() {
	<c:forEach items="${bean.competencies }" var="competency">
		var colspanCompetency = 1; // 1 is of level ranking
		jQuery('#trLevel').append('<th class="span-2" rowspan="2">Level</th>');
		
		<c:forEach items="${functions:getLevelsByCompetencyId(competency.competencyId) }" var="level">
			var colspanLevel = ${functions:getSlotCountByLevelId(level.levelId) };
			var slotCount = colspanLevel;
			// if level not have slot -> colspan of level is 1
			if(colspanLevel == 0) {
				colspanLevel = 1;
			}
			// colspan of competency is all slots of levels 
			colspanCompetency += colspanLevel;
			var thLevel = '<th colspan="' + colspanLevel + '">' + '${level.name}' + '</th>';
			jQuery('#trLevel').append(thLevel);
			// if level not have slot -> slot name is N/A
			if(slotCount == 0) {
				var thSlot = '<th> N/A </th>';
				jQuery('#trSlot').append(thSlot);
			} else {
				<c:forEach items="${functions:getSlotsByLevelId(level.levelId) }" var="slot">
					var thSlot = '<th>' + '${slot.name}' + '</th>';
					jQuery('#trSlot').append(thSlot);
				</c:forEach>
			}
		</c:forEach>
		
		var thCompetency = '<th colspan="' + colspanCompetency + '">' + '${competency.name}' + '</th>';
		jQuery('#trCompetency').append(thCompetency);
		var addWidth = colspanCompetency * 31;
		var cssObj = {'width' : parseInt(jQuery('#tableReport').css('width')) + addWidth ,};
		jQuery('#tableReport').css(cssObj);
		
		<c:forEach items="${bean.employeeDetail }" var="employee" varStatus="employeeCount">
			var levelRanking = '${functions:getLevelRankingByCompetencyId(bean.orgId, employee.userId, employee.periodId, competency.competencyId) }';
			var tdLevelRanking = '<td class="td-align-center">' + levelRanking + '</td>';
			jQuery('#employee'+'${employeeCount.count}').append(tdLevelRanking);
			
			<c:forEach items="${functions:getSlotsReportByCompetencyId(bean.orgId, employee.userId, employee.periodId, competency.competencyId) }" 
					var="slotReport">
				var style="";
				if(${slotReport.status == employee.periodId} ) {
					style = 'style="background-color: #FFFF66"';
				}
				//if slot is approved
				if(${slotReport.ratingStatusBod > 0}) {
					var tdSlotReport = '<td class="td-align-center" ' + style + '>' + '${slotReport.pointName}' + '</td>';
				//slot is evaluated and not approved
				} else if(${slotReport.ratingStatusBod == 0} && ${slotReport.pointValue > 0}) {
					var tdSlotReport = '<td class="td-align-center" ' + style + '> - </td>';
				} else {
					var tdSlotReport = '<td> </td>';
				}
				jQuery('#employee'+'${employeeCount.count}').append(tdSlotReport);
			</c:forEach>
			
		</c:forEach>
		
	</c:forEach>
	
});
</script>
<portlet:renderURL var="URL">
	<portlet:param name="action" value="cds.statisticalreport.levelMapping" />
	<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
</portlet:renderURL>
<form id="levelMappingReportForm" method="post" action="${URL }">
<div class="cds-container">
	<div class="left padding-top" style="font-size: 1.1em; color: #E46C0A">
		<img class="absmiddle" src="/ProGate-portlet/images/cds/statisticalReport.png"
			width="40px" height="40px" />
		<strong>Báo Cáo Thống Kê Level Mapping </strong>
	</div>
	<div class="clear"></div>
	
	<div style="padding:5px;">
		<label class="span-3 padding-bottom"><strong>Bạn đang ở title:</strong> </label>
		<label class="span-7 padding-bottom" style="color: #E46C0A"> 
			<strong>${bean.currentTitle}</strong> 
		</label>
		<div class="right">
			<a href="javascript:demo()">
				<img id="pdfReport" class="absmiddle" title="Xuất PDF" alt="Xuất PDF"
					src="/ProGate-portlet/images/cds/pdf-icon.png" />
			</a>
		</div>
		<div class="clear"></div>
	</div>
	<div class="clear"></div>
	
	<div class="border-radius" style="margin-bottom: 20px;">
		<div class="filter-area">
			<label class="span-2 ">Đợt CDS  </label>
			<div class="span-8 ">
				<select class="span-7" name="<%=RequestConst.PERIOD_ID %>" onchange="this.form.submit()">
					<option value="0"
						<c:if test="${bean.selectedPeriod == 0}">
							<c:out value="selected" />
						</c:if>>Tất cả
					</option>
					<c:forEach items="${bean.evaluationPeriods }" var="eP">
						<option value="${eP.cdsEvaluationPeriodsId}"
							<c:if test="${bean.selectedPeriod == eP.cdsEvaluationPeriodsId}">
								<c:out value="selected" />
							</c:if>>${eP.name } - <fmt:formatDate pattern="MM/yyyy" value="${eP.startDate}" /> đến <fmt:formatDate pattern="MM/yyyy" value="${eP.endDate}" />
						</option>
					</c:forEach>
				</select>
			</div>
			<div class="clear"></div>
		</div>
		<div class="clear"></div>
		
		<div class="scroll-x" style="min-height: 450px;">
		<table id="tableReport" style="width: 910px;">
			<thead>
				<tr id="trCompetency">
					<th class="span-1" rowspan="3">STT</th>
					<th class="span-5" rowspan="3">Đợt CDS</th>
					<th class="span-5" rowspan="3">Title</th>
					<th class="span-4" rowspan="3">Dự Án</th>
					<th class="span-3" rowspan="3">Minimum Requirement</th>
					<!-- add competencies here -->
				</tr>
					
				<tr id="trLevel">
				<!-- add levels here -->
				</tr>
				
				<tr id="trSlot">
				<!-- add slot here -->
				</tr>
			</thead>
			
			<c:if test="${bean.listSize > 0 }">
			<tbody>
			<c:set value="${bean.pagination}" var="paging"></c:set>
				<c:forEach items="${bean.employeeDetail }" var="employee" varStatus="count">
				<tr id="employee${count.count }">
					<td class="td-align-center">${count.count + (paging.currentPage -1) * paging.pageSize}</td>
					<td class=" td-align-left">${employee.periodName } - <fmt:formatDate pattern="MM/yyyy" value="${employee.fromDate}" /> đến <fmt:formatDate pattern="MM/yyyy" value="${employee.toDate}" /></td>
					<td class=" td-align-left">${employee.titleName }</td>
					<td class=" td-align-left">${employee.orgList }</td>
					<td class=" td-align-center">
						<img  class="absmiddle" src="/ProGate-portlet/images/cds/check-green.png" width="18px" height="18px" />
					</td>
					<!-- add level ranking here -->
					<!-- add slot evaluated in period here -->
				</tr>
				</c:forEach>
				
			</tbody>
			</c:if>
		</table>
		
		<c:if test="${bean.listSize == 0 }">
		<div class="cds-notification" style="color:red;">
			<span>Không có dữ liệu</span>
		</div>
		</c:if>
		
		</div>
		<div class="clear"></div>
		
		<c:if test="${bean.listSize > 10 }">
			<div class="cds-paging">
			<c:set value="${bean.pagination}" var="paging"></c:set>
			<%@ include file="/html/portlet/cds/pagination.jsp" %>
			</div>
			<div class="clear"></div>
		</c:if>
		
		<div style="padding: 5px 8px;" class="cds-footnote">
			<strong>Chú thích: </strong> <img class="absmiddle" src="/ProGate-portlet/images/cds/yellow-light.png" width="18px" height="18px" /> Slot được đánh giá trong đợt đang chọn
		</div>
		<div class="clear"></div>
	</div>
</div>
</form>
</c:if>
</c:otherwise>
</c:choose>
