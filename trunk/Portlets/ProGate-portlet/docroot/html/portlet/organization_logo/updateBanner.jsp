<%@page import="larion.progate.service.OrganizationLocalServiceUtil"%>
<%@page import="com.larion.progate.organization.logo.OrganizationImage"%>
<%@include file="/html/portlet/organization_logo/init.jsp" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="larion.progate.model.Organization"%>

<%
 String orgId = request.getParameter(URLParameter_RS.ORG_ID);
ResourceBundle bundle = ResourceBundle.getBundle("content.Language");
String saveLabel = bundle.getString("title.action.save");
Boolean isNoBanner = true;

OrganizationImage orgBanner = (OrganizationImage)request.getAttribute("orgBanner");
isNoBanner = orgBanner.isNoImage();

String noBannerURL = "/ProGate-portlet/images/org_no_banner.jpg";
String bannerURL = noBannerURL;
String addOrUpdateLabel = bundle.getString("title.action.addBanner"); 
Organization org = OrganizationLocalServiceUtil.getOrganization(Integer.parseInt(orgId));

if(!isNoBanner){
    //bannerURL = ProGateUtil.getImageURL(orgBanner.getLargeImageId(), request);
	bannerURL = org.getBannerId();
    addOrUpdateLabel = bundle.getString("title.action.updateBanner") ;    
}
%>

<table  class="portlet-form" id="content">
    <tr>
        <td style="padding-left:10px;">
            <h3> <%=addOrUpdateLabel %> </h3>
            <hr />
        </td>
    </tr> 
    <tr>
        <td style="padding-bottom:10px;">
            <%@ include file="showerror.jsp"%>
			<%@ include file="showsuccess.jsp"%>
        </td>
    </tr> 
    <tr>
        <td align="right" style="padding-right:10px;">
            <%if(!isNoBanner){ %>
            <img style="vertical-align: middle;" src="<%=request.getContextPath()%>/images/news_org/delete.png" width="25" height="25" />            
	        <a href="#" class="btn-delete" id="lb-bt-delete-photo" style="text-decoration:none;">
                <bean:message key="title.action.delete" />
            </a> 
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
            <%} %>
        </td>
    </tr>       
    <tr>
        <td align="center">              
           <div id="lb-banner"> 
            <img src="<%= bannerURL %>"  onLoad='scaleImg(this, 750, 90)'/>
           </div>
        </td>
    </tr>
    <tr>
        <td align="left" class="portlet-form-content">
            <form enctype="application/x-www-form-urlencoded" method="post" class="standard-form stacked simple" name="lb-form-update-banner" id="lb-form-update-banner" action="<portlet:actionURL windowState='<%=WindowState.MAXIMIZED.toString() %>'><portlet:param name='struts_action' value='/organization_logo/updateLogo' /></portlet:actionURL>" >
            <p class="instructions">
                  <bean:message key="message.upload-image-guide-banner" arg0="JPG, GIF và PNG" arg1="100KB" />
            </p>
            <input id="organozationLogo-banner-file" type="file" name="<portlet:namespace />file" tabindex="0" size="140" value="<bean:message key='browse' />" />
            <div id="checkFile" style="display:none;clear:both;margin-bottom:10px;"></div> 
            
             <input type="hidden" name="<portlet:namespace />Id" />
             <input type="hidden" name="<portlet:namespace /><%= URLParameter_RS.FIELD %>" value="<%= URLParameter_RS.BANNER %>" />
             <input type="hidden" name="<%= URLParameter_RS.ORG_ID  %>"  value="<%=orgId %>"    />           
             <p class="actions" align="center">
                <input id="lb-bt-submit" name="<portlet:namespace />submit" type="submit" value="<%=saveLabel %>" class="bt-form">
                <input type="button" style="margin-left:10px;" class="bt-form" value="<bean:message key="title.action.cancel" />" onclick='window.location.href="<%=PortalUtil.getPortalURL(request) %>/<%= ProGateUtil.getConfigValue(renderRequest, ConfigParams_RS.REDIRECT_URL) %>?<%=URLParameter_RS.ORG_ID %>=<%=orgId %>&<%=URLParameter_RS.VIEW_MODE %>=<%=URLParameter_RS.EDIT_MODE %>"' />
            </p>
            <p class="note">
                
             </p>
            </form>  
        </td>
    </tr>    
</table>

  
  <script type="text/javascript" >
  
  function isValidImageType(value)
  {
      return /\.(gif|jpeg|jpg|png)$/i.test (value);
  }
  
  function deleteImageAction(){
  	   var delete_url = '<portlet:actionURL windowState="exclusive"><portlet:param name="<%=URLParameter_RS.ORG_ID  %>" value="<%= orgId %>" /><portlet:param name="struts_action" value="/organization_logo/delete" /></portlet:actionURL>';
      
     jQuery.post(delete_url,
           {"<portlet:namespace /><%= URLParameter_RS.ID %>": <%= orgBanner.getImageId() %>,
	        "field": "<%= URLParameter_RS.BANNER%>"                            },
           
           function(data, status, response){                              
              window.location.href = "<portlet:renderURL windowState='<%=WindowState.MAXIMIZED.toString() %>'>
					                     <portlet:param name='struts_action' value='/organization_logo/updateBanner'/>
					                     <portlet:param name='<%=URLParameter_RS.ORG_ID  %>' value='<%= String.valueOf(orgId)  %>' />
					                  </portlet:renderURL>";   
              //window.location.href = "<%=PortalUtil.getPortalURL(request) %>/<%= ProGateUtil.getConfigValue(renderRequest, ConfigParams_RS.REDIRECT_URL) %>?<%=URLParameter_RS.ORG_ID %>=<%=orgId %>&<%=URLParameter_RS.VIEW_MODE %>=<%=URLParameter_RS.EDIT_MODE %>";
            
           }, 'html');;                   
       
  }
  
jQuery(function() {
    
    jQuery("#lb-bt-submit").click(function(){
		 var fileName = jQuery("#organozationLogo-banner-file").val();
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
    
    jQuery('#lb-form-update-banner input[type=file]').change(function(el) {
        var file_name = jQuery(this).val();
                
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
                 
            var returns = res.split("|");
             jQuery("#lb-form-update-banner input[name=<portlet:namespace />Id]").val(returns[0]); 
             jQuery("#lb-banner img").attr("src", returns[2]);
        }, 'html');
    });
    

    <% if (!isNoBanner){%>
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