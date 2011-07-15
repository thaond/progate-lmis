<%@ include file="init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="com.liferay.portal.util.PortalUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ include file="/html/portlet/common/image_preview.jsp" %>

<portlet:defineObjects />

<%
	String orgId = renderRequest.getParameter("orgId");
	renderRequest.setAttribute("orgId", orgId);
	
	String viewMode = renderRequest.getParameter("viewMode");
	renderRequest.setAttribute("viewMode", viewMode);
	
	HttpServletRequest req = PortalUtil.getHttpServletRequest(renderRequest);
	String hostAdd = PortalUtil.getHost(req);
	int port = PortalUtil.getPortalPort();
	hostAdd = "http://" + hostAdd + ":" + String.valueOf(port) + "/tochuc/trangchu";
	renderRequest.setAttribute("hostAdd", hostAdd);
	
	
	
	
%>

<script type="text/javascript">   
	window.onload = function() {
	  jQuery("#headerNews").focus();	
	}
</script>

<div class="news-org">

	<div class="header-repair">	
		<%
	    	String title = (String)renderRequest.getAttribute("CHANGE_TITLE");
	    	if(title != null){
	    %>
	    		<%=title%>
	    <%	
	    	}else{
	    		title = res.getString("addNewsTitle");
	    %>
				<%=res.getString("addNewsTitle")%>
		<%
			}
		%>
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
						               <portlet:param name="struts_action" value="/NewsOrgProfile/AddNews" />
						               <portlet:param name="orgId" value="${orgId}" />	
						               <portlet:param name="viewMode" value="${viewMode}" />	
						               <portlet:param name="title" value="<%= title%>" />					               
						              </portlet:actionURL>"
				 			method="post" name="addNews" enctype="multipart/form-data">
								<TABLE BORDER="0" CELLSPACING="0" CELLPADDING="0" class="addNews" >
								    <tr>
								    	<td class="label"><%=res.getString("headerNews")%> (<font color="red">*</font>)</td>
								    	<td>
								    		 <div class="box">
							    				  <input type="text" name="headerNews" id="headerNews" maxlength="100" 
							    				  class="text" />						    	    		
							    	    	</div>
							    	    	<div id="checkHeaderNews" style="display:none;clear:both;margin-bottom:10px;"></div>	 			 				    	    						    	    
								    	</td>
								    </tr>
								     <tr>
								    	<td class="label"><%=res.getString("contentNews")%> (<font color="red">*</font>)</td>
								    	<td>
								    		 <div class="box">	
							    				<liferay-ui:input-editor 
							    				    editorImpl="editor.wysiwyg.portal-web.docroot.html.portlet.progate.edit.view.jsp" 
							    				    height="250" width="687px" name="contentNewsEditor"/>
												<input name="contentNews" id="contentNews" type="hidden" />
                                             </div>	 		
                                             <div id="checkContentNewsEditor" style="display:none;clear:both;margin-bottom:10px;"></div>	 				    	    						    	    
								    	</td>
								    </tr>
								    
								   <tr>
								    	<td class="label"><%=res.getString("keywordNews")%></td>
								    	<td>
								    		<div class="box">
							    		  		<div style="float:left;">
							    		  			<input type="text" name="keyword" id="keyword" class="text" maxlength="100"/>
							    		  			<script type="text/javascript">
													 	jQuery("#keyword").keydown(function(event){
												       		if(event.keyCode == 9 || event.keyCode == 8 || event.keyCode == 191 
												       		   || event.keyCode == 37 || event.keyCode == 39){       			
												       		}else{
												       		    if (this.value.length > 100){
												       		    	return false;
												       		    }												       			
												       		}       		
														});
													 </script>
							    		  		</div>
							 				</div>						 											 					 										 								 			
								 		</td>							 		
								    </tr>
								    
								     <tr>
								    	<td class="label"></td>
								    	<td>
								    		<div class="box">
						    		  			<img style="vertical-align: middle;" src="<%=request.getContextPath()%>/images/news_org/information.png" 
						    		  			     width="20" height="20" />
						    		  			<%=res.getString("keywordMark")%>
							 				</div>						 											 					 										 								 			
								 		</td>							 		
								    </tr>
								    

								           <tr>
									    	   <td class="label"></td>
										       <td>
											    	 <div class="box">
										    		  	<div style="float: left;padding-left:5px;">
										    		      <input type="checkbox" name="mark" id="mark" value="<%=res.getString("mark")%>" />
										    		  	 </div>
														 <div style="float: left;vertical-align:middle;"> &nbsp;<%=res.getString("mark")%></div>
										 			  </div>						 											 					 										 								 			
										 		</td>							 		
								           </tr>								             
								           <tr>
									    	   <td class="label"></td>
										        <td>
											    		<div class="box" style="width: 685px;">
										    		  		<img style="vertical-align: middle;float:left;padding-right:5px;" 
										    		  		src="<%=request.getContextPath()%>/images/news_org/information.png" width="20" height="20" />
									    		  			<%=res.getString("noteMark")%>
									    		  		</div>						 											 					 										 								 			
										 		</td>							 		
								          </tr>			

								   								    								      
								   <tr>
								    	<td class="label"><%=res.getString("description")%>(<font color="red">*</font>)</td>
								    	<td>
								    		<div class="box">
							    		  		<div style="float:left;">							    		  			
							    		  			<TEXTAREA name="description" id="description" maxlength="300" COLS=40 ROWS=6></TEXTAREA>
							    		  			<script type="text/javascript">
													 	jQuery("#description").keydown(function(event){
												       		if(event.keyCode == 9 || event.keyCode == 8 || event.keyCode == 191 
												       		   || event.keyCode == 37 || event.keyCode == 39){       			
												       		}else{
												       		    if (this.value.length > 300){
												       		    	return false;
												       		    }												       			
												       		}       		
														});
													 </script>
							    		  		</div>
							    		  		<div>
													<span id="checkDescription" style="display:none;clear:both;margin-bottom:10px;"></span>
												</div>	
							 				</div>						 											 					 										 								 			
								 		</td>							 		
								    </tr>
								      
								    
									 <tr>
								    	<td class="label"><%=res.getString("smallImage")%>(<font color="red">*</font>)</td>
								    	<td>
							    			<div  class="news-org-img-border" align="center">
												<img src="/ProGate-portlet/images/news_org/small_noImage.gif" id="smallImagePreview" 
												     onload="scaleImg(this, 145, 100)" style="display: none;">												
								    		</div>
											<div style="width: 534px; float: left;">
												<span>
													<input type="file" name="smallImage" id="smallImage" size="72" onchange="validImage();" />
												</span>
											</div>	
											<div>
												<span id="checkSmallImage" style="display:none; clear:both; margin-bottom:10px;"></span>
											</div>
											<div class="box" style="width: 534px; padding-top: 10px; text-align: justify;">
							    		  		<img style="vertical-align: middle; float:left; padding-right:5px;" 
							    		  		     src="<%=request.getContextPath()%>/images/news_org/information.png" width="20" height="20" />
						    		  			<%=res.getString("news.infor3")%> 
						    		  		</div>												
								 		</td>							 		
								    </tr>
								   
								 	<tr>					 		
								 		<td colspan="2">
								 			<div class="button-align">
									 			<div class="save-button">
		           								   <button id="themtintuc" class="bt-form" style="height:24px;width:80px;">
		           								   <font size="3pt" style="font-family: sans-serif; font-size: 13px;"><%=res.getString("save")%></font>
		           								   </button>
		        	                            </div>
		        	                   		    </form>
		        	                   		    <form action="${currentURL}" name="NewOrganization" method="get">
			        	                            <div class="cancel-button">
			           								   	<input type="hidden" id="orgId" name="orgId" value="${orgId}"/>
			           								   	<input type="hidden" id="viewMode" name="viewMode" value="${viewMode}"/>
			           								   	<button class="bt-form" type="submit" style="height:24px;width:80px;" onclick="submitForm(document.NewOrganization)">
			           								   	<font size="3pt" style="font-family: sans-serif; font-size: 13px;"><%=res.getString("cancel")%></font>
			           								   	</button>
			        	                            </div>
			        	                        </form>    
		        	                        </div> 	                            
								 		</td>							 		
								 	</tr>				 		 	
			                     </TABLE>
	</div>
