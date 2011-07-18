<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/html/portlet/common/init.jsp" %>
<%@ include file="script/change_password_script.jsp" %>
    
   <form action="" method="post" name="frmChangePassword">   
   <div class="tnt-content">
     <div class="tnt-row tnt-border-bottom" style="border-bottom-color: blue;width: 100%;">
     <div class="tnt-row-left">
     <span class="tnt-title">
           <fmt:message key="title.changepassword"/>
     </span>
     </div>
    </div>
     
     <div class="tnt-body">     
     
     <div>
     <div id="tnt-global-message" style="margin-left: 70px;margin-right: 70px;">
     <span></span>
     </div>
     </div>  
     
     <div class="tnt-row">
     <div style="margin-left: 70px;margin-right: 70px;">
       <span class="tnt-info">
             <fmt:message key="title.changepassword.tip"/></span>   
       <br/><br/> 
     </div>   
     </div>      
      
     <div style="margin-left: 160px;">     
     <div class="tnt-row">
			<div class="tnt-row-left">
			<span>
			<fmt:message key="title.password.old" />
			</span>
			</div>
			<div class="tnt-row-right eighty">
				<span>
				  <input type="password" value="${bean.oldPassword}" name="<%= Request.OLD_PASSWORD%>" 
				         maxlength="32" style="margin-left: 10px; width:300px;"/>
				</span>
				<br/>
				<span id="checkOldPassword" class="tnt-error-message" style="margin-left: 10px;"></span>
		   </div>
      </div>
                    
      <div class="tnt-row">
			<div class="tnt-row-left">
			<span>
			<fmt:message key="title.password.new" />
			</span>
			</div>
			<div class="tnt-row-right eighty">
				<span>
				<input type="password" value="${bean.newPassword}" name="<%= Request.NEW_PASSWORD%>"  
				       maxlength="32" style="margin-left: 10px; width:300px;"/>
				</span>
				<br/>
				<span id="checkNewPassword" class="tnt-error-message" style="margin-left: 10px;"></span>
			</div>		
      </div>                
       
      <div class="tnt-row">        
			<div class="tnt-row-left">
			<span>
			<fmt:message key="title.password.new.again" />
			</span>
			</div>
			<div class="tnt-row-right eighty">
				<span>
				<input type="password" value="${bean.newPasswordAgain}" name="<%= Request.NEW_PASSWORD_AGAIN%>"  
				       maxlength="32" style="margin-left: 10px;width :300px;"/>
				</span>
				<br/>
				<span id="checkNewPasswordAgain" class="tnt-error-message" style="margin-left: 10px;"></span>
			</div>	    
	  </div>
	  </div>
	  	  
	  <div class="tnt-row">
	  <br/>	
			<div class="tnt-row-center" style="float: left; margin-left: 325px;" >
			<div style="margin-left: 70px;">
				<span>				
					<input type="button" onClick="submitChangePassword()" class="bt-form" value='<fmt:message key="button.save" />'/>					
				</span>
				<span>&nbsp;</span>
				<span style="padding-left: 10px;">
				    <input type="button" class="bt-form" onclick="cancel('<c:out value='${bean.returnToFullPageURL }'/>')"
						   value='<fmt:message key="button.cancel" />'/>
				</span>
		   </div> 
			</div>
	  </div>		
	</div>
	</div>
	<input type="hidden" name="<%=URLParameter_RS.RETURN_TO_FULL_PAGE_URL%>" value="${bean.returnToFullPageURL}"/>
    <input type="hidden" name="isCorrectPassword" value="${bean.isCorrectPassword}"/>
    <input type="hidden" name="isChangePasswordSuccessful" value="${bean.isChangePasswordSuccessful}"/>
   </form>   