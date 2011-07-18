
<%@ include file="init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page isELIgnored ="false" %> 

<%@ page import="larion.progate.model.User"%>
<%@ page import="larion.progate.service.UserLocalServiceUtil"%>
<%@ page import="larion.progate.model.ProGateJournalArticle"%>
<%@ page import="larion.progate.service.ProGateJournalArticleLocalServiceUtil"%>
<%@ page import="larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil"%>
<%@ page import="java.util.List"%>

<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="com.liferay.portal.util.PortalUtil"%> 
<%@ page import="javax.portlet.PortletURL"%> 

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects/>

	
<%
	String journalArticleId = (String)renderRequest.getAttribute("articleId");
	int articleId = Integer.valueOf(journalArticleId);
	String authorName = "";
	
	String viewMode = (String)renderRequest.getAttribute("viewMode");
		// tao duong link sua chua
	String orgId = (String)renderRequest.getAttribute("orgId"); 
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.MAXIMIZED);	
	portletURL.setParameter("struts_action", "/NewsOrgProfile/repairNews");
	portletURL.setParameter("orgId", orgId);
    portletURL.setParameter("viewMode", viewMode);
	renderRequest.setAttribute("repairNewsPath", portletURL);
	
	// tao link di ra ngoai
	HttpServletRequest req = PortalUtil.getHttpServletRequest(renderRequest);
	int port = PortalUtil.getPortalPort();
	
	String hostAdd = PortalUtil.getHost(req);
	
	hostAdd = "http://" + hostAdd + ":" + String.valueOf(port) + "/tochuc/tintuc?orgId=" + orgId + "&viewMode=" + viewMode;
	
	renderRequest.setAttribute("hostAdd", hostAdd);
	
	try{
		ProGateJournalArticle article = ProGateJournalArticleLocalServiceUtil.getProGateJournalArticle(articleId);
		User user = UserLocalServiceUtil.getUser(article.getCreatedBy());
		authorName = user.getFirstname() + " " + user.getLastname();
		renderRequest.setAttribute("authorName", authorName);
		renderRequest.setAttribute("article", article);
%>

<div class="org-profile-layout-column-21">   
<div class="news-org"> 
	 <div class="container">
	      <span style="float:right;">
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
	      <br /><br />
	        <!-- -->
		    <c:if test="${isOrgAdmin eq true}">
	        	<img src="<%=request.getContextPath()%>/images/news_org/write.png" style="vertical-align:bottom;" width="25" height="25" />
		    	<a href="${repairNewsPath}&articleId=${article.journalArticleId}" ><%= res.getString("repair")%></a>
	        </c:if>
	        
	         <span style="font-weight:bold;font-size:18px;">${article.title}</span>
	      <br /><br />
	<!-- content this article -->
		${article.content}
	<!-- end this article --> 
	<!-- the author name this article -->
		<div style="text-align:right; font-weight: bold;">
			${authorName}
		</div>
	<!-- end the author name this article --> 
<!--  <h4 class="alt">Theo dòng sự kiện:</h4>
	<ul class="detail-news">
		<li>Donec molestie faucibus velit, at euismod justo congue eget (02/12)</li>
		<li>Donec molestie faucibus velit, at euismod justo congue eget (02/12)</li>
		<li>Donec molestie faucibus velit, at euismod justo congue eget (02/12)</li>
		<li>Donec molestie faucibus velit, at euismod justo congue eget (02/12)</li>
	</ul>
-->		
	<%
	    String articleType = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeNews();
		int articleCount = 15;
		int sum = 0;
		List<ProGateJournalArticle> listArticles = null;
	    try{
	   		listArticles = ProGateJournalArticleLocalServiceUtil.
	       		 getListProGateArticles(Integer.valueOf(orgId), articleType, "", 0, articleCount);
	    	if (listArticles != null){
				sum = listArticles.size();	
			}
	    }catch(Exception e){
	    	System.out.println(e.toString());
	    }
	    renderRequest.setAttribute("listArticles", listArticles);
	    renderRequest.setAttribute("sum", sum);
	%>
	
	<c:forEach var="article" items="${listArticles}" varStatus="rowCounter">  
		<c:if test="${sum > 1}">
			<c:choose>
				<c:when test="${rowCounter.count == 1}">
					<h4 class="alt">Tin mới:</h4><div class="dot-line"></div>		
						<ul class="detail-news">
							<li>
							   <a class="link-othernews" href="${hostAdd}&articleId=${article.journalArticleId}">${article.title}</a>
							   <span style="color: rgb(144, 144, 144);">&nbsp;
                            	    <c:set var="updatedAt" value="${article.updatedAt}" />
						       		<c:choose>
						       			<c:when test="${updatedAt == null}">
						       			  <fmt:formatDate value="${article.createdAt}" type="both" dateStyle="full" timeStyle="short" 
						       			  		timeZone="[B]US/Eastern[/B]"/> 
						       			</c:when>
						       			<c:otherwise>
						       			  <fmt:formatDate value="${article.updatedAt}" type="both" dateStyle="full" timeStyle="short" 
						       			  	timeZone="[B]US/Eastern[/B]"/> 
						       			</c:otherwise>
						       		</c:choose>	
						       	</span>
                            </li>
				</c:when>
				
				<c:when test="${rowCounter.count == 5}">
							<li>
							    <a class="link-othernews" href="${hostAdd}&articleId=${article.journalArticleId}">${article.title}</a>
 								<span style="color: rgb(144, 144, 144);">&nbsp;
                            		<c:set var="updatedAt" value="${article.updatedAt}" />
						       		<c:choose>
						       			<c:when test="${updatedAt == null}">
						       			  <fmt:formatDate value="${article.createdAt}" type="both" dateStyle="full" timeStyle="short" 
						       			  		timeZone="[B]US/Eastern[/B]"/> 
						       			</c:when>
						       			<c:otherwise>
						       			  <fmt:formatDate value="${article.updatedAt}" type="both" dateStyle="full" timeStyle="short" 
						       			  	timeZone="[B]US/Eastern[/B]"/> 
						       			</c:otherwise>
						       		</c:choose>	
                            	</span>
                            </li>
                         </ul>
				</c:when>
				
				<c:when test="${rowCounter.count == 6}">
					<h4 class="alt" style="margin-top:3.25em;">Các tin khác:</h4><div class="dot-line" style="margin-top: -39px;margin-left: 99px;width: 520px;">
						<a href="${hostAdd}"><span style="float:right;">[Trở về]</span></a></div>
						
						<ul class="detail-news">
							<li>
								<a class="link-othernews" href="${hostAdd}&articleId=${article.journalArticleId}">${article.title}</a>
								<span style="color: rgb(144, 144, 144);">&nbsp;
								 	<c:set var="updatedAt" value="${article.updatedAt}" />
						       		<c:choose>
						       			<c:when test="${updatedAt == null}">
						       			  <fmt:formatDate value="${article.createdAt}" type="both" dateStyle="full" timeStyle="short" 
						       			  		timeZone="[B]US/Eastern[/B]"/> 
						       			</c:when>
						       			<c:otherwise>
						       			  <fmt:formatDate value="${article.updatedAt}" type="both" dateStyle="full" timeStyle="short" 
							       			  	timeZone="[B]US/Eastern[/B]"/> 
						       			</c:otherwise>
						       		</c:choose>
					       		</span>	
							</li>
				</c:when>
				<c:when test="${rowCounter.count == sum}">
					<li>
					    <a class="link-othernews" href="${hostAdd}&articleId=${article.journalArticleId}">${article.title}</a>
						<span style="color: rgb(144, 144, 144);">&nbsp;
							 	<c:set var="updatedAt" value="${article.updatedAt}" />
					       		<c:choose>
					       			<c:when test="${updatedAt == null}">
					       			  <fmt:formatDate value="${article.createdAt}" type="both" dateStyle="full" timeStyle="short" 
					       			  		timeZone="[B]US/Eastern[/B]"/> 
					       			</c:when>
					       			<c:otherwise>
					       			  <fmt:formatDate value="${article.updatedAt}" type="both" dateStyle="full" timeStyle="short" 
					       			  	timeZone="[B]US/Eastern[/B]"/> 
					       			</c:otherwise>
					       		</c:choose>	
							</li>
						</span>
					</ul>
				</c:when>
				<c:otherwise>
					<li>
					    <a class="link-othernews" href="${hostAdd}&articleId=${article.journalArticleId}">${article.title}</a>
						<span style="color: rgb(144, 144, 144);">&nbsp;
						 	<c:set var="updatedAt" value="${article.updatedAt}" />
				       		<c:choose>
				       			<c:when test="${updatedAt == null}">
				       			  <fmt:formatDate value="${article.createdAt}" type="both" dateStyle="full" timeStyle="short" 
				       			  		timeZone="[B]US/Eastern[/B]"/> 
				       			</c:when>
				       			<c:otherwise>
				       			  <fmt:formatDate value="${article.updatedAt}" type="both" dateStyle="full" timeStyle="short" 
				       			  	timeZone="[B]US/Eastern[/B]"/> 
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
<%	
    }catch(Exception e){
	 	System.out.println(e.toString());
	}
%>
