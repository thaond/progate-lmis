
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
    String orgId = (String)renderRequest.getParameter("orgId");
    renderRequest.setAttribute("orgId", orgId);
    
    String title = (String)renderRequest.getParameter("title");
    title = (title == null)? res.getString("repairLibrary") : title;
	renderRequest.setAttribute("title", title);
	
	String modeType = (String)renderRequest.getParameter("modeType");
	renderRequest.setAttribute("modeType", modeType);
	
	String titleLibrary = "";
	String embeddedVideo = "";
	String attachFile = "";
	String contentLibrary = "";
	
	ProGateJournalArticle article = null;
	
	String articleId = (String)renderRequest.getParameter("articleId");	
	if (articleId == null){
		articleId = (String)renderRequest.getAttribute("articleId"); // tu man hinh add den man hinh sua
	}
	renderRequest.setAttribute("articleId", articleId);
	if (articleId != null){
		// cau lenh lay len tu database
		article = ProGateJournalArticleLocalServiceUtil.getProGateJournalArticle(Integer.valueOf(articleId));
		titleLibrary = article.getTitle();
		contentLibrary = article.getContent();
		if (modeType.equals("Video")){
			embeddedVideo = article.getDescription();
		}
		
	}

	String viewMode = (String)renderRequest.getParameter("viewMode");	
	renderRequest.setAttribute("viewMode", viewMode);
	
%>

<script type="text/javascript">   
	window.onload = function() {
		
	 	jQuery("#titleLibrary").val(jQuery.trim(jQuery("#titleLibraryTemp").text()));
	 	document.getElementById("embeddedVideo").value = '<%=embeddedVideo.trim()%>';
	 	var modeType = '<%= (String)renderRequest.getParameter("modeType")%>';	
	 	if (modeType == "Video"){
	 		jQuery('input:radio[name="Library"]').filter('[value="Video"]').attr('checked', true);
	 		jQuery('input:radio[name="Library"]').filter('[value="PDF"]').attr('disabled', true);
	 		jQuery("#videoScreen").css("display", "block");
			jQuery("#pdfScreen").css("display", "none");
			jQuery("#modeType").val("Video");
	 	}
	 	if (modeType == "PDF"){
	 		jQuery('input:radio[name="Library"]').filter('[value="PDF"]').attr('checked', true);
	 		jQuery('input:radio[name="Library"]').filter('[value="Video"]').attr('disabled', true);
	 		jQuery("#videoScreen").css("display", "none");
			jQuery("#pdfScreen").css("display", "block");
			jQuery("#modeType").val("PDF");
	 	}
	}
