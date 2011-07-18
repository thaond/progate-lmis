package com.larion.progate.organization.user.management.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import larion.progate.model.Organization;
import larion.progate.model.User;
import larion.progate.service.OrganizationLocalServiceUtil;
import larion.progate.service.ProgateOrganizationParticipantsLocalServiceUtil;
import com.larion.progate.common.constants.Request;
import com.liferay.portal.kernel.util.ParamUtil;

public class CheckingValidDecentralizeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter output = response.getWriter();

		try {
			int orgId = ParamUtil.getInteger(request, Request.ORG_ID, 0);

			Organization org = OrganizationLocalServiceUtil
					.getOrganization(orgId);

			boolean isRootOrg = false;

			if (org.getOrgId() == org.getRootId()) {
				isRootOrg = true;
			}

			int userId = ParamUtil.getInteger(request, Request.USER_ID, 0);

			User owner = ProgateOrganizationParticipantsLocalServiceUtil
					.getOwnerOfOrganizaton(orgId);

			if (owner != null && owner.getUserid() == userId) {
				output.println("action.delete.role.owner.of.user");
			} else {
				if (isRootOrg) {
					output.println(owner.getScreenname());
				} else {

					User manager = ProgateOrganizationParticipantsLocalServiceUtil
							.getManagerOfOrganizaton(orgId);

					if (manager != null && manager.getUserid() == userId) {
						output.println("action.delete.role.manager.of.user");
					} else {
						output.println(manager.getScreenname());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		output.flush();

		output.close();
	}
}
