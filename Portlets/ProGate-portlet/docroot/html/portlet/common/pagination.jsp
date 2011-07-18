<c:if test="${paging.numOfPage > 0}">
<div class="tnt-pagination taglib-page-iterator">
	<div class="search-results">
		<fmt:message key="title.pagination.showing"/>
		
		<c:out value="${paging.fromPage}"/> - <c:out value="${paging.toPage}" /> <fmt:message key="title.pagination.of"/> <c:out value="${paging.totalRecord}" />
		
		<fmt:message key="title.pagination.result"/>
	</div>
	
	<div class="search-pages">
		<div class="delta-selector" id="itemsPerPage">
			<fmt:message key="title.pagination.items.per.page"/>
			
			<select name="${paging.pageSizeName}">
				<c:forEach items="${paging.itemsPerPage}" var="item">
					<c:choose>
						<c:when test="${item == paging.pageSize}">
							<option selected="selected" value="${item}">
								<c:out value="${item}"></c:out>
							</option>
						</c:when>
						
						<c:otherwise>
							<option value="${item}">
								<c:out value="${item}"></c:out>
							</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
		</div>
		
		<div class="page-selector">
			<fmt:message key="title.pagination.page"/>
			
			<select name="${paging.currentPageName}">
				<c:forEach items="${paging.pageList}" var="page">
					<c:choose>
						<c:when test="${page == paging.currentPage}">
							<option selected="selected" value="${page}">
								<c:out value="${page}"></c:out>
							</option>
						</c:when>
						
						<c:otherwise>
							<option value="${page}">
								<c:out value="${page}"></c:out>
							</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
		</div>
		
		<div class="page-links">
			<c:choose>
				<c:when test="${paging.currentPage == 1 || paging.currentPage == 0}">
					<span class="first">
						<fmt:message key="title.pagination.first"/>
					</span>
					
					<span class="previous">
						<fmt:message key="title.pagination.previous"/>
					</span>
				</c:when>
				
				<c:otherwise>
					<a class="first" href="#">
						<fmt:message key="title.pagination.first"/>
					</a>
					
					<a class="previous" href="#">
						<fmt:message key="title.pagination.previous"/>
					</a>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${paging.currentPage == paging.numOfPage}">
					<span class="next">
						<fmt:message key="title.pagination.next"/>
					</span>
					
					<span class="last">
						<fmt:message key="title.pagination.last"/>
					</span>
				</c:when>
				
				<c:otherwise>
					<a class="next" href="#">
						<fmt:message key="title.pagination.next"/>
					</a>
					
					<a class="last" href="#">
						<fmt:message key="title.pagination.last"/>
					</a>
				</c:otherwise>
			</c:choose>		
		</div>
	</div>
</div>
</c:if>