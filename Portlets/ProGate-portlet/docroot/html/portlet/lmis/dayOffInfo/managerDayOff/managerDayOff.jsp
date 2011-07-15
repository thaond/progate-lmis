<%@ include file="../../../lmis/init-tvna.jsp" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" %>

<c:if test="${bean.cmd== bean.DELETE }">
	<c:if test="${bean.isSuccess =='yes'}">
		<script type="text/javascript">
			jQuery(function(){
				var url='<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>">
						<portlet:param name="action" value="commonController" />
					<portlet:param name="<%=Request.TAB_ACT%>" value="<%=Request.TAB_PERSONAL%>" />
					<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
				</portlet:renderURL>'
			document.frmManagerDayOffInfo.action=url;
			document.frmManagerDayOffInfo.submit();
			});
		</script>
	</c:if>
</c:if>
	
<script type="text/javascript">
	jQuery(document).ready(function(){
		var progressOpts = {
				width: 200
			};
		 var percenDayOffOT = jQuery("#percenDayOffOT").val();
		jQuery("#dayOffAnnual").reportprogress(${bean.percenDayOffYear});
		jQuery("#dayOffOT").reportprogress(${bean.percenDayOffOT}); 
		jQuery("#dayOffLastYear").reportprogress(${bean.percenDayOffLastYear});
	});
	jQuery(function() {		
		jQuery(".detailRequest").click(function(e){
			e.preventDefault();
			var id=e.currentTarget.parentNode.getElementsByTagName("input")[3].value;
			var url = '<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
							<portlet:param name="action" value="managerDayOffInfo" />
							<portlet:param name="<%=Request.SELECTED_ID%>" value='id_changetime' />
							<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
							<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_PERSONAL%>"/>
							<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.VIEW%>"/>
						</portlet:renderURL>';
			url = url.replace('id_changetime',id);
			submit(url);
		});
		
		jQuery(".editRequest").click(function(e){
			e.preventDefault();
			var id=e.currentTarget.parentNode.getElementsByTagName("input")[3].value;
			var url='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
							<portlet:param name="action" value="managerDayOffInfo" />
							<portlet:param name="<%=Request.SELECTED_ID%>" value='id_changetime' />
							<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
							<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_PERSONAL%>"/>
							<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.EDIT%>"/>
					</portlet:renderURL>';
			url = url.replace('id_changetime',id);
			submit(url);
		});
		
		jQuery(".cancelRequest").click(function(e){
			e.preventDefault();
			var id=e.currentTarget.parentNode.getElementsByTagName("input")[3].value;
			var url='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
							<portlet:param name="action" value="managerDayOffInfo" />
							<portlet:param name="<%=Request.SELECTED_ID%>" value='id_changetime' />
							<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
							<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_PERSONAL%>"/>
							<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.DELETE%>"/>
					</portlet:renderURL>';
			var href ='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
						<portlet:param name="action" value="commonController" />
						<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
						<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_PERSONAL%>"/>
						</portlet:renderURL>';
			url = url.replace('id_changetime',id);
			jQuery("#deleteComfirm").css("display", "block");
	    	jQuery("#deleteComfirm").data('url',url).data('href',href).dialog("open");
		});
		
		jQuery("#create").click(function(){
			var url='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
							<portlet:param name="action" value="managerDayOffInfo"/>
							<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
							<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_PERSONAL%>"/>
							<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.ADD%>"/>
					</portlet:renderURL>';
			submit(url);
		});
	});
	
	function submit(url){
		//document.frmChangeWorkingTimeList.cancelChangeID.value=id;
		document.frmManagerDayOffInfo.action=url;
		document.frmManagerDayOffInfo.submit();
	}	
	function pagingSubmit(){ 
		var url ='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
			<portlet:param name="action" value="commonController" />
			<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
			<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_PERSONAL%>"/>
			</portlet:renderURL>';
		submit(url);
	}
		
