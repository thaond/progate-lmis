package com.larion.progate.supportorgprofile.struts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.ecs.xhtml.s;

import larion.progate.model.User;

import larion.progate.model.Organization;
import larion.progate.service.UserLocalServiceUtil;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.ActionRequestImpl;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.StrutsPortlet;
import com.larion.progate.supportorgprofile.util.CreatePathSupportOrg;
import com.larion.progate.common.constants.ProgateRoleConst;

public class SupportOrgProfileStruts extends StrutsPortlet {
	
	
	public void doView(RenderRequest req, RenderResponse res)
		throws IOException, PortletException {
			
			String targetPage = "";
			boolean turnDirection = false;
			ArrayList<String> myarr = new ArrayList();
			HashMap<String, String> hm = new HashMap();
			
			String currentURL = PortalUtil.getCurrentURL(req);
			req.setAttribute("currentURL", currentURL);
			
			HttpServletRequest httpSr = PortalUtil.getHttpServletRequest(req);
			HttpServletRequest origReq = PortalUtil.getOriginalServletRequest(httpSr);
			
			String orgId = origReq.getParameter("orgId");
			String viewMode = origReq.getParameter("viewMode");
			req.setAttribute("viewMode", viewMode);
			
			
			try {
				
				if (orgId != null && viewMode != null) {
					System.out.println("orgId = " + orgId);
					req.setAttribute("orgId", orgId);
					// kiem tra quyen User
					boolean isOrgAdmin = false;
					// Get User
					com.liferay.portal.service.ServiceContext sc = ServiceContextFactory.getInstance(this.getClass().getName(), req);
					com.liferay.portal.model.User user = com.liferay.portal.service.UserLocalServiceUtil.getUser(sc.getUserId());
					long userId = user.getUserId();
					
					List<String> listRole = larion.progate.service.ProgateOrganizationParticipantsLocalServiceUtil.getUserRoles(userId, Integer.parseInt(orgId));
					System.out.println(listRole);
					System.out.println("============================");
					for(String role : listRole){
						// khi nao review code thi chuyen cai bien nay thanh hang so trong file const
						if(ProgateRoleConst.PROGATE_ADMIN.equals(role) 
							|| ProgateRoleConst.ORG_ADMIN.equals(role)
							|| ProgateRoleConst.ORG_OWNER.equals(role)){
							if (viewMode.equals("1")){
								isOrgAdmin = true;
							}
						}
					}
					System.out.println("isOrgAdmin=" + isOrgAdmin);
					req.setAttribute("isOrgAdmin", isOrgAdmin);
					
					myarr.add("guilde");
					myarr.add("question");
					myarr.add("library");
					myarr.add("chatonline");
					hm = CreatePathSupportOrg.createPathSupportOrg(res, orgId, viewMode, myarr);	
					
					Set set = hm.entrySet();

				    Iterator i = set.iterator();
				    
				    while(i.hasNext()){
				      Map.Entry me = (Map.Entry)i.next();				    
				      req.setAttribute((String)me.getKey(), (String)me.getValue());
				    }
				}else{
					turnDirection = true;
					targetPage = "/html/portlet/support_org_profile/plainPage.jsp";
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.toString());
				System.out.println("Co loi tai support org profile");
				turnDirection = true;
				targetPage = "/html/portlet/support_org_profile/plainPage.jsp";
			}
			
			String action = (String)origReq.getParameter("actionView");
			String pageNum = origReq.getParameter("pageNum");
			 
			if (action != null){
				String articleId = origReq.getParameter("articleId");
				req.setAttribute("articleId", articleId);
				if (action.equals("generalGuilde") && orgId != ""){
					turnDirection = true;
					targetPage = "/html/portlet/support_org_profile/guilde/generalGuilde.jsp";
					myarr.clear();
					myarr.add("guilde");
				}
				
				if (action.equals("detailGuilde") && orgId != ""){
					System.out.println("detailGuilde");
					turnDirection = true;
					targetPage = "/html/portlet/support_org_profile/guilde/detailGuilde.jsp";
					myarr.clear();
					myarr.add("guilde");
				}
				
				if (action.equals("generalQuestion") && orgId != ""){
					turnDirection = true;
					targetPage = "/html/portlet/support_org_profile/question/generalQuestion.jsp";
					myarr.clear();
					myarr.add("question");
				}
				 
				if (action.equals("detailQuestion") && orgId != ""){
					turnDirection = true;
					targetPage = "/html/portlet/support_org_profile/question/detailQuestion.jsp";
					myarr.clear();
					myarr.add("question");					
				}
				
				if (action.equals("generalVideo") && orgId != ""){
					turnDirection = true;
					targetPage = "/html/portlet/support_org_profile/library/generalVideo.jsp";
					myarr.clear();
					myarr.add("library");
				}
				 
				if (action.equals("detailVideo") && orgId != ""){
					turnDirection = true;
					targetPage = "/html/portlet/support_org_profile/library/detailVideo.jsp";
					myarr.clear();
					myarr.add("library");
				}
				
				if (action.equals("generalPdf") && orgId != ""){
					turnDirection = true;
					targetPage = "/html/portlet/support_org_profile/library/generalPdf.jsp";
					myarr.clear();
					myarr.add("library");
				}
				 
				if (action.equals("detailPdf") && orgId != ""){
					turnDirection = true;
					targetPage = "/html/portlet/support_org_profile/library/detailPdf.jsp";
					myarr.clear();
					myarr.add("library");
				}
				
				if (orgId != null && viewMode != null){
					hm = CreatePathSupportOrg.createPathSupportOrg(res, orgId, viewMode, myarr);
					Set set = hm.entrySet();

				    Iterator i = set.iterator();
				    
				    while(i.hasNext()){
				      Map.Entry me = (Map.Entry)i.next();				    
				      req.setAttribute((String)me.getKey(), (String)me.getValue());
				    }
				}
				
			    if (pageNum == null && orgId != null) {
					req.setAttribute("pageNum", "1");
				} else if (pageNum != null && orgId != null) {
					req.setAttribute("pageNum", pageNum);
				}
				
			}
			
			String struts_action = (String)req.getParameter("struts_action");
			System.out.println("struts_action = " + struts_action);
			if (struts_action != null){
				myarr.clear();
				turnDirection = false;
			}
			
			if (turnDirection){
				PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher(targetPage);
				prd.include(req, res);
			}else{
				System.out.println("super doView");
				super.doView(req, res);
			}
	}
}
