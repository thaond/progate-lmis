<%@ include file="/html/portlet/common/init.jsp"%>
<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<portlet:renderURL var="tab1">
	<portlet:param name="action" value="commonController" />
	<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_EVALUATION_1%>" />
	<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
</portlet:renderURL>

<portlet:renderURL var="tab2">
	<portlet:param name="action" value="commonController" />
	<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_EVALUATION_2%>" />
	<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
</portlet:renderURL>

<portlet:renderURL var="tab3">
	<portlet:param name="action" value="commonController" />
	<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_EVALUATION_3%>" />
	<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
</portlet:renderURL>
<ul class="tabs ">
	<c:choose>
		<c:when test="${bean.activedTab == bean.TAB_EVALUATION_1}">
			<li><a href='${tab1}' class='actived'>Xem kết quả CDS hiện tại</a></li>	
		</c:when>
		<c:otherwise>
			<li><a href='${tab1}'>Xem kết quả CDS hiện tại</a></li>
		</c:otherwise>
	</c:choose>
	
	<c:choose>
		<c:when test="${bean.activedTab == bean.TAB_EVALUATION_2}">
			<li><a href='${tab2}' class='actived'>Chọn slot để đánh giá</a></li>	
		</c:when>
		<c:otherwise>
			<li><a href='${tab2}'>Chọn slot để đánh giá</a></li>
		</c:otherwise>
	</c:choose>
	
	<c:choose>
		<c:when test="${bean.activedTab == bean.TAB_EVALUATION_3}">
			<li><a href='${tab3}' class='actived'>Đánh giá Slot</a></li>	
		</c:when>
		<c:otherwise>
			<li><a href='${tab3}'>Đánh giá Slot</a></li>
		</c:otherwise>
	</c:choose>
</ul>
