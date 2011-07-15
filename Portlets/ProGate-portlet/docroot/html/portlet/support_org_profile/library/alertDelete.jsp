<div id="guildeDialog">
    <div>      
	    <div class="backgroundAlert">     
            <div class="imageAlert">
            	<img alt="" src="<%=request.getContextPath()%>/images/confirm.png">
            </div>    
    	    <div class="messageDelete">
    	    	<span>
    	    		<%= res.getString("libraryMessage")%>
    	    	</span>
    	    </div>
        </div>
      </div>  
</div>
  
	 <script type="text/javascript">
	       jQuery(document).ready(function(){	       		
								
	           jQuery('#deleteGuilde').click(function(){
	           	   if (document.documentElement.scrollTop > 0){
                      window.scrollTo(0,0);
                   }
	           
		           jQuery('#guildeDialog').dialog({
		               	 modal:true,
		               	 resizable: false,
		               	 height: 129,
		               	 width:336,
				         title: '<%=res.getString("alertTitle")%>',
				         buttons: {
				         	 "<%=res.getString("yes")%>" : function() {
						         submitForm(document.deleteLibrary);
						      },
						      "<%=res.getString("no")%>" : function() {
						          jQuery('#guildeDialog').dialog("close");
						      }
					     },
					     open: function(event, ui) {
	                         	jQuery('.ui-dialog-buttonpane > button:last').focus();
	                      },	
	                     close: function(event, ui) {
	                     		jQuery('#guildeDialog').focus();
	                     }
		               }); 											               									           
				       jQuery("#guildeDialog").keyup(function(e) {
						    if (e.keyCode == 13) {
						       jQuery("#guildeDialog").dialog("close");
						    }
						}); 
				  
		           });
	       });
    </script> 