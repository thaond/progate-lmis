
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="larion.progate.model.Organization"%>
<%@page import="larion.progate.service.OrganizationLocalServiceUtil"%>
<%@page import="com.larion.progate.common.bean.PaginationObject"%>
<%@page import="java.util.*"%>

<%@ page import="larion.progate.model.ProGateJournalArticle"%>
<%@ page import="larion.progate.service.ProGateJournalArticleLocalServiceUtil"%>
<%@ page import="larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil"%>
<style type="text/css">
   <%@ include file="/css/new_manage_org/manage_org.css" %>
</style>

<%@ include file="init.jsp" %>

<%
	String keyWords = (String)renderRequest.getAttribute("keyWords");
	String currentURL = (String)renderRequest.getAttribute("currentURL");
	List<Organization> listOrgs = new ArrayList<Organization>();
	int countList = 0;	
	boolean isRepresentOrgPage = false;
	// Get page size
	int pageSize = (Integer)renderRequest.getAttribute("pageSize");		
	
	// Get current page
	int currentPage = (Integer)renderRequest.getAttribute("currentPage");
	
	if(request.getAttribute("isRepresentOrgPage") != null){
		isRepresentOrgPage = (Boolean)request.getAttribute("isRepresentOrgPage");
	}
	int numRecords = 0;
	try{
		if (keyWords != null){
			if(isRepresentOrgPage){
				numRecords = OrganizationLocalServiceUtil.countRepresentOrganizations(true, keyWords);		
			}else{
				numRecords = OrganizationLocalServiceUtil.countSearchOrgName(keyWords);
			}
		}else{
			if(isRepresentOrgPage){
				numRecords = OrganizationLocalServiceUtil.countRepresentOrganizations(true, null);
			}else{
				numRecords = OrganizationLocalServiceUtil.countOrganizations();
			}
		}
		
		//System.out.println("numRecords = " + numRecords);
		
		PaginationObject orgListPaging = new PaginationObject("newManageOrg", numRecords);
		orgListPaging.paging(currentPage, pageSize);		
		renderRequest.setAttribute("orgListPaging", orgListPaging);	
		
		if (keyWords != null){
			if(isRepresentOrgPage){
				listOrgs = OrganizationLocalServiceUtil.getRepresentOrganizations(true, keyWords, orgListPaging.getStartIndex(), orgListPaging.getEndIndex());
			} else {
				listOrgs = OrganizationLocalServiceUtil.searchOrgName(keyWords, orgListPaging.getStartIndex(), orgListPaging.getEndIndex());
			}
		}else{
			if(isRepresentOrgPage){
				listOrgs = OrganizationLocalServiceUtil.getRepresentOrganizations(true, null, orgListPaging.getStartIndex(), orgListPaging.getEndIndex());
			}else{
				listOrgs = OrganizationLocalServiceUtil.getOrganizations(orgListPaging.getStartIndex(), orgListPaging.getEndIndex());
			}
		}	
		
		String intro = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeOrgOverallIntro();
		HashMap hm = new HashMap();
		String html_stripped;
		int orgId;
		Organization organization;
		List<ProGateJournalArticle> listIntro;
		if (listOrgs != null){
			for (Iterator iterator = listOrgs.iterator(); iterator.hasNext();) {
				organization = (Organization) iterator.next();
				orgId = organization.getOrgId();
				// lay phan gioi thieu cua Org		
		        int end = ProGateJournalArticleLocalServiceUtil.countArticleByType(orgId, intro, "");        
		        // Introduction
		        listIntro = ProGateJournalArticleLocalServiceUtil.getListProGateArticles(orgId, intro, "", 0, end);
		        if(listIntro != null){ 
		        	if (listIntro.size() > 0) {
		        		html_stripped = listIntro.get(0).getContent().replaceAll("\\<.*?\\>", "");
		        		hm.put(orgId, html_stripped);
		        	}      	
		        }else{
		        	hm.put(orgId, null);
		        }
			}
			if (hm.size() > 0) renderRequest.setAttribute("descriptions", hm);
		
		}		
		
		if (listOrgs != null) countList = listOrgs.size();
	}catch(Exception e){
		e.printStackTrace();
	}
	renderRequest.setAttribute("countList", countList);

    StringBuilder directPath = new StringBuilder();
	directPath.append(PortalUtil.getPortalURL(request));
	directPath.append("/");
	directPath.append(ProGateUtil.getConfigValue(renderRequest, ConfigParams_RS.REDIRECT_URL));
	renderRequest.setAttribute("directPath", directPath);
	
