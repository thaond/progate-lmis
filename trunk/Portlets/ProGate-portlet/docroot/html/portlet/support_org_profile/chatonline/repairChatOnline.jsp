<%@ include file="/html/portlet/support_org_profile/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="com.liferay.portal.util.PortalUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />

<%@ page import="larion.progate.model.User"%>
<%@ page import="larion.progate.service.UserLocalServiceUtil"%>
<%@ page import="larion.progate.model.ProGateJournalArticle"%>
<%@ page import="larion.progate.service.ProGateJournalArticleLocalServiceUtil"%>
<%@ page import="larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil"%>
<%@ page import="javax.portlet.PortletURL"%> 
<%
	String orgId = renderRequest.getParameter("orgId");
	if (orgId == null){
		orgId = (String)renderRequest.getAttribute("orgId");
	}
	renderRequest.setAttribute("orgId", orgId);
	
	String title = (String)renderRequest.getParameter("title");
	title = (title == null) ? res.getString("repairChatOnline") : title;
	renderRequest.setAttribute("title", title);	
	
	// lay cac chatOnline
    String chatOnlineType = ProGateJournalArticleTypesLocalServiceUtil.getArticleTypeOrgSupportOnline();
    int sumOfChatOnline = ProGateJournalArticleLocalServiceUtil.countArticleByType(Integer.valueOf(orgId), chatOnlineType, "");
    List< ProGateJournalArticle> chatOnlineList = ProGateJournalArticleLocalServiceUtil.getListProGateArticles(Integer.valueOf(orgId), chatOnlineType, "", 0, sumOfChatOnline);
    renderRequest.setAttribute("sumOfChatOnline", sumOfChatOnline);
    System.out.println("sumOfChatOnline =" + sumOfChatOnline);
    if (sumOfChatOnline > 0){
    	renderRequest.setAttribute("chatOnlineList", chatOnlineList);
    }
	
	String viewMode = (String)renderRequest.getParameter("viewMode");
	renderRequest.setAttribute("viewMode", viewMode);
%>
<script type="text/javascript">   
	window.onload = function() {
	 
	}
