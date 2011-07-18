<%@ include file="../../common/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<c:if test="${bean.isProGateAdmin == true}">
	<%@ include file="scripts/manageUser_scripts.jsp"%>

	<form action="" name="frmUser" method="post">
		<div class="pg-right-panel">
			<div id="manageUser">
				<div class="tnt-row tnt-border-bottom">
					<div class="tnt-row-left">
						<div class="tnt-title">
							<label><fmt:message key="title.user.list" /> </label>
						</div>
					</div>
				</div>

				<div class="tnt-row" id="tnt-global-message">
					<span> </span>
				</div>

				<div class="tnt-row">
					<div class="tnt-row-left">
						<fieldset>
							<legend>
								<fmt:message key="title.filter" />
							</legend>
							<label><fmt:message key="title.user.memeber" /> </label> <select
								name="<%=Request.FILTER_USER_TYPICAL_MEMBER%>"
								style="width: 90px;">
								<c:choose>
									<c:when test="${bean.isProactive == 2}">
										<option value="2" selected="selected">
											<fmt:message key="title.all" />
										</option>
									</c:when>

									<c:otherwise>
										<option value="2">
											<fmt:message key="title.all" />
										</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${bean.isProactive == 1}">
										<option value="1" selected="selected">
											<fmt:message key="title.user.typical.member" />
										</option>
									</c:when>

									<c:otherwise>
										<option value="1">
											<fmt:message key="title.user.typical.member" />
										</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${bean.isProactive == 0}">
										<option value="0" selected="selected">
											<fmt:message key="title.user.normal.member" />
										</option>
									</c:when>

									<c:otherwise>
										<option value="0">
											<fmt:message key="title.user.normal.member" />
										</option>
									</c:otherwise>
								</c:choose>
							</select> <label><fmt:message key="title.status" /> </label> <select
								name="<%=Request.FILTER_USER_STATUS%>" style="width: 90px;">
								<c:choose>
									<c:when test="${bean.status == 2}">
										<option value="2" selected="selected">
											<fmt:message key="title.all" />
										</option>
									</c:when>

									<c:otherwise>
										<option value="2">
											<fmt:message key="title.all" />
										</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${bean.status == 1}">
										<option value="1" selected="selected">
											<fmt:message key="title.enabled" />
										</option>
									</c:when>

									<c:otherwise>
										<option value="1">
											<fmt:message key="title.enabled" />
										</option>
									</c:otherwise>
								</c:choose>

								<c:choose>
									<c:when test="${bean.status == 0}">
										<option value="0" selected="selected">
											<fmt:message key="title.disabled" />
										</option>
									</c:when>

									<c:otherwise>
										<option value="0">
											<fmt:message key="title.disabled" />
										</option>
									</c:otherwise>
								</c:choose>
							</select>
						</fieldset>
					</div>

					<div class="tnt-row-right">
						<div style="padding-top: 23px;">
							<input class="txt-search" maxLength="100" type="text"
								value="${bean.searchPhrase}" name="<%=Constants.SEARCH%>" /> <input
								type="button" name="btApplyFilter"
								value='<fmt:message key="title.view"/>'>
						</div>
					</div>
				</div>

				<div class="tnt-row">
					<div class="tnt-control">
						<div class="tnt-row-right">
							<div class="tnt-control-action">
								<a class="tnt-bt-delete" href="javascript:void()"> <fmt:message
										key="button.delete" /> </a> <a class="tnt-bt-typical-member"
									href="javascript:void()"> <fmt:message
										key="title.user.typical.member" /> </a> <a
									class="tnt-bt-normal-member" href="javascript:void()"> <fmt:message
										key="title.user.normal.member" /> </a> <a class="tnt-bt-enable"
									href="javascript:void()"> <fmt:message key="button.enable" />
								</a> <a class="tnt-bt-disable" href="javascript:void()"> <fmt:message
										key="button.disable" /> </a>
							</div>
						</div>
					</div>

					<div>
						<table class="tnt-table">
							<tbody>
								<tr class="tnt-table-header">
									<td width="40"><fmt:message key="title.no" /></td>
									<td width="40"><input id="userAll" type="checkbox" /></td>
									<td width="200"><fmt:message key="title.user.login.name" />
									</td>
									<td width="300"><fmt:message key="title.user.full.name" />
									</td>
									<td width="300"><fmt:message
											key="title.user.email.address" /></td>
									<td width="100"><fmt:message
											key="title.user.last.access.day" /></td>
									<td width="50"><fmt:message
											key="title.user.typical.member" /></td>
									<td width="50"><fmt:message key="title.user.status" /></td>
									<td></td>
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
												value='<c:out value="${user.userid}"/>'>
											</td>

											<td class="tnt-text-cell"><c:out
													value="${user.screenname}" /></td>
											<td class="tnt-text-cell"><c:out
													value="${user.firstname} ${user.lastname}" /></td>
											<td class="tnt-text-cell"><c:out
													value="${user.emailaddress}" /></td>
											<td class="tnt-datetime-cell"><fmt:formatDate
													pattern="dd/MM/yyyy" value="${user.lastlogindate}" />
											</td>
											<td class="tnt-status-cell"><c:choose>
													<c:when test="${user.isProActive == true}">
														<img
															src="/ProGate-portlet/images/button/typical_member.png" />
													</c:when>

													<c:otherwise>
														<img
															src="/ProGate-portlet/images/button/normal_member.png" />
													</c:otherwise>
												</c:choose>
											</td>

											<td class="tnt-status-cell"><c:choose>
													<c:when test="${user.status == true}">
														<fmt:message key="title.enabled" />
													</c:when>

													<c:otherwise>
														<fmt:message key="title.disabled" />
													</c:otherwise>
												</c:choose>
											</td>
											<td class="tnt-status-cell">
												<div>
													<div class="tnt-action lfr-component lfr-menu-list">
														<ul>
															<!-- 
															<li>
																<a href="${history}"> 
																	<fmt:message key="title.user.join.history" />
																</a>
															</li>
															 -->

															<c:if test="${user.status == true}">
																<li><portlet:renderURL
																		windowState="<%=WindowState.NORMAL.toString() %>"
																		var="decentralization">
																		<portlet:param name="action" value="decentralizeUser" />
																		<portlet:param name="<%=Request.USER_ID %>"
																			value='${user.userid}' />
																		<portlet:param
																			name="<%=URLParameter_RS.RETURN_TO_FULL_PAGE_URL %>"
																			value='<%=PortalUtil.getCurrentURL(renderRequest) %>' />
																	</portlet:renderURL> <a href="${decentralization}"> <fmt:message
																			key="title.user.decentralize" /> </a>
																</li>

																<!--
																<li>
																	<a href="${configuration}">
																		<fmt:message key="title.user.configuration" />
																	</a>
																</li>
																-->
															</c:if>
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
							<%@ include file="../../common/pagination.jsp"%>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</form>

	<form name="frmMsg">
		<input type="hidden" name="<%=Request.MESSAGE_TXT%>" id="MsgTxt"
			value="${bean.MsgTxt}">
	</form>
</c:if>