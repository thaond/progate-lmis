package com.larion.progate.cds.action;

import java.io.PrintWriter;
import java.text.Format;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringEscapeUtils;

import larion.progate.cds.model.CdsCdp;
import larion.progate.cds.model.CdsCompetencyStatisticalReport;
import larion.progate.cds.model.CdsEvaluationPeriods;
import larion.progate.model.Organization;
import larion.progate.model.ProgateOrganizationsStaffs;
import larion.progate.cds.model.ViewEmployeesInProjects;
import larion.progate.cds.service.CdsCdpLocalServiceUtil;
import larion.progate.cds.service.CdsCompetencyStatisticalReportLocalServiceUtil;
import larion.progate.cds.service.CdsEvaluationPeriodsLocalServiceUtil;
import larion.progate.service.OrganizationLocalServiceUtil;
import larion.progate.service.ProgateOrganizationsStaffsLocalServiceUtil;
import larion.progate.service.UserLocalServiceUtil;
import larion.progate.cds.service.ViewEmployeesInProjectsLocalServiceUtil;
import larion.progate.cds.service.ViewFinalTitlesLocalServiceUtil;

import com.larion.progate.cds.constant.RequestConst;
import com.larion.progate.cds.utils.PaginationObject;
import com.larion.progate.cds.utils.PermissionAndRole;
import com.larion.progate.common.action.ParameterizableViewAction;

import com.larion.progate.common.constants.Request;
import com.liferay.ibm.icu.text.SimpleDateFormat;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;

public class CdpApprovalAction extends ParameterizableViewAction {

	private PermissionAndRole perAndRole = new PermissionAndRole();

