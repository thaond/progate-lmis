<%@ include file="init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="javax.portlet.WindowState" %>
<portlet:defineObjects />

<div class="active_success_duplication">
	<span style="font-weight:bold;">Rất tiếc !!! </span>Liên kết kích hoạt tài khoản của bạn đã hết hạn.<br />
    Đừng quá lo lắng. Bạn có thể 
      <a href='<portlet:renderURL windowState="<%= WindowState.NORMAL.toString() %>"></portlet:renderURL>'>đăng ký </a>tài khoản mới ngay bây giờ.
</div>