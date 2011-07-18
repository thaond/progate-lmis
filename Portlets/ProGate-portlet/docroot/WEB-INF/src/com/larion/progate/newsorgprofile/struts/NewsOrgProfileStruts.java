package com.larion.progate.newsorgprofile.struts;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import larion.progate.model.ProGateJournalArticle;
import larion.progate.service.ProGateJournalArticleLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil;

import com.larion.progate.common.constants.URLParameter_RS;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.StrutsPortlet;

import com.larion.progate.common.constants.ProgateRoleConst;

public class NewsOrgProfileStruts extends StrutsPortlet {
	public void doView(RenderRequest req, RenderResponse res)
			throws IOException, PortletException {
		String targetPage = "";
		boolean turnDirection = false;

		String backURL = PortalUtil.getCurrentURL(req);
		int indexURL = backURL.indexOf("?");
		if (indexURL != -1) {
			req.setAttribute("currentURL", backURL.substring(0, indexURL));
		}

		try {
			HttpServletRequest httpSr = PortalUtil.getHttpServletRequest(req);
			HttpServletRequest origReq = PortalUtil
					.getOriginalServletRequest(httpSr);
			String orgId = origReq.getParameter(URLParameter_RS.ORG_ID);
			String viewMode = origReq.getParameter(URLParameter_RS.VIEW_MODE);

			if (viewMode != null) {
				req.setAttribute("viewMode", viewMode);
			}
			boolean isViewMode = false;
			if (viewMode != null && "1".equals(viewMode)) {
				isViewMode = true;
			}
			if (orgId != null) {

				String articleType = ProGateJournalArticleTypesLocalServiceUtil
						.getArticleTypeNews();

				// kiem tra quyen User

				boolean isOrgAdmin = false;
				// Get User
				com.liferay.portal.service.ServiceContext sc = ServiceContextFactory
						.getInstance(this.getClass().getName(), req);
				com.liferay.portal.model.User user = com.liferay.portal.service.UserLocalServiceUtil
						.getUser(sc.getUserId());
				long userId = user.getUserId();

				List<String> listRole = larion.progate.service.ProgateOrganizationParticipantsLocalServiceUtil
						.getUserRoles(userId, Integer.parseInt(orgId));

				for (String role : listRole) {
					// khi nao review code thi chuyen cai bien nay thanh hang so
					// trong file const
					if ((ProgateRoleConst.PROGATE_ADMIN.equals(role)
							|| ProgateRoleConst.ORG_ADMIN.equals(role) || ProgateRoleConst.ORG_OWNER
							.equals(role)) && isViewMode) {
						isOrgAdmin = true;
					}
				}
				req.setAttribute("isOrgAdmin", isOrgAdmin);

				List<ProGateJournalArticle> listArticles = ProGateJournalArticleLocalServiceUtil
						.getListProGateArticlesByPrority(
								Integer.valueOf(orgId), articleType, true, "",
								0, 4);

				int baiviet = 0;
				if (listArticles != null) {
					baiviet = listArticles.size();
				}

				if (baiviet == 0) {
					if (isOrgAdmin == false) {
						req.setAttribute("orgId", orgId);
						turnDirection = true;
						targetPage = "/html/portlet/NewsOrgProfile/empty.jsp";
					} else {
						req.setAttribute("orgId", orgId);
						turnDirection = true;
						targetPage = "/html/portlet/NewsOrgProfile/emptyNews.jsp";
					}
				} else {
					req.setAttribute("orgId", orgId);
					turnDirection = true;
					targetPage = "/html/portlet/NewsOrgProfile/homeView.jsp";
				}
			} else {
				turnDirection = true;
				targetPage = "/html/portlet/NewsOrgProfile/plainPage.jsp";
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			turnDirection = true;
			targetPage = "/html/portlet/NewsOrgProfile/plainPage.jsp";
		}

		String currentURL = PortalUtil.getCurrentURL(req);
		if (currentURL.contains("tintuc")) {
			HttpServletRequest httpSr = PortalUtil.getHttpServletRequest(req);
			HttpServletRequest origReq = PortalUtil
					.getOriginalServletRequest(httpSr);
			String orgId = origReq.getParameter("orgId");

			String articleId = origReq.getParameter("articleId");
			boolean detail = false;
			if (articleId != null && orgId != null) {
				detail = true;
				req.setAttribute("orgId", orgId);
				req.setAttribute("articleId", articleId);
				turnDirection = true;
				targetPage = "/html/portlet/NewsOrgProfile/detailArticle.jsp";
			} else if (articleId == null && orgId != null) {
				req.setAttribute("orgId", orgId);
				req.setAttribute("pageNum", "1");
				turnDirection = true;
				targetPage = "/html/portlet/NewsOrgProfile/generalNews.jsp";
			}

			if (!detail) {
				String pageNum = origReq.getParameter("pageNum");

				if (pageNum == null && orgId != null) {
					req.setAttribute("orgId", orgId);
					req.setAttribute("pageNum", "1");
					targetPage = "/html/portlet/NewsOrgProfile/generalNews.jsp";
				} else if (pageNum != null && orgId != null) {
					req.setAttribute("orgId", orgId);
					req.setAttribute("pageNum", pageNum);
					targetPage = "/html/portlet/NewsOrgProfile/generalNews.jsp";
				}
			}

		}

		String action = req.getParameter("struts_action");
		if (action != null) {
			String viewMode = req.getParameter(URLParameter_RS.VIEW_MODE);
			if (viewMode != null) {
				req.setAttribute("viewMode", viewMode);
			}
			turnDirection = false;
		}

		if (turnDirection) {
			PortletRequestDispatcher prd = getPortletContext()
					.getRequestDispatcher(targetPage);
			prd.include(req, res);
		} else {

			super.doView(req, res);
		}

	}
}
