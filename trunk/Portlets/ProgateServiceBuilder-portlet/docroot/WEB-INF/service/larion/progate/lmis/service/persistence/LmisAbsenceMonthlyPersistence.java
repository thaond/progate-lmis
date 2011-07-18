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
 * <a href="LmisAbsenceMonthlyPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisAbsenceMonthlyPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisAbsenceMonthly lmisAbsenceMonthly);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisAbsenceMonthly> lmisAbsenceMonthlies);

	public void clearCache();

	public larion.progate.lmis.model.LmisAbsenceMonthly create(
		java.lang.Integer lmisAbsenceMonthlyId);

	public larion.progate.lmis.model.LmisAbsenceMonthly remove(
		java.lang.Integer lmisAbsenceMonthlyId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceMonthlyException;

	public larion.progate.lmis.model.LmisAbsenceMonthly remove(
		larion.progate.lmis.model.LmisAbsenceMonthly lmisAbsenceMonthly)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceMonthly update(
		larion.progate.lmis.model.LmisAbsenceMonthly lmisAbsenceMonthly)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceMonthly update(
		larion.progate.lmis.model.LmisAbsenceMonthly lmisAbsenceMonthly,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceMonthly updateImpl(
		larion.progate.lmis.model.LmisAbsenceMonthly lmisAbsenceMonthly,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceMonthly findByPrimaryKey(
		java.lang.Integer lmisAbsenceMonthlyId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceMonthlyException;

	public larion.progate.lmis.model.LmisAbsenceMonthly fetchByPrimaryKey(
		java.lang.Integer lmisAbsenceMonthlyId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceMonthly> findByRootID(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceMonthly> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceMonthly> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceMonthly findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceMonthlyException;

	public larion.progate.lmis.model.LmisAbsenceMonthly findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceMonthlyException;

	public larion.progate.lmis.model.LmisAbsenceMonthly[] findByRootID_PrevAndNext(
		java.lang.Integer lmisAbsenceMonthlyId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceMonthlyException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceMonthly> findByuserID(
		int userId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceMonthly> findByuserID(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceMonthly> findByuserID(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceMonthly findByuserID_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceMonthlyException;

	public larion.progate.lmis.model.LmisAbsenceMonthly findByuserID_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceMonthlyException;

	public larion.progate.lmis.model.LmisAbsenceMonthly[] findByuserID_PrevAndNext(
		java.lang.Integer lmisAbsenceMonthlyId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceMonthlyException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceMonthly> findByMonthValue(
		int monthValue) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceMonthly> findByMonthValue(
		int monthValue, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceMonthly> findByMonthValue(
		int monthValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceMonthly findByMonthValue_First(
		int monthValue, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceMonthlyException;

	public larion.progate.lmis.model.LmisAbsenceMonthly findByMonthValue_Last(
		int monthValue, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceMonthlyException;

	public larion.progate.lmis.model.LmisAbsenceMonthly[] findByMonthValue_PrevAndNext(
		java.lang.Integer lmisAbsenceMonthlyId, int monthValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceMonthlyException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceMonthly> findByYearValue(
		int yearValue) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceMonthly> findByYearValue(
		int yearValue, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceMonthly> findByYearValue(
		int yearValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceMonthly findByYearValue_First(
		int yearValue, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceMonthlyException;

	public larion.progate.lmis.model.LmisAbsenceMonthly findByYearValue_Last(
		int yearValue, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceMonthlyException;

	public larion.progate.lmis.model.LmisAbsenceMonthly[] findByYearValue_PrevAndNext(
		java.lang.Integer lmisAbsenceMonthlyId, int yearValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceMonthlyException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceMonthly> findByAbsenceType(
		java.lang.String absenceType) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceMonthly> findByAbsenceType(
		java.lang.String absenceType, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceMonthly> findByAbsenceType(
		java.lang.String absenceType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceMonthly findByAbsenceType_First(
		java.lang.String absenceType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceMonthlyException;

	public larion.progate.lmis.model.LmisAbsenceMonthly findByAbsenceType_Last(
		java.lang.String absenceType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceMonthlyException;

	public larion.progate.lmis.model.LmisAbsenceMonthly[] findByAbsenceType_PrevAndNext(
		java.lang.Integer lmisAbsenceMonthlyId, java.lang.String absenceType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceMonthlyException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceMonthly> findByAbsenceTypeID(
		int absenceTypeId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceMonthly> findByAbsenceTypeID(
		int absenceTypeId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceMonthly> findByAbsenceTypeID(
		int absenceTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceMonthly findByAbsenceTypeID_First(
		int absenceTypeId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceMonthlyException;

	public larion.progate.lmis.model.LmisAbsenceMonthly findByAbsenceTypeID_Last(
		int absenceTypeId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceMonthlyException;

	public larion.progate.lmis.model.LmisAbsenceMonthly[] findByAbsenceTypeID_PrevAndNext(
		java.lang.Integer lmisAbsenceMonthlyId, int absenceTypeId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceMonthlyException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceMonthly> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceMonthly> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceMonthly> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByRootID(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeByuserID(int userId)
		throws com.liferay.portal.SystemException;

	public void removeByMonthValue(int monthValue)
		throws com.liferay.portal.SystemException;

	public void removeByYearValue(int yearValue)
		throws com.liferay.portal.SystemException;

	public void removeByAbsenceType(java.lang.String absenceType)
		throws com.liferay.portal.SystemException;

	public void removeByAbsenceTypeID(int absenceTypeId)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByRootID(int rootId)
		throws com.liferay.portal.SystemException;

	public int countByuserID(int userId)
		throws com.liferay.portal.SystemException;

	public int countByMonthValue(int monthValue)
		throws com.liferay.portal.SystemException;

	public int countByYearValue(int yearValue)
		throws com.liferay.portal.SystemException;

	public int countByAbsenceType(java.lang.String absenceType)
		throws com.liferay.portal.SystemException;

	public int countByAbsenceTypeID(int absenceTypeId)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}