package com.larion.progate.common.utils;

import java.util.Map;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;

import com.liferay.portal.kernel.portlet.BaseFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

public class ManageOrgInfoFriendlyURLMapper extends BaseFriendlyURLMapper{

	@Override
	public String buildPath(LiferayPortletURL portletURL) {
		 String friendlyURLPath = null;
		 
		// get the value
	    final String portletId = portletURL.getPortletId();
	    final String eventName = GetterUtil.getString(portletURL.getParameter("event"));
	 
	    if (Validator.isNotNull(portletId) && Validator.isNotNull(eventName)) {
	        friendlyURLPath = StringPool.FORWARD_SLASH + "ProGate_ManageOrgInfoPortlet"+ StringPool.FORWARD_SLASH + portletId + StringPool.FORWARD_SLASH + eventName;
	        portletURL.addParameterIncludedInPath("event");
	    }
	    // add other pararmeters
	    if (Validator.isNotNull(friendlyURLPath)) {
	        portletURL.addParameterIncludedInPath("p_p_id");
	    }
	 
	    return friendlyURLPath;
	}

	@Override
	public String getMapping() {
		// TODO Auto-generated method stub
		return _MAPPING;
	}

	@Override
	public void populateParams(String friendlyURLPath, Map<String, String[]> params) {
		// get the values
	    final String[] parts = StringUtil.split(friendlyURLPath, StringPool.SLASH);
	    portletId = parts[2];
	    final String event = parts[3];
	    final String namespace = getNamespace();
	 
	    params.put("p_p_id", new String[]{portletId});
	    params.put("p_p_state", new String[]{WindowState.NORMAL.toString()});
	    params.put(namespace + "event", new String[]{event});
	}

	@Override
	public String getPortletId() {
		// TODO Auto-generated method stub
		return portletId;
	}
	
	private static final String _MAPPING = "ProGate_ManageOrgInfo";

	private String portletId;	
	
}
