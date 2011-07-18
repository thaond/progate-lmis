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

package larion.progate.lmis.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.collections.ListUtils;

import com.liferay.portal.SystemException;

import larion.progate.lmis.model.LmisAttendanceDaily;
import larion.progate.lmis.service.LmisGeneralSettingsLocalServiceUtil;
import larion.progate.lmis.service.base.LmisAttendanceDailyLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisAttendanceDailyFinderUtil;
import larion.progate.lmis.service.persistence.LmisAttendanceDailyUtil;
import larion.progate.lmis.service.persistence.LmisGeneralSettingsFinderUtil;


public class LmisAttendanceDailyLocalServiceImpl
	extends LmisAttendanceDailyLocalServiceBaseImpl {
	
	/* (non-Javadoc)
	 * @see larion.progate.lmis.service.LmisAttendanceDailyLocalService#getStartTimeToday(int, java.util.Date)
	 * Gio bat dau lam viec hom nay
	 */

	public Date getStartTimeToday(int userId, Date dayValue,int rootId) throws com.liferay.portal.SystemException {
		try{
		List<LmisAttendanceDaily> lsRoot = LmisAttendanceDailyUtil.findByLmisAttendanceDailyOf(rootId);	
		List<LmisAttendanceDaily> lsUser = LmisAttendanceDailyUtil.findByUserID(userId);
		List<LmisAttendanceDaily> lsDate =LmisAttendanceDailyUtil.findByDayValue(dayValue);
		List<LmisAttendanceDaily> ls = ListUtils.intersection(lsUser, lsDate);
		List<LmisAttendanceDaily> lsResult = ListUtils.intersection(ls,lsRoot);	
		if(lsResult.size() != 0)
		return lsResult.get(0).getRealStartTime();
		} catch (Exception e) {
			System.out.println("Error at LmisAttendanceDaily.getStartTimeToday : " + e.toString());

		}
		return null;
	}
	
	/**
	 * @param userId
	 * @param dayValue
	 * @return long
	 * hom nay di tre
	 */

	public long getStartTimeLateToday(int userId, Date dayValue,int rootId) throws com.liferay.portal.SystemException {
		try{
		Date d1,d2;
		long result;
		List<LmisAttendanceDaily> lsRoot = LmisAttendanceDailyUtil.findByLmisAttendanceDailyOf(rootId);
		List<LmisAttendanceDaily> lsUser = LmisAttendanceDailyUtil.findByUserID(userId);
		List<LmisAttendanceDaily> lsDate =LmisAttendanceDailyUtil.findByDayValue(dayValue);
		List<LmisAttendanceDaily> ls = ListUtils.intersection(lsUser, lsDate);
		List<LmisAttendanceDaily> lsResult = ListUtils.intersection(ls,lsRoot);
		d1 = lsResult.get(0).getRealStartTime();
		d2 = lsResult.get(0).getPlanStartTime();
		result = LmisGeneralSettingsLocalServiceUtil.getTimeDiff(d2, d1);
		if(result < 0 ) return 0;
		else
		return result;
		} catch (Exception e) {
			System.out.println("Error at LmisAttendanceDaily.getStartTimeLateToday : " + e.toString());

		}
		return 0;
	}
	
	/**
	 * @param userId
	 * @param dayValue
	 * @return Date
	 * @throws com.liferay.portal.SystemException
	 * gio ket thuc lam viec hom qua
	 */

	public Date getEndTimeYesterday(int userId, Date dayValue,int rootId) throws com.liferay.portal.SystemException {
		try {
			List<LmisAttendanceDaily> lsRoot = LmisAttendanceDailyUtil
					.findByLmisAttendanceDailyOf(rootId);
			List<LmisAttendanceDaily> lsUser = LmisAttendanceDailyUtil
					.findByUserID(userId);
			List<LmisAttendanceDaily> lsDate = LmisAttendanceDailyUtil
					.findByDayValue(dayValue);
			List<LmisAttendanceDaily> ls = ListUtils.intersection(lsUser,
					lsDate);
			List<LmisAttendanceDaily> lsResult = ListUtils.intersection(ls,
					lsRoot);
			return lsResult.get(0).getRealEndTime();
		} catch (Exception e) {
			System.out.println("Error at LmisAttendanceDaily.getEndTimeYesterday : " + e.toString());

		}
		return null;
	}
	
	/**
	 * @param userId
	 * @param dayValue
	 * @return long
	 * @throws com.liferay.portal.SystemException
	 * Hom qua ve som ? phut
	 */

	public long getEndTimeEarlyYesterDay(int userId, Date dayValue,int rootId) throws com.liferay.portal.SystemException {
		try {
			Date d1, d2;
			long result;
			List<LmisAttendanceDaily> lsRoot = LmisAttendanceDailyUtil
					.findByLmisAttendanceDailyOf(rootId);
			List<LmisAttendanceDaily> lsUser = LmisAttendanceDailyUtil
					.findByUserID(userId);
			List<LmisAttendanceDaily> lsDate = LmisAttendanceDailyUtil
					.findByDayValue(dayValue);
			List<LmisAttendanceDaily> ls = ListUtils.intersection(lsUser,
					lsDate);
			List<LmisAttendanceDaily> lsResult = ListUtils.intersection(ls,
					lsRoot);
			d1 = lsResult.get(0).getRealEndTime();
			d2 = lsResult.get(0).getPlanEndTime();
			result = LmisGeneralSettingsLocalServiceUtil.getTimeDiff(d1, d2);
			if (result < 0)
				return 0;
			if(result > 59)
				return 0;
			else
				return result;
		} catch (Exception e) {
			System.out.println("Error  at  LmisAttendanceDaily.getEndTimeEarlyYesterDay  : " + e.toString());

		}
		return 0;
	}
	

	public List<LmisAttendanceDaily> getListDetailsDayOff(int rootId,
			int userId, Date cur) {
		List<LmisAttendanceDaily> ls = null;
		try {
			
			System.out.println("WWWWWWWWWWWWWWW: " + cur.toString());

			Calendar cal = Calendar.getInstance();				
			Date date1 = new Date(cur.toString());				
			date1.setDate(1);
			Calendar cal1 = Calendar.getInstance();	
			cal1.setTime(cur);

			Date date2 = new Date(cur.toString());
			
			
			
////			date1.setDate(cal.getActualMinimum(GregorianCalendar.DAY_OF_MONTH));
//			date1.setDate(1);
////			date2.setDate(cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH)+1);		
//			date2.setDate(cal.getMaximum(GregorianCalendar.DAY_OF_MONTH));
//			cal.setTime(date1);
			Calendar cal2 = Calendar.getInstance();	
			cal2.setTime(cur);
			
			
			
//			int lastDate = cal.getActualMaximum(Calendar.DATE);
			int lastDate2 = cal2.getActualMaximum(Calendar.DATE);
			
			System.out.println("lastDate2: " + lastDate2);
			date1.setDate(1);
			date2.setDate(lastDate2);
			
			System.out.println("date1: " + date1);
			System.out.println("date2: " + date2);

			@SuppressWarnings("unchecked")
			List<LmisAttendanceDaily> lsRoot = ListUtils.intersection(
					LmisAttendanceDailyUtil.findByRootID(rootId), (ListUtils
							.intersection(LmisAttendanceDailyUtil
									.findByDaySmaller(date2),
									LmisAttendanceDailyUtil
											.findByDayGreater(date1))));
		

			@SuppressWarnings("unchecked")
			List<LmisAttendanceDaily> lsUser = ListUtils.intersection(
					LmisAttendanceDailyUtil.findByUserID(userId), (ListUtils
							.intersection(LmisAttendanceDailyUtil
									.findByDaySmaller(date2),
									LmisAttendanceDailyUtil
											.findByDayGreater(date1))));
		
			ls = ListUtils.intersection(lsRoot, lsUser);
			List<LmisAttendanceDaily> lsAbs= LmisAttendanceDailyUtil.findByabsenceValueGreater(0.0);
			System.out.println("lsAbs  "+ lsAbs);
			List<LmisAttendanceDaily> lsResult = ListUtils.intersection(ls,lsAbs);

			return lsResult;
		} catch (SystemException e) {
			System.out
					.println("Error in LmisAttendanceDailyLocalServiceImpl.getListDetailsDayOff "
							+ e.toString());
			return null;
		}
	}
	
	public double caculateTotalDayOffDontHavePermission_(
			int userId, int rootId) throws SystemException {
		try {
			double result = LmisAttendanceDailyFinderUtil.caculateTotalDayOffDontHavePermission_(userId, rootId)	;
			System.out
					.println("Success LmisAttendanceDailyUtil.caculateTotalDayOffDontHavePermission_ ");
			return result;

		} catch (Exception e) {
			System.out
					.println("Error LmisAttendanceDailyUtil.caculateTotalDayOffDontHavePermission_  "
							+ e.toString());
		}
		return 0;
	}
	
	public double caculateTotalDayOffHavePermission_(
			int userId, int rootId) throws SystemException {
		try {
			double result = LmisAttendanceDailyFinderUtil.caculateTotalDayOffHavePermission_(userId, rootId);
			System.out
					.println("Success LmisAttendanceDailyUtil.caculateTotalDayOffHavePermission_ ");
			return result;

		} catch (Exception e) {
			System.out
					.println("Error LmisAttendanceDailyUtil.caculateTotalDayOffHavePermission_  "
							+ e.toString());
		}
		return 0;
	}
	
	public double getTotalDayOffInMonth_(int userId, int rootId)  throws SystemException {
		try {
			double result = LmisAttendanceDailyFinderUtil.getTotalDayOffInMonth_(userId, rootId);
			System.out
					.println("Success LmisAttendanceDailyLocalServiceImpl.getTotalDayOffInMonth_ ");
			return result;

		} catch (Exception e) {
			System.out
					.println("Error LmisAttendanceDailyLocalServiceImpl.getTotalDayOffInMonth_  "
							+ e.toString());
		}
		return 0;
	}
	
	

}