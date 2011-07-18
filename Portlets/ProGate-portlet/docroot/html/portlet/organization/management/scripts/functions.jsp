<script type="text/javascript">
window.onload = function () {
	if (document.frmMsg.MsgTxt.value != '') {
		
		var action_user = jQuery("#MsgTxt").val();
		if (action_user == "message_edit_org_successful") {
		   jQuery("#dialog_edit_org").css("display", "block");
              jQuery("#dialog_edit_org").dialog({
              	 modal:true,
              	 resizable: false,
	         width: 336,
	         height: 110,
	         buttons: {
	            "Đóng": function() {jQuery("#dialog_edit_org").dialog("close");	}
	         },
	         open: function(event, ui) {
                	jQuery('.ui-dialog-buttonpane > button:last').focus();
                }											         
              });									                 
             jQuery("#dialog_edit_org").keyup(function(e) {
		     if (e.keyCode == 13) {
		       jQuery("#dialog_edit_org").dialog("close");
		     }
		  }); 			
		}
		if (action_user == "message_create_org_successful"){
			//jAlert('<fmt:message key="message_create_org_successful"/>', '<fmt:message key="/organization_management/org_management"/>');
			jQuery("#dialog_create_org").css("display", "block");
			jQuery("#dialog_create_org").dialog({
              	  modal:true,
              	  resizable: false,
	          width: 300,
	          height: 110,
	          buttons: {
	            "Đóng": function() {jQuery("#dialog_create_org").dialog("close");	}
	          },
	          open: function(event, ui) {
                	jQuery('.ui-dialog-buttonpane > button:last').focus();
                 }											         
            });									                 
               jQuery("#dialog_create_org").keyup(function(e) {
		      if (e.keyCode == 13) {
		        jQuery("#dialog_create_org").dialog("close");
		    }
		  }); 		
		}	
	}
	document.frmMsg.MsgTxt.value = '';
	<%
		String key_search = (String)request.getAttribute("key_search");
	    key_search = (key_search == null ? "" : key_search);
	%>
	document.getElementById("search_txt").value = "<%= key_search%>";
	document.getElementById("search_txt").focus();
}

function pagingSubmit(url) {
	var url = '<portlet:actionURL portletMode="view"/>';
	
	document.frmOrgManagement.action = url;
    document.frmOrgManagement.submit();
}

/*
 * jQuery ready
 */
