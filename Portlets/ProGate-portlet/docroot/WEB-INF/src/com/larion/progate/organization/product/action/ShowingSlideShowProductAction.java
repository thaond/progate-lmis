package com.larion.progate.organization.product.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import larion.progate.model.ProGateJournalArticleSlideShow;
import larion.progate.service.ProGateJournalArticleSlideShowLocalServiceUtil;

import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.constants.ConfigParams_RS;
import com.larion.progate.common.constants.URLParameter_RS;
import com.larion.progate.common.utils.ProGateUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.util.PortalUtil;

public class ShowingSlideShowProductAction extends ParameterizableViewAction {

	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {
		HttpServletRequest httpSR = PortalUtil.getHttpServletRequest(request);
		HttpServletRequest origReq = PortalUtil
				.getOriginalServletRequest(httpSR);

		int orgId = ParamUtil.getInteger(origReq, URLParameter_RS.ORG_ID, 0);
		bean.put(URLParameter_RS.ORG_ID, orgId);

		int viewMode = ParamUtil.getInteger(origReq, URLParameter_RS.VIEW_MODE,
				0);
		bean.put(URLParameter_RS.VIEW_MODE, viewMode);

		bean.put("isOrgAdmin",
				ProGateUtil.checkActionPermission(request, orgId, viewMode));

		int slideShowCount = ProGateJournalArticleSlideShowLocalServiceUtil
				.countProGateJournalArticleSlideShows(orgId);
		List<ProGateJournalArticleSlideShow> _slideShowList = ProGateJournalArticleSlideShowLocalServiceUtil
				.getProGateJournalArticleSlideShows(orgId, 0, slideShowCount);

		if (slideShowCount > 5) {
			slideShowCount = 5;
		}
		bean.put("slideShowCount", slideShowCount);

		List<ProGateJournalArticleSlideShow> slideShowList = new ArrayList<ProGateJournalArticleSlideShow>();

		int index = 0;
		for (ProGateJournalArticleSlideShow slideShow : _slideShowList) {
			if (!"".equals(slideShow.getImageUrl())) {
				slideShowList.add(slideShow);
				index += 1;
			}
			if (index == 5) {
				break;
			}
		}
		bean.put("slideShowList", slideShowList);
		// ProGateJournalArticleSlideShow s; s.getImageUrl()
		ProGateUtil.setConfigParamsToBean(request, bean);

		String productDetailLink = PortalUtil.getPortalURL(request)
				+ StringPool.SLASH
				+ bean.get(ConfigParams_RS.PRODUCT_DETAIL_PAGE_URL)
				+ StringPool.QUESTION + URLParameter_RS.ORG_ID
				+ StringPool.EQUAL + orgId + StringPool.AMPERSAND
				+ URLParameter_RS.VIEW_MODE + StringPool.EQUAL + viewMode
				+ StringPool.AMPERSAND + URLParameter_RS.PRODUCT_ID
				+ StringPool.EQUAL;
		bean.put("productDetailLink", productDetailLink);
	}

}
