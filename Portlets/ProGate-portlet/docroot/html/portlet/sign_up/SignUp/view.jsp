<%
/**
 * Copyright (c) 2009 Robisoft, Inc. All rights reserved.
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

<%@ include file="init.jsp" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page import="com.liferay.portal.util.PropsValues" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

 

<div class="header">	
	Đăng Ký Thành Viên		
</div>

<div  class="note_head">
	<font color="red">(*) Thông tin bắt buộc nhập</font>
</div>
<%@ include file="showerror.jsp" %>	
<div align="left">
				<br />
					<form action="<portlet:actionURL><portlet:param name="struts_action" value="/SignUp/SignUpAction" /></portlet:actionURL>"
			 			method="post"
					 	name="SignUpFm" onsubmit="Javascript: if (!validateForm()) return false;">
							<TABLE BORDER="0" CELLSPACING="0" CELLPADDING="0" class="editor" >		
							    <tr>
							    	<td class="label" width="145px">Họ (<font color="red">*</font>)</td>
							    	<td width="535px">							    		
							    			<div class="inputtype">
							    				<input type="text" name="firstname" id="firstname" maxlength="100" class="inputtext" />							    										 				
							 				</div>
							 				<div id="error_firstname" style="display:none;">							 				
							 				</div>	
							 				<div id="hint_firstname" style="display:none;">
							 				</div>		
							 				<div id="check_firstname" style="display:none;clear:both;"></div>				 									 			
							 		</td>
							    </tr>
							    <tr>
							    	<td class="label">Tên (<font color="red">*</font>)</td>
							    	<td>
							    		<div class="inputtype">						    			
							    			<input type="text" name="lastname" id="lastname" maxlength="100" class="inputtext" />
							 			</div>	
							 			<div id="error_lastname" style="display:none;">
							 			</div>	
							 			<div id="hint_lastname" style="display:none;">
							 			</div>		
							 			<div id="check_lastname" style="display:none;clear:both;"></div>						 						 			
							 		</td>							 		
							    </tr>
							    <tr>
							    	<td class="label">Tên đăng nhập (<font color="red">*</font>)</td>
							    	<td>
							    		 <div class="inputtype">		
						    				<input type="text" name="username" id="username" maxlength="100" class="inputtext" onblur="check_username();"/>
						    	    		<div id="check_username" style="display:none;clear:both;"></div>
						    	    	</div>
						    	    	<div id="error_username" style="display:none;">
						 				</div>	
						 				<div id="hint_username" style="display:none;">
							 			</div>			 			 				    	    						    	    
							    	</td>
							    </tr>
							    
							    <tr>
							    	<td class="label">Mật khẩu (<font color="red">*</font>)</td>
							    	<td>
							    		<div class="inputtype">
							    		  		<input type="password" name="password" id="password" maxlength="100" class="inputtext" />
						 				</div>
						 				<div id="error_password" style="display:none;">
						 				</div>		
						 				<div id="hint_password" style="display:none;">
							 		   </div>
							 		   <div id="check_password" style="display:none;clear:both;"></div>		 										 								 			
							 		</td>							 		
							    </tr>
							    <tr>
							      <td class="label"></td>
							      <td>
							        <div style="margin-top:2px;margin-left:10px;">
								      	<div id="password_level">Độ bảo mật của mật khẩu</div>
								      	
								      	 <div style="float: left;">
											<div id="weak1" style="float: left; width: 50px; height: 10px; border: solid 1px #000000;"></div>
											<div id="weak2" style="float: left; width: 50px; height: 10px; border: solid 1px #000000; margin-left:  5px"></div>
											<div id="medium" style="float: left; width: 50px; height: 10px; border: solid 1px #000000; margin-left:  5px"></div>
											<div id="strong" style="float: left; width: 50px; height: 10px; border: solid 1px #000000; margin-left:  5px"></div>
											<div style="float:left;">
												<a href="#" style="float: left;" id="showPassword">
													<img title="Nhấn vào đây để xem hướng dẫn độ bảo mật của các mật khẩu" src="/SignUp-5.2.3.1/images/Symbol Green Question.jpg" width="15px" height="15px" id="popup" style="vertical-align: middle; margin-left: 3px" />
												</a>
												
											   <%@include file="password.jsp"%>
												<script type="text/javascript">
											       jQuery(document).ready(function(){
											           jQuery('#showPassword').click(function(){
											           	   if (document.documentElement.scrollTop > 0){
		                                                      window.scrollTo(0,0);
		                                                   }
											           	
											               jQuery('#password-html').css("display", "block");
											               jQuery('#password-html').dialog({
											               	 modal:true,
											               	 resizable: false,
											               	 height: 388,
											               	 width:588,
													         title: 'Trợ Giúp',
													         buttons: {
														            "Đóng": function() { jQuery('#password-html').dialog("close"); }
														     },
														     open: function(event, ui) {
			                                                     	jQuery('.ui-dialog-buttonpane > button:last').focus();
			                                                  },	
			                                                 close: function(event, ui) {
			                                                 		jQuery('#repassword').focus();
			                                                 }
											               }); 											               									           
													       jQuery("#password-html").keyup(function(e) {
															    if (e.keyCode == 13) {
															       jQuery("#password-html").dialog("close");
															    }
															}); 
													  
											           });
											       });
											   </script>

											</div>										 
										</div>
									</div>
							      </td>
							    </tr>
							    <tr>
							    	<td class="label">Xác nhận mật khẩu (<font color="red">*</font>)</td>
							    	<td>
							    		<div class="inputtype">
							    			<input type="password" name="repassword" id="repassword" maxlength="100" class="inputtext" />
						 					<div id="check_repassword" style="display:none;clear:both;"></div>
						 				</div>
						 				<div id="error_repassword" style="display:none;">
						 			   </div>	
						 			   <div id="hint_repassword" style="display:none;">
							 		   </div>				 								 			
							 		</td>
							    </tr>
							    <tr>
							    	<td class="label">Email (<font color="red">*</font>)</td>
							    	<td>
							    		<div class="inputtype">
						    				<input type="text" name="email" id="email" maxlength="100" class="inputtext" onblur="check_email();"/>						    				
						 					<div id="check_email" style="display:none;clear:both;"></div>
						 					
						 				</div>
						 				<div id="error_email" style="display:none;">
						 				</div>	
						 				<div id="hint_email" style="display:none;">
							 		   </div>					 									 			
							 		</td>							 		
							    </tr>
							    <tr>
							    	<td class="label">Giới tính</td>
							    	<td>
							    		<div class="field_container">
							    			<div class="radio" >
							    				<input type="radio" name="sex" value="true" checked> Nam </input>
			                                </div>
			                                <div style="float:left;" >
			                                	<input type="radio" name="sex" value="false"> Nữ </input>
			                                </div>						    		
		                                </div>
							    	</td>						    	
							    </tr>
							    <tr>
							    	<td class="label">Ngày sinh (<font color="red">*</font>)</td>
							    	<td>
							    		<div class="inputtype">							    			   
						    			    <INPUT type="text" name="birthday" id="birthday" class="inputtext" style="width:291px;" />
								    	  	 <script type="text/javascript">
								    	  	 	// Calendar
												var pickerOpts = {
														showOn: "both",
														yearRange: "-80:+0",
														buttonImage: "<%=request.getContextPath()%>/images/calendar.gif",
														buttonText: "Open datepicker",
														buttonImageOnly: true,
														dateFormat:"dd/mm/yy",
														onClose: function() {
															document.getElementById("birthday").focus();
													    }
												    };
								    	  	 	 jQuery("#birthday").datepicker(pickerOpts); 									    	  
											   </script> 		    				
					 					    <div id="check_birthday" style="display:none;clear:both;"></div>									    		
								    	</div>
								    	<div id="error_birthday" style="display:none;">
					 			   		</div>
							    	</td>							    	
							   </tr>
							   <tr>
							   	 <td class="label"></td>
							   	 <td>
							   	 <div class="question">
						    			<div id="requirement">			    			
						    				<p id="popup_message">Website yêu cầu tất cả các thành viên cung cấp ngày sinh thật để tăng tính xác thực và cung cấp quyền truy cập vào các nội dung phù hợp với lứa tuổi. Bạn có thể ẩn thông tin này trong Trang Cá Nhân của mình nếu muốn, và việc sử dụng thông tin này được quy định theo Các Điều Khoản Thỏa Thuận Về Sử Dụng Dịch Vụ.
											</p>								
						    			</div>
						    			<a href="javascript:void(0);" id="opener">Tại sao tôi cần cung cấp thông tin này?</a>						    			
										<script type="text/javascript">											
									       jQuery(document).ready(function(){
									           jQuery("#opener").click(function(){
									               jQuery("#requirement").css("display", "block");
									               jQuery("#requirement").dialog({
									               	 modal:true,
									               	 resizable: false,
											         width: 448,
											         title:"Tại sao tôi cần cung cấp thông tin này?",
											         buttons: {
											            "Đóng": function() {jQuery("#requirement").dialog("close");	}
											         },
											         open: function(event, ui) {
                                                     	jQuery('.ui-dialog-buttonpane > button:last').focus();
                                                     },
                                                     close: function(event, ui) {
	                                                 		jQuery('#recaptcha_response_field').focus();
	                                                 }											         
									               });									                 
									              jQuery("#requirement").keyup(function(e) {
												     if (e.keyCode == 13) {
												       jQuery("#requirement").dialog("close");
												     }
												  }); 							               									              
									           });
									       });
									   </script>
						    		</div>
						    	 </td>
							   </tr>
							   <tr>
							 	   <td class="label">Mã xác nhận (<font color="red">*</font>)</td>
							 		<td>
							 			<div class="inputtype" >
								 			<script type="text/javascript">var RecaptchaOptions = {theme : 'white'};</script>
								 			<%
									          ReCaptcha c = ReCaptchaFactory.newReCaptcha("6LfbubsSAAAAALpgZMHUF8URC9iJIlFpWMACmshR", "6LfbubsSAAAAAH9rpEyStTH5LtgbQ-Y2UYBfTIcJ", false);
										          out.print(c.createRecaptchaHtml(null, null));
										     %>											     
										     
									     </div>	
									     <div>
									     	<%	if (request.getAttribute("INVALID_RECAPTCHA")!=null){ %>
													<span class="error_captcha">
														<%= request.getAttribute("INVALID_RECAPTCHA") %>
													</span>	
											  <% } %>									     	
									     <div>			 		
							 		</td>
							 	</tr>
							 	<tr>
							 	  <td colspan="2">
							 		<div class="foot">
										<div style="float: left"><input type="checkbox" name="checkAgree" id="checkAgree" ></div>
										<div style="float: left;vertical-align:middle;"> &nbsp;Tôi đã đọc và chấp nhận
										  <a href="#" id="showTerms" title="Nhấn vào đây để xem các điều khoản thỏa thuận về sử dụng dịch vụ">
										 	Các Điều Khoản Thỏa Thuận Về Sử Dụng Dịch Vụ
										  </a>
										  <%@include file="copyright.jsp"%>
										  <script type="text/javascript">
											 jQuery(document).ready(function(){
											   jQuery('#showTerms').click(function(){
											      if (document.documentElement.scrollTop > 0){
                                                      window.scrollTo(0,0);
                                                   }
									           	  jQuery('#term-html').css("display", "block");
										          jQuery('#term-html').dialog({											                 
											               	 modal:true,
											               	 resizable: false,
											               	 height: 388,
													         width:602,
													         title: 'Thông báo',
													         buttons: {
													            "Đóng": function() { jQuery('#term-html').dialog("close"); }
													         }, 
													         open: function(event, ui) {
		                                                     	jQuery('.ui-dialog-buttonpane > button:last').focus();		                                                     		
		                                                     },			
													         close: function(event, ui) {
													         	jQuery('#registry_button').focus();
													         }
										           });  
										          								           
											       jQuery('#term-html').keyup(function(e) {
													    if (e.keyCode == 13) {
													        jQuery('#term-html').dialog("close");
													    }
													});
											    });
											  });
										   </script>
										</div> 	
										<div id="error_condition" style="display:none;clear:both;">
						 			    </div>					
									</div>									
							 	  </td>
							 	</tr>
							 	
							 	<tr>					 		
							 		<td colspan="2">
							 			<div class="div_registerH" style="padding-left:163px;" >
           								   <button id="registry_button" class="bt-form" style="height:24px;width:80px;" type="submit" onkeypress="keyPress(event);"><font size="3pt" style="font-family: sans-serif; font-size: 13px;">Đăng Ký</font></button>
        	                            </div>
							 		</td>							 		
							 	</tr>
							 	<tr>
							 		<td class="foot" colspan="2">
							 			<a href="javascript:alert('Chức năng này đang được xây dựng. Bạn vui lòng trở lại sau. Xin cảm ơn!');">
							 			Đăng ký cho tổ chức</a>							 			
							 		</td>							 		
							 	</tr>				 	
		                     </TABLE>
		                   </form>

</div>
<script type="text/javascript">
   
	window.onload = function() {
	  document.getElementById("firstname").focus();
	
	 
	  <%
		  String firstname = (String)request.getAttribute("firstname");
		  firstname = (firstname == null ? "" : firstname);
		  
		  String lastname =  (String)request.getAttribute("lastname");
		  lastname = (lastname == null ? "" : lastname);
		  
		  String username =  (String)request.getAttribute("username");
		  username = (username == null ? "" : username);
		  
		  String email =  (String)request.getAttribute("email");
		  email = (email == null ? "" : email);
		  
		  String sex = (String)request.getAttribute("sex");
		  sex = (sex == null ? "" : sex);
		  
		  String birthday = (String)request.getAttribute("birthday");
		  birthday = (birthday == null ? "" : birthday);
		 
		%>
	  document.getElementById("firstname").value = "<%= firstname%>";
	  document.getElementById("lastname").value = "<%= lastname%>";
	  document.getElementById("username").value = "<%= username%>";
	  document.getElementById("email").value = "<%= email%>";
	  document.getElementById("birthday").value = "<%= birthday%>";
	  setCheckedRadio("<%= sex%>");
	}
	
   function keyPress(e){
	    if (e.keycode == 13){	
	        e.returnValue = false;	
	        document.SignUpFm.onsubmit();	
	    }		
	}
	
	function check_username(){		
		var username = jQuery('#username').val();
		if (username.length == 0){
			jQuery("#hint_username").css("display", "block");
		    jQuery("#hint_username").html("<img src='/SignUp-5.2.3.1/images/info.gif' class='hint_image_length'  width='15px' height='15px'><span class='hint_message'>Tên đăng nhập không chứa ký tự đặc biệt, không quá 20 ký tự.</span>");
			jQuery("#check_username").text("");
		}else if (username.length > 20){
			jQuery("#hint_username").css("display", "block");
		    jQuery("#hint_username").html("<img src='/SignUp-5.2.3.1/images/info.gif' class='hint_image_length'  width='15px' height='15px'><span class='hint_message_3'>Tên đăng nhập không chứa ký tự đặc biệt, không quá 20 ký tự.</span>");
			jQuery("#check_username").css("display","block");
			jQuery("#check_username").html("<span class='check_error'>Tên đăng nhập không chứa ký tự đặc biệt, không quá <span style='margin-left:5px;'>20</span> ký tự.</span>");			
		}else if (!validText(username)){
			jQuery("#hint_username").css("display", "block");
		    jQuery("#hint_username").html("<img src='/SignUp-5.2.3.1/images/info.gif' class='hint_image_length'  width='15px' height='15px'><span class='hint_message_3'>Tên đăng nhập không chứa ký tự đặc biệt, không quá 20 ký tự.</span>");
			
		    jQuery("#check_username").css("display","block");
			jQuery("#check_username").html("<span class='check_error'>Tên đăng nhập không chứa ký tự đặc biệt, không quá <span style='margin-left:5px;'>20</span> ký tự. </span>");
		}else if (username.length > 0){
			<portlet:namespace />check_existence_username();
		}
	}
		
	function <portlet:namespace />check_existence_username(){
		
	    username = jQuery("#username").val();
	   
		 //url to the resource username
		var userUrl = '<portlet:resourceURL id="checkUser" escapeXml="false"></portlet:resourceURL>';
		
		//send AJAX call using POST
		
		jQuery.ajax({
		   type: "POST",
		   url: userUrl,
		   data: {"check_username": username},
		   success: function(msg){
		     
		     jQuery("#check_username").css("display","block");
			 jQuery("#check_username").html("<span class='check_error'>" + msg + "</span>");
			 var check_username = jQuery("#check_username").text();
			 if (check_username == ''){
			 	jQuery("#check_username").css("display","none");
			 	jQuery("#check_username").text("");
			 }
		    } 
		 });
	}
	
	function check_email(){
		var email = jQuery("#email").val();
		if (email != ''){
			if (!checkEmail(email)){
		 	    jQuery("#hint_email").html("<img src='/SignUp-5.2.3.1/images/info.gif' class='hint_image' width='15px' height='15px'><span class='hint_message'>Email phải đúng định dạng.</span>");
				jQuery("#check_email").css("display","block");
				jQuery("#check_email").html("<span class='check_error'>Email không đúng định dạng.</span>");	
			}else{
				<portlet:namespace />check_existence_email();
			}
		}else{
			jQuery("#check_email").css("display","none");
			jQuery("#check_email").text("");
		}		
	}
	function <portlet:namespace />check_existence_email(){
		var email = jQuery("#email").val();
		 //url to the resource username
		var userUrl = '<portlet:resourceURL id="checkEmail" escapeXml="false"></portlet:resourceURL>';
		
		//send AJAX call using POST
		
		jQuery.ajax({
		   type: "POST",
		   url: userUrl,
		   data: {"useremail": email},
		   success: function(msg){
		     jQuery("#check_email").css("display","block");
			 jQuery("#check_email").html("<span class='check_error'>" + msg + "</span>");
			 var check_email = jQuery("#check_email").text();
			 if (check_email == ''){
			 	jQuery("#check_email").css("display","none");
			 	jQuery("#check_email").text("");
			 	jQuery("#hint_email").html("<img src='/SignUp-5.2.3.1/images/info.gif' class='hint_image' width='15px' height='15px'><span class='hint_message'>Email phải đúng định dạng.</span>");
			 }else{
			 	jQuery("#hint_email").html("<img src='/SignUp-5.2.3.1/images/info.gif' class='hint_image' width='15px' height='15px'><span class='hint_message_email'>Email phải đúng định dạng.</span>");
			 }
		    } 
		 });
	}
	
	
</script>
