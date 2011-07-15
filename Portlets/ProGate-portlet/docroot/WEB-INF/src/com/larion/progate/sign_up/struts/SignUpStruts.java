package com.larion.progate.sign_up.struts;

import com.liferay.portlet.StrutsPortlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.PortletRequestDispatcher;
import com.liferay.portal.util.PortalUtil;
import javax.portlet.*;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.model.User;
import com.larion.progate.sign_up.util.SignUpUtil;

/**
 * @Sample Struts Portlet controller
 * 
 * @author Jeff Robinson
 * 
 */
public class SignUpStruts extends StrutsPortlet {
	String pageToRender = "";

	@Override
	public void doView(RenderRequest request, RenderResponse response)
			throws IOException, PortletException {

		String viewURL = PortalUtil.getCurrentURL(request);
		String re_sendemailPage = request.getParameter("re_sendemail");
		String activeAccount = request.getParameter("requirement");
		response.setContentType("text/html");
		
		System.out.println("SignUpStruts let go");
		
		if (re_sendemailPage != null
				&& re_sendemailPage.contains("re_sendemail")) {
			
			System.out.println("re_sendemail");
			
			this.pageToRender = "/html/portlet/sign_up/ReSendMail/view.jsp";
			request.setAttribute("username", request.getParameter("username"));
			request.setAttribute("firstname", request.getParameter("firstname"));
			request.setAttribute("lastname", request.getParameter("lastname"));
			PortletRequestDispatcher dispatcher = getPortletContext()
					.getRequestDispatcher(pageToRender);
			dispatcher.include(request, response);
		} else if (activeAccount != null
				&& activeAccount.contains("activeAccount")) {
			System.out.println("activeAccount");
			
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			
			System.out.println("username: " + username + " - email: " + email);
			if (username != null && email != null) {
				System.out.println("SignUpUtil.activeAccount");
				int kq = SignUpUtil.activeAccount(username, email, request,
						response);
				System.out.println("kq: " + kq);
				
				if (kq == 1) {
					String login_page = "/dang-nhap?username=" + username
							+ "&active=1";
					request.setAttribute("login_page", login_page);
					this.pageToRender = "/html/portlet/sign_up/ActiveAccount/success.jsp";
				} else if (kq == 0) {
					this.pageToRender = "/html/portlet/sign_up/ActiveAccount/expiration.jsp";
				} else if (kq == -1) {
					this.pageToRender = "/html/portlet/sign_up/ActiveAccount/error.jsp";
				} else if (kq == -2) {
					this.pageToRender = "/html/portlet/sign_up/ActiveAccount/duplication.jsp";
				}
			} else {
				this.pageToRender = "/html/portlet/sign_up/ActiveAccount/error.jsp";
			}

			PortletRequestDispatcher dispatcher = getPortletContext()
					.getRequestDispatcher(pageToRender);
			dispatcher.include(request, response);
		} else {
			super.doView(request, response);
		}
	}

	@Override
	public void doConfig(RenderRequest req, RenderResponse res)
			throws IOException, PortletException {
		super.doConfig(req, res);
	}

	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response)
			throws PortletException, IOException {
		System.out.println("serveResource start");
		
		response.setContentType("application/json");
		String resourceId = request.getResourceID();
		String username = request.getParameter("check_username");
		String useremail = request.getParameter("useremail");
		System.out.println("username: " + username + " - useremail: " + useremail);
		
		PrintWriter writer = response.getWriter();
		try {
			long companyId = PortalUtil.getCompany(request).getCompanyId();
			if (resourceId.equals("checkUser")) {
				User screenname = UserLocalServiceUtil.getUserByScreenName(
						companyId, username);
				
				if (screenname != null) {
					System.out.println("screenname: " + screenname.getUserId());
					
					writer.println("Tên đăng nhập đã được sử dụng");
				}
			} else if (resourceId.equals("checkEmail")) {
				User email = UserLocalServiceUtil.getUserByEmailAddress(
						companyId, useremail);
				if (email != null) {
					System.out.println("email: " + email.getUserId());
					
					writer.println("Email đã được sử dụng");
				}
			}
		} catch (com.liferay.portal.NoSuchUserException no) {
			System.out.println(no);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
