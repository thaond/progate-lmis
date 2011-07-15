jQuery(document).ready(function(){
	/* Handle paging */
	jQuery("a.next").click(function(e){			
		var selectPageSelector = jQuery(this).parent().parent().find(".page-selector select");			
		var currentPageNum = selectPageSelector.val();
		selectPageSelector.val(parseInt(currentPageNum) + 1);
		pagingSubmit();
	});
	
	jQuery("a.previous").click(function(e){
		var selectPageSelector = jQuery(this).parent().parent().find(".page-selector select");			
		var currentPageNum = selectPageSelector.val();
		selectPageSelector.val(parseInt(currentPageNum) - 1);
		pagingSubmit();
	});
	
	jQuery("a.first").click(function(e){
		jQuery(this).parent().parent().find(".page-selector select").val(1);
		pagingSubmit();
	});
	
	jQuery("a.last").click(function(e){
		var selectPageSelector = jQuery(this).parent().parent().find(".page-selector select");			
		var numOfPage = jQuery.trim(selectPageSelector.find("option:last").val());
		selectPageSelector.val(numOfPage);		
		pagingSubmit();
	});
	
	jQuery(".page-selector select").change(function(e){
		pagingSubmit();
	});
	
	jQuery(".delta-selector select").change(function(e){
		pagingSubmit();
	});
});
