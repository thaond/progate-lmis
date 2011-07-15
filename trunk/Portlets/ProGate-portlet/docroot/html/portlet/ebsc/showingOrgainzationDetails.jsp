<%@ include file="../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	
	jQuery(function(){
		
	});
	
</script>

<portlet:renderURL var="detailOrgURL_1">
	<portlet:param name="action"
	               value="showingOrgainzationDetails" />
	<portlet:param name="<%=Request.ORG_ID %>"
	               value="${bean.org.orgId}" />
	<portlet:param name="<%=Request.TA %>"
                   value="<%=Request.TA_1 %>" />
</portlet:renderURL>

<div style="width: 100%">
	<div class="title-msg">
		<fmt:message key="warning.org.information.view" />
		<a href='<c:out value="${detailOrgURL_1}" />' style="text-decoration: none;">
			<c:out value="${bean.org.name}" /></a>
	</div>

	<div class="tabs-menu">
		<c:choose>
			<c:when test="${bean.tabAction == bean.TA_1 || bean.tabAction == bean.TA_1_1 || bean.tabAction == bean.TA_1_2 || bean.tabAction == bean.TA_1_3}">
				<div class="tabs-state tabs-state-active">
				<a><fmt:message key="title.objective.mamagement" /></a>
				</div>
			</c:when>
			<c:otherwise>
				<div class="tabs-state tabs-state-default">
					<a  href='<c:out value="${detailOrgURL_1}" />'><fmt:message key="title.objective.mamagement" /></a>
				</div>
			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="${bean.tabAction == bean.TA_4}">
				<div class="tabs-state tabs-state-active">
				<a><fmt:message key="title.tab4" /></a>
				</div>
			</c:when>
			<c:otherwise>
				<div class="tabs-state tabs-state-default">
					<portlet:renderURL var="detailOrgURL_4">
					    <portlet:param name="action"
					                   value="showingOrgainzationDetails" />
					    <portlet:param name="<%=Request.ORG_ID %>"
					                   value="${bean.org.orgId}" />
					    <portlet:param name="<%=ObjectivesList_RS.OBJ_LIST_ID %>"
					    			   value="${bean.objectiveSet.orgObjectListId}" />
					    <portlet:param name="<%=Request.TA %>"
					                   value="<%=Request.TA_4 %>" />
				  	</portlet:renderURL>
					<a  href='<c:out value="${detailOrgURL_4}" />'><fmt:message key="title.tab4" /></a>
				</div>
			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="${bean.tabAction == bean.TA_5}">
				<div class="tabs-state tabs-state-active">
				<a><fmt:message key="title.tab5" /></a>
				</div>
			</c:when>
			<c:otherwise>
				<div class="tabs-state tabs-state-default">
					<portlet:renderURL var="detailOrgURL_5">
					    <portlet:param name="action"
					                   value="showingOrgainzationDetails" />
					    <portlet:param name="<%=Request.ORG_ID %>"
					                   value="${bean.org.orgId}" />
					    <portlet:param name="<%=ObjectivesList_RS.OBJ_LIST_ID %>"
					    			   value="${bean.objectiveSet.orgObjectListId}" />
					    <portlet:param name="<%=Request.TA %>"
					                   value="<%=Request.TA_5 %>" />
				  	</portlet:renderURL>
					<a  href='<c:out value="${detailOrgURL_5}" />'><fmt:message key="title.tab5" /></a>
				</div>
			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="${bean.tabAction == bean.TA_2}">
				<div class="tabs-state tabs-state-active">
				<a><fmt:message key="title.org.structure.management" /></a>
				</div>
			</c:when>
			<c:otherwise>
				<div class="tabs-state tabs-state-default">
					<portlet:renderURL var="detailOrgURL_2">
					    <portlet:param name="action"
					                   value="showingOrgainzationDetails" />
					    <portlet:param name="<%=Request.ORG_ID %>"
					                   value="${bean.org.orgId}" />
					    <portlet:param name="<%=Request.TA %>"
					                   value="<%=Request.TA_2 %>" />
				  	</portlet:renderURL>
					<a  href='<c:out value="${detailOrgURL_2}" />'><fmt:message key="title.org.structure.management" /></a>
				</div>
			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="${bean.tabAction == bean.TA_3}">
				<div class="tabs-state tabs-state-active">
				<a><fmt:message key="title.office.management" /></a>
				</div>
			</c:when>
			<c:otherwise>
				<div class="tabs-state tabs-state-default">
					<portlet:renderURL var="detailOrgURL_3">
					    <portlet:param name="action"
					                   value="showingOrgainzationDetails" />
					    <portlet:param name="<%=Request.ORG_ID %>"
					                   value="${bean.org.orgId}" />
					    <portlet:param name="<%=Request.TA %>"
					                   value="<%=Request.TA_3 %>" />
				  	</portlet:renderURL>
					<a  href='<c:out value="${detailOrgURL_3}" />'><fmt:message key="title.office.management" /></a>
				</div>
			</c:otherwise>
		</c:choose>
	</div>

	<div class="tabs-content">
		<c:choose>
			<c:when test="${bean.tabAction == bean.TA_1 || bean.tabAction == bean.TA_1_1}">
				<jsp:include page="objectivesManage.jsp"></jsp:include>
			</c:when>

			<c:when test="${bean.tabAction == bean.TA_1_2 || bean.tabAction == bean.TA_1_3}">
				<jsp:include page="objectivesDetail.jsp"></jsp:include>
			</c:when>

			<c:when test="${bean.tabAction == bean.TA_2}">
			</c:when>

			<c:when test="${bean.tabAction == bean.TA_3}">
			</c:when>

			<c:when test="${bean.tabAction == bean.TA_4}">
				<jsp:include page="costCalculate.jsp"></jsp:include>
			</c:when>

			<c:when test="${bean.tabAction == bean.TA_5}">
				<jsp:include page="AhpAlgorithm.jsp"></jsp:include>
			</c:when>
			<c:otherwise>

			</c:otherwise>
		</c:choose>
	</div>
</div>

<FORM NAME="frmMsg">
	<INPUT TYPE="hidden" NAME="MsgTxt" Value="${cobsMsgTxt}">
</FORM>