</script>
<div class="news-org">

	<div class="header-repair">	
	   <%=title%>
	</div>	

   <div class="foresee">	
   <a id="deleteChatOnline" style="text-decoration:none;">	 
		<img style="vertical-align: middle;" src="<%=request.getContextPath()%>/images/support_org_profile/delete.png" width="25" height="25" />
			<%=res.getString("delete")%></a>
			<div style="display: none;">
			&nbsp;&nbsp;|
		<img style="vertical-align: middle;" src="<%=request.getContextPath()%>/images/support_org_profile/preview.png" width="25" height="25" />
		<%=res.getString("foresee")%></div>
	</div>

	<div id="dialogDeleteChatOnline">
		<div>      
		    <div class="backgroundAlert">     
	            <div class="imageAlert">
	            	<img alt="" src="<%=request.getContextPath()%>/images/confirm.png">
	            </div>    
	    	    <div class="messageDelete">
	    	    	<span>
	    	    		<%= res.getString("deleteChatOnlineMessage")%>
	    	    	</span>
	    	    </div>
	        </div>
	      </div>
	</div>
  
	 <script type="text/javascript">
	       jQuery(document).ready(function(){	       		
								
	           jQuery('#deleteChatOnline').click(function(){
	           	   if (document.documentElement.scrollTop > 0){
                      window.scrollTo(0,0);
                   }
	           
		           jQuery('#dialogDeleteChatOnline').dialog({
		               	 modal:true,
		               	 resizable: false,
		               	 height: 129,
		               	 width:336,
				         title: '<%=res.getString("alertTitle")%>',
				         buttons: {
				         	 "<%=res.getString("yes")%>" : function() {
				         	     
				         	      var val = [];
						      	  var c;
						      	  jQuery('input[type="checkbox"]:checked').each(function(i){
						      	        c = jQuery(this).val();
						      	        if (c != "0"){
						      	        	val[i] = c;	
						      	        }
						      	  });
						      	  
						      	  jQuery("#idOfDeletePerson").val(val.join(";"));
				         	 	
						          submitForm(document.DeleteChatOnline);
						         
						      },
						      "<%=res.getString("no")%>" : function() {
						      	  
						          jQuery('#dialogDeleteChatOnline').dialog("close");
						      }
					     },
					     open: function(event, ui) {
	                         	jQuery('.ui-dialog-buttonpane > button:last').focus();
	                      },	
	                     close: function(event, ui) {
	                     		jQuery('#dialogDeleteChatOnline').focus();
	                     }
		               }); 											               									           
				       jQuery("#dialogDeleteChatOnline").keyup(function(e) {
						    if (e.keyCode == 13) {
						       jQuery("#dialogDeleteChatOnline").dialog("close");
						    }
						}); 
				  
		           });
	       });
    </script> 
    
	<div  class="note-head">
		<font color="red">(*) Thông tin bắt buộc nhập</font>
	</div>
	
	<%@ include file="showerror.jsp"%>
	<%@ include file="showsuccess.jsp"%>
	<div align="left">
					<br />
						<form action="<portlet:actionURL>
						               <portlet:param name="struts_action" value="/SupportOrgProfile/RepairChatOnlineAction" />
						               <portlet:param name="orgId" value="${orgId}" />
						               <portlet:param name="viewMode" value="${viewMode}" />
						               <portlet:param name="title" value="<%=title%>" />
						              </portlet:actionURL>" method="post" name="repairChatOnline">
								<div id="chatOnlineList">
								<input type="hidden" name="currentPerson" id="currentPerson" value="${sumOfChatOnline}"/>
								<input type="hidden" name="sumOfPerson" id="sumOfPerson" />								
								<c:forEach var="person" items="${chatOnlineList}" varStatus="rowCounter">
									<div class="checkHidden">
										<input type="checkbox" name="person${rowCounter.count}" id="person${rowCounter.count}" 
											value="${person.journalArticleId}"/>
									</div>
									<div style="float:left;">
										<dl id="sample" class="dropdown sample">
									        <dt>
									        	<a href="javascript:void(0);" id="row${rowCounter.count}"><span>
									        		<c:choose>
									        			<c:when test="${person.description eq 'Yahoo! Messenger'}">
									        				<img class="flag" src="<%=request.getContextPath()%>/images/support_org_profile/yahoo.jpeg" alt="" 
										                	 style="float: left;vertical-align: middle;"/>
										                	<img style="vertical-align: middle; float: right; margin-top: 5pt;" alt="" 
	                											src="/ProGate-portlet/images/support_org_profile/menu_open.gif" class="flag"> 
										                	 <span style="padding-top:5px;"><%= res.getString("yahoo")%></span>
									        			</c:when>
									        			<c:when test="${person.description eq 'Skype'}">
									        				<img class="flag" src="<%=request.getContextPath()%>/images/support_org_profile/skype.jpg" alt="" style="float:left;"/>
									                		<img style="vertical-align: middle; float: right; margin-top: 5pt;" alt="" 
	                											src="/ProGate-portlet/images/support_org_profile/menu_open.gif" class="flag"> 
									                		<span style="padding-top:5px;"><%= res.getString("skype")%></span>
									        			</c:when>
									        			<c:when test="${person.description eq 'Window Live Messenger'}">
									        				<img class="flag" src="<%=request.getContextPath()%>/images/support_org_profile/window.jpeg" alt="" style="float:left;"/>
									                		<img style="vertical-align: middle; float: right; margin-top: 5pt;" alt="" 
	                											src="/ProGate-portlet/images/support_org_profile/menu_open.gif" class="flag"> 
									                		<span style="padding-top:5px;"><%= res.getString("window")%></span>
									        			</c:when>
									        			<c:when test="${person.description eq 'ICQ'}">
									        				<img class="flag" src="<%=request.getContextPath()%>/images/support_org_profile/ICQ.jpeg" alt="" style="float:left;"/>
									                		<img style="vertical-align: middle; float: right; margin-top: 5pt;" alt="" 
	                											src="/ProGate-portlet/images/support_org_profile/menu_open.gif" class="flag"> 
									                		<span style="padding-top:5px;"><%= res.getString("icq")%></span>
									        			</c:when>
									        			<c:when test="${person.description eq 'GTalk'}">
									        				<img class="flag" src="<%=request.getContextPath()%>/images/support_org_profile/googleTalk.jpeg" alt="" style="float:left;"/>
									                		<img style="vertical-align: middle; float: right; margin-top: 5pt;" alt="" 
	                											src="/ProGate-portlet/images/support_org_profile/menu_open.gif" class="flag"> 
									                		<span style="padding-top:5px;"><%= res.getString("gtalk")%></span>
									        			</c:when>
									        		</c:choose>
									        	</span></a>
									        	<input type="hidden" id="typeChatOnline${rowCounter.count}" name="typeChatOnline${rowCounter.count}" value=""/>
									        </dt>
									        <dd >
									            <ul style="margin: 0 0 0 0;" id="list${rowCounter.count}">
										                <li>
											               <a href="javascript:void(0);">
											                	<img class="flag" src="<%=request.getContextPath()%>/images/support_org_profile/yahoo.jpeg" alt="" 
											                	 style="float: left;vertical-align: middle;"/>
											                	 <span style="padding-top:5px;"><%= res.getString("yahoo")%></span>
											               </a>	
										                </li>
									                </a>
									                <li>
									                	<a href="javascript:void(0);">
									                		<img class="flag" src="<%=request.getContextPath()%>/images/support_org_profile/skype.jpg" alt="" style="float:left;"/>
									                		<span style="padding-top:5px;"><%= res.getString("skype")%></span>
									                    </a>
									                </li>
									                <li>
									                	<a href="javascript:void(0);">
									                		<img class="flag" src="<%=request.getContextPath()%>/images/support_org_profile/window.jpeg" alt="" style="float:left;"/>
									                		<span style="padding-top:5px;"><%= res.getString("window")%></span>
									                    </a>
									                </li>
									                <li>
									                	<a href="javascript:void(0);">
									                		<img class="flag" src="<%=request.getContextPath()%>/images/support_org_profile/ICQ.jpeg" alt="" style="float:left;"/>
									                		<span style="padding-top:5px;"><%= res.getString("icq")%></span>
									                    </a>
									                </li>
									               <li>
									                	<a href="javascript:void(0);">
									                		<img class="flag" src="<%=request.getContextPath()%>/images/support_org_profile/googleTalk.jpeg" alt="" style="float:left;"/>
									                		<span style="padding-top:5px;"><%= res.getString("gtalk")%></span>
									                    </a>
									                </li>
									           </ul>
									        </dd>
									    </dl>
			    				  </div>
			                      <div style="margin-top: -5px;">	
			                            <div style="float:left;"> 
			                            	<input type="hidden" name="personId${rowCounter.count}" id="personId${rowCounter.count}" value="${person.journalArticleId}"/>  
											<input type="text" class="chat-text" name="nick${rowCounter.count}" id="nick${rowCounter.count}" 
												value="${person.resourceUrl}"/>(<font color="red">*</font>)
											<div id="checkNick${rowCounter.count}"></div>
										</div>
										<div style="float:left;">   
											<span class="chat-label"><%=res.getString("position")%> (<font color="red">*</font>)</span>
											<input type="text" class="chat-text" name="position${rowCounter.count}" 
												id="position${rowCounter.count}" value="${person.title}"/>												
											<div id="checkPosition${rowCounter.count}"></div>
										</div>
								  </div>
								 <div style="clear:both;margin-bottom:10px;"></div> 
								 	 <script type="text/javascript">
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
								   </script>
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
							    <button id="repairChatOnline" class="bt-form" style="height:24px;width:80px;"><font size="3pt" style="font-family: sans-serif; font-size: 13px;"><%=res.getString("save")%></font></button>
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
   	var count = ${sumOfChatOnline};
	jQuery('#themDong').click(function(){		
		count = count + 1;
		if (count <= 10){
			jQuery('#chatOnlineList').append(jQuery('#addRowChat' + count).html());
		} 
	});
