package com.larion.progate.organization.product.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import larion.progate.model.ProGateCurrencyTypes;
import larion.progate.model.ProGateJournalArticle;
import larion.progate.model.ProGateJournalArticleView;
import larion.progate.service.ProGateCurrencyTypesLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleViewLocalServiceUtil;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

import com.larion.progate.common.constants.ConfigParams_RS;
import com.larion.progate.common.constants.Request;
import com.larion.progate.common.constants.URLParameter_RS;
import com.larion.progate.common.utils.Functions;
import com.larion.progate.common.utils.ProGateUtil;
import com.larion.progate.organization.product.constants.JournalArticle_RS;
import com.larion.progate.organization.product.constants.ProductService_RS;

import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

public class HandlingProductController extends ParameterizableViewController {

	@Override
	protected void handleActionRequestInternal(ActionRequest request,
			ActionResponse response) throws Exception {

		UploadPortletRequest uploadPortlet = PortalUtil
				.getUploadPortletRequest(request);

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		Map<String, Object> bean = new HashMap<String, Object>();

		int orgID = ParamUtil.getInteger(uploadPortlet, URLParameter_RS.ORG_ID);
		bean.put(URLParameter_RS.ORG_ID, orgID);
		System.out.println("orgID: " + orgID);

		int viewMode = ParamUtil.getInteger(uploadPortlet,
				URLParameter_RS.VIEW_MODE);
		bean.put(URLParameter_RS.VIEW_MODE, viewMode);
		System.out.println("viewMode: " + viewMode);

		String returnToFullPageURL = ParamUtil.getString(uploadPortlet,
				URLParameter_RS.RETURN_TO_FULL_PAGE_URL);
		bean.put(URLParameter_RS.RETURN_TO_FULL_PAGE_URL, returnToFullPageURL);
		System.out.println("returnToFullPageURL: " + returnToFullPageURL);

		String cmd = ParamUtil.getString(uploadPortlet, Constants.CMD);

		int journalArticleId = ParamUtil.getInteger(uploadPortlet,
				JournalArticle_RS.JA_ID);
		System.out.println("journalArticleId: " + journalArticleId);

		if (Constants.DELETE.equals(cmd)) {

			ProGateJournalArticleViewLocalServiceUtil
					.deleteProGateArticleViewObject(ProGateJournalArticleViewLocalServiceUtil
							.getProGateJournalArticleView(journalArticleId));

			response.sendRedirect(returnToFullPageURL);
		}

		String productName = uploadPortlet
				.getParameter(JournalArticle_RS.JA_TITLE);
		System.out.println("productName: " + productName);

		String articleType = ProGateJournalArticleTypesLocalServiceUtil
				.getArticleTypeProduct();
		System.out.println("articleType: " + articleType);

		String description = uploadPortlet
				.getParameter(JournalArticle_RS.JA_DESCRIPTION);
		System.out.println("description: " + description);

		Double dOriginalPrice = ParamUtil.getDouble(uploadPortlet,
				ProductService_RS.PS_PRICE);
		System.out.println("dOriginalPrice: " + dOriginalPrice);

		Integer productAmount = Integer.parseInt(uploadPortlet
				.getParameter(ProductService_RS.PS_PRODUCT_AMOUNT));

		Date productExpDate = ParamUtil.getDate(uploadPortlet,
				ProductService_RS.PS_PRODUCT_EXPIRED_DATE,
				new SimpleDateFormat("dd/MM/yyyy"));

		Integer currencyId = Integer.parseInt(uploadPortlet
				.getParameter(ProductService_RS.PS_CURRENCY_ID));
		System.out.println("currencyId: " + currencyId);

		Integer productType = Integer.parseInt(uploadPortlet
				.getParameter(ProductService_RS.PS_PRODUCT_TYPE));
		System.out.println("productType: " + productType);

		Double promoteValue = ParamUtil.getDouble(uploadPortlet,
				ProductService_RS.PS_DISCOUNT);
		System.out.println("promoteValue: " + promoteValue);

		boolean isBestSelling = false;// ParamUtil.getBoolean(uploadPortlet,
										// JournalArticle_RS.JA_TITLE);
		System.out.println("isBestSelling: " + isBestSelling);

		boolean isHot = Boolean.parseBoolean(uploadPortlet
				.getParameter(ProductService_RS.PS_IS_HOT));
		System.out.println("isHot: " + isHot);

		String content = ParamUtil.getString(uploadPortlet,
				JournalArticle_RS.JA_CONTENT);
		// uploadPortlet.getParameter(JournalArticle_RS.JA_CONTENT);
		System.out.println("content: " + content);

		String smallImagePath = Functions.getPathOfUploadImage(request,
				response, uploadPortlet, JournalArticle_RS.JA_SMALL_IMAGE_URL);

		System.out.println("smallImagePath: " + smallImagePath);
		String bigImagePath = smallImagePath;

		if (Constants.UPDATE.equals(cmd)) {

			ProGateJournalArticleView proGateJournalArticleView = ProGateJournalArticleViewLocalServiceUtil
					.getProGateJournalArticleView(journalArticleId);

			proGateJournalArticleView.setTitle(productName);
			proGateJournalArticleView.setArticleType(4);
			proGateJournalArticleView.setDescription(description);
			proGateJournalArticleView.setPrice(dOriginalPrice);
			proGateJournalArticleView.setCurrencyId(currencyId);
			proGateJournalArticleView.setProductType(productType);
			proGateJournalArticleView.setDiscount(promoteValue);
			proGateJournalArticleView.setIsHot(isHot);
			proGateJournalArticleView.setContent(content);
			proGateJournalArticleView.setAmount(productAmount);
			proGateJournalArticleView.setExpiredDate(productExpDate);

			if (!"".endsWith(smallImagePath) && smallImagePath != null) {
				proGateJournalArticleView.setSmallImageUrl(smallImagePath);
				proGateJournalArticleView.setBigImageUrl(smallImagePath);
			}

			ProGateJournalArticleViewLocalServiceUtil
					.updateProGateArticleViewObject(proGateJournalArticleView);

			response.setRenderParameter(Request.MESSAGE_TXT,
					"warning.product.global.update.success");

		} else if (Constants.ADD.equals(cmd)) {

			String titleUrl = ProGateUtil.buildRedirectUrl(
					request,
					ConfigParams_RS.REDIRECT_URL,
					new String[] { URLParameter_RS.ORG_ID,
							URLParameter_RS.VIEW_MODE },
					new String[] { String.valueOf(orgID),
							String.valueOf(viewMode) });

			ProGateJournalArticle product = ProGateJournalArticleLocalServiceUtil
					.createNewProduct(Integer.toString(orgID),
							(int) themeDisplay.getUserId(), productName,
							titleUrl, articleType, description, dOriginalPrice,
							currencyId.intValue(), productType.intValue(),
							promoteValue.floatValue(), isBestSelling, isHot,
							content, smallImagePath, bigImagePath,
							productAmount, productExpDate);

			journalArticleId = product.getPrimaryKey();

			cmd = Constants.UPDATE;

			response.setRenderParameter(Request.MESSAGE_TXT,
					"warning.product.global.add.success");
		}

		response.setRenderParameter(URLParameter_RS.ORG_ID,
				String.valueOf(orgID));
		response.setRenderParameter(URLParameter_RS.VIEW_MODE,
				String.valueOf(viewMode));
		response.setRenderParameter(URLParameter_RS.RETURN_TO_FULL_PAGE_URL,
				returnToFullPageURL);
		response.setRenderParameter(JournalArticle_RS.JA_ID,
				String.valueOf(journalArticleId));
		response.setRenderParameter(Constants.CMD, cmd);
		response.setRenderParameter("action", "handleProduct");
	}

