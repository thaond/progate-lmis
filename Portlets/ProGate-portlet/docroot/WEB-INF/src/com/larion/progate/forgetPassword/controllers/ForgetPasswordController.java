package com.larion.progate.forgetPassword.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

import com.liferay.ibm.icu.text.DateFormat;
import com.liferay.ibm.icu.text.SimpleDateFormat;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

public class ForgetPasswordController extends
		ParameterizableViewController {

	@Override
	protected void handleActionRequestInternal(ActionRequest request,
			ActionResponse response) throws Exception {
			request.setCharacterEncoding("UTF-8");
			String email = "";
			boolean emailIsValid = true;
			String url = "";
			boolean errReCap = false;
			HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
			
			boolean isRegrantPass = Boolean.parseBoolean(request.getParameter("REGRANT_PASS"));
			request.setAttribute("REGRANT_PASS", isRegrantPass);
			
			// check captcha
			String remoteAddr = req.getRemoteAddr();
			ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
			reCaptcha.setPrivateKey("6LfbubsSAAAAAH9rpEyStTH5LtgbQ-Y2UYBfTIcJ");
			String challenge = request.getParameter("recaptcha_challenge_field");
			String uresponse = request.getParameter("recaptcha_response_field");
			ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);
			
			// Get email
			email = request.getParameter("email");
			request.setAttribute("INPUT_EMAIL", email);
			
			if (!reCaptchaResponse.isValid()) {  
				errReCap = true;
				request.setAttribute("INVALID_RECAPTCHA", errReCap);
				//setForward(request, "portlet.struts_portlet.view");
				response.setRenderParameter("action", "showForgetPassword");
			}
			else{
				//email = request.getParameter("email");
				String fullName = "";
				long userId = 0;
				if(email.equalsIgnoreCase("") || email == null){
					emailIsValid = false;
					request.setAttribute("emailIsValid", emailIsValid);
					//setForward(request, "portlet.struts_portlet.view");
					response.setRenderParameter("action", "showForgetPassword");
				}
				else {
					try{
						long companyId = PortalUtil.getCompany(request).getCompanyId();
						User user = UserLocalServiceUtil.getUserByEmailAddress(companyId, email);
						Date currentDate = new Date();
						if(user != null){
							
							userId = user.getUserId();
							fullName = user.getFullName();
							user.setPasswordModifiedDate(currentDate);
							user.setGreeting("true"); // check reset password when user clicked link once
							UserLocalServiceUtil.updateUser(user);
						    
						}
						
						//send mail					
						MailController mail = new MailController();		
						String recipients[] = new String[1];
						recipients[0] = email;
						mail.setReceiver(recipients);
						
						mail.setSubject("Yêu cầu tạo mật khẩu mới");
						//mail.setSubject("Yeu cau tao mat khau moi");
						int numDay = 3;
						if(isRegrantPass){
							numDay = 7;
						}
						
						DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
						Date today = new Date();		
						Date day = new Date(today.getTime() + (1000 * 60 * 60 * 24 * numDay)); 
						
						// Create url
						String hostAdd = PortalUtil.getHost(request);
						int port = PortalUtil.getPortalPort();
						url = "http://" + hostAdd + ":" + port + "/change-pass?id=" + userId + "/";
						String homeURL = "http://" + hostAdd + ":" + port + "/home/" ;
						
						String content = "<p>Chào " + fullName + ",<br />" + 
							"Bạn vừa thực hiện yêu cầu lấy mật khẩu mới trên <a>www.progate.com</a>. Để hoàn tất việc lấy mật khẩu, vui lòng nhấn vào liên kết dưới đây.<br />" +
							"<a href='" + url + "'>" +
							"Link</a><br />" +
							
							"<br />Nếu không phải bạn, vui lòng <b>KHÔNG</b> nhấn vào liên kết này." + 
							"<span style='color: red;'> Liên kết này sẽ hết hạn vào ngày " +
							 dateFormat.format(day) + ".</span><br />" +
							"Mọi thắc mắc xin vui lòng liên hệ <a href='" + homeURL + "'>" +
							"website www.progate.com/hotro</a><br />" +
							"<span style='text-decoration:underline;'>Lưu ý:</span> " +
							"Đây là mail tự động, vui lòng không trả lời mail này." +
							"<br />Trân trọng,<br /><span style='font-weight:bold;'>ProGate Team</span></p>";
						
						//System.out.println("Mail_Content= " + content);
						
						
						mail.setContent(content);
						mail.setHost("mail.elarion.com");
						mail.setPort("25");
						mail.setSender("no-reply@elarion.com");
						mail.setSenderPass("1qazxsw2");
						
						//System.out.println("sender" + mail.getSender());
						try{
							mail.postMail();
						}catch (Exception e){
							System.out.println("Có lỗi khi gửi email - " + e);
							//errorMessage = "Có lỗi khi gửi email";
						}	
						//end sendmail
						System.out.println("Sent mail");
						//setForward(request, "portlet.recovery.SuccessRecovery");
						response.setRenderParameter("action", "forgetPass");
						
					}catch(Exception e){
						emailIsValid = false;
						request.setAttribute("emailIsValid", emailIsValid);
						//setForward(actionRequest, "portlet.struts_portlet.view");
						response.setRenderParameter("action", "showForgetPassword");
					}
				}
			  }		
	}

	@Override
	protected ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {
		Map<String, Object> bean = new HashMap<String, Object>();
		
		String email = "";
		if(request.getAttribute("INPUT_EMAIL") != null){
			email = (String)request.getAttribute("INPUT_EMAIL");
		}
		boolean isRegrantPass = false;
		if(request.getAttribute("REGRANT_PASS") != null){
			isRegrantPass = (Boolean)request.getAttribute("REGRANT_PASS");
		}
		request.setAttribute("INPUT_EMAIL", email);
		request.setAttribute("REGRANT_PASS", isRegrantPass);
		return new ModelAndView(this.getViewName(), "bean", bean);
	}

}