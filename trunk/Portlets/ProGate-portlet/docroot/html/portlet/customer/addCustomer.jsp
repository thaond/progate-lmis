<%@page import="larion.progate.service.ProGateOrgCustomerRepresenterLocalServiceUtil"%>
<%@page import="larion.progate.model.ProGateOrgCustomerRepresenter"%>
<%@page import="larion.progate.model.ProGateOrgCustomer"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool" %>
<%@page import="java.util.regex.Pattern" %>

<%@ include file="/html/portlet/customer/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
       
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ include file="/html/portlet/common/image_preview.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
 	int addSuccess = 0;
	int objectId = 0;
	int cusType = -1; 
	String cusName = "";
	String logo = "";
	String website = "";
	String description = "" ;
	
	String fullname = "";
	String position = "";
	String comment = "";
	
	String textErrOrgName = "";
	int flag = 0;
	int count = 0;
	ProGateOrgCustomer cusObject = null;
	List<ProGateOrgCustomerRepresenter> listOrgFounder = new ArrayList<ProGateOrgCustomerRepresenter>();
	
	int orgId = 0; 
	if(request.getParameter(URLParameter_RS.ORG_ID) != null){
		orgId = Integer.parseInt(request.getParameter(URLParameter_RS.ORG_ID));
	}
	int viewMode = 0; 
	if(request.getParameter(URLParameter_RS.VIEW_MODE) != null){
		viewMode = Integer.parseInt(request.getParameter(URLParameter_RS.VIEW_MODE));
	}
	if(request.getAttribute(Customer_Const.ORG_OBJECT) != null){
		cusObject = (ProGateOrgCustomer)request.getAttribute(Customer_Const.ORG_OBJECT);
	}
	if(request.getParameter(Customer_Const.COUNT) != null){
		count = Integer.parseInt(request.getParameter(Customer_Const.COUNT));
	}
	
	if(cusObject != null) {
		objectId = cusObject.getPrimaryKey();
		cusType = cusObject.getCustomerType();
		cusName = cusObject.getCustomerName();
		logo = cusObject.getLogo();
		website = cusObject.getWebsite();
		description = cusObject.getDescription();
		listOrgFounder = ProGateOrgCustomerRepresenterLocalServiceUtil.getListCustRepresenterByCustId(cusObject.getPrimaryKey(),0,count,false);	
		
	}
	
	if(request.getAttribute(Customer_Const.ADDED_SUCCESS) != null){
		addSuccess = (Integer)request.getAttribute(Customer_Const.ADDED_SUCCESS);
	}
	
	
	String homeUrl= PortalUtil.getPortalURL(request);
	String viewURL = PortalUtil.getCurrentURL(request);
	String currentPage ="";
	if(viewURL.indexOf(StringPool.QUESTION) != -1){
		String[] str = Pattern.compile("\\?").split(viewURL);
		currentPage = str[0];
	}
	String url = homeUrl + currentPage + StringPool.QUESTION + URLParameter_RS.ORG_ID + StringPool.EQUAL+ orgId 
				+ StringPool.AMPERSAND + URLParameter_RS.VIEW_MODE + StringPool.EQUAL+ viewMode;
	
	if(request.getParameter(Customer_Const.FLAG) != null){
		flag = Integer.parseInt(request.getParameter(Customer_Const.FLAG));
	}else{
		if(cusType == 0){
			flag = 1;
		}else if(cusType == 2){
			flag = 2;
		}else if(cusType == 1){
			flag = 3;
		}else{
			flag = 0;
		}
	}
	
	if(request.getParameter(Customer_Const.TEXT_ERROR_ORG_NAME) != null){
		textErrOrgName = "Tên Tổ Chức đã tồn tại";
	}
%>

<liferay-theme:defineObjects />

<script type="text/javascript">

function isValidImageType(value)
{
	  return /\.(gif|jpeg|jpg|png)$/i.test (value);
}

