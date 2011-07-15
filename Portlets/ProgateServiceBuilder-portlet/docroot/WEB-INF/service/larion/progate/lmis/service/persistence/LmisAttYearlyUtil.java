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
 * <a href="LmisAttYearlyUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAttYearlyUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisAttYearly lmisAttYearly) {
		getPersistence().cacheResult(lmisAttYearly);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisAttYearly> lmisAttYearlies) {
		getPersistence().cacheResult(lmisAttYearlies);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisAttYearly create(
		java.lang.Integer lmisAttYearlyId) {
		return getPersistence().create(lmisAttYearlyId);
	}

	public static larion.progate.lmis.model.LmisAttYearly remove(
		java.lang.Integer lmisAttYearlyId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttYearlyException {
		return getPersistence().remove(lmisAttYearlyId);
	}

	public static larion.progate.lmis.model.LmisAttYearly remove(
		larion.progate.lmis.model.LmisAttYearly lmisAttYearly)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisAttYearly);
	}

	public static larion.progate.lmis.model.LmisAttYearly update(
		larion.progate.lmis.model.LmisAttYearly lmisAttYearly)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisAttYearly);
	}

	public static larion.progate.lmis.model.LmisAttYearly update(
		larion.progate.lmis.model.LmisAttYearly lmisAttYearly, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisAttYearly, merge);
	}

	public static larion.progate.lmis.model.LmisAttYearly updateImpl(
		larion.progate.lmis.model.LmisAttYearly lmisAttYearly, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisAttYearly, merge);
	}

	public static larion.progate.lmis.model.LmisAttYearly findByPrimaryKey(
		java.lang.Integer lmisAttYearlyId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttYearlyException {
		return getPersistence().findByPrimaryKey(lmisAttYearlyId);
	}

	public static larion.progate.lmis.model.LmisAttYearly fetchByPrimaryKey(
		java.lang.Integer lmisAttYearlyId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisAttYearlyId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttYearly> findByRootId(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttYearly> findByRootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttYearly> findByRootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisAttYearly findByRootId_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttYearlyException {
		return getPersistence().findByRootId_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisAttYearly findByRootId_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttYearlyException {
		return getPersistence().findByRootId_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisAttYearly[] findByRootId_PrevAndNext(
		java.lang.Integer lmisAttYearlyId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttYearlyException {
		return getPersistence()
				   .findByRootId_PrevAndNext(lmisAttYearlyId, rootId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttYearly> findByUserId(
		int userId) throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttYearly> findByUserId(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttYearly> findByUserId(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisAttYearly findByUserId_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttYearlyException {
		return getPersistence().findByUserId_First(userId, obc);
	}

	public static larion.progate.lmis.model.LmisAttYearly findByUserId_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttYearlyException {
		return getPersistence().findByUserId_Last(userId, obc);
	}

	public static larion.progate.lmis.model.LmisAttYearly[] findByUserId_PrevAndNext(
		java.lang.Integer lmisAttYearlyId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttYearlyException {
		return getPersistence()
				   .findByUserId_PrevAndNext(lmisAttYearlyId, userId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttYearly> findByYearValue(
		int yearValue) throws com.liferay.portal.SystemException {
		return getPersistence().findByYearValue(yearValue);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttYearly> findByYearValue(
		int yearValue, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByYearValue(yearValue, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttYearly> findByYearValue(
		int yearValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByYearValue(yearValue, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisAttYearly findByYearValue_First(
		int yearValue, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttYearlyException {
		return getPersistence().findByYearValue_First(yearValue, obc);
	}

	public static larion.progate.lmis.model.LmisAttYearly findByYearValue_Last(
		int yearValue, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttYearlyException {
		return getPersistence().findByYearValue_Last(yearValue, obc);
	}

	public static larion.progate.lmis.model.LmisAttYearly[] findByYearValue_PrevAndNext(
		java.lang.Integer lmisAttYearlyId, int yearValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttYearlyException {
		return getPersistence()
				   .findByYearValue_PrevAndNext(lmisAttYearlyId, yearValue, obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisAttYearly> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttYearly> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttYearly> findAll(
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

	public static void removeByYearValue(int yearValue)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByYearValue(yearValue);
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

	public static int countByYearValue(int yearValue)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByYearValue(yearValue);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static LmisAttYearlyPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisAttYearlyPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisAttYearlyPersistence _persistence;
}