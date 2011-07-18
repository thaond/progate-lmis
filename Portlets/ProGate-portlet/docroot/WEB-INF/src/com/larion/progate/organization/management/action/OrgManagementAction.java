package com.larion.progate.organization.management.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.portlet.PortletConfig;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import larion.progate.model.Organization;
import larion.progate.model.ProGateOrgType;
import larion.progate.model.Region;
import larion.progate.service.OrganizationLocalServiceUtil;
import larion.progate.service.ProGateOrgTypeLocalServiceUtil;
import larion.progate.service.RegionLocalServiceUtil;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.larion.progate.common.constants.Request;
import com.larion.progate.organization.management.business.OrgMaxNoOfUser;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.struts.PortletAction;

public class OrgManagementAction extends PortletAction {

	@Override
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {

		// Get Viet Nam province/city
		List<Region> orgCities = RegionLocalServiceUtil
				.getListRegionByCountryCode("VN");

		// Get Organization Type
		List<ProGateOrgType> orgTypes = ProGateOrgTypeLocalServiceUtil
				.getProGateOrgTypes(0, ProGateOrgTypeLocalServiceUtil
						.getProGateOrgTypesCount());

		// Get max_no_of_users
		OrgMaxNoOfUser orgMaxNoOfUser = new OrgMaxNoOfUser();
		List<OrgMaxNoOfUser> orgMaxNoOfUsers = orgMaxNoOfUser
				.getOrgMaxNoOfUsers();

		String cmd = ParamUtil.getString(req, Constants.CMD);

		if (!cmd.equals("") && cmd != null) {
			String[] orgsIDFromCheckobx = req
					.getParameterValues(Request.CHILD_CKB);

			if (cmd.equals(Request.ENABLE)) { // Enable Organization
				for (int i = 0; i < orgsIDFromCheckobx.length; i++) {

					Organization org = OrganizationLocalServiceUtil
							.getOrganization(Integer
									.parseInt(orgsIDFromCheckobx[i].trim()));

					org.setOrgStatus(true);
					OrganizationLocalServiceUtil.updateOrganization(org);
				}
			} else if (cmd.equals(Request.DISABLE)) { // Dsiable Organization
				for (int i = 0; i < orgsIDFromCheckobx.length; i++) {

					Organization org = OrganizationLocalServiceUtil
							.getOrganization(Integer
									.parseInt(orgsIDFromCheckobx[i].trim()));

					org.setOrgStatus(false);
					OrganizationLocalServiceUtil.updateOrganization(org);
				}
			} else if (cmd.equals(Constants.DELETE)) { // Delete Organization
				try {
					for (int i = 0; i < orgsIDFromCheckobx.length; i++) {
						OrganizationLocalServiceUtil.deleteOrganization(Integer
								.parseInt(orgsIDFromCheckobx[i].trim()));
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			} else if (cmd.equals(Constants.EDIT)) { // Edit Organization
				int org_id = ParamUtil.getInteger(req, Request.ORG_ID);

				Organization org = OrganizationLocalServiceUtil
						.getOrganization(org_id);

				req.setAttribute("orgCities", orgCities);
				req.setAttribute("orgCityCurrent",
						Integer.parseInt(org.getCity()));

				req.setAttribute("orgTypes", orgTypes);
				req.setAttribute("orgTypeCurrent",
						Integer.parseInt(org.getOrgType()));
				req.setAttribute("orgMaxNoOfUsers", orgMaxNoOfUsers);
				req.setAttribute("orgMaxNoOfUserCurrent", org.getMaxUserCount());

				// req.setAttribute("cobsMsgTxt",
				// "message_edit_org_successful");
				req.setAttribute("org", org);
				return mapping
						.findForward("portlet.organization.management.org_edit");
			} else if (cmd.equals(Constants.SEARCH)) {
				// Get list of organizations by name
				String orgSearch = req.getParameter("key_search");
				List<Organization> orgs = null;
				if (orgSearch.equals("all")) {
					orgs = OrganizationLocalServiceUtil.getOrganizations(0,
							OrganizationLocalServiceUtil
									.getOrganizationsCount());
				} else {
					orgs = OrganizationLocalServiceUtil.searchOrgName(
							orgSearch, 0, OrganizationLocalServiceUtil
									.getOrganizationsCount());
					req.setAttribute("key_search", orgSearch);
				}

				paging(mapping, form, config, req, res, orgs);
				return mapping
						.findForward("portlet.organization.management.org_management");
			} else if (cmd.equals(Constants.ADD)) {

				addNewOrg(mapping, form, config, req, res);

				List<Organization> orgs = OrganizationLocalServiceUtil
						.getOrganizations(0, OrganizationLocalServiceUtil
								.getOrganizationsCount());
				paging(mapping, form, config, req, res, orgs);
				req.setAttribute("cobsMsgTxt", "message_create_org_successful");
				return mapping
						.findForward("portlet.organization.management.org_management");
			}
		}

		PortletSession session = req.getPortletSession();
		String cobsMsgTxt = (String) session.getAttribute("cobsMsgTxt");
		if (!"".equals(cobsMsgTxt)) {
			req.setAttribute("cobsMsgTxt", cobsMsgTxt);
			session.removeAttribute("cobsMsgTxt");
		}

		List<Organization> orgs = OrganizationLocalServiceUtil
				.getOrganizations(0,
						OrganizationLocalServiceUtil.getOrganizationsCount());

		paging(mapping, form, config, req, res, orgs);

		return mapping
				.findForward("portlet.organization.management.org_management");
	}

	public void paging(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res,
			List<Organization> orgs) {

		int pageSize = 20;
		int rowsNum = orgs.size();

		int pagesNum = 1;
		if (rowsNum % pageSize == 0) {
			pagesNum = rowsNum / pageSize;
		} else {
			pagesNum = rowsNum / pageSize + 1;
		}

		String sPageNum = req.getParameter("pageNum");

		int pageNum = 1;
		try {
			if (sPageNum.equals("0")) {
				sPageNum = "1";
				pageNum = 1;
			}
			if (!sPageNum.equals("") || (sPageNum != null)) {
				pageNum = Integer.parseInt(sPageNum.trim());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		int from = 0;
		int to;

		if (rowsNum == 0) {
			from = 1;
		} else {

			from = 1 + (pageNum - 1) * pageSize;
		}

		to = from + pageSize - 1;

		if (to > rowsNum) {
			to = rowsNum;
		}

		// Check when delete last line
		if (from > to) {
			from = from - pageSize;
			pageNum = pageNum - 1;
			if (from > 0) {
				to = from + pageSize - 1;
				if (to > rowsNum) {
					to = rowsNum;
				}
			} else {
				from = 0;
				to = 0;
			}
		}

		if (orgs.isEmpty()) {
			req.setAttribute("orgs", orgs.subList(0, 0));
		} else {
			req.setAttribute("orgs", orgs.subList(from - 1, to));
		}

		req.setAttribute("pageSize", pageSize);
		req.setAttribute("rowsNum", rowsNum);

		req.setAttribute("pagesNum", pagesNum);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("from", from);
		req.setAttribute("to", to);

		List<Integer> pages = new ArrayList<Integer>();
		for (int i = 1; i <= pagesNum; i++)
			pages.add(i);
		req.setAttribute("pages", pages);
	}

	public void addNewOrg(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		/* Get parameter from submit form */
		// String org_id = req.getParameter(Request.ORG_ID).trim();
		// System.out.println("org_id: " + org_id);	
		String orgName = req.getParameter(Request.ORG_NAME).trim();
		//System.out.println("Org Name " + orgName);
		String orgAbbr = req.getParameter(Request.ORG_ABBREVIATION).trim();
		//System.out.println("orgAbbr: " + orgAbbr);
		String description = req.getParameter(Request.ORG_DESCRIPTION).trim();
		//System.out.println("description: " + description);
		String country = req.getParameter(Request.ORG_COUNTRY).trim();
		//System.out.println("country: " + country);
		String city = req.getParameter(Request.ORG_CITY).trim();
		//System.out.println("Org city " + city);

		// String state = req.getParameter(Request.ORG_STATE).trim();
		// System.out.println("Org state " + state);
		String address1 = req.getParameter(Request.ORG_ADDRESS_1).trim();
		//System.out.println("address1: " + address1);
		String address2 = req.getParameter(Request.ORG_ADDRESS_2).trim();
		//System.out.println("address2:" + address2);
		String phone = req.getParameter(Request.ORG_PHONE).trim();
		//System.out.println("phone: " + phone);
		String max_user_count = req.getParameter(Request.ORG_MAX_USER_COUNT)
				.trim();
		//System.out.println("max_user_count:" + max_user_count);
		String orgExpired = req.getParameter(Request.ORG_EXPIRED_ON).trim();
		DateFormat dfm = new SimpleDateFormat("dd/MM/yyyy");
		Date expired_on = null;
		if (!"".equals(orgExpired)) {
			expired_on = dfm.parse(orgExpired);
		}
		//System.out.println(orgExpired);

		String org_type = req.getParameter(Request.ORG_TYPE).trim();
		//System.out.println("org_type: " + org_type);

		String orgStatus = req.getParameter(Request.ORG_STATUS).trim();
		//System.out.println("orgStatus: " + orgStatus);
		boolean status = true;
		if (orgStatus.equals("0")) {
			status = true;
		} else {
			status = false;
		}

		try {
			List<Organization> find_org = OrganizationLocalServiceUtil
					.searchOrgName(orgName, 0,
							OrganizationLocalServiceUtil
									.getOrganizationsCount());
/*
			if (find_org.isEmpty()) {
				Organization org = OrganizationLocalServiceUtil
						.createOrganizationFullInformation(0, orgName, orgAbbr,
								description,
								Integer.parseInt(max_user_count.trim()), "",
								org_type, address1, address2, city, "",
								country, phone, new Date(), expired_on, status);
			}*/
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
