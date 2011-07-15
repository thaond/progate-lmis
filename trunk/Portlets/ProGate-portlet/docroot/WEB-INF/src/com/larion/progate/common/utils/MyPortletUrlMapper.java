package com.larion.progate.common.utils;

import java.util.Map;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;

import com.liferay.portal.kernel.portlet.BaseFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;

public class MyPortletUrlMapper extends BaseFriendlyURLMapper{

	//private String Org_ID = "";		
	//private String Obj_List_ID = "";		
	//private String Per_ID = "" ; 
	
	@Override
	public String buildPath(LiferayPortletURL portletURL) {
	
		String friendlyURLPath = null;		
		String namespace = getNamespace();
		
		if (PortletMode.VIEW.equals(portletURL.getPortletMode())) {
			String action = GetterUtil.getString(portletURL.getParameter("action"));		
			String TabActions = GetterUtil.getString(portletURL.getParameter("TabActions"));		
			String Org_ID = GetterUtil.getString(portletURL.getParameter("Org_ID"));		
			String Obj_List_ID = GetterUtil.getString(portletURL.getParameter("Obj_List_ID"));		
			String Per_ID = GetterUtil.getString(portletURL.getParameter("Per_ID"));		
			
		    friendlyURLPath = StringPool.FORWARD_SLASH + getMapping() +  StringPool.FORWARD_SLASH + action;

		    if (!"".equals(TabActions) && TabActions != null) {
		    	friendlyURLPath = friendlyURLPath + StringPool.FORWARD_SLASH + TabActions;
		    }
		    
		    if (!"".equals(Org_ID) && Org_ID != null) {
		    	friendlyURLPath = friendlyURLPath + StringPool.FORWARD_SLASH + Org_ID;
		    }
		    
		    if (!"".equals(Obj_List_ID) && Obj_List_ID != null) {
		    	friendlyURLPath = friendlyURLPath + StringPool.FORWARD_SLASH + Obj_List_ID;
		    }
		    
		    if (!"".equals(Per_ID) && Per_ID != null) {
		    	friendlyURLPath = friendlyURLPath + StringPool.FORWARD_SLASH + Per_ID;
		    }
		    
		  	portletURL.addParameterIncludedInPath("p_p_id");   
	        //portletURL.addParameterIncludedInPath("p_p_lifecycle");
	        //portletURL.addParameterIncludedInPath("p_p_state");
	        //portletURL.addParameterIncludedInPath("p_p_mode");
	        //portletURL.addParameterIncludedInPath("p_p_col_id");
	        //portletURL.addParameterIncludedInPath("p_p_col_count");
	        portletURL.addParameterIncludedInPath("action");
	        portletURL.addParameterIncludedInPath("TabActions");
	        portletURL.addParameterIncludedInPath("Org_ID");
	        portletURL.addParameterIncludedInPath("Obj_List_ID");
	        portletURL.addParameterIncludedInPath("Per_ID");
		}
		
		return friendlyURLPath;
	}

	@Override
	public String getMapping() {
		// TODO Auto-generated method stub
		return PORTLET_MAPPING;
	}

	@Override
	public void populateParams(String friendlyURLPath, Map<String, String[]> params) {
		
		String[] items = friendlyURLPath.split("/");
		
		if (items.length > 1) {
			
			addParam(params, "p_p_id", PORTLET_ID);
			addParam(params, "p_p_mode", PortletMode.VIEW);
			//addParam(params, "p_p_lifecycle", LIFECYCLE_RENDER);
			addParam(params, "p_p_state", WindowState.MAXIMIZED);
			addParam(params,  "action", getParameter(2,items));
			addParam(params,  "TabActions", getParameter(3,items));
			addParam(params,  "Org_ID", getParameter(4,items));
			addParam(params,  "Obj_List_ID", getParameter(5,items));
			addParam(params,  "Per_ID", getParameter(6,items));
		
		} else {
			
			addParam(params, "p_p_id", PORTLET_ID);
			addParam(params, "p_p_mode", PortletMode.VIEW);
			//addParam(params, "p_p_lifecycle", LIFECYCLE_RENDER);
			addParam(params, "p_p_state", WindowState.NORMAL);
			addParam(params,  "action", getParameter(2,items));
			
		}		
	}

	
	public String getParameter(int index, String[] items) {

		String paramValue = "";

		try {

			paramValue = items[index];

		} catch (ArrayIndexOutOfBoundsException are) {

			paramValue = "";

		} catch (Exception e) {

			paramValue = "";

		}

		return paramValue;
	}

	@Override
	public String getPortletId() {
		// TODO Auto-generated method stub
		return PORTLET_ID;
	}

	private static final String PORTLET_ID = "ProGate_ManageOrgInfo_WAR_ProGate_ManageOrgInfoportlet";
	private static final String PORTLET_MAPPING = "ProGate_ManageOrgInfo";
	private static final String LIFECYCLE_RENDER = "0";
	private static final String LIFECYCLE_ACTION = "1";
	private static final String LIFECYCLE_RESOURCE = "2";
	
}
