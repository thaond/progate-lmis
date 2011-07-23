<%@ include file="../../../lmis/init-tvna.jsp" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" %>
	
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
		
		if(${bean.unReview == "unReview"}){
			
	 		if(${bean.countPending != 0}){
	 			var id = jQuery('.selectedId').val();
	 			var url = '<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
					<portlet:param name="action" value="managerDayOffInfo" />
					<portlet:param name="<%=Request.SELECTED_ID%>" value='id_changetime' />
					<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
					<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_MANAGER%>"/>
					<portlet:param name="<%=Constants.CMD%>" value="<%=Request.REVIEW%>"/>
				</portlet:renderURL>';
				url = url.replace('id_changetime',id);
				submit(url);
	 		}
		}
	});
	jQuery(function(){
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
		jQuery(".detailRequest").click(function(e){
			var id=e.currentTarget.parentNode.getElementsByTagName("input")[2].value;
			var url = '<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
							<portlet:param name="action" value="managerDayOffInfo" />
							<portlet:param name="<%=Request.SELECTED_ID%>" value='id_changetime' />
							<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
							<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_MANAGER%>"/>
							<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.VIEW%>"/>
						</portlet:renderURL>';
			url = url.replace("id_changetime",id);
			submit(url);
			
		});
		jQuery(".reviewRequest").click(function(e){
			var id= e.currentTarget.parentNode.getElementsByTagName("input")[2].value;
			var url = '<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
							<portlet:param name="action" value="managerDayOffInfo" />
							<portlet:param name="<%=Request.SELECTED_ID%>" value='id_changetime' />
							<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
							<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_MANAGER%>"/>
							<portlet:param name="<%=Constants.CMD%>" value="<%=Request.REVIEW%>"/>
						</portlet:renderURL>';
			url = url.replace('id_changetime',id);
			submit(url);
		});
		jQuery("#btnViewInfo").click(function(e){
			var url =  '<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
						<portlet:param name="action" value="managerDayOffBy" />
						<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
						<portlet:param name="<%=Constants.CMD%>" value="viewFilter"/>
						<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_MANAGER%>"/>
						</portlet:renderURL>';
			submit(url);
		});
		
	});
	function submit(url){
		document.frmManagerDayOffBy.action=url;
		document.frmManagerDayOffBy.submit();
	}
	function pagingSubmit(){ 
		jQuery('#frmManagerDayOffBy').submit(); 
	}
