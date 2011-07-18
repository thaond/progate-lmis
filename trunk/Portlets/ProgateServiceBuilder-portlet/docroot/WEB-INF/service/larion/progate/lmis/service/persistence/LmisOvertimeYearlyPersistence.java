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
 * <a href="LmisOvertimeYearlyPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisOvertimeYearlyPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisOvertimeYearly lmisOvertimeYearly);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisOvertimeYearly> lmisOvertimeYearlies);

	public void clearCache();

	public larion.progate.lmis.model.LmisOvertimeYearly create(
		java.lang.Integer lmisOvertimeYearlyId);

	public larion.progate.lmis.model.LmisOvertimeYearly remove(
		java.lang.Integer lmisOvertimeYearlyId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeYearlyException;

	public larion.progate.lmis.model.LmisOvertimeYearly remove(
		larion.progate.lmis.model.LmisOvertimeYearly lmisOvertimeYearly)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeYearly update(
		larion.progate.lmis.model.LmisOvertimeYearly lmisOvertimeYearly)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeYearly update(
		larion.progate.lmis.model.LmisOvertimeYearly lmisOvertimeYearly,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeYearly updateImpl(
		larion.progate.lmis.model.LmisOvertimeYearly lmisOvertimeYearly,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeYearly findByPrimaryKey(
		java.lang.Integer lmisOvertimeYearlyId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeYearlyException;

	public larion.progate.lmis.model.LmisOvertimeYearly fetchByPrimaryKey(
		java.lang.Integer lmisOvertimeYearlyId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeYearly> findByOvertimeYearOf(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeYearly> findByOvertimeYearOf(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeYearly> findByOvertimeYearOf(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeYearly findByOvertimeYearOf_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeYearlyException;

	public larion.progate.lmis.model.LmisOvertimeYearly findByOvertimeYearOf_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeYearlyException;

	public larion.progate.lmis.model.LmisOvertimeYearly[] findByOvertimeYearOf_PrevAndNext(
		java.lang.Integer lmisOvertimeYearlyId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeYearlyException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeYearly> findByUserID(
		int userId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeYearly> findByUserID(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeYearly> findByUserID(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeYearly findByUserID_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeYearlyException;

	public larion.progate.lmis.model.LmisOvertimeYearly findByUserID_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeYearlyException;

	public larion.progate.lmis.model.LmisOvertimeYearly[] findByUserID_PrevAndNext(
		java.lang.Integer lmisOvertimeYearlyId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeYearlyException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeYearly> findByYearValue(
		int yearValue) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeYearly> findByYearValue(
		int yearValue, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeYearly> findByYearValue(
		int yearValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeYearly findByYearValue_First(
		int yearValue, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeYearlyException;

	public larion.progate.lmis.model.LmisOvertimeYearly findByYearValue_Last(
		int yearValue, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeYearlyException;

	public larion.progate.lmis.model.LmisOvertimeYearly[] findByYearValue_PrevAndNext(
		java.lang.Integer lmisOvertimeYearlyId, int yearValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeYearlyException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeYearly> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeYearly> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeYearly> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByOvertimeYearOf(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeByUserID(int userId)
		throws com.liferay.portal.SystemException;

	public void removeByYearValue(int yearValue)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByOvertimeYearOf(int rootId)
		throws com.liferay.portal.SystemException;

	public int countByUserID(int userId)
		throws com.liferay.portal.SystemException;

	public int countByYearValue(int yearValue)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}