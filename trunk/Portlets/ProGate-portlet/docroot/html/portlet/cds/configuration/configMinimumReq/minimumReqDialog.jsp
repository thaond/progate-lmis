<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script>
	<%@ include file="/js/cds/encoder.js"%>
</script>
<script>
	//cho no overlay khi loading
</script>

<div class='simpleModalPopup span-12' id='addEditMRForm' style="display: none;">
	<div class='header'>
		<span><fmt:message key="title.minimumReq" /></span>
	</div>
	<div class='message'>
		<div class="span-10 prepend-1 append-1">
			<div class="span-10 padding-top"><label class="requiredFieldMessage"><fmt:message key="title.CDS.require.field" /></label></div>
			
			<div class="span-2 padding-top">
				<label><fmt:message key="title.minimumReq.name" /></label>
			</div>
			<div class="span-8 last padding-top">
				<input type="text" MAXLENGTH="50" id="name" class="span-8"/>
			</div>
			<div class="prepend-2 span-8 min-height padding-bottom" id="mR-name-warning">
				<fmt:message key="information.minimumReq.name" />
			</div>
			
			<div class="clear"></div>
			<div class="span-2">
				<label><fmt:message key="title.minimumReq.order" /></label>
			</div>
			<div class="span-8 last">
				<input type="text" MAXLENGTH="2" id="order" class="span-2" onkeypress="return isNumberKey(event)"/>
			</div>
			<div class="prepend-2 span-8 min-height" id="mR-order-warning">
				<fmt:message key="information.minimumReq.order" />
			</div>
			
			<div class="span-12 padding-top padding-bottom" style="margin-left: 135px;">
				<input type="submit" value='<fmt:message key="button.save" />' class="yes" /> <input
					type="submit" value='<fmt:message key="button.cancel" />' class="simplemodal-close no" />
			</div>
		</div>
	</div>
</div>

<div class='simpleModalPopup span-12' id='deleteMRForm' style="display: none;">
	<div class='header'>
		<span><fmt:message key="title.minimumReq" /></span>
	</div>
	<div class='message'>
		<div class="span-10 prepend-1 append-1 padding-top padding-bottom" id="warning">
		</div>
		<div class="span-4 padding-top padding-bottom" style="margin-left: 170px;">
			<input type="submit" value='<fmt:message key="button.yes" />' class="yes" /> 
			<input type="submit" value='<fmt:message key="button.no" />' class="simplemodal-close no" />
		</div>
	</div>
</div>
<script>
function validateMRForm(name, order, oldName){
	var ok = true;
	
	if (isEmptyString(order)){
		jQuery("#mR-order-warning").html('<fmt:message key="warning.minimumReq.order.emptyString" />');
		ok = false;
	} else {
		jQuery("#mR-order-warning").html('');
	}
	
	if (isEmptyString(name)){
		jQuery("#mR-name-warning").html('<fmt:message key="warning.minimumReq.name.emptyString" />');
		ok = false;
	} else {
		jQuery("#mR-name-warning").html('');
	}
	
	if (name != oldName){
		var href = '<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
			<portlet:param name="action" value="configMinimumReq" />
			<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
		</portlet:actionURL>';

		jQuery.ajax({
			type:'POST',
			url: href,
			async: false,
			data: {
				"type":"minimumReq",
				"handle":"checkNameExist",
				"minimumRequirementName":name
			},
			success: function(data){
				if (data == "true"){
					//alert("Khong duoc phep them");
					jQuery("#addEditMRForm #name").focus();
					jQuery("#addEditMRForm #name").select();
					jQuery("#mR-name-warning").html('<fmt:message key="warning.minimumReq.name.exist" />');
					ok = false;
				}
			},
			error: function(){
				//alert("Co loi xay ra khi dung ajax");
			}
		});
	}
	
	return ok;
}

