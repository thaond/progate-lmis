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


import com.larion.progate.common.utils.Functions;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import java.net.*;

public class RepairLibraryAction extends PortletAction{
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		System.out.println("repair library action");
		req.setCharacterEncoding("UTF-8");
		HttpServletRequest request = ((ActionRequestImpl) req)
				.getHttpServletRequest();
		request.setCharacterEncoding("UTF-8");
	 
		String titleLibrary = (String) request.getParameter("titleLibrary");
		String contentLibrary = (String) request.getParameter("contentLibrary");
		String orgId = (String)request.getParameter("orgId");		
		String modeType = (String)request.getParameter("modeType");
		String articleId = (String)request.getParameter("articleId");
		System.out.println("articleId =" + articleId);
		
	
		try {
			// get Current User
			com.liferay.portal.service.ServiceContext sc = ServiceContextFactory.getInstance(this.getClass().getName(), req);
			com.liferay.portal.model.User user = UserLocalServiceUtil.getUser(sc.getUserId());
			Long userIdTemp = user.getUserId();
			Integer userId = userIdTemp.intValue();			
		
			ProGateJournalArticle article = ProGateJournalArticleLocalServiceUtil.getProGateJournalArticle(Integer.valueOf(articleId));
			
			System.out.println(article.getTitle());
			article.setTitle(titleLibrary);
			article.setContent(contentLibrary);
			
			
			if (modeType.equals("Video")){
				String videoType = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeOrgSupportVideo();
				String embeddedVideo = (String)request.getParameter("embeddedVideo");
				article.setDescription(embeddedVideo);
				System.out.println("embeddedVideo = " + embeddedVideo);				
				String[] temp = embeddedVideo.split(" ");
				
				for (int i = 0; i < temp.length; i++) {
					if (temp[i].contains("width=")){						
						temp[i] = "width='200'";
					}
					if (temp[i].contains("height=")){
						if (temp[i].contains(">")){
							temp[i] = "height='200'>";
						}else{
							temp[i] = "height='200'";
						}					
					}
				}
				StringBuffer result = new StringBuffer();
				for (int i = 0; i < temp.length; i++) {
					result.append(temp[i]);
					result.append(" ");
				}
				
				article.setSmallImageUrl(result.toString());
				
			}
			
			if (modeType.equals("PDF")){
				String pdfType = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeOrgSupportPdf();
				
				UploadPortletRequest uploadPortlet = PortalUtil.getUploadPortletRequest(req);
				
				String fileName = uploadPortlet.getFileName("attachFile");
				
				if (fileName != ""){
					FileNameMap fileNameMap = URLConnection.getFileNameMap();
				    String type = fileNameMap.getContentTypeFor(fileName);
				    
				    
				    if (type.equals("application/pdf")){
				    	String smallDocumentPath = Functions.getPathOfUploadDocument(req, res, uploadPortlet, "attachFile");
						article.setSmallImageUrl(smallDocumentPath);
				    }else{
				    	request.setAttribute("REPAIR_ERROR", "Đã có lỗi xảy ra trong quá trình thêm hướng dẫn.");
						setForward(req, "portlet.SupportOrgProfile.repairLibrary");
						return;
				    }
				}
			}	
			ProGateJournalArticleLocalServiceUtil.updateProGateJournalArticle(article, true);
			request.setAttribute("REPAIR_SUCCESS", "Bạn đã thêm hướng dẫn thành công.");						
			request.setAttribute("articleId", String.valueOf(article.getPrimaryKey()));
			System.out.println("article.getPrimaryKey() =" + article.getPrimaryKey());
			setForward(req, "portlet.SupportOrgProfile.repairLibrary");
			return;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			request.setAttribute("REPAIR_ERROR", "Đã có lỗi xảy ra trong quá trình thêm hướng dẫn.");
			setForward(req, "portlet.SupportOrgProfile.repairLibrary");
			return;
		}
	}
}