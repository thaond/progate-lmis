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




import larion.progate.lmis.model.LmisAttYearly;
import larion.progate.lmis.service.LmisAbsenceYearlyLocalServiceUtil;
import larion.progate.lmis.service.base.LmisAttYearlyLocalServiceBaseImpl;



import larion.progate.lmis.service.persistence.LmisAttYearlyUtil;

/**
 * <a href="LmisAttYearlyLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAttYearlyLocalServiceImpl
	extends LmisAttYearlyLocalServiceBaseImpl {
	
	/**
	 * @param userId
	 * @param year
	 * @return Date
	 * @throws com.liferay.portal.SystemException
	 * Thoi gian bat dau lam viec trung binh trong nam
	 */
	@Override
	public Date getYearStartTimeAvg(int userId,int year,int rootId) throws com.liferay.portal.SystemException {
		try{
		List<LmisAttYearly> lsRoot =  LmisAttYearlyUtil.findByRootId(rootId);
		List<LmisAttYearly> lsUser =  LmisAttYearlyUtil.findByUserId(userId);	
		List<LmisAttYearly> lsYear=  LmisAttYearlyUtil.findByYearValue(year);	
		List<LmisAttYearly> ls=  ListUtils.intersection(lsUser, lsYear);
		List<LmisAttYearly> lsResult=  ListUtils.intersection(ls,lsRoot);
		return lsResult.get(0).getStartTimeAverage();
	} catch (Exception e) {
		System.out.println("Error at LmisAttYearly.getYearStartTimeAvg  : " + e.toString());

	}
	return null;
}
	
	/**
	 * @param userId
	 * @param year
	 * @return
	 * @throws com.liferay.portal.SystemException
	 * Thoi gian ket thuc lam viec trung binh trong nam
	 */
	@Override
	public Date getYearEndTimeAvg(int userId,int  year,int rootId) throws com.liferay.portal.SystemException {
		try{
			
		List<LmisAttYearly> lsRoot =  LmisAttYearlyUtil.findByRootId(rootId);
		List<LmisAttYearly> lsUser =  LmisAttYearlyUtil.findByUserId(userId);	
		List<LmisAttYearly> lsYear=  LmisAttYearlyUtil.findByYearValue(year);		
		List<LmisAttYearly> ls=  ListUtils.intersection(lsUser, lsYear);
		List<LmisAttYearly> lsResult=  ListUtils.intersection(ls,lsRoot);
		return lsResult.get(0).getEndTimeAverage();
	} catch (Exception e) {
		System.out.println("Error at LmisAttYearly.getYearEndTimeAvg  : " + e.toString());

	}
	return null;
}
	/**
	 * @param userId
	 * @param year
	 * @return
	 * @throws com.liferay.portal.SystemException
	 * Tong so ngay lam viec trong nam
	 */
	@Override
	public int getYearTotalWorkingDate(int userId , int year,int rootId ) throws com.liferay.portal.SystemException {
		try{
		List<LmisAttYearly> lsRoot =  LmisAttYearlyUtil.findByRootId(rootId);
		List<LmisAttYearly> lsUser =  LmisAttYearlyUtil.findByUserId(userId);	
		List<LmisAttYearly> lsYear=  LmisAttYearlyUtil.findByYearValue(year);		
		List<LmisAttYearly> ls=  ListUtils.intersection(lsUser, lsYear);
		List<LmisAttYearly> lsResult=  ListUtils.intersection(ls,lsRoot);
		return lsResult.get(0).getTotalWorkingDay();
		
		} catch (Exception e) {
			System.out.println("Error at LmisAttYearly.getYearTotalWorkingDate  : " + e.toString());

		}
		return 0;
	}
	
	
	/**
	 * @param userId
	 * @param year
	 * @param rootId
	 * @return
	 * @throws com.liferay.portal.SystemException
	 * tong so ngay nghi phep loai " thuong nien nam truoc" con lai
	 */
	@Override
	public double getNumDayOffEachYearRemain(int userId, int year, int rootId)
			throws com.liferay.portal.SystemException {
		try {
			List<LmisAttYearly> lsUser = LmisAttYearlyUtil.findByUserId(userId);
			List<LmisAttYearly> lsYear = LmisAttYearlyUtil
					.findByYearValue(year);
			List<LmisAttYearly> lsRoot = LmisAttYearlyUtil.findByRootId(rootId);
			List<LmisAttYearly> lsTmp = ListUtils.intersection(lsUser, lsYear);
			List<LmisAttYearly> ls = ListUtils.intersection(lsTmp, lsRoot);

			return (ls.get(0).getTotalDayAwardPrevYear());

		} catch (Exception e) {
			System.out.println("Error at LmisAttYearly.getNumDayOffEachYearRemain  : " + e.toString());

		}
		return 0;
	}
	
	/* (non-Javadoc)
	 * @see larion.progate.lmis.service.LmisAttYearlyLocalService#getNumDayOffEachYear(int, int, int)
	 * tong so ngay nghi phep thuong nien moi nam co
	 */
	@Override
	public double getNumDayOffEachYear(int userId, int year, int rootId)
			throws com.liferay.portal.SystemException {
	
		try {
	
			List<LmisAttYearly> lsRoot = LmisAttYearlyUtil.findByRootId(rootId);
			List<LmisAttYearly> lsYear = LmisAttYearlyUtil.findByYearValue(year);
			List<LmisAttYearly> lsU = LmisAttYearlyUtil.findByUserId(userId);		
			List<LmisAttYearly> ls = ListUtils.intersection(lsRoot, lsYear);
			List<LmisAttYearly> lsResult = ListUtils.intersection(lsU, ls);
			double denta= LmisAbsenceYearlyLocalServiceUtil.getNumDayOff(userId,  year,  rootId);
			System.out.println("denta  = "+ denta);
			return (ls.get(0).getTotalDayAwardPrevYear()+ ls.get(0).getTotalDayAward()+ ls.get(0).getTotalDayRemaining()+denta);
		} catch (Exception e) {
			System.out.println("Error at LmisAttYearly.getNumDayOffEachYear : " + e.toString());

		}
		return 0;
	}
	
	/**
	 * @param userId
	 * @param year
	 * @param rootId
	 * @return
	 * @throws com.liferay.portal.SystemException
	 * Tong so ngay nghi thuong nien nam nay
	 */
	@Override
	public double getNumDayOffEachYearThisYear(int userId, int year, int rootId)
			throws com.liferay.portal.SystemException {

		try {

			List<LmisAttYearly> lsRoot = LmisAttYearlyUtil.findByRootId(rootId);
			List<LmisAttYearly> lsYear = LmisAttYearlyUtil
					.findByYearValue(year);
			List<LmisAttYearly> lsU = LmisAttYearlyUtil.findByUserId(userId);
			List<LmisAttYearly> ls = ListUtils.intersection(lsRoot, lsYear);
			List<LmisAttYearly> lsResult = ListUtils.intersection(lsU, ls);
			return (ls.get(0).getTotalDayAward());
		} catch (Exception e) {
			System.out.println("Error at LmisAttYearly.getNumDayOffEachYearThisYear  : " + e.toString());

		}
		return 0;
	}
	
	/**
	 * @param userId
	 * @param year
	 * @param rootId
	 * @return
	 * @throws com.liferay.portal.SystemException
	 * Tong so ngay nghi thuong nien con lai trong nam nay
	 */
	@Override
	public double getNumDayOffEachYearThisYearRemain(int userId, int year,
			int rootId) throws com.liferay.portal.SystemException {

		try {

			List<LmisAttYearly> lsRoot = LmisAttYearlyUtil.findByRootId(rootId);
			List<LmisAttYearly> lsYear = LmisAttYearlyUtil
					.findByYearValue(year);
			List<LmisAttYearly> lsU = LmisAttYearlyUtil.findByUserId(userId);
			List<LmisAttYearly> ls = ListUtils.intersection(lsRoot, lsYear);
			List<LmisAttYearly> lsResult = ListUtils.intersection(lsU, ls);
			return (ls.get(0).getTotalDayRemaining());
		} catch (Exception e) {
			System.out.println("Error at LmisAttYearly.getNumDayOffEachYearThisYearRemain: " + e.toString());

		}
		return 0;
	}
}