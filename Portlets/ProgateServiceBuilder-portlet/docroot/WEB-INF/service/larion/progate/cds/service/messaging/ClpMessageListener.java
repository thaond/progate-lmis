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

package larion.progate.cds.service.messaging;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;

import larion.progate.cds.service.CdsCdpLocalServiceUtil;
import larion.progate.cds.service.CdsCdpServiceUtil;
import larion.progate.cds.service.CdsCompetencyStatisticalReportLocalServiceUtil;
import larion.progate.cds.service.CdsCompetencyStatisticalReportServiceUtil;
import larion.progate.cds.service.CdsEvaluationPeriodsLocalServiceUtil;
import larion.progate.cds.service.CdsEvaluationPeriodsServiceUtil;
import larion.progate.cds.service.CdsLevelStatisticalReportLocalServiceUtil;
import larion.progate.cds.service.CdsLevelStatisticalReportServiceUtil;
import larion.progate.cds.service.CdsMinimumRequirementLevelsLocalServiceUtil;
import larion.progate.cds.service.CdsMinimumRequirementLevelsServiceUtil;
import larion.progate.cds.service.CdsMinimumRequirementsLocalServiceUtil;
import larion.progate.cds.service.CdsMinimumRequirementsServiceUtil;
import larion.progate.cds.service.CdsPACompetenciesLocalServiceUtil;
import larion.progate.cds.service.CdsPACompetenciesServiceUtil;
import larion.progate.cds.service.CdsPAFinalCompeteniesLocalServiceUtil;
import larion.progate.cds.service.CdsPAFinalCompeteniesServiceUtil;
import larion.progate.cds.service.CdsPAFinalLevelsLocalServiceUtil;
import larion.progate.cds.service.CdsPAFinalLevelsServiceUtil;
import larion.progate.cds.service.CdsPAFinalLocalServiceUtil;
import larion.progate.cds.service.CdsPAFinalServiceUtil;
import larion.progate.cds.service.CdsPAFinalSlotsLocalServiceUtil;
import larion.progate.cds.service.CdsPAFinalSlotsServiceUtil;
import larion.progate.cds.service.CdsPALevelsLocalServiceUtil;
import larion.progate.cds.service.CdsPALevelsServiceUtil;
import larion.progate.cds.service.CdsPASlotsLocalServiceUtil;
import larion.progate.cds.service.CdsPASlotsServiceUtil;
import larion.progate.cds.service.CdsPerformanceAppraisalSlotCommentsLocalServiceUtil;
import larion.progate.cds.service.CdsPerformanceAppraisalSlotCommentsServiceUtil;
import larion.progate.cds.service.CdsPerformanceAppraisalSlotRatingLocalServiceUtil;
import larion.progate.cds.service.CdsPerformanceAppraisalSlotRatingServiceUtil;
import larion.progate.cds.service.CdsPerformanceAppraisalsLocalServiceUtil;
import larion.progate.cds.service.CdsPerformanceAppraisalsServiceUtil;
import larion.progate.cds.service.CdsPointsLocalServiceUtil;
import larion.progate.cds.service.CdsPointsServiceUtil;
import larion.progate.cds.service.CdsSlotStatisticalReportLocalServiceUtil;
import larion.progate.cds.service.CdsSlotStatisticalReportServiceUtil;
import larion.progate.cds.service.CdsTitleCompetenciesLocalServiceUtil;
import larion.progate.cds.service.CdsTitleCompetenciesServiceUtil;
import larion.progate.cds.service.CdsTitleMinimumRequirementsLocalServiceUtil;
import larion.progate.cds.service.CdsTitleMinimumRequirementsServiceUtil;
import larion.progate.cds.service.CdsTitlesLocalServiceUtil;
import larion.progate.cds.service.CdsTitlesServiceUtil;
import larion.progate.cds.service.ClpSerializer;
import larion.progate.cds.service.CompetencyLocalServiceUtil;
import larion.progate.cds.service.CompetencyServiceUtil;
import larion.progate.cds.service.LevelLocalServiceUtil;
import larion.progate.cds.service.LevelServiceUtil;
import larion.progate.cds.service.SlotLocalServiceUtil;
import larion.progate.cds.service.SlotServiceUtil;
import larion.progate.cds.service.ViewEmployeesInProjectsLocalServiceUtil;
import larion.progate.cds.service.ViewEmployeesInProjectsServiceUtil;
import larion.progate.cds.service.ViewEmployeesSlotsRatingLocalServiceUtil;
import larion.progate.cds.service.ViewEmployeesSlotsRatingServiceUtil;
import larion.progate.cds.service.ViewFinalCompetenciesLocalServiceUtil;
import larion.progate.cds.service.ViewFinalCompetenciesServiceUtil;
import larion.progate.cds.service.ViewFinalLevelsLocalServiceUtil;
import larion.progate.cds.service.ViewFinalLevelsServiceUtil;
import larion.progate.cds.service.ViewFinalSlotsLocalServiceUtil;
import larion.progate.cds.service.ViewFinalSlotsServiceUtil;
import larion.progate.cds.service.ViewFinalTitlesLocalServiceUtil;
import larion.progate.cds.service.ViewFinalTitlesServiceUtil;
import larion.progate.cds.service.ViewListTitleCompetenciesLocalServiceUtil;
import larion.progate.cds.service.ViewListTitleCompetenciesServiceUtil;
import larion.progate.cds.service.ViewListTitleMinimumRequirementsLocalServiceUtil;
import larion.progate.cds.service.ViewListTitleMinimumRequirementsServiceUtil;
import larion.progate.cds.service.ViewPerformanceAppraisalLevelsLocalServiceUtil;
import larion.progate.cds.service.ViewPerformanceAppraisalLevelsServiceUtil;
import larion.progate.cds.service.ViewPerformanceAppraisalSlotsLocalServiceUtil;
import larion.progate.cds.service.ViewPerformanceAppraisalSlotsServiceUtil;
import larion.progate.cds.service.ViewSlotInformationLocalServiceUtil;
import larion.progate.cds.service.ViewSlotInformationServiceUtil;