jQuery(document).ready(function(){
	var isSuccess = <%=addSuccess %> ;
	var textErrOrgName = '<%=textErrOrgName %>';
	if(isSuccess == 1){
		jQuery("#mesSuccess").css("display","block");
		jQuery("#popupDel").css("display","block");
		jQuery("#mesError").css("display","none");
		jQuery("#mesSuccessDel").css("display","none");
	}else if(isSuccess == 2){
		jQuery("#mesError").css("display","block");
		jQuery("#mesSuccess").css("display","none");
		jQuery("#popupDel").css("display","none");
		jQuery("#mesSuccessDel").css("display","none");
		if(textErrOrgName != ''){
			jQuery("#errOrgName").text(textErrOrgName);
		}else{
			jQuery("#errOrgName").text('');
		}
	}else if(isSuccess == 3){
		jQuery("#mesError").css("display","none");
		jQuery("#mesSuccess").css("display","none");
		jQuery("#popupDel").css("display","none");
		jQuery("#mesSuccessDel").css("display","block");
	}else{
		jQuery("#mesSuccess").css("display","none");
		jQuery("#mesError").css("display","none");
		jQuery("#popupDel").css("display","none");
		jQuery("#mesSuccessDel").css("display","none");
	}
});

function deleteObject(){
	document.hidenDelForm.<%= Customer_Const.COUNT %>.value = representativeCount;
	
	var jQueryform = jQuery("form[name='hidenDelForm']");
		
	jQueryform.ajaxSubmit({
		url: document.hidenDelForm.action,
		success: function(data) {			
			
			if (data == '3') {
				cancel();
			}
		}
	});
}

function showPopupDelete() {
	jQuery("#deletePopupCus").css("visibility","visible");
	jQuery("#deletePopupCus").dialog("open");
}

jQuery(function(){
	
	var close = function() {
		jQuery("#deletePopupCus").dialog("close");
    }
	var submit = function(){
		deleteObject();
		jQuery("#deletePopupCus").dialog("close");
	}
    var dialogOpts = {
    	title:'Đối Tượng ',
    	autoOpen: false,
	    modal: true,
	    buttons: {	'  Có  ': submit,	        
	        ' Không ': close
	    },
	    resizable: false,
	    width: 450,
	    height: 150
    };
    
    jQuery("#deletePopupCus").dialog(dialogOpts);
    jQuery("#popup").click(function(){
    	jQuery("#deletePopupCus").css("visibility","visible");
    	jQuery("#deletePopupCus").dialog("open");
    });	

	});   

	function initEditorDescription() {
		var out =jQuery('#dis').html();
		
		window.<%= Customer_Const.DESCRIPTION %>.setHTML(out);
		return out;
	}
	
	function submitForm() {
		var isValid = true;
		jQuery("#mesError").css("display", "none");
		jQuery("#mesSuccess").css("display","none");
		jQuery("#mesSuccessDel").css("display","none");
		
		// Validate OrgName
		if (validOrgName() == false) {
			jQuery("#mesError").css("display", "block");
			isValid = false;
			//return false;
		}
		
		// Validate OrgLogo
		if (validOrgLogo() == false) {
			jQuery("#mesError").css("display", "block");
			isValid = false;
			//return false;
		}
		
		var descriptionHTML = window.<%= Customer_Const.DESCRIPTION %>.getHTML();
		if (descriptionHTML == ''){
			jQuery("#mesError").css("display", "block");			
			jQuery("#errDes").text('Bạn chưa nhập nội dung');
			isValid = false;
			
		}else{			
			jQuery("#errDes").text('');
		}
		
		if(!isValid){
			return false;
		}
		
		for(var i = 0; i < document.frmAdd.<%= Customer_Const.OBJECT_CUS %>.length;i++)
		{
			if(document.frmAdd.<%= Customer_Const.OBJECT_CUS %>[i].checked )
			{	
				document.frmAdd.<%= Customer_Const.OBJECT_CUS_SELECTED %>.value = document.frmAdd.<%= Customer_Const.OBJECT_CUS %>[i].value;
			 	break;
			}
		}
		document.frmAdd.<%= Customer_Const.DESCRIPTION %>.value = descriptionHTML;
		document.frmAdd.<%= Customer_Const.COUNT %>.value = representativeCount;
    	document.frmAdd.submit();
	}
	
	function cancel(){
		var url = '<%= url %>';
		
		window.parent.location = url ;		
	}
		
	function validOrgName(){
		var orgName = jQuery("#orgName").val();
		if(orgName == ''){
			
			jQuery("#errOrgName").text('Bạn chưa nhập tên tổ chức');
		}else{
			
			jQuery("#errOrgName").text('');
		}
	}
	
	function validOrgLogo(){
		var logo = jQuery("#orgLogo").val();
		
		if(logo != ''){
			// Image preview
			imagePreview("orgLogo", "orgLogoImg");
		}
		if (logo == '' || logo == null) {
			<%System.out.println("Logo == '' or logo == null"); %>
			jQuery("#errLogo").text('Bạn chưa chọn logo');
			return false;
		} else if (!isValidImageType(logo)) {
			jQuery("#errLogo").text('File này có định dạng không được hỗ trợ');
			return false;
		} else {
			jQuery("#errLogo").text('');
		}
		
		return true;
	}
	
	var representativeCount = 1;
	function appendToPeople(){
		representativeCount += 1;
		jQuery("#appendDiv").append(jQuery("#representative").html());
		
	}
	
	function checkSpecialCharacters(data) {
		var iChars = "!@#$%^&*()+=-[]\\\';,./{}|\":<>?~_`";
		for (var i = 0; i < data.length; i++) {
			if (iChars.indexOf(data.charAt(i)) != -1) {
			
				return false;
			}
		}
			return true;
	}

	function closeMes(){
		jQuery("#mesSuccess").css("display","none");
		jQuery("#mesError").css("display","none");
		jQuery("#mesSuccessDel").css("display","none");
		
	}
	

