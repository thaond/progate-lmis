<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<div class="content-has-table border-radius">
	<portlet:renderURL var="evaluationURL">
		<portlet:param name="action" value="cds.evaluation" />
		<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_EVALUATION_1%>" />
		<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
	</portlet:renderURL>
	<form method="post" action="${evaluationURL }">
		<div class="filter-area">
			<label class="span-3 padding-bottom last"><strong>Bạn đang ở title: </strong> </label>
			<label class="span-6 padding-bottom" style="color: #E46C0A"> 
				<strong>${bean.titleName }</strong> 
			</label>
			<div class="clear"></div>
			
			<label class="span-3 last">Competency </label>
			<div class="span-7">
				<select class="span-6" name="<%=RequestConst.COMPETENCY_ID%>" onchange="this.form.submit()">
					<option value="0"
						<c:if test="${bean.selectedCompetency == 0}">
							<c:out value="selected" />
						</c:if>>Tất cả
					</option>
					<c:forEach items="${bean.competencies }" var="competency">
						<option value="${competency.competencyId}"
							<c:if test="${bean.selectedCompetency == competency.competencyId}">
								<c:out value="selected" />
							</c:if>>${competency.name }
						</option>
					</c:forEach>
				</select>
			</div>
			
			<label class="span-3 ">Trạng thái slot</label>
			<div class="span-7">
				<select class="span-6" name="<%=RequestConst.SLOT_STATUS%>" onchange="this.form.submit()">
					<option value="0"
						<c:if test="${bean.selectedSlotStatus == 0}">
							<c:out value="selected" />
						</c:if>>Tất cả
					</option>
					<option value="1"
						<c:if test="${bean.selectedSlotStatus == 1}">
							<c:out value="selected" />
						</c:if>>Đạt
					</option>
					<option value="2"
						<c:if test="${bean.selectedSlotStatus == 2}">
							<c:out value="selected" />
						</c:if>>Không Đạt
					</option>
					<option value="3"
						<c:if test="${bean.selectedSlotStatus == 3}">
							<c:out value="selected" />
						</c:if>>Chưa Đánh Giá
					</option>
				</select>
			</div>
			<div class="clear"></div>
		</div>
	</form>
	<div class="clear"></div>
	
	<table>
	<thead class="scroll-hidden">
		<tr>
			<th class="span-3"></th>
			<th class="span-15">Mô Tả Slot</th>
			<th class="span-2">Điểm</th>
			<th class="span-3 last">Trạng Thái</th>
			
		</tr>
	</thead>
	<tbody class="scroll-hidden">
		<c:forEach items="${bean.finalCompetencies }" var="finalCompetency">
			<tr>
				<td colspan="4"><strong>${finalCompetency.name }
					</strong> – Level Ranking: 
					<c:if test="${finalCompetency.levelRankingValue == ''}">
						N/A
					</c:if>
					<c:if test="${finalCompetency.levelRankingValue != ''}">
						${finalCompetency.levelRankingValue }
					</c:if>
				</td>
			</tr>
			<c:forEach items="${functions:getFinalLevelsByCompetencyId(bean.orgId,bean.userId,finalCompetency.competencyId, bean.selectedSlotStatus)}" var="finalLevel">
				<tr>
					<td class="span-3 td-align-right"><strong>${finalLevel.name }</strong></td>
					<td class="span-15 td-align-right"></td>
					<td class="span-2 td-align-center">
					<c:choose>
						<c:when test="${finalLevel.totalLevelPoint > 0}">
							<c:set var='maxLevelPoint' value='${functions:getMaxLevelPoint(bean.orgId,finalLevel.levelId ) }'  scope="page" />
							${finalLevel.totalLevelPoint }/${maxLevelPoint }
						</c:when>
						<c:otherwise>
							-
						</c:otherwise>
					</c:choose>
					</td>
					<td class="span-3 last td-align-center"></td>
				</tr>
				<c:forEach items="${functions:getFinalSlotsByLevelId(bean.orgId,bean.userId,finalLevel.levelId,bean.selectedSlotStatus)}" var="finalSlot">
					<tr>
						<portlet:renderURL var="slotInformationURL">
							<portlet:param name="action" value="slotInformation" />
							<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_EVALUATION_1%>" />
							<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
							<portlet:param name="<%=RequestConst.SLOT_ID %>" value="${finalSlot.slotId}" />
						</portlet:renderURL>
						<td class="span-3 td-align-right" style="vertical-align: top;">
							<a href="${slotInformationURL }">${finalSlot.name }</a>
						</td>
						<td class="span-15 td-align-left" style="vertical-align: top; text-align: justify;">
							${finalSlot.description }
						</td>
						<td class="span-2 td-align-center" style="vertical-align: top;">
						<c:choose>
							<c:when test="${finalSlot.ratingStatus == true}">
								${finalSlot.pointName }/${finalSlot.maxPointName }
							</c:when>
							<c:otherwise>
								-
							</c:otherwise>
						</c:choose>
						</td>
						<c:choose>
							<c:when test="${finalSlot.isPassed == true}">
							<td class="span-3 last td-align-center" title="Đạt"
								style="vertical-align: top; border:0px;">
								<img src="/ProGate-portlet/images/cds/check-green.png" width="18px" height="18px" />	
							</td>
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${finalSlot.ratingStatus == true}">
									<td class="span-3 last td-align-center" title="Không đạt"
										style="vertical-align: top; padding-top: 7px; border:0px;">
										<img src="/ProGate-portlet/images/cds/x.png" width="15px" height="15px" />	
									</td>
									</c:when>
									<c:otherwise>
									<td class="span-3 last td-align-center" title="Chưa đánh giá"
										style="vertical-align: top; border:0px;">
										<span> - </span>
									</td>
									</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</c:forEach>
		</c:forEach>
	</tbody>
	</table>
	
	<div class="right" style="margin:2px 10px; ">
		<portlet:renderURL var="prepareURL">
			<portlet:param name="action" value="commonController" />
			<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_EVALUATION_2%>" />
			<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
		</portlet:renderURL>
		<a href="${prepareURL}">
			<img class="absmiddle" src="/ProGate-portlet/images/cds/arrow-right.png" width="50px" height="50px" alt="Tiếp tục" />
		</a>
	</div><div class="clear"></div>
	
</div>
