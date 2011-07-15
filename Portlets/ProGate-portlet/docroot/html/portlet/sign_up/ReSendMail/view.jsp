<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="init.jsp" %>
<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>


<script type="text/javascript">
	function <portlet:namespace />check_email(){
		var email = jQuery("#mail").val();
		if( email == ""){
			jQuery("#error_email").css("display","block");
			jQuery("#error_email").html("<span class='error_reemail'>Đây là thông tin bắt buộc.</span>");
			return false;
		}
		else{
			var atpos = email.indexOf("@");
			var stoppos = email.lastIndexOf(".");
	
			if (atpos == -1 || stoppos == -1){ 
				jQuery("#error_email").css("display","block");
				jQuery("#error_email").html("<span class='error_reemail'>Email không đúng định dạng.</span>");
				return false;
			}
			if (stoppos < atpos){
				jQuery("#error_email").css("display","block");
				jQuery("#error_email").html("<span class='error_reemail'>Email không đúng định dạng.</span>");
				return false;
			}
			if(stoppos - atpos == 1){
				jQuery("#error_email").css("display","block");
				jQuery("#error_email").html("<span class='error_reemail'>Email không đúng định dạng.</span>");
				return false;
			}		
		}
		jQuery("#error_email").css("display","none");
		return true;
	}
	jQuery(document).ready(function(){		   
		jQuery('#resend').click(function(){
		    var check =  <portlet:namespace />check_email();
		    if (check){
		        jQuery("#error_email").css("display","none");
		    	submitForm(document.ReSendMailFrm);
		    }else{
		    	return false;
		    }
		});
	});
</script>
<div class="announcement">
	 Bạn vui lòng nhập địa chỉ email và mã xác nhận.
	 Hệ thống sẽ gửi cho bạn một email kích hoạt mới.
</div>

<div  id="error" class="head_error" style="display:none;">
<%	if (request.getAttribute("MESSAGE_ERROR")!=null){%>
		<script type="text/javascript">
			jQuery(document).ready(function(){ 
				jQuery("#error").css("display","block");
				jQuery("#error").html('<font color="red"><%= request.getAttribute("MESSAGE_ERROR") %></font>');
			});
		</script>
	<% }%>
	</div>
<% String username = (String)request.getAttribute("username");
   String firstname = (String)request.getAttribute("firstname");
   String lastname = (String)request.getAttribute("lastname");
 %>
<form action="<portlet:actionURL><portlet:param name="struts_action" value="/SignUp/ReSendMailAction" />
									<portlet:param name="username" value="<%=username%>" />
									<portlet:param name="firstname" value="<%=firstname%>" />
									<portlet:param name="lastname" value="<%=lastname%>" />
								 </portlet:actionURL>"
			 			method="post"
					 	name="ReSendMailFrm">
	<table border="0" cellspacing="0" cellpadding="0" class="resendmail" style="margin-left:auto;margin-right:auto;">
		<tr >
			<td colspan="2" class="reactive_header">
				Cấp Lại Email Kích Hoạt
			</td>
		</tr>
		<tr bgcolor="#FDF6E3">
			<td style="font-size: 13px;padding: 6px 10px 0 15px;" class="draw_column_even">Email</td>
			<td class="draw_colum_last">
				<div class="inputtype">						    			
					<input type="text" name="mail" id="mail" maxlength="100" style="width:310px;" class="inputtext" onblur="<portlet:namespace />check_email();"/>
	 			</div>	
	 			<div id="error_email" style="display:none;">
	 			</div>	
			</td>
		</tr>
		
		<tr bgcolor="#FDF6E3">
			<td style="font-size: 13px;padding: 6px 10px 0 15px;" class="draw_column_even">Mã xác nhận</td>
			<td class="draw_colum_last">
				<div class="inputtype" >
		 			<script type="text/javascript">var RecaptchaOptions = {theme : 'white'};</script>
		 			<%
			          ReCaptcha c = ReCaptchaFactory.newReCaptcha("6LfbubsSAAAAALpgZMHUF8URC9iJIlFpWMACmshR", "6LfbubsSAAAAAH9rpEyStTH5LtgbQ-Y2UYBfTIcJ", false);
				          out.print(c.createRecaptchaHtml(null, null));
				     %>		
			     </div>
			     <div>
			     	<%	if (request.getAttribute("INVALID_RECAPTCHA")!=null){ %>
							<span class="error_reemail">
								<%= request.getAttribute("INVALID_RECAPTCHA") %>
							</span>	
					  <% } %>									     	
				 <div>	
			</td>
		</tr>
		<tr bgcolor="#FDF6E3">					 		
	 		<td colspan="2" class="draw_colum_last">
	 			<div class="div_registerH" style="padding-left:108px;" >
	              <button id="resend" style="width:80px;height:24px;" class="bt-form"><font size="3pt" style="font-family: sans-serif; font-size: 13px;">Đồng Ý</font></button>
	            </div>	            
	 		</td>							 		
		</tr>
	</table>
</form>
