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
 * <a href="LmisViewAttDailyPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisViewAttDailyPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisViewAttDaily lmisViewAttDaily);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewAttDaily> lmisViewAttDailies);

	public void clearCache();

	public larion.progate.lmis.model.LmisViewAttDaily create(
		java.lang.Integer lmisViewAttDailyId);

	public larion.progate.lmis.model.LmisViewAttDaily remove(
		java.lang.Integer lmisViewAttDailyId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException;

	public larion.progate.lmis.model.LmisViewAttDaily remove(
		larion.progate.lmis.model.LmisViewAttDaily lmisViewAttDaily)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewAttDaily update(
		larion.progate.lmis.model.LmisViewAttDaily lmisViewAttDaily)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewAttDaily update(
		larion.progate.lmis.model.LmisViewAttDaily lmisViewAttDaily,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewAttDaily updateImpl(
		larion.progate.lmis.model.LmisViewAttDaily lmisViewAttDaily,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewAttDaily findByPrimaryKey(
		java.lang.Integer lmisViewAttDailyId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException;

	public larion.progate.lmis.model.LmisViewAttDaily fetchByPrimaryKey(
		java.lang.Integer lmisViewAttDailyId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findByRootId(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findByRootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findByRootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewAttDaily findByRootId_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException;

	public larion.progate.lmis.model.LmisViewAttDaily findByRootId_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException;

	public larion.progate.lmis.model.LmisViewAttDaily[] findByRootId_PrevAndNext(
		java.lang.Integer lmisViewAttDailyId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findByOrgId(
		int orgId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findByOrgId(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findByOrgId(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewAttDaily findByOrgId_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException;

	public larion.progate.lmis.model.LmisViewAttDaily findByOrgId_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException;

	public larion.progate.lmis.model.LmisViewAttDaily[] findByOrgId_PrevAndNext(
		java.lang.Integer lmisViewAttDailyId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findByUserId(
		int userId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findByUserId(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findByUserId(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewAttDaily findByUserId_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException;

	public larion.progate.lmis.model.LmisViewAttDaily findByUserId_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException;

	public larion.progate.lmis.model.LmisViewAttDaily[] findByUserId_PrevAndNext(
		java.lang.Integer lmisViewAttDailyId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findByDayValue(
		java.util.Date dayValue) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findByDayValue(
		java.util.Date dayValue, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findByDayValue(
		java.util.Date dayValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewAttDaily findByDayValue_First(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException;

	public larion.progate.lmis.model.LmisViewAttDaily findByDayValue_Last(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException;

	public larion.progate.lmis.model.LmisViewAttDaily[] findByDayValue_PrevAndNext(
		java.lang.Integer lmisViewAttDailyId, java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findByFullName(
		java.lang.String fullName) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findByFullName(
		java.lang.String fullName, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findByFullName(
		java.lang.String fullName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewAttDaily findByFullName_First(
		java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException;

	public larion.progate.lmis.model.LmisViewAttDaily findByFullName_Last(
		java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException;

	public larion.progate.lmis.model.LmisViewAttDaily[] findByFullName_PrevAndNext(
		java.lang.Integer lmisViewAttDailyId, java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttDailyException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttDaily> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByRootId(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeByOrgId(int orgId)
		throws com.liferay.portal.SystemException;

	public void removeByUserId(int userId)
		throws com.liferay.portal.SystemException;

	public void removeByDayValue(java.util.Date dayValue)
		throws com.liferay.portal.SystemException;

	public void removeByFullName(java.lang.String fullName)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByRootId(int rootId)
		throws com.liferay.portal.SystemException;

	public int countByOrgId(int orgId)
		throws com.liferay.portal.SystemException;

	public int countByUserId(int userId)
		throws com.liferay.portal.SystemException;

	public int countByDayValue(java.util.Date dayValue)
		throws com.liferay.portal.SystemException;

	public int countByFullName(java.lang.String fullName)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}