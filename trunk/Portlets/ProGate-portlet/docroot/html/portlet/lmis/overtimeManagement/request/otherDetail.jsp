<%@ include file="../../../lmis/init-tvna.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<script type="text/javascript">
			jQuery(document).ready(function() {
				jQuery('input').not('intput#ctl-back').attr('disabled','disabled');
				jQuery('textarea').attr('disabled','disabled');
				jQuery('select').attr('disabled','disabled');
				jQuery('input#ctl-back,a#_ctl-back').click(function(){
				var url='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
								<portlet:param name="action" value="otherRequestOverTime" />
				        		<portlet:param name="<%=Request.TAB_OT_ACT%>" value="<%=Request.TAB_OT_OTHER%>" />
				        		<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.MANAGE %>" />
				        		<portlet:param name="<%=Request.ROOT_ID %>" value="${bean.rootId}" />
	    				</portlet:renderURL>';
	    			document.frmRequestOTDetail.action=url;
	    			document.frmRequestOTDetail.submit();
				});
			});
</script>


<form action="" name="frmRequestOTDetail" method="post">

	<div class="createChange">
		    <input id="ctl-back" type="image" src="/ProGate-portlet/images/lmis/undo.png" width="24" height="24"
			href="#" id="mode-edit-active" align="absmiddle">
		   	<a id="_ctl-back" href="#" style=""><fmt:message key="lmis.common.back" /></a>
    </div>
	<div class="cls-ot">
		<div class="title-center"><fmt:message key="title.product.detail" /></div>
		<div class="req-field" style="display:none;"><fmt:message key="title.required.field" /></div>
		<div style="height:20px;width:100%"></div>
		<div class="content-left">
			<table id="tbl-field">
				<thead>
					<tr>
						<th width="150px" scope="col"></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<fmt:message key="lmis.ot.reg.create" />
						</td>
						<td>
							<input class="date-req" type="text" name="today" value='<fmt:formatDate pattern="dd/MM/yyyy" value="${bean.ls.createdAt }"  />' readonly="readonly" />
						</td>
					</tr>
					<tr>
						<td class="cls-org">
							<fmt:message key="lmis.ot.nameorg" />
						</td>
						<td>
							<select name="slt-org" class="slt">
								<option value="${bean.ls.orgId }" selected="selected">${bean.ls.orgName }</option>
							</select>
						</td>
					</tr>
					<tr class="cls-reason">
						<td>
							<fmt:message key="lmis.ot.reg.reason" />
						</td>
						<td>
							<textarea id="txt-reason" name="txt-reason" style="width: 320px;height: 112px" rows="5">${bean.ls.requestedReason }</textarea>
						</td>
					</tr>
					<tr>
						<td>
							<label class="cls-error"><fmt:message key="lmis.ot.reg.errreason" /></label>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="content-right">
			<div class="total-ot"> <fmt:message key="lmis.ot.reg.totalhour" /> <span style="font-weight: bold; color: red;">40h</span></div>
			<div class="date-ot">
				<fmt:message key="lmis.ot.reg.regday" /> <input class="date-input-ot" type="text" name="date-ot" value=" <fmt:formatDate pattern="dd/MM/yyyy" value="${bean.ls.requestedAt }"  />" />
			</div>
			<div class="flt-right align-right" style="height:25px;"><label class="cls-error"><fmt:message key="lmis.ot.reg.errdate" /></label></div>
			<div class="clear-right"></div>
			<div class="feedback">
				<fieldset class="fbk-field">
					<legend><fmt:message key="lmis.ot.reg.feedback" /></legend>
					<textarea class="txt-fbk" name="txt-fbk" style="height: 105px;width: 400px">${bean.ls.reaSon }</textarea>
				</fieldset>
				<label id="err-fbk" class="cls-error"><fmt:message key="lmis.ot.reg.errNook" /></label>
			</div>
		</div>
		<div class="clear"></div>
		<div class="tbl-title">
			<div class="mbr-join"><fmt:message key="lmis.ot.reg.mbr" /></div>
			<div class="err-special"> <fmt:message key="lmis.ot.err.filed" /> </div>
		</div>
		<div class="clear"></div>
		<div class="tbl-mbr">
			<table>
				<thead >
					<tr>

						<th scope="row" width="25%"> <fmt:message key="lmis.commom.fullname.employee" /></th>
						<th scope="row" width="10%"><fmt:message key="lmis.attendanceInfo.startTime" /></th>
						<th scope="row" width="10%"><fmt:message key="lmis.ot.reg.hours" /></th>
						<th scope="row"><fmt:message key="lmis.ot.reg.reason" /></th>
					</tr>
				</thead>
				<tbody>
					 <c:forEach var="item" items="${bean.lsDetail }" varStatus="i">
					 	<c:choose>
					 		<c:when test="${i.count%2!=0 }">
								<tr class="oddrow">
							</c:when>
							<c:otherwise>
								<tr class="evenrow">
							</c:otherwise>
					 	</c:choose>

					 		<td style="padding-left:5px;">${item.fullName}</td>
					 		<td class="cls-ctr"><input type="text" value="${functions:getHour(item.startTime) }" /> : <input type="text" value="${functions:getMin(item.startTime)}" /> </td>
					 		<td class="hour"><input type="text" value="${item.requestedHour }" /></td>
					 		<td class="tdreason"><input id="tdreason" type="text" value="${item.reasonDetail }" style="text-align:left;" /></td>
						</tr>
					 </c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div id="btnApp" class="align-right" style="padding-right:20px;display:none;">
		<input class="approved" type="button" value="<fmt:message key="lmis.ot.type.ok" />"  />
		&nbsp
		<input class="cancel" type="button" value="<fmt:message key="lmis.ot.type.nook" />"  />
	</div>
	<input class="reqId" type="hidden" name="reqId" value="${bean.reqId }">
</form>