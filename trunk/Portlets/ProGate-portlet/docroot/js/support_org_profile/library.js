jQuery(document).ready(function(){	
	jQuery('#themThuVien').click(function(){			
		var flag = validateLibraryForm();			
		if (flag){
		  submitForm(document.addLibrary);	
		}else{
		  return false;		  	
		}		
	});	
});
   
  
   
function validateLibraryForm(){	  
   var validate = true;
   var titleLibrary = jQuery('#titleLibrary').val();	
  
   var modeType = jQuery('#modeType').val();   
   
   if (modeType == "Video"){
   		var embeddedVideo = jQuery("#embeddedVideo").val();
   		
   		if (embeddedVideo == ''){
   			validate = false;
			jQuery("#checkEmbeddedVideo").css("display","block");
			jQuery("#checkEmbeddedVideo").html("<span class='error'>Bạn chưa nhập mã nhúng</span>");
   		}else{
   			jQuery("#checkEmbeddedVideo").css("display","none");
   		}
   }else if (modeType == "PDF"){
   		var attachFile = jQuery("#attachFile").val();
   		
   		if (attachFile == ''){
   			validate = false;
			jQuery("#checkAttachFile").css("display","block");
			jQuery("#checkAttachFile").html("<span class='error'>File có định dạng không được hỗ trợ</span>");
   		}else{
   			jQuery("#checkAttachFile").css("display","none");
   		}
   }
   
   jQuery('#contentLibrary').val(jQuery.trim(window.contentLibraryEditor.getHTML()));
   var contentLibrary =  jQuery('#contentLibrary').val();
   
   if(contentLibrary == ''){
		validate = false;
		jQuery("#checkContentLibrary").css("display","block");
		jQuery("#checkContentLibrary").html("<span class='error'>Bạn chưa nhập nội dung</span>");
	}else{
		jQuery("#checkContentLibrary").css("display","none");
	}	 
	   
	if(titleLibrary == ''){
		 validate = false;
		 jQuery("#checkTitleLibrary").css("display","block");
		 jQuery("#checkTitleLibrary").html("<span class='error'>Bạn chưa nhập tiêu đề</span>");
	}else{
		 jQuery("#checkTitleLibrary").css("display","none");
	}	
	
	if (validate == false){
		jQuery("#success").css("display", "none");
		jQuery("#error").css("display", "block");
	}
    return validate;										
}
	
						
							
						
							
