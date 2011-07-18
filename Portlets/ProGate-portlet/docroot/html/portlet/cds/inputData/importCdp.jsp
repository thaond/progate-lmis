<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<portlet:renderURL var="inputData">
	<portlet:param name="action" value="commonController" />
	<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
	<portlet:param name="<%=RequestConst.INPUT_DATA_PAGE %>" value="<%=RequestConst.INPUT_DATA_PAGE_1%>" />
	<portlet:param name="<%=RequestConst.PROJECT_ID%>" value="${bean.selectedProjectId}" />
</portlet:renderURL>

<div class="left padding-top padding-bottom" style="font-size: 1.1em; color: #E46C0A">
	<img class="absmiddle" src="/ProGate-portlet/images/cds/import_big.png"
		width="40px" height="40px" />
	<strong>Import CDP</strong>
</div>
<div class="right" style="padding-top:35px"><a href="<c:out value="${inputData}"/>"><img class="absmiddle" src="/ProGate-portlet/images/cds/back.png"/> Quay lại</a></div>
<div class="right" style="padding-top:35px; padding-right:15px;"><a href="#"><img class="absmiddle" src="/ProGate-portlet/images/cds/filemau.gif"/> Tải file mẫu</a></div>
<div class="clear"></div>

<form action="" name="frmUploadFile" method="post" enctype="multipart/form-data">
<div class=" border-radius">
	<div class="background-radius" style="margin: 2px 2px 10px; padding: 10px;">
		<label class="span-3 padding-bottom"><strong>Nhân viên:  </strong></label>
		<label class="span-8 padding-bottom">${bean.employeeName }</label>
		<label class="span-2 last padding-bottom"><strong>Dự án:  </strong></label>
		<label class="span-8 padding-bottom">${bean.projectOfEmployee }</label>
		<div class="clear"></div>	
		<label class="span-3 "><strong>Chức vụ:  </strong></label>
		<label class="span-8 ">${bean.employeePosition } </label>
		<div class="clear"></div>
	</div>
	<div class="clear"></div>
	<div>
		<label style="padding-left:10px">Chọn file CDP (</label> <label style="color:red;">*</label> <label>)</label>
		<input type="file" name="attachFile" id="attachFile" size="65px"/>
	</div>
	<div class="span-17" id="warning" style="color:red; padding-left:130px;">
	</div>
	<div class="span-21">
		<center style="padding:10px">
			<input type="submit" value='<fmt:message key="button.save" />' class="cds-btn-yes" /> 
			<input type="submit" value='<fmt:message key="button.cancel" />' class="cds-btn-no" />
		</center>
	</div>
	<div class="clear"></div>
</div>
</form>

<script type="text/javascript">
	jQuery(function(){
		jQuery(".cds-btn-no").click(function(e){
			var url = 	'<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>">
							<portlet:param name="action" value="commonController" />
							<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
							<portlet:param name="<%=RequestConst.INPUT_DATA_PAGE %>" value="<%=RequestConst.INPUT_DATA_PAGE_1%>" />
							<portlet:param name="<%=RequestConst.PROJECT_ID%>" value="${bean.selectedProjectId}" />
						</portlet:renderURL>';
			document.frmUploadFile.action=url;
			document.frmUploadFile.submit();
		});
	});
</script>