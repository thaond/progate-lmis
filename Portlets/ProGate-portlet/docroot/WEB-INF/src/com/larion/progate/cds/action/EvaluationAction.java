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

import larion.progate.cds.model.CdsEvaluationPeriods;
import larion.progate.cds.model.CdsPACompetencies;
import larion.progate.cds.model.CdsPASlots;
import larion.progate.cds.model.CdsPerformanceAppraisalSlotComments;
import larion.progate.cds.model.CdsPerformanceAppraisalSlotRating;
import larion.progate.cds.model.CdsPerformanceAppraisals;
import larion.progate.cds.model.CdsPoints;
import larion.progate.cds.model.ViewFinalCompetencies;
import larion.progate.cds.model.ViewFinalSlots;
import larion.progate.cds.model.ViewPerformanceAppraisalSlots;
import larion.progate.cds.model.impl.ViewFinalSlotsImpl;
import larion.progate.cds.service.CdsEvaluationPeriodsLocalServiceUtil;
import larion.progate.cds.service.CdsPACompetenciesLocalServiceUtil;
import larion.progate.cds.service.CdsPASlotsLocalServiceUtil;
import larion.progate.cds.service.CdsPerformanceAppraisalSlotCommentsLocalServiceUtil;
import larion.progate.cds.service.CdsPerformanceAppraisalSlotRatingLocalServiceUtil;
import larion.progate.cds.service.CdsPerformanceAppraisalSlotRatingServiceClp;
import larion.progate.cds.service.CdsPerformanceAppraisalsLocalServiceUtil;
import larion.progate.cds.service.CdsPointsLocalServiceUtil;
import larion.progate.service.UserLocalServiceUtil;
import larion.progate.service.ViewOrgUsersPermissionsLocalServiceUtil;
import larion.progate.cds.service.ViewFinalCompetenciesLocalServiceUtil;
import larion.progate.cds.service.ViewFinalTitlesLocalServiceUtil;
import larion.progate.cds.service.ViewPerformanceAppraisalSlotsLocalServiceUtil;

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

public class EvaluationAction extends ParameterizableViewAction {

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

		perAndRole.check(rootId, userId, RequestConst.PERMISSION_EVALUATION);
		int userRole = perAndRole.getUserRole();
		if (ViewOrgUsersPermissionsLocalServiceUtil.getRoleIdByUserId(RequestConst.APPLICATION_ID, RequestConst.CATEGORY_ID, rootId, 0, userId) == RequestConst.ROLE_BOD){
			bean.put("isBOD", true);
		}
		bean.put("userRole", userRole);
		bean.put("ROLE_PM", RequestConst.ROLE_PM);
		bean.put("ROLE_BOD", RequestConst.ROLE_BOD);
		
