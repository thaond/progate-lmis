package com.larion.progate.video.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;

import larion.progate.model.Organization;
import larion.progate.service.OrganizationLocalServiceUtil;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.larion.progate.common.constants.URLParameter_RS;
import com.larion.progate.video.constants.Video_Const;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;

public class DeleteVideoAction extends PortletAction{
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);	
		int deleteSuccess = 0;
		int orgId = Integer.parseInt(request.getParameter(URLParameter_RS.ORG_ID));
		int mode = Integer.parseInt(request.getParameter(Video_Const.MODE));
		String url = actionRequest.getParameter(Video_Const.CURRENT_URL);
		

		try{
			//Organization org = OrganizationLocalServiceUtil.getOrganization(orgId);
			List<Organization> listOrg = OrganizationLocalServiceUtil.getOrganizations(0, OrganizationLocalServiceUtil.getOrganizationsCount());
			Organization org = null;
			for (Organization organization : listOrg) {
				if (organization.getPrimaryKey() == orgId) {
					org = organization;
					break;
				}
			}
			org.setVideorUrl(null);
			OrganizationLocalServiceUtil.updateOrganization(org);
		deleteSuccess = 3; 
		}catch(Exception e){
			deleteSuccess = 4;  // Error
		}
		//String urlEditVideo = homeUrl + "/" + Video_Const.VIDEO_PAGE + "?" + URLParameter_RS.ORG_ID + "=" + orgId + "&" + Video_Const.MODE + "=" + 2;
		
		actionResponse.setRenderParameter(Video_Const.CURRENT_URL, url);
		
		if(mode == 1){
			actionResponse.setRenderParameter(Video_Const.ADDED_SUCCESS,Integer.toString(deleteSuccess));
			setForward(actionRequest, "portlet.video.add");
		}else{
			actionResponse.setRenderParameter(Video_Const.EDITED_SUCCESS, Integer.toString(deleteSuccess));
			setForward(actionRequest, "portlet.video.edit");
		}
		
	}

}
