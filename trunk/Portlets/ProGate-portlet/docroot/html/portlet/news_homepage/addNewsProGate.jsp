<%@page import="com.larion.progate.news_homepage.constants.News_Const"%>
<%@ include file="../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.liferay.portal.util.PortalUtil"%>

<%@ include file="/html/portlet/common/image_preview.jsp" %>

<style type="text/css">
   <%@ include file="/css/newsOrgProfile.css" %>
</style>

<script type="text/javascript">   
	window.onload = function() {
	  jQuery("#headerNews").focus();	
	}
	
	
	function backButton(){
		var url = '${bean.currentURL}';
		window.location = url ;
	}
	
</script>
<fmt:setBundle basename="mes_key"/>
<div class="news-org">
	<div class="header-repair">	
		<fmt:message key="news.addNews"/>
	</div>	
	<!-- 
    <div class="foresee">		 
		<img style="vertical-align: middle;" src="<//%=request.getContextPath()%>/images/news_org/preview.png" width="25" height="25" />
		<fmt:message key="news.watch"/>
	</div>
	 -->
	<div  class="note-head">
		<font color="red">(*) <fmt:message key="news.information"/></font>
	</div>
	
	<div align="left">
					<br />
						<form action="<portlet:actionURL>
						               <portlet:param name="action" value="addNewsProGate"/>
						              </portlet:actionURL>"
				 			method="post" name="addNewsProGate" enctype="multipart/form-data" id="addNewsProGate">
				 			<input type="hidden" value="${bean.currentURL}" name="<%= News_Const.CURRENT_URL %>"/>
								<TABLE BORDER="0" CELLSPACING="0" CELLPADDING="0" class="addNews" >
								    <tr>
								    	<td class="label"><fmt:message key="news.title"/> (<font color="red">*</font>)</td>
								    	<td>
								    		 <div class="box">
							    				  <input type="text" name="<%= News_Const.TITLE %>" id="headerNews" maxlength="100" 
							    				  class="text" />						    	    		
							    	    	</div>
							    	    	<div id="checkHeaderNews" style="display:none;clear:both;margin-bottom:10px;"></div>	 			 				    	    						    	    
								    	</td>
								    </tr>
								     <tr>
								    	<td class="label"><fmt:message key="news.content"/> (<font color="red">*</font>)</td>
								    	<td>
								    		 <div class="box">	
							    				<liferay-ui:input-editor 
							    				    editorImpl="editor.wysiwyg.portal-web.docroot.html.portlet.progate.edit.view.jsp" 
							    				    height="250" width="687px" name="contentNewsEditor"/>
												<input name="<%= News_Const.CONTENT %>" id="contentNews" type="hidden" />
                                             </div>	 		
                                             <div id="checkContentNewsEditor" style="display:none;clear:both;margin-bottom:10px;"></div>	 				    	    						    	    
								    	</td>
								    </tr>
								    
								   <tr>
								    	<td class="label"><fmt:message key="news.keyword"/></td>
								    	<td>
								    		<div class="box">
							    		  		<div style="float:left;">
							    		  			<input type="text" name="<%= News_Const.KEY_WORD %>" id="keyword" class="text" maxlength="100"/>
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
						    		  			<img style="vertical-align: middle;" src="<%=request.getContextPath()%>/images/news_org/information.png" width="20" height="20" />
						    		  			<fmt:message key="news.infor1"/>
							 				</div>						 											 					 										 								 			
								 		</td>							 		
								    </tr>
								    <!-- 
								    <tr>
								    	<td class="label"></td>
								    	<td>
								    		<div class="box">
							    		  		<div style="float: left;padding-left:5px;">
							    		  		  <input type="checkbox" name="<//%= News_Const.MARK %>" id="mark" value="" />
							    		  		</div>
												<div style="float: left;vertical-align:middle;"> &nbsp;<fmt:message key="news.checkbox"/></div>
							 				</div>						 											 					 										 								 			
								 		</td>							 		
								    </tr>
								    
								    <tr>
								    	<td class="label"></td>
								    	<td>
								    		<div class="box" style="width: 685px;">
							    		  		<img style="vertical-align: middle;float:left;padding-right:5px;" src="<//%=request.getContextPath()%>/images/news_org/information.png" width="20" height="20" />
						    		  			<fmt:message key="news.infor2"/>
						    		  		</div>						 											 					 										 								 			
								 		</td>							 		
								    </tr>
								 -->     
								   <tr>
								    	<td class="label"><fmt:message key="news.intro"/> (<font color="red">*</font>)</td>
								    	<td>
								    		<div class="box">
							    		  		<div style="float:left;">							    		  			
							    		  			<TEXTAREA name="<%= News_Const.DESCRIPTION %>" id="description" maxlength="300" COLS=40 ROWS=6></TEXTAREA>
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
								    	<td class="label"><fmt:message key="news.image"/> (<font color="red">*</font>)</td>
								    	<td>
											<div class="news-org-img-border" align="center">
								    			<img src="/ProGate-portlet/images/news_org/small_noImage.gif" onLoad='scaleImg(this, 145, 100)' id="smallImagePreview" style="display: block;">
								    		</div>
							    			<div style="width: 534px; float: left;">
												<span>
													<input type="file" name="<%= News_Const.SMALL_IMAGE %>" id="smallImage" size="72"/>
												</span>
											</div>	
											<div>
												<span id="checkSmallImage" style="display:none; clear:both;" class="error"></span>
											</div>
											<div class="box" style="width: 534px; padding-top: 10px; text-align: justify;">
							    		  		<img style="vertical-align: middle; float:left; padding-right:5px;" src="<%=request.getContextPath()%>/images/news_org/information.png" width="20" height="20" />
						    		  			<fmt:message key="news.infor3"/>
						    		  		</div>											
								 		</td>							 		
								    </tr>
								 	<tr>					 		
								 		<td colspan="2">
								 			                            
								 		</td>							 		
								 	</tr>				 		 	
			                     </TABLE>
			      </form>
			      <div class="button-align">
			 			<div class="save-button" style="padding-left: 260px; padding-bottom: 10px">
       						<button id="themtintuc" class="bt-form" style="height:24px;width:80px;"><font size="3pt" style="font-family: sans-serif; font-size: 13px;"><fmt:message key="news.save"/></font></button>
    	               </div>
                       <div class="cancel-button">
					   		<button class="bt-form" style="height:24px;width:80px;" onclick="backButton();"><font size="3pt" style="font-family: sans-serif; font-size: 13px;"><fmt:message key="news.cancel"/></font></button>
                       </div>
		        </div> 	
	</div>
