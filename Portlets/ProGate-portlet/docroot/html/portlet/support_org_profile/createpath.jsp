<%
    String orgId = (String)renderRequest.getAttribute("orgId");
	if (orgId != null){
	
		String repairGuide = (String)renderRequest.getAttribute(PathSupportOrgConst.REPAIR_GUIDE_PATH);
		renderRequest.setAttribute("repairGuide", repairGuide);
				
		
		String addGuilde = (String)renderRequest.getAttribute(PathSupportOrgConst.ADD_GUIDE_PATH);
		renderRequest.setAttribute("addGuilde", addGuilde);
		
		String repairQuestion = (String)renderRequest.getAttribute(PathSupportOrgConst.REPAIR_QUESTION_PATH);
		renderRequest.setAttribute("repairQuestion", repairQuestion);
		
		String addQuestion = (String)renderRequest.getAttribute(PathSupportOrgConst.ADD_QUESTION_PATH);
		renderRequest.setAttribute("addQuestion", addQuestion);
		
		String repairLibrary = (String)renderRequest.getAttribute(PathSupportOrgConst.REPAIR_LIBRARY_PATH);
		renderRequest.setAttribute("repairLibrary", repairLibrary);
		
		String addLibrary = (String)renderRequest.getAttribute(PathSupportOrgConst.ADD_LIBRARY_PATH);
		renderRequest.setAttribute("addLibrary", addLibrary);
		
		String repairChatOnline = (String)renderRequest.getAttribute(PathSupportOrgConst.REPAIR_CHATONLINE_PATH);
		renderRequest.setAttribute("repairChatOnline", repairChatOnline);
		
		String addChatOnline = (String)renderRequest.getAttribute(PathSupportOrgConst.ADD_CHATONLINE_PATH);
		renderRequest.setAttribute("addChatOnline", addChatOnline);
		
	}


%>