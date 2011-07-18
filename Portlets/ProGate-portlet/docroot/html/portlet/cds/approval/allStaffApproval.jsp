<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<c:choose>
<c:when test="${bean.hasPermissionOnTab2 == false}">
		<div class="border-radius" style="min-height: 485px; margin-bottom: 20px;">
			<div class="cds-notification">Rất tiếc! Bạn không có quyền truy cập vào liên kết này.<br/>
				Vui lòng nhấp <a href="#">vào đây</a> để trở lại trang chủ.
			</div>
		</div>	
</c:when>
<c:when test="${bean.errorHaveNotAnyOpenPeriod == true}">
		<div class="border-radius" style="min-height: 485px; margin-bottom: 20px;">
			<div style="text-align: center; margin-top: 10px; margin-bottom: 10px">
				Hiện không có đợt CDS nào đang tồn tại ở trạng thái “Mở”.<br />
				Vui lòng nhấp <a href="#">vào đây</a> để trở lại trang chủ.
			</div>
		</div>
</c:when>
<c:otherwise>

<portlet:renderURL var="tab2Reload">
	<portlet:param name="action" value="commonController" />
	<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_APPROVAL_2%>" />
	<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
</portlet:renderURL>
<script>
function pagingSubmit() {
	jQuery('#frmAllStaffApproval').submit();
}

var hrefLockCDS = '<portlet:actionURL>
				<portlet:param name="action" value="commonController" />
				<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_APPROVAL_1%>" />
				<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
				<portlet:param name="<%=RequestConst.PERIOD_ID%>" value="${bean.selectedPeriodId}" />
			</portlet:actionURL>';
				
var enable = true;
function disableApprovalButton(){
	if (enable == false) {
		return;
	} else {
		enable = false;
	}
	jQuery('#allStaffApprovalButton').css("color", "gray");
	jQuery('#allStaffApprovalButton').css("cursor", "default");
	jQuery('#allStaffApprovalButton').html('<img class="absmiddle" src="/ProGate-portlet/images/cds/redPen-dis.png" height="25" width="25" style="cursor:default"/>');
	jQuery('#allStaffApprovalButton').append('Phê duyệt theo đánh giá của PM');
}
function enableApprovalButton(){
	if (enable == true) {
		return;
	} else {
		enable = true;
	}
	jQuery('#allStaffApprovalButton').css("color", "#0066CC");
	jQuery('#allStaffApprovalButton').css("cursor", "pointer");
	jQuery('#allStaffApprovalButton').html('<img class="absmiddle" src="/ProGate-portlet/images/cds/redPen.png" height="25" width="25" style="cursor:pointer"/>');
	jQuery('#allStaffApprovalButton').append('Phê duyệt theo đánh giá của PM');
}

