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
 * <a href="LmisViewAttdancePersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisViewAttdancePersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisViewAttdance lmisViewAttdance);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewAttdance> lmisViewAttdances);

	public void clearCache();

	public larion.progate.lmis.model.LmisViewAttdance create(
		java.lang.Integer lmisViewAttDailyId);

	public larion.progate.lmis.model.LmisViewAttdance remove(
		java.lang.Integer lmisViewAttDailyId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttdanceException;

	public larion.progate.lmis.model.LmisViewAttdance remove(
		larion.progate.lmis.model.LmisViewAttdance lmisViewAttdance)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewAttdance update(
		larion.progate.lmis.model.LmisViewAttdance lmisViewAttdance)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewAttdance update(
		larion.progate.lmis.model.LmisViewAttdance lmisViewAttdance,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewAttdance updateImpl(
		larion.progate.lmis.model.LmisViewAttdance lmisViewAttdance,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewAttdance findByPrimaryKey(
		java.lang.Integer lmisViewAttDailyId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttdanceException;

	public larion.progate.lmis.model.LmisViewAttdance fetchByPrimaryKey(
		java.lang.Integer lmisViewAttDailyId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttdance> findByRootId(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttdance> findByRootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttdance> findByRootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewAttdance findByRootId_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttdanceException;

	public larion.progate.lmis.model.LmisViewAttdance findByRootId_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttdanceException;

	public larion.progate.lmis.model.LmisViewAttdance[] findByRootId_PrevAndNext(
		java.lang.Integer lmisViewAttDailyId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttdanceException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttdance> findByUserId(
		int userId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttdance> findByUserId(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttdance> findByUserId(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewAttdance findByUserId_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttdanceException;

	public larion.progate.lmis.model.LmisViewAttdance findByUserId_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttdanceException;

	public larion.progate.lmis.model.LmisViewAttdance[] findByUserId_PrevAndNext(
		java.lang.Integer lmisViewAttDailyId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttdanceException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttdance> findByDayValue(
		java.util.Date dayValue) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttdance> findByDayValue(
		java.util.Date dayValue, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttdance> findByDayValue(
		java.util.Date dayValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewAttdance findByDayValue_First(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttdanceException;

	public larion.progate.lmis.model.LmisViewAttdance findByDayValue_Last(
		java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttdanceException;

	public larion.progate.lmis.model.LmisViewAttdance[] findByDayValue_PrevAndNext(
		java.lang.Integer lmisViewAttDailyId, java.util.Date dayValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttdanceException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttdance> findByFullName(
		java.lang.String fullName) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttdance> findByFullName(
		java.lang.String fullName, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttdance> findByFullName(
		java.lang.String fullName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewAttdance findByFullName_First(
		java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttdanceException;

	public larion.progate.lmis.model.LmisViewAttdance findByFullName_Last(
		java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttdanceException;

	public larion.progate.lmis.model.LmisViewAttdance[] findByFullName_PrevAndNext(
		java.lang.Integer lmisViewAttDailyId, java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewAttdanceException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttdance> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttdance> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewAttdance> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByRootId(int rootId)
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

	public int countByUserId(int userId)
		throws com.liferay.portal.SystemException;

	public int countByDayValue(java.util.Date dayValue)
		throws com.liferay.portal.SystemException;

	public int countByFullName(java.lang.String fullName)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}