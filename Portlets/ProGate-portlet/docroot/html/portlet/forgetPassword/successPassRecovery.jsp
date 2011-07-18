<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/init.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%
	
	String email = "";
	if (request.getAttribute("INPUT_EMAIL") != null) {
		email = (String)request.getAttribute("INPUT_EMAIL");
	}
	
	boolean isRegrantPass = false;
	if (request.getAttribute("REGRANT_PASS") != null) {
		isRegrantPass = (Boolean)request.getAttribute("REGRANT_PASS");
	}
	
%>

<style type="text/css">
   <%@ include file="/css/forgetPassword/style.css" %>
</style>
<% if(isRegrantPass){ %>
	
	<form name="frmRecovery" method="post">
	
	<table width="360px" align="center" id="common_bgr" width="100%" border="1" bordercolor="#B8BABF"  cellspacing="2" cellpadding="2">
		
		<tr class="labelheader">
			<td style="padding: 10px">
				<label>
					Chúng tôi sẽ gửi email kích hoạt tài khoản vào địa chỉ <a><%=email %></a> của bạn.
					<br><br>
					Bạn vui lòng kiểm tra email và nhấn vào liên kết để kích hoạt tài khoản.
					<br><br>
					<b>Lưu ý:</b>
					<br><br>
					1. Bạn phải chắc chắn rằng địa chỉ email trên là đúng và kiểm tra thư rác hoặc bộ lọc email nếu không nhận được email kích hoạt.
					<br><br>
					2. Liên kết kích hoạt tài khoản sẽ hết hạn trong 7 ngày.
					<br><br>
				</label>
			</td>
		</tr>
		
	</table>
		
</form>


<% }else{ %>
<form name="frmRecovery" method="post">
	<table width="360px" align="center" id="common_bgr" width="100%" border="1" bordercolor="#B8BABF"  cellspacing="2" cellpadding="2">
		
		<tr class="labelheader">
			<td style="padding: 10px">
				<label>
					<b>Xác nhận thành công !
					<br>
					Bạn vui lòng kiểm tra email.
					</b>
					<br><br>
					Một email vừa được gửi đến <a><%=email %></a>. Email này hướng dẫn cách lấy mật khẩu mới.
					<br><br>
					Nhớ kiểm tra để chắc chắn rằng email trên là đúng và kiểm tra thư rác hoặc bộ lọc email nếu bạn không nhận được email này.
					<br><br>
				</label>
			</td>
		</tr>
		
	</table>
	<table width="360px"><tr><td>&nbsp;</td></tr></table>
	<table width="360px" align="center">
		<tr>
			<td align="center" valign="top">
			<a href="/home">
			<button name="GoHome" style="border-color: #CDB463; background-color: #F5ECD3"><font size="3pt" style="font-family: sans-serif;font-size: 13px">Trang chủ</font></button>
			</a>
			</td>
		</tr>
	</table>
</form>
<% } %>