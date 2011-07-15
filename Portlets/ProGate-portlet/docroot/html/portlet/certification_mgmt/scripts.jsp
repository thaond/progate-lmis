<%--
 
 --%>
 
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/html/portlet/certification_mgmt/init.jsp" %>

<%@ page import="larion.progate.model.ProGateJournalArticle"%>

<%
	// renderRequest and portletConfig are objects which, accoring to the
	// portlet spec, are required to be in context. So they should just be 
	// there for you to use.
	//Locale locale = renderRequest.getLocale();
	ResourceBundle bundle = portletConfig.getResourceBundle(locale);
	
	if (((RequestConst.EDIT_CERT).equals(actMode))
			|| ((RequestConst.ADD_CERT).equals(actMode))) {
		certItem = CertificationUtils.getCertifiedArticles(Integer.parseInt(certId));
	}
%>

<script type="text/javascript">

	//alert("I'm here!");

	/* Variables to validate */
	var valid_cert_name = false;
	var valid_cert_logo = false;
	var valid_cert_date = false;

	var actionMode = '<%= actMode %>';

	/*
	 * Validate inputs
	 */	
	function validate() {	
		// Validate cert name
		var cert_name_val = jQuery.trim(document.frmCertified.<%= CertificationConst.JA_TITLE %>.value);		
		if( cert_name_val == "") {
			jQuery("#error_certified_name").text('<%= bundle.getString("error.certified.name") %>');
			valid_cert_name = false;
		} else {
			jQuery("#error_certified_name").text('');
			valid_cert_name = true;
		}
		
		// Validate cert logo
		var cert_logo_val = jQuery.trim(document.frmCertified.<%= CertificationConst.JA_LOGO %>.value);		
		if( cert_logo_val == "") {
			<% if (certItem.getSmallImageUrl().trim().length() > 0) {
			%>
				jQuery("#error_certified_logo").text('');
				valid_cert_logo = true;
			<% } else {
			%>
				jQuery("#error_certified_logo").text('<%= bundle.getString("error.certified.logo.empty") %>');
				valid_cert_logo = false;
			<% }
			%>		
		} else {
			jQuery("#error_certified_logo").text('');
			valid_cert_logo = true;
		}
		
		// Validate cert date
		var cert_date_val = jQuery.trim(document.frmCertified.<%= CertificationConst.JA_CERT_DATE %>.value);		
		if( cert_date_val == "") {
			jQuery("#error_certified_date").text('<%= bundle.getString("error.certified.date") %>');
			valid_cert_date = false;
		} else {
			jQuery("#error_certified_date").text('');
			valid_cert_date = true;
		}
	}
	
	function onSubmitForm(actionMode) {
		//alert("Inside onSubmitForm(): action = " + actionMode + " one in three (<%= RequestConst.ADD_CERT %>, <%= RequestConst.EDIT_CERT %>, <%= RequestConst.DELETE_CERT %>)"); 
		
		var portletActionURL = "";	
		if (actionMode == '<%= RequestConst.ADD_CERT %>') {
			portletActionURL = '<portlet:actionURL windowState="exclusive">
									<portlet:param name="struts_action" value="/certification_mgmt/save_certification" />
									<portlet:param name="<%= RequestConst.ORG_ID %>" value="<%= orgId %>"></portlet:param>
									<portlet:param name="<%= RequestConst.VIEW_MODE %>" value="<%= viewMode %>"></portlet:param>
									<portlet:param name="<%= RequestConst.ACTION %>" value="<%= RequestConst.ADD_CERT %>"></portlet:param>
								</portlet:actionURL>';			
		} else if (actionMode == '<%= RequestConst.EDIT_CERT %>'){
			portletActionURL = '<portlet:actionURL windowState="exclusive">
									<portlet:param name="struts_action" value="/certification_mgmt/save_certification" />
									<portlet:param name="<%= RequestConst.ORG_ID %>" value="<%= orgId %>"></portlet:param>
									<portlet:param name="<%= RequestConst.VIEW_MODE %>" value="<%= viewMode %>"></portlet:param>
									<portlet:param name="<%= RequestConst.ACTION %>" value="<%= RequestConst.EDIT_CERT %>"></portlet:param>
								</portlet:actionURL>';
		} else if (actionMode == '<%= RequestConst.DELETE_CERT %>'){
			portletActionURL = '<portlet:actionURL windowState="exclusive">
									<portlet:param name="struts_action" value="/certification_mgmt/save_certification" />
									<portlet:param name="<%= RequestConst.ORG_ID %>" value="<%= orgId %>"></portlet:param>
									<portlet:param name="<%= RequestConst.VIEW_MODE %>" value="<%= viewMode %>"></portlet:param>
									<portlet:param name="<%= RequestConst.ACTION %>" value="<%= RequestConst.DELETE_CERT %>"></portlet:param>
								</portlet:actionURL>';
		}		
		
		//alert("portletActionURL = " + portletActionURL);
					              
        //document.frmCertified.action = portletActionURL;
  		//document.frmCertified.submit();
		
  		var jQueryform = jQuery("form[name='frmCertified']");
  		
  		jQueryform.ajaxSubmit({
            url: portletActionURL,
            success: function(data) {
            	var params = data.split(';', 2);
            	//alert(params[0] + " and " + params[1]);
            	if (params[0] == '<%= RequestConst.JA_SUCCESS %>') {
            		if (actionMode == '<%= RequestConst.DELETE_CERT%>') {            		
            			cancel();
            		} else {
            			jQuery("#certified_id").val(params[1]);
            			jQuery("#save_success").css('display', 'block');
            			jQuery("#delete_cert").css('display', 'block');
	            		jQuery("#save_error").css('display', 'none');
            		}
            	} else if (params[0] == '<%= RequestConst.JA_ERROR %>') {
            		jQuery("#save_success").css('display', 'none');
            		jQuery("#save_error").css('display', 'block');
            	}
            }
  		});
	}

	/*
	 * Perform form submit
	 */	
	function submit() {
		if ( valid_cert_name == true &&
			 valid_cert_logo == true &&
			 valid_cert_date == true) {			
			//alert("Process submit()");
			
			actionMode = '<%= actMode %>';
			onSubmitForm('<%= actMode %>');
		} else {
			// Show error dialog
			showErrorDialog();
		}
	}

	function validate_and_submit() {
		//alert("Process validate_and_submit();");
		
		validate();
		
		submit();
	}

	function cancel() {
		//alert("Process cancel();");
		
		window.location.href = "<%= urlFullView %>";
	}
	
	function deleteCert() {
		if (confirm('<%= bundle.getString("certified.delete.confirm") %>')) {
			actionMode = '<%= RequestConst.DELETE_CERT %>';
			onSubmitForm('<%= RequestConst.DELETE_CERT %>');
		}
	}
	
	function closeDialog() {
		//alert("Process closeDialog();");
		
		jQuery("#save_success").css('display', 'none');
		jQuery("#save_error").css('display', 'none');		
	}
	
	function showErrorDialog() {
		jQuery("#save_success").css('display', 'none');
		jQuery("#save_error").css('display', 'block');
	}

	/*
	 * jQuery ready
	 */
	jQuery(function(){
		jQuery(".portlet-borderless-bar").html('');
		
		// Calendar
		var pickerOpts = {
				showOn: "both",
				yearRange: "-20:+0",
				buttonImage: "/ProGate-portlet/images/calendar.gif",
				buttonText: "Open datepicker",
				buttonImageOnly: true,
				dateFormat:"dd/mm/yy",
				onClose: function() {
					document.getElementById("certmgmt_certified_date").focus();
				}
			};
			
		jQuery("#certmgmt_certified_date").datepicker(pickerOpts); 		
		// End Calendar
	});

</script>
