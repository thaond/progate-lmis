package com.larion.progate.organization.logo.action;

import java.io.File;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
import larion.progate.model.User;
import larion.progate.service.UserLocalServiceUtil;
*/

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.larion.progate.common.utils.Functions;
import com.larion.progate.common.utils.ProGateUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Time;

import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;

import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.imagegallery.model.IGFolder;
import com.liferay.portlet.imagegallery.model.IGImage;
import com.liferay.portlet.imagegallery.service.IGImageLocalServiceUtil;



public class UploadAction extends PortletAction {
	@Override
	public void serveResource(ActionMapping arg0, ActionForm arg1,
			PortletConfig arg2, ResourceRequest arg3, ResourceResponse arg4)
			throws Exception {
		
		
		super.serveResource(arg0, arg1, arg2, arg3, arg4);
	}
	
	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(
			actionRequest);
		String fileLogoParam = "file";
		File file = uploadRequest.getFile(fileLogoParam);		
		ServiceContext sc;

		try {

			sc = ServiceContextFactory.getInstance(this.getClass().getName() , actionRequest);
			//Make sure the uploaded images can be view by any one;
			sc.setAddCommunityPermissions(true);
			sc.setAddGuestPermissions(true);
	
					
			IGFolder folder = Functions.getIGFolder(sc);
            //String fileName = uploadRequest.getFileName(fileLogoParam);
            String contentType = uploadRequest.getContentType(fileLogoParam);
            
            
            IGImage image = IGImageLocalServiceUtil.addImage(sc.getUserId(), 
					folder.getFolderId(), 
					file.getName() + (new Time()).toString(), 
					file.getName(), 
					file, contentType, sc); 
           
         
            HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(actionRequest);
            String res = image.getImageId()
            			+ "|" 
            			+ ProGateUtil.getImageURL(image.getSmallImageId(), servletRequest)
            			+ "|"
            			+ ProGateUtil.getImageURL(image.getLargeImageId(), servletRequest);
            ProGateUtil.servletPrint(actionResponse ,res);          
			
			
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			
			
			e.printStackTrace();
		}
		catch(SystemException se){
			
			se.printStackTrace();
		}
		catch(NullPointerException e2){
			
			e2.printStackTrace();
		}
		
		
	}
}
