
<%@ include file="init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page isELIgnored ="false" %> 


<%@ page import="larion.progate.model.ProGateJournalArticle"%>
<%@ page import="larion.progate.service.ProGateJournalArticleLocalServiceUtil"%>
<%@ page import="larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects/>
  
<%@ page import="java.util.List"%>
<%@ page import="java.util.LinkedList"%>

<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="com.liferay.portal.util.PortalUtil"%> 
<%@ page import="javax.portlet.PortletURL"%>  
<% 
	String viewMode = (String)renderRequest.getAttribute("viewMode");
	
	String pageNumStr = (String)renderRequest.getAttribute("pageNum");
	int pageNum = Integer.valueOf(pageNumStr);
	System.out.println("pageNum=" + pageNum);
	String orgId = (String)renderRequest.getAttribute("orgId");
   
    String articleType = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeNews();
   
    int articleCount = 15;
    int startArticleNumber = (pageNum - 1)*articleCount;
    int endArticleNumber = startArticleNumber + articleCount;
    int sum = 0;
    List<ProGateJournalArticle> listArticles = null;
    try{
   		listArticles = ProGateJournalArticleLocalServiceUtil.
       		 getListProGateArticles(Integer.valueOf(orgId), articleType, "", startArticleNumber, endArticleNumber);
    	if (listArticles != null){
			sum = listArticles.size();	
		}
    }catch(Exception e){
    	System.out.println(e.toString());
    }
	
	
	
	renderRequest.setAttribute("listArticles", listArticles);
	renderRequest.setAttribute("sum", sum);
	System.out.println("sum = " + sum);
	renderRequest.setAttribute("pageNum", Integer.valueOf(pageNum));
	
	
	// tao duong link lien ket den bai
	HttpServletRequest req = PortalUtil.getHttpServletRequest(renderRequest);
	int port = PortalUtil.getPortalPort();
	
	String hostAdd = PortalUtil.getHost(req);
	hostAdd = "http://" + hostAdd + ":" + String.valueOf(port) + "/tochuc/tintuc?orgId=" + orgId + "&viewMode=" + viewMode;
	
	renderRequest.setAttribute("hostAdd", hostAdd.toString());
	System.out.println("hostAdd = " + hostAdd);
	
	// tao duong link sua chua
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.MAXIMIZED);	
	portletURL.setParameter("struts_action", "/NewsOrgProfile/repairNews");
	portletURL.setParameter("orgId", orgId);
    portletURL.setParameter("viewMode", viewMode);
    
	renderRequest.setAttribute("repairNewsPath", portletURL);
%>
  
