package com.larion.progate.cds.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import larion.progate.cds.model.CdsEvaluationPeriods;
import larion.progate.cds.model.Competency;
import larion.progate.cds.model.ViewEmployeesInProjects;
import larion.progate.cds.service.CdsEvaluationPeriodsLocalServiceUtil;
import larion.progate.cds.service.CompetencyLocalServiceUtil;
import larion.progate.cds.service.ViewEmployeesInProjectsLocalServiceUtil;
import larion.progate.cds.service.ViewFinalTitlesLocalServiceUtil;
import larion.progate.model.Organization;
import larion.progate.model.ProgateOrganizationsStaffs;
import larion.progate.service.OrganizationLocalServiceUtil;
import larion.progate.service.ProgateOrganizationsStaffsLocalServiceUtil;

import com.larion.progate.cds.constant.RequestConst;
import com.larion.progate.cds.utils.PaginationObject;
import com.larion.progate.cds.utils.PermissionAndRole;
import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.constants.Request;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;

public class EmployeeStateStatisticalReportAction extends
		ParameterizableViewAction {
	private PermissionAndRole perAndRole = new PermissionAndRole();

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
					RequestConst.PERMISSION_EMPLOYEE_STATE);
			bean.put("hasPermission", perAndRole.isPermitted());
			if (perAndRole.isPermitted()) {
				int page = ParamUtil.getInteger(request, RequestConst.TAB_PAGE,
						1);
				if (page == 1) {
					handleRenderPage1(request, response, bean, rootId, userId);
				}
				if (page == 2) {
					handleRenderPage2(request, response, bean, rootId, userId);
				}
				bean.put("page", page);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void handleRenderPage1(RenderRequest request,
			RenderResponse response, Map<String, Object> bean, int rootId,
			int userId) throws Exception {

		int periodId = ParamUtil.getInteger(request, RequestConst.PERIOD_ID, 0);
		List<CdsEvaluationPeriods> evaluationPeriods = CdsEvaluationPeriodsLocalServiceUtil
				.loadCdsPeriods(3, rootId);
		bean.put("evaluationPeriods", evaluationPeriods);
		bean.put("periodSize", evaluationPeriods.size());
		if (evaluationPeriods.size() > 0) {
			if (periodId == 0) {
				periodId = evaluationPeriods.get(0).getCdsEvaluationPeriodsId();
			}
			bean.put("selectedPeriod", periodId);

			int projectId = ParamUtil.getInteger(request,
					RequestConst.PROJECT_ID, 0);
			bean.put("selectedProject", projectId);

			List<Competency> competencies = CompetencyLocalServiceUtil
					.getCompetencyListByRootId(rootId);
			bean.put("competencies", competencies);

			List<ViewEmployeesInProjects> employees = new ArrayList<ViewEmployeesInProjects>();
			if (perAndRole.getUserRole() == RequestConst.ROLE_PM) {
				employees = ViewEmployeesInProjectsLocalServiceUtil
						.getEmployeeStateReport(1, rootId, projectId, userId,
								periodId);
				List<Organization> projects = OrganizationLocalServiceUtil
						.getProjectOfPM(rootId, userId);
				bean.put("projects", projects);
			} else if (perAndRole.getUserRole() == RequestConst.ROLE_BOD) {
				employees = ViewEmployeesInProjectsLocalServiceUtil
						.getEmployeeStateReport(2, rootId, projectId, userId,
								periodId);
				List<Organization> projects = OrganizationLocalServiceUtil
						.getProjectOfBOD(rootId);
				bean.put("projects", projects);
			}
			bean.put("listSize", employees.size());

			PaginationObject pagination = new PaginationObject(
					"employeeStateReport", employees.size());
			pagination.paging(request);

			employees = employees.subList(pagination.getStartIndex(),
					pagination.getEndIndex());

			bean.put("pagination", pagination);
			bean.put("employees", employees);
		}

	}

	private void handleRenderPage2(RenderRequest request,
			RenderResponse response, Map<String, Object> bean, int rootId,
			int userId) throws Exception {
		int employeeId = ParamUtil
				.getInteger(request, RequestConst.EMPLOYEE_ID);
		String employeeName = ParamUtil.getString(request,
				RequestConst.EMPLOYEE_NAME);
		String employeeTitle = ViewFinalTitlesLocalServiceUtil
				.getTitleNameByRootIdAndUserId(rootId, employeeId);

		String employeePosition = "";
		String employeeProject = "";
		List<ProgateOrganizationsStaffs> currentInfo = ProgateOrganizationsStaffsLocalServiceUtil
				.getEmployeeInformations(rootId, employeeId);
		if (currentInfo == null) {
			currentInfo = new ArrayList<ProgateOrganizationsStaffs>();
		}
		if (currentInfo.size() > 0) {
			employeePosition += currentInfo.get(0).getPosition();
			int orgId = currentInfo.get(0).getOrgId();
			employeeProject += OrganizationLocalServiceUtil.getOrganization(
					orgId).getName();
		}
		for (int i = 1; i < currentInfo.size(); i++) {
			employeePosition = employeePosition + ", "
					+ currentInfo.get(i).getPosition();
			int orgId = currentInfo.get(i).getOrgId();
			employeeProject = employeeProject
					+ ", "
					+ OrganizationLocalServiceUtil.getOrganization(orgId)
							.getName();
		}

		bean.put("employeeName", employeeName);
		bean.put("employeeTitle", employeeTitle);
		bean.put("employeePosition", employeePosition);
		bean.put("employeeProject", employeeProject);

		List<Competency> competencies = CompetencyLocalServiceUtil
				.getCompetencyListByRootId(rootId);
		bean.put("competencies", competencies);
		List<ViewEmployeesInProjects> employeeDetail = ViewEmployeesInProjectsLocalServiceUtil
				.getEmployeeReportDetails(rootId, employeeId, 0);
		bean.put("listSize", employeeDetail.size());

		PaginationObject pagination = new PaginationObject(
				"employeeStateDetailReport", employeeDetail.size());
		pagination.paging(request);

		employeeDetail = employeeDetail.subList(pagination.getStartIndex(),
				pagination.getEndIndex());

		bean.put("pagination", pagination);
		bean.put("employeeDetail", employeeDetail);

	}
}
