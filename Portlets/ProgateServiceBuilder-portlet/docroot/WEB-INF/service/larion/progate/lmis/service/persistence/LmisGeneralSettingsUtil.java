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
 * <a href="LmisGeneralSettingsUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisGeneralSettingsUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisGeneralSettings lmisGeneralSettings) {
		getPersistence().cacheResult(lmisGeneralSettings);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisGeneralSettings> lmisGeneralSettingses) {
		getPersistence().cacheResult(lmisGeneralSettingses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisGeneralSettings create(
		java.lang.Integer lmisGeneralSettingId) {
		return getPersistence().create(lmisGeneralSettingId);
	}

	public static larion.progate.lmis.model.LmisGeneralSettings remove(
		java.lang.Integer lmisGeneralSettingId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisGeneralSettingsException {
		return getPersistence().remove(lmisGeneralSettingId);
	}

	public static larion.progate.lmis.model.LmisGeneralSettings remove(
		larion.progate.lmis.model.LmisGeneralSettings lmisGeneralSettings)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisGeneralSettings);
	}

	public static larion.progate.lmis.model.LmisGeneralSettings update(
		larion.progate.lmis.model.LmisGeneralSettings lmisGeneralSettings)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisGeneralSettings);
	}

	public static larion.progate.lmis.model.LmisGeneralSettings update(
		larion.progate.lmis.model.LmisGeneralSettings lmisGeneralSettings,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisGeneralSettings, merge);
	}

	public static larion.progate.lmis.model.LmisGeneralSettings updateImpl(
		larion.progate.lmis.model.LmisGeneralSettings lmisGeneralSettings,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisGeneralSettings, merge);
	}

	public static larion.progate.lmis.model.LmisGeneralSettings findByPrimaryKey(
		java.lang.Integer lmisGeneralSettingId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisGeneralSettingsException {
		return getPersistence().findByPrimaryKey(lmisGeneralSettingId);
	}

	public static larion.progate.lmis.model.LmisGeneralSettings fetchByPrimaryKey(
		java.lang.Integer lmisGeneralSettingId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisGeneralSettingId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisGeneralSettings> findByRootID(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisGeneralSettings> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisGeneralSettings> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisGeneralSettings findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisGeneralSettingsException {
		return getPersistence().findByRootID_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisGeneralSettings findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisGeneralSettingsException {
		return getPersistence().findByRootID_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisGeneralSettings[] findByRootID_PrevAndNext(
		java.lang.Integer lmisGeneralSettingId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisGeneralSettingsException {
		return getPersistence()
				   .findByRootID_PrevAndNext(lmisGeneralSettingId, rootId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisGeneralSettings> findByConfType(
		int confType) throws com.liferay.portal.SystemException {
		return getPersistence().findByConfType(confType);
	}

	public static java.util.List<larion.progate.lmis.model.LmisGeneralSettings> findByConfType(
		int confType, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByConfType(confType, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisGeneralSettings> findByConfType(
		int confType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByConfType(confType, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisGeneralSettings findByConfType_First(
		int confType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisGeneralSettingsException {
		return getPersistence().findByConfType_First(confType, obc);
	}

	public static larion.progate.lmis.model.LmisGeneralSettings findByConfType_Last(
		int confType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisGeneralSettingsException {
		return getPersistence().findByConfType_Last(confType, obc);
	}

	public static larion.progate.lmis.model.LmisGeneralSettings[] findByConfType_PrevAndNext(
		java.lang.Integer lmisGeneralSettingId, int confType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisGeneralSettingsException {
		return getPersistence()
				   .findByConfType_PrevAndNext(lmisGeneralSettingId, confType,
			obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisGeneralSettings> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisGeneralSettings> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisGeneralSettings> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByRootID(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRootID(rootId);
	}

	public static void removeByConfType(int confType)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByConfType(confType);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByRootID(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRootID(rootId);
	}

	public static int countByConfType(int confType)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByConfType(confType);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static LmisGeneralSettingsPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisGeneralSettingsPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisGeneralSettingsPersistence _persistence;
}