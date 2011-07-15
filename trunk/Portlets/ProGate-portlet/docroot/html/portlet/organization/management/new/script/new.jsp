 <fmt:message key="add.action" bundle="${msg}" var="add" />
 <fmt:message key="delete.action" bundle="${msg}" var="delete" />
 <fmt:message key="repair.action" bundle="${msg}" var="repair" />
 
<fmt:message key="success.action" bundle="${msg}" var="addSuccessMessage">
    <fmt:param value="${add}"/> 
</fmt:message>
 
 <fmt:message key="success.action" bundle="${msg}" var="repairSuccessMessage">
    <fmt:param value="${repair}"/> 
</fmt:message>

<fmt:message key="success.action" bundle="${msg}" var="deleteSuccessMessage">
    <fmt:param value="${delete}"/> 
</fmt:message>

<fmt:message key="error.action" bundle="${msg}" var="addErrorMessage">
    <fmt:param value="${add}"/> 
</fmt:message>
 
 <fmt:message key="error.action" bundle="${msg}" var="repairErrorMessage">
    <fmt:param value="${repair}"/> 
</fmt:message>

<fmt:message key="error.action" bundle="${msg}" var="deleteErrorMessage">
    <fmt:param value="${delete}"/> 
</fmt:message>

<script type="text/javascript">

var valid_organization_name_exist = true;

function validateInformationForm(){
	var validate = true;
	
	if (!validOrgName()) {
		validate = false;
	}	
	
	if (!validOrgType()){
		validate = false;
	}
	
	if (!validCity()){
		validate = false;
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
	}else if (!checkAddress(address)){
		validate = false;
		jQuery("#checkAddress").css("display","block");
		jQuery("#checkAddress").html("<span class='new-manage-org-error'><%=res.getString("message_require_address_no_special_characters")%></span>");
	}else{
		jQuery("#checkAddress").css("display","none");
	}	
	
	var description = jQuery.trim(jQuery('#description').val());
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
	}else if (!IsNumeric(orgSize)){
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
	}else if (!checkExpiredDate(expiredDate)){
		//checkDate
		validate = false;
		jQuery("#checkExpiredDate").css("display","block");
		jQuery("#checkExpiredDate").html("<span class='new-manage-org-error'><%=res.getString("message.future.expriredDate")%></span>");
	}else{
		jQuery("#checkExpiredDate").css("display","none");
	}	
	
	if (jQuery("#checkOrgName").hasClass('myclass')){
		var oldOrgName = jQuery("#oldOrgName").val();
		if (orgName == oldOrgName){
		}else{
			validate = false;	
			jQuery("#checkOrgName").css("display","block");
			jQuery("#checkOrgName").html("<span class='new-manage-org-error'><%=res.getString("message.hint.orgName")%></span>");
		}		
	}
	
	if (validate == false){
		jQuery("#success").css("display", "none");
		jQuery("#error").css("display", "block");
	}
	return validate;								
}


jQuery(document).ready(function(){	
	jQuery('#themOrg').click(function(){	
		if(validateInformationForm()){
		
			var portletActionURL = '<portlet:actionURL windowState="<%= LiferayWindowState.EXCLUSIVE.toString()%>">
						               	<portlet:param name="struts_action" value="/NewManageOrg/org_manage" />   
						               	<portlet:param name="action" value="create" />  
						               	<portlet:param name="userType" value="${userType}" />  						               
						               	<portlet:param name="cmd" value="add" />   
						            </portlet:actionURL>';	
			document.getElementById("new-manage-org-form").action = portletActionURL;	
			jQuery("#new-manage-org-form").ajaxForm(function(data) { 
				var params = data.split(';');
				if (params[0] == '<%= res.getString("message.action.success") %>') {
            		jQuery("#success").css("display", "block"); 
            		jQuery("<span>${addSuccessMessage}</span>").appendTo(jQuery("#success")); 
					jQuery("#error").css("display", "none");					
					jQuery("#add-action").css("display", "none");
					jQuery("#repair-action").css("display", "block");
					if (params[1] != null){
						jQuery("#orgId").val(params[1]);
					}
					jQuery("#title-action").text("<%=res.getString("title_edit_org")%>");
            	} else if (params[0] == '<%= res.getString("message.action.error") %>') {
            		jQuery("#success").css("display", "none");
					jQuery("#error").css("display", "block");
					jQuery("#error span").empty();
					jQuery("<span>${addErrorMessage}</span>").appendTo(jQuery("#error"));
            	}
			});
		}else{					
			return false;
		}
	});	
	
	jQuery('#suaOrg').click(function(){	
		if(validateInformationForm()){			
			var portletActionURL = '<portlet:actionURL windowState="<%= LiferayWindowState.EXCLUSIVE.toString()%>">
						               	<portlet:param name="struts_action" value="/NewManageOrg/org_manage" />   
						               	<portlet:param name="action" value="update" />
						               	<portlet:param name="userType" value="${userType}" />   
						               	<portlet:param name="cmd" value="add" />    
						            </portlet:actionURL>';	
			document.getElementById("new-manage-org-form").action = portletActionURL;	
			jQuery("#new-manage-org-form").ajaxForm(function(data){
				var params = data.split(';');
				if (params[0] == '<%= res.getString("message.action.success") %>') {
            		jQuery("#success").css("display", "block");     
            		jQuery("#success span").empty(); 		
            		jQuery("<span>${repairSuccessMessage}</span>").appendTo(jQuery("#success"));            		
					jQuery("#error").css("display", "none");					
					if (params[1] != null){
						jQuery("#orgId").val(params[1]);
					}					
            	} else if (params[0] == '<%= res.getString("message.action.error") %>') {
            		jQuery("#success").css("display", "none");
					jQuery("#error").css("display", "block");
					jQuery("#error span").empty();
					jQuery("<span>${repairErrorMessage}</span>").appendTo(jQuery("#error"));
            	}
			});
		}else{					
			return false;
		}
	});		
});

