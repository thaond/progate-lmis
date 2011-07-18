<%@ include file="../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<c:if test="${bean.isAdminOfOrg}">
<div class="freezing-navigation">
	<c:choose>
		<c:when test="${bean.viewMode == '0' }">
			<a class="linkb actived" href='<c:out value="${bean.viewModeUrl }"></c:out>'>
		    	<fmt:message key="title.mode.view" /></a>
		    |
		    <a class="linkb" href='<c:out value="${bean.editModeUrl }"></c:out>'>
				<fmt:message key="title.mode.edit" /></a>
			<%-- |
			<a class="linkb" href="<c:out value="${bean.configModeUrl }"></c:out>">
				<fmt:message key="title.mode.configuration" /></a>  --%>	
		</c:when>
		
		<c:when test="${bean.viewMode == '1' }">
			<a class="linkb " href='<c:out value="${bean.viewModeUrl }"></c:out>'>
		    	<fmt:message key="title.mode.view" /></a>
		    |
		    <a class="linkb actived" href='<c:out value="${bean.editModeUrl }"></c:out>'>
				<fmt:message key="title.mode.edit" /></a>
			<%-- |
			<a class="linkb" href="<c:out value="${bean.configModeUrl }"></c:out>">
				<fmt:message key="title.mode.configuration" /></a> --%>		    
		</c:when>
			
		<c:otherwise>
			<a class="linkb " href='<c:out value="${bean.viewModeUrl }"></c:out>'>
		    	<fmt:message key="title.mode.view" /></a>
		    |
		    <a class="linkb" href='<c:out value="${bean.editModeUrl }"></c:out>'>
				<fmt:message key="title.mode.edit" /></a>
			<%-- |
			<a class="linkb actived" href="<c:out value="${bean.configModeUrl }"></c:out>">
				<fmt:message key="title.mode.configuration" /></a> --%>
		</c:otherwise>
	</c:choose>	  
</div>
</c:if>