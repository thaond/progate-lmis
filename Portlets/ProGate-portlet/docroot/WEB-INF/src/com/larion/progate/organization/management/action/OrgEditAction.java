package com.larion.progate.organization.management.action;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletSession;
import larion.progate.model.Organization;
import larion.progate.service.OrganizationLocalServiceUtil;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.larion.progate.common.constants.Request;
import com.larion.progate.informationOrg.business.OrgType;
import com.larion.progate.organization.management.business.OrgCity;
import com.larion.progate.organization.management.business.OrgMaxNoOfUser;

import com.liferay.portal.struts.PortletAction;

public class OrgEditAction extends PortletAction {
	
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		
		try {
			String org_id = actionRequest.getParameter(Request.ORG_ID).trim();
			System.out.println("org_id: " + org_id);
			String orgName = actionRequest.getParameter(Request.ORG_NAME).trim();
			System.out.println("Org Name " + orgName);
			String orgAbbr = actionRequest.getParameter(Request.ORG_ABBREVIATION).trim();
			System.out.println("orgAbbr: "+orgAbbr);
			String description = actionRequest.getParameter(Request.ORG_DESCRIPTION).trim();
			System.out.println("description: " + description);
			String country = actionRequest.getParameter(Request.ORG_COUNTRY).trim();
			System.out.println("country: "+ country);
			String city = actionRequest.getParameter(Request.ORG_CITY).trim();
			System.out.println("Org city " + city);
			//String state = actionRequest.getParameter(Request.ORG_STATE).trim();
			//System.out.println("Org state " + state);
			String address1 = actionRequest.getParameter(Request.ORG_ADDRESS_1).trim();
			System.out.println("address1: "+address1);
			String address2 = actionRequest.getParameter(Request.ORG_ADDRESS_2).trim();
			System.out.println("address2:" + address2);
			String phone = actionRequest.getParameter(Request.ORG_PHONE).trim();
			System.out.println("phone: "+phone);
			String max_user_count = actionRequest.getParameter(Request.ORG_MAX_USER_COUNT).trim();
			System.out.println("max_user_count:"+max_user_count);
			String orgExpired = actionRequest.getParameter(Request.ORG_EXPIRED_ON).trim();
			DateFormat dfm = new SimpleDateFormat("dd/MM/yyyy");
			Date expired_on = null;
			if (!"".equals(orgExpired)) {
				expired_on = dfm.parse(orgExpired);
			}
			System.out.println(orgExpired);
			String org_type = actionRequest.getParameter(Request.ORG_TYPE).trim();
			System.out.println("org_type: " + org_type);
			String orgStatus = actionRequest.getParameter(Request.ORG_STATUS).trim();
			System.out.println("orgStatus: "+orgStatus);

			//String orgProfile = actionRequest.getParameter(Request.ORG_PROFILE).trim();//field nay chua co
			
			Organization org = OrganizationLocalServiceUtil
					.getOrganization(Integer.parseInt(org_id));
			// Organization org =
			// OrganizationLocalServiceUtil.createOrganizationFullInformation(orgName,
			// orgAbbr, description, Integer.parseInt(max_user_count.trim()),
			// "",
			// org_type, address1, address2, state, state, country, phone, new
			// Date(), new Date(orgExpired) );
			org.setName(orgName);
			org.setAbbreviation(orgAbbr);
			org.setDescription(description);
			org.setMaxUserCount(Integer.parseInt(max_user_count));
			org.setAddress1(address1);
			org.setAddress2(address2);
			org.setCity(city);
			//org.setState(state);
			org.setCountry(country);
			org.setPhone(phone);
			// org.setType_id(Integer.parseInt(org_type));
			org.setOrgType(org_type);
			org.setExpiredDate(expired_on);
           
			if (orgStatus.equals("0")) {
				org.setOrgStatus(true);
			} else {
				org.setOrgStatus(false);
			}


			OrganizationLocalServiceUtil.updateOrganization(org);
			
			org = OrganizationLocalServiceUtil
					.getOrganization(Integer.parseInt(org_id));
			//actionRequest.setAttribute("org", org);
			
			// Get Viet Nam province/city
			OrgCity orgCity = new OrgCity();
			List<OrgCity> orgCities = orgCity.getOrgCities();
			
			// Get Organization Type
			OrgType orgType = new OrgType();
			List<OrgType> orgTypes = orgType.getOrgTypes();
			
			// Get max_no_of_users
			OrgMaxNoOfUser orgMaxNoOfUser = new OrgMaxNoOfUser();
			List<OrgMaxNoOfUser> orgMaxNoOfUsers = orgMaxNoOfUser.getOrgMaxNoOfUsers();
			
			actionRequest.setAttribute("orgCities", orgCities);
			actionRequest.setAttribute("orgCityCurrent", Integer.parseInt(org.getCity()));
			
			actionRequest.setAttribute("orgTypes", orgTypes);				
			actionRequest.setAttribute("orgTypeCurrent", Integer.parseInt(org.getOrgType()));
			
			actionRequest.setAttribute("orgMaxNoOfUsers", orgMaxNoOfUsers);				
			actionRequest.setAttribute("orgMaxNoOfUserCurrent", org.getMaxUserCount()); 
			
			//actionRequest.setAttribute("cobsMsgTxt", "message_edit_org_successful");			
			
			//actionRequest.setAttribute("cobsMsgTxt", "message_edit_org_successful");
			PortletSession session = actionRequest.getPortletSession();
			session.setAttribute("cobsMsgTxt", "message_edit_org_successful");
		} catch (Exception e) {			
			System.out.println("Error: "+e.getMessage());
		}
		
