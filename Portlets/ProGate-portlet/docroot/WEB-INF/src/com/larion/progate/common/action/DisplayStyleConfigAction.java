package com.larion.progate.common.action;

import com.larion.progate.common.constants.ConfigParams_RS;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.tags.TagsEntryException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;

public class DisplayStyleConfigAction extends ConfigAction {

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
			
			/*try {
				String portletId = ParamUtil.getString(actionRequest,
						ConfigParams_RS.PORTLET_ID);
				
				if (!"".equals(portletId)) {

					ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
							.getAttribute(WebKeys.THEME_DISPLAY);

					com.liferay.portal.model.PortletPreferences _preferences = PortletPreferencesLocalServiceUtil
							.getPortletPreferences(themeDisplay.getPlid(),
									portletResource).get(0);

					if (_preferences != null) {

						PortletPreferencesLocalServiceUtil
								.updatePortletPreferences(_preferences, true);

					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}*/
			
			String[] prams = {
					ConfigParams_RS.PORTLET_ID,
					ConfigParams_RS.NAME,
					ConfigParams_RS.IMAGE,
					ConfigParams_RS.ICON,
					ConfigParams_RS.DISPLAY_STYLE,
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
}