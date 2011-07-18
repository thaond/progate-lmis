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

package com.sample.jsp.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import larion.progate.cds.service.CompetencyLocalServiceUtil;
import larion.progate.lmis.model.LmisViewAttdance;
import larion.progate.lmis.service.LmisAttendanceDailyLocalServiceUtil;
import larion.progate.lmis.service.LmisDayTypesLocalServiceUtil;
import larion.progate.lmis.service.LmisOvertimeApprovalsLocalServiceUtil;
import larion.progate.lmis.service.LmisViewAttdanceLocalServiceUtil;
import larion.progate.lmis.service.LmisViewWorkingCalendarLocalServiceUtil;
import larion.progate.lmis.service.utils.LmisUtils;
import larion.progate.model.Organization;
import larion.progate.model.ProgateOrganizationParticipants;
import larion.progate.model.User;
import larion.progate.model.UserInformationView;
import larion.progate.model.ViewOrgUsersPermissions;
import larion.progate.service.OrganizationLocalServiceUtil;
import larion.progate.service.ProgateOrganizationParticipantsLocalServiceUtil;
import larion.progate.service.UserLocalServiceUtil;
import larion.progate.service.ViewOrgUsersPermissionsLocalServiceUtil;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.collections.map.HashedMap;

/**
 * <p>
 * Description </>
 * 
 * @author (Your name)
 * 
 */
public class JSPPortlet extends GenericPortlet {

	public void init() throws PortletException {
		editJSP = getInitParameter("edit-jsp");
		helpJSP = getInitParameter("help-jsp");
		viewJSP = getInitParameter("view-jsp");
	}

	public void doDispatch(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		String jspPage = renderRequest.getParameter("jspPage");

		if (jspPage != null) {
			include(jspPage, renderRequest, renderResponse);
		} else {
			super.doDispatch(renderRequest, renderResponse);
		}
	}

	public void doEdit(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		if (renderRequest.getPreferences() == null) {
			super.doEdit(renderRequest, renderResponse);
		} else {
			include(editJSP, renderRequest, renderResponse);
		}
	}

	public void doHelp(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		include(helpJSP, renderRequest, renderResponse);
	}

	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		System.out.println("Start");
		try {
//			Date da =LmisUtils.convertStrtoDate("01/07/2011", "dd/MM/yyyy");
			System.out.println(LmisAttendanceDailyLocalServiceUtil.getListDetailsDayOff(1501,25435435 , new Date()));
			System.out.println("========================");
			System.out.println(LmisAttendanceDailyLocalServiceUtil.getListDetailsDayOff(1501,25435435 , new Date(2011,4, 21)));
//			System.out.println(LmisDayTypesLocalServiceUtil.getLmisDayTypeses(0, 6));
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("Fail");
		}

		System.out.println("End");

		include(viewJSP, renderRequest, renderResponse);
	}

	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
	}

	protected void include(String path, RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		PortletRequestDispatcher portletRequestDispatcher = getPortletContext()
				.getRequestDispatcher(path);

		if (portletRequestDispatcher == null) {
			_log.error(path + " is not a valid include");
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}

	protected String editJSP;
	protected String helpJSP;
	protected String viewJSP;

	private static Log _log = LogFactoryUtil.getLog(JSPPortlet.class);

}
