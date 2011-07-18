package com.larion.progate.organization.menu.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

import com.larion.progate.common.constants.URLParameter_RS;
import com.larion.progate.common.utils.ProGateUtil;
import com.larion.progate.organization.menu.constants.URL_Const;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.util.PortalUtil;


public class OrgMenuController extends ParameterizableViewController {
	
	@Override
	protected ModelAndView handleRenderRequestInternal(RenderRequest request, RenderResponse response)
			throws Exception {
		
		Map<String, Object> bean = new HashMap<String, Object>();
		
		HttpServletRequest orgRequest = PortalUtil.
				getOriginalServletRequest(
						PortalUtil.getHttpServletRequest(request));
		
		String orgID = ParamUtil.getString(orgRequest, URLParameter_RS.ORG_ID);
		String viewMode = ParamUtil.getString(orgRequest, URLParameter_RS.VIEW_MODE);
		
		String path = URL_Const.ORG_TRANGCHU;
		String viewURL = PortalUtil.getCurrentURL(request);
		
		int index = 0;
		if(viewURL.indexOf(URL_Const.ORG_GIOITHIEU) != -1){
			index = 1;
			path = URL_Const.ORG_GIOITHIEU;
		}
		if(viewURL.indexOf(URL_Const.ORG_TINTUC) != -1){
			index = 2;
			path = URL_Const.ORG_TINTUC;
		}
		if(viewURL.indexOf(URL_Const.ORG_SANPHAM) != -1){
			index = 3;
			path = URL_Const.ORG_SANPHAM;
		}
		if(viewURL.indexOf(URL_Const.ORG_DICHVU) != -1){
			index = 4;
			path = URL_Const.ORG_DICHVU;
		}
		if(viewURL.indexOf(URL_Const.ORG_HOTRO) != -1){
			index = 5;
			path = URL_Const.ORG_HOTRO;
		}
		if(viewURL.indexOf(URL_Const.ORG_SITEMAP) != -1){
			index = 6;
			path = URL_Const.ORG_SITEMAP;
		}
		if(viewURL.indexOf(URL_Const.ORG_GIOITHIEU_TONGQUAN) != -1){
			index = 7;
			path = URL_Const.ORG_GIOITHIEU_TONGQUAN;
		}
		if(viewURL.indexOf(URL_Const.ORG_GIOITHIEU_SODOTOCHUC) != -1){
			index = 8;
			path = URL_Const.ORG_GIOITHIEU_SODOTOCHUC;
		}
		if(viewURL.indexOf(URL_Const.ORG_GIOITHIEU_LICHSUPHATTRIEN) != -1){
			index = 9;
			path = URL_Const.ORG_GIOITHIEU_LICHSUPHATTRIEN;
		}
		if(viewURL.indexOf(URL_Const.ORG_GIOITHIEU_KHACHHANG) != -1){
			index = 10;
			path = URL_Const.ORG_GIOITHIEU_KHACHHANG;
		}
		if(viewURL.indexOf(URL_Const.ORG_GIOITHIEU_DOITAC) != -1){
			index = 11;
			path = URL_Const.ORG_GIOITHIEU_DOITAC;
		}
		
		request.setAttribute(URL_Const.INDEX, index);
		request.setAttribute(URLParameter_RS.ORG_ID, orgID);
		request.setAttribute(URLParameter_RS.VIEW_MODE, viewMode);
		//System.out.println("index: " + index + "- orgID: " + orgID + " - viewMode: " + viewMode);
		//bean.put(URL_Const.INDEX, index);
		//bean.put(URLParameter_RS.ORG_ID, orgID);
		bean.put(URLParameter_RS.VIEW_MODE, viewMode);
		
		bean.put("isAdminOfOrg", ProGateUtil.isAdminOfOrg(request, Integer.parseInt(orgID)));
		
		String viewModeUrl = viewURL.replaceAll(URLParameter_RS.VIEW_MODE + StringPool.EQUAL + viewMode, 
				URLParameter_RS.VIEW_MODE + StringPool.EQUAL + 0);
		bean.put("viewModeUrl", viewModeUrl);
		
		String editModeUrl = viewURL.replaceAll(URLParameter_RS.VIEW_MODE + StringPool.EQUAL + viewMode, 
				URLParameter_RS.VIEW_MODE + StringPool.EQUAL + 1);
		bean.put("editModeUrl", editModeUrl);
		
		String configModeUrl = viewURL.replaceAll(URLParameter_RS.VIEW_MODE + StringPool.EQUAL + viewMode, 
				URLParameter_RS.VIEW_MODE + StringPool.EQUAL + 2);		
		bean.put("configModeUrl", configModeUrl);
		
		return( new ModelAndView(this.getViewName(), "bean", bean));
	}
}