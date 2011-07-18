package com.larion.progate.cds.action;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import larion.progate.cds.model.CdsEvaluationPeriods;
import larion.progate.cds.model.CdsMinimumRequirements;
import larion.progate.model.Organization;
import larion.progate.model.ProgateOrganizationsStaffs;
import larion.progate.cds.service.CdsEvaluationPeriodsLocalServiceUtil;
import larion.progate.cds.service.CdsMinimumRequirementsLocalServiceUtil;
import larion.progate.service.OrganizationLocalServiceUtil;
import larion.progate.service.ProgateOrganizationsStaffsLocalServiceUtil;
import larion.progate.cds.service.utils.importFile;

import com.larion.progate.cds.constant.RequestConst;
import com.larion.progate.cds.utils.PermissionAndRole;
import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.constants.RSConstants;
import com.larion.progate.common.constants.Request;
import com.larion.progate.common.utils.Functions;
import com.larion.progate.common.utils.ProGateUtil;
import com.liferay.documentlibrary.FileSizeException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.permission.DLFolderPermission;

public class InputDataAction extends ParameterizableViewAction {

	private PermissionAndRole perAndRoleInputData = new PermissionAndRole();

	@Override
	public void handleActionRequestInternal(ActionRequest request,
			ActionResponse response, Map<String, Object> bean) throws Exception {
		// TODO Auto-generated method stub
		//bean.put(RSConstants.VIEW_NAME, "cds/inputData/inputDataScreen");
		String page = ParamUtil
				.getString(request, RequestConst.INPUT_DATA_PAGE);

		ServiceContext sc = ServiceContextFactory.getInstance(this.getClass()
				.getName(), request);
		int userId = (int) sc.getUserId();
		bean.put("userId", userId);

		int orgId = ParamUtil.getInteger(request, Request.ORG_ID);
		bean.put("orgId", orgId);

		if (RequestConst.INPUT_DATA_PAGE_2.equals(page)) {
			System.out.println("----------------------");
			HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
			req.setCharacterEncoding("UTF-8");

			String org = Integer.toString(orgId);

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
				System.out.println("fileEntryId:" + fileEntryId);

				if (fileEntryId != -1 || fileEntryId != -2) {
					response.setRenderParameter("action", "commonController");
					response.setRenderParameter(Request.ORG_ID, org);
					response.setRenderParameter(RequestConst.INPUT_DATA_PAGE,
							RequestConst.INPUT_DATA_PAGE_1);
					
					int selectedProjectIdInt = ParamUtil.getInteger(request, RequestConst.PROJECT_ID);
					System.out.println("selectedProjectIdInt: "+selectedProjectIdInt);
					String selectedProjectIdString = Integer.toString(selectedProjectIdInt);
					System.out.println("selectedProjectIdString: "+selectedProjectIdString);
					response.setRenderParameter(RequestConst.PROJECT_ID, selectedProjectIdString);
					
					int importUserIdInt = ParamUtil.getInteger(request, RequestConst.EMPLOYEE_ID);
					System.out.println("importUserIdInt: "+importUserIdInt);
					String importUserIdString = Integer.toString(importUserIdInt);
					System.out.println("importUserIdString: "+importUserIdString);
					response.setRenderParameter("importUserId", importUserIdString);
				}

				if (fileEntryId == -1 || fileEntryId == -2) {
					int employeeId = ParamUtil.getInteger(request,
							RequestConst.EMPLOYEE_ID);
					System.out.println("employeeId:" + employeeId);
					String employee = Integer.toString(employeeId);

					String employeeName = ParamUtil.getString(request,
							RequestConst.EMPLOYEE_NAME);
					System.out.println("employeeName:" + employeeName);

					String employeePosition = ParamUtil.getString(request,
							RequestConst.EMPLOYEE_POSITION);
					System.out.println("employeePosition:" + employeePosition);

					String projectOfEmployee = ParamUtil.getString(request,
							RequestConst.EMPLOYEE_PROJECT);
					System.out
							.println("projectOfEmployee:" + projectOfEmployee);

					response.setRenderParameter("action", "commonController");
					response.setRenderParameter(Request.ORG_ID, org);
					response.setRenderParameter(RequestConst.INPUT_DATA_PAGE,
							RequestConst.INPUT_DATA_PAGE_2);
					response.setRenderParameter(RequestConst.EMPLOYEE_ID,
							employee);
					response.setRenderParameter(RequestConst.EMPLOYEE_NAME,
							employeeName);
					response.setRenderParameter(RequestConst.EMPLOYEE_POSITION,
							employeePosition);
					response.setRenderParameter(RequestConst.EMPLOYEE_PROJECT,
							projectOfEmployee);
					if (fileEntryId == -1) {
						response.setRenderParameter(
								RequestConst.FILE_SIZE_TOO_BIG,
								"fileSizeTooBig");
					}
					if (fileEntryId == -2) {
						response.setRenderParameter(RequestConst.UPLOAD_ERROR,
								"uploadError");
					}
				}

				DLFileEntry fileEntry = DLFileEntryLocalServiceUtil
						.getDLFileEntry(fileEntryId);
				System.out.println("fileEntry:" + fileEntry);
				InputStream io = DLFileEntryLocalServiceUtil.getFileAsStream(
						fileEntry.getCompanyId(), fileEntry.getUserId(),
						fileEntry.getFolderId(), fileEntry.getName());
				System.out.println("InputStream: " + io);
				int employeeId = ParamUtil.getInteger(request,
						RequestConst.EMPLOYEE_ID);
				System.out.println("employeeId: " + employeeId);
				importFile cdsfile = new importFile();
				System.out.println("orgId: " + orgId);
				System.out.println("userId: " + userId);
				
				try {
					boolean complete = cdsfile
							.importData(orgId, employeeId, io);
					System.out.println("complete: " + complete);
					if (complete == false) {
						int employeeID = ParamUtil.getInteger(request,
								RequestConst.EMPLOYEE_ID);
						System.out.println("employeeID:" + employeeID);
						String selectedEmployee = Integer.toString(employeeID);

						String employeeName = ParamUtil.getString(request,
								RequestConst.EMPLOYEE_NAME);
						System.out.println("employeeName:" + employeeName);

						String employeePosition = ParamUtil.getString(request,
								RequestConst.EMPLOYEE_POSITION);
						System.out.println("employeePosition:"
								+ employeePosition);

						String projectOfEmployee = ParamUtil.getString(request,
								RequestConst.EMPLOYEE_PROJECT);
						System.out.println("projectOfEmployee:"
								+ projectOfEmployee);

						response.setRenderParameter("action",
								"commonController");
						response.setRenderParameter(Request.ORG_ID, org);
						response.setRenderParameter(
								RequestConst.INPUT_DATA_PAGE,
								RequestConst.INPUT_DATA_PAGE_2);
						response.setRenderParameter(RequestConst.EMPLOYEE_ID,
								selectedEmployee);
						response.setRenderParameter(RequestConst.EMPLOYEE_NAME,
								employeeName);
						response.setRenderParameter(
								RequestConst.EMPLOYEE_POSITION,
								employeePosition);
						response.setRenderParameter(
								RequestConst.EMPLOYEE_PROJECT,
								projectOfEmployee);
						response.setRenderParameter(RequestConst.UPLOAD_ERROR,
								"uploadError");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {

		try {
			String page = ParamUtil.getString(request,
					RequestConst.INPUT_DATA_PAGE);
			if (page == null || page.equals("")) {
				page = RequestConst.INPUT_DATA_PAGE_1;
			}

			int rootId = ParamUtil.getInteger(request, Request.ORG_ID);
			if (rootId == 0) {
				HttpServletRequest orgReq = PortalUtil
						.getOriginalServletRequest(PortalUtil
								.getHttpServletRequest(request));
				rootId = ParamUtil.getInteger(orgReq, Request.ORG_ID);
			}
			if (rootId == 0) {
				HttpServletRequest httpSR = PortalUtil.getHttpServletRequest(request);
				HttpServletRequest origReq = PortalUtil.getOriginalServletRequest(httpSR);
				rootId = ProGateUtil.getOrganizationId(origReq);
			}
			bean.put("orgId", rootId);
			
			ServiceContext sc = ServiceContextFactory.getInstance(this
					.getClass().getName(), request);
			int userId = (int) sc.getUserId();
			bean.put("userId", userId);

			perAndRoleInputData.check(rootId, userId,
					RequestConst.PERMISSION_INPUT_DATA);
			bean.put("hasPermissionInputData",
					perAndRoleInputData.isPermitted());

			if (perAndRoleInputData.isPermitted()) {
				if (RequestConst.INPUT_DATA_PAGE_1.equals(page)) {
					
					List<Organization> orgs = new ArrayList<Organization>();
					orgs = OrganizationLocalServiceUtil.getProjectOfBOD(rootId);
					bean.put("orgs", orgs);

					int selectedProjectId = ParamUtil.getInteger(request,
							RequestConst.PROJECT_ID);
					System.out.println("selectedProjectId: "+selectedProjectId);
					if (selectedProjectId == 0 && orgs.size() != 0) {
						selectedProjectId = orgs.get(0).getOrgId();
					}
					bean.put("selectedProjectId", selectedProjectId);
					System.out
							.println("selectedProjectId:" + selectedProjectId);

					List<ProgateOrganizationsStaffs> employees = new ArrayList<ProgateOrganizationsStaffs>();
					employees = ProgateOrganizationsStaffsLocalServiceUtil
							.getEmployeesInCompany(rootId, selectedProjectId);

					for (ProgateOrganizationsStaffs progateOrganizationsStaffs : employees) {
						System.out.println(progateOrganizationsStaffs);
					}
					bean.put("employees", employees);

					boolean lockInput = false;
					List<CdsEvaluationPeriods> listEP = CdsEvaluationPeriodsLocalServiceUtil
							.getPeriodByRootId(rootId);
					if (listEP.size() != 0) {
						for (CdsEvaluationPeriods cdsEvaluationPeriods : listEP) {
							if (cdsEvaluationPeriods.getIsModified() == true) {
								lockInput = true;
								break;
							}
						}
					}
					bean.put("lockInput", lockInput);
					
					int importUserId = ParamUtil.getInteger(request,
							"importUserId");
					bean.put("importUserId", importUserId);
					System.out.println("importUserId:" + importUserId);
				}

				if (RequestConst.INPUT_DATA_PAGE_2.equals(page)) {
					int projectId = ParamUtil.getInteger(request,
							RequestConst.PROJECT_ID);
					bean.put("selectedProjectId", projectId);
					System.out.println("projectId:" + projectId);
					
					int employeeId = ParamUtil.getInteger(request,
							RequestConst.EMPLOYEE_ID);
					bean.put("employeeId", employeeId);
					System.out.println("employeeId:" + employeeId);

					String employeeName = ParamUtil.getString(request,
							RequestConst.EMPLOYEE_NAME);
					bean.put("employeeName", employeeName);
					System.out.println("employeeName:" + employeeName);

					String employeePosition = ParamUtil.getString(request,
							RequestConst.EMPLOYEE_POSITION);
					bean.put("employeePosition", employeePosition);
					System.out.println("employeePosition:" + employeePosition);

					String projectOfEmployee = ParamUtil.getString(request,
							RequestConst.EMPLOYEE_PROJECT);
					bean.put("projectOfEmployee", projectOfEmployee);
					System.out
							.println("projectOfEmployee:" + projectOfEmployee);

					String fileSizeTooBig = ParamUtil.getString(request,
							RequestConst.FILE_SIZE_TOO_BIG);
					bean.put("fileSizeTooBig", fileSizeTooBig);
					System.out.println("fileSizeTooBig:" + fileSizeTooBig);

					String uploadError = ParamUtil.getString(request,
							RequestConst.UPLOAD_ERROR);
					bean.put("uploadError", uploadError);
					System.out.println("uploadError:" + uploadError);
				}

				if (RequestConst.INPUT_DATA_PAGE_3.equals(page)) {
					int employeeId = ParamUtil.getInteger(request,
							RequestConst.EMPLOYEE_ID);
					bean.put("employeeId", employeeId);
					System.out.println("employeeId:" + employeeId);

					String employeeName = ParamUtil.getString(request,
							RequestConst.EMPLOYEE_NAME);
					bean.put("employeeName", employeeName);
					System.out.println("employeeName:" + employeeName);

					String employeePosition = ParamUtil.getString(request,
							RequestConst.EMPLOYEE_POSITION);
					bean.put("employeePosition", employeePosition);
					System.out.println("employeePosition:" + employeePosition);

					String projectOfEmployee = ParamUtil.getString(request,
							RequestConst.EMPLOYEE_PROJECT);
					bean.put("projectOfEmployee", projectOfEmployee);
					System.out
							.println("projectOfEmployee:" + projectOfEmployee);

					List<CdsMinimumRequirements> minimumRequirements = CdsMinimumRequirementsLocalServiceUtil
							.getMinimumRequirementListByRootId(rootId);
					bean.put("minimumRequirements", minimumRequirements);
				}

				if (RequestConst.INPUT_DATA_PAGE_4.equals(page)) {
					int employeeId = ParamUtil.getInteger(request,
							RequestConst.EMPLOYEE_ID);
					bean.put("employeeId", employeeId);
					System.out.println("employeeId:" + employeeId);

					String employeeName = ParamUtil.getString(request,
							RequestConst.EMPLOYEE_NAME);
					bean.put("employeeName", employeeName);
					System.out.println("employeeName:" + employeeName);

					String employeePosition = ParamUtil.getString(request,
							RequestConst.EMPLOYEE_POSITION);
					bean.put("employeePosition", employeePosition);
					System.out.println("employeePosition:" + employeePosition);

					String projectOfEmployee = ParamUtil.getString(request,
							RequestConst.EMPLOYEE_PROJECT);
					bean.put("projectOfEmployee", projectOfEmployee);
					System.out
							.println("projectOfEmployee:" + projectOfEmployee);
				}
			}

			bean.put("activedPage", page);
			bean.put("INPUT_DATA_PAGE_1", RequestConst.INPUT_DATA_PAGE_1);
			bean.put("INPUT_DATA_PAGE_2", RequestConst.INPUT_DATA_PAGE_2);
			bean.put("INPUT_DATA_PAGE_3", RequestConst.INPUT_DATA_PAGE_3);
			bean.put("INPUT_DATA_PAGE_4", RequestConst.INPUT_DATA_PAGE_4);
		} catch (Exception e) {
			e.printStackTrace();
		}

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
		DLFileEntry fileEntry;
		String fileName1 = "file input";
		String fileTitle = fileName;
		int count = DLFileEntryLocalServiceUtil.getDLFileEntriesCount();
		String countStr = Integer.toString(count);
		String[] fileTitleChane = fileTitle.split(".csv");
		String fileTitleChanged = fileTitleChane[0] + countStr;
		System.out.println("ten file: " + fileTitleChanged);
		try {
			fileEntry = DLFileEntryLocalServiceUtil.addFileEntry(
					themeDisplay.getUserId(), folderId, fileName,
					fileTitleChanged, fileName1, "", file, serviceContext);
			long fileEntryId = fileEntry.getFileEntryId();
			return fileEntryId;
		} catch (FileSizeException fileSizeTooBig) {
			fileSizeTooBig.printStackTrace();
			System.out.println("File size qua lon");
			return -1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Upload file co loi");
			return -2;
		}
	}

}
