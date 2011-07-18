<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.larion.progate.common.constants.URLParameter_RS"%>
<%@page import="com.larion.progate.video.constants.Video_Const"%>
<%@ include file="/html/portlet/video/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%
 	int addSuccess = 0;
	//int deleteSuccess = 0;
	String videoURL = "";
	String currentUrl = "";
	if(request.getParameter(Video_Const.ADDED_SUCCESS) != null){
		addSuccess = Integer.parseInt(request.getParameter(Video_Const.ADDED_SUCCESS));
	}
	//if(request.getAttribute(Video_Const.DELETE_SUCCESS) != null){
	//	deleteSuccess = (Integer)request.getAttribute(Video_Const.DELETE_SUCCESS);
	//}
	
	int orgId = Integer.parseInt(request.getParameter(URLParameter_RS.ORG_ID));
	if(ParamUtil.getString(request,Video_Const.VIDEO_URL) != null){
		videoURL = ParamUtil.getString(request,Video_Const.VIDEO_URL);
	}
	if(ParamUtil.getString(request,Video_Const.CURRENT_URL) != null){
		currentUrl = ParamUtil.getString(request,Video_Const.CURRENT_URL);
	}
	
%>

<script type="text/javascript">

	function validateURL(){
		var url = jQuery('#url').val();
		if( url == ""){
			jQuery("#err2").text('Bạn chưa nhập mã nhúng');
			jQuery("#mesErrorShow").css("display","block");
			jQuery("#mesSuccess").css("display","none");
			jQuery("#mesError").css("display","none");
			jQuery("#mesSuccessDel").css("display","none");
			return false;
		}
		if( url != ""){
			jQuery("#err2").text('');
			jQuery("#mesErrorShow").css("display","none");
		}
		return true;
	}
	
	
	function submitForm(){
		if(validateURL()){
			document.frmAdd.submit();
		}
	}
	
	function deleteVideo(){
		var orgId = <%= orgId %> ;
		document.hidenDelForm.submit();
		
	}
	
	function closeMes(){
		jQuery("#mesSuccess").css("display","none");
		jQuery("#mesErrorShow").css("display","none");
		jQuery("#mesError").css("display","none");
		jQuery("#mesSuccessDel").css("display","none");
	}
	
	
	jQuery(function(){
		// Show help password
		var close = function() {
			jQuery("#deletePopup").dialog("close");
	    }
		var submit = function(){
			deleteVideo();
			jQuery("#deletePopup").dialog("close");
		}
	    var dialogOpts = {
	    	title:'Video Giới Thiệu',
	    	autoOpen: false,
		    modal: true,
		    buttons: {	'  Có  ': submit,	        
		        ' Không ': close
		    },
		    resizable: false,
		    width: 450,
		    height: 150
	    };
	    
	    jQuery("#deletePopup").dialog(dialogOpts);
	    jQuery("#popup").click(function(){
	    	jQuery("#deletePopup").css("visibility","visible");
	    	jQuery("#deletePopup").dialog("open");
	    });	

		});   
	
		function backButton(){
			var url = '<%= currentUrl %>';
			window.parent.location = url ;
		}
	
</script>




<form name="frmAdd" method="post" onsubmit="Javascript: return false;" action="<portlet:actionURL><portlet:param name='struts_action' value='/video/add_video'></portlet:param></portlet:actionURL>">
	<input type="hidden" name="<%= URLParameter_RS.ORG_ID %>" value="<%= orgId %>">
	<input type="hidden" name="<%= Video_Const.CURRENT_URL %>" value="<%= currentUrl %>">
	<div class="video-layout">
		<div class="video-add-header">
			<span class="content-header">Thêm Video Giới Thiệu</span>
		</div>
		<div class="video-body">
			<div class="tr-header">
