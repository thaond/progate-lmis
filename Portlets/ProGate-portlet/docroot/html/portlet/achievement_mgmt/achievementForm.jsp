<%--
 
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/html/portlet/achievement_mgmt/init.jsp" %>


<style type="text/css">
   <%@ include file="/css/achie_mgmt/form.css" %>
	<%@ include file="/css/jquery.alerts.css" %> 
</style>

<script type="text/javascript" src="/ProGate-portlet/js/jquery.alerts.js"></script>

<%@ include file="/html/portlet/achievement_mgmt/scripts.jsp" %>

<form action="" method="post" name="frmAchievement" enctype="multipart/form-data">
<div class="org-profile-layout-column-21" style="float: left;">
	<div class="achiemgmt-frm-header">
		<% if ((RequestConst.ADD_ACHIE).equals(actMode)) {
		%>
		<div class="achiemgmt-frm-header-title">
			<span class="achiemgmt-frm-header-text"><%= bundle.getString("title.achievement.add") %></span>
		</div>
		<% } else {
		%>
		<div class="achiemgmt-frm-header-title">
			<span class="achiemgmt-frm-header-text"><%= bundle.getString("title.achievement.edit") %></span>
		</div>
		<% }
		%>
		
		<div class="achiemgmt-frm-header-border">
		</div>
	</div>
	
	<% if (((RequestConst.EDIT_ACHIE).equals(actMode))
			&& (achieItem == null)) {
	%>
	<div class="achiemgmt-frm-body">
		<div class="achiemgmt-frm-row" style="background:#FFDDDD; height:32px;">
			<div class="achiemgmt-frm-row-left" style="padding-top:4px; padding-left:4px; height:24px;">
				<span class="achiemgmt-icon-error"> </span>
			</div>
			<div class="achiemgmt-frm-row-left" style="padding-top:8px; padding-left:4px">
				<span class="achiemgmt-text-error"> <%= bundle.getString("achievement.edit.empty") %></span>
			</div>
		</div>
	</div>
	<% } else {
	%>
	<div class="achiemgmt-frm-body">
		<div class="achiemgmt-frm-row">
			<%	if ((RequestConst.EDIT_ACHIE).equals(actMode)) {
			%>
			<div id="delete_achie" class="achiemgmt-frm-action-right" style="display:block; padding-left:4px;">				
				<span style="padding-left:4px; padding-right:4px;">|</span>
				<span class="achiemgmt-btn-delete" onclick="deleteAchie()"><%= bundle.getString("title.action.delete") %></span>				
			</div>
			<% } else {%>
			<div id="delete_achie" class="achiemgmt-frm-action-right" style="display:none; padding-left:4px;">				
				<span style="padding-left:4px; padding-right:4px;">|</span>
				<span class="achiemgmt-btn-delete" onclick="deleteAchie()"><%= bundle.getString("title.action.delete") %></span>				
			</div>
			<% }
			%>
			
			<div id="back_achie" class="achiemgmt-frm-action-right" style="display:block; padding-left:4px;">
				<a href="<%= urlFullView %>">
					<span class="achiemgmt-btn-return"><%= bundle.getString("title.action.back") %></span>
				</a>
			</div>			
		</div>
		
		<div id="save_success" class="achiemgmt-frm-row" style="background:#D5FFDD; display:none; height:32px;">
			<div class="achiemgmt-frm-row-left" style="padding-top:4px; padding-left:4px; height:24px;">
				<span class="achiemgmt-icon-success"></span>
			</div>
			<div class="achiemgmt-frm-row-left" style="padding-top:8px; padding-left:4px">
				<span class="achiemgmt-text-success"> 
				<% if ((RequestConst.ADD_ACHIE).equals(actMode)) {
				%>
					<%= bundle.getString("achievement.save.success") %>
				<% } else {
				%>
					<%= bundle.getString("achievement.edit.success") %>
				<% }
				%>
				</span>
			</div>
			<div class="achiemgmt-frm-action-right" style="padding-top:8px;">
				<span class="achiemgmt-btn-close" onclick="closeDialog()"></span>
			</div>
		</div>
		
		<div id="save_error" class="achiemgmt-frm-row" style="background:#FFDDDD; display:none; height:32px;">
			<div class="achiemgmt-frm-row-left" style="padding-top:4px; padding-left:4px; height:24px;">
				<span class="achiemgmt-icon-error"></span> 
			</div>
			<div class="achiemgmt-frm-row-left" style="padding-top:8px; padding-left:4px">
				<span class="achiemgmt-text-error"> <%= bundle.getString("achievement.save.error") %></span>
			</div>
			<div class="achiemgmt-frm-action-right" style="padding-top:8px;">
				<span class="achiemgmt-btn-close" onclick="closeDialog()"></span>
			</div>
		</div>
		
		<div class="achiemgmt-frm-row">
			<div class="achiemgmt-frm-row-left">
				<span class="achiemgmt-frm-required-title"><%= bundle.getString("title.required.field") %></span>
				<input id="achieve_id" type="hidden" name="<%= RequestConst.ACHIE_ID %>" value="<%= achieId %>"/>
			</div>
		</div>
		
		<div class="achiemgmt-frm-row">
			<div class="achiemgmt-frm-row-left">
				<span><%= bundle.getString("title.required.achiename") %></span>
			</div>
			
			<div class="achiemgmt-frm-row-right">
				<span>
					<input class="achiemgmt-frm-input" type="text" name="<%= AchievementConst.JA_TITLE %>" 
							maxlength="<%= AchievementConst.JA_TITLE_LEGNTH %>" value="<%= achieItem.getTitle() %>" />
				</span>
				
				<span id="error_achievement_name" class="achiemgmt-frm-error-message"></span>
			</div>
		</div>
		
		<div class="achiemgmt-frm-row">
			<div class="achiemgmt-frm-row-left">
			<span><%= bundle.getString("title.required.achielogo") %></span>
			</div>
			
			<div class="achiemgmt-frm-row-right">
				<span>
					<input type="file" name="<%= AchievementConst.JA_LOGO %>" size="54"/>
				</span>
				
				<span id="error_achievement_logo" class="achiemgmt-frm-error-message"></span>
			</div>
		</div>
		
		<div class="achiemgmt-frm-row">
			<div class="achiemgmt-frm-row-right">
				<span class="achiemgmt-icon-info"> <%= bundle.getString("achievement.uploadImg") %></span>			
			</div>
		</div>
		
		<div class="achiemgmt-frm-row">
			<div class="achiemgmt-frm-row-left">
			<span><%= bundle.getString("title.required.achiedate") %></span>
			</div>
			
			<div class="achiemgmt-frm-row-right">
				<span>
					<input id="achiemgmt_achievement_date" class="achiemgmt-date-field" type="text" 
							readonly="readonly" name="<%= AchievementConst.JA_ACHIE_DATE %>"  
							value="<%= achieItem.getAddInfo().substring(13) %>" />
				</span>
			</div>
			
			<div class="achiemgmt-frm-row-right">
				<span id="error_achievement_date" class="achiemgmt-frm-error-message"></span>
			</div>
		</div>
		
		<div class="achiemgmt-frm-row">
			<div class="achiemgmt-frm-row-center">
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