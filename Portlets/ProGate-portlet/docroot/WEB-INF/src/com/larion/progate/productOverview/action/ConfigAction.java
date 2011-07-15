/**
 * Copyright (c) [Year] [Organization] All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */


package com.larion.progate.productOverview.action;

import com.larion.progate.productOverview.constants.*;

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
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * <p>Your description here</p>
 *
 * @author (Your name)
 *
 */
public class ConfigAction extends BaseConfigurationAction {

	@Override
	public void processAction(PortletConfig config, ActionRequest actionRequest,
							ActionResponse actionResponse) throws Exception {
			
		try {
			
			String portletResource = ParamUtil.getString(actionRequest, "portletResource");
			String displayStyle = ParamUtil.getString(actionRequest, RequestConst.DISPLAY_STYLE);
			String displaySubStyle = ParamUtil.getString(actionRequest, RequestConst.DISPLAY_SUB_STYLE);
			int numOfItem = ParamUtil.getInteger(actionRequest, RequestConst.NUM_OF_ITEM);
			int maxItems = ParamUtil.getInteger(actionRequest, RequestConst.MAX_ITEM_TO_SHOW);
			String friendlyUrl = ParamUtil.getString(actionRequest, RequestConst.FRIENDLY_URL);
			String newProductUrl = ParamUtil.getString(actionRequest, RequestConst.NEW_PRODUCT_URL);
			String sellingProductUrl = ParamUtil.getString(actionRequest, RequestConst.SELLING_PRODUCT_URL);
			String discountProductUrl = ParamUtil.getString(actionRequest, RequestConst.DISCOUNT_PRODUCT_URL);
			
			if (numOfItem < 1) {
				numOfItem = RequestConst.INCREMENT_CONST;
				
				System.out.println("Default: numOfItems = " + numOfItem);
			}
			
			if (maxItems < 1) {
				maxItems = RequestConst.MAX_ITEMS_CONST;
			}
			
			if (friendlyUrl.trim().length() < 1) {
				friendlyUrl = ProductOverviewConst.FRIENDLY_URL;
				
				System.out.println("Default: friendlyUrl = " + friendlyUrl);
			}
			
			if (newProductUrl.trim().length() < 1) {
				newProductUrl = ProductOverviewConst.NEW_PRODUCT_FRIENDLY_URL;
			}
			
			if (sellingProductUrl.trim().length() < 1) {
				sellingProductUrl = ProductOverviewConst.SELLING_PRODUCT_FRIENDLY_URL;
			}
			
			if (discountProductUrl.trim().length() < 1) {
				discountProductUrl = ProductOverviewConst.DISCOUNT_PRODUCT_FRIENDLY_URL;
			}
			
			//System.out.println("portletResource = " + portletResource);
			System.out.println("displayStyle = " + displayStyle);
			System.out.println("displaySubStyle = " + displaySubStyle);
			System.out.println("numOfItem = " + numOfItem);
			System.out.println("maxItems = " + maxItems);
			System.out.println("friendlyUrl = " + friendlyUrl);
			System.out.println("newProductUrl = " + newProductUrl);
			System.out.println("sellingProductUrl = " + sellingProductUrl);
			System.out.println("discountProductUrl = " + discountProductUrl);

			PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);			
			
			prefs.setValue(RequestConst.DISPLAY_STYLE, displayStyle);
			prefs.setValue(RequestConst.DISPLAY_SUB_STYLE, displaySubStyle);
			prefs.setValue(RequestConst.NUM_OF_ITEM, Integer.toString(numOfItem));
			prefs.setValue(RequestConst.MAX_ITEM_TO_SHOW, Integer.toString(maxItems));
			prefs.setValue(RequestConst.FRIENDLY_URL, friendlyUrl);
			prefs.setValue(RequestConst.NEW_PRODUCT_URL, newProductUrl);
			prefs.setValue(RequestConst.SELLING_PRODUCT_URL, sellingProductUrl);
			prefs.setValue(RequestConst.DISCOUNT_PRODUCT_URL, discountProductUrl);
			
			//  Read, validate, and then set form parameters as portlet prerferences
			prefs.store();

			SessionMessages.add(actionRequest, config.getPortletName() + ".doConfigure");			
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
	
	@Override
	public String render(PortletConfig config, RenderRequest renderRequest,
						RenderResponse renderResponse) throws Exception {
	
		return "/html/portlet/product_overview/configuration.jsp";
	}
}