</script>
<div class="support-org">

	<div class="header-guilde">	
	   ${title}
	</div>	

   <div class="foresee">	
   <a id="deleteGuilde" style="text-decoration:none;">
   		<img style="vertical-align: middle;" src="<%=request.getContextPath()%>/images/support_org_profile/delete.png" width="25" height="25" />
		<%=res.getString("delete")%></a>
		<div style="display: none;">
		&nbsp;&nbsp;|
		<img style="vertical-align: middle;" src="<%=request.getContextPath()%>/images/news_org/preview.png" width="25" height="25" />
		<%=res.getString("foresee")%></div>
	</div>
	

	<%@ include file="alertDelete.jsp"%>
	
	
	<div  class="note-head">
		<font color="red">(*) Thông tin bắt buộc nhập</font>
	</div>
	
	<%@ include file="showerror.jsp"%>
	<%@ include file="showsuccess.jsp"%>
	<div align="left">
					<br />
						<form action="<portlet:actionURL>
						               <portlet:param name="struts_action" value="/SupportOrgProfile/RepairLibraryAction" />
						               <portlet:param name="orgId" value="${orgId}" />	
						               <portlet:param name="viewMode" value="${viewMode}" />	
						               <portlet:param name="title" value="${title}" />
						               <portlet:param name="articleId" value="${articleId}" />					               
						              </portlet:actionURL>"
				 			method="post" name="repairLibrary" enctype="multipart/form-data">
				 			    <input name="modeType" id="modeType" type="hidden"/>				 			    
								<TABLE BORDER="0" CELLSPACING="0" CELLPADDING="0" class="addGuilde" >
								    <tr>
								    	<td class="label"><%=res.getString("titleLibrary")%> (<font color="red">*</font>)</td>
								    	<td>
								    		 <div class="box">
							    				  <input type="text" name="titleLibrary" id="titleLibrary" maxlength="100" 
							    				  class="text" />						    	    		
							    	    	</div>
							    	    	<div id="checkTitleLibrary" style="display:none;clear:both;margin-bottom:10px;"></div>	 			 				    	    						    	    
								    	</td>
								    </tr>
								    <tr>
								    	<td class="label"><%=res.getString("typeLibrary")%> (<font color="red">*</font>)</td>
								    	<td>
								    		<div class="box">
								    			<div class="radio" >
								    				<input type="radio" name="Library" value="<%= res.getString("video")%>" checked><%= res.getString("video")%></input>
				                                </div>
				                                <div style="float:left;" >
				                                	<input type="radio" name="Library" value="<%= res.getString("pdf")%>"><%= res.getString("pdf")%></input>
				                                </div>						    		
			                                </div>				    	    
								    	</td>
								    </tr>
								   
								    <tr>
								    	<td colspan="2">
								    		<div id="videoScreen" style="display:none;">  
								    			<table>
												     <tr>
												    	<td class="label"><%=res.getString("embeddedVideo")%> (<font color="red">*</font>)</td>
												    	<td>
												    		<div class="box">	    		
												    			<TEXTAREA name="embeddedVideo" id="embeddedVideo" COLS=40 ROWS=6>												    				
												    			</TEXTAREA>					    		
							                                </div>	
							                                 <div id="checkEmbeddedVideo" style="display:none;clear:both;margin-bottom:10px;"></div>	 			 				    	    						    	    
												    	</td>
												    </tr>
												    
												     <tr>
												    	<td class="label"></td>
												    	<td>
												    		<div class="box" style="width:700px;">
										    		  			<img style="vertical-align: middle;" src="<%=request.getContextPath()%>/images/news_org/information.png" width="20" height="20" />
										    		  			<fmt:message key="informationVideo" bundle="${msg}">
																    <fmt:param value="<span style='color: #30A1BE;font-weight: bold;'>"/> 
																    <fmt:param value="</span>"/> 
																    <fmt:param value="<span style='color: #30A1BE;font-weight: bold;'>"/> 
																    <fmt:param value="</span>"/> 
																</fmt:message>
											 				</div>						 											 					 										 								 			
												 		</td>							 		
												    </tr>
											   </table>
										   </div> 
								    	</td>
								    </tr> 
								  
								   <tr>
								   		<td colspan="2">
								   			<div id="pdfScreen" style="display:none;">  
								   				<table>
												     <tr>
												    	<td class="label"><%=res.getString("attachFile")%> (<font color="red">*</font>) 												    	 
												    	</td>
												    	<td>
												    		<div class="box">
																<input type="file" name="attachFile" id="attachFile" size="72"/>
															</div>	
															<div id="checkAttachFile" style="display:none;clear:both;margin-bottom:10px;">
															</div>						 				    	    						    	    
												    	</td>
												    </tr>
												    
												     <tr>
												    	<td class="label"></td>
												    	<td>
												    		<div class="box">
										    		  			<img style="vertical-align: middle;" src="<%=request.getContextPath()%>/images/news_org/information.png" width="20" height="20" />
										    		  			<%=res.getString("informationPDF")%>
											 				</div>						 											 					 										 								 			
												 		</td>							 		
												    </tr>
											    </table>
										    </div>
								   		</td>
								   </tr>
								   
								    
								     <tr>
								    	<td class="label"><%=res.getString("contentLibrary")%> (<font color="red">*</font>)</td>
								    	<td>
								    		 <div class="box">	
							    				<liferay-ui:input-editor 
							    				    editorImpl="editor.wysiwyg.portal-web.docroot.html.portlet.progate.edit.view.jsp" 
							    				    height="250" width="687px" name="contentLibraryEditor"/>
												<input name="contentLibrary" id="contentLibrary" type="hidden" />
                                             </div>	 		
                                             <div id="checkContentLibrary" style="display:none;clear:both;margin-bottom:10px;"></div>	 				    	    						    	    
								    	</td>
								    </tr>
								   
								 	<tr>					 		
								 		<td colspan="2">
								 			<div class="button-align">
									 			<div class="save-button">
		           								   <button id="suaThuVien" disable="true" class="bt-form" style="height:24px;width:80px;"><font size="3pt" style="font-family: sans-serif; font-size: 13px;"><%=res.getString("save")%></font></button>
		        	                            </div>
		        	                   		    </form>
		        	                   		    <form action="${returnPath}" name="cancleAddLibrary" method="get">
			        	                            <div class="cancel-button">
			           								   	<input type="hidden" id="orgId" name="orgId" value="${orgId}"/>
			           								   	<input type="hidden" id="viewMode" name="viewMode" value="${viewMode}" />	
			           								   	<c:choose>				           								   		
			           								   		<c:when test='${modeType eq "PDF"}'>           								    
			           								   			<!-- <input type="hidden" id="actionView" name="actionView" value="detailPdf"/> -->
			           								   			<input type="hidden" id="actionView" name="actionView" value="generalPdf"/>
			           								   		</c:when>
			           								   		<c:when test='${modeType eq "Video"}'>       								    
			           								   			<!-- <input type="hidden" id="actionView" name="actionView" value="detailVideo"/> -->
			           								   			<input type="hidden" id="actionView" name="actionView" value="generalVideo"/>
			           								   		</c:when>
			           								   	</c:choose>
			           								   	<!-- <input type="hidden" id="articleId" name="articleId" value="${articleId}"/> -->
			           								   	<input type="hidden" id="pageNum" name="pageNum" value="1"/>
			           								   	<button class="bt-form" type="submit" style="height:24px;width:80px;" onclick="submitForm(document.cancleAddLibrary)"><font size="3pt" style="font-family: sans-serif; font-size: 13px;"><%=res.getString("cancel")%></font></button>
			        	                            </div>
			        	                        </form> 
			        	                     </div>    	                            
								 		</td>							 		
								 	</tr>				 		 	
			                     </TABLE>
	</div>
