<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script>
	<%@ include file="/js/cds/validate.js" %>
</script>

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

<c:choose>
<c:when test="${bean.hasPermissionOnTab1 == false}">
	<div id="loading" class="cds-loading">
		<img src="/ProGate-portlet/images/cds/ajax-loader.gif"/>
	</div>
	<c:choose>
	<c:when test="${bean.hasPermissionOnTab2 == true}">
		<script>
			jQuery("#loading").show();
			location.href='${cdsPointsURL}';
		</script>
	</c:when>
	<c:when test="${bean.hasPermissionOnTab3 == true}">
		<script>
			jQuery("#loading").show();
			location.href='${evaluationPeriodsURL}';
		</script>
	</c:when>
	<c:when test="${bean.hasPermissionOnTab4 == true}">
		<script>
			jQuery("#loading").show();
			location.href='${configMinimumReqURL}';
		</script>
	</c:when>
	<c:when test="${bean.hasPermissionOnTab5 == true}">
		<script>
			jQuery("#loading").show();
			location.href='${configTitleURL}';
		</script>
	</c:when>
	<c:otherwise>
		<div class="cds-container">
			<jsp:include page="/html/portlet/cds/configuration/configScreenTabs.jsp"></jsp:include>
			<div class="border-radius" style="min-height: 485px; margin-bottom: 20px;">
				<div class="cds-notification">Rất tiếc! Bạn không có quyền truy cập vào liên kết này.<br/>
					Vui lòng nhấp <a href="#">vào đây</a> để trở lại trang chủ.
				</div>
			</div>	
		</div>
	</c:otherwise>
	</c:choose>
