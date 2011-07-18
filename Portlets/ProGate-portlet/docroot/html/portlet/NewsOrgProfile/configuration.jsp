<%@ include file="init.jsp" %>

<form action="<liferay-portlet:actionURL portletConfiguration='true'/>" method="post" name="SendMailConfigfm">
<style>
#config_table tr td{
	width:200px;
	padding-top:5px; 
	padding-right:10px;
	text-align:right;
}
</style>
<%
		PortletPreferences preferences = renderRequest.getPreferences();
		
		String portletResource = ParamUtil.getString(request, "portletResource");

		if (Validator.isNotNull(portletResource)) {
			preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
		}
		String[] def = {"duongdtt@elarion.com", StringPool.BLANK, StringPool.BLANK, StringPool.BLANK};
		String server = GetterUtil.getString(preferences.getValue("txt_server_name", StringPool.BLANK));
		String protocol = GetterUtil.getString(preferences.getValue("txt_protocol", StringPool.BLANK));
		String port = GetterUtil.getString(preferences.getValue("txt_port", StringPool.BLANK));
		String email = GetterUtil.getString(preferences.getValue("txt_email", StringPool.BLANK));
		String pass = GetterUtil.getString(preferences.getValue("txt_pass", StringPool.BLANK));
		String[] receiver = new String[4];
		receiver = preferences.getValues("txt_receiver", def);
%>
<script type="text/javascript">
	jQuery(document).ready(function(){
		jQuery("a.portlet-icon-back").attr("href","/contact-us");
		jQuery("#butSubmit").click(function(){
			flag = false;
			var text = jQuery("[name='txt_receiver_1']").val();
			text.replace(" ","");
			if (text!=""){
				flag = true;
			}
			text = jQuery("[name='txt_receiver_2']").val();
			text.replace(" ","");
			if (text!=""){
				flag = true;
			}
			text = jQuery("[name='txt_receiver_3']").val();
			text.replace(" ","");
			if (text!=""){
				flag = true;
			}
			text = jQuery("[name='txt_receiver_4']").val();
			text.replace(" ","");
			if (text!=""){
				flag = true;
			}
			if(flag){
				document.SendMailConfigfm.submit();
			}
			else{	
				alert("Please type at least one receiver email!");
			}
		});
	});
</script>
<table id="config_table">
	<tbody>
		<tr>
			<td width="80px">Server name:</td>
			<td><input type="text" name="txt_server_name" size="25" value="<%=server %>"/></td>
			<td>Receiver 1:</td>
			<td><input type="text" name="txt_receiver_1" value="<%=receiver[0]%>"/></td>
		</tr>
		<tr>
			<td>Protocol:</td>
			<td style="text-align:left">
				<select type="text" name="txt_protocol" >
				<%
					if (protocol.equals("smtp")){
						out.print("<option value='smtp' selected>SMTP</option>");
					}
					else{
						out.print("<option value='smtp'>SMTP</option>");
					}
					if (protocol.equals("pop3")){
						out.print("<option value='pop3' selected>POP3</option>");
					}
					else{
						out.print("<option value='pop3'>POP3</option>");
					}
					if (protocol.equals("esmtp")){
						out.print("<option value='esmtp' selected>ESMTP</option>");
					}
					else{
						out.print("<option value='esmtp'>ESMTP</option>");
					}
				%>
				</select>
			</td>
			<td>Receiver 2:</td>
			<td><input type="text" name="txt_receiver_2" value="<%=receiver[1]%>"/></td>
		</tr>
		<tr>
			<td>Port:</td>
			<td><input type="text" name="txt_port" size="5" value="<%=port %>"/></td>
			<td>Receiver 3:</td>
			<td><input type="text" name="txt_receiver_3" value="<%=receiver[2]%>"/></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input type="text" name="txt_email" value="<%=email %>"/></td>
			<td>Receiver 4:</td>
			<td><input type="text" name="txt_receiver_4" value="<%=receiver[3]%>"/></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="txt_pass" value="<%=pass %>"/></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td colspan="4"><center><input type="button" id="butSubmit" name="butSubmit" value="Save"/></center></td>		
		</tr>
	</tbody>
</table>
</form>
<script> 	var searchIcon = document.getElementById("globalsearch").getElementsByTagName("input")[1];	 	searchIcon.style.position = "relative"; 	searchIcon.style.top = "4px"; 	searchIcon.style.right = "-30px"; 	searchIcon.style.width = "15px"; </script>