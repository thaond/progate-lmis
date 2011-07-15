<%@ include file="../../../lmis/init-tvna.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<script type="text/javascript">

	jQuery(function() {	
		var href='<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>">
					<portlet:param name="action" value="commonController" />
					<portlet:param name="<%=Request.TAB_ACT%>" value="<%=Request.TAB_PERSONAL%>" />
					<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
					</portlet:renderURL>';
		var close = function(){			
			document.frmChangeWorkingTimeList.action=href;
			document.frmChangeWorkingTimeList.submit();
		};
		jQuery(".detailChange").click(function(e){
			e.preventDefault();
			var id=e.currentTarget.parentNode.getElementsByTagName("input")[3].value;
			var url = '<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
							<portlet:param name="action" value="changeWorkingTimeDetail" />
							<portlet:param name="<%=Request.SELECTED_ID%>" value='id_changetime' />
							<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
							<portlet:param name="<%=Request.TAB_ACT%>" value="<%=Request.TAB_PERSONAL%>" />
							<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.VIEW%>" />
						</portlet:renderURL>';
			submit(url,id);
		});
		jQuery(".editChange").click(function(e){
			e.preventDefault();
			var id=e.currentTarget.parentNode.getElementsByTagName("input")[3].value;
			var url='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
						<portlet:param name="action" value="changeWorkingTimeDetail" />
						<portlet:param name="<%=Request.SELECTED_ID%>" value="id_changetime" />
						<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
						<portlet:param name="<%=Request.TAB_ACT%>" value="<%=Request.TAB_PERSONAL%>" />
						<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.EDIT%>" />
					</portlet:renderURL>';
			submit(url,id);
		});

		jQuery(".cancelChange").click(function(e){
			//var id=jQuery(this).parent().find('input')[3].value;
			//var code =jQuery(this).parent().prev().find('input');
			e.preventDefault();
			var id=e.currentTarget.parentNode.getElementsByTagName("input")[3].value;
			var url='<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>">
						<portlet:param name="action" value="changeWorkingTimeDetail" />
						<portlet:param name="<%=Request.SELECTED_ID%>" value="id_changetime" />
						<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
						<portlet:param name="<%=Request.TAB_ACT%>" value="<%=Request.TAB_PERSONAL%>" />
						<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.DELETE%>" />
					</portlet:renderURL>';
			url=url.replace('id_changetime',id);
			jQuery("#deleteComfirm").css("display", "block");
	    	jQuery("#deleteComfirm").data('url',url).data('close',close).dialog("open");
		});

		jQuery(".createChange").click(function(e){
			e.preventDefault();
			var url='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
						<portlet:param name="action" value="changeWorkingTimeDetail" />
						<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
						<portlet:param name="<%=Request.TAB_ACT%>" value="<%=Request.TAB_PERSONAL%>" />
						<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.ADD%>" />
					</portlet:renderURL>';
			var id=0;
			submit(url,id);
		});
	});

	function submit(url,id){
		if(id!=0){
			url=url.replace('id_changetime',id);
		}
		//document.frmChangeWorkingTimeList.cancelChangeID.value=id;
		document.frmChangeWorkingTimeList.action=url;
		document.frmChangeWorkingTimeList.submit();
	}
	
	function pagingSubmit(){ 
		var url='<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>">
				<portlet:param name="action" value="commonController" />
				<portlet:param name="<%=Request.TAB_ACT%>" value="<%=Request.TAB_PERSONAL%>" />
				<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
				</portlet:renderURL>';
		document.frmChangeWorkingTimeList.action=url;
		document.frmChangeWorkingTimeList.submit();
	}
</script>
<jsp:include page="../../dialog/dialog-delete.jsp"></jsp:include>



