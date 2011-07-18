<%@ include file="../common/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.larion.progate.paging.constants.PagingConst"%>
<%@ page import="com.larion.progate.productOverview.constants.*" %>
<%@ page import="com.larion.progate.common.utils.ProGateUtil" %>
<%@ page import="com.larion.progate.common.constants.*" %>
<%@ page import="com.larion.progate.common.bean.PaginationObject" %>

<%@ page import="larion.progate.model.ProGateJournalArticleView" %>
<%@ page import="larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil" %>
<%@ page import="larion.progate.service.ProGateJournalArticleViewLocalServiceUtil" %>

<%
	// Get page size
	int pageSize = ParamUtil.getInteger(request, PagingConst.PAGE_SIZE, RequestConst.INCREMENT_CONST);		
	
	// Get current page
	int currentPage = ParamUtil.getInteger(request, PagingConst.GOTO_PAGE, 1);
	
	//System.out.println("Container: currentPage = " + currentPage + "; pageSize = " + pageSize);

	Map<String, Object> bean = new HashMap<String, Object>();	
		
	int orgId = 0;
	bean.put(URLParameter_RS.ORG_ID, orgId);
	
	int categoryType = 0;
	int productType = 0;
	
	productType = ParamUtil.getInteger(request, URLParameter_RS.PRODUCT_TYPE, 0);
	
	String displayStyle = ParamUtil.getString(request, RequestConst.DISPLAY_STYLE, RequestConst.PRODUCT_LIST);
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
	
	String displaySubStyle = ParamUtil.getString(request, RequestConst.DISPLAY_SUB_STYLE, RequestConst.ALL_PRODUCT_LIST);
	bean.put("displaySubStyle", displaySubStyle);
	
	if (RequestConst.NEW_PRODUCT_LIST.equals(displaySubStyle)) {
		productType = 1;
	} else if (RequestConst.SELLING_PRODUCT_LIST.equals(displaySubStyle)) {
		productType = 2;
	} else if (RequestConst.DISCOUNT_PRODUCT_LIST.equals(displaySubStyle)) {
		productType = 3;
	}
	bean.put("productType", productType);
	
	String friendlyUrl = ParamUtil.getString(request, RequestConst.FRIENDLY_URL, ProductOverviewConst.FRIENDLY_URL);
	String newProductUrl = ParamUtil.getString(request, RequestConst.NEW_PRODUCT_URL, ProductOverviewConst.NEW_PRODUCT_FRIENDLY_URL);
	String sellingProductUrl = ParamUtil.getString(request, RequestConst.SELLING_PRODUCT_URL, ProductOverviewConst.SELLING_PRODUCT_FRIENDLY_URL);
	String discountProductUrl = ParamUtil.getString(request, RequestConst.DISCOUNT_PRODUCT_URL, ProductOverviewConst.DISCOUNT_PRODUCT_FRIENDLY_URL);
	
	bean.put(RequestConst.FRIENDLY_URL, friendlyUrl);
	bean.put(RequestConst.NEW_PRODUCT_URL, newProductUrl);
	bean.put(RequestConst.SELLING_PRODUCT_URL, sellingProductUrl);
	bean.put(RequestConst.DISCOUNT_PRODUCT_URL, discountProductUrl);	
	
	List<ProGateJournalArticleView> productList = null;
	
	// Get total records
	int numRecords = ProGateJournalArticleViewLocalServiceUtil
					.countListArticleByOrgIdAndProductType(orgId, 
							productType, 
							ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeProduct(), 
							categoryType, false);
	
	int increment = ParamUtil.getInteger(request, "numOfRecords", RequestConst.INCREMENT_CONST);
	bean.put("numOfRecords", increment);
	
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
	
	System.out.println("productList.size = " + productList.size());
	
	request.setAttribute("bean", bean);
%>

<fmt:setBundle basename="messages" scope="session"/>
<%@ include file="productListContainer.jsp" %>
