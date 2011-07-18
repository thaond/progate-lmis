package com.larion.progate.myblog.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import larion.progate.model.ProGateJournalArticle;
import larion.progate.service.ProGateJournalArticleLocalServiceUtil;
import larion.progate.service.ProGateJournalArticlePrioritiesLocalServiceUtil;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

import com.larion.progate.common.utils.Functions;
import com.larion.progate.news_homepage.constants.News_Const;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

public class UpdateMyBlogController extends ParameterizableViewController {

	@Override
	protected void handleActionRequestInternal(ActionRequest request,
			ActionResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		int addSuccess = 0;
		int articleId = 0;
		String msg = "";
		// Map<String, Object> bean = new HashMap<String, Object>();
		// ThemeDisplay themeDisplay = (ThemeDisplay) request
		// .getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadPortlet = PortalUtil
				.getUploadPortletRequest(request);
		articleId = Integer.parseInt(uploadPortlet
				.getParameter(News_Const.ARTICLE_ID));
		String title = uploadPortlet.getParameter(News_Const.TITLE);
		String content = uploadPortlet.getParameter(News_Const.CONTENT);
		content = content.replaceAll("../../../image", "/image");
		String keyword = uploadPortlet.getParameter(News_Const.KEY_WORD);
		String mark = uploadPortlet.getParameter(News_Const.MARK);
		String description = uploadPortlet.getParameter(News_Const.DESCRIPTION);
		String currentURL = uploadPortlet.getParameter(News_Const.CURRENT_URL);
		// if (description.length() > 2000){
		// description = (String)content.substring(2000);
		// }else{
		// description.concat(content);
		// }

		try {
			// Get current User
			com.liferay.portal.service.ServiceContext sc = ServiceContextFactory
					.getInstance(this.getClass().getName(), request);
			com.liferay.portal.model.User user = UserLocalServiceUtil
					.getUser(sc.getUserId());
			Long userIdTemp = user.getUserId();
			int userId = userIdTemp.intValue();

			ProGateJournalArticle article = null;
			if (articleId != 0) {
				article = ProGateJournalArticleLocalServiceUtil
						.getProGateJournalArticle(articleId);
				article.setTitle(title);
				article.setContent(content);
				article.setDescription(description);
				if (mark != null) {
					article.setPriority(ProGateJournalArticlePrioritiesLocalServiceUtil
							.getPriorityImportantId());
				} else {
					article.setPriority(ProGateJournalArticlePrioritiesLocalServiceUtil
							.getPriorityNormalId());
				}

				article.setUpdatedBy(userId);
				article.setUpdatedAt(new Date());

				String fileName = uploadPortlet
						.getFileName(News_Const.SMALL_IMAGE);
				if (fileName != "") {
					String smallImagePath = Functions.getPathOfUploadImage(
							request, response, uploadPortlet,
							News_Const.SMALL_IMAGE);
					article.setSmallImageUrl(smallImagePath);
				}

				// article.setOrgId("0");

				article = ProGateJournalArticleLocalServiceUtil
						.updateProGateJournalArticle(article, true);
				addSuccess = 1;
			}

		} catch (Exception e) {
			// TODO: handle exception
			addSuccess = 2;

		}

		response.setRenderParameter(News_Const.ADD_SUCCESS,
				Integer.toString(addSuccess));
		response.setRenderParameter(News_Const.MSG_TEXT, msg);
		response.setRenderParameter(News_Const.ARTICLE_ID,
				Integer.toString(articleId));
		response.setRenderParameter(News_Const.CURRENT_URL, currentURL);
		response.setRenderParameter("action", "updateMyBlog");
	}

	@Override
	protected ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {

		Map<String, Object> bean = new HashMap<String, Object>();
		int isAdd = 0;
		int addSuccess = 0;
		int articleId = Integer.parseInt(request
				.getParameter(News_Const.ARTICLE_ID));
		if (request.getParameter(News_Const.CMD) != null) {
			isAdd = Integer.parseInt(request.getParameter(News_Const.CMD));
		}
		if (request.getParameter(News_Const.ADD_SUCCESS) != null) {
			addSuccess = Integer.parseInt(request
					.getParameter(News_Const.ADD_SUCCESS));
		}
		String msgText = "";
		if (request.getParameter(News_Const.MSG_TEXT) != null) {
			msgText = request.getParameter(News_Const.MSG_TEXT);
		}
		String currentURL = "";
		if (request.getParameter(News_Const.CURRENT_URL) != null) {
			currentURL = request.getParameter(News_Const.CURRENT_URL);
		}
		ProGateJournalArticle article = null;
		if (articleId != 0) {
			article = ProGateJournalArticleLocalServiceUtil
					.getProGateJournalArticle(articleId);
		}

		bean.put("article", article);
		bean.put("cmd", isAdd);
		bean.put("msgText", msgText);
		bean.put("addSuccess", addSuccess);
		bean.put("currentURL", currentURL);
		return new ModelAndView(this.getViewName(), "bean", bean);
	}

}