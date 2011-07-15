package com.larion.progate.resetPassword.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

import com.liferay.ibm.icu.text.DateFormat;
import com.liferay.ibm.icu.text.SimpleDateFormat;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.security.pwd.PwdEncryptor;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

public class ResetPasswordController extends
		ParameterizableViewController {

	@Override
	protected void handleActionRequestInternal(ActionRequest request,
			ActionResponse response) throws Exception {
		
		
		long userId = Long.parseLong(request.getParameter("userId"));
		String newPassword = request.getParameter("password");
		
		try{
			
			updatePassword(userId, newPassword);
			//setForward(actionRequest, "portlet.struts_portlet.test");
			response.setRenderParameter("action", "resetPass");
			return;
		}catch(Exception e){
			System.out.println("Can not reset password!");
			//setForward(actionRequest, "portlet.struts_portlet.view");
			response.setRenderParameter("action", "showForgetPassword");
		}
	}
	
	 private User updatePassword(
			             long userId, String password1)
			         	 throws PortalException,SystemException{
		 
		 User user = UserLocalServiceUtil.getUser(userId);
			
		 String fullname = user.getFullName();
		 String greeting = "Welcome " + fullname + "!";
         String oldEncPwd = user.getPassword();
         if (!user.isPasswordEncrypted()) {
             oldEncPwd = PwdEncryptor.encrypt(user.getPassword());
         
         }
         String newEncPwd = PwdEncryptor.encrypt(password1);
         user.setPassword(newEncPwd);
         user.setPasswordUnencrypted(oldEncPwd);
         user.setPasswordEncrypted(true);
         user.setGreeting(greeting); // Set greeting field again to check mail when click one
         user.setPasswordModified(false);
         user.setPasswordModifiedDate(new Date());
         UserLocalServiceUtil.updateUser(user);
         return user;
     }

	@Override
	protected ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {
		Map<String, Object> bean = new HashMap<String, Object>();
		
		String email = "";
		if(request.getAttribute("INPUT_EMAIL") != null){
			email = (String)request.getAttribute("INPUT_EMAIL");
		}
		request.setAttribute("INPUT_EMAIL", email);
		return new ModelAndView(this.getViewName(), "bean", bean);
	}

}