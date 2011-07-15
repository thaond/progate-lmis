package com.larion.progate.productOverview.action;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.larion.progate.common.constants.*;
import com.larion.progate.common.utils.ProGateUtil;

import com.larion.progate.productOverview.constants.*;
import com.larion.progate.paging.constants.PagingConst;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

public class ProductList extends ParameterizableViewAction {

	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {

		try {
			//System.out.println("Inside handleRenderRequestInternal() in " + this.getClass().getName());
			
			HttpServletRequest httpSR = PortalUtil.getHttpServletRequest(request);
			HttpServletRequest origReq = PortalUtil.getOriginalServletRequest(httpSR);
			
			int orgId = 0;
			bean.put(URLParameter_RS.ORG_ID, orgId);
			
			int productId = ParamUtil.getInteger(origReq, URLParameter_RS.PRODUCT_ID, 0);
			
			int categoryType = 0;
			int productType = 0;
			
			productType = ParamUtil.getInteger(origReq, URLParameter_RS.PRODUCT_TYPE, 0);
			
			String displayStyle = ProGateUtil.getConfigValue(request, RequestConst.DISPLAY_STYLE);
			bean.put("displayStyle", displayStyle);
			
			bean.put("productView", RequestConst.PRODUCT_LIST);
			bean.put("courseView", RequestConst.COURSE_LIST);
			bean.put("examView", RequestConst.EXAM_LIST);
			bean.put("courseHomeView", RequestConst.COURSE_LIST_OVERVIEW);
			bean.put("examHomeView", RequestConst.EXAM_LIST_OVERVIEW);
			
			if (RequestConst.PRODUCT_LIST.equals(displayStyle)) {
				categoryType = 1;
			} else if (RequestConst.COURSE_LIST.equals(displayStyle) || 
					RequestConst.COURSE_LIST_OVERVIEW.equals(displayStyle)) {
				categoryType = 2;
			} else if (RequestConst.EXAM_LIST.equals(displayStyle) || 
					RequestConst.EXAM_LIST_OVERVIEW.equals(displayStyle)) {
				categoryType = 3;
			}
			
			String displaySubStyle = ProGateUtil.getConfigValue(request, RequestConst.DISPLAY_SUB_STYLE);
			bean.put("displaySubStyle", displaySubStyle);
			
			if (RequestConst.NEW_PRODUCT_LIST.equals(displaySubStyle)) {
				productType = 1;
			} else if (RequestConst.SELLING_PRODUCT_LIST.equals(displaySubStyle)) {
				productType = 2;
			} else if (RequestConst.DISCOUNT_PRODUCT_LIST.equals(displaySubStyle)) {
				productType = 3;
			}
			bean.put("productType", productType);
			
			String friendlyUrl = ProGateUtil.getConfigValue(request, RequestConst.FRIENDLY_URL);
			String newProductUrl = ProGateUtil.getConfigValue(request, RequestConst.NEW_PRODUCT_URL);
			String sellingProductUrl = ProGateUtil.getConfigValue(request, RequestConst.SELLING_PRODUCT_URL);
			String discountProductUrl = ProGateUtil.getConfigValue(request, RequestConst.DISCOUNT_PRODUCT_URL);
			
			bean.put(RequestConst.FRIENDLY_URL, friendlyUrl);
			bean.put(RequestConst.NEW_PRODUCT_URL, newProductUrl);
			bean.put(RequestConst.SELLING_PRODUCT_URL, sellingProductUrl);
			bean.put(RequestConst.DISCOUNT_PRODUCT_URL, discountProductUrl);
						
			if (productId != 0) { // Showing product details
				bean.put(URLParameter_RS.PRODUCT_ID, productId);
				
				ProGateJournalArticleView currentProduct = ProGateJournalArticleViewLocalServiceUtil
						.getProGateJournalArticleView(productId);
				bean.put("currentProduct", currentProduct);
				
				/* Get list of related products */
				List<ProGateJournalArticleView> relatedProductList = ProGateJournalArticleViewLocalServiceUtil
						.getListArticleByOrgIdAndProductType(orgId, 
								currentProduct.getProductType(), 
								ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeProduct(), 
								categoryType, 
								false, 0, RequestConst.MAX_RELATED_PRODUCT);
				bean.put("relatedProductList", relatedProductList);
				
				//System.out.println("relatedProductList.count = " + relatedProductList.size());
				
				bean.put(RSConstants.VIEW_NAME, "product_overview/productDetail");
				
			} else if (productType != 0) { // List product by type				
				List<ProGateJournalArticleView> productList = null;
				
				// Get total records
				int numRecords = ProGateJournalArticleViewLocalServiceUtil
								.countListArticleByOrgIdAndProductType(orgId, 
										productType, 
										ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeProduct(), 
										categoryType, false);
				
				int increment = Integer.parseInt(ProGateUtil.getConfigValue(request, RequestConst.NUM_OF_ITEM));
				bean.put("numOfRecords", increment);
				
				// Get page size
				int pageSize = ParamUtil.getInteger(request, PagingConst.PAGE_SIZE, RequestConst.INCREMENT_CONST);		
				
				// Get current page
				int currentPage = ParamUtil.getInteger(request, PagingConst.GOTO_PAGE, 1);
				
				//System.out.println("currentPage = " + currentPage + "; pageSize = " + pageSize);
				
				PaginationObject productPaging = new PaginationObject("productPaging", numRecords);
				productPaging.paging(currentPage, pageSize);				
				bean.put("productPaging", productPaging);
				
				//System.out.println("getStartIndex = " + productPaging.getStartIndex() + "; getEndIndex = " + productPaging.getEndIndex());
				
				productList = ProGateJournalArticleViewLocalServiceUtil
								.getListArticleByOrgIdAndProductType(orgId,
										productType,
										ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeProduct(), 
										categoryType, 
										false, productPaging.getStartIndex(), productPaging.getEndIndex());
	
				if (productList == null) {
					productList = new ArrayList<ProGateJournalArticleView>();
				}
				bean.put("productList", productList);
				bean.put("lastIndexProductList", productList.size());
				
				System.out.println("productList.count = " + productList.size());
								
				bean.put(RSConstants.VIEW_NAME, "product_overview/productListByType");				
			} else {			
				String maxItems = ProGateUtil.getConfigValue(request, RequestConst.MAX_ITEM_TO_SHOW);
	
				if (RequestConst.COURSE_LIST_OVERVIEW.equals(displayStyle) ||
						RequestConst.EXAM_LIST_OVERVIEW.equals(displayStyle)) {
					// Get lists of products
					List<ProGateJournalArticleView> productList = ProGateJournalArticleViewLocalServiceUtil
							.getListArticleByOrgIdAndProductType(
									orgId,
									0, // 0 - All Product
									ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeProduct(), 
									categoryType, 
									false, 0, Integer.parseInt(maxItems));
					
					bean.put("productList", productList);
					
					//System.out.println("productList.count = " + productList.size());
					
					bean.put(RSConstants.VIEW_NAME, "product_overview/courseListHome");
				} else {
					// Get lists of products
					List<ProGateJournalArticleView> newProductList = ProGateJournalArticleViewLocalServiceUtil
							.getListArticleByOrgIdAndProductType(
									orgId,
									1, // 1 - New Product
									ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeProduct(), 
									categoryType, 
									false, 0, Integer.parseInt(maxItems));
					bean.put("newProductList", newProductList);
					bean.put("lastIndexNewProductList", newProductList.size());
					
					//System.out.println("newProduct.count = " + newProductList.size());
					
					List<ProGateJournalArticleView> bestSellProductList = ProGateJournalArticleViewLocalServiceUtil
							.getListArticleByOrgIdAndProductType(
									orgId,
									2, // 2 - Best Seller Product
									ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeProduct(), 
									categoryType, 
									false, 0, Integer.parseInt(maxItems));
					bean.put("bestSellProductList", bestSellProductList);
					bean.put("lastIndexBestSellProductList", bestSellProductList.size());
					
					//System.out.println("bestSellProductList.count = " + bestSellProductList.size());
		
					List<ProGateJournalArticleView> promoteProductList = ProGateJournalArticleViewLocalServiceUtil
							.getListArticleByOrgIdAndProductType(
									orgId,
									3, // 3 - Promote Product
									ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeProduct(), 
									categoryType, 
									false, 0, Integer.parseInt(maxItems));
					bean.put("promoteProductList", promoteProductList);
					bean.put("lastIndexPromoteProductList", promoteProductList.size());
					
					//System.out.println("promoteProductList.count = " + promoteProductList.size());
					
					bean.put(RSConstants.VIEW_NAME, "product_overview/productList");
				}
			}
		} catch (Exception e) {
			// e.printStackTrace();
			bean.put(RSConstants.VIEW_NAME, "product_overview/productList");
		}
	}
}
