package com.larion.progate.video.view;

import com.larion.progate.common.constants.URLParameter_RS;
import com.larion.progate.common.constants.ProgateRoleConst;
import com.larion.progate.video.constants.Video_Const;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.StrutsPortlet;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import larion.progate.model.Organization;
import larion.progate.service.OrganizationLocalServiceUtil;

/**
 * <p>Your description here</p>
 *
 * @author (Your name)
 *
 */
public class SamplePortlet extends StrutsPortlet {

	@Override
	public void doView(RenderRequest req, RenderResponse res)
		throws IOException, PortletException {
		
		
		HttpServletRequest request = PortalUtil.getHttpServletRequest(req);	
		HttpServletRequest orgRequest = PortalUtil.getOriginalServletRequest(request);
		int orgId = 0;
		//int mode = 0;
		int addSuccess = 0;
		int editSuccess = 0;
		int viewMode = 0;
		
		if(orgRequest.getParameter(URLParameter_RS.ORG_ID) != null){
			orgId = Integer.parseInt(orgRequest.getParameter(URLParameter_RS.ORG_ID));
		}

		if(orgRequest.getParameter(URLParameter_RS.VIEW_MODE) != null){
			viewMode = Integer.parseInt(orgRequest.getParameter(URLParameter_RS.VIEW_MODE));
		}
		
//		if(orgRequest.getParameter(Video_Const.MODE) != null){
//			mode = Integer.parseInt(orgRequest.getParameter(Video_Const.MODE));
//		}
		// Build URL
		String homeUrl= PortalUtil.getPortalURL(request);
		String viewURL = PortalUtil.getCurrentURL(req);
		String page ="";
		if(viewURL.indexOf(StringPool.QUESTION) != -1){
			//String[] s = viewURL.split(StringPool.QUESTION);
			String[] s = Pattern.compile("\\?").split(viewURL);
			page = s[0];
		}
		String currentUrl = homeUrl + page + StringPool.QUESTION + URLParameter_RS.ORG_ID + StringPool.EQUAL+ orgId + StringPool.AMPERSAND + URLParameter_RS.VIEW_MODE + StringPool.EQUAL+ viewMode;
		
		if(orgRequest.getParameter(Video_Const.ADDED_SUCCESS) != null){
			addSuccess = Integer.parseInt(orgRequest.getParameter(Video_Const.ADDED_SUCCESS));
		}
		
		if(orgRequest.getParameter(Video_Const.EDITED_SUCCESS) != null){
			editSuccess = Integer.parseInt(orgRequest.getParameter(Video_Const.EDITED_SUCCESS));
		}

		String videoUrl = "";
		String video = "";
		boolean isOrgAdmin = false;
		if(orgId != 0){
			try {
				// Get information of org
				//Organization org = OrganizationLocalServiceUtil.getOrganization(orgId);

				List<Organization> listOrg = OrganizationLocalServiceUtil.getOrganizations(0, OrganizationLocalServiceUtil.getOrganizationsCount());
				Organization org = null;
				for (Organization organization : listOrg) {
					if (organization.getPrimaryKey() == orgId) {
						org = organization;
						break;
					}
				}
				videoUrl = org.getVideorUrl();
				
				if(!videoUrl.isEmpty()){
					String videoSrc = "";
					String[] x = Pattern.compile("\'").split(videoUrl);
					for (int i = 0; i < x.length; i++) {
						if (x[i].indexOf("http://") != -1) {
							videoSrc = x[i];
						}
					}
					video = "<iframe title='YouTube video player' class='youtube-player' type='text/html' width='100%' height='250' src='" + videoSrc + "' frameborder='0' allowFullScreen></iframe>";
				}
				// Get User
				ServiceContext sc = ServiceContextFactory.getInstance(this.getClass().getName(), req);
				com.liferay.portal.model.User user = UserLocalServiceUtil.getUser(sc.getUserId());
				long userId = user.getUserId();
				
				List<String> listRole = larion.progate.service.ProgateOrganizationParticipantsLocalServiceUtil.getUserRoles(userId, orgId);
				for(String role : listRole){
					if(ProgateRoleConst.PROGATE_ADMIN.equals(role) 
						|| ProgateRoleConst.ORG_ADMIN.equals(role)
						|| ProgateRoleConst.ORG_OWNER.equals(role)){
						isOrgAdmin = true;
					}
				}
				
			} catch (Exception e) {
				
			}
		}

		req.setAttribute(Video_Const.CURRENT_URL, currentUrl);
		req.setAttribute(URLParameter_RS.ORG_ID, orgId);
		req.setAttribute(Video_Const.VIDEO_URL, video);
		req.setAttribute(Video_Const.ADDED_SUCCESS, addSuccess);
		req.setAttribute(Video_Const.EDITED_SUCCESS, editSuccess);
		req.setAttribute(Video_Const.IS_ORG_ADMIN,isOrgAdmin);
		req.setAttribute(URLParameter_RS.VIEW_MODE, viewMode);
		super.doView(req, res);
	}

}
