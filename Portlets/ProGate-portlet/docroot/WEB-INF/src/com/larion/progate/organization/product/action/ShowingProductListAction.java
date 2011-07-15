package com.larion.progate.organization.product.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import larion.progate.model.ProGateJournalArticleView;
import larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleViewLocalServiceUtil;

import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.bean.PaginationObject;
import com.larion.progate.common.constants.ConfigParams_RS;
import com.larion.progate.common.constants.RSConstants;
import com.larion.progate.common.constants.URLParameter_RS;
import com.larion.progate.common.utils.ProGateUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.util.PortalUtil;

public class ShowingProductListAction extends ParameterizableViewAction {

	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {

		try {

			HttpServletRequest httpSR = PortalUtil
					.getHttpServletRequest(request);
			HttpServletRequest origReq = PortalUtil
					.getOriginalServletRequest(httpSR);

			int orgId = ParamUtil
					.getInteger(origReq, URLParameter_RS.ORG_ID, 0);
			bean.put(URLParameter_RS.ORG_ID, orgId);

			int viewMode = ParamUtil.getInteger(origReq,
					URLParameter_RS.VIEW_MODE, 0);
			bean.put(URLParameter_RS.VIEW_MODE, viewMode);

			bean.put("isOrgAdmin",
					ProGateUtil.checkActionPermission(request, orgId, viewMode));

			String searchProductName = ParamUtil.getString(request,
					Constants.SEARCH, "");
			bean.put("searchProductName", searchProductName);

			int productId = ParamUtil.getInteger(origReq,
					URLParameter_RS.PRODUCT_ID, 0);

			int productType = ParamUtil.getInteger(origReq,
					URLParameter_RS.PRODUCT_TYPE, 0);
			if (productType == 0) {
				productType = GetterUtil.getInteger(ProGateUtil.getConfigValue(
						request, URLParameter_RS.PRODUCT_TYPE), 0);
			}
			bean.put("_productType", productType);

			int categoryType = ParamUtil.getInteger(origReq,
					URLParameter_RS.PRODUCT_CATEGORY_TYPE, 0);
			if (categoryType == 0) {
				categoryType = GetterUtil.getInteger(ProGateUtil
						.getConfigValue(request,
								URLParameter_RS.PRODUCT_CATEGORY_TYPE), 0);
			}
			bean.put("categoryType", categoryType);

			boolean isOrgProfilePage = (categoryType == 0) ? false : true;
			bean.put("isOrgProfilePage", isOrgProfilePage);

			String orgProfileLink = ProGateUtil.getConfigValue(request,
					ConfigParams_RS.PRODUCT_DETAIL_PAGE_URL);

			orgProfileLink += StringPool.QUESTION + URLParameter_RS.VIEW_MODE
					+ StringPool.EQUAL + 0 + StringPool.AMPERSAND
					+ URLParameter_RS.ORG_ID + StringPool.EQUAL;
			bean.put("orgProfileLink", orgProfileLink);

			int currentPage = ParamUtil.getInteger(origReq,
					URLParameter_RS.CURRENT_PAGE, 1);

			int pageSize = ParamUtil.getInteger(origReq,
					URLParameter_RS.PAGE_SIZE, 20);

			if (productId != 0) { // Showing product details
				bean.put(URLParameter_RS.PRODUCT_ID, productId);

				ProGateJournalArticleView curProduct = ProGateJournalArticleViewLocalServiceUtil
						.getProGateJournalArticleView(productId);
				bean.put("curProduct", curProduct);

				Date today = new Date();

				Date productExpDate = curProduct.getExpiredDate();

				if (productExpDate != null) {
					if (today.before(productExpDate)) {
						bean.put("isExpiredDate", false);
					} else {
						bean.put("isExpiredDate", true);
					}
				} else {
					bean.put("isExpiredDate", false);
				}

				PaginationObject paginationRelatedProduct = null;

				/* Get list of related products */
				List<ProGateJournalArticleView> relateProductList = null;
				System.out.println("categoryType:" + categoryType);
				if (categoryType == 0) {

					paginationRelatedProduct = new PaginationObject("Product",
							ProGateJournalArticleViewLocalServiceUtil
									.countListArticleByOrgIdAndProductType(
											orgId, curProduct.getProductType(),
											ProGateJournalArticleTypesLocalServiceUtil
													.getArticleTypeProduct(),
											false));

					paginationRelatedProduct.paging(currentPage, pageSize);

					relateProductList = ProGateJournalArticleViewLocalServiceUtil
							.getListArticleByOrgIdAndProductType(orgId,
									curProduct.getProductType(),
									ProGateJournalArticleTypesLocalServiceUtil
											.getArticleTypeProduct(), false,
									paginationRelatedProduct.getStartIndex(),
									paginationRelatedProduct.getEndIndex());

				} else {

					paginationRelatedProduct = new PaginationObject("Product",
							ProGateJournalArticleViewLocalServiceUtil
									.countListArticleByOrgIdAndProductType(
											orgId, curProduct.getProductType(),
											ProGateJournalArticleTypesLocalServiceUtil
													.getArticleTypeProduct(),
											categoryType, false));

					paginationRelatedProduct.paging(currentPage, pageSize);

					relateProductList = ProGateJournalArticleViewLocalServiceUtil
							.getListArticleByOrgIdAndProductType(orgId,
									curProduct.getProductType(),
									ProGateJournalArticleTypesLocalServiceUtil
											.getArticleTypeProduct(),
									categoryType, false,
									paginationRelatedProduct.getStartIndex(),
									paginationRelatedProduct.getEndIndex());
				}

				
				
				bean.put("paginationRelatedProduct", paginationRelatedProduct);
				bean.put("relateProductList", relateProductList);
				bean.put("lastIndexRelateProductList", relateProductList.size());
				bean.put("relateProductListSize", relateProductList.size() - 1);
				
				
				
				bean.put(RSConstants.VIEW_NAME,
						"organization/product/viewProduct");
			} else if (productType != 0) { // Showing product list by type

				PaginationObject paginationProduct = null;

				List<ProGateJournalArticleView> productList = null;

				if (categoryType == 0) {

					paginationProduct = new PaginationObject("Product",
							ProGateJournalArticleViewLocalServiceUtil
									.countListArticleByOrgIdAndProductType(
											orgId, productType,
											ProGateJournalArticleTypesLocalServiceUtil
													.getArticleTypeProduct(),
											false));
					paginationProduct.paging(currentPage, pageSize);

					productList = ProGateJournalArticleViewLocalServiceUtil
							.getListArticleByOrgIdAndProductType(orgId,
									productType,
									ProGateJournalArticleTypesLocalServiceUtil
											.getArticleTypeProduct(), false,
									paginationProduct.getStartIndex(),
									paginationProduct.getEndIndex());
				} else {

					paginationProduct = new PaginationObject("Product",
							ProGateJournalArticleViewLocalServiceUtil
									.countListArticleByOrgIdAndProductType(
											orgId, productType,
											ProGateJournalArticleTypesLocalServiceUtil
													.getArticleTypeProduct(),
											categoryType, false));

					paginationProduct.paging(currentPage, pageSize);

					productList = ProGateJournalArticleViewLocalServiceUtil
							.getListArticleByOrgIdAndProductType(orgId,
									productType,
									ProGateJournalArticleTypesLocalServiceUtil
											.getArticleTypeProduct(),
									categoryType, false, paginationProduct
											.getStartIndex(), paginationProduct
											.getEndIndex());
				}
				bean.put("paginationProduct", paginationProduct);
				bean.put("productList", productList);
				bean.put("lastIndexProductList", productList.size());

				bean.put(RSConstants.VIEW_NAME,
						"organization/product/showingProductListByType");
			} else {
				String numOfItem = ProGateUtil.getConfigValue(request,
						ConfigParams_RS.NUM_OF_ITEM);

				// Get list of products
				List<ProGateJournalArticleView> newProductList = null;

				if (categoryType == 0) {
					newProductList = ProGateJournalArticleViewLocalServiceUtil
							.getListArticleByOrgIdAndProductType(
									orgId,
									1, // 1 - New Product
									ProGateJournalArticleTypesLocalServiceUtil
											.getArticleTypeProduct(), false, 0,
									Integer.parseInt(numOfItem));
				} else {
					newProductList = ProGateJournalArticleViewLocalServiceUtil
							.getListArticleByOrgIdAndProductType(
									orgId,
									1, // 1 - New Product
									ProGateJournalArticleTypesLocalServiceUtil
											.getArticleTypeProduct(),
									categoryType, false, 0, Integer
											.parseInt(numOfItem));
				}
				bean.put("newProductList", newProductList);
				bean.put("lastIndexNewProductList", newProductList.size());

				List<ProGateJournalArticleView> bestSellProductList = null;
				if (categoryType == 0) {
					bestSellProductList = ProGateJournalArticleViewLocalServiceUtil
							.getListArticleByOrgIdAndProductType(
									orgId,
									2, // 2 - Best Seller Product
									ProGateJournalArticleTypesLocalServiceUtil
											.getArticleTypeProduct(), false, 0,
									Integer.parseInt(numOfItem));
				} else {
					bestSellProductList = ProGateJournalArticleViewLocalServiceUtil
							.getListArticleByOrgIdAndProductType(
									orgId,
									2, // 2 - Best Seller Product
									ProGateJournalArticleTypesLocalServiceUtil
											.getArticleTypeProduct(),
									categoryType, false, 0, Integer
											.parseInt(numOfItem));
				}
				bean.put("bestSellProductList", bestSellProductList);
				bean.put("lastIndexBestSellProductList",
						bestSellProductList.size());

				List<ProGateJournalArticleView> promoteProductList = null;
				if (categoryType == 0) {
					promoteProductList = ProGateJournalArticleViewLocalServiceUtil
							.getListArticleByOrgIdAndProductType(
									orgId,
									3, // 3 - Promote Product
									ProGateJournalArticleTypesLocalServiceUtil
											.getArticleTypeProduct(), false, 0,
									Integer.parseInt(numOfItem));
				} else {
					promoteProductList = ProGateJournalArticleViewLocalServiceUtil
							.getListArticleByOrgIdAndProductType(
									orgId,
									3, // 3 - Promote Product
									ProGateJournalArticleTypesLocalServiceUtil
											.getArticleTypeProduct(),
									categoryType, false, 0, Integer
											.parseInt(numOfItem));
				}
				bean.put("promoteProductList", promoteProductList);
				bean.put("lastIndexPromoteProductList",
						promoteProductList.size());
			}

			ProGateUtil.setConfigParamsToBean(request, bean);

			String currentURL = PortalUtil.getCurrentURL(request);

			String paramViewMode = URLParameter_RS.VIEW_MODE + StringPool.EQUAL;
			int indexViewMode = currentURL.indexOf(paramViewMode);
			if (indexViewMode != -1) {
				currentURL = currentURL.substring(0, indexViewMode
						+ paramViewMode.length() + 1);
			} else {
				int indexQuestion = currentURL.indexOf(StringPool.QUESTION);
				if (indexQuestion != -1) {
					currentURL = currentURL.substring(0, indexQuestion);
				}
			}

			String productByTypeLink = currentURL;

			if (productByTypeLink.indexOf(StringPool.QUESTION) == -1) {
				productByTypeLink += StringPool.QUESTION
						+ URLParameter_RS.PRODUCT_TYPE + StringPool.EQUAL;
			} else {
				productByTypeLink += StringPool.AMPERSAND
						+ URLParameter_RS.PRODUCT_TYPE + StringPool.EQUAL;
			}
			bean.put("productByTypeLink", productByTypeLink);

			String productDetailLink = currentURL;

			if (productDetailLink.indexOf(StringPool.QUESTION) == -1) {
				productDetailLink += StringPool.QUESTION
						+ URLParameter_RS.PRODUCT_ID + StringPool.EQUAL;
			} else {
				productDetailLink += StringPool.AMPERSAND
						+ URLParameter_RS.PRODUCT_ID + StringPool.EQUAL;
			}
			bean.put("productDetailLink", productDetailLink);

			String searchURL = currentURL;
			String pagingURL = "";

			if (productId != 0) {
				pagingURL = searchURL = productDetailLink + productId;
			} else if (productType != 0) {
				pagingURL = searchURL = productByTypeLink + productType;
			}
			bean.put("searchURL", searchURL);

			if (!"".equals(searchProductName)) {
				pagingURL += StringPool.AMPERSAND + URLParameter_RS.SEARCH
						+ StringPool.EQUAL + searchProductName;
			}
			bean.put("pagingURL", pagingURL);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
