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
 * <a href="LmisOverTimeReportHoursPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisOverTimeReportHoursPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisOverTimeReportHours lmisOverTimeReportHours);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisOverTimeReportHours> lmisOverTimeReportHourses);

	public void clearCache();

	public larion.progate.lmis.model.LmisOverTimeReportHours create(
		java.lang.Integer lmisOverTimeReportHoursId);

	public larion.progate.lmis.model.LmisOverTimeReportHours remove(
		java.lang.Integer lmisOverTimeReportHoursId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportHoursException;

	public larion.progate.lmis.model.LmisOverTimeReportHours remove(
		larion.progate.lmis.model.LmisOverTimeReportHours lmisOverTimeReportHours)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOverTimeReportHours update(
		larion.progate.lmis.model.LmisOverTimeReportHours lmisOverTimeReportHours)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOverTimeReportHours update(
		larion.progate.lmis.model.LmisOverTimeReportHours lmisOverTimeReportHours,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOverTimeReportHours updateImpl(
		larion.progate.lmis.model.LmisOverTimeReportHours lmisOverTimeReportHours,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOverTimeReportHours findByPrimaryKey(
		java.lang.Integer lmisOverTimeReportHoursId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportHoursException;

	public larion.progate.lmis.model.LmisOverTimeReportHours fetchByPrimaryKey(
		java.lang.Integer lmisOverTimeReportHoursId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReportHours> findByDetailID(
		int detailId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReportHours> findByDetailID(
		int detailId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReportHours> findByDetailID(
		int detailId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOverTimeReportHours findByDetailID_First(
		int detailId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportHoursException;

	public larion.progate.lmis.model.LmisOverTimeReportHours findByDetailID_Last(
		int detailId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportHoursException;

	public larion.progate.lmis.model.LmisOverTimeReportHours[] findByDetailID_PrevAndNext(
		java.lang.Integer lmisOverTimeReportHoursId, int detailId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportHoursException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReportHours> findByOtID(
		int otId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReportHours> findByOtID(
		int otId, int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReportHours> findByOtID(
		int otId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOverTimeReportHours findByOtID_First(
		int otId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportHoursException;

	public larion.progate.lmis.model.LmisOverTimeReportHours findByOtID_Last(
		int otId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportHoursException;

	public larion.progate.lmis.model.LmisOverTimeReportHours[] findByOtID_PrevAndNext(
		java.lang.Integer lmisOverTimeReportHoursId, int otId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeReportHoursException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReportHours> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReportHours> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReportHours> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByDetailID(int detailId)
		throws com.liferay.portal.SystemException;

	public void removeByOtID(int otId)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByDetailID(int detailId)
		throws com.liferay.portal.SystemException;

	public int countByOtID(int otId) throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}