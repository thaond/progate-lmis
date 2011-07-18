<%@ include file="../../../../common/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../dialog/dialogAddUserToOrganization.jsp"%>

<style type="text/css">
#dialogAddUserToOrganization {
	display: none;
}
</style>

<script type="text/javascript">
	
	function pagingSubmit() {
		applyFilter();
	}
	
	function search() {
		applyFilter();
	}
	
	function applyFilter() {
		submit();
	}
	
	jQuery(function() {
		jQuery(".tnt-bt-delete").click(function(){
			if(jQuery("input[name='userId']:checked").length == 0) {
				alert('<fmt:message key="warning.user.none.choose"/>');
			} else {
				
				var answer = confirm('<fmt:message key="warning.user.delete.from.organization.confirm"/>');
				
				var url = '<portlet:actionURL>
							    <portlet:param name="action" value="commonController" />
								<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.DELETE%>"/>
							</portlet:actionURL>';
				
				jQuery("#successMsg").val('<fmt:message key="warning.user.delete.from.organization.success"></fmt:message>');
				
				if (answer) {
					submit(url);
				}
			}
		});
	});
</script>

<div class="tnt-row">
	<div class="tnt-row-left">
		<fieldset>
			<legend>
				<fmt:message key="title.filter" />
			</legend>
			<label><fmt:message key="title.user.role" /> </label> <select
				name="<%=Request.FILTER_USER_ROLE%>" style="width: 230px;">
				<c:choose>
					<c:when test="${bean.filterRole == 0}">
						<option value="0" selected="selected">
							<fmt:message key="title.all" />
						</option>
					</c:when>

					<c:otherwise>
						<option value="0">
							<fmt:message key="title.all" />
						</option>
					</c:otherwise>
				</c:choose>

				<c:forEach items="${bean.roles}" var="role">
					<c:choose>
						<c:when test="${role.roleId == bean.filterRole}">
							<option value="${role.roleId}" selected="selected">
								<c:out value="${role.name}" />
							</option>
						</c:when>

						<c:otherwise>
							<option value="${role.roleId}">
								<c:out value="${role.name}" />
							</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
		</fieldset>
	</div>

	<div class="tnt-row-right">
		<div style="padding-top: 23px;">
			<c:if
				test="${bean.isRootOrgOwner == true || bean.isRootOrgAdmin == true
				|| bean.isOrgManager == true || bean.isOrgAdmin == true}">
				<input class="txt-search" maxLength="100" type="text"
					value="${bean.searchPhrase}" style="width: 310px;"
					name="<%=Constants.SEARCH%>" />
			</c:if>

			<input type="button" name="btApplyFilter"
				value='<fmt:message key="title.view"/>'>
		</div>
	</div>
</div>

