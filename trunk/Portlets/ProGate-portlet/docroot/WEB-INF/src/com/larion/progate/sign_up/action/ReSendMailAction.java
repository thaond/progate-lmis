package com.larion.progate.sign_up.action;

import javax.portlet.*;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.ActionRequestImpl;
import com.liferay.portlet.RenderRequestImpl;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;
import com.liferay.portlet.ActionRequestImpl;
import com.larion.progate.sign_up.util.SendMailUtil;
import com.liferay.portlet.ActionResponseImpl;
import com.liferay.portal.model.User; 
import com.liferay.portal.model.Contact;

public class ReSendMailAction extends PortletAction{
	public void processAction(ActionMapping mapping, ActionForm form, 
	  PortletConfig config, ActionRequest req, ActionResponse res) throws Exception {
		HttpServletRequest request = ((ActionRequestImpl) req)
									.getHttpServletRequest();
		
		String useremail = request.getParameter("mail");
		String username = request.getParameter("username");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		// check captcha
		String remoteAddr = request.getRemoteAddr();
		ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
		reCaptcha.setPrivateKey("6LfbubsSAAAAAH9rpEyStTH5LtgbQ-Y2UYBfTIcJ");

		String challenge = request.getParameter("recaptcha_challenge_field");
		String uresponse = request.getParameter("recaptcha_response_field");
		ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr,
				challenge, uresponse);

		if (!reCaptchaResponse.isValid()) {
			request.setAttribute("INVALID_RECAPTCHA", "Mã xác nhận không đúng.");
			request.setAttribute("username", username);
			request.setAttribute("firstname", firstname);
			request.setAttribute("lastname", lastname);
			setForward(req, "portlet.ReSendMail.view");
			return;
		}
		
		String[] listUserMail = new String[1];
		listUserMail[0] = useremail;
		// Send mail
		PortletURL renderURL = ((ActionResponseImpl)res).createRenderURL();
		renderURL.setParameter("requirement", "activeAccount");
		renderURL.setParameter("username", username);
		renderURL.setParameter("email", useremail);
		renderURL.setWindowState(WindowState.MAXIMIZED);
		String activelink = renderURL.toString();
		
		SendMailUtil mail = new SendMailUtil();
		mail.setReceiver(listUserMail);
		mail.setHashCode("saltHere");
		mail.setActivateService("");
		String errorMessage = "";
		try{
			mail.postMail(firstname, lastname, username, activelink);
			request.setAttribute("EMAIL", useremail);
			setForward(req, "portlet.ReSendMail.success");
			return;
		}catch(javax.mail.SendFailedException f){
			System.out.println(f);
			//errorMessage = "Địa chỉ email không tồn tại.";
			//request.setAttribute("MESSAGE_ERROR", errorMessage);
			request.setAttribute("EMAIL", useremail);
			setForward(req, "portlet.ReSendMail.success");
			return;
		}catch(Exception e){
			System.out.println(e);
			//errorMessage = "Có lỗi khi gửi email kích hoạt.";
			//request.setAttribute("MESSAGE_ERROR", errorMessage);
			request.setAttribute("EMAIL", useremail);
			setForward(req, "portlet.ReSendMail.success");
			return;
		}
	}
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
	  PortletConfig config, RenderRequest req, RenderResponse res) throws Exception {
		return mapping.findForward(getForward(req));
	}
	
}
