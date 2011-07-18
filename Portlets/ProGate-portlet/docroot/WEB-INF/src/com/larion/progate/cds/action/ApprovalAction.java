package com.larion.progate.cds.action;

import java.io.PrintWriter;
import java.text.Format;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringEscapeUtils;

import larion.progate.cds.model.CdsEvaluationPeriods;
import larion.progate.cds.model.CdsPerformanceAppraisalSlotComments;
import larion.progate.cds.model.CdsPerformanceAppraisalSlotRating;
import larion.progate.cds.model.CdsPerformanceAppraisals;
import larion.progate.cds.model.CdsPoints;
import larion.progate.model.Organization;
import larion.progate.model.ProgateOrganizationsStaffs;
import larion.progate.cds.model.ViewEmployeesInProjects;
import larion.progate.cds.model.ViewPerformanceAppraisalSlots;
import larion.progate.cds.service.CdsEvaluationPeriodsLocalServiceUtil;
import larion.progate.cds.service.CdsPASlotsLocalServiceUtil;
import larion.progate.cds.service.CdsPerformanceAppraisalSlotCommentsLocalServiceUtil;
import larion.progate.cds.service.CdsPerformanceAppraisalSlotRatingLocalServiceUtil;
import larion.progate.cds.service.CdsPerformanceAppraisalsLocalServiceUtil;
import larion.progate.cds.service.CdsPointsLocalServiceUtil;
import larion.progate.service.OrganizationLocalServiceUtil;
import larion.progate.service.ProgateOrganizationsStaffsLocalServiceUtil;
import larion.progate.service.UserLocalServiceUtil;
import larion.progate.cds.service.ViewEmployeesInProjectsLocalServiceUtil;
import larion.progate.cds.service.ViewEmployeesSlotsRatingLocalServiceUtil;
import larion.progate.cds.service.ViewFinalTitlesLocalServiceUtil;
import larion.progate.cds.service.ViewPerformanceAppraisalSlotsLocalServiceUtil;

import com.larion.progate.cds.constant.RequestConst;
import com.larion.progate.cds.utils.PermissionAndRole;
import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.cds.utils.PaginationObject;
import com.larion.progate.common.constants.Request;
import com.larion.progate.common.utils.ProGateUtil;
import com.liferay.ibm.icu.text.SimpleDateFormat;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;

public class ApprovalAction extends ParameterizableViewAction {

	private PermissionAndRole perAndRoleOnTab1 = new PermissionAndRole();
	private PermissionAndRole perAndRoleOnTab2 = new PermissionAndRole();
	private PermissionAndRole perAndRoleOnTab3 = new PermissionAndRole();

