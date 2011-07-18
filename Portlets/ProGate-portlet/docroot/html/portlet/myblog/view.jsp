<%@page import="org.walluck.oscar.News"%>
<%@page import="com.larion.progate.customer.util.CustomerUtil"%>
<%@page import="larion.progate.model.ProGateJournalArticle"%>
<%@page import="com.larion.progate.news_homepage.constants.News_Const"%>
<%@ include file="../common/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style type="text/css">
   <%@ include file="/css/style.css" %>
</style>
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
	<jsp:include page="detailMyBlog.jsp"></jsp:include>
	</div>
</c:when>
<c:otherwise>
	<jsp:include page="myBlog.jsp"></jsp:include>
</c:otherwise>
</c:choose>
