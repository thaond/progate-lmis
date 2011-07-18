package com.larion.progate.product.action;

import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import larion.progate.model.OrganizationView;
import larion.progate.model.ProGateJournalArticleView;
import larion.progate.service.OrganizationViewLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil;
import larion.progate.service.ProGateJournalArticleViewLocalServiceUtil;

import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.bean.PaginationObject;
import com.larion.progate.common.constants.Request;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;

public class ManagingProductAction extends ParameterizableViewAction {

	// private static List<Integer> productIdList = new ArrayList<Integer>();

	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {

		try {

			String cmd = ParamUtil.getString(request, Constants.CMD,
					Constants.MANAGE);

			/*
			 * int[] productIDs = ParamUtil.getIntegerValues(request,
			 * Request.PRODUCT_ID);
			 * 
			 * for (int i = 0; i < productIDs.length; i++) { if
			 * (productIdList.indexOf(productIDs[i]) == -1) {
			 * productIdList.add(productIDs[i]); } }
			 */

			int selectedOrgId = ParamUtil.getInteger(request,
					Request.SELECTED_ORG_ID, -1);

			int currentOrgId = ParamUtil.getInteger(request,
					Request.CURRENT_ORG_ID, -1);

			if (Constants.SAVE.equals(cmd)) {
				addProductToProGate(request, response, bean);
			}

			if (Constants.DELETE.equals(cmd)) {
				removeProductFromProGate(request, response, bean);
			}

			if (Constants.SEARCH.equals(cmd)) {
				currentOrgId = -1;
				selectedOrgId = -1;
			}
			// bean.put("productIdList", productIdList);

			String searchOrgName = ParamUtil.getString(request,
					Constants.SEARCH, "");
			bean.put("searchOrgName", searchOrgName);
			List<OrganizationView> organizationList;

			PaginationObject paginationOrganization = new PaginationObject(
					"Organization",
					OrganizationViewLocalServiceUtil
							.getOrganizationViewsCount());
			paginationOrganization.paging(request);

			if (!"".equals(searchOrgName)) {
				organizationList = OrganizationViewLocalServiceUtil
						.searchOrgName(searchOrgName, 0,
								OrganizationViewLocalServiceUtil
										.getOrganizationViewsCount());

				paginationOrganization = new PaginationObject("Organization",
						organizationList.size());
				paginationOrganization.paging(request);

				organizationList = organizationList.subList(
						paginationOrganization.getStartIndex(),
						paginationOrganization.getEndIndex());
			} else {
				organizationList = OrganizationViewLocalServiceUtil
						.getOrganizationViews(
								paginationOrganization.getStartIndex(),
								paginationOrganization.getEndIndex());
			}
			paginationOrganization.setListObject(organizationList);
			bean.put("paginationOrganization", paginationOrganization);

			if (currentOrgId == -1) {
				if (organizationList.size() > 0) {
					currentOrgId = organizationList.get(0).getOrgId();
				}
			}

			if (selectedOrgId == -1) {
				selectedOrgId = currentOrgId;
			}
			bean.put("selectedOrgId", selectedOrgId);

			if (organizationList.size() > 0) {
				PaginationObject paginationProduct = new PaginationObject(
						"Product",
						ProGateJournalArticleViewLocalServiceUtil.countListArticleByOrgIdAndProductType(
								selectedOrgId, 0, // 0 - All Product
								ProGateJournalArticleTypesLocalServiceUtil
										.getArticleTypeProduct(), false));

				if (currentOrgId != selectedOrgId) {
					paginationProduct.setNextPaging(false);
				}

				paginationProduct.paging(request);

				List<ProGateJournalArticleView> productList = ProGateJournalArticleViewLocalServiceUtil
						.getListArticleByOrgIdAndProductType(
								selectedOrgId,
								0, // 0 - All Product
								ProGateJournalArticleTypesLocalServiceUtil
										.getArticleTypeProduct(), false,
								paginationProduct.getStartIndex(),
								paginationProduct.getEndIndex());

				paginationProduct.setListObject(productList);
				bean.put("paginationProduct", paginationProduct);
			}

			currentOrgId = selectedOrgId;
			bean.put("currentOrgId", currentOrgId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateProductType(RenderRequest request,
			RenderResponse response, Map<String, Object> bean, int productType)
			throws Exception {

		int[] productIDs = ParamUtil.getIntegerValues(request,
				Request.PRODUCT_ID);

		for (int i = 0; i < productIDs.length; i++) {
			ProGateJournalArticleView proGateJournalArticleView = ProGateJournalArticleViewLocalServiceUtil
					.getProGateJournalArticleView(productIDs[i]);

			proGateJournalArticleView.setProgateCategory(productType);

			ProGateJournalArticleViewLocalServiceUtil
					.updateProGateArticleViewObject(proGateJournalArticleView);
		}

		/*
		 * for (int productId : productIdList) { ProGateJournalArticleView
		 * proGateJournalArticleView = ProGateJournalArticleViewLocalServiceUtil
		 * .getProGateJournalArticleView(productId);
		 * 
		 * proGateJournalArticleView.setProgateCategory(productType);
		 * 
		 * ProGateJournalArticleViewLocalServiceUtil
		 * .updateProGateArticleViewObject(proGateJournalArticleView); }
		 * productIdList.clear();
		 */
	}

	public void addProductToProGate(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {

		int productType = ParamUtil
				.getInteger(request, Request.PRODUCT_TYPE, 0);

		updateProductType(request, response, bean, productType);
	}

	public void removeProductFromProGate(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {

		int productType = 0;

		updateProductType(request, response, bean, productType);
	}
}