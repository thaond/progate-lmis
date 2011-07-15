<%@ include file="../../../common/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="scripts/manageUser_scripts.jsp"%>

<form action="" name="frmUser" method="post">
	<div class="tnt-user-management">
		<div id="manageUser">
			<div class="tnt-row">
				<div class="tnt-row-left">
					<div>
						<label style="font-size: 14px;"> <fmt:message
								key="title.user.going.to">
							</fmt:message> </label> <select name="<%=Request.SELECTED_ORG_ID%>" id="selectedOrgId"
							style="width: 858px;">
							<c:choose>
								<c:when test="${bean.isRootOrg == true}">
									<option value="${bean.rootOrgId}" selected="selected">${bean.orgName}</option>
								</c:when>

								<c:otherwise>
									<option value="${bean.rootOrgId}">${bean.orgName}</option>
								</c:otherwise>
							</c:choose>

							<c:forEach items="${bean.subOrgList}" var="subOrg">
								<c:choose>
									<c:when test="${subOrg.orgId == bean.selectedOrgId}">
										<option value="${subOrg.orgId}" selected="selected">${subOrg.orgName}</option>
									</c:when>

									<c:otherwise>
										<option value="${subOrg.orgId}">${subOrg.orgName}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>

			<div class="tnt-row tnt-border-bottom">
				<div class="tnt-row-left">
					<div class="tnt-title">
						<label><fmt:message key="title.user.management" /> </label>
					</div>
				</div>
			</div>

			<c:choose>
				<c:when test="${bean.isRootOrgOwner == false && bean.isRootOrgAdmin == false
					&& bean.isOrgManager == false && bean.isOrgAdmin == false}">
					
					<div class="tnt-row tnt-warning-message" id="tnt-global-message">
						<span>
							<fmt:message key="warning.user.none.enough.role.in.org" />
						</span>
					</div>					
				</c:when>
				
				<c:otherwise>
					<div class="tnt-row" id="tnt-global-message">
						<span></span>
					</div>
				</c:otherwise>
			</c:choose>
			

			<div class="tabs-menu tnt-row">
				<c:if
					test="${bean.isRootOrgOwner == true || bean.isRootOrgAdmin == true
					|| bean.isOrgManager == true || bean.isOrgAdmin == true}">
					<c:choose>
						<c:when test="${bean.tab == bean.MEMBER_TAB}">
							<div class="tabs-state tabs-state-active">
								<a><fmt:message key="title.user.memeber" /> </a>
							</div>
						</c:when>
						<c:otherwise>
							<div class="tabs-state tabs-state-default">
								<portlet:renderURL var="memberTab">
									<portlet:param name="action" value="commonController" />
									<portlet:param name="<%=Request.ROOT_ORG_ID %>"
										value="${bean.rootOrgId}" />
									<portlet:param name="<%=Request.SELECTED_ORG_ID %>"
										value="${bean.selectedOrgId}" />
									<portlet:param name="<%=Request.TAB %>"
										value="<%=Request.MEMBER_TAB %>" />
								</portlet:renderURL>
								<a href='<c:out value="${memberTab}" />'> <fmt:message
										key="title.user.memeber" /> </a>
							</div>
						</c:otherwise>
					</c:choose>
				</c:if>

				<c:if
					test="${(bean.isRootOrgOwner == true || bean.isRootOrgAdmin == true) && bean.isRootOrg == true}">
					<c:choose>
						<c:when test="${bean.tab == bean.INVITE_MEMBER_TAB}">
							<div class="tabs-state tabs-state-active">
								<a><fmt:message key="title.user.invite.memeber" /> </a>
							</div>
						</c:when>
						<c:otherwise>
							<div class="tabs-state tabs-state-default">
								<portlet:renderURL var="inviteMemberTab">
									<portlet:param name="action" value="commonController" />
									<portlet:param name="<%=Request.ROOT_ORG_ID %>"
										value="${bean.rootOrgId}" />
									<portlet:param name="<%=Request.SELECTED_ORG_ID %>"
										value="${bean.selectedOrgId}" />
									<portlet:param name="<%=Request.TAB %>"
										value="<%=Request.INVITE_MEMBER_TAB %>" />
								</portlet:renderURL>
								<a href='<c:out value="${inviteMemberTab}" />'> <fmt:message
										key="title.user.invite.memeber" /> </a>
							</div>
						</c:otherwise>
					</c:choose>
				</c:if>

				<c:if
					test="${(bean.isRootOrgOwner == true || bean.isRootOrgAdmin == true) && bean.isRootOrg == true}">
					<c:choose>
						<c:when test="${bean.tab == bean.INVITED_MEMBER_TAB}">
							<div class="tabs-state tabs-state-active">
								<a><fmt:message key="title.user.invited.memeber" /> </a>
							</div>
						</c:when>
						<c:otherwise>
							<div class="tabs-state tabs-state-default">
								<portlet:renderURL var="invitedMemberTab">
									<portlet:param name="action" value="commonController" />
									<portlet:param name="<%=Request.ROOT_ORG_ID %>"
										value="${bean.rootOrgId}" />
									<portlet:param name="<%=Request.SELECTED_ORG_ID %>"
										value="${bean.selectedOrgId}" />
									<portlet:param name="<%=Request.TAB %>"
										value="<%=Request.INVITED_MEMBER_TAB %>" />
								</portlet:renderURL>
								<a href='<c:out value="${invitedMemberTab}" />'> <fmt:message
										key="title.user.invited.memeber" /> </a>
							</div>
						</c:otherwise>
					</c:choose>
				</c:if>

				<c:if
					test="${(bean.isRootOrgOwner == true || bean.isRootOrgAdmin == true) && bean.isRootOrg == true}">
					<c:choose>
						<c:when test="${bean.tab == bean.WAITING_MEMBER_TAB}">
							<div class="tabs-state tabs-state-active">
								<a><fmt:message key="title.user.waiting.memeber" /> </a>
							</div>
						</c:when>
						<c:otherwise>
							<div class="tabs-state tabs-state-default">
								<portlet:renderURL var="waitingMemberTab">
									<portlet:param name="action" value="commonController" />
									<portlet:param name="<%=Request.ROOT_ORG_ID %>"
										value="${bean.rootOrgId}" />
									<portlet:param name="<%=Request.SELECTED_ORG_ID %>"
										value="${bean.selectedOrgId}" />
									<portlet:param name="<%=Request.TAB %>"
										value="<%=Request.WAITING_MEMBER_TAB %>" />
								</portlet:renderURL>
								<a href='<c:out value="${waitingMemberTab}" />'> <fmt:message
										key="title.user.waiting.memeber" /> </a>
							</div>
						</c:otherwise>
					</c:choose>
				</c:if>

				<c:if
					test="${bean.isRootOrgOwner == true || bean.isRootOrgAdmin == true
					|| bean.isOrgManager == true || bean.isOrgAdmin == true}">
					<c:choose>
						<c:when test="${bean.tab == bean.OLD_MEMBER_TAB}">
							<div class="tabs-state tabs-state-active">
								<a><fmt:message key="title.user.old.memeber" /> </a>
							</div>
						</c:when>
						<c:otherwise>
							<div class="tabs-state tabs-state-default">
								<portlet:renderURL var="oldMemberTab">
									<portlet:param name="action" value="commonController" />
									<portlet:param name="<%=Request.ROOT_ORG_ID %>"
										value="${bean.rootOrgId}" />
									<portlet:param name="<%=Request.SELECTED_ORG_ID %>"
										value="${bean.selectedOrgId}" />
									<portlet:param name="<%=Request.TAB %>"
										value="<%=Request.OLD_MEMBER_TAB %>" />
								</portlet:renderURL>
								<a href='<c:out value="${oldMemberTab}" />'> <fmt:message
										key="title.user.old.memeber" /> </a>
							</div>
						</c:otherwise>
					</c:choose>
				</c:if>

			</div>

			<div class="tabs-content">
				<c:choose>
					<c:when test="${bean.tab == bean.MEMBER_TAB}">
						<c:if
							test="${bean.isRootOrgOwner == true || bean.isRootOrgAdmin == true
					|| bean.isOrgManager == true || bean.isOrgAdmin == true}">
							<jsp:include page="include/member.jsp"></jsp:include>
						</c:if>
					</c:when>

					<c:when test="${bean.tab == bean.INVITE_MEMBER_TAB}">
						<c:if
							test="${(bean.isRootOrgOwner == true || bean.isRootOrgAdmin == true) && bean.isRootOrg == true}">
							<jsp:include page="include/inviteMember.jsp"></jsp:include>
						</c:if>
					</c:when>

					<c:when test="${bean.tab == bean.INVITED_MEMBER_TAB}">
						<c:if
							test="${(bean.isRootOrgOwner == true || bean.isRootOrgAdmin == true) && bean.isRootOrg == true}">
							<jsp:include page="include/invitedMember.jsp"></jsp:include>
						</c:if>
					</c:when>

					<c:when test="${bean.tab == bean.WAITING_MEMBER_TAB}">
						<c:if
							test="${(bean.isRootOrgOwner == true || bean.isRootOrgAdmin == true) && bean.isRootOrg == true}">
							<jsp:include page="include/waitingMember.jsp"></jsp:include>
						</c:if>
					</c:when>

					<c:when test="${bean.tab == bean.OLD_MEMBER_TAB}">
						<c:if
							test="${bean.isRootOrgOwner == true || bean.isRootOrgAdmin == true
					|| bean.isOrgManager == true || bean.isOrgAdmin == true}">
							<jsp:include page="include/oldMember.jsp"></jsp:include>
						</c:if>
					</c:when>

					
				</c:choose>
			</div>
		</div>
	</div>

	<input type="hidden" name="<%=Request.TAB%>" value="${bean.tab}">
	<input type="hidden" name="<%=Request.ROOT_ORG_ID%>" value="${bean.rootOrgId}"> 
	<input type="hidden" name="<%=Request.SUCCESS_MESSAGE%>" value="${bean.successMsg}"
		id="successMsg"> <input type="hidden" name="<%=Request.FAIL_MESSAGE%>" value="${bean.failMsg}" id="failMsg">
</form>

<form name="frmMsg">
	<input type="hidden" name="<%=Request.MESSAGE_STATUS%>" id="msgStatus"
		value="${bean.msgStatus}">
</form>