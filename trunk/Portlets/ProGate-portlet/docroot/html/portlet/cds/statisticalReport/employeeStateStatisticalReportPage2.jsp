<%@ include file="/html/portlet/cds/init.jsp"%>
<script>
	<%@ include file="/js/cds/libs/base64.js" %>
	<%@ include file="/js/cds/libs/sprintf.js" %>
	<%@ include file="/js/cds/jspdf.js" %>
</script>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
function pagingSubmit() {
    jQuery('#employeeStateReportDetailForm').submit();
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
	<portlet:param name="action" value="cds.statisticalreport.employeeState" />
	<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
	<portlet:param name="<%=RequestConst.TAB_PAGE %>" value="2" />
</portlet:renderURL>
<form id="employeeStateReportDetailForm" method="post" action="${URL }">
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
		<div class="filter-area" style="margin: 2px 2px 10px;">
			<label class="span-3 padding-bottom"><strong>Nhân viên:  </strong></label>
			<label class="span-8 padding-bottom">${bean.employeeName }</label>
			<label class="span-3 last padding-bottom"><strong>Title hiện tại:  </strong></label>
			<label class="span-8 padding-bottom">${bean.employeeTitle }</label>
			<div class="clear"></div>	
			<label class="span-3 "><strong>Chức vụ hiện tại:  </strong></label>
			<label class="span-8 ">${bean.employeePosition } </label>
			<label class="span-3 last "><strong>Dự án hiện tại: </strong></label>
			<label class="span-8 ">${bean.employeeProject } </label>
			<div class="clear"></div>
		</div>
		<div class="clear"></div>
		
		<div class="scroll-x" style="min-height: 450px;">
		<table id="tableReport" style="width: 910px;">
			<thead>
				<tr id="trCompetency">
					<th class="span-1" style="padding: 0px 2px;" rowspan="3">STT</th>
					<th class="span-5" rowspan="3">Đợt CDS</th>
					<th class="span-5" rowspan="3">Chức Danh</th>
					<th class="span-5" rowspan="3">Dự Án</th>
					<th class="" style="padding: 0px 3px;" rowspan="3">Minimum Requirement</th>
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
					<td class=" td-align-left">
					<script> 
						var projects = "- " + "${employee.orgList }";
						//replace all ", " in the string using /g
						projects = projects.replace(/, /g, "<br />- ");
						document.write(projects);
					</script> 
					</td>
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
			<%@ include file="/html/portlet/common/pagination.jsp" %>
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