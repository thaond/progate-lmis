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

package com.larion.progate.organization.management.action;


import java.util.List;
import java.util.Map;

import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.bean.PaginationObject;
import com.larion.progate.news_homepage.constants.News_Const;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;


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
public class OrgListAction extends ParameterizableViewAction {

	@Override
	public void handleRenderRequestInternal(RenderRequest req,
			RenderResponse res, Map<String, Object> bean) throws Exception {
		HttpServletRequest httpSr = PortalUtil.getHttpServletRequest(req);
		HttpServletRequest origReq = PortalUtil.getOriginalServletRequest(httpSr);
		boolean isRepresentOrgPage = false;
		
		
		String currentURL = PortalUtil.getCurrentURL(req);
		int indexCurrentPage = currentURL.indexOf("?currentPage");
		if (indexCurrentPage != -1){
			currentURL = currentURL.substring(0, indexCurrentPage);	
		}
		req.setAttribute("currentURL", currentURL);
		
		if(currentURL.indexOf("to-chuc-tieu-bieu") != -1){
			isRepresentOrgPage = true;
		}
		
		req.setAttribute("isRepresentOrgPage", isRepresentOrgPage);
		
		int pageSize = 10;
		if (origReq.getParameter("pageSize") != null) pageSize = Integer.valueOf(origReq.getParameter("pageSize"));
		req.setAttribute("pageSize", pageSize);
		
		int currentPage = 1;
		if (origReq.getParameter("currentPage") != null) currentPage = Integer.valueOf(origReq.getParameter("currentPage"));
		req.setAttribute("currentPage", currentPage);
		
		String pageURL = currentURL;
		int indexPage = pageURL.indexOf("?");
		if (indexPage != -1) {
			pageURL = pageURL.substring(0, indexPage);
		}		
		req.setAttribute("pageURL", pageURL);
		
		String keyWords = origReq.getParameter("keyWords");
		if (keyWords != null){
			req.setAttribute("keyWords", keyWords);
		}
		
	}

}
