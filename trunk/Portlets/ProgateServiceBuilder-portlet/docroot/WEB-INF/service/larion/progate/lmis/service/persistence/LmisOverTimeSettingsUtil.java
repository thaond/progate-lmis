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
 * <a href="LmisOverTimeSettingsUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOverTimeSettingsUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisOverTimeSettings lmisOverTimeSettings) {
		getPersistence().cacheResult(lmisOverTimeSettings);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisOverTimeSettings> lmisOverTimeSettingses) {
		getPersistence().cacheResult(lmisOverTimeSettingses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisOverTimeSettings create(
		java.lang.Integer lmisOverTimeSettingsId) {
		return getPersistence().create(lmisOverTimeSettingsId);
	}

	public static larion.progate.lmis.model.LmisOverTimeSettings remove(
		java.lang.Integer lmisOverTimeSettingsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeSettingsException {
		return getPersistence().remove(lmisOverTimeSettingsId);
	}

	public static larion.progate.lmis.model.LmisOverTimeSettings remove(
		larion.progate.lmis.model.LmisOverTimeSettings lmisOverTimeSettings)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisOverTimeSettings);
	}

	public static larion.progate.lmis.model.LmisOverTimeSettings update(
		larion.progate.lmis.model.LmisOverTimeSettings lmisOverTimeSettings)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisOverTimeSettings);
	}

	public static larion.progate.lmis.model.LmisOverTimeSettings update(
		larion.progate.lmis.model.LmisOverTimeSettings lmisOverTimeSettings,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisOverTimeSettings, merge);
	}

	public static larion.progate.lmis.model.LmisOverTimeSettings updateImpl(
		larion.progate.lmis.model.LmisOverTimeSettings lmisOverTimeSettings,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisOverTimeSettings, merge);
	}

	public static larion.progate.lmis.model.LmisOverTimeSettings findByPrimaryKey(
		java.lang.Integer lmisOverTimeSettingsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeSettingsException {
		return getPersistence().findByPrimaryKey(lmisOverTimeSettingsId);
	}

	public static larion.progate.lmis.model.LmisOverTimeSettings fetchByPrimaryKey(
		java.lang.Integer lmisOverTimeSettingsId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisOverTimeSettingsId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeSettings> findByOtID(
		int otId) throws com.liferay.portal.SystemException {
		return getPersistence().findByOtID(otId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeSettings> findByOtID(
		int otId, int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findByOtID(otId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeSettings> findByOtID(
		int otId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOtID(otId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisOverTimeSettings findByOtID_First(
		int otId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeSettingsException {
		return getPersistence().findByOtID_First(otId, obc);
	}

	public static larion.progate.lmis.model.LmisOverTimeSettings findByOtID_Last(
		int otId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeSettingsException {
		return getPersistence().findByOtID_Last(otId, obc);
	}

	public static larion.progate.lmis.model.LmisOverTimeSettings[] findByOtID_PrevAndNext(
		java.lang.Integer lmisOverTimeSettingsId, int otId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeSettingsException {
		return getPersistence()
				   .findByOtID_PrevAndNext(lmisOverTimeSettingsId, otId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeSettings> findByDayID(
		int dayType) throws com.liferay.portal.SystemException {
		return getPersistence().findByDayID(dayType);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeSettings> findByDayID(
		int dayType, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDayID(dayType, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeSettings> findByDayID(
		int dayType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDayID(dayType, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisOverTimeSettings findByDayID_First(
		int dayType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeSettingsException {
		return getPersistence().findByDayID_First(dayType, obc);
	}

	public static larion.progate.lmis.model.LmisOverTimeSettings findByDayID_Last(
		int dayType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeSettingsException {
		return getPersistence().findByDayID_Last(dayType, obc);
	}

	public static larion.progate.lmis.model.LmisOverTimeSettings[] findByDayID_PrevAndNext(
		java.lang.Integer lmisOverTimeSettingsId, int dayType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeSettingsException {
		return getPersistence()
				   .findByDayID_PrevAndNext(lmisOverTimeSettingsId, dayType, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeSettings> findByOverTimeSettingsOf(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByOverTimeSettingsOf(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeSettings> findByOverTimeSettingsOf(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOverTimeSettingsOf(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeSettings> findByOverTimeSettingsOf(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOverTimeSettingsOf(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisOverTimeSettings findByOverTimeSettingsOf_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeSettingsException {
		return getPersistence().findByOverTimeSettingsOf_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisOverTimeSettings findByOverTimeSettingsOf_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeSettingsException {
		return getPersistence().findByOverTimeSettingsOf_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisOverTimeSettings[] findByOverTimeSettingsOf_PrevAndNext(
		java.lang.Integer lmisOverTimeSettingsId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeSettingsException {
		return getPersistence()
				   .findByOverTimeSettingsOf_PrevAndNext(lmisOverTimeSettingsId,
			rootId, obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeSettings> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeSettings> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeSettings> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByOtID(int otId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByOtID(otId);
	}

	public static void removeByDayID(int dayType)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByDayID(dayType);
	}

	public static void removeByOverTimeSettingsOf(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByOverTimeSettingsOf(rootId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByOtID(int otId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByOtID(otId);
	}

	public static int countByDayID(int dayType)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByDayID(dayType);
	}

	public static int countByOverTimeSettingsOf(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByOverTimeSettingsOf(rootId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static LmisOverTimeSettingsPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisOverTimeSettingsPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisOverTimeSettingsPersistence _persistence;
}