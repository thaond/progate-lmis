<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<c:choose>
<c:when test="${bean.hasPermissionSlotReport == false}">
<div class="cds-container">
	<div class="left padding-top" style="font-size: 1.1em; color: #E46C0A">
		<img class="absmiddle" src="/ProGate-portlet/images/cds/statisticalReport.png"
			width="40px" height="40px" />
		<strong>Báo Cáo Thống Kê Slot</strong>
	</div>
	<div class="clear"></div>
	<div class="border-radius" style="min-height: 495px; margin-bottom: 20px">
		<div class="cds-notification">Rất tiếc! Bạn không có quyền truy cập vào liên kết này.<br/>
			Vui lòng nhấp <a href="#">vào đây</a> để trở lại trang chủ.
		</div>
	</div>
</div>	
</c:when>
<c:otherwise>
<div class="cds-container">
	<div class="left padding-top" style="font-size: 1.1em; color: #E46C0A">
		<img class="absmiddle" src="/ProGate-portlet/images/cds/statisticalReport.png"
			width="40px" height="40px" />
		<strong>Báo Cáo Thống Kê Slot</strong>
	</div>
	<div class="clear"></div>
	
	<div style="padding:5px;">
		<label class="span-3 padding-bottom"><strong>Bạn đang ở title: </strong></label>
		<label class="span-7 padding-bottom" style="color: #E46C0A"> 
			<strong>
				<c:choose>
					<c:when test="${bean.currentTitle != ''}">
						${bean.currentTitle }
					</c:when>
					<c:otherwise>
						N/A
					</c:otherwise>
				</c:choose>
			</strong> 
		</label>
	</div>
	<div class="clear"></div>
	
	<c:choose>
	<c:when test="${bean.hasClosedEvaluationPeriods == false}">
	<div class="notification border-radius" style="min-height: 495px; margin-bottom: 20px">
		Hiện không có đợt CDS nào đang tồn tại ở trạng thái “Đóng”<br />
		Vui lòng nhấp <a href="#">vào đây</a> để trở lại trang chủ.
	</div>
	</c:when>
	<c:otherwise>
	<div class="content-has-table border-radius" style="margin-bottom:15px; padding-bottom:0px;">
		<portlet:renderURL var="slotSR">
			<portlet:param name="action" value="commonController" />
			<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
		</portlet:renderURL>
		<form method="post" action='<c:out value="${slotSR}"/>'>
			<div class="filter-area span-21">
			
				<label class="span-2 ">Đợt CDS  </label>
				<div class="span-8 ">
					<select class="span-6" name="<%=RequestConst.PERIOD_ID %>" onchange="this.form.submit()">
						<c:forEach items="${bean.evaluationPeriods }" var="eP">
							<option value="${eP.cdsEvaluationPeriodsId}"
								<c:if test="${bean.selectedPeriod == eP.cdsEvaluationPeriodsId}">
									<c:out value="selected" />
								</c:if>>${eP.name } - <fmt:formatDate pattern="MM/yyyy" value="${eP.startDate}" /> đến <fmt:formatDate pattern="MM/yyyy" value="${eP.endDate}" />
							</option>
						</c:forEach>
					</select>
				</div>
				
				<label class="span-1 "><strong>Title: </strong></label>
				<label class="span-9 " style="color: #E46C0A"> 
					<strong>
						<c:choose>
							<c:when test="${bean.periodTitle != ''}">
								${bean.periodTitle}
							</c:when>
							<c:otherwise>
								N/A
							</c:otherwise>
						</c:choose>
					</strong> 
				</label>
				<div class="clear"></div>
			</div>
		</form>
		<div class="clear"></div>
		
		<table>
			<thead>
				<tr>
					<th class="span-17" colspan="2">Mô Tả Slot</th>
					<th class="span-4">Tên PM</th>
					<th class="span-2 last">Điểm</th>
				</tr>
			</thead>
			<tbody>
				
				<c:forEach items="${bean.listCompetency}" var="competency">
					<tr>
						<td colspan="4"><strong>${competency.name }
							</strong> – Level Ranking: 
							<c:if test="${competency.levelRankingValue == ''}">
								N/A
							</c:if>
							<c:if test="${competency.levelRankingValue != ''}">
								${competency.levelRankingValue }
							</c:if>
						</td>
					</tr>
					<c:forEach items="${functions:getSSRLevelsByCompetencyId(bean.orgId, bean.userId, bean.selectedPeriod, competency.competencyId)}" var="level">
						<tr>
							<td class="span-3 td-align-right"><strong>${level.name }</strong></td>
							<td class="span-15 td-align-right"></td>
							<td class="span-2 td-align-center"></td>
							<td class="span-3 last td-align-center">
								<c:choose>
									<c:when test="${level.totalLevelPoint > 0}">
										<c:set var='maxLevelPoint' value='${functions:getMaxLevelPoint(bean.orgId,level.levelId ) }'  scope="page" />
										${level.totalLevelPoint }/${maxLevelPoint }
									</c:when>
									<c:otherwise>
										
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<c:forEach items="${functions:getSSRSlotsByLevelId(bean.orgId, bean.userId, bean.selectedPeriod, level.levelId)}" var="slot">
							<tr>
								<td class="span-3 td-align-right"><strong>${slot.name}</strong></td>
								<td class="span-15 td-align-left">${slot.description}</td>
								<td class="span-2 td-align-center">
									<c:choose>
										<c:when test="${slot.ratingStatusPm > 0}">
											${functions:getUserFullnameByUserId(slot.pmId)}
										</c:when>
										<c:when test="${slot.ratingStatusPm == 0 && slot.pointValue > 0}">
											-
										</c:when>
										<c:otherwise>
											
										</c:otherwise>
									</c:choose>
								</td>
								<c:set var='highlight' value=''  scope="page" />
								<c:if test="${slot.status == bean.selectedPeriod}">
									<c:set var='highlight' value='background:#FFFF66'  scope="page" />
								</c:if>
								<td class="span-3 last td-align-center" style="${highlight}">
									<c:choose>
										<c:when test="${slot.ratingStatusBod > 0}">
											${slot.pointName }/${slot.maxPointName}
										</c:when>
										<c:when test="${slot.ratingStatusBod == 0 && slot.pointValue > 0}">
											-
										</c:when>
										<c:otherwise>
											
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</c:forEach>
					</c:forEach>
				</c:forEach>
			</tbody>
		</table>
		
		<div class="span-10" style="padding-top:5px; padding-left:5px; padding-bottom:5px;">
			<strong>Chú thích: </strong> <img class="absmiddle" src="/ProGate-portlet/images/cds/yellow-light.png"
			width="20px" height="20px" /> <label>Slot được đánh giá trong đợt đang chọn</label>
		</div>
		<div class="clear"></div>
	</div>
	</c:otherwise>
	</c:choose>
	
</div>
</c:otherwise>
</c:choose>