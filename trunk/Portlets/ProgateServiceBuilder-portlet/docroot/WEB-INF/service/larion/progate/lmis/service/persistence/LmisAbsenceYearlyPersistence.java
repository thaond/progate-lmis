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
 * <a href="LmisAbsenceYearlyPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisAbsenceYearlyPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisAbsenceYearly lmisAbsenceYearly);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> lmisAbsenceYearlies);

	public void clearCache();

	public larion.progate.lmis.model.LmisAbsenceYearly create(
		java.lang.Integer lmisAbsenceYearlyId);

	public larion.progate.lmis.model.LmisAbsenceYearly remove(
		java.lang.Integer lmisAbsenceYearlyId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException;

	public larion.progate.lmis.model.LmisAbsenceYearly remove(
		larion.progate.lmis.model.LmisAbsenceYearly lmisAbsenceYearly)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceYearly update(
		larion.progate.lmis.model.LmisAbsenceYearly lmisAbsenceYearly)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceYearly update(
		larion.progate.lmis.model.LmisAbsenceYearly lmisAbsenceYearly,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceYearly updateImpl(
		larion.progate.lmis.model.LmisAbsenceYearly lmisAbsenceYearly,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceYearly findByPrimaryKey(
		java.lang.Integer lmisAbsenceYearlyId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException;

	public larion.progate.lmis.model.LmisAbsenceYearly fetchByPrimaryKey(
		java.lang.Integer lmisAbsenceYearlyId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findByRootID(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceYearly findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException;

	public larion.progate.lmis.model.LmisAbsenceYearly findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException;

	public larion.progate.lmis.model.LmisAbsenceYearly[] findByRootID_PrevAndNext(
		java.lang.Integer lmisAbsenceYearlyId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findByuserID(
		int userId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findByuserID(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findByuserID(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceYearly findByuserID_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException;

	public larion.progate.lmis.model.LmisAbsenceYearly findByuserID_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException;

	public larion.progate.lmis.model.LmisAbsenceYearly[] findByuserID_PrevAndNext(
		java.lang.Integer lmisAbsenceYearlyId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findByYearValue(
		int yearValue) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findByYearValue(
		int yearValue, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findByYearValue(
		int yearValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceYearly findByYearValue_First(
		int yearValue, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException;

	public larion.progate.lmis.model.LmisAbsenceYearly findByYearValue_Last(
		int yearValue, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException;

	public larion.progate.lmis.model.LmisAbsenceYearly[] findByYearValue_PrevAndNext(
		java.lang.Integer lmisAbsenceYearlyId, int yearValue,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findByAbsenceType(
		java.lang.String absenceType) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findByAbsenceType(
		java.lang.String absenceType, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findByAbsenceType(
		java.lang.String absenceType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceYearly findByAbsenceType_First(
		java.lang.String absenceType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException;

	public larion.progate.lmis.model.LmisAbsenceYearly findByAbsenceType_Last(
		java.lang.String absenceType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException;

	public larion.progate.lmis.model.LmisAbsenceYearly[] findByAbsenceType_PrevAndNext(
		java.lang.Integer lmisAbsenceYearlyId, java.lang.String absenceType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findByAbsenceTypeID(
		int absenceTypeId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findByAbsenceTypeID(
		int absenceTypeId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findByAbsenceTypeID(
		int absenceTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisAbsenceYearly findByAbsenceTypeID_First(
		int absenceTypeId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException;

	public larion.progate.lmis.model.LmisAbsenceYearly findByAbsenceTypeID_Last(
		int absenceTypeId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException;

	public larion.progate.lmis.model.LmisAbsenceYearly[] findByAbsenceTypeID_PrevAndNext(
		java.lang.Integer lmisAbsenceYearlyId, int absenceTypeId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceYearlyException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisAbsenceYearly> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByRootID(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeByuserID(int userId)
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

	public int countByYearValue(int yearValue)
		throws com.liferay.portal.SystemException;

	public int countByAbsenceType(java.lang.String absenceType)
		throws com.liferay.portal.SystemException;

	public int countByAbsenceTypeID(int absenceTypeId)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}