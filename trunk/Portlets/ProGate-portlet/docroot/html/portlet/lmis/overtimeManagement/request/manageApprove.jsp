<%@ include file="../../../lmis/init-tvna.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<c:if test="${bean.cmd ==bean.view }">
<script type="text/javascript">
		jQuery(document).ready(function() {
			jQuery('input').not('intput#ctl-back').not('input#ctl-approve').attr('disabled','disabled');
			jQuery('textarea').attr('disabled','disabled');
			jQuery('select').attr('disabled','disabled');
			jQuery('div.date-ot').append('<div style="float:right;padding-right:6px;margin-top: 2px;"> <img src="/ProGate-portlet/images/lmis/viewAttendanceInfo/disable_datepicker.png"></div>');
			jQuery('input#ctl-back,a#_ctl-back').click(function(){
				var url='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
							<portlet:param name="action" value="manageRequestOverTime" />
		        		<portlet:param name="<%=Request.TAB_OT_ACT %>" value="<%=Request.TAB_OT_MANAGER %>" />
		        		<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.MANAGE %>" />
		        		<portlet:param name="<%=Request.ROOT_ID %>" value="${bean.rootId}" />
	    						</portlet:renderURL>';
	    			document.frmRequestOTDetail.action=url;
	    			document.frmRequestOTDetail.submit();
				});
			
			jQuery('textarea#txt-fbk').css('height','105px');
			jQuery('input#ctl-approve,a#_ctl-approve').click(function(){
				var reqId=jQuery('.reqId').val();
				var url='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
					<portlet:param name="action" value="manageRequestOverTime" />
					<portlet:param name="<%=Request.TAB_ACT%>" value="<%=Request.TAB_OT_MANAGER%>" />
					<portlet:param name="<%=Request.ROOT_ID%>" value="${bean.rootId}" />
					<portlet:param name="reqId" value="xreqIdx" />
					<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.APPROVE%>" />
				</portlet:renderURL>';
				url = url.replace("xreqIdx",reqId);
				document.frmRequestOTDetail.action=url;
	    		document.frmRequestOTDetail.submit();
			});
			
		});
</script>
</c:if>
<c:if test="${bean.cmd==bean.approve}">
<script type="text/javascript">
	jQuery(document).ready(function() {
		jQuery('input').attr('disabled','disabled');
		jQuery('textarea.txt-fbk').removeAttr('disabled');
		
		jQuery('div#btnApp').css('display','inline');
		jQuery('div#btnApp').css('float','right');
		jQuery('div#btnApp input').removeAttr('disabled');
		jQuery('div.total-ot').css('display','inline');
		jQuery('div.date-ot').css('margin-top', '11px');
		jQuery('div.date-ot').append('<div style="float:right;padding-right:6px;margin-top: 2px;"> <img src="/ProGate-portlet/images/lmis/viewAttendanceInfo/disable_datepicker.png"></div>');
		jQuery('div#removed').remove();
		jQuery('input#ctl-back, a#_ctl-back').click(function(){
			var url='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
				<portlet:param name="action" value="manageRequestOverTime" />
				<portlet:param name="<%=Request.TAB_OT_ACT %>" value="<%=Request.TAB_OT_MANAGER %>" />
        		<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.MANAGE %>" />
        		<portlet:param name="<%=Request.ROOT_ID %>" value="${bean.rootId}" />
			</portlet:renderURL>';
			document.frmRequestOTDetail.action=url;
			document.frmRequestOTDetail.submit();
		});
		jQuery('input.approved').click(function(){
			
			doApprove(true);
		});
		jQuery('input.cancel').click(function(e){
			var reason = jQuery('textarea.txt-fbk').val();
			if(reason==""){
				jQuery('label#err-fbk').css('display','inline');
				e.preventDefault();
			}else{
				
				doApprove(false);
			}
		});
	});
	 function doApprove(isApproved){
		 var href='<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
				<portlet:param name="action" value="manageRequestOverTime" />
				<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.APPROVE%>" />
	    		<portlet:param name="<%=Request.ROOT_ID%>" value="${bean.rootId }" />
	    		<portlet:param name="reqId" value="${bean.reqId}" />
			</portlet:actionURL>';
			var orgIdreq = jQuery('select.slt').val();
			var reason = jQuery('textarea.txt-fbk').val();
			var reqId = jQuery('input.reqId').val();
	
			jQuery('input.cancel').attr('disabled','disabled');
			jQuery('input.approved').attr('disabled','disabled');
			loadBackgroud();
			jQuery.ajax({
				type: 'POST',
				url: href,
				data:{
					"handle":"approved",
					"reqId":reqId,
					"orgIdreq":orgIdreq,
					"isApproved":isApproved,
					"reason":reason
				},
				success: function(data){
					jQuery("#backgroundLoading").hide();
					alert("Phê duyệt đơn thành công");
					jQuery('input.approved').removeAttr('disabled');
					jQuery('input.cancel').removeAttr('disabled');
					var url='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
						<portlet:param name="action" value="manageRequestOverTime" />
            		<portlet:param name="<%=Request.TAB_OT_ACT %>" value="<%=Request.TAB_OT_MANAGER %>" />
            		<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.MANAGE %>" />
            		<portlet:param name="<%=Request.ROOT_ID %>" value="${bean.rootId}" />
	    						</portlet:renderURL>';
	    			document.frmRequestOTDetail.action=url;
	    			document.frmRequestOTDetail.submit();
				},
				error: function(data) {
					jQuery("#backgroundLoading").hide();
					alert("Đã xảy ra loi, vui lòng thông báo đến quản trị viên ProGate");
					jQuery('input.approved').removeAttr('disabled');
					jQuery('input.cancel').removeAttr('disabled');
					var url='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
						<portlet:param name="action" value="manageRequestOverTime" />
            		<portlet:param name="<%=Request.TAB_OT_ACT %>" value="<%=Request.TAB_OT_MANAGER %>" />
            		<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.MANAGE %>" />
            		<portlet:param name="<%=Request.ROOT_ID %>" value="${bean.rootId}" />
	    						</portlet:renderURL>';
	    			document.frmRequestOTDetail.action=url;
	    			document.frmRequestOTDetail.submit();
				}
			});
	 }
	function loadBackgroud(){
			jQuery("#backgroundLoading").css({
					"opacity": "0.7"
				});
			jQuery("#backgroundLoading").fadeIn("slow");
		}
