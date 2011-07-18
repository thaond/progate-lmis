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
 * <a href="LmisViewDayTypeOverTimeSettingTypeUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewDayTypeOverTimeSettingTypeUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType lmisViewDayTypeOverTimeSettingType) {
		getPersistence().cacheResult(lmisViewDayTypeOverTimeSettingType);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType> lmisViewDayTypeOverTimeSettingTypes) {
		getPersistence().cacheResult(lmisViewDayTypeOverTimeSettingTypes);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType create(
		java.lang.Integer lmisViewDayTypeOverTimeSettingTypeId) {
		return getPersistence().create(lmisViewDayTypeOverTimeSettingTypeId);
	}

	public static larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType remove(
		java.lang.Integer lmisViewDayTypeOverTimeSettingTypeId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewDayTypeOverTimeSettingTypeException {
		return getPersistence().remove(lmisViewDayTypeOverTimeSettingTypeId);
	}

	public static larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType remove(
		larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType lmisViewDayTypeOverTimeSettingType)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisViewDayTypeOverTimeSettingType);
	}

	public static larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType update(
		larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType lmisViewDayTypeOverTimeSettingType)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewDayTypeOverTimeSettingType);
	}

	public static larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType update(
		larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType lmisViewDayTypeOverTimeSettingType,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewDayTypeOverTimeSettingType, merge);
	}

	public static larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType updateImpl(
		larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType lmisViewDayTypeOverTimeSettingType,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence()
				   .updateImpl(lmisViewDayTypeOverTimeSettingType, merge);
	}

	public static larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType findByPrimaryKey(
		java.lang.Integer lmisViewDayTypeOverTimeSettingTypeId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewDayTypeOverTimeSettingTypeException {
		return getPersistence()
				   .findByPrimaryKey(lmisViewDayTypeOverTimeSettingTypeId);
	}

	public static larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType fetchByPrimaryKey(
		java.lang.Integer lmisViewDayTypeOverTimeSettingTypeId)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .fetchByPrimaryKey(lmisViewDayTypeOverTimeSettingTypeId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType> findByRootID(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewDayTypeOverTimeSettingTypeException {
		return getPersistence().findByRootID_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewDayTypeOverTimeSettingTypeException {
		return getPersistence().findByRootID_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType[] findByRootID_PrevAndNext(
		java.lang.Integer lmisViewDayTypeOverTimeSettingTypeId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewDayTypeOverTimeSettingTypeException {
		return getPersistence()
				   .findByRootID_PrevAndNext(lmisViewDayTypeOverTimeSettingTypeId,
			rootId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType> findByDayType(
		int dayType) throws com.liferay.portal.SystemException {
		return getPersistence().findByDayType(dayType);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType> findByDayType(
		int dayType, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDayType(dayType, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType> findByDayType(
		int dayType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDayType(dayType, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType findByDayType_First(
		int dayType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewDayTypeOverTimeSettingTypeException {
		return getPersistence().findByDayType_First(dayType, obc);
	}

	public static larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType findByDayType_Last(
		int dayType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewDayTypeOverTimeSettingTypeException {
		return getPersistence().findByDayType_Last(dayType, obc);
	}

	public static larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType[] findByDayType_PrevAndNext(
		java.lang.Integer lmisViewDayTypeOverTimeSettingTypeId, int dayType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewDayTypeOverTimeSettingTypeException {
		return getPersistence()
				   .findByDayType_PrevAndNext(lmisViewDayTypeOverTimeSettingTypeId,
			dayType, obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByRootID(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRootID(rootId);
	}

	public static void removeByDayType(int dayType)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByDayType(dayType);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByRootID(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRootID(rootId);
	}

	public static int countByDayType(int dayType)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByDayType(dayType);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static LmisViewDayTypeOverTimeSettingTypePersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(
		LmisViewDayTypeOverTimeSettingTypePersistence persistence) {
		_persistence = persistence;
	}

	private static LmisViewDayTypeOverTimeSettingTypePersistence _persistence;
}