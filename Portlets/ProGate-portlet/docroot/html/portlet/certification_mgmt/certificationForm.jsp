<%--
 
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/html/portlet/certification_mgmt/init.jsp" %>


<style type="text/css">
   <%@ include file="/css/cert_mgmt/form.css" %>
	<%@ include file="/css/jquery.alerts.css" %> 
</style>

<script type="text/javascript" src="/ProGate-portlet/js/jquery.alerts.js"></script>

<%@ include file="/html/portlet/certification_mgmt/scripts.jsp" %>

<form action="" method="post" name="frmCertified" enctype="multipart/form-data">
<div class="org-profile-layout-column-21" style="float: left;">
	<div class="certmgmt-frm-header">
		<% if ((RequestConst.ADD_CERT).equals(actMode)) {
		%>
		<div class="certmgmt-frm-header-title">
			<span class="certmgmt-frm-header-text"><%= bundle.getString("title.certified.add") %></span>
		</div>
		<% } else {
		%>
		<div class="certmgmt-frm-header-title">
			<span class="certmgmt-frm-header-text"><%= bundle.getString("title.certified.edit") %></span>
		</div>
		<% }
		%>
		
		<div class="certmgmt-frm-header-border">
		</div>
	</div>
	
	<% if (((RequestConst.EDIT_CERT).equals(actMode))
			&& (countCert == 0)) {
	%>
	<div class="certmgmt-frm-body">
		<div class="certmgmt-frm-row" style="background:#FFDDDD; height:32px;">
			<div class="certmgmt-frm-row-left" style="padding-top:4px; padding-left:4px; height:24px;">
				<span class="certmgmt-icon-error"> </span>
			</div>
			<div class="certmgmt-frm-row-left" style="padding-top:8px; padding-left:4px">
				<span class="certmgmt-text-error"> <%= bundle.getString("certified.edit.empty") %></span>
			</div>
		</div>
	</div>
	<% } else {
	%>
	<div class="certmgmt-frm-body">
		<div class="certmgmt-frm-row">
			<% if ((RequestConst.EDIT_CERT).equals(actMode)) {
			%>
			<div id="delete_cert" class="certmgmt-frm-action-right" style="display:block; padding-left:4px;">				
				<span style="padding-left:4px; padding-right:4px;">|</span>
				<span class="certmgmt-btn-delete" onclick="deleteCert()"><%= bundle.getString("title.action.delete") %></span>				
			</div>
			<% } else {
			%>
			<div id="delete_cert" class="certmgmt-frm-action-right" style="display:none; padding-left:4px;">
			<span style="padding-left:4px; padding-right:4px;">|</span>				
				<span class="certmgmt-btn-delete" onclick="deleteCert()"><%= bundle.getString("title.action.delete") %></span>				
			</div>
			<% }
			%>
			
			<div id="back_cert" class="certmgmt-frm-action-right" style="display:block; padding-left:4px;">
				<a href="<%= urlFullView %>">
					<span class="certmgmt-btn-return"><%= bundle.getString("title.action.back") %></span>
				</a>
			</div>			
		</div>
		
		<div id="save_success" class="certmgmt-frm-row" style="background:#D5FFDD; display:none; height:32px;">
			<div class="certmgmt-frm-row-left" style="padding-top:4px; padding-left:4px; height:24px;">
				<span class="certmgmt-icon-success"></span>
			</div>
			<div class="certmgmt-frm-row-left" style="padding-top:8px; padding-left:4px">
				<span class="certmgmt-text-success"> 
				<% if ((RequestConst.ADD_CERT).equals(actMode)) {
				%>
					<%= bundle.getString("certified.save.success") %>
				<% } else {
				%>
					<%= bundle.getString("certified.edit.success") %>
				<% }
				%>
				</span>
			</div>
			<div class="certmgmt-frm-action-right" style="padding-top:8px;">
				<span class="certmgmt-btn-close" onclick="closeDialog()"></span>
			</div>
		</div>

		<div id="save_error" class="certmgmt-frm-row" style="background:#FFDDDD; display:none; height:32px;">
			<div class="certmgmt-frm-row-left" style="padding-top:4px; padding-left:4px; height:24px;">
				<span class="certmgmt-icon-error"></span> 
			</div>
			<div class="certmgmt-frm-row-left" style="padding-top:8px; padding-left:4px">
				<span class="certmgmt-text-error"> <%= bundle.getString("certified.save.error") %></span>
			</div>
			<div class="certmgmt-frm-action-right" style="padding-top:8px;">
				<span class="certmgmt-btn-close" onclick="closeDialog()"></span>
			</div>
		</div>
		
		<div class="certmgmt-frm-row">
			<div class="certmgmt-frm-row-left">
				<span class="certmgmt-frm-required-title"><%= bundle.getString("title.required.field") %></span>
				<input id="certified_id" type="hidden" name="<%= RequestConst.CERT_ID %>" value="<%= certId %>"/>
			</div>
		</div>
		
		<div class="certmgmt-frm-row">
			<div class="certmgmt-frm-row-left">
				<span><%= bundle.getString("title.required.certname") %></span>
			</div>
			
			<div class="certmgmt-frm-row-right">
				<span>
					<input class="certmgmt-frm-input" type="text" name="<%= CertificationConst.JA_TITLE %>" 
							maxlength="<%= CertificationConst.JA_TITLE_LEGNTH %>" value="<%= certItem.getTitle() %>" />
				</span>
				
				<span id="error_certified_name" class="certmgmt-frm-error-message"></span>
			</div>
		</div>
		
		<div class="certmgmt-frm-row">
			<div class="certmgmt-frm-row-left">
			<span><%= bundle.getString("title.required.certlogo") %></span>
			</div>
			
			<div class="certmgmt-frm-row-right">
				<span>
					<input type="file" name="<%= CertificationConst.JA_LOGO %>" size="61"/>
				</span>
				
				<span id="error_certified_logo" class="certmgmt-frm-error-message"></span>
			</div>
		</div>
		
		<div class="certmgmt-frm-row">
			<div class="certmgmt-frm-row-right">
				<span class="certmgmt-icon-info"> <%= bundle.getString("certified.uploadImg") %></span>			
			</div>
		</div>
		
		<div class="certmgmt-frm-row">
			<div class="certmgmt-frm-row-left">
			<span><%= bundle.getString("title.required.certdate") %></span>
			</div>
			
			<div class="certmgmt-frm-row-right">
				<span>
					<input id="certmgmt_certified_date" class="certmgmt-date-field" type="text" 
							readonly="readonly" name="<%= CertificationConst.JA_CERT_DATE %>"  
							value="<%= certItem.getAddInfo().substring(14) %>" />
				</span>
			</div>
			
			<div class="certmgmt-frm-row-right">
				<span id="error_certified_date" class="certmgmt-frm-error-message"></span>
			</div>
		</div>
		
		<div class="certmgmt-frm-row">
			<div class="certmgmt-frm-row-center">
				<span>
				<input type="button" class="bt-form" onclick="validate_and_submit()"
					value='<%= bundle.getString("title.action.save") %>'/>
				</span>
				
				<span>
				<input type="button" class="bt-form" onclick="cancel()"
					value='<%= bundle.getString("title.action.cancel") %>'/>
				</span>
			</div>
		</div>
	</div>	
	<% }
	%>
</div>		
		
</form>