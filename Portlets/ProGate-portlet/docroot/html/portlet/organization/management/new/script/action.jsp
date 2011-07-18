
 <%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<fmt:message key="delete.action" bundle="${msg}" var="delete" />
  <fmt:message key="join.action" bundle="${msg}" var="join" />
  <fmt:message key="delete.many.action" bundle="${msg}" var="deleteMany" />
  
 <fmt:message key="message_delete_confirm-new" bundle="${msg}" var="deleteOrgConfirm">
    <fmt:param value="${delete}"/> 
</fmt:message>

<fmt:message key="message_delete_confirm-new-1" bundle="${msg}" var="deleteOrgConfirm1">
    <fmt:param value="${delete}"/> 
</fmt:message>

 <fmt:message key="message_join_confirm" bundle="${msg}" var="joinOrgConfirm">
    <fmt:param value="${join}"/> 
</fmt:message>

 <fmt:message key="message_success_action" bundle="${msg}" var="deleteOrgMessage">
    <fmt:param value="${delete}"/> 
</fmt:message>

 <fmt:message key="message_success_action" bundle="${msg}" var="deleteManyOrgMessage">
    <fmt:param value="${deleteMany}"/> 
</fmt:message>
 
 <script type="text/javascript" > 
  
  
  function manipulationOrg(obj, orgId){	
	  var disable_url = '<portlet:actionURL windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">  						
	  						<portlet:param name="struts_action" value="/NewManageOrg/org_manage" />
	  					</portlet:actionURL>';
	  var text = jQuery.trim(jQuery("#enable-disable-text", obj).text());
	  if (text == "<%=res.getString("disable")%>"){
	      jQuery.post(disable_url,{"orgId": orgId, "action": "disable"},function(response){
   	 			jQuery("#enable-disable-text", obj).text("<%=res.getString("enable")%>");});	   
	  }else if (text == "<%=res.getString("enable")%>"){	 
	  	   jQuery.post(disable_url,{"orgId": orgId, "action": "enable"},function(response){
   	 			jQuery("#enable-disable-text", obj).text("<%=res.getString("disable")%>");});	  
	  }
  }
  
  function toggleActiveOrg(obj, orgId){  	  
  	  var active_url = '<portlet:actionURL windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">  						
	  						<portlet:param name="struts_action" value="/NewManageOrg/org_manage" />
	  					</portlet:actionURL>';
	  var text = jQuery.trim(jQuery("#typical-normal-text", obj).text());
  	  	
  	  if (text == "<%=res.getString("org.typical")%>"){
  	  	 jQuery.post(active_url,{"orgId": orgId, "action": "inactive"},function(response){
   	 		jQuery("#typical-normal-text", obj).text("<%=res.getString("org.normal")%>");
   	 		jQuery("#typical-normal-image-" + orgId).removeClass("hightlights-org-enable").addClass("hightlights-org-disable");});
	  	 
	  }else if (text == "<%=res.getString("org.normal")%>"){
	  	 jQuery.post(active_url,{"orgId": orgId, "action": "active"},function(response){
   	 		jQuery("#typical-normal-text", obj).text("<%=res.getString("org.typical")%>");
   	 		jQuery("#typical-normal-image-" + orgId).removeClass("hightlights-org-disable").addClass("hightlights-org-enable");});	  	 	
	  }		
  }
  
  function deleteOrg(orgId, orgName){
  		jQuery('#dialogDeleteOrg p').html("${deleteOrgConfirm}" + "<span class='new-manage-org-name-alert'>" + orgName + "</span>&nbsp;"
  		      +"<%= res.getString("message_question")%>");
  		
		jQuery('#dialogDeleteOrg').dialog({
	       	 modal:true,
	       	 resizable: false,
	       	 height: 140,
	       	 width:480,	
	       	 title:"<%=res.getString("deleteOrg")%>",			         
	         buttons: {
	           	"<%=res.getString("yes")%>" : function() {
	           		 var delete_url =  '<portlet:actionURL windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">  						
					  						<portlet:param name="struts_action" value="/NewManageOrg/org_manage" />
					  					</portlet:actionURL>';
	 				 jQuery.post(delete_url, {"orgId": orgId, "action":"delete"}, function(){
	 				   jQuery("#dialogDeleteOrg").dialog("close");
	 				   jQuery('#dialogDeleteOrg p').html("${deleteOrgMessage}" + "<span class='new-manage-org-name-alert'>" + orgName + 
	 						   "</span>&nbsp;" +"<%= res.getString("message_success")%>");
					   jQuery('#dialogDeleteOrg').dialog({
					    	 modal:true,
					       	 resizable: false,
					       	 height: 128,
					       	 width:370,	
					       	 title:"<%=res.getString("deleteOrg")%>",
					       	 buttons: {
								"<%=res.getString("action.ok")%>" : function() {window.location.reload();}
							 }
					    });
	 				 });
	           	},
		        "<%=res.getString("no")%>" : function() {
		            jQuery('#dialogDeleteOrg').dialog("close");
		            jQuery('input[type="checkbox"]:checked').each(function(){
		    			this.checked = false;
		    	  	});
		         }
	          },
		     open: function(event, ui) {
	                 	jQuery('.ui-dialog-buttonpane > button:last').focus();
	         },	
	         close: function(event, ui) {
	             		jQuery('#dialogDeleteOrg').focus();
	         }
	     }); 		
         	
      jQuery("#dialogDeleteOrg").keyup(function(e) {
	      if (e.keyCode == 13) {
	         jQuery("#dialogDeleteOrg").dialog("close");
	      }
	  }); 	  
  }
    
  function deleteManyOrg(){
  
  		var val = [];
	  	var c;
	  	jQuery('input[type="checkbox"]:checked').each(function(i){
	  	        c = jQuery(this).val();
	  	        if (c != "0"){
	  	        	val[i] = c;	
	  	        }
	  	});
		if (val.join(";") == ''){
			jQuery('#dialogDeleteOrg p').html("<%=res.getString("message_delete_no_org")%>");
			jQuery('#dialogDeleteOrg').dialog({
		       	 modal:true,
		       	 resizable: false,
		       	 height: 115,
		       	 width:225,	
		       	 title:"<%=res.getString("deleteOrg")%>",
		       	 buttons:{
		       	 	"<%=res.getString("action.ok")%>" : function() {jQuery("#dialogDeleteOrg").dialog("close");}
		       	 }	
		 	});
	    }else{
		        jQuery('#dialogDeleteOrg p').html("${deleteOrgConfirm1}");
		        
		    	jQuery('#dialogDeleteOrg').dialog({
			       	 modal:true,
			       	 resizable: false,
			       	 height: 130,
			       	 width:370,	
			       	 title:"<%=res.getString("deleteOrg")%>",			         
			         buttons: {
			           	"<%=res.getString("yes")%>" : function() {
			           		 var delete_url =  '<portlet:actionURL windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">  						
					  						<portlet:param name="struts_action" value="/NewManageOrg/org_manage" />
					  					</portlet:actionURL>';
	 				 		 jQuery.post(delete_url, {"orgIds": val.join(";"), "action":"deleteManyOrg"}, function(){
	 				 		 	   jQuery("#dialogDeleteOrg").dialog("close");
				 				   jQuery('#dialogDeleteOrg p').html("${deleteManyOrgMessage}" + "<%= res.getString("message_success")%>");
								   jQuery('#dialogDeleteOrg').dialog({
								   		 modal:true,
								       	 resizable: false,
								       	 height: 80,
								       	 width:370,	
								       	 title:"<%=res.getString("deleteOrg")%>",
								       	 buttons: {
											"<%=res.getString("action.ok")%>" : function() {window.location.reload();}
										 }								   
								   });
	 				 		 }); 			 				 
			           	},
				        "<%=res.getString("no")%>" : function() {
				            jQuery('#dialogDeleteOrg').dialog("close");
				            jQuery('input[type="checkbox"]:checked').each(function(){
				    			this.checked = false;
				    	  	});					  	       
				         }
			          },
				     open: function(event, ui) {
			                 	jQuery('.ui-dialog-buttonpane > button:last').focus();
			         },	
			         close: function(event, ui) {
			             		jQuery('#dialogDeleteOrg').focus();
			         }
			     });
		    	jQuery("#dialogDeleteOrg").keyup(function(e) {
				      if (e.keyCode == 13) {
				         jQuery("#dialogDeleteOrg").dialog("close");
				      }
				 }); 	
		}	
  }  
  
  function joinOrg(orgId, orgName){
	  alert("joinOrg");
  	  jQuery('#dialogDeleteOrg p').html("${joinOrgConfirm}" + "&nbsp;<span class='new-manage-org-name-alert'>" + orgName + "</span>&nbsp;" +"<%= res.getString("message_question")%>");
  	  jQuery('#dialogDeleteOrg').dialog({
  	  		 modal:true,
	       	 resizable: false,
	       	 height: 130,
	       	 width:500,		
	       	 title:"<%=res.getString("joinOrg")%>",
	       	 buttons:{
       	 		"<%=res.getString("yes")%>" : function() {
	           		 var join_url =  '<portlet:actionURL windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">  						
			  						<portlet:param name="struts_action" value="/NewManageOrg/org_manage" />
			  					</portlet:actionURL>';
			 		 jQuery.post(join_url, {"orgId": orgId, "typeOfRequest": 1, "action":"join"}, function(){
			 		 	   jQuery("#dialogDeleteOrg").dialog("close");
		 				   jQuery('#dialogDeleteOrg p').html("<%=res.getString("message_success_join")%>" + "&nbsp;" + "<span class='new-manage-org-name-alert'>" + orgName + "</span>&nbsp;" +"<%= res.getString("message_success")%>");
						   jQuery('#dialogDeleteOrg').dialog({
						   		 modal:true,
						       	 resizable: false,
						       	 height: 130,
	       						 width:480,	
						       	 title:"<%=res.getString("joinOrg")%>",
						       	 buttons: {
									"<%=res.getString("action.ok")%>" : function() {window.location.reload();}
								 }								   
						   });
			 		 }); 			 				 
	           	},
	       	 	"<%=res.getString("no")%>" : function() {jQuery("#dialogDeleteOrg").dialog("close");}
	       	 },
	       	 open: function(event, ui) {
	                 	jQuery('.ui-dialog-buttonpane > button:last').focus();
	         },	
	         close: function(event, ui) {
	             		jQuery('#dialogDeleteOrg').focus();
	         }	
  	  });
  	  
  	  jQuery("#dialogDeleteOrg").keyup(function(e) {
	      if (e.keyCode == 13) {
	         jQuery("#dialogDeleteOrg").dialog("close");
	      }
	  }); 	
  }
  
  function leaveOrg(orgId, orgName){
  	  jQuery('#dialogDeleteOrg p').html("<%=res.getString("message.leave.org")%>" + "&nbsp;<span class='new-manage-org-name-alert'>" + orgName + "</span>&nbsp;" +"<%= res.getString("message_question")%>");
  	  jQuery('#dialogDeleteOrg').dialog({
  	  		 modal:true,
	       	 resizable: false,
	       	 height: 130,
	       	 width:500,		
	       	 title:"<%=res.getString("joinOrg")%>",
	       	 buttons:{
       	 		"<%=res.getString("yes")%>" : function() {
	           		 var join_url =  '<portlet:actionURL windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">  						
			  						<portlet:param name="struts_action" value="/NewManageOrg/org_manage" />
			  					</portlet:actionURL>';
			 		 jQuery.post(join_url, {"orgId": orgId, "typeOfRequest": 0, "action":"leave"}, function(){
			 		 	   jQuery("#dialogDeleteOrg").dialog("close");
		 				   jQuery('#dialogDeleteOrg p').html("<%=res.getString("message.leave.org.success")%>&nbsp;" + "<span class='new-manage-org-name-alert'>" + orgName + "</span>&nbsp;" +"<%= res.getString("message_success")%>");
						   jQuery('#dialogDeleteOrg').dialog({
						   		 modal:true,
						       	 resizable: false,
						       	 height: 130,
	       						 width: 480,	
						       	 title:"<%=res.getString("joinOrg")%>",
						       	 buttons: {
									"<%=res.getString("action.ok")%>" : function() {window.location.reload();}
								 }								   
						   });
			 		 }); 			 				 
	           	},
	       	 	"<%=res.getString("no")%>" : function() {jQuery("#dialogDeleteOrg").dialog("close");}
	       	 },
	       	 open: function(event, ui) {
	                 	jQuery('.ui-dialog-buttonpane > button:last').focus();
	         },	
	         close: function(event, ui) {
	             		jQuery('#dialogDeleteOrg').focus();
	         }	
  	  });
  	  
  	  jQuery("#dialogDeleteOrg").keyup(function(e) {
	      if (e.keyCode == 13) {
	         jQuery("#dialogDeleteOrg").dialog("close");
	      }
	  }); 	
  }
  
  function acceptToLeave(orgId, orgName){
  		 var active_url = '<portlet:actionURL windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">  						
	  						<portlet:param name="struts_action" value="/NewManageOrg/org_manage" />
	  					</portlet:actionURL>';
	  	 jQuery.post(active_url,{"orgId": orgId, "typeOfRequest": 4, "action":"leave"},function(response){
   	 		jQuery('#dialogDeleteOrg p').html("<%=res.getString("message_success_leave")%>" + "&nbsp;<span class='new-manage-org-name-alert'>" + orgName + "</span>&nbsp;" +"<%= res.getString("message_success")%>");
  	  		jQuery('#dialogDeleteOrg').dialog({
	  	  		 modal:true,
		       	 resizable: false,
		       	 height: 130,
		       	 width: 480,		
		       	 title:"<%=res.getString("acceptToLeave")%>",
		       	 buttons:{       	 		
		       	 	"<%=res.getString("action.ok")%>" : function() {window.location.reload();}
		       	 },
		       	 open: function(event, ui) {
		                 	jQuery('.ui-dialog-buttonpane > button:last').focus();
		         },	
		         close: function(event, ui) {
		             		jQuery('#dialogDeleteOrg').focus();
		         }	
	  	 	});
  	  
			jQuery("#dialogDeleteOrg").keyup(function(e) {
			      if (e.keyCode == 13) {
			         jQuery("#dialogDeleteOrg").dialog("close");
			      }
			}); 	
   	 	});
  }
  
	function acceptToJoin(orgId, orgName){
		 var active_url = '<portlet:actionURL windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">  						
							<portlet:param name="struts_action" value="/NewManageOrg/org_manage" />
						</portlet:actionURL>';
		 jQuery.post(active_url,{"orgId": orgId, "typeOfRequest": 3, "action":"join"},function(response){
			jQuery('#dialogDeleteOrg p').html("<%=res.getString("message_success_join")%>" + "&nbsp;<span class='new-manage-org-name-alert'>" + orgName + "</span>&nbsp;" +"<%= res.getString("message_success")%>");
			jQuery('#dialogDeleteOrg').dialog({
				 modal:true,
				 resizable: false,
				 height: 130,
				 width:500,		
				 title:"<%=res.getString("acceptToJoin")%>",
				 buttons:{       	 		
					"<%=res.getString("action.ok")%>" : function() {window.location.reload();}
				 },
				 open: function(event, ui) {
							jQuery('.ui-dialog-buttonpane > button:last').focus();
				 },	
				 close: function(event, ui) {
							jQuery('#dialogDeleteOrg').focus();
				 }	
			});
	  
			jQuery("#dialogDeleteOrg").keyup(function(e) {
				  if (e.keyCode == 13) {
					 jQuery("#dialogDeleteOrg").dialog("close");
				  }
			}); 	
		});
	}
	
	function rejectToJoin(orgId, orgName){
		 var active_url = '<portlet:actionURL windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">  						
							<portlet:param name="struts_action" value="/NewManageOrg/org_manage" />
						</portlet:actionURL>';
		 jQuery.post(active_url,{"orgId": orgId, "typeOfRequest": 4, "action":"join"},function(response){
			jQuery('#dialogDeleteOrg p').html("<%=res.getString("message_success_reject_join")%>" + "&nbsp;<span class='new-manage-org-name-alert'>" + orgName + "</span>&nbsp;" +"<%= res.getString("message_success")%>");
			jQuery('#dialogDeleteOrg').dialog({
				 modal:true,
				 resizable: false,
				 height: 130,
				 width:500,		
				 title:"<%=res.getString("rejectToJoin")%>",
				 buttons:{       	 		
					"<%=res.getString("action.ok")%>" : function() {window.location.reload();}
				 },
				 open: function(event, ui) {
							jQuery('.ui-dialog-buttonpane > button:last').focus();
				 },	
				 close: function(event, ui) {
							jQuery('#dialogDeleteOrg').focus();
				 }	
			});
	  
			jQuery("#dialogDeleteOrg").keyup(function(e) {
				  if (e.keyCode == 13) {
					 jQuery("#dialogDeleteOrg").dialog("close");
				  }
			}); 	
		});
	}
  
   function joinOrgConfirm(orgId, orgName){
   		 var active_url = '<portlet:actionURL windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">  						
	  						<portlet:param name="struts_action" value="/NewManageOrg/org_manage" />
	  					</portlet:actionURL>';
	  	 jQuery.post(active_url,{"orgId": orgId, "typeOfRequest": 1, "action":"join"},function(response){
   	 	 	jQuery('#dialogDeleteOrg p').html("<%=res.getString("message_success_join_1")%>" + "&nbsp;<span class='new-manage-org-name-alert'>" + orgName + ".</span>&nbsp;" +"<%= res.getString("message_success_join_2")%>");
  	  		jQuery('#dialogDeleteOrg').dialog({
	  	  		 modal:true,
		       	 resizable: false,
		       	 height: 130,
		       	 width:500,		
		       	 title:"<%=res.getString("joinOrg")%>",
		       	 buttons:{       	 		
		       	 	"<%=res.getString("action.ok")%>" : function() {
		       	 		jQuery("#dialogDeleteOrg").dialog("close");
		       	 		window.location.reload();
		       	 	}
		       	 },
		       	 open: function(event, ui) {
		                 	jQuery('.ui-dialog-buttonpane > button:last').focus();
		         },	
		         close: function(event, ui) {
		             		jQuery('#dialogDeleteOrg').focus();
		         }	
	  	 	});
  	  
			jQuery("#dialogDeleteOrg").keyup(function(e) {
			      if (e.keyCode == 13) {
			         jQuery("#dialogDeleteOrg").dialog("close");
			      }
			}); 	
   	 	});   
   }
 </script>