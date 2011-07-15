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
 * <a href="LmisAttMonthlyPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisAttMonthlyPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisAttMonthly lmisAttMonthly);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisAttMonthly> lmisAttMonthlies);

	public void clearCache();

	public larion.progate.lmis.model.LmisAttMonthly create(
		java.lang.Integer lmisAttMonthlysId);

	public larion.progate.lmis.model.LmisAttMonthly remove(
		java.lang.Integer lmisAttMonthlysId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException;

	public larion.progate.lmis.model.LmisAttMonthly remove(
		larion.progate.lmis.model.LmisAttMonthly lmisAttMonthly)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAttMonthly update(
		larion.progate.lmis.model.LmisAttMonthly lmisAttMonthly)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAttMonthly update(
		larion.progate.lmis.model.LmisAttMonthly lmisAttMonthly, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAttMonthly updateImpl(
		larion.progate.lmis.model.LmisAttMonthly lmisAttMonthly, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAttMonthly findByPrimaryKey(
		java.lang.Integer lmisAttMonthlysId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException;

	public larion.progate.lmis.model.LmisAttMonthly fetchByPrimaryKey(
		java.lang.Integer lmisAttMonthlysId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttMonthly> findByRootId(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttMonthly> findByRootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttMonthly> findByRootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAttMonthly findByRootId_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException;

	public larion.progate.lmis.model.LmisAttMonthly findByRootId_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException;

	public larion.progate.lmis.model.LmisAttMonthly[] findByRootId_PrevAndNext(
		java.lang.Integer lmisAttMonthlysId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException;

	public java.util.List<larion.progate.lmis.model.LmisAttMonthly> findByNumDayAward(
		double numDayAward) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttMonthly> findByNumDayAward(
		double numDayAward, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttMonthly> findByNumDayAward(
		double numDayAward, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAttMonthly findByNumDayAward_First(
		double numDayAward, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException;

	public larion.progate.lmis.model.LmisAttMonthly findByNumDayAward_Last(
		double numDayAward, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException;

	public larion.progate.lmis.model.LmisAttMonthly[] findByNumDayAward_PrevAndNext(
		java.lang.Integer lmisAttMonthlysId, double numDayAward,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException;

	public java.util.List<larion.progate.lmis.model.LmisAttMonthly> findByUserId(
		int userId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttMonthly> findByUserId(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttMonthly> findByUserId(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAttMonthly findByUserId_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException;

	public larion.progate.lmis.model.LmisAttMonthly findByUserId_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException;

	public larion.progate.lmis.model.LmisAttMonthly[] findByUserId_PrevAndNext(
		java.lang.Integer lmisAttMonthlysId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException;

	public java.util.List<larion.progate.lmis.model.LmisAttMonthly> findByMonthValue(
		int monthValue) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttMonthly> findByMonthValue(
		int monthValue, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttMonthly> findByMonthValue(
		int monthValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAttMonthly findByMonthValue_First(
		int monthValue, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException;

	public larion.progate.lmis.model.LmisAttMonthly findByMonthValue_Last(
		int monthValue, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException;

	public larion.progate.lmis.model.LmisAttMonthly[] findByMonthValue_PrevAndNext(
		java.lang.Integer lmisAttMonthlysId, int monthValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException;

	public java.util.List<larion.progate.lmis.model.LmisAttMonthly> findByYearValue(
		int yearValue) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttMonthly> findByYearValue(
		int yearValue, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttMonthly> findByYearValue(
		int yearValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAttMonthly findByYearValue_First(
		int yearValue, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException;

	public larion.progate.lmis.model.LmisAttMonthly findByYearValue_Last(
		int yearValue, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException;

	public larion.progate.lmis.model.LmisAttMonthly[] findByYearValue_PrevAndNext(
		java.lang.Integer lmisAttMonthlysId, int yearValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAttMonthlyException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttMonthly> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttMonthly> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAttMonthly> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByRootId(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeByNumDayAward(double numDayAward)
		throws com.liferay.portal.SystemException;

	public void removeByUserId(int userId)
		throws com.liferay.portal.SystemException;

	public void removeByMonthValue(int monthValue)
		throws com.liferay.portal.SystemException;

	public void removeByYearValue(int yearValue)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByRootId(int rootId)
		throws com.liferay.portal.SystemException;

	public int countByNumDayAward(double numDayAward)
		throws com.liferay.portal.SystemException;

	public int countByUserId(int userId)
		throws com.liferay.portal.SystemException;

	public int countByMonthValue(int monthValue)
		throws com.liferay.portal.SystemException;

	public int countByYearValue(int yearValue)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}