%>
<script type="text/javascript">   
	window.onload = function() {
		jQuery("#search-key").focus();
	}
	
	function ReplaceAll(stringSource, stringToFind, stringToReplace){
		var temp = stringSource;
		var index = temp.indexOf(stringToFind);
		    while(index != -1){
		        temp = temp.replace(stringToFind,stringToReplace);
		        index = temp.indexOf(stringToFind);
		    }
		    return temp;
	}
	
	/*
	jQuery(document).ready(function() {
		searchStr = '<%= keyWords %>';
		searchStr = searchStr.trim();
		if ((searchStr != null) && (searchStr != '')) {
			resultStr = jQuery("#org-list-content").html();
			resultStr = resultStr.replace(new RegExp(searchStr,"ig"), '<b style="color: black">' + searchStr + '</b>');
			jQuery("#org-list-content").html(resultStr);
		}		
	});
	*/
</script>
<div class="menu-org-container">
	<div class="menu-org-header">
		<% if(isRepresentOrgPage){ %>	
			<span style="font-size: 16px;" class="menu-org-tuade">Tổ Chức Tiêu Biểu</span>
		<% }else{ %>   
	   		<span style="font-size: 16px;" class="menu-org-tuade"><%= res.getString("organizations")%></span>	 
	   	<%} %>   
	   	<c:if test="${countList > 0 || (countList == 0 && keyWords!= null)}">		 	
			 	<input type="text" name="search-key" id="search-key" class="new-manage-org-search" maxlength="50" class="text" value="${keyWords}" style="width:450px;"/>	
			 	<script type="text/javascript">
				 	jQuery("#search-key").keypress(function(e){
				      if(e.keyCode == 13){
				      	jQuery("#timkiem").click();
				      }
				    });
				</script>			
			 	<button id="timkiem" class="bt-form" style="height:21px;width:40px;">	
					<font size="3pt" style="font-family: sans-serif; font-size: 13px;">
						<%= res.getString("search.org")%>
					</font>
				</button>
				<script type="text/javascript">
				 	jQuery("#timkiem").click(function(){
				 		var searchKey = jQuery.trim(jQuery("#search-key").val());
				 		if (searchKey != ''){
				 			var urlSearch = "${pageURL}" + "?keyWords" + "=" + searchKey;		
					 		window.location.href= urlSearch; 
				 		}
				 		if (searchKey == ''){
				 			var urlSearch = "${pageURL}";			 
					 		window.location.href= urlSearch; 
				 		}
				 		
					});					
				</script>				
	 	</c:if>		  	 	 
	    <div style="border-bottom: 1px dotted gray; padding-top: 5px;"></div>
	</div>

    <%	if (countList == 0 && keyWords!= null) { 
	%>
		<div class="new-manage-org-list-content" style="margin-right: 16px;">
			<%= res.getString("message.no.search.org")%>
		</div>
		
	<%
		} else if (countList == 0){				
	%>	
			
	<%	} else {
	%>		
	<div id="org-list-content" class="menu-org-content" style="float: left;">
		<c:forEach var="org" items="<%= listOrgs %>" varStatus="rowCounter">
			<c:choose>
				<c:when test="${(org.orgStatus == true)}">
					<c:set var="orgId" value="${org.orgId}" />	
					<div class="menu-org-folder-news">				
						<div class="menu-org-logo-org">						
							<a href="${directPath}?<%= URLParameter_RS.ORG_ID%>=${orgId}&<%=URLParameter_RS.VIEW_MODE%>=<%=RSConstants.VIEW_MODE%>">
								<c:set value="${fn:trim(org.logoId)}" var="logo"/>							
								<c:choose>								
									<c:when test="${logo == null || logo == '' }">									
										<div class="logo">
											<img class="logo" src="<%=request.getContextPath()%>/images/new-manage-org/small_noImage.gif" alt="">
										</div>								
									</c:when>
									<c:otherwise>
										<div class="logo">
											<img id="anh${rowCounter.count}" src="${logo}" alt="" class="logoImg"
											onLoad='scaleImg(this, 150, 120)' style="display: none;">
										</div>											
									</c:otherwise>
								</c:choose>
							</a>
						</div>
						<div class="menu-org-content">
							<span align="left" class="new-manage-org-name">					
							<a class="new-manage-org-link" href="${directPath}?<%= URLParameter_RS.ORG_ID%>=${orgId}&<%=URLParameter_RS.VIEW_MODE%>=<%=RSConstants.VIEW_MODE%>">${org.name}</a>
							<c:if test="${org.isProactive == true}">
								<img src="<%=request.getContextPath()%>/images/new-manage-org/PremierPro.png" class="hightlights-org-enable" id="typical-normal-image-${org.orgId}">
							</c:if>
							</span>
							<br />
							<span style="color:gray;">1/${org.maxUserCount} <%=res.getString("member")%>&nbsp;|&nbsp; ${org.city} &nbsp;|&nbsp; ${org.orgType} &nbsp;|&nbsp;  
								<c:choose>
									<c:when test="${org.updatedAt == null || org.updatedAt == ''}">
										<fmt:formatDate value="${org.createdAt}" pattern="dd/MM/yyyy"/> 
									</c:when>
									<c:otherwise>
										<fmt:formatDate value="${org.updatedAt}" pattern="dd/MM/yyyy"/> 
									</c:otherwise>
								</c:choose>
							</span>
							<div id="descript${orgId}"></div>
							 <script>
							  jQuery(document).ready(function () {
							  		jQuery("#descript${orgId}").append(jQuery("#description${orgId}").html());
								});
							  </script>			
						</div>			
					</div>
				</c:when>
				<c:when test="${org.orgStatus == false}"> 
					<div class="new-manage-org-folder-news-disable">
						<div class="menu-org-logo-org">						
							<c:set value="${fn:trim(org.logoId)}" var="logo"/>							
							<c:choose>								
								<c:when test="${logo == null || fn:length(logo) == 0 }">									
									<div class="logo">
										<img class="logo" 
											src="<%=request.getContextPath()%>/images/new-manage-org/small_noImage.gif" alt="">
									</div>		
							    </c:when>
								<c:otherwise>
									<div class="logo">
										<img id="anh${rowCounter.count}" src="${logo}" alt="" onLoad='scaleImg(this, 150, 120)' style="display: none;"></div>
								</c:otherwise>
							</c:choose>		
						</div>
						<div class="new-manage-org-content org-disable">
							<span align="left" class="new-manage-org-name org-disable">${org.name}</span>
							<c:if test="${org.isProactive == true}">
								<img src="<%=request.getContextPath()%>/images/new-manage-org/PremierPro.png" class="hightlights-org-enable"></span>
							</c:if><br />
							<span style="color:gray;">1/${org.maxUserCount} <%=res.getString("member")%>&nbsp;|&nbsp; ${org.city} &nbsp;|&nbsp; ${org.orgType} &nbsp;|&nbsp;  
								<c:choose>
									<c:when test="${org.updatedAt == null || org.updatedAt == ''}">
										<fmt:formatDate value="${org.createdAt}" pattern="dd/MM/yyyy"/> 
									</c:when>
									<c:otherwise>
										<fmt:formatDate value="${org.updatedAt}" pattern="dd/MM/yyyy"/> 
									</c:otherwise>
								</c:choose>
							</span>
							<div id="descript${orgId}"></div>
							 <script>
							  jQuery(document).ready(function () {
							  		jQuery("#descript${orgId}").append(jQuery("#description${orgId}").html());
								});
							  </script>								
						</div>					
					</div>
				</c:when>
			</c:choose>	
		</c:forEach>	
	</div>
</div>
<%}%>

