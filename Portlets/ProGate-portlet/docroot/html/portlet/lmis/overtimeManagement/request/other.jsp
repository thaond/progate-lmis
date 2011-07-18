
<%@ include file="../../../lmis/init-tvna.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
	<script type="text/javascript">
		jQuery(function (){
			jQuery('.detailChange').click(function(e)
					{
						var reqId=jQuery(this).parent().find('.hid').val();
						var url='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
							<portlet:param name="action" value="requestOverTimeDetail" />
							<portlet:param name="<%=Request.TAB_ACT%>" value="<%=Request.TAB_OT_OTHER%>" />
							<portlet:param name="reqId" value="xreqIdx" />
							<portlet:param name="otherdetail" value="otherdetail" />
							<portlet:param name="<%=Request.ROOT_ID%>" value="${bean.rootId}" />
							<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.VIEW%>" />
							
						</portlet:renderURL>';
						url = url.replace("xreqIdx",reqId);
						document.frmRequestOTList.action=url;
						document.frmRequestOTList.submit();
					});
		});
		function pagingSubmit(){ 
			
			document.frmRequestOTList.submit();
		}
	</script>
<form action="" name="frmRequestOTList" method="post">

	<div class="content">
		<div class="tableContainer">
			<table width="100%" border="0" cellspacing="0">
				<thead style="color:#ffffff">
					<tr>
						<th width="40px" scope="col"><fmt:message key="lmis.common.number" /> </th>
						<th width="10%" scope="col"><fmt:message key="lmis.ot.date" /> </th>
						<th width="30%" scope="col"><fmt:message key="lmis.ot.nameorg.list" /></th>
						<th width="30%" scope="col"><fmt:message key="lmis.ot.regby" /></th>
						<th width="15%" scope="col"><fmt:message key="title.organization.status" /></th>
						<th width="200px" scope="col"></th>
					</tr>
				</thead>
				<tbody>
						<c:forEach var="item" items="${bean.lsOther }" varStatus="i">
						<c:choose>
							<c:when test="${i.count%2!=0 }">
								<tr class="oddrow">
							</c:when>
							<c:otherwise>
								<tr class="evenrow">
							</c:otherwise>
						</c:choose>
									<td class="cls-center">${i.count }</td>
									<td class="cls-center">
										<fmt:formatDate pattern="dd/MM/yyyy" value="${item.requestedAt}" />
									</td>
									<td class="cls-left">
										${item.orgName }
									</td>
									<td class="cls-left">
										${item.reqFirstName} ${item.reqMiddleName} ${item.reqLastName}
									</td>
									<td class="cls-left">
										<c:choose>
											<c:when test="${item.requestedStatus ==bean.otPending }">
												<fmt:message key="lmis.ot.type.pending" />
											</c:when>
											<c:when test="${item.requestedStatus ==bean.otAccepted }">
												<fmt:message key="lmis.ot.type.ok" />
											</c:when>
											<c:when test="${item.requestedStatus ==bean.otNotAccepted }">
												<fmt:message key="lmis.ot.type.nook" />
											</c:when>
											<c:when test="${item.requestedStatus ==bean.otReported }">
												<fmt:message key="lmis.ot.type.reported" />
											</c:when>
											<c:when test="${item.requestedStatus ==bean.otBaned }">
												<fmt:message key="lmis.ot.type.baned" />
											</c:when>
										</c:choose>
									</td>
									<td>
										<input class="hid" type="hidden" value="${item.otReqsId }" />
										<input class="detailChange" type="image" src="/ProGate-portlet/images/lmis/detail.png" title='<fmt:message key="button.view" />'/>
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
	</div>
	<input type="hidden" id="rootId" name="rootId" value="${bean.rootId }" />
</form>