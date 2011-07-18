<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<div class="border-radius" style="min-height: 475px; width: 910px; margin-bottom: 20px">
<c:choose>
<c:when test="${bean.errorHaveNotAnyOpenPeriod == true}">
	<div style="" class="prepend-top cds-notification">
		Hiện không có đợt CDS nào đang tồn tại ở trạng thái “Mở”. <br/>
		Vui lòng nhấp <a href="#">vào đây</a> để trở lại trang chủ.
	</div>
</c:when>
<c:otherwise>
	<div class="" style="padding: 10px; background-color: rgb(219, 238, 244); -moz-border-radius-topleft: 5px; -moz-border-radius-topright: 5px; -moz-border-radius-bottomright: 5px; -moz-border-radius-bottomleft: 5px;">
		<form method="post" action="">
			<label class="span-3 last padding-bottom"><strong>Bạn đang ở title:</strong></label> 
			<label class="span-19 last padding-bottom" style="color: #F7941D; margin-left: 10px"><strong>${bean.currentTitle}</strong></label>
			<div class="clear"></div>

			<label class="span-3 last">Đợt CDS</label>
			<div class="span-8 last" style="margin-left: 10px">
				<select class="span-7 last" onchange="this.form.submit()" id="periodId" name="<%=RequestConst.PERIOD_ID%>">
					<c:forEach items="${bean.periods}" var="period">
						<option <c:if test="${period.cdsEvaluationPeriodsId == bean.selectedPeriodId}">selected="selected"</c:if> value="${period.cdsEvaluationPeriodsId}">
							${period.name} - <fmt:formatDate pattern="MM/yyyy" value="${period.startDate}" /> đến <fmt:formatDate pattern="MM/yyyy" value="${period.endDate}" />
						</option>	
					</c:forEach>
				</select>
			</div>
			<div class="span-11 last" style="text-align: right">
			<c:if test="${bean.errorNotInThisPeriod == false}">
				<span style="margin-right: 10px"><strong>Trạng thái CDS:</strong></span>
				<c:choose>
					<c:when test="${bean.paStatus.ratingStatus == 0}">
					<span style="margin-right: 10px" title="Chưa đánh giá">
						<img class="absmiddle" src="/ProGate-portlet/images/cds/check-gray.png" width="18px" height="18px" /> Nhân viên
					</span> 
					</c:when>
					<c:when test="${bean.paStatus.ratingStatus == 1}">
					<span style="margin-right: 10px" title="Đang đánh giá">
						<img class="absmiddle" src="/ProGate-portlet/images/cds/inprogress.png" width="18px" height="18px" title="Đang đánh giá"/> Nhân viên
					</span>
					</c:when>
					<c:when test="${bean.paStatus.ratingStatus == 2}">
					<span style="margin-right: 10px" title="Đã đánh giá">
						<img class="absmiddle" src="/ProGate-portlet/images/cds/check-green.png" width="18px" height="18px" title="Đã đánh giá"/> Nhân viên
					</span> 
					</c:when>
				</c:choose>
					
				<c:choose>
					<c:when test="${bean.paStatus.ratingStatusPm == 0}">
					<span style="margin-right: 10px" title="Chưa phê duyệt">
						<img class="absmiddle" src="/ProGate-portlet/images/cds/check-gray.png" width="18px" height="18px" title="Chưa phê duyệt"/> PM
					</span> 
					</c:when>
					<c:when test="${bean.paStatus.ratingStatusPm == 1}">
					<span style="margin-right: 10px" title="Đang phê duyệt">
						<img class="absmiddle" src="/ProGate-portlet/images/cds/inprogress.png" width="18px" height="18px" title="Đang phê duyệt"/> PM
					</span> 
					</c:when>
					<c:when test="${bean.paStatus.ratingStatusPm == 2}">
					<span style="margin-right: 10px" title="Đã phê duyệt">
						<img class="absmiddle" src="/ProGate-portlet/images/cds/check-green.png" width="18px" height="18px" title="Đã phê duyệt"/> PM
					</span> 
					</c:when>
				</c:choose>
				
				<c:choose>
					<c:when test="${bean.paStatus.ratingStatusBod == 0}">
					<span style=""  title="Chưa phê duyệt">
						<img class="absmiddle" src="/ProGate-portlet/images/cds/check-gray.png" width="18px" height="18px"/> BOD
					</span> 
					</c:when>
					<c:when test="${bean.paStatus.ratingStatusBod == 1}">
					<span style=""  title="Đang phê duyệt">
						<img class="absmiddle" src="/ProGate-portlet/images/cds/inprogress.png" width="18px" height="18px" title="Đang phê duyệt"/> BOD
					</span> 
					</c:when>
					<c:when test="${bean.paStatus.ratingStatusBod == 2}">
					<span style=""  title="Đã phê duyệt">
						<img class="absmiddle" src="/ProGate-portlet/images/cds/check-green.png" width="18px" height="18px" title="Đã phê duyệt"/> BOD
					</span> 
					</c:when>
				</c:choose> 
					
			</c:if>
			</div>
			
		</form>
		<div class="clear"></div>
	</div>

	<div class="clear"></div>
	<c:choose>
		<c:when test="${bean.errorNotInThisPeriod == true}">
			<div style="" class="cds-notification">
				Hiện tại bạn không được quyền đánh giá trong đợt CDS này.<br />
				Vui lòng chọn đợt CDS khác để đánh giá.
			</div>
		</c:when>
		<c:when test="${bean.warningHaveNotAnySlot == true}">
			<portlet:renderURL var="tab2">
				<portlet:param name="action" value="commonController" />
				<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_EVALUATION_2%>" />
				<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
				<portlet:param name="<%=RequestConst.PERIOD_ID%>" value="${bean.selectedPeriodId}"/>
			</portlet:renderURL>
			<div style="" class="cds-notification">
				Hiện tại không có slot nào trong danh sách đánh giá.<br/>
				Vui lòng nhấn <a href="${tab2}">vào đây</a> để thêm slot.
			</div>
		</c:when>
		<c:otherwise>
			<table>
				<thead>
					<tr>
						<th class="span-18" colspan="2" rowspan="2">Mô Tả Slot</th>
						<th rowspan="2" class="span-1">Điểm</th>
						<th rowspan="2" class="span-2">Đánh giá</th>
						<th colspan="3" class="span-3 last">Trạng Thái Slot</th>
						
					</tr>
					<tr>
						<!-- <th class="span-2"></th> -->
						<th class="span-2">Nhân viên đánh giá</th>
						<th class="span-2">PM phê duyệt</th>
						<th class="span-2 last">BOD phê duyệt</th>
					</tr>
				
				</thead>
				<tbody>
				<c:forEach items="${bean.competencies}" var="competency">
					<tr>
						<td colspan="6">
							<strong> ${functions:getCompetencyNameByCompetencyId(competency.competencyId)}</strong> 
						– Level Ranking:
						<c:choose>
							<c:when test="${competency.levelRankingHash == 0}">N/A</c:when>
							<c:otherwise>${competency.levelRankingValue}</c:otherwise>
						</c:choose> 
						</td>
					</tr>
					<c:forEach items="${functions:getPALevelsByPACompetencyId(bean.userId, bean.selectedPeriodId, competency.competencyId)}" var="level">
						<tr>
							<td class="span-3 td-align-right"><strong>${level.levelName}</strong></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<c:forEach items="${functions:getPASlotsByPALevelId(bean.userId, bean.selectedPeriodId, level.levelId)}" var="slot">
							<tr>
								<td class="span-3 td-align-right">${slot.slotName}
								</td>
								<td class="span-15 td-align-left">${slot.description}</td>
								<td class="span-1 td-align-right">
									<c:if test="${slot.pointValue == 0}">-</c:if>
									<c:if test="${slot.pointValue != 0}">${slot.pointValue}</c:if>
								</td>
								<td class="span-2 td-align-center">
									<portlet:renderURL var="tab3Page2">
										<portlet:param name="action" value="commonController" />
										<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_EVALUATION_3%>" />
										<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
										<portlet:param name="<%=RequestConst.TAB_PAGE%>" value="2" />
										<portlet:param name="<%=RequestConst.PERIOD_ID%>" value="${bean.selectedPeriodId}"/>
										<portlet:param name="<%=RequestConst.SLOT_ID%>" value="${slot.slotId}"/>
									</portlet:renderURL>
									<a href="${tab3Page2}">
									<img src="/ProGate-portlet/images/cds/evaluate.png" width="18px" height="18px" /></a></td>
								<td class="span-3 last td-align-center">
								<c:choose>
									<c:when test="${slot.ratingStatus == 0}">
										<img src="/ProGate-portlet/images/cds/check-gray.png" width="18px" height="18px" title="Chưa đánh giá"/>
									</c:when>
									<c:when test="${slot.ratingStatus == 1 || slot.ratingStatus == 2}">
										<img src="/ProGate-portlet/images/cds/check-green.png" width="18px" height="18px" title="Đã đánh giá"/>
									</c:when>
								</c:choose>
								</td>
								<td class="span-3 last td-align-center">
								<c:choose>
									<c:when test="${slot.ratingStatusPm == 0}">
										<img src="/ProGate-portlet/images/cds/check-gray.png" width="18px" height="18px" title="Chưa phê duyệt"/>
									</c:when>
									<c:when test="${slot.ratingStatusPm == 1 || slot.ratingStatusPm == 2}">
										<img src="/ProGate-portlet/images/cds/check-green.png" width="18px" height="18px" title="Đã phê duyệt"/>
									</c:when>
								</c:choose>
								</td>
								<td class="span-3 last td-align-center">
								<c:choose>
									<c:when test="${slot.ratingStatusBod == 0}">
										<img src="/ProGate-portlet/images/cds/check-gray.png" width="18px" height="18px" title="Chưa phê duyệt"/>
									</c:when>
									<c:when test="${slot.ratingStatusBod == 1 || slot.ratingStatusBod == 2}">
										<img src="/ProGate-portlet/images/cds/check-green.png" width="18px" height="18px" title="Đã phê duyệt"/>
									</c:when>
								</c:choose>
								</td>
							</tr>	
						</c:forEach>
					</c:forEach>
				</c:forEach>
				</tbody> 
			</table>
			</c:otherwise>
	</c:choose>
	
</c:otherwise>
</c:choose>
</div>