package com.larion.progate.myblog.controllers;

import java.util.HashMap;
import java.util.Map;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import larion.progate.model.ProGateJournalArticle;
import larion.progate.service.ProGateJournalArticleLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

import com.larion.progate.common.utils.Functions;
import com.larion.progate.news_homepage.constants.News_Const;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

public class AddMyBlogController extends ParameterizableViewController {

	@Override
	protected void handleActionRequestInternal(ActionRequest request,
			ActionResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String msg = "";
		int articleId = 0;
		int isAdd = 0;
		int addSuccess = 0;

		UploadPortletRequest uploadPortlet = PortalUtil
				.getUploadPortletRequest(request);
		String currentURL = uploadPortlet.getParameter(News_Const.CURRENT_URL);
		String title = uploadPortlet.getParameter(News_Const.TITLE);
		String content = uploadPortlet.getParameter(News_Const.CONTENT);
		content = content.replaceAll("../../../image", "/image");
		String keyword = uploadPortlet.getParameter(News_Const.KEY_WORD);
		String mark = uploadPortlet.getParameter(News_Const.MARK);
		String description = uploadPortlet.getParameter(News_Const.DESCRIPTION);

		String smallImagePath = Functions.getPathOfUploadImage(request,
				response, uploadPortlet, News_Const.SMALL_IMAGE);
		try {
			// Get current User
			com.liferay.portal.service.ServiceContext sc = ServiceContextFactory
					.getInstance(this.getClass().getName(), request);
			com.liferay.portal.model.User user = UserLocalServiceUtil
					.getUser(sc.getUserId());
			Long userIdTemp = user.getUserId();
			int userId = userIdTemp.intValue();
			String articleType = ProGateJournalArticleTypesLocalServiceUtil
					.getArticleTypeNews();
			ProGateJournalArticle article = null;

			if (mark != null) {
				article = ProGateJournalArticleLocalServiceUtil.createNews(
						Integer.toString(-1), userId, title, articleType,
						description, content, smallImagePath, "", true, "");
			} else {
				article = ProGateJournalArticleLocalServiceUtil.createNews(
						Integer.toString(-1), userId, title, articleType,
						description, content, smallImagePath, "", false, "");
			}

			if (article != null) {
				addSuccess = 1;
				articleId = article.getPrimaryKey();
			}
		} catch (Exception e) {
			// TODO: handle exception
			addSuccess = 2;

		}
		isAdd = 1;
		response.setRenderParameter(News_Const.CMD, Integer.toString(isAdd));
		response.setRenderParameter(News_Const.MSG_TEXT, msg);
		response.setRenderParameter(News_Const.ADD_SUCCESS,
				Integer.toString(addSuccess));
		response.setRenderParameter(News_Const.ARTICLE_ID,
				Integer.toString(articleId));
		response.setRenderParameter(News_Const.CURRENT_URL, currentURL);
		response.setRenderParameter("action", "updateMyBlog");
	}

	@Override
	protected ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {
		Map<String, Object> bean = new HashMap<String, Object>();
		String currentURL = "";
		if (request.getParameter(News_Const.CURRENT_URL) != null) {
			currentURL = request.getParameter(News_Const.CURRENT_URL);
		}
		bean.put("currentURL", currentURL);
		return new ModelAndView(this.getViewName(), "bean", bean);
	}

}