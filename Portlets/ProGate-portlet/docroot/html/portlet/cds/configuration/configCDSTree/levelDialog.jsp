<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script>
	<%@ include file="/js/cds/encoder.js"%>
</script>
<div class='simpleModalPopup span-12' id='addEditLevelForm' style="display: none;">
	<div class='header'>
		<span><fmt:message key="title.level" /></span>
	</div>
	<div class='message'>
		<div class="span-10 prepend-1 append-1">
			<div class="span-10 padding-top"><label class="requiredFieldMessage"><fmt:message key="title.CDS.require.field" /></label></div>
			
			<div class="span-2 padding-top">
				<label><fmt:message key="title.level.name" /></label>
			</div>
			<div class="span-8 last padding-top">
				<input type="text" id="name" MAXLENGTH="50" class="span-8"/>
			</div>
			<div class="prepend-2 span-8 min-height padding-bottom" id="level-name-warning">
				<fmt:message key="information.level.name" />
			</div>
			<div class="clear"></div>
			
			<div class="span-2">
				<label><fmt:message key="title.level.order" /></label>
			</div>
			<div class="span-8 last">
				<input type="text" id="order" class="span-2" MAXLENGTH="2" onkeypress="return isNumberKey(event)"/>
			</div>
			<div class="prepend-2 span-8 min-height" id="level-order-warning">
				<fmt:message key="information.level.order" />
			</div>
			<div class="span-12 padding-top padding-bottom" style="margin-left: 135px;">
				<input type="submit" value='<fmt:message key="button.save" />' class="yes" /> <input
					type="submit" value='<fmt:message key="button.cancel" />' class="simplemodal-close no" />
			</div>
		</div>
	</div>
</div>

<div class='simpleModalPopup span-12' id='deleteLevelForm' style="display: none;">
	<div class='header'>
		<span><fmt:message key="title.level" /></span>
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

