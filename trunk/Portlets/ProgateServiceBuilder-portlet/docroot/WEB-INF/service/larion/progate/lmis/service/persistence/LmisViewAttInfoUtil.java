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
 * <a href="LmisViewAttInfoUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewAttInfoUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisViewAttInfo lmisViewAttInfo) {
		getPersistence().cacheResult(lmisViewAttInfo);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewAttInfo> lmisViewAttInfos) {
		getPersistence().cacheResult(lmisViewAttInfos);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisViewAttInfo create(
		java.lang.Integer lmisViewAttInfoId) {
		return getPersistence().create(lmisViewAttInfoId);
	}

	public static larion.progate.lmis.model.LmisViewAttInfo remove(
		java.lang.Integer lmisViewAttInfoId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttInfoException {
		return getPersistence().remove(lmisViewAttInfoId);
	}

	public static larion.progate.lmis.model.LmisViewAttInfo remove(
		larion.progate.lmis.model.LmisViewAttInfo lmisViewAttInfo)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisViewAttInfo);
	}

	public static larion.progate.lmis.model.LmisViewAttInfo update(
		larion.progate.lmis.model.LmisViewAttInfo lmisViewAttInfo)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewAttInfo);
	}

	public static larion.progate.lmis.model.LmisViewAttInfo update(
		larion.progate.lmis.model.LmisViewAttInfo lmisViewAttInfo, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewAttInfo, merge);
	}

	public static larion.progate.lmis.model.LmisViewAttInfo updateImpl(
		larion.progate.lmis.model.LmisViewAttInfo lmisViewAttInfo, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisViewAttInfo, merge);
	}

	public static larion.progate.lmis.model.LmisViewAttInfo findByPrimaryKey(
		java.lang.Integer lmisViewAttInfoId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttInfoException {
		return getPersistence().findByPrimaryKey(lmisViewAttInfoId);
	}

	public static larion.progate.lmis.model.LmisViewAttInfo fetchByPrimaryKey(
		java.lang.Integer lmisViewAttInfoId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisViewAttInfoId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttInfo> findByRootId(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttInfo> findByRootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttInfo> findByRootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttInfo findByRootId_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttInfoException {
		return getPersistence().findByRootId_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttInfo findByRootId_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttInfoException {
		return getPersistence().findByRootId_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttInfo[] findByRootId_PrevAndNext(
		java.lang.Integer lmisViewAttInfoId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttInfoException {
		return getPersistence()
				   .findByRootId_PrevAndNext(lmisViewAttInfoId, rootId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttInfo> findByUserId(
		int userId) throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttInfo> findByUserId(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttInfo> findByUserId(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttInfo findByUserId_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttInfoException {
		return getPersistence().findByUserId_First(userId, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttInfo findByUserId_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttInfoException {
		return getPersistence().findByUserId_Last(userId, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttInfo[] findByUserId_PrevAndNext(
		java.lang.Integer lmisViewAttInfoId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttInfoException {
		return getPersistence()
				   .findByUserId_PrevAndNext(lmisViewAttInfoId, userId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttInfo> findByDayValue(
		java.util.Date dayValue) throws com.liferay.portal.SystemException {
		return getPersistence().findByDayValue(dayValue);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttInfo> findByDayValue(
		java.util.Date dayValue, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDayValue(dayValue, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttInfo> findByDayValue(
		java.util.Date dayValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDayValue(dayValue, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttInfo findByDayValue_First(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttInfoException {
		return getPersistence().findByDayValue_First(dayValue, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttInfo findByDayValue_Last(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttInfoException {
		return getPersistence().findByDayValue_Last(dayValue, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttInfo[] findByDayValue_PrevAndNext(
		java.lang.Integer lmisViewAttInfoId, java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttInfoException {
		return getPersistence()
				   .findByDayValue_PrevAndNext(lmisViewAttInfoId, dayValue, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttInfo> findByFullName(
		java.lang.String fullName) throws com.liferay.portal.SystemException {
		return getPersistence().findByFullName(fullName);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttInfo> findByFullName(
		java.lang.String fullName, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByFullName(fullName, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttInfo> findByFullName(
		java.lang.String fullName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByFullName(fullName, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttInfo findByFullName_First(
		java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttInfoException {
		return getPersistence().findByFullName_First(fullName, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttInfo findByFullName_Last(
		java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttInfoException {
		return getPersistence().findByFullName_Last(fullName, obc);
	}

	public static larion.progate.lmis.model.LmisViewAttInfo[] findByFullName_PrevAndNext(
		java.lang.Integer lmisViewAttInfoId, java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttInfoException {
		return getPersistence()
				   .findByFullName_PrevAndNext(lmisViewAttInfoId, fullName, obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisViewAttInfo> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttInfo> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewAttInfo> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByRootId(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRootId(rootId);
	}

	public static void removeByUserId(int userId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByUserId(userId);
	}

	public static void removeByDayValue(java.util.Date dayValue)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByDayValue(dayValue);
	}

	public static void removeByFullName(java.lang.String fullName)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByFullName(fullName);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByRootId(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRootId(rootId);
	}

	public static int countByUserId(int userId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByUserId(userId);
	}

	public static int countByDayValue(java.util.Date dayValue)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByDayValue(dayValue);
	}

	public static int countByFullName(java.lang.String fullName)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByFullName(fullName);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static LmisViewAttInfoPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisViewAttInfoPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisViewAttInfoPersistence _persistence;
}