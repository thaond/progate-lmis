<%@ include file="/html/portlet/pg_overview/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	
	int editSuccess = 0;

	if(request.getAttribute(Overview_Const.EDITED_SUCCESS) != null){
		editSuccess = (Integer)request.getAttribute(Overview_Const.EDITED_SUCCESS);
	}
	
	int orgId = Integer.parseInt(request.getParameter(URLParameter_RS.ORG_ID));
	int viewMode =Integer.parseInt(request.getParameter(URLParameter_RS.VIEW_MODE));
	//String introOverall = request.getParameter(Overview_Const.INTRO);
	//String visionOverall = request.getParameter(Overview_Const.VISION);
	//String misionOverall = request.getParameter(Overview_Const.MISSION);
	//String coreValueOverall = request.getParameter(Overview_Const.CORE_VALUE);
	
	String introOverall = "";
	String visionOverall = "";
	String misionOverall = "";
	String coreValueOverall = "";
	
	try {
		String introType = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeOrgOverallIntro();
		String visionType = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeOrgOverallVision();
		String missionType = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeOrgOverallMission();
		String coreValueType = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeOrgOverallCoreValue();
		int end = ProGateJournalArticleLocalServiceUtil.countArticleByType(orgId, introType, "");
		
		// Intro
		List<ProGateJournalArticle> listIntro = ProGateJournalArticleLocalServiceUtil
				.getListProGateArticles(orgId, introType, "", 0, end);
		if((listIntro != null) && (listIntro.size() != 0)){
			introOverall = listIntro.get(0).getContent();
		}
		
		// Vision
		List<ProGateJournalArticle> listVision = ProGateJournalArticleLocalServiceUtil
				.getListProGateArticles(orgId, visionType, "", 0, end);
		if((listVision != null) && (listVision.size() != 0)){
			visionOverall = listVision.get(0).getContent();
			
		}
		
		// Mission
		List<ProGateJournalArticle> listMission = ProGateJournalArticleLocalServiceUtil
				.getListProGateArticles(orgId, missionType, "", 0, end);
		if((listMission != null) && (listMission.size() != 0)){
			misionOverall = listMission.get(0).getContent();
		}
		
		// CoreValue
		List<ProGateJournalArticle> listCoreValue = ProGateJournalArticleLocalServiceUtil
				.getListProGateArticles(orgId, coreValueType, "", 0, end);
		if((listCoreValue != null) && (listCoreValue.size() != 0)){
			coreValueOverall = listCoreValue.get(0).getContent();
			
		}
	} catch (Exception e) {

	}
	
	String currentUrl = "";
	if(request.getParameter(Overview_Const.CURRENT_URL) != null){
		currentUrl = request.getParameter(Overview_Const.CURRENT_URL);
	}
	
%>

<liferay-theme:defineObjects />