		if(perAndRole.isPermitted()){
			HttpServletResponse res = PortalUtil.getHttpServletResponse(response);
			res.setCharacterEncoding("UTF-8");
			PrintWriter output = res.getWriter();

			String tab = ParamUtil.getString(request, RequestConst.TAB);

			if (RequestConst.TAB_EVALUATION_2.equals(tab)) {
				try {
					int periodId = ParamUtil.getInteger(request, "periodId");
					int[] competencies = ParamUtil.getIntegerValues(request,
							"competencies");
					List<Integer> competenciesList = new ArrayList<Integer>();
					for (int competency : competencies) {
						// System.out.println("competency: " + competency);
						competenciesList.add(competency);
					}

					int[] levels = ParamUtil.getIntegerValues(request, "levels");
					List<Integer> levelsList = new ArrayList<Integer>();
					for (int level : levels) {
						// System.out.println("level: " + level);
						levelsList.add(level);
					}

					int[] slots = ParamUtil.getIntegerValues(request, "slots");
					String[] pointNames = request.getParameterValues("pointNames");
					int[] pointValues = ParamUtil.getIntegerValues(request,
							"pointValues");

					List<ViewFinalSlots> finalSlots = new ArrayList<ViewFinalSlots>();
					for (int i = 0; i < slots.length; i++) {
						/*
						 * System.out .println("slot :" + slots[i] + ", pointName: "
						 * + pointNames[i] + ", pointValue: " + pointValues[i]);
						 */
						ViewFinalSlots finalSlot = new ViewFinalSlotsImpl();
						finalSlot.setSlotId(slots[i]);
						finalSlot.setPointName(pointNames[i]);
						finalSlot.setPointValue(pointValues[i]);
						finalSlots.add(finalSlot);
					}
					if (CdsPASlotsLocalServiceUtil.addPASlots(rootId, userId,
							periodId, competenciesList, levelsList, finalSlots)) {
						output.print("ban da them thanh cong 1 DS Slot muon danh gia");
					} else {
						output.print("co loi xay ra khi them 1 DS Slot muon danh gia");
					}
				} catch (Exception e) {
					output.print("co loi xay ra khi thuc hien action");
					System.out.println("co loi xay ra khi thuc hien action");
				}
			}

			if (RequestConst.TAB_EVALUATION_3.equals(tab)) {
				int periodId = ParamUtil
						.getInteger(request, RequestConst.PERIOD_ID);
				int slotId = ParamUtil.getInteger(request, RequestConst.SLOT_ID);
				boolean disablePointRating = ParamUtil.getBoolean(request, "disablePointRating");
				if (disablePointRating == false){
					handleActionTab3Page2(request, response, bean, rootId, userId, userRole, 
							periodId, slotId, output);
				}
			}

			output.flush();
		}
	}

	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {

		String tab = ParamUtil.getString(request, RequestConst.TAB);
		if (tab == null || tab.equals("")) {
			// kiem tra trang thai cds cua user
			tab = RequestConst.TAB_EVALUATION_1;
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

		ServiceContext sc = ServiceContextFactory.getInstance(this.getClass()
				.getName(), request);
		int userId = (int) sc.getUserId();
		bean.put("userId", userId);

		perAndRole.check(rootId, userId, RequestConst.PERMISSION_EVALUATION);
		int userRole = perAndRole.getUserRole();
		System.out.println("rootId:" + rootId);
		System.out.println("userId:" + userId);
		System.out.println("userRole:" + userRole);
		bean.put("userRole", userRole);
		
		//Kiem tra neu BOD ko vao dc man hinh danh gia thi chuyen sang phe duyet
		/*if (ViewOrgUsersPermissionsLocalServiceUtil.getRoleIdByUserId(RequestConst.APPLICATION_ID, RequestConst.CATEGORY_ID, rootId, 0, userId) == RequestConst.ROLE_BOD){
			
			StringBuffer url = new StringBuffer();
			url.append("http://");
			url.append(PortalUtil.getHost(request));
			url.append(":"); 
			url.append(PortalUtil.getPortalPort());
			url.append("/tochuc/ungdung/danhgia/cds/phe-duyet?orgId=");
			url.append(rootId);
			
			bean.put("isBOD", true);
			bean.put("linkToApprovalScreen", url.toString());
		}*/
		
		bean.put("ROLE_PM", RequestConst.ROLE_PM);
		bean.put("ROLE_EMPLOYEE", RequestConst.ROLE_EMPLOYEE);
		bean.put("ROLE_BOD", RequestConst.ROLE_BOD);
		
		if (perAndRole.isPermitted()){
			bean.put("hasPermission", true);
		} else {
			bean.put("hasPermission", false);
		}
		if (perAndRole.isPermitted()){
			// using for tab 1 and 2
			int competencyId = ParamUtil.getInteger(request,
					RequestConst.COMPETENCY_ID, 0);
			// System.out.println("competencyId: " + competencyId);
			bean.put("selectedCompetency", competencyId);
			int slotStatus = ParamUtil.getInteger(request,
					RequestConst.SLOT_STATUS, 0);
			// System.out.println("slotStatus: " + slotStatus);
			bean.put("selectedSlotStatus", slotStatus);
			
			List<ViewFinalCompetencies> competencies = ViewFinalCompetenciesLocalServiceUtil
					.getFinalCompetenciesList(rootId, userId, 0, 0);
			bean.put("competencies", competencies);
			String titleName = ViewFinalTitlesLocalServiceUtil
					.getTitleNameByRootIdAndUserId(rootId, userId);
			bean.put("titleName", titleName);

			if (RequestConst.TAB_EVALUATION_1.equals(tab)) {
				List<ViewFinalCompetencies> finalCompetencies = ViewFinalCompetenciesLocalServiceUtil
						.getFinalCompetenciesList(rootId, userId, competencyId, slotStatus);
				bean.put("finalCompetencies", finalCompetencies);
			}

			if (RequestConst.TAB_EVALUATION_2.equals(tab)) {
				int periodId = ParamUtil.getInteger(request,
						RequestConst.PERIOD_ID, 0);
				List<CdsEvaluationPeriods> evaluationPeriods = CdsEvaluationPeriodsLocalServiceUtil
						.loadCdsPeriods(2, rootId);
				bean.put("evaluationPeriods", evaluationPeriods);
				if(evaluationPeriods.size() == 0) {
					bean.put("hasOpenEvaluationPeriods", false);
					bean.put("selectedPeriod", periodId);
					//no evaluation slots
					bean.put("paSlotsSize", -1);
				} else {
					if (periodId == 0) {
						periodId = evaluationPeriods.get(0).getCdsEvaluationPeriodsId();
					}
					bean.put("selectedPeriod", periodId);
					CdsPerformanceAppraisals pA = CdsPerformanceAppraisalsLocalServiceUtil
							.getCdsPerformanceAppraisals(userId, periodId);
					if (pA == null) {
						bean.put("hasPermissionToEvaluate", false);
					} else {
						bean.put("lockCDS", pA.getIsLocked());
						
						List<ViewFinalCompetencies> aboveFinalCompetencies = ViewFinalCompetenciesLocalServiceUtil
								.getFinalCompetenciesList(rootId, userId, competencyId, slotStatus);
						bean.put("aboveFinalCompetencies", aboveFinalCompetencies);
						
						List<ViewFinalCompetencies> belowFinalCompetencies = ViewFinalCompetenciesLocalServiceUtil
								.getFinalCompetenciesList(rootId, userId, 0, 0);
						bean.put("belowFinalCompetencies", belowFinalCompetencies);

						// get list of slots which user selected to evaluate
						List<CdsPASlots> paSlots = CdsPASlotsLocalServiceUtil
								.getCdsPASlotsList(userId, periodId);
						if (paSlots == null) {
							paSlots = new ArrayList<CdsPASlots>();
						}
						bean.put("paSlotsSize", paSlots.size());
						bean.put("paSlots", paSlots);
					}
				}
			}

			if (RequestConst.TAB_EVALUATION_3.equals(tab)) {

				String currentTitle = ViewFinalTitlesLocalServiceUtil
						.getTitleNameByRootIdAndUserId(rootId, userId);
				if (currentTitle.equals("")) {
					currentTitle = "N/A";
				}
				bean.put("currentTitle", currentTitle);

				int page = ParamUtil.getInteger(request, RequestConst.TAB_PAGE);

				if (page == 0) {
					page = 1;
				}
				if (page == 1) {
					handleRenderTab3Page1(request, response, bean, rootId, userId);
				}
				if (page == 2) {
					handleRenderTab3Page2(request, response, bean, rootId, userId, userRole);
				}
				bean.put("page", page);
			}

			bean.put("activedTab", tab);
			bean.put("TAB_EVALUATION_1", RequestConst.TAB_EVALUATION_1);
			bean.put("TAB_EVALUATION_2", RequestConst.TAB_EVALUATION_2);
			bean.put("TAB_EVALUATION_3", RequestConst.TAB_EVALUATION_3);
		}
	}

	private void handleRenderTab3Page1(RenderRequest request,
			RenderResponse response, Map<String, Object> bean, int rootId,
			int userId) throws Exception {
		List<CdsEvaluationPeriods> periods = CdsEvaluationPeriodsLocalServiceUtil
				.loadCdsPeriods(2, rootId);
		
		if (periods.size() == 0){		
			bean.put("errorHaveNotAnyOpenPeriod", true);
			bean.put("errorHaveNotAnyOpenPeriodMessage", "Hiện tại không có đợt CDS nào tồn tại với trạng thái đang \"Mở\"");
		} else {
			bean.put("errorHaveNotAnyOpenPeriod", false);
			int selectedPeriodId = ParamUtil.getInteger(request,
					RequestConst.PERIOD_ID);
			if (selectedPeriodId == 0) {
				selectedPeriodId = periods.get(0).getCdsEvaluationPeriodsId();
			}
			bean.put("periods", periods);
			bean.put("selectedPeriodId", selectedPeriodId);
			// System.out.println("periodId = " + selectedPeriodId);
			CdsPerformanceAppraisals PA = CdsPerformanceAppraisalsLocalServiceUtil
					.getCdsPerformanceAppraisals(userId, selectedPeriodId);
			// System.out.println("pA = " + PA);
			if (PA != null) {
				bean.put("errorNotInThisPeriod", false);
				bean.put("paStatus", PA); // Status of the performance appraisal

				//Map<Object, Object> competencyLevelSlot = new HashMap<Object, Object>();

				List<CdsPACompetencies> competencies = CdsPACompetenciesLocalServiceUtil
						.getCdsPACompetencies(userId, selectedPeriodId);
				
				if (competencies == null) {
					competencies = new ArrayList<CdsPACompetencies>();
				}
				if (competencies.size() == 0){
					bean.put("warningHaveNotAnySlot", true);
					bean.put("warningHaveNotAnySlotMessage", "Hiện tại không có slot nào trong danh sách đánh giá. Vui lòng nhấn vào đây để thêm slot.");
				} else {
					bean.put("competencies", competencies);
					/*for (CdsPACompetencies competency : competencies) {
						Map<Object, Object> levelSlot = new LinkedHashMap<Object, Object>();
						List<ViewPerformanceAppraisalLevels> levels = ViewPerformanceAppraisalLevelsLocalServiceUtil
								.getCdsPALevels(userId, selectedPeriodId,
										competency.getCompetencyId());
	
						if (levels == null) {
							levels = new ArrayList<ViewPerformanceAppraisalLevels>();
						}
	
						for (ViewPerformanceAppraisalLevels level : levels) {
							List<ViewPerformanceAppraisalSlots> slots = ViewPerformanceAppraisalSlotsLocalServiceUtil
									.getCdsPASlots(userId, selectedPeriodId,
											level.getLevelId());
	
							if (slots == null) {
								slots = new ArrayList<ViewPerformanceAppraisalSlots>();
							}
	
							levelSlot.put(level, slots);
						}
						competencyLevelSlot.put(competency, levelSlot);
						
					}
					bean.put("competencyLevelSlot", competencyLevelSlot);
					*/
				}
			} else {
				bean.put("errorNotInThisPeriod", true);
				bean.put("errorNotInThisPeriodMessage",
						"Bạn hiện không có trong đợt CDS này, hãy chọn đợt CDS khác để đánh giá");
			}
		}

		
	}

	private void handleRenderTab3Page2(RenderRequest request,
			RenderResponse response, Map<String, Object> bean, int rootId,
			int userId, int userRole) throws Exception {
		try {
			int selectedPeriodId = ParamUtil.getInteger(request,
					RequestConst.PERIOD_ID);
			CdsEvaluationPeriods period = CdsEvaluationPeriodsLocalServiceUtil
					.getCdsEvaluationPeriods(selectedPeriodId);
			bean.put("period", period);

			CdsPerformanceAppraisals PA = CdsPerformanceAppraisalsLocalServiceUtil
					.getCdsPerformanceAppraisals(userId, selectedPeriodId);
			bean.put("paStatus", PA); // Status of the performance appraisal
			
			int numerator = CdsPASlotsLocalServiceUtil.countSlotEvaluateByUser(
					userId, selectedPeriodId, 1);
			int denominator = CdsPASlotsLocalServiceUtil.countSlotPreEvaluate(
					userId, selectedPeriodId);
			long rateOfProgress = Math.round((double) numerator * 100 / denominator);
			bean.put("rateOfProgress", rateOfProgress);

			List<CdsPoints> points = CdsPointsLocalServiceUtil
					.getCdsPointListByRootId(rootId);
			bean.put("points", points);
			System.out.println("points="+points);
			
			int slotId = ParamUtil.getInteger(request, RequestConst.SLOT_ID);
			ViewPerformanceAppraisalSlots slot = ViewPerformanceAppraisalSlotsLocalServiceUtil
					.getPASlotDetail(userId, selectedPeriodId, slotId);
			bean.put("slot", slot);
			
			//Chua kiem tra dot dong' (phan phe duyet cung vay)
			if (((slot.getRatingStatus() != 0 || slot.getRatingStatusPm() != 0 || slot.getRatingStatusBod() != 0 ) && userRole == RequestConst.ROLE_EMPLOYEE) 
					|| (slot.getRatingStatus() != 0 || slot.getRatingStatusBod() != 0 && userRole == RequestConst.ROLE_PM)){ //Neu pm/bod da phe duyet thi disable ratingPoint
				bean.put("disableRatingPoint", true);
			} else {
				bean.put("disableRatingPoint", false);
			}
			//slot.getRatingStatusPm()
			// System.out.println("point-value: "+ slot.getPointValue());

			List<CdsPerformanceAppraisalSlotRating> slotRatingHistoryList = CdsPerformanceAppraisalSlotRatingLocalServiceUtil
					.getSlotRatingHistory(rootId ,userId, slotId);
			bean.put("slotRatingHistoryList", slotRatingHistoryList);
			bean.put("sizeOfSlotRatingHistoryList", slotRatingHistoryList.size());
			// slotRatingHistoryList.get(0).getUserType();
			bean.put("userId", userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void handleActionTab3Page2(ActionRequest request,
			ActionResponse response, Map<String, Object> bean, int rootId,
			int userId, int userRole, int periodId, int slotId, PrintWriter output)
			throws Exception {
		String handle = ParamUtil.getString(request, RequestConst.HANDLE);
		if (handle.equals(RequestConst.HANDLE_SAVE_POINT_RATING)) {
			try {
				//Kiem tra neu da phe duyet thi ko cho danh gia
				ViewPerformanceAppraisalSlots slot = ViewPerformanceAppraisalSlotsLocalServiceUtil.getPASlotDetail(userId, periodId, slotId);
				
				if (((slot.getRatingStatus() != 0 || slot.getRatingStatusPm() != 0 || slot.getRatingStatusBod() != 0 ) && userRole == RequestConst.ROLE_EMPLOYEE) 
						|| (slot.getRatingStatus() != 0 || slot.getRatingStatusBod() != 0 && userRole == RequestConst.ROLE_PM)){ //Da phe duyet
					//tra ve error
				} else {
					String pointName = ParamUtil.getString(request, RequestConst.POINT_NAME);
					int pointValue = ParamUtil.getInteger(request, RequestConst.POINT_VALUE);
					
					CdsPerformanceAppraisalSlotRatingLocalServiceUtil
							.addPASlotRating(rootId, periodId, userId, slotId,
									userId, true, 0, pointName, pointValue);
					
					if (userRole == RequestConst.ROLE_PM){ //neu la PM thi tu phe duyet
						CdsPerformanceAppraisalSlotRatingLocalServiceUtil.addPASlotRating(rootId, periodId, userId, slotId, userId, true, 1, pointName, pointValue);
					}
				}
				// output.print("Bạn đã đánh giá thành công cho slot");
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
						rootId, userId, periodId, slotId, userId, commentText);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (handle.equals(RequestConst.HANDLE_GET_COMMENT_LIST)) {
			try {
				List<CdsPerformanceAppraisalSlotComments> commentList = CdsPerformanceAppraisalSlotCommentsLocalServiceUtil
						.getSlotComments(userId, periodId, slotId);
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

					String content = StringEscapeUtils.escapeHtml(comment.getCommentContent());

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
	}
}
