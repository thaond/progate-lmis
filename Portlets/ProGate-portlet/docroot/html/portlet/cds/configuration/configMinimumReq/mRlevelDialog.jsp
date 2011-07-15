<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script>
	<%@ include file="/js/cds/encoder.js"%>
</script>
<div class='simpleModalPopup span-12' id='addEditMRLevelForm' style="display: none;">
	<div class='header'>
		<span><fmt:message key="title.mRLevel" /></span>
	</div>
	<div class='message'>
		<div class="span-10 prepend-1 append-1">
			<div class="span-10 padding-top"><label class="requiredFieldMessage"><fmt:message key="title.CDS.require.field" /></label></div>
			
			<div class="span-2 padding-top">
				<label><fmt:message key="title.mRLevel.name" /></label>
			</div>
			<div class="span-8 last padding-top">
				<input type="text" id="name" MAXLENGTH="50" class="span-8"/>
			</div>
			<div class="prepend-2 span-8 min-height padding-bottom" id="mRLevel-name-warning">
				<fmt:message key="information.mRLevel.name" />
			</div>
			<div class="clear"></div>
			
			<div class="span-2">
				<label><fmt:message key="title.mRLevel.order" /></label>
			</div>
			<div class="span-8 last">
				<input type="text" id="order" class="span-2" MAXLENGTH="2" onkeypress="return isNumberKey(event)"/>
			</div>
			<div class="prepend-2 span-8 min-height" id="mRLevel-order-warning">
				<fmt:message key="information.minimumReq.order" />
			</div>
			<div class="span-12 padding-top padding-bottom" style="margin-left: 135px;">
				<input type="submit" value='<fmt:message key="button.save" />' class="yes" /> <input
					type="submit" value='<fmt:message key="button.cancel" />' class="simplemodal-close no" />
			</div>
		</div>
	</div>
</div>

<div class='simpleModalPopup span-12' id='deleteMRLevelForm' style="display: none;">
	<div class='header'>
		<span><fmt:message key="title.mRLevel" /></span>
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

function validateMRLevelForm(name, order, oldName, parentId){
	var ok = true;
	if (isEmptyString(order)){
		jQuery("#mRLevel-order-warning").html('<fmt:message key="warning.mRLevel.order.emptyString" />');
		ok = false;
	} else {
		jQuery("#mRLevel-order-warning").html('');
	}
	
	if (isEmptyString(name)){
		jQuery("#mRLevel-name-warning").html('<fmt:message key="warning.mRLevel.name.emptyString" />');
		ok = false;
	} else {
		jQuery("#mRLevel-name-warning").html('');
	}
	//alert("name="+name);
	//alert("oldName="+oldName);
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
				"type":"mRLevel",
				"handle":"checkNameExist",
				"minimumRequirementLevelName":name,
				"parentId":parentId
			},
			success: function(data){
				//alert(name);
				//alert("data="+data);
				if (data == "true"){
					//alert("Khong duoc phep them");
					jQuery("#addEditMRLevelForm #name").focus();
					jQuery("#addEditMRLevelForm #name").select();
					jQuery("#mRLevel-name-warning").html('<fmt:message key="warning.mRLevel.name.exist" />');
					ok = false;
				}
			},
			error: function(){
				//alert("Co loi xay ra khi dung ajax");
			}
		});
	}
	//alert("ok="+ok);
	return ok;
}
function showMRLevelDeleteDialog(id){
	jQuery('#deleteMRLevelForm').modal({
		closeHTML: "<a href='#' title='Close' style='text-decoration:none;position:absolute; right:15px; top:6px; color:#fff;'><img src='/ProGate-portlet/images/cds/closeDialog.gif'/></a>",
		onShow: function(dialog){
			jQuery('#deleteMRLevelForm .yes').click(function(){
				var href = '<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
								<portlet:param name="action" value="configMinimumReq" />
								<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
							</portlet:actionURL>';
				
				jQuery.ajax({
					type:'POST',
					url: href,
					data: {
						"type":"mRLevel",
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

function showMRLevelAddEditDialog(id, parentId, oldName, order){
	
	jQuery("#addEditMRLevelForm #name").val(oldName);
	jQuery("#addEditMRLevelForm #order").val(order);
	
	jQuery('#addEditMRLevelForm').modal({
		closeHTML: "<a href='#' title='Close' style='text-decoration:none;position:absolute; right:15px; top:6px; color:#fff;'><img src='/ProGate-portlet/images/cds/closeDialog.gif'/></a>",
		onShow: function(dialog){
			jQuery('#addEditMRLevelForm .yes').click(function(){
				var href = '<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
								<portlet:param name="action" value="configMinimumReq" />
								<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
							</portlet:actionURL>';
				
				var name = jQuery("#addEditMRLevelForm #name").val();
				var order = jQuery("#addEditMRLevelForm #order").val();
				
				if (validateMRLevelForm(name, order, oldName, parentId)){
					jQuery.ajax({
						type:'POST',
						url: href,
						data: {
							"type":"mRLevel",
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
							//alert("Co loi xay ra khi dung ajax");
						}
					});
					
					jQuery.modal.close();
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

jQuery('.editMRLevel').click(function(e){
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
			"type":"mRLevel",
			"handle":"edit",
			"id":id,
		},
		success: function(xml){
			//alert("Data:" + xml);
			//alert(jQuery(xml).find('name:first').html());

			var nameToEdit = jQuery(xml).find('name:first').text();
			var orderToEdit = jQuery(xml).find('order:first').text();
			var parentId = jQuery(xml).find('parentId:first').text();
			
			jQuery('#addEditMRLevelForm #name').val(nameToEdit);
			jQuery('#addEditMRLevelForm #order').val(orderToEdit);
			
			//hien pop-up
			showMRLevelAddEditDialog(id, parentId, nameToEdit, orderToEdit);
		},
		error: function(){
			//alert("Co loi xay ra khi dung ajax");
		}
	});
	
});

jQuery('.addMRLevel').click(function (e) {
		e.preventDefault();
		var parentId = e.currentTarget.parentNode.parentNode.getElementsByTagName("input")[0].value.toString();
		var defaultOrder = e.currentTarget.parentNode.parentNode.getElementsByTagName("input")[2].value.toString();
		showMRLevelAddEditDialog("-1", parentId, "", defaultOrder);
});

jQuery('.deleteMRLevel').click(function(e){
	e.preventDefault();
	var id = e.currentTarget.parentNode.parentNode.getElementsByTagName("input")[0].value.toString();
	var name = e.currentTarget.parentNode.parentNode.getElementsByTagName("input")[1].value.toString();
	var message = '<fmt:message key="warning.mRLevel.delete.confirm">' + '<fmt:param>' + Encoder.htmlEncode(name, true) + '</fmt:param>' + '</fmt:message>';
	
	jQuery('#deleteMRLevelForm #warning').html(message);
	showMRLevelDeleteDialog(id);
});

</script>