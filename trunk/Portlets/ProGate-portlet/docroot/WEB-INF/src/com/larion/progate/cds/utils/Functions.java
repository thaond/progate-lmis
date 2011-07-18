package com.larion.progate.cds.utils;

import java.util.ArrayList;
import java.util.List;

import larion.progate.cds.model.CdsEvaluationPeriods;
import larion.progate.cds.model.CdsLevelStatisticalReport;
import larion.progate.cds.model.CdsMinimumRequirementLevels;
import larion.progate.cds.model.CdsPoints;
import larion.progate.cds.model.CdsSlotStatisticalReport;
import larion.progate.cds.model.CdsTitleMinimumRequirements;
import larion.progate.cds.model.Level;
import larion.progate.model.Organization;
import larion.progate.cds.model.Slot;
import larion.progate.model.User;
import larion.progate.cds.model.ViewFinalCompetencies;
import larion.progate.cds.model.ViewFinalLevels;
import larion.progate.cds.model.ViewFinalSlots;
import larion.progate.cds.model.ViewListTitleCompetencies;
import larion.progate.cds.model.ViewListTitleMinimumRequirements;
import larion.progate.cds.model.ViewPerformanceAppraisalLevels;
import larion.progate.cds.model.ViewPerformanceAppraisalSlots;
import larion.progate.cds.model.impl.CdsSlotStatisticalReportImpl;
import larion.progate.cds.service.CdsCompetencyStatisticalReportLocalServiceUtil;
import larion.progate.cds.service.CdsEvaluationPeriodsLocalServiceUtil;
import larion.progate.cds.service.CdsLevelStatisticalReportLocalServiceUtil;
import larion.progate.cds.service.CdsMinimumRequirementLevelsLocalServiceUtil;
import larion.progate.cds.service.CdsPerformanceAppraisalsLocalServiceUtil;
import larion.progate.cds.service.CdsPointsLocalServiceUtil;
import larion.progate.cds.service.CdsSlotStatisticalReportLocalServiceUtil;
import larion.progate.cds.service.CdsTitleMinimumRequirementsLocalServiceUtil;
import larion.progate.cds.service.CompetencyLocalServiceUtil;
import larion.progate.cds.service.LevelLocalServiceUtil;
import larion.progate.service.OrganizationLocalServiceUtil;
import larion.progate.cds.service.SlotLocalServiceUtil;
import larion.progate.service.UserLocalServiceUtil;
import larion.progate.cds.service.ViewEmployeesInProjectsLocalServiceUtil;
import larion.progate.cds.service.ViewFinalCompetenciesLocalServiceUtil;
import larion.progate.cds.service.ViewFinalLevelsLocalServiceUtil;
import larion.progate.cds.service.ViewFinalSlotsLocalServiceUtil;
import larion.progate.cds.service.ViewListTitleCompetenciesLocalServiceUtil;
import larion.progate.cds.service.ViewListTitleMinimumRequirementsLocalServiceUtil;
import larion.progate.cds.service.ViewPerformanceAppraisalLevelsLocalServiceUtil;
import larion.progate.cds.service.ViewPerformanceAppraisalSlotsLocalServiceUtil;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

public class Functions {
	/* Functions for Evaluation Period */
	public static boolean isNotUsed(int id) throws PortalException,
			SystemException {
		return CdsEvaluationPeriodsLocalServiceUtil
				.testBeforeDeleteCdsPeriod(id);
	}
	/* END Functions for Evaluation Period*/
	
	/* Functions for Config Title */
	/*Screen*/
	public static List<ViewListTitleCompetencies> getTitleCompetenciesByTitleId(
			int id) throws PortalException, SystemException {
		List<ViewListTitleCompetencies> titleCompetencies = ViewListTitleCompetenciesLocalServiceUtil
				.loadListTitleCompetencies(id);
		return titleCompetencies;
	}

	public static String getTitleMRLevelsNameByTitleId(int id)
			throws PortalException, SystemException {
		StringBuffer names = new StringBuffer();
		List<CdsTitleMinimumRequirements> titleMinimumRequirements = CdsTitleMinimumRequirementsLocalServiceUtil
				.loadListTitleMinimumRequirements(id);
		if (titleMinimumRequirements.size() > 0) {
			int levelId = titleMinimumRequirements.get(0)
					.getMinimumRequirementLevelId();
			CdsMinimumRequirementLevels mrLevel = CdsMinimumRequirementLevelsLocalServiceUtil
					.getCdsMinimumRequirementLevels(levelId);
			names.append(mrLevel.getName());
		}
		for (int i = 1; i < titleMinimumRequirements.size(); i++) {
			int levelId = titleMinimumRequirements.get(i)
					.getMinimumRequirementLevelId();
			CdsMinimumRequirementLevels mrLevel = CdsMinimumRequirementLevelsLocalServiceUtil
					.getCdsMinimumRequirementLevels(levelId);
			names.append(", ").append(mrLevel.getName());
		}
		return names.toString();
	}
	
	/*Dialog*/
	public static int getLevelCountByCompetencyId(int id)
			throws PortalException, SystemException {
		List<Level> levels = LevelLocalServiceUtil
				.getLevelListByCompetencyId(id);

		return levels.size();
	}
	
