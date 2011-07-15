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

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.time.DateUtils;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

import larion.progate.cds.model.CdsEvaluationPeriods;
import larion.progate.cds.model.CdsPASlots;
import larion.progate.cds.model.CdsPerformanceAppraisalSlotRating;
import larion.progate.model.User;
import larion.progate.cds.model.ViewEmployeesInProjects;
import larion.progate.cds.service.CdsEvaluationPeriodsLocalServiceUtil;
import larion.progate.service.UserLocalServiceUtil;
import larion.progate.cds.service.base.CdsPerformanceAppraisalSlotRatingLocalServiceBaseImpl;
import larion.progate.cds.service.persistence.CdsEvaluationPeriodsUtil;
import larion.progate.cds.service.persistence.CdsPASlotsFinderUtil;
import larion.progate.cds.service.persistence.CdsPerformanceAppraisalSlotRatingFinderUtil;
import larion.progate.cds.service.persistence.CdsPerformanceAppraisalSlotRatingUtil;
import larion.progate.cds.service.persistence.CdsPerformanceAppraisalsFinderUtil;
import larion.progate.cds.service.utils.Constants;

/**
 * <a href="CdsPerformanceAppraisalSlotRatingLocalServiceImpl.java.html"><b><i>
 * View Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class CdsPerformanceAppraisalSlotRatingLocalServiceImpl extends
		CdsPerformanceAppraisalSlotRatingLocalServiceBaseImpl {
	// NV danh gia, PM phe duyet hoac BOD phe duyet ca nhan
	public boolean addPASlotRating(int rootId, int periodId, int userId,
			int slotId, int ratingBy, boolean ratingStatus, int userType,
			String pointName, int pointValue) throws SystemException,
			PortalException {
		// user_type = 0 la nhan vien, 1 la PM, 2 la BOD
		try {
			Date date = new Date();
			date = DateUtils.addHours(date, Constants.UTC_HOURS);// Gio lay ra
																	// bi cham 7
																	// tieng nen
																	// phai cong
																	// them
			CdsPerformanceAppraisalSlotRating slotRating = createCdsPerformanceAppraisalSlotRating(null);
			slotRating.setRootId(rootId);
			slotRating.setPeriodId(periodId);
			slotRating.setUserId(userId);
			slotRating.setSlotId(slotId);
			slotRating.setRatingBy(ratingBy);
			slotRating.setRatingAt(date);
			slotRating.setRatingStatus(ratingStatus);
			slotRating.setUserType(userType);
			slotRating.setPointName(pointName);
			slotRating.setPointValue(pointValue);
			CdsPerformanceAppraisalSlotRating addSlotRating = addCdsPerformanceAppraisalSlotRating(slotRating);
			return true;
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsPerformanceAppraisalSlotRatingLocalServiceImpl.addPASlotRating "
							+ e.toString());
			return false;
		}
	}

	// BOD phe duyet toan bo
	public boolean addPASlotRatingByBOD(int[] userId, int periodId,
			int ratingByBOD, int userTypeBOD) throws SystemException,
			PortalException {
		try {
			for (int i = 0; i < userId.length; i++) {

				List<CdsPASlots> listSlotRatingByPM = CdsPASlotsFinderUtil
						.getCdsPASlotRatingByPM(periodId, userId[i]);
				if (listSlotRatingByPM == null)
					listSlotRatingByPM = new ArrayList<CdsPASlots>();
				for (int j = 0; j < listSlotRatingByPM.size(); j++) {
					CdsPASlots rating = listSlotRatingByPM.get(j);
					addPASlotRating(rating.getRootId(), periodId, userId[i],
							rating.getSlotId(), ratingByBOD, true, userTypeBOD,
							rating.getPointName(), rating.getPointValue());
				}
			}
			return true;
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsPerformanceAppraisalSlotRatingLocalServiceImpl.addPASlotRatingByBOD"
							+ e.toString());
			return false;
		}
	}

	// public List<Map<CdsPerformanceAppraisalSlotRating,
	// CdsEvaluationPeriods>>getSlotRatingHistory
	// (int userId, int slotId) throws SystemException, PortalException {
	// List<Map<CdsPerformanceAppraisalSlotRating, CdsEvaluationPeriods>>
	// history = new
	// ArrayList<Map<CdsPerformanceAppraisalSlotRating,CdsEvaluationPeriods>>();
	// List<CdsPerformanceAppraisalSlotRating> listUserId =
	// CdsPerformanceAppraisalSlotRatingUtil .findByUserId(userId);
	// List<CdsPerformanceAppraisalSlotRating> listSlotId =
	// CdsPerformanceAppraisalSlotRatingUtil .findBySlotId(slotId);
	// List<CdsPerformanceAppraisalSlotRating> slotHistory = ListUtils
	// .intersection(listUserId, listSlotId); for
	// (CdsPerformanceAppraisalSlotRating slot : slotHistory) {
	// CdsEvaluationPeriods objPeriod = CdsEvaluationPeriodsUtil
	// .findByPrimaryKey(slot.getPeriodId());
	// Map<CdsPerformanceAppraisalSlotRating, CdsEvaluationPeriods> map = new
	// HashMap<CdsPerformanceAppraisalSlotRating, CdsEvaluationPeriods>();
	// map.put(slot, objPeriod); history.add(map);
	// }
	// return history;
	// }
	//

	// public List<Map<Object,Object>> getSlotRatingHistory( int userId, int
	// slotId)
	// throws SystemException, PortalException {
	// List<Map<Object,Object>> history = new ArrayList<Map<Object,Object>>();
	// List<CdsPerformanceAppraisalSlotRating> listUserId =
	// CdsPerformanceAppraisalSlotRatingUtil .findByUserId(userId);
	// List<CdsPerformanceAppraisalSlotRating> listSlotId =
	// CdsPerformanceAppraisalSlotRatingUtil .findBySlotId(slotId);
	// List<CdsPerformanceAppraisalSlotRating> slotHistory = ListUtils
	// .intersection(listUserId, listSlotId); Format formatterForDate = new
	// SimpleDateFormat("dd/MM/yyyy HH:mm");
	// for(CdsPerformanceAppraisalSlotRating slot : slotHistory) {
	// CdsEvaluationPeriods objPeriod = CdsEvaluationPeriodsUtil
	// .findByPrimaryKey(slot.getPeriodId()); User objUser =
	// UserLocalServiceUtil.getUser(slot.getUserId()); Map<Object, Object> map =
	// new HashMap<Object, Object>();
	// map.put("periodName", objPeriod.getName());
	// map.put("fromDate", formatterForDate.format(objPeriod.getFromDate()));
	// map.put("toDate", formatterForDate.format(objPeriod.getToDate()));
	// StringBuffer authorStringBuffer = new StringBuffer();
	// authorStringBuffer.append(objUser.getFirstname());
	// if(!objUser.getMiddlename().isEmpty()){
	// authorStringBuffer.append(" ");
	// authorStringBuffer.append(objUser.getMiddlename()); }
	// authorStringBuffer.append(" ");
	// authorStringBuffer.append(objUser.getLastname());
	// String author = authorStringBuffer.toString();
	// map.put("userFullName", author);
	// map.put("raingStatus", slot.getRatingStatus());
	// map.put("pointName", slot.getPointName());
	// map.put("ratingAt", slot.getRatingAt());
	// map.put("userType", slot.getUserType()); history.add(map);
	// }
	// return history;
	// }
	//

	public List<CdsPerformanceAppraisalSlotRating> getSlotRatingHistory(
			int rootId, int userId, int slotId) throws SystemException,
			PortalException {
		try {
			List<CdsPerformanceAppraisalSlotRating> listSlotHistory = CdsPerformanceAppraisalSlotRatingFinderUtil
					.getSlotRatingHistory(rootId, userId, slotId);
			if (listSlotHistory == null)
				listSlotHistory = new ArrayList<CdsPerformanceAppraisalSlotRating>();
			return listSlotHistory;
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsPerformanceAppraisalSlotRatingLocalServiceImpl.getSlotRatingHistory "
							+ e.toString());
			List<CdsPerformanceAppraisalSlotRating> listNull = new ArrayList<CdsPerformanceAppraisalSlotRating>();
			return listNull;
		}
	}

	public int getLastRatingPointByUserType(int periodId, int userId,
			int slotId, int userType) throws SystemException, PortalException {
		try {
			List<CdsPerformanceAppraisalSlotRating> listRating = CdsPerformanceAppraisalSlotRatingFinderUtil
					.getLastRatingNotApproved(periodId, userId, slotId,
							userType);
			if (listRating == null)
				listRating = new ArrayList<CdsPerformanceAppraisalSlotRating>();
			int pointValue = listRating.get(0).getPointValue();
			return pointValue;
		} catch (Exception e) {
			System.out
					.println("ERROR in CdsPerformanceAppraisalSlotRatingLocalServiceImpl.getLastRatingPointByUserType "
							+ e.toString());
			return -1;
		}
	}
}