<%@ include file="../../../common/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">

	function initEditor() {
		
		var out = document.frmProduct.<%=JournalArticle_RS.JA_CONTENT%>.value;
		
	    //out = out.replace('<','&#x200B;<');    
	    window.jaContent.setHTML(out);
	    
		return document.frmProduct.<%=JournalArticle_RS.JA_CONTENT%>.value;
	}
	
	function getHtmlValue() {
	    var html = window.<%=JournalArticle_RS.JA_CONTENT%>.getHTML();	    
	}
	
	/* Variables to validate */	
	var valid_product_name = false;
	var valid_product_price = false;
	var valid_product_currency = false;
	var valid_product_type = false;
	var valid_product_discount = false;
	var valid_product_amount = false;
	var valid_product_expiredDate = false;
	var valid_product_description = false;
	var valid_product_content = false;
	var valid_product_image = false;
	var isPromotion = false;
	
	function pagingSubmit() {
		//alert('Handling pagingSubmit()');
		submit();
	}
	
	function submit() {
		
		var currentPageNum = jQuery("#productPaging").find(".page-selector select").val();
		
		var pageSize = jQuery("#productPaging").find("#itemsPerPage select").val();
		
		window.location.href = "${bean.pagingURL}"
								+ "&" + "<%=URLParameter_RS.CURRENT_PAGE%>"	+ "=" + currentPageNum
								+ "&" + "<%=URLParameter_RS.PAGE_SIZE%>" + "=" + pageSize;
	}
	
	function doSubmit(actionUrl) {
		if ( valid_product_name == true &&
				 valid_product_price == true &&
				 valid_product_discount == true &&
				 valid_product_amount == true &&
				 valid_product_expiredDate == true &&
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
			'<portlet:actionURL windowState="<%=WindowState.MAXIMIZED.toString()%>">
				<portlet:param name="action" value="handleProduct"></portlet:param>
			    <portlet:param name="<%=Constants.CMD%>" value="<%=Constants.ADD%>"/>
			</portlet:actionURL>';
		
		doSubmit(portletActionURL);
	}
	
	function updateSubmit() {
		
		var portletActionURL = 
			'<portlet:actionURL windowState="<%=WindowState.MAXIMIZED.toString()%>">
				<portlet:param name="action" value="handleProduct"></portlet:param>
				<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.UPDATE%>"/>
			</portlet:actionURL>';
		
		doSubmit(portletActionURL);
	}
	
	function deleteProduct() {
		if (confirm('<fmt:message key="warning.product.confirm.delete"/>')) {
			var portletActionURL = 
				'<portlet:actionURL windowState="<%=WindowState.NORMAL.toString()%>">
					<portlet:param name="action" value="handleProduct" />
					<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.DELETE%>"/>
				</portlet:actionURL>';
			
			document.frmProduct.action = portletActionURL;
		    document.frmProduct.submit();
		}
	}
	
	function cancel(url) {
		window.location = url;
	}
	
	function viewProduct(url) {
		window.location = url;
	}
	
	function search() {
		
		if (jQuery(".txt-search").val() == '<fmt:message key="title.product.name.input"/>') {
			jQuery(".txt-search").val('');
		}
		
		var searchProductName = jQuery(".txt-search").val();
		
		if (searchProductName != '') {
			var url = 
				"${bean.searchURL}"
				+ "?"
				+ "<%=URLParameter_RS.SEARCH%>"
				+ "="
				+ searchProductName;
			
			window.location.href = url;
		}
	}
	
	function validate() {
		// Validate product name
		var product_name_val = jQuery.trim(document.frmProduct.<%=JournalArticle_RS.JA_TITLE%>.value);
		if( product_name_val == "") {
			jQuery("#error_product_name").text('<fmt:message key="warning.product.require.name" />');
			valid_product_name = false;
		} else {
			jQuery("#error_product_name").text('');
			valid_product_name = true;
		}
		
		// Validate product price
		var product_price_val = jQuery.trim(document.frmProduct.<%=ProductService_RS.PS_PRICE%>.value);
		product_price_val = product_price_val.replace(",", "");
		document.frmProduct.<%=ProductService_RS.PS_PRICE%>.value = product_price_val;
		
		if( product_price_val == "") {
			jQuery("#error_product_price").text('<fmt:message key="warning.product.require.price" />');
			valid_product_price = false;
		} else {
			jQuery("#error_product_price").text('');
			valid_product_price = true;
		}
		
		// Validate product discount
		var product_discount_val = jQuery.trim(document.frmProduct.<%=ProductService_RS.PS_DISCOUNT%>.value);
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
		
		//Validate product amount
		var product_amount_val = jQuery.trim(document.frmProduct.<%=ProductService_RS.PS_PRODUCT_AMOUNT%>.value);
		product_amount_val = product_amount_val.replace(",","");
		document.frmProduct.<%=ProductService_RS.PS_PRODUCT_AMOUNT%>.value = product_amount_val;
		if(product_amount_val==""){
			jQuery("#error_product_amount").text('<fmt:message key="warning.product.require.amount" />');
			valid_product_amount = false;
		}else{
			jQuery("#error_product_amount").text('');
			valid_product_amount=true;
		}
		
		//Validate product expired date
		var product_expiredDate = jQuery.trim(document.frmProduct.<%=ProductService_RS.PS_PRODUCT_EXPIRED_DATE%>.value);
		
		if(product_expiredDate==""){
			jQuery("#error_product_expiredDate").text('<fmt:message key="warning.product.require.expiredDate" />');
			valid_product_expiredDate = false;
		}else{
			var today = new Date();
			
			var d   =  parseInt(product_expiredDate.substring(0,2),10); 
			var m   =  parseInt(product_expiredDate.substring(3,5),10);
			var y   =  parseInt(product_expiredDate.substring(6,10),10); 
			
			var expDate = new Date(y,m-1,d);
			
			if(expDate>today){
				jQuery("#error_product_expiredDate").text('');
				valid_product_expiredDate = true;	
			}else{
				jQuery("#error_product_expiredDate").text('<fmt:message key="warning.product.require.expired.day.larger.now"/>');
				valid_product_expiredDate = false;
			}
		}
				
		// Validate product description
		var product_description_val = jQuery.trim(document.frmProduct.<%=JournalArticle_RS.JA_DESCRIPTION%>.value);
		if( product_description_val == "") {
			jQuery("#error_product_description").text('<fmt:message key="warning.product.require.description" />');			
			valid_product_description = false;
		} else {
			jQuery("#error_product_description").text('');
			valid_product_description = true;
		}
		
		// Validate product content
		var product_content_val = jQuery.trim(window.jaContent.getHTML());
		document.frmProduct.<%=JournalArticle_RS.JA_CONTENT%>.value = product_content_val;
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
		var product_image_val = jQuery.trim(document.frmProduct.<%=JournalArticle_RS.JA_SMALL_IMAGE_URL%>.value);
		if( product_image_val == "") {
			jQuery("#error_product_image").text('<fmt:message key="warning.product.require.image" />');
			valid_product_image = false;
		}
	}
	
	function validateUpdateImage() {
		var product_image_val = jQuery.trim(document.frmProduct.<%=JournalArticle_RS.JA_SMALL_IMAGE_URL%>.value);
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
	
	jQuery(document).ready(function(){
		
		jQuery(".productContent img").each(function(){
			jQuery(this).load(function(){
				scaleImg(jQuery(this), 630, 400);
			});	
		});
		
		// Calendar
		var pickerOpts = {
				showOn: "both",
				buttonImage: "<%=request.getContextPath()%>/images/calendar.gif",
				buttonText: "Open datepicker",
				buttonImageOnly: true,
				dateFormat:"dd/mm/yy"
		    };
		    
		jQuery("#product_expiredDate").datepicker(pickerOpts);

		
		/* Handle search */
		jQuery(".txt-search").focus();
		jQuery(".txt-search").focus(function(){
			if (jQuery(this).val() == '<fmt:message key="title.product.name.input"/>') {
				jQuery(this).val('');
			}
		});
		jQuery(".txt-search").blur(function(){
			if (jQuery(this).val() == "") {
				jQuery(this).val('<fmt:message key="title.product.name.input"/>');
			}
		});
		
		jQuery(".txt-search").bind('keydown', function(e) {
	        if (e.which == 13) {
	        	search();
	        }
	    });
		
		jQuery(".bt-search").click(function(){
			search();
		});
		
		/*  Load warning message when form on load */
		// document.frmMsg.MsgTxt.value
		var msgContent = jQuery("input[name='MsgTxt']").val();
		if ( msgContent != '') {
			if ( msgContent == 'warning.product.global.add.success' ) {
				
				jQuery("#tnt-global-message").addClass("tnt-global-success-message");
				jQuery("#tnt-global-message").removeClass("tnt-global-error-message");
				jQuery("#tnt-global-message span").text('<fmt:message key="warning.product.global.add.success" />');
				
			} else if ( msgContent == 'warning.product.global.update.success' ) {
				
				jQuery("#tnt-global-message").addClass("tnt-global-success-message");
				jQuery("#tnt-global-message").removeClass("tnt-global-error-message");
				jQuery("#tnt-global-message span").text('<fmt:message key="warning.product.global.update.success" />');
				
			} else {
				
				jQuery("#tnt-global-message").removeClass("tnt-global-success-message");
				jQuery("#tnt-global-message").addClass("tnt-global-error-message");
				jQuery("#tnt-global-message span").text('<fmt:message key="warning.product.global.error" />');
				
			}
		}
		
		if (jQuery("#rdPromotion").attr("checked") == true) {
			isPromotion = true;
			jQuery("#isDisplayPromotion").css("display", "block");
		}
		
		var desc = jQuery("textarea[name='<%=JournalArticle_RS.JA_DESCRIPTION%>']").val();
		jQuery("textarea[name='<%=JournalArticle_RS.JA_DESCRIPTION%>']").val(jQuery.trim(desc));
		
		jQuery("input[name='<%=ProductService_RS.PS_PRODUCT_TYPE%>']").change(function(){
			if(jQuery(this).val() == '3') {
				isPromotion = true;
				jQuery("#isDisplayPromotion").css("display", "block");
			} else {
				isPromotion = false;
				jQuery("#isDisplayPromotion").css("display", "none");
			}
		});
		
		jQuery("input[name='<%=ProductService_RS.PS_IS_HOT%>']").change(function(){
			if(jQuery(this).attr("checked") == true) {
				jQuery(this).val("true");
		    }
		    else{
		    	jQuery(this).val("false");
		    }
		});
		
		jQuery("textarea[name='<%=JournalArticle_RS.JA_DESCRIPTION%>']").bind('paste', function(e) {	     
			setTimeout(function() {
				var value = document.frmProduct.<%=JournalArticle_RS.JA_DESCRIPTION%>.value;
				document.frmProduct.<%=JournalArticle_RS.JA_DESCRIPTION%>.value = value.substring(0, 160);
		    }, 10);
		});
		
		jQuery("input[name='<%=JournalArticle_RS.JA_SMALL_IMAGE_URL%>']").change(function(){
			
			if (this.files) {
				//  This works in Firefox, #image-preview is an <img src="" />
				jQuery(".image-preview").attr("src", this.files[0].getAsDataURL());
			} else {
				// This is just wishful thinking, but it's a security issue so the value of the input is never
				// a true local file path
				jQuery(".image-preview").attr("src", jQuery(this).val());
				
			}
			
			var jQueryform = jQuery("form[name='frmProduct']");
            
			var href = '<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
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
                	} else if (data == 'warning.image.invalid.format') {
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