<%@ include file="init.jsp" %>
<%@ include file="createpath.jsp" %>


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
	// lay cac bai huong dan
	String guildeType = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeOrgSupportGuideline();
	List<ProGateJournalArticle> guildeList = ProGateJournalArticleLocalServiceUtil.getListProGateArticles(Integer.valueOf(orgId), guildeType,
	                                                "", 0, 5);
	int sumOfGuildeArticle = ProGateJournalArticleLocalServiceUtil.countArticleByType(Integer.valueOf(orgId), guildeType, "");
	renderRequest.setAttribute("sumOfGuildeArticle", sumOfGuildeArticle);
	
	int guildeCount = guildeList.size();
	renderRequest.setAttribute("guildeCount", guildeCount);
	
	if (guildeCount > 0){
		renderRequest.setAttribute("guildeList", guildeList);
	}  
	
    // lay cac bai cau hoi
    String questionType = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeOrgSupportFaq();
    List< ProGateJournalArticle> questionList = ProGateJournalArticleLocalServiceUtil.getListProGateArticles(Integer.valueOf(orgId), questionType, "", 0, 5);
    
    int sumOfQuestionArticle = ProGateJournalArticleLocalServiceUtil.countArticleByType(Integer.valueOf(orgId), questionType, "");
	renderRequest.setAttribute("sumOfQuestionArticle", sumOfQuestionArticle);
    
    int questionCount = questionList.size();
    renderRequest.setAttribute("questionCount", questionCount);
    if (questionCount > 0){
    	renderRequest.setAttribute("questionList", questionList);
    }
    
    
    // lay cac video
    String videoType = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeOrgSupportVideo();
    List< ProGateJournalArticle> videoList = ProGateJournalArticleLocalServiceUtil.getListProGateArticles(Integer.valueOf(orgId), videoType, "", 0, 5);
   
    int sumOfVideoArticle = ProGateJournalArticleLocalServiceUtil.countArticleByType(Integer.valueOf(orgId), videoType, "");
	renderRequest.setAttribute("sumOfVideoArticle", sumOfVideoArticle);
   
    int videoCount = videoList.size();
    renderRequest.setAttribute("videoCount", videoCount);
    if (videoCount > 0){
    	renderRequest.setAttribute("videoList", videoList);
    }
    
    // lay cac bai pdf
    String pdfType = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeOrgSupportPdf();
    List< ProGateJournalArticle> pdfList =  ProGateJournalArticleLocalServiceUtil.getListProGateArticles(Integer.valueOf(orgId), pdfType, "", 0, 5);
    
    int sumOfPdfArticle = ProGateJournalArticleLocalServiceUtil.countArticleByType(Integer.valueOf(orgId), pdfType, "");
	renderRequest.setAttribute("sumOfPdfArticle", sumOfPdfArticle);
    
    int pdfCount = pdfList.size();
    renderRequest.setAttribute("pdfCount", pdfCount);
    if (pdfCount > 0){
    	renderRequest.setAttribute("pdfList", pdfList);
    }
    
    // lay cac chatOnline
    String chatOnlineType = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeOrgSupportOnline();
    int sumOfChatOnline = ProGateJournalArticleLocalServiceUtil.countArticleByType(Integer.valueOf(orgId), chatOnlineType, "");
    List< ProGateJournalArticle> chatOnlineList = ProGateJournalArticleLocalServiceUtil.getListProGateArticles(Integer.valueOf(orgId), chatOnlineType, "", 0, sumOfChatOnline);
    renderRequest.setAttribute("sumOfChatOnline", sumOfChatOnline);
    System.out.println("sumOfChatOnline =" + sumOfChatOnline);
    if (sumOfChatOnline > 0){
    	renderRequest.setAttribute("chatOnlineList", chatOnlineList);
    }
