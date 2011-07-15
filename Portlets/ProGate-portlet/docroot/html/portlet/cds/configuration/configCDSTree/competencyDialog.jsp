<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script>
	<%@ include file="/js/cds/encoder.js"%>
</script>

<div class='simpleModalPopup span-12' id='addEditCompetencyForm'
	style="display: none;">
	<div class='header'>
		<span><fmt:message key="title.competency" /> </span>
	</div>
	<div class='message'>
		<div class="span-10 prepend-1 append-1">
			<div class="span-10 padding-top">
				<label class="requiredFieldMessage"><fmt:message
						key="title.CDS.require.field" /> </label>
			</div>

			<div class="span-2 padding-top">
				<label><fmt:message key="title.competency.name" /> </label>
			</div>
			<div class="span-8 last padding-top">
				<input type="text" MAXLENGTH="50" id="name" class="span-8" />
			</div>
			<div class="prepend-2 span-8 min-height padding-bottom" id="competency-name-warning">
				<fmt:message key="information.competency.name" />
			</div>

			<div class="clear"></div>
			<div class="span-2">
				<label><fmt:message key="title.competency.order" /> </label>
			</div>
			<div class="span-8 last">
				<input type="text" MAXLENGTH="2" id="order" class="span-2" onkeypress="return isNumberKey(event)"/>
			</div>
			<div class="prepend-2 span-8 min-height" id="competency-order-warning">
				<fmt:message key="information.competency.order" />
			</div>

			<div class="span-12 padding-top padding-bottom"
				style="margin-left: 135px;">
				<input type="submit" value='<fmt:message key="button.save" />'
					class="yes" /> <input type="submit"
					value='<fmt:message key="button.cancel" />'
					class="simplemodal-close no" />
			</div>
		</div>
	</div>
</div>

<div class='simpleModalPopup span-12' id='deleteCompetencyForm'
	style="display: none;">
	<div class='header'>
		<span><fmt:message key="title.competency" /> </span>
	</div>
	<div class='message'>
		<div class="span-10 prepend-1 append-1 padding-top padding-bottom"
			id="warning"></div>
		<div class="span-4 padding-top padding-bottom"
			style="margin-left: 170px;">
			<input type="submit" value='<fmt:message key="button.yes" />'
				class="yes" /> <input type="submit"
				value='<fmt:message key="button.no" />' class="simplemodal-close no" />
		</div>
	</div>
</div>
<script>
function validateCompetencyForm(name, order, oldName){
	var ok = true;
	
	if (isEmptyString(order)){
		jQuery("#competency-order-warning").html('<fmt:message key="warning.competency.order.emptyString" />');
		ok = false;
	} else {
		jQuery("#competency-order-warning").html('');
	}
	
	if (isEmptyString(name)){
		jQuery("#competency-name-warning").html('<fmt:message key="warning.competency.name.emptyString" />');
		ok = false;
	} else {
		jQuery("#competency-name-warning").html('');
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
				"type":"competency",
				"handle":"checkNameExist",
				"competencyName":name
			},
			success: function(data){
				if (data == "true"){
					//alert("Khong duoc phep them");
					jQuery("#addEditCompetencyForm #name").focus();
					jQuery("#addEditCompetencyForm #name").select();
					jQuery("#competency-name-warning").html('<fmt:message key="warning.competency.name.exist" />');
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

function showCompetencyDeleteDialog(id){
	jQuery('#deleteCompetencyForm').modal({
		closeHTML: "<a href='#' title='Close' style='text-decoration:none;position:absolute; right:15px; top:6px; color:#fff;'><img src='/ProGate-portlet/images/cds/closeDialog.gif'/></a>",
		onShow: function(dialog){
			jQuery('#deleteCompetencyForm .yes').click(function(){
				var href = '<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
								<portlet:param name="action" value="commonController" />
								<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
							</portlet:actionURL>';
				
				jQuery.ajax({
					type:'POST',
					url: href,
					data: {
						"type":"competency",
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

function showCompetencyAddEditDialog(id, nameToEdit){
	
	//xoa du lieu cu
	if (id=="-1"){ //them competency
		jQuery("#addEditCompetencyForm #name").val("");
		//jQuery("#addEditCompetencyForm #order").val("");
		jQuery("#addEditCompetencyForm #order").val(jQuery("#nextCompetencyOrder").val());
	}
	
	jQuery('#addEditCompetencyForm').modal({
		closeHTML: "<a href='#' title='Close' style='text-decoration:none;position:absolute; right:15px; top:6px; color:#fff;'><img src='/ProGate-portlet/images/cds/closeDialog.gif'/></a>",
		onShow: function(dialog){
			jQuery('#addEditCompetencyForm .yes').click(function(){
				
				var href = '<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
								<portlet:param name="action" value="commonController" />
								<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
							</portlet:actionURL>';
				
				var name = jQuery("#addEditCompetencyForm #name").val();
				var order = jQuery("#addEditCompetencyForm #order").val();
				var oldName = nameToEdit;

				if (validateCompetencyForm(name, order, oldName)){
					jQuery.ajax({
						type:'POST',
						url: href,
						data: {
							"type":"competency",
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
							//alert("Co loi xay ra khi dung ajax");
						}
					});
				} else {
					return false;
				}
				jQuery.modal.close(); //tat popup
			});
		},
		onClose: function(dialog){
			jQuery.modal.close();
			//location.reload();
		}
	});
}

jQuery('.editCompetency').click(function(e){
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
			"type":"competency",
			"handle":"edit",
			"id":id,
		},
		success: function(xml){
			//alert("Data:" + xml);
			//alert(jQuery(xml).find('name:first').html());

			var nameToEdit = jQuery(xml).find('name:first').text();
			var orderToEdit = jQuery(xml).find('order:first').text();
			
			jQuery('#addEditCompetencyForm #name').val(nameToEdit);
			jQuery('#addEditCompetencyForm #order').val(orderToEdit);
			
			//hien pop-up
			showCompetencyAddEditDialog(id, nameToEdit);
		},
		error: function(){
			alert("Co loi xay ra khi dung ajax");
		}
	});
	
});

jQuery('#addCompetency').click(function (e) {
		e.preventDefault();
		showCompetencyAddEditDialog("-1", "");
});

jQuery('.deleteCompetency').click(function(e){
	e.preventDefault();
	var id = e.currentTarget.parentNode.parentNode.getElementsByTagName("input")[0].value.toString();
	var name = e.currentTarget.parentNode.parentNode.getElementsByTagName("input")[1].value.toString();
	var hasLevels = e.currentTarget.parentNode.parentNode.getElementsByTagName("input")[3].value.toString();
	var message;
	
	if (hasLevels == "0"){
		message = '<fmt:message key="warning.competency.delete.confirm">' + '<fmt:param>' + Encoder.htmlEncode(name, true) + '</fmt:param>' + '</fmt:message>';
	} else {
		message = '<fmt:message key="warning.competency.delete.hasLevels.confirm">' + '<fmt:param>' + Encoder.htmlEncode(name, true) + '</fmt:param>' + '</fmt:message>';
	}
	
	jQuery('#deleteCompetencyForm #warning').html(message);
	showCompetencyDeleteDialog(id);
});

</script>