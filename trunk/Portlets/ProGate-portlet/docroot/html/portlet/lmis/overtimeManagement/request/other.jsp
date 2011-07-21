
<%@ include file="../../../lmis/init-tvna.jsp" %>
<%@ page import="larion.progate.lmis.service.utils.LmisConst" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
	<script type="text/javascript">
		jQuery(function (){
			if (${bean.selectedStatus == 1}){
				jQuery("#status option[value='1']").attr('selected','selected');
			}
			if(${bean.selectedStatus == 2}){
				jQuery("#status option[value='2']").attr('selected','selected');
			}
			if(${bean.selectedStatus == 3}){
				jQuery("#status option[value='3']").attr('selected','selected');
			}
			if(${bean.selectedStatus == 4}){
				jQuery("#status option[value='4']").attr('selected','selected');
			}
			if(${bean.selectedStatus == 5}){
				jQuery("#status option[value='5']").attr('selected','selected');
			}
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
		<div class="filter" style="height: 20px; padding-top: 10px;">
			<div class="selected-org">
				<fmt:message key="lmis.ot.nameorg"/>
				<select name="selectedOrg" style="width: 350px;">
					<option value="-1"><fmt:message key="lmis.common.all"/></option>
				<c:forEach var="subOrg" items="${bean.listSubOrg}" varStatus="countItems">
					<c:choose>
						<c:when test="${bean.selectedOrg == subOrg.orgId}">
							<option selected="selected" value="${subOrg.orgId}">${subOrg.name}</option>
						</c:when>
						<c:otherwise>
							<option value="${subOrg.orgId}">${subOrg.name}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				</select>
			</div>
			<div class="selected-status">
				<fmt:message key="lmis.common.statusLower"/>
				<select id="status" name="selectedStatus" style="width: 150px;">
						<option id="allStatus" value="-1" ><fmt:message key="lmis.common.all"/></option>
						<option id="pending" value="<%=LmisConst.OverTimeReq_Status_Pending%>"><fmt:message key="lmis.overtimeReport.status.pending"/></option>
						<option id="accepted" value="<%=LmisConst.OverTimeReq_Status_Accepted%>"><fmt:message key="lmis.overtimeReport.status.accepted"/></option>
						<option id="notAccepted" value="<%=LmisConst.OverTimeReq_Status_NotAccept%>"><fmt:message key="lmis.overtimeReport.status.notAccepted"/></option>
						<option id="reported" value="<%=LmisConst.OverTimeReq_Status_Created_Report%>"><fmt:message key="lmis.ot.type.reported"/></option>
						<option id="banned" value="<%=LmisConst.OverTimeReq_Status_Ban%>"><fmt:message key="lmis.ot.type.baned"/></option>
				</select>
			</div>
			<div class="search-button" style="margin-top: -3px">
				<input id="filter" type="submit" style="height: 26px" class="view" value='<fmt:message key="button.view"/>' />
			</div>
		</div>
			<table width="100%" border="0" cellspacing="0">
				<thead style="color:#ffffff">
					<tr>
					<th width="40px" scope="col"><fmt:message key="lmis.common.number" /> </th>
						<th width="25%" scope="col"><fmt:message key="lmis.ot.nameorg.list" /></th>
						<th width="90px" scope="col">Ngày tạo</th>
						<th width="90px" scope="col">Ngày tăng ca</th>
						<th width="25%" scope="col"><fmt:message key="lmis.ot.regby" /></th>
						<th width="12%" scope="col"><fmt:message key="title.organization.status" /></th>
						<th width="80px" scope="col"></th>
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
											<c:when test="${item.requestedStatus ==6 }">
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