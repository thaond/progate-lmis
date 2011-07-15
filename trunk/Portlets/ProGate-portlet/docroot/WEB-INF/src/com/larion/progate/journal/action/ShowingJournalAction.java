package com.larion.progate.journal.action;

import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import larion.progate.model.ProGateJournalArticle;
import larion.progate.model.ProGateJournalArticleTypes;
import larion.progate.service.ProGateJournalArticleLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil;
import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.bean.PaginationObject;
import com.larion.progate.common.constants.ConfigParams_RS;
import com.larion.progate.common.constants.RSConstants;
import com.larion.progate.common.constants.Request;
import com.larion.progate.common.constants.URLParameter_RS;
import com.larion.progate.common.utils.ProGateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.util.PortalUtil;

public class ShowingJournalAction extends ParameterizableViewAction {

	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {

		try {

			HttpServletRequest httpSR = PortalUtil
					.getHttpServletRequest(request);
			HttpServletRequest origReq = PortalUtil
					.getOriginalServletRequest(httpSR);

			int orgId = ProGateUtil.getOrganizationId(origReq);

			bean.put(URLParameter_RS.ORG_ID, orgId);

			int articleId = ParamUtil.getInteger(origReq,
					URLParameter_RS.ARTICLE_ID, 0);

			bean.put("isAdminOfOrg", ProGateUtil.isAdminOfOrg(request, orgId));

			String journalType = ProGateUtil.getConfigValue(request,
					ConfigParams_RS.JOURNAL_TYPE);
			bean.put("journalType", journalType);

			int journalArticleType = GetterUtil.getInteger(ProGateUtil
					.getConfigValue(request,
							ConfigParams_RS.JOURNAL_ARTICLES_TYPE), 0);
			bean.put("journalArticleType", journalArticleType);

			String journalArticleTypeName = String.valueOf(journalArticleType);

			ProGateJournalArticleTypes journalArticleTypeObject = ProGateJournalArticleTypesLocalServiceUtil
					.getProGateJournalArticleTypes(journalArticleType);

			if (journalArticleTypeObject != null) {

				journalArticleTypeName = journalArticleTypeObject.getName();

				bean.put("journalArticleTypeName", journalArticleTypeName);
			}

			if (Request.JOURNAL_CONTENT.equals(journalType)) {

				List<ProGateJournalArticle> journalArticles = ProGateJournalArticleLocalServiceUtil
						.getListProGateArticles(orgId, journalArticleTypeName,
								"", 0, 1);

				if (journalArticles != null && journalArticles.size() > 0) {
					articleId = journalArticles.get(0).getJournalArticleId();
				}
			}

			bean.put(URLParameter_RS.ARTICLE_ID, orgId);

			if (articleId != 0) {
				ProGateJournalArticle journalArticle = ProGateJournalArticleLocalServiceUtil
						.getProGateJournalArticle(articleId);
				bean.put("journalArticle", journalArticle);

				bean.put(RSConstants.VIEW_NAME, "journal/showJournalContent");
			} else {
				PaginationObject paginationArticles = new PaginationObject(
						"Articles",
						ProGateJournalArticleLocalServiceUtil
								.countArticleByType(orgId,
										journalArticleTypeName, ""));
				paginationArticles.paging(request);
				bean.put("paginationArticles", paginationArticles);

				List<ProGateJournalArticle> journalArticles = ProGateJournalArticleLocalServiceUtil
						.getListProGateArticles(orgId, journalArticleTypeName,
								"", paginationArticles.getStartIndex(),
								paginationArticles.getEndIndex());

				bean.put("journalArticles", journalArticles);

				bean.put(RSConstants.VIEW_NAME, "journal/showJournalArticles");
			}

			String currentURL = PortalUtil.getCurrentURL(request);

			String articleDetailLink = currentURL;

			if (articleDetailLink.indexOf(StringPool.QUESTION) == -1) {
				articleDetailLink += StringPool.QUESTION
						+ URLParameter_RS.ORG_ID + StringPool.EQUAL + orgId;
			} else {
				articleDetailLink += StringPool.AMPERSAND
						+ URLParameter_RS.ARTICLE_ID + StringPool.EQUAL;
			}
			bean.put("articleDetailLink", articleDetailLink);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}