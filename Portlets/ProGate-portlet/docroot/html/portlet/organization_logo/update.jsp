<%@page import="larion.progate.service.OrganizationLocalServiceUtil"%>
<%@page import="larion.progate.model.Organization"%>
<%@page import="com.larion.progate.organization.logo.OrganizationImage"%>
<%@ include file="/html/portlet/organization_logo/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
String orgId = request.getParameter(URLParameter_RS.ORG_ID);
ResourceBundle bundle = ResourceBundle.getBundle("content.Language");
String saveLabel = bundle.getString("title.action.save");

OrganizationImage orgLogo = (OrganizationImage)request.getAttribute("orgLogo");
Boolean isNoLogo = orgLogo.isNoImage();

String noLogoURL = "/ProGate-portlet/images/org_no_logo.png";
String logoURL = noLogoURL;
String addOrUpdateLabel = bundle.getString("title.action.addLogo"); 

Organization org = OrganizationLocalServiceUtil.getOrganization(Integer.parseInt(orgId));

if(!isNoLogo){	
	//logoURL = ProGateUtil.getImageURL(orgLogo.getSmallImageId(), request);
    logoURL = org.getLogoId();
	addOrUpdateLabel = bundle.getString("title.action.updateLogo");
}

%>

<div class="grid-b profile-photo">
       <div id="sidebar">
      <div class="current-photo">
        <div class="title">
          <h3><bean:message key="message.logo.currentLogo" /></h3>
        </div>
        <div class="content">
              <img alt="Current Photo" src="<%=logoURL %>" onLoad='scaleImg(this, 178, 148)'>
               <%if(!isNoLogo){ %>
	              <ul>
	                <li>     
	                  <a href="#" id="lb-bt-delete-photo" style="text-decoration:none;"><bean:message key="title.action.deleteLogo" /></a>
	                </li>
	              </ul>
               <%} %>
        </div>
      </div>      
    </div>
  <div id="dialogDelete" title="<bean:message key='title.action.support' />">
	 <div>      
	    <div class="backgroundAlert">     
            <div class="imageAlert">
            	<img alt="" src="<%=request.getContextPath()%>/images/confirm.png">
            </div>    
    	    <div class="messageDelete">
    	    	<span>
    	    		<bean:message key='message.confirm.deleteImage' />
    	    	</span>
    	    </div>
        </div>
      </div> 
  </div>
 <div id="content">      
          
          <form accept-charset="UTF-8" enctype="application/x-www-form-urlencoded" method="post" name="uploadMemberPicture" class="standard-form stacked simple" action="<portlet:actionURL windowState='<%=WindowState.MAXIMIZED.toString() %>'><portlet:param name='struts_action' value='/organization_logo/updateLogo' /></portlet:actionURL>">
    
          <h2><%=addOrUpdateLabel %></h2>
          <div id="private-content">
	          <%@ include file="showerror.jsp"%>
			  <%@ include file="showsuccess.jsp"%>
          </div>
          <p class="instructions">
           <bean:message key="message.upload-image-guide" arg0="JPG, GIF và PNG" arg1="100KB" />
          </p>
            <div class="fieldgroup">
              <input id="organozationLogo-logo-file"  type="file" size="30"  name="<portlet:namespace />file" />
            </div>
            <div id="checkFile" style="display:none;clear:both;margin-bottom:10px;"></div> 
            <input id="lb-image-id" type="hidden" name="<portlet:namespace />Id"  />
            <input  type="hidden" name="<portlet:namespace /><%= URLParameter_RS.FIELD  %>" value="<%= URLParameter_RS.LOGO  %>"  />
            <input type="hidden" name="<portlet:namespace /><%=  URLParameter_RS.ORG_ID %>" value=<%=orgId %> />
          <p class="actions" align="center">
            <input id="lb-bt-submit" name="<portlet:namespace />submit" type="submit" value="<%=saveLabel %>" class="bt-form" />
            <input type="button" style="margin-left:10px;" class="bt-form" value="<bean:message key="title.action.cancel" />" onclick='window.location.href="<%=PortalUtil.getPortalURL(request) %>/<%= ProGateUtil.getConfigValue(renderRequest, ConfigParams_RS.REDIRECT_URL) %>?<%=URLParameter_RS.ORG_ID %>=<%=orgId %>&<%=URLParameter_RS.VIEW_MODE %>=<%=URLParameter_RS.EDIT_MODE %>"' /> 
           </p>
            <p class="note"></p>
          </form>             
      </div>    
  </div>
  
  <script type="text/javascript" >
  
  
  function isValidImageType(value)
  {
	  return /\.(gif|jpeg|jpg|png)$/i.test (value);
  }
  
  function deleteImageAction(){
	   var delete_url = '<portlet:actionURL windowState="exclusive"><portlet:param name="<%=URLParameter_RS.ORG_ID  %>" value="<%= orgId %>" /><portlet:param name="struts_action" value="/organization_logo/delete" /></portlet:actionURL>';
	   
       jQuery.post(delete_url,
    		   {"<portlet:namespace />Id": <%= orgLogo.getImageId() %>,
    	        "field":"logo"
    	        }, 
    		   
    		   function(data, status, response){
    			  window.location.href = "<portlet:renderURL windowState='<%=WindowState.MAXIMIZED.toString() %>'>
    			                               <portlet:param name='struts_action' value='/organization_logo/update'/>
    			                               <portlet:param name='<%=URLParameter_RS.ORG_ID  %>' value='<%= String.valueOf(orgId)  %>' />
    			                            </portlet:renderURL>";		        			  
    		   }, 'html');;
  }
  