</script> 

<form name="frmAdd" method="post" onsubmit="Javascript: return false;" 
	action="<portlet:actionURL>
			<portlet:param name='struts_action' value='/customer/add_action'></portlet:param>
			<portlet:param name='<%= URLParameter_RS.ORG_ID %>' value='<%= Integer.toString(orgId) %>'></portlet:param>
			<portlet:param name='<%= URLParameter_RS.VIEW_MODE %>' value='1'></portlet:param>
			</portlet:actionURL>" enctype="multipart/form-data">
	<input type="hidden" name="<%= URLParameter_RS.ORG_ID %>" value="<%= orgId %>">
	<input type="hidden" name="<%= Customer_Const.DESCRIPTION %>" value="">
	<input type="hidden" name="<%= Customer_Const.OBJECT_CUS_SELECTED %>" value="">
	<input type="hidden" name="<%= Customer_Const.COUNT %>" value="">
	<input type="hidden" name="<%= Customer_Const.URL %>" value="<%= url %>">
	
	<div id="dis" style="display:none">
		<%= description  %>
	</div>
	
	<div class="tq-layout">
		<div class="tq-add-header">
			<span class="tq-content-header">Thêm Khách Hàng / Đối Tác</span>
		</div>
		<div class="tq-body">
			<div class="tq-tr-header" style="display: none;">
				<div style="float: right; padding-top: 11x;"><span style="float: left;padding-top: 10px" class="tq-body-content">Xem trước</span></div>
				<div class="tq-img-td" style="float: right;"><img alt="" src="/ProGate-portlet/images/preview.png" width="30px" height="25px"/></div>
			<div id="popupDel" style="display: none;">
				<div class="img-td" style="float: right;padding-top: 8px; padding-right: 5px"><span> | </span></div>
				<div class="img-td" style="float: right;padding-top: 10px; padding-right: 9px; cursor:pointer;"><span onclick="showPopupDelete();"> Xoá </span></div>
				<div class="img-td" style="float: right;padding-right: 2px;"><img alt="" src="/ProGate-portlet/images/error.png" width="23px" height="23px" id="popup" style="vertical-align: middle; margin-left: 3px; cursor:pointer;"/></div>
				<%@include file="deletePopupCus.jsp"%>
			</div>
			</div>
			<br>
			<% //if(addSuccess == 1){ %>
				<div class="tq-body-mes-success" id="mesSuccess" style="display: none;">
					<div class="tq-img-td" style="float: left;"><img alt="" src="/ProGate-portlet/images/success.png" width="20px" height="20px"></div>
					<div style="float: left; padding-top: 8px; padding-left: 5px;">
						<span class="tq-body-content-mes">Bạn đã thêm đối tượng thành công </span>
					</div>
					<div style="float:right; padding-right:20px;">
						<img alt="" src="/ProGate-portlet/images/black_delete.png" width="28px" height="28px" onclick="closeMes();">
					</div>
				</div>
				<div class="tq-body-mes-success" id="mesSuccessDel" style="display: none;">
					<div class="tq-img-td" style="float: left;"><img alt="" src="/ProGate-portlet/images/success.png" width="20px" height="20px"></div>
					<div style="float: left; padding-top: 8px; padding-left: 5px;">
						<span class="tq-body-content-mes">Bạn đã xóa đối tượng thành công </span>
					</div>
					<div style="float:right; padding-right:20px;">
						<img alt="" src="/ProGate-portlet/images/black_delete.png" width="28px" height="28px" onclick="closeMes();">
					</div>
				</div>
			<%//} %>
			<% //if(addSuccess == 2){ %>
				<div class="tq-body-mes-error" id="mesError" style="display: none;">
					<div class="tq-img-td" style="float: left;"><img alt="" src="/ProGate-portlet/images/error.png" width="20px" height="20px"></div>
					<div style="float: left; padding-top: 8px; padding-left: 5px;">
						<span class="tq-body-content-mes">Đã có lỗi xảy ra trong quá trình lưu đối tượng</span>
					</div>
					<div style="float:right; padding-right:20px;">
						<img alt="" src="/ProGate-portlet/images/black_delete.png" width="28px" height="28px" onclick="closeMes();">
					</div>
				</div>
			<%//} %>
			<br>
			<div style="padding-left:20px" class="tq-mes">(*) Thông tin bắt buộc nhập</div>
			<br>
			
			<div class="tq-body">
				<div class="cus-td-content"><span class="tq-body-content">Đối Tượng</span></div>
				<div class="tq-td">
					<input type="radio" name="<%= Customer_Const.OBJECT_CUS %>" value="<%=Customer_Const.CUSTOMER  %>" <%= flag == 1 ? "checked='checked'" : "" %>/>
					<label class="cus-radio">Khách Hàng</label>
					
					<input type="radio" name="<%= Customer_Const.OBJECT_CUS %>" value="<%=Customer_Const.PARTNER  %>" <%= flag == 2 ? "checked='checked'" : "" %>/>
					<label class="cus-radio">Đối Tác</label>
					
					<input type="radio" name="<%= Customer_Const.OBJECT_CUS %>" value="<%=Customer_Const.CUS_PART  %>" <%= flag == 3 ? "checked='checked'" : "" %>>
					<label class="cus-radio">Khách Hàng - Đối Tác</label>
				</div>
			</div>
			<div class="tq-body">
				<div class="cus-td-content"><span class="tq-body-content">Hồ Sơ Của Tổ Chức</span></div>
				<div class="tq-td">
					<input type="radio" name="<%= Customer_Const.ORG_PROFILE %>" value="">
					<label style="padding-right: 77px; padding-left: 3px">Có</label>
					
					<input type="radio" name="<%= Customer_Const.ORG_PROFILE %>" value="" checked="checked">
					<label class="cus-radio">Không</label>
				</div>
				<div class="cus-td-img">
					<div class="tq-img-td" style="float: left;"><img alt="" src="/ProGate-portlet/images/information.png" width="20px" height="20px"></div>
					<div class="div-info">
						<span class="tq-body-content">
							Hồ sơ của tổ chức là một cái nhìn ngắn gọn hoặc bản tóm tắt của tổ chức, nó thể hiện các hoạt động của tổ chức hay những cơ hội / thách thức mà tổ chức đó đối mặt. 
							Bạn hãy chọn <span class="tq-body-content-mes"> Có </span> nếu tổ chức của bạn đã có hồ sơ tổ chức trong ProGate và chọn <span class="tq-body-content-mes">Không</span> nếu tổ chức bạn chưa có hồ sơ tổ chức trong ProGate.
						</span>
					</div>
				</div>
			</div>
			<div class="tq-body">
				<div class="cus-td-content"><span class="tq-body-content">Tên Tổ Chức (<span class="tq-mes">*</span>) </span></div>
				<div class="tq-td">
					<input type="text" name="<%= Customer_Const.ORG_NAME %>" value="<%= cusName %>" size="78" id="orgName" onblur="validOrgName();" maxlength="50">
				</div>
				<div class="cus-td-img">
					<div class="tq-mes" id="errOrgName"></div>
				</div>
			</div>
			<div class="tq-body">
				<div class="cus-td-content"><span class="tq-body-content">Logo (<span class="tq-mes">*</span>)</span></div>
				<div class="tq-td">
					<div class="cus-image" id="orgLogoDiv" style="display: block;"> 
						<img src="/ProGate-portlet/images/news_org/small_noImage.gif" id="orgLogoImg" onload="scaleImg(this, 145, 100)">
					</div>
				</div>
				<div style="float: left; width: 65%; padding-left: 8px;">
					<div style="float: left; width: 100%;">
						<input type="file" name="<%= Customer_Const.LOGO %>" size="77" id="orgLogo" onchange="validOrgLogo();"/>
					</div>
					<div style="float: left; width: 100%;">
						<div class="tq-mes" id="errLogo"></div>
					</div>
					<div style="float: left; width: 100%;">
						<div class="tq-img-td" style="float: left;"><img alt="" src="/ProGate-portlet/images/information.png" width="20px" height="20px"></div>
						<div class="div-info">
							<span class="tq-body-content">
								Bạn có thể tải các tập tin JPG, GIF hoặc PNG với dung lượng dưới 100KB và kích thước tối đa 145 x 100 px.
								Nếu bạn tải ảnh có kích thước hơn 145 x 100 px thì ảnh sẽ được thay đổi kích thước một cách tự động.
			
							</span>
						</div>
					</div>
				</div>
			</div>
			<div class="tq-body">
				<div class="cus-td-content"><span class="tq-body-content">Website </span></div>
				<div class="tq-td">
					<input type="text" name="<%= Customer_Const.WEBSITE %>" value="<%= website  %>" size="78" maxlength="50">
				</div>
			</div>
			<div class="tq-body">
				<div class="cus-td-content"><span class="tq-body-content">Mô Tả (<span class="tq-mes">*</span>)</span></div>
				<div class="tq-td">
					<liferay-ui:input-editor
							name='<%= Customer_Const.DESCRIPTION %>'
							editorImpl="editor.wysiwyg.portal-web.docroot.html.portlet.progate.edit.view.jsp"
							toolbarSet="liferay-article"
							initMethod='initEditorDescription'
							onChangeMethod='editorContentChanged'
							height="300"
							width="720"
					/>
					
				</div>
				<div class="cus-td-img">
					<div class="tq-mes" id="errDes"></div>
				</div>
			</div>
			<div id="appendDiv">
			<%
			if((listOrgFounder != null) && (listOrgFounder.size()!= 0)){
				for(int i = 0 ; i < listOrgFounder.size(); i++){
					ProGateOrgCustomerRepresenter founder = listOrgFounder.get(i);
				
			%>
				<div class="tq-body">
					<div>
						<div style="padding-top: 6px;float: left;"><span class="tq-body-content">Người Đại Diện  <%=i %></span> </div>
						<div style="float: left;margin-left: 10px; width: 85%; padding-top: 18px; border-bottom: 1px solid #E6771C;"></div>
					</div>
				</div>
				<div class="tq-body">
					<div class="cus-td-content"><span class="tq-body-content">Họ và Tên</span></div>
					<div class="tq-td">
						<input type="text" name="<%= Customer_Const.FULL_NAME %>" value="<%= founder.getFirstName() %>" size="55" maxlength="50">
					</div>
				</div>
				<div class="tq-body">
					<div class="cus-td-content"><span class="tq-body-content">Chức Vụ</span></div>
					<div class="tq-td">
						<input type="text" name="<%= Customer_Const.POSITION %>" value="<%= founder.getRole() %>" size="55" maxlength="50">
					</div>
				</div>
				<div class="tq-body">
					<div class="cus-td-content"><span class="tq-body-content">Nhận Xét</span></div>
					<div class="tq-td" style="width: 80%;">
						<textarea rows="5" cols="87" name="<%= Customer_Const.COMMENT %>"><%= founder.getDescription() %></textarea>
					</div>
					<div class="cus-td-img">
						<div class="tq-img-td" style="float: left;"><img alt="" src="/ProGate-portlet/images/information.png" width="20px" height="20px"></div>
						<div class='div-info'>
							<span class="tq-body-content">
								Đây là phần nhận xét của người đại diện thuộc tổ chức này về tổ chức của bạn. 
								Phần này sẽ được hiển thị ở phần Khách Hàng Nói Về Chúng Tôi.
							</span>
						</div>
					</div>
				</div>
			<%
				}
			}else{  %>
			<div class="tq-body">
					<div>
						<div style="padding-top: 6px;float: left;"><span class="tq-body-content">Người Đại Diện </span> </div>
						<div style="float: left;margin-left: 10px; width: 85%; padding-top: 18px; border-bottom: 1px solid #E6771C;"></div>
					</div>
				</div>
				<div class="tq-body">
					<div class="cus-td-content"><span class="tq-body-content">Họ và Tên</span></div>
					<div class="tq-td">
						<input type="text" name="<%= Customer_Const.FULL_NAME %>" value="" size="55">
					</div>
				</div>
				<div class="tq-body">
					<div class="cus-td-content"><span class="tq-body-content">Chức Vụ</span></div>
					<div class="tq-td">
						<input type="text" name="<%= Customer_Const.POSITION %>" value="" size="55">
					</div>
				</div>
				<div class="tq-body">
					<div class="cus-td-content"><span class="tq-body-content">Nhận Xét</span></div>
					<div class="tq-td" style="width: 80%;">
						<textarea rows="5" cols="87" name="<%= Customer_Const.COMMENT %>"></textarea>
					</div>
					<div class="cus-td-img">
						<div class="tq-img-td" style="float: left;"><img alt="" src="/ProGate-portlet/images/information.png" width="20px" height="20px"></div>
						<div class='div-info'>
							<span class="tq-body-content">
								Đây là phần nhận xét của người đại diện thuộc tổ chức này về tổ chức của bạn. 
								Phần này sẽ được hiển thị ở phần Khách Hàng Nói Về Chúng Tôi.
							</span>
						</div>
					</div>
				</div>
			</div>
			<%	
			}
			%>
			<div class="tq-body">
				<a style="text-decoration: none;cursor: pointer;" onclick="appendToPeople();"><span class="tg-content-blue"> + Thêm Người Đại Diện</span></a>
			</div>
			<div class="tq-body">
				<div class="tq-td-img-button">
					<div style="float:left">
						<button style="height: 24px; width: 70px;" class="bt-form" onclick="submitForm();"><span class="tq-body-content">Lưu</span></button>
					</div>
					<div style="float:left; padding-left: 20px">	
						<button style="height: 24px; width: 70px;" class="bt-form" onclick="cancel();"><span class="tq-body-content">Hủy</span></button>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>