	@Override
	protected ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {

		Map<String, Object> bean = new HashMap<String, Object>();

		int orgID = ParamUtil.getInteger(request, URLParameter_RS.ORG_ID);
		bean.put(URLParameter_RS.ORG_ID, orgID);

		int viewMode = ParamUtil.getInteger(request, URLParameter_RS.VIEW_MODE);
		bean.put(URLParameter_RS.VIEW_MODE, viewMode);

		String returnToFullPageURL = ParamUtil.getString(request,
				URLParameter_RS.RETURN_TO_FULL_PAGE_URL);
		bean.put(URLParameter_RS.RETURN_TO_FULL_PAGE_URL, returnToFullPageURL);

		String cmd = ParamUtil.getString(request, Constants.CMD);
		bean.put(Constants.CMD, cmd);

		int journalArticleId = ParamUtil.getInteger(request,
				JournalArticle_RS.JA_ID);

		List<ProGateCurrencyTypes> currencyList = ProGateCurrencyTypesLocalServiceUtil
				.getProGateCurrencyTypeses(0,
						ProGateCurrencyTypesLocalServiceUtil
								.getProGateCurrencyTypesesCount());
		bean.put("currencyList", currencyList);

		if (Constants.UPDATE.equals(cmd)) {
			String msgTxt = ParamUtil.getString(request, Request.MESSAGE_TXT);
			bean.put(Request.MESSAGE_TXT, msgTxt);

			ProGateJournalArticleView product = ProGateJournalArticleViewLocalServiceUtil
					.getProGateJournalArticleView(journalArticleId);
			bean.put("product", product);
			Date today = new Date();

			Date productExpDate = product.getExpiredDate();

			if (productExpDate != null) {
				if (today.before(productExpDate)) {
					bean.put("isExpiredDate", false);
				} else {
					bean.put("isExpiredDate", true);
				}
			} else {
				bean.put("isExpiredDate", false);
			}

		}

		return new ModelAndView(this.getViewName(), "bean", bean);
	}
}
