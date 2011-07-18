package com.larion.progate.sign_up.action;

import javax.mail.internet.InternetAddress;
import javax.portlet.*;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.liferay.portal.struts.PortletAction;
import java.util.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.liferay.portlet.ActionRequestImpl;
import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;
import com.larion.progate.common.constants.SendMailConst;
import com.larion.progate.common.utils.SendMailUtil;
//import com.larion.progate.sign_up.util.SendMailUtil;
import com.larion.progate.sign_up.util.SignUpUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletURL;
import com.liferay.portlet.ActionResponseImpl;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.regex.Pattern;
import java.text.ParseException;

//import org.apache.jetspeed.userinfo;

public class SignUpAction extends PortletAction {

	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		System.out.println("SignUpAction start");
		
		/* check if gain value from Form */
		boolean flag = true;
		String errorMessage = "";
		req.setCharacterEncoding("UTF-8");
		HttpServletRequest request = ((ActionRequestImpl) req)
				.getHttpServletRequest();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		// check captcha
		String remoteAddr = request.getRemoteAddr();
		ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
		reCaptcha.setPrivateKey("6LfbubsSAAAAAH9rpEyStTH5LtgbQ-Y2UYBfTIcJ");

		String firstname = (String) request.getParameter("firstname");
		String lastname = (String) request.getParameter("lastname");
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		String useremail = (String) request.getParameter("email");
		String sex = (String) request.getParameter("sex");
		String birthday = (String) request.getParameter("birthday");

		String birthday_day = "";
		String birthday_month = "";
		String birthday_year = "";

