package com.larion.progate.productOverview.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

import com.larion.progate.common.action.Action;
import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.constants.ConfigParams_RS;
import com.larion.progate.common.constants.RSConstants;
import com.larion.progate.common.utils.ProGateUtil;
import com.larion.progate.paging.constants.PagingConst;
import com.larion.progate.productOverview.constants.RequestConst;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

public class ProductOverviewController extends ParameterizableViewController {

	@Override
	protected void handleActionRequestInternal(ActionRequest request,
			ActionResponse response) throws Exception {
		
		HttpServletResponse res = PortalUtil.getHttpServletResponse(response);
		ServletOutputStream output = res.getOutputStream();

		Map<String, Object> bean = new HashMap<String, Object>();

		String displayStyle = ProGateUtil.getConfigValue(request, RequestConst.DISPLAY_STYLE, RequestConst.PRODUCT_LIST);				
		bean.put("displayStyle", displayStyle);
		
		//System.out.println("Action: displayStyle = " + displayStyle);
		
		// Get page size
		int pageSize = ParamUtil.getInteger(request, PagingConst.PAGE_SIZE, RequestConst.INCREMENT_CONST);		
		
		// Get current page
		int currentPage = ParamUtil.getInteger(request, PagingConst.GOTO_PAGE, 1);
		
		//System.out.println("Action: currentPage = " + currentPage + "; pageSize = " + pageSize);

		try {
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"beans.xml");

			Action action = (Action) context.getBean(displayStyle);
			action.handleActionRequestInternal(request, response, bean);

			String actionName = (String) bean.get(RSConstants.ACTION);
			
			//System.out.println("Action: actionName = " + actionName);
			
			if (!"".equals(actionName) && actionName != null) {
				response.setRenderParameter("action", actionName);
			}			

			response.setRenderParameter(PagingConst.GOTO_PAGE, Integer.toString(currentPage));
			response.setRenderParameter(PagingConst.PAGE_SIZE, Integer.toString(pageSize));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		output.println("success");
		output.flush();
	}

	@Override
	protected ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {

		Map<String, Object> bean = new HashMap<String, Object>();

		String displayStyle = ProGateUtil.getConfigValue(request, RequestConst.DISPLAY_STYLE, RequestConst.PRODUCT_LIST);
		bean.put("displayStyle", displayStyle);
		
		//System.out.println("Render: displayStyle = " + displayStyle);		
		
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"beans.xml");
			
			ParameterizableViewAction action = (ParameterizableViewAction) context
					.getBean(displayStyle);
			action.handleRenderRequestInternal(request, response, bean);

			String viewName = (String) bean.get(RSConstants.VIEW_NAME);
			
			//System.out.println("Render: bean.viewName = " + viewName);
			
			if (!"".equals(viewName) && viewName != null) {
				return (new ModelAndView(viewName, "bean", bean));
			}

			viewName = action.getViewName();
			
			System.out.println("Render: action.viewName = " + viewName);
			
			if (!"".equals(viewName) && viewName != null) {
				return (new ModelAndView(viewName, "bean", bean));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return (new ModelAndView(this.getViewName(), "bean", bean));
	}
}