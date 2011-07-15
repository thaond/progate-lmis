<%@page import="larion.progate.service.OrganizationLocalServiceUtil"%>
<%@page import="com.larion.progate.organization.logo.OrganizationImage"%>
<%@page import="larion.progate.model.Organization"%>
<%@ include file="/html/portlet/organization_logo/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript" src="/ProGate-portlet/js/util.js"></script>
<script type="text/javascript" src="/ProGate-portlet/js/scaleImg.js"></script>

<%

String logoURL = "/ProGate-portlet/images/org_no_logo.png";
String bannerURL = "/ProGate-portlet/images/org_no_banner.jpg";

ResourceBundle bundle = ResourceBundle.getBundle("content.Language");
String actionLabel = bundle.getString("title.action.add");
String updateBannerLabel = bundle.getString("title.action.add");
String updateLabel = bundle.getString("title.action.update");
String saveLabel = bundle.getString("title.action.save");
String defaultSlogan = bundle.getString("message.defaultSlogan");

OrganizationImage orgLogo = (OrganizationImage)request.getAttribute("orgLogo");
OrganizationImage orgBanner = (OrganizationImage)request.getAttribute("orgBanner");

Boolean isNoLogo = orgLogo.isNoImage();
Boolean isNoBanner = orgBanner.isNoImage();

String slogan = "";
String orgName = orgLogo.getOrgName();
Integer orgId = orgLogo.getOrgId();
Boolean isEditable = ProGateUtil.isEditable(PortalUtil.getUserId(request),orgId);;
Boolean isEditMode =  ProGateUtil.isEditMode(PortalUtil.getOriginalServletRequest(request));;
// Update Code on Mar 17, 2011
String org_Id = (String)request.getAttribute(URLParameter_RS.ORG_ID);
Organization org = OrganizationLocalServiceUtil.getOrganization(Integer.parseInt(org_Id));

if(!isNoLogo){
	//logoURL = ProGateUtil.getImageURL(orgLogo.getSmallImageId(), request);
	logoURL = org.getLogoId();
	actionLabel = bundle.getString("title.action.updateLogo");
}
	
if(!isNoBanner){
	//bannerURL = ProGateUtil.getImageURL(orgBanner.getLargeImageId(), request);	    
	bannerURL = org.getBannerId();
    updateBannerLabel = bundle.getString("title.action.updateBanner");	 
}	

if(orgLogo.getOrganization() != null){
	slogan = orgLogo.getOrganization().getSlogan();	
}	

if((slogan == null || slogan.equals("")) && isEditMode ){
	slogan = defaultSlogan;
}

%>

<div class="lb-layout-common org-profile-layout-column-1">
	<div class="lb-logo-layout">
			<div class="lb-logo-content">
			  <img src="<%=logoURL %>" alt="logo" onLoad='scaleImg(this, 178, 148)' style="display: none;"/>		  	  
			  <% if (isEditable && isEditMode){ %>			    
			      <a href="<portlet:renderURL windowState='<%=WindowState.MAXIMIZED.toString() %>'>
			         <portlet:param name='struts_action' value='/organization_logo/update'/>
			         <portlet:param name='<%=URLParameter_RS.ORG_ID  %>' value='<%= String.valueOf(orgId)  %>' />
			         </portlet:renderURL>" > <%=actionLabel %></a>
			          
			  <% } %>			
			</div>
		</div>
		<div class="lb-banner-layout">
				
		<div class="lb-tr-content">
			<div id="lb-org-name"> 
		         <div class="original"><%= orgName%></div>
		          <div class='new-text'>
                        <input tabindex="1" class='user-edit' size="50" maxlength="75" />
                        <script type="text/javascript">
						 	jQuery("#lb-org-name .user-edit").keydown(function(event){
					       		if(event.keyCode == 9 || event.keyCode == 8 || event.keyCode == 191 
					       		   || event.keyCode == 37 || event.keyCode == 39){       			
					       		}else{
					       		    if (this.value.length > 75){
					       		    	return false;
					       		    }												       			
					       		}       		
							});
						</script>
                        <input tabindex="2" type='submit' class='lb-org-send btn-primary' value=' <bean:message key="title.action.save" /> ' /> 
                        <input tabindex="3" type='submit' class='lb-org-cancel  btn-primary' value=' <bean:message key="title.action.cancel" /> ' />
                     </div>
			 </div>
			<div  id="lb-org-slogan">
			          <div class="original"><%= slogan %></div>
			          <div class='new-text'>
                        <input tabindex="4" class='user-edit' size="50" maxlength="180" />
                        <script type="text/javascript">
						 	jQuery("#lb-org-slogan .user-edit").keydown(function(event){
					       		if(event.keyCode == 9 || event.keyCode == 8 || event.keyCode == 191 
					       		   || event.keyCode == 37 || event.keyCode == 39){       			
					       		}else{
					       		    if (this.value.length > 180){
					       		    	return false;
					       		    }												       			
					       		}       		
							});
						</script>
                        <input tabindex="5" type='submit' class='lb-org-send  btn-primary' value=' <bean:message key="title.action.save" /> ' /> 
                        <input tabindex="6" type='submit' class='lb-org-cancel  btn-primary' value=' <bean:message key="title.action.cancel" /> ' />
                     </div>
                     
			</div>
		</div>
		<div class="lb-banner-tr">
		 <img src="<%=bannerURL %>" alt="logo" onLoad='scaleImg(this, 750, 90)' style="display: none;"/>
		  <% if (isEditable && isEditMode){ %>                
                  <a href="<portlet:renderURL windowState='<%=WindowState.MAXIMIZED.toString() %>'>
                     <portlet:param name='struts_action' value='/organization_logo/updateBanner'/>
                     <portlet:param name='<%=URLParameter_RS.ORG_ID  %>' value='<%= String.valueOf(orgId)  %>' />
                     
                     </portlet:renderURL>" > <%= updateBannerLabel %></a>
                      
              <% } %>   		
		</div>
		
	</div>
</div>

<script type="text/javascript">
jQuery(function() {

	  <% if (isEditable && isEditMode){ %>     
	var url = '<portlet:actionURL windowState="exclusive"><portlet:param name="<%=URLParameter_RS.ORG_ID  %>" value="<%= String.valueOf(orgId) %>" /><portlet:param name="struts_action" value="/organization_logo/updateSlogan" /></portlet:actionURL>'; 
	jQuery('#lb-org-slogan').inlineEdit({
         display: '.original',
         form: '.new-text',
         text: '.user-edit',
         save: '.lb-org-send',
         postVar: '<portlet:namespace />slogan',
         cancel: '.lb-org-cancel',
         hover: 'lb-inline-edit-hover',
         href: url
     });
	
	jQuery('#lb-org-name').inlineEdit({
        display: '.original',
        form: '.new-text',
        text: '.user-edit',
        save: '.lb-org-send',
        cancel: '.lb-org-cancel',
        postVar: '<portlet:namespace />name',        
        hover: 'lb-inline-edit-hover',
        href: url
    });
    <%}%>
 
});
</script>