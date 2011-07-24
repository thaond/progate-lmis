<%@ include file="../../../lmis/init-tvna.jsp" %>
<%@ include file="../../validation/val_overtime_request.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>


<script type="text/javascript">
	function validate(){
		//Check Reason Common
		var rs =jQuery('textarea#txt-reason').val();
		if(rs=="" ||rs==null ){
			jQuery('label#err-reason').css('display','inline');
			return false;
		}
		else{
			jQuery('label#err-reason').css('display','none');
			//Check Reason Detail
			var flag= true;
			var i=0;
			jQuery('table#tbl tbody input[type="checkbox"]:checked').each(function(){
				var tr = jQuery(this).parent().parent();
				var rss = jQuery(tr).find('input#tdreason').val();
				if(rss=="" ||rss==null){
					flag=false;
				}
			});
			if(flag==false){
				jQuery('div#err-special').css('display','inline');
				return false;
			}else{
				jQuery('div#err-special').css('display','none');
				var chk = false;
				jQuery('table#tbl tbody input[type="checkbox"]').each(function(){
					if(this.checked){
						chk=true;
					}
				});
				if(chk==false){
					alert("Cần ít nhất một thành viên để tạo đăng ký tăng ca!");
					return false;
				}
				else{ return true;}
			}
		}
		
	}
	jQuery(document).ready(function() {
			/*show datepicker*/
			jQuery('input[type="checkbox"]').each(function(){
				this.checked=false;
			});
			<c:forEach items="${bean.lsAll}" var="item">
				var id = '${item.userId}';
				jQuery("input[value='"+id+"'][type='checkbox']").each(function(){
					this.checked =true;
					var tr = jQuery(this).parent().parent();
					jQuery(tr).find('#tdreason').val('${item.reasonDetail}');
					jQuery(tr).find('.h').val('${item.requestedHour}');
					jQuery(tr).find('.H').val('${functions:getHour(item.startTime)}');
					jQuery(tr).find('.m').val('${functions:getMin(item.startTime)}');
				});
			
			</c:forEach>
			jQuery('input#cln').click(function(){
				var reqId=jQuery('input#reqId').val();
				var url='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
    				<portlet:param name="action" value="requestOverTimeDetail" />
					<portlet:param name="<%=Request.TAB_OT_ACT%>" value="<%=Request.TAB_OT_PER%>" />
					<portlet:param name="<%=Request.ROOT_ID%>" value="${bean.rootId}" />
					<portlet:param name="reqId" value="xreqIdx" />
					<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.EDIT%>" />
				</portlet:renderURL>';
				url = url.replace("xreqIdx",reqId);
				document.frmRequestOTDetail.action=url;
				document.frmRequestOTDetail.submit();
			});
			
			jQuery(".date-input-ot").datepicker({
				showOn: "both",	
				buttonImage: "/ProGate-portlet/images/lmis/viewAttendanceInfo/datetime.png",
				buttonImageOnly: true,
				defaultDate: '+1d',
				buttonText:'Chọn ngày',
				minDate: '0',
				dateFormat:'dd/mm/yy'
			});
			jQuery('input#ctl-back,a#_createChange').click(function(){
				
				var url='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
	    			<portlet:param name="action" value="requestOverTime" />
	    			<portlet:param name="<%=Request.TAB_OT_ACT%>" value="<%=Request.TAB_OT_PER %>" />
	    			<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.MANAGE%>" />
	    			<portlet:param name="<%=Request.ROOT_ID %>" value="${bean.rootId }" />
    						</portlet:renderURL>';
    			document.frmRequestOTDetail.action=url;
    			document.frmRequestOTDetail.submit();
			});
			jQuery('input.date-req').not('input#ctl-back').attr('disabled','disabled');
			jQuery('textarea.txt-fbk').attr('disabled','disabled');
			
			jQuery('div.tbl-mbr table input[type="text"]').attr('disabled','disabled');
			jQuery('input.chk-item').change(function(){
				var chk = this.checked;
				var tr = jQuery(this).parent().parent();
				if(chk==true)
				{
					jQuery(tr).find('input[type="text"]').removeAttr('disabled');
					var r = jQuery('#txt-reason').val();
					jQuery(tr).find('input[type="text"]:last').val(r);
				}else{
					jQuery(tr).find('input[type="text"]').attr('disabled','disabled');
					jQuery(tr).find('input[type="text"]:last').val("");
				}
			});
			jQuery('input.chk-all').change(function(){
				var chk = this.checked;
				if(chk==true){
					jQuery('input.chk-item').attr('checked','true');
					jQuery('div.tbl-mbr table input[type="text"]').removeAttr('disabled');
					var r = jQuery('#txt-reason').val();
					jQuery('input.lydo').each(function(){
						jQuery(this).val(r);
					});
				}else{
					jQuery('input.chk-item').removeAttr('checked');
					jQuery('div.tbl-mbr table input[type="text"]').attr('disabled','disabled');
					jQuery('input.lydo').each(function(){
						jQuery(this).val("");
					});
				}
			});
			// Add OT REQ
			jQuery('input.btnedit').one('click',function(e){
				
				var chk = validate();
				
				if(chk)
				{
					var href='<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
						<portlet:param name="action" value="requestOverTimeDetail" />
						<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.EDIT%>" />
		        		<portlet:param name="<%=Request.ROOT_ID%>" value="${bean.rootId }" />
					</portlet:actionURL>';

					var reqDate= jQuery('.date-input-ot').val();
					var orgIDreq = jQuery('select.slt').val();
					var otReason = jQuery('textarea#txt-reason').val();
					var arrUID = new Array();
					var arrReason = new Array();
					var arrTotal = new Array();
					var arrHM = new Array();
					var arrEndTime= new Array();
					var reqId = jQuery('input#reqId').val();
	

					jQuery('table#tbl tbody input[@name=chk-all]:checked').each(function(i){
						var chk =this.checked;
						var p = jQuery(this).parent().parent();
						if(chk){
							arrUID.push(jQuery(p).find('input[@name=chk-all]:checked').val());
							arrReason.push(jQuery(p).find('input[@name=tdreason]').val());
							var total =jQuery(p).find('input[@name=h]').val();
							arrTotal.push(total);
							var H =jQuery(p).find('input[@name=H]').val();
							var M =jQuery(p).find('input[@name=m]').val();
							arrHM.push(H+"/"+M);
							iH = parseInt(H) + parseInt(total);
							arrEndTime.push(iH+"/"+M);
						}
					});
					jQuery(this).attr('disabled','disabled');
					loadBackgroud();
					jQuery.ajax({
						type: 'POST',
						url: href,
						data:{
							"handle":"edit",
							"reqId":reqId,
							"reqDate":reqDate,
							"orgIDreq":orgIDreq,
							"otReason":otReason,
							"arrUID":arrUID,
							"arrReason":arrReason,
							"arrTotal":arrTotal,
							"arrHM":arrHM,
							"arrEndTime":arrEndTime
						},
						success: function(data){
							var url='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
				    			<portlet:param name="action" value="requestOverTime" />
				    			<portlet:param name="<%=Request.TAB_OT_ACT%>" value="<%=Request.TAB_OT_PER %>" />
				    			<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.MANAGE%>" />
				    			<portlet:param name="<%=Request.ROOT_ID %>" value="${bean.rootId }" />
			    						</portlet:renderURL>';
							jQuery("#backgroundLoading").hide();
							jQuery("#editSuccess").css("display", "block");
							jQuery("#editSuccess").data('url',url).dialog("open");
							jQuery(this).removeAttr('disabled');
						
						},
						error: function(data) {
							jQuery("#backgroundLoading").hide();
							alert("Đã xảy ra loi, vui lòng thông báo đến quản trị viên ProGate");
							jQuery(this).removeAttr('disabled');
							var href='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
										<portlet:param name="<%=Request.TAB_OT_ACT%>" value="<%=Request.TAB_OT_PER %>" />
			            				<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.MANAGE%>" />
			            				<portlet:param name="<%=Request.ROOT_ID %>" value="${bean.rootId }" />
									 </portlet:renderURL>';
							document.frmRequestOTDetail.action=href;
							document.frmRequestOTDetail.submit();
						}
					});
				}
			});

		});
		function myOrg(){
			var url ='<portlet:renderURL var="viewRequestURL">
			        		<portlet:param name="action" value="requestOverTimeDetail" />
			        		<portlet:param name="<%=Request.TAB_OT_ACT%>" value="<%=Request.TAB_OT_PER%>" />
			        		<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.ADD%>" />
			        		<portlet:param name="<%=Request.ROOT_ID%>" value="${bean.rootId }" />
						</portlet:renderURL>';
				document.frmRequestOTDetail.action=url;
				document.frmRequestOTDetail.submit();
		}
		function loadBackgroud(){
			jQuery("#backgroundLoading").css({
					"opacity": "0.7"
				});
			jQuery("#backgroundLoading").fadeIn("slow");
		}
		
