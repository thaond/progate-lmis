<%@ include file="../../../lmis/init-tvna.jsp" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" %>

<script type="text/javascript">
	jQuery(document).ready(function(){
		jQuery('.tableContainer :input').attr("disabled","disabled");
		jQuery("#dateAttendance").datepicker({
			showOn: "both",
			buttonImage: "/ProGate-portlet/images/lmis/viewAttendanceInfo/datetime.png",
			buttonImageOnly: true,
			buttonText:'',
			dateFormat:'dd/mm/yy',
			maxDate:'0'
		});
		
		if(${bean.status == 0}){
			jQuery("#selectedStatus option[value='0']").attr('selected','selected');
		}
		if(${bean.status == 1}){
			jQuery("#selectedStatus option[value='1']").attr('selected','selected');
		}
		if(${bean.status == 2}){
			jQuery("#selectedStatus option[value='2']").attr('selected','selected');
		}
		if(${bean.status == 3}){
			jQuery("#selectedStatus option[value='3']").attr('selected','selected');
		}
		if(${bean.permissive == 0}){
			jQuery("#selectedPermissive option[value='0']").attr('selected','selected');
		}
		if(${bean.permissive == 1}){
			jQuery("#selectedPermissive option[value='1']").attr('selected','selected');
		}
	});
	
	jQuery(function(){
		jQuery("#btnViewInfo").click(function(e){
			var url = '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>">
						<portlet:param name="action" value="commonController"/>
						<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_PERSONAL %>"/>
						<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId }"/>
						<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.SEARCH%>"/>
						</portlet:renderURL>';
			submit(url);
		});
	});
	function pagingSubmit(){ 
		var url = '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>">
					<portlet:param name="action" value="commonController"/>
					<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_PERSONAL %>"/>
					<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId }"/>
					</portlet:renderURL>';
		submit(url);
	}
	function submit(url){
		document.frmAttendanceInfo.action=url;
		document.frmAttendanceInfo.submit();
	}
</script>	
<form action="" name="frmAttendanceInfo" id="frmAttendanceInfo" method="post">
	<div class="content">
		<div class="sort">
			<div style="float:left">
				<label><fmt:message key="lmis.attendanceInfo.dateAttendances"/></label>
				<span><input type="text" id="dateAttendance" name="dateAttendance" style="height: 20px;width:6em"
						value="<fmt:formatDate pattern="dd/MM/yyyy" value="${bean.dayValue}"/>"/></span>  		
			</div>
			
			<div style="float:left;margin-left:38px">
				<label>Trạng thái</label>
				<span>
					<select style="width: 200px;height: 22px" name="selectedStatus" id="selectedStatus" >
						<option value="-1">
							<c:out value="Tất cả"/>
						</option>
						<option value="0">
							<c:out value="Đi làm"/>
						</option>
						<option value="1">
							<c:out value="Nghỉ buổi sáng"/>
						</option>
						<option value="2">
							<c:out value="Nghỉ buổi chiều"/>
						</option>
						<option value="3">
							<c:out value="Nghỉ cả ngày"/>
						</option>
					</select>
				</span>
			</div>
			<div style="float:left;margin-left:38px">
				<label>Có phép</label>
				<select style="width: 200px;height: 22px" name="selectedPermissive" id="selectedPermissive">
					<option value="-1">
						<c:out value="Tất cả"/>
					</option>
					<option value=1>
						<c:out value="Có"/>
					</option>
					<option value=0>
						<c:out value="Không"/>
					</option>
				</select>
			</div>
			<div style="float:left;margin-left:20px">
				<input type="button" id="btnViewInfo" value="Xem" style="width:45px;height:25px">
			</div>
			<div class="clear"></div>	
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
						<th width="15%"  scope="col"><fmt:message key="lmis.common.day"/> </th>
						<th width="12%"  scope="col" title="Giờ bắt đầu đăng ký"><fmt:message key="lmis.attendanceInfo.registeredStartTime"/></th>
						<th width="12%" scope="col" title="Giờ kết thúc đăng ký"><fmt:message key="lmis.attendanceInfo.registeredEndTime"/></th>	
						<th width="12%" scope="col" title="Giờ bắt đầu"><fmt:message key="lmis.attendanceInfo.startTime"/></th>
						<th width="12%" scope="col" title="Giờ kết thúc"><fmt:message key="lmis.attendanceInfo.endTime"/></th>
						<th width="12%" scope="col"><fmt:message key="lmis.common.status"/></th>
						<th width="10%" scope="col" ><fmt:message key="lmis.common.allowed"/></th>
						<th scope="col" title="Nghỉ đột xuất"><fmt:message key="lmis.common.unscheduled"/></th>
					</tr>
				</thead>
				<tbody >
					<c:forEach var="items" items="${bean.listAttDaily}" varStatus="itemCount">
						<c:choose>
							<c:when test="${itemCount.count % 2 !=0 }">
								<tr class="oddrow">
							</c:when>
							<c:otherwise>
								<tr class="evenrow">
							</c:otherwise>
						</c:choose>
									<td>${itemCount.count}</td>
									<td><fmt:formatDate pattern="dd/MM/yyyy" value="${items.dayValue}"/></td>
									<td><fmt:formatDate pattern="HH:mm" value="${items.planStartTime }"/></td>
									<td><fmt:formatDate pattern="HH:mm" value="${items.planEndTime }"/></td>
									<td><fmt:formatDate pattern="HH:mm" value="${items.realStartTime }"/></td>
									<td><fmt:formatDate pattern="HH:mm" value="${items.realEndTime }"/></td>
									<td>
										<c:choose>
											<c:when test="${items.abSence == 0 }">
												<img src="/ProGate-portlet/images/lmis/viewAttendanceInfo/Di_Lam.png" title="Đi làm">
											</c:when>
											<c:when test="${items.abSence == 1 }">
												<img src="/ProGate-portlet/images/lmis/viewAttendanceInfo/NghiBuoiSang.png" title="Nghỉ buổi sáng">
											</c:when>
											<c:when test="${items.abSence == 2 }">
												<img src="/ProGate-portlet/images/lmis/viewAttendanceInfo/NghiBuoiChieu.png" title="Nghỉ buổi chiều">
											</c:when>
											<c:when test="${items.abSence == 3 }">
												<img src="/ProGate-portlet/images/lmis/viewAttendanceInfo/Nghi_Ca_Ngay.png" title="Nghỉ cả ngày">
											</c:when>
										</c:choose>
									</td>
									<td>
										<c:choose>
											<c:when test="${items.isPermissive == true}">
												<input type="checkbox" name="allowedDayOff" checked="checked">
											</c:when>
											<c:when test="${items.isPermissive == false}">
												<input type="checkbox" name="notAllowedDayOff">
											</c:when>
										</c:choose>
									</td>
									<td><img alt="Nghi dot xuat" src="/ProGate-portlet/images/lmis/viewAttendanceInfo/mail.png" title="Nghỉ đột xuất"></td>
					</c:forEach>
				</tbody>
			</table>
		</div><!-- End table container -->
		<div class="lmis-paging"> 
					<c:set value="${bean.pagination}" var="paging"></c:set> 
						<%@ include file="/html/portlet/common/pagination.jsp" %>  
		</div>
		</c:otherwise>
	</c:choose>
	</div><!-- End content -->
	
</form>		