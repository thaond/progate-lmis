	
	function validateForm(){
	        
	        jQuery("#hint_firstname").css("display", "none");
	        jQuery("#hint_lastname").css("display", "none");
	        jQuery("#hint_username").css("display", "none");
	        jQuery("#hint_password").css("display", "none");
	        jQuery("#hint_repassword").css("display", "none");
	        jQuery("#hint_email").css("display", "none");
	
		    var flag = true;
		
			if (document.SignUpFm.checkAgree.checked == false){
			    jQuery("#error_condition").css("display","block");
				jQuery("#error_condition").html("<span class='check_error'>Bạn cần chấp nhận Các Điều Khoản Thỏa Thuận Về Sử Dụng Dịch Vụ.</span>");
				flag = false;				
			}else{
				 jQuery("#error_condition").css("display","none");
			}
		
			var firstname = jQuery('#firstname').val();
			var lastname = jQuery('#lastname').val();
			var username = jQuery('#username').val();
			
			var email = jQuery('#email').val();
			var password = jQuery('#password').val();
			var repassword = jQuery('#repassword').val();
			
			var birthday = jQuery('#birthday').val();
		   
			var match = new RegExp("^[a-zA-Z0-9]+$");
			var chara_match = new RegExp("^[a-zA-Z]+$");
								
						
			if(firstname == ''){		
				jQuery("#check_firstname").css("display","none");		
				jQuery("#error_firstname").css("display","block");
				jQuery("#error_firstname").html("<span class='error_message'>Đây là thông tin bắt buộc.</span>");
				flag = false;
			}else if (!validText(firstname)){
				jQuery("#check_firstname").css("display","none");	
				jQuery("#error_firstname").css("display","block");
				jQuery("#error_firstname").html("<span class='error_message_2'>Họ không chứa ký tự đặc biệt, không quá 20 ký tự.</span>");
				flag = false;
			}else if (firstname.length > 20){
				jQuery("#check_firstname").css("display","none");	
				jQuery("#error_firstname").css("display","block");
				jQuery("#error_firstname").html("<span class='error_message_2'>Họ không chứa ký tự đặc biệt, không quá 20 ký tự.</span>");
				flag = false;
			}else{
				jQuery("#check_firstname").css("display","none");	
				jQuery("#error_firstname").css("display","none");
			}
					
			if(lastname == ''){
				jQuery("#check_lastname").css("display","none");
				jQuery("#error_lastname").css("display","block");
				jQuery("#error_lastname").html("<span class='error_message'>Đây là thông tin bắt buộc.</span>");
				flag = false;
			}else if (!validText(lastname)){
				jQuery("#check_lastname").css("display","none");
				jQuery("#error_lastname").css("display","block");
				jQuery("#error_lastname").html("<span class='error_message_2'>Tên không chứa ký tự đặc biệt, không quá 20 ký tự.</span>");
				flag = false;
			}else if (lastname.length > 20){
				jQuery("#check_lastname").css("display","none");
				jQuery("#error_lastname").css("display","block");
				jQuery("#error_lastname").html("<span class='error_message_2'>Tên không chứa ký tự đặc biệt, không quá 20 ký tự.</span>");
				flag = false;
			}else{
				jQuery("#check_lastname").css("display","none");
				jQuery("#error_lastname").css("display","none");
			}
					
			if(username == ''){
				jQuery("#check_username").css("display","none");
				jQuery("#error_username").css("display","block");
				jQuery("#error_username").html("<span class='error_message'>Đây là thông tin bắt buộc.</span>");
				flag = false;
			}else if (username.length > 20){
				jQuery("#check_username").css("display","none");
				jQuery("#error_username").css("display","block");
				jQuery("#error_username").html("<span class='error_message'>Tên đăng nhập không chứa ký tự đặc biệt, không quá 20 ký tự.</span>");
				flag = false;
			}else{
				var check_username = jQuery("#check_username").text();
				
				if (check_username != ''){				
					jQuery("#check_username").css("display","none");
					jQuery("#error_username").css("display","block");
					jQuery("#error_username").html("<span class='error_message_3'>" + jQuery("#check_username").text() + "</span>");			
					flag = false;
				}else{
					jQuery("#check_username").css("display","none");
					jQuery("#error_username").css("display","none");
				}
			}
						
		    if (!validText(username)){
		    	jQuery("#check_username").css("display","none");
		    	jQuery("#error_username").css("display","block");
				jQuery("#error_username").html("<span class='error_message_2'>Tên đăng nhập không chứa ký tự đặc biệt, không quá 20 ký tự.</span>");
				flag = false;
		    }
		    if (password == ''){
		    	jQuery("#check_password").css("display","none");
				jQuery("#error_password").css("display","block");
				jQuery("#error_password").html("<span class='error_message'>Đây là thông tin bắt buộc.</span>");
				flag = false;
			}else if (password.length < 6){
				jQuery("#check_password").css("display","none");
				jQuery("#error_password").css("display","block");
				jQuery("#error_password").html("<span class='error_message_2'>Mật khẩu phải dài từ 6 đến 32 ký tự.</span>");
				flag = false;
			}else if (password.length > 32){
				jQuery("#check_password").css("display","none");
				jQuery("#error_password").css("display","block");
				jQuery("#error_password").html("<span class='error_message_2'>Mật khẩu phải dài từ 6 đến 32 ký tự.</span>");
				flag = false;
			}else{
				jQuery("#check_password").css("display","none");
				jQuery("#error_password").css("display","none");
			}
			
			if (repassword == ''){
				jQuery("#check_repassword").css("display","none");
				jQuery("#error_repassword").css("display","block");
				jQuery("#error_repassword").html("<span class='error_message'>Đây là thông tin bắt buộc.</span>");
				flag = false;
			}else if (repassword != password){
				jQuery("#check_repassword").css("display","none");
				jQuery("#error_repassword").css("display","block");
				jQuery("#error_repassword").html("<span class='error_message'>Các mật khẩu không khớp.</span>");
				flag = false;
			}else{
				jQuery("#check_repassword").css("display","none");
				jQuery("#error_repassword").css("display","none");
			}
			
			if (email == ''){
				jQuery("#error_email").css("display","block");
				jQuery("#error_email").html("<span class='error_message'>Đây là thông tin bắt buộc.</span>");
				flag = false;
			}else if (!checkEmail(email)){
				jQuery("#check_email").css("display","none");
				jQuery("#error_email").css("display","block");
				jQuery("#error_email").html("<span class='error_message'>Email không đúng định dạng.</span>");	
				flag = false;
			}else {
				var check_email = jQuery("#check_email").text();
				if (check_email != ''){	
					jQuery("#check_email").css("display","none");
					jQuery("#error_email").css("display","block");
					jQuery("#error_email").html("<span class='error_message'>" + jQuery("#check_email").text() + "</span>");				
					flag = false;
				}else{
					jQuery("#error_email").css("display","none");
				}
			}
			
			if (birthday.length == ''){
				jQuery("#check_birthday").css("display","none");
				jQuery("#error_birthday").css("display","block");
				jQuery("#error_birthday").html("<span class='error_message'>Phải chọn ngày sinh.</span>");
				flag = false;
			}else{	
				if (checkDate(birthday)){
					jQuery("#check_birthday").css("display","none");			
					jQuery("#error_birthday").css("display","none");
				}else{
					jQuery("#check_birthday").css("display","none");
					jQuery("#error_birthday").css("display","block");
					jQuery("#error_birthday").html("<span class='error_message_2'>Phải chọn ngày sinh <span style='padding-right:10px;'>trong quá khứ.</span></span>");
					flag = false;
				}
			}
			return flag;
	}
	
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
	
	
	function checkEmail(email){
			var atpos = email.indexOf("@");
			var stoppos = email.lastIndexOf(".");
			
			if (atpos == -1 || stoppos == -1){				
				return false;
			}
			if (stoppos < atpos){				
				return false;
			}
			if(stoppos - atpos == 1){				
				return false;
			}
			var emailexpress = new RegExp("^[a-zA-Z][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$", "g");
			if(!emailexpress.test(email)){
				return false;
			}
			return true;
	}	
	
	function setCheckedRadio(val){
		var radioButtons = document.getElementsByName("sex");
		for (var x = 0; x < radioButtons.length; x++){
			if(radioButtons[x].value == val){
				radioButtons[x].checked = true;
			}
		}
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
	
	// for key up password
	    jQuery('#password').keyup(function() {
	       // var password = jQuery('#password').val();	
	        jQuery("#hint_password").css("display","block");
			var input = jQuery('#password').val();
			var strongRegex = new RegExp("^(?=.*[^a-zA-Z0-9_])(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).*$", "g");
			var mediumRegex = new RegExp("^(((?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]))|((?=.*[A-Z])(?=.*[a-z])(?=.*[^a-zA-Z0-9_]))|((?=.*[a-z])(?=.*[0-9])(?=.*[^a-zA-Z0-9_]))|((?=.*[A-Z])(?=.*[0-9])(?=.*[^a-zA-Z0-9_]))).*$", "g");
			var enoughRegex = new RegExp("^(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[^a-zA-Z0-9_]))|((?=.*[A-Z])(?=.*[^a-zA-Z0-9_]))|((?=.*[0-9])(?=.*[^a-zA-Z0-9_]))).*", "g");
			if (strongRegex.test(input)){
					jQuery('#weak1').css("background-color","lightgreen");
					jQuery('#weak2').css("background-color","lightgreen");
					jQuery('#medium').css("background-color","lightgreen");
					jQuery('#strong').css("background-color","lightgreen");
					jQuery('#password_level').text("Độ bảo mật của mật khẩu: Mạnh");
			}else{
				if(mediumRegex.test(input)){
					jQuery('#weak1').css("background-color","lightgreen");
					jQuery('#weak2').css("background-color","lightgreen");
					jQuery('#medium').css("background-color","lightgreen");
					jQuery('#strong').css("background-color","white");
					jQuery('#password_level').text("Độ bảo mật của mật khẩu: Trung Bình");
				}else{
					if (enoughRegex.test(input)){
						jQuery('#weak1').css("background-color","lightgreen");
						jQuery('#weak2').css("background-color","lightgreen");
						jQuery('#medium').css("background-color","white");
						jQuery('#strong').css("background-color","white");
						jQuery('#password_level').text("Độ bảo mật của mật khẩu: Yếu");
						}
					else{
						jQuery('#weak1').css("background-color","lightgreen");
						jQuery('#weak2').css("background-color","white");
						jQuery('#medium').css("background-color","white");
						jQuery('#strong').css("background-color","white");
						jQuery('#password_level').text("Độ bảo mật của mật khẩu: Yếu");
					}
				}
			}
	
			if(input == ""){
				jQuery('#weak1').css("background-color","white");
				jQuery('#weak2').css("background-color","white");
				jQuery('#medium').css("background-color","white");
				jQuery('#strong').css("background-color","white");	
			}				    				
	 });
	
	jQuery('#firstname').focus(function () {	
			jQuery("#error_firstname").css("display", "none");					
         	jQuery("#hint_firstname").css("display","block");
			jQuery("#hint_firstname").html("<img src='/SignUp-5.2.3.1/images/info.gif' class='hint_image_length' width='15px' height='15px'><span class='hint_message_length'>Họ không được chứa ký tự đặc biệt, không quá 20 ký tự.</span>");
	});
		
	jQuery('#firstname').blur(function () {
		jQuery("#hint_firstname").css("display","none");		
		var firstname = jQuery('#firstname').val();
		if (firstname.length > 20){
			jQuery("#check_firstname").css("display","block");
			jQuery("#check_firstname").html("<span class='check_error'>Họ không chứa ký tự đặc biệt, không quá 20 ký tự .</span>");			
		}else if (!validText(firstname)){
		    jQuery("#check_firstname").css("display","block");
			jQuery("#check_firstname").html("<span class='check_error'>Họ không chứa ký tự đặc biệt, không quá 20 ký tự </span>");
		}else{
			jQuery("#check_firstname").css("display","none");
		}
	});
		
	jQuery("#username").focus(function(){
		jQuery("#error_username").css("display", "none");
		jQuery("#check_username").css("display","none");
		jQuery("#hint_username").css("display", "block");
		jQuery("#hint_username").html("<img src='/SignUp-5.2.3.1/images/info.gif' class='hint_image_length'  width='15px' height='15px'><span class='hint_message_length'>Tên đăng nhập không chứa ký tự đặc biệt, không quá 20 ký tự.</span>");
	});
	
	jQuery("#username").blur(function(){
		jQuery("#hint_username").css("display", "none");
	});
	
	jQuery('#password').focus(function(){
		jQuery("#error_password").css("display", "none");
		jQuery("#hint_password").css("display", "block");
		jQuery("#hint_password").html("<img src='/SignUp-5.2.3.1/images/info.gif' class='hint_image_length' width='15px' height='15px'><span class='hint_message_length'>Mật khẩu phải dài từ 6 đến 32 <span style='padding-right:8px;'>ký tự</span> </span>");
	});
	
	jQuery('#password').blur(function(){
		jQuery("#hint_password").css("display", "none");	
		var password = jQuery('#password').val();
		if (password.length > 0 && password.length < 6){
				jQuery("#check_password").css("display","block");
				jQuery("#check_password").html("<span class='check_error'>Mật khẩu phải dài từ 6 đến 32 ký tự.</span>");
				flag = false;
			}else if (password.length > 32){
				jQuery("#check_password").css("display","block");
				jQuery("#check_password").html("<span class='check_error'>Mật khẩu phải dài từ 6 đến 32 ký tự.</span>");
				flag = false;
			}else{
				jQuery("#check_password").css("display","none");
			}	
	});
	
	jQuery("#repassword").focus(function(){
		jQuery("#error_repassword").css("display", "none");
		jQuery("#hint_repassword").css("display", "block");
		var check_repassword = jQuery("#check_repassword").text();
		if (check_repassword == ''){
			jQuery("#hint_repassword").html("<img src='/SignUp-5.2.3.1/images/info.gif' class='hint_image' width='15px' height='15px'><span class='hint_message' >Mật khẩu 2 lần phải giống nhau</span>");
		}else{
			jQuery("#hint_repassword").html("<img src='/SignUp-5.2.3.1/images/info.gif' class='hint_image'' width='15px' height='15px'><span class='hint_message_2' >Mật khẩu 2 lần phải giống nhau</span>");
		}		
	});	
	
	jQuery("#repassword").blur(function (){
		jQuery("#hint_repassword").css("display", "none");
		var password = jQuery('#password').val();
		var repassword = jQuery('#repassword').val();
		if (repassword != password){
			jQuery("#check_repassword").css("display","block");
			jQuery("#check_repassword").html("<span class='check_error'>Các mật khẩu không khớp.</span>");
		}else{
			jQuery("#check_repassword").css("display","none");
		}
	});
		
	jQuery('#email').focus(function(){
		jQuery("#error_email").css("display", "none");
		jQuery("#hint_email").css("display", "block");
		var check_email = jQuery("#check_email").text();
		if (check_email == ''){
			jQuery("#hint_email").html("<img src='/SignUp-5.2.3.1/images/info.gif' class='hint_image' width='15px' height='15px'><span class='hint_message'>Email phải đúng định dạng.</span>");
		}else{
			jQuery("#hint_email").html("<img src='/SignUp-5.2.3.1/images/info.gif' class='hint_image' width='15px' height='15px'><span class='hint_message_email'>Email phải đúng định dạng.</span>");
		}
		
	});
	
	jQuery('#email').blur(function(){	
		jQuery("#hint_email").css("display", "none");
	});
	
	jQuery('#lastname').focus(function(){
		jQuery("#error_lastname").css("display", "none");
		jQuery("#hint_lastname").css("display", "block");
		jQuery("#hint_lastname").html("<img src='/SignUp-5.2.3.1/images/info.gif' class='hint_image_length' width='15px' height='15px'><span class='hint_message_length'>Tên không chứa ký tự đặc biệt, không quá 20 ký tự.</span>");
	});
	
	jQuery('#lastname').blur(function(){
		jQuery("#hint_lastname").css("display", "none");
		var lastname = jQuery('#lastname').val();
		if (lastname.length > 20){
			jQuery("#check_lastname").css("display","block");
			jQuery("#check_lastname").html("<span class='check_error'>Tên không chứa ký tự đặc biệt, không quá 20 ký tự.</span>");			
		}else if (!validText(lastname)){
		    jQuery("#check_lastname").css("display","block");
			jQuery("#check_lastname").html("<span class='check_error'>Tên không chứa ký tự đặc biệt, không quá 20 ký tự. </span>");
		}else{
			jQuery("#check_lastname").css("display","none");
		}
	});
		
	jQuery('#birthday').blur(function(){
		var birthday = jQuery('#birthday').val();
		if (birthday.length == ''){
			jQuery("#check_birthday").css("display","block");
			jQuery("#check_birthday").html("<span class='check_error'>Phải chọn ngày sinh.</span>");
		}else{
			if (checkDate(birthday)){
				jQuery("#check_birthday").css("display","none");
			}else{
				jQuery("#check_birthday").css("display","block");
				jQuery("#check_birthday").html("<span class='check_error'>Phải chọn ngày sinh <span style='padding-right:10px;'>trong quá khứ.</span></span>");
			}
		}
	});	
								
