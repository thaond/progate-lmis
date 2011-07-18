<%@page import="java.util.ArrayList"%>
<%@page import="larion.progate.service.ProGateRolesLocalServiceUtil"%>
<%@page
	import="larion.progate.service.ProgateOrganizationParticipantsLocalServiceUtil"%>
<%@page import="com.larion.progate.common.utils.ProGateUtil"%>
<%@page import="com.larion.progate.organization.logo.OrganizationImage"%>
<%@ page import="larion.progate.model.ProGateJournalArticle"%>
<%@ page
	import="larion.progate.service.ProGateJournalArticleLocalServiceUtil"%>
<%@ page
	import="larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil"%>

<%@ include file="/html/portlet/organization/management/new/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="larion.progate.model.Organization"%>
<%@page import="larion.progate.service.OrganizationLocalServiceUtil"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.*"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>

<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="com.liferay.portal.util.PortalUtil"%>
<%@ page import="com.larion.progate.common.bean.PaginationObject"%>
<%
	String currentURL = (String) renderRequest
			.getAttribute("currentURL");
	String pageURL = (String) renderRequest.getAttribute("pageURL");

	int userType = (Integer) renderRequest.getAttribute("userType");
	boolean isProGateAdmin = (Boolean) renderRequest.getAttribute("isProGateAdmin");
	int userId = (Integer) renderRequest.getAttribute("userId");	

	int countList = 0;
	List<Organization> listOrgs = null;

	String keyWords = (String) renderRequest.getAttribute("keyWords");
	int modeView = (userType != -1) ? userType : 0;
	
	if (isProGateAdmin == true) {
		modeView = 0;
	}

	int numRecords = 0;
	// Get total records
	if (keyWords != null) {
		numRecords = OrganizationLocalServiceUtil
				.countsearchOrganizations(userId, modeView, keyWords);
	} else {
		numRecords = OrganizationLocalServiceUtil.countOrganizations(
				userId, modeView);
	}

	// Get page size
	int pageSize = (Integer) renderRequest.getAttribute("pageSize");

	// Get current page
	int currentPage = (Integer) renderRequest
			.getAttribute("currentPage");

	PaginationObject orgListPaging = new PaginationObject("newManageOrg", numRecords);
	orgListPaging.paging(currentPage, pageSize);
	renderRequest.setAttribute("orgListPaging", orgListPaging);

	if (keyWords != null) {
		listOrgs = OrganizationLocalServiceUtil.searchOrganizations(
				userId, modeView, keyWords,
				orgListPaging.getStartIndex(),
				orgListPaging.getEndIndex());
	} else {
		listOrgs = OrganizationLocalServiceUtil.getOrganizations(
				userId, modeView, orgListPaging.getStartIndex(),
				orgListPaging.getEndIndex());
	}
	 System.out.println("userId "+userId);
	String intro = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeOrgOverallIntro();
	HashMap hm = new HashMap();
	String html_stripped;
	int orgId;
	Organization organization;
	List<ProGateJournalArticle> listIntro;
	if (listOrgs != null) {
		for (Iterator iterator = listOrgs.iterator(); iterator
				.hasNext();) {
			organization = (Organization) iterator.next();
			orgId = organization.getOrgId();
			
			// Introduction
			listIntro = ProGateJournalArticleLocalServiceUtil.getListProGateArticles(orgId, intro, "", 0, 2);
			
			if (listIntro != null) {
				if (listIntro.size() > 0) {
					html_stripped = listIntro.get(0).getContent()
							.replaceAll("\\<.*?\\>", "");
					hm.put(orgId, html_stripped);
				}
			} else {
				hm.put(orgId, null);
			}
		}
		if (hm.size() > 0)
			renderRequest.setAttribute("descriptions", hm);
	}

	if (listOrgs == null) {
		listOrgs = new ArrayList<Organization>();
	}
	countList = listOrgs.size();
	
	renderRequest.setAttribute("countList", countList);
	
    System.out.println("countList "+countList);
    
	StringBuilder directPath = new StringBuilder();
	directPath.append(PortalUtil.getPortalURL(request));
	directPath.append("/");
	directPath.append(ProGateUtil.getConfigValue(renderRequest,
			ConfigParams_RS.REDIRECT_URL));
	renderRequest.setAttribute("directPath", directPath);
	
	String userMgmtURL = GlobalSettings.FRIENDLY_URL_USER_MGMT;
	renderRequest.setAttribute("userMgmtURL", userMgmtURL);
