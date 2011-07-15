package com.larion.progate.customer.action;

import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;


import larion.progate.model.Organization;
import larion.progate.model.ProGateJournalArticle;
import larion.progate.service.OrganizationLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil;

import larion.progate.model.ProGateOrgCustomer;
import larion.progate.model.ProGateOrgCustomerRepresenter;
import larion.progate.service.ProGateOrgCustomerLocalServiceUtil;
import larion.progate.service.ProGateOrgCustomerRepresenterLocalServiceUtil;
import larion.progate.service.ProGateOrgCustomerLocalServiceUtil;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.larion.progate.achievementMgmt.constants.AchievementConst;
import com.larion.progate.common.constants.URLParameter_RS;
import com.larion.progate.common.utils.Functions;
import com.larion.progate.customer.constants.Customer_Const;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;

public class EditCustomerAction extends PortletAction {

	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

		int addedSuccess = 0;
		String custNameErr = "";
		String logo = "";
		int orgId = Integer.parseInt(actionRequest
				.getParameter(URLParameter_RS.ORG_ID));	
		int objectId = Integer.parseInt(actionRequest
				.getParameter(Customer_Const.OBJECT_ID));
		String objectType = actionRequest
				.getParameter(Customer_Const.OBJECT_CUS);
		String custName = actionRequest.getParameter(Customer_Const.ORG_NAME);
		UploadPortletRequest uploadPortlet = PortalUtil
				.getUploadPortletRequest(actionRequest);
		
		String logoUrl = (String) actionRequest.getParameter(Customer_Const.LOGO).trim();
		System.out.println("logoUrl = " + logoUrl);
		
		try {
			if (logoUrl.length() > 0) {
				logo = Functions.getPathOfUploadImage(actionRequest,
					actionResponse, uploadPortlet, Customer_Const.LOGO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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

		ProGateOrgCustomer custObject = null;
		int type = 0;
		try {
			
			if(objectType.equals(Customer_Const.CUSTOMER)){
				type = 0;
			}else if(objectType.equals(Customer_Const.PARTNER)){
				type = 2;
			}else{
				type = 1;
			}

			custObject = ProGateOrgCustomerLocalServiceUtil
					.getProGateOrgCustomer(objectId);
			
			if (custObject != null) {
				custObject.setCustomerName(custName);
				custObject.setCustomerType(type);
				custObject.setWebsite(website);
				custObject.setDescription(description);
				custObject.setModifiedDate(new Date());
				if (logo != "") {
					custObject.setLogo(logo);
				}
				
				List<ProGateOrgCustomerRepresenter> listFounder = ProGateOrgCustomerRepresenterLocalServiceUtil
						.getListCustRepresenterByCustId(objectId, 0, 100, false);
				
				if (listFounder != null) {
					for (ProGateOrgCustomerRepresenter representer : listFounder) {
						ProGateOrgCustomerRepresenterLocalServiceUtil
								.deleteProGateOrgCustomerRepresenter(representer);
					}
				}

				createRepresentative(listFullName, listposition, listComment,
						count, objectId, orgId);
				
				ProGateOrgCustomerLocalServiceUtil.updateProGateOrgCustomer(custObject,true);

				addedSuccess = 1;
			}

		} catch (Exception e) {
			addedSuccess = 2; // Error

		}
		actionResponse.setRenderParameter(Customer_Const.URL, url);
		actionResponse.setRenderParameter(Customer_Const.COUNT,
				Integer.toString(count));
		actionResponse.setRenderParameter(Customer_Const.OBJECT_ID,
				Integer.toString(objectId));
		actionRequest.setAttribute(Customer_Const.ORG_OBJECT, custObject);
		actionRequest.setAttribute(Customer_Const.ADDED_SUCCESS, addedSuccess);
		actionResponse.setRenderParameter(Customer_Const.TEXT_ERROR_ORG_NAME,
				custNameErr);
		
		setForward(actionRequest, "portlet.customer.edit");
	}

	private void createRepresentative(String[] listFullName,
			String[] listPosition, String[] listComment, 
			int count, int custKey, int orgId) throws Exception {
		
		for (int i = 0; i < count; i++) {
			if (listFullName[i].trim().length() > 0) {
				ProGateOrgCustomerRepresenterLocalServiceUtil
							.createCustRepresenter(listFullName[i], "",
									listPosition[i], listComment[i], custKey, orgId);
			}
		}

	}
}