	@Override
	public void handleActionRequestInternal(ActionRequest request,
			ActionResponse response, Map<String, Object> bean) throws Exception {
		int rootId = ParamUtil.getInteger(request, Request.ORG_ID, 0);
		if (rootId == 0) {
			HttpServletRequest orgReq = PortalUtil
					.getOriginalServletRequest(PortalUtil
							.getHttpServletRequest(request));
			rootId = ParamUtil.getInteger(orgReq, Request.ORG_ID);
		}

		bean.put("orgId", rootId);

		ServiceContext sc = ServiceContextFactory.getInstance(this.getClass()
				.getName(), request);
		int userId = (int) sc.getUserId();

		HttpServletResponse res = PortalUtil.getHttpServletResponse(response);
		res.setCharacterEncoding("UTF-8");
		PrintWriter output = res.getWriter();

		String tab = ParamUtil.getString(request, RequestConst.TAB);

		//Kiem tra o man hinh la quyen phe duyet toan cong ty hay phe duyet tung du an
		perAndRoleOnTab1.check(rootId, userId,
				RequestConst.PERMISSION_EMPLOYEE_IN_COMPANY_APPROVAL);
		if (perAndRoleOnTab1.isPermitted() == false){
			perAndRoleOnTab1.check(rootId, userId,
					RequestConst.PERMISSION_EMPLOYEE_IN_PROJECT_APPROVAL);
		}
		
		perAndRoleOnTab2.check(rootId, userId,
				RequestConst.PERMISSION_ALL_STAFF_APPROVAL);

		if (RequestConst.TAB_APPROVAL_1.equals(tab)) {

			if (perAndRoleOnTab1.isPermitted()) {
				handleActionTab1(request, response, bean, rootId, userId,
						perAndRoleOnTab1.getUserRole(), output); // Phe duyet ca
																	// nhan
			}
		}
		if (RequestConst.TAB_APPROVAL_2.equals(tab)) {
			if (perAndRoleOnTab2.isPermitted()) {
				handleActionTab2(request, response, bean, rootId, userId,
						perAndRoleOnTab2.getUserRole(), output); // Phe duyet
																	// toan bo
			}
		}
		if (RequestConst.TAB_APPROVAL_3.equals(tab)) {

		}
		output.flush();
	}

	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {

		try {
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

			/* Kiem tra quyen tren tung man hinh */
			
			//Kiem tra o man hinh la quyen phe duyet toan cong ty hay phe duyet tung du an
			perAndRoleOnTab1.check(rootId, userId,
					RequestConst.PERMISSION_EMPLOYEE_IN_COMPANY_APPROVAL);
			if (perAndRoleOnTab1.isPermitted() == false){
				perAndRoleOnTab1.check(rootId, userId,
						RequestConst.PERMISSION_EMPLOYEE_IN_PROJECT_APPROVAL);
			}
			
			perAndRoleOnTab2.check(rootId, userId,
					RequestConst.PERMISSION_ALL_STAFF_APPROVAL);
			perAndRoleOnTab3.check(rootId, userId,
					RequestConst.PERMISSION_TITLE_APPROVAL);

			bean.put("hasPermissionOnTab1", perAndRoleOnTab1.isPermitted());
			bean.put("hasPermissionOnTab2", perAndRoleOnTab2.isPermitted());
			bean.put("hasPermissionOnTab3", perAndRoleOnTab3.isPermitted());

			bean.put("ROLE_PM", RequestConst.ROLE_PM);
			bean.put("ROLE_BOD", RequestConst.ROLE_BOD);

			String tab = ParamUtil.getString(request, RequestConst.TAB);
			if (tab == null || tab.equals("")) {
				if (perAndRoleOnTab1.isPermitted()) {
					tab = RequestConst.TAB_APPROVAL_1;
				} else if (perAndRoleOnTab2.isPermitted()) {
					tab = RequestConst.TAB_APPROVAL_2;
				} else if (perAndRoleOnTab3.isPermitted()) {
					tab = RequestConst.TAB_APPROVAL_3;
				} else {
					tab = RequestConst.TAB_APPROVAL_1;
				}
			}

			bean.put("region", "");

			if (RequestConst.TAB_APPROVAL_1.equals(tab)) {

				if (perAndRoleOnTab1.isPermitted()) {
					bean.put("userRole", perAndRoleOnTab1.getUserRole());
					// System.out.println("userRole" +
					// perAndRoleOnTab1.getUserRole());
					String page = ParamUtil.getString(request,
							RequestConst.TAB_PAGE,
							RequestConst.TAB_APPROVAL_1_PAGE_1);

					if (page.equals(RequestConst.TAB_APPROVAL_1_PAGE_1)) {
						handleRenderTab1Page1(request, response, bean, rootId,
								userId, perAndRoleOnTab1.getUserRole());
					}
					if (page.equals(RequestConst.TAB_APPROVAL_1_PAGE_2)) {
						handleRenderTab1Page2(request, response, bean, rootId,
								userId, perAndRoleOnTab1.getUserRole());
					}
					bean.put("page", page);
					bean.put("TAB_APPROVAL_1_PAGE_1",
							RequestConst.TAB_APPROVAL_1_PAGE_1);
					bean.put("TAB_APPROVAL_1_PAGE_2",
							RequestConst.TAB_APPROVAL_1_PAGE_2);
				}
			}

			if (RequestConst.TAB_APPROVAL_2.equals(tab)) {
				bean.put("userRole", perAndRoleOnTab2.getUserRole());
				// System.out.println("userRole" +
				// perAndRoleOnTab1.getUserRole());
				if (perAndRoleOnTab2.isPermitted()) {
					handleRenderTab2(request, response, bean, rootId, userId,
							perAndRoleOnTab2.getUserRole());
				}
			}

			if (RequestConst.TAB_APPROVAL_3.equals(tab)) {
				if (perAndRoleOnTab3.isPermitted()) {
					bean.put("userRole", perAndRoleOnTab3.getUserRole());
					handleRenderTab3(request, response, bean, rootId, userId,
							perAndRoleOnTab3.getUserRole());
				}
			}

			bean.put("activedTab", tab);
			
			bean.put("TAB_APPROVAL_1", RequestConst.TAB_APPROVAL_1);
			bean.put("TAB_APPROVAL_2", RequestConst.TAB_APPROVAL_2);
			bean.put("TAB_APPROVAL_3", RequestConst.TAB_APPROVAL_3);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void handleRenderTab1Page1(RenderRequest request,
			RenderResponse response, Map<String, Object> bean, int rootId,
			int userId, int userRole) throws Exception {
		boolean disableApproval = ParamUtil.getBoolean(request,
				RequestConst.DISABLE_APPROVAL);
		// System.out.println("disableApproval=" + disableApproval);
		bean.put("disableApproval", disableApproval);

		List<CdsEvaluationPeriods> periods = CdsEvaluationPeriodsLocalServiceUtil
				.loadCdsPeriods(2, rootId);

		if (periods.size() == 0) {
			bean.put("errorHaveNotAnyOpenPeriod", true);
			bean.put("errorHaveNotAnyOpenPeriodMessage",
					"Không có đợt CDS nào đang mở.");
		} else {
			bean.put("errorHaveNotAnyOpenPeriod", false);
			int selectedPeriodId = ParamUtil.getInteger(request,
					RequestConst.PERIOD_ID);

			if (selectedPeriodId == 0) {
				selectedPeriodId = periods.get(0).getCdsEvaluationPeriodsId();
			}
			bean.put("periods", periods);
			bean.put("selectedPeriodId", selectedPeriodId);

			List<Organization> orgs = new ArrayList<Organization>();

			if (userRole == RequestConst.ROLE_PM) {
				orgs = OrganizationLocalServiceUtil.getProjectOfPM(rootId,
						userId);
			}

			if (userRole == RequestConst.ROLE_BOD) {
				orgs = OrganizationLocalServiceUtil.getProjectOfBOD(rootId);
			}

			// System.out.println("orgs = " + orgs); /////////////////////////
			bean.put("orgs", orgs);

			int selectedProjectId = ParamUtil.getInteger(request,
					RequestConst.PROJECT_ID);
			/*
			 * if (selectedProjectId == 0) { selectedProjectId =
			 * orgs.get(0).getPrimaryKey(); }
			 */
			bean.put("selectedProjectId", selectedProjectId);
			// System.out.println("selectedProjectId" + selectedProjectId);
			int selectedCdsStatus = ParamUtil.getInteger(request,
					RequestConst.CDS_STATUS, 3);
			bean.put("selectedCdsStatus", selectedCdsStatus);
			// System.out.println("selectedCdsStatus = " + selectedCdsStatus);

			List<ViewEmployeesInProjects> fullEmployees = new ArrayList<ViewEmployeesInProjects>();
			if (userRole == RequestConst.ROLE_PM) {
				fullEmployees = ViewEmployeesInProjectsLocalServiceUtil
						.getEmployees(selectedPeriodId, selectedProjectId,
								selectedCdsStatus, userId);
			}
			if (userRole == RequestConst.ROLE_BOD) {
				fullEmployees = ViewEmployeesInProjectsLocalServiceUtil
						.getEmployeesBOD(selectedPeriodId, selectedProjectId,
								selectedCdsStatus, rootId);
			}

			// Xu li loai bo nhung nhan vien chua danh gia slot nao
			List<ViewEmployeesInProjects> employees = new ArrayList<ViewEmployeesInProjects>();
			for (ViewEmployeesInProjects e : fullEmployees) {
				if (e.getRatingStatus() != 0) {
					// Neu la BOD thi chi hien ra nhung nhan vien thuoc du an
					// dang chon ???
					/*
					 * if ((userRole == RequestConst.ROLE_PM) || (userRole ==
					 * RequestConst.ROLE_BOD &&
					 * (ViewEmployeesInProjectsLocalServiceUtil
					 * .checkEmployee(selectedPeriodId, e.getUserId()) ==
					 * e.getOrgId()))){ employees.add(e); }
					 */

					/*
					 * if (userRole == RequestConst.ROLE_PM){ employees.add(e);
					 * } else if (userRole == RequestConst.ROLE_BOD){ if
					 * (selectedProjectId != 0){ if
					 * (ViewEmployeesInProjectsLocalServiceUtil
					 * .checkEmployee(selectedPeriodId, e.getUserId()) ==
					 * e.getOrgId()){ employees.add(e); } } else {
					 * employees.add(e); } }
					 */
					employees.add(e);
				}
			}
			bean.put("sizeOfEmployees", employees.size());

			PaginationObject pagination = new PaginationObject("employees",
					employees.size());
			pagination.paging(request);

			employees = employees.subList(pagination.getStartIndex(),
					pagination.getEndIndex());

			bean.put("pagination", pagination);
			bean.put("employees", employees);
			// employees.get(0).getIsRemoved();
			// System.out.println("employees = " + employees);
			// employees.get(0).get;
			// CdsPerformanceAppraisalsLocalServiceUtil.lockedCds(periodId,
			// employeeId);
		}
	}

	private void handleRenderTab1Page2(RenderRequest request,
			RenderResponse response, Map<String, Object> bean, int rootId,
			int userId, int userRole) throws Exception {

		int selectedPeriodId = ParamUtil.getInteger(request,
				RequestConst.PERIOD_ID);
		CdsEvaluationPeriods period = CdsEvaluationPeriodsLocalServiceUtil
				.getCdsEvaluationPeriods(selectedPeriodId);
		bean.put("period", period); // qua ben kia lay ngay gio

		int employeeId = ParamUtil
				.getInteger(request, RequestConst.EMPLOYEE_ID);
		bean.put("employeeId", employeeId);

		StringBuffer employeeName = new StringBuffer();
		employeeName.append(UserLocalServiceUtil.getUser(employeeId)
				.getFirstname());
		employeeName.append(" ");
		String middleName = UserLocalServiceUtil.getUser(employeeId)
				.getMiddlename();
		if (!middleName.isEmpty()) {
			employeeName.append(middleName);
			employeeName.append(" ");
		}
		employeeName.append(UserLocalServiceUtil.getUser(employeeId)
				.getLastname());
		bean.put("employeeName", employeeName.toString());

		int projectId = ParamUtil.getInteger(request, RequestConst.PROJECT_ID);
		bean.put("projectId", projectId);
		// System.out.println("ProjectIdPage2="+ projectId);////////////////////
		Organization project = OrganizationLocalServiceUtil
				.getOrganization(projectId);
		bean.put("projectName", project.getName());
		// System.out.println("projectName="+
		// project.getName());////////////////////
		ProgateOrganizationsStaffs orgStaff = ProgateOrganizationsStaffsLocalServiceUtil
				.getStaffDetails(projectId, employeeId);
		if (orgStaff.getPosition().equals("")) {
			bean.put("position", "N/A");
		} else {
			bean.put("position", orgStaff.getPosition());
		}

		String titleName = ViewFinalTitlesLocalServiceUtil
				.getTitleNameByRootIdAndUserId(rootId, employeeId);
		if (titleName.equals("")) {
			bean.put("titleName", "N/A");
		} else {
			bean.put("titleName", titleName);
		}

		CdsPerformanceAppraisals PA = CdsPerformanceAppraisalsLocalServiceUtil
				.getCdsPerformanceAppraisals(employeeId, selectedPeriodId);
		bean.put("paStatus", PA); // Status of the performance appraisal
		// System.out.println("lock="+PA.getIsLocked());

		boolean disableApproval = ParamUtil.getBoolean(request,
				RequestConst.DISABLE_APPROVAL, false);
		bean.put("disableApproval", disableApproval);
		System.out.println("disableApproval=" + disableApproval);// ////////////////
		int numerator = CdsPASlotsLocalServiceUtil.countSlotEvaluateByUser(
				employeeId, selectedPeriodId, 1);
		int denominator = CdsPASlotsLocalServiceUtil.countSlotPreEvaluate(
				employeeId, selectedPeriodId);
		long rateOfProgress = Math
				.round((double) numerator * 100 / denominator);
		bean.put("rateOfProgress", rateOfProgress);

		String region = ParamUtil.getString(request,
				RequestConst.TAB_PAGE_REGION,
				RequestConst.TAB_APPROVAL_1_PAGE_2_REGION_1);
		int projectIdForReturnButton = ParamUtil.get(request,
				"projectIdForReturnButton", 0);
		bean.put("projectIdForReturnButton", projectIdForReturnButton);
		// System.out.println("projectIdForReturnButton="+projectIdForReturnButton);
		if (region.equals(RequestConst.TAB_APPROVAL_1_PAGE_2_REGION_1)) {
			List<ViewPerformanceAppraisalSlots> slotList = ViewEmployeesSlotsRatingLocalServiceUtil
					.getEmployeesSlotsRating(selectedPeriodId, employeeId);
			bean.put("slotList", slotList);
		}

		if (region.equals(RequestConst.TAB_APPROVAL_1_PAGE_2_REGION_2)) {
			int slotId = ParamUtil.getInteger(request, RequestConst.SLOT_ID);
			ViewPerformanceAppraisalSlots slot = ViewPerformanceAppraisalSlotsLocalServiceUtil
					.getPASlotDetail(employeeId, selectedPeriodId, slotId);
			bean.put("slot", slot);
			// System.out.println("slot-point-value:"+slot.getPointValue());
			// System.out.println("slot-point-ratingStatusPm:"+slot.getRatingStatusPm());
			// slot.getPointValue() && slot.getRatingStatusPm()
			int lastRatingPoint = 0; // truong hop so 0 co van de
			if (userRole == RequestConst.ROLE_PM) {
				lastRatingPoint = CdsPerformanceAppraisalSlotRatingLocalServiceUtil
						.getLastRatingPointByUserType(selectedPeriodId,
								employeeId, slotId, 0); // 1-Employee
			}
			if (userRole == RequestConst.ROLE_BOD) {
				if (slot.getRatingStatusPm() > 0) {
					lastRatingPoint = CdsPerformanceAppraisalSlotRatingLocalServiceUtil
							.getLastRatingPointByUserType(selectedPeriodId,
									employeeId, slotId, 1); // 2-PM
				} else {
					lastRatingPoint = CdsPerformanceAppraisalSlotRatingLocalServiceUtil
							.getLastRatingPointByUserType(selectedPeriodId,
									employeeId, slotId, 0); // 1-Employee
				}
			}
			bean.put("lastRatingPoint", lastRatingPoint);

			if (userRole == RequestConst.ROLE_PM
					&& slot.getRatingStatusBod() != 0) { // Neu pm vao ma bod da
															// phe duyet thi
															// disable
															// ratingPoint
				bean.put("disableRatingPoint", true);
				System.out.println("disableRatingPoint=true");
			} else {
				bean.put("disableRatingPoint", false);
				System.out.println("disableRatingPoint=false");
			}

			List<CdsPoints> points = CdsPointsLocalServiceUtil
					.getCdsPointListByRootId(rootId);
			bean.put("points", points);

			List<CdsPerformanceAppraisalSlotRating> slotRatingHistoryList = CdsPerformanceAppraisalSlotRatingLocalServiceUtil
					.getSlotRatingHistory(rootId, employeeId, slotId);
			bean.put("slotRatingHistoryList", slotRatingHistoryList);
			bean.put("sizeOfSlotRatingHistoryList",
					slotRatingHistoryList.size());

			// ratingStatus: 0-chua phe duyet, 1-dong y, 2-khong dong y
			if (userRole == RequestConst.ROLE_PM) {
				if (slot.getRatingStatusPm() == 0) {
					bean.put("theLastRatingStatus", "n/a");
				} else {
					if (slot.getRatingStatusPm() == 1) {
						bean.put("theLastRatingStatus", "agree");
					} else {
						bean.put("theLastRatingStatus", "disagree");
					}
				}
			}

			if (userRole == RequestConst.ROLE_BOD) {
				if (slot.getRatingStatusBod() == 0) {
					bean.put("theLastRatingStatus", "n/a");
				} else {
					if (slot.getRatingStatusBod() == 1) {
						bean.put("theLastRatingStatus", "agree");
					} else {
						bean.put("theLastRatingStatus", "disagree");
					}
				}
			}

		}

		bean.put("region", region);
		bean.put("TAB_APPROVAL_1_PAGE_2_REGION_1",
				RequestConst.TAB_APPROVAL_1_PAGE_2_REGION_1);
		bean.put("TAB_APPROVAL_1_PAGE_2_REGION_2",
				RequestConst.TAB_APPROVAL_1_PAGE_2_REGION_2);
	}

	private void handleRenderTab2(RenderRequest request,
			RenderResponse response, Map<String, Object> bean, int rootId,
			int userId, int userRole) throws Exception {

		List<CdsEvaluationPeriods> periods = CdsEvaluationPeriodsLocalServiceUtil
				.loadCdsPeriods(2, rootId);
		if (periods.size() == 0) {
			bean.put("errorHaveNotAnyOpenPeriod", true);
			bean.put("errorHaveNotAnyOpenPeriodMessage",
					"Không có đợt CDS nào đang mở.");
		} else {
			int selectedPeriodId = ParamUtil.getInteger(request,
					RequestConst.PERIOD_ID);

			if (selectedPeriodId == 0) {
				selectedPeriodId = periods.get(0).getCdsEvaluationPeriodsId();
			}
			bean.put("periods", periods);
			bean.put("selectedPeriodId", selectedPeriodId);

			List<Organization> orgs = new ArrayList<Organization>();

			if (userRole == RequestConst.ROLE_BOD) {
				orgs = OrganizationLocalServiceUtil.getProjectOfBOD(rootId);
			}

			// System.out.println("orgs = " + orgs); /////////////////////////
			bean.put("orgs", orgs);

			int selectedProjectId = ParamUtil.getInteger(request,
					RequestConst.PROJECT_ID);
			/*
			 * if (selectedProjectId == 0) { selectedProjectId =
			 * orgs.get(0).getPrimaryKey(); }
			 */
			bean.put("selectedProjectId", selectedProjectId);

			int selectedCdsStatus = ParamUtil.getInteger(request,
					RequestConst.CDS_STATUS, 3);
			bean.put("selectedCdsStatus", selectedCdsStatus);

			List<ViewEmployeesInProjects> employees = ViewEmployeesInProjectsLocalServiceUtil
					.getAllEmplApprovalBOD(selectedPeriodId, selectedProjectId,
							selectedCdsStatus, rootId);

			/*
			 * //Xu li loai bo nhung nhan vien chua danh gia slot nao
			 * List<ViewEmployeesInProjects> employees = new
			 * ArrayList<ViewEmployeesInProjects>(); for
			 * (ViewEmployeesInProjects e : fullEmployees) { if
			 * (e.getRatingStatus() != 0){ employees.add(e); } }
			 */

			PaginationObject pagination = new PaginationObject("employees",
					employees.size());
			pagination.paging(request);

			employees = employees.subList(pagination.getStartIndex(),
					pagination.getEndIndex());

			bean.put("pagination", pagination);
			bean.put("employees", employees);
			bean.put("sizeOfEmployees", employees.size());
			/*
			 * System.out.println("selectedPeriodId = " + selectedPeriodId);
			 * System.out.println("selectedProjectId = " + selectedProjectId);
			 * System.out.println("selectedCdsStatus = " + selectedCdsStatus);
			 * System.out.println("userId = " + userId);
			 * System.out.println("rootId = " + rootId);
			 * System.out.println("employees = " + employees);
			 */
			// employees.get(0).getOrgList()
		}
	}

	private void handleRenderTab3(RenderRequest request,
			RenderResponse response, Map<String, Object> bean, int rootId,
			int userId, int userRole) throws Exception {
		
	}
	private void handleActionTab1(ActionRequest request,
			ActionResponse response, Map<String, Object> bean, int rootId,
			int userId, int userRole, PrintWriter output) throws Exception {

		String handle = ParamUtil.getString(request, RequestConst.HANDLE);

		int periodId = ParamUtil.getInteger(request, RequestConst.PERIOD_ID);
		int slotId = ParamUtil.getInteger(request, RequestConst.SLOT_ID);
		int employeeId = ParamUtil
				.getInteger(request, RequestConst.EMPLOYEE_ID);

		if (handle.equals(RequestConst.HANDLE_SAVE_POINT_RATING)) { // Cap nhat
																	// diem cho
																	// mot nhan
																	// vien
																	// (pva)
			try {
				String pointName = ParamUtil.getString(request,
						RequestConst.POINT_NAME);
				int pointValue = ParamUtil.getInteger(request,
						RequestConst.POINT_VALUE);
				String ratingStatus = ParamUtil.getString(request,
						RequestConst.RATING_STATUS);
				boolean ratingStatusBoolean = ratingStatus.equals("agree") ? true
						: false;
				// boolean ratingStatus =
				// ParamUtil.getBoolean(request,"ratingStatus");

				// pm phe duyet
				// ViewOrgUsersPermissionsLocalServiceUtil.checkPermissions(0,
				// 0, rootId, rootId, userId, isRoot, perId)
				
				//Kiem tra: neu ratingStatus == agree thi lay' lay diem phe duyet tu database
				//Muc dich: sua loi nhan vien danh gia trong luc pm nhan nut phe duyet
				if (ratingStatusBoolean == true){
					int lastRatingPoint = 0; // truong hop so 0 co van de
					ViewPerformanceAppraisalSlots slot = ViewPerformanceAppraisalSlotsLocalServiceUtil
					.getPASlotDetail(employeeId, periodId, slotId);
					
					if (userRole == RequestConst.ROLE_PM) {
						lastRatingPoint = CdsPerformanceAppraisalSlotRatingLocalServiceUtil
								.getLastRatingPointByUserType(periodId,
										employeeId, slotId, 0); // 1-Employee
					}
					if (userRole == RequestConst.ROLE_BOD) {
						if (slot.getRatingStatusPm() > 0) {
							lastRatingPoint = CdsPerformanceAppraisalSlotRatingLocalServiceUtil
									.getLastRatingPointByUserType(periodId,
											employeeId, slotId, 1); // 2-PM
						} else {
							lastRatingPoint = CdsPerformanceAppraisalSlotRatingLocalServiceUtil
									.getLastRatingPointByUserType(periodId,
											employeeId, slotId, 0); // 1-Employee
						}
					}
					pointValue = lastRatingPoint;
					
					List<CdsPoints> points = CdsPointsLocalServiceUtil
					.getCdsPointListByRootId(rootId);
					
					for (CdsPoints point : points) {
						if (point.getPointValue() == pointValue){
							pointName = point.getPointName();
							break;
						}
					}
				}				
				
				// Phe duyet 
				if (userRole == RequestConst.ROLE_PM) {
					CdsPerformanceAppraisalSlotRatingLocalServiceUtil
							.addPASlotRating(rootId, periodId, employeeId,
									slotId, userId, ratingStatusBoolean, 1,
									pointName, pointValue);
				} else if (userRole == RequestConst.ROLE_BOD) {
					CdsPerformanceAppraisalSlotRatingLocalServiceUtil
							.addPASlotRating(rootId, periodId, employeeId,
									slotId, userId, ratingStatusBoolean, 2,
									pointName, pointValue);
				}

				output.print("Bạn đã đánh giá thành công cho slot");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (handle.equals(RequestConst.HANDLE_SAVE_COMMENT)) {
			try {
				// int commentBy = ParamUtil.getInteger(request, "commentBy");
				// //Id cua nguoi danh gia/phe duyet (pva)
				String commentText = ParamUtil.getString(request,
						RequestConst.COMMENT_TEXT);
				CdsPerformanceAppraisalSlotCommentsLocalServiceUtil.addComment(
						rootId, employeeId, periodId, slotId, userId,
						commentText);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (handle.equals(RequestConst.HANDLE_GET_COMMENT_LIST)) {
			try {
				List<CdsPerformanceAppraisalSlotComments> commentList = CdsPerformanceAppraisalSlotCommentsLocalServiceUtil
						.getSlotComments(employeeId, periodId, slotId);
				StringBuffer xml = new StringBuffer();
				xml.append("<?xml version=\"1.0\"?>\n");
				xml.append("<commentList>\n");
				for (CdsPerformanceAppraisalSlotComments comment : commentList) {

					int commentBy = comment.getCommentBy();

					StringBuffer authorStringBuffer = new StringBuffer();
					authorStringBuffer.append(UserLocalServiceUtil.getUser(
							commentBy).getFirstname());
					authorStringBuffer.append(" ");
					String middleName = UserLocalServiceUtil.getUser(commentBy)
							.getMiddlename();
					if (!middleName.isEmpty()) {
						authorStringBuffer.append(middleName);
						authorStringBuffer.append(" ");
					}
					authorStringBuffer.append(UserLocalServiceUtil.getUser(
							commentBy).getLastname());
					String author = authorStringBuffer.toString();

					String content = StringEscapeUtils.escapeHtml(comment
							.getCommentContent());

					Date commentAt = comment.getCommentAt();
					Format formatterForDate = new SimpleDateFormat("dd/MM/yyyy");
					Format formatterForHour = new SimpleDateFormat("HH:mm");
					String date = formatterForDate.format(commentAt);
					String hour = formatterForHour.format(commentAt);

					xml.append("<comment>\n");

					xml.append("<author>");
					xml.append(author);
					xml.append("</author>\n");

					xml.append("<content>");
					xml.append(content);
					xml.append("</content>\n");

					xml.append("<date>");
					xml.append(date);
					xml.append("</date>\n");

					xml.append("<hour>");
					xml.append(hour);
					xml.append("</hour>\n");

					xml.append("</comment>\n");
				}
				xml.append("</commentList>");

				output.print(xml.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (handle.equals(RequestConst.HANDLE_LOCK_CDS)) {
			System.out.println("periodId = " + periodId);
			System.out.println("employeeId = " + employeeId);
			CdsPerformanceAppraisalsLocalServiceUtil.lockedCds(periodId,
					employeeId); // ko co title ko chay dc
		}
		output.flush();
	}

	private void handleActionTab2(ActionRequest request,
			ActionResponse response, Map<String, Object> bean, int rootId,
			int userId, int userRole, PrintWriter output) throws Exception {
		String handle = ParamUtil.getString(request, RequestConst.HANDLE);
		int periodId = ParamUtil.getInteger(request, RequestConst.PERIOD_ID);
		if (handle.equals(RequestConst.HANDLE_APPROVE_ALL_STAFF)) {
			int[] employeeIdList = ParamUtil.getIntegerValues(request,
					"employeeIdList");

			CdsPerformanceAppraisalSlotRatingLocalServiceUtil
					.addPASlotRatingByBOD(employeeIdList, periodId, userId, 2);
		}
		output.flush();
	}

}
