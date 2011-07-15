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

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.ListUtils;
import larion.progate.lmis.model.LmisAttMonthly;
import larion.progate.lmis.service.base.LmisAttMonthlyLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisAttMonthlyUtil;


/**
 * @author tienld
 *
 */

public class LmisAttMonthlyLocalServiceImpl
	extends LmisAttMonthlyLocalServiceBaseImpl {
	
/*	 (non-Javadoc)
	 * @see larion.progate.lmis.service.LmisAttMonthlyLocalService#getTotalEndTimeEarly(int)
	 * tong thoi gian ve som (phut)*/
	 
	@Override
	public int getTotalEndTimeEarly(int userId, int month, int year, int rootId)
			throws com.liferay.portal.SystemException {
		try {
			List<LmisAttMonthly> lsUser = LmisAttMonthlyUtil
					.findByUserId(userId);
			List<LmisAttMonthly> lsMonth = LmisAttMonthlyUtil
					.findByMonthValue(month);
			List<LmisAttMonthly> lsYear = LmisAttMonthlyUtil
					.findByYearValue(year);
			List<LmisAttMonthly> lsRoot = LmisAttMonthlyUtil
					.findByRootId(rootId);
			List<LmisAttMonthly> lsTmp = ListUtils
					.intersection(lsMonth, lsYear);
			List<LmisAttMonthly> ls = ListUtils.intersection(lsTmp, lsRoot);
			List<LmisAttMonthly> lsResult = ListUtils.intersection(lsUser, ls);
			return lsResult.get(0).getTotalTimeEarly();
		} catch (Exception e) {
			System.out.println("Error at LmisAttMonthly.getTotalEndTimeEarly  : " + e.toString());
		}
		return 0; 
	}
	
/*	 (non-Javadoc)
	 * @see larion.progate.lmis.service.LmisAttMonthlyLocalService#getTotalStartTimeLately(int)
	 * Tong thoi gian di tre(phut)*/
	 
	@Override
	public int getTotalStartTimeLately(int userId, int month, int year,
			int rootId) throws com.liferay.portal.SystemException {
		try {
			List<LmisAttMonthly> lsUser = LmisAttMonthlyUtil
					.findByUserId(userId);
			List<LmisAttMonthly> lsMonth = LmisAttMonthlyUtil
					.findByMonthValue(month);
			List<LmisAttMonthly> lsYear = LmisAttMonthlyUtil
					.findByYearValue(year);
			List<LmisAttMonthly> lsRoot = LmisAttMonthlyUtil
					.findByRootId(rootId);
			List<LmisAttMonthly> lsTmp = ListUtils
					.intersection(lsMonth, lsYear);
			List<LmisAttMonthly> ls = ListUtils.intersection(lsTmp, lsRoot);
			List<LmisAttMonthly> lsResult = ListUtils.intersection(lsUser, ls);
			return lsResult.get(0).getTotalTimeLate();
		} catch (Exception e) {
			System.out.println("Error at LmisAttMonthly.getTotalStartTimeLately  : " + e.toString());
		}
		return 0;
	}
	
	/* (non-Javadoc)
	 * @see larion.progate.lmis.service.LmisAttMonthlyLocalService#getTotalStartTimeLately(int)
	 * Thoi gian bat dau trung binh trong thang*/
	 

	public Date getMonthStartTimeAvg(int userId, int month, int year, int rootId)
			throws com.liferay.portal.SystemException {	
		try{
			List<LmisAttMonthly> lsUser = LmisAttMonthlyUtil
					.findByUserId(userId);
			List<LmisAttMonthly> lsMonth = LmisAttMonthlyUtil
					.findByMonthValue(month);
			List<LmisAttMonthly> lsYear = LmisAttMonthlyUtil
					.findByYearValue(year);
			List<LmisAttMonthly> lsRoot = LmisAttMonthlyUtil
					.findByRootId(rootId);
			List<LmisAttMonthly> lsTmp = ListUtils
					.intersection(lsMonth, lsYear);
			List<LmisAttMonthly> ls = ListUtils.intersection(lsTmp, lsRoot);
			List<LmisAttMonthly> lsResult = ListUtils.intersection(lsUser, ls);
			return lsResult.get(0).getStartTimeAverage();	
	} catch (Exception e) {
		System.out.println("Error at LmisAttMonthly.getMonthStartTimeAvg : " + e.toString());

	}
	return null;
}
	
/*	 (non-Javadoc)
	 * @see larion.progate.lmis.service.LmisAttMonthlyLocalService#getTotalStartTimeLately(int)
	 * Thoi gian ket thuc trung binh trong thang*/
	 
	@Override
	public Date getMonthEndTimeAvg(int userId, int month, int year, int rootId)
			throws com.liferay.portal.SystemException {
		try{
			List<LmisAttMonthly> lsUser = LmisAttMonthlyUtil
					.findByUserId(userId);
			List<LmisAttMonthly> lsMonth = LmisAttMonthlyUtil
					.findByMonthValue(month);
			List<LmisAttMonthly> lsYear = LmisAttMonthlyUtil
					.findByYearValue(year);
			List<LmisAttMonthly> lsRoot = LmisAttMonthlyUtil
					.findByRootId(rootId);
			List<LmisAttMonthly> lsTmp = ListUtils
					.intersection(lsMonth, lsYear);
			List<LmisAttMonthly> ls = ListUtils.intersection(lsTmp, lsRoot);
			List<LmisAttMonthly> lsResult = ListUtils.intersection(lsUser, ls);
			return lsResult.get(0).getEndTimeAverage();
		
	} catch (Exception e) {
		System.out.println("Error at LmisAttMonthly.getMonthEndTimeAvg : " + e.toString());

	}
	return null;
}
	 /*(non-Javadoc)
	 * @see larion.progate.lmis.service.LmisAttMonthlyLocalService#getTotalStartTimeLately(int)
	 * So phut di tre bi phat*/
	 
	@Override
	public int getTotalStartTimeLatePernalty(int userId, int month, int year,
			int rootId) throws com.liferay.portal.SystemException {
		try {
			List<LmisAttMonthly> lsUser = LmisAttMonthlyUtil
					.findByUserId(userId);
			List<LmisAttMonthly> lsMonth = LmisAttMonthlyUtil
					.findByMonthValue(month);
			List<LmisAttMonthly> lsYear = LmisAttMonthlyUtil
					.findByYearValue(year);
			List<LmisAttMonthly> lsRoot = LmisAttMonthlyUtil
					.findByRootId(rootId);
			List<LmisAttMonthly> lsTmp = ListUtils
					.intersection(lsMonth, lsYear);
			List<LmisAttMonthly> ls = ListUtils.intersection(lsTmp, lsRoot);
			List<LmisAttMonthly> lsResult = ListUtils.intersection(lsUser, ls);
			return lsResult.get(0).getTotalTimeLatePenalty();
		} catch (Exception e) {
			System.out.println("Error at LmisAttMonthly.getTotalStartTimeLatePernalty  : " + e.toString());
		}
		return 0;
	}
	/* (non-Javadoc)
	 * @see larion.progate.lmis.service.LmisAttMonthlyLocalService#getTotalStartTimeLately(int)
	 * So phut di tre da nhan he so*/
	 
	@Override
	public double getTotalStartTimeLateFinal(int userId, int month, int year,
			int rootId) throws com.liferay.portal.SystemException {
		try {
			List<LmisAttMonthly> lsUser = LmisAttMonthlyUtil
					.findByUserId(userId);
			List<LmisAttMonthly> lsMonth = LmisAttMonthlyUtil
					.findByMonthValue(month);
			List<LmisAttMonthly> lsYear = LmisAttMonthlyUtil
					.findByYearValue(year);
			List<LmisAttMonthly> lsRoot = LmisAttMonthlyUtil
					.findByRootId(rootId);
			List<LmisAttMonthly> lsTmp = ListUtils
					.intersection(lsMonth, lsYear);
			List<LmisAttMonthly> ls = ListUtils.intersection(lsTmp, lsRoot);
			List<LmisAttMonthly> lsResult = ListUtils.intersection(lsUser, ls);
			return lsResult.get(0).getTotalTimeLateFinal();
		} catch (Exception e) {
			System.out.println("Error : " + e.toString());
		}
		return 0;
	}
	
	/**
	 * @param userId
	 * @return int
	 * @throws com.liferay.portal.SystemException
	 * so phut ve som bi phat
	 */
	@Override
	public int getTotalEndTimeEarlyPernalty(int userId,int month, int year,int rootId) throws com.liferay.portal.SystemException {
		try{
		List<LmisAttMonthly> lsUser =  LmisAttMonthlyUtil.findByUserId(userId);
		List<LmisAttMonthly> lsMonth =  LmisAttMonthlyUtil.findByMonthValue(month);
		List<LmisAttMonthly> lsYear=  LmisAttMonthlyUtil.findByYearValue(year);
		List<LmisAttMonthly> lsRoot =  LmisAttMonthlyUtil.findByRootId(rootId);
		List<LmisAttMonthly> lsTmp=  ListUtils.intersection(lsMonth, lsYear);
		List<LmisAttMonthly> ls=  ListUtils.intersection(lsTmp, lsRoot);
		List<LmisAttMonthly> lsResult=  ListUtils.intersection(lsUser, ls);
		return lsResult.get(0).getTotalTimeEarlyPenalty();
		} catch (Exception e) {
			System.out.println("Error at LmisAttMonthly.getTotalEndTimeEarlyPernalty  : " + e.toString());
		}
		return 0;
	}
	/**
	 * @param userId
	 * @return double
	 * @throws com.liferay.portal.SystemException
	 * so phut ve som bi phat
	 */
	@Override
	public double getTotalEndTimeEarlyFinal(int userId,int month,int year,int rootId) throws com.liferay.portal.SystemException {
		try{
		List<LmisAttMonthly> lsUser =  LmisAttMonthlyUtil.findByUserId(userId);
		List<LmisAttMonthly> lsMonth =  LmisAttMonthlyUtil.findByMonthValue(month);
		List<LmisAttMonthly> lsYear=  LmisAttMonthlyUtil.findByYearValue(year);
		List<LmisAttMonthly> lsRoot =  LmisAttMonthlyUtil.findByRootId(rootId);
		List<LmisAttMonthly> lsTmp=  ListUtils.intersection(lsMonth, lsYear);
		List<LmisAttMonthly> ls=  ListUtils.intersection(lsTmp, lsRoot);
		List<LmisAttMonthly> lsResult=  ListUtils.intersection(lsUser, ls);
		return lsResult.get(0).getTotalTimeEarlyFinal();
		} catch (Exception e) {
			System.out.println("Error : " + e.toString());

		}
		return 0;
	}
	/**
	 * @param userId
	 * @return double
	 * @throws com.liferay.portal.SystemException
	 * so gio tang ca trong thang
	 */
	@Override
	public double getTotalOverTime(int userId, int month, int year, int rootId)
			throws com.liferay.portal.SystemException {
		try {
			List<LmisAttMonthly> lsUser = LmisAttMonthlyUtil
					.findByUserId(userId);
			List<LmisAttMonthly> lsMonth = LmisAttMonthlyUtil
					.findByMonthValue(month);
			List<LmisAttMonthly> lsYear = LmisAttMonthlyUtil
					.findByYearValue(year);
			List<LmisAttMonthly> lsRoot = LmisAttMonthlyUtil
					.findByRootId(rootId);
			List<LmisAttMonthly> lsTmp = ListUtils
					.intersection(lsMonth, lsYear);
			List<LmisAttMonthly> ls = ListUtils.intersection(lsTmp, lsRoot);
			List<LmisAttMonthly> lsResult = ListUtils.intersection(lsUser, ls);
			return lsResult.get(0).getTotalOvertime();
		} catch (Exception e) {
			System.out.println("Error : " + e.toString());

		}
		return 0;
	}
	
	/**
	 * @param userId
	 * @return double
	 * @throws com.liferay.portal.SystemException
	 * so gio tang ca da nhan he so
	 */
	@Override
	public double getTotalOverTimeFinal(int userId, int month, int year,
			int rootId) throws com.liferay.portal.SystemException {
		try {
			List<LmisAttMonthly> lsUser = LmisAttMonthlyUtil
					.findByUserId(userId);
			List<LmisAttMonthly> lsMonth = LmisAttMonthlyUtil
					.findByMonthValue(month);
			List<LmisAttMonthly> lsYear = LmisAttMonthlyUtil
					.findByYearValue(year);
			List<LmisAttMonthly> lsRoot = LmisAttMonthlyUtil
					.findByRootId(rootId);
			List<LmisAttMonthly> lsTmp = ListUtils
					.intersection(lsMonth, lsYear);
			List<LmisAttMonthly> ls = ListUtils.intersection(lsTmp, lsRoot);
			List<LmisAttMonthly> lsResult = ListUtils.intersection(lsUser, ls);
			return lsResult.get(0).getTotalOvertimeFinal();
		} catch (Exception e) {
			System.out.println("Error : " + e.toString());

		}
		return 0;
	}

	/**
	 * @param userId
	 * @return double
	 * @throws com.liferay.portal.SystemException
	 * so ngay nghi bu tang ca duoc huong trong thang nay
	 */
	
	@Override
	public double getTotalDayCompensation(int userId, int month, int year,
			int rootId) throws com.liferay.portal.SystemException {
		try {
			List<LmisAttMonthly> lsUser = LmisAttMonthlyUtil
					.findByUserId(userId);
			List<LmisAttMonthly> lsMonth = LmisAttMonthlyUtil
					.findByMonthValue(month);
			List<LmisAttMonthly> lsYear = LmisAttMonthlyUtil
					.findByYearValue(year);
			List<LmisAttMonthly> lsRoot = LmisAttMonthlyUtil
					.findByRootId(rootId);
			List<LmisAttMonthly> lsTmp = ListUtils
					.intersection(lsMonth, lsYear);
			List<LmisAttMonthly> ls = ListUtils.intersection(lsTmp, lsRoot);
			List<LmisAttMonthly> lsResult = ListUtils.intersection(lsUser, ls);
			return lsResult.get(0).getTotalDayCompensationNextMonth();
		} catch (Exception e) {
			System.out.println("Error : " + e.toString());

		}
		return 0;
	}

	/**
	 * @param userId
	 * @return double
	 * @throws com.liferay.portal.SystemExceptiono ngay 
	 * so ngay da nghi bu tang ca trong thang
	 */
	@Override
	public double getTotalDayOffCompensation(int userId,int month, int year,int rootId) throws com.liferay.portal.SystemException {
		try{
		List<LmisAttMonthly> lsUser =  LmisAttMonthlyUtil.findByUserId(userId);
		List<LmisAttMonthly> lsMonth =  LmisAttMonthlyUtil.findByMonthValue(month);
		List<LmisAttMonthly> lsYear=  LmisAttMonthlyUtil.findByYearValue(year);
		List<LmisAttMonthly> lsRoot =  LmisAttMonthlyUtil.findByRootId(rootId);
		List<LmisAttMonthly> lsTmp=  ListUtils.intersection(lsMonth, lsYear);
		List<LmisAttMonthly> ls=  ListUtils.intersection(lsTmp, lsRoot);
		List<LmisAttMonthly> lsResult=  ListUtils.intersection(lsUser, ls);
		return lsResult.get(0).getTotalDayOffCompensation();
	} catch (Exception e) {
		System.out.println("Error : " + e.toString());

	}
	return 0;
}
	
	/**
	 * @param userId
	 * @return double
	 * @throws com.liferay.portal.SystemExceptiono ngay 
	 * so ngay da nghi bu tang ca con lai trong thang
	 */
	
	@Override
	public double getTotalDayCompensationRemain(int userId, int month,	int year, int rootId) throws com.liferay.portal.SystemException {
		try {
			List<LmisAttMonthly> lsUser = LmisAttMonthlyUtil
					.findByUserId(userId);
			List<LmisAttMonthly> lsMonth = LmisAttMonthlyUtil
					.findByMonthValue(month);
			List<LmisAttMonthly> lsYear = LmisAttMonthlyUtil
					.findByYearValue(year);
			List<LmisAttMonthly> lsRoot = LmisAttMonthlyUtil
					.findByRootId(rootId);
			List<LmisAttMonthly> lsTmp = ListUtils
					.intersection(lsMonth, lsYear);
			List<LmisAttMonthly> ls = ListUtils.intersection(lsTmp, lsRoot);
			List<LmisAttMonthly> lsResult = ListUtils.intersection(lsUser, ls);
			return (lsResult.get(0).getTotalDayCompensation() - lsResult.get(0)
					.getTotalDayOffCompensation());
		} catch (Exception e) {
			System.out.println("Error : " + e.toString());

		}
		return 0;
	}
	
	/**
	 * @param userId
	 * @return double
	 * @throws com.liferay.portal.SystemExceptiono ngay 
	 * Số ngày nghỉ bù tăng ca chuyển sang tháng sau
	 */
	@Override
	public double getTotalDayCompensationNextMOnth(int userId,int month,int year,int rootId) throws com.liferay.portal.SystemException {
		try {
			List<LmisAttMonthly> lsUser = LmisAttMonthlyUtil
					.findByUserId(userId);
			List<LmisAttMonthly> lsMonth = LmisAttMonthlyUtil
					.findByMonthValue(month);
			List<LmisAttMonthly> lsYear = LmisAttMonthlyUtil
					.findByYearValue(year);
			List<LmisAttMonthly> lsRoot = LmisAttMonthlyUtil
					.findByRootId(rootId);
			List<LmisAttMonthly> lsTmp = ListUtils
					.intersection(lsMonth, lsYear);
			List<LmisAttMonthly> ls = ListUtils.intersection(lsTmp, lsRoot);
			List<LmisAttMonthly> lsResult = ListUtils.intersection(lsUser, ls);
			return (lsResult.get(0).getTotalDayCompensationNextMonth());
		} catch (Exception e) {
			System.out.println("Error : " + e.toString());

		}
		return 0;
	}
	
	/**
	 * @param userId
	 * @return double
	 * @throws com.liferay.portal.SystemExceptiono ngay 
	 * Số gio thuong / so gio phat
	 */
	@Override
	public double getTotalTimeFinal(int userId, int month, int year, int rootId)
			throws com.liferay.portal.SystemException {
		try {
			List<LmisAttMonthly> lsUser = LmisAttMonthlyUtil
					.findByUserId(userId);
			List<LmisAttMonthly> lsMonth = LmisAttMonthlyUtil
					.findByMonthValue(month);
			List<LmisAttMonthly> lsYear = LmisAttMonthlyUtil
					.findByYearValue(year);
			List<LmisAttMonthly> lsRoot = LmisAttMonthlyUtil
					.findByRootId(rootId);
			List<LmisAttMonthly> lsTmp = ListUtils
					.intersection(lsMonth, lsYear);
			List<LmisAttMonthly> ls = ListUtils.intersection(lsTmp, lsRoot);
			List<LmisAttMonthly> lsResult = ListUtils.intersection(lsUser, ls);
			return (lsResult.get(0).getTotalTimeFinal());
		} catch (Exception e) {
			System.out.println("Error : " + e.toString());

		}
		return 0;
	}
	
	
	/**
	 * @param userId
	 * @return double
	 * @throws com.liferay.portal.SystemExceptiono ngay 
	 * Số ngay duoc thuong
	 */
	
	@Override
	public double getNumDayAward(int userId, int month, int year, int rootId)
			throws com.liferay.portal.SystemException {
		try {
			List<LmisAttMonthly> lsUser = LmisAttMonthlyUtil
					.findByUserId(userId);
			List<LmisAttMonthly> lsMonth = LmisAttMonthlyUtil
					.findByMonthValue(month);
			List<LmisAttMonthly> lsYear = LmisAttMonthlyUtil
					.findByYearValue(year);
			List<LmisAttMonthly> lsRoot = LmisAttMonthlyUtil
					.findByRootId(rootId);
			List<LmisAttMonthly> lsTmp = ListUtils
					.intersection(lsMonth, lsYear);
			List<LmisAttMonthly> ls = ListUtils.intersection(lsTmp, lsRoot);
			List<LmisAttMonthly> lsResult = ListUtils.intersection(lsUser, ls);
			return (lsResult.get(0).getNumDayAward());
		} catch (Exception e) {
			System.out.println("Error : " + e.toString());

		}
		return 0;
	}
	
	
	/**
	 * @param userId
	 * @param year
	 * @return double
	 * @throws com.liferay.portal.SystemException
	 */




	
	
	
	/**
	 * @param userId
	 * @param year
	 * @return double
	 * @throws com.liferay.portal.SystemException
	 * tong so ngay nghi trong thang
	 */
	
	@Override
	public double getTotalDayOffInMonth(int userId, int month, int year,
			int rootId) throws com.liferay.portal.SystemException {
		try {

			List<LmisAttMonthly> lsUser = LmisAttMonthlyUtil
					.findByUserId(userId);
			List<LmisAttMonthly> lsMonth = LmisAttMonthlyUtil
					.findByMonthValue(month);
			List<LmisAttMonthly> lsYear = LmisAttMonthlyUtil
					.findByYearValue(year);
			List<LmisAttMonthly> lsRoot = LmisAttMonthlyUtil
					.findByRootId(rootId);
			List<LmisAttMonthly> lsTmp = ListUtils
					.intersection(lsMonth, lsYear);
			List<LmisAttMonthly> ls = ListUtils.intersection(lsTmp, lsRoot);
			List<LmisAttMonthly> lsResult = ListUtils.intersection(lsUser, ls);
			return lsResult.get(0).getTotalDayOff();
		} catch (Exception e) {
			System.out.println("Error : " + e.toString());

		}
		return 0;
	}
	


	
}