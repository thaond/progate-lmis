<div id="questionDialog">
     <div>      
	    <div class="backgroundAlert">     
            <div class="imageAlert">
            	<img alt="" src="<%=request.getContextPath()%>/images/confirm.png">
            </div>    
    	    <div class="messageDelete">
    	    	<span>
    	    		<%= res.getString("questionMessage")%>
    	    	</span>
    	    </div>
        </div>
      </div> 
</div>
  
	 <script type="text/javascript">
	       jQuery(document).ready(function(){	       		
								
	           jQuery('#deleteQuestion').click(function(){
	           	   if (document.documentElement.scrollTop > 0){
                      window.scrollTo(0,0);
                   }
	           
		           jQuery('#questionDialog').dialog({
		               	 modal:true,
		               	 resizable: false,
		               	 height: 129,
		               	 width:336,
		               	 title: '<%=res.getString("alertTitle")%>',
				         buttons: {
				         	 "<%=res.getString("yes")%>" : function() {
						          submitForm(document.deleteQuestion);
						      },
						      "<%=res.getString("no")%>" : function() {
						          jQuery('#questionDialog').dialog("close");
						      }
					     },
					     open: function(event, ui) {
	                         	jQuery('.ui-dialog-buttonpane > button:last').focus();
	                      },	
	                     close: function(event, ui) {
	                     		jQuery('#questionDialog').focus();
	                     }
		               }); 											               									           
				       jQuery("#questionDialog").keyup(function(e) {
						    if (e.keyCode == 13) {
						       jQuery("#questionDialog").dialog("close");
						    }
						}); 
				  
		           });
	       });
    </script> 