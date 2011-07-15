<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/html/portlet/common/init.jsp" %>
<%@ include file="script/change_password_script.jsp" %>
    
   <form action="" method="post" name="frmChangePassword">   
   <div class="tnt-content"  style="margin-left: 100px;">
     <div class="tnt-row tnt-border-bottom" style="border-bottom-color: blue;width: 750px;">
     <div class="tnt-row-left">
     <span class="tnt-title">
           <fmt:message key="title.changepassword"/>
     </span>
     </div>
    </div>
     
     <div class="tnt-body">     
     <div class="tnt-row" id="tnt-global-message">
     <span></span>
     </div>
     
     <br/><br/>       
     <div class="tnt-row">
       <span class="tnt-info">
             <fmt:message key="title.changepassword.tip"/></span>   
       <br/><br/>    
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
				         maxlength="20" width="40%" style="margin-left: 10px;"/>
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
				       maxlength="20" width="40%" style="margin-left: 10px;"/>
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
				       maxlength="20" width="40%" style="margin-left: 10px;"/>
				</span>
				<br/>
				<span id="checkNewPasswordAgain" class="tnt-error-message" style="margin-left: 10px;"></span>
			</div>	    
	  </div>
	  </div>
	  	  
	  <div class="tnt-row">
	  <br/>	
			<div class="tnt-row-center" style="float: left; margin-left: 310px;" > 
				<span>				
					<input type="button" onClick="submitChangePassword()" class="bt-form" value='<fmt:message key="button.save" />'/>					
				</span>
				<span>&nbsp;</span>
				<span>
				    <input type="button" class="bt-form" onclick="cancel('<c:out value='${bean.returnToFullPageURL }'/>')"
						   value='<fmt:message key="button.cancel" />'/>
				</span>
			</div>
	  </div>		
	</div>
	</div>
	<input type="hidden" name="<%=URLParameter_RS.RETURN_TO_FULL_PAGE_URL%>" value="${bean.returnToFullPageURL}"/>
    <input type="hidden" name="isCorrectPassword" value="${bean.isCorrectPassword}"/>
    <input type="hidden" name="isChangePasswordSuccessful" value="${bean.isChangePasswordSuccessful}"/>
   </form>   