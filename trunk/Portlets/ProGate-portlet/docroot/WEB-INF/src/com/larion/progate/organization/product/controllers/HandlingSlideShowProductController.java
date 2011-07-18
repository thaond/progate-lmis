package com.larion.progate.organization.product.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import larion.progate.model.ProGateJournalArticleSlideShow;
import larion.progate.model.ProGateJournalArticleView;
import larion.progate.model.impl.ProGateJournalArticleSlideShowImpl;
import larion.progate.service.ProGateJournalArticleSlideShowLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleViewLocalServiceUtil;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

import com.larion.progate.common.constants.Request;
import com.larion.progate.common.constants.URLParameter_RS;
import com.larion.progate.common.utils.Functions;
import com.larion.progate.organization.product.constants.SlideShowProduct_RS;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

public class HandlingSlideShowProductController extends
		ParameterizableViewController {

	@Override
	protected void handleActionRequestInternal(ActionRequest request,
			ActionResponse response) throws Exception {

		UploadPortletRequest uploadPortlet = PortalUtil
				.getUploadPortletRequest(request);

		Map<String, Object> bean = new HashMap<String, Object>();
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		int orgId = ParamUtil.getInteger(uploadPortlet, URLParameter_RS.ORG_ID);
		bean.put(URLParameter_RS.ORG_ID, orgId);

		int viewMode = ParamUtil.getInteger(uploadPortlet,
				URLParameter_RS.VIEW_MODE);
		bean.put(URLParameter_RS.VIEW_MODE, viewMode);

		String returnToFullPageURL = ParamUtil.getString(uploadPortlet,
				URLParameter_RS.RETURN_TO_FULL_PAGE_URL);
		bean.put(URLParameter_RS.RETURN_TO_FULL_PAGE_URL, returnToFullPageURL);

		System.out.println("returnToFullPageURL: " + returnToFullPageURL);

		String cmd = ParamUtil.getString(uploadPortlet, Constants.CMD);
		System.out.println("cmd: " + cmd);

		if (Constants.ADD.equals(cmd)) {
			int index = 0;
			for (int i = 1; i <= 5; i++) {
				String slideShowProductImageURL = "";
				String slideShowProductTitle = "";
				try {
					slideShowProductImageURL = Functions.getPathOfUploadImage(
							request, response, uploadPortlet,
							SlideShowProduct_RS.SSP_IMAGE_URL + "-" + i);

					slideShowProductTitle = ParamUtil.getString(uploadPortlet,
							SlideShowProduct_RS.SSP_TITLE + "-" + i);
				} catch (Exception e) {
					slideShowProductImageURL = "";
					slideShowProductTitle = "";
				}

				String slideShowProductID = ParamUtil.getString(uploadPortlet,
						SlideShowProduct_RS.SSP_PRODUCT_ID + "-" + i);

				if (!"".equals(slideShowProductImageURL)
						&& slideShowProductImageURL != null) {
					index += 1;

					System.out.println("slideShowProductID"
							+ slideShowProductID);

					ProGateJournalArticleSlideShowLocalServiceUtil
							.createArticleSlideShow(orgId,
									Integer.parseInt(slideShowProductID),
									slideShowProductImageURL,
									slideShowProductTitle, "", index,
									(int) themeDisplay.getUserId());

				}
			}

			System.out.println("index: " + index);

			List<ProGateJournalArticleView> productList = ProGateJournalArticleViewLocalServiceUtil
					.getProGateJournalArticleViews(0,
							ProGateJournalArticleViewLocalServiceUtil
									.getProGateJournalArticleViewsCount());

			for (int j = index + 1; j <= 5; j++) {
				ProGateJournalArticleSlideShowLocalServiceUtil
						.createArticleSlideShow(orgId, productList.get(0)
								.getPrimaryKey(), "", "", "", j,
								(int) themeDisplay.getUserId());
			}

			cmd = Constants.UPDATE;

			response.setRenderParameter(Request.MESSAGE_TXT,
					"warning.slideshow.product.global.add.success");

		} else if (Constants.UPDATE.equals(cmd)) {

			List<ProGateJournalArticleSlideShow> slideShowList = ProGateJournalArticleSlideShowLocalServiceUtil
					.getProGateJournalArticleSlideShows(orgId, 0, 5);

			for (int i = 1; i <= 5; i++) {
				String slideShowProductImageURL = "";
				try {
					slideShowProductImageURL = Functions.getPathOfUploadImage(
							request, response, uploadPortlet,
							SlideShowProduct_RS.SSP_IMAGE_URL + "-" + i);
				} catch (Exception e) {
					slideShowProductImageURL = "";
				}

				String slideShowProductTitle = ParamUtil.getString(
						uploadPortlet, SlideShowProduct_RS.SSP_TITLE + "-" + i);

				Integer slideShowProductID = ParamUtil.getInteger(
						uploadPortlet, SlideShowProduct_RS.SSP_PRODUCT_ID + "-"
								+ i);

				ProGateJournalArticleSlideShow slideShow = slideShowList
						.get(i - 1);

				slideShow.setOrgId(orgId);

				if (!"".equals(slideShowProductImageURL)) {
					slideShow.setImageUrl(slideShowProductImageURL);
				}

				if (!"".equals(slideShowProductTitle)) {
					slideShow.setTitle(slideShowProductTitle);
				}

				if (!"".equals(slideShowProductID)) {
					slideShow.setProductId(slideShowProductID);
				}

				slideShow.setUpdatedBy((int) themeDisplay.getUserId());
				ProGateJournalArticleSlideShowLocalServiceUtil
						.updateProGateJournalArticleSlideShow(slideShow, true);
			}

			response.setRenderParameter(Request.MESSAGE_TXT,
					"warning.slideshow.product.global.update.success");

		} else if (Constants.DELETE.equals(cmd)) {
			String[] slideShowIDFromCheckobx = uploadPortlet
					.getParameterValues(Request.CHILD_CKB);

			int end = ProGateJournalArticleSlideShowLocalServiceUtil
					.countProGateJournalArticleSlideShows(orgId);

			List<ProGateJournalArticleSlideShow> slideShowList = ProGateJournalArticleSlideShowLocalServiceUtil
					.getProGateJournalArticleSlideShows(orgId, 0, end);

			ProGateJournalArticleSlideShow lastSlideShow = slideShowList
					.get(end - 1);

			int lasIndex = lastSlideShow.getSlideIndex();

			for (int i = 0; i < slideShowIDFromCheckobx.length; i++) {

				lasIndex += 1;

				System.out.println("slideShowIDFromCheckobx: "
						+ slideShowIDFromCheckobx[i]);

				ProGateJournalArticleSlideShow slideShow = ProGateJournalArticleSlideShowLocalServiceUtil
						.getProGateJournalArticleSlideShow(Integer
								.parseInt(slideShowIDFromCheckobx[i]));

				slideShow.setSlideIndex(lasIndex);
				slideShow.setImageUrl("");
				slideShow.setTitle("");

				ProGateJournalArticleSlideShowLocalServiceUtil
						.updateProGateJournalArticleSlideShow(slideShow);

			}

			slideShowList = ProGateJournalArticleSlideShowLocalServiceUtil
					.getProGateJournalArticleSlideShows(orgId, 0, end);
			int count = 5;
			for (ProGateJournalArticleSlideShow slideShow : slideShowList) {
				if ("".equals(slideShow.getImageUrl())) {
					count -= 1;
				}
			}
			if (count == 0) {
				for (ProGateJournalArticleSlideShow slideShow : slideShowList) {
					ProGateJournalArticleSlideShowLocalServiceUtil
							.deleteProGateJournalArticleSlideShow(slideShow);
				}
			}

			response.sendRedirect(returnToFullPageURL);
		}

		response.setRenderParameter(URLParameter_RS.ORG_ID,
				String.valueOf(orgId));
		response.setRenderParameter(URLParameter_RS.VIEW_MODE,
				String.valueOf(viewMode));
		response.setRenderParameter(URLParameter_RS.RETURN_TO_FULL_PAGE_URL,
				returnToFullPageURL);
		response.setRenderParameter(Constants.CMD, cmd);
		response.setRenderParameter("action", "handleSlideShowProduct");
	}

	@Override
	protected ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {

		Map<String, Object> bean = new HashMap<String, Object>();

		int orgId = ParamUtil.getInteger(request, URLParameter_RS.ORG_ID);
		bean.put(URLParameter_RS.ORG_ID, orgId);

		int viewMode = ParamUtil.getInteger(request, URLParameter_RS.VIEW_MODE);
		bean.put(URLParameter_RS.VIEW_MODE, viewMode);

		String returnToFullPageURL = ParamUtil.getString(request,
				URLParameter_RS.RETURN_TO_FULL_PAGE_URL);
		bean.put(URLParameter_RS.RETURN_TO_FULL_PAGE_URL, returnToFullPageURL);

		String cmd = ParamUtil.getString(request, Constants.CMD);
		bean.put("cmd", cmd);

		String msgTxt = ParamUtil.getString(request, Request.MESSAGE_TXT);
		bean.put(Request.MESSAGE_TXT, msgTxt);

		List<ProGateJournalArticleView> productList = ProGateJournalArticleViewLocalServiceUtil
				.getListArticleByOrgIdAndProductType(
						orgId,
						0, // 0 - All Product
						ProGateJournalArticleTypesLocalServiceUtil
								.getArticleTypeProduct(), false, 0,
						ProGateJournalArticleViewLocalServiceUtil
								.getProGateJournalArticleViewsCount());
		bean.put("productList", productList);
		bean.put("productListCount", productList.size());

		List<ProGateJournalArticleSlideShow> slideShowList = new ArrayList<ProGateJournalArticleSlideShow>();

		if (Constants.ADD.equals(cmd)) {
			for (int i = 0; i < 5; i++) {
				ProGateJournalArticleSlideShow slideShow = new ProGateJournalArticleSlideShowImpl();
				slideShowList.add(slideShow);
			}

		} else if (Constants.UPDATE.equals(cmd)) {
			int slideShowCount = ProGateJournalArticleSlideShowLocalServiceUtil
					.countProGateJournalArticleSlideShows(orgId);

			if (slideShowCount > 5) {
				slideShowCount = 5;
			}

			bean.put("slideShowCount", slideShowCount);
			System.out.println("slideShowCount " + slideShowCount);

			slideShowList = ProGateJournalArticleSlideShowLocalServiceUtil
					.getProGateJournalArticleSlideShows(orgId, 0,
							slideShowCount);
		}
		bean.put("slideShowList", slideShowList);

		return new ModelAndView(this.getViewName(), "bean", bean);
	}
}
