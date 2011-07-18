package com.larion.progate.cds.action;

import java.io.PrintWriter;
import java.text.Format;
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

import larion.progate.cds.model.CdsCdp;
import larion.progate.cds.model.CdsCompetencyStatisticalReport;
import larion.progate.cds.model.CdsEvaluationPeriods;
import larion.progate.cds.model.ViewEmployeesInProjects;
import larion.progate.cds.service.CdsCdpLocalServiceUtil;
import larion.progate.cds.service.CdsCompetencyStatisticalReportLocalServiceUtil;
import larion.progate.cds.service.CdsEvaluationPeriodsLocalServiceUtil;
import larion.progate.cds.service.ViewEmployeesInProjectsLocalServiceUtil;
import larion.progate.service.UserLocalServiceUtil;

import org.apache.commons.lang.StringEscapeUtils;

import com.larion.progate.cds.constant.RequestConst;
import com.larion.progate.cds.utils.PermissionAndRole;
import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.constants.Request;
import com.larion.progate.common.utils.ProGateUtil;
import com.liferay.ibm.icu.text.SimpleDateFormat;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;

public class CdpEvaluationAction extends ParameterizableViewAction {

	private PermissionAndRole perAndRole = new PermissionAndRole();

	@Override
	public void handleActionRequestInternal(ActionRequest request,
			ActionResponse response, Map<String, Object> bean) throws Exception {
		// TODO Auto-generated method stub

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

		ServiceContext sc = ServiceContextFactory.getInstance(this.getClass()
				.getName(), request);
		int userId = (int) sc.getUserId();

		perAndRole
				.check(rootId, userId, RequestConst.PERMISSION_CDP_EVALUATION);

		if (perAndRole.isPermitted()) {
			HttpServletResponse res = PortalUtil
					.getHttpServletResponse(response);
			res.setCharacterEncoding("UTF-8");
			PrintWriter output = res.getWriter();

			int periodId = ParamUtil
					.getInteger(request, RequestConst.PERIOD_ID);

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
					CdsCdpLocalServiceUtil.addCdp(rootId, periodId, userId,
							userId, commentText);
					output.println("Da them thanh cong 1 comment");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (handle.equals(RequestConst.HANDLE_GET_COMMENT_LIST)) {
				try {
					List<CdsCdp> commentList = CdsCdpLocalServiceUtil.getCdp(
							rootId, userId, periodId);
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

			perAndRole.check(rootId, userId,
					RequestConst.PERMISSION_CDP_EVALUATION);
			bean.put("hasPermission", perAndRole.isPermitted());

			if (perAndRole.isPermitted()) {
				List<CdsEvaluationPeriods> periods = CdsEvaluationPeriodsLocalServiceUtil
						.loadCdsPeriods(3, rootId);

				if (periods.size() == 0) {
					bean.put("errorHaveNotAnyClosePeriod", true);
					bean.put("errorHaveNotAnyClosePeriodMessage",
							"Không có đợt CDS nào đang đóng.");
				} else {
					bean.put("errorHaveNotAnyClosePeriod", false);
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
					bean.put("periods", periods);
					bean.put("selectedPeriodId", selectedPeriodId);

					CdsEvaluationPeriods period = CdsEvaluationPeriodsLocalServiceUtil
							.getCdsEvaluationPeriods(selectedPeriodId);
					bean.put("period", period); // qua ben kia lay ngay gio

					List<ViewEmployeesInProjects> userDetail = ViewEmployeesInProjectsLocalServiceUtil
							.getEmployeeDetailsCDP(rootId, userId,
									selectedPeriodId);
					Iterator<ViewEmployeesInProjects> userDetailIterator = userDetail
							.iterator();

					ViewEmployeesInProjects v;
					StringBuffer positionList = new StringBuffer();
					String projectNameList = "";

					if (userDetail.size() > 0) {
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

					// String titleName =
					// ViewFinalTitlesLocalServiceUtil.getTitleNameByRootIdAndUserId(rootId,
					// userId);
					// bean.put("titleName", titleName);
					if (userDetail.size() == 0) {
						bean.put("titleName", "");
					} else {
						bean.put("titleName", userDetail.get(0).getTitleName());
					}

					List<CdsCompetencyStatisticalReport> competencies = CdsCompetencyStatisticalReportLocalServiceUtil
							.getCdsCompetencyStatisticalReportList(rootId,
									userId, selectedPeriodId);
					bean.put("competencies", competencies);
					// competencies.get(0).getLevelRankingValue();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
