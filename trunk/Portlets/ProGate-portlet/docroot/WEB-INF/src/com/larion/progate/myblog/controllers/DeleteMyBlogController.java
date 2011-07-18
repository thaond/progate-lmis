package com.larion.progate.myblog.controllers;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import larion.progate.service.ProGateJournalArticleLocalServiceUtil;

import org.springframework.web.portlet.mvc.ParameterizableViewController;

import com.larion.progate.common.utils.ProGateUtil;
import com.larion.progate.news_homepage.constants.News_Const;
import com.liferay.portal.kernel.util.ParamUtil;

public class DeleteMyBlogController extends ParameterizableViewController {

	@Override
	protected void handleActionRequestInternal(ActionRequest request,
			ActionResponse response) throws Exception {

		int articleId = ParamUtil.getInteger(request, News_Const.ARTICLE_ID);
		String viewMode = ParamUtil.getString(request, News_Const.VIEW_MODE);

		// Get current User
		try {

			if (articleId != 0) {
				ProGateJournalArticleLocalServiceUtil
						.deleteProGateJournalArticle(Integer.valueOf(articleId));
			}

		} catch (Exception e) {

		}

		ProGateUtil.redirectToPageWithParams(request, response,
				News_Const.MY_BLOG, new String[] { News_Const.VIEW_MODE },
				new String[] { viewMode });

	}
}