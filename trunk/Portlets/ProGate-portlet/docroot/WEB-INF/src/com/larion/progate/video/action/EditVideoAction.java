package com.larion.progate.video.action;

import java.util.List;
import java.util.regex.Pattern;

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

public class EditVideoAction extends PortletAction{
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);	
		
		int editedSuccess = 0;
		int orgId = Integer.parseInt(actionRequest.getParameter(URLParameter_RS.ORG_ID));
		String url = actionRequest.getParameter(Video_Const.CURRENT_URL);
		String videoURL = actionRequest.getParameter(Video_Const.VIDEO_URL);
		
		
		String videoSrc = "";
		String[] x = Pattern.compile("\"").split(videoURL);
		for (int i = 0; i < x.length; i++) {
			if (x[i].indexOf("http://") != -1) {
				videoSrc = x[i];
			}
		}
		String video = "<iframe title='YouTube video player' class='youtube-player' type='text/html' width='100%' height='250' src='" + videoSrc + "' frameborder='0' allowFullScreen></iframe>";
		
		String videoAfterUpdate = "" ;
		String videoData = "";
		String videoSave ="";
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
			org.setVideorUrl(video);
			OrganizationLocalServiceUtil.updateOrganization(org);
			
			// get URL video after edited
			
			videoAfterUpdate = org.getVideorUrl();
			
			
			
			String[] s = Pattern.compile("\'").split(videoAfterUpdate);
			for (int i = 0; i < s.length; i++) {
				if (s[i].indexOf("http://") != -1) {
					videoData = s[i];
				}
			}
			videoSave = "<iframe title='YouTube video player' class='youtube-player' type='text/html' width='300' height='250' src='" + videoData + "' frameborder='0' allowFullScreen></iframe>";
			
			editedSuccess = 1; 
			
		}catch(Exception e){
			editedSuccess = 2;  // Error
			
		}
		
		actionResponse.setRenderParameter(Video_Const.EDITED_SUCCESS,Integer.toString(editedSuccess));
		actionResponse.setRenderParameter(Video_Const.VIDEO_URL,videoSave);
		actionResponse.setRenderParameter(Video_Const.CURRENT_URL,url);
		setForward(actionRequest, "portlet.video.edit");
		
	}
}