		setForward(actionRequest, "portlet.organization.management.org_management");
	}
	
	/*
	@Override
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		System.out.println("let go");
		try {
			String org_id = req.getParameter(Request.ORG_ID).trim();
			System.out.println("org_id: " + org_id);
			String orgName = req.getParameter(Request.ORG_NAME).trim();
			System.out.println("Org Name " + orgName);
			String orgAbbr = req.getParameter(Request.ORG_ABBREVIATION).trim();
			System.out.println("orgAbbr: "+orgAbbr);
			String description = req.getParameter(Request.ORG_DESCRIPTION).trim();
			System.out.println("description: " + description);
			String country = req.getParameter(Request.ORG_COUNTRY).trim();
			System.out.println("country: "+ country);
			String city = req.getParameter(Request.ORG_CITY).trim();
			System.out.println("Org city " + city);
			//String state = req.getParameter(Request.ORG_STATE).trim();
			//System.out.println("Org state " + state);
			String address1 = req.getParameter(Request.ORG_ADDRESS_1).trim();
			System.out.println("address1: "+address1);
			String address2 = req.getParameter(Request.ORG_ADDRESS_2).trim();
			System.out.println("address2:" + address2);
			String phone = req.getParameter(Request.ORG_PHONE).trim();
			System.out.println("phone: "+phone);
			String max_user_count = req.getParameter(Request.ORG_MAX_USER_COUNT).trim();
			System.out.println("max_user_count:"+max_user_count);
			String orgExpired = req.getParameter(Request.ORG_EXPIRED_ON).trim();
			DateFormat dfm = new SimpleDateFormat("dd/MM/yyyy");
			Date expired_on = null;
			if (!"".equals(orgExpired)) {
				expired_on = dfm.parse(orgExpired);
			}
			System.out.println(orgExpired);
			String org_type = req.getParameter(Request.ORG_TYPE).trim();
			System.out.println("org_type: " + org_type);
			String orgStatus = req.getParameter(Request.ORG_STATUS).trim();
			System.out.println("orgStatus: "+orgStatus);

			Organization org = OrganizationLocalServiceUtil
					.getOrganization(Integer.parseInt(org_id));
			// Organization org =
			// OrganizationLocalServiceUtil.createOrganizationFullInformation(orgName,
			// orgAbbr, description, Integer.parseInt(max_user_count.trim()),
			// "",
			// org_type, address1, address2, state, state, country, phone, new
			// Date(), new Date(orgExpired) );
			org.setName(orgName);
			org.setAbbreviation(orgAbbr);
			org.setDescription(description);
			org.setMax_user_count(Integer.parseInt(max_user_count));
			org.setAddress1(address1);
			org.setAddress2(address2);
			org.setCity(city);
			//org.setState(state);
			org.setCountry(country);
			org.setPhone(phone);
			// org.setType_id(Integer.parseInt(org_type));
			org.setSubscription_expiration_date(expired_on);

			if (orgStatus.equals("0")) {
				org.setOrgStatus(true);
			} else {
				org.setOrgStatus(false);
			}

			OrganizationLocalServiceUtil.updateOrganization(org);
			
			org = OrganizationLocalServiceUtil
					.getOrganization(Integer.parseInt(org_id));
			req.setAttribute("org", org);
			
			// Get Viet Nam province/city
			OrgCity orgCity = new OrgCity();
			List<OrgCity> orgCities = orgCity.getOrgCities();
			
			// Get Organization Type
			OrgType orgType = new OrgType();
			List<OrgType> orgTypes = orgType.getOrgTypes();
			
			// Get max_no_of_users
			OrgMaxNoOfUser orgMaxNoOfUser = new OrgMaxNoOfUser();
			List<OrgMaxNoOfUser> orgMaxNoOfUsers = orgMaxNoOfUser.getOrgorgMaxNoOfUsers();
			
			req.setAttribute("orgCities", orgCities);
			req.setAttribute("orgCityCurrent", Integer.parseInt(org.getCity()));
			
			req.setAttribute("orgTypes", orgTypes);				
			req.setAttribute("orgTypeCurrent", 1); // waiting
			
			req.setAttribute("orgMaxNoOfUsers", orgMaxNoOfUsers);				
			req.setAttribute("orgMaxNoOfUserCurrent", org.getMax_user_count()); 
			
			//req.setAttribute("cobsMsgTxt", "message_edit_org_successful");			
			
			req.setAttribute("cobsMsgTxt", "message_edit_org_successful");
			
		} catch (Exception e) {			
			System.out.println("Error: "+e.getMessage());
		}
		//PortletURL portletURL = res.createRenderURL();
		//portletURL.setProperty(arg0, arg1)
		return mapping.findForward("portlet.organization.management.org_edit");
		//return mapping.findForward("portlet.organization.management.org_management");
	}*/
}
