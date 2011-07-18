<%--
 
 --%>
 
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/html/portlet/achievement_mgmt/init.jsp" %>

<%@ page import="larion.progate.model.ProGateJournalArticle"%>

<%
	// renderRequest and portletConfig are objects which, accoring to the
	// portlet spec, are required to be in context. So they should just be 
	// there for you to use.
	//Locale locale = renderRequest.getLocale();
	ResourceBundle bundle = portletConfig.getResourceBundle(locale);
	
	if (((RequestConst.EDIT_ACHIE).equals(actMode))
			|| ((RequestConst.ADD_ACHIE).equals(actMode))) {
		achieItem = AchievementUtils.getAchievementArticles(Integer.parseInt(achieId));
	}
%>

<script type="text/javascript">

	//alert("I'm here!");

	/* Variables to validate */
	var valid_achie_name = false;
	var valid_achie_logo = false;
	var valid_achie_date = false;
	
	var actionMode = '<%= actMode %>';

	/*
	 * Validate inputs
	 */	
	function validate() {	
		// Validate achie name
		var achie_name_val = jQuery.trim(document.frmAchievement.<%= AchievementConst.JA_TITLE %>.value);		
		if( achie_name_val == "") {
			jQuery("#error_achievement_name").text('<%= bundle.getString("error.achievement.name") %>');
			valid_achie_name = false;
		} else {
			jQuery("#error_achievement_name").text('');
			valid_achie_name = true;
		}
		
		// Validate achie logo
		var achie_logo_val = jQuery.trim(document.frmAchievement.<%= AchievementConst.JA_LOGO %>.value);		
		if( achie_logo_val == "") {
			<% if (achieItem.getSmallImageUrl().trim().length() > 0) {
			%>
				jQuery("#error_achievement_logo").text('');
				valid_achie_logo = true;
			<% } else {
			%>
				jQuery("#error_achievement_logo").text('<%= bundle.getString("error.achievement.logo.empty") %>');
				valid_achie_logo = false;
			<% }
			%>		
		} else {
			jQuery("#error_achievement_logo").text('');
			valid_achie_logo = true;
		}
		
		// Validate achie date
		var achie_date_val = jQuery.trim(document.frmAchievement.<%= AchievementConst.JA_ACHIE_DATE %>.value);		
		if( achie_date_val == "") {
			jQuery("#error_achievement_date").text('<%= bundle.getString("error.achievement.date") %>');
			valid_achie_date = false;
		} else {
			jQuery("#error_achievement_date").text('');
			valid_achie_date = true;
		}
	}
	
	function onSubmitForm(actionMode) {
		var portletActionURL = "";	
		if (actionMode == '<%= RequestConst.ADD_ACHIE %>') {
			portletActionURL = '<portlet:actionURL windowState="exclusive">
									<portlet:param name="struts_action" value="/achievement_mgmt/save_achievement" />
									<portlet:param name="<%= RequestConst.ORG_ID %>" value="<%= orgId %>"></portlet:param>
									<portlet:param name="<%= RequestConst.VIEW_MODE %>" value="<%= viewMode %>"></portlet:param>
									<portlet:param name="<%= RequestConst.ACTION %>" value="<%= RequestConst.ADD_ACHIE %>"></portlet:param>
								</portlet:actionURL>';			
		} else if (actionMode == '<%= RequestConst.EDIT_ACHIE %>'){
			portletActionURL = '<portlet:actionURL windowState="exclusive">
									<portlet:param name="struts_action" value="/achievement_mgmt/save_achievement" />
									<portlet:param name="<%= RequestConst.ORG_ID %>" value="<%= orgId %>"></portlet:param>
									<portlet:param name="<%= RequestConst.VIEW_MODE %>" value="<%= viewMode %>"></portlet:param>
									<portlet:param name="<%= RequestConst.ACTION %>" value="<%= RequestConst.EDIT_ACHIE %>"></portlet:param>
								</portlet:actionURL>';
		} else if (actionMode == '<%= RequestConst.DELETE_ACHIE %>'){
			portletActionURL = '<portlet:actionURL windowState="exclusive">
									<portlet:param name="struts_action" value="/achievement_mgmt/save_achievement" />
									<portlet:param name="<%= RequestConst.ORG_ID %>" value="<%= orgId %>"></portlet:param>
									<portlet:param name="<%= RequestConst.VIEW_MODE %>" value="<%= viewMode %>"></portlet:param>
									<portlet:param name="<%= RequestConst.ACTION %>" value="<%= RequestConst.DELETE_ACHIE %>"></portlet:param>
								</portlet:actionURL>';
		}		
		
		//alert("portletActionURL = " + portletActionURL);
					              
        //document.frmAchievement.action = portletActionURL;
  		//document.frmAchievement.submit();
  		
  		var jQueryform = jQuery("form[name='frmAchievement']");
  		
  		jQueryform.ajaxSubmit({
            url: portletActionURL,
            success: function(data) {
            	var params = data.split(';', 2);
            	//alert(params[0] + " and " + params[1]);
            	if (params[0] == '<%= RequestConst.JA_SUCCESS %>') {
            		if (actionMode == '<%= RequestConst.DELETE_ACHIE%>') {            		
            			cancel();
            		} else {
            			jQuery("#achieve_id").val(params[1]);
            			jQuery("#save_success").css('display', 'block');
            			jQuery("#delete_achie").css('display', 'block');
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
		if ( valid_achie_name == true &&
			 valid_achie_logo == true &&
			 valid_achie_date == true) {			
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
	
	function deleteAchie() {		
		if (confirm('<%= bundle.getString("achievement.delete.confirm") %>')) {
			actionMode = '<%= RequestConst.DELETE_ACHIE %>';
			onSubmitForm('<%= RequestConst.DELETE_ACHIE %>');
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
					document.getElementById("achiemgmt_achievement_date").focus();
				}
			};
			
		jQuery("#achiemgmt_achievement_date").datepicker(pickerOpts); 		
		// End Calendar
	});

</script>
