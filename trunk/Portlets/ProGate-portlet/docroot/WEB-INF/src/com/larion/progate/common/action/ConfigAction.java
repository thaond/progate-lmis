package com.larion.progate.common.action;

import com.larion.progate.common.constants.ConfigParams_RS;
import com.larion.progate.common.constants.URLParameter_RS;
import com.liferay.portal.kernel.portlet.BaseConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.tags.TagsEntryException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;


public class ConfigAction extends BaseConfigurationAction {

	@Override
	public void processAction(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {
		
		try {
			String portletResource = ParamUtil.getString(
				actionRequest, "portletResource");

			PortletPreferences preferences =
				PortletPreferencesFactoryUtil.getPortletSetup(
					actionRequest, portletResource);
			
			String[] prams = {
					ConfigParams_RS.NAME,
					ConfigParams_RS.IMAGE,
					ConfigParams_RS.ICON,
					URLParameter_RS.PRODUCT_TYPE,
					URLParameter_RS.PRODUCT_CATEGORY_TYPE,
					ConfigParams_RS.NUM_OF_ITEM, 
					ConfigParams_RS.REDIRECT_URL, 
					ConfigParams_RS.PRODUCT_DETAIL_PAGE_URL
					};
			
			for (String param : prams) {
				setValueOfParamToPortletPreferences(actionRequest, 
						preferences, param);
			}
			
			if (SessionErrors.isEmpty(actionRequest)) {
				preferences.store();
				SessionMessages.add(
					actionRequest,
					portletConfig.getPortletName() + ".doConfigure");
			}
		}
		catch (Exception e) {
			if (e instanceof TagsEntryException) {
				SessionErrors.add(actionRequest, e.getClass().getName(), e);
			}
			else {
				throw e;
			}
		}
	}
	
	public void setValueOfParamToPortletPreferences(
			PortletRequest request, PortletPreferences preferences, String param) throws Exception{
		String value = ParamUtil.getString(request, param);
		preferences.setValue(param, value);
	}
	
	@Override
	public String render(
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse)
		throws Exception {		
		return "/html/portlet/common/configuration.jsp";
	}
}