</c:when>
<c:otherwise>
<div class="cds-container">

	<jsp:include page="/html/portlet/cds/configuration/configScreenTabs.jsp"></jsp:include>
	
	<div class="border-radius" style="padding: 22px; min-height: 460px; margin-bottom: 20px">
		<input type="hidden" id="nextCompetencyOrder"
			value="${bean.nextCompetencyOrder}" /> 
		<a href='#' id='addCompetency'> 
			<img class="absmiddle" src="/ProGate-portlet/images/cds/add.png" width="18px" height="18px" />
			<fmt:message key="title.competency.action.add" />
		</a>
		<!-- modal content -->

		<table>
			<!--
			<tr>
			<td>Ten + mo ta</td> 
			<td>Thu tu</td>
			<td>Them</td>
			<td>Sua</td>
			<td>Xoa</td>
			</tr>
			-->
			<!-- bien khoi dau khi lap allLevels -->
			<c:set var="init1" value="0" scope="page" />
			<!-- bien khoi dau khi lap allSlots -->
			<c:set var="init2" value="0" scope="page" />

			<!-- 	Lap tat ca cac competency -->
			<c:if test="${ bean.sizeOfCompetency > 0}">
				<c:forEach var="i" begin="0" end="${bean.sizeOfCompetency - 1}">
					<tr class="cds-background-white">
						<td class="span-13">
							<div style="float:left;">
								<img src="/ProGate-portlet/images/cds/tron.png" width="10px" height="10px" style="margin-top: 0.35em"/>
							</div>
							<div style="padding-left: 20px; text-align: justify;"> 
								<strong><c:out escapeXml="false" value="${bean.competencies[i].name}"></c:out></strong>
							</div>
							<input type="hidden" name="id" value='<c:out value="${bean.competencies[i].competencyId}" />' />
							<input type="hidden" name="name" value='<c:out escapeXml="false" value="${bean.competencies[i].name}" />' /> 
							<input type="hidden" name="nextLevelOrder" value='<c:out value="${bean.nextLevelOrders[i]}" />' /> 
							<input type="hidden" name="hasLevels" value='<c:out value="${bean.competencyLevel[i]}" />' /></td>
						<td style="vertical-align: top; padding-top: 4px;"><fmt:message key="title.CDS.order" />: <c:out value="${bean.competencies[i].numberOrder}"></c:out></td>
						<td class="td-align-left" style="vertical-align: top; padding-top: 3px;">
							<a href="#" class="addLevel"> 
								<img class="absmiddle" src="/ProGate-portlet/images/cds/add.png" width="18px" height="18px" /> 
									<fmt:message key="title.level.action.add" /> 
							</a>
						</td>
						<td class="td-align-center" style="vertical-align: top; padding-top: 3px;">
							<a href="#" class="editCompetency"> 
								<img class="absmiddle" src="/ProGate-portlet/images/cds/edit.gif" width="18px"
								height="18px" /> <fmt:message key="title.competency.action.edit" />
							</a>
						</td>
						<td class="td-align-center" style="vertical-align: top; padding-top: 3px;">
							<a href="#" class="deleteCompetency"> 
								<img class="absmiddle" src="/ProGate-portlet/images/cds/delete.png" width="18px"
								height="18px" /> 
									<fmt:message key="title.competency.action.delete" /> 
							</a>
						</td>
					</tr>

					<!-- Lay ra tat ca cac level cua competencies[i] -->
					<c:if test="${bean.competencyLevel[i] > 0}">
						<c:forEach var="j" begin="${pageScope.init1}"
							end="${pageScope.init1 + bean.competencyLevel[i]-1}">
							<tr class="cds-background-white">
								<td class="span-12" >
									<div style="padding-left: 20px;">
										<div style="float:left;">
											<img src="/ProGate-portlet/images/cds/vuong.png" 
												width="10px" height="10px" style="margin-top: 0.35em" />
										</div>
										<div style="padding-left: 20px; text-align: justify;" > 
											<strong><c:out escapeXml="false" value="${bean.allLevels[j].name}"></c:out></strong>
										</div>
									</div>
									
									<input type="hidden" name="id" value='<c:out value="${bean.allLevels[j].levelId}" />' /> 
									<input type="hidden" name="name" value='<c:out escapeXml="false" value="${bean.allLevels[j].name}" />' /> 
									<input type="hidden" name="nextSlotOrder" value='<c:out value="${bean.nextSlotOrders[j]}" />' /> 
									<input type="hidden" name="hasSlots" value='<c:out value="${bean.levelSlot[j]}" />' />
								</td>
								<td style="vertical-align: top; padding-top: 4px;"><fmt:message key="title.CDS.order" />: 
									<c:out value="${bean.allLevels[j].numberOrder}"></c:out>
								</td>
								<td class="td-align-left" style="vertical-align: top; padding-top: 3px;">
									<a href="#" class="addSlot">
										<img class="absmiddle"
										src="/ProGate-portlet/images/cds/add.png" width="18px"
										height="18px" /> <fmt:message key="title.slot.action.add" />
									</a>
								</td>
								<td class="td-align-center" style="vertical-align: top; padding-top: 3px;">
									<a href="#" class="editLevel">
										<img class="absmiddle"
										src="/ProGate-portlet/images/cds/edit.gif" width="18px"
										height="18px" /> <fmt:message key="title.level.action.edit" />
									</a>
								</td>
								<td class="td-align-center" style="vertical-align: top; padding-top: 3px;">
									<a href="#" class="deleteLevel">
										<img class="absmiddle"
										src="/ProGate-portlet/images/cds/delete.png" width="18px"
										height="18px" /> <fmt:message key="title.level.action.delete" />
									</a>
								</td>
							</tr>

							<!-- Lay ra tat ca cac slot cua levels[j] -->
							<c:if test="${bean.levelSlot[j] > 0}">
								<c:forEach var="k" begin="${pageScope.init2}"
									end="${pageScope.init2 + bean.levelSlot[j]-1}">
									<tr class="cds-background-white">
										<td style="vertical-align: top; padding-top: 6px;">
											<div class="span-12" style="padding-left: 40px;">
												<div style="float:left;">
													<img src="/ProGate-portlet/images/cds/muiten.png" 
														width="10px" height="10px" style="margin-top: 0.45em"/>
												</div>
												<div style="padding-left: 20px; text-align: left;">
													<strong><c:out escapeXml="false" value="${bean.allSlots[k].name}"></c:out>:</strong>
													<span><c:out escapeXml="false" value="${bean.allSlots[k].description}"></c:out></span>
												</div>
											</div> 
											<%-- 
											<div class="span-7 td-align-top" style="text-align: justify;">
												<c:out value="${bean.allSlots[k].description}"></c:out>
											</div>
											 --%>
											<input type="hidden" name="id" value='<c:out value="${bean.allSlots[k].slotId}" />' /> 
											<input type="hidden" name="name" value='<c:out escapeXml="false" value="${bean.allSlots[k].name}" />' />
										</td>
										<td style="vertical-align: top; padding-top: 4px;">
											<fmt:message key="title.CDS.order" />: <c:out value="${bean.allSlots[k].numberOrder}"></c:out>
										</td>
										<td></td>
										<td class="td-align-center" style="vertical-align: top; padding-top: 3px;">
											<a href="#" class="editSlot"> <img class="absmiddle"
												src="/ProGate-portlet/images/cds/edit.gif" width="18px"
												height="18px" /> <fmt:message key="title.slot.action.edit" />
											</a>
										</td>
										<td class="td-align-center" style="vertical-align: top; padding-top: 3px;">
											<a href="#" class="deleteSlot"> <img class="absmiddle"
												src="/ProGate-portlet/images/cds/delete.png" width="18px"
												height="18px" /> <fmt:message key="title.slot.action.delete" />
											</a>
										</td>
									</tr>
								</c:forEach>
								<c:set var="init2" value="${pageScope.init2+bean.levelSlot[j]}"
									scope="page" />
							</c:if>
						</c:forEach>
						<c:set var="init1"
							value="${pageScope.init1+bean.competencyLevel[i]}" scope="page" />
					</c:if>
				</c:forEach>
			</c:if>
		</table>
	</div>

	<jsp:include page="/html/portlet/cds/configuration/configCDSTree/competencyDialog.jsp"></jsp:include>
	<jsp:include page="/html/portlet/cds/configuration/configCDSTree/levelDialog.jsp"></jsp:include>
	<jsp:include page="/html/portlet/cds/configuration/configCDSTree/slotDialog.jsp"></jsp:include>

</div>
</c:otherwise>
</c:choose>