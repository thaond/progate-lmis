
<form action="<liferay-portlet:actionURL portletConfiguration='true'/>" method="post" name="frmConfig">

<div>
	<div class="tnt-row">
		<div class="tnt-row-left">
		<span>
		<fmt:message key="title.num.of.item.config" />
		</span>
		</div>
		
		<div class="tnt-row-right">
		<span>		
		<input type="text" name="<%=ConfigParams_RS.NUM_OF_ITEM %>" value=""/>
		</span>
		</div>
	</div>
	
	<div class="tnt-row">
		<div class="tnt-row-left">
		<span>
		<fmt:message key="title.redirect.url.config" />
		</span>
		</div>
		
		<div class="tnt-row-right">
		<span>
		<% String homeURL = PortalUtil.getPortalURL(request); %>
		<span><%=homeURL %>/</span>
		<input type="text" name="redirectURL" value=""/>
		</span>
		</div>
	</div>
	
	<div class="tnt-row">
		<div class="tnt-row-left">
		<span>
		
		</span>
		</div>
		
		<div class="tnt-row-right">
		<span>		
		
		<span><%=homeURL %>/</span>
		<input type="text" name="productDetailURL" value=""/>
		</span>
		</div>
	</div>	
	
	<div>
	<input type="submit" id="butSubmit" name="butSubmit" value="Save"/>
	</div>
</div>
</form>