<%@ include file="/html/portlet/common/init.jsp"%>
<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
function pagingSubmit() {
    jQuery('#titleForm').submit();
}
</script>

<div class="cds-container">
	<div class="left padding-top" style="font-size: 1.1em; color: #E46C0A">
		<img class="absmiddle" src="/ProGate-portlet/images/cds/inforHeader.png"
			width="40px" height="40px" />
		<strong>Thông Tin Slot</strong>
	</div>
	
	<div class="right padding-right prepend-top" style="margin-top: 32px;">
		<portlet:renderURL var="tab1">
			<portlet:param name="action" value="commonController" />
			<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_EVALUATION_1%>" />
			<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
		</portlet:renderURL>
		<a href="${tab1}">
			<img style="margin:0.25em 0;" class="absmiddle" src="/ProGate-portlet/images/cds/back.png"/>
			Quay lại
		</a>
	</div>
	<div class="clear"></div>
	
	<div class="content-has-table border-radius" style="margin: 0px; padding: 0px;">
			<label class="span-3 last padding-left padding-top padding-bottom"><strong>Bạn đang ở title: </strong></label>
			<label class="span-6 padding-top padding-bottom" style="color: #E46C0A"> 
				<strong> ${bean.titleName }</strong>  
			</label>
		<div class="clear"></div>
		
		<div class="slot-information ">
			<strong>${bean.slot.aliasName }: </strong>${bean.slot.description }
		</div>
		<div class="clear"></div>
		
		<div style="min-height: 350px; background-color: white; -moz-border-radius: 5px;">
		<table>
		<thead>
			<tr>
				<th class="span-2">STT</th>
				<th class="span-5">Đợt CDS</th>
				<th class="span-5">Dự Án</th>
				<th class="span-5">PM Phê Duyệt</th>
				<th class="span-2">Điểm </th>
				<th class="span-4 last">Trạng Thái</th>
				
			</tr>
		</thead>
		
		<c:if test="${bean.listSize > 0 }">
			<tbody>
			<c:set value="${bean.pagination}" var="paging"></c:set>
				<c:forEach items="${bean.slotsInfo }" var="slotInfo" varStatus="count">
				<tr>
					<td class="span-2 td-align-center">${count.count + (paging.currentPage -1) * paging.pageSize}</td>
					<td class="span-5 td-align-left">${slotInfo.periodName } - <fmt:formatDate pattern="MM/yyyy" value="${slotInfo.fromDate}" /> đến <fmt:formatDate pattern="MM/yyyy" value="${slotInfo.toDate}" /></td>
					<td class="span-5 td-align-left">${slotInfo.orgName }</td>
					<td class="span-5 td-align-left">${slotInfo.pmName }</td>
					<td class="span-2 td-align-center">${slotInfo.pointName }</td>
					<td class="span-4 last td-align-center">
					<c:choose>
						<c:when test="${slotInfo.isPassed == true}">
							<img title="Đạt" src="/ProGate-portlet/images/cds/check-green.png" width="18px" height="18px"/>	
						</c:when>
						<c:otherwise>
							<img title="Không đạt"src="/ProGate-portlet/images/cds/x.png" width="18px" height="18px"/>	
						</c:otherwise>
					</c:choose>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</c:if>
		</table>
		
		<c:if test="${bean.listSize == 0 }">
			<div class="cds-notification" >
				<span>Slot này chưa được đánh giá.</span>
			</div>
		</c:if>
		</div>
		
		<c:if test="${bean.listSize > 10 }">
			<div class="cds-paging">
			<c:set value="${bean.pagination}" var="paging"></c:set>
			<%@ include file="/html/portlet/common/pagination.jsp" %>
			</div>
			<div class="clear"></div>
		</c:if>
	</div>
</div>