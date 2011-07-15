package com.larion.progate.newsorgprofile.action;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;

import larion.progate.model.ProGateJournalArticle;
import larion.progate.service.ProGateJournalArticleLocalServiceUtil;
import larion.progate.service.ProGateJournalArticlePrioritiesLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.larion.progate.common.utils.Functions;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.ActionRequestImpl;

public class RepairNewsAction extends PortletAction {
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		System.out.println("repair");
		req.setCharacterEncoding("UTF-8");
		HttpServletRequest request = ((ActionRequestImpl) req)
				.getHttpServletRequest();
		request.setCharacterEncoding("UTF-8");

		String headerNews = (String) request.getParameter("headerNews");
		String content = (String) request.getParameter("contentNews");
		String keyword = (String) request.getParameter("keyword");
		String mark = (String) request.getParameter("mark");
		String orgIdTemp = (String) request.getParameter("orgId");
		String articleId = (String) request.getParameter("articleId");
		int orgId = Integer.valueOf(orgIdTemp);

		String description = (String) request.getParameter("description");

		try {
			// Get current User
			com.liferay.portal.service.ServiceContext sc = ServiceContextFactory
					.getInstance(this.getClass().getName(), req);
			com.liferay.portal.model.User user = UserLocalServiceUtil
					.getUser(sc.getUserId());
			Long userIdTemp = user.getUserId();
			int userId = userIdTemp.intValue();

			String articleType = ProGateJournalArticleTypesLocalServiceUtil
					.getArticleTypeNews();

			ProGateJournalArticle article = null;
			if (articleId != null) {
				article = ProGateJournalArticleLocalServiceUtil
						.getProGateJournalArticle(Integer.valueOf(articleId));
				article.setTitle(headerNews);
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

				UploadPortletRequest uploadPortlet = PortalUtil
						.getUploadPortletRequest(req);
				String fileName = uploadPortlet.getFileName("smallImage");
				if (fileName != "") {
					String smallImagePath = Functions.getPathOfUploadImage(req,
							res, uploadPortlet, "smallImage");
					article.setSmallImageUrl(smallImagePath);
				}

				article = ProGateJournalArticleLocalServiceUtil
						.updateProGateJournalArticle(article, true);
			}

			if (article != null) {
				request.setAttribute("REPAIR_SUCCESS",
						"Bạn đã cập nhập tin tức thành công.");
				request.setAttribute("orgId", orgIdTemp);
				request.setAttribute("articleId",
						String.valueOf(article.getPrimaryKey()));
				String title = (String) request.getParameter("title");
				request.setAttribute("CHANGE_TITLE", title);
				setForward(req, "portlet.NewsOrgProfile.repairNews");
				return;
			} else {
				String title = (String) request.getParameter("title");
				request.setAttribute("CHANGE_TITLE", title);
				request.setAttribute("REPAIR_ERROR",
						"Đã có lỗi xảy ra trong quá trình cập nhập tin tức.");
				request.setAttribute("orgId", orgIdTemp);
				setForward(req, "portlet.NewsOrgProfile.repairNews");
				return;
			}
		} catch (Exception e) {
			// TODO: handle exception
			String title = (String) request.getParameter("title");
			request.setAttribute("CHANGE_TITLE", title);
			request.setAttribute("REPAIR_ERROR",
					"Đã có lỗi xảy ra trong quá trình cập nhập tin tức.");
			request.setAttribute("orgId", orgIdTemp);
			setForward(req, "portlet.NewsOrgProfile.repairNews");
			return;
		}
	}
}
