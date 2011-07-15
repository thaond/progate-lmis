<%@ include file="../../common/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<style type="text/css">
<%@include file="/css/jquery.timeentry.css"%>
</style>
<script type="text/javascript" src="/ProGate-portlet/js/jquery.timeentry.js"></script>

<script type="text/javascript">

jQuery(function() {
	/*
	var href = 
	'<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
		<portlet:param name="action" value="checkingValidImage" />
	</portlet:actionURL>';
	
	jQuery.ajax({
        type: "GET",
		url: href,
		success: function(xml) {			
	 		var name = jQuery(xml).find('name:first');	 		
		},
		error: function(xhr, textStatus, error) {
	        var xml = xhr.responseText; 	        
	        var name = jQuery(xml).find('name:first');	 		
	    }
	});*/
});
</script>

<form action="" metdod="post" name="frmProduct"
	enctype="multipart/form-data">

<div class="tnt-row">
<table class="tnt-table">
	<tbody>
		<tr class="tnt-table-header">
			<td rowspan="2"></td>
			<td rowspan="2"></td>
			<td rowspan="2"></td>
			<td rowspan="2">Mo Ta</td>
			<td rowspan="2">Danh Gia</td>
			<td colspan="3">Trang Thai</td>
		</tr>

		<tr class="tnt-table-header">
			<td>Nhan Vien Danh Gia</td>
			<td>PM Phe Duyet</td>
			<td>BOD Phe Duyet</td>
		</tr>

		<tr class="tnt-table-row-0">
			<td colspan="8">Productivity – Level Ranking: 0 – 1</td>
		</tr>

		<tr class="tnt-table-row-1">
			<td></td>
			<td colspan="7">Level 1</td>
		</tr>

		<tr class="tnt-table-row-0">
			<td></td>
			<td></td>
			<td>2</td>
			<td>Consistently perform well under supervision</td>
			<td>Img1</td>
			<td>Img2</td>
			<td>Img3</td>
			<td>Img3</td>
		</tr>
	</tbody>
</table>
</div>

<div class="tnt-row"><script type="text/javascript">
	var prevCode = 0;

	jQuery(function() {
		jQuery("#comment").keydown(function(evt) {
			if (evt.keyCode == 13) {
				if (prevCode == 1) {
					//alert('Shift + Enter Pressed');
					var rowsVal = jQuery(this).attr("rows");
					jQuery(this).attr("rows", rowsVal + 1);

				} else {
					//alert('Enter Pressed');
				}
			} else if (evt.keyCode == 16) {
				prevCode = 1;
			} else {
				prevCode = 0;
			}
		});

		//jQuery('#defaultEntry').timeEntry();
		//jQuery('#defaultEntry').timepicker();
	});
</script> <textarea rows="1" cols="100" id="comment"></textarea>


<p>
	<span class="demoLabel">Default time entry:</span>
	
	<span class="timeEntry_wrap">
		<input type="text" id="defaultEntry" size="10" class="hasTimeEntry">
	
		<span style="display: inline-block; 
			background: url(&quot;/ProGate-portlet/images/spinnerDefault.png&quot;) no-repeat scroll 0px 0px transparent; 
			width: 20px; height: 20px;"
			class="timeEntry_control" title="Decrement">
		</span>
	</span>
</p>
</div>

</form>