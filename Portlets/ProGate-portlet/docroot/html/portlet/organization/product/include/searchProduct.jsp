<%@ include file="../../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<div class="tnt-product-search tnt-row">
	<div class="tnt-row-right">
		<div>
		<label><fmt:message key="title.search"/></label>
		
		<input class="txt-search"
			   maxLength="100" type="text" 
			   value='${bean.searchProductName}'
			   name="<%=Constants.SEARCH %>" />
		
		<a href="#" class="tnt-bt-search">&nbsp;</a>
		</div>		
	</div>
</div>
