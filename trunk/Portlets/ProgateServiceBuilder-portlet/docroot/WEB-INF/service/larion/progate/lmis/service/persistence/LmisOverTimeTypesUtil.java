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
 * <a href="LmisOverTimeTypesUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOverTimeTypesUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisOverTimeTypes lmisOverTimeTypes) {
		getPersistence().cacheResult(lmisOverTimeTypes);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisOverTimeTypes> lmisOverTimeTypeses) {
		getPersistence().cacheResult(lmisOverTimeTypeses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisOverTimeTypes create(
		java.lang.Integer lmisOverTimeTypesId) {
		return getPersistence().create(lmisOverTimeTypesId);
	}

	public static larion.progate.lmis.model.LmisOverTimeTypes remove(
		java.lang.Integer lmisOverTimeTypesId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeTypesException {
		return getPersistence().remove(lmisOverTimeTypesId);
	}

	public static larion.progate.lmis.model.LmisOverTimeTypes remove(
		larion.progate.lmis.model.LmisOverTimeTypes lmisOverTimeTypes)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisOverTimeTypes);
	}

	public static larion.progate.lmis.model.LmisOverTimeTypes update(
		larion.progate.lmis.model.LmisOverTimeTypes lmisOverTimeTypes)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisOverTimeTypes);
	}

	public static larion.progate.lmis.model.LmisOverTimeTypes update(
		larion.progate.lmis.model.LmisOverTimeTypes lmisOverTimeTypes,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisOverTimeTypes, merge);
	}

	public static larion.progate.lmis.model.LmisOverTimeTypes updateImpl(
		larion.progate.lmis.model.LmisOverTimeTypes lmisOverTimeTypes,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisOverTimeTypes, merge);
	}

	public static larion.progate.lmis.model.LmisOverTimeTypes findByPrimaryKey(
		java.lang.Integer lmisOverTimeTypesId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeTypesException {
		return getPersistence().findByPrimaryKey(lmisOverTimeTypesId);
	}

	public static larion.progate.lmis.model.LmisOverTimeTypes fetchByPrimaryKey(
		java.lang.Integer lmisOverTimeTypesId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisOverTimeTypesId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeTypes> findByOverTimeTypesOf(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByOverTimeTypesOf(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeTypes> findByOverTimeTypesOf(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOverTimeTypesOf(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeTypes> findByOverTimeTypesOf(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOverTimeTypesOf(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisOverTimeTypes findByOverTimeTypesOf_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeTypesException {
		return getPersistence().findByOverTimeTypesOf_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisOverTimeTypes findByOverTimeTypesOf_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeTypesException {
		return getPersistence().findByOverTimeTypesOf_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisOverTimeTypes[] findByOverTimeTypesOf_PrevAndNext(
		java.lang.Integer lmisOverTimeTypesId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeTypesException {
		return getPersistence()
				   .findByOverTimeTypesOf_PrevAndNext(lmisOverTimeTypesId,
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

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeTypes> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeTypes> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeTypes> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByOverTimeTypesOf(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByOverTimeTypesOf(rootId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByOverTimeTypesOf(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByOverTimeTypesOf(rootId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeSettings> getLmisOverTimeSettingses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getLmisOverTimeSettingses(pk);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeSettings> getLmisOverTimeSettingses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisOverTimeSettingses(pk, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeSettings> getLmisOverTimeSettingses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisOverTimeSettingses(pk, start, end, obc);
	}

	public static int getLmisOverTimeSettingsesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisOverTimeSettingsesSize(pk);
	}

	public static boolean containsLmisOverTimeSettings(java.lang.Integer pk,
		java.lang.Integer lmisOverTimeSettingsPK)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .containsLmisOverTimeSettings(pk, lmisOverTimeSettingsPK);
	}

	public static boolean containsLmisOverTimeSettingses(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().containsLmisOverTimeSettingses(pk);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReportHours> getLmisOverTimeReportHourses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getLmisOverTimeReportHourses(pk);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReportHours> getLmisOverTimeReportHourses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisOverTimeReportHourses(pk, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReportHours> getLmisOverTimeReportHourses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisOverTimeReportHourses(pk, start, end, obc);
	}

	public static int getLmisOverTimeReportHoursesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisOverTimeReportHoursesSize(pk);
	}

	public static boolean containsLmisOverTimeReportHours(
		java.lang.Integer pk, java.lang.Integer lmisOverTimeReportHoursPK)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .containsLmisOverTimeReportHours(pk,
			lmisOverTimeReportHoursPK);
	}

	public static boolean containsLmisOverTimeReportHourses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().containsLmisOverTimeReportHourses(pk);
	}

	public static LmisOverTimeTypesPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisOverTimeTypesPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisOverTimeTypesPersistence _persistence;
}