<form action="" name="frmChangeWorkingTimeList" id="frmChangeWorkingTimeList" method="post">
	<div class="createChange">
    	<input id="createChange" type="image" src="/ProGate-portlet/images/lmis/add.png" height="24px" width="24px" />
    	<a id="_createChange" href="#"><fmt:message key="lmis.common.create" /></a>
    </div>
    <c:choose>
    	<c:when test="${bean.size ==0 }">
			<%@ include file="../../../lmis/noDataManager.jsp" %>
		</c:when>
		<c:otherwise>
		    <div class="content">
				<div class="tableContainer" style="min-height: 315px">
					<table width="100%" border="0" cellspacing="0">
						<thead style="color:#ffffff">
							<tr>
								<th class="styleSTT" scope="col"><fmt:message key="lmis.common.number" /> </th>
								<th width="10%"  scope="col"><fmt:message key="lmis.changeworkingtime.codeform" /> </th>
								<th width="22%"  scope="col"><fmt:message key="lmis.changeworkingtime.startdate" /></th>
								<th width="22%" scope="col"><fmt:message key="lmis.changeworkingtime.enddate" /></th>
								<th width="30%" scope="col"><fmt:message key="lmis.common.status" /></th>
								<th scope="col"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="itemLmisTimeChangeRequest" items="${bean.timeChangeRequest}" varStatus="itemCount">
								<c:choose>
									<c:when test="${itemLmisTimeChangeRequest.requestedStatus==2 && (functions:compareDate(bean.dayValue,itemLmisTimeChangeRequest.endDate)< 0 || functions:compareDate(bean.dayValue,itemLmisTimeChangeRequest.endDate) == 0)}">
										<tr class="hightLight">
									</c:when>
									<c:when test="${itemCount.count % 2 !=0 }">
										<tr class="oddrow">
									</c:when>
									<c:otherwise>
										<tr class="evenrow">
									</c:otherwise>
								</c:choose>
											<td>${itemCount.count}</td>
											<td>
												${itemLmisTimeChangeRequest.lmisTimeChangeRequestId}
											</td>
											<td>
												<fmt:formatDate pattern="dd/MM/yyyy" value="${itemLmisTimeChangeRequest.startDate }" />
											</td>
											<td>
												<fmt:formatDate pattern="dd/MM/yyyy" value="${itemLmisTimeChangeRequest.endDate }" />
											</td>
											<td class="cls-left">
												<c:choose>
													<c:when test="${itemLmisTimeChangeRequest.requestedStatus==1}">
														<fmt:message key="status.waiting" />
													</c:when>
													<c:when test="${itemLmisTimeChangeRequest.requestedStatus==2}">
														<fmt:message key="status.agree" />
													</c:when>
													<c:when test="${itemLmisTimeChangeRequest.requestedStatus==3}">
														<fmt:message key="status.notagree" />
													</c:when>
												</c:choose>
											</td>
											<td>
													<input class="detailChange" type="image" src="/ProGate-portlet/images/lmis/detail.png" height="24" width="24"
													title='<fmt:message key="lmis.viewDetail" />'/>
											<c:choose>
												<c:when test="${itemLmisTimeChangeRequest.requestedStatus==3 || itemLmisTimeChangeRequest.requestedStatus==2 }">
		
													<input class="editChange" type="image" src="/ProGate-portlet/images/lmis/Edit_disable.png" disabled="disabled" height="24" width="24"/>
													<input class="cancelChange" type="image" src="/ProGate-portlet/images/lmis/disable_cancel.png" disabled="disabled" height="24" width="24"/>
												</c:when>
												<c:when test="${itemLmisTimeChangeRequest.requestedStatus==1}">
													<input class="editChange" type="image" src="/ProGate-portlet/images/lmis/edit.png"  title='<fmt:message key="lmis.edit" />' height="24" width="24"/>
													<input class="cancelChange" type="image" src="/ProGate-portlet/images/lmis/Cancel.png" title='<fmt:message key="lmis.deployForm" />'height="24" width="24"/>
												</c:when>
											</c:choose>
											<input type="hidden" class="selectTimeChangeID" value='<c:out value="${itemLmisTimeChangeRequest.lmisTimeChangeRequestId}" />'/>
											</td>
										</tr>
							</c:forEach>
						</tbody>
					</table>
				</div><!--End tableContainer-->
		<div class="lmis-paging"> 
					<c:set value="${bean.pagination}" var="paging"></c:set> 
						<%@ include file="/html/portlet/common/pagination.jsp" %>  
		</div>
		</div><!--End content-->
	</c:otherwise>
	</c:choose>
</form>

