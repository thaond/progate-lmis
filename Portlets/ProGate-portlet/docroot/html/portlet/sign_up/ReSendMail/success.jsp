<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="javax.portlet.WindowState" %>
<portlet:defineObjects />
<%@ include file="init.jsp" %>

<div  class="reactive_success">
	<p style="padding:10px 10px 10px 0px;">
			Chúng tôi sẽ gửi email kích hoạt tài khoản vào địa chỉ <span style="text-decoration:underline;color:#000BFF"><%= request.getAttribute("EMAIL")%></span>
	của bạn.<br />
			Bạn vui lòng kiểm tra email và nhấn vào liên kết để kích hoạt tài khoản.<br />
	</p>
	
	<p>
			<span style="font-weight:bold;">Lưu ý:</span> <br />
	    <ol style="padding-top:0px;margin-top:-12px;margin-left:20px;text-align:justify;">
		  <li>Bạn phải chắc chắn rằng địa chỉ email trên là đúng và kiểm tra thư rác hoặc bộ lọc 
		email nếu không nhận được email kích hoạt.</li>
		  <li>Liên kết kích hoạt tài khoản sẽ hết hạn sau 7 ngày.</li>
		</ol>
	</p>
</div>