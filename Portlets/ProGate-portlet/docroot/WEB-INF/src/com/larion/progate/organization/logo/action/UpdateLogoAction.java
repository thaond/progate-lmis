package com.larion.progate.organization.logo.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;

import larion.progate.model.Organization;
import larion.progate.service.OrganizationLocalServiceUtil;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.larion.progate.common.constants.URLParameter_RS;
import com.larion.progate.common.utils.ProGateUtil;
import com.larion.progate.organization.logo.OrganizationImage;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.ActionRequestImpl;


public class UpdateLogoAction extends PortletAction {
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)

	throws Exception {
	
		HttpServletRequest request = ((ActionRequestImpl) actionRequest).getHttpServletRequest();
        request.setCharacterEncoding("UTF-8");

        
        Integer orgId = ParamUtil.getInteger(actionRequest, URLParameter_RS.ORG_ID);
		String imageId = ParamUtil.getString(actionRequest, URLParameter_RS.ID);
		String field = ParamUtil.getString(actionRequest, URLParameter_RS.FIELD);
		String logoUrl = "";
		String bannerUrl = "";
		
		try {			
			if(Validator.isDigit(imageId) && orgId > 0){
				Organization org = OrganizationLocalServiceUtil
				.getOrganization(orgId);
				if(field.equals(URLParameter_RS.LOGO)){
					OrganizationImage orgLogo = new OrganizationImage(org, OrganizationImage.LOGO);
					orgLogo.setLocalImageId(Long.parseLong(imageId));
					logoUrl = ProGateUtil.getImageURL(orgLogo.getSmallImageId(), request);					
					org.setLogoId(logoUrl);
					
				}else if(field.equals(URLParameter_RS.BANNER)){
					OrganizationImage orgBanner = new OrganizationImage(org, OrganizationImage.BANNER);
					orgBanner.setLocalImageId(Long.parseLong(imageId));
					bannerUrl = ProGateUtil.getImageURL(orgBanner.getLargeImageId(), request);
					org.setBannerId(bannerUrl);
				}
				
				OrganizationLocalServiceUtil.updateOrganization(org);
			}

			request.setAttribute("REPAIR_SUCCESS", "Bạn đã thêm tin tức thành công.");
			if (field.equals(URLParameter_RS.LOGO)){
				setForward(actionRequest, "portlet.organization.logo.update");
			}else if (field.equals(URLParameter_RS.BANNER)){
				setForward(actionRequest, "portlet.organization.logo.updateBanner");
			}
			return;
//			String returnURL = getHomeRedirect(portletConfig, actionRequest, String.valueOf(orgId),
//												String.valueOf(URLParameter_RS.EDIT_MODE));
			// sendRedirect(actionRequest, actionResponse, returnURL);
//			actionResponse.sendRedirect(returnURL);
		} catch (Exception e) {
			// TODO: handle exception			
			//e.printStackTrace();
			request.setAttribute("REPAIR_ERROR", "Bạn đã thêm tin tức thành công.");
			if (field.equals(URLParameter_RS.LOGO)){
				setForward(actionRequest, "portlet.organization.logo.update");
			}else if (field.equals(URLParameter_RS.BANNER)){
				setForward(actionRequest, "portlet.organization.logo.updateBanner");
			}		
			return;
		}
		
	}

	protected String getHomeRedirect(PortletConfig portletConfig,
			ActionRequest actionRequest, String orgId, String viewMode)
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		// PortletURLImpl portletURL = new PortletURLImpl(
		// (ActionRequestImpl) actionRequest,
		// portletConfig.getPortletName(), themeDisplay.getPlid(),
		// PortletRequest.RENDER_PHASE);

		StringBuffer page = new StringBuffer(themeDisplay.getPortalURL());
		page.append("/tochuc/trangchu");
		page.append("?");
		page.append(URLParameter_RS.ORG_ID + "=" + orgId);
		page.append("&");
		page.append(URLParameter_RS.VIEW_MODE + "=" + viewMode);

		return page.toString();
	}
}
