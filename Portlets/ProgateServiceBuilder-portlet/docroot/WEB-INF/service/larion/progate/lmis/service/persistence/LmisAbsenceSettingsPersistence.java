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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * <a href="LmisAbsenceSettingsPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisAbsenceSettingsPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisAbsenceSettings lmisAbsenceSettings);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisAbsenceSettings> lmisAbsenceSettingses);

	public void clearCache();

	public larion.progate.lmis.model.LmisAbsenceSettings create(
		java.lang.Integer lmisAbsenceSettingsId);

	public larion.progate.lmis.model.LmisAbsenceSettings remove(
		java.lang.Integer lmisAbsenceSettingsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceSettingsException;

	public larion.progate.lmis.model.LmisAbsenceSettings remove(
		larion.progate.lmis.model.LmisAbsenceSettings lmisAbsenceSettings)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceSettings update(
		larion.progate.lmis.model.LmisAbsenceSettings lmisAbsenceSettings)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceSettings update(
		larion.progate.lmis.model.LmisAbsenceSettings lmisAbsenceSettings,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceSettings updateImpl(
		larion.progate.lmis.model.LmisAbsenceSettings lmisAbsenceSettings,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceSettings findByPrimaryKey(
		java.lang.Integer lmisAbsenceSettingsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceSettingsException;

	public larion.progate.lmis.model.LmisAbsenceSettings fetchByPrimaryKey(
		java.lang.Integer lmisAbsenceSettingsId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceSettings> findByRootID(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceSettings> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceSettings> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceSettings findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceSettingsException;

	public larion.progate.lmis.model.LmisAbsenceSettings findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceSettingsException;

	public larion.progate.lmis.model.LmisAbsenceSettings[] findByRootID_PrevAndNext(
		java.lang.Integer lmisAbsenceSettingsId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceSettingsException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceSettings> findByAbsencePermissive(
		boolean absencePermissive) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceSettings> findByAbsencePermissive(
		boolean absencePermissive, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceSettings> findByAbsencePermissive(
		boolean absencePermissive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceSettings findByAbsencePermissive_First(
		boolean absencePermissive,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceSettingsException;

	public larion.progate.lmis.model.LmisAbsenceSettings findByAbsencePermissive_Last(
		boolean absencePermissive,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceSettingsException;

	public larion.progate.lmis.model.LmisAbsenceSettings[] findByAbsencePermissive_PrevAndNext(
		java.lang.Integer lmisAbsenceSettingsId, boolean absencePermissive,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceSettingsException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceSettings> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceSettings> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceSettings> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByRootID(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeByAbsencePermissive(boolean absencePermissive)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByRootID(int rootId)
		throws com.liferay.portal.SystemException;

	public int countByAbsencePermissive(boolean absencePermissive)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> getLmisAttendanceDailies(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> getLmisAttendanceDailies(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttendanceDaily> getLmisAttendanceDailies(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getLmisAttendanceDailiesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsLmisAttendanceDaily(java.lang.Integer pk,
		java.lang.Integer lmisAttendanceDailyPK)
		throws com.liferay.portal.SystemException;

	public boolean containsLmisAttendanceDailies(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> getLmisAbsenceRequestses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> getLmisAbsenceRequestses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceRequests> getLmisAbsenceRequestses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getLmisAbsenceRequestsesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsLmisAbsenceRequests(java.lang.Integer pk,
		java.lang.Integer lmisAbsenceRequestsPK)
		throws com.liferay.portal.SystemException;

	public boolean containsLmisAbsenceRequestses(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;
}