jQuery(function() {
	
	jQuery("#lb-bt-submit").click(function(){
		 var fileName = jQuery("#organozationLogo-logo-file").val();
		 if (fileName == '' || !isValidImageType(fileName)){
		 	jQuery("#error").css("display","block");
            jQuery("#success").css("display","none");
            jQuery("#checkFile").css("display","block");
		    jQuery("#checkFile").html("<span class='error'><%= bundle.getString("title.action.error")%></span>");
            return false;
		 }else{
		 	return true; 
		 }
	});
	
	
    jQuery('#organozationLogo-logo-file').change(function(el) {
    	var file_name =	jQuery(this).val();
    	    	
    	if(!isValidImageType(file_name)){
    		jQuery("#error").css("display","block");
            jQuery("#success").css("display","none");
            jQuery("#checkFile").css("display","block");
		    jQuery("#checkFile").html("<span class='error'><%= bundle.getString("title.action.errorBanner")%></span>");
    		return;
    	}else{
    		jQuery("#error").css("display","none");
            jQuery("#success").css("display","none");
            jQuery("#checkFile").css("display","none");
    	}

    	var upload_url = '<portlet:actionURL windowState="exclusive"><portlet:param name="<%=URLParameter_RS.ORG_ID  %>" value="<%= orgId %>" /><portlet:param name="struts_action" value="/organization_logo/upload" /></portlet:actionURL>';
    	
        jQuery(this).upload(upload_url, 
                  function(res) {
        	//res = "1123|/image_galary/image?image_id=1313&t=12341234123|/fjaslfja" 
        
        	var returns = res.split("|");
        	 jQuery("#lb-image-id").val(returns[0]); 
             jQuery("div.current-photo .content img").attr("src", returns[1]);
        }, 'html');
    });
    
   
    <% if (!isNoLogo){%>
		   jQuery("#lb-bt-delete-photo").click(function(){
		      if (document.documentElement.scrollTop > 0){
                      window.scrollTo(0,0);
                }
	           
	           jQuery('#dialogDelete').dialog({
	               	 modal:true,
	               	 resizable: false,
	               	 height: 129,
	               	 width:336,
			         title: '<bean:message key='title.action.support' />',
			         buttons: {
			         	 "<bean:message key='title.action.yes' />" : function() {
					         deleteImageAction();
					      },
					      "<bean:message key='title.action.no' />" : function() {
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
		   
    <% }%>
  
});
</script>