	@Override
	public void handleActionRequestInternal(ActionRequest request,
			ActionResponse response, Map<String, Object> bean) throws Exception {

		int rootId = ParamUtil.getInteger(request, Request.ORG_ID);
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

		perAndRole.check(rootId, userId, RequestConst.PERMISSION_CDP_APPROVAL);

		if (perAndRole.isPermitted()) {
			HttpServletResponse res = PortalUtil
					.getHttpServletResponse(response);
			res.setCharacterEncoding("UTF-8");
			PrintWriter output = res.getWriter();

			int periodId = ParamUtil
					.getInteger(request, RequestConst.PERIOD_ID);
			int employeeId = ParamUtil.getInteger(request,
					RequestConst.EMPLOYEE_ID);

			String handle = ParamUtil.getString(request, RequestConst.HANDLE);
			if (handle.equals(RequestConst.HANDLE_SAVE_COMMENT)) {
				try {
					// int commentBy = ParamUtil.getInteger(request,
					// "commentBy");
					// //Id cua nguoi danh gia/phe duyet (pva)
					String commentText = ParamUtil.getString(request,
							RequestConst.COMMENT_TEXT);
					/*
					 * CdsPerformanceAppraisalSlotCommentsLocalServiceUtil.
					 * addComment( rootId, userId, periodId, slotId, userId,
					 * commentText);
					 */
					CdsCdpLocalServiceUtil.addCdp(rootId, periodId, employeeId,
							userId, commentText);
					output.println("Da them thanh cong 1 comment");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (handle.equals(RequestConst.HANDLE_GET_COMMENT_LIST)) {
				try {
					List<CdsCdp> commentList = CdsCdpLocalServiceUtil.getCdp(
							rootId, employeeId, periodId);
					StringBuffer xml = new StringBuffer();
					xml.append("<?xml version=\"1.0\"?>\n");
					xml.append("<commentList>\n");
					for (CdsCdp comment : commentList) {

						int commentBy = comment.getWrittenBy();

						StringBuffer authorStringBuffer = new StringBuffer();
						authorStringBuffer.append(UserLocalServiceUtil.getUser(
								commentBy).getFirstname());
						authorStringBuffer.append(" ");
						String middleName = UserLocalServiceUtil.getUser(
								commentBy).getMiddlename();
						if (!middleName.isEmpty()) {
							authorStringBuffer.append(middleName);
							authorStringBuffer.append(" ");
						}
						authorStringBuffer.append(UserLocalServiceUtil.getUser(
								commentBy).getLastname());
						String author = authorStringBuffer.toString();

						String content = StringEscapeUtils.escapeHtml(comment
								.getWrittenContent());

						Date commentAt = comment.getWrittenAt();
						Format formatterForDate = new SimpleDateFormat(
								"dd/MM/yyyy");
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
			output.flush();
		}
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

			bean.put("orgId", rootId);

			ServiceContext sc = ServiceContextFactory.getInstance(this
					.getClass().getName(), request);
			int userId = (int) sc.getUserId();
			bean.put("userId", userId);

			perAndRole.check(rootId, userId,
					RequestConst.PERMISSION_CDP_APPROVAL);
			bean.put("hasPermission", perAndRole.isPermitted());
			int userRole = perAndRole.getUserRole();

			String page = ParamUtil.getString(request, RequestConst.TAB_PAGE,
					RequestConst.CDP_APPROVAL_PAGE_1);
			bean.put("page", page);
			bean.put("CDP_APPROVAL_PAGE_1", RequestConst.CDP_APPROVAL_PAGE_1);
			bean.put("CDP_APPROVAL_PAGE_2", RequestConst.CDP_APPROVAL_PAGE_2);
			List<CdsEvaluationPeriods> periods = CdsEvaluationPeriodsLocalServiceUtil
					.loadCdsPeriods(3, rootId);
			if (periods.size() == 0) {
				bean.put("errorHaveNotAnyClosePeriod", true);
				// bean.put("errorPeriodIsNotCloseMessage",
				// "Không có đợt CDS nào đang đóng.");
			} else {
				int selectedPeriodId = ParamUtil.getInteger(request,
						RequestConst.PERIOD_ID);

				if (selectedPeriodId != 0) {
					CdsEvaluationPeriods periodTemp = CdsEvaluationPeriodsLocalServiceUtil
							.getCdsEvaluationPeriods(selectedPeriodId);
					if (periodTemp.getStatus() != 3) {
						selectedPeriodId = 0;
					}
				}

				if (selectedPeriodId == 0) {
					selectedPeriodId = periods.get(0)
							.getCdsEvaluationPeriodsId();
				}

				if (page.equals(RequestConst.CDP_APPROVAL_PAGE_1)) {
					bean.put("periods", periods);
					bean.put("selectedPeriodId", selectedPeriodId);

					List<Organization> orgs = new ArrayList<Organization>();

					if (userRole == RequestConst.ROLE_PM) {
						orgs = OrganizationLocalServiceUtil.getProjectOfPM(
								rootId, userId);
					}

					if (userRole == RequestConst.ROLE_BOD) {
						orgs = OrganizationLocalServiceUtil
								.getProjectOfBOD(rootId);
					}

					bean.put("orgs", orgs);

					int selectedProjectId = ParamUtil.getInteger(request,
							RequestConst.PROJECT_ID);
					bean.put("selectedProjectId", selectedProjectId);

					List<ViewEmployeesInProjects> fullEmployees = new ArrayList<ViewEmployeesInProjects>();
					if (userRole == RequestConst.ROLE_PM) {
						fullEmployees = ViewEmployeesInProjectsLocalServiceUtil
								.getEmployeesCdp(selectedPeriodId,
										selectedProjectId, userId);
					}
					if (userRole == RequestConst.ROLE_BOD) {
						fullEmployees = ViewEmployeesInProjectsLocalServiceUtil
								.getEmployeesCdpBOD(selectedPeriodId,
										selectedProjectId, rootId);
					}

					// Cho nay can phai loc ra danh sach nhung nhan vien da co'
					// comment
					List<ViewEmployeesInProjects> employees = new ArrayList<ViewEmployeesInProjects>();
					for (ViewEmployeesInProjects e : fullEmployees) {
						if (CdsCdpLocalServiceUtil.checkCdp(rootId,
								e.getUserId(), selectedPeriodId)) {
							employees.add(e);
						}
					}
					bean.put("sizeOfEmployees", employees.size());

					PaginationObject pagination = new PaginationObject(
							"employees", employees.size());
					pagination.paging(request);

					employees = employees.subList(pagination.getStartIndex(),
							pagination.getEndIndex());

					bean.put("pagination", pagination);
					bean.put("employees", employees);
				}

				if (page.equals(RequestConst.CDP_APPROVAL_PAGE_2)) {
					CdsEvaluationPeriods period = CdsEvaluationPeriodsLocalServiceUtil
							.getCdsEvaluationPeriods(selectedPeriodId);
					bean.put("period", period); // qua ben kia lay ngay gio

					int employeeId = ParamUtil.getInteger(request,
							RequestConst.EMPLOYEE_ID);
					bean.put("employeeId", employeeId);

					int projectIdForReturnButton = ParamUtil.get(request,
							"projectIdForReturnButton", 0);
					bean.put("projectIdForReturnButton",
							projectIdForReturnButton);

					String currentTitle = ViewFinalTitlesLocalServiceUtil
							.getTitleNameByRootIdAndUserId(rootId, employeeId);
					if (currentTitle.equals("")) {
						currentTitle = "N/A";
					}
					bean.put("currentTitle", currentTitle);

					List<ProgateOrganizationsStaffs> employeeInformations = ProgateOrganizationsStaffsLocalServiceUtil
							.getEmployeeInformations(rootId, employeeId);
					ProgateOrganizationsStaffs e;
					StringBuffer currentPositionList = new StringBuffer();
					StringBuffer currentProjectNameList = new StringBuffer();
					Iterator<ProgateOrganizationsStaffs> eInfoIterator = employeeInformations
							.iterator();

					if (employeeInformations.size() > 0) {
						e = eInfoIterator.next();
						int projectId = e.getOrgId();
						currentProjectNameList
								.append(OrganizationLocalServiceUtil
										.getOrganization(projectId).getName());
						currentPositionList.append(e.getPosition());

						while (eInfoIterator.hasNext()) {
							e = eInfoIterator.next();
							projectId = e.getOrgId();

							currentProjectNameList.append(", ");
							currentPositionList.append(", ");

							currentProjectNameList
									.append(OrganizationLocalServiceUtil
											.getOrganization(projectId)
											.getName());
							currentPositionList.append(e.getPosition());
						}

						bean.put("currentPositionList",
								currentPositionList.toString());
						bean.put("currentProjectNameList",
								currentProjectNameList.toString());
					} else {
						bean.put("currentPositionList", "N/A");
						bean.put("currentProjectNameList", "N/A");
					}

					List<ViewEmployeesInProjects> userDetails = ViewEmployeesInProjectsLocalServiceUtil
							.getEmployeeDetailsCDP(rootId, employeeId,
									selectedPeriodId);
					Iterator<ViewEmployeesInProjects> userDetailIterator = userDetails
							.iterator();

					ViewEmployeesInProjects v;
					StringBuffer positionList = new StringBuffer();
					String projectNameList = "";

					if (userDetails.size() > 0) {
						v = userDetailIterator.next();
						projectNameList = v.getOrgList();
						positionList.append(v.getPosition());

						while (userDetailIterator.hasNext()) {
							v = userDetailIterator.next();
							positionList.append(", ");
							positionList.append(v.getPosition());
						}

						/*
						 * projectNameList = userDetail.get(0).getOrgList();
						 * positionList.append(userDetail.get(0).getPosition());
						 */
					}

					bean.put("projectNameList", projectNameList);
					bean.put("positionList", positionList.toString());

					/*
					 * String titleName =
					 * ViewFinalTitlesLocalServiceUtil.getTitleNameByRootIdAndUserId
					 * (rootId, employeeId); bean.put("titleName", titleName);
					 */
					if (userDetails.size() == 0) {
						bean.put("titleName", "");
					} else {
						bean.put("titleName", userDetails.get(0).getTitleName());
					}

					List<CdsCompetencyStatisticalReport> competencies = CdsCompetencyStatisticalReportLocalServiceUtil
							.getCdsCompetencyStatisticalReportList(rootId,
									employeeId, selectedPeriodId);
					bean.put("competencies", competencies);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