function showMRDeleteDialog(id){
	jQuery('#deleteMRForm').modal({
		closeHTML: "<a href='#' title='Close' style='text-decoration:none;position:absolute; right:15px; top:6px; color:#fff;'><img src='/ProGate-portlet/images/cds/closeDialog.gif'/></a>",
		onShow: function(dialog){
			jQuery('#deleteMRForm .yes').click(function(){
				var href = '<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
								<portlet:param name="action" value="configMinimumReq" />
								<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
							</portlet:actionURL>';
				
				jQuery.ajax({
					type:'POST',
					url: href,
					data: {
						"type":"minimumReq",
						"handle":"delete",
						"id":id
					},
					success: function(data){
						//alert("server said: "+ data);
						location.reload();
					},
					error: function(){
						alert("Co loi xay ra khi dung ajax");
					}
				});
				
				jQuery.modal.close();
			});
		},
		onClose: function(dialog){
			jQuery.modal.close();
			//location.reload();
		}
	});
}

function showMRAddEditDialog(id, nameToEdit){
	
	//xoa du lieu cu
	if (id=="-1"){
		jQuery("#addEditMRForm #name").val("");
		//jQuery("#addEditMRForm #order").val("");
		jQuery("#addEditMRForm #order").val(jQuery("#nextMROrder").val());
	}
	
	jQuery('#addEditMRForm').modal({
		closeHTML: "<a href='#' title='Close' style='text-decoration:none;position:absolute; right:15px; top:6px; color:#fff;'><img src='/ProGate-portlet/images/cds/closeDialog.gif'/></a>",
		onShow: function(dialog){
			jQuery('#addEditMRForm .yes').click(function(){
				
				var href = '<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
								<portlet:param name="action" value="configMinimumReq" />
								<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
							</portlet:actionURL>';
				
				var name = jQuery("#addEditMRForm #name").val();
				var order = jQuery("#addEditMRForm #order").val();
				var oldName = nameToEdit;
				
				if (validateMRForm(name, order, oldName)){
					
					jQuery.ajax({
						type:'POST',
						url: href,
						data: {
							"type":"minimumReq",
							"handle":"add",
							"id":id,
							"name":name,
							"order":order
						},						
						success: function(data){
							//alert("server said: "+ data);
							location.reload();
						},
						error: function(){
							alert("Co loi xay ra khi dung ajax");
						}
					});
					jQuery.modal.close(); //tat popup
					
				} else {
					return false;
				}
			});
		},
		onClose: function(dialog){
			jQuery.modal.close();
			//location.reload();
		}
	});
}

jQuery('.editMR').click(function(e){
	e.preventDefault();
	
	var href = '<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
					<portlet:param name="action" value="configMinimumReq" />
					<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
				</portlet:actionURL>';
	var id = e.currentTarget.parentNode.parentNode.getElementsByTagName("input")[0].value.toString();
	
	//load du lieu vao popup
	jQuery.ajax({
		type:'GET',
		url: href,
		//dataType: 'xml',		
		data: {
			"type":"minimumReq",
			"handle":"edit",
			"id":id,
		},
		success: function(xml){
			//alert("Data:" + xml);
			//alert(jQuery(xml).find('name:first').html());

			var nameToEdit = jQuery(xml).find('name:first').text();
			var orderToEdit = jQuery(xml).find('order:first').text();
			
			jQuery('#addEditMRForm #name').val(nameToEdit);
			jQuery('#addEditMRForm #order').val(orderToEdit);
			
			//hien pop-up
			showMRAddEditDialog(id, nameToEdit);
		},
		error: function(){
			alert("Co loi xay ra khi dung ajax");
		}
	});
	
});

jQuery('#addMR').click(function (e) {
		e.preventDefault();
		showMRAddEditDialog("-1", "");
});

jQuery('.deleteMR').click(function(e){
	e.preventDefault();
	var id = e.currentTarget.parentNode.parentNode.getElementsByTagName("input")[0].value.toString();
	var name = e.currentTarget.parentNode.parentNode.getElementsByTagName("input")[1].value.toString();
	var hasLevels = e.currentTarget.parentNode.parentNode.getElementsByTagName("input")[3].value.toString();
	var message;
	
	if (hasLevels == "0"){
		message = '<fmt:message key="warning.minimumReq.delete.confirm">' + '<fmt:param>' + name + '</fmt:param>' + '</fmt:message>';
	} else {
		message = '<fmt:message key="warning.minimumReq.delete.hasLevels.confirm">' + '<fmt:param>' + name + '</fmt:param>' + '</fmt:message>';
	}
	
	jQuery('#deleteMRForm #warning').html(message);
	showMRDeleteDialog(id);
});

</script>