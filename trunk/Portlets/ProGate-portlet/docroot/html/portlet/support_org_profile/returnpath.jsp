<%
	String currentURL = (String)renderRequest.getAttribute("currentURL");
	int beginParameter = currentURL.indexOf("?");
	String returnPath = "";
	if (beginParameter != -1){
		returnPath = currentURL.substring(0, beginParameter);
	}	
	renderRequest.setAttribute("returnPath", returnPath);
	
	String returnGeneralPath = "";
	int indexGuide = currentURL.indexOf("&actionView");
	if (indexGuide != -1){
		returnGeneralPath = currentURL.substring(0, indexGuide);		
	}
	renderRequest.setAttribute("returnGeneralPath", returnGeneralPath);	
	
%>
