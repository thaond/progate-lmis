
<%@ include file="../../../lmis/init-tvna.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="../../dialog/dialog-delete.jsp"></jsp:include>
<script type="text/javascript">
		jQuery(document).ready(function() {
			jQuery('input#ctl-add,a#_createChange,a#new').click(function(){
				var url='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
							<portlet:param name="action" value="requestOverTimeDetail" />
			        		<portlet:param name="<%=Request.TAB_OT_ACT%>" value="<%=Request.TAB_OT_PER%>" />
			        		<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.ADD%>" />
			        		<portlet:param name="<%=Request.ROOT_ID%>" value="${bean.rootId }" />
						</portlet:renderURL>';
			document.frmRequestOTList.action=url;
			document.frmRequestOTList.submit();
			});
		});
</script>

<c:choose>
<c:when test="${bean.size ==0 }">
	<%@ include file="../../../lmis/nodata.jsp" %>
</c:when>
<c:otherwise>
<script type="text/javascript">
		jQuery(document).ready(function() {
			
			jQuery('.detailChange').click(function(e)
			{
				var reqId=jQuery(this).parent().find('.hid').val();
				
				var url='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
					<portlet:param name="action" value="requestOverTimeDetail" />
					<portlet:param name="<%=Request.TAB_ACT%>" value="<%=Request.TAB_OT_PER%>" />
					<portlet:param name="reqId" value="xreqIdx" />
					<portlet:param name="<%=Request.ROOT_ID%>" value="${bean.rootId}" />
					<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.VIEW%>" />
				</portlet:renderURL>';
				url = url.replace("xreqIdx",reqId);
				
				document.frmRequestOTList.action=url;
				document.frmRequestOTList.submit();
			});
			jQuery('.editChange').click(function(e){
				var reqId=jQuery(this).parent().find('.hid').val();
				var url='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
    				<portlet:param name="action" value="requestOverTimeDetail" />
					<portlet:param name="<%=Request.TAB_OT_ACT%>" value="<%=Request.TAB_OT_PER%>" />
					<portlet:param name="<%=Request.ROOT_ID%>" value="${bean.rootId}" />
					<portlet:param name="reqId" value="xreqIdx" />
					<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.EDIT%>" />
				</portlet:renderURL>';
				url = url.replace("xreqIdx",reqId);
				document.frmRequestOTList.action=url;
				document.frmRequestOTList.submit();
			});
			jQuery('.cancelChange').click(function(e){
				var rootId=jQuery(".rootId").val();
				var reqId=jQuery(this).parent().find('.hid').val();
				var href='<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
					<portlet:param name="action" value="requestOverTimeDetail" />
					<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.DELETE%>" />
					<portlet:param name="reqId" value="xreqIdx" />
					<portlet:param name="<%=Request.ROOT_ID%>" value="${bean.rootId }" />
				</portlet:actionURL>';
				href = href.replace("xreqIdx",reqId);
				
				jQuery.ajax({
					type: 'POST',
					url: href,
					data:{
						
					},
					success: function(data){
						alert("Bạn đã xóa thành công");
						var url='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
								<portlet:param name="action" value="requestOverTime" />
		            			<portlet:param name="<%=Request.TAB_OT_ACT%>" value="<%=Request.TAB_OT_PER %>" />
		            			<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.MANAGE%>" />
		            			<portlet:param name="<%=Request.ROOT_ID %>" value="${bean.rootId }" />
							</portlet:renderURL>';
						document.frmRequestOTList.action=url;
						document.frmRequestOTList.submit();
					},
					error: function(data) {
						alert("Bạn đã xóa thành công");
						var url='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
							<portlet:param name="action" value="requestOverTime" />
	            			<portlet:param name="<%=Request.TAB_OT_ACT%>" value="<%=Request.TAB_OT_PER %>" />
	            			<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.MANAGE%>" />
	            			<portlet:param name="<%=Request.ROOT_ID %>" value="${bean.rootId }" />
						</portlet:renderURL>';
					document.frmRequestOTList.action=url;
					document.frmRequestOTList.submit();
					}
				});
				
			});

		});
		function pagingSubmit(){ 
			var url='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
				<portlet:param name="action" value="requestOverTime" />
				<portlet:param name="<%=Request.TAB_OT_ACT%>" value="<%=Request.TAB_OT_PER %>" />
				<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.MANAGE%>" />
				<portlet:param name="<%=Request.ROOT_ID %>" value="${bean.rootId }" />
			</portlet:renderURL>';
			document.frmRequestOTList.action=url;
			document.frmRequestOTList.submit();
		}
	</script>

