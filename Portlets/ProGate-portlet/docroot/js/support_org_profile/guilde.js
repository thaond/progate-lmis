jQuery(document).ready(function(){	
		jQuery('#themhuongdan').click(function(){			
			var flag = validateGuildeForm();			
			if (flag){
			  submitForm(document.addGuilde);	
			}else{
			  return false;		  	
			}		
		});	
	});
   
  
   
function validateGuildeForm(){	  
   var validate = true;
   var titleGuilde = jQuery('#titleGuilde').val();	  
   
   jQuery('#contentGuilde').val(jQuery.trim(window.contentGuildeEditor.getHTML()));
   var contentGuilde =  jQuery('#contentGuilde').val();
   
   if(contentGuilde == ''){
		validate = false;
		jQuery("#checkContentGuilde").css("display","block");
		jQuery("#checkContentGuilde").html("<span class='error'>Bạn chưa nhập nội dung</span>");
	}else{
		jQuery("#checkContentGuilde").css("display","none");
	}	 
	   
	if(titleGuilde == ''){
		 validate = false;
		 jQuery("#checkTitleGuilde").css("display","block");
		 jQuery("#checkTitleGuilde").html("<span class='error'>Bạn chưa nhập tiêu đề</span>");
	}else{
		 jQuery("#checkTitleGuilde").css("display","none");
	}	
	
	if (validate == false){
		jQuery("#error").css("display","block");	
		jQuery("#success").css("display","none");	
	}
    return validate;										
}
	
						
							
						
							