</script>
 <form action="<portlet:actionURL>
	               <portlet:param name="struts_action" value="/SupportOrgProfile/DeleteChatOnlineAction" />
	               <portlet:param name="orgId" value="${orgId}" />
	               <portlet:param name="viewMode" value="${viewMode}" />
	               <portlet:param name="title" value="<%=title%>" />
              </portlet:actionURL>" name="DeleteChatOnline" method="post">
    <input type="hidden" name="idOfDeletePerson" id="idOfDeletePerson" />
</form>  

<c:forEach var="i" begin="${sumOfChatOnline + 1}" end="10" step="1" varStatus="rowCounter">
	<div id="addRowChat${i}" style="display:none;">
		<div class="checkHidden">
				<input type="checkbox" name="person${i}" id="person${i}" value=""/>
		</div>
		<div style="float:left;">
			<dl id="sample" class="dropdown sample" style="margin-top: -8px;margin-left:5px;">
		        <dt>
		        	<a href="javascript:void(0);" id="row${i}"><span>
		        		<img class="flag" src="<%=request.getContextPath()%>/images/support_org_profile/yahoo.jpeg" alt="" 
	                	 style="float: left;vertical-align: middle;"/>
	                	 <img style="vertical-align: middle; float: right; margin-top: 5pt;" alt="" 
	                		src="/ProGate-portlet/images/support_org_profile/menu_open.gif" class="flag"> 										                	 
	                	 <span style="padding-top:5px;"><%= res.getString("yahoo")%></span>
		        	</span></a>
		        	<input type="hidden" id="typeChatOnline${i}" name="typeChatOnline${i}" value=""/>
		        </dt>
		        <dd >
		            <ul style="margin: 0 0 0 0;" id="list${i}">
		               
			                <li>
				               <a href="javascript:void(0);">
				                	<img class="flag" src="<%=request.getContextPath()%>/images/support_org_profile/yahoo.jpeg" alt="" 
				                	 style="float: left;vertical-align: middle;"/>
				                	 <span style="padding-top:5px;"><%= res.getString("yahoo")%></span>
				               </a>	
			                </li>
		                </a>
		                <li>
		                	<a href="javascript:void(0);">
		                		<img class="flag" src="<%=request.getContextPath()%>/images/support_org_profile/skype.jpg" alt="" style="float:left;"/>
		                		<span style="padding-top:5px;"><%= res.getString("skype")%></span>
		                    </a>
		                </li>
		                <li>
		                	<a href="javascript:void(0);">
		                		<img class="flag" src="<%=request.getContextPath()%>/images/support_org_profile/window.jpeg" alt="" style="float:left;"/>
		                		<span style="padding-top:5px;"><%= res.getString("window")%></span>
		                    </a>
		                </li>
		                <li>
		                	<a href="javascript:void(0);">
		                		<img class="flag" src="<%=request.getContextPath()%>/images/support_org_profile/ICQ.jpeg" alt="" style="float:left;"/>
		                		<span style="padding-top:5px;"><%= res.getString("icq")%></span>
		                    </a>
		                </li>
		               <li>
		                	<a href="javascript:void(0);">
		                		<img class="flag" src="<%=request.getContextPath()%>/images/support_org_profile/googleTalk.jpeg" alt="" style="float:left;"/>
		                		<span style="padding-top:5px;"><%= res.getString("gtalk")%></span>
		                    </a>
		                </li>
		           </ul>
		        </dd>
		    </dl>
	  </div>
	  <div style="margin-top: -5px;">	
	        <div style="float:left;">   
				<input type="text" class="chat-text" name="nick${i}" id="nick${i}" />(<font color="red">*</font>)
				<div id="checkNick${i}"></div>
			</div>
			<div style="float:left;">   
				<span class="chat-label"><%=res.getString("position")%> (<font color="red">*</font>)</span>
				<input type="text" class="chat-text" name="position${i}" id="position${i}" />
				<div id="checkPosition${i}"></div>
			</div>
			<div style="clear:both;"></div>
	  </div>
	  <div style="clear:both;margin-bottom:10px;"></div>
	  <script type="text/javascript">
	  		jQuery(document).ready(function() {
	            jQuery("#list${i} img.flag").addClass("flagvisibility");
	
	            jQuery("#row${i}").click(function() {
	                jQuery("#list${i}").toggle();
	            });
	                        
	            jQuery("#list${i} li a").click(function() {
	                var text = jQuery(this).html();
	                jQuery("#row${i} span").html(text);
	                jQuery("#row${i} span:eq(1)").append(jQuery("#drop-down-image").html());
	                jQuery("#list${i}").hide();
	            });
	           
	            jQuery(document).bind('click', function(e) {
	                var jQueryclicked = jQuery(e.target);
	                if (! jQueryclicked.parents().hasClass("dropdown"))
	                    jQuery("#list${i}").hide();
	            });
	        });
	       
	        jQuery("#checkNick${i}").attr("style","clear:both;display:none;");
			jQuery("#checkPosition${i}").attr("style","clear: both;display:none;");
	  </script>
	</div> 
</c:forEach>   


<script type="text/javascript">
jQuery(document).ready(function(){	
	jQuery('#repairChatOnline').click(function(){	
		var flag = validateRepairChatForm();
		if (flag){
		  submitForm(document.repairChatOnline);	
		}else{
		  return false;		  	
		}		
	});	
});
   
  
   
function validateRepairChatForm(){	  
   
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
   
   jQuery("#sumOfPerson").val(count);
   if (validate == false){
		jQuery("#success").css("display", "none");
		jQuery("#error").css("display", "block");
   }
   return validate;				
}   


</script>