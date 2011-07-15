<%@ include file="../../../lmis/grid/grid.jsp" %>
<%@ include file="../../../lmis/init-tvna.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>


<script type="text/javascript">
	jQuery(document).ready(function(){
		if (${bean.selectedStatus == 1}){
			jQuery("#status option[value='1']").attr('selected','selected');
		}
		if(${bean.selectedStatus == 2}){
			jQuery("#status option[value='2']").attr('selected','selected');
		}
		if(${bean.selectedStatus == 3}){
			jQuery("#status option[value='3']").attr('selected','selected');
		}
	});
	function mySelect(){
		var url = '<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
			<portlet:param name="action" value="managerChangeWorkingTime" />
			<portlet:param name="<%=Constants.CMD%>" value="<%=Request.SELECTED%>"/>
			<portlet:param name="<%=Request.TAB_ACT%>" value="<%=Request.TAB_MANAGER%>" />
			<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
		</portlet:renderURL>';
	submit(url);
	}
	jQuery(function() {
		// Handle focus and blur event of search texbox
		jQuery(".txt-search").focus(function() {
			if (jQuery(this).val() == '<fmt:message key="lmis.common.find" />') {
				jQuery(this).val('');
			}
		});
		jQuery(".txt-search").blur(function(){
			if (jQuery(this).val() == "") {
				jQuery(this).val('<fmt:message key="lmis.common.find" />');
			}
		});
		//click review
		jQuery(".review").click(function(e){
			e.preventDefault();
			var id = e.currentTarget.parentNode.getElementsByTagName("input")[2].value;
			var url = '<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
							<portlet:param name="action" value="managerChangeWorkingTime" />
							<portlet:param name="<%=Request.SELECTED_ID%>" value="id_changetime" />
							<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
							<portlet:param name="<%=Request.TAB_ACT%>" value="<%=Request.TAB_MANAGER%>" />
							<portlet:param name="<%=Constants.CMD%>" value="<%=Request.REVIEW%>" />
						</portlet:renderURL>';
			url=url.replace('id_changetime',id);
			submit(url);
		});
		jQuery(".detailChange").click(function(e){
			e.preventDefault();
			var id=e.currentTarget.parentNode.getElementsByTagName("input")[2].value;
			var url = '<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
							<portlet:param name="action" value="managerChangeWorkingTime" />
							<portlet:param name="<%=Request.SELECTED_ID%>" value='id_changetime' />
							<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
							<portlet:param name="<%=Request.TAB_ACT%>" value="<%=Request.TAB_MANAGER%>" />
							<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.VIEW%>" />
						</portlet:renderURL>';
			url=url.replace('id_changetime',id);
			submit(url);
		});
	});
	function submit(url){
		document.frmManagerChangeWorkingTime.action=url;
		document.frmManagerChangeWorkingTime.submit();
	}
	function pagingSubmit(){ 
		jQuery('#frmManagerChangeWorkingTime').submit(); 
	}
</script>


