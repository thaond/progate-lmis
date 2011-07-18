<%@page import="com.larion.progate.news_homepage.constants.News_Const"%>
<%@page import="larion.progate.model.ProGateJournalArticle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/init.jsp" %>
<%@ page import="com.liferay.portal.util.PortalUtil"%>
<style type="text/css">
   <%@ include file="/css/newsOrgProfile.css" %>
</style>
<script type="text/javascript">
	jQuery(function(){	
		jQuery(".blogArticleContent img").each(function(){
			scaleImg(this, 630, 400);
	    });
	});
</script>		
<%
	boolean isAdmin = false;
	int isNewsPage = 0;
	String title = "";
	String description = "";
	String currentUrl = "";
	String detailNewsUrl = "";

	List<ProGateJournalArticle> listNews = null;

	if (request.getAttribute(News_Const.IS_ADMIN) != null) {
		isAdmin = (Boolean) (request.getAttribute(News_Const.IS_ADMIN));
	}
		
	if (request.getAttribute(News_Const.NEWS_PAGE) != null) {
		isNewsPage = (Integer) (request
				.getAttribute(News_Const.NEWS_PAGE));
	}
	if (request.getAttribute(News_Const.LIST_NEWS) != null) {
		listNews = (List<ProGateJournalArticle>) (request
				.getAttribute(News_Const.LIST_NEWS));
	}
	if (request.getAttribute(News_Const.CURRENT_URL) != null) {
		currentUrl = (String) request
				.getAttribute(News_Const.CURRENT_URL);
	}
	if (request.getAttribute(News_Const.DETAIL_NEWS_URL) != null) {
		detailNewsUrl = (String) request
				.getAttribute(News_Const.DETAIL_NEWS_URL);
	}
	int sum = 0;
	if ((listNews != null) && (listNews.size() != 0)) {
		sum = listNews.size();
	}
	request.setAttribute("sum", sum);
	
%>
<fmt:setBundle basename="mes_key"/>
<c:if test="${bean.isMyself }">
	<div class="freezing-navigation">
		<c:choose>
			<c:when test="${bean.viewMode == '0' }">
				<a class="linkb actived"
					href='<c:out value="${bean.viewModeUrl }"></c:out>'> Xem Blog </a>
		    |
		    <a class="linkb"
					href='<c:out value="${bean.editModeUrl }"></c:out>'> Sửa Blog </a>
			</c:when>

			<c:when test="${bean.viewMode == '1' }">
				<a class="linkb "
					href='<c:out value="${bean.viewModeUrl }"></c:out>'> Xem Blog </a>
		    |
		    <a class="linkb actived"
					href='<c:out value="${bean.editModeUrl }"></c:out>'> Sửa Blog </a>
			</c:when>
		</c:choose>
	</div>