</script>
<jsp:include page="../../dialog/dialog-deleteDayOff.jsp"></jsp:include>	
<form action="" name="frmManagerDayOffInfo" id="frmManagerDayOffInfo" method="post">
	 <div id="create" class="cls-rightAngle" style="margin-right:1em">
    	<input id="create" type="image" src="/ProGate-portlet/images/lmis/add.png" height="24px" width="24px">
    	<a id="id-rightAngle" href="#"><fmt:message key="lmis.common.create"/></a>
    </div>
     <c:choose>
    	<c:when test="${bean.size ==0 }">
			<%@ include file="../../../lmis/noDataManager.jsp" %>
		</c:when>
	<c:otherwise>
	
	<div class="content">
		<div class="progressBar">
			<fieldset>
				<legend><fmt:message key="lmis.dayoff.month"/></legend>
				<div style="margin:10px 10px 0 ">
					<label>Tổng số ngày nghỉ phép thường niên: ${bean.dayOffYear} ngày, còn lại: ${bean.dayOffYearRemain} ngày</label>
					<span><div id="dayOffAnnual" class="progressbar" type="text" name="progress" ></div></span>
				</div>
				<div style="padding-top:15px;margin:0 10px 0 10px">
					<label>Tổng số ngày nghỉ bù tăng ca trong tháng: ${bean.dayOffOT} ngày, còn lại: ${bean.dayOffOTRemain} ngày</label>
					<span><div id="dayOffOT" class="progressbar" type="text" name="progress" ></div></span>
				</div>
				<div style="padding-top:15px;margin:0 10px 10px">
					<label>Tổng số ngày nghỉ phép thường niên năm trước: ${bean.dayOffLastYear} ngày, còn lại: ${bean.dayOffLastYearRemain } ngày</label>
					<span><div id="dayOffLastYear" class="progressbar" type="text" name="progress" ></div></span>
				</div>				
			</fieldset>
		</div><!-- end progress -->
		<div class="dayOff">
			<fieldset>
				<legend><fmt:message key="lmis.dayoff.list"/></legend>
				<div class="tableContainer" style="margin-left:0.75em; margin-top:0px;min-height: 315px">
					<table width="100%">
						<thead style="color:#ffffff" >
						<tr>
							<th class="styleSTT"  scope="col"><fmt:message key="lmis.common.number"/> </th>
							<th width="30%"  scope="col"><fmt:message key="lmis.dayoff.type"/> </th>
							<th width="17%"  scope="col"><fmt:message key="lmis.dayoff.begin"/></th>
							<th width="17%" scope="col"><fmt:message key="lmis.dayoff.end"/></th>
							<th width="20%" scope="col"><fmt:message key="lmis.common.status"/></th>
							<th scope="col">&nbsp</th>
						</tr>
						</thead>
						<tbody>
							<c:forEach var="items" items="${bean.listAbsence}" varStatus="itemCount">
								<c:choose>
									<c:when test="${itemCount.count % 2 !=0 }">
										<tr class="oddrow">
									</c:when>
									<c:otherwise>
										<tr class="evenrow">
									</c:otherwise>
								</c:choose>	
											<td>${itemCount.count}</td>
											<td class="cls-left">
												${items.absenceType}
											</td>
											<td><fmt:formatDate pattern="dd/MM/yyyy" value="${items.startDate }"/></td>
											<td><fmt:formatDate pattern="dd/MM/yyyy" value="${items.endDate }"/></td>
											<td class="cls-left">
												<c:choose>
													<c:when test="${items.requestedStatus==1}">
														<fmt:message key="status.waiting" />
													</c:when>
													<c:when test="${items.requestedStatus==2}">
														<fmt:message key="status.agree" />
													</c:when>
													<c:when test="${items.requestedStatus==3}">
														<fmt:message key="status.notagree" />
													</c:when>
													<c:when test="${items.requestedStatus==6}">
														Đã vô hiệu hóa
													</c:when>
												</c:choose>
											</td>
											<td>
												<input class="detailRequest" type="image" src="/ProGate-portlet/images/lmis/detail.png" height="24" width="24"
														title='<fmt:message key="lmis.viewDetail"/>'/>
												<c:choose>
													<c:when test="${items.requestedStatus==1}">
														<input class="editRequest" type="image" src="/ProGate-portlet/images/lmis/edit.png" height="24" width="24"
															title='<fmt:message key="lmis.edit"/>' />
														<input class="cancelRequest" type="image" src="/ProGate-portlet/images/lmis/Cancel.png" height="24" width="24"
															title='Vô hiệu hóa'/>														
													</c:when>
													<c:otherwise>
														<input class="editRequest" type="image" src="/ProGate-portlet/images/lmis/Edit_disable.png" disabled="disabled" height="24" width="24" />
														<input class="cancelRequest" type="image" src="/ProGate-portlet/images/lmis/disable_cancel.png" disabled="disabled" height="24" width="24" />
													</c:otherwise>
												</c:choose>
												<input type="hidden" name="absenceRequestsId" value="${items.lmisAbsenceRequestsId }">
											</td>
									</tr>
							</c:forEach>								
						</tbody>
					</table>
				</div>
				<div class="lmis-paging"> 
					<c:set value="${bean.pagination}" var="paging"></c:set> 
						<%@ include file="/html/portlet/common/pagination.jsp" %>  
				</div>				
			</fieldset>
		</div>
		
	</div><!-- End content -->
	</c:otherwise>
	</c:choose>
	<%-- <input type="hidden" id="percenDayOffOT" value="${bean.percenDayOffOT }"> --%>
</form>