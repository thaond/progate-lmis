/**
 * Copyright (c) [Year] [Organization] All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.larion.progate.myblog.action;

import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.bean.PaginationObject;
import com.larion.progate.common.constants.URLParameter_RS;
import com.larion.progate.news_homepage.constants.News_Const;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import larion.progate.model.ProGateJournalArticle;
import larion.progate.service.ProGateJournalArticleLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil;

/**
 * <p>
 * Your description here
 * </p>
 * 
 * @author (Your name)
 * 
 */
public class MyBlogAction extends ParameterizableViewAction {

	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {

		try {
			boolean isEditable = false;
			int newsPage = 0;
			int articleId = 0;
			String userName;
			long userId;
			long companyId;

			List<ProGateJournalArticle> listNews = null;
			HttpServletRequest orgRequest = PortalUtil
					.getOriginalServletRequest(PortalUtil
							.getHttpServletRequest(request));

			String viewURL = PortalUtil.getCurrentURL(request);

			// Build URL
			String homeUrl = PortalUtil.getPortalURL(request);
			String currentUrl = homeUrl + "/my-blog";

			String detailNewsURL = currentUrl + StringPool.QUESTION
					+ News_Const.ARTICLE_ID + StringPool.EQUAL;

			if (viewURL.indexOf(News_Const.ARTICLE_ID) != -1) {
				newsPage = 1;
				articleId = Integer.parseInt(orgRequest
						.getParameter(News_Const.ARTICLE_ID));
			}
			String authorName = "";
			ProGateJournalArticle article = null;
			if (articleId != 0) {
				article = ProGateJournalArticleLocalServiceUtil
						.getProGateJournalArticle(articleId);
				User user = UserLocalServiceUtil
						.getUser(article.getCreatedBy());
				authorName = user.getFirstName() + " " + user.getLastName();

			}

			// Get User
			userName = ParamUtil.getString(orgRequest,
					URLParameter_RS.USER_NAME, null);
			ThemeDisplay themeDisplay = (ThemeDisplay) request
					.getAttribute(WebKeys.THEME_DISPLAY);
			User user = null;
			if (userName != null) { // see blog of myself
				companyId = themeDisplay.getCompanyId();
				user = UserLocalServiceUtil.getUserByScreenName(companyId,
						userName);
				if (user.getUserId() == themeDisplay.getUser().getUserId())
					isEditable = true;
			} else { // see blog of owner
				/*
				 * ServiceContext sc = ServiceContextFactory.getInstance(this
				 * .getClass().getName(), request); user =
				 * UserLocalServiceUtil.getUser(sc.getUserId());
				 */
				user = themeDisplay.getUser();
				userId = user.getUserId();
				if (user.getUserId() != themeDisplay.getDefaultUserId())
					isEditable = true;
			}

			userId = user.getUserId();
			System.out.println("userId: " + userId);
			System.out.println("userName: " + user.getScreenName());
			System.out.println("companyId: " + themeDisplay.getCompanyId());
			System.out.println("isEditable: " + isEditable);
			System.out.println("Default userId: "
					+ themeDisplay.getDefaultUserId());

			int end = ProGateJournalArticleLocalServiceUtil
					.countListBlogArticles(userId, "");

			PaginationObject paginationNews = new PaginationObject(
					"NewsProGate", end);
			paginationNews.paging(
					ParamUtil.getInteger(request,
							paginationNews.getCurrentPageName(), 1), 20);
			listNews = ProGateJournalArticleLocalServiceUtil
					.getListBlogArticles(userId, "",
							paginationNews.getStartIndex(),
							paginationNews.getEndIndex());

			// Paging
			bean.put("paginationNews", paginationNews);

			request.setAttribute(News_Const.IS_EDITABLE, isEditable);
			request.setAttribute(News_Const.IS_NEWS_PAGE, newsPage);
			request.setAttribute(News_Const.LIST_NEWS, listNews);
			request.setAttribute(News_Const.CURRENT_URL, currentUrl);
			request.setAttribute(News_Const.ARTICLE, article);
			request.setAttribute(News_Const.DETAIL_NEWS_URL, detailNewsURL);
			bean.put("authorName", authorName);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
