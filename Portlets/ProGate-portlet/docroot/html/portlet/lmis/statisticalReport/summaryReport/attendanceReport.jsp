<%@ include file="../../../lmis/init-tvna.jsp" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" %>
	
<script type="text/javascript">
<!--
jQuery(function(){
	jQuery('input[name="btnView"]').click(function(){
		jQuery("#selectedPart option[value='-1']").attr('selected','selected');
		var url='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
			<portlet:param name="action" value="commonController" />
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
					<portlet:param name="action" value="commonController" />
					<portlet:param name="<%=Constants.CMD%>" value="<%=Request.SELECTED%>"/>
					<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
				</portlet:renderURL>';
	submit(url);
}
function pagingSubmit(){ 
	var url = '<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
			<portlet:param name="action" value="commonController" />
			<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
			</portlet:renderURL>';
	submit(url);
}
function submit(url){
	document.frmAttendanceReport.action=url;
	document.frmAttendanceReport.submit();
}
//-->
</script>
<form action="" name="frmAttendanceReport" method="post">
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
						<input type="button" id="view" name="btnView" value="Xem">
				</span>
			</div>
			<div>
				<label><fmt:message key="lmis.attendanceInfo.part"/></label>
				<span><select style="width:200px" name="selectedPart" id="selectedPart" onchange="mySelect()">
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
				<input class ="txt-search" type="text" name="<%=Constants.SEARCH %>" size="27px" value='<fmt:message key="lmis.common.find"/>'/>
				<span class="bt-search">&nbsp</span>
			</div>
			<div class="clear"></div>
		</div>
    	<div class="tableContainer" style="overflow:auto">
    		<table class="table" style="overflow-y:auto;overflow-x:hidden;width:130%" >
    			<thead style="color:#ffffff">
    				<tr>
    				<th class="styleSTT"><fmt:message key="lmis.common.number"/></th>
    				<th width="50px">Mã NV</th>
    				<th width="150px">Họ Tên Nhân Viên</th>
    				<th width="70px" title="Giờ bắt đầu làm việc trung bình trong tháng">GBĐLVTB Trong Tháng</th>
    				<th width="70px" title="Giờ kết thúc làm việc trung bình trong tháng">GKTLVTB Trong Tháng</th>
    				<th width="60px"  title="Thời gian đi trễ bị phát">TGĐT BP (Phút)</th>
    				<th width="60px" title="Thời gian về sớm bị phạt">TGVS BP (Phút)</th>
    				<th width="60px" title="Thời gian làm việc">Thời Gian LV (Giờ)</th>
    				<th width="45px" title="Thời gian đi trễ">TGĐT (Phút)</th>
    				<th width="75px" title="Tổng thời gian đi trễ bị phạt đã nhân hệ số">TTGĐT BP (Phút) Đã Nhân Hệ Số</th>
    				<th width="60px" title="Thời gian về sớm">TGVS (Phút)</th>   				
    				<th width="75px" title="Tổng thời gian về sớm đã nhân hệ số">TTGVS BP (Phút) Đã Nhân Hệ Số</th>
    				<th width="50px" title="Giờ bắt đầu làm việc trung bình trong năm">GBĐLVTB Trong Năm</th>    				
    				<th width="50px" title="Giờ kết thúc làm việc trung bình trong năm">GKTLVTB Trong Năm</th>
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
									<td><fmt:formatDate pattern="HH:mm" value="${functions:getAVGTimeStartMonth(items.userId,bean.month,bean.year,bean.orgId)}"/></td>
									<td><fmt:formatDate pattern="HH:mm" value="${functions:getAVGTimeEndMonth(items.userId,bean.month,bean.year,bean.orgId)}"/></td>
									<td class="cls-num-right"> ${functions:getTimeLatePernalty(items.userId,bean.month,bean.year,bean.orgId)}</td>
									<td class="cls-num-right"> ${functions:getTimeEarlyPernalty(items.userId,bean.month,bean.year,bean.orgId)}</td>
									<td class="cls-num-right">${functions:getTotalWorkingTime(items.userId,bean.month,bean.year,bean.orgId)}</td>
									<td class="cls-num-right">${functions:getTimeLate(items.userId,bean.month,bean.year,bean.orgId)}</td>
									<td class="cls-num-right"> ${functions:getTimeLateFinal(items.userId,bean.month,bean.year,bean.orgId)}</td>
									<td class="cls-num-right"> ${functions:getTimeEarly(items.userId,bean.month,bean.year,bean.orgId)}</td>
									<td class="cls-num-right" > ${functions:getTimeEarlyFinal(items.userId,bean.month,bean.year,bean.orgId)}</td>
									<td><fmt:formatDate pattern="HH:mm" value="${functions:getAVGTimeStartYear(items.userId,bean.year,bean.orgId)}"/></td>
									<td><fmt:formatDate pattern="HH:mm" value="${functions:getAVGTimeEndYear(items.userId,bean.year,bean.orgId)}"/></td>
								</tr>
					</c:forEach>
    		</table>
    	</div><!-- tableContainer -->
    	<div class="lmis-paging"> 
					<c:set value="${bean.pagination}" var="paging"></c:set> 
						<%@ include file="/html/portlet/common/pagination.jsp" %>  
		</div>
    </div><!-- End content -->
</form>