<fmt:message key="here" bundle="${msg}" var="clickHere" />
<c:choose>
	<c:when test="${filterType == 0}">
		<fmt:message key="none.org.admin" bundle="${msg}" var="emptyList">
		    <fmt:param value='<a class="new-manage-org-link" href="${pageURL}?userType=0&cmd=add">${clickHere}</a>'/>
		    <fmt:param value='<a class="new-manage-org-link" href="${pageURL}?userType=2">${clickHere}</a>'/> 
		</fmt:message>
	</c:when>
	<c:when test="${filterType == 1}">
		<fmt:message key="none.org.member" bundle="${msg}" var="emptyList">
		    <fmt:param value='<a class="new-manage-org-link" href="${pageURL}?userType=0&cmd=add">${clickHere}</a>'/>
		    <fmt:param value='<a class="new-manage-org-link" href="${pageURL}?userType=2">${clickHere}</a>'/> 
		</fmt:message>
	</c:when>
	<c:when test="${filterType == 3}">
		<fmt:message key="no.org.waiting.admin.agree" bundle="${msg}" var="emptyList"/>
	</c:when>
	<c:when test="${filterType == 4}">
		<fmt:message key="no.org.invite.me.join" bundle="${msg}" var="emptyList"/>
	</c:when>
	<c:otherwise>
		<c:set value="" var="emptyList" />
	</c:otherwise>
</c:choose>


<div class="new-manage-org-list-content" style="margin-right: 18px;">
${emptyList}
</div>