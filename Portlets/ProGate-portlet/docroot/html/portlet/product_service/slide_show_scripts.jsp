<%@ include file="../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<script type="text/javascript">

	/* Variables to validate */
	var valid_slideshow_product_imageurl_1 = true;
	var valid_slideshow_product_imageurl_2 = true;
	var valid_slideshow_product_imageurl_3 = true;
	var valid_slideshow_product_imageurl_4 = true;
	var valid_slideshow_product_imageurl_5 = true;
	var valid_slideshow_product_title_1 = true;
	var valid_slideshow_product_title_2 = true;
	var valid_slideshow_product_title_3 = true;
	var valid_slideshow_product_title_4 = true;
	var valid_slideshow_product_title_5 = true;
	
	function submit(actionUrl) {
		if ( valid_slideshow_product_imageurl_1 == true &&
			 valid_slideshow_product_imageurl_2 == true &&
			 valid_slideshow_product_imageurl_3 == true &&
			 valid_slideshow_product_imageurl_4 == true &&
			 valid_slideshow_product_imageurl_5 == true &&
			 valid_slideshow_product_title_1 == true && 
			 valid_slideshow_product_title_2 == true &&
			 valid_slideshow_product_title_3 == true &&
			 valid_slideshow_product_title_4 == true &&
			 valid_slideshow_product_title_5 == true ) {
			
			document.frmSlideShowProduct.action = actionUrl;
			document.frmSlideShowProduct.submit();
			
		} else {
			jQuery("#tnt-global-message").removeClass("tnt-global-success-message");
			jQuery("#tnt-global-message").addClass("tnt-global-error-message");
			jQuery("#tnt-global-message span").text('<fmt:message key="warning.slideshow.product.global.error" />');
		}
	}
	
	function addSubmit() {
		
		var portletActionURL = 
			'<portlet:actionURL windowState="<%=WindowState.MAXIMIZED.toString() %>">
				<portlet:param name="action" value="addSlideShowProduct"></portlet:param>
				<portlet:param name="<%=URLParameter_RS.ORG_ID %>" value="${bean.orgId}"/>
			    <portlet:param name="<%=URLParameter_RS.VIEW_MODE %>" value="${bean.viewMode}"/>
			</portlet:actionURL>';
		
		submit(portletActionURL);
	}
	
	function updateSubmit() {
		
		var portletActionURL = 
			'<portlet:actionURL windowState="<%=WindowState.MAXIMIZED.toString() %>">
				<portlet:param name="action" value="updateSlideShowProduct"></portlet:param>
				<portlet:param name="<%=URLParameter_RS.ORG_ID %>" value="${bean.orgId}"/>
			    <portlet:param name="<%=URLParameter_RS.VIEW_MODE %>" value="${bean.viewMode}"/>
			</portlet:actionURL>';
		
		submit(portletActionURL);
	}
	
	function checkSlideShowTitle(index) {
		var imageUrID = "#file-target-" + index;
		var slideShowTitleID = "#slideShowTitle-" + index;
		var errorTitleSlideShowID = "#error_title_slideshow-" + index;
		
		var imageUrlVal = jQuery(imageUrID).val();
		var titleVal = jQuery(slideShowTitleID).val();
		var errorSlideShowTitle = jQuery(errorTitleSlideShowID);
		
		if (imageUrlVal != "") {			
			if (titleVal == "") {
				errorSlideShowTitle.text('<fmt:message key="warning.slideshow.product.require.title" />');
				
				if (index = 1)  {
					valid_slideshow_product_title_1 = false;
				} else if (index = 2)  {
					valid_slideshow_product_title_2 = false;
				} else if (index = 3)  {
					valid_slideshow_product_title_3 = false;
				} else if (index = 4)  {
					valid_slideshow_product_title_4 = false;
				} else if (index = 5)  {
					valid_slideshow_product_title_5 = false;
				}				
			} else {
				errorSlideShowTitle.text('');
				
				if (index = 1)  {
					valid_slideshow_product_title_1 = true;
				} else if (index = 2)  {
					valid_slideshow_product_title_2 = true;
				} else if (index = 3)  {
					valid_slideshow_product_title_3 = true;
				} else if (index = 4)  {
					valid_slideshow_product_title_4 = true;
				} else if (index = 5)  {
					valid_slideshow_product_title_5 = true;
				}
			}
		}
	}
	
	function checkImageFormat(index) {
		var jQueryform = jQuery("form[name='frmSlideShowProduct']");
        
		var href = '';
		var errorSlideShowImageID = '#error_slide_show_image-' + index;
		var errorSlideShowImage = jQuery(errorSlideShowImageID);
		
		switch(index) {
			case 1:
				href = '<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
					<portlet:param name="action" value="checkingValidImage" />
					<portlet:param name="fileUpload" value="Ssp_Image_Url-1" />
				</portlet:actionURL>';
				break;
			case 2:
				href = '<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
					<portlet:param name="action" value="checkingValidImage" />
					<portlet:param name="fileUpload" value="Ssp_Image_Url-2" />
				</portlet:actionURL>';
				break;
			case 3:
				href = '<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
					<portlet:param name="action" value="checkingValidImage" />
					<portlet:param name="fileUpload" value="Ssp_Image_Url-3" />
				</portlet:actionURL>';
				break;
			case 4:
				href = '<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
					<portlet:param name="action" value="checkingValidImage" />
					<portlet:param name="fileUpload" value="Ssp_Image_Url-4" />
				</portlet:actionURL>';
				break;
			default:
				href = '<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
					<portlet:param name="action" value="checkingValidImage" />
					<portlet:param name="fileUpload" value="Ssp_Image_Url-5" />
				</portlet:actionURL>';
		}
		
		jQueryform.ajaxSubmit({
            url: href,
            success: function(data) {
            	data = jQuery.trim(data);
            	if (data == 'warning.image.invalid.name.extension') {
            		errorSlideShowImage.text('<fmt:message key="warning.image.invalid.name.extension" />');
            		if (index = 1)  {
            			valid_slideshow_product_imageurl_1 = false;
    				} else if (index = 2)  {
    					valid_slideshow_product_imageurl_2 = false;
    				} else if (index = 3)  {
    					valid_slideshow_product_imageurl_3 = false;
    				} else if (index = 4)  {
    					valid_slideshow_product_imageurl_4 = false;
    				} else if (index = 5)  {
    					valid_slideshow_product_imageurl_5 = false;
    				}
            	} else if (data == 'warning.image.invalid.format') {
            		errorSlideShowImage.text('<fmt:message key="warning.image.invalid.format" />');
            		if (index = 1)  {
            			valid_slideshow_product_imageurl_1 = false;
    				} else if (index = 2)  {
    					valid_slideshow_product_imageurl_2 = false;
    				} else if (index = 3)  {
    					valid_slideshow_product_imageurl_3 = false;
    				} else if (index = 4)  {
    					valid_slideshow_product_imageurl_4 = false;
    				} else if (index = 5)  {
    					valid_slideshow_product_imageurl_5 = false;
    				}
            	} else if (data == 'warning.image.invalid.format'){
            		errorSlideShowImage.text('<fmt:message key="warning.image.invalid.format" />');
            		if (index = 1)  {
            			valid_slideshow_product_imageurl_1 = false;
    				} else if (index = 2)  {
    					valid_slideshow_product_imageurl_2 = false;
    				} else if (index = 3)  {
    					valid_slideshow_product_imageurl_3 = false;
    				} else if (index = 4)  {
    					valid_slideshow_product_imageurl_4 = false;
    				} else if (index = 5)  {
    					valid_slideshow_product_imageurl_5 = false;
    				}
            	} else {
            		errorSlideShowImage.text('');
            		if (index = 1)  {
            			valid_slideshow_product_imageurl_1 = true;
    				} else if (index = 2)  {
    					valid_slideshow_product_imageurl_2 = true;
    				} else if (index = 3)  {
    					valid_slideshow_product_imageurl_3 = true;
    				} else if (index = 4)  {
    					valid_slideshow_product_imageurl_4 = true;
    				} else if (index = 5)  {
    					valid_slideshow_product_imageurl_5 = true;
    				}
            	}
            }
        });
	}
	
	function validate() {
		// Validate slide show product title
		for ( i = 1; i <= 5; i++) {
			checkSlideShowTitle(i);			
		}		
	}
	
	function update_validate_and_submit() {
		validate();
		updateSubmit();
	}
	
	function add_validate_and_submit() {
		validate();
		addSubmit();
	}
	
	function deleteSlideShowProduct() {
		
		if(jQuery("input[name='child_ckb']:checked").length == 0) {
			alert('<fmt:message key="warning.slideshow.product.no.choose.delete" />');
		}
		else {
			if (confirm('<fmt:message key="warning.product.confirm.delete"/>')) {
				var portletActionURL = 
					'<portlet:actionURL windowState="<%=WindowState.MAXIMIZED.toString() %>">
						<portlet:param name="action" value="deleteSlideShowProduct"></portlet:param>
						<portlet:param name="<%=URLParameter_RS.ORG_ID %>" value="${bean.orgId}"/>
					    <portlet:param name="<%=URLParameter_RS.VIEW_MODE %>" value="${bean.viewMode}"/>
					</portlet:actionURL>';
				
				submit(portletActionURL);
			}		
		}
	}
	
	function cancel(url) {		
		window.location = url;
	}
	
	jQuery(function(){
		
		/*  Load warning message when form on load */
		if ( document.frmMsg.MsgTxt.value != '') {
			if ( document.frmMsg.MsgTxt.value == 'warning.slideshow.product.global.add.success' ) {
								
				jQuery("#tnt-global-message").addClass("tnt-global-success-message");
				jQuery("#tnt-global-message").removeClass("tnt-global-error-message");
				jQuery("#tnt-global-message span").text('<fmt:message key="warning.slideshow.product.global.add.success" />');
				
			} else if ( document.frmMsg.MsgTxt.value == 'warning.slideshow.product.global.update.success' ) {
				
				jQuery("#tnt-global-message").addClass("tnt-global-success-message");
				jQuery("#tnt-global-message").removeClass("tnt-global-error-message");
				jQuery("#tnt-global-message span").text('<fmt:message key="warning.slideshow.product.global.update.success" />');
				
			} else {
				
				jQuery("#tnt-global-message").removeClass("tnt-global-success-message");
				jQuery("#tnt-global-message").addClass("tnt-global-error-message");
				jQuery("#tnt-global-message span").text('<fmt:message key="warning.slideshow.product.global.error" />');
				
			}
		}
		
		jQuery("#file-target-1").change(function() {
			checkImageFormat(1);
		});
		
		jQuery("#file-target-2").change(function() {
			checkImageFormat(2);
		});
		
		jQuery("#file-target-3").change(function() {
			checkImageFormat(3);
		});
		
		jQuery("#file-target-4").change(function() {
			checkImageFormat(4);
		});
		
		jQuery("#file-target-5").change(function() {
			checkImageFormat(5);
		});
		
		// File target is a <input type="file" />
		jQuery(".file-target").change(function() {
			
			// Browser supports `files` as part of DOM
			if (this.files) {
			
			  //  This works in Firefox, #image-preview is an <img src="" />
			  jQuery(this).parent().parent().parent().parent().find(".image-preview").attr("src", this.files[0].getAsDataURL());
			  //jQuery("image-preview").attr("src", this.files[0].getAsDataURL());
			  
			} else {
			
			  // This is just wishful thinking, but it's a security issue so the value of the input is never
			  // a true local file path
			 // jQuery("#image-preview").attr("src", jQuery("#file-target").val());
			  jQuery(this).parent().parent().parent().parent().find(".image-preview").attr("src", jQuery(this).val());
			
			}
			
			// Firefox gives you a file name
			// Safari / Chrome gives you nothing
			// IE / Opera gives you a weird /fakepath/filename.ext
			//jQuery("#file-upload-area").append(jQuery("#file-target").val());
			
			//jQuery("#preview-area").show();

		});		
	});
</script>