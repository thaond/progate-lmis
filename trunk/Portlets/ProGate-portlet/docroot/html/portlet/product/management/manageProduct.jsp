<%@ include file="../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<script type="text/javascript">

	function pagingSubmit(){
		submit();
	}

	function submit(url){
		if (jQuery(".txt-search").val() == '<fmt:message key="title.organization.name.input"/>') {
			jQuery(".txt-search").val('');
		}
		
		if (url == '' || url == null) {
			url = '<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
						<portlet:param name="action" value="productManagement" />
						<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.MANAGE %>" />
					</portlet:renderURL>';
		}
		
		document.frmProduct.action = url;
		document.frmProduct.submit();
	}
	
	function search() {
		var url = '<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
			<portlet:param name="action" value="productManagement" />
			<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.SEARCH %>" />
		</portlet:renderURL>';

		submit(url);
	}

	jQuery(function(){
		
		/* Handle organization selected*/
		jQuery(".tnt-table-row-selected").hover(
			function () {
				if (!jQuery(this).hasClass("tnt-table-row-current")) {
					jQuery(this).find("td").css("background", "AntiqueWhite");
				}
			},
			function () {
				if (!jQuery(this).hasClass("tnt-table-row-current")) {
					if (jQuery(this).hasClass("tnt-table-row-0")) {
						jQuery(this).find("td").css("background", "#d0d8e8");
					} else {
						jQuery(this).find("td").css("background", "#e9edf4");
					}
				}
			}
		);
		
		jQuery(".tnt-table-row-selected").click(function(){
			var selectedOrg = jQuery(this).find(".selectedOrgId");
			
			jQuery(".selectedOrgId").removeAttr("name");
			selectedOrg.attr("name", "selectedOrgId");
			
			submit();
			
		});
		
		/* Handle save/delete */
		jQuery("#productAll").click(function(){
			if(jQuery(this).attr("checked") == true) {			
				jQuery("input[name='productId']").attr("checked",true);
		    }
		    else{	    	
		    	jQuery("input[name='productId']").attr("checked",false);
		    }
		});
		
		jQuery(".productChild").click(function(){
			if(jQuery(this).attr("checked") == false) {
				jQuery("#productAll").attr("checked", false);
			}
		});
		
		jQuery("#save").click(function(){
			
			if(jQuery("input[name='productId']:checked").length == 0) {
				alert('<fmt:message key="warning.product.none.choose"/>');
			}
			else {
				var url = '<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
								<portlet:param name="action" value="productManagement" />
								<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.SAVE %>" />
							</portlet:renderURL>';
				
				submit(url);
			}
		});
		
		jQuery("#delete").click(function(){
			
			if(jQuery("input[name='productId']:checked").length == 0) {
				alert('<fmt:message key="warning.product.none.choose"/>');
			}
			else {
				var url = '<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
								<portlet:param name="action" value="productManagement" />
								<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
							</portlet:renderURL>';
				
				submit(url);
			}
		});
		
		/* Handle search */
		jQuery(".txt-search").focus();
		jQuery(".txt-search").focus(function(){
			if (jQuery(this).val() == '<fmt:message key="title.organization.name.input"/>') {
				jQuery(this).val('');
			}
		});
		jQuery(".txt-search").blur(function(){
			if (jQuery(this).val() == "") {
				jQuery(this).val('<fmt:message key="title.organization.name.input"/>');	
			}
		});
		
		jQuery(".txt-search").bind('keydown', function(e) {
	        if (e.which == 13) {	        	
	        	search();
	        }
	    });
		
		jQuery(".bt-search").click(function(){
			search();
		});
	});

</script>

<form action="" name="frmProduct" method="post">

<div class="pg-right-panel">
	
	<div id="orgList">
		<jsp:include page="include/listOrganization.jsp"></jsp:include>
	</div>
	
	<div id="productList" class="tnt-row">
		<jsp:include page="include/listProduct.jsp"></jsp:include>
	</div>
	
	<div class="tnt-row">
	<div class="tnt-row-left">
		<label><fmt:message key="title.product.type.choose"/></label>
		<select name="<%=Request.PRODUCT_TYPE %>">
			<option value="1"><fmt:message key="title.product.type.1"/></option>
			<option value="2"><fmt:message key="title.product.type.2"/></option>
			<option value="3"><fmt:message key="title.product.type.3"/></option>
		</select>
	</div>
	</div>
	
	<div class="tnt-row">
	<div class="tnt-row-center">
		<input type="button" class="bt-form" id="save" style="width: 80px;"
				value='<fmt:message key="button.add.to" />'/>
		
		<input type="button" class="bt-form" id="delete"
				value='<fmt:message key="button.remove.from" />'/>
	</div>
	</div>
</div>

<input type="hidden" name="<%=Request.CURRENT_ORG_ID %>" value="${bean.currentOrgId }"/>
</form>