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

package larion.progate.lmis.service.persistence;

/**
 * <a href="LmisAbsenceYearlyUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAbsenceYearlyUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisAbsenceYearly lmisAbsenceYearly) {
		getPersistence().cacheResult(lmisAbsenceYearly);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> lmisAbsenceYearlies) {
		getPersistence().cacheResult(lmisAbsenceYearlies);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisAbsenceYearly create(
		java.lang.Integer lmisAbsenceYearlyId) {
		return getPersistence().create(lmisAbsenceYearlyId);
	}

	public static larion.progate.lmis.model.LmisAbsenceYearly remove(
		java.lang.Integer lmisAbsenceYearlyId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException {
		return getPersistence().remove(lmisAbsenceYearlyId);
	}

	public static larion.progate.lmis.model.LmisAbsenceYearly remove(
		larion.progate.lmis.model.LmisAbsenceYearly lmisAbsenceYearly)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisAbsenceYearly);
	}

	public static larion.progate.lmis.model.LmisAbsenceYearly update(
		larion.progate.lmis.model.LmisAbsenceYearly lmisAbsenceYearly)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisAbsenceYearly);
	}

	public static larion.progate.lmis.model.LmisAbsenceYearly update(
		larion.progate.lmis.model.LmisAbsenceYearly lmisAbsenceYearly,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisAbsenceYearly, merge);
	}

	public static larion.progate.lmis.model.LmisAbsenceYearly updateImpl(
		larion.progate.lmis.model.LmisAbsenceYearly lmisAbsenceYearly,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisAbsenceYearly, merge);
	}

	public static larion.progate.lmis.model.LmisAbsenceYearly findByPrimaryKey(
		java.lang.Integer lmisAbsenceYearlyId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException {
		return getPersistence().findByPrimaryKey(lmisAbsenceYearlyId);
	}

	public static larion.progate.lmis.model.LmisAbsenceYearly fetchByPrimaryKey(
		java.lang.Integer lmisAbsenceYearlyId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisAbsenceYearlyId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findByRootID(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceYearly findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException {
		return getPersistence().findByRootID_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceYearly findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException {
		return getPersistence().findByRootID_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceYearly[] findByRootID_PrevAndNext(
		java.lang.Integer lmisAbsenceYearlyId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException {
		return getPersistence()
				   .findByRootID_PrevAndNext(lmisAbsenceYearlyId, rootId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findByuserID(
		int userId) throws com.liferay.portal.SystemException {
		return getPersistence().findByuserID(userId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findByuserID(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByuserID(userId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findByuserID(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByuserID(userId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceYearly findByuserID_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException {
		return getPersistence().findByuserID_First(userId, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceYearly findByuserID_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException {
		return getPersistence().findByuserID_Last(userId, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceYearly[] findByuserID_PrevAndNext(
		java.lang.Integer lmisAbsenceYearlyId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException {
		return getPersistence()
				   .findByuserID_PrevAndNext(lmisAbsenceYearlyId, userId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findByYearValue(
		int yearValue) throws com.liferay.portal.SystemException {
		return getPersistence().findByYearValue(yearValue);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findByYearValue(
		int yearValue, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByYearValue(yearValue, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findByYearValue(
		int yearValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByYearValue(yearValue, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceYearly findByYearValue_First(
		int yearValue, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException {
		return getPersistence().findByYearValue_First(yearValue, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceYearly findByYearValue_Last(
		int yearValue, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException {
		return getPersistence().findByYearValue_Last(yearValue, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceYearly[] findByYearValue_PrevAndNext(
		java.lang.Integer lmisAbsenceYearlyId, int yearValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException {
		return getPersistence()
				   .findByYearValue_PrevAndNext(lmisAbsenceYearlyId, yearValue,
			obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findByAbsenceType(
		java.lang.String absenceType) throws com.liferay.portal.SystemException {
		return getPersistence().findByAbsenceType(absenceType);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findByAbsenceType(
		java.lang.String absenceType, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByAbsenceType(absenceType, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findByAbsenceType(
		java.lang.String absenceType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByAbsenceType(absenceType, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceYearly findByAbsenceType_First(
		java.lang.String absenceType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException {
		return getPersistence().findByAbsenceType_First(absenceType, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceYearly findByAbsenceType_Last(
		java.lang.String absenceType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException {
		return getPersistence().findByAbsenceType_Last(absenceType, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceYearly[] findByAbsenceType_PrevAndNext(
		java.lang.Integer lmisAbsenceYearlyId, java.lang.String absenceType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException {
		return getPersistence()
				   .findByAbsenceType_PrevAndNext(lmisAbsenceYearlyId,
			absenceType, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findByAbsenceTypeID(
		int absenceTypeId) throws com.liferay.portal.SystemException {
		return getPersistence().findByAbsenceTypeID(absenceTypeId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findByAbsenceTypeID(
		int absenceTypeId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByAbsenceTypeID(absenceTypeId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findByAbsenceTypeID(
		int absenceTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByAbsenceTypeID(absenceTypeId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceYearly findByAbsenceTypeID_First(
		int absenceTypeId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException {
		return getPersistence().findByAbsenceTypeID_First(absenceTypeId, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceYearly findByAbsenceTypeID_Last(
		int absenceTypeId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException {
		return getPersistence().findByAbsenceTypeID_Last(absenceTypeId, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceYearly[] findByAbsenceTypeID_PrevAndNext(
		java.lang.Integer lmisAbsenceYearlyId, int absenceTypeId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException {
		return getPersistence()
				   .findByAbsenceTypeID_PrevAndNext(lmisAbsenceYearlyId,
			absenceTypeId, obc);
	}

	public static java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	public static java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByRootID(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRootID(rootId);
	}

	public static void removeByuserID(int userId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByuserID(userId);
	}

	public static void removeByYearValue(int yearValue)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByYearValue(yearValue);
	}

	public static void removeByAbsenceType(java.lang.String absenceType)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByAbsenceType(absenceType);
	}

	public static void removeByAbsenceTypeID(int absenceTypeId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByAbsenceTypeID(absenceTypeId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByRootID(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRootID(rootId);
	}

	public static int countByuserID(int userId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByuserID(userId);
	}

	public static int countByYearValue(int yearValue)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByYearValue(yearValue);
	}

	public static int countByAbsenceType(java.lang.String absenceType)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByAbsenceType(absenceType);
	}

	public static int countByAbsenceTypeID(int absenceTypeId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByAbsenceTypeID(absenceTypeId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static LmisAbsenceYearlyPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisAbsenceYearlyPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisAbsenceYearlyPersistence _persistence;
}