/**
 * <a href="ClpMessageListener.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ClpMessageListener implements MessageListener {
	public static final String SERVLET_CONTEXT_NAME = ClpSerializer.SERVLET_CONTEXT_NAME;

	public void receive(Message message) {
		try {
			doReceive(message);
		}
		catch (Exception e) {
			_log.error("Unable to process message " + message, e);
		}
	}

	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(SERVLET_CONTEXT_NAME)) {
			CompetencyLocalServiceUtil.clearService();

			CompetencyServiceUtil.clearService();
			LevelLocalServiceUtil.clearService();

			LevelServiceUtil.clearService();
			SlotLocalServiceUtil.clearService();

			SlotServiceUtil.clearService();
			CdsPointsLocalServiceUtil.clearService();

			CdsPointsServiceUtil.clearService();
			CdsEvaluationPeriodsLocalServiceUtil.clearService();

			CdsEvaluationPeriodsServiceUtil.clearService();
			CdsTitlesLocalServiceUtil.clearService();

			CdsTitlesServiceUtil.clearService();
			CdsTitleCompetenciesLocalServiceUtil.clearService();

			CdsTitleCompetenciesServiceUtil.clearService();
			CdsMinimumRequirementsLocalServiceUtil.clearService();

			CdsMinimumRequirementsServiceUtil.clearService();
			CdsTitleMinimumRequirementsLocalServiceUtil.clearService();

			CdsTitleMinimumRequirementsServiceUtil.clearService();
			CdsMinimumRequirementLevelsLocalServiceUtil.clearService();

			CdsMinimumRequirementLevelsServiceUtil.clearService();
			ViewListTitleCompetenciesLocalServiceUtil.clearService();

			ViewListTitleCompetenciesServiceUtil.clearService();
			ViewListTitleMinimumRequirementsLocalServiceUtil.clearService();

			ViewListTitleMinimumRequirementsServiceUtil.clearService();
			CdsPAFinalCompeteniesLocalServiceUtil.clearService();

			CdsPAFinalCompeteniesServiceUtil.clearService();
			CdsPAFinalLevelsLocalServiceUtil.clearService();

			CdsPAFinalLevelsServiceUtil.clearService();
			CdsPAFinalSlotsLocalServiceUtil.clearService();

			CdsPAFinalSlotsServiceUtil.clearService();
			ViewFinalCompetenciesLocalServiceUtil.clearService();

			ViewFinalCompetenciesServiceUtil.clearService();
			ViewFinalLevelsLocalServiceUtil.clearService();

			ViewFinalLevelsServiceUtil.clearService();
			ViewFinalSlotsLocalServiceUtil.clearService();

			ViewFinalSlotsServiceUtil.clearService();
			ViewFinalTitlesLocalServiceUtil.clearService();

			ViewFinalTitlesServiceUtil.clearService();
			ViewSlotInformationLocalServiceUtil.clearService();

			ViewSlotInformationServiceUtil.clearService();
			CdsPASlotsLocalServiceUtil.clearService();

			CdsPASlotsServiceUtil.clearService();
			CdsPALevelsLocalServiceUtil.clearService();

			CdsPALevelsServiceUtil.clearService();
			CdsPACompetenciesLocalServiceUtil.clearService();

			CdsPACompetenciesServiceUtil.clearService();
			ViewPerformanceAppraisalLevelsLocalServiceUtil.clearService();

			ViewPerformanceAppraisalLevelsServiceUtil.clearService();
			ViewPerformanceAppraisalSlotsLocalServiceUtil.clearService();

			ViewPerformanceAppraisalSlotsServiceUtil.clearService();
			CdsPerformanceAppraisalSlotRatingLocalServiceUtil.clearService();

			CdsPerformanceAppraisalSlotRatingServiceUtil.clearService();
			CdsPerformanceAppraisalSlotCommentsLocalServiceUtil.clearService();

			CdsPerformanceAppraisalSlotCommentsServiceUtil.clearService();
			CdsPerformanceAppraisalsLocalServiceUtil.clearService();

			CdsPerformanceAppraisalsServiceUtil.clearService();
			ViewEmployeesInProjectsLocalServiceUtil.clearService();

			ViewEmployeesInProjectsServiceUtil.clearService();
			ViewEmployeesSlotsRatingLocalServiceUtil.clearService();

			ViewEmployeesSlotsRatingServiceUtil.clearService();
			CdsSlotStatisticalReportLocalServiceUtil.clearService();

			CdsSlotStatisticalReportServiceUtil.clearService();
			CdsLevelStatisticalReportLocalServiceUtil.clearService();

			CdsLevelStatisticalReportServiceUtil.clearService();
			CdsCompetencyStatisticalReportLocalServiceUtil.clearService();

			CdsCompetencyStatisticalReportServiceUtil.clearService();
			CdsCdpLocalServiceUtil.clearService();

			CdsCdpServiceUtil.clearService();
			CdsPAFinalLocalServiceUtil.clearService();

			CdsPAFinalServiceUtil.clearService();
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClpMessageListener.class);
}