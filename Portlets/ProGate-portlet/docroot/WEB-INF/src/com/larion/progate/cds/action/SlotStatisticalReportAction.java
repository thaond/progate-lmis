package com.larion.progate.cds.action;

import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import larion.progate.cds.model.CdsCompetencyStatisticalReport;
import larion.progate.cds.model.CdsEvaluationPeriods;
import larion.progate.cds.model.CdsPerformanceAppraisals;
import larion.progate.cds.model.CdsTitles;
import larion.progate.cds.service.CdsCompetencyStatisticalReportLocalServiceUtil;
import larion.progate.cds.service.CdsEvaluationPeriodsLocalServiceUtil;
import larion.progate.cds.service.CdsPerformanceAppraisalsLocalServiceUtil;
import larion.progate.cds.service.CdsTitlesLocalServiceUtil;
import larion.progate.cds.service.ViewFinalTitlesLocalServiceUtil;

import com.larion.progate.cds.constant.RequestConst;
import com.larion.progate.cds.utils.PermissionAndRole;
import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.constants.Request;
import com.larion.progate.common.utils.ProGateUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;

public class SlotStatisticalReportAction extends ParameterizableViewAction {

	private PermissionAndRole perAndRoleSlotReport = new PermissionAndRole();

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

			perAndRoleSlotReport.check(rootId, userId,
					RequestConst.PERMISSION_SLOT_REPORT);
			bean.put("hasPermissionSlotReport",
					perAndRoleSlotReport.isPermitted());

			if (perAndRoleSlotReport.isPermitted()) {
				try {
					String currentTitle = ViewFinalTitlesLocalServiceUtil
							.getTitleNameByRootIdAndUserId(rootId, userId);
					bean.put("currentTitle", currentTitle);

					int periodId = ParamUtil.getInteger(request,
							RequestConst.PERIOD_ID, 0);
					List<CdsEvaluationPeriods> evaluationPeriods = CdsEvaluationPeriodsLocalServiceUtil
							.loadCdsPeriods(3, rootId);
					bean.put("evaluationPeriods", evaluationPeriods);
					if (evaluationPeriods.size() == 0) {
						boolean hasClosedEvaluationPeriods = false;
						bean.put("hasClosedEvaluationPeriods",
								hasClosedEvaluationPeriods);
					}
					if (periodId == 0 && evaluationPeriods.size() != 0) {
						periodId = evaluationPeriods.get(0)
								.getCdsEvaluationPeriodsId();
					}
					bean.put("selectedPeriod", periodId);
					if (periodId != 0) {
						CdsPerformanceAppraisals cpa = CdsPerformanceAppraisalsLocalServiceUtil
								.getCdsPerformanceAppraisals(userId, periodId);
						if (cpa != null) {
							int cpaId = cpa.getTitleId();
							if (cpaId != 0) {
								CdsTitles pt = CdsTitlesLocalServiceUtil
										.getCdsTitles(cpaId);
								String periodTitle = pt.getName();
								bean.put("periodTitle", periodTitle);
							}
							if (cpaId == 0) {
								bean.put("periodTitle", "N/A");
							}
						}
						if (cpa == null) {
							bean.put("periodTitle", "N/A");
						}
					}

					List<CdsCompetencyStatisticalReport> listCompetency = CdsCompetencyStatisticalReportLocalServiceUtil
							.getCdsCompetencyStatisticalReportList(rootId,
									userId, periodId);
					bean.put("listCompetency", listCompetency);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