<div class="tnt-row">
	<div class="tnt-control">
		<div class="tnt-row-right">
			<div class="tnt-control-action">
				<c:if
					test="${(bean.isRootOrgOwner == true || bean.isRootOrgAdmin == true) && bean.isRootOrg == true}">
					<a class="tnt-bt-add" href="javascript:void()"> <fmt:message
							key="title.user.action.add.to.child.organization" /> </a>
				</c:if>

				<c:if
					test="${bean.isRootOrgOwner == true || bean.isRootOrgAdmin == true}">
					<a class="tnt-bt-delete" href="javascript:void()"> <fmt:message
							key="title.user.action.delete.from.organization" /> </a>
				</c:if>
			</div>
		</div>
	</div>

	<div>
		<table class="tnt-table">
			<tbody>
				<tr class="tnt-table-header">
					<td width="40"><fmt:message key="title.no" /></td>
					<td width="40"><input class="cbkSelectAll" type="checkbox" />
					</td>
					<td width="200"><fmt:message key="title.user.login.name" /></td>
					<td width="300"><fmt:message key="title.user.full.name" /></td>
					<td width="300"><fmt:message key="title.user.email.address" />
					</td>
					<td width="120"><fmt:message key="title.user.join.date" /></td>
					<td width="100"><fmt:message key="title.user.role" /></td>
					<td width="40"></td>
				</tr>
				<c:choose>
					<c:when test="${bean.countListUsers == 0}">
						<tr>
							<td colspan="8" class="tnt-warning-message"><fmt:message
									key="warning.search.no.results" />
							</td>
						</tr>
					</c:when>

					<c:otherwise>
						<c:forEach items="${bean.users}" var="user" varStatus="count">
							<c:choose>
								<c:when test="${count.count % 2 != 0}">
									<tr class="tnt-table-row-0">
								</c:when>

								<c:otherwise>
									<tr class="tnt-table-row-1">
								</c:otherwise>
							</c:choose>
							<td class="tnt-number-cell"><c:out
									value="${count.count + ( bean.paginationUser.currentPage - 1 ) * bean.paginationUser.pageSize}" />
									
							</td>

							<td class="tnt-number-cell"><input type="checkbox"
								name="<%=Request.USER_ID%>"
								value='<c:out value="${user.userId}"/>' class="cbkChild">
							</td>

							<td class="tnt-text-cell"><c:out value="${user.screenName}" />
							</td>
							<td class="tnt-text-cell"><c:out
									value="${user.firstName} ${user.lastName}" /></td>
							<td class="tnt-text-cell"><c:out
									value="${user.emailAddress}" /></td>
							<td class="tnt-datetime-cell"><fmt:formatDate
									pattern="dd/MM/yyyy" value="${user.approvedAt}" />
							</td>

							<td class="tnt-text-cell"><c:out value="${user.rolename}" />
							</td>

							<td class="tnt-status-cell">
								<div>
									<div class="tnt-action lfr-component lfr-menu-list">
										<ul>
											<!--
											<c:if test="${bean.isRootOrgOwner == true || bean.isRootOrgAdmin == true
												|| bean.isOrgManager == true || bean.isOrgAdmin == true}">
												<li>
													<a href="#"> 
														<fmt:message key="title.user.join.history" /> 
													</a>
												</li>
											</c:if>
											-->

											<c:set var="isDecentralized" scope="page" value="false"></c:set>
											<c:choose>
												<c:when test="${bean.isRootOrg == true}">
													<c:if test="${bean.isRootOrgOwner == true}">
														<c:set var="isDecentralized" scope="page" value="true"></c:set>
													</c:if>
												</c:when>

												<c:otherwise>
													<c:if test="${bean.isRootOrgOwner == true 
														|| bean.isRootOrgAdmin == true || bean.isOrgManager == true}">
														<c:set var="isDecentralized" scope="page" value="true"></c:set>
													</c:if>
												</c:otherwise>
											</c:choose>

											<c:if test="${isDecentralized == true}">
												<li><portlet:renderURL
														windowState="<%=WindowState.NORMAL.toString() %>"
														var="decentralization">
														<portlet:param name="action" value="decentralizeUserInOrg" />
														<portlet:param name="<%=Request.USER_ID %>"
															value='${user.userId}' />
														<portlet:param name="<%=Request.SELECTED_ORG_ID %>"
															value="${bean.selectedOrgId}" />
														<portlet:param name="<%=Request.ROOT_ORG_ID %>"
															value="${bean.rootOrgId}" />
													</portlet:renderURL> <a href="${decentralization}"> <fmt:message
															key="title.user.decentralize" /> </a>
												</li>
											</c:if>

											<!--
											<c:if test="${bean.isRootOrgOwner == true || bean.isRootOrgAdmin == true
												|| bean.isOrgManager == true || bean.isOrgAdmin == true}">
												<li>
													<a href="#"> 
														<fmt:message key="title.user.configuration" />
													</a>
												</li>
											</c:if>
											-->
										</ul>
									</div>

									<a href="#" class="tnt-show-actions"> <img alt=""
										src="/ProGate-portlet/images/button/action.png"> </a>
								</div>
							</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>

	<c:if test="${bean.countListUsers > 0}">
		<div class="tnt-row">
			<c:set value="${bean.paginationUser}" var="paging"></c:set>
			<%@ include file="../../../../common/pagination.jsp"%>
		</div>
	</c:if>
</div>