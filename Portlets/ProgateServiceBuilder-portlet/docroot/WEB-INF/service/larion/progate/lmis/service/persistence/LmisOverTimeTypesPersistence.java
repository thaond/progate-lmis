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
 * <a href="LmisOverTimeTypesPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisOverTimeTypesPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisOverTimeTypes lmisOverTimeTypes);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisOverTimeTypes> lmisOverTimeTypeses);

	public void clearCache();

	public larion.progate.lmis.model.LmisOverTimeTypes create(
		java.lang.Integer lmisOverTimeTypesId);

	public larion.progate.lmis.model.LmisOverTimeTypes remove(
		java.lang.Integer lmisOverTimeTypesId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeTypesException;

	public larion.progate.lmis.model.LmisOverTimeTypes remove(
		larion.progate.lmis.model.LmisOverTimeTypes lmisOverTimeTypes)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOverTimeTypes update(
		larion.progate.lmis.model.LmisOverTimeTypes lmisOverTimeTypes)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOverTimeTypes update(
		larion.progate.lmis.model.LmisOverTimeTypes lmisOverTimeTypes,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOverTimeTypes updateImpl(
		larion.progate.lmis.model.LmisOverTimeTypes lmisOverTimeTypes,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOverTimeTypes findByPrimaryKey(
		java.lang.Integer lmisOverTimeTypesId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeTypesException;

	public larion.progate.lmis.model.LmisOverTimeTypes fetchByPrimaryKey(
		java.lang.Integer lmisOverTimeTypesId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeTypes> findByOverTimeTypesOf(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeTypes> findByOverTimeTypesOf(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeTypes> findByOverTimeTypesOf(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOverTimeTypes findByOverTimeTypesOf_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeTypesException;

	public larion.progate.lmis.model.LmisOverTimeTypes findByOverTimeTypesOf_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeTypesException;

	public larion.progate.lmis.model.LmisOverTimeTypes[] findByOverTimeTypesOf_PrevAndNext(
		java.lang.Integer lmisOverTimeTypesId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOverTimeTypesException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeTypes> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeTypes> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeTypes> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByOverTimeTypesOf(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByOverTimeTypesOf(int rootId)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeSettings> getLmisOverTimeSettingses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeSettings> getLmisOverTimeSettingses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeSettings> getLmisOverTimeSettingses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getLmisOverTimeSettingsesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsLmisOverTimeSettings(java.lang.Integer pk,
		java.lang.Integer lmisOverTimeSettingsPK)
		throws com.liferay.portal.SystemException;

	public boolean containsLmisOverTimeSettingses(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReportHours> getLmisOverTimeReportHourses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReportHours> getLmisOverTimeReportHourses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOverTimeReportHours> getLmisOverTimeReportHourses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getLmisOverTimeReportHoursesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsLmisOverTimeReportHours(java.lang.Integer pk,
		java.lang.Integer lmisOverTimeReportHoursPK)
		throws com.liferay.portal.SystemException;

	public boolean containsLmisOverTimeReportHourses(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;
}