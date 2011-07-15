<%@ include file="../../../lmis/init-tvna.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
function mySelect(){
	var check = jQuery('.txt-search').val();
	if(check == "Nhập tên nhân viên"){
		jQuery('.txt-search').val("");
	}
	var url = '<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
			<portlet:param name="action" value="managerAttendanceInfo" />
			<portlet:param name="<%=Constants.CMD%>" value="<%=Request.SELECTED%>"/>
			<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
		</portlet:renderURL>';
	submit(url);
}

jQuery(document).ready(function() {				
	/*show datepicker*/
	jQuery("#dateAttendance").datepicker({
		showOn: "both",
		buttonImage: "/ProGate-portlet/images/lmis/viewAttendanceInfo/datetime.png",
		buttonImageOnly: true,
		buttonText:'',
		dateFormat:'dd/mm/yy',
		maxDate:'0'
	});
	jQuery(document).ready(function(){
		jQuery('.tableContainer input:checkbox').attr("disabled","disabled");
	});
});

jQuery(function(){
	//search
	jQuery(".txt-search").focus(function() {
		if (jQuery(this).val() == '<fmt:message key="lmis.common.find"/>') {
			jQuery(this).val('');
		}
	});
	
	jQuery("#dateAttendance").keydown(function(e) {
		if (e.keyCode > 0 ) {
			e.preventDefault();	
		}	
	});
	
	jQuery(".txt-search").blur(function(){
		if (jQuery(this).val() == "") {
			jQuery(this).val('<fmt:message key="lmis.common.find"/>');
		}
	});
	
	jQuery(".uploadFile").click(function(e){
		var url = '<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
						<portlet:param name="action" value="uploadFile" />
						<portlet:param name="<%=Constants.CMD%>" value="<%=Request.UPLOAD%>"/>
						<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
					</portlet:renderURL>';
		submit(url);
	});
	jQuery("#btnViewInfo").click(function(e){
		var date = jQuery("#dateAttendance").val();
		if(date=="" || date == null){
			alert("Bạn chưa chọn ngày ");
		}
		else{
			var url = '<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
						<portlet:param name="action" value="managerAttendanceInfo" />
						<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.VIEW%>"/>
						<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
					</portlet:renderURL>';
			submit(url);
		}
	});
	
	jQuery(".bt-search").click(function(e){
		var check = jQuery('.txt-search').val();
		if(check == "Nhập tên nhân viên"){
			jQuery('.txt-search').val("");
		}
		var url = '<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
						<portlet:param name="action" value="managerAttendanceInfo" />
						<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.SEARCH%>"/>
						<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
					</portlet:renderURL>';
		submit(url);
	});
	
});

function submit(url){
	document.frmManagerAttendanceBy.action=url;
	document.frmManagerAttendanceBy.submit();
}
function pagingSubmit(){ 
	jQuery('#frmManagerAttendanceBy').submit(); 
}
</script>
<jsp:include page="../../dialog/dialog-updateAttendanceInfo.jsp"></jsp:include>

<form action="" name="frmManagerAttendanceBy" id="frmManagerAttendanceBy" method="post">
	<div class="uploadFile">
    	<input id="createChange" type="image" src="/ProGate-portlet/images/lmis/viewAttendanceInfo/upload_file.png"/>
    	<a id="_uploadFile" href="#"><fmt:message key="lmis.attendanceInfo.uploadFile"/></a>
    </div>
    
	<div class="content">
		<div class="sort">
			<div style="float:left">
				<label><fmt:message key="lmis.attendanceInfo.dateAttendances"/></label>
				<span><input type="text" id="dateAttendance" name="dateAttendance" style="height: 20px;width:6em"
						value="<fmt:formatDate pattern="dd/MM/yyyy" value="${bean.dayValue}"/>"/></span>  		
			</div>
			<div style="float:left;margin-top:-2px;margin-left:6px">
				<input type="button" id="btnViewInfo" value="Xem" style="width:45px;height:25px">
			</div>
			<div style="float:left;margin-left:38px">
				<label><fmt:message key="lmis.attendanceInfo.part"/></label>
				<span>
					<select style="width: 200px;height: 22px" name="selectedPart" onchange="mySelect()">
						<option value="-1">
							<c:out value="Tất cả"/>
						</option>
						<c:forEach var="list" items="${bean.listPart}" varStatus="itemCount">
							<c:choose>
								<c:when test="${list.orgId == bean.selectedPartId}">
									<option  value="${list.orgId }" selected="selected">
	                                             <c:out value="${list.name}"/>
									</option>
								</c:when>
								<c:otherwise>
									<option value="${list.orgId}">
										<c:out value="${list.name}"/>
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</span>
			</div>
			<div style="float:right;margin-right:-6px;">
				<input class="txt-search" type="text" name="<%=Constants.SEARCH %>" style="height:22px;width:18em" value='<fmt:message key="lmis.common.find"/>'/>
				<span class="bt-search">&nbsp</span>
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
			<div class="tableContainer">
				<table width="100%" border="0" cellspacing="0" >
					<thead style="color:#ffffff" >
						<tr>
							<th class="styleSTT"  scope="col"><fmt:message key="lmis.common.number"/> </th>
							<th width="6%"  scope="col"><fmt:message key="lmis.config.code.staffID"/> </th>
							<th width="35%"  scope="col"><fmt:message key="lmis.commom.fullname.employee"/> </th>
							<th width="7%" scope="col"><fmt:message key="lmis.common.status"/></th>
							<th width="7%" scope="col"><fmt:message key="lmis.common.allowed"/></th>
							<th width="7%"  scope="col" title="Giờ bắt đầu đăng ký"><fmt:message key="lmis.attendanceInfo.registeredStartTime"/></th>
							<th width="7%" scope="col" title="Giờ kết thúc đăng ký"><fmt:message key="lmis.attendanceInfo.registeredEndTime"/></th>	
							<th width="7%" scope="col" title="Giờ bắt đầu"><fmt:message key="lmis.attendanceInfo.startTime"/></th>
							<th width="7%" scope="col" title="Giờ kết thúc"><fmt:message key="lmis.attendanceInfo.endTime"/></th>
							<th width="5%" scope="col" title="Nghỉ đột xuất"><fmt:message key="lmis.common.unscheduled"/></th>
							<th scope="col"><fmt:message key="lmis.common.edit"/></th>
						</tr>
					</thead>
					<tbody>
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
										<td>${items.staffCode }</td>
										<td class="cls-left">${items.fullName}</td>
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
										<td><fmt:formatDate pattern="HH:mm" value="${items.planStartTime }"/></td>
										<td><fmt:formatDate pattern="HH:mm" value="${items.planEndTime }"/></td>
										<td><fmt:formatDate pattern="HH:mm" value="${items.realStartTime }"/></td>
										<td><fmt:formatDate pattern="HH:mm" value="${items.realEndTime }"/></td>
										<td><img alt="Nghi dot xuat" src="/ProGate-portlet/images/lmis/viewAttendanceInfo/mail.png"></td>
										<td><input class="edit" type="image" src="/ProGate-portlet/images/lmis/edit.png"  
													title='<fmt:message key="lmis.edit"/>' />
											<input type="hidden" class="selectId" value="${items.lmisViewAttDailyId}"/>
										</td>
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
