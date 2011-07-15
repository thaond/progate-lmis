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

import java.util.List;

import org.apache.commons.collections.ListUtils;

import larion.progate.lmis.model.LmisAbsenceYearly;
import larion.progate.lmis.service.base.LmisAbsenceYearlyLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisAbsenceYearlyUtil;
import larion.progate.lmis.service.utils.LmisConst;

/**
 * <a href="LmisAbsenceYearlyLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class LmisAbsenceYearlyLocalServiceImpl extends
		LmisAbsenceYearlyLocalServiceBaseImpl {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * larion.progate.lmis.service.LLmisAbsenceYearlyLocalService#getNumDayOff(int,
	 * int, int, int) tong so ngay 'loai nghi phep thuong nien' da nghi trong nam
	 */

	public double getNumDayOff(int userId, int year, int rootId)
			throws com.liferay.portal.SystemException {
		try {
			List<LmisAbsenceYearly> lsUser = LmisAbsenceYearlyUtil
					.findByuserID(userId);
			List<LmisAbsenceYearly> lsYear = LmisAbsenceYearlyUtil
					.findByYearValue(year);
			List<LmisAbsenceYearly> lsRoot = LmisAbsenceYearlyUtil
					.findByRootID(rootId);
			List<LmisAbsenceYearly> lsType = LmisAbsenceYearlyUtil
					.findByAbsenceType(LmisConst.Num_Day_Off_Each_Year);
			List<LmisAbsenceYearly> lsTmp = ListUtils.intersection(lsUser,
					lsYear);
			List<LmisAbsenceYearly> ls = ListUtils.intersection(lsTmp, lsRoot);
			List<LmisAbsenceYearly> lsResult = ListUtils.intersection(lsType,
					ls);
			return (lsResult.get(0).getTotalDay());

		} catch (Exception e) {
			System.out.println("Error : " + e.toString());

		}
		return 0;
	}

	/**
	 * @param userId
	 * @param year
	 * @param rootId
	 * @return
	 * @throws com.liferay.portal.SystemException
	 * Tong so ngay nghi "Loai nghi phep thuong nien nam truoc da nghi"
	 */
	public double getNumDayOffEachYearLastYear(int userId, int year, int rootId)
			throws com.liferay.portal.SystemException {
		try {
			List<LmisAbsenceYearly> lsUser = LmisAbsenceYearlyUtil
					.findByuserID(userId);
			List<LmisAbsenceYearly> lsYear = LmisAbsenceYearlyUtil
					.findByYearValue(year);
			List<LmisAbsenceYearly> lsRoot = LmisAbsenceYearlyUtil
					.findByRootID(rootId);
			List<LmisAbsenceYearly> lsType = LmisAbsenceYearlyUtil
					.findByAbsenceType(LmisConst.Num_Day_Off_Each_Year_Last_Year);
			List<LmisAbsenceYearly> lsTmp = ListUtils.intersection(lsUser,
					lsYear);
			List<LmisAbsenceYearly> ls = ListUtils.intersection(lsTmp, lsRoot);
			List<LmisAbsenceYearly> lsResult = ListUtils.intersection(lsType,
					ls);
			return (lsResult.get(0).getTotalDay());

		} catch (Exception e) {
			System.out.println("Error at LmisAbsenceYearly.getNumDayOffEachYearLastYear : " + e.toString());

		}
		return 0;
	}
	
}