<form action="" name="frmRequestOTList" method="post">
    			
  	<div class="createChange"  >
		<input id="ctl-add" type="image" src="/ProGate-portlet/images/lmis/add.png" width="24px" height="24px"
			href="#" id="mode-edit-active">
	   	<a id="_createChange" href="#"><fmt:message key="lmis.common.create" /></a>
    </div>
	<div class="content">
		<div class="tableContainer" style="min-height: 315px;">
			<table width="100%" border="0" cellspacing="0">
				<thead style="color:#ffffff">
					<tr>
						<th width="40px" scope="col"><fmt:message key="lmis.common.number" /> </th>
						<th width="25%" scope="col"><fmt:message key="lmis.ot.nameorg.list" /></th>
						<th width="90px" scope="col">Ngày Tạo</th>
						<th width="90px" scope="col">Ngày Tăng Ca</th>
						<th width="25%" scope="col"><fmt:message key="lmis.ot.regby" /></th>
						<th width="12%" scope="col"><fmt:message key="title.organization.status" /></th>
						<th width="100px" scope="col"></th>
					</tr>
				</thead>

				<tbody>

					<c:forEach var="item" items="${bean.ls }" varStatus="i">
						<c:choose>
							<c:when test="${i.count%2!=0 }">
								<tr class="oddrow">
							</c:when>
							<c:otherwise>
								<tr class="evenrow">
							</c:otherwise>
						</c:choose>
									<td class="cls-center">${i.count }</td>
									<td class="cls-left">
										${item.orgName }
									</td>
									<td class="cls-center">
										<fmt:formatDate pattern="dd/MM/yyyy" value="${item.createdAt}" />
									</td>
									<td class="cls-center">
										<fmt:formatDate pattern="dd/MM/yyyy" value="${item.requestedAt}" />
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
											<c:when test="${item.requestedStatus ==6 }">
												<fmt:message key="lmis.ot.type.reported" />
											</c:when>
										</c:choose>
									</td>
									<c:choose>
										<c:when test="${item.requestedBy!=bean.userId && item.requestedStatus ==bean.otPending }">
											<td>
												<input class="hid" type="hidden"  value="${item.otReqsId }" />
												<input class="detailChange" type="image" src="/ProGate-portlet/images/lmis/detail.png" title='<fmt:message key="button.view" />'/>
												<input class="editChange"  type="image" src="/ProGate-portlet/images/lmis/Edit_disable.png" disabled="disabled" title='<fmt:message key="button.edit" />'/>
												<input class="cancelChange"  type="image" src="/ProGate-portlet/images/lmis/disable_cancel.png" disabled="disabled" title='<fmt:message key="button.delete" />'/>
											</td>
										</c:when>
										<c:when test="${item.requestedStatus ==bean.otPending }">
											<td>
												<input class="hid" type="hidden"  value="${item.otReqsId }" />
												<input class="detailChange" type="image" src="/ProGate-portlet/images/lmis/detail.png" title='<fmt:message key="button.view" />'/>
												<input class="editChange" type="image" src="/ProGate-portlet/images/lmis/edit.png" title='<fmt:message key="button.edit" />'/>
												<input class="cancelChange" type="image" src="/ProGate-portlet/images/lmis/Cancel.png" title='<fmt:message key="button.delete" />'/>
											</td>
										</c:when>
										<c:when test="${item.requestedStatus ==bean.otBaned }">
											<td>
												<input class="hid" type="hidden"  value="${item.otReqsId }" />
												<input class="detailChange" type="image" src="/ProGate-portlet/images/lmis/detail.png" title='<fmt:message key="button.view" />'/>
												<input class="editChange"  type="image" src="/ProGate-portlet/images/lmis/Edit_disable.png" disabled="disabled" title='<fmt:message key="button.edit" />'/>
												<input class="cancelChange"  type="image" src="/ProGate-portlet/images/lmis/disable_cancel.png" disabled="disabled" title='<fmt:message key="button.delete" />'/>
											</td>
										</c:when>
										<c:otherwise>
											<td>
												<input class="hid" type="hidden" value="${item.otReqsId }" />
												<input class="detailChange" type="image" src="/ProGate-portlet/images/lmis/detail.png" title='<fmt:message key="button.view" />'/>
												<input class="editChange" type="image" src="/ProGate-portlet/images/lmis/Edit_disable.png" disabled="disabled" title='<fmt:message key="button.edit" />'/>
												<input class="cancelChange" type="image" src="/ProGate-portlet/images/lmis/disable_cancel.png" disabled="disabled" title='<fmt:message key="button.delete" />'/>
											</td>
										</c:otherwise>
									</c:choose>
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
	<input type="hidden" class="rootId" name="rootId" value="${bean.rootId }" />
</form>
</c:otherwise>
</c:choose>
<div id="backgroundLoading" >
	<div id="imgLoad">
	<img  src="/ProGate-portlet/images/lmis/loader.gif" />
	</div>
</div>