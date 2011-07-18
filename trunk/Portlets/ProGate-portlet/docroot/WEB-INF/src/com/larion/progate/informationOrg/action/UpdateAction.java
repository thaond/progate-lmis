package com.larion.progate.informationOrg.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import larion.progate.model.Organization;
import larion.progate.service.OrganizationLocalServiceUtil;
import larion.progate.service.ProGateOrgTypeLocalServiceUtil;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.ActionRequestImpl;
import com.liferay.portlet.ActionResponseImpl;

public class UpdateAction extends PortletAction {
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {

		boolean flag = true;
		String errorMessage = "";
		req.setCharacterEncoding("UTF-8");
		HttpServletRequest request = ((ActionRequestImpl) req)
				.getHttpServletRequest();
		request.setCharacterEncoding("UTF-8");

		String orgId = (String) request.getParameter("orgId");
		String establishDate = (String) request.getParameter("f_date1");
		String[] date = establishDate.split("/");

		Calendar orgFounded = CalendarFactoryUtil.getCalendar();
		orgFounded.set(Integer.valueOf(date[2]), Integer.valueOf(date[1]) - 1,
				Integer.valueOf(date[0]));

		String orgType = (String) request.getParameter("orgType");
		String orgSize = (String) request.getParameter("orgSize");

		String founder = (String) request.getParameter("founder");
		String website = (String) request.getParameter("website");
		String country = (String) request.getParameter("country");
		String city = (String) request.getParameter("city");
		String phone = (String) request.getParameter("phone");
		String address = (String) request.getParameter("address");
		
		try {
			// Quann comment
			larion.progate.model.Organization org = null;
			org = larion.progate.service.OrganizationLocalServiceUtil
					.getOrgObjectFromOrgId(Integer.parseInt(orgId));
			// end Quann comment
			org.setOrgFounded(orgFounded.getTime());
			int orgTypeId = ProGateOrgTypeLocalServiceUtil
					.getOrgTypeIfFromName(orgType);

			org.setOrgTypeId(orgTypeId);
			org.setOrgType(orgType);
			org.setFounderList(founder);
			org.setWebsite(website);
			org.setCity(city);
			org.setCountry(country);
			org.setPhone(phone);
			org.setAddress1(address);
			org.setOrgSize(Integer.valueOf(orgSize));
			larion.progate.service.OrganizationLocalServiceUtil.updateOrganization(org);
			request.setAttribute("MESSAGE_SUCCESS",
					"Bạn đã cập nhật thông tin tổ chức thành công.");
			request.setAttribute("orgId", orgId);
			setForward(req, "portlet.InformationOrg.update");
			return;
		} catch (Exception e) {
			// TODO: handle exception
			// System.out.println(e.toString());
			request.setAttribute("MESSAGE_ERROR",
					"Đã có lỗi xảy ra trong quá trình cập nhật thông tin tổ chức.");
			request.setAttribute("orgId", orgId);
			setForward(req, "portlet.InformationOrg.update");
			return;
		}


	}

}