</div>

<script type="text/javascript">
    function <portlet:namespace />initEditor() {
        return '';
    }

    function <portlet:namespace />extractCodeFromEditor() {
         document.addNews.contentNews.value = window.contentNewsEditor.getHTML();
	}
	
	jQuery(document).ready(function(){	
		jQuery('#themtintuc').click(function(){			
			var flag = validateNewsForm();			
			if (flag){
			  submitForm(document.addNews);	
			}else{
			  return false;		  	
			}		
		});	
	});
	
	function validateNewsForm(){	  
	   var validate = true;
	   var headerNews = jQuery('#headerNews').val();
	   
	   jQuery('#contentNews').val(jQuery.trim(window.contentNewsEditor.getHTML()));
	   var contentNewsEditor =  jQuery('#contentNews').val();
	   var description = jQuery('#description').val();
	   
	   
	   if(contentNewsEditor == ''){
			validate = false;
			jQuery("#checkContentNewsEditor").css("display","block");
			jQuery("#checkContentNewsEditor").html("<span class='error'>Bạn chưa nhập nội dung</span>");
		}else{
			jQuery("#checkContentNewsEditor").css("display","none");
		}	 
		   
		if(headerNews == ''){
			 validate = false;
			 jQuery("#checkHeaderNews").css("display","block");
			 jQuery("#checkHeaderNews").html("<span class='error'>Bạn chưa nhập tiêu đề</span>");
		}else{
			 jQuery("#checkHeaderNews").css("display","none");
		}	
		
		if(description == ''){
			 validate = false;
			 jQuery("#checkDescription").css("display","block");
			 jQuery("#checkDescription").html("<span class='error'>Bạn chưa giới thiệu tin tức này</span>");
		}else{
			 jQuery("#checkDescription").css("display","none");
		}
		
		if (smallImage == ''){
			 validate = false;
			 jQuery("#checkSmallImage").css("display","block");
			 jQuery("#checkSmallImage").html("<span class='error'>Bạn chưa đưa hình đại diện tin tức này</span>");
		}else{
			 jQuery("#checkSmallImage").css("display","none");
		}
		
		// Validate OrgLogo
		if (validImage() == fale) {
			validate = false;
		}
		
		if (validate == false){
			jQuery("#success").css("display", "none");
			jQuery("#error").css("display", "block");
		}	
	   return validate;										
	}
	
	function validImage() {
		// Image preview
		imagePreview("smallImage", "smallImagePreview");		
		
	   var smallImage = jQuery('#smallImage').val();
		
		if (smallImage == '') {
			jQuery("#checkSmallImage").html("<span class='error'>Bạn chưa đưa hình đại diện tin tức này</span>");
			return false;
		} else if (!isValidImageType(smallImage)) {
			jQuery("#checkSmallImage").html("<span class='error'>File này có định dạng không được hỗ trợ</span>");
			return false;
		} else {
			jQuery("#mesError").css("display", "none");
			jQuery("#checkSmallImage").html("");
		}
		
		return true;
	}
	
	function isValidImageType(value)
	{
		  return /\.(gif|jpeg|jpg|png)$/i.test (value);
	}
</script>

