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
	System.out.println("abc =" + request.getAttribute("abc"));
	String orgId = (String)renderRequest.getParameter("orgId");
	if (orgId == null){
		orgId = (String)request.getParameter("orgId");
	}	
	renderRequest.setAttribute("orgId", orgId);
	
	String title = (String) request.getParameter("title");
	title = (title == null) ? res.getString("repairQuestion") : title;
	renderRequest.setAttribute("title", title);
	
	// Lay noi dung cua bai huong dan cu the
	String articleId = (String)renderRequest.getParameter("articleId");

	if (articleId == null){
		articleId = (String)request.getAttribute("articleId");
	}
	renderRequest.setAttribute("articleId", articleId);
	System.out.println("articleId =" + articleId);
	
	String titleArticle = "";
	String contentArticle = "";
	int orderArticle = -1;
	
	if (articleId != null){
		try{
			ProGateJournalArticle article = ProGateJournalArticleLocalServiceUtil.getProGateJournalArticle(
		                                     Integer.valueOf(articleId));
		    titleArticle = article.getDescription();
		    contentArticle = article.getContent();   
		    orderArticle = article.getArticleOrder();                              
		}catch( Exception e){
			System.out.println(e.toString());
		}                                     
	} 
	
	String viewMode = (String)renderRequest.getParameter("viewMode");
	if (viewMode == null){
		viewMode = (String)request.getParameter("viewMode");
	}	
		
	renderRequest.setAttribute("viewMode", viewMode);
%>

<script type="text/javascript">   
	window.onload = function() {
	 	jQuery("#descriptionQuestion").html(jQuery.trim(jQuery("#descriptionQuestionTemp").text()));
	 	jQuery("#order").val("<%=orderArticle%>");
	}
	/*	
	 * Function to check if this is number key
	 */
	function AcceptDigits(objtextbox)
	{
		var exp = /[^\d]/g;
		objtextbox.value = objtextbox.value.replace(exp,'');
	}
</script>
<div class="support-org">

	<div class="header-guilde">	
	   ${title}
	</div>	

   <div class="foresee">		 
   <a id="deleteQuestion" style="text-decoration:none;">
		<img style="vertical-align: middle;" src="<%=request.getContextPath()%>/images/support_org_profile/delete.png" width="25" height="25" />
			<%=res.getString("delete")%></a>
			<div style="display: none;">
			&nbsp;&nbsp;|
		<img style="vertical-align: middle;" src="<%=request.getContextPath()%>/images/support_org_profile/preview.png" width="25" height="25" />
			<%=res.getString("foresee")%></div>
	</div>
	
	<%@ include file="alertDelete.jsp"%>
	
	<div class="note-head">
		<font color="red">(*) Thông tin bắt buộc nhập</font>
	</div>
	
	<%@ include file="showerror.jsp"%>
	<%@ include file="showsuccess.jsp"%>
	<div align="left">
					<br />
						<form action="<portlet:actionURL>
						               <portlet:param name="struts_action" value="/SupportOrgProfile/RepairQuestionAction" />
						               <portlet:param name="orgId" value="${orgId}" />	
						               <portlet:param name="viewMode" value="${viewMode}" />
						               <portlet:param name="articleId" value="${articleId}" />
						               <portlet:param name="title" value="${title}" />					               
						              </portlet:actionURL>"
				 			method="post" name="addQuestion">
								<TABLE BORDER="0" CELLSPACING="0" CELLPADDING="0" class="addGuilde" >
									<tr>
								    	<td class="label"><%=res.getString("order")%></td>
								    	<td>
								    		 <div class="box">
							    				  <input type="text" name="order" id="order" maxlength="100" style="width:50px;"
							    				  class="text" onkeyup="AcceptDigits(this)"/>						    	    		
							    	    	</div>
							    	    	<div id="checkOrder" style="display:none;clear:both;margin-bottom:10px;"></div>	 			 				    	    						    	    
								    	</td>
								    </tr>
								    <tr>
								    	<td class="label"><%=res.getString("titleQuestion")%> (<font color="red">*</font>)</td>
								    	<td>
								    		 <div class="box">
							    				  <TEXTAREA name="descriptionQuestion" id="descriptionQuestion" COLS=40 ROWS=6></TEXTAREA>						    	    		
							    	    	</div>
							    	    	<div id="checkDescriptionQuestion" style="display:none;clear:both;margin-bottom:10px;"></div>	 			 				    	    						    	    
								    	</td>
								    </tr>
								     <tr>
								    	<td class="label"><%=res.getString("contentQuestion")%> (<font color="red">*</font>)</td>
								    	<td>
								    		 <div class="box">	
							    				<liferay-ui:input-editor 
							    				    editorImpl="editor.wysiwyg.portal-web.docroot.html.portlet.progate.edit.view.jsp" 
							    				    height="250" width="687px" name="contentQuestionEditor"/>
												<input name="contentQuestion" id="contentQuestion" type="hidden" />
                                             </div>	 		
                                             <div id="checkContentQuestion" style="display:none;clear:both;margin-bottom:10px;"></div>	 				    	    						    	    
								    	</td>
								    </tr>
								   
								 	<tr>					 		
								 		<td colspan="2">
								 			<div class="button-align">
									 			<div class="save-button">
		           								   <button id="themcauhoi" class="bt-form" style="height:24px;width:80px;"><font size="3pt" style="font-family: sans-serif; font-size: 13px;"><%=res.getString("save")%></font></button>
		        	                            </div>
		        	                   		    </form>
		        	                   		    <form action="${returnPath}" name="cancleQuestion" method="get">
			        	                            <div class="cancel-button">
			           								   	<input type="hidden" id="orgId" name="orgId" value="${orgId}"/>
			           								   	<input type="hidden" id="viewMode" name="viewMode" value="${viewMode}"/>
			           								   	<input type="hidden" id="actionView" name="actionView" value="generalQuestion"/>
			           								   	<input type="hidden" id="pageNum" name="pageNum" value="1"/>
			           								   	<!-- <input type="hidden" id="actionView" name="actionView" value="detailQuestion"/> -->
			           								   	<!-- <input type="hidden" id="articleId" name="articleId" value="${articleId}"/> -->
			           								   	<button class="bt-form" type="submit" style="height:24px;width:80px;" onclick="submitForm(document.cancleQuestion)"><font size="3pt" style="font-family: sans-serif; font-size: 13px;"><%=res.getString("cancel")%></font></button>
			        	                            </div>
			        	                        </form>  
		        	                        </div>   	                            
								 		</td>							 		
								 	</tr>				 		 	
			                     </TABLE>
	</div>
</div>

<div id="descriptionQuestionTemp" style="display:none">
	<%= titleArticle%>
</div>
<div id="contentQuestionTemp" style="display:none">
	<%= contentArticle%>
</div>

<script type="text/javascript">
    function <portlet:namespace />initEditor() {
        var out =jQuery('#contentQuestionTemp').html();
    	//out = out.replace('<','&#x200B;<');    	
        window.contentQuestionEditor.setHTML(out);
	    return out;
    }
</script>

 <form action="<portlet:actionURL>
	               <portlet:param name="struts_action" value="/SupportOrgProfile/DeleteQuestionAction" />
	               <portlet:param name="orgId" value="${orgId}" />
	               <portlet:param name="viewMode" value="${viewMode}" />
	               <portlet:param name="articleId" value="${articleId}" />
	               <portlet:param name="title" value="${title}" />
              </portlet:actionURL>" name="deleteQuestion" method="post">
  
</form>  