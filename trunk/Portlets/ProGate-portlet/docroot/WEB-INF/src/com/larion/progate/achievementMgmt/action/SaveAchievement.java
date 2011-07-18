package com.larion.progate.achievementMgmt.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.portlet.PortletPreferences;

import java.io.PrintWriter;
import javax.servlet.ServletOutputStream;

import larion.progate.model.ProGateJournalArticle;
import larion.progate.service.ProGateJournalArticleLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil;
import larion.progate.service.persistence.ProGateJournalArticleUtil;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

import com.larion.progate.achievementMgmt.constants.RequestConst;
import com.larion.progate.achievementMgmt.constants.AchievementConst;
import com.larion.progate.common.utils.Functions;

@SuppressWarnings("unused")
public class SaveAchievement extends PortletAction{
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		
		req.setCharacterEncoding("UTF-8");
		HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
		request.setCharacterEncoding("UTF-8");
		
		HttpServletResponse response = PortalUtil.getHttpServletResponse(res);
		
		ServletOutputStream output = response.getOutputStream();
		
		int actionStatus = RequestConst.JA_NORMAL;			
		
		String portletResource = ParamUtil.getString(req, "portletResource");
		PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(req, portletResource);
		
		String friendlyUrl = preferences.getValue(RequestConst.FRIENDLY_URL, AchievementConst.FRIENDLY_URL);		
		//System.out.println("friendlyUrl = " + friendlyUrl);
		
		String homeUrl= PortalUtil.getPortalURL(request);
		//System.out.println("homeUrl = " + homeUrl);
		
		String achieTitle = (String) request.getParameter(AchievementConst.JA_TITLE).trim();
		String achieLogo = (String) request.getParameter(AchievementConst.JA_LOGO).trim();
		String achieDate = (String) request.getParameter(AchievementConst.JA_ACHIE_DATE).trim();
		String achieIdStr = (String) request.getParameter(RequestConst.ACHIE_ID).trim();
		
		int orgId = Integer.parseInt(req.getParameter(RequestConst.ORG_ID));
		String viewMode = (String) req.getParameter(RequestConst.VIEW_MODE);
		String actMode = (String) req.getParameter(RequestConst.ACTION);
		int achieId = Integer.parseInt(achieIdStr);
		
		System.out.println("achieId = " + achieId);
		
		// Upload image
		String imageUrl = "";
		if ((!(RequestConst.DELETE_ACHIE).equals(actMode))
			&&(((RequestConst.ADD_ACHIE).equals(actMode))
					|| (achieLogo.length() > 0))) {
			try {
				// Upload image
				UploadPortletRequest uploadPortlet = PortalUtil.getUploadPortletRequest(req);			
				
				imageUrl = Functions.getPathOfUploadImage(req, res, uploadPortlet, AchievementConst.JA_LOGO);
				System.out.println("imageUrl =" + imageUrl);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Achie Mgmt: Error in uploading image");
				e.toString();
				
				actionStatus = RequestConst.JA_ERROR;
				
				output.print(Integer.toString(actionStatus) + ";" + Integer.toString(0));		
				output.flush();
				output.close();
				
				res.setRenderParameter(RequestConst.ACHIE_ID, Integer.toString(0));
				res.setRenderParameter(RequestConst.ACTION_STATUS, Integer.toString(actionStatus));
				setForward(req, "portlet.achievement_mgmt.view");
				return;
			}
		}
		
		// Get User
		ServiceContext sc = ServiceContextFactory.getInstance(this.getClass().getName(), req);
		User user = UserLocalServiceUtil.getUser(sc.getUserId());
		Long userIdLong = user.getUserId();
		int userId = userIdLong.intValue();
		
		String articleType = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeAchievement();
		//System.out.println("articleType = " + articleType);
		
		ProGateJournalArticle achieItem = null; 
		if (achieId > 0) {
			achieItem = ProGateJournalArticleLocalServiceUtil.getProGateJournalArticle(achieId);
		} else {
			achieItem = ProGateJournalArticleLocalServiceUtil.createEmptyObject();
			
			//achieItem.setArticleType(ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeAchie());
			achieItem.setCreatedBy(userId);
		}
		
