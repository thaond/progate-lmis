/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package larion.progate.cds.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import larion.progate.cds.service.CdsCdpLocalService;
import larion.progate.cds.service.CdsCdpService;
import larion.progate.cds.service.CdsCompetencyStatisticalReportLocalService;
import larion.progate.cds.service.CdsCompetencyStatisticalReportService;
import larion.progate.cds.service.CdsEvaluationPeriodsLocalService;
import larion.progate.cds.service.CdsEvaluationPeriodsService;
import larion.progate.cds.service.CdsLevelStatisticalReportLocalService;
import larion.progate.cds.service.CdsLevelStatisticalReportService;
import larion.progate.cds.service.CdsMinimumRequirementLevelsLocalService;
import larion.progate.cds.service.CdsMinimumRequirementLevelsService;
import larion.progate.cds.service.CdsMinimumRequirementsLocalService;
import larion.progate.cds.service.CdsMinimumRequirementsService;
import larion.progate.cds.service.CdsPACompetenciesLocalService;
import larion.progate.cds.service.CdsPACompetenciesService;
import larion.progate.cds.service.CdsPAFinalCompeteniesLocalService;
import larion.progate.cds.service.CdsPAFinalCompeteniesService;
import larion.progate.cds.service.CdsPAFinalLevelsLocalService;
import larion.progate.cds.service.CdsPAFinalLevelsService;
import larion.progate.cds.service.CdsPAFinalLocalService;
import larion.progate.cds.service.CdsPAFinalService;
import larion.progate.cds.service.CdsPAFinalSlotsLocalService;
import larion.progate.cds.service.CdsPAFinalSlotsService;
import larion.progate.cds.service.CdsPALevelsLocalService;
import larion.progate.cds.service.CdsPALevelsService;
import larion.progate.cds.service.CdsPASlotsLocalService;
import larion.progate.cds.service.CdsPASlotsService;
import larion.progate.cds.service.CdsPerformanceAppraisalSlotCommentsLocalService;
import larion.progate.cds.service.CdsPerformanceAppraisalSlotCommentsService;
import larion.progate.cds.service.CdsPerformanceAppraisalSlotRatingLocalService;
import larion.progate.cds.service.CdsPerformanceAppraisalSlotRatingService;
import larion.progate.cds.service.CdsPerformanceAppraisalsLocalService;
import larion.progate.cds.service.CdsPerformanceAppraisalsService;
import larion.progate.cds.service.CdsPointsLocalService;
import larion.progate.cds.service.CdsPointsService;
import larion.progate.cds.service.CdsSlotStatisticalReportLocalService;
import larion.progate.cds.service.CdsSlotStatisticalReportService;
import larion.progate.cds.service.CdsTitleCompetenciesLocalService;
import larion.progate.cds.service.CdsTitleCompetenciesService;
import larion.progate.cds.service.CdsTitleMinimumRequirementsLocalService;
import larion.progate.cds.service.CdsTitleMinimumRequirementsService;
import larion.progate.cds.service.CdsTitlesLocalService;
import larion.progate.cds.service.CdsTitlesService;
import larion.progate.cds.service.CompetencyLocalService;
import larion.progate.cds.service.CompetencyService;
import larion.progate.cds.service.LevelLocalService;
import larion.progate.cds.service.LevelService;
import larion.progate.cds.service.SlotLocalService;
import larion.progate.cds.service.SlotService;
import larion.progate.cds.service.ViewEmployeesInProjectsLocalService;
import larion.progate.cds.service.ViewEmployeesInProjectsService;
import larion.progate.cds.service.ViewEmployeesSlotsRatingLocalService;
import larion.progate.cds.service.ViewEmployeesSlotsRatingService;
import larion.progate.cds.service.ViewFinalCompetenciesLocalService;
import larion.progate.cds.service.ViewFinalCompetenciesService;
import larion.progate.cds.service.ViewFinalLevelsLocalService;
import larion.progate.cds.service.ViewFinalLevelsService;
import larion.progate.cds.service.ViewFinalSlotsLocalService;
import larion.progate.cds.service.ViewFinalSlotsService;
import larion.progate.cds.service.ViewFinalTitlesLocalService;
import larion.progate.cds.service.ViewFinalTitlesService;
import larion.progate.cds.service.ViewListTitleCompetenciesLocalService;
import larion.progate.cds.service.ViewListTitleCompetenciesService;
import larion.progate.cds.service.ViewListTitleMinimumRequirementsLocalService;
import larion.progate.cds.service.ViewListTitleMinimumRequirementsService;
import larion.progate.cds.service.ViewPerformanceAppraisalLevelsLocalService;
import larion.progate.cds.service.ViewPerformanceAppraisalLevelsService;
import larion.progate.cds.service.ViewPerformanceAppraisalSlotsLocalService;
import larion.progate.cds.service.ViewPerformanceAppraisalSlotsService;
import larion.progate.cds.service.ViewSlotInformationLocalService;
import larion.progate.cds.service.ViewSlotInformationService;
import larion.progate.cds.service.persistence.CdsCdpFinder;
import larion.progate.cds.service.persistence.CdsCdpPersistence;
import larion.progate.cds.service.persistence.CdsCompetencyStatisticalReportFinder;
import larion.progate.cds.service.persistence.CdsCompetencyStatisticalReportPersistence;
import larion.progate.cds.service.persistence.CdsEvaluationPeriodsFinder;
import larion.progate.cds.service.persistence.CdsEvaluationPeriodsPersistence;
import larion.progate.cds.service.persistence.CdsLevelStatisticalReportFinder;
import larion.progate.cds.service.persistence.CdsLevelStatisticalReportPersistence;
import larion.progate.cds.service.persistence.CdsMinimumRequirementLevelsPersistence;
import larion.progate.cds.service.persistence.CdsMinimumRequirementsPersistence;
import larion.progate.cds.service.persistence.CdsPACompetenciesFinder;
import larion.progate.cds.service.persistence.CdsPACompetenciesPersistence;
import larion.progate.cds.service.persistence.CdsPAFinalCompeteniesPersistence;
import larion.progate.cds.service.persistence.CdsPAFinalLevelsPersistence;
import larion.progate.cds.service.persistence.CdsPAFinalPersistence;
import larion.progate.cds.service.persistence.CdsPAFinalSlotsPersistence;
import larion.progate.cds.service.persistence.CdsPALevelsFinder;
import larion.progate.cds.service.persistence.CdsPALevelsPersistence;
import larion.progate.cds.service.persistence.CdsPASlotsFinder;
import larion.progate.cds.service.persistence.CdsPASlotsPersistence;
import larion.progate.cds.service.persistence.CdsPerformanceAppraisalSlotCommentsFinder;
import larion.progate.cds.service.persistence.CdsPerformanceAppraisalSlotCommentsPersistence;
import larion.progate.cds.service.persistence.CdsPerformanceAppraisalSlotRatingFinder;
import larion.progate.cds.service.persistence.CdsPerformanceAppraisalSlotRatingPersistence;
import larion.progate.cds.service.persistence.CdsPerformanceAppraisalsFinder;
import larion.progate.cds.service.persistence.CdsPerformanceAppraisalsPersistence;
import larion.progate.cds.service.persistence.CdsPointsPersistence;
import larion.progate.cds.service.persistence.CdsSlotStatisticalReportFinder;
import larion.progate.cds.service.persistence.CdsSlotStatisticalReportPersistence;
import larion.progate.cds.service.persistence.CdsTitleCompetenciesPersistence;
import larion.progate.cds.service.persistence.CdsTitleMinimumRequirementsPersistence;
import larion.progate.cds.service.persistence.CdsTitlesPersistence;
import larion.progate.cds.service.persistence.CompetencyPersistence;
import larion.progate.cds.service.persistence.LevelFinder;
import larion.progate.cds.service.persistence.LevelPersistence;
import larion.progate.cds.service.persistence.SlotFinder;
import larion.progate.cds.service.persistence.SlotPersistence;
import larion.progate.cds.service.persistence.ViewEmployeesInProjectsFinder;
import larion.progate.cds.service.persistence.ViewEmployeesInProjectsPersistence;
import larion.progate.cds.service.persistence.ViewEmployeesSlotsRatingFinder;
import larion.progate.cds.service.persistence.ViewEmployeesSlotsRatingPersistence;
import larion.progate.cds.service.persistence.ViewFinalCompetenciesFinder;
import larion.progate.cds.service.persistence.ViewFinalCompetenciesPersistence;
import larion.progate.cds.service.persistence.ViewFinalLevelsFinder;
import larion.progate.cds.service.persistence.ViewFinalLevelsPersistence;
import larion.progate.cds.service.persistence.ViewFinalSlotsFinder;
import larion.progate.cds.service.persistence.ViewFinalSlotsPersistence;
import larion.progate.cds.service.persistence.ViewFinalTitlesFinder;
import larion.progate.cds.service.persistence.ViewFinalTitlesPersistence;
import larion.progate.cds.service.persistence.ViewListTitleCompetenciesPersistence;
import larion.progate.cds.service.persistence.ViewListTitleMinimumRequirementsPersistence;
import larion.progate.cds.service.persistence.ViewPerformanceAppraisalLevelsFinder;
import larion.progate.cds.service.persistence.ViewPerformanceAppraisalLevelsPersistence;
import larion.progate.cds.service.persistence.ViewPerformanceAppraisalSlotsFinder;
import larion.progate.cds.service.persistence.ViewPerformanceAppraisalSlotsPersistence;
import larion.progate.cds.service.persistence.ViewSlotInformationFinder;
import larion.progate.cds.service.persistence.ViewSlotInformationPersistence;

