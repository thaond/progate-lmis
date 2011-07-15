package com.larion.progate.certificationMgmt.action;

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

import com.larion.progate.certificationMgmt.constants.RequestConst;
import com.larion.progate.certificationMgmt.constants.CertificationConst;
import com.larion.progate.common.utils.Functions;

@SuppressWarnings("unused")
public class SaveCertification extends PortletAction{
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
		
		String friendlyUrl = preferences.getValue(RequestConst.FRIENDLY_URL, CertificationConst.FRIENDLY_URL);		
		//System.out.println("friendlyUrl = " + friendlyUrl);
		
		String homeUrl= PortalUtil.getPortalURL(request);
		//System.out.println("homeUrl = " + homeUrl);
		
		String certTitle = (String) request.getParameter(CertificationConst.JA_TITLE).trim();
		String certLogo = (String) request.getParameter(CertificationConst.JA_LOGO).trim();
		String certDate = (String) request.getParameter(CertificationConst.JA_CERT_DATE).trim();
		String certIdStr = (String) request.getParameter(RequestConst.CERT_ID).trim();
		
		int orgId = Integer.parseInt(req.getParameter(RequestConst.ORG_ID));
		String viewMode = (String) req.getParameter(RequestConst.VIEW_MODE);
		String actMode = (String) req.getParameter(RequestConst.ACTION);
		int certId = Integer.parseInt(certIdStr);
		
		System.out.println("certId = " + certId);
		
		// Upload image
		String imageUrl = "";
		if ((!(RequestConst.DELETE_CERT).equals(actMode))
			&&(((RequestConst.ADD_CERT).equals(actMode))
					|| (certLogo.length() > 0))) {
			try {
				// Upload image
				UploadPortletRequest uploadPortlet = PortalUtil.getUploadPortletRequest(req);			
				
				imageUrl = Functions.getPathOfUploadImage(req, res, uploadPortlet, CertificationConst.JA_LOGO);
				System.out.println("imageUrl =" + imageUrl);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Cert Mgmt: Error in uploading image");
				e.toString();
				
				actionStatus = RequestConst.JA_ERROR;
				
				output.print(Integer.toString(actionStatus) + ";" + Integer.toString(0));		
				output.flush();
				output.close();

				res.setRenderParameter(RequestConst.CERT_ID, Integer.toString(0));
				res.setRenderParameter(RequestConst.ACTION_STATUS, Integer.toString(actionStatus));
				setForward(req, "portlet.certification_mgmt.view");
				return;
			}
		}
		
		// Get User
		ServiceContext sc = ServiceContextFactory.getInstance(this.getClass().getName(), req);
		User user = UserLocalServiceUtil.getUser(sc.getUserId());
		Long userIdLong = user.getUserId();
		int userId = userIdLong.intValue();
		
		String articleType = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeCert();
		//System.out.println("articleType = " + articleType);
		
		ProGateJournalArticle certItem = null; 
		if (certId > 0) {
			certItem = ProGateJournalArticleLocalServiceUtil.getProGateJournalArticle(certId);
		} else {
			certItem = ProGateJournalArticleLocalServiceUtil.createEmptyObject();
			
			//certItem.setArticleType(ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeCert());
			certItem.setCreatedBy(userId);
		}
		
		if (certItem != null) {
			certItem.setOrgId(Integer.toString(orgId));
			certItem.setTitle(certTitle);
			certItem.setAddInfo(CertificationConst.JA_ADD_INFO_PREFIX + "=" + certDate);
			certItem.setUpdatedBy(userId);
			if (imageUrl.length() > 0) {
				certItem.setSmallImageUrl(imageUrl);
			}
		} else {
			System.out.println("Cert Mgmt: Cannot found data for articleId = " + certId);
			
			actionStatus = RequestConst.JA_ERROR;
			
			output.print(Integer.toString(actionStatus) + ";" + Integer.toString(0));		
			output.flush();
			output.close();
			
			res.setRenderParameter(RequestConst.CERT_ID, Integer.toString(0));
			res.setRenderParameter(RequestConst.ACTION_STATUS, Integer.toString(actionStatus));
			setForward(req, "portlet.certification_mgmt.view");
			return;
		}		
		