</div>

<script type="text/javascript">

	function isValidImageType(value)
	{
	    return /\.(gif|jpeg|jpg|png)$/i.test (value);
	}
	
	jQuery('#addNewsProGate input[type=file]').change(function(el) {
		// Image preview
		imagePreview("smallImage", "smallImagePreview");
		
        var file_name = jQuery(this).val();
		if (file_name == '') {
			jQuery("#checkSmallImage").css("display","block");
			jQuery("#checkSmallImage").html("Bạn chưa đưa hình đại diện tin tức này");
			return;
		} else if (!isValidImageType(file_name)){            
        	jQuery("#checkSmallImage").css("display","block");
			jQuery("#checkSmallImage").html("File này có định dạng không được hỗ trợ.");
            return;
        }else{
        	jQuery("#checkSmallImage").css("display","none");
        }
	});
	
    function <portlet:namespace />initEditor() {
        return '';
    }

    function <portlet:namespace />extractCodeFromEditor() {
         document.addNewsProGate.contentNews.value = window.contentNewsEditor.getHTML();
	}
	
	jQuery(document).ready(function(){	
		jQuery('#themtintuc').click(function(){	
			var fileName = jQuery("#smallImage").val();
			var flag = validateNewsForm();	
			if (flag && isValidImageType(fileName)){
				document.addNewsProGate.submit();
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
	   var smallImage = jQuery('#smallImage').val();
	   
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
		
		if(smallImage == ''){
			 validate = false;
			 jQuery("#checkSmallImage").css("display","block");
			 jQuery("#checkSmallImage").html("Bạn chưa đưa hình đại diện tin tức này.");
		}else{
			if(!isValidImageType(smallImage)){
				validate = false;
				jQuery("#checkSmallImage").css("display","block");
				jQuery("#checkSmallImage").html("File này có định dạng không được hỗ trợ.");
			}else{
				jQuery("#checkSmallImage").css("display","none");
			}
			 
		}
		
		if (validate == false){
			jQuery("#success").css("display", "none");
			jQuery("#error").css("display", "block");
		}	
	   return validate;										
	}
	
	
</script>

