package com.larion.progate.supportorgprofile.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

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
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.ActionRequestImpl;


import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portlet.imagegallery.model.IGImage;
import com.liferay.portlet.imagegallery.service.IGImageLocalServiceUtil;
import com.liferay.portlet.imagegallery.service.IGImageServiceUtil; 


public class AddGuildeAction extends PortletAction{
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		System.out.println("add guilde action");
		req.setCharacterEncoding("UTF-8");
		HttpServletRequest request = ((ActionRequestImpl) req)
				.getHttpServletRequest();
		request.setCharacterEncoding("UTF-8");
	 
		String titleGuilde = (String) request.getParameter("titleGuilde");
		String contentGuilde = (String) request.getParameter("contentGuilde");
		String orgId = (String)request.getParameter("orgId");		
		
		try {
			// get Current User
			com.liferay.portal.service.ServiceContext sc = ServiceContextFactory.getInstance(this.getClass().getName(), req);
			com.liferay.portal.model.User user = UserLocalServiceUtil.getUser(sc.getUserId());
			Long userIdTemp = user.getUserId();
			Integer userId = userIdTemp.intValue();
			
			String articleType = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeOrgSupportGuideline();
			
			ProGateJournalArticle article = null;
			article = ProGateJournalArticleLocalServiceUtil.createNewArticleObject(orgId, userId, titleGuilde,
																articleType, "", contentGuilde, "", "", "");			
			ProGateJournalArticleLocalServiceUtil.getProGateJournalArticle(article.getPrimaryKey());
						
			if (article != null){
				request.setAttribute("ADD_SUCCESS", "Bạn đã thêm hướng dẫn thành công.");						
				request.setAttribute("articleId", String.valueOf(article.getPrimaryKey()));
				setForward(req, "portlet.SupportOrgProfile.repairGuilde");
				return;
			}else{
				request.setAttribute("ADD_ERROR", "Đã có lỗi xảy ra trong quá trình thêm hướng dẫn.");				
				setForward(req, "portlet.SupportOrgProfile.addGuilde");
				return;
			}
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("ADD_ERROR", "Đã có lỗi xảy ra trong quá trình thêm hướng dẫn.");
			setForward(req, "portlet.SupportOrgProfile.addGuilde");
			return;
		}
	}
}