jQuery(document).ready(function(){
	disableApprovalButton();
	/*Kiem tra: neu tat ca checkbox bi disable thi nut checkAll bi disable*/
	var allIsDisabled = true; 
	jQuery("input[@name=checkList]").each(function() {
		var disabled = jQuery(this).attr("disabled");
		if (disabled == false){
			allIsDisabled = false; 
		}
	});
	
	if (allIsDisabled == true) {
		jQuery('#checkAll').attr("disabled", "disabled");
	}
	
	/*Kiem tra xong*/
	jQuery("#checkAll").click(function() {
		var checked_status = this.checked;
		jQuery("input[@name=checkList]").each(function() {
			var disabled = jQuery(this).attr("disabled");
			
			if(checked_status == true) {
				enableApprovalButton();
			}else {
				disableApprovalButton();
			}
			
			if (disabled == false) {
				this.checked = checked_status;	
			}
		});
	});
	
	/*enable/disable approval button when user check more than one checkbox*/
	jQuery("input[@name=checkList]").click(function() {
		var checked_status = false;
		var checkAll = 0;
		var count = 0;
		jQuery("input[@name=checkList]").each(function(i) {
			var disabled = jQuery(this).attr("disabled");
			if (disabled == false) {
				if(jQuery(this).is(":checked")) {
					checked_status = true;
					checkAll = checkAll + 1;
				}
				count = count + 1;		
			}
		});
		if (checkAll == count){
			jQuery("#checkAll").attr('checked', true);
		} else {
			jQuery("#checkAll").attr('checked', false);
		}
		if (checked_status == true) {
			enableApprovalButton();
	 	}else {
	 		disableApprovalButton();
	 	}
	});	
	
	
	jQuery("#allStaffApprovalButton").click(function(e){
		if (enable == false) return false;
		var employeeIdList = new Array();
		jQuery("input[@name=checkList]").each(function(i) {
			if(jQuery(this).is(":checked")) {
				employeeIdList.push(jQuery(this).val());
			}
		});
		//alert("Array:"+employeesId);
		jQuery('#approvalCompetencyForm').modal({
			closeHTML: "<a href='#' title='Close' style='text-decoration:none;position:absolute; right:15px; top:6px; color:#fff;'><img src='/ProGate-portlet/images/cds/closeDialog.gif'/></a>",
			onShow: function(dialog){
				jQuery('#approvalCompetencyForm .yes').click(function(){
					var hrefApproval = '<portlet:actionURL>
						<portlet:param name="action" value="commonController" />
						<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_APPROVAL_2%>" />
						<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
						<portlet:param name="<%=RequestConst.PERIOD_ID%>" value="${bean.selectedPeriodId}" />
						</portlet:actionURL>';
					
					jQuery.ajax({
						type:'POST',
						url: hrefApproval,
						data: {
							'<%=RequestConst.HANDLE%>':'<%=RequestConst.HANDLE_APPROVE_ALL_STAFF%>',
							"employeeIdList":employeeIdList
						},
						success: function(data){
							//alert("server said: "+ data);
							location.href="${tab2Reload}";
						},
						error: function(){
							alert("Co loi xay ra khi dung ajax");
						}
					});
					
					jQuery.modal.close();
				});
			},
			onClose: function(dialog){
				jQuery.modal.close();
				//location.reload();
			}
		});
	});
	
	jQuery("#search").click(function(e){
		jQuery("#frmAllStaffApproval").submit();	
	});
	
	jQuery(".lockCDS").each(function(i){
		jQuery(this).click(function(){
			var status = jQuery(this).attr("status");
			var employeeId = jQuery(this).attr("employeeId");
			
			if (status == "lock"){
				jQuery(this).attr('src', '/ProGate-portlet/images/cds/unlock.png');	
				jQuery(this).attr("status","unlock");
			}
			if (status == "unlock"){
				jQuery(this).attr('src', '/ProGate-portlet/images/cds/lock.png');
				jQuery(this).attr("status","lock");
			}
			
			jQuery.ajax({
				type:'POST',
				url: hrefLockCDS,
				data: {
					'<%=RequestConst.HANDLE%>':'<%=RequestConst.HANDLE_LOCK_CDS%>',
					'<%=RequestConst.EMPLOYEE_ID%>':employeeId
				},						
				success: function(data){
					//alert("server said: "+ data);
				},
				error: function(){
					alert("Co loi xay ra khi dung ajax");
				}
			});
		});	  
	});
});
</script>

<div class='simpleModalPopup span-12' id='approvalCompetencyForm' style="display: none;">
	<div class='header'>
		<span>Phê duyệt nhanh</span>
	</div>
	<div class='message'>
		<div class="span-10 prepend-1 append-1 padding-top padding-bottom" id="warning">
			Bạn có chắc chắn muốn phê duyệt cho các nhân viên này theo điểm đánh giá của PM không?
		</div>
		<div class="span-4 padding-top padding-bottom"
			style="margin-left: 170px;">
			<input type="submit" value='<fmt:message key="button.yes" />'
				class="yes" /> <input type="submit"
				value='<fmt:message key="button.no" />' class="simplemodal-close no" />
		</div>
	</div>
</div>

<portlet:renderURL var="tab2">
	<portlet:param name="action" value="commonController" />
	<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_APPROVAL_2%>" />
	<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
</portlet:renderURL>
	
