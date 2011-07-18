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
			boolean isMyself = false;
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
			bean.put("viewURL", viewURL);
			System.out.println("ViewURL: "+viewURL);

			String viewMode = ParamUtil.getString(orgRequest,
					URLParameter_RS.VIEW_MODE, "0");
			bean.put("viewMode", viewMode);
			System.out.println("viewMode: " + viewMode);
			
			//get return back URL
			String returnToFullPageURL = ParamUtil.getString(request,
					URLParameter_RS.RETURN_TO_FULL_PAGE_URL, "");

			if ("".equals(returnToFullPageURL)) {
				returnToFullPageURL = orgRequest.getHeader("referer");
			}
			bean.put(URLParameter_RS.RETURN_TO_FULL_PAGE_URL, returnToFullPageURL);
			System.out.println("returnToFullPageURL: "+ returnToFullPageURL);
			

			//Show URL of viewMode and editMode
			String viewModeUrl;
			String editModeUrl;
			if (viewURL.contains("viewMode")) {
				viewModeUrl = viewURL.replaceAll(URLParameter_RS.VIEW_MODE
						+ StringPool.EQUAL + viewMode,
						URLParameter_RS.VIEW_MODE + StringPool.EQUAL + 0);

				editModeUrl = viewURL.replaceAll(URLParameter_RS.VIEW_MODE
						+ StringPool.EQUAL + viewMode,
						URLParameter_RS.VIEW_MODE + StringPool.EQUAL + 1);
				
			}
			else if(viewURL.contains("?")) {
				viewModeUrl = viewURL + "&viewMode=0";
				editModeUrl = viewURL + "&viewMode=1";
			}
			else {
				viewModeUrl = viewURL + "?viewMode=0";
				editModeUrl = viewURL + "?viewMode=1";
			}
			bean.put("viewModeUrl", viewModeUrl);
			bean.put("editModeUrl", editModeUrl);
			System.out.println("viewModeURL: "+viewModeUrl);
			System.out.println("editModeURL: "+editModeUrl);

			// Build URL
			String homeUrl = PortalUtil.getPortalURL(request);
			//String currentUrl = homeUrl + "/my-blog?viewMode=1";
			String currentUrl = viewURL;

			String detailNewsURL = homeUrl + "/my-blog" + StringPool.QUESTION
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
					isMyself = true;
			} else { // see blog of owner
				user = themeDisplay.getUser();
				userId = user.getUserId();
				if (user.getUserId() != themeDisplay.getDefaultUserId())
					//if (viewMode.equals("1"))
					//	isEditable = true;
					isMyself = true;
			}
			
			if(isMyself && viewMode.equals("1"))
				isEditable = true;
			bean.put("isMyself", isMyself);

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
			request.setAttribute(News_Const.VIEW_MODE, viewMode);
			bean.put("authorName", authorName);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
