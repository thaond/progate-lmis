<%@ include file="../../../../common/init.jsp"%>
<%@ include file="../../../../lmis/initOfConfig.jsp"%>

<script type="text/javascript">
//SETTING UP OUR POPUP
//0 means disabled; 1 means enabled;
var popupStatus = 0;

//loading popup with jQuery magic!
function loadPopup(){
	//loads popup only if it is disabled
	if(popupStatus==0){
		jQuery("#backgroundPopup").css({
			"opacity": "0.7"
		});
		jQuery("#backgroundPopup").fadeIn("normal");
		jQuery("#popupHelp").fadeIn("normal");
		popupStatus = 1;
	}
}

//disabling popup with jQuery magic!
function disablePopup(){
	//disables popup only if it is enabled
	if(popupStatus==1){
		jQuery("#backgroundPopup").fadeOut("slow");
		jQuery("#popupHelp").fadeOut("slow");
		popupStatus = 0;
	}
}

//centering popup
function centerPopup(){
	//request data for centering
	var windowWidth = document.documentElement.clientWidth;
	var windowHeight = document.documentElement.clientHeight;
	var popupHeight = jQuery("#popupHelp").height();
	var popupWidth = jQuery("#popupHelp").width();
	//centering
	jQuery("#popupHelp").css({
		"position": "absolute",
		"top": windowHeight/2-popupHeight/2,
		"left": windowWidth/2-popupWidth/2
	});
	//only need force for IE6
	
	jQuery("#backgroundPopup").css({
		"height": windowHeight
	});
	
}


//CONTROLLING EVENTS IN jQuery
jQuery(document).ready(function(){
	
	//LOADING POPUP
	//Click the button event!
	jQuery("#help-icon").click(function(event){
		//centering with css
		centerPopup();
		//load popup
		loadPopup();
		event.preventDefault();
	});
				
	//CLOSING POPUP
	//Click the x event!
	jQuery("#popup-close, #closeHelpPopup").click(function(){
		disablePopup();
	});

	//Press Escape event!
	jQuery(document).keypress(function(e){
		if(e.keyCode==27 && popupStatus==1){
			disablePopup();
		}
	});
});

</script>
<div id="popupHelp">
	<div class="popupHeader">
		<div class="popHeaderTitle">
			<fmt:message key="lmis.config.file.help" />
		</div>
		<div id="popup-close">x</div>
	</div>

	<div id="popupContent">
		<img alt="" src="/ProGate-portlet/images/lmis/example.png">
	</div>
	<div align="center"	style="padding-top: 10px; padding-bottom: 10px; clear: both; cursor: pointer;">
		<input class="button-enable" id="closeHelpPopup" type="reset"	value='<fmt:message key="button.close" />'  />
	</div>
</div>