/**
 * <a href="ViewEmployeesInProjectsServiceBaseImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public abstract class ViewEmployeesInProjectsServiceBaseImpl
	extends PrincipalBean implements ViewEmployeesInProjectsService {
	public CompetencyLocalService getCompetencyLocalService() {
		return competencyLocalService;
	}

	public void setCompetencyLocalService(
		CompetencyLocalService competencyLocalService) {
		this.competencyLocalService = competencyLocalService;
	}

	public CompetencyService getCompetencyService() {
		return competencyService;
	}

	public void setCompetencyService(CompetencyService competencyService) {
		this.competencyService = competencyService;
	}

	public CompetencyPersistence getCompetencyPersistence() {
		return competencyPersistence;
	}

	public void setCompetencyPersistence(
		CompetencyPersistence competencyPersistence) {
		this.competencyPersistence = competencyPersistence;
	}

	public LevelLocalService getLevelLocalService() {
		return levelLocalService;
	}

	public void setLevelLocalService(LevelLocalService levelLocalService) {
		this.levelLocalService = levelLocalService;
	}

	public LevelService getLevelService() {
		return levelService;
	}

	public void setLevelService(LevelService levelService) {
		this.levelService = levelService;
	}

	public LevelPersistence getLevelPersistence() {
		return levelPersistence;
	}

	public void setLevelPersistence(LevelPersistence levelPersistence) {
		this.levelPersistence = levelPersistence;
	}

	public LevelFinder getLevelFinder() {
		return levelFinder;
	}

	public void setLevelFinder(LevelFinder levelFinder) {
		this.levelFinder = levelFinder;
	}

	public SlotLocalService getSlotLocalService() {
		return slotLocalService;
	}

	public void setSlotLocalService(SlotLocalService slotLocalService) {
		this.slotLocalService = slotLocalService;
	}

	public SlotService getSlotService() {
		return slotService;
	}

	public void setSlotService(SlotService slotService) {
		this.slotService = slotService;
	}

	public SlotPersistence getSlotPersistence() {
		return slotPersistence;
	}

	public void setSlotPersistence(SlotPersistence slotPersistence) {
		this.slotPersistence = slotPersistence;
	}

	public SlotFinder getSlotFinder() {
		return slotFinder;
	}

	public void setSlotFinder(SlotFinder slotFinder) {
		this.slotFinder = slotFinder;
	}

	public CdsPointsLocalService getCdsPointsLocalService() {
		return cdsPointsLocalService;
	}

	public void setCdsPointsLocalService(
		CdsPointsLocalService cdsPointsLocalService) {
		this.cdsPointsLocalService = cdsPointsLocalService;
	}

	public CdsPointsService getCdsPointsService() {
		return cdsPointsService;
	}

	public void setCdsPointsService(CdsPointsService cdsPointsService) {
		this.cdsPointsService = cdsPointsService;
	}

	public CdsPointsPersistence getCdsPointsPersistence() {
		return cdsPointsPersistence;
	}

	public void setCdsPointsPersistence(
		CdsPointsPersistence cdsPointsPersistence) {
		this.cdsPointsPersistence = cdsPointsPersistence;
	}

	public CdsEvaluationPeriodsLocalService getCdsEvaluationPeriodsLocalService() {
		return cdsEvaluationPeriodsLocalService;
	}

	public void setCdsEvaluationPeriodsLocalService(
		CdsEvaluationPeriodsLocalService cdsEvaluationPeriodsLocalService) {
		this.cdsEvaluationPeriodsLocalService = cdsEvaluationPeriodsLocalService;
	}

	public CdsEvaluationPeriodsService getCdsEvaluationPeriodsService() {
		return cdsEvaluationPeriodsService;
	}

	public void setCdsEvaluationPeriodsService(
		CdsEvaluationPeriodsService cdsEvaluationPeriodsService) {
		this.cdsEvaluationPeriodsService = cdsEvaluationPeriodsService;
	}

	public CdsEvaluationPeriodsPersistence getCdsEvaluationPeriodsPersistence() {
		return cdsEvaluationPeriodsPersistence;
	}

	public void setCdsEvaluationPeriodsPersistence(
		CdsEvaluationPeriodsPersistence cdsEvaluationPeriodsPersistence) {
		this.cdsEvaluationPeriodsPersistence = cdsEvaluationPeriodsPersistence;
	}

	public CdsEvaluationPeriodsFinder getCdsEvaluationPeriodsFinder() {
		return cdsEvaluationPeriodsFinder;
	}

	public void setCdsEvaluationPeriodsFinder(
		CdsEvaluationPeriodsFinder cdsEvaluationPeriodsFinder) {
		this.cdsEvaluationPeriodsFinder = cdsEvaluationPeriodsFinder;
	}

	public CdsTitlesLocalService getCdsTitlesLocalService() {
		return cdsTitlesLocalService;
	}

	public void setCdsTitlesLocalService(
		CdsTitlesLocalService cdsTitlesLocalService) {
		this.cdsTitlesLocalService = cdsTitlesLocalService;
	}

	public CdsTitlesService getCdsTitlesService() {
		return cdsTitlesService;
	}

	public void setCdsTitlesService(CdsTitlesService cdsTitlesService) {
		this.cdsTitlesService = cdsTitlesService;
	}

	public CdsTitlesPersistence getCdsTitlesPersistence() {
		return cdsTitlesPersistence;
	}

	public void setCdsTitlesPersistence(
		CdsTitlesPersistence cdsTitlesPersistence) {
		this.cdsTitlesPersistence = cdsTitlesPersistence;
	}

	public CdsTitleCompetenciesLocalService getCdsTitleCompetenciesLocalService() {
		return cdsTitleCompetenciesLocalService;
	}

	public void setCdsTitleCompetenciesLocalService(
		CdsTitleCompetenciesLocalService cdsTitleCompetenciesLocalService) {
		this.cdsTitleCompetenciesLocalService = cdsTitleCompetenciesLocalService;
	}

	public CdsTitleCompetenciesService getCdsTitleCompetenciesService() {
		return cdsTitleCompetenciesService;
	}

	public void setCdsTitleCompetenciesService(
		CdsTitleCompetenciesService cdsTitleCompetenciesService) {
		this.cdsTitleCompetenciesService = cdsTitleCompetenciesService;
	}

	public CdsTitleCompetenciesPersistence getCdsTitleCompetenciesPersistence() {
		return cdsTitleCompetenciesPersistence;
	}

	public void setCdsTitleCompetenciesPersistence(
		CdsTitleCompetenciesPersistence cdsTitleCompetenciesPersistence) {
		this.cdsTitleCompetenciesPersistence = cdsTitleCompetenciesPersistence;
	}

	public CdsMinimumRequirementsLocalService getCdsMinimumRequirementsLocalService() {
		return cdsMinimumRequirementsLocalService;
	}

	public void setCdsMinimumRequirementsLocalService(
		CdsMinimumRequirementsLocalService cdsMinimumRequirementsLocalService) {
		this.cdsMinimumRequirementsLocalService = cdsMinimumRequirementsLocalService;
	}

	public CdsMinimumRequirementsService getCdsMinimumRequirementsService() {
		return cdsMinimumRequirementsService;
	}

	public void setCdsMinimumRequirementsService(
		CdsMinimumRequirementsService cdsMinimumRequirementsService) {
		this.cdsMinimumRequirementsService = cdsMinimumRequirementsService;
	}

	public CdsMinimumRequirementsPersistence getCdsMinimumRequirementsPersistence() {
		return cdsMinimumRequirementsPersistence;
	}

	public void setCdsMinimumRequirementsPersistence(
		CdsMinimumRequirementsPersistence cdsMinimumRequirementsPersistence) {
		this.cdsMinimumRequirementsPersistence = cdsMinimumRequirementsPersistence;
	}

	public CdsTitleMinimumRequirementsLocalService getCdsTitleMinimumRequirementsLocalService() {
		return cdsTitleMinimumRequirementsLocalService;
	}

	public void setCdsTitleMinimumRequirementsLocalService(
		CdsTitleMinimumRequirementsLocalService cdsTitleMinimumRequirementsLocalService) {
		this.cdsTitleMinimumRequirementsLocalService = cdsTitleMinimumRequirementsLocalService;
	}

	public CdsTitleMinimumRequirementsService getCdsTitleMinimumRequirementsService() {
		return cdsTitleMinimumRequirementsService;
	}

	public void setCdsTitleMinimumRequirementsService(
		CdsTitleMinimumRequirementsService cdsTitleMinimumRequirementsService) {
		this.cdsTitleMinimumRequirementsService = cdsTitleMinimumRequirementsService;
	}

	public CdsTitleMinimumRequirementsPersistence getCdsTitleMinimumRequirementsPersistence() {
		return cdsTitleMinimumRequirementsPersistence;
	}

	public void setCdsTitleMinimumRequirementsPersistence(
		CdsTitleMinimumRequirementsPersistence cdsTitleMinimumRequirementsPersistence) {
		this.cdsTitleMinimumRequirementsPersistence = cdsTitleMinimumRequirementsPersistence;
	}

	public CdsMinimumRequirementLevelsLocalService getCdsMinimumRequirementLevelsLocalService() {
		return cdsMinimumRequirementLevelsLocalService;
	}

	public void setCdsMinimumRequirementLevelsLocalService(
		CdsMinimumRequirementLevelsLocalService cdsMinimumRequirementLevelsLocalService) {
		this.cdsMinimumRequirementLevelsLocalService = cdsMinimumRequirementLevelsLocalService;
	}

	public CdsMinimumRequirementLevelsService getCdsMinimumRequirementLevelsService() {
		return cdsMinimumRequirementLevelsService;
	}

	public void setCdsMinimumRequirementLevelsService(
		CdsMinimumRequirementLevelsService cdsMinimumRequirementLevelsService) {
		this.cdsMinimumRequirementLevelsService = cdsMinimumRequirementLevelsService;
	}

	public CdsMinimumRequirementLevelsPersistence getCdsMinimumRequirementLevelsPersistence() {
		return cdsMinimumRequirementLevelsPersistence;
	}

	public void setCdsMinimumRequirementLevelsPersistence(
		CdsMinimumRequirementLevelsPersistence cdsMinimumRequirementLevelsPersistence) {
		this.cdsMinimumRequirementLevelsPersistence = cdsMinimumRequirementLevelsPersistence;
	}

	public ViewListTitleCompetenciesLocalService getViewListTitleCompetenciesLocalService() {
		return viewListTitleCompetenciesLocalService;
	}

	public void setViewListTitleCompetenciesLocalService(
		ViewListTitleCompetenciesLocalService viewListTitleCompetenciesLocalService) {
		this.viewListTitleCompetenciesLocalService = viewListTitleCompetenciesLocalService;
	}

	public ViewListTitleCompetenciesService getViewListTitleCompetenciesService() {
		return viewListTitleCompetenciesService;
	}

	public void setViewListTitleCompetenciesService(
		ViewListTitleCompetenciesService viewListTitleCompetenciesService) {
		this.viewListTitleCompetenciesService = viewListTitleCompetenciesService;
	}

	public ViewListTitleCompetenciesPersistence getViewListTitleCompetenciesPersistence() {
		return viewListTitleCompetenciesPersistence;
	}

	public void setViewListTitleCompetenciesPersistence(
		ViewListTitleCompetenciesPersistence viewListTitleCompetenciesPersistence) {
		this.viewListTitleCompetenciesPersistence = viewListTitleCompetenciesPersistence;
	}

	public ViewListTitleMinimumRequirementsLocalService getViewListTitleMinimumRequirementsLocalService() {
		return viewListTitleMinimumRequirementsLocalService;
	}

	public void setViewListTitleMinimumRequirementsLocalService(
		ViewListTitleMinimumRequirementsLocalService viewListTitleMinimumRequirementsLocalService) {
		this.viewListTitleMinimumRequirementsLocalService = viewListTitleMinimumRequirementsLocalService;
	}

	public ViewListTitleMinimumRequirementsService getViewListTitleMinimumRequirementsService() {
		return viewListTitleMinimumRequirementsService;
	}

	public void setViewListTitleMinimumRequirementsService(
		ViewListTitleMinimumRequirementsService viewListTitleMinimumRequirementsService) {
		this.viewListTitleMinimumRequirementsService = viewListTitleMinimumRequirementsService;
	}

	public ViewListTitleMinimumRequirementsPersistence getViewListTitleMinimumRequirementsPersistence() {
		return viewListTitleMinimumRequirementsPersistence;
	}

	public void setViewListTitleMinimumRequirementsPersistence(
		ViewListTitleMinimumRequirementsPersistence viewListTitleMinimumRequirementsPersistence) {
		this.viewListTitleMinimumRequirementsPersistence = viewListTitleMinimumRequirementsPersistence;
	}

	public CdsPAFinalCompeteniesLocalService getCdsPAFinalCompeteniesLocalService() {
		return cdsPAFinalCompeteniesLocalService;
	}

	public void setCdsPAFinalCompeteniesLocalService(
		CdsPAFinalCompeteniesLocalService cdsPAFinalCompeteniesLocalService) {
		this.cdsPAFinalCompeteniesLocalService = cdsPAFinalCompeteniesLocalService;
	}

	public CdsPAFinalCompeteniesService getCdsPAFinalCompeteniesService() {
		return cdsPAFinalCompeteniesService;
	}

	public void setCdsPAFinalCompeteniesService(
		CdsPAFinalCompeteniesService cdsPAFinalCompeteniesService) {
		this.cdsPAFinalCompeteniesService = cdsPAFinalCompeteniesService;
	}

	public CdsPAFinalCompeteniesPersistence getCdsPAFinalCompeteniesPersistence() {
		return cdsPAFinalCompeteniesPersistence;
	}

	public void setCdsPAFinalCompeteniesPersistence(
		CdsPAFinalCompeteniesPersistence cdsPAFinalCompeteniesPersistence) {
		this.cdsPAFinalCompeteniesPersistence = cdsPAFinalCompeteniesPersistence;
	}

	public CdsPAFinalLevelsLocalService getCdsPAFinalLevelsLocalService() {
		return cdsPAFinalLevelsLocalService;
	}

	public void setCdsPAFinalLevelsLocalService(
		CdsPAFinalLevelsLocalService cdsPAFinalLevelsLocalService) {
		this.cdsPAFinalLevelsLocalService = cdsPAFinalLevelsLocalService;
	}

	public CdsPAFinalLevelsService getCdsPAFinalLevelsService() {
		return cdsPAFinalLevelsService;
	}

	public void setCdsPAFinalLevelsService(
		CdsPAFinalLevelsService cdsPAFinalLevelsService) {
		this.cdsPAFinalLevelsService = cdsPAFinalLevelsService;
	}

	public CdsPAFinalLevelsPersistence getCdsPAFinalLevelsPersistence() {
		return cdsPAFinalLevelsPersistence;
	}

	public void setCdsPAFinalLevelsPersistence(
		CdsPAFinalLevelsPersistence cdsPAFinalLevelsPersistence) {
		this.cdsPAFinalLevelsPersistence = cdsPAFinalLevelsPersistence;
	}

	public CdsPAFinalSlotsLocalService getCdsPAFinalSlotsLocalService() {
		return cdsPAFinalSlotsLocalService;
	}

	public void setCdsPAFinalSlotsLocalService(
		CdsPAFinalSlotsLocalService cdsPAFinalSlotsLocalService) {
		this.cdsPAFinalSlotsLocalService = cdsPAFinalSlotsLocalService;
	}

	public CdsPAFinalSlotsService getCdsPAFinalSlotsService() {
		return cdsPAFinalSlotsService;
	}

	public void setCdsPAFinalSlotsService(
		CdsPAFinalSlotsService cdsPAFinalSlotsService) {
		this.cdsPAFinalSlotsService = cdsPAFinalSlotsService;
	}

	public CdsPAFinalSlotsPersistence getCdsPAFinalSlotsPersistence() {
		return cdsPAFinalSlotsPersistence;
	}

	public void setCdsPAFinalSlotsPersistence(
		CdsPAFinalSlotsPersistence cdsPAFinalSlotsPersistence) {
		this.cdsPAFinalSlotsPersistence = cdsPAFinalSlotsPersistence;
	}

	public ViewFinalCompetenciesLocalService getViewFinalCompetenciesLocalService() {
		return viewFinalCompetenciesLocalService;
	}

	public void setViewFinalCompetenciesLocalService(
		ViewFinalCompetenciesLocalService viewFinalCompetenciesLocalService) {
		this.viewFinalCompetenciesLocalService = viewFinalCompetenciesLocalService;
	}

	public ViewFinalCompetenciesService getViewFinalCompetenciesService() {
		return viewFinalCompetenciesService;
	}

	public void setViewFinalCompetenciesService(
		ViewFinalCompetenciesService viewFinalCompetenciesService) {
		this.viewFinalCompetenciesService = viewFinalCompetenciesService;
	}

	public ViewFinalCompetenciesPersistence getViewFinalCompetenciesPersistence() {
		return viewFinalCompetenciesPersistence;
	}

	public void setViewFinalCompetenciesPersistence(
		ViewFinalCompetenciesPersistence viewFinalCompetenciesPersistence) {
		this.viewFinalCompetenciesPersistence = viewFinalCompetenciesPersistence;
	}

	public ViewFinalCompetenciesFinder getViewFinalCompetenciesFinder() {
		return viewFinalCompetenciesFinder;
	}

	public void setViewFinalCompetenciesFinder(
		ViewFinalCompetenciesFinder viewFinalCompetenciesFinder) {
		this.viewFinalCompetenciesFinder = viewFinalCompetenciesFinder;
	}

	public ViewFinalLevelsLocalService getViewFinalLevelsLocalService() {
		return viewFinalLevelsLocalService;
	}

	public void setViewFinalLevelsLocalService(
		ViewFinalLevelsLocalService viewFinalLevelsLocalService) {
		this.viewFinalLevelsLocalService = viewFinalLevelsLocalService;
	}

	public ViewFinalLevelsService getViewFinalLevelsService() {
		return viewFinalLevelsService;
	}

	public void setViewFinalLevelsService(
		ViewFinalLevelsService viewFinalLevelsService) {
		this.viewFinalLevelsService = viewFinalLevelsService;
	}

	public ViewFinalLevelsPersistence getViewFinalLevelsPersistence() {
		return viewFinalLevelsPersistence;
	}

	public void setViewFinalLevelsPersistence(
		ViewFinalLevelsPersistence viewFinalLevelsPersistence) {
		this.viewFinalLevelsPersistence = viewFinalLevelsPersistence;
	}

	public ViewFinalLevelsFinder getViewFinalLevelsFinder() {
		return viewFinalLevelsFinder;
	}

	public void setViewFinalLevelsFinder(
		ViewFinalLevelsFinder viewFinalLevelsFinder) {
		this.viewFinalLevelsFinder = viewFinalLevelsFinder;
	}

	public ViewFinalSlotsLocalService getViewFinalSlotsLocalService() {
		return viewFinalSlotsLocalService;
	}

	public void setViewFinalSlotsLocalService(
		ViewFinalSlotsLocalService viewFinalSlotsLocalService) {
		this.viewFinalSlotsLocalService = viewFinalSlotsLocalService;
	}

	public ViewFinalSlotsService getViewFinalSlotsService() {
		return viewFinalSlotsService;
	}

	public void setViewFinalSlotsService(
		ViewFinalSlotsService viewFinalSlotsService) {
		this.viewFinalSlotsService = viewFinalSlotsService;
	}

	public ViewFinalSlotsPersistence getViewFinalSlotsPersistence() {
		return viewFinalSlotsPersistence;
	}

	public void setViewFinalSlotsPersistence(
		ViewFinalSlotsPersistence viewFinalSlotsPersistence) {
		this.viewFinalSlotsPersistence = viewFinalSlotsPersistence;
	}

	public ViewFinalSlotsFinder getViewFinalSlotsFinder() {
		return viewFinalSlotsFinder;
	}

	public void setViewFinalSlotsFinder(
		ViewFinalSlotsFinder viewFinalSlotsFinder) {
		this.viewFinalSlotsFinder = viewFinalSlotsFinder;
	}

	public ViewFinalTitlesLocalService getViewFinalTitlesLocalService() {
		return viewFinalTitlesLocalService;
	}

	public void setViewFinalTitlesLocalService(
		ViewFinalTitlesLocalService viewFinalTitlesLocalService) {
		this.viewFinalTitlesLocalService = viewFinalTitlesLocalService;
	}

	public ViewFinalTitlesService getViewFinalTitlesService() {
		return viewFinalTitlesService;
	}

	public void setViewFinalTitlesService(
		ViewFinalTitlesService viewFinalTitlesService) {
		this.viewFinalTitlesService = viewFinalTitlesService;
	}

	public ViewFinalTitlesPersistence getViewFinalTitlesPersistence() {
		return viewFinalTitlesPersistence;
	}

	public void setViewFinalTitlesPersistence(
		ViewFinalTitlesPersistence viewFinalTitlesPersistence) {
		this.viewFinalTitlesPersistence = viewFinalTitlesPersistence;
	}

	public ViewFinalTitlesFinder getViewFinalTitlesFinder() {
		return viewFinalTitlesFinder;
	}

	public void setViewFinalTitlesFinder(
		ViewFinalTitlesFinder viewFinalTitlesFinder) {
		this.viewFinalTitlesFinder = viewFinalTitlesFinder;
	}

	public ViewSlotInformationLocalService getViewSlotInformationLocalService() {
		return viewSlotInformationLocalService;
	}

	public void setViewSlotInformationLocalService(
		ViewSlotInformationLocalService viewSlotInformationLocalService) {
		this.viewSlotInformationLocalService = viewSlotInformationLocalService;
	}

	public ViewSlotInformationService getViewSlotInformationService() {
		return viewSlotInformationService;
	}

	public void setViewSlotInformationService(
		ViewSlotInformationService viewSlotInformationService) {
		this.viewSlotInformationService = viewSlotInformationService;
	}

	public ViewSlotInformationPersistence getViewSlotInformationPersistence() {
		return viewSlotInformationPersistence;
	}

	public void setViewSlotInformationPersistence(
		ViewSlotInformationPersistence viewSlotInformationPersistence) {
		this.viewSlotInformationPersistence = viewSlotInformationPersistence;
	}

	public ViewSlotInformationFinder getViewSlotInformationFinder() {
		return viewSlotInformationFinder;
	}

	public void setViewSlotInformationFinder(
		ViewSlotInformationFinder viewSlotInformationFinder) {
		this.viewSlotInformationFinder = viewSlotInformationFinder;
	}

	public CdsPASlotsLocalService getCdsPASlotsLocalService() {
		return cdsPASlotsLocalService;
	}

	public void setCdsPASlotsLocalService(
		CdsPASlotsLocalService cdsPASlotsLocalService) {
		this.cdsPASlotsLocalService = cdsPASlotsLocalService;
	}

	public CdsPASlotsService getCdsPASlotsService() {
		return cdsPASlotsService;
	}

	public void setCdsPASlotsService(CdsPASlotsService cdsPASlotsService) {
		this.cdsPASlotsService = cdsPASlotsService;
	}

	public CdsPASlotsPersistence getCdsPASlotsPersistence() {
		return cdsPASlotsPersistence;
	}

	public void setCdsPASlotsPersistence(
		CdsPASlotsPersistence cdsPASlotsPersistence) {
		this.cdsPASlotsPersistence = cdsPASlotsPersistence;
	}

	public CdsPASlotsFinder getCdsPASlotsFinder() {
		return cdsPASlotsFinder;
	}

	public void setCdsPASlotsFinder(CdsPASlotsFinder cdsPASlotsFinder) {
		this.cdsPASlotsFinder = cdsPASlotsFinder;
	}

	public CdsPALevelsLocalService getCdsPALevelsLocalService() {
		return cdsPALevelsLocalService;
	}

	public void setCdsPALevelsLocalService(
		CdsPALevelsLocalService cdsPALevelsLocalService) {
		this.cdsPALevelsLocalService = cdsPALevelsLocalService;
	}

	public CdsPALevelsService getCdsPALevelsService() {
		return cdsPALevelsService;
	}

	public void setCdsPALevelsService(CdsPALevelsService cdsPALevelsService) {
		this.cdsPALevelsService = cdsPALevelsService;
	}

	public CdsPALevelsPersistence getCdsPALevelsPersistence() {
		return cdsPALevelsPersistence;
	}

	public void setCdsPALevelsPersistence(
		CdsPALevelsPersistence cdsPALevelsPersistence) {
		this.cdsPALevelsPersistence = cdsPALevelsPersistence;
	}

	public CdsPALevelsFinder getCdsPALevelsFinder() {
		return cdsPALevelsFinder;
	}

	public void setCdsPALevelsFinder(CdsPALevelsFinder cdsPALevelsFinder) {
		this.cdsPALevelsFinder = cdsPALevelsFinder;
	}

	public CdsPACompetenciesLocalService getCdsPACompetenciesLocalService() {
		return cdsPACompetenciesLocalService;
	}

	public void setCdsPACompetenciesLocalService(
		CdsPACompetenciesLocalService cdsPACompetenciesLocalService) {
		this.cdsPACompetenciesLocalService = cdsPACompetenciesLocalService;
	}

	public CdsPACompetenciesService getCdsPACompetenciesService() {
		return cdsPACompetenciesService;
	}

	public void setCdsPACompetenciesService(
		CdsPACompetenciesService cdsPACompetenciesService) {
		this.cdsPACompetenciesService = cdsPACompetenciesService;
	}

	public CdsPACompetenciesPersistence getCdsPACompetenciesPersistence() {
		return cdsPACompetenciesPersistence;
	}

	public void setCdsPACompetenciesPersistence(
		CdsPACompetenciesPersistence cdsPACompetenciesPersistence) {
		this.cdsPACompetenciesPersistence = cdsPACompetenciesPersistence;
	}

	public CdsPACompetenciesFinder getCdsPACompetenciesFinder() {
		return cdsPACompetenciesFinder;
	}

	public void setCdsPACompetenciesFinder(
		CdsPACompetenciesFinder cdsPACompetenciesFinder) {
		this.cdsPACompetenciesFinder = cdsPACompetenciesFinder;
	}

	public ViewPerformanceAppraisalLevelsLocalService getViewPerformanceAppraisalLevelsLocalService() {
		return viewPerformanceAppraisalLevelsLocalService;
	}

	public void setViewPerformanceAppraisalLevelsLocalService(
		ViewPerformanceAppraisalLevelsLocalService viewPerformanceAppraisalLevelsLocalService) {
		this.viewPerformanceAppraisalLevelsLocalService = viewPerformanceAppraisalLevelsLocalService;
	}

	public ViewPerformanceAppraisalLevelsService getViewPerformanceAppraisalLevelsService() {
		return viewPerformanceAppraisalLevelsService;
	}

	public void setViewPerformanceAppraisalLevelsService(
		ViewPerformanceAppraisalLevelsService viewPerformanceAppraisalLevelsService) {
		this.viewPerformanceAppraisalLevelsService = viewPerformanceAppraisalLevelsService;
	}

	public ViewPerformanceAppraisalLevelsPersistence getViewPerformanceAppraisalLevelsPersistence() {
		return viewPerformanceAppraisalLevelsPersistence;
	}

	public void setViewPerformanceAppraisalLevelsPersistence(
		ViewPerformanceAppraisalLevelsPersistence viewPerformanceAppraisalLevelsPersistence) {
		this.viewPerformanceAppraisalLevelsPersistence = viewPerformanceAppraisalLevelsPersistence;
	}

	public ViewPerformanceAppraisalLevelsFinder getViewPerformanceAppraisalLevelsFinder() {
		return viewPerformanceAppraisalLevelsFinder;
	}

	public void setViewPerformanceAppraisalLevelsFinder(
		ViewPerformanceAppraisalLevelsFinder viewPerformanceAppraisalLevelsFinder) {
		this.viewPerformanceAppraisalLevelsFinder = viewPerformanceAppraisalLevelsFinder;
	}

	public ViewPerformanceAppraisalSlotsLocalService getViewPerformanceAppraisalSlotsLocalService() {
		return viewPerformanceAppraisalSlotsLocalService;
	}

	public void setViewPerformanceAppraisalSlotsLocalService(
		ViewPerformanceAppraisalSlotsLocalService viewPerformanceAppraisalSlotsLocalService) {
		this.viewPerformanceAppraisalSlotsLocalService = viewPerformanceAppraisalSlotsLocalService;
	}

	public ViewPerformanceAppraisalSlotsService getViewPerformanceAppraisalSlotsService() {
		return viewPerformanceAppraisalSlotsService;
	}

	public void setViewPerformanceAppraisalSlotsService(
		ViewPerformanceAppraisalSlotsService viewPerformanceAppraisalSlotsService) {
		this.viewPerformanceAppraisalSlotsService = viewPerformanceAppraisalSlotsService;
	}

	public ViewPerformanceAppraisalSlotsPersistence getViewPerformanceAppraisalSlotsPersistence() {
		return viewPerformanceAppraisalSlotsPersistence;
	}

	public void setViewPerformanceAppraisalSlotsPersistence(
		ViewPerformanceAppraisalSlotsPersistence viewPerformanceAppraisalSlotsPersistence) {
		this.viewPerformanceAppraisalSlotsPersistence = viewPerformanceAppraisalSlotsPersistence;
	}

	public ViewPerformanceAppraisalSlotsFinder getViewPerformanceAppraisalSlotsFinder() {
		return viewPerformanceAppraisalSlotsFinder;
	}

	public void setViewPerformanceAppraisalSlotsFinder(
		ViewPerformanceAppraisalSlotsFinder viewPerformanceAppraisalSlotsFinder) {
		this.viewPerformanceAppraisalSlotsFinder = viewPerformanceAppraisalSlotsFinder;
	}

	public CdsPerformanceAppraisalSlotRatingLocalService getCdsPerformanceAppraisalSlotRatingLocalService() {
		return cdsPerformanceAppraisalSlotRatingLocalService;
	}

	public void setCdsPerformanceAppraisalSlotRatingLocalService(
		CdsPerformanceAppraisalSlotRatingLocalService cdsPerformanceAppraisalSlotRatingLocalService) {
		this.cdsPerformanceAppraisalSlotRatingLocalService = cdsPerformanceAppraisalSlotRatingLocalService;
	}

	public CdsPerformanceAppraisalSlotRatingService getCdsPerformanceAppraisalSlotRatingService() {
		return cdsPerformanceAppraisalSlotRatingService;
	}

	public void setCdsPerformanceAppraisalSlotRatingService(
		CdsPerformanceAppraisalSlotRatingService cdsPerformanceAppraisalSlotRatingService) {
		this.cdsPerformanceAppraisalSlotRatingService = cdsPerformanceAppraisalSlotRatingService;
	}

	public CdsPerformanceAppraisalSlotRatingPersistence getCdsPerformanceAppraisalSlotRatingPersistence() {
		return cdsPerformanceAppraisalSlotRatingPersistence;
	}

	public void setCdsPerformanceAppraisalSlotRatingPersistence(
		CdsPerformanceAppraisalSlotRatingPersistence cdsPerformanceAppraisalSlotRatingPersistence) {
		this.cdsPerformanceAppraisalSlotRatingPersistence = cdsPerformanceAppraisalSlotRatingPersistence;
	}

	public CdsPerformanceAppraisalSlotRatingFinder getCdsPerformanceAppraisalSlotRatingFinder() {
		return cdsPerformanceAppraisalSlotRatingFinder;
	}

	public void setCdsPerformanceAppraisalSlotRatingFinder(
		CdsPerformanceAppraisalSlotRatingFinder cdsPerformanceAppraisalSlotRatingFinder) {
		this.cdsPerformanceAppraisalSlotRatingFinder = cdsPerformanceAppraisalSlotRatingFinder;
	}

	public CdsPerformanceAppraisalSlotCommentsLocalService getCdsPerformanceAppraisalSlotCommentsLocalService() {
		return cdsPerformanceAppraisalSlotCommentsLocalService;
	}

	public void setCdsPerformanceAppraisalSlotCommentsLocalService(
		CdsPerformanceAppraisalSlotCommentsLocalService cdsPerformanceAppraisalSlotCommentsLocalService) {
		this.cdsPerformanceAppraisalSlotCommentsLocalService = cdsPerformanceAppraisalSlotCommentsLocalService;
	}

	public CdsPerformanceAppraisalSlotCommentsService getCdsPerformanceAppraisalSlotCommentsService() {
		return cdsPerformanceAppraisalSlotCommentsService;
	}

	public void setCdsPerformanceAppraisalSlotCommentsService(
		CdsPerformanceAppraisalSlotCommentsService cdsPerformanceAppraisalSlotCommentsService) {
		this.cdsPerformanceAppraisalSlotCommentsService = cdsPerformanceAppraisalSlotCommentsService;
	}

	public CdsPerformanceAppraisalSlotCommentsPersistence getCdsPerformanceAppraisalSlotCommentsPersistence() {
		return cdsPerformanceAppraisalSlotCommentsPersistence;
	}

	public void setCdsPerformanceAppraisalSlotCommentsPersistence(
		CdsPerformanceAppraisalSlotCommentsPersistence cdsPerformanceAppraisalSlotCommentsPersistence) {
		this.cdsPerformanceAppraisalSlotCommentsPersistence = cdsPerformanceAppraisalSlotCommentsPersistence;
	}

	public CdsPerformanceAppraisalSlotCommentsFinder getCdsPerformanceAppraisalSlotCommentsFinder() {
		return cdsPerformanceAppraisalSlotCommentsFinder;
	}

	public void setCdsPerformanceAppraisalSlotCommentsFinder(
		CdsPerformanceAppraisalSlotCommentsFinder cdsPerformanceAppraisalSlotCommentsFinder) {
		this.cdsPerformanceAppraisalSlotCommentsFinder = cdsPerformanceAppraisalSlotCommentsFinder;
	}

	public CdsPerformanceAppraisalsLocalService getCdsPerformanceAppraisalsLocalService() {
		return cdsPerformanceAppraisalsLocalService;
	}

	public void setCdsPerformanceAppraisalsLocalService(
		CdsPerformanceAppraisalsLocalService cdsPerformanceAppraisalsLocalService) {
		this.cdsPerformanceAppraisalsLocalService = cdsPerformanceAppraisalsLocalService;
	}

	public CdsPerformanceAppraisalsService getCdsPerformanceAppraisalsService() {
		return cdsPerformanceAppraisalsService;
	}

	public void setCdsPerformanceAppraisalsService(
		CdsPerformanceAppraisalsService cdsPerformanceAppraisalsService) {
		this.cdsPerformanceAppraisalsService = cdsPerformanceAppraisalsService;
	}

	public CdsPerformanceAppraisalsPersistence getCdsPerformanceAppraisalsPersistence() {
		return cdsPerformanceAppraisalsPersistence;
	}

	public void setCdsPerformanceAppraisalsPersistence(
		CdsPerformanceAppraisalsPersistence cdsPerformanceAppraisalsPersistence) {
		this.cdsPerformanceAppraisalsPersistence = cdsPerformanceAppraisalsPersistence;
	}

	public CdsPerformanceAppraisalsFinder getCdsPerformanceAppraisalsFinder() {
		return cdsPerformanceAppraisalsFinder;
	}

	public void setCdsPerformanceAppraisalsFinder(
		CdsPerformanceAppraisalsFinder cdsPerformanceAppraisalsFinder) {
		this.cdsPerformanceAppraisalsFinder = cdsPerformanceAppraisalsFinder;
	}

	public ViewEmployeesInProjectsLocalService getViewEmployeesInProjectsLocalService() {
		return viewEmployeesInProjectsLocalService;
	}

	public void setViewEmployeesInProjectsLocalService(
		ViewEmployeesInProjectsLocalService viewEmployeesInProjectsLocalService) {
		this.viewEmployeesInProjectsLocalService = viewEmployeesInProjectsLocalService;
	}

	public ViewEmployeesInProjectsService getViewEmployeesInProjectsService() {
		return viewEmployeesInProjectsService;
	}

	public void setViewEmployeesInProjectsService(
		ViewEmployeesInProjectsService viewEmployeesInProjectsService) {
		this.viewEmployeesInProjectsService = viewEmployeesInProjectsService;
	}

	public ViewEmployeesInProjectsPersistence getViewEmployeesInProjectsPersistence() {
		return viewEmployeesInProjectsPersistence;
	}

	public void setViewEmployeesInProjectsPersistence(
		ViewEmployeesInProjectsPersistence viewEmployeesInProjectsPersistence) {
		this.viewEmployeesInProjectsPersistence = viewEmployeesInProjectsPersistence;
	}

	public ViewEmployeesInProjectsFinder getViewEmployeesInProjectsFinder() {
		return viewEmployeesInProjectsFinder;
	}

	public void setViewEmployeesInProjectsFinder(
		ViewEmployeesInProjectsFinder viewEmployeesInProjectsFinder) {
		this.viewEmployeesInProjectsFinder = viewEmployeesInProjectsFinder;
	}

	public ViewEmployeesSlotsRatingLocalService getViewEmployeesSlotsRatingLocalService() {
		return viewEmployeesSlotsRatingLocalService;
	}

	public void setViewEmployeesSlotsRatingLocalService(
		ViewEmployeesSlotsRatingLocalService viewEmployeesSlotsRatingLocalService) {
		this.viewEmployeesSlotsRatingLocalService = viewEmployeesSlotsRatingLocalService;
	}

	public ViewEmployeesSlotsRatingService getViewEmployeesSlotsRatingService() {
		return viewEmployeesSlotsRatingService;
	}

	public void setViewEmployeesSlotsRatingService(
		ViewEmployeesSlotsRatingService viewEmployeesSlotsRatingService) {
		this.viewEmployeesSlotsRatingService = viewEmployeesSlotsRatingService;
	}

	public ViewEmployeesSlotsRatingPersistence getViewEmployeesSlotsRatingPersistence() {
		return viewEmployeesSlotsRatingPersistence;
	}

	public void setViewEmployeesSlotsRatingPersistence(
		ViewEmployeesSlotsRatingPersistence viewEmployeesSlotsRatingPersistence) {
		this.viewEmployeesSlotsRatingPersistence = viewEmployeesSlotsRatingPersistence;
	}

	public ViewEmployeesSlotsRatingFinder getViewEmployeesSlotsRatingFinder() {
		return viewEmployeesSlotsRatingFinder;
	}

	public void setViewEmployeesSlotsRatingFinder(
		ViewEmployeesSlotsRatingFinder viewEmployeesSlotsRatingFinder) {
		this.viewEmployeesSlotsRatingFinder = viewEmployeesSlotsRatingFinder;
	}

	public CdsSlotStatisticalReportLocalService getCdsSlotStatisticalReportLocalService() {
		return cdsSlotStatisticalReportLocalService;
	}

	public void setCdsSlotStatisticalReportLocalService(
		CdsSlotStatisticalReportLocalService cdsSlotStatisticalReportLocalService) {
		this.cdsSlotStatisticalReportLocalService = cdsSlotStatisticalReportLocalService;
	}

	public CdsSlotStatisticalReportService getCdsSlotStatisticalReportService() {
		return cdsSlotStatisticalReportService;
	}

	public void setCdsSlotStatisticalReportService(
		CdsSlotStatisticalReportService cdsSlotStatisticalReportService) {
		this.cdsSlotStatisticalReportService = cdsSlotStatisticalReportService;
	}

	public CdsSlotStatisticalReportPersistence getCdsSlotStatisticalReportPersistence() {
		return cdsSlotStatisticalReportPersistence;
	}

	public void setCdsSlotStatisticalReportPersistence(
		CdsSlotStatisticalReportPersistence cdsSlotStatisticalReportPersistence) {
		this.cdsSlotStatisticalReportPersistence = cdsSlotStatisticalReportPersistence;
	}

	public CdsSlotStatisticalReportFinder getCdsSlotStatisticalReportFinder() {
		return cdsSlotStatisticalReportFinder;
	}

	public void setCdsSlotStatisticalReportFinder(
		CdsSlotStatisticalReportFinder cdsSlotStatisticalReportFinder) {
		this.cdsSlotStatisticalReportFinder = cdsSlotStatisticalReportFinder;
	}

	public CdsLevelStatisticalReportLocalService getCdsLevelStatisticalReportLocalService() {
		return cdsLevelStatisticalReportLocalService;
	}

	public void setCdsLevelStatisticalReportLocalService(
		CdsLevelStatisticalReportLocalService cdsLevelStatisticalReportLocalService) {
		this.cdsLevelStatisticalReportLocalService = cdsLevelStatisticalReportLocalService;
	}

	public CdsLevelStatisticalReportService getCdsLevelStatisticalReportService() {
		return cdsLevelStatisticalReportService;
	}

	public void setCdsLevelStatisticalReportService(
		CdsLevelStatisticalReportService cdsLevelStatisticalReportService) {
		this.cdsLevelStatisticalReportService = cdsLevelStatisticalReportService;
	}

	public CdsLevelStatisticalReportPersistence getCdsLevelStatisticalReportPersistence() {
		return cdsLevelStatisticalReportPersistence;
	}

	public void setCdsLevelStatisticalReportPersistence(
		CdsLevelStatisticalReportPersistence cdsLevelStatisticalReportPersistence) {
		this.cdsLevelStatisticalReportPersistence = cdsLevelStatisticalReportPersistence;
	}

	public CdsLevelStatisticalReportFinder getCdsLevelStatisticalReportFinder() {
		return cdsLevelStatisticalReportFinder;
	}

	public void setCdsLevelStatisticalReportFinder(
		CdsLevelStatisticalReportFinder cdsLevelStatisticalReportFinder) {
		this.cdsLevelStatisticalReportFinder = cdsLevelStatisticalReportFinder;
	}

	public CdsCompetencyStatisticalReportLocalService getCdsCompetencyStatisticalReportLocalService() {
		return cdsCompetencyStatisticalReportLocalService;
	}

	public void setCdsCompetencyStatisticalReportLocalService(
		CdsCompetencyStatisticalReportLocalService cdsCompetencyStatisticalReportLocalService) {
		this.cdsCompetencyStatisticalReportLocalService = cdsCompetencyStatisticalReportLocalService;
	}

	public CdsCompetencyStatisticalReportService getCdsCompetencyStatisticalReportService() {
		return cdsCompetencyStatisticalReportService;
	}

	public void setCdsCompetencyStatisticalReportService(
		CdsCompetencyStatisticalReportService cdsCompetencyStatisticalReportService) {
		this.cdsCompetencyStatisticalReportService = cdsCompetencyStatisticalReportService;
	}

	public CdsCompetencyStatisticalReportPersistence getCdsCompetencyStatisticalReportPersistence() {
		return cdsCompetencyStatisticalReportPersistence;
	}

	public void setCdsCompetencyStatisticalReportPersistence(
		CdsCompetencyStatisticalReportPersistence cdsCompetencyStatisticalReportPersistence) {
		this.cdsCompetencyStatisticalReportPersistence = cdsCompetencyStatisticalReportPersistence;
	}

	public CdsCompetencyStatisticalReportFinder getCdsCompetencyStatisticalReportFinder() {
		return cdsCompetencyStatisticalReportFinder;
	}

	public void setCdsCompetencyStatisticalReportFinder(
		CdsCompetencyStatisticalReportFinder cdsCompetencyStatisticalReportFinder) {
		this.cdsCompetencyStatisticalReportFinder = cdsCompetencyStatisticalReportFinder;
	}

	public CdsCdpLocalService getCdsCdpLocalService() {
		return cdsCdpLocalService;
	}

	public void setCdsCdpLocalService(CdsCdpLocalService cdsCdpLocalService) {
		this.cdsCdpLocalService = cdsCdpLocalService;
	}

	public CdsCdpService getCdsCdpService() {
		return cdsCdpService;
	}

	public void setCdsCdpService(CdsCdpService cdsCdpService) {
		this.cdsCdpService = cdsCdpService;
	}

	public CdsCdpPersistence getCdsCdpPersistence() {
		return cdsCdpPersistence;
	}

	public void setCdsCdpPersistence(CdsCdpPersistence cdsCdpPersistence) {
		this.cdsCdpPersistence = cdsCdpPersistence;
	}

	public CdsCdpFinder getCdsCdpFinder() {
		return cdsCdpFinder;
	}

	public void setCdsCdpFinder(CdsCdpFinder cdsCdpFinder) {
		this.cdsCdpFinder = cdsCdpFinder;
	}

	public CdsPAFinalLocalService getCdsPAFinalLocalService() {
		return cdsPAFinalLocalService;
	}

	public void setCdsPAFinalLocalService(
		CdsPAFinalLocalService cdsPAFinalLocalService) {
		this.cdsPAFinalLocalService = cdsPAFinalLocalService;
	}

	public CdsPAFinalService getCdsPAFinalService() {
		return cdsPAFinalService;
	}

	public void setCdsPAFinalService(CdsPAFinalService cdsPAFinalService) {
		this.cdsPAFinalService = cdsPAFinalService;
	}

	public CdsPAFinalPersistence getCdsPAFinalPersistence() {
		return cdsPAFinalPersistence;
	}

	public void setCdsPAFinalPersistence(
		CdsPAFinalPersistence cdsPAFinalPersistence) {
		this.cdsPAFinalPersistence = cdsPAFinalPersistence;
	}

	protected void runSQL(String sql) throws SystemException {
		try {
			PortalUtil.runSQL(sql);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(name = "larion.progate.cds.service.CompetencyLocalService.impl")
	protected CompetencyLocalService competencyLocalService;
	@BeanReference(name = "larion.progate.cds.service.CompetencyService.impl")
	protected CompetencyService competencyService;
	@BeanReference(name = "larion.progate.cds.service.persistence.CompetencyPersistence.impl")
	protected CompetencyPersistence competencyPersistence;
	@BeanReference(name = "larion.progate.cds.service.LevelLocalService.impl")
	protected LevelLocalService levelLocalService;
	@BeanReference(name = "larion.progate.cds.service.LevelService.impl")
	protected LevelService levelService;
	@BeanReference(name = "larion.progate.cds.service.persistence.LevelPersistence.impl")
	protected LevelPersistence levelPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.LevelFinder.impl")
	protected LevelFinder levelFinder;
	@BeanReference(name = "larion.progate.cds.service.SlotLocalService.impl")
	protected SlotLocalService slotLocalService;
	@BeanReference(name = "larion.progate.cds.service.SlotService.impl")
	protected SlotService slotService;
	@BeanReference(name = "larion.progate.cds.service.persistence.SlotPersistence.impl")
	protected SlotPersistence slotPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.SlotFinder.impl")
	protected SlotFinder slotFinder;
	@BeanReference(name = "larion.progate.cds.service.CdsPointsLocalService.impl")
	protected CdsPointsLocalService cdsPointsLocalService;
	@BeanReference(name = "larion.progate.cds.service.CdsPointsService.impl")
	protected CdsPointsService cdsPointsService;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPointsPersistence.impl")
	protected CdsPointsPersistence cdsPointsPersistence;
	@BeanReference(name = "larion.progate.cds.service.CdsEvaluationPeriodsLocalService.impl")
	protected CdsEvaluationPeriodsLocalService cdsEvaluationPeriodsLocalService;
	@BeanReference(name = "larion.progate.cds.service.CdsEvaluationPeriodsService.impl")
	protected CdsEvaluationPeriodsService cdsEvaluationPeriodsService;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsEvaluationPeriodsPersistence.impl")
	protected CdsEvaluationPeriodsPersistence cdsEvaluationPeriodsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsEvaluationPeriodsFinder.impl")
	protected CdsEvaluationPeriodsFinder cdsEvaluationPeriodsFinder;
	@BeanReference(name = "larion.progate.cds.service.CdsTitlesLocalService.impl")
	protected CdsTitlesLocalService cdsTitlesLocalService;
	@BeanReference(name = "larion.progate.cds.service.CdsTitlesService.impl")
	protected CdsTitlesService cdsTitlesService;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsTitlesPersistence.impl")
	protected CdsTitlesPersistence cdsTitlesPersistence;
	@BeanReference(name = "larion.progate.cds.service.CdsTitleCompetenciesLocalService.impl")
	protected CdsTitleCompetenciesLocalService cdsTitleCompetenciesLocalService;
	@BeanReference(name = "larion.progate.cds.service.CdsTitleCompetenciesService.impl")
	protected CdsTitleCompetenciesService cdsTitleCompetenciesService;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsTitleCompetenciesPersistence.impl")
	protected CdsTitleCompetenciesPersistence cdsTitleCompetenciesPersistence;
	@BeanReference(name = "larion.progate.cds.service.CdsMinimumRequirementsLocalService.impl")
	protected CdsMinimumRequirementsLocalService cdsMinimumRequirementsLocalService;
	@BeanReference(name = "larion.progate.cds.service.CdsMinimumRequirementsService.impl")
	protected CdsMinimumRequirementsService cdsMinimumRequirementsService;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsMinimumRequirementsPersistence.impl")
	protected CdsMinimumRequirementsPersistence cdsMinimumRequirementsPersistence;
	@BeanReference(name = "larion.progate.cds.service.CdsTitleMinimumRequirementsLocalService.impl")
	protected CdsTitleMinimumRequirementsLocalService cdsTitleMinimumRequirementsLocalService;
	@BeanReference(name = "larion.progate.cds.service.CdsTitleMinimumRequirementsService.impl")
	protected CdsTitleMinimumRequirementsService cdsTitleMinimumRequirementsService;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsTitleMinimumRequirementsPersistence.impl")
	protected CdsTitleMinimumRequirementsPersistence cdsTitleMinimumRequirementsPersistence;
	@BeanReference(name = "larion.progate.cds.service.CdsMinimumRequirementLevelsLocalService.impl")
	protected CdsMinimumRequirementLevelsLocalService cdsMinimumRequirementLevelsLocalService;
	@BeanReference(name = "larion.progate.cds.service.CdsMinimumRequirementLevelsService.impl")
	protected CdsMinimumRequirementLevelsService cdsMinimumRequirementLevelsService;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsMinimumRequirementLevelsPersistence.impl")
	protected CdsMinimumRequirementLevelsPersistence cdsMinimumRequirementLevelsPersistence;
	@BeanReference(name = "larion.progate.cds.service.ViewListTitleCompetenciesLocalService.impl")
	protected ViewListTitleCompetenciesLocalService viewListTitleCompetenciesLocalService;
	@BeanReference(name = "larion.progate.cds.service.ViewListTitleCompetenciesService.impl")
	protected ViewListTitleCompetenciesService viewListTitleCompetenciesService;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewListTitleCompetenciesPersistence.impl")
	protected ViewListTitleCompetenciesPersistence viewListTitleCompetenciesPersistence;
	@BeanReference(name = "larion.progate.cds.service.ViewListTitleMinimumRequirementsLocalService.impl")
	protected ViewListTitleMinimumRequirementsLocalService viewListTitleMinimumRequirementsLocalService;
	@BeanReference(name = "larion.progate.cds.service.ViewListTitleMinimumRequirementsService.impl")
	protected ViewListTitleMinimumRequirementsService viewListTitleMinimumRequirementsService;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewListTitleMinimumRequirementsPersistence.impl")
	protected ViewListTitleMinimumRequirementsPersistence viewListTitleMinimumRequirementsPersistence;
	@BeanReference(name = "larion.progate.cds.service.CdsPAFinalCompeteniesLocalService.impl")
	protected CdsPAFinalCompeteniesLocalService cdsPAFinalCompeteniesLocalService;
	@BeanReference(name = "larion.progate.cds.service.CdsPAFinalCompeteniesService.impl")
	protected CdsPAFinalCompeteniesService cdsPAFinalCompeteniesService;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPAFinalCompeteniesPersistence.impl")
	protected CdsPAFinalCompeteniesPersistence cdsPAFinalCompeteniesPersistence;
	@BeanReference(name = "larion.progate.cds.service.CdsPAFinalLevelsLocalService.impl")
	protected CdsPAFinalLevelsLocalService cdsPAFinalLevelsLocalService;
	@BeanReference(name = "larion.progate.cds.service.CdsPAFinalLevelsService.impl")
	protected CdsPAFinalLevelsService cdsPAFinalLevelsService;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPAFinalLevelsPersistence.impl")
	protected CdsPAFinalLevelsPersistence cdsPAFinalLevelsPersistence;
	@BeanReference(name = "larion.progate.cds.service.CdsPAFinalSlotsLocalService.impl")
	protected CdsPAFinalSlotsLocalService cdsPAFinalSlotsLocalService;
	@BeanReference(name = "larion.progate.cds.service.CdsPAFinalSlotsService.impl")
	protected CdsPAFinalSlotsService cdsPAFinalSlotsService;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPAFinalSlotsPersistence.impl")
	protected CdsPAFinalSlotsPersistence cdsPAFinalSlotsPersistence;
	@BeanReference(name = "larion.progate.cds.service.ViewFinalCompetenciesLocalService.impl")
	protected ViewFinalCompetenciesLocalService viewFinalCompetenciesLocalService;
	@BeanReference(name = "larion.progate.cds.service.ViewFinalCompetenciesService.impl")
	protected ViewFinalCompetenciesService viewFinalCompetenciesService;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewFinalCompetenciesPersistence.impl")
	protected ViewFinalCompetenciesPersistence viewFinalCompetenciesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewFinalCompetenciesFinder.impl")
	protected ViewFinalCompetenciesFinder viewFinalCompetenciesFinder;
	@BeanReference(name = "larion.progate.cds.service.ViewFinalLevelsLocalService.impl")
	protected ViewFinalLevelsLocalService viewFinalLevelsLocalService;
	@BeanReference(name = "larion.progate.cds.service.ViewFinalLevelsService.impl")
	protected ViewFinalLevelsService viewFinalLevelsService;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewFinalLevelsPersistence.impl")
	protected ViewFinalLevelsPersistence viewFinalLevelsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewFinalLevelsFinder.impl")
	protected ViewFinalLevelsFinder viewFinalLevelsFinder;
	@BeanReference(name = "larion.progate.cds.service.ViewFinalSlotsLocalService.impl")
	protected ViewFinalSlotsLocalService viewFinalSlotsLocalService;
	@BeanReference(name = "larion.progate.cds.service.ViewFinalSlotsService.impl")
	protected ViewFinalSlotsService viewFinalSlotsService;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewFinalSlotsPersistence.impl")
	protected ViewFinalSlotsPersistence viewFinalSlotsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewFinalSlotsFinder.impl")
	protected ViewFinalSlotsFinder viewFinalSlotsFinder;
	@BeanReference(name = "larion.progate.cds.service.ViewFinalTitlesLocalService.impl")
	protected ViewFinalTitlesLocalService viewFinalTitlesLocalService;
	@BeanReference(name = "larion.progate.cds.service.ViewFinalTitlesService.impl")
	protected ViewFinalTitlesService viewFinalTitlesService;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewFinalTitlesPersistence.impl")
	protected ViewFinalTitlesPersistence viewFinalTitlesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewFinalTitlesFinder.impl")
	protected ViewFinalTitlesFinder viewFinalTitlesFinder;
	@BeanReference(name = "larion.progate.cds.service.ViewSlotInformationLocalService.impl")
	protected ViewSlotInformationLocalService viewSlotInformationLocalService;
	@BeanReference(name = "larion.progate.cds.service.ViewSlotInformationService.impl")
	protected ViewSlotInformationService viewSlotInformationService;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewSlotInformationPersistence.impl")
	protected ViewSlotInformationPersistence viewSlotInformationPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewSlotInformationFinder.impl")
	protected ViewSlotInformationFinder viewSlotInformationFinder;
	@BeanReference(name = "larion.progate.cds.service.CdsPASlotsLocalService.impl")
	protected CdsPASlotsLocalService cdsPASlotsLocalService;
	@BeanReference(name = "larion.progate.cds.service.CdsPASlotsService.impl")
	protected CdsPASlotsService cdsPASlotsService;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPASlotsPersistence.impl")
	protected CdsPASlotsPersistence cdsPASlotsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPASlotsFinder.impl")
	protected CdsPASlotsFinder cdsPASlotsFinder;
	@BeanReference(name = "larion.progate.cds.service.CdsPALevelsLocalService.impl")
	protected CdsPALevelsLocalService cdsPALevelsLocalService;
	@BeanReference(name = "larion.progate.cds.service.CdsPALevelsService.impl")
	protected CdsPALevelsService cdsPALevelsService;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPALevelsPersistence.impl")
	protected CdsPALevelsPersistence cdsPALevelsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPALevelsFinder.impl")
	protected CdsPALevelsFinder cdsPALevelsFinder;
	@BeanReference(name = "larion.progate.cds.service.CdsPACompetenciesLocalService.impl")
	protected CdsPACompetenciesLocalService cdsPACompetenciesLocalService;
	@BeanReference(name = "larion.progate.cds.service.CdsPACompetenciesService.impl")
	protected CdsPACompetenciesService cdsPACompetenciesService;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPACompetenciesPersistence.impl")
	protected CdsPACompetenciesPersistence cdsPACompetenciesPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPACompetenciesFinder.impl")
	protected CdsPACompetenciesFinder cdsPACompetenciesFinder;
	@BeanReference(name = "larion.progate.cds.service.ViewPerformanceAppraisalLevelsLocalService.impl")
	protected ViewPerformanceAppraisalLevelsLocalService viewPerformanceAppraisalLevelsLocalService;
	@BeanReference(name = "larion.progate.cds.service.ViewPerformanceAppraisalLevelsService.impl")
	protected ViewPerformanceAppraisalLevelsService viewPerformanceAppraisalLevelsService;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewPerformanceAppraisalLevelsPersistence.impl")
	protected ViewPerformanceAppraisalLevelsPersistence viewPerformanceAppraisalLevelsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewPerformanceAppraisalLevelsFinder.impl")
	protected ViewPerformanceAppraisalLevelsFinder viewPerformanceAppraisalLevelsFinder;
	@BeanReference(name = "larion.progate.cds.service.ViewPerformanceAppraisalSlotsLocalService.impl")
	protected ViewPerformanceAppraisalSlotsLocalService viewPerformanceAppraisalSlotsLocalService;
	@BeanReference(name = "larion.progate.cds.service.ViewPerformanceAppraisalSlotsService.impl")
	protected ViewPerformanceAppraisalSlotsService viewPerformanceAppraisalSlotsService;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewPerformanceAppraisalSlotsPersistence.impl")
	protected ViewPerformanceAppraisalSlotsPersistence viewPerformanceAppraisalSlotsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewPerformanceAppraisalSlotsFinder.impl")
	protected ViewPerformanceAppraisalSlotsFinder viewPerformanceAppraisalSlotsFinder;
	@BeanReference(name = "larion.progate.cds.service.CdsPerformanceAppraisalSlotRatingLocalService.impl")
	protected CdsPerformanceAppraisalSlotRatingLocalService cdsPerformanceAppraisalSlotRatingLocalService;
	@BeanReference(name = "larion.progate.cds.service.CdsPerformanceAppraisalSlotRatingService.impl")
	protected CdsPerformanceAppraisalSlotRatingService cdsPerformanceAppraisalSlotRatingService;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPerformanceAppraisalSlotRatingPersistence.impl")
	protected CdsPerformanceAppraisalSlotRatingPersistence cdsPerformanceAppraisalSlotRatingPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPerformanceAppraisalSlotRatingFinder.impl")
	protected CdsPerformanceAppraisalSlotRatingFinder cdsPerformanceAppraisalSlotRatingFinder;
	@BeanReference(name = "larion.progate.cds.service.CdsPerformanceAppraisalSlotCommentsLocalService.impl")
	protected CdsPerformanceAppraisalSlotCommentsLocalService cdsPerformanceAppraisalSlotCommentsLocalService;
	@BeanReference(name = "larion.progate.cds.service.CdsPerformanceAppraisalSlotCommentsService.impl")
	protected CdsPerformanceAppraisalSlotCommentsService cdsPerformanceAppraisalSlotCommentsService;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPerformanceAppraisalSlotCommentsPersistence.impl")
	protected CdsPerformanceAppraisalSlotCommentsPersistence cdsPerformanceAppraisalSlotCommentsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPerformanceAppraisalSlotCommentsFinder.impl")
	protected CdsPerformanceAppraisalSlotCommentsFinder cdsPerformanceAppraisalSlotCommentsFinder;
	@BeanReference(name = "larion.progate.cds.service.CdsPerformanceAppraisalsLocalService.impl")
	protected CdsPerformanceAppraisalsLocalService cdsPerformanceAppraisalsLocalService;
	@BeanReference(name = "larion.progate.cds.service.CdsPerformanceAppraisalsService.impl")
	protected CdsPerformanceAppraisalsService cdsPerformanceAppraisalsService;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPerformanceAppraisalsPersistence.impl")
	protected CdsPerformanceAppraisalsPersistence cdsPerformanceAppraisalsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPerformanceAppraisalsFinder.impl")
	protected CdsPerformanceAppraisalsFinder cdsPerformanceAppraisalsFinder;
	@BeanReference(name = "larion.progate.cds.service.ViewEmployeesInProjectsLocalService.impl")
	protected ViewEmployeesInProjectsLocalService viewEmployeesInProjectsLocalService;
	@BeanReference(name = "larion.progate.cds.service.ViewEmployeesInProjectsService.impl")
	protected ViewEmployeesInProjectsService viewEmployeesInProjectsService;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewEmployeesInProjectsPersistence.impl")
	protected ViewEmployeesInProjectsPersistence viewEmployeesInProjectsPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewEmployeesInProjectsFinder.impl")
	protected ViewEmployeesInProjectsFinder viewEmployeesInProjectsFinder;
	@BeanReference(name = "larion.progate.cds.service.ViewEmployeesSlotsRatingLocalService.impl")
	protected ViewEmployeesSlotsRatingLocalService viewEmployeesSlotsRatingLocalService;
	@BeanReference(name = "larion.progate.cds.service.ViewEmployeesSlotsRatingService.impl")
	protected ViewEmployeesSlotsRatingService viewEmployeesSlotsRatingService;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewEmployeesSlotsRatingPersistence.impl")
	protected ViewEmployeesSlotsRatingPersistence viewEmployeesSlotsRatingPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.ViewEmployeesSlotsRatingFinder.impl")
	protected ViewEmployeesSlotsRatingFinder viewEmployeesSlotsRatingFinder;
	@BeanReference(name = "larion.progate.cds.service.CdsSlotStatisticalReportLocalService.impl")
	protected CdsSlotStatisticalReportLocalService cdsSlotStatisticalReportLocalService;
	@BeanReference(name = "larion.progate.cds.service.CdsSlotStatisticalReportService.impl")
	protected CdsSlotStatisticalReportService cdsSlotStatisticalReportService;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsSlotStatisticalReportPersistence.impl")
	protected CdsSlotStatisticalReportPersistence cdsSlotStatisticalReportPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsSlotStatisticalReportFinder.impl")
	protected CdsSlotStatisticalReportFinder cdsSlotStatisticalReportFinder;
	@BeanReference(name = "larion.progate.cds.service.CdsLevelStatisticalReportLocalService.impl")
	protected CdsLevelStatisticalReportLocalService cdsLevelStatisticalReportLocalService;
	@BeanReference(name = "larion.progate.cds.service.CdsLevelStatisticalReportService.impl")
	protected CdsLevelStatisticalReportService cdsLevelStatisticalReportService;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsLevelStatisticalReportPersistence.impl")
	protected CdsLevelStatisticalReportPersistence cdsLevelStatisticalReportPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsLevelStatisticalReportFinder.impl")
	protected CdsLevelStatisticalReportFinder cdsLevelStatisticalReportFinder;
	@BeanReference(name = "larion.progate.cds.service.CdsCompetencyStatisticalReportLocalService.impl")
	protected CdsCompetencyStatisticalReportLocalService cdsCompetencyStatisticalReportLocalService;
	@BeanReference(name = "larion.progate.cds.service.CdsCompetencyStatisticalReportService.impl")
	protected CdsCompetencyStatisticalReportService cdsCompetencyStatisticalReportService;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsCompetencyStatisticalReportPersistence.impl")
	protected CdsCompetencyStatisticalReportPersistence cdsCompetencyStatisticalReportPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsCompetencyStatisticalReportFinder.impl")
	protected CdsCompetencyStatisticalReportFinder cdsCompetencyStatisticalReportFinder;
	@BeanReference(name = "larion.progate.cds.service.CdsCdpLocalService.impl")
	protected CdsCdpLocalService cdsCdpLocalService;
	@BeanReference(name = "larion.progate.cds.service.CdsCdpService.impl")
	protected CdsCdpService cdsCdpService;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsCdpPersistence.impl")
	protected CdsCdpPersistence cdsCdpPersistence;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsCdpFinder.impl")
	protected CdsCdpFinder cdsCdpFinder;
	@BeanReference(name = "larion.progate.cds.service.CdsPAFinalLocalService.impl")
	protected CdsPAFinalLocalService cdsPAFinalLocalService;
	@BeanReference(name = "larion.progate.cds.service.CdsPAFinalService.impl")
	protected CdsPAFinalService cdsPAFinalService;
	@BeanReference(name = "larion.progate.cds.service.persistence.CdsPAFinalPersistence.impl")
	protected CdsPAFinalPersistence cdsPAFinalPersistence;
}