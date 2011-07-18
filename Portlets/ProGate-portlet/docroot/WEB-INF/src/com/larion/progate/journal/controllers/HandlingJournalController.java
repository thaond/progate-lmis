package com.larion.progate.journal.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import larion.progate.model.ProGateJournalArticle;
import larion.progate.model.ProGateJournalArticleTypes;
import larion.progate.model.ProGateJournalArticleView;
import larion.progate.service.ProGateJournalArticleLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleViewLocalServiceUtil;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

import com.larion.progate.common.constants.ConfigParams_RS;
import com.larion.progate.common.constants.Request;
import com.larion.progate.common.constants.URLParameter_RS;
import com.larion.progate.common.utils.Functions;
import com.larion.progate.common.utils.ProGateUtil;
import com.larion.progate.organization.product.constants.JournalArticle_RS;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

public class HandlingJournalController extends ParameterizableViewController {

	@Override
	protected void handleActionRequestInternal(ActionRequest request,
			ActionResponse response) throws Exception {

		UploadPortletRequest uploadPortlet = PortalUtil
				.getUploadPortletRequest(request);

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		Map<String, Object> bean = new HashMap<String, Object>();

		int orgId = ParamUtil.getInteger(uploadPortlet, URLParameter_RS.ORG_ID);
		bean.put(URLParameter_RS.ORG_ID, orgId);
		System.out.println("orgId: " + orgId);

		String returnToFullPageURL = ParamUtil.getString(uploadPortlet,
				URLParameter_RS.RETURN_TO_FULL_PAGE_URL);
		bean.put(URLParameter_RS.RETURN_TO_FULL_PAGE_URL, returnToFullPageURL);
		System.out.println("returnToFullPageURL: " + returnToFullPageURL);

		String cmd = ParamUtil.getString(uploadPortlet, Constants.CMD);

		int journalArticleId = ParamUtil.getInteger(uploadPortlet,
				JournalArticle_RS.JA_ID);
		System.out.println("journalArticleId: " + journalArticleId);

		if (Constants.DELETE.equals(cmd)) {

			ProGateJournalArticleViewLocalServiceUtil
					.deleteProGateArticleViewObject(ProGateJournalArticleViewLocalServiceUtil
							.getProGateJournalArticleView(journalArticleId));

			response.sendRedirect(returnToFullPageURL);
		}

		String articleTitle = uploadPortlet
				.getParameter(JournalArticle_RS.JA_TITLE);
		System.out.println("articleTitle: " + articleTitle);

		String description = uploadPortlet
				.getParameter(JournalArticle_RS.JA_DESCRIPTION);

		System.out.println("description: " + description);

		String content = ParamUtil.getString(uploadPortlet,
				JournalArticle_RS.JA_CONTENT);
		content = content.replaceAll("../../../image", "/image");
		System.out.println("content: " + content);

		String smallImagePath = Functions.getPathOfUploadImage(request,
				response, uploadPortlet, JournalArticle_RS.JA_SMALL_IMAGE_URL);

		System.out.println("smallImagePath: " + smallImagePath);

		if (Constants.UPDATE.equals(cmd)) {

			ProGateJournalArticle journalArticle = ProGateJournalArticleLocalServiceUtil
					.getProGateJournalArticle(journalArticleId);

			journalArticle.setTitle(articleTitle);
			journalArticle.setDescription(description);
			journalArticle.setContent(content);
			journalArticle.setUpdatedAt(new Date());

			if (!"".endsWith(smallImagePath) && smallImagePath != null) {
				journalArticle.setSmallImageUrl(smallImagePath);
				journalArticle.setBigImageUrl(smallImagePath);
			}

			ProGateJournalArticleLocalServiceUtil.updateProGateJournalArticle(
					journalArticle, false);

			ProGateUtil.setMessageStatus(uploadPortlet, response,
					Request.MESSAGE_STATUS_SUCCESS);

		} else if (Constants.ADD.equals(cmd)) {

			String journalArticleType = ProGateUtil.getConfigValue(request,
					ConfigParams_RS.JOURNAL_ARTICLES_TYPE);
			System.out.println("journalArticleType: " + journalArticleType);

			String journalArticleTypeName = journalArticleType;

			ProGateJournalArticleTypes journalArticleTypeObject = ProGateJournalArticleTypesLocalServiceUtil
					.getProGateJournalArticleTypes(Integer
							.valueOf(journalArticleType));

			if (journalArticleTypeObject != null) {

				journalArticleTypeName = journalArticleTypeObject.getName();

				System.out.println("journalArticleTypeName: "
						+ journalArticleTypeName);
			}

			ProGateJournalArticle journalArticle = ProGateJournalArticleLocalServiceUtil
					.createNewArticle(String.valueOf(orgId),
							(int) themeDisplay.getUserId(), articleTitle,
							journalArticleTypeName, description, content,
							smallImagePath, "", "");

			journalArticleId = journalArticle.getPrimaryKey();

			cmd = Constants.UPDATE;

			ProGateUtil.setMessageStatus(uploadPortlet, response,
					Request.MESSAGE_STATUS_SUCCESS);
		}

		response.setRenderParameter(URLParameter_RS.ORG_ID,
				String.valueOf(orgId));
		response.setRenderParameter(URLParameter_RS.RETURN_TO_FULL_PAGE_URL,
				returnToFullPageURL);
		response.setRenderParameter(JournalArticle_RS.JA_ID,
				String.valueOf(journalArticleId));
		response.setRenderParameter(Constants.CMD, cmd);
		response.setRenderParameter("action", "handleJournal");
	}

	@Override
	protected ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {

		Map<String, Object> bean = new HashMap<String, Object>();

		int orgId = ParamUtil.getInteger(request, URLParameter_RS.ORG_ID);
		bean.put(URLParameter_RS.ORG_ID, orgId);

		String returnToFullPageURL = ParamUtil.getString(request,
				URLParameter_RS.RETURN_TO_FULL_PAGE_URL);
		bean.put(URLParameter_RS.RETURN_TO_FULL_PAGE_URL, returnToFullPageURL);

		String cmd = ParamUtil.getString(request, Constants.CMD);
		bean.put(Constants.CMD, cmd);

		if (Constants.UPDATE.equals(cmd)) {
			int journalArticleId = ParamUtil.getInteger(request,
					JournalArticle_RS.JA_ID);

			ProGateJournalArticleView journalArticle = ProGateJournalArticleViewLocalServiceUtil
					.getProGateJournalArticleView(journalArticleId);
			bean.put("journalArticle", journalArticle);
		}

		ProGateUtil.setMessageToBean(request, bean);

		return new ModelAndView(this.getViewName(), "bean", bean);
	}
}