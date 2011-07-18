<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
 
<div class='simpleModalPopup span-10' id='addEditCdsPointsForm' style="display: none;">
	<div class='header'>
		<span><fmt:message key="title.cdspoints" /></span>
	</div>
	<div class='message'>
		<div class="column span-9 last" style="padding-left:20px;padding-right:20px;">
			<div class="column span-9 last" style="padding-top:5px; padding-left:5px;">
				<div class="column" style="width: 60px; text-align: center; color: orange;""><strong>Điểm</strong></div>
				<div class="column" style="padding-left:10px; color:orange;"><strong>Điểm bằng số</strong></div>
				<div class="column" style="padding-left:60px; color:orange;"><strong>Mô tả</strong></div>
			</div>
			<div class="column span-9" style="padding-top:5px; padding-left:5px;">
				<div class="column"><input style="width: 60px; text-align:center;" type="text" value="1" id="name1" name="pName" /> </div>
				<div class="column"> = </div>
				<div class="column"><input style="width: 60px; text-align:center;" type="text" value="1" id="value1" name="pValue" /></div>
				<div class="column"> - </div>
				<div class="column"><input style="width: 160px" type="text" value="Chưa đạt yêu cầu" id="des1" name="pDes" /> <input name="pId" type="hidden" id="id1"/></div>
			</div>
				<div class="column span-9" style="padding-top:10px; padding-left:5px;">
				<div class="column"><input style="width: 60px; text-align:center;" type="text" value="2" id="name2" name="pName" /></div>
				<div class="column"> = </div>
				<div class="column"><input style="width: 60px; text-align:center;" type="text" value="2" id="value2" name="pValue" /></div>
				<div class="column"> - </div>
				<div class="column"><input style="width: 160px" type="text" value="Cần cải thiện" id="des2" name="pDes" /> <input name="pId" type="hidden" id="id2"/></div>
			</div>
				<div class="column span-9" style="padding-top:10px; padding-left:5px;">
				<div class="column"><input style="width: 60px; text-align:center;" type="text" value="3" id="name3" name="pName" /></div>
				<div class="column"> = </div>
				<div class="column"><input style="width: 60px; text-align:center;" type="text" value="3" id="value3" name="pValue" /></div>
				<div class="column"> - </div>
				<div class="column"><input style="width: 160px" type="text" value="Đạt yêu cầu" id="des3" name="pDes" /> <input name="pId" type="hidden" id="id3"/></div>
			</div>
				<div class="column span-9" style="padding-top:10px; padding-left:5px;">
				<div class="column"><input style="width: 60px; text-align:center;" type="text" value="4" id="name4" name="pName" /></div>
				<div class="column"> = </div>
				<div class="column"><input style="width: 60px; text-align:center;" type="text" value="4" id="value4" name="pValue" /></div>
				<div class="column"> - </div>
				<div class="column"><input style="width: 160px" type="text" value="Tốt" id="des4" name="pDes" /> <input name="pId" type="hidden" id="id4"/></div>
			</div>
				<div class="column span-9" style="padding-top:10px; padding-left:5px;">
				<div class="column"><input style="width: 60px; text-align:center;" type="text" value="5" id="name5" name="pName" /></div>
				<div class="column"> = </div>
				<div class="column"><input style="width: 60px; text-align:center;" type="text" value="5" id="value5" name="pValue" /></div>
				<div class="column"> - </div>
				<div class="column"><input style="width: 160px" type="text" value="Xuất sắc" id="des5" name="pDes" /> <input name="pId" type="hidden" id="id5"/></div>
			</div>
			<div style="padding-top: 5px;" class="column">
				<div><label id="errorName" class="requiredFieldMessage"></label></div>
				<div><label id="errorValue" class="requiredFieldMessage"></label></div>
				<div><label id="errorDes" class="requiredFieldMessage"></label></div>
			</div>
			<div style="padding-left: 80px; padding-top: 10px; padding-bottom: 10px;" class="column">
				<input type="submit" value='<fmt:message key="button.save" />' class="yes" /> <input
					type="submit" value='<fmt:message key="button.cancel" />' class="simplemodal-close no" />
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
jQuery("input[@name=pName]").focus(function(){
    if(this.value == "Điểm"){
    	this.value = "";
    }
});
jQuery("input[@name=pName]").blur(function(){
	if(this.value == ""){
    	this.value = "Điểm";
    }
});
jQuery("input[@name=pValue]").focus(function(){
    if(this.value == "Trọng số"){
    	this.value = "";
    }
});
jQuery("input[@name=pValue]").blur(function(){
	if(this.value == ""){
    	this.value = "Trọng số";
    }
});
jQuery("input[@name=pDes]").focus(function(){
    if(this.value == "Mô tả"){
    	this.value = "";
    }
});
jQuery("input[@name=pDes]").blur(function(){
	if(this.value == ""){
    	this.value = "Mô tả";
    }
});
jQuery('input[@name=pValue]').keyup( 
    	function() 
    	{ 
    		this.value = this.value.replace(/[^0-9\.]/g,'');
    	}	
); 

