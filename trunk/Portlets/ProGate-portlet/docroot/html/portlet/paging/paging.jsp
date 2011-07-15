<%--

--%>

<style type="text/css">
   <%@ include file="/css/paging.css" %>
</style>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="paging_scripts.jsp" %>

<div align="right">
	<%-- Only show paging if total pages > 1 --%>	
	<c:if test="${totalPages > 1}">
		
		<%--
		Paging layout: 
		+ firstPage, prevPage	(case when currentPage > 1)
		+ currentPage - 100 	(case when currentPage > 100) 
		+ currentPage - 50 		(case when currentPage > 50)
		+ currentPage - 20 		(case when currentPage > 20)
		+ currentPage - 10 		(case when currentPage > 10)
		+ currentPage - 2, currentPage - 1, currentPage, currentPage + 1, currentPage + 2 
			(in this case, buffer = 2)
		+ currentPage + 10 		(case when (totalPages - currentPage) > 10) 
		+ currentPage + 20 		(case when (totalPages - currentPage) > 20)
		+ currentPage + 50 		(case when (totalPages - currentPage) > 50)
		+ currentPage + 100		(case when (totalPages - currentPage) > 100)
		+ nextPage, lastPage	(case when currentPage < totalPages)   
		 --%>

		<div class="pagenav" align="right">
			<table cellspacing="1" cellpadding="3" border="0" class="tborder">
				<tbody>
				<tr>						
					<td style="font-weight: normal;" class="vbmenu_control">
						<fmt:message bundle="${msg}" key="title.paging.name">
							<fmt:param>${currentPage}</fmt:param>
							<fmt:param>${totalPages}</fmt:param>
						</fmt:message>
					</td>
					
					<%-- parse images to first and previous --%>
					<c:if test="${currentPage > 1}">						
						<td nowrap="nowrap" class="alt1">
							<a title="<fmt:message bundle="${msg}" key="title.paging.tooltips">
								<fmt:param><fmt:message bundle="${msg}" key="title.paging.firstPage" /></fmt:param>
								<fmt:param>${(firstPage - 1) * increment + 1}</fmt:param>
								<fmt:param>${firstPage * increment}</fmt:param>
								<fmt:param>${total}</fmt:param>
							</fmt:message>" 
							href="${urlToRedirect}&${goPage}=${firstPage}" class="pagingfont">
							<strong>&laquo;</strong> <fmt:message bundle="${msg}" key="title.paging.firstPage" /></a>
						</td>
						<td class="alt1">
							<a title="<fmt:message bundle="${msg}" key="title.paging.tooltips">
								<fmt:param><fmt:message bundle="${msg}" key="title.paging.prevPage" /></fmt:param>
								<fmt:param>${(prevPage - 1) * increment + 1}</fmt:param>
								<fmt:param>${prevPage * increment}</fmt:param>
								<fmt:param>${total}</fmt:param>
							</fmt:message>" 
							href="${urlToRedirect}&${goPage}=${prevPage}" class="pagingfont">&lt;</a>
						</td>
					</c:if>
					
					<%-- parse start numbers - all links where currentPage greater than 100, 50, 20, 10 --%>
					<c:forEach var="buff" varStatus="buffSts" items="<%= bufferArrayReverse %>">
						<%-- 
						<c:out value="${buff}" /> 
						--%>
						<c:if test="${currentPage > buff}">
							<c:set value="${currentPage - buff}" var="pageNum" />
							<td class="alt1">
								<a title="<fmt:message bundle="${msg}" key="title.paging.tooltips">
									<fmt:param>${pageNum}</fmt:param>
									<fmt:param>${(pageNum - 1) * increment + 1}</fmt:param>
									<fmt:param>${pageNum * increment}</fmt:param>
									<fmt:param>${total}</fmt:param>
								</fmt:message>" 
								href="${urlToRedirect}&${goPage}=${pageNum}" class="pagingfont">${pageNum}</a>
							</td>
						</c:if>
					</c:forEach>
					
					<%-- parse numbers - all links from (currentPage - buffer) to (currentPage + buffer) --%>
					<c:set value="${currentPage - buffer}" var="startPage"/>
				    <c:if test="${startPage < 1}">
				    	<c:set value="${1}" var="startPage"/>
				    </c:if>
				    <c:set value="${currentPage + buffer}" var="endPage"/>
				    <c:if test="${endPage > totalPages}">
				    	<c:set value="${totalPages}" var="endPage"/>
				    </c:if>
					<c:forEach begin="${startPage}" end="${endPage}" var="pageNum" varStatus="pageSts">						    					    
					    <c:set value="${pageNum * increment}" var="maxRecords"/>
					    <c:if test="${maxRecords > total}">
					    	<c:set value="${total}" var="maxRecords"/>
					    </c:if>
					    
					    <c:if test="${currentPage == pageNum}">
					    	<td class="alt2">
								<span title="<fmt:message bundle="${msg}" key="title.paging.tooltips">
									<fmt:param>${pageNum}</fmt:param>
									<fmt:param>${(pageNum - 1) * increment + 1}</fmt:param>
									<fmt:param>${maxRecords}</fmt:param>
									<fmt:param>${total}</fmt:param>
								</fmt:message>" class="pagingfont">${pageNum}</span>
							</td>
					    </c:if>
					    <c:if test="${currentPage != pageNum}">
					    	<td class="alt1">
								<a title="<fmt:message bundle="${msg}" key="title.paging.tooltips">
									<fmt:param>${pageNum}</fmt:param>
									<fmt:param>${(pageNum - 1) * increment + 1}</fmt:param>
									<fmt:param>${maxRecords}</fmt:param>
									<fmt:param>${total}</fmt:param>
								</fmt:message>" 
								href="${urlToRedirect}&${goPage}=${pageNum}" class="pagingfont">${pageNum}</a>
							</td>					         
					    </c:if>
					</c:forEach>
					
					<%-- parse end numbers - all links where (totalPages - currentPage) greater than 10, 20, 50, 100 --%>
					<c:forEach var="buff" varStatus="buffSts" items="<%= bufferArray %>">
						<%-- 
						<c:out value="${buff}" /> 
						--%>
						<c:if test="${(currentPage + buff) < totalPages}">
							<c:set value="${currentPage + buff}" var="pageNum" />
							<td class="alt1">
								<a title="<fmt:message bundle="${msg}" key="title.paging.tooltips">
									<fmt:param>${pageNum}</fmt:param>
									<fmt:param>${(pageNum - 1) * increment + 1}</fmt:param>
									<fmt:param>${pageNum * increment}</fmt:param>
									<fmt:param>${total}</fmt:param>
								</fmt:message>" 
								href="${urlToRedirect}&${goPage}=${pageNum}" class="pagingfont">${pageNum}</a>
							</td>
						</c:if>
					</c:forEach>
					
					<%-- parse images to next and last --%>
					<c:if test="${currentPage < totalPages}">
						<td class="alt1">
							<a title="<fmt:message bundle="${msg}" key="title.paging.tooltips">
								<fmt:param><fmt:message bundle="${msg}" key="title.paging.nextPage" /></fmt:param>
								<fmt:param>${(nextPage - 1) * increment + 1}</fmt:param>
								<fmt:param>${nextPage * increment}</fmt:param>
								<fmt:param>${total}</fmt:param>
							</fmt:message>" 
							href="${urlToRedirect}&${goPage}=${nextPage}" class="pagingfont">&gt;</a>
						</td>
						<td nowrap="nowrap" class="alt1">
							<a title="<fmt:message bundle="${msg}" key="title.paging.tooltips">
								<fmt:param><fmt:message bundle="${msg}" key="title.paging.lastPage" /></fmt:param>
								<fmt:param>${(totalPages - 1) * increment + 1}</fmt:param>
								<fmt:param>${total}</fmt:param>
								<fmt:param>${total}</fmt:param>
							</fmt:message>" 
							href="${urlToRedirect}&${goPage}=${totalPages}" class="pagingfont">
							<fmt:message bundle="${msg}" key="title.paging.lastPage" /> <strong>&raquo;</strong></a>
						</td>
					</c:if>
					<td title="" class="vbmenu_control"> 
						<span onclick="changeDisplayPageNav()">
						<img border="0" src="<%= request.getContextPath() %>/images/menu_open.gif" title="" alt="" style="cursor: pointer;">
						</span>				
					</td>
				</tr></tbody>
			</table>
		</div>
		
		<div id="pagenav_menu" style="display: none;" align="right">
			<table cellspacing="1" cellpadding="3" border="0" class="vbmenu_popup">
				<tbody>			
					<tr><td nowrap="nowrap" class="thead"><fmt:message bundle="${msg}" key="title.paging.gotoPage" /></td></tr>
					<tr>
						<td title="" class="vbmenu_option" style="padding: 4px;">
							<input type="text" value="${pageNumber}" id="goToPage" onKeyPress="onKeyPress(event);" maxlength="4" size="3"/>
							<input type="button" onclick="pagingGoTo()" value="<fmt:message bundle="${msg}" key="title.paging.go" />"/><br/>
						</td>
					</tr>			
				</tbody>
			</table>
		</div>
	</c:if>
</div>
