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

package larion.progate.cds.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.time.DateUtils;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

import larion.progate.cds.model.CdsEvaluationPeriods;
import larion.progate.cds.model.CdsPACompetencies;
import larion.progate.cds.model.CdsPerformanceAppraisals;
import larion.progate.model.Organization;
import larion.progate.cds.service.CdsPerformanceAppraisalsLocalServiceUtil;
import larion.progate.service.OrganizationLocalServiceUtil;
import larion.progate.cds.service.base.CdsEvaluationPeriodsLocalServiceBaseImpl;
import larion.progate.cds.service.persistence.CdsEvaluationPeriodsUtil;
import larion.progate.cds.service.persistence.CdsPACompetenciesUtil;
import larion.progate.cds.service.persistence.CdsPerformanceAppraisalsUtil;
import larion.progate.cds.service.utils.Constants;

/**
 * <a href="CdsEvaluationPeriodsLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class CdsEvaluationPeriodsLocalServiceImpl extends
		CdsEvaluationPeriodsLocalServiceBaseImpl {
	// Add CDS Evaluation Periods
	public int addCdsPeriod(int rootId, String name, Date fromDate,
			Date toDate, Date startDate, Date endDate, int status, int createdBy)
			throws SystemException, PortalException {
		try {
			Date date = new Date();
			date = DateUtils.addHours(date, Constants.UTC_HOURS);// Gio lay ra
																	// bi cham 7
																	// tieng nen
																	// phai cong
																	// them
			CdsEvaluationPeriods evaluationPeriods = createCdsEvaluationPeriods(null);
			evaluationPeriods.setRootId(rootId);
			evaluationPeriods.setName(name);
			evaluationPeriods.setFromDate(fromDate);
			evaluationPeriods.setToDate(toDate);
			evaluationPeriods.setStartDate(startDate);
			evaluationPeriods.setEndDate(endDate);
			evaluationPeriods.setStatus(status);
			evaluationPeriods.setCreatedBy(createdBy);
			evaluationPeriods.setCreatedAt(date);
			evaluationPeriods.setIsModified(true);
			CdsEvaluationPeriods evaluationPeriods1 = addCdsEvaluationPeriods(evaluationPeriods);
			return evaluationPeriods1.getPrimaryKey();
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsEvaluationPeriodsLocalServiceImpl.addCdsPeriod "
							+ e.toString());
			return 0;
		}
	}

	// Update CDS Evaluation Period
	public boolean updateCdsPeriod(int id, String name, Date fromDate,
			Date toDate, Date startDate, Date endDate, int status, int updatedBy)
			throws SystemException, PortalException {
		try {
			CdsEvaluationPeriods evaluationPeriods = getCdsEvaluationPeriods(id);
			Date date = new Date();
			date = DateUtils.addHours(date, Constants.UTC_HOURS);// Gio lay ra
																	// bi cham 7
																	// tieng nen
																	// phai cong
																	// them
			if (name != null && fromDate != null && toDate != null
					&& startDate != null && endDate != null) {
				evaluationPeriods.setName(name);
				evaluationPeriods.setFromDate(fromDate);
				evaluationPeriods.setToDate(toDate);
				evaluationPeriods.setStartDate(startDate);
				evaluationPeriods.setEndDate(endDate);
				evaluationPeriods.setStatus(status);
				evaluationPeriods.setUpdatedBy(updatedBy);
				evaluationPeriods.setUpdatedAt(date);
				CdsEvaluationPeriods evaluationPeriods1 = updateCdsEvaluationPeriods(evaluationPeriods);
				return true;
			} else {
				evaluationPeriods.setStatus(status);
				evaluationPeriods.setUpdatedBy(updatedBy);
				evaluationPeriods.setUpdatedAt(date);
				CdsEvaluationPeriods evaluationPeriods1 = updateCdsEvaluationPeriods(evaluationPeriods);
				return true;
			}
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsEvaluationPeriodsLocalServiceImpl.updateCdsPeriod "
							+ e.toString());
			return false;
		}
	}

	// Kiem tra dot da duoc su dung hay chua
	public boolean testBeforeDeleteCdsPeriod(int id) throws SystemException,
			PortalException {
		try {
			List<CdsPACompetencies> competencyList = CdsPACompetenciesUtil
					.findByPeriodId(id);
			if (competencyList.size() != 0)
				return false;
			return true;
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsEvaluationPeriodsLocalServiceImpl.testBeforeDeleteCdsPeriod() "
							+ e.toString());
			return false;
		}
	}

	// Delete CDS Evaluation Period by CdsEvaluationPeriodId
	public boolean deleteCdsPeriod(int id) throws SystemException,
			PortalException {
		try {
			List<CdsPACompetencies> competencyList = CdsPACompetenciesUtil
					.findByPeriodId(id);
			if (competencyList.size() != 0)
				return false;
			List<CdsPerformanceAppraisals> paList = CdsPerformanceAppraisalsUtil
					.findByPeriodId(id);
			for (CdsPerformanceAppraisals pa : paList) {
				CdsPerformanceAppraisalsLocalServiceUtil
						.deleteCdsPerformanceAppraisals(pa);
			}
			deleteCdsEvaluationPeriods(id);
			return true;
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsEvaluationPeriodsLocalServiceImpl.deleteCdsPeriod() "
							+ e.toString());
			return false;
		}
	}

	// Show list of CDS Evaluation Periods
	public List<CdsEvaluationPeriods> loadCdsPeriods(int status, int rootId)
			throws SystemException, PortalException {
		try {
			List<CdsEvaluationPeriods> evaluationPeriodsRootIdList = CdsEvaluationPeriodsUtil
					.findByrootId(rootId);
			// Lay tat ca
			if (status == 0) {
				return evaluationPeriodsRootIdList;
			} else {
				List<CdsEvaluationPeriods> evaluationPeriodsStatusList = CdsEvaluationPeriodsUtil
						.findBystatus(status);
				List<CdsEvaluationPeriods> CdsEvaluationPeriodsList = ListUtils
						.intersection(evaluationPeriodsRootIdList,
								evaluationPeriodsStatusList);
				return CdsEvaluationPeriodsList;
			}
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsEvaluationPeriodsLocalServiceImpl.loadCdsPeriods "
							+ e.toString());
			List<CdsEvaluationPeriods> listNull = new ArrayList<CdsEvaluationPeriods>();
			return listNull;
		}
	}

	// Check evaluation period first time
	public int checkPeriod(int rootId) throws SystemException, PortalException {
		List<CdsEvaluationPeriods> listRoot = CdsEvaluationPeriodsUtil
				.findByrootId(rootId);
		try {
			for (CdsEvaluationPeriods root : listRoot) {
				if (root.getIsModified() == false)
					return root.getPrimaryKey();
			}
			return 0;
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsEvaluationPeriodsLocalServiceImpl.checkPeriod "
							+ e.toString());
			return 0;
		}
	}

	// Create period to import file if check return false
	// Vua vo tab Dot, ktra co ton tai dot khoi tao chua, chua thi tao, khi vao
	// tab import, ktra coi
	// xem co dot khoi tao chua, chua co thi tao roi moi cho import, neu ko thi
	// ko cho import
	public int addCdsPeriodImport(int rootId, int createdBy)
			throws SystemException, PortalException {
		try {
			Date date = new Date();
			date = DateUtils.addHours(date, Constants.UTC_HOURS);// Gio lay ra
																	// bi cham 7
																	// tieng nen
																	// phai cong
																	// them
			CdsEvaluationPeriods evaluationPeriods = createCdsEvaluationPeriods(null);
			evaluationPeriods.setRootId(rootId);
			evaluationPeriods.setName("Đợt khởi tạo");
			evaluationPeriods.setFromDate(date);
			evaluationPeriods.setToDate(date);
			evaluationPeriods.setStartDate(date);
			evaluationPeriods.setEndDate(date);
			evaluationPeriods.setStatus(2);
			evaluationPeriods.setCreatedBy(createdBy);
			evaluationPeriods.setCreatedAt(date);
			evaluationPeriods.setIsModified(false);
			CdsEvaluationPeriods evaluationPeriods1 = addCdsEvaluationPeriods(evaluationPeriods);
			return evaluationPeriods1.getPrimaryKey();
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsEvaluationPeriodsLocalServiceImpl.addCdsPeriodImport "
							+ e.toString());
			return 0;
		}
	}

	// Update period to import file
	public boolean updateCdsPeriodImport(int id, int status)
			throws SystemException, PortalException {
		CdsEvaluationPeriods evaluationPeriods = getCdsEvaluationPeriods(id);
		try {
			Date date = new Date();
			date = DateUtils.addHours(date, Constants.UTC_HOURS);// Gio lay ra
																	// bi cham 7
																	// tieng nen
																	// phai cong
																	// them
			// Set lai to_date trong dot khoi tao moi khi import
			// to_date + them 2 ngay de thay duoc nv trong bao cao thong ke
			date = DateUtils.addDays(date, 2);
			evaluationPeriods.setStatus(status);
			evaluationPeriods.setToDate(date);
			CdsEvaluationPeriods evaluationPeriods1 = updateCdsEvaluationPeriods(evaluationPeriods);
			return true;
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsEvaluationPeriodsLocalServiceImpl.updateCdsPeriodImport "
							+ e.toString());
			return false;
		}
	}

	// Find period by RootId
	public List<CdsEvaluationPeriods> getPeriodByRootId(int rootId)
			throws SystemException, PortalException {
		try {
			return CdsEvaluationPeriodsUtil.findByrootId(rootId);
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsEvaluationPeriodsLocalServiceImpl.getPeriodByRootId "
							+ e.toString());
			List<CdsEvaluationPeriods> listNull = new ArrayList<CdsEvaluationPeriods>();
			return listNull;
		}
	}

	// Kiem tra co dot nao dang mo hay dong ko
	public boolean checkOpenOrClosePeriod(int rootId) throws SystemException,
			PortalException {
		try {
			List<CdsEvaluationPeriods> periodList = CdsEvaluationPeriodsUtil
					.findByrootId(rootId);
			for (CdsEvaluationPeriods period : periodList) {
				// Kiem tra chi can ton tai 1 dot dang dong hoac mo thi tra ve
				if (period.getStatus() == 3 || period.getStatus() == 2)
					return true;
			}
			return false;
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsEvaluationPeriodsLocalServiceImpl.checkOpenOrClosePeriod "
							+ e.toString());
			return true;
		}
	}

	// Lay id dot khoi tao
	public int getImportedEvaluation() throws SystemException, PortalException {
		try {
			List<CdsEvaluationPeriods> period = CdsEvaluationPeriodsUtil
					.findByisModified(false);
			return period.get(0).getPrimaryKey();
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsEvaluationPeriodsLocalServiceImpl.getImportedEvaluation "
							+ e.toString());
			return 0;
		}
	}
}