function validateLevelForm(name, order, oldName, parentId){
	var ok = true;
	if (isEmptyString(order)){
		jQuery("#level-order-warning").html('<fmt:message key="warning.level.order.emptyString" />');
		ok = false;
	} else {
		jQuery("#level-order-warning").html('');
	}
	
	if (isEmptyString(name)){
		jQuery("#level-name-warning").html('<fmt:message key="warning.level.name.emptyString" />');
		ok = false;
	} else {
		jQuery("#level-name-warning").html('');
	}
	
	//alert("name2="+name);
	//alert("oldName2="+oldName);
	
	if (name != oldName){
		var href = '<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
			<portlet:param name="action" value="commonController" />
			<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
		</portlet:actionURL>';

		jQuery.ajax({
			type:'POST',
			url: href,
			async: false,
			data: {
				"type":"level",
				"handle":"checkNameExist",
				"levelName":name,
				"parentId":parentId
			},
			success: function(data){
				//alert(name);
				//alert(data);
				if (data == "true"){
					//alert("Khong duoc phep them");
					jQuery("#addEditLevelForm #name").focus();
					jQuery("#addEditLevelForm #name").select();
					jQuery("#level-name-warning").html('<fmt:message key="warning.level.name.exist" />');
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
function showLevelDeleteDialog(id){
	jQuery('#deleteLevelForm').modal({
		closeHTML: "<a href='#' title='Close' style='text-decoration:none;position:absolute; right:15px; top:6px; color:#fff;'><img src='/ProGate-portlet/images/cds/closeDialog.gif'/></a>",
		onShow: function(dialog){
			jQuery('#deleteLevelForm .yes').click(function(){
				var href = '<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
								<portlet:param name="action" value="commonController" />
								<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
							</portlet:actionURL>';
				
				jQuery.ajax({
					type:'POST',
					url: href,
					data: {
						"type":"level",
						"handle":"delete",
						"id":id
					},
					success: function(data){
						//alert("server said: "+ data);
						location.reload();
					},
					error: function(){
						//alert("Co loi xay ra khi dung ajax");
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

function showLevelAddEditDialog(id, parentId, oldName, order){
	
	jQuery("#addEditLevelForm #name").val(oldName);
	jQuery("#addEditLevelForm #order").val(order);
	
	jQuery('#addEditLevelForm').modal({
		closeHTML: "<a href='#' title='Close' style='text-decoration:none;position:absolute; right:15px; top:6px; color:#fff;'><img src='/ProGate-portlet/images/cds/closeDialog.gif'/></a>",
		onShow: function(dialog){
			jQuery('#addEditLevelForm .yes').click(function(){
				var href = '<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
								<portlet:param name="action" value="commonController" />
								<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
							</portlet:actionURL>';
				
				//alert("oldName="+oldName);
				var name = jQuery("#addEditLevelForm #name").val();
				var order = jQuery("#addEditLevelForm #order").val();
				//alert("name="+name);
				
				if (validateLevelForm(name, order, oldName, parentId)){
					jQuery.ajax({
						type:'POST',
						url: href,
						data: {
							"type":"level",
							"handle":"add",
							"id":id,
							"parentId":parentId,
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
				} else {
					return false;
				}
				
				jQuery.modal.close();
			});
		},
		onClose: function(dialog){
			jQuery.modal.close();
			//location.reload();
		}
	});
}

jQuery('.editLevel').click(function(e){
	e.preventDefault();
	
	var href = '<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
					<portlet:param name="action" value="commonController" />
					<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
				</portlet:actionURL>';
	var id = e.currentTarget.parentNode.parentNode.getElementsByTagName("input")[0].value.toString();
	
	//load du lieu vao popup
	jQuery.ajax({
		type:'GET',
		url: href,
		//dataType: 'xml',		
		data: {
			"type":"level",
			"handle":"edit",
			"id":id,
		},
		success: function(xml){
			//alert("Data:" + xml);
			//alert(jQuery(xml).find('name:first').html());

			var nameToEdit = jQuery(xml).find('name:first').text();
			var orderToEdit = jQuery(xml).find('order:first').text();
			var parentId = jQuery(xml).find('parentId:first').text();
			
			jQuery('#addEditLevelForm #name').val(nameToEdit);
			jQuery('#addEditLevelForm #order').val(orderToEdit);
			
			//hien pop-up
			showLevelAddEditDialog(id, parentId, nameToEdit, orderToEdit);
		},
		error: function(){
			alert("Co loi xay ra khi dung ajax");
		}
	});
	
});

jQuery('.addLevel').click(function (e) {
		e.preventDefault();
		var parentId = e.currentTarget.parentNode.parentNode.getElementsByTagName("input")[0].value.toString();
		var defaultOrder = e.currentTarget.parentNode.parentNode.getElementsByTagName("input")[2].value.toString();
		showLevelAddEditDialog("-1", parentId, "", defaultOrder);
});

jQuery('.deleteLevel').click(function(e){
	e.preventDefault();
	var id = e.currentTarget.parentNode.parentNode.getElementsByTagName("input")[0].value.toString();
	var name = e.currentTarget.parentNode.parentNode.getElementsByTagName("input")[1].value.toString();
	var hasSlots = e.currentTarget.parentNode.parentNode.getElementsByTagName("input")[3].value.toString();
	
	var message;
	
	if (hasSlots == "0"){
		message = '<fmt:message key="warning.level.delete.confirm">' + '<fmt:param>' + Encoder.htmlEncode(name, true) + '</fmt:param>' + '</fmt:message>';
	} else {
		message = '<fmt:message key="warning.level.delete.hasSlots.confirm">' + '<fmt:param>' + Encoder.htmlEncode(name, true) + '</fmt:param>' + '</fmt:message>';
	} 
	jQuery('#deleteLevelForm #warning').html(message);
	showLevelDeleteDialog(id);
});

</script>