	public static int getLevelCountByMinimumRequirementId(int id)
			throws PortalException, SystemException {
		List<CdsMinimumRequirementLevels> MRLevels = CdsMinimumRequirementLevelsLocalServiceUtil
				.getCdsMRLevelListByMinimumRequirementId(id);

		return MRLevels.size();
	}
	
	public static List<CdsMinimumRequirementLevels> getLevelsByMinimumRequirementId(
			int id) throws PortalException, SystemException {
		List<CdsMinimumRequirementLevels> MRLevels = CdsMinimumRequirementLevelsLocalServiceUtil
				.getCdsMRLevelListByMinimumRequirementId(id);
		return MRLevels;
	}
	/* END Functions for Config Title */
	
	/* Functions for CurrentResult and Prepare */
	public static int getMaxLevelPoint(int rootId, int levelId)
			throws PortalException, SystemException {
		List<Slot> slots = SlotLocalServiceUtil.getSlotListByLevelId(levelId);
		int slotSize = slots.size();
		CdsPoints maxPoint = CdsPointsLocalServiceUtil.getCdsPointMax(rootId);
		int maxLevelPoint = slotSize * maxPoint.getPointValue();
		return maxLevelPoint;
	}
	
	public static List<ViewFinalLevels> getFinalLevelsByCompetencyId(int rootId , int userId, int competencyId, int slotStatus )
	throws PortalException, SystemException {
		List<ViewFinalLevels> finalLevels = ViewFinalLevelsLocalServiceUtil
				.getFinalLevelsList(rootId, userId, competencyId, slotStatus);
		return finalLevels;
	}
	
	public static List<ViewFinalSlots> getFinalSlotsByLevelId(int rootId, int userId, int levelId, int slotStatus)
	throws PortalException, SystemException {
		List<ViewFinalSlots> finalSlots = ViewFinalSlotsLocalServiceUtil
				.getFinalSlotsList(rootId, userId, levelId, slotStatus);
		return finalSlots;
	}
	/* END Functions for CurrentResult and Prepare */
	
	/* Functions for Prepare */
	public static int getLevelCountByCompetencyIdAndSlotStatus(int rootId,
			int userId, int competencyId, int slotStatus)
			throws PortalException, SystemException {
		List<ViewFinalLevels> finalLevels = ViewFinalLevelsLocalServiceUtil
				.getFinalLevelsList(rootId, userId, competencyId, slotStatus);
		return finalLevels.size();
	}

	public static int getSlotCountByLevelIdAndSlotStatus(int rootId,
			int userId, int levelId, int slotStatus) throws PortalException,
			SystemException {
		List<ViewFinalSlots> finalSlots = ViewFinalSlotsLocalServiceUtil
				.getFinalSlotsList(rootId, userId, levelId, slotStatus);
		return finalSlots.size();
	}
	/* END Functions for Prepare */
	
	public static List<ViewListTitleMinimumRequirements> getTitleMinimumRequirementsByTitleId(
			int id) throws PortalException, SystemException {
		List<ViewListTitleMinimumRequirements> titleMinimumRequirements = ViewListTitleMinimumRequirementsLocalServiceUtil
				.loadListTitleMinimumRequirements(id);
		return titleMinimumRequirements;
	}

	public static String getUserNameByUserId(int id) throws PortalException,
			SystemException {
		User user = UserLocalServiceUtil.getUser(id);
		String name = user.getFirstname() + user.getMiddlename() + " "
				+ user.getLastname();
		return name;
	}

	/*
	 * Functions for Evaluation
	 */

	public static String getCompetencyNameByCompetencyId(int id)
			throws PortalException, SystemException {
		return CompetencyLocalServiceUtil.getCompetency(id).getName();
	}

	public static CdsEvaluationPeriods getPeriodByPeriodId(int id)
			throws PortalException, SystemException {
		return CdsEvaluationPeriodsLocalServiceUtil.getCdsEvaluationPeriods(id);
	}

	public static String getUserFullnameByUserId(int id)
			throws PortalException, SystemException {
		StringBuffer userStringBuffer = new StringBuffer();
		userStringBuffer
				.append(UserLocalServiceUtil.getUser(id).getFirstname());
		userStringBuffer.append(" ");
		String middleName = UserLocalServiceUtil.getUser(id).getMiddlename();
		if (!middleName.isEmpty()) {
			userStringBuffer.append(middleName);
			userStringBuffer.append(" ");
		}
		userStringBuffer.append(UserLocalServiceUtil.getUser(id).getLastname());
		String userFullname = userStringBuffer.toString();
		return userFullname;
	}
	
	/* Functions for Statistical Report: Employee State and Level Mapping*/
	public static List<Level> getLevelsByCompetencyId(int competencyId)
			throws PortalException, SystemException {
		List<Level> Levels = LevelLocalServiceUtil
				.getLevelListByCompetencyId(competencyId);
		return Levels;
	}

	public static List<Slot> getSlotsByLevelId(int levelId)
			throws PortalException, SystemException {
		List<Slot> Slots = SlotLocalServiceUtil.getSlotListByLevelId(levelId);
		return Slots;
	}

