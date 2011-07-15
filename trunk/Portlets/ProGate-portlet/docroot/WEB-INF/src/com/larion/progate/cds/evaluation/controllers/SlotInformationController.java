package com.larion.progate.cds.evaluation.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import larion.progate.cds.model.Slot;
import larion.progate.cds.model.ViewSlotInformation;
import larion.progate.cds.service.SlotLocalServiceUtil;
import larion.progate.cds.service.ViewFinalTitlesLocalServiceUtil;
import larion.progate.cds.service.ViewSlotInformationLocalServiceUtil;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

import com.larion.progate.cds.constant.RequestConst;
import com.larion.progate.cds.utils.PaginationObject;
import com.larion.progate.common.constants.Request;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;

public class SlotInformationController extends ParameterizableViewController {

	@Override
	protected ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {
		Map<String, Object> bean = new HashMap<String, Object>();
		int rootId = ParamUtil.getInteger(request, Request.ORG_ID);
		if (rootId == 0) {
			HttpServletRequest orgReq = PortalUtil
					.getOriginalServletRequest(PortalUtil
							.getHttpServletRequest(request));
			rootId = ParamUtil.getInteger(orgReq, Request.ORG_ID);
		}
		bean.put("orgId", rootId);

		ServiceContext sc = ServiceContextFactory.getInstance(this.getClass()
				.getName(), request);
		int userId = (int) sc.getUserId();

		String titleName = ViewFinalTitlesLocalServiceUtil
				.getTitleNameByRootIdAndUserId(rootId, userId);
		bean.put("titleName", titleName);

		int slotId = ParamUtil.getInteger(request, RequestConst.SLOT_ID);
		Slot slot = SlotLocalServiceUtil.getSlot(slotId);
		bean.put("slot", slot);

		List<ViewSlotInformation> slotsInfo = ViewSlotInformationLocalServiceUtil
				.getSlotInformationListBySlotIdAndUserId(slotId, userId);
		if(slotsInfo == null) {
			slotsInfo = new ArrayList<ViewSlotInformation>();
		}
		bean.put("listSize",slotsInfo.size() );

		PaginationObject pagination = new PaginationObject(
				"configTitle", slotsInfo.size());
		pagination.paging(request);
		
		slotsInfo = slotsInfo.subList(
				pagination.getStartIndex(),
				pagination.getEndIndex());
		
		bean.put("pagination", pagination);
		bean.put("slotsInfo", slotsInfo);
		
		return new ModelAndView(this.getViewName(), "bean", bean);
	}

}
