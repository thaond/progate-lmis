package com.larion.progate.common.action;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public interface Action {
	
	public void handleActionRequestInternal(ActionRequest request,
			ActionResponse response,  Map<String, Object> bean) throws Exception; 
	
	public void handleRenderRequestInternal(RenderRequest request, 
			RenderResponse response, Map<String, Object> bean)	throws Exception;
	
}
