package com.larion.progate.customer.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import larion.progate.model.Organization;
import larion.progate.service.OrganizationLocalServiceUtil;
import larion.progate.model.ProGateOrgCustomer;
import larion.progate.model.ProGateOrgCustomerRepresenter;
import larion.progate.service.ProGateOrgCustomerLocalServiceUtil;
import larion.progate.service.ProGateOrgCustomerRepresenterLocalServiceUtil;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.larion.progate.customer.constants.Customer_Const;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;

public class DeleteCustomerAction extends PortletAction {

	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

		int deleteSuccess = 0;
		int objectId = Integer.parseInt(actionRequest.getParameter(Customer_Const.OBJECT_ID));
		String url = actionRequest.getParameter(Customer_Const.URL);

		try {
			ProGateOrgCustomerLocalServiceUtil.deleteProGateOrgCustomer(objectId);
			
			deleteSuccess = 3;
			actionResponse.setRenderParameter(Customer_Const.OBJECT_ID, "0");
		} catch (Exception e) {
			deleteSuccess = 4; // Error
		}
		
		HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);
		ServletOutputStream output = response.getOutputStream();
		output.print(deleteSuccess);
		output.flush();
		output.close();
		
		actionRequest.setAttribute(Customer_Const.ADDED_SUCCESS, deleteSuccess);
		actionResponse.setRenderParameter(Customer_Const.URL, url);
		setForward(actionRequest, "portlet.customer.view");
	}

}
