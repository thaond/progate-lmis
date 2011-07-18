
<fmt:message key="add.action" bundle="${msg}" var="add" />
<fmt:message key="delete.action" bundle="${msg}" var="delete" />
<fmt:message key="repair.action" bundle="${msg}" var="repair" />

<fmt:message key="success.action" bundle="${msg}"
	var="addSuccessMessage">
	<fmt:param value="${add}" />
</fmt:message>

<fmt:message key="success.action" bundle="${msg}"
	var="repairSuccessMessage">
	<fmt:param value="${repair}" />
</fmt:message>

<fmt:message key="success.action" bundle="${msg}"
	var="deleteSuccessMessage">
	<fmt:param value="${delete}" />
</fmt:message>

<fmt:message key="error.action" bundle="${msg}" var="addErrorMessage">
	<fmt:param value="${add}" />
</fmt:message>

<fmt:message key="error.action" bundle="${msg}" var="repairErrorMessage">
	<fmt:param value="${repair}" />
</fmt:message>

<fmt:message key="error.action" bundle="${msg}" var="deleteErrorMessage">
	<fmt:param value="${delete}" />
</fmt:message>

<script type="text/javascript">

function initEditor() {
	
	var out = document.frmNewManageOrg.description.value;
	
    window.descriptionEditor.setHTML(out);
    
	return document.frmNewManageOrg.description.value;
}

function cancel(url){
	window.location=url;
}

