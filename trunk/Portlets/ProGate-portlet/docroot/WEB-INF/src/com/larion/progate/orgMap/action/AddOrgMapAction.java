package com.larion.progate.orgMap.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import larion.progate.model.ProGateJournalArticle;
import larion.progate.service.ProGateJournalArticleLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.larion.progate.common.constants.URLParameter_RS;
import com.larion.progate.common.utils.Functions;
import com.larion.progate.orgMap.constants.OrgMap_Const;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;

public class AddOrgMapAction extends PortletAction {

	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

		int addedSuccess = 0;
		int orgId = Integer.parseInt(actionRequest.getParameter(URLParameter_RS.ORG_ID));
		int viewMode =Integer.parseInt(actionRequest.getParameter(URLParameter_RS.VIEW_MODE));
		String title = actionRequest.getParameter(OrgMap_Const.TITLE);
		UploadPortletRequest uploadPortlet = PortalUtil.getUploadPortletRequest(actionRequest);
		String imageMap = Functions.getPathOfUploadImage(actionRequest, actionResponse, uploadPortlet, OrgMap_Const.IMAGE_MAP);
		//String imageMap = actionRequest.getParameter(OrgMap_Const.IMAGE_MAP);
		String description = actionRequest.getParameter(OrgMap_Const.DESCRIPTION);
		String currentUrl = actionRequest.getParameter(OrgMap_Const.CURRENT_URL);
		
		try {
			 
			 String orgMapType = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeOrgMap();
			 int end = ProGateJournalArticleLocalServiceUtil.countArticleByType(orgId, orgMapType, "");
			
			// Get User
			ServiceContext sc = ServiceContextFactory.getInstance(this
					.getClass().getName(), actionRequest);
			com.liferay.portal.model.User user = UserLocalServiceUtil
					.getUser(sc.getUserId());
			int userId = (int) user.getUserId();

			ProGateJournalArticle orgMapArtical = ProGateJournalArticleLocalServiceUtil.createNewArticle(Integer.toString(orgId), userId, title, orgMapType,description, "", imageMap, imageMap, "");
			if (orgMapArtical != null) {
				addedSuccess = 1; // success
			} else {
				addedSuccess = 2; // error
			}

		} catch (Exception e) {
			addedSuccess = 2; // Error

		}
		
		actionResponse.setRenderParameter(URLParameter_RS.ORG_ID, Integer.toString(orgId));
		actionResponse.setRenderParameter(URLParameter_RS.VIEW_MODE, Integer.toString(viewMode));
		
		actionResponse.setRenderParameter(OrgMap_Const.TITLE, title);
		actionResponse.setRenderParameter(OrgMap_Const.IMAGE_MAP, imageMap);
		actionResponse.setRenderParameter(OrgMap_Const.DESCRIPTION, description);
		actionResponse.setRenderParameter(OrgMap_Const.CURRENT_URL, currentUrl);
		actionRequest.setAttribute(OrgMap_Const.ADDED_SUCCESS, addedSuccess);
		setForward(actionRequest, "portlet.orgMap.add");

	}
}
