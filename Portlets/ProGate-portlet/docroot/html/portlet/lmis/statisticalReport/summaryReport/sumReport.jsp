<%@ include file="../../../lmis/init-tvna.jsp" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" %>

<script type="text/javascript">
<!--

jQuery(function(){
	jQuery('input[name="btnView"]').click(function(){
		jQuery("#selectedPart option[value='-1']").attr('selected','selected');
		var url='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
			<portlet:param name="action" value="reportSummary" />
			<portlet:param name="<%=Request.TAB_ACTION %>" value="<%=Request.TAB_REPORT %>"/>
			<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
			</portlet:renderURL>';
		submit(url);
	});
	
	jQuery('#fromMonth').change(function(){
		var fromMonth = parseInt(jQuery("#fromMonth").val());
		var toMonth = parseInt(jQuery("#toMonth").val());
		jQuery("#toMonth option").each(function() {
			jQuery(this).remove();
		});
		for(i = fromMonth+1;i<13;i++ ){
			jQuery('#toMonth').append(jQuery('<option></option>').val(i).html(i));
		}
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
					<portlet:param name="action" value="reportSummary" />
					<portlet:param name="<%=Constants.CMD%>" value="<%=Request.SELECTED%>"/>
					<portlet:param name="<%=Request.TAB_ACTION %>" value="<%=Request.TAB_REPORT %>"/>
					<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
				</portlet:renderURL>';
	submit(url);
}
function submit(url){
	document.frmSumReport.action=url;
	document.frmSumReport.submit();
}
function pagingSubmit(){ 
	jQuery('#frmSumReport').submit(); 
}
//-->
</script>
<form action="" name="frmSumReport" id="frmSumReport" method="post">
	<div class="content">
		<div class="filter">
			<div style="margin-left:10px">
				<label>Từ tháng</label>
				<span><select style="width:50px" name="fromMonth" id="fromMonth">
					<c:forEach var="i" begin="1" end="12" step="1">
							<c:choose>
								<c:when test="${i == bean.fromMonth}">
									<option value="${i}" selected="selected"><c:out value="${i}"/></option>
								</c:when>
								<c:otherwise><option value="${i}"><c:out value="${i}"/></option></c:otherwise>	
							</c:choose>											
					</c:forEach>
				</select> </span>
			</div>
			<div >
				<label>Đến tháng</label>
				<span><select style="width:50px" name="toMonth" id="toMonth">
					<c:forEach var="i" begin="1" end="12" step="1">
							<c:choose>
								<c:when test="${i == bean.toMonth}">
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
			<div class="clear"></div>
			<div style="margin:10px">
				<input class="txt-search" type="text" name="<%=Constants.SEARCH %>" size="27px" value='<fmt:message key="lmis.common.find"/>'/>
				<span class="bt-search">&nbsp</span>
			</div>
			<div class="clear"></div>
		</div>
		<div class="tableContainer" style="overflow:auto">
			<table class="table" style="overflow-y:auto;overflow-x:hidden;width:125%" >
				<thead style="color:#ffffff">
					<tr>
						<th class="styleSTT" style="height:23px" rowspan="2"><fmt:message key="lmis.common.number"/></th>
	    				<th width="90px" title="Mã nhân viên">Mã NV</th>
	    				<th width="300px">Họ Tên Nhân Viên</th>
	    				<th width="100px" title="Tổng số ngày nghỉ  có phép">TSNN<br/>Có Phép</th>
	    				<th width="100px" title="Tổng số ngày nghỉ không phép">TSNN<br/>Không Phép</th>
	    				<th width="95px" title="Tổng thời gian làm việc">TTGLV<br/>(Ngày)</th>
	    				<th width="105px" title="Tổng thời gian đi trễ">TTGĐT<br/>(Phút)</th>
	    				<th width="100px" title="Tổng thời gian về sớm">TTGVS<br/> (Phút)</th>
	    				<th width="100px">Tổng Giờ<br/>Thưởng/Phạt</th>
	    				<th width="115px" title="Thời gian bắt đầu trung bình">TGBDTB</th>
	    				<th width="135px" title="Thời gian kết thúc trung bình">TGKTTB</th>
	    				<th width="100px" title="Tổng thời gian tăng ca">TTGTC<br/>(Giờ)</th>
	    				<th width="100px" title="Tổng thời gian tăng ca được hưởng">TTGTC<br/> Được Hưởng</th>
	    				<th width="100px" title="Tổng số ngày nghỉ phép thường niên">TSN NPTN</th>
	    				<th width="100px" title="Tổng số ngày nghỉ phép thường niên đã nghỉ">TSN NPTN<br/> Đã Nghỉ</th>    				
	    				
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
									<td class="cls-num-right">${functions:getDetailSummayReportDouble(items.userId,bean.fromMonth,bean.toMonth,bean.year,bean.orgId,5)}</td>
									<td class="cls-num-right">${functions:getDetailSummayReportDouble(items.userId,bean.fromMonth,bean.toMonth,bean.year,bean.orgId,6)}</td>
									<td class="cls-num-right">${functions:getDetailSummayReportInt(items.userId,bean.fromMonth,bean.toMonth,bean.year,bean.orgId,3)}</td>
									<td class="cls-num-right">${functions:getDetailSummayReportInt(items.userId,bean.fromMonth,bean.toMonth,bean.year,bean.orgId,1)}</td>
									<td class="cls-num-right">${functions:getDetailSummayReportInt(items.userId,bean.fromMonth,bean.toMonth,bean.year,bean.orgId,2)}</td>
									<td class="cls-num-right">${functions:getDetailSummayReportDouble(items.userId,bean.fromMonth,bean.toMonth,bean.year,bean.orgId,7)}</td>
									<td><fmt:formatDate pattern="HH:mm" value="${functions:getDetailSummayReportDate(items.userId,bean.fromMonth,bean.toMonth,bean.year,bean.orgId,1)}"/></td>
									<td><fmt:formatDate pattern="HH:mm" value="${functions:getDetailSummayReportDate(items.userId,bean.fromMonth,bean.toMonth,bean.year,bean.orgId,2)}"/></td>
									<td class="cls-num-right">${functions:getDetailSummayReportDouble(items.userId,bean.fromMonth,bean.toMonth,bean.year,bean.orgId,1)}</td>
									<td class="cls-num-right">${functions:getDetailSummayReportDouble(items.userId,bean.fromMonth,bean.toMonth,bean.year,bean.orgId,2)}</td>
									<td class="cls-num-right">${functions:getDetailSummayReportInt(items.userId,bean.fromMonth,bean.toMonth,bean.year,bean.orgId,4)}</td>
									<td class="cls-num-right">${functions:getDetailSummayReportDouble(items.userId,bean.fromMonth,bean.toMonth,bean.year,bean.orgId,3)}</td>
									
									
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