</script>
</c:if>
<form action="" name="frmRequestOTDetail" method="post">

	<div class="createChange">
		
		<c:if test="${bean.ls.requestedStatus==bean.otPending && bean.showApp==true }">
			   	<input id="ctl-approve" type="image" src="/ProGate-portlet/images/lmis/overtimeManagement/Pheduyet.png"
					href="#" id="mode-edit-active" align="absmiddle">
			   	<a id="_ctl-approve" href="#"><fmt:message key="lmis.ot.button.app" /></a>
	   	</c:if>
		    <input id="ctl-back" type="image" src="/ProGate-portlet/images/lmis/undo.png" width="24" height="24"
			href="#" id="mode-edit-active" align="absmiddle">
		   	<a id="_ctl-back" href="#" style=""><fmt:message key="lmis.common.back" /></a>
    </div>
	<div class="cls-ot" style="-moz-border-radius: 2px 5px 5px 5px;	-webkit-border-radius: 2px 5px 5px 5px;border-radius: 2px 5px 5px 5px;">
		<div class="title-center"><fmt:message key="title.product.detail" /></div>
		<div class="req-field" style="display:none;"><fmt:message key="title.required.field" /></div>
		<div style="height:20px;width:100%"></div>
		<div class="content-left">
			<table id="tbl-field">
				<thead>
					<tr>
						<th width="100px" scope="col"></th>
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
							<select name="slt-org" class="slt" disabled="disabled">
								<option value="${bean.ls.orgId }" selected="selected">${bean.ls.orgName }</option>
							</select>
						</td>
					</tr>
					<tr class="cls-reason">
						<td>
							<fmt:message key="lmis.ot.reg.reason" />
						</td>
						<td>
							<textarea id="txt-reason" name="txt-reason" style="width: 320px;height: 112px" rows="5" disabled="disabled">${bean.ls.requestedReason }</textarea>
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
			<div class="total-ot"> <fmt:message key="lmis.ot.reg.totalhour" /> <span style="font-weight: bold; color: red;">${bean.totalHour }</span></div>
			<div class="date-ot">
				<fmt:message key="lmis.ot.reg.regday" /> <input class="date-input-ot" type="text" name="date-ot" value=" <fmt:formatDate pattern="dd/MM/yyyy" value="${bean.ls.requestedAt }"  />" />
			</div>
			
			<div class="clear-right"></div>
			<div class="feedback">
				<fieldset class="fbk-field">
					<legend><fmt:message key="lmis.ot.reg.feedback" /> (<span style="color:red">*</span>) </legend>
					<textarea id="txt-fbk" class="txt-fbk" name="txt-fbk" style="height: 80px;width: 400px">${bean.ls.reaSon }</textarea>
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

						<th scope="row" width="25%" style="border: 1px solid #C0C0C0;"> <fmt:message key="lmis.commom.fullname.employee" /></th>
						
						<th scope="row" width="10%" style="border: 1px solid #C0C0C0;"><fmt:message key="lmis.attendanceInfo.startTime" /></th>
						<th scope="row" width="10%" style="border: 1px solid #C0C0C0;"><fmt:message key="lmis.ot.reg.hours" /></th>
						<th scope="row" style="border: 1px solid #C0C0C0;"><fmt:message key="lmis.ot.reg.reason.up" /></th>
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

					 		<td style="padding-left: 10px;border:1px solid #C0C0C0;">${item.fullName}</td>
					 		<td class="cls-ctr" style="border: 1px solid #C0C0C0;"><input type="text" value="${functions:getHour(item.startTime) }" /> : <input type="text" value="${functions:getMin(item.startTime)}" /> </td>
					 		<td class="hour" style="border: 1px solid #C0C0C0;"><input type="text" value="${item.requestedHour }" /></td>
					 		<td class="tdreason" style="border: 1px solid #C0C0C0;"><input id="tdreason" type="text" value="${item.reasonDetail }" style="text-align:left;" /></td>
						</tr>
					 </c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div id="btnApp" class="button" style="display:none">
		<input class="cancel" type="button" value="<fmt:message key="button.notagree" />"  style="width: 110px; background-image: url('/ProGate-portlet/images/lmis/Khong_Dong_Y.png')" />
		&nbsp
		<input class="approved" type="button" value="<fmt:message key="button.agree" />"  />
	</div>
	<input class="reqId" type="hidden" name="reqId" value="${bean.reqId }">
</form>
<div id="backgroundLoading" >
	<div id="imgLoad">
	<img  src="/ProGate-portlet/images/lmis/loader.gif" />
	</div>
</div>