</div>
<div id="titleLibraryTemp" style="display:none">
	<%= titleLibrary%>
</div>
<div id="contentLibraryTemp" style="display:none">
	<%= contentLibrary%>
</div>

<script type="text/javascript">
    function <portlet:namespace />initEditor() {
        var out =jQuery('#contentLibraryTemp').html();
        //out = out.replace('<','&#x200B;<');    	
        window.contentLibraryEditor.setHTML(out);
	    return out;
    }
    
    jQuery(document).ready(function(){	
	jQuery('#suaThuVien').click(function(){			
			var flag = validateRepairLibrary();			
			if (flag){
			  submitForm(document.repairLibrary);	
			}else{
			  return false;		  	
			}		
		});	
	});
   
	function validateRepairLibrary(){	  
	   var validate = true;
	   var titleLibrary = jQuery('#titleLibrary').val();	
	  
	   var modeType = jQuery('#modeType').val();   
	   
	   if (modeType == "Video"){
	   		var embeddedVideo = jQuery("#embeddedVideo").val();
	   		
	   		if (embeddedVideo == ''){
	   			validate = false;
				jQuery("#checkEmbeddedVideo").css("display","block");
				jQuery("#checkEmbeddedVideo").html("<span class='error'>Bạn chưa nhập mã nhúng</span>");
	   		}else{
	   			jQuery("#checkEmbeddedVideo").css("display","none");
	   		}
	   }
	   
	   jQuery('#contentLibrary').val(jQuery.trim(window.contentLibraryEditor.getHTML()));
	   var contentLibrary =  jQuery('#contentLibrary').val();
	   
	   if(contentLibrary == ''){
			validate = false;
			jQuery("#checkContentLibrary").css("display","block");
			jQuery("#checkContentLibrary").html("<span class='error'>Bạn chưa nhập nội dung</span>");
		}else{
			jQuery("#checkContentLibrary").css("display","none");
		}	 
		   
		if(titleLibrary == ''){
			 validate = false;
			 jQuery("#checkTitleLibrary").css("display","block");
			 jQuery("#checkTitleLibrary").html("<span class='error'>Bạn chưa nhập tiêu đề</span>");
		}else{
			 jQuery("#checkTitleLibrary").css("display","none");
		}	
		
		if (validate == false){
			jQuery("#error").css("display","block");
			jQuery("#success").css("display","none");
		}
	    return validate;										
	}
	
			
</script>
<form action="<portlet:actionURL>
	               <portlet:param name="struts_action" value="/SupportOrgProfile/DeleteLibraryAction" />
	               <portlet:param name="orgId" value="${orgId}" />
	               <portlet:param name="viewMode" value="${viewMode}" />
	               <portlet:param name="articleId" value="${articleId}" />
	               <portlet:param name="title" value="${title}" />
              </portlet:actionURL>" name="deleteLibrary" method="post">
  
</form>  
 