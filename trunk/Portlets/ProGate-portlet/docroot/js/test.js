function validateInformationForm(){
	var validate = true;								
	var orgFounded = jQuery('#f_date1').val();
	var orgType = jQuery('#orgType').val();
	var orgSize = jQuery('#orgSize').val();
	var founder = jQuery('#founder').val();
	var website = jQuery('#website').val();
//	var email = jQuery('#email').val();
	var city = jQuery('#city').val();
	var address = jQuery('#address').val();
	var phone = jQuery('#phone').val();
	
	if(orgFounded == ''){
		validate = false;
		jQuery("#checkEstablishDate").css("display","block");
		jQuery("#checkEstablishDate").html("<span class='error'><%=res.getString("error.blank.orgFounded")%></span>");
	}else if (!checkDate(orgFounded)){
		//checkDate
		validate = false;
		jQuery("#checkEstablishDate").css("display","block");
		jQuery("#checkEstablishDate").html("<span class='error'><%=res.getString("error.future.orgFounded")%></span>");
	}else{
		jQuery("#checkEstablishDate").css("display","none");
	}	
			
	if(orgType == '<%=res.getString("blank.field")%>'){
		validate = false;
		jQuery("#checkOrgType").css("display","block");
		jQuery("#checkOrgType").html("<span class='error'><%=res.getString("error.blank.orgType")%></span>");
	}else{
		jQuery("#checkOrgType").css("display","none");
	}
			
	if(orgSize == ''){
		validate = false;
		jQuery("#checkOrgSize").css("display","block");
		jQuery("#checkOrgSize").html("<span class='error'><%=res.getString("error.blank.orgSize")%></span>");
	}else if (!IsNumeric(orgSize)){
		validate = false;
		jQuery("#checkOrgSize").css("display","block");
		jQuery("#checkOrgSize").html("<span class='error'><%=res.getString("error.number.orgSize")%></span>");
	}else{									
		jQuery("#checkOrgSize").css("display","none");
	}
	
	if(founder == ''){
		validate = false;
		jQuery("#checkFounder").css("display","block");
		jQuery("#checkFounder").html("<span class='error'><%=res.getString("error.blank.founder")%></span>");
	}else if (!validText(founder)){
		validate = false;
		jQuery("#checkFounder").css("display","block");
		jQuery("#checkFounder").html("<span class='error'><%=res.getString("error.specialCharacter")%></span>");
	}else{
		jQuery("#checkFounder").css("display","none");
	}	
	
	if(website == ''){
		validate = false;
		jQuery("#checkWebsite").css("display","block");
		jQuery("#checkWebsite").html("<span class='error'><%=res.getString("error.blank.website")%></span>");
	}else{
		jQuery("#checkWebsite").css("display","none");
	}	
	
//	if(email == ''){
//		validate = false;
//		jQuery("#checkEmail").css("display","block");
//		jQuery("#checkEmail").html("<span class='error'><%=res.getString("error.blank.email")%></span>");
//	}else{
//		jQuery("#checkEmail").css("display","none");
//	}	
	
	if(city == '<%=res.getString("blank.field")%>'){
		validate = false;
		jQuery("#checkCity").css("display","block");
		jQuery("#checkCity").html("<span class='error'><%=res.getString("error.blank.city")%></span>");
	}else{
		jQuery("#checkCity").css("display","none");
	}
	
	if(phone == ''){
		validate = false;
		jQuery("#checkPhone").css("display","block");
		jQuery("#checkPhone").html("<span class='error'><%=res.getString("error.blank.phone")%></span>");
	}else{
		jQuery("#checkPhone").css("display","none");
	}	
	
	if(address == ''){
		validate = false;
		jQuery("#checkAddress").css("display","block");
		jQuery("#checkAddress").html("<span class='error'><%=res.getString("error.blank.address")%></span>");
	}else if (!checkAddress(address)){
		validate = false;
		jQuery("#checkAddress").css("display","block");
		jQuery("#checkAddress").html("<span class='error'><%=res.getString("error.specialCharacter")%></span>");
	}else{
		jQuery("#checkAddress").css("display","none");
	}	
	
	if (validate == false){
		jQuery("#success").css("display", "none");
		jQuery("#error").css("display", "block");
	}
	return validate;								
}