</script>
<<jsp:include page="../../dialog/dialog-editRequestOt.jsp"></jsp:include>
<form action="" id="frmRequestOTDetail" name="frmRequestOTDetail" method="post">
	<div class="createChange" >
	    <input id="ctl-back" type="image" src="/ProGate-portlet/images/lmis/undo.png" width="24" height="24">
	   	<a id="_createChange" href="#"><fmt:message key="lmis.common.back" /></a>
    </div>
	<div class="cls-ot">
		<div class="title-center"><fmt:message key="title.product.detail" /></div>
		<div class="req-field" ><fmt:message key="title.required.field.lower" /></div>
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
							<input class="date-req" type="text" name="today" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${bean.ls.createdAt}" />" readonly="readonly" />
						</td>
					</tr>
					<tr>
						<td class="cls-org">
							<fmt:message key="lmis.ot.nameorg" />
						</td>
						<td><a></a>
							<select name="slt-org" class="slt" disabled="disabled">
								<option value="${bean.ls.orgId }" selected="selected">${bean.ls.orgName }</option>
							</select>
						</td>
					</tr>
					<tr class="cls-reason">
						<td>
							<fmt:message key="lmis.ot.reg.reason" /> (<span style="color:red">*</span>)
						</td>
						<td>
							<textarea id="txt-reason" name="txt-reason" style="width: 320px;height: 112px" rows="5">${bean.ls.requestedReason }</textarea>
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<label id="err-reason" class="cls-error"><fmt:message key="lmis.ot.reg.errreason" /></label>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="content-right">
			<div class="total-ot"> <fmt:message key="lmis.ot.reg.totalhour" /> <span style="font-weight: bold; color: red;">40h</span></div>
			<div class="date-ot">
				<fmt:message key="lmis.ot.reg.regday" /> <input style =" width:70%;" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${bean.ls.requestedAt}" />" class="date-input-ot" type="text" name="date-ot" />
			</div>
			
			<div class="clear-right"></div>
			<div class="feedback">
				<fieldset class="fbk-field">
					<legend><fmt:message key="lmis.ot.reg.feedback" /> </legend>
					<textarea class="txt-fbk" name="txt-fbk" style="height: 105px;width: 400px">Phản hồi của người phê duyệt sẽ hiển thị ở đây </textarea>
				</fieldset>
				<label class="cls-error"><fmt:message key="lmis.ot.reg.errNook" /></label>
			</div>
		</div>
		<div class="clear"></div>
		<div class="tbl-title">
			<div class="mbr-join"><fmt:message key="lmis.ot.reg.mbr" /></div>
			<div id="err-special" class="err-special"> <fmt:message key="lmis.ot.err.filed" /> </div>
		</div>
		<div class="clear"></div>
		<div class="tbl-mbr">
			<table id="tbl">
				<thead >
					<tr>
						<th scope="row" width="3%" style="border: 1px solid #C0C0C0;"><input class="chk-all" type="checkbox" name="chk-all" value="checked" /></th>
						<th scope="row" width="25%" style="border: 1px solid #C0C0C0;"> <fmt:message key="lmis.commom.fullname.employee" /></th>
						<th scope="row" width="10%" style="border: 1px solid #C0C0C0;"><fmt:message key="lmis.attendanceInfo.startTime" /></th>
						<th scope="row" width="10%" style="border: 1px solid #C0C0C0;"><fmt:message key="lmis.ot.reg.hours"/> </th>
						<th scope="row" style="border: 1px solid #C0C0C0;"><fmt:message key="lmis.ot.reg.reason.up" /> (<span style="color:red">*</span>)</th>
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

									<td style="text-align: center;border: 1px solid #C0C0C0;" ><input class="chk-item" type="checkbox" name="chk-all" value="${item.userId}" /></td>
									<td style="padding-left:5px;border: 1px solid #C0C0C0;">${item.fullName }</td>
									<td class="cls-ctr" style="border: 1px solid #C0C0C0;"><input class="H" name="H" type="text" value="17" maxlength="2" /> : <input class="m" name="m" type="text" value="30" maxlength="2" /> </td>
									<td class="hour" style="border: 1px solid #C0C0C0;"><input class="h" name="h" type="text" value="2" maxlength="2"></td>
									<td class="tdreason" style="border: 1px solid #C0C0C0;"><input class="lydo" id="tdreason" name="tdreason" type="text" value="" /></td>
								</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>
	<div class="button">
		<input id="cln" type="button" value="<fmt:message key="button.reset" />"  />
		&nbsp
		<input class="btnedit" type="button" value="<fmt:message key="button.sendform" />"  />
	</div>
	<input id="reqId" type="hidden" name="reqId" value="${bean.reqId }"/>
</form>
<div id="backgroundLoading" >
	<div id="imgLoad">
	<img  src="/ProGate-portlet/images/lmis/loader.gif" />
	</div>
</div>