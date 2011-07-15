<%@ include file="../../../lmis/init-tvna.jsp" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" %>
<script type="text/javascript">
<!--
jQuery(function(){
	jQuery('input[name="btnView"]').click(function(){
		jQuery("#selectedPart option[value='-1']").attr('selected','selected');
		var url='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
			<portlet:param name="action" value="reportOverTime" />
			<portlet:param name="<%=Request.TAB_ACTION %>" value="<%=Request.TAB_OVERTIME %>"/>
			<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
			</portlet:renderURL>';
		submit(url);
	});
	
	jQuery(".txt-search").focus(function() {
		if (jQuery(this).val() == '<fmt:message key="lmis.common.find" />') {
			jQuery(this).val('');
		}
	});
	jQuery(".txt-search").blur(function(){
		if (jQuery(this).val() == "") {
			jQuery(this).val('<fmt:message key="lmis.common.find" />');
		}
	});
});
function mySelect(){
	var url = '<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
					<portlet:param name="action" value="reportOverTime" />
					<portlet:param name="<%=Constants.CMD%>" value="<%=Request.SELECTED%>"/>
					<portlet:param name="<%=Request.TAB_ACTION %>" value="<%=Request.TAB_OVERTIME %>"/>
					<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
				</portlet:renderURL>';
	submit(url);
}
function submit(url){
	document.frmOverTimeReport.action=url;
	document.frmOverTimeReport.submit();
}
function pagingSubmit(){ 
	jQuery('#frmOverTimeReport').submit(); 
}
//-->
</script>
<form action="" name="frmOverTimeReport" id="frmOverTimeReport" method="post">
	<div class="content">
		<div class="filter">
			<div style="margin-left:10px">
				<label><fmt:message key="lmis.common.month"/></label>
				<span><select style="width:50px" name="month">
					<c:forEach var="i" begin="1" end="12" step="1">
								<c:choose>
									<c:when test="${i == bean.month}">
										<option value="${i}" selected="selected"><c:out value="${i}"/></option>
									</c:when>
									<c:otherwise><option value="${i}"><c:out value="${i}"/></option></c:otherwise>
								</c:choose>								
							</c:forEach>
				</select> </span>
			</div>
			<div>
				<label><fmt:message key="title.year"/></label>
				<span>
						<input type="text" name="year" style="width:5em" value="${bean.year}">
						<input type="button" name="btnView" value="Xem" id="view">
				</span>
			</div>
			<div>
				<label><fmt:message key="lmis.attendanceInfo.part"/></label>
				<span><select style="width:200px" name="selectedPart" onchange="mySelect()">
					<option value="-1">
							<c:out value="Tất cả"/>
						</option>
						<c:forEach var="list" items="${bean.lsPart}" varStatus="itemCount">
							<c:choose>
								<c:when test="${list.orgId == bean.selectedPartId}">
									<option  value="${list.orgId }" selected="selected">
	                                             <c:out value="${list.name}"/>
									</option>
								</c:when>
								<c:otherwise>
									<option value="${list.orgId}">
										<c:out value="${list.name}"/>
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</select></span>
			</div>
			<div>
				<input class="txt-search" type="text" name="<%=Constants.SEARCH %>" size="27px" value='<fmt:message key="lmis.common.find"/>'/>
				<span class="bt-search">&nbsp</span>
			</div>
			<div class="clear"></div>
		</div>
		<div class="tableContainer" style="overflow:auto">
			<table class="table" style="overflow-y:auto;overflow-x:hidden;width:183%" >
				<thead style="color:#ffffff">
					<tr>
						<th class="styleSTT" style="height:23px" rowspan="2"><fmt:message key="lmis.common.number"/></th>
	    				<th width="90px">Mã NV</th>
	    				<th width="300px">Họ Tên Nhân Viên</th>
	    				<c:forEach var="items" items="${bean.lsName}" varStatus="itemCount">
	    					<th width="135px" title="Thời gian tăng ca chưa nhân hệ số">TGTC ${items.description}<br/> Chưa Nhân Hệ Số</th>
	    				</c:forEach>
	    				<th width="100px" title="Thời gian tăng ca ngày nghỉ">TGTCNN (Giờ)<br/> Chưa Nhân Hệ Số</th>
	    				<th width="95px" title="Tổng thời gian tăng ca">TTGTC (Giờ)<br/> Đã Nhân Hệ Số</th>
	    				<th width="100px" title="Số ngày nghỉ bù tăng ca tổng cộng">Số Ngày NBTC<br/> Tổng Cộng</th>
	    				<th width="100px" title="Số ngày nghỉ bù tăng ca đã nghỉ">Số Ngày NBTC<br/> Đã Nghỉ</th>
	    				<th width="100px" title="Số ngày nghỉ bù tăng ca còn lại">Số Ngày NBTC<br/> Còn Lại</th>
	    				<th width="100px" title="Số ngày nghỉ bù tăng ca cho tháng sau">Số Ngày NBTC<br/> Cho Tháng Sau</th>
	    				<th width="100px">Số Giờ Thưởng</th>
	    			</tr>		
				</thead>
				<tbody>
					<c:forEach var="items" items="${bean.lsUser}" varStatus="itemCount">
    					<c:choose>
							<c:when test="${itemCount.count % 2 !=0 }">
								<tr class="oddrow">
							</c:when>
							<c:otherwise>
								<tr class="evenrow">
							</c:otherwise>
						</c:choose>
									<td>${itemCount.count}</td>
									<td>${items.staffCode }</td>
									<td class="cls-left">${items.fullName}</td>
									<c:forEach var="item" items="${bean.lsName}" varStatus="itemCount">
										<td class="cls-stt-right">${functions:getTotalHourOT(items.userId,bean.month,bean.year,bean.orgId,item.lmisOverTimeTypesId)}</td>
									</c:forEach>
									<td class="cls-stt-right">0.0</td>
									<td class="cls-stt-right">${functions:getOverTimeHour(items.userId,bean.month,bean.year,bean.orgId)}</td>
									<td class="cls-stt-right">${functions:getTotalDayAbsenceCompensasion(items.userId,bean.month,bean.year,bean.orgId,1)}</td>
									<td class="cls-stt-right">${functions:getTotalDayAbsenceCompensasion(items.userId,bean.month,bean.year,bean.orgId,2)}</td>
									<td class="cls-stt-right">${functions:getTotalDayAbsenceCompensasion(items.userId,bean.month,bean.year,bean.orgId,3)}</td>
									<td class="cls-stt-right">${functions:getDayCompensationNextMonth(items.userId,bean.month,bean.year,bean.orgId)}</td>
									<td class="cls-stt-right">${functions:getTotalHourOverTimeReward(items.userId,bean.month,bean.year,bean.orgId)}</td>
							</tr>
					</c:forEach>
				</tbody>
			</table>
		</div><!-- end container -->
		<div class="lmis-paging"> 
					<c:set value="${bean.pagination}" var="paging"></c:set> 
						<%@ include file="/html/portlet/common/pagination.jsp" %>  
		</div>
	</div><!-- end content -->
</form>