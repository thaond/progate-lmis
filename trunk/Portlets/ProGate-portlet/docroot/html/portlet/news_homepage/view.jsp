<%@page import="org.walluck.oscar.News"%>
<%@page import="com.larion.progate.customer.util.CustomerUtil"%>
<%@page import="larion.progate.model.ProGateJournalArticle"%>
<%@page import="com.larion.progate.news_homepage.constants.News_Const"%>
<%@ include file="../common/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	boolean isAdmin = false;
	int isNewsPage = 0;
	String title = "";
	String description = "";
	String currentUrl = "";
	String detailNewsUrl = "";
	
	List<ProGateJournalArticle> listNews = null;
	String homeUrl= PortalUtil.getPortalURL(request);
	String newsPage = homeUrl + News_Const.NEWS_PAGE;
	
	if(request.getAttribute(News_Const.IS_ADMIN) != null){
		isAdmin = (Boolean)(request.getAttribute(News_Const.IS_ADMIN));
	}
	if(request.getAttribute(News_Const.NEWS_PAGE) != null){
		isNewsPage = (Integer)(request.getAttribute(News_Const.NEWS_PAGE));
	}
	if(request.getAttribute(News_Const.LIST_NEWS) != null){
		listNews = (List<ProGateJournalArticle>)(request.getAttribute(News_Const.LIST_NEWS));
	}
	if(request.getAttribute(News_Const.CURRENT_URL) != null){
		currentUrl = (String)request.getAttribute(News_Const.CURRENT_URL);
	}
	if(request.getAttribute(News_Const.DETAIL_NEWS_URL) != null){
		detailNewsUrl = (String)request.getAttribute(News_Const.DETAIL_NEWS_URL);
	}
	int sum = 0;
	if ((listNews != null) && (listNews.size() !=0)){
		sum = listNews.size();
	}
	 request.setAttribute("sum", sum);
%>

<fmt:setBundle basename="mes_key"/>
<c:choose>
<c:when test="${isNewsPage == 1}">
	<div style="padding-left: 6px">
		<jsp:include page="newsPage.jsp"></jsp:include>
	</div>
</c:when>
<c:when test="${isNewsPage == 2}">
	<div style="padding-left: 6px">
	<jsp:include page="detailArticle.jsp"></jsp:include>
	</div>
</c:when>
<c:otherwise>
<div class="news-common-layout">
	<div class="news-header-background">
		<a href="${currentURL }" style="text-decoration: none;"><span class="news-header-content"><fmt:message key="news"/></span></a>
	</div>
	<%
	ProGateJournalArticle firstArticle = null;
	if((listNews != null) && (listNews.size() != 0)){
		firstArticle = listNews.get(0);
		String des = firstArticle.getDescription();
		String trunCatDes = CustomerUtil.truncate(des,300,"...");
		
	%>
	<div class="news-body">
		<div class="news-layout-left">
			<div class="news-img-left">
				<img alt=""
					class="newsBigImage" onLoad='scaleImg(this, 300, 200)'
					src="<%=firstArticle.getSmallImageUrl() %>" style="display: none;">
			</div>
			<div class="news-content-left">
			<c:if test="${isAdmin}">
		  		<img src="<%=request.getContextPath()%>/images/news_org/write.png" style="vertical-align:bottom;" width="25" height="25" />
		   		<a href='<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString()%>">							         
					         <portlet:param name="action" value="updateNewsProGate"/>
					         <portlet:param name="<%= News_Const.ARTICLE_ID %>" value="<%= Integer.toString(firstArticle.getPrimaryKey()) %>"/>
					         <portlet:param name="<%= News_Const.CURRENT_URL %>" value="<%= currentUrl %>"/>
				         </portlet:renderURL>' style="text-decoration: none;"><fmt:message key="news.edit"/></a>
			 </c:if><a href="<%= detailNewsUrl + firstArticle.getPrimaryKey() %>" style="text-decoration: none;"><span style="font-weight: bold; padding-bottom: 2px;color: black;"><%= firstArticle.getTitle() %></span></a></div>
			<div class="news-content-left">
				<span><%= trunCatDes %></span>
			</div>
		</div>
		<div class="news-layout-right">
		<%
			int countList = 0;
			if(listNews.size() >= 5){
				countList = 5;
			}else{
				countList = listNews.size();
			}
			for(int i = 1; i < countList; i++){
			
		%>
			<div class="news-right">
				<div class="news-img-right">
					<img alt=""
						class="newsSmallImage" onLoad='scaleImg(this, 100, 70)'
						src="<%=listNews.get(i).getSmallImageUrl() %>" style="display: none;">
				</div>
				<div class="news-content-right">
				<c:if test="${isAdmin}">
			  		<img src="<%=request.getContextPath()%>/images/news_org/write.png" style="vertical-align:bottom;" width="25" height="25" />
			   		<a href='<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString()%>">							         
						         <portlet:param name="action" value="updateNewsProGate"/>
						         <portlet:param name="<%= News_Const.ARTICLE_ID %>" value="<%= Integer.toString(listNews.get(i).getPrimaryKey()) %>"/>
						         <portlet:param name="<%= News_Const.CURRENT_URL %>" value="<%= currentUrl %>"/>
							 </portlet:renderURL>' style="text-decoration: none;"><fmt:message key="news.edit"/></a>
			 	</c:if><a href="<%= detailNewsUrl + listNews.get(i).getPrimaryKey() %>" style="text-decoration: none; color: black;"><span><%= listNews.get(i).getTitle() %> </span></a>
				</div>
			</div>
			<br/>
			<div class="news-row-line"></div>
		<%
			}
		%>	
			
		</div>
	</div>	
	
	<% } %>
</div>	
</c:otherwise>
</c:choose>
