<div class="tnt-paging">
	<div style="display: inline">
		[ <c:out value="${paging.fromPage}"/> - <c:out value="${paging.toPage}" /> of <c:out value="${paging.totalRecord}" /> ] &nbsp;
	</div>
	<div style="display: inline" class="pagination">
		<c:choose>
			<c:when test="${paging.currentPage == 1 || paging.currentPage == 0}">
				<span class="disabled_prev_page"><img alt="Prev_button_notclick"
					  src="<%=request.getContextPath() %>/images/prev_button_notclick.gif">
				</span>
			</c:when>
			<c:otherwise>
				<a class="prev_page" href="javascript:void()" >
				<img alt="Prev_button" src="<%=request.getContextPath() %>/images/prev_button.gif"></a>
			</c:otherwise>
		</c:choose>									
		<c:forEach items="${paging.pageList}" var="page">
		<c:choose>
			<c:when test="${page == paging.currentPage}">
				<span><c:out value="${page}"></c:out></span>									
			</c:when>
			<c:otherwise>
				<a href="javascript:void()" class="goToLinkPage">
					<c:out value="${page}"></c:out>
				</a>&nbsp;
			</c:otherwise>
		</c:choose>
		</c:forEach>
		<c:choose>
			<c:when test="${paging.currentPage == paging.numOfPage}">
				<span class="disabled_next_page"><img alt="Next_button_notclick"
					  src="<%=request.getContextPath() %>/images/next_button_notclick.gif">
				</span>
			</c:when>
			<c:otherwise>
				<a class="next_page" href="javascript:void()" >
				<img alt="Next_button" src="<%=request.getContextPath() %>/images/next_button.gif"></a>
			</c:otherwise>
		</c:choose>					
	</div>
	
	<span style="padding-top: 5px">&nbsp;
		<input style="width: 40px; display: inline; height: 18px; font-size: 10px;" 
			class="txtPageNum" type="text" maxlength="3" 
			onkeypress="return isNumberKey(event)" >&nbsp;
	</span>
	<span style="height: 18px; cursor: pointer" class="bt-go-pagging">&nbsp;&nbsp;&nbsp;</span>
	 
</div>

<input type="hidden" name="${paging.currentPageName }" value="${paging.currentPage }"/>