<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
/**
 * Copyright (c) [Year] [Organization] All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
%>
<%@ include file="../common/init.jsp" %>
<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>



<%
	boolean isCaptchaOK = true;
	boolean isEmailValid = true;
	boolean isRegrantPass = false;
	String email = "";
	
	boolean errReCap = false;
	if(request.getAttribute("INVALID_RECAPTCHA") != null){
		errReCap = (Boolean)request.getAttribute("INVALID_RECAPTCHA");
	}
	
	if (request.getAttribute("INVALID_RECAPTCHA") != null) {
		isCaptchaOK = false;
		//invalidCapcha = request.getAttribute("INVALID_RECAPTCHA").toString();
	}
	if (request.getAttribute("emailIsValid") != null) {
		isEmailValid = (Boolean)request.getAttribute("emailIsValid");
		
	}
	
	if (request.getAttribute("INPUT_EMAIL") != null) {
		email = (String)request.getAttribute("INPUT_EMAIL");
	}
	
	if(request.getAttribute("REGRANT_PASS") != null){
		isRegrantPass = (Boolean)request.getAttribute("REGRANT_PASS");
	}
	
	
%>

<style type="text/css">
   <%@ include file="/css/forgetPassword/style.css" %>
</style>
<script type="text/javascript">

function validateForm(){
	
	var email = jQuery('#email').val();
	
	if( email == ""){
		jQuery("#errEmail").text('Đây là thông tin bắt buộc nhập');
		return false;
	}
	else{
		var atpos = document.frmRecovery.email.value.indexOf("@");
		var stoppos = document.frmRecovery.email.value.lastIndexOf(".");

		if (atpos == -1 || stoppos == -1){ 
			jQuery("#errEmail").text('Email không đúng định dạng');
			return false;
		}
		if (stoppos < atpos){
			jQuery("#errEmail").text('Email không đúng định dạng');
			return false;
		}
		if(stoppos - atpos == 1){
			jQuery("#errEmail").text('Email không đúng định dạng');
			return false;
		}
		
	}
	
	if(document.frmRecovery.email.value != ""){
		jQuery("#errEmail").text('');
	}
	
	if(document.frmRecovery.email.value != ""){
		jQuery("#errEmail").text('');
	}
	
	return true;
}

function focusEmail(){
	
	document.frmRecovery.email.focus();
		
}
function submitForm(){
	if(validateForm()){
		document.frmRecovery.submit();
	}
	
}

function keyPress(e)
{
	if (e.which == 13)
	{
		e.returnValue = false;
		submitForm()
		//document.frmRecovery.submit();
		//document.getElementById("signIn").click();
	}
}
</script>
<body onload="focusEmail()" onkeypress="keyPress(event);">
<%
	if(isRegrantPass){
%>
<form name="frmRecovery" method="post" onsubmit="Javascript: if (!validateForm()) return false;" 
action="<portlet:actionURL><portlet:param name='action' value='forgetPass'></portlet:param></portlet:actionURL>">
	<table width="360px">
	<input type="hidden" name="REGRANT_PASS" value="<%= isRegrantPass%>">
	<%if(!isEmailValid){ %>
	<tr>
		<td>
			<table width="100%" align="center" id="common_bgr" border="1" bordercolor="#B8BABF"  cellspacing="2" cellpadding="2">
				
				<tr class="message_alert">
					<td style="padding: 10px">
						<label style="font-weight: bold">
							Địa chỉ email <%=email %> mà bạn vừa nhập không thuộc bất kỳ tài khoản nào. Xin thử lại.
						</label>
					</td>
				</tr>
				
			</table>
		</td>
	</tr>
	<%} %>
	
	<tr>
		<td>
			<table width="360px"><tr><td>&nbsp;</td></tr></table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="100%" align="center" id="common_bgr" border="1" bordercolor="#B8BABF"  cellspacing="2" cellpadding="2">
				
				<tr class="labelheader">
					<td style="padding: 10px" width="100%">
						<label>
							Bạn vui lòng nhập email và mã xác nhận.
							<br>
							Hệ thống sẽ gởi cho bạn một email kích hoạt mới.
						</label>
					</td>
				</tr>
				
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="360px"><tr><td>&nbsp;</td></tr></table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="360px" id="common_bgr" width="100%" border="1" bordercolor="#B8BABF" cellspacing="2" cellpadding="2">
				<tr class="labelheader">
					<td colspan="2" bgcolor="#FF8802" style="padding-top: 0px; padding-bottom: 10px">
							<br>
							<div style="padding-left: 10px;padding-top: 0px; padding-bottom: 0px">
								<label style="font-size: 14px"><b>Cấp lại email kích hoạt</b></label>
							</div>
					</td>
				</tr>
				<tr class="labelheader">
					<td nowrap="nowrap">&nbsp;<label style="padding-left: 10px;">Email</label></td>
					<td>
						<div align="left" style="padding-left: 10px;padding-top: 10px"><input type="text" name="email" id="email" maxlength="50" size="35" onblur="validateForm()" value="<%=email %>"></div>
						<div align="left" style="padding-left: 10px; padding-bottom: 5px;font-family: sans-serif;color: red; display: inline;" id="errEmail"></div>
					</td>
				</tr>
				
				<tr class="labelheader">
					<td nowrap="nowrap">&nbsp;<label style="padding-left: 10px">Mã xác nhận&nbsp;</label></td>
					<td style="padding:10px;">
						<div class="inputtype" align="left">
				 			<script type="text/javascript">var RecaptchaOptions = {theme : 'white'};</script>
				 			<%
					          ReCaptcha c = ReCaptchaFactory.newReCaptcha("6LfbubsSAAAAALpgZMHUF8URC9iJIlFpWMACmshR", "6LfbubsSAAAAAH9rpEyStTH5LtgbQ-Y2UYBfTIcJ", false);
						          out.print(c.createRecaptchaHtml(null, null));
						     %>								
						     
					     </div>
					     <%if(errReCap){%>
					     	<div align="left" style="padding: 10px;font-family: sans-serif;color: red; display: inline;font-weight: bold" id="invalidCaptcha">Mã xác nhận không đúng</div>
					     <%} %>
					</td>
				</tr>
				<tr>
					<td style="border-right: 0">&nbsp;</td>
					<td style="padding-left:10px; padding-bottom: 5px; padding-top:5px;border-left: 0;">
					<button name="recovery" type="submit" style="border-color: #CDB463; background-color: #F5ECD3"><font size="3pt" style="font-family: sans-serif;font-size: 13px">Đồng ý</font></button>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	</table>
</form>

<% }else{ %>

<form name="frmRecovery" method="post" onsubmit="Javascript: if (!validateForm()) return false;" 
action="<portlet:actionURL><portlet:param name='action' value='forgetPass'></portlet:param></portlet:actionURL>">
	<table width="360px">
	<input type="hidden" name="REGRANT_PASS" value="<%= isRegrantPass%>">
	<%if(!isEmailValid){ %>
	<tr>
		<td>
			<table width="100%" align="center" id="common_bgr" border="1" bordercolor="#B8BABF"  cellspacing="2" cellpadding="2">
				
				<tr class="message_alert">
					<td style="padding: 10px">
						<label style="font-weight: bold">
							Địa chỉ email <%=email %> mà bạn vừa nhập không thuộc bất kỳ tài khoản nào. Xin thử lại.
						</label>
					</td>
				</tr>
				
			</table>
		</td>
	</tr>
	<%} %>
	
	<tr>
		<td>
			<table width="360px"><tr><td>&nbsp;</td></tr></table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="100%" align="center" id="common_bgr" border="1" bordercolor="#B8BABF"  cellspacing="2" cellpadding="2">
				
				<tr class="labelheader">
					<td style="padding: 10px" width="100%">
						<label>
							<b>Bạn đã quên mật khẩu?</b>
							<br><br>
							Vui lòng nhập vào những thông tin dưới đây để chúng tôi xác nhận bạn trong hệ thông ProGate. 
							<br><br>
							Chúng tôi sẽ gửi đến bạn một email có chứa liên kết dùng để khôi phục mật khẩu.
						</label>
					</td>
				</tr>
				
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="360px"><tr><td>&nbsp;</td></tr></table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="360px" id="common_bgr" width="100%" border="1" bordercolor="#B8BABF" cellspacing="2" cellpadding="2">
				<tr class="labelheader">
					<td colspan="2" bgcolor="#FF8802" style="padding-top: 0px; padding-bottom: 10px">
						<br>
						<div style="padding-left: 10px;padding-top: 0px; padding-bottom: 0px">
							<label style="font-size: 14px"><b>Quên mật khẩu</b></label>
						</div>
					</td>
				</tr>
				<tr class="labelheader">
					<td nowrap="nowrap">&nbsp;<label style="padding-left: 10px">Email</label>
					</td>
					
					<td>
						<div align="left" style="padding-left: 10px; padding-top: 10px; padding-bottom: 10px"><input type="text" id="email" name="email" maxlength="50" size="35" onblur="validateForm()" value="<%=email %>"></div>
						
						<div align="left" style="padding-left: 10px; padding-bottom: 5px;font-family: sans-serif;color: red;" id="errEmail">		
						</div>
		
					</td>
				</tr>
				
				<tr class="labelheader">
					<td nowrap="nowrap">&nbsp;<label style="padding-left: 10px">Mã xác nhận&nbsp;</label></td>
					<td style="padding:10px;">
						<div class="inputtype" align="left">
				 			<script type="text/javascript">var RecaptchaOptions = {theme : 'white'};</script>
				 			<%
					          ReCaptcha c = ReCaptchaFactory.newReCaptcha("6LfbubsSAAAAALpgZMHUF8URC9iJIlFpWMACmshR", "6LfbubsSAAAAAH9rpEyStTH5LtgbQ-Y2UYBfTIcJ", false);
						          out.print(c.createRecaptchaHtml(null, null));
						     %>								
						     
					     </div>
					     <br>
					     <%if(errReCap){%>
					     	<div align="left" style="padding-left: 5px;font-family: sans-serif;color: red; display: inline;" id="invalidCaptcha">Mã xác nhận không đúng</div>
					     <%}%>
					</td>
				</tr>
				<tr>
					<td style="border-right: 0">&nbsp;</td>
					<td style="padding-left:10px; padding-bottom: 5px; padding-top:5px;border-left: 0;">
					<button name="recovery" type="button" style="border-color: #CDB463; background-color: #F5ECD3" onclick="javascript:submitForm();"><font size="3pt" style="font-family: sans-serif;font-size: 13px">Khôi phục</font></button>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	</table>	
</form>
<% } %>
</body>