		if (achieItem != null) {
			achieItem.setOrgId(Integer.toString(orgId));
			achieItem.setTitle(achieTitle);
			achieItem.setAddInfo(AchievementConst.JA_ADD_INFO_PREFIX + "=" + achieDate);
			achieItem.setUpdatedBy(userId);
			if (imageUrl.length() > 0) {
				achieItem.setSmallImageUrl(imageUrl);
			}
		} else {
			System.out.println("Achie Mgmt: Cannot found data for articleId = " + achieId);
			
			actionStatus = RequestConst.JA_ERROR;
			
			output.print(Integer.toString(actionStatus) + ";" + Integer.toString(0));		
			output.flush();
			output.close();
			
			res.setRenderParameter(RequestConst.ACHIE_ID, Integer.toString(0));
			res.setRenderParameter(RequestConst.ACTION_STATUS, Integer.toString(actionStatus));
			setForward(req, "portlet.achievement_mgmt.view");
			return;
		}		
		
		//System.out.println("getAddInfo = " + achieItem.getAddInfo());
		
		// Save an achievement into database
		try {
			if ((RequestConst.ADD_ACHIE).equals(actMode)) {
				// Insert 
				System.out.println("Begin process insert an item into database");
				
				ProGateJournalArticle achieRet = ProGateJournalArticleLocalServiceUtil.createNews(achieItem.getOrgId(), achieItem.getUpdatedBy(), achieItem.getTitle(), 
												articleType, "", "", achieItem.getSmallImageUrl(), "", false, achieItem.getAddInfo());
				
				achieRet.setAddInfo(achieItem.getAddInfo());
				achieItem = ProGateJournalArticleLocalServiceUtil.updateProGateJournalArticle(achieRet, true);
			} else if ((RequestConst.EDIT_ACHIE).equals(actMode)) {
				// Update
				System.out.println("Begin process update item form database");
				
				achieItem = ProGateJournalArticleLocalServiceUtil.updateProGateJournalArticle(achieItem, true);
			} else if ((RequestConst.DELETE_ACHIE).equals(actMode)) {
				// Delete
				System.out.println("Begin process delete item from database");
				
				ProGateJournalArticleLocalServiceUtil.deleteProGateJournalArticle(achieId);
			} else {
				System.out.println("Invalid action: " + actMode);
				
				actionStatus = RequestConst.JA_ERROR;
			}
			
			if (actionStatus == RequestConst.JA_NORMAL) {
				if (achieItem == null) {
					System.out.println("Fail???");
					
					actionStatus = RequestConst.JA_ERROR;
				} else {
					System.out.println("Successful!");				
					
					/*
					System.out.println("ArticleId = " + achieItem.getJournalArticleId());
					System.out.println("Title = " + achieItem.getTitle());
					System.out.println("ImageUrl = " + achieItem.getSmallImageUrl());
					System.out.println("AddInfo = " + achieItem.getAddInfo());
					*/
					
					actionStatus = RequestConst.JA_SUCCESS;
					
					output.print(Integer.toString(actionStatus) + ";" + Integer.toString(achieItem.getJournalArticleId()));		
					output.flush();
					output.close();
					
					res.setRenderParameter(RequestConst.ACHIE_ID, Integer.toString(achieItem.getJournalArticleId()));
					res.setRenderParameter(RequestConst.ACTION_STATUS, Integer.toString(actionStatus));
					setForward(req, "portlet.achievement_mgmt.view");	
					return;
				}
			}			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Achie Mgmt: Error in processing database");
			e.printStackTrace();
			
			actionStatus = RequestConst.JA_ERROR;
			
			output.print(Integer.toString(actionStatus) + ";" + Integer.toString(achieItem.getJournalArticleId()));		
			output.flush();
			output.close();
			
			res.setRenderParameter(RequestConst.ACHIE_ID, Integer.toString(achieItem.getJournalArticleId()));
			res.setRenderParameter(RequestConst.ACTION_STATUS, Integer.toString(actionStatus));
			setForward(req, "portlet.achievement_mgmt.view");
			return;
		}
	}

	private String buildRedirectUrl(String homeUrl, String friendlyUrl, int orgId, String viewMode, String actMode, int achieId) {
		String redirectUrl = homeUrl + "/" + friendlyUrl 
							+ "?" + RequestConst.ORG_ID + "=" + orgId 
							+ "&" + RequestConst.VIEW_MODE + "=" + viewMode 
							+ "&" + RequestConst.ACTION + "=" + actMode;
		if (achieId > 0) {
			redirectUrl += "&" + RequestConst.ACHIE_ID + "=" + achieId;
		}
		
		System.out.println("redirectUrl = " + redirectUrl);
		
		return redirectUrl;
	}
	
	@Override
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Achie Mgmt: Error in processing render");
			e.printStackTrace();
		}
		
		return mapping.findForward(getForward(req));
	}
}
