package com.larion.progate.ebsc.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import larion.progate.model.OrgObjectList;
import larion.progate.model.OrgObjectMeasure;
import larion.progate.model.OrgObjectObjective;
import larion.progate.model.OrgObjectPerspective;
import larion.progate.model.OrgObjectTargets;
import larion.progate.model.Organization;
import larion.progate.service.OrgObjectListLocalServiceUtil;
import larion.progate.service.OrgObjectMeasureLocalServiceUtil;
import larion.progate.service.OrgObjectObjectiveLocalServiceUtil;
import larion.progate.service.OrgObjectPerspectiveLocalServiceUtil;
import larion.progate.service.OrgObjectTargetsLocalServiceUtil;
import larion.progate.service.OrganizationLocalServiceUtil;
import larion.progate.service.utils.OrgObjectAhpAlgorithmLocalUtils;
import larion.progate.service.utils.OrgObjectListLocalUtils;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

import com.larion.progate.ebsc.constants.Measures_RS;
import com.larion.progate.ebsc.constants.ObjectivesList_RS;
import com.larion.progate.ebsc.constants.Objectives_RS;
import com.larion.progate.ebsc.constants.Perspectives_RS;
import com.larion.progate.common.constants.Request;
import com.larion.progate.ebsc.constants.Targets_RS;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;

public class ShowingOrgainzationDetailsController extends
		ParameterizableViewController {

	@Override
	protected ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {

		Map<String, Object> bean = new HashMap<String, Object>();

		String tabAction = ParamUtil.getString(request, Request.TA);
		bean.put("tabAction", tabAction);

		if (Request.ADD_OBJECTIVE_SET_ACT.equals(tabAction)) {

		}

		if (Request.DELETE_OBJECTIVE_SET_ACT.equals(tabAction)) {

		}

		handleProcessDialogAction(request, response, bean);

		handleProcessTabAction(request, response, bean);

		bean.put("TA_1", Request.TA_1);
		bean.put("TA_1_1", Request.TA_1_1);
		bean.put("TA_1_2", Request.TA_1_2);
		bean.put("TA_1_3", Request.TA_1_3);
		bean.put("TA_2", Request.TA_2);
		bean.put("TA_3", Request.TA_3);
		bean.put("TA_4", Request.TA_4);
		bean.put("TA_5", Request.TA_5);

		return new ModelAndView(this.getViewName(), "bean", bean);
	}

	public void handleProcessDialogAction(RenderRequest request,
			RenderResponse response, Map<String, Object> bean)
			throws PortalException, SystemException {

	}

	public void handleProcessTabAction(RenderRequest request,
			RenderResponse response, Map<String, Object> bean)
			throws PortalException, SystemException {

	}
}
