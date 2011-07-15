<%@ include file="../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<c:choose>
	<c:when test="${bean.isExistedOrgSet == false }">
		<div style="padding: 17px;">
		<span><fmt:message key="warning.org.none.objective"/></span>
		</div>
		
		<jsp:include page="dialog/dialogCreateObjectiveSet.jsp"></jsp:include>
	</c:when>
	<c:otherwise>
		<jsp:include page="objectivesList.jsp"></jsp:include>
	</c:otherwise>	
</c:choose>