%>

<script type="text/javascript">   
	window.onload = function() {
		jQuery("#search-key").focus();		
	}
</script>

<%@ include file="notice.jsp"%>

<div class="right-content" id="<portlet:namespace/>library">

	<c:choose>
		<c:when
			test="${(userType < 0 || userType > 4) && isProGateAdmin == false}">
			<c:set value="0" var="filterType" />
		</c:when>
		<c:otherwise>
			<c:set value="<%= userType %>" var="filterType" />
		</c:otherwise>
	</c:choose>

	<div style="width: 100%; margin-top: 12px;">
		<span class="new-manage-org-header"> <c:choose>
				<c:when test="${isProGateAdmin == true}">
					<%=res.getString("org.other")%>
				</c:when>
				<c:when test="${filterType == 0}">
					<%=res.getString("org.admin")%>
				</c:when>
				<c:when test="${filterType == 1}">
					<%=res.getString("org.member")%>
				</c:when>
				<c:when test="${filterType == 3}">
					<%=res.getString("org.wait")%>
				</c:when>
				<c:when test="${filterType == 4}">
					<%=res.getString("org.invite")%>
				</c:when>
				<c:otherwise>
					<%=res.getString("org.other")%>
				</c:otherwise>
			</c:choose> </span>

		<c:if test="${countList > 0 || (countList == 0 && keyWords!= null)}">
			<input type="text" name="search-key" id="search-key"
				class="new-manage-org-search" maxlength="50" class="text"
				value="${keyWords}" />
			<script type="text/javascript">
			 	jQuery("#search-key").keypress(function(e){
			      if(e.keyCode == 13){
			      	jQuery("#timkiem").click();
			      }
			    });
			</script>
			<button id="timkiem" class="bt-form"
				style="height: 21px; width: 80px;">
				<font size="3pt" style="font-family: sans-serif; font-size: 13px;">
					<%=res.getString("search.org")%> </font>
			</button>
			<script type="text/javascript">
			 	jQuery("#timkiem").click(function(){
			 		var searchKey = jQuery.trim(jQuery("#search-key").val());
			 		if (searchKey != ''){
			 			var urlSearch = "<%=pageURL%>";			 		
				 		<%if (userType < 0 || userType > 4) {%>			 			
				 			urlSearch = urlSearch + "?keyWords" + "=" + searchKey;
				 		<%} else {%>
				 			urlSearch = urlSearch + "?userType" + "=" + "<%=userType%>" + "&keyWords" + "=" + searchKey;
				 		<%}%>				 		
				 		
				 		window.location.href= urlSearch; 
			 		}
			 		if (searchKey == ''){
			 			var urlSearch = "<%=pageURL%>";			 		
				 		<%if ((userType < 0 || userType > 4) && isProGateAdmin == true) {%>			 			
				 			urlSearch = urlSearch;
				 		<%} else {%>
				 			urlSearch = urlSearch + "?userType" + "=" + "<%=userType%>";
				 		<%}%>				 		
				 		
				 		window.location.href= urlSearch; 
			 		}
			 		
				});					
			</script>
		</c:if>
		<div class="new-manage-org-dot-line"></div>

		<%
			if (countList == 0 && keyWords != null) {
		%>
		<div class="new-manage-org-list-content" style="margin-right: 18px;">
			<%=res.getString("message.no.search.org")%>
		</div>

		<%
			} else if (countList == 0) {
		%>
		<%@ include file="empty_list.jsp"%>
		<%
			} else {
		%>
		<c:if test="${filterType == 0}">
			<div align="right" class="new-manage-org-action-head">
				<a class="new-manage-org-link" href="${pageURL}?userType=0&cmd=add"><%=res.getString("add.org")%></a>
			</div>
		</c:if>

		<c:if test="${isProGateAdmin == true}">
			<div align="right" class="new-manage-org-action-head">
				<a class="new-manage-org-link" href="${pageURL}?cmd=add"><%=res.getString("add.org")%></a>
				&nbsp;|&nbsp; <a class="new-manage-org-link"
					href="javascript:void(0);" onClick="deleteManyOrg()"><%=res.getString("delete.org")%></a>
				&nbsp;|&nbsp; <a class="new-manage-org-link"
					href="javascript:void(0);"><%=res.getString("configuration.org")%></a>
			</div>
		</c:if>

		<c:forEach var="org" items="<%= listOrgs %>" varStatus="rowCounter">
			<c:set var="orgId" value="${org.orgId}" />
			<c:choose>
				<c:when
					test="${!(org.orgStatus == false && (filterType == 1 || filterType == 3 || filterType == 4))}">
					<div class="new-manage-org-folder-news">
						<c:if test="${isProGateAdmin == true}">
							<div class="new-manage-org-checkOrg">
								<input type="checkbox" value="${orgId}" />
							</div>
						</c:if>
						<div class="new-manage-org-logo-org">
							<a
								href="${directPath}?<%=URLParameter_RS.ORG_ID%>=${orgId}&<%=URLParameter_RS.VIEW_MODE%>=<%=RSConstants.VIEW_MODE%>">
								<c:set value="${fn:trim(org.logoId)}" var="logo" /> <c:choose>
									<c:when test="${logo == null || logo == '' }">
										<div class="logo" align="center">
											<img class="logo"
												src="<%=request.getContextPath()%>/images/new-manage-org/small_noImage.gif"
												alt="">
										</div>
									</c:when>
									<c:otherwise>
										<div class="logo" align="center">
											<img id="anh${rowCounter.count}" alt="">
										</div>
										<%@ include file="scale_image.jsp"%>
									</c:otherwise>
								</c:choose> </a>
						</div>
						<div class="new-manage-org-content">
							<span align="left" class="new-manage-org-name"> <a
								class="new-manage-org-link"
								href="${directPath}?<%=URLParameter_RS.ORG_ID%>=${orgId}&<%=URLParameter_RS.VIEW_MODE%>=<%=RSConstants.VIEW_MODE%>">${org.name}</a>
								<c:choose>
									<c:when test="${org.isProactive == true}">
										<img
											src="<%=request.getContextPath()%>/images/new-manage-org/PremierPro.png"
											class="hightlights-org-enable"
											id="typical-normal-image-${org.orgId}">
							</span>
				</c:when>
				<c:otherwise>
					<img
						src="<%=request.getContextPath()%>/images/new-manage-org/PremierPro.png"
						class="hightlights-org-disable"
						id="typical-normal-image-${org.orgId}">
					</span>
				</c:otherwise>
			</c:choose>
			<br />
			<span style="color: gray;">1/${org.maxUserCount} <%=res.getString("member")%>&nbsp;|&nbsp;
				${org.city} &nbsp;|&nbsp; ${org.orgType} &nbsp;|&nbsp; <c:choose>
					<c:when test="${org.updatedAt == null || org.updatedAt == ''}">
						<fmt:formatDate value="${org.createdAt}" pattern="dd/MM/yyyy" />
					</c:when>
					<c:otherwise>
						<fmt:formatDate value="${org.updatedAt}" pattern="dd/MM/yyyy" />
					</c:otherwise>
				</c:choose> </span>

			<div id="descript${orgId}"></div>
			<script>
								  jQuery(document).ready(function () {
								  		jQuery("#descript${orgId}").append(jQuery("#description${orgId}").html());
									});
								  </script>

			<div>
				<%@ include file="action_authorities.jsp"%>
			</div>
	</div>
</div>
</c:when>
<c:when test="${org.orgStatus == false && filterType == 1}">
	<div class="new-manage-org-folder-news-disable">
		<div class="new-manage-org-logo-org">
			<c:set value="${fn:trim(org.logoId)}" var="logo" />
			<c:choose>
				<c:when test="${logo == null || fn:length(logo) == 0 }">
					<div class="logo" align="center">
						<img class="logo"
							src="<%=request.getContextPath()%>/images/new-manage-org/small_noImage.gif"
							alt="">
					</div>
				</c:when>
				<c:otherwise>
					<div class="logo" align="center">
						<img id="anh${rowCounter.count}" alt="">
					</div>
					<%@ include file="scale_image.jsp"%>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="new-manage-org-content org-disable">
			<span align="left" class="new-manage-org-name org-disable">${org.name}</span>
			<c:if test="${org.isProactive == true}">
				<img
					src="<%=request.getContextPath()%>/images/new-manage-org/PremierPro.png"
					class="hightlights-org-enable">
				</span>
			</c:if>
			<br /> <span style="color: gray;">1/${org.maxUserCount} <%=res.getString("member")%>&nbsp;|&nbsp;
				${org.city} &nbsp;|&nbsp; ${org.orgType} &nbsp;|&nbsp; <c:choose>
					<c:when test="${org.updatedAt == null || org.updatedAt == ''}">
						<fmt:formatDate value="${org.createdAt}" pattern="dd/MM/yyyy" />
					</c:when>
					<c:otherwise>
						<fmt:formatDate value="${org.updatedAt}" pattern="dd/MM/yyyy" />
					</c:otherwise>
				</c:choose> </span>
			<div id="descript${orgId}"></div>
			<script>
								  jQuery(document).ready(function () {
								  		jQuery("#descript${orgId}").append(jQuery("#description${orgId}").html());
									});
			</script>
			<div>
				<%@ include file="action_authorities.jsp"%>
			</div>
		</div>
	</div>
</c:when>
</c:choose>
</c:forEach>
<%
			}
		%>
