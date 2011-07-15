<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<c:if test="${bean.page == 1}">
	<jsp:include page="/html/portlet/cds/evaluation/evaluateSlotPage1.jsp"></jsp:include>
</c:if>
<c:if test="${bean.page == 2}">
	<jsp:include page="/html/portlet/cds/evaluation/evaluateSlotPage2.jsp"></jsp:include>
</c:if>

