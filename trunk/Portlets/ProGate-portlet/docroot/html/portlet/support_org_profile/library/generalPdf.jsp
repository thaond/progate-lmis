<%@ include file="/html/portlet/support_org_profile/init.jsp" %>
<%@ include file="/html/portlet/support_org_profile/createpath.jsp" %>

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
	String articleType = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeOrgSupportPdf();
	String pageNumStr = (String)renderRequest.getAttribute("pageNum");
	int pageNum = Integer.valueOf(pageNumStr);
	
	// thay doi URL
	String currentURL = (String)renderRequest.getAttribute("currentURL");
	int pageIndex = currentURL.indexOf("&pageNum=");
	String pagingURL = (String)currentURL.substring(0, pageIndex);
	renderRequest.setAttribute("pagingURL", pagingURL);
	
	
	int detailIndex = currentURL.indexOf("&actionView=");
	String detailURL = (String)currentURL.substring(0, detailIndex);
	renderRequest.setAttribute("detailURL", detailURL);
	System.out.println("detailURL=" + detailURL);
	
	int articleCount = 10;
    int startArticleNumber = (pageNum - 1)*articleCount;
    int endArticleNumber = startArticleNumber + articleCount;
    int count = 0;
    List<ProGateJournalArticle> listArticles = null;
    try{
   		listArticles = ProGateJournalArticleLocalServiceUtil.
       		 getListProGateArticles(Integer.valueOf(orgId), articleType, "", startArticleNumber, endArticleNumber);
    	if (listArticles != null){
			count = listArticles.size();	
		}
    }catch(Exception e){
    	System.out.println(e.toString());
    }   
	renderRequest.setAttribute("count", count);
	
	if (count > 0){
		renderRequest.setAttribute("listArticles", listArticles);
	}  
	
	
	String hostAdd = PortalUtil.getHost(renderRequest);
	int port = PortalUtil.getPortalPort();
	hostAdd = "http://" + hostAdd + ":" + String.valueOf(port);
	renderRequest.setAttribute("hostAdd", hostAdd);
%>
<div class="org-profile-layout-column-21">	
<div class="news-org">  
	<div class="container">
	      <div class="support-distance">
	      	<img src="<%=request.getContextPath()%>/images/support_org_profile/ark2.png" style="vertical-align:middle;" width="25" height="25"/>
	      	<span class="header">
	      		<%= res.getString("librabry")%> > <%= res.getString("pdf")%>
	      	</span>
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
		 <div class="list-content">
		 	  <c:forEach var="article" items="${listArticles}" varStatus="rowCounter">
		        <div class="folder-news">
		           <img src="<%=request.getContextPath()%>/images/support_org_profile/question.png" style="padding-right:5px;vertical-align: middle;float: left;" width="15" height="15"/>
		           <div class="small-image">
		               <c:if test="${isOrgAdmin eq true}">
		               		<img src="<%=request.getContextPath()%>/images/support_org_profile/write.png" style="vertical-align:bottom;" width="15" height="15" />
		               		<a href="${repairLibrary}&articleId=${article.journalArticleId}&modeType=PDF" ><%= res.getString("repair")%></a>
		               </c:if>
			           <a href="${detailURL}&actionView=detailPdf&articleId=${article.journalArticleId}" class="link-title">
				    		${article.title}
				       </a>
				        <div style="text-align:justify; margin-top: 10px;">
				        	<c:choose>
								<c:when test="${fn:length(article.content) > 320}">
									<c:set value="${fn:substring(article.content, 300, 320)}" var="strTemp" />
									<c:set value="${fn:indexOf(strTemp, ' ')}" var="iTemp" />
									<c:out value="${fn:substring(article.content, 0, 300 + iTemp)}..." escapeXml="false"></c:out>
								</c:when>				
								<c:otherwise>
									<c:out value="${article.content}" escapeXml="false"></c:out>
								</c:otherwise>
							</c:choose>
						</div>
						<div>
							<img src="<%=request.getContextPath()%>/images/support_org_profile/PDF_icon.jpg" style="vertical-align:bottom;" width="25" height="25" />
		                	<a href="${hostAdd}${article.smallImageUrl}" target="_blank">${article.description}</a>
		                </div> 
		           </div>
		           <div style="clear:both;">
		        </div>
		      </c:forEach>
		 </div>
	
		<%
			int sumOfArticle = ProGateJournalArticleLocalServiceUtil.countArticleByType(Integer.valueOf(orgId), articleType, "");
			
			System.out.println("pageNum =" + pageNum);
			int batchPage = 10; // moi trang se the hien 10 trang tiep theo, bat dau la cac so 1, 11, 21
	   		int pagePerPage = 10; // so tin moi trang
	   		// pageNum la so trang hien tai
	   		int startPage = (pageNum/batchPage)*batchPage + 1; // tinh so bat dau nhu la so 1, 11, 21
	   		System.out.println("startPage =" + startPage);
	   		int endPage;
	   		
	   		int totalPageCount;
	   		if (sumOfArticle%pagePerPage == 0){
	   			totalPageCount = sumOfArticle/pagePerPage;
	   		}else{
	   			totalPageCount = sumOfArticle/pagePerPage + 1;
	   		}
	   		// tinh tong cong la co bao nhieu trang
	   		
	   		int remainPageCount = totalPageCount - startPage; // tinh so trang con lai khi di den trang thu 1 hoac trang 11 hoac trang 21
	   		if (remainPageCount > 10){
	   			endPage = batchPage + startPage; // 
	   		}else{
	   			endPage = remainPageCount + startPage;
	   		}
	   		
	   		renderRequest.setAttribute("startPage", startPage);
	   		renderRequest.setAttribute("endPage", endPage);
	   	    renderRequest.setAttribute("batchPage", batchPage);
		%>
	<c:if test="${sumOfArticle > 10}">	
		<div class="paging">
			<a href="${pagingURL}&pageNum=1">
				<%= res.getString("before")%>
			</a>
			<c:choose>
			   <c:when test="${startPage/batchPage >= 1}">
					<a href="javascript:void(0);">
						<c:out value="..." />
					</a>
				</c:when>
			</c:choose>
			<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1" varStatus="rowCounter">
				<c:choose>
					<c:when test="${rowCounter.count <= batchPage}">
						<c:choose>
							<c:when test="${rowCounter.count == pageNum}">
								<a href="${pagingURL}&pageNum=${rowCounter.count}" id="selected">
									<c:out value="${i}" />
								</a>
							</c:when>
							<c:otherwise>
								<a href="${pagingURL}&pageNum=${rowCounter.count}">
									<c:out value="${i}" />
								</a>
							</c:otherwise>
						</c:choose>						
					</c:when>
					<c:otherwise>
						<a href="javascript:void(0);">
							<c:out value="..." />
						</a>
						<a href="${pagingURL}&pageNum=${rowCounter.count + 1}">
							<%= res.getString("after")%>
						</a>
					</c:otherwise>
				</c:choose>		
			</c:forEach>
	   </div>
	</c:if>
</div>
</div>