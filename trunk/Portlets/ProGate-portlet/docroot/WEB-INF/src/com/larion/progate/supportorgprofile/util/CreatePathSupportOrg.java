package com.larion.progate.supportorgprofile.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.portlet.PortletURL;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;
import com.larion.progate.supportorgprofile.constants.PathSupportOrgConst;

public class CreatePathSupportOrg{
	public static HashMap createPathSupportOrg(RenderResponse renderResponse, String orgId, String viewMode, ArrayList<String> arrayList){
		HashMap<String, String> hm = new HashMap();
		
		/*
		 *  tao san cac man hinh di chuyen den phan sua va them
		 */
		try {
			
			//get an Iterator object for ArrayList using iterator() method.
			
			Iterator<String> itr = arrayList.iterator();
		
			while(itr.hasNext()){
			
				
				String command = (String)itr.next();
				
				
				if (command.equals("guilde")){
					// tao duong link sua chua cho phan huong dan
					PortletURL repairGuildePath = renderResponse.createRenderURL();			
					repairGuildePath.setWindowState(WindowState.MAXIMIZED);	
					repairGuildePath.setParameter("struts_action", "/SupportOrgProfile/repairGuilde");
					repairGuildePath.setParameter("orgId", orgId);
					repairGuildePath.setParameter("viewMode", viewMode);
				    hm.put(PathSupportOrgConst.REPAIR_GUIDE_PATH, repairGuildePath.toString());				   
				    
				    // tao duong link them cho phan huong dan
					PortletURL addGuildePath = renderResponse.createRenderURL();
					addGuildePath.setWindowState(WindowState.MAXIMIZED);	
					addGuildePath.setParameter("struts_action", "/SupportOrgProfile/addGuilde");
					addGuildePath.setParameter("orgId", orgId);
					addGuildePath.setParameter("viewMode", viewMode);
					hm.put(PathSupportOrgConst.ADD_GUIDE_PATH, addGuildePath.toString());
				}
				if (command.equals("question")){
					// tao duong link sua chua cho phan cau hoi
					PortletURL repairQuestionPath = renderResponse.createRenderURL();
					repairQuestionPath.setWindowState(WindowState.MAXIMIZED);	
					repairQuestionPath.setParameter("struts_action", "/SupportOrgProfile/repairQuestion");
					repairQuestionPath.setParameter("orgId", orgId);
					repairQuestionPath.setParameter("viewMode", viewMode);
					hm.put(PathSupportOrgConst.REPAIR_QUESTION_PATH, repairQuestionPath.toString());
						
					// tao duong link them cho phan cau hoi
					PortletURL addQuestionPath = renderResponse.createRenderURL();
					addQuestionPath.setWindowState(WindowState.MAXIMIZED);	
					addQuestionPath.setParameter("struts_action", "/SupportOrgProfile/addQuestion");
					addQuestionPath.setParameter("orgId", orgId);
					addQuestionPath.setParameter("viewMode", viewMode);
					hm.put(PathSupportOrgConst.ADD_QUESTION_PATH, addQuestionPath.toString());
				}
				if (command.equals("library")){
					// tao duong link sua chua cho phan thu vien
					PortletURL repairVideoPath = renderResponse.createRenderURL();
					repairVideoPath.setWindowState(WindowState.MAXIMIZED);	
					repairVideoPath.setParameter("struts_action", "/SupportOrgProfile/repairLibrary");
					repairVideoPath.setParameter("orgId", orgId);
					repairVideoPath.setParameter("viewMode", viewMode);
					hm.put(PathSupportOrgConst.REPAIR_LIBRARY_PATH, repairVideoPath.toString());
						
					// tao duong link them cho phan thu vien
					PortletURL addVideoPath = renderResponse.createRenderURL();
					addVideoPath.setWindowState(WindowState.MAXIMIZED);	
					addVideoPath.setParameter("struts_action", "/SupportOrgProfile/addLibrary");
					addVideoPath.setParameter("orgId", orgId);
					addVideoPath.setParameter("viewMode", viewMode);
					hm.put(PathSupportOrgConst.ADD_LIBRARY_PATH, addVideoPath.toString());
				}
				
				if (command.equals("chatonline")){
					// tao duong link sua chua cho phan chatOnline
					PortletURL addChatOnlinePath = renderResponse.createRenderURL();
					addChatOnlinePath.setWindowState(WindowState.MAXIMIZED);	
					addChatOnlinePath.setParameter("struts_action", "/SupportOrgProfile/addChatOnline");
					addChatOnlinePath.setParameter("orgId", orgId);
					addChatOnlinePath.setParameter("viewMode", viewMode);
					hm.put(PathSupportOrgConst.ADD_CHATONLINE_PATH, addChatOnlinePath.toString());
						
					// tao duong link them cho phan chatOnline
					PortletURL repairChatOnlinePath = renderResponse.createRenderURL();
					repairChatOnlinePath.setWindowState(WindowState.MAXIMIZED);	
					repairChatOnlinePath.setParameter("struts_action", "/SupportOrgProfile/repairChatOnline");
					repairChatOnlinePath.setParameter("orgId", orgId);
					repairChatOnlinePath.setParameter("viewMode", viewMode);
					hm.put(PathSupportOrgConst.REPAIR_CHATONLINE_PATH, repairChatOnlinePath.toString());
					
				}
			
			
			
		
		    }
			
		    return hm;
		} catch (Exception e) {
			// TODO: handle exception
			return new HashMap();
		}
		
	}
}