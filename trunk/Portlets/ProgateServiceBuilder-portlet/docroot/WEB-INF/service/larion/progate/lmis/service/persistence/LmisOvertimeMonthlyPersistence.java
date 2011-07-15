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
 * <a href="LmisOvertimeMonthlyPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisOvertimeMonthlyPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisOvertimeMonthly lmisOvertimeMonthly);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> lmisOvertimeMonthlies);

	public void clearCache();

	public larion.progate.lmis.model.LmisOvertimeMonthly create(
		java.lang.Integer lmisOvertimeMonthlyId);

	public larion.progate.lmis.model.LmisOvertimeMonthly remove(
		java.lang.Integer lmisOvertimeMonthlyId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException;

	public larion.progate.lmis.model.LmisOvertimeMonthly remove(
		larion.progate.lmis.model.LmisOvertimeMonthly lmisOvertimeMonthly)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeMonthly update(
		larion.progate.lmis.model.LmisOvertimeMonthly lmisOvertimeMonthly)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeMonthly update(
		larion.progate.lmis.model.LmisOvertimeMonthly lmisOvertimeMonthly,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeMonthly updateImpl(
		larion.progate.lmis.model.LmisOvertimeMonthly lmisOvertimeMonthly,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeMonthly findByPrimaryKey(
		java.lang.Integer lmisOvertimeMonthlyId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException;

	public larion.progate.lmis.model.LmisOvertimeMonthly fetchByPrimaryKey(
		java.lang.Integer lmisOvertimeMonthlyId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByOvertimeMonthlyOf(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByOvertimeMonthlyOf(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByOvertimeMonthlyOf(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeMonthly findByOvertimeMonthlyOf_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException;

	public larion.progate.lmis.model.LmisOvertimeMonthly findByOvertimeMonthlyOf_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException;

	public larion.progate.lmis.model.LmisOvertimeMonthly[] findByOvertimeMonthlyOf_PrevAndNext(
		java.lang.Integer lmisOvertimeMonthlyId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByUserID(
		int userId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByUserID(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByUserID(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeMonthly findByUserID_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException;

	public larion.progate.lmis.model.LmisOvertimeMonthly findByUserID_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException;

	public larion.progate.lmis.model.LmisOvertimeMonthly[] findByUserID_PrevAndNext(
		java.lang.Integer lmisOvertimeMonthlyId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByOrgID(
		int orgId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByOrgID(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByOrgID(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeMonthly findByOrgID_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException;

	public larion.progate.lmis.model.LmisOvertimeMonthly findByOrgID_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException;

	public larion.progate.lmis.model.LmisOvertimeMonthly[] findByOrgID_PrevAndNext(
		java.lang.Integer lmisOvertimeMonthlyId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByOtID(
		int otId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByOtID(
		int otId, int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByOtID(
		int otId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeMonthly findByOtID_First(
		int otId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException;

	public larion.progate.lmis.model.LmisOvertimeMonthly findByOtID_Last(
		int otId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException;

	public larion.progate.lmis.model.LmisOvertimeMonthly[] findByOtID_PrevAndNext(
		java.lang.Integer lmisOvertimeMonthlyId, int otId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByMonthValue(
		int monthValue) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByMonthValue(
		int monthValue, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByMonthValue(
		int monthValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeMonthly findByMonthValue_First(
		int monthValue, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException;

	public larion.progate.lmis.model.LmisOvertimeMonthly findByMonthValue_Last(
		int monthValue, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException;

	public larion.progate.lmis.model.LmisOvertimeMonthly[] findByMonthValue_PrevAndNext(
		java.lang.Integer lmisOvertimeMonthlyId, int monthValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByYearValue(
		int yearValue) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByYearValue(
		int yearValue, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findByYearValue(
		int yearValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeMonthly findByYearValue_First(
		int yearValue, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException;

	public larion.progate.lmis.model.LmisOvertimeMonthly findByYearValue_Last(
		int yearValue, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException;

	public larion.progate.lmis.model.LmisOvertimeMonthly[] findByYearValue_PrevAndNext(
		java.lang.Integer lmisOvertimeMonthlyId, int yearValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeMonthlyException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeMonthly> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByOvertimeMonthlyOf(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeByUserID(int userId)
		throws com.liferay.portal.SystemException;

	public void removeByOrgID(int orgId)
		throws com.liferay.portal.SystemException;

	public void removeByOtID(int otId)
		throws com.liferay.portal.SystemException;

	public void removeByMonthValue(int monthValue)
		throws com.liferay.portal.SystemException;

	public void removeByYearValue(int yearValue)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByOvertimeMonthlyOf(int rootId)
		throws com.liferay.portal.SystemException;

	public int countByUserID(int userId)
		throws com.liferay.portal.SystemException;

	public int countByOrgID(int orgId)
		throws com.liferay.portal.SystemException;

	public int countByOtID(int otId) throws com.liferay.portal.SystemException;

	public int countByMonthValue(int monthValue)
		throws com.liferay.portal.SystemException;

	public int countByYearValue(int yearValue)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}