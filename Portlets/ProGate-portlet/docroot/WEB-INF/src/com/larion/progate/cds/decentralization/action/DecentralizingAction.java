package com.larion.progate.cds.decentralization.action;

import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.constants.Request;
import com.liferay.portal.kernel.util.ParamUtil;

public class DecentralizingAction extends ParameterizableViewAction {

	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {

		String tabAction = ParamUtil.getString(request, Request.TA);
		bean.put("tabAction", tabAction);
	}
}