<div id="representative" style="display: none">
	<div class='tq-body'>
				<div>
					<div style='padding-top: 6px;float: left;'><span class='tq-body-content'>Người Đại Diện </span> </div>
					<div style='float: left;margin-left: 10px; width: 85%; padding-top: 18px; border-bottom: 1px solid #E6771C;'></div>
				</div>
			</div>
			<div class='tq-body'>
				<div class='cus-td-content'><span class='tq-body-content'>Họ và Tên</span></div>
				<div class='tq-td'>
					<input type='text' name='<%= Customer_Const.FULL_NAME %>' value='' size='55'>
				</div>
			</div>
			<div class="tq-body">
				<div class='cus-td-content'><span class='tq-body-content'>Chức Vụ</span></div>
				<div class='tq-td'>
					<input type='text' name='<%= Customer_Const.POSITION %>' value='' size='55'>
				</div>
			</div>
			<div class='tq-body'>
				<div class='cus-td-content'><span class='tq-body-content'>Nhận Xét</span></div>
				<div class='tq-td' style="width: 80%;">
					<textarea rows='5' cols='87' name='<%= Customer_Const.COMMENT %>'></textarea>
				</div>
				<div class='cus-td-img'>
					<div class='tq-img-td' style='float: left;'><img alt='' src='/ProGate-portlet/images/information.png' width='20px' height='20px'></div>
					<div class='div-info'>
						<span class='tq-body-content'>
							Đây là phần nhận xét của người đại diện thuộc tổ chức này về tổ chức của bạn. 
							Phần này sẽ được hiển thị ở phần Khách Hàng Nói Về Chúng Tôi.
						</span>
					</div>
				</div>
			</div>
</div>
<form name="hidenDelForm" method="post" 
	action="<portlet:actionURL windowState='exclusive'>
				<portlet:param name='struts_action' value='/customer/del_action'></portlet:param>
				<portlet:param name='<%= URLParameter_RS.ORG_ID %>' value='<%= Integer.toString(orgId) %>'></portlet:param>
				<portlet:param name='<%= URLParameter_RS.VIEW_MODE %>' value='1'></portlet:param>
			</portlet:actionURL>">
			<input type="hidden" id="<%= Customer_Const.OBJECT_ID %>" name="<%= Customer_Const.OBJECT_ID %>" value="<%= objectId %>">
			<input type="hidden" name="<%= Customer_Const.URL %>" value="<%= url %>">
			<input type="hidden" name="<%= Customer_Const.MODE %>" value="1">
			<input type="hidden" name="<%= Customer_Const.COUNT %>" value="">
</form>

