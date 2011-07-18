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


public class RepairGuildeAction extends PortletAction{
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		System.out.println("repair guilde action");
		req.setCharacterEncoding("UTF-8");
		HttpServletRequest request = ((ActionRequestImpl) req)
				.getHttpServletRequest();
		request.setCharacterEncoding("UTF-8");
	
		String titleGuilde = (String) request.getParameter("titleGuilde");
		String contentGuilde = (String) request.getParameter("contentGuilde");
		String articleId = (String)request.getParameter("articleId");
		
		
		
		try {
			
			String articleType = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeOrgSupportGuideline();
			
			ProGateJournalArticle article = ProGateJournalArticleLocalServiceUtil.getProGateJournalArticle(
                    														Integer.valueOf(articleId));
			
			article.setTitle(titleGuilde);
			article.setContent(contentGuilde);
			article = ProGateJournalArticleLocalServiceUtil.updateProGateJournalArticle(article, true);
						
			if (article != null){
				request.setAttribute("REPAIR_SUCCESS", "Bạn đã cập nhập hướng dẫn thành công.");	
				setForward(req, "portlet.SupportOrgProfile.repairGuilde");
				return;
			}else{
				request.setAttribute("REPAIR_ERROR", "Đã có lỗi xảy ra trong quá trình cập nhập hướng dẫn.");	
				setForward(req, "portlet.SupportOrgProfile.repairGuilde");
				return;
			}
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("REPAIR_ERROR", "Đã có lỗi xảy ra trong quá trình cập nhập hướng dẫn.");
			setForward(req, "portlet.SupportOrgProfile.repairGuilde");
			return;
		}
	}
}