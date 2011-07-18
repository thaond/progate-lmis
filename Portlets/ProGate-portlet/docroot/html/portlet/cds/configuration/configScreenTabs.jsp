<%@ include file="../../cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<portlet:renderURL var="configCDSTreeURL">
	<portlet:param name="action" value="commonController" />
	<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
</portlet:renderURL>

<portlet:renderURL var="cdsPointsURL">
	<portlet:param name="action" value="cdsPoints" />
	<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
</portlet:renderURL>

<portlet:renderURL var="evaluationPeriodsURL">
	<portlet:param name="action" value="evaluationPeriods" />
	<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
</portlet:renderURL>

<portlet:renderURL var="configTitleURL">
	<portlet:param name="action" value="configTitle" />
	<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
</portlet:renderURL>

<portlet:renderURL var="configMinimumReqURL">
	<portlet:param name="action" value="configMinimumReq" />
	<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
</portlet:renderURL>

<div class="left padding-top padding-bottom" style="font-size: 1.1em; color: #E46C0A">
	<img class="absmiddle" src="/ProGate-portlet/images/cds/configuration.png"
		width="40px" height="40px" />
	<strong>Cấu hình</strong>
</div>
<div class="clear"></div>

<c:if test="${bean.hasPermissionOnTab1 == true || bean.hasPermissionOnTab2 == true 
	|| bean.hasPermissionOnTab3 == true || bean.hasPermissionOnTab4 == true
	|| bean.hasPermissionOnTab5 == true}">
<ul class="tabs ">
	<c:if test="${bean.hasPermissionOnTab1 == true}">
	<c:choose>
		<c:when test="${bean.tab == 'configCDSTree'}">
			<li><a href='${configCDSTreeURL}' class='actived'>Cấu trúc CDS</a></li>	
		</c:when>
		<c:otherwise>
			<li><a href='${configCDSTreeURL}'>Cấu trúc CDS</a></li>	
		</c:otherwise>
	</c:choose>
	</c:if>
	<c:if test="${bean.hasPermissionOnTab1 == false}">
		<li><a class="disabled">Cấu trúc CDS</a></li>	
	</c:if>
	
	<c:if test="${bean.hasPermissionOnTab2 == true}">
	<c:choose>
		<c:when test="${bean.tab == 'cdsPoints'}">
			<li><a href='${cdsPointsURL}' class='actived'>Thang điểm</a></li>
		</c:when>
		<c:otherwise>
			<li><a href='${cdsPointsURL}'>Thang điểm</a></li>
		</c:otherwise>
	</c:choose>
	</c:if>
	
	<c:if test="${bean.hasPermissionOnTab2 == false}">
		<li><a class="disabled">Thang điểm</a></li>
	</c:if>
	
	<c:if test="${bean.hasPermissionOnTab4 == true}">
	<c:choose>
		<c:when test="${bean.tab == 'configMinimumReq'}">
			<li><a href='${configMinimumReqURL}' class='actived'>Minimum requirement</a></li>
		</c:when>
		<c:otherwise>
			<li><a href='${configMinimumReqURL}'>Minimum requirement</a></li>
		</c:otherwise>
	</c:choose>
	</c:if>
	<c:if test="${bean.hasPermissionOnTab4 == false}">
		<li><a class="disabled">Minimum requirement</a></li>
	</c:if>
	
	<c:if test="${bean.hasPermissionOnTab5 == true}">
	<c:choose>
		<c:when test="${bean.tab == 'configTitle'}">
			<li><a href='${configTitleURL}' class='actived'>Title</a></li>
		</c:when>
		<c:otherwise>
			<li><a href='${configTitleURL}'>Title</a></li>	
		</c:otherwise>
	</c:choose>
	</c:if>
	<c:if test="${bean.hasPermissionOnTab5 == false}">
		<li><a class="disabled">Title</a></li>
	</c:if>
	
	<c:if test="${bean.hasPermissionOnTab3 == true}">
	<c:choose>
		<c:when test="${bean.tab == 'evaluationPeriods'}">
			<li><a href='${evaluationPeriodsURL}' class='actived'>Đợt CDS</a></li>
		</c:when>
		<c:otherwise>
			<li><a href='${evaluationPeriodsURL}'>Đợt CDS</a></li>
		</c:otherwise>
	</c:choose>
	</c:if>
	<c:if test="${bean.hasPermissionOnTab3 == false}">
		<li><a class="disabled">Đợt CDS</a></li>
	</c:if>
	
</ul>
</c:if>