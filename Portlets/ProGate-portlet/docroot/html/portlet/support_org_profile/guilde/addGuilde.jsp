
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
	if (orgId == null){
		orgId = (String)renderRequest.getAttribute("orgId");
	}
	System.out.println("orgId = " + orgId);
	renderRequest.setAttribute("orgId", orgId);
	
	String title = (String)renderRequest.getParameter("title");
	title = (title == null) ? res.getString("addGuilde") : title;
	renderRequest.setAttribute("title", title);
	
	
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
		<img style="vertical-align: middle;" src="<%=request.getContextPath()%>/images/support_org_profile/preview.png" width="25" height="25" />
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
						               <portlet:param name="struts_action" value="/SupportOrgProfile/AddGuildeAction" />
						               <portlet:param name="orgId" value="${orgId}" />
						               <portlet:param name="viewMode" value="${viewMode}" />	
						               <portlet:param name="title" value="${title}" />					               
						              </portlet:actionURL>"
				 			method="post" name="addGuilde" enctype="multipart/form-data">
								<TABLE BORDER="0" CELLSPACING="0" CELLPADDING="0" class="addGuilde" >
								    <tr>
								    	<td class="label"><%=res.getString("titleGuilde")%> (<font color="red">*</font>)</td>
								    	<td>
								    		 <div class="box">
							    				  <input type="text" name="titleGuilde" id="titleGuilde" maxlength="100" 
							    				  class="text" />						    	    		
							    	    	</div>
							    	    	<div id="checkTitleGuilde" style="display:none;clear:both;margin-bottom:10px;"></div>	 			 				    	    						    	    
								    	</td>
								    </tr>
								     <tr>
								    	<td class="label"><%=res.getString("contentGuilde")%> (<font color="red">*</font>)</td>
								    	<td>
								    		 <div class="box">	
							    				<liferay-ui:input-editor 
							    				    editorImpl="editor.wysiwyg.portal-web.docroot.html.portlet.progate.edit.view.jsp" 
							    				    height="250" width="687px" name="contentGuildeEditor"/>
												<input name="contentGuilde" id="contentGuilde" type="hidden" />
                                             </div>	 		
                                             <div id="checkContentGuilde" style="display:none;clear:both;margin-bottom:10px;"></div>	 				    	    						    	    
								    	</td>
								    </tr>
								   
								 	<tr>					 		
								 		<td colspan="2">
								 			<div class="button-align">
									 			<div class="save-button">
		           								   <button id="themhuongdan" class="bt-form" style="height:24px;width:80px;"><font size="3pt" style="font-family: sans-serif; font-size: 13px;"><%=res.getString("save")%></font></button>
		        	                            </div>
		        	                   		    </form>
		        	                   		    <form action="${returnPath}" name="cancleSupport" method="get">
			        	                            <div class="cancel-button">
			           								   	<input type="hidden" id="orgId" name="orgId" value="${orgId}"/>
			           								   	<input type="hidden" id="viewMode" name="viewMode" value="${viewMode}"/>
			           								   	<input type="hidden" id="actionView" name="actionView" value="generalGuilde"/>
			           								   	<input type="hidden" id="pageNum" name="pageNum" value="1"/>
			           								   	<button class="bt-form" type="submit" style="height:24px;width:80px;" id="cancelAddGuilde"><font size="3pt" style="font-family: sans-serif; font-size: 13px;"><%=res.getString("cancel")%></font></button>
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
   
</script>