</c:if>
<div style="width: 673px; float: left;padding-bottom: 5px;">
<div class="news-org"> 
	 <div class="container">
		 <div style="height:30px;margin-top: 10px; margin-left: 10px;">
		      	<span class="tuade" style="font-size: 16px;"><fmt:message key="news.watchNews"/></span>
		      	<span style="float:right; color: rgb(144, 144, 144);">
			      	<c:set var="updatedAt" value="${article.updatedAt}" />
		       		<fmt:setLocale value="vi_VN"/>
		       		<c:choose>
		       			<c:when test="${updatedAt == null}">
		       			  <fmt:formatDate value="${article.createdAt}" pattern="EEEE, dd/MM/yyyy, hh:mm:ss"/> 
		       			</c:when>
		       			<c:otherwise>
		       			  <fmt:formatDate value="${article.updatedAt}" pattern="EEEE, dd/MM/yyyy, hh:mm:ss"/> 
		       			</c:otherwise>
		       		</c:choose>		
		      	</span>
		      	 
			    <div style="border-bottom: 1px dotted gray; padding-top: 5px;"></div>
		</div>
	      <br />
	      <div style="padding-left: 10px">
	       
		    <c:if test="${isEditable}">
	        	<img src="<%=request.getContextPath()%>/images/news_org/write.png" style="vertical-align:bottom;" width="25" height="25" />
		    	<a href='<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString()%>">							         
											         <portlet:param name="action" value="updateNewsProGate"/>
											         <portlet:param name="<%= News_Const.ARTICLE_ID %>" value="${article.primaryKey }"/>
											         <portlet:param name="<%= News_Const.CURRENT_URL %>" value="<%= currentUrl %>"/>
											         </portlet:renderURL>'><fmt:message key="news.edit"/></a>
	        </c:if>
	         <span style="font-weight:bold;font-size:14px;">${article.title}</span>
	      <br />
        <div class="blogArticleContent">
		${article.content}
	    </div>
		<div style="text-align:right; font-weight: bold;">
			${bean.authorName}
		</div>
	<c:forEach var="article" items="${listNews}" varStatus="rowCounter">  
		<c:if test="${sum > 1}">
			<c:choose>
				<c:when test="${rowCounter.count == 1}">
					<h4 class="alt">Bài viết mới:</h4><div class="dot-line" style="width:592px "></div>		
						<ul class="detail-news">
							<li>
							   <a class="link-othernews" href="<%=detailNewsUrl%>${article.primaryKey}">${article.title}</a>
							   <span style="color: rgb(144, 144, 144);">
                            	    <c:set var="updatedAt" value="${article.updatedAt}" />
						       		<c:choose>
						       			<c:when test="${updatedAt == null}">
						       			 (<fmt:formatDate value="${article.createdAt}" pattern="dd/MM/yyyy"/>)
						       			</c:when>
						       			<c:otherwise>
						       			 (<fmt:formatDate value="${article.updatedAt}" pattern="dd/MM/yyyy"/>) 
						       			</c:otherwise>
						       		</c:choose>	
						       	</span>
                            </li>
				</c:when>
				
				<c:when test="${rowCounter.count == 5}">
							<li>
							    <a class="link-othernews" href="<%=detailNewsUrl%>${article.primaryKey}">${article.title}</a>
 								<span style="color: rgb(144, 144, 144);">
                            		<c:set var="updatedAt" value="${article.updatedAt}" />
						       		<c:choose>
						       			<c:when test="${updatedAt == null}">
						       			  (<fmt:formatDate value="${article.createdAt}" pattern="dd/MM/yyyy"/>) 
						       			</c:when>
						       			<c:otherwise>
						       			  (<fmt:formatDate value="${article.updatedAt}" pattern="dd/MM/yyyy"/>) 
						       			</c:otherwise>
						       		</c:choose>	
                            	</span>
                            </li>
                         </ul>
				</c:when>
				
				<c:when test="${rowCounter.count == 6}">
					<h4 class="alt">Các bài viết khác:</h4><div class="dot-line" style="margin-top: -39px;margin-left: 99px;width: 560px;">
						<a href="<%=currentUrl%>"><span style="float:right;">[Trở về]</span></a></div>
						
						<ul class="detail-news">
							<li>
								<a class="link-othernews" href="<%=detailNewsUrl%>${article.primaryKey}">${article.title}</a>
								<span style="color: rgb(144, 144, 144);">
								 	<c:set var="updatedAt" value="${article.updatedAt}" />
						       		<c:choose>
						       			<c:when test="${updatedAt == null}">
						       			  (<fmt:formatDate value="${article.createdAt}" pattern="dd/MM/yyyy"/>) 
						       			</c:when>
						       			<c:otherwise>
						       			  (<fmt:formatDate value="${article.updatedAt}" pattern="dd/MM/yyyy"/>) 
						       			</c:otherwise>
						       		</c:choose>
					       		</span>	
							</li>
				</c:when>
				<c:when test="${rowCounter.count == sum}">
					<li>
					    <a class="link-othernews" href="<%=detailNewsUrl%>${article.primaryKey}">${article.title}</a>
						<span style="color: rgb(144, 144, 144);">
							 	<c:set var="updatedAt" value="${article.updatedAt}" />
					       		<c:choose>
					       			<c:when test="${updatedAt == null}">
					       			  (<fmt:formatDate value="${article.createdAt}" pattern="dd/MM/yyyy"/>) 
					       			</c:when>
					       			<c:otherwise>
					       			  (<fmt:formatDate value="${article.updatedAt}" pattern="dd/MM/yyyy"/>) 
					       			</c:otherwise>
					       		</c:choose>	
							</li>
						</span>
					</ul>
				</c:when>
				<c:otherwise>
					<li>
					    <a class="link-othernews" href="<%=detailNewsUrl%>${article.primaryKey}">${article.title}</a>
						<span style="color: rgb(144, 144, 144);">
						 	<c:set var="updatedAt" value="${article.updatedAt}" />
				       		<c:choose>
				       			<c:when test="${updatedAt == null}">
				       			  (<fmt:formatDate value="${article.createdAt}" pattern="dd/MM/yyyy"/>) 
				       			</c:when>
				       			<c:otherwise>
				       			  (<fmt:formatDate value="${article.updatedAt}" pattern="dd/MM/yyyy"/>) 
				       			</c:otherwise>
				       		</c:choose>	
			       		</span>
					</li>
				</c:otherwise>
			</c:choose>
		</c:if>
	</c:forEach>
	<div style="margin-top:30px;"></div>
</div>
</div>

