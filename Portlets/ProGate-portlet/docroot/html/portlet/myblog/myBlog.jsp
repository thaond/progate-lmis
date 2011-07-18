<%@page import="larion.progate.model.ProGateJournalArticle"%>
<%@page import="com.larion.progate.news_homepage.constants.News_Const"%>
<%@page
	import="larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil"%>
<%@page
	import="larion.progate.service.ProGateJournalArticleLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="javax.portlet.WindowState"%>
<style type="text/css">
<%@
include file="/css/newsOrgProfile.css"%>
</style>

<%@ include file="../common/init.jsp"%>

<%
	boolean isAdmin = false;
	boolean isEditable = false;
	int isNewsPage = 0;
	String title = "";
	String description = "";
	String currentUrl = "";
	String detailNewsUrl = "";

	List<ProGateJournalArticle> listNews = null;

	if (request.getAttribute(News_Const.IS_EDITABLE) != null) {
		isEditable = (Boolean) (request
				.getAttribute(News_Const.IS_EDITABLE));
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

<fmt:setBundle basename="mes_key" />

<script type="text/javascript">  
	/*
	 * jQuery ready
	 */
	jQuery(function(){
		
		jQuery(".smallImagePreview").each(function(){
			scaleImg(this, 145, 100);
	    });
		
    	// Calendar
		var pickerOpts = {
				showOn: "both",
				yearRange: "-80:+0",
				buttonImage: "<%=request.getContextPath()%>/images/news_org/calendar.gif",
				buttonText: "Open datepicker",
				buttonImageOnly: true,
				dateFormat:"dd/mm/yy",
				onClose: function() {
					document.getElementById("f_date1").focus();
			    }
		    };
    	jQuery("#f_date1").datepicker(pickerOpts); 
   });
	
	
	function pagingSubmit(url){
		url = '<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString()%>">
			<portlet:param name="action" value="showProGateNews" />
		</portlet:renderURL>';
		document.pagingForm.action = url;
		document.pagingForm.submit();
	}
	
	
	jQuery(document).ready(function() {
		jQuery("#itemsPerPage").css("display","none");
	});
</script>
<fmt:setLocale value="vi_VN" />
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
<div style="width: 673px; float: left; padding-bottom: 5px; padding-left: 5px;">
	<div class="news-org">
		<form name="pagingForm" method="post" action="">
			<div class="container">
				<div style="height: 30px; margin-top: 10px; margin-left: 10px">
					<span class="tuade" style="font-size: 16px;"><fmt:message
							key="blog.header" /> </span>
					<c:if test="${isEditable }">
						<span class="add-new-more"> <a class="pg-content-link"
							href='<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString()%>">							         
											         <portlet:param name="action" value="addMyBlog"/>
											         <portlet:param name="<%= News_Const.CURRENT_URL %>" value="<%= currentUrl %>"/>
											         </portlet:renderURL>'>
								<fmt:message key="news.add" /> </a> </span>
					</c:if>
					<div style="border-bottom: 1px dotted gray; padding-top: 5px;"></div>
				</div>
				<div style="padding-left: 10px;">

					<c:forEach var="article" items="${listNews}" varStatus="rowCounter">
						<!-- First new -->

						<!-- Other news -->
						<c:if test="${sum >= 1}">
							<c:choose>
								<c:when test="${sum < 10}">
									
									<c:if
										test="${rowCounter.count >= 1 && rowCounter.count <= sum}">
										<div class="folder-news-pg">
											<div class="news-org-img-border" align="center">
												<a href="<%=detailNewsUrl%>${article.primaryKey}"> <c:set
														var="smallImageUrl" value="${article.smallImageUrl}" /> <c:choose>
														<c:when test="${smallImageUrl == ''}">
															<img alt=""
																src="<%=request.getContextPath()%>/images/news_org/small_noImage.gif">
														</c:when>
														<c:otherwise>
															<img alt="" src="${article.smallImageUrl}" class="smallImagePreview"/>
														</c:otherwise>
													</c:choose> </a>
											</div>
											<div style="text-align: justify;">
												
												<c:choose>
													<c:when test="${isEditable }">
														<span class="edit-acticle"> <img
															src="<%=request.getContextPath()%>/images/news_org/write.png"
															style="vertical-align: bottom;" width="15" height="15" />
															<a
															href='<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString()%>">							         
											         <portlet:param name="action" value="updateMyBlog"/>
											         <portlet:param name="<%= News_Const.ARTICLE_ID %>" value="${article.primaryKey }"/>
											         <portlet:param name="<%= News_Const.CURRENT_URL %>" value="<%= currentUrl %>"/>
											         </portlet:renderURL>'>
																<fmt:message key="news.edit" /> </a> </span>
													</c:when>
												</c:choose>

												<a class="link-title"
													href="<%=detailNewsUrl%>${article.primaryKey}">
													${article.title} </a>

												<div class="asset-metadata"
													style="color: rgb(144, 144, 144);">
													<c:set var="updatedAt" value="${article.updatedAt}" />
													<c:choose>
														<c:when test="${updatedAt == null}">
															<fmt:formatDate value="${article.createdAt}"
																pattern="EEEE, dd/MM/yyyy, hh:mm:ss" />
														</c:when>
														<c:otherwise>
															<fmt:formatDate value="${article.updatedAt}"
																pattern="EEEE, dd/MM/yyyy, hh:mm:ss" />
														</c:otherwise>
													</c:choose>
												</div>
											</div>
											<div style="text-align: justify;">
												<c:choose>
													<c:when test="${fn:length(article.description) > 200}">
														<c:out
															value="${fn:substring(article.description, 0, 200)}..."
															escapeXml="false"></c:out>
													</c:when>
													<c:otherwise>
														<c:out value="${article.description}" escapeXml="false"></c:out>
													</c:otherwise>
												</c:choose>
											</div>
											<div style="clear: both;"></div>
										</div>
									</c:if>
									<!-- end -->
								</c:when>
								<c:otherwise>
									
									<c:if test="${rowCounter.count >= 1 && rowCounter.count < 11}">

										<div class="folder-news-pg">
											<div class="news-org-img-border" align="center">
												<a href="<%=detailNewsUrl%>${article.primaryKey}"> <c:set
														var="smallImageUrl" value="${article.smallImageUrl}" /> <c:choose>
														<c:when test="${smallImageUrl == ''}">
															<img class="img-subject fl" alt=""
																src="<%=request.getContextPath()%>/images/news_org/small_noImage.gif">
														</c:when>
														<c:otherwise>
															<img alt="" src="${article.smallImageUrl}"
																class="smallImagePreview"/>
														</c:otherwise>
													</c:choose> </a>
											</div>
											<div style="text-align: justify;">
												<!-- sua chua-->
												<c:choose>
													<c:when test="${isEditable }">
														<span class="edit-acticle"> <img
															src="<%=request.getContextPath()%>/images/news_org/write.png"
															style="vertical-align: bottom;" width="15" height="15" />
															<a
															href='<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString()%>">							         
											         <portlet:param name="action" value="updateMyBlog"/>
											         <portlet:param name="<%= News_Const.ARTICLE_ID %>" value="${article.primaryKey }"/>
											         <portlet:param name="<%= News_Const.CURRENT_URL %>" value="<%= currentUrl %>"/>
											         </portlet:renderURL>'>
																<fmt:message key="news.edit" /> </a> </span>
													</c:when>
												</c:choose>

												<a class="link-title"
													href="<%=detailNewsUrl%>${article.primaryKey}">
													${article.title} </a>
												<div class="asset-metadata"
													style="color: rgb(144, 144, 144);">
													<c:set var="updatedAt" value="${article.updatedAt}" />
													<c:choose>
														<c:when test="${updatedAt == null}">
															<fmt:formatDate value="${article.createdAt}"
																pattern="EEEE, dd/MM/yyyy, hh:mm:ss" />
														</c:when>
														<c:otherwise>
															<fmt:formatDate value="${article.updatedAt}"
																pattern="EEEE, dd/MM/yyyy, hh:mm:ss" />	
														</c:otherwise>
													</c:choose>
												</div>
											</div>
											<div style="text-align: justify;">
												<c:choose>
													<c:when test="${fn:length(article.description) > 200}">
														<c:out
															value="${fn:substring(article.description, 0, 200)}..."
															escapeXml="false"></c:out>
													</c:when>
													<c:otherwise>
														<c:out value="${article.description}" escapeXml="false"></c:out>
													</c:otherwise>
												</c:choose>
											</div>
											<div style="clear: both;"></div>
										</div>
									</c:if>

									
								</c:otherwise>
							</c:choose>
						</c:if>
						
						<c:if test="${sum >= 11}">
							<c:choose>
								<c:when test="${sum < 16}">
									<!-- Khi co nhieu hon 10 bai nhung it hon 16 bai-->
									<c:if test="${rowCounter.count == 11}">
										<div class="othernews-header">
											<div class="othernews-title fl" style="color: black;">
												<fmt:message key="blog.otherNews" />
											</div>
										</div>
										<div>
											<ul class="general-news">
									</c:if>
									<c:if
										test="${rowCounter.count >= 11 && rowCounter.count <= sum}">
										<li><a class="link-othernews"
											href="<%=detailNewsUrl%>${article.primaryKey}">
												${article.title} </a> <span style="color: rgb(144, 144, 144);">
												<c:set var="updatedAt" value="${article.updatedAt}" /> <c:choose>
													<c:when test="${updatedAt == null}">
					           			  (<fmt:formatDate value="${article.createdAt}"
															pattern="dd/MM/yyyy" />)
					           			</c:when>
													<c:otherwise>
					           			  (<fmt:formatDate value="${article.updatedAt}"
															pattern="dd/MM/yyyy" />)
					           			</c:otherwise>
												</c:choose> </span>
										</li>
									</c:if>
									<c:if test="${rowCounter.count == sum}">
										</ul>
				</div>
				</c:if>
				<!-- End-->
				</c:when>
				<c:otherwise>
					
					<c:if test="${rowCounter.count == 11}">
						<div class="othernews-header">
							<div class="othernews-title fl" style="color: black;">
								<fmt:message key="blog.otherNews" />
							</div>
						</div>
						<div>
							<ul class="general-news">
					</c:if>
					<c:if test="${rowCounter.count >= 11}">
						<li><a class="link-othernews"
							href="<%=detailNewsUrl%>${article.primaryKey}">
								${article.title} </a> <span style="color: rgb(144, 144, 144);">
								<c:set var="updatedAt" value="${article.updatedAt}" /> <c:choose>
									<c:when test="${updatedAt == null}">
					           			 (<fmt:formatDate value="${article.createdAt}"
											pattern="dd/MM/yyyy" />) 
					           			</c:when>
									<c:otherwise>
					           			  (<fmt:formatDate value="${article.updatedAt}"
											pattern="dd/MM/yyyy" />) 
					           			</c:otherwise>
								</c:choose> </span>
						</li>
					</c:if>
					<c:if test="${rowCounter.count == sum}">
						</ul>
			</div>
			</c:if>
		
			</c:otherwise>
			</c:choose>
			</c:if>
			
			</c:forEach>

			<c:if test="${sum >= 1}">
				<div style="padding-top: 20px;" align="right">
					<c:set value="${bean.paginationNews}" var="paging"></c:set>
					<%@ include file="../common/pagination.jsp"%>
				</div>
			</c:if>

		</form>
	</div>
</div>
