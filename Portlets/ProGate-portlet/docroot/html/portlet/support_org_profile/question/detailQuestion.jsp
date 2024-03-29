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
	
	try{
		String articleType = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeOrgSupportGuideline();
		ProGateJournalArticle article = ProGateJournalArticleLocalServiceUtil.getProGateJournalArticle(
                    							Integer.valueOf(articleId));
        renderRequest.setAttribute("article", article);
%>
<script type="text/javascript">
	jQuery(function(){	
		jQuery(".small-image-other img").each(function(){
			scaleImg(this, 430, 350);
	    });
	});
</script>	
<div class="org-profile-layout-column-21">	
<div class="support-org">  
	 <div class="container">
	 	
	 	 <!-- Phan Cau hoi -->
	 	<div id="guilde" class="support-distance">
	      	<img src="<%=request.getContextPath()%>/images/support_org_profile/cauhoithuonggap.png" style="vertical-align:middle;" width="25" height="25"/>
	      	<span class="header">
	      		<a href='${returnGeneralPath}&actionView=generalQuestion&pageNum=1' >
	      		  <%= res.getString("question")%>
	      		</a>
	      	</span>
	      	<span class="add-support-org" id="repair-question-section">
		    	<c:if test="${isOrgAdmin eq true}">
		    		<img src="<%=request.getContextPath()%>/images/news_org/write.png" style="vertical-align:bottom;" width="15" height="15" />
		    		<a class="pg-content-link" style="color:#30A1BE;" href='${repairQuestion}&articleId=${article.journalArticleId}' ><%=res.getString("repair")%></a>
		    	</c:if>
		    </span>
		    <div style="border-bottom: 1px dotted gray;"></div>
		 </div>	
	 	
	 	 <div class="list-content">
	 	    <div class="folder-news">
	 	       <img src="<%=request.getContextPath()%>/images/support_org_profile/question.png" style="padding-right:5px;vertical-align: middle;float:left;" width="18" height="18"/>
	           <div class="small-image-other">
               		${article.description}
               </div>
	        </div>
        	
        	<div class="folder-news">
	 	       <img src="<%=request.getContextPath()%>/images/support_org_profile/answer.jpg" style="padding-right:5px;vertical-align: middle;float:left;" width="18" height="18"/>
	           <div class="small-image-other" style="text-align: justify ;margin-right: 45px;">
               		${article.content}
               </div>
	        </div>
	       
			<div style="float: right;margin-bottom: 30px;margin-top: 20px;">
				<a href="${returnGeneralPath}&actionView=generalQuestion&pageNum=1">
					<%=res.getString("back")%>
				</a>
			</div>
			<!-- end the author name this article --> 
		</div>
</div>	
</div>
<%
	}catch( Exception e){
		
	}
%>