<div class="border-radius" style="min-height: 475px;">
<form id="frmAllStaffApproval" name="frmAllStaffApproval" action="${tab2}" method="post">
	<div class="" style="padding: 10px; background-color: rgb(219, 238, 244); -moz-border-radius-topleft: 5px; -moz-border-radius-topright: 5px; -moz-border-radius-bottomright: 5px; -moz-border-radius-bottomleft: 5px;">
	<%-- <form id="filterForm" method="post" action="${tab2}"> --%>
		<div class="span-9 padding-bottom">
			<label style="float: left; margin-right: 10px; width: 65px;">Đợt CDS</label>
			<select class="span-7 last" onchange="" id="periodId" name="<%=RequestConst.PERIOD_ID%>">
				<c:forEach items="${bean.periods}" var="period">
					<option <c:if test="${period.cdsEvaluationPeriodsId == bean.selectedPeriodId}">selected="selected"</c:if> value="${period.cdsEvaluationPeriodsId}">
						${period.name} - <fmt:formatDate pattern="MM/yyyy" value="${period.startDate}" /> đến <fmt:formatDate pattern="MM/yyyy" value="${period.endDate}" />
					</option>	
				</c:forEach>
			</select>
		</div>
		
		<div class="span-10 last padding-bottom">
			<label style="float: left; margin-left: 20px; width: 80px;">Trạng Thái</label>
			<select onchange="" class="span-7 last" name="<%=RequestConst.CDS_STATUS%>">
				<option value="3" <c:if test="${bean.selectedCdsStatus == 3}">selected="selected"</c:if>>Xem tất cả</option>
				<option value="0" <c:if test="${bean.selectedCdsStatus == 0}">selected="selected"</c:if>>Chưa phê duyệt</option>
				<option value="1" <c:if test="${bean.selectedCdsStatus == 1}">selected="selected"</c:if>>Đang phê duyệt</option>
				<option value="2" <c:if test="${bean.selectedCdsStatus == 2}">selected="selected"</c:if>>Đã phê duyệt</option>
			</select>
		</div>

		
		<div class="span-3" style="margin-top:0px">
			<a id="search" href="#">
				<img class="absmiddle" src="/ProGate-portlet/images/cds/search.png" height="25" width="25"><span style="color:#E46C0A">Tìm kiếm</span>
			</a>
		</div>
		
		<div class="span-9">
			<label style="float: left; margin-right: 10px; width: 65px;">Dự án</label>
			<select class="span-7 last" onchange="" id="periodId" name="<%=RequestConst.PROJECT_ID%>">
				<option value="0">Xem tất cả</option>
				<c:forEach items="${bean.orgs}" var="org">
					<option <c:if test="${org.orgId == bean.selectedProjectId}">selected="selected"</c:if> value="${org.orgId}">
						${org.name}
					</option>	
				</c:forEach>
			</select>
		</div>

		
		<div class="span-13 last right" style="height: 0px;">
			<a id="allStaffApprovalButton" href="#" style="float:right; margin-right: 10px; margin-top: 0px">
				<!-- <img class="absmiddle" src="/ProGate-portlet/images/cds/redPen.png" height="25" width="25" style="cursor:pointer"/> <span>Phê duyệt theo đánh giá của PM</span> -->
			</a> 
		</div>
	<!-- </form> -->
		<div class="clear"></div>

	</div>
	<c:if test="${bean.sizeOfEmployees > 0}">
	<div style="min-height:370px">
	<table>
		<thead>
			<tr>
				<th class="span-1">STT</th>
				<th class="span-1"><input type="checkbox" name="checkAll" id="checkAll" style="vertical-align: middle;"/></th>
				<th class="span-5">Tên Nhân Viên</th>
				<th class="span-2">Chức Vụ</th>

				<th class="span-2">Title</th>
				<th class="span-3">Dự Án</th>
				<th class="span-4">Tên PM</th>
				<th class="span-2">Trạng Thái Phê Duyệt</th>
				<th class="span-2">Khóa CDS</th>
			</tr>

		</thead>
		
		<tbody>
		<c:set var="numberOrder" value="1" />
		<c:forEach items="${bean.employees}" var="employee">
			<%-- <c:if test="${employee.ratingStatus != 0}"> --%>
			
			<portlet:renderURL var="tab1Page2">
				<portlet:param name="action" value="commonController" />
				<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_APPROVAL_1%>" />
				<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
				<portlet:param name="<%=RequestConst.TAB_PAGE%>" value="<%=RequestConst.TAB_APPROVAL_1_PAGE_2%>" />
				<portlet:param name="<%=RequestConst.TAB_PAGE_REGION%>" value="<%=RequestConst.TAB_APPROVAL_1_PAGE_2_REGION_1%>" />
				<portlet:param name="<%=RequestConst.EMPLOYEE_ID%>" value="${employee.userId}" />
				<portlet:param name="<%=RequestConst.PROJECT_ID%>" value="${employee.orgId}" />
				<portlet:param name="<%=RequestConst.PERIOD_ID%>" value="${employee.periodId}" />
			</portlet:renderURL>
			
			<tr>
				<td class="td-align-center">
					<c:out value="${numberOrder}"/>
				</td>
				<td class="td-align-center">
				<c:choose>
					<c:when test="${employee.ratingStatusBod == 2}">
						<input disabled="disabled" type="checkbox" name="checkList" value='${employee.userId}' style="vertical-align: middle;"/>
					</c:when>
					<c:otherwise>
						<input type="checkbox" name="checkList" value='${employee.userId}' style="vertical-align: middle;"/>
					</c:otherwise>
				</c:choose>
				</td>
				<c:set var="numberOrder" value="${numberOrder + 1}" />
				<td class="td-align-left"><a href="${tab1Page2}">${functions:getUserFullnameByUserId(employee.userId)}</a></td>
				<td class="td-align-left">${employee.position}</td>
				<td class="td-align-left">
					<c:choose>
						<c:when test="${empty employee.titleAbbreviation}">N/A</c:when>
						<c:otherwise>${employee.titleAbbreviation}</c:otherwise>
					</c:choose>
				</td>
				<td class="td-align-left">${employee.orgList}</td>
				<td class="td-align-left">${employee.pmList}</td>
				<td class="td-align-center">
				<c:choose>
					<c:when test="${employee.ratingStatusBod == 0}">
						<img class="absmiddle" title="Chưa phê duyệt" src="/ProGate-portlet/images/cds/check-gray.png" width="18px" height="18px" /> 
					</c:when>
					<c:when test="${employee.ratingStatusBod == 1}">
						<img class="absmiddle" title="Đang phê duyệt" src="/ProGate-portlet/images/cds/inprogress.png" width="18px" height="18px" /> 
					</c:when>
					<c:when test="${employee.ratingStatusBod == 2}">
						<img class="absmiddle" title="Đã phê duyệt" src="/ProGate-portlet/images/cds/check-green.png" width="18px" height="18px" /> 
					</c:when>
				</c:choose>
				</td>
				<td class="td-align-center">
				<c:choose>
					<c:when test="${employee.isLocked}"><img employeeId="${employee.userId}" class="lockCDS" status="lock" title="CDS đã khóa" src="/ProGate-portlet/images/cds/lock.png" height="25" width="25" style="cursor:pointer"></c:when>
					<c:otherwise><img class="lockCDS" employeeId="${employee.userId}" status="unlock" title="CDS đang mở" src="/ProGate-portlet/images/cds/unlock.png" height="25" width="25" style="cursor:pointer"></c:otherwise>
				</c:choose>
				</td>
			</tr>
			<%-- </c:if> --%>
		</c:forEach>							
		</tbody>
	</table>
	</div>
		<c:if test="${bean.sizeOfEmployees >= 10}">
		<div class="cds-paging">
			<c:set value="${bean.pagination}" var="paging"></c:set>
			<%@ include file="/html/portlet/common/pagination.jsp" %>
		</div>
		</c:if>
	</c:if>
	
	<c:if test="${bean.sizeOfEmployees == 0}">
		<table>
			<thead>
				<tr>
					<th class="span-1">STT</th>
					<th class="span-1"><input type="checkbox" name="checkAll" id="checkAll" style="vertical-align: middle;"/></th>
					<th class="span-5">Tên Nhân Viên</th>
					<th class="span-2">Chức Vụ</th>
	
					<th class="span-2">Title</th>
					<th class="span-3">Dự Án</th>
					<th class="span-4">Tên PM</th>
					<th class="span-2">Trạng Thái Phê Duyệt</th>
					<th class="span-2">Khóa CDS</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
		<div style="text-align: center; color:red; margin-top: 10px; margin-bottom: 10px">Không có dữ liệu</div>
	</c:if>
</form>
</div>

</c:otherwise>
</c:choose>