<script type="text/javascript">

	function initEditorIntro() {
		var out =jQuery('#introDis').html();
		//out = out.replace('<','&#x200B;<');
		window.<%= Overview_Const.INTRO %>.setHTML(out);
		return out;
	}
	function initEditorVision() {
		var out =jQuery('#visDis').html();
		//out = out.replace('<','&#x200B;<');
		window.<%= Overview_Const.VISION %>.setHTML(out);
		return out;
	}
	function initEditorMission() {
		var out =jQuery('#misDis').html();
		//out = out.replace('<','&#x200B;<');
		window.<%= Overview_Const.MISSION %>.setHTML(out);
		return out;
	}
	function initEditorCoreValue() {
		var out =jQuery('#coDis').html();
		//out = out.replace('<','&#x200B;<');
		window.<%= Overview_Const.CORE_VALUE %>.setHTML(out);
		return out;
	}


	function submitForm() {
		var introHTML = window.<%= Overview_Const.INTRO %>.getHTML();
		var visionHTML = window.<%= Overview_Const.VISION %>.getHTML();
	    var missionHTML = window.<%= Overview_Const.MISSION %>.getHTML();
	    var coreValueHTML = window.<%= Overview_Const.CORE_VALUE %>.getHTML();  
    	document.frmEdit.<%= Overview_Const.INTRO %>.value = introHTML;
    	document.frmEdit.<%= Overview_Const.VISION %>.value = visionHTML;
    	document.frmEdit.<%= Overview_Const.MISSION %>.value = missionHTML;
    	document.frmEdit.<%= Overview_Const.CORE_VALUE %>.value = coreValueHTML;
    	
    	document.frmEdit.submit();
	    
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

<form name="frmEdit" method="post" onsubmit="Javascript: return false;" action="<portlet:actionURL>
<portlet:param name='struts_action' value='/pg_overview/edit_action'></portlet:param>
<portlet:param name='<%=URLParameter_RS.ORG_ID  %>' value='<%= Integer.toString(orgId) %>'></portlet:param>
<portlet:param name='<%=URLParameter_RS.VIEW_MODE  %>' value='<%= Integer.toString(viewMode) %>'></portlet:param>
</portlet:actionURL>">
	<input type="hidden" name="<%= URLParameter_RS.ORG_ID %>" value="<%= orgId%>">
	<input type="hidden" name="<%= Overview_Const.INTRO %>" value="">
	<input type="hidden" name="<%= Overview_Const.VISION %>" value="">
	<input type="hidden" name="<%= Overview_Const.MISSION %>" value="">
	<input type="hidden" name="<%= Overview_Const.CORE_VALUE %>" value="">
	<input type="hidden" name="<%= Overview_Const.CURRENT_URL %>" value="<%= currentUrl %>">
	
	<div id="introDis" style="display:none">
		<%= introOverall %>
	</div>
	<div id="visDis" style="display:none">
		<%= visionOverall %>
	</div>
	<div id="misDis" style="display:none">
		<%= misionOverall %>
	</div>
	<div id="coDis" style="display:none">
		<%= coreValueOverall %>
	</div>
	
	<div class="tq-layout">
		<div class="tq-add-header">
			<span class="tq-content-header">Sửa Tổng Quan</span>
		</div>
		<div class="tq-body">
			<div class="tq-tr-header" style="display: none;">
				<div style="float: right; padding-top: 11x;"><span style="float: left;padding-top: 10px" class="tq-body-content">Xem trước</span></div>
				<div class="tq-img-td" style="float: right;"><img alt="" src="/ProGate-portlet/images/preview.png" width="30px" height="25px"/></div>
			</div>
			<% if(editSuccess == 1){ %>
				<div class="tq-body-mes-success" id="mesSuccess">
					<div class="tq-img-td" style="float: left;"><img alt="" src="/ProGate-portlet/images/success.png" width="20px" height="20px"></div>
					<div style="float: left; padding-top: 8px; padding-left: 5px;">
						<span class="tq-body-content-mes">Bạn đã cập nhật tổng quan thành công </span>
					</div>
					<div style="float:right; padding-right:20px;">
						<img alt="" src="/ProGate-portlet/images/black_delete.png" width="28px" height="28px" onclick="closeMes();">
					</div>
				</div>
			<%} %>
			<% if(editSuccess == 2){ %>
				<div class="tq-body-mes-error" id="mesError">
					<div class="tq-img-td" style="float: left;"><img alt="" src="/ProGate-portlet/images/error.png" width="20px" height="20px"></div>
					<div style="float: left; padding-top: 8px; padding-left: 5px;">
						<span class="tq-body-content-mes">Đã có lỗi xảy ra trong quá trình cập nhật tổng quan </span>
					</div>
					<div style="float:right; padding-right:20px;">
						<img alt="" src="/ProGate-portlet/images/black_delete.png" width="28px" height="28px" onclick="closeMes();">
					</div>
				</div>
			<%} %>
			<div class="tq-body-mes-error" id="mesErrorShow" style="display: none;">
					<div class="tq-img-td" style="float: left;"><img alt="" src="/ProGate-portlet/images/error.png" width="20px" height="20px"></div>
					<div style="float: left; padding-top: 8px; padding-left: 5px;">
						<span class="tq-body-content-mes">Đã có lỗi xảy ra trong quá trình cập nhật tổng quan </span>
					</div>
					<div style="float:right; padding-right:20px;">
						<img alt="" src="/ProGate-portlet/images/black_delete.png" width="28px" height="28px" onclick="closeMes();">
					</div>
				</div>
			<div class="tq-body">
				<div class="tq-td-content"><span class="tq-body-content">Giới Thiệu</span></div>
				<div class="tq-td">
					<liferay-ui:input-editor
							name='<%= Overview_Const.INTRO %>'
							editorImpl="editor.wysiwyg.portal-web.docroot.html.portlet.progate.edit.view.jsp"
							toolbarSet="liferay-article"
							initMethod='initEditorIntro'
							onChangeMethod='editorContentChanged'
							height="300"
							width="770"
					/>
				</div>
				<div class="tq-td-img">
					<div class="img-td" style="float: left;"><img alt="" src="/ProGate-portlet/images/information.png" width="20px" height="20px"></div>
					<div style="float: left; padding-top: 8px; padding-left: 5px;">
						<span class="tq-body-content">
							Nếu bạn không nhập nội dung thì sẽ không hiển thị phần này
						</span>
					</div>
				</div>
			</div>
			<div class="tq-body">
				<div class="tq-td-content"><span class="tq-body-content">Tầm Nhìn</span></div>
				<div class="tq-td">
					<liferay-ui:input-editor
							name='<%= Overview_Const.VISION %>'
							editorImpl="editor.wysiwyg.portal-web.docroot.html.portlet.progate.edit.view.jsp"
							toolbarSet="liferay-article"
							initMethod='initEditorVision'
							onChangeMethod='editorContentChanged'
							height="232"
							width="770"
					/>
				</div>
				<div class="tq-td-img">
					<div class="tq-img-td" style="float: left;"><img alt="" src="/ProGate-portlet/images/information.png" width="20px" height="20px"></div>
					<div style="float: left; padding-top: 8px; padding-left: 5px;">
						<span class="tq-body-content">
							Nếu bạn không nhập nội dung thì sẽ không hiển thị phần này
						</span>
					</div>
				</div>
			</div>
			<div class="tq-body">
				<div class="tq-td-content"><span class="body-content">Sứ Mệnh</span></div>
				<div class="tq-td">
					<liferay-ui:input-editor
							name='<%= Overview_Const.MISSION %>'
							editorImpl="editor.wysiwyg.portal-web.docroot.html.portlet.progate.edit.view.jsp"
							toolbarSet="liferay-article"
							initMethod='initEditorMission'
							onChangeMethod='editorContentChanged'
							height="232"
							width="770"
					/>
				</div>
				<div class="tq-td-img">
					<div class="tq-img-td" style="float: left;"><img alt="" src="/ProGate-portlet/images/information.png" width="20px" height="20px"></div>
					<div style="float: left; padding-top: 8px; padding-left: 5px;">
						<span class="tq-body-content">
							Nếu bạn không nhập nội dung thì sẽ không hiển thị phần này
						</span>
					</div>
				</div>
			</div>
			<div class="tq-body">
				<div class="tq-td-content"><span class="tq-body-content">Giá Trị Cốt Lõi</span></div>
				<div class="tq-td">
					<liferay-ui:input-editor
							name='<%= Overview_Const.CORE_VALUE %>'
							editorImpl="editor.wysiwyg.portal-web.docroot.html.portlet.progate.edit.view.jsp"
							toolbarSet="liferay-article"
							initMethod='initEditorCoreValue'
							onChangeMethod='editorContentChanged'
							height="232"
							width="770"
					/>
				</div>
				<div class="tq-td-img">
					<div class="tq-img-td" style="float: left;"><img alt="" src="/ProGate-portlet/images/information.png" width="20px" height="20px"></div>
					<div style="float: left; padding-top: 8px; padding-left: 5px;">
						<span class="tq-body-content">
							Nếu bạn không nhập nội dung thì sẽ không hiển thị phần này
						</span>
					</div>
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