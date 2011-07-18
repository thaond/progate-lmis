package com.larion.progate.organization.management.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import larion.progate.model.Organization;
import larion.progate.service.OrganizationLocalServiceUtil;

import com.larion.progate.common.constants.Request;
import com.liferay.portal.SystemException;

public class ValidateOrgServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		String sOrgName = req.getParameter(Request.ORG_NAME).trim();
		boolean isOrgNameExist = false;		
		
		System.out.println("Test exist Org Name: " + sOrgName);
		try {
			if (!"".equals(sOrgName)) {

				List<Organization> orgs = OrganizationLocalServiceUtil
						.getOrganizations(0, OrganizationLocalServiceUtil
								.getOrganizationsCount());
				
				for (Organization organization : orgs) {
					if (sOrgName.equals(organization.getName())) {
						isOrgNameExist = true;
						break;
					}
				}
			}
		} catch (SystemException e) {
			System.out.println("Error: ");
			e.printStackTrace();
		}

		if (isOrgNameExist) {
			out.print("inValid");
			System.out.println("inValid");
		} else {
			out.print("valid");
			System.out.println("valid");
		}

		out.close();
	}
}
