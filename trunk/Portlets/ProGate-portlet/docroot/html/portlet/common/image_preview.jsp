<script type="text/javascript">	
	function imagePreview(imgId, imgPreviewId) {		
		var file = document.getElementById(imgId);
		var imgPreview = document.getElementById(imgPreviewId);

		if (document.all) {
			imgPreview.src = file.value;
		} else  {
			imgPreview.src = file.files.item(0).getAsDataURL();
		}
	}
</script>