jQuery('#addCdsPoint').click(function (e) {
	e.preventDefault();
	showCdsPointsAddEditDialog("-1");
});

jQuery('#editCdsPoint').click(function (e) {
	e.preventDefault();
	if(${bean.lockEditButton == false}){
		var href = '<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
			<portlet:param name="action" value="cdsPoints" />
			<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
		</portlet:actionURL>';
		jQuery.ajax({
			type:'GET',
			url: href,		
			data: {
				"handle":"edit",
			},
			success: function(xml){
				var id1 = jQuery(xml).find('id1:first').text();
				jQuery('#addEditCdsPointsForm #id1').val(id1);
				var id2 = jQuery(xml).find('id2:first').text();
				jQuery('#addEditCdsPointsForm #id2').val(id2);
				var id3 = jQuery(xml).find('id3:first').text();
				jQuery('#addEditCdsPointsForm #id3').val(id3);
				var id4 = jQuery(xml).find('id4:first').text();
				jQuery('#addEditCdsPointsForm #id4').val(id4);
				var id5 = jQuery(xml).find('id5:first').text();
				jQuery('#addEditCdsPointsForm #id5').val(id5);
				
				var name1 = jQuery(xml).find('name1:first').text();
				jQuery('#addEditCdsPointsForm #name1').val(name1);
				var name2 = jQuery(xml).find('name2:first').text();
				jQuery('#addEditCdsPointsForm #name2').val(name2);
				var name3 = jQuery(xml).find('name3:first').text();
				jQuery('#addEditCdsPointsForm #name3').val(name3);
				var name4 = jQuery(xml).find('name4:first').text();
				jQuery('#addEditCdsPointsForm #name4').val(name4);
				var name5 = jQuery(xml).find('name5:first').text();
				jQuery('#addEditCdsPointsForm #name5').val(name5);
				
				var value1 = jQuery(xml).find('value1:first').text();
				jQuery('#addEditCdsPointsForm #value1').val(value1);
				var value2 = jQuery(xml).find('value2:first').text();
				jQuery('#addEditCdsPointsForm #value2').val(value2);
				var value3 = jQuery(xml).find('value3:first').text();
				jQuery('#addEditCdsPointsForm #value3').val(value3);
				var value4 = jQuery(xml).find('value4:first').text();
				jQuery('#addEditCdsPointsForm #value4').val(value4);
				var value5 = jQuery(xml).find('value5:first').text();
				jQuery('#addEditCdsPointsForm #value5').val(value5);
				
				var des1 = jQuery(xml).find('des1:first').text();
				jQuery('#addEditCdsPointsForm #des1').val(des1);
				var des2 = jQuery(xml).find('des2:first').text();
				jQuery('#addEditCdsPointsForm #des2').val(des2);
				var des3 = jQuery(xml).find('des3:first').text();
				jQuery('#addEditCdsPointsForm #des3').val(des3);
				var des4 = jQuery(xml).find('des4:first').text();
				jQuery('#addEditCdsPointsForm #des4').val(des4);
				var des5 = jQuery(xml).find('des5:first').text();
				jQuery('#addEditCdsPointsForm #des5').val(des5);
				
				showCdsPointsAddEditDialog("0");
			},
			error: function(){
				alert("Co loi xay ra khi dung ajax");
			}
		});
	}
});

function showCdsPointsAddEditDialog(id){

	
	jQuery('#addEditCdsPointsForm').modal({
		closeHTML: "<a href='#' title='Close' style='text-decoration:none;position:absolute; right:16px; top:6px; color:#fff;'><img src='/ProGate-portlet/images/cds/closeDialog.gif'/></a>",
		onShow: function(dialog){
			jQuery('.yes').click(function (e) {
				if(isValidation()){
				var pointname = new Array();
				var pointvalue = new Array();
				var description = new Array();
				var pointid = new Array();
				jQuery('input[@name=pId]').each( 
				    	function() 
				    	{ 
				    		pointid.push(jQuery(this).val());
				    	}	
				); 
				jQuery('input[@name=pName]').each( 
				    	function() 
				    	{ 
				    		pointname.push(jQuery(this).val());
				    	}	
				); 
				jQuery('input[@name=pValue]').each( 
				    	function() 
				    	{ 
				    		pointvalue.push(jQuery(this).val());
				    	}	
				); 
				jQuery('input[@name=pDes]').each( 
				    	function() 
				    	{ 
				    		description.push(jQuery(this).val());
				    	}	
				);
				var href = '<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
								<portlet:param name="action" value="cdsPoints" />
								<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
							</portlet:actionURL>';
				jQuery.ajax({
					type:'POST',
					url: href,
					data: {
						"handle":"add",
						"id":id,
						"data0":pointid,
						"data1":pointname,
						"data2":pointvalue,
						"data3":description
					},
					success: function(data){
						//alert("server said: "+ data);
						location.reload();
					},
					error: function(){
						alert("Co loi xay ra khi dung ajax");
					}
				});
				}
			});
		},
		onClose: function(dialog){
			jQuery.modal.close();
		}
	});
}
</script>