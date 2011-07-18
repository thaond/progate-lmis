<%--

--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.larion.progate.partnerView.constants.RequestConst"%>

<%
	// renderRequest and portletConfig are objects which, accoring to the
	// portlet spec, are required to be in context. So they should just be 
	// there for you to use.
	//Locale locale = renderRequest.getLocale();
	//ResourceBundle bundle = portletConfig.getResourceBundle(locale);
	
	String urlToRedirect = PortalUtil.getPortalURL(request) + "/tochuc/trangchu"
							+ "?" + RequestConst.ORG_ID + "=" + orgId 
							+ "&" + RequestConst.VIEW_MODE + "=" + viewMode;
	
	//System.out.println("urlToRedirect = " + urlToRedirect);
	
	//System.out.println("increment = " + paging.get(RequestConst.INCREMENT));
	//System.out.println("totalRecords = " + paging.get(RequestConst.TOTAL_RECORD));
	//System.out.println("currentPage = " + paging.get(RequestConst.CURRENT_PAGE));
	
	int currPage = (Integer)paging.get(RequestConst.CURRENT_PAGE);
	int numOfItem = (Integer)paging.get(RequestConst.INCREMENT);
	int countRecord = (Integer)paging.get(RequestConst.TOTAL_RECORD);
	int countPage = 0;
	
	if (countRecord % numOfItem == 0) {
		countPage = countRecord / numOfItem;
	} else {
		countPage = (countRecord - countRecord % numOfItem) / numOfItem + 1;
	}
	
	int startIndex = 0;
	int endIndex = countRecord;
%>

<fmt:setBundle basename="content.Paging_vn" var="msg"></fmt:setBundle>

<%-- variables --%>
<c:set value="<%= (Integer)paging.get(RequestConst.INCREMENT) %>" var="increment"/>
<c:set value="<%= (Integer)paging.get(RequestConst.TOTAL_RECORD) %>" var="total"/>
<c:set value="<%= (Integer)paging.get(RequestConst.CURRENT_PAGE) %>" var="currentPage"/>
<c:set value="<%= countPage %>" var="totalPages"/>
	
<script type="text/javascript">
var currentPage = 1;
var totalPage = <%= countPage %>;

function nextPage() {		
	if (currentPage < totalPage) {
		currentPage += 1;
		
		showPage(currentPage);
	}	
}

function prevPage() {
	if (currentPage > 1) {
		currentPage -= 1;
		
		showPage(currentPage);
	}
}

function showPage(page) {
	jQuery("#paging_summary").html('Trang ' + page + ' / Tổng số ' + totalPage + ' trang');
	
	if (page > 1) {
		jQuery("#previous_page").css('cursor', 'pointer');
		jQuery("#previous_page").css('opacity', '1');
	} else {
		jQuery("#previous_page").css('cursor', '');
		jQuery("#previous_page").css('opacity', '0.6');
	}
	
	if (page < totalPage) {
		jQuery("#next_page").css('cursor', 'pointer');
		jQuery("#next_page").css('opacity', '1');
	} else {
		jQuery("#next_page").css('cursor', '');
		jQuery("#next_page").css('opacity', '0.6');
	}
		
	for (var x = 0; x < totalPage; x++) {		
		if ((x + 1) == page) {
			jQuery("#partner_list" + (x + 1)).css('display', 'block');
		} else {
			jQuery("#partner_list" + (x + 1)).css('display', 'none');
		}
	}
}

</script>
