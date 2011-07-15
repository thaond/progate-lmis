<%@page import="com.larion.progate.news_homepage.constants.News_Const"%>
<%@ include file="../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.liferay.portal.util.PortalUtil"%>

<%@ include file="/html/portlet/common/image_preview.jsp" %>

<style type="text/css">
   <%@ include file="/css/newsOrgProfile.css" %>
</style>

<%
	String homeUrl= PortalUtil.getPortalURL(request);
	String currentUrl = homeUrl + "/my-blog" ;
	
%>

<script type="text/javascript">   
	window.onload = function() {
	  jQuery("#headerNews").focus();	
	}
	
	
	function backButton(){
		var url = '${bean.currentURL}';
		window.location.href = url ;
	}
	
	function closeMes(){
		jQuery("#mesSuccess").css("display","none");
		jQuery("#mesError").css("display","none");
	}
	
</script>

<fmt:setBundle basename="mes_key"/>

<c:set value="${bean.article }" var = "article"></c:set>

<div class="news-org">
	<div class="header-repair">	
		<c:choose>
			<c:when test="${bean.cmd == 1 }">
				<fmt:message key="blog.addNews"/>
			</c:when>
			<c:otherwise>
				<fmt:message key="blog.editNews"/>
			</c:otherwise>
		</c:choose>
		
	</div>	
   <div class="foresee">
   		<img style="vertical-align: middle;cursor: pointer;" src="<%=request.getContextPath()%>/images/news_org/delete.png" width="25" height="25" onclick="deleteNews();"/>
		<a id="deleteNews" style="text-decoration:none;cursor: pointer;" onclick="deleteNews();"><fmt:message key="news.delete"/></a>&nbsp;&nbsp;		 
		<!--  
		<img style="vertical-align: middle;" src="<//%=request.getContextPath()%>/images/news_org/preview.png" width="25" height="25" />
		<fmt:message key="news.watch"/>
		-->
	</div>
	
	<div  class="note-head">
		<font color="red">(*) <fmt:message key="news.information"/></font>
	</div>
			<c:if test="${bean.addSuccess == 1 }">
				<div class="video-body-mes-success news-msg" id="mesSuccess">
					<div class="img-td" style="float: left;"><img alt="" src="/ProGate-portlet/images/success.png" width="20px" height="20px"></div>
					<div style="float: left; padding-top: 8px; padding-left: 5px;">
						<span class="tq-body-content-mes"> 
							<c:choose>
								<c:when test="${bean.cmd == 1 }">
									<fmt:message key="blog.sucAdd"/>
								</c:when>
								<c:otherwise>
									<fmt:message key="blog.sucEdit"/>
								</c:otherwise>
							</c:choose>
						</span>
					</div>
					<div style="float:right; padding-right:20px;">
						<img alt="" src="/ProGate-portlet/images/black_delete.png" width="28px" height="28px" onclick="closeMes();">
					</div>
				</div>
			</c:if>
			<c:if test="${bean.addSuccess == 2 }">
				<div class="video-body-mes-error news-msg" id="mesError">
					<div class="img-td" style="float: left;"><img alt="" src="/ProGate-portlet/images/error.png" width="20px" height="20px"></div>
					<div style="float: left; padding-top: 8px; padding-left: 5px;">
						<span class="tq-body-content-mes">
							<c:choose>
								<c:when test="${bean.cmd == 1 }">
									<fmt:message key="blog.errAdd"/>
								</c:when>
								<c:otherwise>
									<fmt:message key="blog.errEdit"/>
								</c:otherwise>
							</c:choose>
						</span>
					</div>
					<div style="float:right; padding-right:20px;">
						<img alt="" src="/ProGate-portlet/images/black_delete.png" width="28px" height="28px" onclick="closeMes();">
					</div>
				</div>
			</c:if>

	<div align="left">
					<br />
						<form action="<portlet:actionURL>
						               <portlet:param name="action" value="updateMyBlog"/>
						              </portlet:actionURL>"
				 			method="post" name="updateNews" enctype="multipart/form-data" id="updateNewsProGate">
				 			<input type="hidden" value="${article.primaryKey }" name="<%=News_Const.ARTICLE_ID %>"/>
				 			<input type="hidden" value="${bean.currentURL}" name="<%= News_Const.CURRENT_URL %>"/>
								<TABLE BORDER="0" CELLSPACING="0" CELLPADDING="0" class="addNews" >
								    <tr>
								    	<td class="label"><fmt:message key="news.title"/> (<font color="red">*</font>) </td>
								    	<td>
								    		 <div class="box">
							    				  <input type="text" name="<%= News_Const.TITLE %>" id="headerNews" maxlength="100" 
							    				  class="text" value="${article.title}"/>						    	    		
							    	    	</div>
							    	    	<div id="checkHeaderNews" style="display:none;clear:both;margin-bottom:10px;"></div>	 			 				    	    						    	    
								    	</td>
								    </tr>
								     <tr>
								    	<td class="label"><fmt:message key="news.content"/> (<font color="red">*</font>) </td>
								    	<td>
								    		 <div class="box">	
							    				<liferay-ui:input-editor 
							    				    editorImpl="editor.wysiwyg.portal-web.docroot.html.portlet.progate.edit.view.jsp" 
							    				    height="250" width="687px" name="contentNewsEditor"/>
												<input name="<%= News_Const.CONTENT %>" id="contentNews" type="hidden" value=""/>
                                             </div>	 		
                                             <div id="checkContentNewsEditor" style="display:none;clear:both;margin-bottom:10px;"></div>	 				    	    						    	    
								    	</td>
								    </tr>
								    
								   <tr>
								    	<td class="label"><fmt:message key="news.keyword"/></td>
								    	<td>
								    		<div class="box">
							    		  		<div style="float:left;">
							    		  			<input type="text" name="<%= News_Const.KEY_WORD %>" id="keyword" class="text" maxlength="100" value=""/>
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
							    		  		<c:choose>
							    		  		<c:when test="${article.priority == 1 }">
							    		  		  <input type="checkbox" name="<//%= News_Const.MARK %>" id="mark" value="1" checked="checked"/>
							    		  		</c:when>
							    		  		<c:otherwise>
							    		  			 <input type="checkbox" name="<//%= News_Const.MARK %>" id="mark" value="0"/>
							    		  		</c:otherwise>
							    		  		</c:choose>
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
								    	<td class="label"><fmt:message key="news.intro"/> (<font color="red">*</font>) </td>
								    	<td>
								    		<div class="box">
							    		  		<div style="float:left;">							    		  			
							    		  			<textarea name="<%= News_Const.DESCRIPTION %>" id="description" maxlength="300" COLS=40 ROWS=6> <c:out value="${article.description}"/> </textarea>
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
								    	<td class="label"><fmt:message key="news.image"/></td>
								    	<td>
								    		<div class="news-org-img-border" align="center">
								    			<img id="smallImageDisplay" alt="" src="${article.smallImageUrl}" onLoad='scaleImg(this, 145, 100)' style="display: none;">
								    		</div>
							    			<div style="width: 534px; float: left;">
												<span>
												<input type="file" name="<%= News_Const.SMALL_IMAGE %>" id="smallImage" size="72"/>
												</span>
											</div>	
											<div style="padding-top: 5px; width: 654px; float: right;">
												<span id="checkSmallImage" style="display:none; clear:both;" class="error"></span>
											</div>	
											<div class="box" style="width: 534px; padding-top: 10px; text-align: justify;">
							    		  		<img style="vertical-align: middle;float:left;padding-right:5px;padding-bottom: 11px;" src="<%=request.getContextPath()%>/images/news_org/information.png" width="20" height="20" />
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
      					<button id="suatintuc" class="bt-form" style="height:24px;width:80px;"><font size="3pt" style="font-family: sans-serif; font-size: 13px;"><fmt:message key="news.save"/></font></button>
   	                </div>
   	                <div class="cancel-button">
      					<button class="bt-form" style="height:24px;width:80px;" onclick="backButton();"><font size="3pt" style="font-family: sans-serif; font-size: 13px;"><fmt:message key="news.cancel"/></font></button>
   	                </div>
   	              </div> 	 
	</div>
