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
 * <a href="LmisAbsenceSettingsUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAbsenceSettingsUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisAbsenceSettings lmisAbsenceSettings) {
		getPersistence().cacheResult(lmisAbsenceSettings);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisAbsenceSettings> lmisAbsenceSettingses) {
		getPersistence().cacheResult(lmisAbsenceSettingses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisAbsenceSettings create(
		java.lang.Integer lmisAbsenceSettingsId) {
		return getPersistence().create(lmisAbsenceSettingsId);
	}

	public static larion.progate.lmis.model.LmisAbsenceSettings remove(
		java.lang.Integer lmisAbsenceSettingsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceSettingsException {
		return getPersistence().remove(lmisAbsenceSettingsId);
	}

	public static larion.progate.lmis.model.LmisAbsenceSettings remove(
		larion.progate.lmis.model.LmisAbsenceSettings lmisAbsenceSettings)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisAbsenceSettings);
	}

	public static larion.progate.lmis.model.LmisAbsenceSettings update(
		larion.progate.lmis.model.LmisAbsenceSettings lmisAbsenceSettings)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisAbsenceSettings);
	}

	public static larion.progate.lmis.model.LmisAbsenceSettings update(
		larion.progate.lmis.model.LmisAbsenceSettings lmisAbsenceSettings,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisAbsenceSettings, merge);
	}

	public static larion.progate.lmis.model.LmisAbsenceSettings updateImpl(
		larion.progate.lmis.model.LmisAbsenceSettings lmisAbsenceSettings,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisAbsenceSettings, merge);
	}

	public static larion.progate.lmis.model.LmisAbsenceSettings findByPrimaryKey(
		java.lang.Integer lmisAbsenceSettingsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceSettingsException {
		return getPersistence().findByPrimaryKey(lmisAbsenceSettingsId);
	}

	public static larion.progate.lmis.model.LmisAbsenceSettings fetchByPrimaryKey(
		java.lang.Integer lmisAbsenceSettingsId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisAbsenceSettingsId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceSettings> findByRootID(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceSettings> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceSettings> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceSettings findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceSettingsException {
		return getPersistence().findByRootID_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceSettings findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceSettingsException {
		return getPersistence().findByRootID_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceSettings[] findByRootID_PrevAndNext(
		java.lang.Integer lmisAbsenceSettingsId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceSettingsException {
		return getPersistence()
				   .findByRootID_PrevAndNext(lmisAbsenceSettingsId, rootId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceSettings> findByAbsencePermissive(
		boolean absencePermissive) throws com.liferay.portal.SystemException {
		return getPersistence().findByAbsencePermissive(absencePermissive);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceSettings> findByAbsencePermissive(
		boolean absencePermissive, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByAbsencePermissive(absencePermissive, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceSettings> findByAbsencePermissive(
		boolean absencePermissive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByAbsencePermissive(absencePermissive, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceSettings findByAbsencePermissive_First(
		boolean absencePermissive,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceSettingsException {
		return getPersistence()
				   .findByAbsencePermissive_First(absencePermissive, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceSettings findByAbsencePermissive_Last(
		boolean absencePermissive,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceSettingsException {
		return getPersistence()
				   .findByAbsencePermissive_Last(absencePermissive, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceSettings[] findByAbsencePermissive_PrevAndNext(
		java.lang.Integer lmisAbsenceSettingsId, boolean absencePermissive,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceSettingsException {
		return getPersistence()
				   .findByAbsencePermissive_PrevAndNext(lmisAbsenceSettingsId,
			absencePermissive, obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceSettings> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceSettings> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceSettings> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByRootID(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRootID(rootId);
	}

	public static void removeByAbsencePermissive(boolean absencePermissive)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByAbsencePermissive(absencePermissive);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByRootID(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRootID(rootId);
	}

	public static int countByAbsencePermissive(boolean absencePermissive)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByAbsencePermissive(absencePermissive);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> getLmisAttendanceDailies(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getLmisAttendanceDailies(pk);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> getLmisAttendanceDailies(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisAttendanceDailies(pk, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> getLmisAttendanceDailies(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisAttendanceDailies(pk, start, end, obc);
	}

	public static int getLmisAttendanceDailiesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisAttendanceDailiesSize(pk);
	}

	public static boolean containsLmisAttendanceDaily(java.lang.Integer pk,
		java.lang.Integer lmisAttendanceDailyPK)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .containsLmisAttendanceDaily(pk, lmisAttendanceDailyPK);
	}

	public static boolean containsLmisAttendanceDailies(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().containsLmisAttendanceDailies(pk);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> getLmisAbsenceRequestses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getLmisAbsenceRequestses(pk);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> getLmisAbsenceRequestses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisAbsenceRequestses(pk, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> getLmisAbsenceRequestses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisAbsenceRequestses(pk, start, end, obc);
	}

	public static int getLmisAbsenceRequestsesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisAbsenceRequestsesSize(pk);
	}

	public static boolean containsLmisAbsenceRequests(java.lang.Integer pk,
		java.lang.Integer lmisAbsenceRequestsPK)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .containsLmisAbsenceRequests(pk, lmisAbsenceRequestsPK);
	}

	public static boolean containsLmisAbsenceRequestses(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().containsLmisAbsenceRequestses(pk);
	}

	public static LmisAbsenceSettingsPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisAbsenceSettingsPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisAbsenceSettingsPersistence _persistence;
}