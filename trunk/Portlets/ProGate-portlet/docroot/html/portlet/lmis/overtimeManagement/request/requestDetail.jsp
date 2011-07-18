<%@ include file="../../../lmis/init-tvna.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<style type="text/css">
   <%@ include file="/css/lmis/src/grid.css" %>
</style>

<script type="text/javascript">
			jQuery(document).ready(function() {
			/*show datepicker*/
			jQuery('#ctl-edit').click(function(){
				jQuery('input').removeAttr('disabled');
				jQuery('textarea#txt-reason').removeAttr('disabled');
				jQuery('.date-req').attr('disabled','disabled');
			});
			jQuery(".btnSend").show("fast");
			jQuery("#review").attr("disabled","disabled");
		});
		</script>
	<script type="text/javascript">

	jQuery(document).ready(function() {
		jQuery('input').attr('disabled','disabled');
		jQuery('textarea').attr('disabled','disabled');
		jQuery('select').attr('disabled','disabled');
	});
	</script>

<form action="" name="frmRequestOTDetail" method="post">
	<div class="createChange"  style="margin-top:-36px">
		<c:if test="${bean.cmd == bean.edit }">
			<input id="ctl-edit" type="image" src="/ProGate-portlet/images/lmis/edit.png"
			href="#" id="mode-edit-active">
		   	<a id="_createChange" href="#"><fmt:message key="button.edit" /></a>
		   	<input id="ctl-delete" type="image" src="/ProGate-portlet/images/lmis/Cancel.png"
			href="#" id="mode-edit-active">
		   	<a id="_createChange" href="#"><fmt:message key="lmis.ot.reg.cancel" /></a>
	   	</c:if>
	    <input id="ctl-back" type="image" src="/ProGate-portlet/images/lmis/undo.png" width="24" height="24"
		href="#" id="mode-edit-active">
	   	<a id="_createChange" href="#"><fmt:message key="lmis.common.back" /></a>
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
							<input class="date-req" type="text" name="today" value="18/04/2010" readonly="readonly" />
						</td>
					</tr>
					<tr>
						<td class="cls-org">
							<fmt:message key="lmis.ot.nameorg" />
						</td>
						<td>
							<select name="slt-org" class="slt">
								<option value="idOrg">Java Project Hunter</option>
							</select>
						</td>
					</tr>
					<tr class="cls-reason">
						<td>
							<fmt:message key="lmis.ot.reg.reason" />
						</td>
						<td>
							<textarea id="txt-reason" name="txt-reason" cols="30" rows="5"></textarea>
							<br>
							<label class="cls-error"><fmt:message key="lmis.ot.reg.errreason" /></label>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="content-right">
			<div class="total-ot"> <fmt:message key="lmis.ot.reg.totalhour" /> <span style="font-weight: bold; color: red;">40h</span></div>
			<div class="date-ot">
				<fmt:message key="lmis.ot.reg.regday" /> <input class="date-input-ot" type="text" name="date-ot"  />
			</div>
			<div class="flt-right align-right" style="height:25px;"><label class="cls-error"><fmt:message key="lmis.ot.reg.errdate" /></label></div>
			<div class="clear-right"></div>
			<div class="feedback">
				<fieldset class="fbk-field">
					<legend><fmt:message key="lmis.ot.reg.feedback" /></legend>
					<textarea name="txt-fbk" cols="48" rows="3">feedback</textarea>
				</fieldset>
				<label class="cls-error"><fmt:message key="lmis.ot.reg.errNook" /></label>
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
					<tr class="oddrow">
						<td>Nguyen Van ti</td>
						<td><input type="text" value="18" /> : <input type="text" value="30" /> </td>
						<td class="hour"><input type="text" value="30" /></td>
						<td class="tdreason"><input id="tdreason" type="text" value="Ly do tang ca" style="text-align:left;" /></td>
					</tr>
					<tr class="evenrow">
						<td>Nguyen Van ti</td>
						<td><input type="text" value="18" /> : <input type="text" value="30" /> </td>
						<td class="hour"><input type="text" value="30" /></td>
						<td class="tdreason"><input id="tdreason" type="text" value="Ly do tang ca" style="text-align:left;" /></td>
					</tr>
					<tr class="oddrow">
						<td>Nguyen Van ti</td>
						<td><input type="text" value="18" /> : <input type="text" value="30" /> </td>
						<td class="hour"><input type="text" value="30" /></td>
						<td class="tdreason"><input id="tdreason" type="text" value="Ly do tang ca" style="text-align:left;" /></td>
					</tr>
					<tr class="evenrow">
						<td>Nguyen Van ti</td>
						<td><input type="text" value="18" /> : <input type="text" value="30" /> </td>
						<td class="hour"><input type="text" value="30" /></td>
						<td class="tdreason"><input id="tdreason" type="text" value="Ly do tang ca" style="text-align:left;" /></td>
					</tr>
					<tr class="oddrow">
						<td>Nguyen Van ti</td>
						<td><input type="text" value="18" /> : <input type="text" value="30" /> </td>
						<td class="hour"><input type="text" value="30" /></td>
						<td class="tdreason"><input id="tdreason" type="text" value="Ly do tang ca" style="text-align:left;" /></td>
					</tr>
					<tr class="evenrow">
						<td>Nguyen Van  cong tong nu ta thi cti</td>
						<td><input type="text" value="18" /> : <input type="text" value="30" /> </td>
						<td class="hour"><input type="text" value="30" /></td>
						<td class="tdreason"><input id="tdreason" type="text" value="Ly do tang ca" style="text-align:left;" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</form>