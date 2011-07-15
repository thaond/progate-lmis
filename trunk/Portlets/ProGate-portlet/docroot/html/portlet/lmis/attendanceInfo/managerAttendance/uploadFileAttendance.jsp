<%@ include file="../../../lmis/grid/grid.jsp" %>
<%@ include file="../../../lmis/init-tvna.jsp" %>
<%@ include file="../../../lmis/validation/validation_upload.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<% 
String result = renderRequest.getParameter("result");
System.out.println("ket qua: "+result);
%>

<script type="text/javascript">
	jQuery(document).ready(function() {				
		/*show datepicker*/
		jQuery("#dateAttendance").datepicker({
			showOn: "both",
			buttonImage: "/ProGate-portlet/images/lmis/viewAttendanceInfo/datetime.png",
			buttonImageOnly: true,
			buttonText:'Chọn ngày',
			dateFormat:'dd/mm/yy',
			maxDate: '0'
		});
	});
	jQuery(function(){
		jQuery(".btnSave").click(function(e){
			var date = jQuery("#dateAttendance").val();
			var url = '<portlet:actionURL  windowState="<%=WindowState.NORMAL.toString() %>">
							<portlet:param name="action" value="uploadFile" />
							<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.SAVE%>"/>
							<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_MANAGER%>"/>
							<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
							<portlet:param name="<%=Request.DATEIMPORT%>" value="xdatex"/>
						</portlet:actionURL>';
				url = url.replace('xdatex',date);
				if(isValidation()){
					submitUpload(url);
				}
								
		});
		jQuery(".back, .btnDeploy").click(function(){
			var url='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
						<portlet:param name="action" value="managerAttendanceInfo" />
						<portlet:param name="<%=Constants.CMD%>" value="<%=Request.UNDO_HANDER%>"/>
						<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_MANAGER%>"/>
						<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
					</portlet:renderURL>';
			submit(url);
		});
		jQuery("#dateAttendance").keydown(function(e) {
			if (e.keyCode > 0 ) {
				e.preventDefault();	
			}	
		});
	});
	function submit(url){
		document.frmUploadFile.action=url;
		document.frmUploadFile.submit();
	}
	function submitUpload(url){
		document.frmUploadFile.action=url;
		document.frmUploadFile.enctype="multipart/form-data";
		document.frmUploadFile.submit();
	}		
</script>

<form action="" name="frmUploadFile" method="post" enctype="multipart/form-data">
<div class="wrapper">
	<div class="header">
       	 <div id="title">
            <b><fmt:message key="lmis.attendanceInfo.updateHeader"/></b>   
       	</div>
    </div><!--End header-->
    <div class="clear"></div>
    <div id="uploadFile">
    	<div class="event">
    		<div class="back">
    			<input id="back" type="image" src="/ProGate-portlet/images/lmis/undo.png">
    			<a class="tvna_style2" href="#"><fmt:message key="lmis.common.back"/></a>
    		</div>
    		<div class="downloadEx">
    			<input id="downloadEx" type="image" src="/ProGate-portlet/images/lmis/download.png">
    			<a class="tvna_style2" href="#"><fmt:message key="lmis.attendanceInfo.uploadEx"/></a>
    		</div>
    	</div>
    	<div class="clear"></div>
    </div>
    
    <div style="margin-left:15em;">
    	<div style="padding-bottom:1em"><fmt:message key="lmis.common.requiredField"/></div>
    	<table>
    		<tr>
    			<td>
    				<label><fmt:message key="lmis.attendanceInfo.dateAttendance"/></label>
    			</td>
    			<td>
    				<input style="margin-left:0.5em" type="text" id="dateAttendance" 
    					value="<fmt:formatDate pattern="dd/MM/yyyy" value="${bean.currentDate}"/>"/>
    				<div style="margin-left:0.5em"><label id="errorDate" class="hiddenMessage"></label></div>
    			</td>
    		</tr>
    		<tr>
    			<td>  
    				<div style="margin-top:1.2em">
    					<label ><fmt:message key="lmis.attendanceInfo.chooseFile"/></label></div>
    			</td>
    			<td>
    				<input class="tvna_style1" size="45" type="file" name="attachFile" id="attachFile"/>
    			</td>
    		</tr>
    		<tr>
    			<td>&nbsp</td>
    			<td><span>
    					<label id="chooseFile" class="tvna_style1"><img src="/ProGate-portlet/images/lmis/info.png"">
    						<fmt:message key="lmis.attendanceInfo.message"/></label>
    					<label id="errorFileEmpty" class="hiddenMessage" style="padding-left:10px"></label>
    			</span></td>
    		</tr>
    	</table>
    </div><!-- End content upload file -->
    <center style="padding-top:1em;padding-bottom:1em">
    	<input type="button" style="width:75px" value='<fmt:message key="button.save"/>' class="btnSave"/>
    	<input type="button" style="width:75px" value='<fmt:message key="button.deploy"/>' class="btnDeploy"/>
    </center>
</div>
</form>