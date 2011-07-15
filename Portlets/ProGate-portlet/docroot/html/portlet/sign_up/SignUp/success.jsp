<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="javax.portlet.WindowState" %>
<portlet:defineObjects />
<% 
   String firstname = (String)request.getAttribute("FIRSTNAME");
   String lastname = (String)request.getAttribute("LASTNAME");
   String username = (String)request.getAttribute("USERNAME");
   String name = firstname + " " + lastname;
%>
<div  class="note">
       
		<p>
			Xin chào bạn <span style="font-weight:bold;"><%= name %></span>. Chúc mừng bạn đã đăng ký thành công!<br />
		</p>
		
		<p style="padding:10px 10px 10px 0px;">
			Chúng tôi sẽ gửi email kích hoạt tài khoản vào địa chỉ <span style="text-decoration:underline;color:#000BFF"><%= request.getAttribute("EMAIL")%></span> của bạn.<br />
			Bạn vui lòng kiểm tra email và nhấn vào liên kết để kích hoạt tài khoản.<br />
		</p>
		
		<p>
			<span style="font-weight:bold;">Lưu ý:</span> <br />
			<ol style="padding-top:0px;margin-top:-12px;margin-left:20px;">
			  <li>Bạn phải chắc chắn rằng địa chỉ email trên là đúng.</li>
			  <li>Nếu bạn không nhận được email kích hoạt, vui lòng kiểm tra thư rác (bulk mail) hoặc click vào <a href='<portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>">
		               <portlet:param name="re_sendemail" value="re_sendemail" />
		               <portlet:param name="username" value="<%=username%>" />
		               <portlet:param name="firstname" value="<%=firstname%>" />
		               <portlet:param name="lastname" value="<%=lastname%>" />
		              </portlet:renderURL>'>đây</a> để yêu cầu gửi lại emai hướng dẫn kích hoạt.
		      </li>
			  <li> Liên kết kích hoạt tài khoản sẽ hết hạn sau 7 ngày.</li>
			</ol>
       </p>
</div>