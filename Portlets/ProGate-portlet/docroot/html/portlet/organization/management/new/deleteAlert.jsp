<div id="dialogDelete" title="<%=res.getString("delete")%>">
	 <div>      
	    <div class="new-manage-org-backgroundAlert">     
           
    	    <div class="new-manage-org-messageDelete">
    	    	<img width="27" height="27" src="/ProGate-portlet/images/confirm.png" alt="" class="new-manage-org-imageAlert">
    	    	<%= res.getString("message_delete_confirm")%>    	    	
    	    </div>
        </div>
      </div> 
</div>
  
	 <script type="text/javascript">
	       jQuery(document).ready(function(){	       		
								
	           jQuery('#deleteOrg').click(function(){
	           	   if (document.documentElement.scrollTop > 0){
                      window.scrollTo(0,0);
                   }
	           
		           jQuery('#dialogDelete').dialog({
		               	 modal:true,
		               	 resizable: false,
		               	 height: 129,
		               	 width:336,				         
				         buttons: {
				         	 "<%=res.getString("yes")%>" : function() {
						        submitForm(document.DeleteOrg);
						      },
						      "<%=res.getString("no")%>" : function() {
						          jQuery('#dialogDelete').dialog("close");
						      }
					     },
					     open: function(event, ui) {
	                         	jQuery('.ui-dialog-buttonpane > button:last').focus();
	                      },	
	                     close: function(event, ui) {
	                     		jQuery('#dialogDelete').focus();
	                     }
		               }); 											               									           
				       jQuery("#dialogDelete").keyup(function(e) {
						    if (e.keyCode == 13) {
						       jQuery("#dialogDelete").dialog("close");
						    }
						}); 
				  
		           });
	       });
    </script> 