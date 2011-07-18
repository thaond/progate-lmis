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
	<strong>Import CDS</strong>
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
	<div style="text-align:center;">
		<div class="span-4">
			<label style="padding-left:10px">Chọn file CDS (</label> <label style="color:red;">*</label> <label>)</label>
		</div>
		<div class="span-17" style="text-align:left">
			<input type="file" name="attachFile" id="attachFile" size="65px"/>
			<div class="span-17" id="warning" style="color:red; padding-left:5px;"></div>
			<c:choose>
				<c:when test="${bean.fileSizeTooBig == 'fileSizeTooBig'}">
					<div class="span-17" id="warning_size" style="color:red; padding-left:5px;">
						File này có dung lượng quá lớn
					</div>
				</c:when>
				<c:when test="${bean.uploadError == 'uploadError'}">
					<div class="span-17" id="warning_size" style="color:red; padding-left:5px;">
						Có lỗi xảy ra khi upload file
					</div>
				</c:when>
				<c:otherwise>
					<div class="span-17" id="warning_size" style="padding-left:5px;">
						<img width="15px" height="15px" src="/ProGate-portlet/images/cds/information.png" class="absmiddle">
						Bạn có thể tải lên các tập tin CSV với dung lượng dưới 2 MB
					</div>
				</c:otherwise>
			</c:choose>
			
		</div>
	</div>
	<div class="span-23" style="text-align:center;">
		<center style="padding:10px">
			<input type="submit" value='<fmt:message key="button.save" />' class="cds-btn-yes" /> 
			<input type="submit" value='<fmt:message key="button.cancel" />' class="cds-btn-no" />
		</center>
	</div>
	<div class="clear"></div>
</div>
</form>

<script type="text/javascript">
	
	function checkFile(){
		var File = document.getElementById('attachFile').value;
		if(File==null || File==''){
			return false;
		} else{
			return true;
		}
	}
	
	function checkFileExt(){
		var FileExt = document.getElementById('attachFile').value.lastIndexOf(".csv");
		if(FileExt == -1) {
			return false;
		} else{
			return true;
		}
	}
	
	jQuery(function(){
		jQuery(".cds-btn-yes").click(function(e){
			e.preventDefault();
			jQuery("#warning_size").hide();
			if(checkFile() == false){
				jQuery("#warning").html('Vui lòng chọn file');
			} else{
				jQuery("#warning").html('');
				if (checkFileExt() == false){
					jQuery("#warning").html('File được chọn không đúng định dạng');
				} else {
					jQuery("#warning").html('');
				}
			}
			if(checkFileExt()){
				var url = 	'<portlet:actionURL  windowState="<%=WindowState.NORMAL.toString() %>">
								<portlet:param name="action" value="commonController" />
								<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
								<portlet:param name="<%=RequestConst.INPUT_DATA_PAGE %>" value="<%=RequestConst.INPUT_DATA_PAGE_2%>" />
								<portlet:param name="<%=RequestConst.PROJECT_ID%>" value="${bean.selectedProjectId}" />
								<portlet:param name="<%=RequestConst.EMPLOYEE_ID%>" value="${bean.employeeId}" />
								<portlet:param name="<%=RequestConst.EMPLOYEE_NAME%>" value="${bean.employeeName}" />
								<portlet:param name="<%=RequestConst.EMPLOYEE_POSITION%>" value="${bean.employeePosition}" />
								<portlet:param name="<%=RequestConst.EMPLOYEE_PROJECT%>" value="${bean.projectOfEmployee}" />
							</portlet:actionURL>';
				document.frmUploadFile.action=url;
				document.frmUploadFile.enctype="multipart/form-data";
				document.frmUploadFile.submit();
			}
		});
		
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