	public static int getSlotCountByLevelId(int levelId)
			throws PortalException, SystemException {
		int count = 0;
		List<Slot> Slots = SlotLocalServiceUtil.getSlotListByLevelId(levelId);
		count += Slots.size();
		return count;
	}

	public static String getLevelRankingByCompetencyId(int rootId, int userId,
			int periodId, int competencyId) throws PortalException,
			SystemException {
		return CdsCompetencyStatisticalReportLocalServiceUtil
				.getLevelRankingValue(rootId, userId, periodId, competencyId);
	}

	public static List<CdsSlotStatisticalReport> getSlotsReportByCompetencyId(
			int rootId, int userId, int periodId, int competencyId)
			throws PortalException, SystemException {
		List<CdsSlotStatisticalReport> slotStatiscalReport = new ArrayList<CdsSlotStatisticalReport>();
		List<Level> Levels = LevelLocalServiceUtil
				.getLevelListByCompetencyId(competencyId);
		for (Level level : Levels) {
			List<CdsSlotStatisticalReport> temp = CdsSlotStatisticalReportLocalServiceUtil
					.getCdsSlotStatisticalReportList(rootId, userId, periodId,
							level.getLevelId());
			/*
			 * level ko co slots -> them 1 doi tuong slot report rong de slot
			 * report cua level khac ko bi day sang trai 1 cot
			 */
			if (temp.size() == 0) {
				temp = new ArrayList<CdsSlotStatisticalReport>();
				CdsSlotStatisticalReport objTemp = new CdsSlotStatisticalReportImpl();
				temp.add(objTemp);
			}
			slotStatiscalReport.addAll(temp);
		}
		return slotStatiscalReport;
	}
	/* END Functions for Statistical Report: Employee State and Level Mapping*/

	/*
	 * Functions for Approval
	 */
	public static int getProjectIdOfEmployeeByPeriod(int periodId, int userId)
			throws PortalException, SystemException { // user X trong dot Y nam
														// trong du an nao
		/*
		 * System.out.println("periodId = " + periodId);
		 * System.out.println("userId = " + userId);
		 * System.out.println("orgId = " +
		 * ViewEmployeesInProjectsLocalServiceUtil.checkEmployee(periodId,
		 * userId));
		 */
		return ViewEmployeesInProjectsLocalServiceUtil.checkEmployee(periodId,
				userId);
	}

	/*
	 * Functions for Input Data
	 */
	public static String getProjectNameByProjectId(int orgId)
			throws PortalException, SystemException {
		Organization org = OrganizationLocalServiceUtil.getOrganization(orgId);
		return org.getName();
	}
	
	public static boolean checkImportedOrNot (int rootId, int userId)
			throws PortalException, SystemException {
		boolean test = CdsPerformanceAppraisalsLocalServiceUtil.checkInImportedPeriod(rootId, userId);
		return test;
	}
	/*
	 * Functions for Evaluate SLot
	 */
	public static List<ViewPerformanceAppraisalLevels> getPALevelsByPACompetencyId(int userId, int selectedPeriodId, int competencyId)
	throws PortalException, SystemException {
		List<ViewPerformanceAppraisalLevels> levels = ViewPerformanceAppraisalLevelsLocalServiceUtil.getCdsPALevels(userId, selectedPeriodId, competencyId);
		if (levels == null) {
			levels = new ArrayList<ViewPerformanceAppraisalLevels>();
		}
		return levels;
	}
	
	public static List<ViewPerformanceAppraisalSlots> getPASlotsByPALevelId(int userId, int selectedPeriodId, int levelId)
	throws PortalException, SystemException {
		List<ViewPerformanceAppraisalSlots> slots = ViewPerformanceAppraisalSlotsLocalServiceUtil.getCdsPASlots(userId, selectedPeriodId, levelId);
		if (slots == null) {
			slots = new ArrayList<ViewPerformanceAppraisalSlots>();
		}
		return slots;
	}
	
	/*
	 * Functions for Slot Statistical Report
	 */
	public static List<CdsLevelStatisticalReport> getSSRLevelsByCompetencyId(int rootId, int userId, int periodId, int competencyId)
		throws PortalException, SystemException {
		List<CdsLevelStatisticalReport> listLevel = CdsLevelStatisticalReportLocalServiceUtil.getCdsLevelStatisticalReportList(rootId, userId, periodId, competencyId);
		if(listLevel == null){
			listLevel = new ArrayList<CdsLevelStatisticalReport>();
		}
		return listLevel;
	}
	
	public static List<CdsSlotStatisticalReport> getSSRSlotsByLevelId(int rootId, int userId, int periodId, int levelId)
		throws PortalException, SystemException {
		List<CdsSlotStatisticalReport> listSlot = CdsSlotStatisticalReportLocalServiceUtil.getCdsSlotStatisticalReportList(rootId, userId, periodId, levelId);
		if(listSlot == null){
			listSlot = new ArrayList<CdsSlotStatisticalReport>();
		}
		return listSlot;
	}
	
	
}
