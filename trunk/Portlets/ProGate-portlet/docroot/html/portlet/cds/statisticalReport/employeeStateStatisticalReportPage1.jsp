<%@ include file="/html/portlet/cds/init.jsp"%>
<script>
	<%@ include file="/js/cds/libs/base64.js" %>
	<%@ include file="/js/cds/libs/sprintf.js" %>
	<%@ include file="/js/cds/jspdf.js" %>
</script>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<c:if test="${bean.periodSize == 0 }">
<div class="cds-container ">
	<div class="left padding-top" style="font-size: 1.1em; color: #E46C0A">
	<img class="absmiddle" src="/ProGate-portlet/images/cds/statisticalReport.png"
		width="40px" height="40px" />
	<strong>Báo Cáo Thống Kê Tình Trạng CDS Của Nhân Viên</strong>
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
    jQuery('#employeeStateReportForm').submit();
}

function demo() {
	var doc = new jsPDF();
	doc.text(20, 20, 'Chao ban!');
	doc.text(20, 30, 'Hien tai chuc nang nay chua duoc thuc hien.');
	doc.addPage();
	doc.text(20, 20, 'Do you like that?');
	doc.setProperties({
		title: 'Báo Cáo Thống Kê Tình Trạng CDS Của Nhân Viên',
		subject: 'Báo Cáo Thống Kê',		
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
		
		<c:forEach items="${bean.employees }" var="employee" varStatus="employeeCount">
			var levelRanking = '${functions:getLevelRankingByCompetencyId(bean.orgId, employee.userId, bean.selectedPeriod, competency.competencyId) }';
			var tdLevelRanking = '<td class="td-align-center">' + levelRanking + '</td>';
			jQuery('#employee'+'${employeeCount.count}').append(tdLevelRanking);
			
			<c:forEach items="${functions:getSlotsReportByCompetencyId(bean.orgId, employee.userId, bean.selectedPeriod, competency.competencyId) }" 
					var="slotReport">
				var style="";
				if(${slotReport.status == bean.selectedPeriod} ) {
					style = 'style="background-color: #FFFF66"';
				}
				/*if slot is approved*/
				if(${slotReport.ratingStatusBod > 0}) {
					var tdSlotReport = '<td class="td-align-center" ' + style + '>' + '${slotReport.pointName}' + '</td>';
				/*slot is evaluated and not approved*/
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
	<portlet:param name="action" value="cds.statisticalreport.employeeState" />
	<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
	<portlet:param name="<%=RequestConst.TAB_PAGE %>" value="1" />
</portlet:renderURL>
<form id="employeeStateReportForm" method="post" action="${URL }">
<div class="cds-container ">
	<div class="left padding-top" style="font-size: 1.1em; color: #E46C0A">
		<img class="absmiddle" src="/ProGate-portlet/images/cds/statisticalReport.png"
			width="40px" height="40px" />
		<strong>Báo Cáo Thống Kê Tình Trạng CDS Của Nhân Viên</strong>
	</div>
	
	<div class="right" style="padding-top: 15px;">
		<a href="javascript:demo()">
			<img id="pdfReport" class="absmiddle" title="Xuất PDF" alt="Xuất PDF"
				src="/ProGate-portlet/images/cds/pdf-icon.png" />
		</a>
	</div>
	<div class="clear"></div>

	<div class=" border-radius" style="margin-bottom: 20px;">
		<div class="filter-area">
			<label class="span-2 ">Đợt CDS  </label>
			<div class="span-8 ">
				<select class="span-7" name="<%=RequestConst.PERIOD_ID %>" onchange="this.form.submit()">
					<c:forEach items="${bean.evaluationPeriods }" var="eP">
						<option value="${eP.cdsEvaluationPeriodsId}"
							<c:if test="${bean.selectedPeriod == eP.cdsEvaluationPeriodsId}">
								<c:out value="selected" />
							</c:if>>${eP.name } - <fmt:formatDate pattern="MM/yyyy" value="${eP.startDate}" /> đến <fmt:formatDate pattern="MM/yyyy" value="${eP.endDate}" />
						</option>
					</c:forEach>
				</select>
			</div>
			<label class="span-2 last ">Dự án</label>
			<div class="span-8 ">
				<select class="span-7" name="<%=RequestConst.PROJECT_ID %>" onchange="this.form.submit()">
					<option value="0"
						<c:if test="${bean.selectedProject == 0}">
							<c:out value="selected" />
						</c:if>>Tất cả
					</option>
					<c:forEach items="${bean.projects }" var="project">
						<option value="${project.orgId}"
							<c:if test="${bean.selectedProject == project.orgId}">
								<c:out value="selected" />
							</c:if>> ${project.name }
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
					<th class="span-4" rowspan="3">Tên Nhân Viên</th>
					<th class="span-3" rowspan="3">Chức Vụ</th>
					<th class="span-2" rowspan="3">Title</th>
					<th class="span-4" rowspan="3">Dự Án Theo Đợt</th>
					<th class="span-3" rowspan="3">Minimum Requirement</th>
					<!-- add competencies here -->
				</tr>
					
				<tr id="trLevel">
				<!-- using script add levels here -->
				</tr>
				
				<tr id="trSlot">
				<!-- using script add slot here -->
				</tr>
			</thead>
			
			<c:if test="${bean.listSize > 0 }">
			<tbody>
			<c:set value="${bean.pagination}" var="paging"></c:set>
				<c:forEach items="${bean.employees }" var="employee" varStatus="count">
				<portlet:renderURL var="employeeDetailPage">
					<portlet:param name="action" value="commonController" />
					<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
					<portlet:param name="<%=RequestConst.EMPLOYEE_ID%>" value="${employee.userId}" />
					<portlet:param name="<%=RequestConst.EMPLOYEE_NAME%>" value="${functions:getUserFullnameByUserId(employee.userId) }" />
					<portlet:param name="<%=RequestConst.TAB_PAGE%>" value="2" />
				</portlet:renderURL>
				<tr id="employee${count.count }">
					<td class="td-align-center">${count.count + (paging.currentPage -1) * paging.pageSize}</td>
					<td class=" td-align-left"><a href="${employeeDetailPage }"> ${functions:getUserFullnameByUserId(employee.userId) }</a></td>
					<c:choose>
					<c:when test="${employee.periodId == bean.selectedPeriod}">
						<td class=" td-align-left">${employee.position }</td>
						<td class=" td-align-left">
							${employee.titleAbbreviation }
							<c:if test="${employee.isTitleUp == true}">
						 		<img  class="absmiddle" src="/ProGate-portlet/images/cds/len-title.png" width="18px" height="18px" />
							</c:if>
						</td>
						<td class=" td-align-left">${employee.orgList }</td>
					</c:when>
					<c:otherwise>
						<td class=" td-align-left"></td>
						<td class=" td-align-left"></td>
						<td class=" td-align-left"></td>
					</c:otherwise>
					</c:choose>
					<td class=" td-align-center">
						<img  class="absmiddle" src="/ProGate-portlet/images/cds/check-green.png" width="18px" height="18px" />
					</td>
					<!-- using script add level ranking here -->
					<!-- using script add slot evaluated in period here -->
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
