<script type="text/javascript">
	jQuery("#anh${rowCounter.count}").ready(function() {
		
        var maxWidth;
        var maxHeight;
        var width;
        var height;
        var ratio;
        
        var img = new Image();
        
		img.onload = function() {
		  //alert(this.width + 'x' + this.height);
		  width = this.width;    // Current image width
       	  height = this.height; 
       	  maxWidth = 150; // Max width for the image
          maxHeight = 120;    // Max height for the image
       	
       	   // Check if the current width is larger than the max
	        if(width >= height && width >= maxWidth)
	        {
        		ratio = maxWidth / width;   // get ratio for scaling image	           
	            width = maxWidth;
	            height = height * ratio;
	            if (height>=maxHeight){
	            	height = maxHeight;
	            }	  
	        }
	        else if(height > width && height >= maxHeight)
	        {
        		ratio = maxHeight / height; // get ratio for scaling image
	            height = maxHeight;
	            width = width * ratio;	
	            if (width>=maxWidth){
	            	width = maxWidth;
	            }    				           
	        }
	        
       	  jQuery("#anh${rowCounter.count}").attr({
				src: "${logo}",
				height: height,
				width: width
			});
			
		  if (height < maxHeight){
		  	var top = Math.round((maxHeight - height)/2);
		  	jQuery("#anh${rowCounter.count}").css("margin-top", top);	
		  }	
		  
		}
		img.src = '${logo}';
	});
								
</script>				