</script>
<jsp:include page="../../dialog/dialog-viewCalDayOff.jsp"></jsp:include>	
<form action="" name="frmManagerDayOffBy" id="frmManagerDayOffBy" method="post">
	<div id="calDayOff" class="cls-rightAngle" style="margin-right:1em">
    	<input id="calDayOff" type="image" src="/ProGate-portlet/images/lmis/Thong_Ke_Don.png" height="24" width="24">
    	<a id="id-rightAngle" href="#">Thống Kê Đơn</a>
    </div>
    <c:choose>
    <c:when test="${bean.countPending !=0}">  	
   		 <div class="cls-rightAngle" style="margin-right:15em;margin-top:-1.5em">
   			 <label style="font-weight:bold;color:blue"><fmt:message key="lmis.overtimeReport.youhave">
   			 											<fmt:param>${bean.countPending }</fmt:param></fmt:message> </label>
    	</div>
    </c:when>
    </c:choose>
    
    <div class="content">
    <div style="padding:10px 0 0 10px;float:left">
    	<label>Trạng thái</label>
    	<span>
			<select style="width: 130px;height: 22px" name="selectedStatus" id="status">
				<option value="-1">
					<c:out value="Tất cả"/>
				</option>
				<option value="1">
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
    <div style="padding:10px 0 0 15px;float:left">
    	<label>Loại ngày nghỉ</label>
    	<span>
			<select name="absenceType" style="width:215px;height: 22px">
				<option value="-1">
					<c:out value="Tất cả"/>
				</option>
				<c:forEach var="list" items="${bean.lsAbType}" varStatus="itemCount">
					<c:choose>
						<c:when test="${list.lmisAbsenceSettingsId == bean.absenceType }">
							<option value= "${list.lmisAbsenceSettingsId }" selected="selected">
								<c:out value="${list.name_ }"/>
							</option>
						</c:when>
						<c:otherwise>
							<option value="${list.lmisAbsenceSettingsId }">
								<c:out value="${list.name_ }"/>
							</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
		</span>
    </div>
    <div style="float:left;padding:10px 35px 0 10px">
		<input type="button" id="btnViewInfo" value="Xem" style="width:45px;height:22px">
	</div>
    <div class="search" style="margin-left:45px">
		<input class="txt-search" type="text" name="<%=Constants.SEARCH %>"  value='<fmt:message key="lmis.common.find" />'/>
		<span class="bt-search" style="margin-right:-20px">&nbsp</span>
	</div>
	<c:choose>
    	<c:when test="${bean.size ==0 }">
    		<div style="margin-top:20px">
				<%@ include file="../../../lmis/noDataManager.jsp" %>
			</div>
		</c:when>
	<c:otherwise>
    	<div class="tableContainer" style="min-height: 315px">
    		<table class="table" >
    			<thead style="color:#ffffff" >
    				<tr>
						<th class="styleSTT"  scope="col"><fmt:message key="lmis.common.number"/> </th>
						<th width="8%"  scope="col"><fmt:message key="lmis.config.code.staffID"/> </th>
						<th width="20%"  scope="col"><fmt:message key="lmis.common.fullname"/> </th>
						<th width="24%"  scope="col"><fmt:message key="lmis.dayoff.type"/></th>
						<th width="11%" scope="col"><fmt:message key="lmis.dayoff.begin"/></th>	
						<th width="11%" scope="col"><fmt:message key="lmis.dayoff.end"/></th>
						<th width="13%" scope="col"><fmt:message key="lmis.common.status"/></th>			
						<th scope="col">&nbsp</th>
					</tr>
    			</thead>
    			<tbody >
    				<c:forEach var="items" items="${bean.listAbsence}" varStatus="itemCount">
    					<c:choose>
							<c:when test="${itemCount.count % 2 !=0 }">
								<tr class="oddrow">
							</c:when>
							<c:otherwise>
								<tr class="evenrow">
							</c:otherwise>
						</c:choose>
									<td>${itemCount.count}</td>
									<td>${functions:getStaffCodeByUserId(bean.orgId,items.requestedBy) }</td>
									<td class="cls-left">${functions:getFullName(items.requestedBy)}</td>
									<td class="cls-left">${items.absenceType }</td>
									<td><fmt:formatDate pattern="dd/MM/yyyy" value="${items.startDate }"/></td>
									<td><fmt:formatDate pattern="dd/MM/yyyy" value="${items.endDate }"/></td>
									<td class="cls-left">
											<c:choose>
												<c:when test="${items.requestedStatus==1}">
													<fmt:message key="status.waiting" />
												</c:when>
												<c:when test="${items.requestedStatus==2}">
													<fmt:message key="status.agree" />
												</c:when>
												<c:when test="${items.requestedStatus==3}">
													<fmt:message key="status.notagree" />
												</c:when>
												<c:when test="${items.requestedStatus==6}">
													Đã vô hiệu hóa
												</c:when>
											</c:choose>
									</td>
									<td>
										<input class="detailRequest" type="image" src="/ProGate-portlet/images/lmis/detail.png"
														title='<fmt:message key="lmis.viewDetail"/>'/>
										<c:choose>
											<c:when test="${items.requestedStatus==1}">
												<input class="reviewRequest" type="image" src="/ProGate-portlet/images/lmis/overtimeManagement/Pheduyet.png"
														title='<fmt:message key="lmis.review"/>'/>
											</c:when>
											<c:otherwise>
												<input class="reviewRequest" type="image" src="/ProGate-portlet/images/lmis/overtimeManagement/Pheduyet_Disable.png" disabled="disabled"/>
											</c:otherwise>
										</c:choose>
										<input type="hidden" class="selectedId" name="absenceRequestsId" value="${items.lmisAbsenceRequestsId }">
									</td>
							</tr>
    				</c:forEach>
    			</tbody>
    		</table>
    	</div><!-- tableContainer -->
    	<div class="lmis-paging"> 
					<c:set value="${bean.pagination}" var="paging"></c:set> 
						<%@ include file="/html/portlet/common/pagination.jsp" %>  
		</div>
		 </c:otherwise>
    </c:choose>
    </div><!-- End content -->
   
</form>
