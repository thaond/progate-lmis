<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../common/init.jsp" %>
<%
	String fullName = "";
	if (request.getAttribute("FullName") != null) {
		fullName =(String) request.getAttribute("FullName");
	}
	
	String email = "";
	if (request.getAttribute("Email") != null) {
		email =(String) request.getAttribute("Email");
	}
	
	boolean isLimited = false;
	if (request.getAttribute("isLimited") != null) {
		isLimited =(Boolean) request.getAttribute("isLimited");
	}
	boolean isResetPass = true;
	if (request.getAttribute("isResetPass") != null) {
		isResetPass =(Boolean) request.getAttribute("isResetPass");
	}
	
	boolean isActivated = true;
	if (request.getAttribute("isActivated") != null) {
		isActivated =(Boolean) request.getAttribute("isActivated");
	}
	
	long userId = 0;
	if (request.getAttribute("UserId") != null) {
		userId =(Long) request.getAttribute("UserId");
	}
	int wrongRePass = 0;
%>
<style type="text/css">
   <%@ include file="/css/resetPassword/style.css" %>
</style>
<script type="text/javascript">
	
function validatePass(){
	var pass = jQuery('#password').val();
	
	if( pass == ""){
		jQuery("#errPass").text('Đây là thông tin bắt buộc nhập');
		return false;		
	}else{
		jQuery("#errPass").text('');
	}
	
	if (pass.length < 6 || pass.length > 32){
		jQuery("#errPass").text('Mật khẩu phải dài từ 6 đến 32 ký tự');
		return false;
	}else{
		jQuery("#errPass").text('');
	}
	
	return true;
}

function validateRepass(){

	var pass = jQuery('#password').val();
	var rePass = jQuery('#repassword').val();
		
	if( rePass == ""){
		jQuery("#errRepass").text('Đây là thông tin bắt buộc nhập');
		return false;		
	}else{
		jQuery("#errRepass").text('');
	}
	
	if(pass != rePass){
		jQuery("#errRepass").text('Các mật khẩu không khớp');
		return false;
	}else{
		jQuery("#errRepass").text('');
	}
	if (rePass.length < 6 || rePass.length > 32){
		jQuery("#errRepass").text('Mật khẩu phải dài từ 6 đến 32 ký tự');
		return false;
	}else{
		jQuery("#errRepass").text('');
	}
	
	return true;
}
	
	function focusPassword(){
		
		document.frmResetPass.password.focus();
			
	}
	
	function submitForm(){
		if(validatePass() && validateRepass()){
			document.frmResetPass.submit();
		}
	}
	
	function keyPress(e)
	{
		if (e.which == 13)
		{
			e.returnValue = false;
			submitForm();
		}
	}
	
	function test(){
		var input = jQuery('#password').val();
		var strongRegex = new RegExp("^(?=.*[^a-zA-Z0-9_])(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).*$", "g");
		var mediumRegex = new RegExp("^(((?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]))|((?=.*[A-Z])(?=.*[a-z])(?=.*[^a-zA-Z0-9_]))|((?=.*[a-z])(?=.*[0-9])(?=.*[^a-zA-Z0-9_]))|((?=.*[A-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9_]))).*$", "g");
		var enoughRegex = new RegExp("^(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[^a-zA-Z0-9_]))|((?=.*[A-Z])(?=.*[^a-zA-Z0-9_]))|((?=.*[0-9])(?=.*[^a-zA-Z0-9_]))).*", "g");
		if (strongRegex.test(input)){
				jQuery('#weak1').css("background-color","lightgreen");
				jQuery('#weak2').css("background-color","lightgreen");
				jQuery('#medium').css("background-color","lightgreen");
				jQuery('#strong').css("background-color","lightgreen");
				jQuery('#password_level').text("Độ bảo mật của mật khẩu: Mạnh");
		}else{
			if(mediumRegex.test(input)){
				jQuery('#weak1').css("background-color","lightgreen");
				jQuery('#weak2').css("background-color","lightgreen");
				jQuery('#medium').css("background-color","lightgreen");
				jQuery('#strong').css("background-color","white");
				jQuery('#password_level').text("Độ bảo mật của mật khẩu: Trung Bình");
			}else{
				if (enoughRegex.test(input)){
					jQuery('#weak1').css("background-color","lightgreen");
					jQuery('#weak2').css("background-color","lightgreen");
					jQuery('#medium').css("background-color","white");
					jQuery('#strong').css("background-color","white");
					jQuery('#password_level').text("Độ bảo mật của mật khẩu: Yếu");
					}
				else{
					jQuery('#weak1').css("background-color","lightgreen");
					jQuery('#weak2').css("background-color","white");
					jQuery('#medium').css("background-color","white");
					jQuery('#strong').css("background-color","white");
					jQuery('#password_level').text("Độ bảo mật của mật khẩu: Yếu");
				}
			}
		}

		if(input == ""){
			jQuery('#weak1').css("background-color","white");
			jQuery('#weak2').css("background-color","white");
			jQuery('#medium').css("background-color","white");
			jQuery('#strong').css("background-color","white");	
		}
	}

	jQuery(function(){
	// Show help password
	var close = function() {
		jQuery("#password-help").dialog("close");
    }
    var dialogOpts = {
    	title:'Trợ giúp',
    	autoOpen: false,
	    modal: true,
	    buttons: {		        
	        ' Đóng ': close
	    },
	    resizable: false,
	    width: 600,
	    height: 400
    };
    
    jQuery("#password-help").dialog(dialogOpts);
    jQuery("#popup").click(function(){
    	jQuery("#password-help").css("visibility","visible");
    	jQuery("#password-help").dialog("open");
    	//jQuery("#password-help").width(575);
    });	

	});    
