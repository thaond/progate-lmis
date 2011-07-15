<%@ include file="../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<script type="text/javascript">

	/*
	 * Function to check if this is decimal number
	 */
	function isDecimal(evt) {
		var charCode = (evt.which) ? evt.which : event.keyCode
		
		if (charCode == 46) {
			return true;
		}		
				
		if (charCode > 31 && (charCode < 48 || charCode > 57))
			return false;
		
		return true;
	}


	function initEditor() {
		
		var out = document.frmProduct.<%=JournalArticle_RS.JA_CONTENT %>.value;
		
	    //out = out.replace('<','&#x200B;<');    
	    window.jaContent.setHTML(out);
	    
		return document.frmProduct.<%=JournalArticle_RS.JA_CONTENT %>.value;
	}
	
	function getHtmlValue() {
	    var html = window.<%=JournalArticle_RS.JA_CONTENT %>.getHTML();	    
	}
	
	function imposeMaxLength(Object, MaxLen, evt)
	{
		var charCode = (evt.which) ? evt.which : event.keyCode;
		
		if (charCode == 8) {
			return true;
		}
		
		return (Object.value.length <= MaxLen);
	}
	
	/* Variables to validate */	
	var valid_product_name = false;
	var valid_product_price = false;
	var valid_product_currency = false;
	var valid_product_type = false;
	var valid_product_discount = false;
	var valid_product_description = false;
	var valid_product_content = false;
	var valid_product_image = false;
	var isPromotion = false;
	
	function submit(actionUrl) {
		if ( valid_product_name == true &&
				 valid_product_price == true &&
				 valid_product_discount == true &&	
				 valid_product_description == true &&		
				 valid_product_content == true &&
				 valid_product_image == true ) {
			
			document.frmProduct.action = actionUrl;
			document.frmProduct.submit();
		} else {			
			jQuery("#tnt-global-message").removeClass("tnt-global-success-message");
			jQuery("#tnt-global-message").addClass("tnt-global-error-message");
			jQuery("#tnt-global-message span").text('<fmt:message key="warning.product.global.error" />');
		}
	}
	
	function addSubmit() {		
		var portletActionURL = 
			'<portlet:actionURL windowState="<%=WindowState.MAXIMIZED.toString() %>">
				<portlet:param name="action" value="addProduct"></portlet:param>
				<portlet:param name="<%=URLParameter_RS.ORG_ID %>" value="${bean.orgId}"/>
			    <portlet:param name="<%=URLParameter_RS.VIEW_MODE %>" value="${bean.viewMode}"/>
			    <portlet:param name="<%=URLParameter_RS.RETURN_TO_FULL_PAGE_URL %>" value="${bean.returnToFullPageURL}"/>
			</portlet:actionURL>';
		
		submit(portletActionURL);
	}
	
	function updateSubmit() {
		
		var portletActionURL = 
			'<portlet:actionURL windowState="<%=WindowState.MAXIMIZED.toString() %>">
				<portlet:param name="action" value="updateProduct"></portlet:param>
				<portlet:param name="<%=URLParameter_RS.ORG_ID %>" value="${bean.orgId}"/>
			    <portlet:param name="<%=URLParameter_RS.VIEW_MODE %>" value="${bean.viewMode}"/>
				<portlet:param name="<%=JournalArticle_RS.JA_ID %>" value="${bean.product.journalArticleId}"/>
				<portlet:param name="<%=URLParameter_RS.RETURN_TO_FULL_PAGE_URL %>" value="${bean.returnToFullPageURL}"/>
			</portlet:actionURL>';
		
		submit(portletActionURL);
	}
	
	function validate() {
		// Validate product name
		var product_name_val = jQuery.trim(document.frmProduct.<%=JournalArticle_RS.JA_TITLE %>.value);		
		if( product_name_val == "") {
			jQuery("#error_product_name").text('<fmt:message key="warning.product.require.name" />');
			valid_product_name = false;			
		} else {
			jQuery("#error_product_name").text('');
			valid_product_name = true;
		}
		
		// Validate product price
		var product_price_val = jQuery.trim(document.frmProduct.<%=ProductService_RS.PS_PRICE %>.value);
		product_price_val = product_price_val.replace(",", "");
		document.frmProduct.<%=ProductService_RS.PS_PRICE %>.value = product_price_val;
		
		if( product_price_val == "") {
			jQuery("#error_product_price").text('<fmt:message key="warning.product.require.price" />');			
			valid_product_price = false;
		} else {
			jQuery("#error_product_price").text('');
			valid_product_price = true;
		}
		
		// Validate product discount
		var product_discount_val = jQuery.trim(document.frmProduct.<%=ProductService_RS.PS_DISCOUNT %>.value);		
		if (isPromotion == true) {
			if( product_discount_val == "") {
				jQuery("#error_product_discount").text('<fmt:message key="warning.product.require.discount" />');			
				valid_product_discount = false;
			} else {
				jQuery("#error_product_discount").text('');
				valid_product_discount = true;
			}
		} else {
			valid_product_discount = true;
		}
		
		// Validate product description
		var product_description_val = jQuery.trim(document.frmProduct.<%=JournalArticle_RS.JA_DESCRIPTION %>.value);
		if( product_description_val == "") {
			jQuery("#error_product_description").text('<fmt:message key="warning.product.require.description" />');			
			valid_product_description = false;
		} else {
			jQuery("#error_product_description").text('');
			valid_product_description = true;
		}
		
		// Validate product content
		var product_content_val = jQuery.trim(window.jaContent.getHTML());
		document.frmProduct.<%=JournalArticle_RS.JA_CONTENT %>.value = product_content_val;
		if( product_content_val == "") {
			jQuery("#error_product_content").text('<fmt:message key="warning.product.require.content" />');			
			valid_product_content = false;
		} else {
			jQuery("#error_product_content").text('');
			valid_product_content = true;
		}		
	}
	
	function validateAddImage() {
		// Validate product image
		var product_image_val = jQuery.trim(document.frmProduct.<%=JournalArticle_RS.JA_SMALL_IMAGE_URL %>.value);
		if( product_image_val == "") {
			jQuery("#error_product_image").text('<fmt:message key="warning.product.require.image" />');
			valid_product_image = false;
		}
	}
	
	function validateUpdateImage() {
		var product_image_val = jQuery.trim(document.frmProduct.<%=JournalArticle_RS.JA_SMALL_IMAGE_URL %>.value);
		if( product_image_val == "") {
			jQuery("#error_product_image").text('');
			valid_product_image = true;
		}
	}
	
	function update_validate_and_submit() {		
		validate();
		validateUpdateImage();		
		updateSubmit();
	}
	
	function add_validate_and_submit() {
		validate();
		validateAddImage();
		addSubmit();
	}
	
	function cancel(url) {
		window.location = url;	    
	}
	
	function deleteProduct() {		
		if (confirm('<fmt:message key="warning.product.confirm.delete"/>')) {
			var portletActionURL = 
				'<portlet:actionURL windowState="<%=WindowState.NORMAL.toString() %>">
					<portlet:param name="action" value="deleteProduct" />
					<portlet:param name="<%=URLParameter_RS.ORG_ID %>" value="${bean.orgId}"/>
				    <portlet:param name="<%=URLParameter_RS.VIEW_MODE %>" value="${bean.viewMode}"/>
					<portlet:param name="<%=JournalArticle_RS.JA_ID %>" value="${bean.product.journalArticleId}"/>				
				</portlet:actionURL>';
			
			document.frmProduct.action = portletActionURL;
		    document.frmProduct.submit();
		}		
	}
	
	function viewProduct(url) {
		window.location = url;
	}
	
	jQuery(function(){
		/*  Load warning message when form on load */		
		if ( document.frmMsg.MsgTxt.value != '') {
			if ( document.frmMsg.MsgTxt.value == 'warning.product.global.add.success' ) {
							
				jQuery("#tnt-global-message").addClass("tnt-global-success-message");
				jQuery("#tnt-global-message").removeClass("tnt-global-error-message");
				jQuery("#tnt-global-message span").text('<fmt:message key="warning.product.global.add.success" />');
				
			} else if ( document.frmMsg.MsgTxt.value == 'warning.product.global.update.success' ) {
				
				jQuery("#tnt-global-message").addClass("tnt-global-success-message");
				jQuery("#tnt-global-message").removeClass("tnt-global-error-message");
				jQuery("#tnt-global-message span").text('<fmt:message key="warning.product.global.update.success" />');
				
			} else {
				
				jQuery("#tnt-global-message").removeClass("tnt-global-success-message");
				jQuery("#tnt-global-message").addClass("tnt-global-error-message");
				jQuery("#tnt-global-message span").text('<fmt:message key="warning.product.global.error" />');
				
			}
		}
		//document.frmMsg.MsgTxt.value = '';
		
		if (jQuery("#rdPromotion").attr("checked") == true) {			
			isPromotion = true;
			jQuery("#isDisplayPromotion").css("display", "block");
		}
		
		document.frmProduct.<%=JournalArticle_RS.JA_DESCRIPTION %>.value = 
				jQuery.trim(document.frmProduct.<%=JournalArticle_RS.JA_DESCRIPTION %>.value);
		
		jQuery("input[name='<%=ProductService_RS.PS_PRODUCT_TYPE %>']").change(function(){			
			if(jQuery(this).val() == '3') {
				isPromotion = true;
				jQuery("#isDisplayPromotion").css("display", "block");
			} else {
				isPromotion = false;
				jQuery("#isDisplayPromotion").css("display", "none");
			}
		});
		
		jQuery("input[name='<%=ProductService_RS.PS_IS_HOT %>']").change(function(){
			if(jQuery(this).attr("checked") == true) {
				jQuery(this).val("true");
		    }
		    else{
		    	jQuery(this).val("false");
		    }
		});
		
		jQuery("textarea[name='<%=JournalArticle_RS.JA_DESCRIPTION %>']").bind('paste', function(e) {		     
			setTimeout(function() {
				var value = document.frmProduct.<%=JournalArticle_RS.JA_DESCRIPTION %>.value;
				document.frmProduct.<%=JournalArticle_RS.JA_DESCRIPTION %>.value = value.substring(0, 315);				
		    }, 10);
		});
		
		jQuery("input[name='<%=JournalArticle_RS.JA_SMALL_IMAGE_URL %>']").change(function(){
						
			var jQueryform = jQuery("form[name='frmProduct']");
            
			var href = '<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
							<portlet:param name="action" value="checkingValidImage" />
							<portlet:param name="fileUpload" value="<%=JournalArticle_RS.JA_SMALL_IMAGE_URL%>" />
						</portlet:actionURL>';
			
			jQueryform.ajaxSubmit({
                url: href,
                success: function(data) {
                	data = jQuery.trim(data);
                	
                	if (data == 'warning.image.invalid.name.extension') {
                		jQuery("#error_product_image").text('<fmt:message key="warning.image.invalid.name.extension" />');
                		valid_product_image = false;
                	} else if (data == 'warning.image.invalid.format') {
                		jQuery("#error_product_image").text('<fmt:message key="warning.image.invalid.format" />');
                		valid_product_image = false;
                	} else if (data == 'warning.image.invalid.format'){
                		jQuery("#error_product_image").text('<fmt:message key="warning.image.invalid.format" />');
                		valid_product_image = false;
                	} else {
                		jQuery("#error_product_image").text('');
                		valid_product_image = true;
                	}
                }
            });
		});
	});
</script>