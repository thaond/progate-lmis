<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script>
	<%@ include file="/js/cds/encoder.js"%>
</script>
<script>
function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : "";
	if (obj.getAttribute && obj.value.length>mlength)
		obj.value=obj.value.substring(0,mlength);
}
</script>
<div class='simpleModalPopup span-12' id='addEditSlotForm' style="display: none;">
	<div class='header'>
		<span><fmt:message key="title.slot" /></span>
	</div>
	<div class='message'>
		<div class="span-10 prepend-1 append-1">
			<div class="span-10 padding-top"><label class="requiredFieldMessage"><fmt:message key="title.CDS.require.field" /></label></div>
			
			<div class="span-2 padding-top">
				<label><fmt:message key="title.slot.name" /></label>
			</div>
			<div class="span-8 last padding-top">
				<input type="text" id="name" MAXLENGTH="50" class="span-8"/>
			</div>
			<div class="clear"></div>
			<div class="prepend-2 span-8 min-height padding-bottom" id="slot-name-warning">
				<fmt:message key="information.slot.name" />
			</div>
			
			<div class="span-2">
				<label><fmt:message key="title.slot.description" /></label>
			</div>
			<div class="span-8 last">
				<textarea rows="5" cols="" id="description" class="span-8" maxlength="255" onkeyup="return ismaxlength(this)"></textarea>
			</div>
			<div class="prepend-2 span-8 min-height padding-bottom" id="slot-description-warning">
				<fmt:message key="information.slot.description" />
			</div>
			
			<div class="span-2">
				<label><fmt:message key="title.slot.order" /></label>
			</div>
			<div class="span-8 last">
				<input type="text" id="order" class="span-2" MAXLENGTH="2" onkeypress="return isNumberKey(event)"/>
			</div>
			<div class="prepend-2 span-8 min-height" id="slot-order-warning">
				<fmt:message key="information.slot.order" />
			</div>
			
			<div class="span-12 padding-top padding-bottom" style="margin-left: 135px;">
				<input type="submit" value='<fmt:message key="button.save" />' class="yes" /> <input
					type="submit" value='<fmt:message key="button.cancel" />' class="simplemodal-close no" />
			</div>
		</div>
	</div>
</div>

<div class='simpleModalPopup span-12' id='deleteSlotForm' style="display: none;">
	<div class='header'>
		<span><fmt:message key="title.slot" /></span>
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

function validateSlotForm(name, order, description, oldName, parentId){
	var ok = true;
	
	if (isEmptyString(order)){
		jQuery("#slot-order-warning").html('<fmt:message key="warning.slot.order.emptyString" />');
		ok = false;
	} else {
		jQuery("#slot-order-warning").html('');
	}
	
	if (isEmptyString(name)){
		jQuery("#slot-name-warning").html('<fmt:message key="warning.slot.name.emptyString" />');
		ok = false;
	} else {
		jQuery("#slot-name-warning").html('');
	}
	
	if (isEmptyString(description)){
		jQuery("#slot-description-warning").html('<fmt:message key="warning.slot.description.emptyString" />');
		ok = false;
	} else {
		jQuery("#slot-description-warning").html('');
	}
	
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
				"type":"slot",
				"handle":"checkNameExist",
				"slotName":name,
				"parentId":parentId
			},
			success: function(data){
				//alert(name);
				//alert(data);
				if (data == "true"){
					//alert("Khong duoc phep them");
					jQuery("#addEditSlotForm #name").focus();
					jQuery("#addEditSlotForm #name").select();
					jQuery("#slot-name-warning").html('<fmt:message key="warning.slot.name.exist" />');
					ok = false;
				}
				//alert(ok);
				return ok;
			},
			error: function(){
				//alert("Co loi xay ra khi dung ajax");
			}
		});
	}
	
	return ok;
}


function showSlotDeleteDialog(id){
	jQuery('#deleteSlotForm').modal({
		closeHTML: "<a href='#' title='Close' style='text-decoration:none;position:absolute; right:15px; top:6px; color:#fff;'><img src='/ProGate-portlet/images/cds/closeDialog.gif'/></a>",
		onShow: function(dialog){
			jQuery('#deleteSlotForm .yes').click(function(){
				var href = '<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
								<portlet:param name="action" value="commonController" />
								<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
							</portlet:actionURL>';
				
				jQuery.ajax({
					type:'POST',
					url: href,
					data: {
						"type":"slot",
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

function showSlotAddEditDialog(id, parentId, oldName, description, order){

	jQuery("#addEditSlotForm #name").val(oldName);
	jQuery("#addEditSlotForm #order").val(order);	
	jQuery("#addEditSlotForm #description").val(description);
	
	jQuery('#addEditSlotForm').modal({
		closeHTML: "<a href='#' title='Close' style='text-decoration:none;position:absolute; right:15px; top:6px; color:#fff;'><img src='/ProGate-portlet/images/cds/closeDialog.gif'/></a>",
		onShow: function(dialog){
			jQuery('#addEditSlotForm .yes').click(function(){
				var href = '<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
								<portlet:param name="action" value="commonController" />
								<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
							</portlet:actionURL>';
				
				var name = jQuery("#addEditSlotForm #name").val();
				var order = jQuery("#addEditSlotForm #order").val();
				var description = jQuery("#addEditSlotForm #description").val();
				
				if (validateSlotForm(name, order, description, oldName, parentId)){
					jQuery.ajax({
						type:'POST',
						url: href,
						data: {
							"type":"slot",
							"handle":"add",
							"id":id,
							"parentId":parentId,
							"name":name,
							"order":order,
							"description":description,
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
	//		location.reload();
		}
	});
}

jQuery('.editSlot').click(function(e){
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
			"type":"slot",
			"handle":"edit",
			"id":id,
		},
		success: function(xml){
			//alert("Data:" + xml);
			//alert(jQuery(xml).find('name:first').html());

			var nameToEdit = jQuery(xml).find('name:first').text();
			var orderToEdit = jQuery(xml).find('order:first').text();
			var parentId = jQuery(xml).find('parentId:first').text();
			var descriptionToEdit = jQuery(xml).find('description:first').text();
			
			//hien pop-up
			showSlotAddEditDialog(id, parentId, nameToEdit, descriptionToEdit, orderToEdit);
		},
		error: function(){
			alert("Co loi xay ra khi dung ajax");
		}
	});
	
});

jQuery('.addSlot').click(function (e) {
		e.preventDefault();
		var parentId = e.currentTarget.parentNode.parentNode.getElementsByTagName("input")[0].value.toString();
		var defaultOrder = e.currentTarget.parentNode.parentNode.getElementsByTagName("input")[2].value.toString();
		
		showSlotAddEditDialog("-1", parentId, "", "", defaultOrder);
});

jQuery('.deleteSlot').click(function(e){
	e.preventDefault();
	var id = e.currentTarget.parentNode.parentNode.getElementsByTagName("input")[0].value.toString();
	var name = e.currentTarget.parentNode.parentNode.getElementsByTagName("input")[1].value.toString();
	var message = '<fmt:message key="warning.slot.delete.confirm">' + '<fmt:param>' + Encoder.htmlEncode(name, true) + '</fmt:param>' + '</fmt:message>'; 
	jQuery('#deleteSlotForm #warning').html(message);
	showSlotDeleteDialog(id);
});

</script>