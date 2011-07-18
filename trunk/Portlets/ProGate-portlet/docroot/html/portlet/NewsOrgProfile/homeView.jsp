
<%@page import="com.larion.progate.common.constants.URLParameter_RS"%>
<%@ include file="init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page isELIgnored="false"%>

<%@ page import="larion.progate.model.ProGateJournalArticle"%>
<%@ page import="com.larion.progate.organization.product.constants.JournalArticle_RS"%>
<%@ page
	import="larion.progate.service.ProGateJournalArticleLocalServiceUtil"%>
<%@ page
	import="larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="com.liferay.portal.util.PortalUtil"%>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.LinkedList"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />

<script type="text/javascript" src="/ProGate-portlet/js/util.js"></script>
<script type="text/javascript" src="/ProGate-portlet/js/scaleImg.js"></script>

<%
	String orgId = (String) renderRequest.getAttribute("orgId");
	String viewMode = (String) renderRequest.getAttribute("viewMode");

	String backURL = renderRequest.getParameter("backURL");
	if (backURL == null) {
		backURL = (String) renderRequest.getAttribute("backURL");
	}
	renderRequest.setAttribute("backURL", backURL);

	String articleType = ProGateJournalArticleTypesLocalServiceUtil
			.getArticleTypeNews();
	System.out.println(articleType);
	List<ProGateJournalArticle> listArticles = ProGateJournalArticleLocalServiceUtil
			.getListProGateArticlesByPrority(Integer.valueOf(orgId),
					articleType, true, "", 0, 3);
	renderRequest.setAttribute("listArticles", listArticles);

	int sum = 0;
	if (listArticles != null) {
		sum = listArticles.size();
	}
	renderRequest.setAttribute("sum", sum);
%>

<%
	HttpServletRequest req = PortalUtil
			.getHttpServletRequest(renderRequest);
	String hostAdd = PortalUtil.getHost(req);
	int port = PortalUtil.getPortalPort();

	hostAdd = "http://" + hostAdd + ":" + String.valueOf(port)
			+ "/tochuc/tintuc?orgId=" + orgId + "&viewMode=" + viewMode;
	renderRequest.setAttribute("hostAdd", hostAdd);
	
%>

<div class="org-profile-layout-column-212">

	<div class="pg-common-layout-news-org">
		<!-- Header -->
		<div class="pg-common-header-news-org">
			<div class="pg-td-header-news-org">
				<span class="pg-header-content-news-org"><%=res.getString("title")%></span>
			</div>
		</div>

		<!-- Content -->
		<div class="pg-common-body-news-org">
			<c:forEach var="article" items="${listArticles}"
				varStatus="rowCounter">
				<c:choose>
					<c:when test="${rowCounter.count == 1}">
						<div class="pg-tr-content-border-news-org"
							style="border-bottom: none;">
							<div class="pg-image-content-news-org">
								<a href="${hostAdd}&articleId=${article.journalArticleId}">
									<c:set var="smallImageUrl" value="${article.smallImageUrl}" />
									<c:choose>
										<c:when test="${smallImageUrl == ''}">
											<img alt=""
												src="<%=request.getContextPath()%>/images/news_org/small_noImage.gif" />
										</c:when>
										<c:otherwise>
											<img alt="" src="${article.smallImageUrl}"
												onLoad='scaleImg(this, 70, 70)' style="display: none;" />
										</c:otherwise>
									</c:choose> </a>
							</div>
							<div class="pg-td-content-news-org">
								<span class="pg-normal-content-news-org"> <!-- sua chua-->
									<c:choose>
										<c:when test="${isOrgAdmin eq true}">
										   
										   <portlet:renderURL var="editJournalArticles" 
													windowState="<%=WindowState.MAXIMIZED.toString() %>">
											    <portlet:param name="struts_action" value="handleJournal" />
											    <portlet:param name="<%=JournalArticle_RS.JA_ORG_ID%>" 
											    	value='${orgId}'/>											    	
											    <portlet:param name="<%=JournalArticle_RS.JA_ID %>" 
											    	value='${article.journalArticleId}'/>
											    <portlet:param name="<%=URLParameter_RS.RETURN_TO_FULL_PAGE_URL %>" 
											    	value='<%=PortalUtil.getCurrentURL(renderRequest) %>'/>
											    <portlet:param name="<%=Constants.CMD%>" value="<%=Constants.UPDATE%>"/>
											</portlet:renderURL>
											
											<img
												src="<%=request.getContextPath()%>/images/news_org/write.png"
												style="vertical-align: bottom;" width="15" height="15" />
											<a href='<c:out value="${editJournalArticles}"></c:out>'>
												<%=res.getString("repair")%>
											</a>
										</c:when>
									</c:choose> 
									<a class="pg-content-link-news-org"
									href="${hostAdd}&articleId=${article.journalArticleId}">
										${article.title} 
									</a> 
									<br /> 
							   </span>
							</div>
						</div>
						<div class="pg-tr-content-news-org" style="margin-top: -10px;">
							<div class="list-content" style="border-bottom: 1px dotted gray;">
							</div>
						</div>
					</c:when>
					<c:when test="${rowCounter.count == sum && sum > 1}">
						<div class="pg-tr-content-news-org">
							<div class="list-content">
								<span class="pg-normal-content-news-org"> <c:choose>
										<c:when test="${isOrgAdmin eq true}">
										  
										    <portlet:renderURL var="editJournalArticles" 
													windowState="<%=WindowState.MAXIMIZED.toString() %>">
											    <portlet:param name="action" value="handleJournal" />
											    <portlet:param name="<%=URLParameter_RS.ORG_ID %>" 
											    	value='${orgId}'/>											    	
											    <portlet:param name="<%=JournalArticle_RS.JA_ID %>" 
											    	value='${article.journalArticleId}'/>
											    <portlet:param name="<%=URLParameter_RS.RETURN_TO_FULL_PAGE_URL %>" 
											    	value='<%=PortalUtil.getCurrentURL(renderRequest) %>'/>
											    <portlet:param name="<%=Constants.CMD%>" value="<%=Constants.UPDATE%>"/>
											</portlet:renderURL>
											
											<img
												src="<%=request.getContextPath()%>/images/news_org/write.png"
												style="vertical-align: bottom;" width="15" height="15" />
											<a	href='<c:out value="${editJournalArticles}"></c:out>'><%=res.getString("repair")%></a>
										</c:when>
									</c:choose> <img src="<%=request.getContextPath()%>/images/dot.png" /> <a
									class="pg-content-link-news-org"
									href="${hostAdd}&articleId=${article.journalArticleId}">
										${article.title} </a> </span>
							</div>
						</div>
					</c:when>

					<c:otherwise>
						<div class="pg-tr-content-news-org">
							<div class="list-content" style="border-bottom: 1px dotted gray;">
								<span class="pg-normal-content-news-org"> <c:choose>
										<c:when test="${isOrgAdmin eq true}">
											<img
												src="<%=request.getContextPath()%>/images/news_org/write.png"
												style="vertical-align: bottom;" width="15" height="15" />
											<a
												href="${repairNewsPath}&articleId=${article.journalArticleId}"><%=res.getString("repair")%></a>
										</c:when>
									</c:choose> <img src="<%=request.getContextPath()%>/images/dot.png" /> <a
									class="pg-content-link-news-org"
									href="${hostAdd}&articleId=${article.journalArticleId}">
										${article.title} </a> </span>
							</div>
						</div>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</div>
	</div>
</div>