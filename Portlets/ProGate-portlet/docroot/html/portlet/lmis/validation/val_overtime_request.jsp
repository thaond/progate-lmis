<script type="text/javascript">
	jQuery(document).ready(function() {
		jQuery("input:text").not('#tdreason').keydown(function(e) {
	    	// Allow only backspace and delete
	    	if ( e.keyCode == 46 || e.keyCode == 8 || e.keyCode==9 || e.keyCode== 37 || e.keyCode== 38 || e.keyCode==39 || e.keyCode==40) {
	    		// let it happen, don't do anything
	    	}
	    	else {
	    		// Ensure that it is a number and stop the keypress
	    		if (e.keyCode < 48 || e.keyCode > 57 ) {
	    			e.preventDefault();
	    		}
	    	}
		});
		jQuery(".date-input-ot").keydown(function(e) {
	    		if (e.keyCode > 0 ) {
	    			e.preventDefault();
	    		}
		});

		jQuery(".h").keydown(function(e) {
			if ( e.keyCode == 46 || e.keyCode == 8 || e.keyCode==9 || e.keyCode== 37 || e.keyCode==38 || e.keyCode==39 || e.keyCode==40) {
	    	}else	{
	    		if (e.keyCode < 48 || e.keyCode > 57 ) {
	    			e.preventDefault();
	    		}
	    	}
		});
		jQuery(".h").blur(function(e) {
			var v = jQuery(this).val();
			if(v >=12){
				jQuery(this).val('12');
			}
			if(v=="0" || v==""){
				jQuery(this).val('2');
			}

		});
		jQuery(".H").keydown(function(e) {
			if ( e.keyCode == 46 || e.keyCode == 8 ) {
	    		// let it happen, don't do anything
	    	}else	{
	    		if (e.keyCode < 48 || e.keyCode > 57 ) {
	    			e.preventDefault();
	    		}
	    	}
		});
	 	jQuery(".H").blur(function(e) {
			var v = jQuery(this).val();
			if(v >=24){
				jQuery(this).val('23');
			}
			if(v=="" || v==null){
				jQuery(this).val('00');
			}
		});
		jQuery(".m").keydown(function(e) {
			if ( e.keyCode == 46 || e.keyCode == 8 ) {
	    		// let it happen, don't do anything
	    	}else	{
	    		if (e.keyCode < 48 || e.keyCode > 57 ) {
	    			e.preventDefault();
	    		}
	    	}
		});
		jQuery(".m").blur(function(e) {
			var v = jQuery(this).val();
			if(v >=60){
				jQuery(this).val('59');
			}
			if(v=="" || v==null){
				jQuery(this).val('00');
			}
		});
 

	});
</script>