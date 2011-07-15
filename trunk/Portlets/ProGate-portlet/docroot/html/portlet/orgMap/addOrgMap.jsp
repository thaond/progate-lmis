
<%@page import="com.larion.progate.common.constants.URLParameter_RS"%>
<%@ page import="com.larion.progate.orgMap.constants.OrgMap_Const"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/html/portlet/orgMap/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
 	int addSuccess = 0;
	if(request.getAttribute(OrgMap_Const.ADDED_SUCCESS) != null){
		addSuccess = (Integer)request.getAttribute(OrgMap_Const.ADDED_SUCCESS);
	}
	
	int orgId = Integer.parseInt(request.getParameter(URLParameter_RS.ORG_ID));
	int viewMode =Integer.parseInt(request.getParameter(URLParameter_RS.VIEW_MODE));
	String title = "";
	String imageMap = request.getContextPath()+ "/images/new-manage-org/small_noImage.gif";
	String description = "";
	String currentUrl = "";
	
	
	if(request.getParameter(OrgMap_Const.TITLE) != null){
		title = request.getParameter(OrgMap_Const.TITLE);
	}
	if(request.getParameter(OrgMap_Const.IMAGE_MAP) != null){
		imageMap = request.getParameter(OrgMap_Const.IMAGE_MAP).toString();
	}
	if(request.getParameter(OrgMap_Const.DESCRIPTION) != null){
		description = request.getParameter(OrgMap_Const.DESCRIPTION);
	}
	if(request.getParameter(OrgMap_Const.CURRENT_URL) != null){
		currentUrl = request.getParameter(OrgMap_Const.CURRENT_URL);
	}
	
%>

<liferay-theme:defineObjects />

<script type="text/javascript">
	
	function isValidImageType(value)
	{
	    return /\.(gif|jpeg|jpg|png)$/i.test (value);
	}
	jQuery(document).ready(function(){
		jQuery('#frmAdd input[type=file]').change(function(el) {
		    var file_name = jQuery(this).val();
		    if(!isValidImageType(file_name)){            
		    	jQuery("#errOrgName").css("display","block");
				jQuery("#errOrgName").html("File này có định dạng không được hỗ trợ.");
		        return;
		    }else{
		    	jQuery("#errOrgName").css("display","none");
		    }
		});
	});
	function initEditorDescription() {
		var out =jQuery('#introDis').html();
		//out = out.replace('<','&#x200B;<');
		window.<%= OrgMap_Const.DESCRIPTION %>.setHTML(out);
		return out;
	}
	
	

	function submitForm() {
		var descriptionHTML = window.<%= OrgMap_Const.DESCRIPTION %>.getHTML();
		var title = document.frmAdd.<%= OrgMap_Const.TITLE %>.value ;
		var imageMap = document.frmAdd.<%= OrgMap_Const.IMAGE_MAP %>.value ;
	    if((title == '') || (imageMap == '') || (descriptionHTML == '')){
	    	jQuery("#err").text('Bạn chưa nhập đầy đủ thông tin');
	    	jQuery("#mesErrorShow").css("display","block");
	    	jQuery("#mesError").css("display","none");
	    	jQuery("#mesSuccess").css("display","none");
	    }else{
	    	if(!isValidImageType(imageMap)){
	    		jQuery("#errOrgName").css("display","block");
				jQuery("#errOrgName").html("File này có định dạng không được hỗ trợ.");
	    	}else{
		    	jQuery("#err").text('');
		    	jQuery("#mesErrorShow").css("display","none");
		    	document.frmAdd.<%= OrgMap_Const.DESCRIPTION %>.value = descriptionHTML;
		    	document.frmAdd.submit();
	    	}
	    }
	}
	
	function backButton(){
		var url = '<%= currentUrl %>';
		window.parent.location = url ;
	}
	
	function closeMes(){
		jQuery("#mesSuccess").css("display","none");
		jQuery("#mesError").css("display","none");
		jQuery("#mesErrorShow").css("display","none");
	}

</script> 

<form name="frmAdd" method="post" onsubmit="Javascript: return false;" action="<portlet:actionURL>
			<portlet:param name='struts_action' value='/orgMap/add_action'></portlet:param>
			<portlet:param name='<%=URLParameter_RS.ORG_ID  %>' value='<%= Integer.toString(orgId) %>'></portlet:param>
			<portlet:param name='<%=URLParameter_RS.VIEW_MODE  %>' value='<%= Integer.toString(viewMode) %>'></portlet:param>
