<%@ include file="/html/portlet/support_org_profile/init.jsp" %>
<%@ include file="/html/portlet/support_org_profile/createpath.jsp" %>
<%@ include file="/html/portlet/support_org_profile/returnpath.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="com.liferay.portal.util.PortalUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page isELIgnored ="false" %> 
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="javax.portlet.PortletPreferences" %>

<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="javax.portlet.ValidatorException" %>
<%@ page import="com.liferay.portlet.PortletPreferencesFactoryUtil" %>


<%
	String journalArticleId = (String)renderRequest.getAttribute("articleId");
	int articleId = Integer.valueOf(journalArticleId);
	
	
	
	String hostAdd = PortalUtil.getHost(renderRequest);
	int port = PortalUtil.getPortalPort();
	hostAdd = "http://" + hostAdd + ":" + String.valueOf(port);
	renderRequest.setAttribute("hostAdd", hostAdd);
	
	try{
		String articleType = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeOrgSupportGuideline();
		ProGateJournalArticle article = ProGateJournalArticleLocalServiceUtil.getProGateJournalArticle(
                    							Integer.valueOf(articleId));
        renderRequest.setAttribute("article", article);
	
%>
<div class="org-profile-layout-column-21">	
<div class="support-org">  
	 <div class="container">
	 	
	 	 <!-- Phan huong dan -->
	 	<div id="guilde" >
	      	<img src="<%=request.getContextPath()%>/images/support_org_profile/help.png" style="vertical-align:middle;" width="25" height="25"/>
	      	<span class="header">
	      		<a href="${returnGeneralPath}&actionView=generalPdf&pageNum=1">	      	
	      			<%= res.getString("librabry")%> > <%= res.getString("pdf")%>	
	      		</a>      		
	      	</span>
	      	<span class="add-support-org">
	      		<c:if test="${isOrgAdmin eq true}">
			    	<a class="pg-content-link" style="color:#30A1BE;" href='${addLibrary}' >
			          <%=res.getString("add")%>
			        </a>
		        </c:if>
		    </span>
		    <div style="border-bottom: 1px dotted gray;"></div>
		 </div>	
	 	
	 	 <div class="list-content">
	 	 
	 	   <c:if test="${isOrgAdmin eq true}">
	        	<img src="<%=request.getContextPath()%>/images/news_org/write.png" style="vertical-align:bottom;" width="25" height="25" />
		    	<a href="${repairLibrary}&articleId=${article.journalArticleId}&modeType=PDF" ><%= res.getString("repair")%></a>
	       </c:if> 
	         <span id="header-detail">${article.title}</span>
	       
	        <div>
				<img src="<%=request.getContextPath()%>/images/support_org_profile/PDF_icon.jpg" style="vertical-align:bottom;" width="25" height="25" />
            	<a href="${hostAdd}${article.smallImageUrl}" target="_blank">${article.description}</a>
            </div> 
		                
	        <div id="content-detail">
			<!-- content this article -->
				${article.content}
			</div>
           
			<!-- end this article --> 
			<!-- the author name this article -->
			<div style="float: right;margin-bottom: 30px;margin-top: 20px;">
				<a href="${returnGeneralPath}&actionView=generalPdf&pageNum=1">
					<%=res.getString("back")%>
				</a>
			</div>
			<!-- end the author name this article --> 
		</div>
</div>	
</div>
<script>
	jQuery("#content-detail").attr("style","margin-top:20px;text-align:justify;");
	jQuery("#header-detail").attr("style","font-weight:bold;font-size:18px;text-align:justify;");
</script>
<%
	}catch( Exception e){
		
	}
%>