<div id="orgList_paging" class="menu-org-paging">
	<c:if test="${countList > 0}">
		<c:set value="${orgListPaging}" var="paging"></c:set>
		<%@ include file="/html/portlet/common/pagination.jsp" %>
	</c:if>
</div>

<script type="text/javascript">
	function pagingSubmit(){
		var selectPageSelector = jQuery("#orgList_paging").find(".page-selector select");	
		var currentPageNum = selectPageSelector.val();
		
		var selectPageSizeSelector = jQuery("#orgList_paging").find(".delta-selector select");			
		var currentPageSize = selectPageSizeSelector.val();
		
		if (currentPageNum > 0) {
			<%if (currentURL.indexOf("?") == -1){%>
				window.location.href="<%=currentURL%>?currentPage=" + currentPageNum + "&pageSize=" + currentPageSize;
			<%}else{%>
				window.location.href="<%=currentURL%>&currentPage=" + currentPageNum + "&pageSize=" + currentPageSize;
			<%}%>
		}
	}
</script>

<div style="display:none;">
	<c:forEach items="${descriptions}" var="entry">
		<div id="description${entry.key}">
			<c:if test="${entry.value != null}">
				<c:choose>
					<c:when test="${fn:length(entry.value) > 120}">
						<c:set value="${fn:substring(entry.value, 120, 130)}" var="strTemp" />
						<c:set value="${fn:indexOf(strTemp, ' ')}" var="iTemp" />
						<c:out value="${fn:substring(entry.value, 0, 120 + iTemp)}..." escapeXml="false"></c:out>
					</c:when>				
					<c:otherwise>
						<c:out value="${entry.value}" escapeXml="false"></c:out>
					</c:otherwise>
				</c:choose>	
			</c:if>		
		</div>
	</c:forEach>
</div>