		String challenge = request.getParameter("recaptcha_challenge_field");
		String uresponse = request.getParameter("recaptcha_response_field");
		ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr,
				challenge, uresponse);

		if (!reCaptchaResponse.isValid()) {
			request.setAttribute("INVALID_RECAPTCHA", "Mã xác nhận không đúng.");

			request.setAttribute("firstname", firstname);
			request.setAttribute("lastname", lastname);
			request.setAttribute("username", username);
			request.setAttribute("email", useremail);
			request.setAttribute("sex", sex);
			request.setAttribute("birthday", birthday);

			setForward(req, "portlet.SignUp.view");
			return;
		}

		if (firstname.equals("") || lastname.equals("") || username.equals("")
				|| password.equals("") || useremail.equals("")
				|| sex.equals("") || birthday.equals("")) {
			request.setAttribute("MESSAGE_ERROR",
					"(*): Thông tin bắt buộc nhập");
			setForward(req, "portlet.SignUp.view");
			return;
		}

		String email_regex = "^[a-zA-Z][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$";
		if (!useremail.matches(email_regex)) {
			request.setAttribute("MESSAGE_ERROR", "Email is invalid!");
			setForward(req, "portlet.SignUp.view");
			return;
		}

		if ((Pattern.matches("^.*['~@#$%^&*;/\\|()\\[\\]{}?<>\\.`].*$",
				firstname)) == true || firstname.length() > 20) {
			request.setAttribute("MESSAGE_ERROR",
					"Họ không chứa ký tự đặc biệt, không quá 20 ký tự.");
			setForward(req, "portlet.SignUp.view");
			return;
		}

		if ((Pattern.matches("^.*['~@#$%^&*;/\\|()\\[\\]{}?<>\\.`].*$",
				lastname)) == true || lastname.length() > 20) {
			request.setAttribute("MESSAGE_ERROR",
					"Tên không chứa ký tự đặc biệt, không quá 20 ký tự.");
			setForward(req, "portlet.SignUp.view");
			return;
		}

		if ((Pattern.matches("^.*['~@#$%^&*;/\\|()\\[\\]{}?<>\\.`].*$",
				username)) == true || username.length() > 20) {
			request.setAttribute("MESSAGE_ERROR",
					"Tên đăng nhập không chứa ký tự đặc biệt, không quá 20 ký tự.");
			setForward(req, "portlet.SignUp.view");
			return;
		}

		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		Date testDate = null;
		try {
			testDate = sdf.parse(birthday);
		} catch (ParseException parse) {
			request.setAttribute("MESSAGE_ERROR",
					"Không đúng format dd/mm/yyyy");
			setForward(req, "portlet.SignUp.view");
			return;
		}
		// now test for legal values of parameters
		if (!sdf.format(testDate).equals(birthday)) {
			request.setAttribute("MESSAGE_ERROR",
					"Ngày tháng năm nhập vào không hợp lệ.");
			setForward(req, "portlet.SignUp.view");
			return;
		} else {
			String[] days = birthday.split("/");
			birthday_day = days[0];
			birthday_month = days[1];
			birthday_year = days[2];
		}

		Calendar currentcal = Calendar.getInstance();
		currentcal.set(currentcal.get(Calendar.YEAR),
				currentcal.get(Calendar.MONTH),
				currentcal.get(Calendar.DAY_OF_MONTH));

		Calendar cal = Calendar.getInstance();
		cal.set(Integer.valueOf(birthday_year),
				Integer.valueOf(birthday_month) - 1,
				Integer.valueOf(birthday_day));

		if (cal.after(currentcal)) {
			String message_error = "Ngày sinh "
					+ new SimpleDateFormat("dd/MM/yyyy").format(cal.getTime())
					+ " lớn hơn ngày hiện tại "
					+ new SimpleDateFormat("dd/MM/yyyy").format(currentcal
							.getTime());
			request.setAttribute("MESSAGE_ERROR", message_error);
			setForward(req, "portlet.SignUp.view");
			return;
		}

		HashMap info_user = new HashMap();
		info_user.put("password", new String(password));
		info_user.put("username", new String(username));
		info_user.put("useremail", new String(useremail));
		info_user.put("firstname", new String(firstname));
		info_user.put("lastname", new String(lastname));
		info_user.put("sex", new String(sex));
		info_user.put("birthday_month", new String(birthday_month));
		info_user.put("birthday_day", new String(birthday_day));
		info_user.put("birthday_year", new String(birthday_year));

		String[] listUserMail = new String[1];
		listUserMail[0] = useremail;
		// Send mail
		PortletURL renderURL = ((ActionResponseImpl) res).createRenderURL();
		renderURL.setParameter("requirement", "activeAccount");
		renderURL.setParameter("username", username);
		renderURL.setParameter("email", useremail);
		renderURL.setWindowState(WindowState.MAXIMIZED);
		String activelink = renderURL.toString();

		// SendMailUtil mail = new SendMailUtil();
		// mail.setReceiver(listUserMail);
		// mail.setHashCode("saltHere");
		// mail.setActivateService("");
		System.out.println("SignUpUtil.addUser start");
		String add_result = SignUpUtil.addUser(info_user, req);
		System.out.println("add_result: " + add_result);
		
		if (add_result != null) {
			request.setAttribute("MESSAGE_ERROR", add_result);
			request.setAttribute("firstname", firstname);
			request.setAttribute("lastname", lastname);
			request.setAttribute("sex", sex);
			request.setAttribute("birthday", birthday);
			setForward(req, "portlet.SignUp.view");
			return;
		} else {
			try {
				// Send mail
				
				StringBuilder activationUrl = new StringBuilder();
				activationUrl.append(activelink);
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date today = new Date();
				Date seven_date = new Date(today.getTime()
						+ (1000 * 60 * 60 * 24 * 7));

				System.out.println("Begin send mail:");
				InternetAddress[] to = { new InternetAddress(useremail,
						firstname + " " + lastname) };

				SendMailUtil mailSender = new SendMailUtil();
				mailSender.sendMail(to, SendMailConst.ACTIVE_MEMBER,
						new String[] {}, new String[] {}, new String[] {
								"[$UserName$]", "[$Link$]", "[$date$]" },
						new String[] { username, activationUrl.toString(),
								dateFormat.format(seven_date)});

				System.out
						.println("activationUrl: " + activationUrl.toString());
				System.out.println("Send mail successful!");

				request.setAttribute("FIRSTNAME", firstname);
				request.setAttribute("LASTNAME", lastname);
				request.setAttribute("EMAIL", useremail);
				request.setAttribute("USERNAME", username);
				setForward(req, "portlet.SignUp.success");
				return;
			} catch (Exception e) {
				System.out.println(e);
				request.setAttribute("FIRSTNAME", firstname);
				request.setAttribute("LASTNAME", lastname);
				request.setAttribute("EMAIL", useremail);
				request.setAttribute("USERNAME", username);
				setForward(req, "portlet.SignUp.success");
				return;
			}
		}
	}

	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		return mapping.findForward(getForward(req));
	}
}
