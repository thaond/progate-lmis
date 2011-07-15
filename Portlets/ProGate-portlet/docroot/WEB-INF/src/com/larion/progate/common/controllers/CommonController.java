package com.larion.progate.common.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

import com.larion.progate.common.action.Action;
import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.constants.ConfigParams_RS;
import com.larion.progate.common.constants.RSConstants;
import com.larion.progate.common.utils.ProGateUtil;

public class CommonController extends ParameterizableViewController {

	@Override
	protected void handleActionRequestInternal(ActionRequest request,
			ActionResponse response) throws Exception {

		Map<String, Object> bean = new HashMap<String, Object>();

		String displayStyle = ProGateUtil.getConfigValue(request,
				ConfigParams_RS.DISPLAY_STYLE);

		if ("".equals(displayStyle)) {
			displayStyle = "view_no_config";
		}
		bean.put("displayStyle", displayStyle);

		try {
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"beans.xml");

			Action action = (Action) context.getBean(displayStyle);
			action.handleActionRequestInternal(request, response, bean);

			String actionName = (String) bean.get(RSConstants.ACTION);
			if (!"".equals(actionName) && actionName != null) {
				response.setRenderParameter("action", actionName);
			} else {
				response.setRenderParameter("action", "commonController");
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	@Override
	protected ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {

		Map<String, Object> bean = new HashMap<String, Object>();

		String displayStyle = ProGateUtil.getConfigValue(request,
				ConfigParams_RS.DISPLAY_STYLE);

		if ("".equals(displayStyle)) {
			displayStyle = "view_no_config";
		}
		bean.put("displayStyle", displayStyle);
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"beans.xml");

			ParameterizableViewAction action = (ParameterizableViewAction) context
					.getBean(displayStyle);
			action.handleRenderRequestInternal(request, response, bean);

			String viewName = (String) bean.get(RSConstants.VIEW_NAME);
			System.out.println("viewname=" + viewName);
			if (!"".equals(viewName) && viewName != null) {
				return (new ModelAndView(viewName, "bean", bean));
			}

			viewName = action.getViewName();
			System.out.println("viewname=" + viewName);
			if (!"".equals(viewName) && viewName != null) {
				return (new ModelAndView(viewName, "bean", bean));
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}

		return (new ModelAndView(this.getViewName(), "bean", bean));
	}
}