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
import java.util.List;

import org.apache.commons.collections.ListUtils;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

import larion.progate.cds.model.CdsPerformanceAppraisals;
import larion.progate.cds.service.CdsEvaluationPeriodsLocalServiceUtil;
import larion.progate.cds.service.CdsPerformanceAppraisalsLocalServiceUtil;
import larion.progate.cds.service.base.CdsPerformanceAppraisalsLocalServiceBaseImpl;
import larion.progate.cds.service.persistence.CdsPerformanceAppraisalsFinderUtil;
import larion.progate.cds.service.persistence.CdsPerformanceAppraisalsUtil;

/**
 * <a href="CdsPerformanceAppraisalsLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class CdsPerformanceAppraisalsLocalServiceImpl extends
		CdsPerformanceAppraisalsLocalServiceBaseImpl {
	public CdsPerformanceAppraisals getCdsPerformanceAppraisals(int userId,
			int periodId) throws SystemException, PortalException {
		try {
			List<CdsPerformanceAppraisals> list = CdsPerformanceAppraisalsFinderUtil
					.getCdsPerformanceAppraisals(userId, periodId);
			if (list == null) {
				return null;
			} else {
				return list.get(0);
			}
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsPerformanceAppraisalsLocalServiceImpl.getCdsPerformanceAppraisals "
							+ e.toString());
			return null;
		}
	}

	public boolean lockedCds(int periodId, int userId) throws SystemException,
			PortalException {
		try {
			/*
			 * List<CdsPerformanceAppraisals> periodList =
			 * CdsPerformanceAppraisalsUtil .findByPeriodId(periodId);
			 * List<CdsPerformanceAppraisals> userList =
			 * CdsPerformanceAppraisalsUtil .findByUserId(userId);
			 * List<CdsPerformanceAppraisals> cdsPa = ListUtils.intersection(
			 * periodList, userList);
			 * 
			 * CdsPerformanceAppraisals pA = cdsPa.get(0);
			 */
			CdsPerformanceAppraisals pA = getCdsPerformanceAppraisals(userId,
					periodId);
			if (pA == null)
				return false;
			if (pA.getIsLocked() == false)
				pA.setIsLocked(true);
			else
				pA.setIsLocked(false);
			CdsPerformanceAppraisalsLocalServiceUtil
					.updateCdsPerformanceAppraisals(pA);
			return true;
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsPerformanceAppraisalsLocalServiceImpl.lockedCds"
							+ e.toString());
			return false;
		}
	}

	// Ktra user do co nam trong Dot Khoi Tao (import) ko
	public boolean checkInImportedPeriod(int rootId, int userId)
			throws SystemException, PortalException {
		try {
			List<CdsPerformanceAppraisals> listRoot = CdsPerformanceAppraisalsUtil
					.findByRootId(rootId);
			List<CdsPerformanceAppraisals> listUser = CdsPerformanceAppraisalsUtil
					.findByUserId(userId);
			List<CdsPerformanceAppraisals> listPA = ListUtils.intersection(
					listUser, listRoot);
			for (CdsPerformanceAppraisals pA : listPA) {
				if (pA.getPeriodId() == CdsEvaluationPeriodsLocalServiceUtil
						.getImportedEvaluation() && pA.getRatingStatus()!=0)
					return true; 
				// Da import vi co dot khoi tao va trang thai nv != 0
			}
			return false; // Chua import lan nao
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsPerformanceAppraisalsLocalServiceImpl.checkInImportedPeriod "
							+ e.toString());
			return false;
		}
	}
}