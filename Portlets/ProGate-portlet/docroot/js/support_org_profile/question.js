jQuery(document).ready(function(){	
		jQuery('#themcauhoi').click(function(){			
			var flag = validateQuestionForm();			
			if (flag){
			  submitForm(document.addQuestion);	
			}else{
			  return false;		  	
			}		
		});	
	});
   
  
   
function validateQuestionForm(){	  
   var validate = true;
   var descriptionQuestion = jQuery('#descriptionQuestion').val();	  
   
   jQuery('#contentQuestion').val(jQuery.trim(window.contentQuestionEditor.getHTML()));
   var contentQuestion =  jQuery('#contentQuestion').val();
   
   if(contentQuestion == ''){
		validate = false;
		jQuery("#checkContentQuestion").css("display","block");
		jQuery("#checkContentQuestion").html("<span class='error'>Bạn chưa nhập trả lời</span>");
	}else{
		jQuery("#checkContentQuestion").css("display","none");
	}	 
	   
	if(descriptionQuestion == ''){
		 validate = false;
		 jQuery("#checkDescriptionQuestion").css("display","block");
		 jQuery("#checkDescriptionQuestion").html("<span class='error'>Bạn chưa nhập câu hỏi</span>");
	}else{
		 jQuery("#checkDescriptionQuestion").css("display","none");
	}	
	
	if (validate == false){
		jQuery("#success").css("display", "none");
		jQuery("#error").css("display", "block");
	}
    return validate;										
}
	