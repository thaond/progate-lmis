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


public class AddChatOnlineAction extends PortletAction{
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		System.out.println("add guilde action");
		req.setCharacterEncoding("UTF-8");
		HttpServletRequest request = ((ActionRequestImpl) req)
				.getHttpServletRequest();
		request.setCharacterEncoding("UTF-8");
	 
		
		String orgId = (String)request.getParameter("orgId");	
		String contentChatOnline = "";
		String currentPerson = (String)request.getParameter("currentPerson");
		int countPerson = Integer.valueOf(currentPerson);
		
		System.out.println("countPerson = " + countPerson);
		
		try {
			// get Current User
			com.liferay.portal.service.ServiceContext sc = ServiceContextFactory.getInstance(this.getClass().getName(), req);
			com.liferay.portal.model.User user = UserLocalServiceUtil.getUser(sc.getUserId());
			Long userIdTemp = user.getUserId();
			Integer userId = userIdTemp.intValue();
			
			String articleType = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeOrgSupportOnline();
			
			ProGateJournalArticle article = null;
			for (int i = 1; i <= countPerson; i++) {
				String nick1 = (String) request.getParameter("nick" + i);
				String position1 = (String) request.getParameter("position" + i);	
				String typeChatOnline = (String)request.getParameter("typeChatOnline" + i);
				
				if (typeChatOnline.equals("Yahoo! Messenger")){
					contentChatOnline = "<a href='ymsgr:sendim?" + nick1 + "'><span style='font-size: medium;'>" +
							            "<img border='0' style='width: 130px; height: 25px;' title='" +
							            nick1 + "' src='http://opi.yahoo.com/online?u=" + nick1 + 
							            "&amp;m=g&amp;t=2&amp;1=us'></span> </a>";	
					
				}else if (typeChatOnline.equals("Skype")){
					contentChatOnline = "<a href='skype:" +
							             nick1 +"?call'><img src='http://mystatus.skype.com/balloon/" +
							             nick1 + "' style='border: none;margin-top:-10px;' width='182' height='44' title='" +
							             nick1 + "' /></a> ";
					
				}
				
				ProGateJournalArticleLocalServiceUtil.createNewArticleObject(orgId, userId, position1,
						articleType, typeChatOnline, contentChatOnline, "", nick1, "");	
				
			}
			
			request.setAttribute("ADD_SUCCESS", "Bạn đã thêm hỗ trợ viên  thành công.");	
			setForward(req, "portlet.SupportOrgProfile.repairChatOnline");
			return;
			
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("ADD_ERROR", "Đã có lỗi xảy ra trong quá trình thêm hỗ trợ viên.");
			setForward(req, "portlet.SupportOrgProfile.addChatOnline");
			return;
		}
	}
}