/*
 * Validate Org Name
 */
 function validOrgName(){
		var validate = true;
		var oldOrgName = jQuery.trim(jQuery('#oldOrgName').val());
		var orgName = jQuery.trim(jQuery('#orgName').val());
		
		if (orgName == ''){
			validate = false;
			jQuery("#checkOrgName").css("display","block");
			jQuery("#checkOrgName").html("<span class='new-manage-org-error'><%=res.getString("message.blank.orgName")%></span>");
		}else if (orgName.length<2 || orgName.length>255){
			validate = false;
			jQuery("#checkOrgName").css("display","block");
			jQuery("#checkOrgName").html("<span class='new-manage-org-error'><%=res.getString("message.hint.orgName")%></span>");
		}else if (!validText(orgName)){
			validate = false;
			jQuery("#checkOrgName").css("display","block");
			jQuery("#checkOrgName").html("<span class='new-manage-org-error'><%=res
						.getString("message_require_name_no_special_characters")%></span>");
		}else{
			if(oldOrgName == null){
				checkOrgExist();
				if(!valid_organization_name_exist){
					validate = false;
					jQuery("#checkOrgName").css("display","block");
					jQuery("#checkOrgName").html("<span class='new-manage-org-error'><%=res.getString("message.exist.orgName")%></span>");
				}else {
		          	jQuery("#checkOrgName").css("display","none");
				}
			}
			else if (oldOrgName != orgName){
				checkOrgExist();
				if(!valid_organization_name_exist){
					validate = false;
					jQuery("#checkOrgName").css("display","block");
					jQuery("#checkOrgName").html("<span class='new-manage-org-error'><%=res.getString("message.exist.orgName")%></span>");
				}else {
		          	jQuery("#checkOrgName").css("display","none");
				}
			}
			else {
				jQuery("#checkOrgName").css("display","none");
			}
		}
		
		return validate;
	}

	/*
	 * Check check orgName exist in listOrg
	 */
	function checkOrgExist() {
		jQuery.ajax({
			type:"POST",
			data:"orgName="+jQuery('#orgName').val(),
			url:"/ProGate-portlet/servlet/ValidateOrgServlet",
			success: function(data){	
				if(data == "inValid"){
					valid_organization_name_exist = false;
				}else {
					valid_organization_name_exist = true;
				}
			}
		});
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
				if (params[0] == '<%= res.getString("message.action.success") %>') {	
					jQuery("#checkOrgName").removeClass('myclass');	
					var checkName = jQuery.trim(jQuery("#checkOrgName").text());
					if (checkName == '<%=res.getString("message.hint.orgName")%>'){
						jQuery("#checkOrgName").css("display", "none");
					}			
	        	} else if (params[0] == '<%= res.getString("message.action.error") %>') {    
					jQuery("#checkOrgName").addClass('myclass');	
	        	}
		    });
		}
	}
}

/*
 * Validate Org Type
 */
function validOrgType(){
	var validate = true;
	
	var orgType = jQuery.trim(jQuery('#orgType').val());
	if(orgType == '<%=res.getString("select")%>'){
		validate = false;
		jQuery("#checkOrgType").css("display","block");
		jQuery("#checkOrgType").html("<span class='new-manage-org-error'><%=res.getString("message.blank.orgType")%></span>");
	}else{
		jQuery("#checkOrgType").css("display","none");
	}
	
	return validate;
}

/*
 * Validate City
 */
function validCity(){
	var validate = true;
	
	var city = jQuery.trim(jQuery('#city').val());
	if(city == '<%=res.getString("select")%>'){
		validate = false;
		jQuery("#checkCity").css("display","block");
		jQuery("#checkCity").html("<span class='new-manage-org-error'><%=res.getString("message.blank.city")%></span>");
	}else{
		jQuery("#checkCity").css("display","none");
	}
	
	return validate;
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

</script>