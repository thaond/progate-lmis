<%@ include file="../../../lmis/init-tvna.jsp" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" %>

<script type="text/javascript">
<!--
jQuery(function(){
	jQuery('input[name="btnView"]').click(function(){
		jQuery("#selectedPart option[value='-1']").attr('selected','selected');
		var url='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
			<portlet:param name="action" value="reportDayOff" />
			<portlet:param name="<%=Request.TAB_ACTION %>" value="<%=Request.TAB_DAYOFF %>"/>
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
					<portlet:param name="action" value="reportDayOff" />
					<portlet:param name="<%=Constants.CMD%>" value="<%=Request.SELECTED%>"/>
					<portlet:param name="<%=Request.TAB_ACTION %>" value="<%=Request.TAB_DAYOFF %>"/>
					<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
				</portlet:renderURL>';
	submit(url);
}
function submit(url){
	document.frmDayOffReport.action=url;
	document.frmDayOffReport.submit();
}
function pagingSubmit(){ 
	jQuery('#frmDayOffReport').submit(); 
}
//-->
</script>
<form action="" name="frmDayOffReport" id="frmDayOffReport" method="post">
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
		<div class="tableContainer" style="overflow:auto; width:905px">
			<table class="table" style="overflow-y:auto;overflow-x:hidden;width:340%" >
				<thead style="color:#ffffff">
					<tr>
						<th class="styleSTT" style="height:23px" rowspan="2"><fmt:message key="lmis.common.number"/></th>
	    				<th width="60px" rowspan="2">Mã NV</th>
	    				<th width="170px" rowspan="2">Họ Tên Nhân Viên</th>
	    				<th width="84px" rowspan="2" title="Tổng số ngày được nghỉ">TS Ngày Được Nghỉ</th>
	    				<th width="84px" rowspan="2" title="Tổng số ngày nghỉ có phép">TS Ngày Nghỉ Có Phép</th>
	    				<th width="84px" rowspan="2" title="Tổng số ngày nghỉ không phép">TS Ngày Nghỉ Không Phép</th>
	    				<th width="84px"rowspan="2" title="Tổng số ngày đã nghỉ">TS Ngày Đã Nghỉ</th>
	    				 <c:forEach var="items" items="${bean.lsNameAb}">
	    					<th width="50px" colspan="3" style="height:23px" >${items.name_ }</th>
	    				</c:forEach> 
	    				
	    			</tr>
	    			<tr>
	    				<c:forEach var="items" items="${bean.lsNameAb}">
	    					<th style="height:23px">Đã Xin</th>
	    					<th style="height:23px">Đã Duyệt</th>
	    					<th style="height:23px">Đã Nghỉ</th>
	    				</c:forEach>
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
									<td class="cls-num-right">${functions:getDetailSummayReportDouble(items.userId,bean.month,bean.month,bean.year,bean.orgId,8)}</td>
									<td class="cls-num-right">${functions:getDayOffHavePermission(items.userId, bean.month, bean.year, bean.orgId) }</td>
									<td class="cls-num-right">${functions:getDayOffDontHavePermission(items.userId, bean.month, bean.year, bean.orgId) }</td>
									<td class="cls-num-right">${functions:getTotalDayOff(items.userId,bean.month,bean.year,bean.orgId)}</td>
									<c:forEach var="item" items="${bean.lsNameAb}">
										<td class="cls-num-right">${functions:getAbsenceDetail(items.userId,bean.month,bean.year,bean.orgId,item.lmisAbsenceSettingsId,1)}</td>
										<td class="cls-num-right">${functions:getAbsenceDetail(items.userId,bean.month,bean.year,bean.orgId,item.lmisAbsenceSettingsId,2)}</td>
										<td class="cls-num-right">${functions:getAbsenceDetail(items.userId,bean.month,bean.year,bean.orgId,item.lmisAbsenceSettingsId,3)}</td>
									</c:forEach> 
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