</portlet:actionURL>" enctype="multipart/form-data" id="frmAdd">
	<input type="hidden" name="<%= URLParameter_RS.ORG_ID %>" value="<%= orgId%>">
	<input type="hidden" name="<%= OrgMap_Const.DESCRIPTION %>" value="">
	<input type="hidden" name="<%= OrgMap_Const.CURRENT_URL %>" value="<%= currentUrl %>">
	
	<div id="introDis" style="display:none">
		<%= description %>
	</div>
	
	<div class="tq-layout">
		<div class="tq-add-header">
			<span class="tq-content-header">Thêm Sơ Đồ Tổ Chức</span>
		</div>
		<div class="tq-body">
			<div class="tq-tr-header" style="display: none;">
				<div style="float: right; padding-top: 11x;"><span style="float: left;padding-top: 10px" class="tq-body-content">Xem trước</span></div>
				<div class="tq-img-td" style="float: right;"><img alt="" src="/ProGate-portlet/images/preview.png" width="30px" height="25px"/></div>
			</div>
			<br>
			<br>
			<div style="padding-left:20px" class="tq-mes">(*) Thông tin bắt buộc nhập</div>
			<br>
			<% if(addSuccess == 1){ %>
				<div class="tq-body-mes-success" id="mesSuccess">
					<div class="tq-img-td" style="float: left;"><img alt="" src="/ProGate-portlet/images/success.png" width="20px" height="20px"></div>
					<div style="float: left; padding-top: 8px; padding-left: 5px;">
						<span class="tq-body-content-mes">Bạn đã thêm sơ đồ tổ chức thành công </span>
					</div>
					<div style="float:right; padding-right:20px;">
						<img alt="" src="/ProGate-portlet/images/black_delete.png" width="28px" height="28px" onclick="closeMes();">
					</div>
				</div>
			<%} %>
			<% if(addSuccess == 2){ %>
				<div class="tq-body-mes-error" id="mesError">
					<div class="tq-img-td" style="float: left;"><img alt="" src="/ProGate-portlet/images/error.png" width="20px" height="20px"></div>
					<div style="float: left; padding-top: 8px; padding-left: 5px;">
						<span class="tq-body-content-mes">Đã có lỗi xảy ra trong quá trình thêm sơ đồ tổ chức </span>
					</div>
					<div style="float:right; padding-right:20px;">
						<img alt="" src="/ProGate-portlet/images/black_delete.png" width="28px" height="28px" onclick="closeMes();">
					</div>
				</div>
			<%} %>
			<div class="tq-body-mes-error" id="mesErrorShow" style="display: none;">
					<div class="tq-img-td" style="float: left;"><img alt="" src="/ProGate-portlet/images/error.png" width="20px" height="20px"></div>
					<div style="float: left; padding-top: 8px; padding-left: 5px;">
						<span class="tq-body-content-mes">Đã có lỗi xảy ra trong quá trình thêm sơ đồ tổ chức </span>
					</div>
					<div style="float:right; padding-right:20px;">
						<img alt="" src="/ProGate-portlet/images/black_delete.png" width="28px" height="28px" onclick="closeMes();">
					</div>
			</div>
			<div class="tq-td-img">
					<div class="tq-mes" id="err" style="padding-left: 22px"></div>
			</div>
			<div class="tq-body">
				<div class="tq-td-content"><span class="tq-body-content">Tiêu Đề</span></div>
				<div class="tq-td">
					<input type="text" name="<%= OrgMap_Const.TITLE %>" value="<%= title %>" size="83">
				</div>
				<div class="tq-td-img">
					<div class="tq-img-td" style="float: left;"><img alt="" src="/ProGate-portlet/images/information.png" width="20px" height="20px"></div>
					<div style="float: left; padding-top: 8px; padding-left: 5px;">
						<span class="tq-body-content">
							Tiêu đề sẽ được canh giữa
						</span>
					</div>
				</div>
			</div>
			<div class="tq-body">
				<div class="tq-td-content"><span class="tq-body-content">Hình Ảnh (<span class="tq-mes">*</span>)</span></div>
				<div class="orgMap-img">
					<img id="image-preview" class="img-subject fl" alt="" src="<%= imageMap %>" onLoad='scaleImg(this, 145, 100)' style="display: none;">
				</div>
				<div class="tq-td-right">
					<input type="file" name="<%= OrgMap_Const.IMAGE_MAP %>" size="56"/>
					<div class="tq-mes" id="errOrgName" style="display: none;"></div>
					<div>
						<div class="tq-img-td" style="float: left;"><img alt="" src="/ProGate-portlet/images/information.png" width="20px" height="20px"></div>
						<div style=" padding-top: 8px; padding-left: 25px; padding-right: 25px">
							<span class="tq-body-content">
								Bạn có thể tải các tập tin JPG, GIF hoặc PNG với dung lượng dưới 1KB và kích thước tối đa 500 x 375 px.
								Nếu bạn tải ảnh có kích thước hơn 500 x 375 px thì ảnh sẽ được thay đổi kích thước một cách tự động
							</span>
						</div>
					</div>
				</div>
			</div>
			<div class="tq-body">
				<div class="tq-td-content"><span class="tq-body-content">Mô Tả</span></div>
				<div class="tq-td">
					<liferay-ui:input-editor
							name='<%= OrgMap_Const.DESCRIPTION %>'
							editorImpl="editor.wysiwyg.portal-web.docroot.html.portlet.progate.edit.view.jsp"
							toolbarSet="liferay-article"
							initMethod='initEditorDescription'
							onChangeMethod='editorContentChanged'
							height="300"
							width="770"
					/>
					
				</div>
			</div>
			<div class="tq-body">
				<div class="tq-td-img-button">
					<div style="float:left">
						<button style="height: 24px; width: 70px;" class="bt-form" onclick="submitForm();"><span class="tq-body-content">Lưu</span></button>
					</div>
					<div style="float:left; padding-left: 20px">	
						<button style="height: 24px; width: 70px;" class="bt-form" onclick="backButton();"><span class="tq-body-content">Hủy</span></button>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>