<!-- 				<div style="float: right; padding-top: 11x;"><span style="float: left;padding-top: 10px" class="body-content">Xem trước</span></div> -->
<!-- 				<div class="img-td" style="float: right;"><img alt="" src="/ProGate-portlet/images/preview.png" width="30px" height="25px"></div> -->
			<% if(addSuccess == 1){ %>
				<div class="img-td" style="float: right;padding-top: 8px; padding-right: 5px"><span> | </span></div>
				<div class="img-td" style="float: right;padding-top: 10px; padding-right: 9px"><span> Xoá </span></div>
				<div class="img-td" style="float: right;padding-right: 2px;"><img alt="" src="/ProGate-portlet/images/error.png" width="23px" height="23px" id="popup" style="vertical-align: middle; margin-left: 3px"/>
				<%@include file="deletePopup.jsp"%>
			<%} %>
			</div>
		</div>
			<% if(addSuccess == 1){ %>
				<div class="video-body-mes-success" id="mesSuccess">
					<div class="img-td" style="float: left;"><img alt="" src="/ProGate-portlet/images/success.png" width="20px" height="20px"></div>
					<div style="float: left; padding-top: 8px; padding-left: 5px;">
						<span class="tq-body-content-mes">Bạn đã thêm video giới thiệu thành công </span>
					</div>
					<div style="float:right; padding-right:20px;">
						<img alt="" src="/ProGate-portlet/images/black_delete.png" width="28px" height="28px" onclick="closeMes();">
					</div>
				</div>
			<%} %>
			<% if(addSuccess == 2){ %>
				<div class="video-body-mes-error" id="mesError">
					<div class="img-td" style="float: left;"><img alt="" src="/ProGate-portlet/images/error.png" width="20px" height="20px"></div>
					<div style="float: left; padding-top: 8px; padding-left: 5px;">
						<span class="tq-body-content-mes">Đã có lỗi xảy ra trong quá trình lưu video giới thiệu </span>
					</div>
					<div style="float:right; padding-right:20px;">
						<img alt="" src="/ProGate-portlet/images/black_delete.png" width="28px" height="28px" onclick="closeMes();">
					</div>
				</div>
			<%} %>
			<% if(addSuccess == 3){ %>
				<div class="video-body-mes-success" id="mesSuccessDel">
					<div class="img-td" style="float: left;"><img alt="" src="/ProGate-portlet/images/success.png" width="20px" height="20px"></div>
					<div style="float: left; padding-top: 8px; padding-left: 5px;">
						<span class="tq-body-content-mes">Bạn đã xoá video giới thiệu thành công </span>
					</div>
					<div style="float:right; padding-right:20px;">
						<img alt="" src="/ProGate-portlet/images/black_delete.png" width="28px" height="28px" onclick="closeMes();">
					</div>
				</div>
			<%} %>
			<div class="video-body-mes-error" id="mesErrorShow" style="display: none;">
					<div class="img-td" style="float: left;"><img alt="" src="/ProGate-portlet/images/error.png" width="20px" height="20px"></div>
					<div style="float: left; padding-top: 8px; padding-left: 5px;">
						<span class="tq-body-content-mes">Đã có lỗi xảy ra trong quá trình lưu video giới thiệu </span>
					</div>
					<div style="float:right; padding-right:20px;">
						<img alt="" src="/ProGate-portlet/images/black_delete.png" width="28px" height="28px" onclick="closeMes();">
					</div>
			</div>
			<div class="video-body">
				<div class="td-content"><span class="body-content">Mã nhúng (<span class="body-header">*</span>)</span></div>
				<div class="video-td">
					<textarea rows="12" cols="94" name="<%= Video_Const.VIDEO_URL %>" id="url" onblur="validateURL()"><%= videoURL %></textarea>
					<div class="video-mes" id="err2"></div>
				</div>
			</div>
			<div class="video-body">
				<div class="video-td-img">
					<div class="img-td" style="float: left;"><img alt="" src="/ProGate-portlet/images/information.png" width="20px" height="20px"></div>
					<div style="float: left; padding-top: 8px; padding-left: 5px;">
						<span class="body-content">
							Chúng tôi chỉ hỗ trợ hiển thị video của bạn ở <span style="color: #30A1BE; font-size: 13px; font-weight: bold;">YouTube</span>. Vì vậy bạn phải sao chép mã nhúng của video ở <span style="color: #30A1BE; font-size: 13px; font-weight: bold;">YouTube</span> vào đây.
						</span>
					</div>
				</div>
			</div>
			<div class="video-body">
				<div class="tq-td-img-button">
					<div style="float:left">
						<button style="height: 24px; width: 70px;" class="bt-form" onclick="submitForm();"><span class="body-content">Lưu</span></button>
					</div>
					<div style="float:left; padding-left: 20px">	
						<button style="height: 24px; width: 70px;" class="bt-form" onclick="backButton();"><span class="body-content">Hủy</span></button>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>

<form name="hidenDelForm" method="post" action="<portlet:actionURL><portlet:param name='struts_action' value='/video/del_video'></portlet:param></portlet:actionURL>">
			<input type="hidden" id="<%= URLParameter_RS.ORG_ID %>" name="<%= URLParameter_RS.ORG_ID %>" value="<%= orgId %>">
			<input type="hidden" name="<%= Video_Const.MODE %>" value="1">
			<input type="hidden" name="<%= Video_Const.CURRENT_URL %>" value="<%= currentUrl%>">
</form>
		