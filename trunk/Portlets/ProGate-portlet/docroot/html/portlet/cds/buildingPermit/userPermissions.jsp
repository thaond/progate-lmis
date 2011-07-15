<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<c:choose>
<c:when test="${bean.hasPermissionOnTab2 == false}">
		<div class="border-radius" style="min-height: 495px; margin-bottom: 20px;">
			<div class="cds-notification">Rất tiếc! Bạn không có quyền truy cập vào liên kết này.<br/>
				Vui lòng nhấp <a href="#">vào đây</a> để trở lại trang chủ.
			</div>
		</div>	
</c:when>
<c:otherwise>
<div class="cds-container">
<div class="border-radius span-23" style="padding-bottom:10px; margin-bottom: 20px;">
	<div class="span-22 prepend-1 last">
		<table class="span-20 prepend-top">
			<tr>
				<td>Tên nhân viên</td>
				<td><input id="search_txt" type="text" name="txtsearch" value="Tìm kiếm..." /></td>
				<td>Dự án</td>
				<td style="padding-right:0px">
					<portlet:renderURL var="tab2">
						<portlet:param name="action" value="commonController" />
						<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_BUILDING_PERMIT_2%>" />
						<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
					</portlet:renderURL>
					<form action='<c:out value="${tab2}"/>' method="post">
						<select name="org" onchange="this.form.submit()" >
							<c:forEach items="${bean.listOrg}" var="org" varStatus="count">
								<option <c:if test="${org.orgId == bean.org}">selected</c:if> value="${org.orgId}" >${org.name}</option>
							</c:forEach>
						</select>
					</form>
				</td>
				<td style="color: orange; padding-left:0px"><a href="#"><img  class="absmiddle" src="/ProGate-portlet/images/cds/search.png" width="25px" height="25px" /></a>Tìm kiếm</td>
			</tr>
		</table>
	</div>
	
	<form action='' name="listNV" method="post">
		<div style="margin-left:40px" class="scroll border-radius span-9 prepend-top">
			<div style="padding: 1px;">
			<table class="cds-table">
				<thead>
					<tr style="color:white; background: #30A1BE;">
						<th>STT</th><th>Tên Nhân Viên</th><th>Chức Vụ</th>
					</tr>
				</thead>
				<tbody id="listNV" class="scroll-y" style="height:315px">
					<c:forEach items="${bean.listUserId}" var="uId" varStatus="count">
					
					<tr class="row-selected <c:if test="${uId.userId == bean.userId}">focus</c:if>" style="cursor: pointer;">
						<td class="td-align-center">${count.count}<input type="hidden" class="userId-selected" value="${uId.userId}"/><input type="hidden" class="org-selected" value="${bean.org}"/></td><td> ${functions:getUserFullnameByUserId(uId.userId)}<br /></td><td>${uId.position}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			</div>
		</div>
	</form>
	<div class="scroll border-radius span-10 prepend-top" style="margin-left:80px">
		<div style="padding: 1px;">
			<table>
				<thead>
					<tr style="color:white; background: #30A1BE;">
							<th colspan="2" style="text-align: center;">Danh Sách Chức Năng</th>
					</tr>
				</thead>
				<tbody id="listPermit" class="scroll-y" style="height:315px">
				<c:forEach items="${bean.fullPer}" var="fp" varStatus="count">
				<c:set var="name" value="checkList" scope="page"></c:set>
				<c:forEach items="${bean.userPer}" var="up" varStatus="count">
					<c:if test="${ fp.description == up.description }">
						<c:if test="${ up.roleId != -1 }">
						<c:set var="name" value="" scope="page"></c:set>
						</c:if>
					</c:if>
				</c:forEach>
				<tr>
					<td style="width:15px">
						<input style="margin-left:8px" type="checkbox" name="<c:out value="${pageScope.name}"></c:out>" value="${fp.proGatePermissionsId}"/>
					</td>
					<td style="padding-left:10px">
						${fp.description}<br />
					</td>
				</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		
	</div>
	<div>
		<div style="padding-top: 10px; padding-left: 50px;" class="span-21">
			<c:if test="${bean.datasize == 0}">Hiện tại không có dữ liệu</c:if>
		</div>
		<div class="span-6 prepend-9" style="padding-top:10px">
			<input type="submit" value='<fmt:message key="button.save" />' class="cds-btn-yes" /> 
			<input type="submit" value='<fmt:message key="button.default" />' class="cds-btn-no" />
		</div>
	</div>
	
</div>
</div>
</c:otherwise>
</c:choose>

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
		if(perRole != -1){
			this.disabled = true;
		}
	});
	</c:forEach>
});

jQuery(
	function(){
		jQuery(".cds-table tr").hover(
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
			<portlet:param name="<%=RequestConst.TAB%>" value="${bean.activedTab}" />
			<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
		</portlet:renderURL>';
		document.listNV.action=href;
		document.listNV.submit();
	});
	jQuery('.cds-btn-no').click(function(e){
		var href='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
			<portlet:param name="action" value="commonController" />
			<portlet:param name="userId" value="${bean.userId}" />
			<portlet:param name="org" value="${bean.org}" />
			<portlet:param name="<%=RequestConst.TAB%>" value="${bean.activedTab}" />
			<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
		</portlet:renderURL>';
		document.listNV.action=href;
		document.listNV.submit();
	});
});

jQuery('.cds-btn-yes').click(function(e){
	e.preventDefault();
	var arrayId = new Array();
	jQuery("input[@name=checkList]:checked").each(function(i) {
		arrayId.push(jQuery(this).val());
	});
	var href = '<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
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
				<portlet:param name="<%=RequestConst.TAB%>" value="${bean.activedTab}" />
				<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
			</portlet:renderURL>';
			document.listNV.action=href;
			document.listNV.submit();
		},
		error: function(){
			alert("Co loi xay ra khi dung ajax");
		}
	});
});

jQuery("input[@name=txtsearch]").focus(function(){
    if(this.value == "Tìm kiếm..."){
    	this.value = "";
    }
});

jQuery("input[@name=txtsearch]").blur(function(){
	if(this.value == ""){
    	this.value = "Tìm kiếm...";
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
