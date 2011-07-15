<%@ include file="../common/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	function pagingSubmit() {
		
		var url = '<portlet:renderURL>
					    <portlet:param name="action" value="commonController" />
					    <portlet:param name="<%= URLParameter_RS.ORG_ID%>" value="${bean.orgId}" />
					</portlet:renderURL>';
		
		document.frmJournal.action = url;
		document.frmJournal.submit();
	}
</script>


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

			<!-- List of journal articles -->
			<div class="tnt-row">
				<div class="tnt-row tnt-border-bottom">
					<div class="tnt-row-left">
						<span class="tnt-journal-title"> 
							<a href="#">
								
							</a> 
						</span>
					</div>
				</div>

				<div class="tnt-row">
					<c:forEach items="${bean.journalArticles}" var="journalArticle"	varStatus="count">						
						<div class="tnt-row" style="padding-top: 20px;">
							<div class="tnt-row-left tnt-journal-img">
								<img alt="" src='<c:out value="${journalArticle.smallImageUrl}"></c:out>'
									 onLoad='scaleImg(this, 145, 100)' style="display: none;">
						    </div>
						    
							<div class="tnt-row-right seventy-half">
								<div class="tnt-journal-description">
									<div>
										<c:if test="${bean.isAdminOfOrg == true}">
										<span class="tnt-bt-edit">
											<portlet:renderURL var="editJournalArticles" 
													windowState="<%=WindowState.MAXIMIZED.toString() %>">
											    <portlet:param name="action" value="handleJournal" />
											    <portlet:param name="<%=URLParameter_RS.ORG_ID %>" 
											    	value='${bean.orgId}'/>											    	
											    <portlet:param name="<%=JournalArticle_RS.JA_ID %>" 
											    	value='${journalArticle.journalArticleId}'/>
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
											<a href="${bean.articleDetailLink}${journalArticle.journalArticleId}">
												<c:out value="${journalArticle.title}"></c:out>
											</a>
										</span>
									</div>
									
									<div class="tnt-text" style="padding-top: 3px;">
										<span>
											<c:out value="${journalArticle.description}" escapeXml="false"></c:out>												
										</span>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			
			<div class="tnt-row">
				<c:set value="${bean.paginationArticles}" var="paging"></c:set>
				<%@ include file="../common/pagination.jsp"%>
			</div>
		</div>
	</div>
</form>