</script>
<body onload="focusPassword()" onkeypress="keyPress(event);">
<form name="frmResetPass" method="post" onsubmit="Javascript: if (!validateForm()) return false;" action="<portlet:actionURL><portlet:param name='action' value='resetPass'></portlet:param></portlet:actionURL>">
	
	<%if(isLimited){ %>
	<table width="460px" align="center" id="common_bgr" border="1" bordercolor="#B8BABF"  cellspacing="2" cellpadding="2">
		<tr class="labelheader">
			<td style="padding: 10px">
				<div>
					<label>
						<b>Rất tiếc !!! </b> Liên kết lấy mật khẩu mới này đã <b>hết hạn</b>. 
					</label>
				</div>
				<br>
				<div>
					<label>
						Bạn nên sử dụng chức năng "<a href="/forget-pass"><b>Quên mật khẩu</b></a>" của hệ thống để yêu cầu gửi một email hướng dẫn lấy lại mật khẩu.
					</label>
				</div>
			</td>
		</tr>
	</table>
	<%}else if(!isResetPass){ %>
	
		<table width="460px" align="center" id="common_bgr" border="1" bordercolor="#B8BABF"  cellspacing="2" cellpadding="2">
		<tr class="labelheader">
			<td style="padding: 10px">
				<div>
					<label>
						<b>Rất tiếc !!! </b> Bạn đã sử dụng liên kết này để tạo mật khẩu trước đó. Bạn không thể sử dụng liên kết này tiếp tục được nữa. 
					</label>
				</div>
				<br>
				<div>
					<label>
						Nếu vẫn không nhớ mật khẩu. Đừng quá lo lắng. Bạn nên sử dụng chức năng "<a href="/forget-pass"><b>Quên mật khẩu</b></a>" của hệ thống để yêu cầu gửi một email hướng dẫn lấy lại mật khẩu.
					</label>
				</div>
			</td>
		</tr>
		
	</table>
	
	<%}else if(!isActivated){ %>
	
		<table width="460px" align="center" id="common_bgr" border="1" bordercolor="#B8BABF"  cellspacing="2" cellpadding="2">
		<tr class="labelheader">
			<td style="padding: 10px">
				<div>
					<label>
						<b>Rất tiếc !!! </b> Tài khoản của bạn chưa được kích hoạt. Xin vui lòng kích hoạt tài khoản bằng cách kiểm tra email <b><%=email %></b> của bạn
						để thực hiện kích hoạt tài khoản theo hướng dẫn trong mail. 
					</label>
				</div>
				<br>
				<div>
					<label>
						Nếu bạn không nhận được email hướng dẫn kích hoạt, xin vui lòng kiểm tra cả trong hòm thư rác (bulk mail)
						hoặc <a href="/regrant-email">nhấn vào đây</a> để yêu cầu gởi lại mail hướng dẫn kích hoạt.
					</label>
				</div>
			</td>
		</tr>
		
	</table>
	
	
	<%}else{ %>
		<table width="460px">
		<tr>
			<td>
				<table width="100%" align="center" id="common_bgr" border="1" bordercolor="#B8BABF"  cellspacing="2" cellpadding="2">
					
					<tr class="labelheader">
						<td style="padding: 10px">
							<label>
								Chào bạn <b><%=fullName %></b>, vui lòng nhập vào mật khẩu mới để hoàn tất quá trình lấy lại mật khẩu.
							</label>
						</td>
					</tr>
					
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table width="100%"><tr><td>&nbsp;</td></tr></table>
			</td>
		</tr>
		<tr>
			<td>
				<table width="100%" align="center" id="common_bgr" border="1" bordercolor="#B8BABF"  cellspacing="2" cellpadding="2">
					<tr class="labelheader">
						<td colspan="2" bgcolor="#FF8802" style="padding-top: 0px; padding-bottom: 10px">
						<br>
							<div style="padding-left: 5px;padding-top: 0px; padding-bottom: 0px">
								<label style="font-size: 14px"><b>Hãy nhập vào mật khẩu mới</b></label>
							</div>
						</td>
					</tr>
					<tr class="labelheader">
				    	<td width="40%" class="labelheader" style="font-size: 13px;font-family: sans-serif;padding-top: 0px; padding-left: 5px">Mật khẩu mới</td>
				    	<td width="60%">
				    		<div>
					    		<div align="left" style="padding-top: 10px;padding-left: 10px">
					    		  		<input type="password" name="password" id="password" maxlength="35" size="32" onblur="validatePass()" onkeyup="test()"/>
				 				</div>
						 		
				 		   </div>	
				 		    										 								 			
					        <div style="padding-top:10px;padding-left: 10px">
						      	<div id="password_level" style="font-size: 13px;font-family: sans-serif;">Độ bảo mật của mật khẩu</div>
						      	
						      	 <div style="float: left;">
									<div id="weak1" style="float: left; width: 50px; height: 10px; border: solid 1px #000000;"></div>
									<div id="weak2" style="float: left; width: 50px; height: 10px; border: solid 1px #000000; margin-left:  5px"></div>
									<div id="medium" style="float: left; width: 50px; height: 10px; border: solid 1px #000000; margin-left:  5px"></div>
									<div id="strong" style="float: left; width: 50px; height: 10px; border: solid 1px #000000; margin-left:  5px"></div>
									<div style="float:left;">
											<img title="Nhấn vào đây để xem hướng dẫn độ bảo mật của mật khẩu" src="/ProGate-portlet/images/resetPassword/Symbol Green Question.jpg" width="15px" height="15px" id="popup" style="vertical-align: middle; margin-left: 3px" />
										<%@include file="password_help.jsp"%>
									</div>										 
								</div>
							</div>
							<br/>
							
							<div id="errPass" style="font-family: sans-serif;color: red;font-size: 13px;padding-left: 10px;padding-bottom: 5px">
								
							</div>
							
				      </td>
				    </tr>
				    <tr class="labelheader">
				    	<td width="40%">	
				    		<label style="font-size: 13px;font-family: sans-serif;padding-left: 5px">Xác nhận mật khẩu</label>	    	
				    	<br>
				
				    	</td>
				    	<td width="60%">
				    		<div align="left" style="padding-top: 10px;padding-left: 10px; padding-bottom: 5px">
				    				<input type="password" name="repassword" id="repassword" maxlength="35" size="32" onblur="validateRepass()"/>
			 				</div>
			 				
			 				<div id="errRepass" style="font-family: sans-serif;color: red;font-size: 13px;padding-left: 10px; padding-bottom: 5px;">
									
							</div>
				 		</td>
				    </tr>
				    <tr>
						<td colspan="2" style="padding-right:90px; padding-bottom: 5px; padding-top:5px;border-left: 0;" align="center">
						<button type="button" style="border-color: #CDB463; background-color: #F5ECD3" onclick="javascript:submitForm();"><font size="3pt" style="font-family: sans-serif;font-size: 13px">Tạo mới</font></button>
						</td>
					</tr>
	
				</table>
			</td>
		</tr>
		</table>
	<%} %>
	
	<input type="hidden" name="userId" value="<%=userId %>">
</form>