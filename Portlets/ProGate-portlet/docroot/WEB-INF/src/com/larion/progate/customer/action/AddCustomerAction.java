package com.larion.progate.customer.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;


import larion.progate.model.Organization;
import larion.progate.model.ProGateJournalArticle;
import larion.progate.model.ProGateOrgCustomerRepresenter;
import larion.progate.service.OrganizationLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil;

import larion.progate.model.ProGateOrgCustomer;
import larion.progate.service.ProGateOrgCustomerLocalServiceUtil;
import larion.progate.service.ProGateOrgCustomerRepresenterLocalServiceUtil;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.larion.progate.common.constants.URLParameter_RS;
import com.larion.progate.common.utils.Functions;
import com.larion.progate.customer.constants.Customer_Const;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;

public class AddCustomerAction extends PortletAction {

	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

		int addedSuccess = 0;
		String orgNameErr = "";
		ProGateOrgCustomer orgObject = null;

		int orgId = Integer.parseInt(actionRequest
				.getParameter(URLParameter_RS.ORG_ID));		
		String objectType = actionRequest
				.getParameter(Customer_Const.OBJECT_CUS_SELECTED);
		String customerName = actionRequest
				.getParameter(Customer_Const.ORG_NAME);
		UploadPortletRequest uploadPortlet = PortalUtil
				.getUploadPortletRequest(actionRequest);
		String logo = Functions.getPathOfUploadImage(actionRequest,
				actionResponse, uploadPortlet, Customer_Const.LOGO);
		String description = actionRequest
				.getParameter(Customer_Const.DESCRIPTION);
		String website = actionRequest.getParameter(Customer_Const.WEBSITE);
		int count = Integer.parseInt(actionRequest
				.getParameter(Customer_Const.COUNT));
		String url = actionRequest.getParameter(Customer_Const.URL);

		String[] listFullName = actionRequest
				.getParameterValues(Customer_Const.FULL_NAME);
		String[] listposition = actionRequest
				.getParameterValues(Customer_Const.POSITION);
		String[] listComment = actionRequest
				.getParameterValues(Customer_Const.COMMENT);
		
		System.out.println("orgId = " + orgId);
		
		int type = 0;
		try {
			if(objectType.equals(Customer_Const.CUSTOMER)){
				type = 0;
			}else if(objectType.equals(Customer_Const.PARTNER)){
				type = 2;
			}else{
				type = 1; // both
			}
			boolean isValidCustName = ProGateOrgCustomerLocalServiceUtil
					.validateCustName(customerName, orgId);
			if (isValidCustName) {
				orgObject = ProGateOrgCustomerLocalServiceUtil
						.createCustomerOrgProfile(customerName, description, type,
								logo, website, false, "", orgId);

				if (orgObject != null) {
					int custKey = orgObject.getPrimaryKey();
					createRepresentative(listFullName, listposition,
							listComment, count, custKey, orgId);
					addedSuccess = 1;
				}
				
			} else {
				addedSuccess = 2;
				orgNameErr = Customer_Const.ORG_NAME_ERR;
			}

		} catch (Exception e) {
			addedSuccess = 2; // Error

		}
		
		actionResponse.setRenderParameter(URLParameter_RS.ORG_ID, Integer.toString(orgId));
		actionResponse.setRenderParameter(URLParameter_RS.VIEW_MODE, "1");
		actionResponse.setRenderParameter(Customer_Const.URL, url);
		actionResponse.setRenderParameter(Customer_Const.COUNT,
				Integer.toString(count));
		actionRequest.setAttribute(Customer_Const.ORG_OBJECT, orgObject);
		actionRequest.setAttribute(Customer_Const.ADDED_SUCCESS, addedSuccess);
		actionResponse.setRenderParameter(Customer_Const.TEXT_ERROR_ORG_NAME,
				orgNameErr);
		setForward(actionRequest, "portlet.customer.add");

	}

	private void createRepresentative(String[] listFullName,
			String[] listPosition, String[] listComment, int count,
			int customerId, int orgId) throws Exception {
		for (int i = 0; i < count; i++) {
			if (listFullName[i].trim().length() > 0) {
				ProGateOrgCustomerRepresenterLocalServiceUtil
							.createCustRepresenter(listFullName[i], "",
									listPosition[i], listComment[i], customerId, orgId);
			}

		}

	}
}