		//System.out.println("getAddInfo = " + certItem.getAddInfo());
		
		// Save an certified into database
		try {
			if ((RequestConst.ADD_CERT).equals(actMode)) {
				// Insert 
				System.out.println("Begin process insert an item into database");
				
				ProGateJournalArticle certRet = ProGateJournalArticleLocalServiceUtil.createNews(certItem.getOrgId(), certItem.getUpdatedBy(), certItem.getTitle(), 
												articleType, "", "", certItem.getSmallImageUrl(), "", false, certItem.getAddInfo());
				
				certRet.setAddInfo(certItem.getAddInfo());
				certItem = ProGateJournalArticleLocalServiceUtil.updateProGateJournalArticle(certRet, true);
			} else if ((RequestConst.EDIT_CERT).equals(actMode)) {
				// Update
				System.out.println("Begin process update item form database");
				
				certItem = ProGateJournalArticleLocalServiceUtil.updateProGateJournalArticle(certItem, true);
			} else if ((RequestConst.DELETE_CERT).equals(actMode)) {
				// Delete
				System.out.println("Begin process delete item from database");
				
				ProGateJournalArticleLocalServiceUtil.deleteProGateJournalArticle(certId);
			} else {
				System.out.println("Invalid action: " + actMode);
				
				actionStatus = RequestConst.JA_ERROR;
			}
			
			if (actionStatus == RequestConst.JA_NORMAL) {
				if (certItem == null) {
					System.out.println("Fail???");
					
					actionStatus = RequestConst.JA_ERROR;
				} else {
					System.out.println("Successful!");				
					
					/*
					System.out.println("ArticleId = " + certItem.getJournalArticleId());
					System.out.println("Title = " + certItem.getTitle());
					System.out.println("ImageUrl = " + certItem.getSmallImageUrl());
					System.out.println("AddInfo = " + certItem.getAddInfo());
					*/
					
					actionStatus = RequestConst.JA_SUCCESS;

					output.print(Integer.toString(actionStatus) + ";" + Integer.toString(certItem.getJournalArticleId()));		
					output.flush();
					output.close();
					
					res.setRenderParameter(RequestConst.CERT_ID, Integer.toString(certItem.getJournalArticleId()));
					res.setRenderParameter(RequestConst.ACTION_STATUS, Integer.toString(actionStatus));
					setForward(req, "portlet.certification_mgmt.view");
					return;
				}
			}			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Cert Mgmt: Error in processing database");
			e.printStackTrace();
			
			actionStatus = RequestConst.JA_ERROR;

			output.print(Integer.toString(actionStatus) + ";" + Integer.toString(certItem.getJournalArticleId()));		
			output.flush();
			output.close();
			
			res.setRenderParameter(RequestConst.CERT_ID, Integer.toString(certItem.getJournalArticleId()));
			res.setRenderParameter(RequestConst.ACTION_STATUS, Integer.toString(actionStatus));
			setForward(req, "portlet.certification_mgmt.view");
			return;
		}
	}

	private String buildRedirectUrl(String homeUrl, String friendlyUrl, int orgId, String viewMode, String actMode, int certId) {
		String redirectUrl = homeUrl + "/" + friendlyUrl 
							+ "?" + RequestConst.ORG_ID + "=" + orgId 
							+ "&" + RequestConst.VIEW_MODE + "=" + viewMode 
							+ "&" + RequestConst.ACTION + "=" + actMode;
		if (certId > 0) {
			redirectUrl += "&" + RequestConst.CERT_ID + "=" + certId;
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
			System.out.println("Cert Mgmt: Error in processing render");
			e.printStackTrace();
		}
		
		return mapping.findForward(getForward(req));
	}
}
