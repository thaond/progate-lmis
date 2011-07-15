package com.larion.progate.developHistory.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;

import larion.progate.model.ProGateJournalArticle;
import larion.progate.service.ProGateJournalArticleLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.larion.progate.common.constants.URLParameter_RS;
import com.larion.progate.developHistory.constants.DevHistory_Const;
import com.larion.progate.overview.constants.Overview_Const;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;

public class AddDevHistoryAction extends PortletAction {

	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

		
		int addedSuccess = 0;
		int orgId = ParamUtil.getInteger(actionRequest,URLParameter_RS.ORG_ID);
		int viewMode =Integer.parseInt(actionRequest.getParameter(URLParameter_RS.VIEW_MODE));
		String history = ParamUtil.getString(actionRequest,DevHistory_Const.HISTORY);
		String currentUrl = ParamUtil.getString(actionRequest,DevHistory_Const.CURRENT_URL);
		

		try {
			
			// Get User
			ServiceContext sc = ServiceContextFactory.getInstance(this
					.getClass().getName(), actionRequest);
			com.liferay.portal.model.User user = UserLocalServiceUtil
					.getUser(sc.getUserId());
			int userId = (int) user.getUserId();

			String historyType = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeOrgHistory();
			int end = ProGateJournalArticleLocalServiceUtil.countArticleByType(orgId, historyType, "");
			List<ProGateJournalArticle> listHistory = ProGateJournalArticleLocalServiceUtil
					.getListProGateArticles(orgId, historyType, "", 0, end);
			if((listHistory != null) && (listHistory.size() != 0)){
				ProGateJournalArticle historyArticle =listHistory.get(0);
				historyArticle.setContent(history);
				ProGateJournalArticleLocalServiceUtil.updateProGateJournalArticle(historyArticle, true);
			}else{
				ProGateJournalArticle historyArtical = ProGateJournalArticleLocalServiceUtil.createNewArticle(Integer.toString(orgId), userId, "History", historyType,"", history, "", "", "");
			}
			addedSuccess = 1; // success
			

		} catch (Exception e) {
			addedSuccess = 2; // Error

		}
		actionResponse.setRenderParameter(URLParameter_RS.ORG_ID, Integer.toString(orgId));
		actionResponse.setRenderParameter(URLParameter_RS.VIEW_MODE, Integer.toString(viewMode));
		
		actionRequest.setAttribute(DevHistory_Const.ADDED_SUCCESS, addedSuccess);
		actionResponse.setRenderParameter(DevHistory_Const.HISTORY, history);
		actionResponse.setRenderParameter(DevHistory_Const.CURRENT_URL, currentUrl);
		setForward(actionRequest, "portlet.developHistory.add");

	}
}
