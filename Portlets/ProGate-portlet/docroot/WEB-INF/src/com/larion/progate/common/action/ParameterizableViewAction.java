package com.larion.progate.common.action;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class ParameterizableViewAction implements Action{

	private String viewName;
	
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	
	public String getViewName() {
		return viewName;
	}
	
	protected void initApplicationContext() {
		if (this.viewName == null) {
			throw new IllegalArgumentException("viewName is required");
		}
	}
	
	@Override
	public void handleActionRequestInternal(ActionRequest request,
			ActionResponse response, Map<String, Object> bean) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
