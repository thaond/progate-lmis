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
 * <a href="LmisViewDayValueMaxUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewDayValueMaxUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisViewDayValueMax lmisViewDayValueMax) {
		getPersistence().cacheResult(lmisViewDayValueMax);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewDayValueMax> lmisViewDayValueMaxs) {
		getPersistence().cacheResult(lmisViewDayValueMaxs);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisViewDayValueMax create(
		java.lang.Integer lmisViewDayValueMaxId) {
		return getPersistence().create(lmisViewDayValueMaxId);
	}

	public static larion.progate.lmis.model.LmisViewDayValueMax remove(
		java.lang.Integer lmisViewDayValueMaxId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewDayValueMaxException {
		return getPersistence().remove(lmisViewDayValueMaxId);
	}

	public static larion.progate.lmis.model.LmisViewDayValueMax remove(
		larion.progate.lmis.model.LmisViewDayValueMax lmisViewDayValueMax)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisViewDayValueMax);
	}

	public static larion.progate.lmis.model.LmisViewDayValueMax update(
		larion.progate.lmis.model.LmisViewDayValueMax lmisViewDayValueMax)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewDayValueMax);
	}

	public static larion.progate.lmis.model.LmisViewDayValueMax update(
		larion.progate.lmis.model.LmisViewDayValueMax lmisViewDayValueMax,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewDayValueMax, merge);
	}

	public static larion.progate.lmis.model.LmisViewDayValueMax updateImpl(
		larion.progate.lmis.model.LmisViewDayValueMax lmisViewDayValueMax,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisViewDayValueMax, merge);
	}

	public static larion.progate.lmis.model.LmisViewDayValueMax findByPrimaryKey(
		java.lang.Integer lmisViewDayValueMaxId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewDayValueMaxException {
		return getPersistence().findByPrimaryKey(lmisViewDayValueMaxId);
	}

	public static larion.progate.lmis.model.LmisViewDayValueMax fetchByPrimaryKey(
		java.lang.Integer lmisViewDayValueMaxId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisViewDayValueMaxId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewDayValueMax> findByRootID(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewDayValueMax> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewDayValueMax> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewDayValueMax findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewDayValueMaxException {
		return getPersistence().findByRootID_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewDayValueMax findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewDayValueMaxException {
		return getPersistence().findByRootID_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewDayValueMax[] findByRootID_PrevAndNext(
		java.lang.Integer lmisViewDayValueMaxId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewDayValueMaxException {
		return getPersistence()
				   .findByRootID_PrevAndNext(lmisViewDayValueMaxId, rootId, obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisViewDayValueMax> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewDayValueMax> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewDayValueMax> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByRootID(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRootID(rootId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByRootID(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRootID(rootId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static LmisViewDayValueMaxPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisViewDayValueMaxPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisViewDayValueMaxPersistence _persistence;
}