<%@ include file="init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="larion.progate.model.Organization"%>
<%@page import="larion.progate.service.OrganizationLocalServiceUtil"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%
	
	String pageNumStr = (String)renderRequest.getParameter("pageNum");
	int pageNum = (pageNumStr == null)? 1 : Integer.valueOf(pageNumStr);
	renderRequest.setAttribute("pageNum", pageNum);
	
	int articleCount = 10;
	int startArticleNumber = (pageNum - 1)*articleCount;
	int endArticleNumber = startArticleNumber + articleCount;
	try{
		List<Organization> orgs = OrganizationLocalServiceUtil.getOrganizations(startArticleNumber, endArticleNumber);
        int count = 0;
        if (orgs != null){
        	count = orgs.size();
        	System.out.println("count = " + count);
        }
        renderRequest.setAttribute("count", count);
        if (count > 0){
        	renderRequest.setAttribute("listOrgs", orgs);
        }
		
	} catch (Exception e) {
		// TODO: handle exception
	}

%>
<div class="right-content">
	<div style="width:100%;">
		<span class="new-manage-org-header">	   
			<%= res.getString("org.admin")%>	 
	 	</span>	
	 	<input type="text" class="new-manage-org-search" maxlength="75" class="text" />	
	 	<button id="timkiem" class="bt-form" style="height:24px;width:80px;">	
			<font size="3pt" style="font-family: sans-serif; font-size: 13px;">
				<%= res.getString("search.org")%>
			</font>
		</button>		
		<div style="border-bottom: 1px dotted gray;margin-top:2px;"></div>		
		<div align="right">
			<a class="new-manage-org-link" href="javascript:void(0);"><%= res.getString("add.org")%></a>
		</div>	
		
		<c:if test="${count > 0}">
			<c:forEach var="org" items="${listOrgs}" varStatus="rowCounter">
				<div class="new-manage-org-folder-news">
					<div class="new-manage-org-logo-org">
						<a href="javascript:void(0);">
							<c:set var="logo" value="${org.logoId}" />
							<c:choose>
								<c:when test="${logo eq '' || logo == null}">
									<img class="logo" src="<%=request.getContextPath()%>/images/new-manage-org/small_noImage.gif" alt="">
								</c:when>
								<c:otherwise>
									<img class="logo" src="${org.logoId}" alt="">
								</c:otherwise>
							</c:choose>
						</a>
					</div>
					<div class="new-manage-org-content">
						<div align="left" class="new-manage-org-name">${org.name}<img src="<%=request.getContextPath()%>/images/new-manage-org/PremierPro.png" class="hightlights-org"></div>
						<div>${org.orgSize} <%=res.getString("member")%>&nbsp;|&nbsp; ${org.city} &nbsp;|&nbsp; ${org.orgType} &nbsp;|&nbsp;  
							<c:set var="updatedAt" value="${org.updatedAt}" />
							<c:choose>
								<c:when test="${updatedAt == null}">
									<fmt:formatDate value="${org.createdAt}" pattern="dd/MM/yyyy"/> 
								</c:when>
								<c:otherwise>
									<fmt:formatDate value="${org.updatedAt}" pattern="dd/MM/yyyy"/> 
								</c:otherwise>
							</c:choose>
						</div>
						<div>
							${org.description}
						</div>
						<div>
							<a href="javascript:void(0);" class="new-manage-org-link"><%=res.getString("user.management")%></a> &nbsp;|&nbsp;
							<a href="javascript:void(0);" class="new-manage-org-link"><%=res.getString("edit")%></a> &nbsp;|&nbsp; 
							<c:set var="status" value="${org.orgStatus}" />
							<c:choose>								
								<c:when test="${status == false}">
									<a href="javascript:void(0);" class="new-manage-org-link"><%=res.getString("enable")%></a>&nbsp; |&nbsp; 
							    </c:when>
							    <c:otherwise>
							    	<a href="javascript:void(0);" class="new-manage-org-link"><%=res.getString("disable")%></a>&nbsp; |&nbsp; 
							    </c:otherwise>
							</c:choose>
							<a href="javascript:void(0);" class="new-manage-org-link"><%=res.getString("delete")%></a>						
						</div>
					</div>					
				</div>	
				<div style="clear:both;"></div>		
			</c:forEach>		
		</c:if>
	</div>	
	
	
	<%
		int sumOfArticle = OrganizationLocalServiceUtil.getOrganizationsCount();
		renderRequest.setAttribute("sumOfArticle", sumOfArticle);
	%>

	<div class="new-manage-org-paging">
			<a href="${currentURL}&pageNum=1">
				<%= res.getString("before")%>
			</a>
		
		   <%
		        
		   		int batchPage = 10; // moi trang se the hien 10 trang tiep theo, bat dau la cac so 1, 11, 21
		   		int pagePerPage = 10; // so tin moi trang
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
								<a href="${currentURL}&pageNum=${rowCounter.count};" id="new-manage-org-selected">
									<c:out value="${i}" />
								</a>
							</c:when>
							<c:otherwise>
								<a href="${currentURL}&pageNum=${rowCounter.count};">
									<c:out value="${i}" />
								</a>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<a href="javascript:void(0);">
							<c:out value="..." />
						</a>
						<a href="${currentURL}&pageNum=${rowCounter.count + 1}">
							<%= res.getString("after")%>
						</a>
					</c:otherwise>
				</c:choose>		
			</c:forEach>
	   </div>
</div>