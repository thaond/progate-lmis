package com.larion.progate.newsorgprofile.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import larion.progate.model.ProGateJournalArticle;
import larion.progate.service.ProGateJournalArticleLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.larion.progate.common.utils.Functions;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.ActionRequestImpl;

public class AddNewsAction extends PortletAction {
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {

		req.setCharacterEncoding("UTF-8");
		HttpServletRequest request = ((ActionRequestImpl) req)
				.getHttpServletRequest();
		request.setCharacterEncoding("UTF-8");

		String headerNews = (String) request.getParameter("headerNews");
		String content = (String) request.getParameter("contentNews");
		String keyword = (String) request.getParameter("keyword");
		String mark = (String) request.getParameter("mark");
		String orgIdTemp = (String) request.getParameter("orgId");
		int orgId = Integer.valueOf(orgIdTemp);

		String description = (String) request.getParameter("description");
		if (description.length() > 2000) {
			description = (String) content.substring(2000);
		} else {
			description.concat(content);
		}

		UploadPortletRequest uploadPortlet = PortalUtil
				.getUploadPortletRequest(req);
		String smallImagePath = Functions.getPathOfUploadImage(req, res,
				uploadPortlet, "smallImage");

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
			if (mark != null) {
				article = ProGateJournalArticleLocalServiceUtil.createNews(
						Integer.toString(orgId), userId, headerNews,
						articleType, description, content, smallImagePath, "",
						true, "");
			} else {
				article = ProGateJournalArticleLocalServiceUtil.createNews(
						Integer.toString(orgId), userId, headerNews,
						articleType, description, content, smallImagePath, "",
						false, "");
			}

			if (article != null) {

				request.setAttribute("ADD_SUCCESS",
						"Bạn đã thêm tin tức thành công.");
				request.setAttribute("orgId", orgIdTemp);
				String title = (String) request.getParameter("title");
				request.setAttribute("CHANGE_TITLE", title);
				request.setAttribute("articleId",
						String.valueOf(article.getPrimaryKey()));
				setForward(req, "portlet.NewsOrgProfile.repairNews");
				return;
			} else {

				String title = (String) request.getParameter("title");
				request.setAttribute("CHANGE_TITLE", title);
				request.setAttribute("ADD_ERROR",
						"Đã xảy ra lỗi trong quá trình lưu tin tức.");
				request.setAttribute("orgId", orgIdTemp);
				setForward(req, "portlet.NewsOrgProfile.addNews");
				return;
			}
		} catch (Exception e) {
			// TODO: handle exception

			String title = (String) request.getParameter("title");
			request.setAttribute("CHANGE_TITLE", title);
			request.setAttribute("ADD_ERROR",
					"Đã xảy ra lỗi trong quá trình lưu tin tức.");
			request.setAttribute("orgId", orgIdTemp);
			setForward(req, "portlet.NewsOrgProfile.addNews");
			return;
		}
	}

	@Override
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		return mapping.findForward(getForward(req));
	}
}
