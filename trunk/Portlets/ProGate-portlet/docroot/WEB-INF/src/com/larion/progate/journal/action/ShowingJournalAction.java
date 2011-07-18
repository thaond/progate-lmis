package com.larion.progate.journal.action;

import java.text.SimpleDateFormat;
import java.util.Date;
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

			String articleDetailLink = "";

			if (currentURL.indexOf(StringPool.QUESTION) == -1) {
				articleDetailLink = currentURL;
			} else {
				articleDetailLink = currentURL.substring(0,
						currentURL.indexOf(StringPool.QUESTION));
			}

			articleDetailLink += StringPool.QUESTION + URLParameter_RS.ORG_ID
					+ StringPool.EQUAL + orgId + StringPool.AMPERSAND
					+ URLParameter_RS.ARTICLE_ID + StringPool.EQUAL;

			bean.put("articleDetailLink", articleDetailLink);

			// Show near news
			int isShowNearNews = GetterUtil
					.getInteger(ProGateUtil.getConfigValue(request,
							ConfigParams_RS.IS_SHOW_NEAR_NEWS));

			bean.put("isShowNearNews", isShowNearNews);

			if (isShowNearNews == 1) {
				StringBuilder announcementLinks = getArticleLinksByType(orgId,
						"Org_thongbao", articleDetailLink);

				StringBuilder upcomingEventLinks = getArticleLinksByType(orgId,
						"Org_sukiensaptoi", articleDetailLink);

				bean.put("announcementLinks", announcementLinks);
				bean.put("upcomingEventLinks", upcomingEventLinks);

				String portalURL = PortalUtil.getPortalURL(request);

				bean.put(
						"announcementLink",
						portalURL
								+ "/tochuc/portal/thong-tin-noi-bo/tin-tuc-va-su-kien/thong-bao?orgId="
								+ orgId);

				bean.put("upcomingEventLink",
						"/tochuc/portal/thong-tin-noi-bo/tin-tuc-va-su-kien/su-kien-sap-toi?orgId="
								+ orgId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public StringBuilder getArticleLinksByType(int orgId,
			String journalArticleTypeName, String articleDetailLink)
			throws Exception {
		StringBuilder links = new StringBuilder();

		List<ProGateJournalArticle> journalArticles = ProGateJournalArticleLocalServiceUtil
				.getListProGateArticles(orgId, journalArticleTypeName, "", 0, 1);

		int count = 0;

		for (ProGateJournalArticle journalArticle : journalArticles) {

			links.append("<img src='/ProGate-portlet/images/bullet.jpg' alt=''></img>&nbsp;");
			links.append("<a class='hotnews' href=\"");

			links.append(articleDetailLink
					+ journalArticle.getJournalArticleId() + "\"");

			links.append(">");
			links.append(journalArticle.getTitle());
			links.append("</a>&nbsp;&nbsp;");
			links.append("<span style='color: Chocolate'>(");

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			links.append(sdf.format(journalArticle.getUpdatedAt()));

			links.append(")</span>");

			if (isNew(journalArticle.getUpdatedAt(), 14)) {
				links.append("<img src='/ProGate-portlet/images/new.gif' alt=''></img>");
			}
			links.append("<br /><br />");

			count++;

			if (count == 6) {
				break;
			}
		}

		return links;
	}

	public boolean isNew(Date date, int days) {
		Date today = new Date();
		long rangeTime = today.getTime() - (long) days * 24 * 60 * 60 * 1000;

		long time = date.getTime();

		if (time >= rangeTime) {
			return true;
		}

		return false;
	}
}