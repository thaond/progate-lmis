<%@ page import="com.larion.progate.lmis.constants.LmisRequest" %>
<%@ include file="../../../../common/init.jsp" %>
<%@ include file="../../../../lmis/init-ttn.jsp" %>
<jsp:include page="../../../dialog/dialog-configPermissionOk.jsp" />
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<div class="cds-container">
<div class="border-radius span-23">
	<div class="span-22 prepend-1 last">
		<table class="span-16 prepend-top" style="margin-top: 15px">
			<tr>
				<td width="55px"><fmt:message key="lmis.attendanceInfo.part" /></td>
				<td width="400px">
					<form action="" method="post">
						<select name="org" onchange="this.form.submit()" style="width: 360px">
							<c:forEach items="${bean.listOrg}" var="org" varStatus="count">
								<c:choose>
									<c:when test="${org.orgId == bean.org}">
										<option  value="${org.orgId}" selected="selected">${org.name} </option>
									</c:when>
									<c:otherwise>
										<option  value="${org.orgId}">${org.name} </option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</form>
				</td>
				<td width="95px"><fmt:message key="lmis.configPermission.staffName" /></td>
				<td><input id="search_txt" type="text" name="txtsearch" value="<fmt:message key='lmis.configPermission.inputStaffName' />"  style="width: 230px; height: 20px;"/></td>
				<td style="color: orange"><a href="#"><img  class="absmiddle" src="/ProGate-portlet/images/lmis/Search.png" width="25px" height="25px" /></a><fmt:message key="lmis.common.search"/></td>
			</tr>
		</table>
	</div>
	<form action="" name="listNV" method="post">
		<div style="margin-left:20px" class="around-table1 span-9 prepend-top">
			<div style="padding: 1px;">
			<table class="table-content">
				<thead class="tbl-header" style="display:block; width: 99.9%; margin-left: -1px;">
					<tr class="header_table" >
						<th scope="col" height="29px" width="30px" class="align-center border-style"><fmt:message key="lmis.common.number" /></th>
						<th scope="col" height="29px" width="380px" class="align-center border-style"><fmt:message key="lmis.config.code.staffname" /></th>
<%-- 						<th scope="col" height="29px" width="90px" class="align-center border-style" ><fmt:message key="lmis.configPermission.position" /></th> --%>
					</tr>
				</thead>
				<tbody class="display_block" id="listUserOfOrg">
				<c:forEach items="${bean.listUserId}" var="uId" varStatus="count">
				 <c:choose>
				 	<c:when test="${count.count%2 !=0}">
				 		<tr class="row-selected oddrow <c:if test="${uId.userId == bean.userId}">focus</c:if>">
				 	</c:when>
				 	<c:otherwise>
				 		<tr class="row-selected evenrow <c:if test="${uId.userId == bean.userId}">focus</c:if>">
				 	</c:otherwise>
				 </c:choose>
						<td width="30px" style="text-align: center">${count.count}<input type="hidden" class="userId-selected" value="${uId.userId}" /><input type="hidden" class="org-selected" value="${bean.org}" /></td>
						<td width="380px" style="text-indent: 10px"> ${functions:getUserNameByUserId(uId.userId)}<br /></td>
<%-- 						<td width="90px">${uId.position}</td> --%>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			</div>
		</div>
	</form>
	<div class="around-table1 span-8 prepend-top" style="margin-left:40px">
			<table class="table-content">
				<thead class="tbl-header" style="display:block">
					<tr class="header_table">
<!--						<th width="20px" scope="col" height='30px'><input id="checkAll" name="checkAll" type="checkbox" /> </th>-->
						<th width="420px" scope="col" height='30px' style="border: none"><fmt:message key="lmis.configPermission.listOfFunction" /></th>
						
					</tr>
				</thead>
				<tbody class="display_block" id="listPermit">
				  <c:forEach items="${bean.fullPer}" var="fp" varStatus="countStatus">
						<c:set var="name" value="checkList" scope="page"></c:set>
						<c:if test="${fp.proGatePermissionsId}">
							<c:set var="disableIt" value="disabled" scope="page"></c:set>
						</c:if>
					<c:forEach items="${bean.userPer}" var="up" varStatus="count">
						<c:if test="${ fp.description == up.description }">
							<c:if test="${ up.roleId != -1 }">
							<c:set var="name" value="" scope="page"></c:set>
							</c:if>
						</c:if>
					</c:forEach>
					<c:choose>
						<c:when test="${countStatus.count %2 !=0}">
							<tr class="oddrow">
						</c:when>
						<c:otherwise>
							<tr class="evenrow">
						</c:otherwise>
					</c:choose>
						<td style="width:20px; text-align: center">
							<input id="${fp.proGatePermissionsId}" style="margin-left:8px" type="checkbox" name="<c:out value="${pageScope.name}"></c:out>" value="${fp.proGatePermissionsId}" <c:out value="${pageScope.disableIt}"/> />
						</td>
						<td width="400px" style="padding-left:10px">
							<label for="${fp.proGatePermissionsId}">${fp.description}</label><br />
						</td>
				</tr>
			  </c:forEach>
			</tbody>
			</table>

	</div>