%>
<div class="org-profile-layout-column-21">	
	<div class="support-org">
		<div class="container">
		<!-- Phan huong dan -->
	 	
		 	<!-- Tua de -->
		 	<div id="guilde" class="support-distance">
		      	<img src="<%=request.getContextPath()%>/images/support_org_profile/help.png" style="vertical-align:middle;" width="25" height="25"/>
		      	<span class="header">
		      		<a href='${currentURL}&actionView=generalGuilde&pageNum=1' >
		      			<%= res.getString("guilde")%>
		      		</a>
		      	</span>
			      	<span class="add-support-org" >
			      		<c:if test="${isOrgAdmin eq true}">
					    	<a class="pg-content-link" style="color:#30A1BE;" href='${addGuilde}' >
					          <%=res.getString("add")%>
					        </a>
				        </c:if>
				    </span>
			    <div style="border-bottom: 1px dotted gray;"></div>
			 </div>	
		    
		     <!-- Noi dung -->
		     <div class="list-content">
		     	<c:if test="${guildeCount > 0}">		     
		     		 <c:forEach var="guildeArticle" items="${guildeList}" varStatus="rowCounter">
				        <div class="folder-news">
				           <img src="<%=request.getContextPath()%>/images/support_org_profile/next.png" style="padding-right:5px;vertical-align: middle;float: left;" width="15" height="15"/>
				           <div class="small-image">
				           	   <c:if test="${isOrgAdmin eq true}">
				           	   		<img src="<%=request.getContextPath()%>/images/news_org/write.png" style="vertical-align:bottom;" width="15" height="15" />
				           	   		<a href="${repairGuide}&articleId=${guildeArticle.journalArticleId}" ><%= res.getString("repair")%></a>
				           	   </c:if>
					           <a href="${currentURL}&actionView=detailGuilde&articleId=${guildeArticle.journalArticleId}" class="link-title">
						       		${guildeArticle.title}
						       </a>
				           </div>
				        </div>
				        <div style="clear:both;"></div>
				     </c:forEach>
			     </c:if>
			 </div>
			 <c:if test="${(isOrgAdmin eq true) && (sumOfGuildeArticle > 5)}">
			 	<div style="float:right;padding:7px;"><a href="${currentURL}&actionView=generalGuilde&pageNum=1"><%=res.getString("seemore")%></a></div>
			 </c:if>
			 <div style="clear:both;"></div>
		<!-- Ket thuc Phan huong dan -->
		
		
		<!-- Câu Hỏi Thường Gặp -->
			<!-- Tua de -->
		 	<div id="question" style="margin-top:30px;">
		      	<img src="<%=request.getContextPath()%>/images/support_org_profile/cauhoithuonggap.png" style="vertical-align:middle;" width="25" height="25"/>
		      	<span class="header"><a href="${currentURL}&actionView=generalQuestion&pageNum=1"><%= res.getString("question")%></a></span>
		      	<c:if test="${isOrgAdmin eq true}">
			      	<span class="add-support-org">
				    	<a class="pg-content-link" style="color:#30A1BE;" href='${addQuestion}' >
				          <%=res.getString("add")%>
				        </a>
				    </span>
				</c:if>
			    <div style="border-bottom: 1px dotted gray;"></div>
			 </div>	
			 
			 <!-- Noi dung -->
			 <div class="list-content">
				 <c:if test="${questionCount > 0}">
				 	 <c:forEach var="questionArticle" items="${questionList}" varStatus="rowCounter">
				        <div class="folder-news">
				       	   <img src="<%=request.getContextPath()%>/images/support_org_profile/question.png" style="padding-right:5px;vertical-align: middle;float:left;" width="18" height="18"/>
			               <div class="small-image-other">
			               		<c:if test="${isOrgAdmin eq true}">
				        			<img src="<%=request.getContextPath()%>/images/news_org/write.png" style="vertical-align:bottom;" width="15" height="15" />
				        			<a href="${repairQuestion}&articleId=${questionArticle.journalArticleId}" ><%= res.getString("repair")%></a>
				        		</c:if>
			            		<a href="${currentURL}&actionView=detailQuestion&articleId=${questionArticle.journalArticleId}" class="question-link">
				           			${questionArticle.description}
				           		</a>
				            </div>
				        </div>
				        <div style="clear:both;"></div>
				     </c:forEach>
				 </c:if>
			 </div>
			 <c:if test="${(isOrgAdmin eq true) && (sumOfQuestionArticle > 5)}">
			 	<div style="float:right;padding:7px;"><a href="${currentURL}&actionView=generalQuestion&pageNum=1"><%=res.getString("seemore")%></a></div>
			 </c:if>
			 <div style="clear:both;"></div>
		<!-- Ket thuc Câu Hỏi Thường Gặp -->
		
		<!-- Thư Viện Tài Liệu -->
			<!-- Tua de -->
		 	<div id="library" style="margin-top:30px;">
		      	<img src="<%=request.getContextPath()%>/images/support_org_profile/ark2.png" style="vertical-align:middle;" width="25" height="25"/>
		      	<span class="header"><%= res.getString("librabry")%></span>
		      	<c:if test="${isOrgAdmin eq true}">
			      	<span class="add-support-org">
				    	<a class="pg-content-link" style="color:#30A1BE;" href='${addLibrary}' >
				          <%=res.getString("add")%>
				        </a>
				    </span>
			    </c:if>
			    <div style="border-bottom: 1px dotted gray;"></div>
			 </div>	
			 
			 <!-- Noi dung -->
			 	<!-- Video -->
				 <div id="video">
			      	<img src="<%=request.getContextPath()%>/images/support_org_profile/video.ico" style="vertical-align:middle;" width="15" height="15"/>
			      	<span class="header"><a href="${currentURL}&actionView=generalVideo&pageNum=1"><%= res.getString("video")%></a></span>
				 </div>	
				 <div  class="list-content">
				 	<c:if test="${videoCount > 0}">
				 		<c:forEach var="videoArticle" items="${videoList}" varStatus="rowCounter">
					        <div class="folder-news">
					           <div class="under-line">
					           		<c:if test="${isOrgAdmin eq true}">
					           			<img src="<%=request.getContextPath()%>/images/news_org/write.png" style="vertical-align:bottom;" width="15" height="15" />
						           		<a href="${repairLibrary}&articleId=${videoArticle.journalArticleId}&modeType=Video" ><%= res.getString("repair")%></a>
						           </c:if>
				            	   <a href="${currentURL}&actionView=detailVideo&articleId=${videoArticle.journalArticleId}" class="link-title">
				            	   		${videoArticle.title}
				            	   </a>
				            	</div>
					        </div>
					        <div style="clear:both;"></div>
					     </c:forEach>	
				 	</c:if>
				 </div>
				 
				<c:if test="${(isOrgAdmin eq true) && (sumOfVideoArticle > 5)}">
				 	<div style="float:right;padding:7px;"><a href="${currentURL}&actionView=generalVideo&pageNum=1"><%=res.getString("seemore")%></a></div>
				 </c:if>
				 
				 
				 <div style="clear:both;"></div>
				 <div class="inner-dot"></div>
		 
		        <!-- PDF -->	 
			     <div id="pdf">
			      	<img src="<%=request.getContextPath()%>/images/support_org_profile/PDF_icon.jpg" style="vertical-align:middle;" width="15" height="15"/>
			      	<span class="header"><a href="${currentURL}&actionView=generalPdf&pageNum=1"><%= res.getString("pdf")%></a></span>
				 </div>	
				  <div class="list-content">
				  	<c:if test="${pdfCount > 0}">
				  		<c:forEach var="pdfArticle" items="${pdfList}" varStatus="rowCounter">
					        <div class="folder-news">
					           <div class="under-line">
					           		<c:if test="${isOrgAdmin eq true}">
					           			<img src="<%=request.getContextPath()%>/images/news_org/write.png" style="vertical-align:bottom;" width="15" height="15" />
						           		<a href="${repairLibrary}&articleId=${pdfArticle.journalArticleId}&modeType=PDF" ><%= res.getString("repair")%></a>
						           </c:if>
				            		<a href="${currentURL}&actionView=detailPdf&articleId=${pdfArticle.journalArticleId}" class="link-title">
				            			${pdfArticle.title}
				            		</a>
				            	</div>
				            	<div style="clear:both;"></div>
					        </div>
					     </c:forEach>
				  	</c:if>
				 </div>
				<c:if test="${(isOrgAdmin eq true) && (sumOfPdfArticle > 5)}">
				 	<div style="float:right;padding:7px;"><a href="${currentURL}&actionView=generalPdf&pageNum=1"><%=res.getString("seemore")%></a></div>
				 </c:if>
		<!-- Ket thuc Thư Viện Tài Liệu -->
		<div style="clear:both;"></div>
		
			<!-- Hỗ Trợ Trực Tuyến -->
	 	<div id="chatonline" style="margin-top:30px;">
	      	<img src="<%=request.getContextPath()%>/images/support_org_profile/chatonline.png" style="vertical-align:middle;" width="25" height="25"/>
	      	<span class="header"><%= res.getString("chatonline")%></span>
	      	<c:if test="${isOrgAdmin eq true}">
	      		<c:choose>
	      			<c:when test="${sumOfChatOnline >= 1}">
	      				<span class="add-support-org">
				      		<img src="<%=request.getContextPath()%>/images/news_org/write.png" style="vertical-align:bottom;" width="15" height="15" />
			      			<a class="pg-content-link" style="color:#30A1BE;" style="color:#30A1BE;" href='${repairChatOnline}' >
					          <%=res.getString("repair")%>
					        </a>
					    </span>
	      			</c:when>
	      			<c:otherwise>
	      				<span class="add-support-org">
					    	<a class="pg-content-link" style="color:#30A1BE;" href='${addChatOnline}' >
					          <%=res.getString("add")%>
					        </a>
					    </span>
	      			</c:otherwise>
	      		</c:choose>
		    </c:if>
		    <div style="border-bottom: 1px dotted gray;"></div>
		 </div>	
		 <div style="clear:both;"></div>
		   <c:if test="${sumOfChatOnline >= 1 }">
			 	<c:forEach var="person" items="${chatOnlineList}" varStatus="rowCounter">
			 		<div class="chatonline">
			 		 <c:choose>
				          <c:when test="${rowCounter.count == 1}">
				          	<h6 style="text-align: center;">${person.title}</h6>
				          </c:when>
				          <c:otherwise>
				          	<h6 style="padding-left:15px;">${person.title}</h6>
				          </c:otherwise>
			         </c:choose>
			         <div style="padding-top: 10px; padding-bottom:10px; text-align: center;">
					 		${person.content}
					 	</div>
				 	</div>
				 </c:forEach>
			</c:if>
		 	
		<!-- Ket thuc Hỗ Trợ Trực Tuyến -->
		
		</div>	
	</div>
</div>
<script>	
	jQuery("#video").attr("style","margin-top:20px;margin-left:30px;;");
	jQuery("#pdf").attr("style","margin-left:30px;");
	
    jQuery('<span style="padding-right:5px;vertical-align: middle;float:left;padding-left:25px;">-</span>').insertBefore(".under-line");
	
</script>