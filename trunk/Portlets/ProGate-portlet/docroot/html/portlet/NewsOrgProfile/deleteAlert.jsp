<div id="dialogDelete" title="<%=res.getString("delete")%>">
	 <div>      
	    <div class="backgroundAlert">     
            <div class="imageAlert">
            	<img alt="" src="<%=request.getContextPath()%>/images/confirm.png">
            </div>    
    	    <div class="messageDelete">
    	    	<span>
    	    		<%= res.getString("deleteNews")%>
    	    	</span>
    	    </div>
        </div>
      </div> 
</div>
  
	 <script type="text/javascript">
	       jQuery(document).ready(function(){	       		
								
	           jQuery('#deleteNews').click(function(){
	           	   if (document.documentElement.scrollTop > 0){
                      window.scrollTo(0,0);
                   }
	           
	           jQuery('#dialogDelete').dialog({
	               	 modal:true,
	               	 resizable: false,
	               	 height: 129,
	               	 width:336,
			         title: '<%=res.getString("titleDelete")%>',
			         buttons: {
			         	 "<%=res.getString("yes")%>" : function() {
					         submitForm(document.DeleteNewsOrg);
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