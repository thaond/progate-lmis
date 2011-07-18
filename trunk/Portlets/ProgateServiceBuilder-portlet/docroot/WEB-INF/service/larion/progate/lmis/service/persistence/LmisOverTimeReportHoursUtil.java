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
 * <a href="LmisOverTimeReportHoursUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOverTimeReportHoursUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisOverTimeReportHours lmisOverTimeReportHours) {
		getPersistence().cacheResult(lmisOverTimeReportHours);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisOverTimeReportHours> lmisOverTimeReportHourses) {
		getPersistence().cacheResult(lmisOverTimeReportHourses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisOverTimeReportHours create(
		java.lang.Integer lmisOverTimeReportHoursId) {
		return getPersistence().create(lmisOverTimeReportHoursId);
	}

	public static larion.progate.lmis.model.LmisOverTimeReportHours remove(
		java.lang.Integer lmisOverTimeReportHoursId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportHoursException {
		return getPersistence().remove(lmisOverTimeReportHoursId);
	}

	public static larion.progate.lmis.model.LmisOverTimeReportHours remove(
		larion.progate.lmis.model.LmisOverTimeReportHours lmisOverTimeReportHours)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisOverTimeReportHours);
	}

	public static larion.progate.lmis.model.LmisOverTimeReportHours update(
		larion.progate.lmis.model.LmisOverTimeReportHours lmisOverTimeReportHours)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisOverTimeReportHours);
	}

	public static larion.progate.lmis.model.LmisOverTimeReportHours update(
		larion.progate.lmis.model.LmisOverTimeReportHours lmisOverTimeReportHours,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisOverTimeReportHours, merge);
	}

	public static larion.progate.lmis.model.LmisOverTimeReportHours updateImpl(
		larion.progate.lmis.model.LmisOverTimeReportHours lmisOverTimeReportHours,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisOverTimeReportHours, merge);
	}

	public static larion.progate.lmis.model.LmisOverTimeReportHours findByPrimaryKey(
		java.lang.Integer lmisOverTimeReportHoursId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportHoursException {
		return getPersistence().findByPrimaryKey(lmisOverTimeReportHoursId);
	}

	public static larion.progate.lmis.model.LmisOverTimeReportHours fetchByPrimaryKey(
		java.lang.Integer lmisOverTimeReportHoursId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisOverTimeReportHoursId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReportHours> findByDetailID(
		int detailId) throws com.liferay.portal.SystemException {
		return getPersistence().findByDetailID(detailId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReportHours> findByDetailID(
		int detailId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDetailID(detailId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReportHours> findByDetailID(
		int detailId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByDetailID(detailId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisOverTimeReportHours findByDetailID_First(
		int detailId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportHoursException {
		return getPersistence().findByDetailID_First(detailId, obc);
	}

	public static larion.progate.lmis.model.LmisOverTimeReportHours findByDetailID_Last(
		int detailId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportHoursException {
		return getPersistence().findByDetailID_Last(detailId, obc);
	}

	public static larion.progate.lmis.model.LmisOverTimeReportHours[] findByDetailID_PrevAndNext(
		java.lang.Integer lmisOverTimeReportHoursId, int detailId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportHoursException {
		return getPersistence()
				   .findByDetailID_PrevAndNext(lmisOverTimeReportHoursId,
			detailId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReportHours> findByOtID(
		int otId) throws com.liferay.portal.SystemException {
		return getPersistence().findByOtID(otId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReportHours> findByOtID(
		int otId, int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findByOtID(otId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReportHours> findByOtID(
		int otId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOtID(otId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisOverTimeReportHours findByOtID_First(
		int otId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportHoursException {
		return getPersistence().findByOtID_First(otId, obc);
	}

	public static larion.progate.lmis.model.LmisOverTimeReportHours findByOtID_Last(
		int otId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportHoursException {
		return getPersistence().findByOtID_Last(otId, obc);
	}

	public static larion.progate.lmis.model.LmisOverTimeReportHours[] findByOtID_PrevAndNext(
		java.lang.Integer lmisOverTimeReportHoursId, int otId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportHoursException {
		return getPersistence()
				   .findByOtID_PrevAndNext(lmisOverTimeReportHoursId, otId, obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReportHours> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReportHours> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOverTimeReportHours> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByDetailID(int detailId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByDetailID(detailId);
	}

	public static void removeByOtID(int otId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByOtID(otId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByDetailID(int detailId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByDetailID(detailId);
	}

	public static int countByOtID(int otId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByOtID(otId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static LmisOverTimeReportHoursPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisOverTimeReportHoursPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisOverTimeReportHoursPersistence _persistence;
}