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


public class DeleteChatOnlineAction extends PortletAction{
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		System.out.println("delete chat Online action");
		req.setCharacterEncoding("UTF-8");
		HttpServletRequest request = ((ActionRequestImpl) req)
				.getHttpServletRequest();
		request.setCharacterEncoding("UTF-8");
		
		String idOfDeletePerson = (String)request.getParameter("idOfDeletePerson");
		String[] idArr = idOfDeletePerson.split(";");
		String articleId;
	    String orgId = (String)request.getParameter("orgId");
	   
	    if (idArr[0].equals("")){
	    	request.setAttribute("DELETE_ERROR", "Đã có lỗi xảy ra trong quá trình xóa hỗ trợ viên.");
			setForward(req, "portlet.SupportOrgProfile.repairChatOnline");
			return;
	    }
	    
	    try{
	    	for (int i = 0; i < idArr.length; i++) {
				ProGateJournalArticleLocalServiceUtil.getProGateJournalArticle(Integer.valueOf(idArr[i]));
			}	
		}catch (Exception e){
			request.setAttribute("DELETE_ERROR", "Đã có lỗi xảy ra trong quá trình xóa hướng dẫn.");
			setForward(req, "portlet.SupportOrgProfile.addChatOnline");
			return;
		}
		
		try {
			
			for (int i = 0; i < idArr.length; i++) {
				ProGateJournalArticleLocalServiceUtil.deleteProGateJournalArticle(Integer.valueOf(idArr[i]));
			}	
			
			// lay cac chatOnline
		    String chatOnlineType = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeOrgSupportOnline();
		    int sumOfChatOnline = ProGateJournalArticleLocalServiceUtil.countArticleByType(Integer.valueOf(orgId), chatOnlineType, "");
		    
		    if (sumOfChatOnline == 0){
		    	request.setAttribute("DELETE_SUCCESS", "Bạn đã xóa hỗ trợ viên thành công.");	
				setForward(req, "portlet.SupportOrgProfile.addChatOnline");
				return;
		    }else{
		    	request.setAttribute("DELETE_SUCCESS", "Bạn đã xóa hỗ trợ viên thành công.");	
				setForward(req, "portlet.SupportOrgProfile.repairChatOnline");
				return;
		    }
			
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("DELETE_ERROR", "Đã có lỗi xảy ra trong quá trình xóa hỗ trợ viên.");
			setForward(req, "portlet.SupportOrgProfile.repairChatOnline");
			return;
		}
	}
}