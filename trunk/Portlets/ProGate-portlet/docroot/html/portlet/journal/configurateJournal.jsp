<%@page import="larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil"%>
<%@page import="larion.progate.model.ProGateJournalArticleTypes"%>
<%@page import="java.util.Arrays"%>
<%@ include file="../common/init.jsp" %>
<%@ page isELIgnored="false" %>

<%
	//Get list of display style. Read from portal-ext.properties 
	PortletPreferences preferences = renderRequest.getPreferences();

	String portletResource = ParamUtil.getString(request,
			"portletResource");

	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(
				request, portletResource);
	}

	String curDisplayStyle = preferences.getValue(
			ConfigParams_RS.DISPLAY_STYLE, null);

	String[] journalTypes = { Request.JOURNAL_ARTICLES,
			Request.JOURNAL_CONTENT };

	String curJournalType = preferences.getValue(
			ConfigParams_RS.JOURNAL_TYPE, Request.JOURNAL_ARTICLES);

	List<ProGateJournalArticleTypes> journalArticleTypes = ProGateJournalArticleTypesLocalServiceUtil
			.getProGateJournalArticleTypeses(0,
					ProGateJournalArticleTypesLocalServiceUtil
							.getProGateJournalArticleTypesesCount());

	String curJournalArticlesType = preferences.getValue(
			ConfigParams_RS.JOURNAL_ARTICLES_TYPE, null);
	
	String isShowNearNews = preferences.getValue(
			ConfigParams_RS.IS_SHOW_NEAR_NEWS, "0");	
%>

<form action="<liferay-portlet:actionURL portletConfiguration='true'/>" method="post" name="frmConfig">

<div>
	<div class="tnt-row">
		<div class="tnt-row-left">
		<span>
		<fmt:message key="title.config.journal.type" />
		</span>
		</div>
		
		<div class="tnt-row-right eighty">
		<span>
		<select name="<%=ConfigParams_RS.JOURNAL_TYPE%>">
		<c:set var="_curJournalType" value="<%=curJournalType %>"></c:set>
		<c:forEach items="<%= journalTypes %>" var="journalType"  varStatus="count">						
			<option value="${journalType}"
				<c:if test="${journalType == _curJournalType}"> selected </c:if>
				> ${journalType}
			</option>
		</c:forEach>		
		</select>
		</span>
		</div>
	</div>	
	
	<div class="tnt-row">
		<div class="tnt-row-left">
		<span>
		<fmt:message key="title.config.journal.articles.type" />
		</span>
		</div>
		
		<div class="tnt-row-right eighty">
		<span>
		<select name="<%=ConfigParams_RS.JOURNAL_ARTICLES_TYPE%>">
		<c:set var="_curJournalArticlesType" value="<%=curJournalArticlesType %>"></c:set>
		<c:forEach items="<%= journalArticleTypes %>" var="journalArticleType"  varStatus="count">						
			<option value="${journalArticleType.journalArticleTypesId}"
				<c:if test="${journalArticleType.journalArticleTypesId == _curJournalArticlesType}"> selected </c:if>
				> ${journalArticleType.name}
			</option>
		</c:forEach>		
		</select>
		</span>
		</div>
	</div>
	
	<div class="tnt-row">
		<div class="tnt-row-left">
		<span>
		<fmt:message key="title.config.journal.is.show.near.news" />
		</span>
		</div>
		
		<div class="tnt-row-right eighty">
			<span>
				<label>true</label>
				<input type="radio" name="<%=ConfigParams_RS.IS_SHOW_NEAR_NEWS%>" 
					value="1" <%= ("1".equals(isShowNearNews)) ? "checked=checked" : ""%>>
			</span>
			
			<span>
				<label>false</label>
				<input type="radio" name="<%=ConfigParams_RS.IS_SHOW_NEAR_NEWS%>" 
					value="0" <%= ("0".equals(isShowNearNews)) ? "checked=checked" : ""%>>
			</span>
		</div>
	</div>
	
	<div class="tnt-row">
		<div class="tnt-row-left">
		<span>
		<fmt:message key="button.add" />
		</span>
		</div>
		
		<div class="tnt-row-right eighty">
		<span>
		<input type="text" name="<%=ConfigParams_RS.JOURNAL_ARTICLES_TYPE_TEXT%>" value="">
		</span>
		</div>
	</div>
	
	<div>
	<input type="submit" id="butSubmit" name="butSubmit" value="Save"/>
	</div>
</div>
</form>