</div>
<div id="des" style="display:none">
		${article.content}
</div>
<script type="text/javascript">
	function isValidImageType(value)
	{
	    return /\.(gif|jpeg|jpg|png)$/i.test (value);
	}
	
	jQuery('#smallImage').change(function(el) {
	    // Image preview
		imagePreview("smallImage", "smallImageDisplay");
		
		var file_name = jQuery(this).val();
	    if (file_name == '') {
			jQuery("#checkSmallImage").css("display","block");
			jQuery("#checkSmallImage").html("Bạn chưa đưa hình đại diện tin tức này");
			return;
		} else if(!isValidImageType(file_name)){            
	    	jQuery("#checkSmallImage").css("display","block");
			jQuery("#checkSmallImage").html("File này có định dạng không được hỗ trợ.");
	        return;
	    }else{
	    	jQuery("#checkSmallImage").css("display","none");
	    }
	});
	
	function <portlet:namespace />initEditor(){
    	var out =jQuery('#des').html();  	
        window.contentNewsEditor.setHTML(out);
	    return out;
   }

    function <portlet:namespace />extractCodeFromEditor() {
         document.updateNews.contentNews.value = window.contentNewsEditor.getHTML();
	}
	
	jQuery(document).ready(function(){	
		jQuery('#suatintuc').click(function(){			
			var flag = validateNewsForm();			
			if (flag){
			 	submitForm(document.updateNews);	
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
		
		if (validate == false){
			jQuery("#success").css("display", "none");
			jQuery("#error").css("display", "block");
		}	
	   return validate;										
	}
	
	function deleteNews() {		
		if (confirm('<fmt:message key="warning.confirm.delete"/>')) {
			var portletActionURL = 
				'<portlet:actionURL windowState="<%=WindowState.NORMAL.toString() %>">
					<portlet:param name="action" value="deleteMyBlog"/>
					<portlet:param name="<%= News_Const.ARTICLE_ID %>" value="${article.primaryKey}"/>				
				</portlet:actionURL>';
			document.updateNews.action = portletActionURL;
		    document.updateNews.submit();
		}		
	}
	
</script>

