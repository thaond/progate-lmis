package com.larion.progate.journal.action;

import java.util.ArrayList;
import java.util.List;

import com.larion.progate.common.action.ConfigAction;
import com.larion.progate.common.constants.ConfigParams_RS;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.tags.TagsEntryException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import larion.progate.model.ProGateJournalArticle;
import larion.progate.model.ProGateJournalArticleTypes;
import larion.progate.service.ProGateJournalArticleLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil;

public class ConfiguratingJournalArticlesAction extends ConfigAction {

	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		try {
			String portletResource = ParamUtil.getString(actionRequest,
					"portletResource");

			PortletPreferences preferences = PortletPreferencesFactoryUtil
					.getPortletSetup(actionRequest, portletResource);

			List<String> params = new ArrayList<String>();
			params.add(ConfigParams_RS.JOURNAL_TYPE);

			String journalAcricleTypeText = ParamUtil.getString(actionRequest,
					ConfigParams_RS.JOURNAL_ARTICLES_TYPE_TEXT, "");

			if (!"".equals(journalAcricleTypeText)) {
				ProGateJournalArticleTypes journalArticleType = ProGateJournalArticleTypesLocalServiceUtil
						.createProGateJournalArticleTypes(journalAcricleTypeText);
				System.out.println("journalArticleTypeId: "
						+ journalArticleType.getPrimaryKey());

				preferences.setValue(ConfigParams_RS.JOURNAL_ARTICLES_TYPE,
						journalArticleType.getJournalArticleTypesId()
								.toString());
			} else {
				params.add(ConfigParams_RS.JOURNAL_ARTICLES_TYPE);
			}

			for (String param : params) {
				setValueOfParamToPortletPreferences(actionRequest, preferences,
						param);
			}

			if (SessionErrors.isEmpty(actionRequest)) {
				preferences.store();
				SessionMessages.add(actionRequest,
						portletConfig.getPortletName() + ".doConfigure");
			}
		} catch (Exception e) {
			if (e instanceof TagsEntryException) {
				SessionErrors.add(actionRequest, e.getClass().getName(), e);
			} else {
				throw e;
			}
		}
	}

	@Override
	public String render(PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
			throws Exception {
		return "/html/portlet/journal/configurateJournal.jsp";
	}
}