jQuery(document).ready(function(){	
	jQuery('#save_information').click(function(){		
		var flag = validateInformationForm();
		if(flag){						
			submitForm(document.informationOrg);	
		}else{					
			return false;
		}
	});	
});

/*
	validate website address 
*/	

function ValidateWebAddress(incomingString)
{
    var companyUrl = incomingString; 
    var RegExp = /^(([\w]+:)?\/\/)?(([\d\w]|%[a-fA-f\d]{2,2})+(:([\d\w]|%[a-fA-f\d]{2,2})+)?@)?([\d\w][-\d\w]{0,253}[\d\w]\.)+[\w]{2,4}(:[\d]+)?(\/([-+_~.\d\w]|%[a-fA-f\d]{2,2})*)*(\?(&?([-+_~.\d\w]|%[a-fA-f\d]{2,2})=?)*)?(#([-+_~.\d\w]|%[a-fA-f\d]{2,2})*)?$/; 
    if(RegExp.test(companyUrl))
    { 
        return true;
    }
    else
    { 
        return false;
    } 	
} 

					
function isURL(urlStr) {
	if (urlStr.indexOf(" ") != -1) {
		alert("Spaces are not allowed in a URL");
		return false;
	}
	
	if (urlStr == "" || urlStr == null) {
		return true;
	}
	
	urlStr=urlStr.toLowerCase();
	
	var specialChars="\\(\\)><@,;:\\\\\\\"\\.\\[\\]";
	var validChars="\[^\\s" + specialChars + "\]";
	var atom=validChars + '+';
	var urlPat=/^http:\/\/(\w*)\.([\-\+a-z0-9]*)\.(\w*)/;
	var matchArray=urlStr.match(urlPat);
	
	if (matchArray==null) {
		//alert("The URL seems incorrect \ncheck it begins with http://\n and it has 2 .'s");
		return false;
	}
	
	var user=matchArray[2];
	var domain=matchArray[3];
	
	for (i=0; i<user.length; i++) {
		if (user.charCodeAt(i)>127) {
			//alert("This domain contains invalid characters.");
			return false;
		}
	}
	
	for (i=0; i<domain.length; i++) {
		if (domain.charCodeAt(i) > 127) {
			//alert("This domain name contains invalid characters.");
			return false;
		}
	}
	
	var atomPat=new RegExp("^" + atom + "$");
	var domArr=domain.split(".");
	var len=domArr.length;
	
	for (i=0;i<len;i++) {
		if (domArr[i].search(atomPat) == -1) {
			//alert("The domain name does not seem to be valid.");
			return false;
		}
	}
	
	return true;
} 
/*
	checkDate
*/
function checkDate(birthday){
	var currentTime = new Date();
	var month1 = currentTime.getMonth();
	var day1 = currentTime.getDate();
	var year1 = currentTime.getFullYear();
	var now = new Date(year1, month1, day1);
	if (birthday != ""){
		var birthday_arr = birthday.split("/");
		var day2 = birthday_arr[0];
		var month2 = birthday_arr[1];
		var year2 = birthday_arr[2];
		var my_birthday = new Date(year2, month2 -1, day2);
		var DaysDiff = Math.floor((now.getTime() - my_birthday.getTime())/(1000*60*60*24));
		if(DaysDiff > 0){
			return true;
		}else{
			return false;
		}
	}
	return false;
}	
/*
	check special characters
*/
function validText(value) {
	var chaos = new Array ("'","~","@","#","$","%","^","&","*",";","/","\\","|", "(" , ")", "[","]", "{", "}", "?", "<", ">", ".", "`");
	var c = -1;
	for (var i =0; i< chaos.length; i++) {
	  c = value.lastIndexOf(chaos[i]);
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
	
*/
 function keyPress(e){
    if (e.which == 13){	
        e.returnValue = false;	
        document.SignUpFm.submit();	
    }		
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
function IsNumeric(sText)

{
   var ValidChars = "0123456789";
   var IsNumber=true;
   var Char;

 
   for (i = 0; i < sText.length && IsNumber == true; i++) 
      { 
      Char = sText.charAt(i); 
      if (ValidChars.indexOf(Char) == -1) 
         {
         IsNumber = false;
         }
      }
   return IsNumber;
}

	