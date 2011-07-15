function scaleImg(img, maxWidth, maxHeight) {
	var width = 0;
	var height = 0;
    var ratio = 1;
	
    // Get current size of image
    width = jQuery(img).attr("width"); 
	height = jQuery(img).attr("height");
	
	// maxWidth = 150; // Max width for the image
    // maxHeight = 120; // Max height for the image
   	
    // Check if the current width is larger than the max
    if (width > maxWidth || height > maxHeight)	{
		if ((maxHeight / height) <= (maxWidth / width))	{			
			ratio = width / height; 
			height = maxHeight;
			width = maxHeight * ratio;
		} else {			
			ratio = height / width; 
			height = maxWidth * ratio ;
			width = maxWidth;
		}
	}
    
    if (height < maxHeight) {
    	var top = Math.round((maxHeight - height)/2);
    	jQuery(img).css("margin-top", top);
    }
	
    if (width < maxWidth) {
    	var left = Math.round((maxWidth - width)/2);
    	jQuery(img).css("margin-left", left);
    }
    
    jQuery(img).css("display", "block");
    jQuery(img).attr("width", width);
    jQuery(img).attr("height", height);    
}
