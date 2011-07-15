package com.larion.progate.cds.action;

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

import com.larion.progate.cds.constant.RequestConst;
import com.larion.progate.cds.utils.PaginationObject;
import com.larion.progate.cds.utils.PermissionAndRole;
import com.larion.progate.common.action.ParameterizableViewAction;

import com.larion.progate.common.constants.Request;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;

public class LevelMappingStatisticalReportAction extends
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
					RequestConst.PERMISSION_LEVEL_MAPPING);
			bean.put("hasPermission", perAndRole.isPermitted());
			if (perAndRole.isPermitted()) {
				int periodId = ParamUtil.getInteger(request,
						RequestConst.PERIOD_ID, 0);
				bean.put("selectedPeriod", periodId);

				List<CdsEvaluationPeriods> evaluationPeriods = CdsEvaluationPeriodsLocalServiceUtil
						.loadCdsPeriods(3, rootId);
				bean.put("evaluationPeriods", evaluationPeriods);
				bean.put("periodSize", evaluationPeriods.size());

				if (evaluationPeriods.size() > 0) {
					String currentTitle = ViewFinalTitlesLocalServiceUtil
							.getTitleNameByRootIdAndUserId(rootId, userId);
					bean.put("currentTitle", currentTitle);
					List<Competency> competencies = CompetencyLocalServiceUtil
							.getCompetencyListByRootId(rootId);
					bean.put("competencies", competencies);
					List<ViewEmployeesInProjects> employeeDetail = ViewEmployeesInProjectsLocalServiceUtil
							.getEmployeeReportDetails(rootId, userId, periodId);
					bean.put("listSize", employeeDetail.size());

					PaginationObject pagination = new PaginationObject(
							"levelMappingReport", employeeDetail.size());
					pagination.paging(request);

					employeeDetail = employeeDetail.subList(
							pagination.getStartIndex(),
							pagination.getEndIndex());

					bean.put("pagination", pagination);
					bean.put("employeeDetail", employeeDetail);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