function validateInformationForm(){
	var validate = true;	
	var isOrgExisted=jQuery.trim(jQuery('#isOrgExisted').text());	
	if(isOrgExisted=="true"){
		validate = false;
		jQuery("#checkOrgName").css("display","block");
		jQuery("#checkOrgName").html("<span class='new-manage-org-error'><%=res.getString("message.exist.orgName")%></span>");
	}else{
		jQuery("#checkOrgName").css("display","none");
	}

	var orgName = jQuery.trim(jQuery('#orgName').val());
	if (orgName == ''){
		validate = false;
		jQuery("#checkOrgName").css("display","block");
		jQuery("#checkOrgName").html("<span class='new-manage-org-error'><%=res.getString("message.blank.orgName")%></span>");
	}else if (orgName.length<2 || orgName.length>255){
		validate = false;
		jQuery("#checkOrgName").css("display","block");
		jQuery("#checkOrgName").html("<span class='new-manage-org-error'><%=res.getString("message.hint.orgName")%></span>");
	}else if (validText(orgName)==false){
		validate = false;
		jQuery("#checkOrgName").css("display","block");
		jQuery("#checkOrgName").html("<span class='new-manage-org-error'><%=res
					.getString("message_require_name_no_special_characters")%></span>");
	}
	
	var orgType = jQuery.trim(jQuery('#orgType').val());
	if(orgType == '<%=res.getString("select")%>'){
		validate = false;
		jQuery("#checkOrgType").css("display","block");
		jQuery("#checkOrgType").html("<span class='new-manage-org-error'><%=res.getString("message.blank.orgType")%></span>");
	}else{
		jQuery("#checkOrgType").css("display","none");
	}
	
	var city = jQuery.trim(jQuery('#city').val());
	if(city == '<%=res.getString("select")%>'){
		validate = false;
		jQuery("#checkCity").css("display","block");
		jQuery("#checkCity").html("<span class='new-manage-org-error'><%=res.getString("message.blank.city")%></span>");
	}else{
		jQuery("#checkCity").css("display","none");
	}
	
	var email = jQuery.trim(jQuery('#email').val());
	if(email == ''){
		validate = false;
		jQuery("#checkEmail").css("display","block");
		jQuery("#checkEmail").html("<span class='new-manage-org-error'><%=res.getString("message.blank.email")%></span>");
	}else{
		var emailPattern = /^([a-zA-Z0-9_.-])+@(([a-zA-Z0-9-])+.)+([a-zA-Z0-9]{2,4})+$/ ;
		if(emailPattern.test(email)){
			jQuery("#checkEmail").css("display","none");
			jQuery("#checkEmail").html("");
		}else{
			validate = false;
			jQuery("#checkEmail").css("display","block");
			jQuery("#checkEmail").html("<span class='new-manage-org-error'><%=res.getString("message.invalid.format.email")%></span>");
		}
	}
	
	var phone = jQuery.trim(jQuery('#phone').val());
	if(phone == ''){
		jQuery("#checkPhone").css("display","none");
	}else if (phone.length > 20){
		validate = false;
		jQuery("#checkPhone").css("display","block");
		jQuery("#checkPhone").html("<span class='new-manage-org-error'><%=res.getString("message.hint.phone")%></span>");
	}else{
		jQuery("#checkPhone").css("display","none");
	}			
	
	var address = jQuery.trim(jQuery('#address').val());
	if(address == ''){
		jQuery("#checkAddress").css("display","none");
	}else if (address.length < 2 || address.length > 255){
		validate = false;
		jQuery("#checkAddress").css("display","block");
		jQuery("#checkAddress").html("<span class='new-manage-org-error'><%=res.getString("message.hint.address")%></span>");
	}else{
	       var iChars = "!@#$%^*+=[]\\\';{}|\":<>?~_`";
	       var flag=true;
	       
		   for (var i = 0; i < address.length; i++) {
		  	if (iChars.indexOf(address.charAt(i)) != -1) {
		  		falg=false;
		  		break;
		  	}
		  }
		   if(flag){
			   jQuery("#checkAddress").css("display","none");
		   }
		   else{
			    validate = false;
				jQuery("#checkAddress").css("display","block");
				jQuery("#checkAddress").html("<span class='new-manage-org-error'><%=res
					.getString("message_require_address_no_special_characters")%></span>");
		   }
	}	
	
	var description = jQuery.trim(window.descriptionEditor.getHTML());
	document.frmNewManageOrg.description.value = description;
	if(description == ''){
		validate = false;
		jQuery("#checkDescription").css("display","block");
		jQuery("#checkDescription").html("<span class='new-manage-org-error'><%=res.getString("message.blank.description")%></span>");
	}else{
		jQuery("#checkDescription").css("display","none");
	}	
	
	var orgSize = jQuery.trim(jQuery('#orgSize').val());
	if(orgSize == ''){
		validate = false;
		jQuery("#checkOrgSize").css("display","block");
		jQuery("#checkOrgSize").html("<span class='new-manage-org-error'><%=res.getString("message.blank.orgSize")%></span>");
	}else if (IsNumeric(orgSize)==false){
		validate = false;
		jQuery("#checkOrgSize").css("display","block");
		jQuery("#checkOrgSize").html("<span class='new-manage-org-error'><%=res.getString("message.number")%></span>");
	}else{									
		jQuery("#checkOrgSize").css("display","none");
	}
	
	var expiredDate = jQuery.trim(jQuery('#expiredDate').val());
	if(expiredDate == ''){
		validate = false;
		jQuery("#checkExpriredDate").css("display","block");
		jQuery("#checkExpriredDate").html("<span class='new-manage-org-error'><%=res.getString("message.blank.expriredDate")%></span>");
	}else {
		var today = new Date();	
		var d   =  parseInt(expiredDate.substring(0,2),10); 
		var m   =  parseInt(expiredDate.substring(3,5),10);
		var y   =  parseInt(expiredDate.substring(6,10),10); 
			
		var expDate = new Date(y,m-1,d);
		
		if (expDate < today) {					
			validate = false;
			jQuery("#checkExpiredDate").css("display","block");
			jQuery("#checkExpiredDate").html("<span class='new-manage-org-error'><%=res.getString("message.future.expriredDate")%></span>");
		} else{
			jQuery("#checkExpiredDate").css("display","none");
		}
	}					
	
	if (validate == false){
		jQuery("#success").css("display", "none");
		jQuery("#error").css("display", "block");
	}else{
		jQuery("#checkOrgName").css("display","none");
	}
	
	return validate;
}

jQuery(document).ready(function(){	
		
	var pickerOpts = {
			showOn: "both",
			yearRange: "-80:+0",
			buttonImage: "<%=request.getContextPath()%>/images/calendar.gif",
			buttonImageOnly: true,
			dateFormat:"dd/mm/yy",
			onClose: function() {
				document.getElementById("expiredDate").focus();
		    }
	    };
	 	 jQuery("#expiredDate").datepicker(pickerOpts); 	
	 	 
	 	jQuery("#orgSize").keydown(function(event){
       		if(event.keyCode == 9 || event.keyCode == 8 || event.keyCode == 191 
       		   || event.keyCode == 37 || event.keyCode == 39){       			
       		}else{
       		    if (this.value.length > 11){
       		    	return false;
       		    }												       			
       		}       		
		});
	 	
	 	jQuery("#address").keydown(function(event){
       		if(event.keyCode == 9 || event.keyCode == 8 || event.keyCode == 191 
       		   || event.keyCode == 37 || event.keyCode == 39){       			
       		}else{
       		    if (this.value.length > 255){
       		    	return false;
       		    }												       			
       		}       		
		});
	 	
	 	
	 	jQuery("#phone").focus(function(event){
	 		var phone = jQuery.trim(jQuery('#phone').val());
			if(phone == ''){
       			jQuery("#phone").val("(+84)");
       		}
		});
	 	
	 	jQuery("#phone").blur(function(event){
	 		var phone = jQuery.trim(jQuery('#phone').val());
			if(phone == '(+84)'){
       			jQuery("#phone").val('');
       		}
		});
	 	
	
	jQuery("#save").click(function(){	
	    
		if(validateInformationForm()==true){
			
			var cmd =jQuery("input[name='cmd']").val();
			
			var orgName = jQuery('#orgName').val();

			if(cmd=='add'){
				
				var portletActionURL = '<portlet:actionURL windowState="exclusive">
	               	<portlet:param name="struts_action" value="/NewManageOrg/org_manage" ></portlet:param>   
	               	<portlet:param name="action" value="create" ></portlet:param>  
	               	<portlet:param name="userType" value="${userType}" ></portlet:param>  						               
	               	<portlet:param name="cmd" value="add" ></portlet:param>   
	                </portlet:actionURL>';	
	            
                var jQueryform = jQuery("form[name='frmNewManageOrg']");
			  		
			    jQueryform.ajaxSubmit({
			            url: portletActionURL,
			            success: function(data) {
							var params = data.split(';');
							
							if (params[0] == '<%=res.getString("message.action.success")%>') {
								jQuery("#success").css("display", "block"); 
								jQuery("#success span").empty(); 	
								jQuery("<span>${addSuccessMessage}</span>").appendTo(jQuery("#success")); 
								jQuery("#error").css("display", "none");	
								jQuery('#currentOrgName').val(orgName);
								jQuery("#isOrgExisted").text("true");
											
							if (params[1] != null){
								jQuery("#orgId").val(params[1]);
							}
							jQuery("#title-action").text("<%=res.getString("title_edit_org")%>");
							
							} else if (params[0] == '<%=res.getString("message.action.error")%>') {
								jQuery("#success").css("display", "none");
								jQuery("#error").css("display", "block");
								jQuery("#error span").empty();
								jQuery("<span>${addErrorMessage}</span>").appendTo(jQuery("#error"));
							}
			            }
			   });
				
			}else if(cmd=='edit'){
				
				var portletActionURL = '<portlet:actionURL windowState="exclusive">
	               	<portlet:param name="struts_action" value="/NewManageOrg/org_manage" ></portlet:param>   
	               	<portlet:param name="action" value="update" ></portlet:param>  
	               	<portlet:param name="userType" value="${userType}" ></portlet:param>  						               
	               	<portlet:param name="cmd" value="add" ></portlet:param>   
	                </portlet:actionURL>';	
	            
					var jQueryform = jQuery("form[name='frmNewManageOrg']");
			  		
					jQueryform.ajaxSubmit({
			            url: portletActionURL,
			            success: function(data) {
							var params = data.split(';');
							
							if (params[0] == '<%=res.getString("message.action.success")%>') {
								jQuery("#success").css("display", "block");     
								jQuery("#success span").empty(); 		
								jQuery("<span>${repairSuccessMessage}</span>").appendTo(jQuery("#success"));            		
								jQuery("#error").css("display", "none");	
								jQuery('#currentOrgName').val(orgName);
							if (params[1] != null){
								jQuery("#orgId").val(params[1]);
							}	
							
							} else if (params[0] == '<%=res.getString("message.action.error")%>') {
								jQuery("#success").css("display", "none");
								jQuery("#error").css("display", "block");
								jQuery("#error span").empty();								
								jQuery("<span>${repairErrorMessage}</span>").appendTo(jQuery("#error"));
							}
			            }
				});
			}
		}	
	});	
});	


function check_email(){
	var email = jQuery("#mail").val();
	if( email == ""){
		jQuery("#error_email").css("display","block");
		jQuery("#error_email").html("<span class='error_reemail'>Đây là thông tin bắt buộc.</span>");
		return false;
	}
	else{
		var atpos = email.indexOf("@");
		var stoppos = email.lastIndexOf(".");

		if (atpos == -1 || stoppos == -1){ 
			jQuery("#error_email").css("display","block");
			jQuery("#error_email").html("<span class='error_reemail'>Email không đúng định dạng.</span>");
			return false;
		}
		if (stoppos < atpos){
			jQuery("#error_email").css("display","block");
			jQuery("#error_email").html("<span class='error_reemail'>Email không đúng định dạng.</span>");
			return false;
		}
		if(stoppos - atpos == 1){
			jQuery("#error_email").css("display","block");
			jQuery("#error_email").html("<span class='error_reemail'>Email không đúng định dạng.</span>");
			return false;
		}		
	}
	jQuery("#error_email").css("display","none");
	return true;
}
	/*
	 * Check check orgName exist in listOrg
	 */
	function checkOrgExist() {
		var orgName = jQuery('#orgName').val();
		var currentOrgName = jQuery('#currentOrgName').val();
		
		var cmd =jQuery("input[name='cmd']").val();
		
		if(cmd=='add'){
			if(orgName!=''){
			   if(orgName==currentOrgName && currentOrgName != null ){
				jQuery("#isOrgExisted").text("true");
				jQuery("#error").css("display", "block");
				jQuery("#checkOrgName").css("display","block");
				jQuery("#checkOrgName").html("<span class='new-manage-org-error'><%=res.getString("message.exist.orgName")%></span>");
			   }else{
			 
		        	jQuery.ajax({
		    			type:"POST",
		    			data:"orgName="+jQuery('#orgName').val(),
		    			url:"/ProGate-portlet/servlet/ValidateOrgServlet",
		    			success: function(data){	
		    				if(data == "inValid"){
		    					jQuery("#isOrgExisted").text("true");
		    					jQuery("#error").css("display", "block");
		    					jQuery("#success").css("display", "none");
		    					jQuery("#checkOrgName").css("display","block");
		    					jQuery("#checkOrgName").html("<span class='new-manage-org-error'><%=res.getString("message.exist.orgName")%></span>");
		    					
		    				}else {
		    					jQuery("#error").css("display", "none");
		    					jQuery("#success").css("display", "none");
		    					jQuery("#isOrgExisted").text("false");
		    					jQuery("#checkOrgName").css("display","none");
		    					
		    				}
		    			}
		    		});	
		        }
			 }  		
		}else if(cmd='edit'){
			if(orgName!=''){
			if(orgName==currentOrgName && currentOrgName != null){
				jQuery("#isOrgExisted").text("false");
				jQuery("#checkOrgName").css("display","none");
			}else{
				
		        	jQuery.ajax({
		    			type:"POST",
		    			data:"orgName="+jQuery('#orgName').val(),
		    			url:"/ProGate-portlet/servlet/ValidateOrgServlet",
		    			success: function(data){	
		    				if(data == "inValid"){
		    					jQuery("#error").css("display", "block");
		    					jQuery("#isOrgExisted").text("true");
		    					jQuery("#checkOrgName").css("display","block");
		    					jQuery("#checkOrgName").html("<span class='new-manage-org-error'><%=res.getString("message.exist.orgName")%></span>");
		    				}else {
		    					jQuery("#isOrgExisted").text("false");
		    					jQuery("#checkOrgName").css("display","none");
		    					jQuery("#error").css("display", "none");
		    					jQuery('#currentOrgName').val(orgName);
		    				}
		    			}
		    		});	
		        }
				
			}
		}
	}

/*
 * Check Exist OrgName
 */
function checkExistOrgName(){
	var orgName = jQuery.trim(jQuery('#orgName').val());
	var oldOrgName = jQuery.trim(jQuery('#oldOrgName').val());
	
	if (validOrgName()) {
		if (orgName != oldOrgName) {
			var active_url = '<portlet:actionURL windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">  						
		  						<portlet:param name="struts_action" value="/NewManageOrg/org_manage" />
		  					</portlet:actionURL>';
			jQuery.post(active_url,{"validateName": orgName, "action": "validateOrgName"}, function(data){
				var params = data.split(';');
				if (params[0] == '<%=res.getString("message.action.success")%>') {	
					jQuery("#checkOrgName").removeClass('myclass');	
					var checkName = jQuery.trim(jQuery("#checkOrgName").text());
					if (checkName == '<%=res.getString("message.hint.orgName")%>'){
						jQuery("#checkOrgName").css("display", "none");
					}			
	        	} else if (params[0] == '<%=res.getString("message.action.error")%>') {    
					jQuery("#checkOrgName").addClass('myclass');	
	        	}
		    });
		}
	}
}


/*
 * Check Expired Date
 */
function checkExpiredDate(value){
	   // Validate expired date
		var now = new Date();		
		var divdate = new Date();
		/* split the text date in the div */
		var dateparts = value.split('/'); // Format date should be dd/mm/yyy
		
		divdate.setFullYear(parseInt(dateparts[2]), parseInt(dateparts[1])-1, parseInt(dateparts[0]));
		/* compare dates - 14 days = (14*24*60*60*1000) milliseconds */
		if (divdate < now) {					
			valid_expired_date = false;
		} else {			
			valid_expired_date = true;	
		}
		// End Validate expired date
	return 	valid_expired_date;
}


/*
	check special characters
*/
function validText(value) {
	var chaos = new Array ("'","~","#","$","%","^","*",";","/","\\","|", "[","]", "{", "}", "?", "<", ">", "`","!");
	var c = -1;
	for (var i =0; i< chaos.length; i++) {
	  c = value.indexOf(chaos[i]);
	  if (c > -1){
	    break;
	  }
	}
	if (c > -1){
	  return false;		
	}
	return true;
}


/*
 * Check address
 */ 
function checkAddress(data) {
	var iChars = "!@#$%^*+=[]\\\';{}|\":<>?~_`";
	   for (var i = 0; i < data.length; i++) {
	  	if (iChars.indexOf(data.charAt(i)) != -1) {
	  	  //alert ("Your string has special characters. \nThese are not allowed.");
	  	return false;
	  	}
	  }
	return true;   
}

/*
 * IsNumeric
 */ 
function IsNumeric(sText){
   var ValidChars = "0123456789";
   var IsNumber=true;
   var Char;
 
   for (i = 0; i < sText.length && IsNumber == true; i++){ 
      Char = sText.charAt(i); 
      if (ValidChars.indexOf(Char) == -1) 
         {
         IsNumber = false;
         }
   }
   return IsNumber;
}

/*	
 * Function to check if this is number key
 */
function AcceptDigits(objtextbox)
{
	var exp = /[^\d]/g;
	objtextbox.value = objtextbox.value.replace(exp,'');
}

/*	
 * Function to check if this is number key
 */
function AcceptPhone(objtextbox)
{
   var ValidPhone = "0123456789()+-. ";
   var IsPhone=true;
   var Char;
 
   for (j = 0; j < objtextbox.length && IsPhone == true; j++){ 
      Char = objtextbox.charAt(j); 
      if (ValidPhone.indexOf(Char) == -1) 
         {
         	IsPhone = false;
         }
   }
   return IsPhone;
}

function extractAlpha(str)
{
	str.value =  str.value.replace(/[^0-9()+-.\s+]/,'');
}


function checkOrgName(){
	var orgName = jQuery.trim(jQuery('#orgName').val());
	if (orgName == ''){
		
		jQuery("#checkOrgName").css("display","block");
		jQuery("#checkOrgName").html("<span class='new-manage-org-error'><%=res.getString("message.blank.orgName")%></span>");
	}else if (orgName.length<2 || orgName.length>255){
		
		jQuery("#checkOrgName").css("display","block");
		jQuery("#checkOrgName").html("<span class='new-manage-org-error'><%=res.getString("message.hint.orgName")%></span>");
	}else if (validText(orgName)==false){
		
		jQuery("#checkOrgName").css("display","block");
		jQuery("#checkOrgName").html("<span class='new-manage-org-error'><%=res
					.getString("message_require_name_no_special_characters")%></span>");
	}
}

function checkOrgType(){
	var orgType = jQuery.trim(jQuery('#orgType').val());
	if(orgType == '<%=res.getString("select")%>'){
	
		jQuery("#checkOrgType").css("display","block");
		jQuery("#checkOrgType").html("<span class='new-manage-org-error'><%=res.getString("message.blank.orgType")%></span>");
	}else{
		jQuery("#checkOrgType").css("display","none");
	}
}

function checkCity(){
	var city = jQuery.trim(jQuery('#city').val());
	if(city == '<%=res.getString("select")%>'){
		
		jQuery("#checkCity").css("display","block");
		jQuery("#checkCity").html("<span class='new-manage-org-error'><%=res.getString("message.blank.city")%></span>");
	}else{
		jQuery("#checkCity").css("display","none");
	}
	
}

function checkEmail(){
	var email = jQuery.trim(jQuery('#email').val());
	if(email == ''){
		jQuery("#checkEmail").css("display","block");
		jQuery("#checkEmail").html("<span class='new-manage-org-error'><%=res.getString("message.blank.email")%></span>");
	}else{
		jQuery("#checkEmail").css("display","none");
	}
	
}

function checkPhone(){
	var phone = jQuery.trim(jQuery('#phone').val());
	if(phone == ''){
		jQuery("#checkPhone").css("display","none");
	}else if (phone.length > 20){
		
		jQuery("#checkPhone").css("display","block");
		jQuery("#checkPhone").html("<span class='new-manage-org-error'><%=res.getString("message.hint.phone")%></span>");
	}else{
		jQuery("#checkPhone").css("display","none");
	}			
	
}

function checkAddress(){
	var address = jQuery.trim(jQuery('#address').val());
	if(address == ''){
		jQuery("#checkAddress").css("display","none");
	}else if (address.length < 2 || address.length > 255){
		
		jQuery("#checkAddress").css("display","block");
		jQuery("#checkAddress").html("<span class='new-manage-org-error'><%=res.getString("message.hint.address")%></span>");
	}else if (checkAddress(address)==false){
		
		jQuery("#checkAddress").css("display","block");
		jQuery("#checkAddress").html("<span class='new-manage-org-error'><%=res
					.getString("message_require_address_no_special_characters")%></span>");
	}else{
		jQuery("#checkAddress").css("display","none");
	}
}

function checkDescription(){
	var description = jQuery.trim(window.descriptionEditor.getHTML());
	document.frmNewManageOrg.description.value = description;
	if(description == ''){
		
		jQuery("#checkDescription").css("display","block");
		jQuery("#checkDescription").html("<span class='new-manage-org-error'><%=res.getString("message.blank.description")%></span>");
	}else{
		jQuery("#checkDescription").css("display","none");
	}	
}

function checkOrgSize(){
	var orgSize = jQuery.trim(jQuery('#orgSize').val());
	if(orgSize == ''){
		
		jQuery("#checkOrgSize").css("display","block");
		jQuery("#checkOrgSize").html("<span class='new-manage-org-error'><%=res.getString("message.blank.orgSize")%></span>");
	}else if (IsNumeric(orgSize)==false){
		
		jQuery("#checkOrgSize").css("display","block");
		jQuery("#checkOrgSize").html("<span class='new-manage-org-error'><%=res.getString("message.number")%></span>");
	}else{									
		jQuery("#checkOrgSize").css("display","none");
	}	
}

function checkExpiredDate(){
	
	var expiredDate = jQuery.trim(jQuery('#expiredDate').val());
	if(expiredDate == ''){
		
		jQuery("#checkExpriredDate").css("display","block");
		jQuery("#checkExpriredDate").html("<span class='new-manage-org-error'><%=res.getString("message.blank.expriredDate")%></span>");
	}else if (checkExpiredDate(expiredDate)==false){
		
		jQuery("#checkExpiredDate").css("display","block");
		jQuery("#checkExpiredDate").html("<span class='new-manage-org-error'><%=res.getString("message.future.expriredDate")%></span>");
	}else{
		jQuery("#checkExpiredDate").css("display","none");
	}
}


</script>