</div>
</div>



<div id="orgList_paging" class="productView-paging">
	<c:if test="${countList > 0}">
		<c:set value="${orgListPaging}" var="paging"></c:set>
		<%@ include file="/html/portlet/common/pagination.jsp"%>
	</c:if>
</div>

<%@ include file="script/action.jsp"%>
<script type="text/javascript">
	function pagingSubmit(){
		var selectPageSelector = jQuery("#orgList_paging").find(".page-selector select");	
		var currentPageNum = selectPageSelector.val(); 
		var selectPageSizeSelector = jQuery("#orgList_paging").find(".delta-selector select");			
		var currentPageSize = selectPageSizeSelector.val();
		
		<%if (currentURL.indexOf("?") == -1) {%>
			window.location.href="<%=currentURL%>?currentPage" + "=" + currentPageNum + "&pageSize" + "=" + currentPageSize;
		<%} else {%>
			window.location.href="<%=currentURL%>&currentPage" + "=" + currentPageNum + "&pageSize" + "=" + currentPageSize;
		<%}%>
	}
</script>
<div style="display: none;">
	<c:forEach items="${descriptions}" var="entry">
		<div id="description${entry.key}">
			<c:if test="${entry.value != null}">
				<c:choose>
					<c:when test="${fn:length(entry.value) > 120}">
						<c:set value="${fn:substring(entry.value, 120, 130)}"
							var="strTemp" />
						<c:set value="${fn:indexOf(strTemp, ' ')}" var="iTemp" />
						<c:out value="${fn:substring(entry.value, 0, 120 + iTemp)}..."
							escapeXml="false"></c:out>
					</c:when>
					<c:otherwise>
						<c:out value="${entry.value}" escapeXml="false"></c:out>
					</c:otherwise>
				</c:choose>
			</c:if>
		</div>
	</c:forEach>
</div>