<form action="" name="frmManagerChangeWorkingTime" id="frmManagerChangeWorkingTime" method="post">
	<c:choose>
   		 <c:when test="${bean.countPending !=0}">  	
   			 <div class="cls-rightAngle" style="margin-right:10px;margin-top:-1.5em">
   			 <label style="font-weight:bold;color:blue"><fmt:message key="lmis.overtimeReport.youhave">
   			 											<fmt:param>${bean.countPending }</fmt:param></fmt:message> </label>
    		</div>
    	</c:when>
    </c:choose>
    <div class="content">
    <div style="padding:10px 0 0 10px;float:left">
    	<label>Trạng thái</label>
    	<span>
			<select style="width: 200px;height: 25px" name="selectedStatus" id="status" onchange="mySelect()">
				<option value="-1">
					<c:out value="Tất cả"/>
				</option>
				<option value="1" >
					<c:out value="Chờ phê duyệt"/>
				</option>
				<option value="2">
					<c:out value="Đồng ý"/>
				</option>
				<option value="3">
					<c:out value="Không đồng ý"/>
				</option>
			</select>
		</span>
				
    </div>
    <div class="search">
		<input class="txt-search" style="margin-left:50px" type="text" name="<%=Constants.SEARCH %>"  value='<fmt:message key="lmis.common.find" />'/>
		<span class="bt-search" style="margin-right:-20px">&nbsp</span>
	</div>
	<c:choose>
    	<c:when test="${bean.size ==0 }">
    	<div style="margin-top:10px">
			<%@ include file="../../../lmis/noDataManager.jsp" %>
		</div>
		</c:when>
	<c:otherwise>
		<div class="tableContainer" style="min-height: 315px">
			<table width="100%" border="0" cellspacing="0">
				<thead style="color:#ffffff">
					<tr>
						<th class="styleSTT"  scope="col"><fmt:message key="lmis.common.number" /> </th>
						<th width="10%"  scope="col"><fmt:message key="lmis.changeworkingtime.codeform" /></th>
						<th width="30%" scope="col"><fmt:message key="lmis.commom.fullname.employee" /></th>
						<th width="15%"  scope="col"><fmt:message key="lmis.changeworkingtime.startdate" /></th>
						<th width="15%" scope="col"><fmt:message key="lmis.changeworkingtime.enddate" /></th>
						<th width="18%" scope="col"><fmt:message key="lmis.common.status" /></th>
						<th scope="col">&nbsp</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="items" items="${bean.listViewTimeChangeReqs}" varStatus="itemCount">
						<c:choose>
							<c:when test="${items.requestedStatus == 2 && (functions:compareDate(bean.dayValue,items.endDate)< 0 || functions:compareDate(bean.dayValue,items.endDate) == 0)}">
								<tr class="hightLight">
							</c:when>
							<c:when test="${itemCount.count % 2 !=0 }">
								<tr class="oddrow">
							</c:when>
							<c:otherwise>
								<tr class="evenrow">
							</c:otherwise>
						</c:choose>
									<td>${itemCount.count}</td>
									<td>${items.lmisViewTimeChangeReqId}</td>
									<td class="cls-left">${items.fullName}</td>
									<td><fmt:formatDate pattern="dd/MM/yyyy" value="${items.startDate }" /></td>
									<td><fmt:formatDate pattern="dd/MM/yyyy" value="${items.endDate}" /></td>
									<td class="cls-left">
										<c:choose>
											<c:when test="${items.requestedStatus == 1 }">
												<fmt:message key="status.waiting" />
											</c:when>
											<c:when test="${items.requestedStatus == 2 }">
												<fmt:message key="status.agree" />
											</c:when>
											<c:when test="${items.requestedStatus == 3 }">
												<fmt:message key="status.notagree" />
											</c:when>
										</c:choose>
									</td>
									<td>
										<input class="detailChange" type="image" src="/ProGate-portlet/images/lmis/detail.png"
											title='<fmt:message key="lmis.viewDetail" />'/>
										<c:choose>
											<c:when test="${items.requestedStatus==3 || items.requestedStatus==2}">
												<input class="review" type="image" src="/ProGate-portlet/images/lmis/disable_review.png" disabled="disabled" />
											</c:when>
											<c:otherwise>
												<input class="review" type="image" src="/ProGate-portlet/images/lmis/review.png"
													title='<fmt:message key="lmis.review" />'/>
											</c:otherwise>
										</c:choose>
										<input type="hidden" class="selectChangeTimeID" value="${items.lmisViewTimeChangeReqId}" />
									</td>
					</c:forEach>
				</tbody>
			</table>
		</div><!--End tableContainer-->
		<div class="lmis-paging"> 
					<c:set value="${bean.pagination}" var="paging"></c:set> 
						<%@ include file="/html/portlet/common/pagination.jsp" %>  
		</div>
		</c:otherwise>
	</c:choose>
	</div><!--End content-->
	
</form>
