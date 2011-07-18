
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.larion.progate.developHistory.constants.DevHistory_Const"%>
<%@ include file="/html/portlet/pg_overview/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ page import="com.larion.progate.overview.constants.Overview_Const"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
 	int addSuccess = 0;
	String history = "";
	String currentUrl = "";
	if(request.getAttribute(DevHistory_Const.ADDED_SUCCESS) != null){
		addSuccess = (Integer)request.getAttribute(DevHistory_Const.ADDED_SUCCESS);
	}
	
	int orgId = ParamUtil.getInteger(request, URLParameter_RS.ORG_ID);
	int viewMode =Integer.parseInt(request.getParameter(URLParameter_RS.VIEW_MODE));
	if(request.getParameter(DevHistory_Const.HISTORY) != null){
		history = ParamUtil.getString(request, DevHistory_Const.HISTORY);
	}
	if(request.getParameter(DevHistory_Const.CURRENT_URL) != null){
		currentUrl = ParamUtil.getString(request, DevHistory_Const.CURRENT_URL);
	}
	
%>

<liferay-theme:defineObjects />

<script type="text/javascript">
		
	function initEditorHistory() {
		var out =jQuery('#introDis').html();
		//out = out.replace('<','&#x200B;<');
		window.<%= DevHistory_Const.HISTORY %>.setHTML(out);
		return out;
	}
	
	

	function submitForm() {
		var historyHTML = window.<%= DevHistory_Const.HISTORY %>.getHTML();
	    if(historyHTML != ""){
	    	jQuery("#err").text('');
	    	jQuery("#mesErrorShow").css("display","none");
	    	document.frmAdd.<%= DevHistory_Const.HISTORY %>.value = historyHTML;
	    	document.frmAdd.submit();
	    }else{
	    	jQuery("#err").text('Bạn chưa nhập đầy đủ thông tin');
	    	jQuery("#mesErrorShow").css("display","block");
	    	jQuery("#mesSuccess").css("display","none");
	    	jQuery("#mesError").css("display","none");
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
<portlet:param name='struts_action' value='/developHistory/add_action'></portlet:param>
<portlet:param name='<%=URLParameter_RS.ORG_ID  %>' value='<%= Integer.toString(orgId) %>'></portlet:param>
<portlet:param name='<%=URLParameter_RS.VIEW_MODE  %>' value='<%= Integer.toString(viewMode) %>'></portlet:param>
</portlet:actionURL>">
	<input type="hidden" name="<%= URLParameter_RS.ORG_ID %>" value="<%= orgId%>">
	<input type="hidden" name="<%= DevHistory_Const.HISTORY %>" value="">
	<input type="hidden" name="<%= DevHistory_Const.CURRENT_URL %>" value="<%= currentUrl %>">
	
	<div id="introDis" style="display:none">
		<%= history %>
	</div>
	
	<div class="tq-layout">
		<div class="tq-add-header">
			<span class="tq-content-header">Thêm Lịch Sử Phát Triển</span>
		</div>
		<div class="tq-body">
			<div class="tq-tr-header" style="display: none;">
				<div style="float: right; padding-top: 11x;"><span style="float: left;padding-top: 10px" class="tq-body-content">Xem trước</span></div>
				<div class="tq-img-td" style="float: right;"><img alt="" src="/ProGate-portlet/images/preview.png" width="30px" height="25px"/></div>
			</div>
			<% if(addSuccess == 1){ %>
				<div class="tq-body-mes-success" id="mesSuccess">
					<div class="tq-img-td" style="float: left;"><img alt="" src="/ProGate-portlet/images/success.png" width="20px" height="20px"></div>
					<div style="float: left; padding-top: 8px; padding-left: 5px;">
						<span class="tq-body-content-mes">Bạn đã thêm lịch sử phát triển thành công </span>
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
						<span class="tq-body-content-mes">Đã có lỗi xảy ra trong quá trình thêm lịch sử phát triển </span>
					</div>
					<div style="float:right; padding-right:20px;">
						<img alt="" src="/ProGate-portlet/images/black_delete.png" width="28px" height="28px" onclick="closeMes();">
					</div>
				</div>
			<%} %>
			<div class="tq-body-mes-error" id="mesErrorShow" style="display: none;">
					<div class="tq-img-td" style="float: left;"><img alt="" src="/ProGate-portlet/images/error.png" width="20px" height="20px"></div>
					<div style="float: left; padding-top: 8px; padding-left: 5px;">
						<span class="tq-body-content-mes">Đã có lỗi xảy ra trong quá trình thêm lịch sử phát triển </span>
					</div>
					<div style="float:right; padding-right:20px;">
						<img alt="" src="/ProGate-portlet/images/black_delete.png" width="28px" height="28px" onclick="closeMes();">
					</div>
				</div>
			<div class="tq-body">
				<div class="tq-td-content"><span class="tq-body-content">Nội Dung</span></div>
				<div class="tq-td">
					<liferay-ui:input-editor
							name='<%= DevHistory_Const.HISTORY %>'
							editorImpl="editor.wysiwyg.portal-web.docroot.html.portlet.progate.edit.view.jsp"
							toolbarSet="liferay-article"
							initMethod='initEditorHistory'
							onChangeMethod='editorContentChanged'
							height="400"
							width="770"
					/>
					
				</div>
				<div class="tq-td-img">
					<div class="tq-mes" id="err"></div>
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