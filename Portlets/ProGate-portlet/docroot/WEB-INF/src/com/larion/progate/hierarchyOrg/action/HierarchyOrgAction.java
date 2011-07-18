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

package com.larion.progate.hierarchyOrg.action;


import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.constants.URLParameter_RS;
import com.larion.progate.video.constants.Video_Const;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import larion.progate.model.Organization;
import larion.progate.service.OrganizationLocalServiceUtil;


/**
 * <p>
 * Your description here
 * </p>
 * 
 * @author (Your name)
 * 
 */
public class HierarchyOrgAction extends ParameterizableViewAction {

	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {

		HttpServletRequest orgRequest = PortalUtil
		.getOriginalServletRequest(PortalUtil
				.getHttpServletRequest(request));

		int orgId = Integer.parseInt(orgRequest.getParameter(URLParameter_RS.ORG_ID));
		int viewMode = Integer.parseInt(orgRequest.getParameter(URLParameter_RS.VIEW_MODE));
		Organization org = OrganizationLocalServiceUtil.getOrganization(orgId);
		List<Organization> listAllChildOrg =OrganizationLocalServiceUtil.getListAllSubOrganizations(orgId); 
		//System.out.println("listAllChildOrg.size()= " +listAllChildOrg.size());
		//for(int i = 0; i<listAllChildOrg.size(); i ++){
		//	System.out.println("NameOrg= " +listAllChildOrg.get(i).getName());
		//}
		
		
		request.setAttribute(URLParameter_RS.LIST_ALL_CHILD_ORG, listAllChildOrg);
		request.setAttribute(URLParameter_RS.ORGANIZATION, org);
		request.setAttribute(URLParameter_RS.VIEW_MODE, viewMode);
	}

}
