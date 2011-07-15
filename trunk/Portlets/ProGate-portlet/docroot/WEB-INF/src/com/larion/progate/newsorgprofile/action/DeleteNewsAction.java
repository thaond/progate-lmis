package com.larion.progate.newsorgprofile.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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

import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.ActionRequestImpl;

import com.liferay.portal.kernel.upload.UploadPortletRequest;


public class DeleteNewsAction extends PortletAction{
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		HttpServletRequest request = ((ActionRequestImpl) req).getHttpServletRequest();
		request.setCharacterEncoding("UTF-8");
		String orgId = (String)request.getParameter("orgId");
		String articleId = (String)request.getParameter("articleId");
		
		try{
			ProGateJournalArticle article = ProGateJournalArticleLocalServiceUtil.getProGateJournalArticle(Integer.valueOf(articleId));
		}catch (Exception e){
			request.setAttribute("DELETE_ERROR", "Đã có lỗi xảy ra trong quá trình xóa hướng dẫn.");
			setForward(req, "portlet.NewsOrgProfile.addNews");
			return;
		}
		
		try {			
			ProGateJournalArticleLocalServiceUtil.deleteProGateJournalArticle(Integer.valueOf(articleId));
			request.setAttribute("DELETE_SUCCESS", "Bạn đã xóa tin tức thành công.");
			String title = (String)request.getParameter("title");
			request.setAttribute("CHANGE_TITLE", title);
			request.setAttribute("orgId", orgId);
			setForward(req, "portlet.NewsOrgProfile.addNews");
			return;
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("DELETE_ERROR", "Đã có lỗi xảy ra trong quá trình xóa tin tức.");
			request.setAttribute("orgId", orgId);
			request.setAttribute("articleId", articleId);
			setForward(req, "portlet.NewsOrgProfile.repairNews");
			return;
		}
	}
}