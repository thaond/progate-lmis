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

import com.liferay.portal.kernel.util.Validator;

import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portlet.imagegallery.model.IGImage;
import com.liferay.portlet.imagegallery.service.IGImageLocalServiceUtil;
import com.liferay.portlet.imagegallery.service.IGImageServiceUtil; 


public class AddQuestionAction extends PortletAction{
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		System.out.println("add question action");
		req.setCharacterEncoding("UTF-8");
		HttpServletRequest request = ((ActionRequestImpl) req)
				.getHttpServletRequest();
		request.setCharacterEncoding("UTF-8");
	 
		String descriptionQuestion = (String) request.getParameter("descriptionQuestion");
		String contentQuestion = (String) request.getParameter("contentQuestion");
		String orgId = (String)request.getParameter("orgId");	
		String articleOrder = (String)request.getParameter("order");
		System.out.println("articleOrder = " + articleOrder);
		
		try {
			// get Current User
			com.liferay.portal.service.ServiceContext sc = ServiceContextFactory.getInstance(this.getClass().getName(), req);
			com.liferay.portal.model.User user = UserLocalServiceUtil.getUser(sc.getUserId());
			Long userIdTemp = user.getUserId();
			Integer userId = userIdTemp.intValue();
			
			String articleType = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeOrgSupportFaq();
			
			if (articleOrder.equals("")){
				articleOrder = String.valueOf(ProGateJournalArticleLocalServiceUtil.countArticleByType(Integer.valueOf(orgId), articleType, "") + 1);
			}
			System.out.println("articleOrder = " + articleOrder);
			
			ProGateJournalArticle article = null;
			article = ProGateJournalArticleLocalServiceUtil.createNewArticleObject(orgId, userId, "",
																articleType, descriptionQuestion, contentQuestion, "", "", "articleOrder=" + articleOrder);			
			ProGateJournalArticleLocalServiceUtil.getProGateJournalArticle(article.getPrimaryKey());
			System.out.println("article.getPrimaryKey() =" + article.getPrimaryKey());
			
			
			if (article != null){
				request.setAttribute("ADD_SUCCESS", "Bạn đã thêm câu hỏi thành công.");	
				request.setAttribute("articleId", String.valueOf(article.getPrimaryKey()));
				setForward(req, "portlet.SupportOrgProfile.repairQuestion");
				return;
			}else{
				request.setAttribute("ADD_ERROR", "Đã có lỗi xảy ra trong quá trình thêm câu hỏi.");				
				setForward(req, "portlet.SupportOrgProfile.addQuestion");
				return;
			}
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("ADD_ERROR", "Đã có lỗi xảy ra trong quá trình thêm câu hỏi.");
			setForward(req, "portlet.SupportOrgProfile.addQuestion");
			return;
		}
	}
}