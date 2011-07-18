
<%@ include file="/html/portlet/support_org_profile/init.jsp" %>
<%@ include file="/html/portlet/support_org_profile/returnpath.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="com.liferay.portal.util.PortalUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page isELIgnored ="false" %> 
<%@ page import="com.liferay.portal.util.PortalUtil" %>

<%
  
    String title = (String)renderRequest.getParameter("title");
    if (title == null){
    	title = res.getString("addChatOnline");
    }
	renderRequest.setAttribute("title", title);

	String orgId = (String)renderRequest.getParameter("orgId");
	renderRequest.setAttribute("orgId", orgId);
	
	
	String viewMode = (String)renderRequest.getParameter("viewMode");
	if (viewMode == null){
		viewMode = (String)request.getParameter("viewMode");
	}	
	renderRequest.setAttribute("viewMode", viewMode);
%>

<script type="text/javascript">   
	window.onload = function() {
	 
	}
</script>




<div class="support-org">

	<div class="header-guilde">	
	   ${title}
	</div>	

   <div class="foresee" style="display: none;">	   		
		<img style="vertical-align: middle;" src="<%=request.getContextPath()%>/images/news_org/preview.png" width="25" height="25" />
		<%=res.getString("foresee")%>
	</div>
	
	<div  class="note-head">
		<font color="red">(*) Thông tin bắt buộc nhập</font>
	</div>
	
	<%@ include file="showerror.jsp"%>
	<%@ include file="showsuccess.jsp"%>
	<div align="left">
					<br />
						<form action="<portlet:actionURL>
						               <portlet:param name="struts_action" value="/SupportOrgProfile/AddChatOnlineAction" />
						               <portlet:param name="orgId" value="${orgId}" />	
						               <portlet:param name="viewMode" value="${viewMode}" />
						               <portlet:param name="title" value="${title}" />					               
						              </portlet:actionURL>"
				 			method="post" name="addChatOnline">
				 	<input type="hidden" name="currentPerson" id="currentPerson"/>
				 	<div id="chatOnlineList">
				 		<c:forEach var="i" begin="1" end="10" step="1" varStatus="rowCounter">
				 			<c:choose>
				 				<c:when test="${rowCounter.count == 1}">
				 					<div id="person${rowCounter.count}">
				 						<%@ include file="chatonline.jsp"%>
								  </div>
				 				</c:when>
				 				<c:otherwise>
				 					<div id="person${rowCounter.count}" style="display:none;">
				 						<%@ include file="chatonline.jsp"%>	
								  </div>							
				 				</c:otherwise>
				 			</c:choose>
				  			
					  </c:forEach>
				</div>	
			     <div style="clear:both;"></div>
			    
		    	<span style="float:left;padding:7px;margin-left: 24px;">
			    	<a style="color:#30A1BE;text-decoration:none;margin-left: 16px;" id="themDong">
			          <%=res.getString("add-support-user")%>
			        </a>
			    </span>
				<div style="clear:both;"></div>   
			    <div class="save-button" style="padding-left: 354px;">
				    <button id="themChatOnline" class="bt-form" style="height:24px;width:80px;"><font size="3pt" style="font-family: sans-serif; font-size: 13px;"><%=res.getString("save")%></font></button>
                </div>							
	        </form>
	        <form action="${returnPath}" name="cancleAddChatOnline" method="get">
                <div class="cancel-button">
				   	<input type="hidden" id="orgId" name="orgId" value="${orgId}"/>
				   	<input type="hidden" id="viewMode" name="viewMode" value="${viewMode}"/>
				   	<button class="bt-form" type="submit" style="height:24px;width:80px;" onclick="submitForm(document.cancleAddChatOnline)"><font size="3pt" style="font-family: sans-serif; font-size: 13px;"><%=res.getString("cancel")%></font></button>
                </div>
            </form>     	                            
						 		
	</div>
</div>

<div style="display:none;" id="drop-down-image">
	<img style="vertical-align: middle; float: right; margin-top: 2pt;" alt="" 
	     src="/ProGate-portlet/images/support_org_profile/menu_open.gif" class="flag"> 
</div>
<script type="text/javascript">
    function <portlet:namespace />initEditor() {
        return '';
    }
    <c:forEach var="i" begin="1" end="10" step="1" varStatus="rowCounter">
	    jQuery(document).ready(function() {
	            jQuery("#list${rowCounter.count} img.flag").addClass("flagvisibility");
	
	            jQuery("#row${rowCounter.count}").click(function() {
	                jQuery("#list${rowCounter.count}").toggle();
	            });
	                        
	            jQuery("#list${rowCounter.count} li a").click(function() {	            	
	                var text = jQuery(this).html();
	                jQuery("#row${rowCounter.count} span").html(text);
	                jQuery("#row${rowCounter.count} span:eq(1)").append(jQuery("#drop-down-image").html());
	                jQuery("#list${rowCounter.count}").hide();
	            });
	           
	            jQuery(document).bind('click', function(e) {
	                var jQueryclicked = jQuery(e.target);
	                if (! jQueryclicked.parents().hasClass("dropdown"))
	                    jQuery("#list${rowCounter.count}").hide();
	            });
	
	
	            jQuery("#flagSwitcher").click(function() {
	                jQuery("#list${rowCounter.count} img.flag").toggleClass("flagvisibility");
	            });
	        });
	    jQuery("#checkNick${rowCounter.count}").attr("style","clear:both;display:none;");
		jQuery("#checkPosition${rowCounter.count}").attr("style","clear: both;display:none;");
	
	</c:forEach>
	
    var count = 1;
	jQuery('#themDong').click(function(){
		count = count + 1;	
		if (count <= 10){
			jQuery('#person' + count).css("display", "block");	
		}
	});
</script>


<script type="text/javascript">
jQuery(document).ready(function(){	
	jQuery('#themChatOnline').click(function(){	
		var flag = validateChatOnlineForm();
		if (flag){
		  submitForm(document.addChatOnline);	
		}else{
		  return false;		  	
		}		
	});	
});
   
  
   
function validateChatOnlineForm(){	  
   
   var validate = true;
   var i = 1;
   for (i =1;i<=count;i++){
   	   var typeChatOnline = jQuery.trim(jQuery("#row" + i).text());
	   jQuery('#typeChatOnline' + i).val(typeChatOnline);
	  
	   var nick = jQuery.trim(jQuery("#nick" + i).val());
	   jQuery("#nick" + i).val(nick);
	   
	   var position = jQuery("#position" + i).val();
	   
	   
	   if(nick == ''){
			validate = false;
			jQuery("#checkNick" + i).css("display","block");
			jQuery("#checkNick" + i).html("<span class='error'>Bạn chưa nhập yahoo id</span>");
		}else{
			jQuery("#checkNick" + i).css("display","none");
		}	 
		   
		if(position == ''){
			 validate = false;
			 jQuery("#checkPosition" + i).attr("style","clear: both; margin-left: 88px;display:block;");
			 jQuery("#checkPosition" + i).html("<span class='error'>Bạn chưa nhập chức vụ</span>");
		}else{
			 jQuery("#checkPosition" + i).css("display","none");
		}			
   }
   
   jQuery("#currentPerson").val(count);
   
   if (validate == false){
		jQuery("#success").css("display", "none");
		jQuery("#error").css("display", "block");
   }
   return validate;	
    									
}   
</script>