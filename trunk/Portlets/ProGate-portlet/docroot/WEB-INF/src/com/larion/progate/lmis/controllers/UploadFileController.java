package com.larion.progate.lmis.controllers;

import com.larion.progate.common.constants.Request;
import com.larion.progate.common.utils.Functions;

import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.upload.*;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.permission.DLFolderPermission;
import com.liferay.portlet.documentlibrary.service.persistence.*;

import java.io.File;
import java.io.InputStream;

import java.net.*;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

import larion.progate.lmis.model.LmisGeneralSettings;
import larion.progate.lmis.service.LmisGeneralSettingsLocalServiceUtil;
import larion.progate.lmis.service.utils.LmisUtils;
import larion.progate.lmis.service.utils.UpdateAttInfo;

import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

public class UploadFileController extends ParameterizableViewController {

	@Override
	protected void handleActionRequestInternal(ActionRequest request,
			ActionResponse response) throws Exception {
		System.out.println("----------------------");
		HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
		HttpServletRequest orgReq = PortalUtil.getOriginalServletRequest(req);
		req.setCharacterEncoding("UTF-8");
		Map<String, Object> bean = new HashMap<String, Object>();
		SimpleDateFormat df=new SimpleDateFormat("dd/MM/yy");

		ServiceContext sc = ServiceContextFactory.getInstance(this.getClass().getName(), request);
		User user = UserLocalServiceUtil.getUser(sc.getUserId());
		Long userIdTemp = user.getUserId();
		Integer userId = userIdTemp.intValue();

		String tabAction = ParamUtil.getString(request, Request.TAB_ACTION);
		bean.put("tabAction", tabAction);
		System.out.println("-------------tabaction in upload: " + tabAction);

		response.setRenderParameter("action", "managerAttendanceInfo");
		
		int orgId = ParamUtil.getInteger(request, Request.ORG_ID);
		bean.put("orgId", orgId);
		System.out.println("----------------OrgId in upload: " + orgId);
		String orgIdStr = Integer.toString(orgId);
		response.setRenderParameter(Request.ORG_ID, orgIdStr);
		String cmd = ParamUtil.getString(request, Constants.CMD);
		System.out.println("---save: " + cmd);
		String currentDateStr =request.getParameter(Request.DATEIMPORT);
		System.out.println("cr-----------------------------------------------------------------: "+ currentDateStr);
		Date currentDate=df.parse(currentDateStr);
		System.out.println("currentDate--------------------------------------------------------: "+ currentDate);
		if (cmd.equals(Constants.SAVE)) {
			UploadPortletRequest uploadPortlet = PortalUtil
					.getUploadPortletRequest(request);
			String fileName = uploadPortlet.getFileName("attachFile");
			String fileContent = uploadPortlet.getContentType("attachFile"); // text/plain
			System.out.println("---fileName: " + fileName);
			System.out.println("---fileContent: " + fileContent);
			if (fileName != null) {
				java.io.File file = uploadPortlet.getFile("attachFile");
				System.out.println("----file: " + file);

				// get fileEntryId
				long fileEntryId = getFileEntryIDOfFile(request, file, fileName);
				DLFileEntry fileEntry = DLFileEntryLocalServiceUtil
						.getDLFileEntry(fileEntryId);

				InputStream io = DLFileEntryLocalServiceUtil.getFileAsStream(
						fileEntry.getCompanyId(), fileEntry.getUserId(),
						fileEntry.getFolderId(), fileEntry.getName());
				List<LmisGeneralSettings> ls = LmisGeneralSettingsLocalServiceUtil.getInfoConfigFileAttendance(orgId);
				if(ls.size() ==4){
					ArrayList<String> arr = new ArrayList<String>();
					for (LmisGeneralSettings i : ls) {
						arr.add(i.getName());
					}
					int errCode = LmisUtils.updateAttInfo(orgId, userId, currentDate, 1, true, io, arr);
					System.out.println(errCode);
					System.out.println("InputStream: " + io);
				}else{
					response.setRenderParameter("result", "failed");
				}
				//	public static int updateAttInfo(int rootId, int userId, Date imp,int importType, boolean isSessionRelated, InputStream input)
				//int errCode = LmisUtils.updateAttInfo(arg0, arg1, arg2, arg3, arg4, arg5, arg6)(orgId, userId, currentDate, 1, true, io);
				/*UpdateAttInfo errCode = new UpdateAttInfo(orgId,userId,currentDate,1,true,io);
				if(errCode.getHasError()){
					System.out.println("co loi upload");
				}*/
				
				response.setRenderParameter("result", "success");
			} else {
				response.setRenderParameter("result", "failed");
			}
		}
		bean.put("TAB_PERSONAL", Request.TAB_PERSONAL);
		bean.put("TAB_MANAGER", Request.TAB_MANAGER);
	}

	@Override
	protected ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("---------------this-------render-----");
		Map<String, Object> bean = new HashMap<String, Object>();
		String orgId = ParamUtil.getString(request, Request.ORG_ID);
		bean.put("orgId",orgId);
		System.out.println("------------this render orgId: "+orgId);
		Date date= new Date();
		bean.put("currentDate", date);
		return new ModelAndView(this.getViewName(),"bean",bean);
	}

	public static long getFileEntryIDOfFile(PortletRequest request, File file,
			String fileName) throws Exception {
		System.out.println("--------debug1---------");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				DLFolder.class.getName(), request);
		System.out.println("-------debug2-----------");
		DLFolder folder = Functions.getDLFolder(serviceContext);
		long folderId = folder.getFolderId();

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		DLFolderPermission.check(themeDisplay.getPermissionChecker(),
				folder.getFolderId(), ActionKeys.ADD_DOCUMENT);

		try {
			DLFileEntry fileSame = DLFileEntryLocalServiceUtil.getFileEntry(
					folderId, fileName);
			long fileEntryId1 = fileSame.getFileEntryId();
			DLFileEntryLocalServiceUtil.deleteDLFileEntry(fileEntryId1);
		} catch (Exception e) {
			// not exist nothing
		}
		/*
		 * boolean isExist=false; List<DLFileEntry> listFile =
		 * DLFileEntryLocalServiceUtil.getDLFileEntries(0,
		 * DLFileEntryLocalServiceUtil.getDLFileEntriesCount()); for
		 * (DLFileEntry dlFileEntry : listFile) { if (dlFileEntry.getName()) }
		 */
		DLFileEntry fileEntry;
		String fileName1 = "file input";
		String fileTitle = fileName;
		int count = DLFileEntryLocalServiceUtil.getDLFileEntriesCount();
		String countStr = Integer.toString(count);
		String[] fileTitleChane = fileTitle.split(".csv");
		String fileTitleChanged = fileTitleChane[0] + countStr;
		System.out.println("ten file: "+fileTitleChanged);
		try {
			fileEntry = DLFileEntryLocalServiceUtil.addFileEntry(
					themeDisplay.getUserId(), folderId, fileName,
					fileTitleChanged, fileName1, "", file, serviceContext);
			long fileEntryId = fileEntry.getFileEntryId();
			return fileEntryId;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return -1;
		}
	}
}