jQuery(function() {
	
	// Handle focus and blur event of search texbox
	jQuery("#search_txt").focus();
	jQuery("#search_txt").focus(function(){
		if (jQuery(this).val() == '<fmt:message key="title.organization.name.input"/>') {
			jQuery(this).val('');
		}
	});
	jQuery("#search_txt").blur(function(){
		if (jQuery(this).val() == "") {
			jQuery(this).val('<fmt:message key="title.organization.name.input"/>');	
		}
	});
	// End Focus to search texbox
	    
	// Pagging
	jQuery(".goToLinkPage").click(function(e){
		jQuery("input[name='pageNum']").val(jQuery(this).html());
		
		var portletActionURL = 
			'<portlet:actionURL>
				<portlet:param name="struts_action" value="/organization_management/org_management">
				</portlet:param>
			</portlet:actionURL>';
		
		document.frmOrgManagement.action = portletActionURL;
        document.frmOrgManagement.submit();
		e.preventDefault();
	});
	
	jQuery(".bt-go-pagging").click(function(e){
		
		var txtPageNum = jQuery.trim(jQuery("#page_number").val());
		var integer = /^\d+$/;
		if (!integer.test(txtPageNum)) {
			return;
		}
		else
		{
			var pagesNum = jQuery("input[name='pagesNum']").val();
			if (txtPageNum > pagesNum) txtPageNum = pagesNum; 
			jQuery("input[name='pageNum']").val(txtPageNum);
		
			var portletActionURL = 
				'<portlet:actionURL>
					<portlet:param name="struts_action" value="/organization_management/org_management">
					</portlet:param>
				</portlet:actionURL>';
					
			document.frmOrgManagement.action = portletActionURL;
            document.frmOrgManagement.submit();
        }	
	});

	
	jQuery(".next_page").click(function(e){
		var nextPageNum = jQuery("input[name='pageNum']").val();
		jQuery("input[name='pageNum']").val(parseInt(nextPageNum) + 1);
		
		var portletActionURL = 
			'<portlet:actionURL>
				<portlet:param name="struts_action" value="/organization_management/org_management"></portlet:param>
			</portlet:actionURL>';
			
		document.frmOrgManagement.action = portletActionURL;
        document.frmOrgManagement.submit();

		e.preventDefault();
	});

	
	jQuery(".prev_page").click(function(e){
		var prevPageNum = jQuery("input[name='pageNum']").val();
		jQuery("input[name='pageNum']").val(prevPageNum - 1);
		
		var portletActionURL = 
			'<portlet:actionURL>
				<portlet:param name="struts_action" value="/organization_management/org_management"></portlet:param>
			</portlet:actionURL>';
			
		document.frmOrgManagement.action = portletActionURL;
        document.frmOrgManagement.submit();

        e.preventDefault();
	}); // End Paging

	// Checkbox
	jQuery("#parent_ckb").change(function(e){		
		if(jQuery(this).attr("checked") == true) {			
			jQuery("input[name='child_ckb']").attr("checked",true);
	    }
	    else{	    	
	    	jQuery("input[name='child_ckb']").attr("checked",false);
	    }
	});// End checkobx
	
	// Enable/Disable 
	jQuery(".bt-enable").click(function(e){
		if(jQuery("input[name='child_ckb']:checked").length == 0) {
			jAlert('<fmt:message key="message_choose_organization_warning"/>');
		}
		else {
			var answer =  confirm('<fmt:message key="message_enable_confirm"/>');
			if(answer == true) {
				var portletActionURL = 
					'<portlet:actionURL>
						<portlet:param name="struts_action" value="/organization_management/org_management"/>
						<portlet:param name="<%= Constants.CMD %>" value="<%= Request.ENABLE %>" />
					</portlet:actionURL>';
					
				document.frmOrgManagement.action = portletActionURL;
		        document.frmOrgManagement.submit();
			} else {
				return;
			}			
		}	
	});
	
	jQuery(".bt-disable").click(function(e){
		if(jQuery("input[name='child_ckb']:checked").length == 0) {
			jAlert('<fmt:message key="message_choose_organization_warning"/>');
		}
		else {
			var answer =  confirm('<fmt:message key="message_disable_confirm"/>');
			if(answer == true) {
				var portletActionURL = 
					'<portlet:actionURL><portlet:param name="struts_action" value="/organization_management/org_management"/>
						<portlet:param name="<%= Constants.CMD %>" value="<%= Request.DISABLE %>" />
					</portlet:actionURL>';
				document.frmOrgManagement.action = portletActionURL;
		        document.frmOrgManagement.submit();	
			} else {
				return;
			}			
		}	
	}); // End Eable/Disable

	// Delete
	jQuery(".bt-delete").click(function(e){
		if(jQuery("input[name='child_ckb']:checked").length == 0) {
			jAlert('<fmt:message key="message_choose_organization_warning"/>');
		}
		else {
			var answer =  confirm('<fmt:message key="message_delete_confirm"/>');
			if(answer == true) {
				var portletActionURL = 
					'<portlet:actionURL><portlet:param name="struts_action" value="/organization_management/org_management"/>
						<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
					</portlet:actionURL>';
				document.frmOrgManagement.action = portletActionURL;
		        document.frmOrgManagement.submit();	
			} else {
				return;
			}			
		}			
	}); // End Delete

	// Add new
	jQuery(".bt-new").click(function(e){
		var portletActionURL = 
			'<portlet:renderURL><portlet:param name="struts_action" value="/organization_management/org_new"/>
			</portlet:renderURL>';
		window.location = portletActionURL;
	}); // End Add new

		
	// Search
	function search() {
		var search_org = jQuery("#search_txt").val();
		if(search_org == "") {
			var portletActionURL = '<portlet:actionURL>
										<portlet:param name="struts_action" value="/organization_management/org_management"/>
			                            <portlet:param name="<%= Constants.CMD %>" value="<%= Constants.SEARCH %>" />
			                        </portlet:actionURL>&key_search=all';
			document.frmOrgManagement.action = portletActionURL;
	        document.frmOrgManagement.submit();
		}else if (search_org == '<fmt:message key="title.organization.name.input"/>'){
		
		}else {			
			var portletActionURL = '<portlet:actionURL>
										<portlet:param name="struts_action" value="/organization_management/org_management"/>
			                            <portlet:param name="<%= Constants.CMD %>" value="<%= Constants.SEARCH %>" />
			                        </portlet:actionURL>&key_search=' + search_org;
			document.frmOrgManagement.action = portletActionURL;
	        document.frmOrgManagement.submit();
		}
	}
	// Press enter to search
	jQuery(".txt-search").bind('keydown', function(e) {
        if (e.which == 13) {
        	search();
        }
    });
	
	// Click button to search
	jQuery(".bt-search").click(function(){
		search();
	});
}); 

</script>