<script type="text/javascript">  
	/*
	 * jQuery ready
	 */
	jQuery(function(){
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
</script>

<fmt:setLocale value="vi_VN"/>
<div class="org-profile-layout-column-21">  
<div class="news-org">  
	<div class="container">
	      <div style="height:30px;margin-top: 10px;">
	      	<img src="<%=request.getContextPath()%>/images/news_org/global.png" style="vertical-align:middle;" width="25" height="25"/>
	      	<span class="tuade"><%= res.getString("news")%></span>
	      	 <c:if test="${isOrgAdmin eq true}">
			    <span class="add-new-more">
			    	<a class="pg-content-link" style="color:#30A1BE;" href='<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString()%>">							         
											         	<portlet:param name="struts_action" value="/NewsOrgProfile/addNews"/>
											         	<portlet:param name="orgId" value="${orgId}"/>
											         	<portlet:param name="viewMode" value="${viewMode}"/>
											         </portlet:renderURL>' >
			          <%=res.getString("addNews")%>
			        </a>
			    </span>
			  </c:if>
		    <div style="border-bottom: 1px dotted gray;"></div>
		  </div>	
		<c:forEach var="article" items="${listArticles}" varStatus="rowCounter">  
		  <!-- First new -->
			<c:choose>
				<c:when test="${rowCounter.count <= 5}">
				  <div class="folder-news"> 				  
			  	 	  <div class="news-org-img-border" align="center">       
		               	  	<a href="${hostAdd}&articleId=${article.journalArticleId}">
		               	  		<c:set var="smallImageUrl" value="${article.smallImageUrl}"/>
			          			<c:choose>
			          				<c:when test="${smallImageUrl == '' || smallImageUrl == null}">
		                    			<img alt="" src="<%=request.getContextPath()%>/images/news_org/small_noImage.gif">
		                 			</c:when>
				          		    <c:otherwise>
				          		    	<div>
				          		    	<img alt="" src="${article.smallImageUrl}" onLoad='scaleImg(this, 145, 100)' style="display: none;">
		                 				</div>
		                 			</c:otherwise>
			          			</c:choose>
		                 	 </a>
	                  </div>
	                  
	                  <div style="text-align: justify;"> 
	                  	 	<!-- sua chua-->
						    <c:choose>
							    <c:when test="${isOrgAdmin eq true}">
				                  	<img src="<%=request.getContextPath()%>/images/news_org/write.png" style="vertical-align:bottom;" width="25" height="25"/>
								    <a href="${repairNewsPath}&articleId=${article.journalArticleId}"><%= res.getString("repair")%></a>
			                    </c:when>
		                    </c:choose>
		                    
		                    <a class="link-title" href="${hostAdd}&articleId=${article.journalArticleId}">
		                    	${article.title}
		                    </a>
	                    
				          	<div class="asset-metadata">
					            <c:set var="updatedAt" value="${article.updatedAt}" />
				           		<c:choose>
				           			<c:when test="${updatedAt == null}">
				           			  <fmt:formatDate value="${article.createdAt}" pattern="EEEE, dd/MM/yyyy, hh:mm:ss" /> 
				           			</c:when>
				           			<c:otherwise>
				           			  <fmt:formatDate value="${article.updatedAt}" pattern="EEEE, dd/MM/yyyy, hh:mm:ss" /> 
				           			</c:otherwise>
				           		</c:choose>		
				            </div>
			          </div> 		          
	                  <div style="text-align:justify;">
		                 ${article.description}
		              </div>
		              <div style="clear:both;"></div>
		           </div>
				</c:when>
				
				<c:when test="${rowCounter.count == 6}">
					<div class="othernews-header">
			           <div class="othernews-title fl"><%= res.getString("othernews")%></div>
			         </div>
			         <div>
			           <ul class="general-news">
			           	 <li>
			               <a class="link-othernews" href="${hostAdd}&articleId=${article.journalArticleId}">
			               		${article.title}
			               </a>
			               <span style="color: rgb(144, 144, 144);">&nbsp;
			                 <c:set var="updatedAt" value="${article.updatedAt}" />
			           		 <c:choose>
			           			<c:when test="${updatedAt == null}">
			           			  <fmt:formatDate value="${article.createdAt}" pattern="dd/MM/yyyy" /> 
			           			</c:when>
			           			<c:otherwise>
			           			  <fmt:formatDate value="${article.updatedAt}" pattern="dd/MM/yyyy" /> 
			           			</c:otherwise>
			           		 </c:choose>	
			               </span>
			             </li>
				</c:when>
				<c:when test="${rowCounter.count > 6}">
					<li>
		               <a class="link-othernews" href="${hostAdd}&articleId=${article.journalArticleId}">
		               		${article.title}
		               </a>
		               <span style="color: rgb(144, 144, 144);">&nbsp;
		                 <c:set var="updatedAt" value="${article.updatedAt}" />
		           		 <c:choose>
		           			<c:when test="${updatedAt == null}">
		           			  <fmt:formatDate value="${article.createdAt}" pattern="dd/MM/yyyy"/> 
		           			</c:when>
		           			<c:otherwise>
		           			  <fmt:formatDate value="${article.updatedAt}" pattern="dd/MM/yyyy"/> 
		           			</c:otherwise>
		           		 </c:choose>	
		               </span>
		             </li>
				</c:when>			   
			</c:choose>
		<!-- End List Other news -->
        </c:forEach>  
        <c:if test="${sum >= 6}">
        		</ul> 
			</div> 
        </c:if>   
<%
	int sumOfArticle = ProGateJournalArticleLocalServiceUtil.countArticleByType(Integer.valueOf(orgId), articleType, null);
	renderRequest.setAttribute("sumOfArticle", sumOfArticle);
%>
<c:if test="${sumOfArticle > 15}">	
	<form action="" method="post" name="informationOrg">
		<TABLE BORDER="0" CELLSPACING="0" CELLPADDING="0" style=" margin-bottom: 30px;margin-top: 30px;">
			<tr>
		    	<td class="label"><%= res.getString("oldnews")%></td>
		    	<td>
		    	  <div class="inputtype">
		    	    <INPUT type="text" name="f_date1" id="f_date1" class="inputtext" 
			    	           maxlength="70" />
		    	   
					 <input type="button" id="watch" name="watch" value="<%= res.getString("watch")%>" class="bt-form" style="margin-left: 10px;margin-top: 3px;width:75px;"/><br />   					    			    					    				
					 <div id="checkEstablishDate" style="display:none;clear:both;"></div>									    		
			      </div>								    	
		    	</td>							    	
		   </tr>
		</table>
	</form>



	<form action="<portlet:actionURL>
		               <portlet:param name="struts_action" value="/InformationOrg/UpdateAction" />
		               <portlet:param name="orgId" value="${orgId}" />
		               <portlet:param name="action" value="" />
		          </portlet:actionURL>" method="post" name="informationOrg">
		<div class="paging">
			<a href="${hostAdd}&pageNum=1">
				<%= res.getString("before")%>
			</a>
		
		   <%
		        
		   		int batchPage = 10; // moi trang se the hien 10 trang tiep theo, bat dau la cac so 1, 11, 21
		   		int pagePerPage = 15; // so tin moi trang
		   		// pageNum la so trang hien tai
		   		int startPage = (pageNum/batchPage)*batchPage + 1; // tinh so bat dau nhu la so 1, 11, 21
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
								<a href="${hostAdd}&pageNum=${pageNum}" id="selected">
									<c:out value="${i}" />
								</a>
							</c:when>
							<c:otherwise>
								<a href="${hostAdd}&pageNum=${rowCounter.count}">
									<c:out value="${i}" />
								</a>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<a href="javascript:void(0);">
							<c:out value="..." />
						</a>
						<a href="${hostAdd}&pageNum=${rowCounter.count + 1}">
							<%= res.getString("after")%>
						</a>
					</c:otherwise>
				</c:choose>		
			</c:forEach>
	   </div>
	</form>
</c:if>
</div>
</div>