</div>
	<div style="padding-top: 10px; padding-left: 50px;" class="span-21">
			<c:if test="${bean.datasize == 0}"><fmt:message key="lmis.configPermission.noDatabase"/></c:if>
	</div>
	<div align="center" style="padding-top: 0px; padding-left:25px; padding-bottom: 2px; clear: both">
		<input class="button-enable" id="savePermission" type="button" value='<fmt:message key="button.save" />' />
		<input	class="default-button-enable" id="cancelPermission" type="button" value='<fmt:message key="lmis.common.default" />' />
	</div>
</div>

<script type="text/javascript">
jQuery(document).ready(function() {
	jQuery('input[type="checkbox"]:checked').each(function(){
	this.checked = false;
	});
	<c:forEach items="${bean.userPer}" var="up">
		var perId = '${up.permissionId}';
		var perRole = '${up.roleId}';
		jQuery("input[@value='"+perId+"'][type='checkbox']").each(function(){
			this.checked = true;
			if(perRole != -1 ){
				this.disabled = true;
			}
		});
	</c:forEach>
});
jQuery(document).ready(function(){
	jQuery("#checkAll").click(function(){
		var checked_status =this.checked;
		jQuery("input[name='checkList']").each(function(){
			this.checked =checked_status;
		});
	});
});

jQuery(function(){
		jQuery(".table-content tr").not(".header_table").hover(
			function(){
				jQuery(this).addClass("highlight");
			},
			function(){
				jQuery(this).removeClass("highlight");
			}
		)
	}
)

jQuery(function() {
	jQuery(".row-selected").click(function(e){
		//e.preventDefault();
		var data1 = jQuery(this).find(".userId-selected");
		jQuery(".userId-selected").removeAttr("name");
		data1.attr("name","userId");
		var data2 = jQuery(this).find(".org-selected");
		jQuery(".org-selected").removeAttr("name");
		data2.attr("name","org");
		var href='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
			<portlet:param name="action" value="commonController" />
			<portlet:param name="<%=LmisRequest.TAB_ACTION%>" value="${bean.activedTab}" />
			<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
		</portlet:renderURL>';
		document.listNV.action=href;
		document.listNV.submit();
	});
	jQuery('#cancelPermission').click(function(e){
		var href='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
			<portlet:param name="action" value="commonController" />
			<portlet:param name="userId" value="${bean.userId}" />
			<portlet:param name="org" value="${bean.org}" />
			<portlet:param name="<%=LmisRequest.TAB_ACTION%>" value="${bean.activedTab}" />
			<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
		</portlet:renderURL>';
		document.listNV.action=href;
		document.listNV.submit();
	});
});

jQuery('#savePermission').click(function(e){
	e.preventDefault();
	var arrayId = new Array();
	jQuery("input[@name=checkList]:checked").each(function(i) {
		arrayId.push(jQuery(this).val());
	});
	var href = '<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
		<portlet:param name="action" value="commonController" />
		<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
	</portlet:actionURL>';
	jQuery.ajax({
		type:'POST',
		url: href,
		data: {
			"org":${bean.org},
			"userId":${bean.userId},
			"listPerId":arrayId
		},
		success: function(data){
			var href='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
				<portlet:param name="action" value="commonController" />
				<portlet:param name="userId" value="${bean.userId}" />
				<portlet:param name="org" value="${bean.org}" />
				<portlet:param name="<%=LmisRequest.TAB_ACTION%>" value="${bean.activedTab}" />
				<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
			</portlet:renderURL>';
			jQuery(".successful").css("display", "block");
		    jQuery(".successful").data('url',href).data('close',close).dialog("open");
		},
		error: function(){
			alert("Có lỗi xảy ra khi lưu cấu hình phân quyền");
		}
	});
});

jQuery("input[@name=txtsearch]").focus(function(){
    if(this.value == "Nhập tên nhân viên"){
    	this.value = "";
    }
});

jQuery("input[@name=txtsearch]").blur(function(){
	if(this.value == ""){
    	this.value = "Nhập tên nhân viên";
    }
});

jQuery('#listNV,#listPermit').removeAttr('style');
if(jQuery('#listNV').height() > 315) {
	jQuery('#listNV').css("height","315px");
}
if(jQuery('#listPermit').height() > 315) {
	jQuery('#listPermit').css("height","315px");
}
</script>