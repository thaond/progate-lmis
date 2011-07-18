<%@ include file="../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<script type="text/javascript">
	jQuery(function() {
		var right = Math.round((jQuery(window).width() - 960)/2) - 1;
		
		jQuery(".last-child-menu").css("right", right);
	});
</script>

<div id="beneathnav">
<c:out value="${bean.navMenu}" escapeXml="false"></c:out>
</div>