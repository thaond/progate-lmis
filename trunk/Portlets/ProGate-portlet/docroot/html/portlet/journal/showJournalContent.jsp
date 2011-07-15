<%@ include file="../common/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<form action="" method="post" name="frmJournal">
	<div class="tnt-portal-right">
		<div class="tnt-journal">
			<div>
				<div class="tnt-row-right">
					<c:if test="${bean.isAdminOfOrg == true}">
						<span> 
							<portlet:renderURL windowState="<%=WindowState.MAXIMIZED.toString() %>"
									var="addJournalArticles">
								<portlet:param name="action" value="handleJournal" />
								<portlet:param name="<%=URLParameter_RS.ORG_ID %>" value='${bean.orgId}' />								
								<portlet:param name="<%=URLParameter_RS.RETURN_TO_FULL_PAGE_URL %>"
									value='<%=PortalUtil.getCurrentURL(renderRequest) %>' />
								<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.ADD%>" />
							</portlet:renderURL>
							
							<a href="${addJournalArticles}" class="tnt-link">
								+ <fmt:message key="button.add" />
							</a>
						</span>
					</c:if>
				</div>
			</div>

			<!-- Show journal content -->
			<div class="tnt-row">
				<div class="tnt-row tnt-border-bottom">
					<div class="tnt-left">
						<c:if test="${bean.isAdminOfOrg == true}">
						<span class="tnt-bt-edit">
							<portlet:renderURL var="editJournalArticles" 
									windowState="<%=WindowState.MAXIMIZED.toString() %>">
							    <portlet:param name="action" value="handleJournal" />
							    <portlet:param name="<%=URLParameter_RS.ORG_ID %>" 
							    	value='${bean.orgId}'/>											    	
							    <portlet:param name="<%=JournalArticle_RS.JA_ID %>" 
							    	value='${bean.journalArticle.journalArticleId}'/>
							    <portlet:param name="<%=URLParameter_RS.RETURN_TO_FULL_PAGE_URL %>" 
							    	value='<%=PortalUtil.getCurrentURL(renderRequest) %>'/>
							    <portlet:param name="<%=Constants.CMD%>" value="<%=Constants.UPDATE%>"/>
							</portlet:renderURL>
							
							<a href='<c:out value="${editJournalArticles}"></c:out>' 
								class="tnt-link" >
								<fmt:message key="button.edit" />
							</a>
						</span>
						&nbsp;
						</c:if>
					
						<span class="tnt-article-title">
							<c:out value="${bean.journalArticle.title}"></c:out>
						</span>
					</div>
				</div>
				
				<div class="tnt-row tnt-text">
					<c:out value="${bean.journalArticle.content}" escapeXml="false"></c:out>
				</div>
			</div>
		</div>
	</div>
</form>