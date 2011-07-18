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
 * <a href="LmisViewStaffRootOrgOrderedPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisViewStaffRootOrgOrderedPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> lmisViewStaffRootOrgOrdereds);

	public void clearCache();

	public larion.progate.lmis.model.LmisViewStaffRootOrgOrdered create(
		java.lang.Integer lmisViewStaffRootOrgOrderedId);

	public larion.progate.lmis.model.LmisViewStaffRootOrgOrdered remove(
		java.lang.Integer lmisViewStaffRootOrgOrderedId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgOrderedException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgOrdered remove(
		larion.progate.lmis.model.LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgOrdered update(
		larion.progate.lmis.model.LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgOrdered update(
		larion.progate.lmis.model.LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgOrdered updateImpl(
		larion.progate.lmis.model.LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgOrdered findByPrimaryKey(
		java.lang.Integer lmisViewStaffRootOrgOrderedId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgOrderedException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgOrdered fetchByPrimaryKey(
		java.lang.Integer lmisViewStaffRootOrgOrderedId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> findByRootID(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgOrdered findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgOrderedException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgOrdered findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgOrderedException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgOrdered[] findByRootID_PrevAndNext(
		java.lang.Integer lmisViewStaffRootOrgOrderedId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgOrderedException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> findByUserId(
		int userId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> findByUserId(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> findByUserId(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgOrdered findByUserId_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgOrderedException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgOrdered findByUserId_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgOrderedException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgOrdered[] findByUserId_PrevAndNext(
		java.lang.Integer lmisViewStaffRootOrgOrderedId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgOrderedException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> findByOrgID(
		int orgId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> findByOrgID(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> findByOrgID(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgOrdered findByOrgID_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgOrderedException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgOrdered findByOrgID_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgOrderedException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgOrdered[] findByOrgID_PrevAndNext(
		java.lang.Integer lmisViewStaffRootOrgOrderedId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgOrderedException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> findByFullName(
		java.lang.String fullName) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> findByFullName(
		java.lang.String fullName, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> findByFullName(
		java.lang.String fullName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgOrdered findByFullName_First(
		java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgOrderedException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgOrdered findByFullName_Last(
		java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgOrderedException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgOrdered[] findByFullName_PrevAndNext(
		java.lang.Integer lmisViewStaffRootOrgOrderedId,
		java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgOrderedException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByRootID(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeByUserId(int userId)
		throws com.liferay.portal.SystemException;

	public void removeByOrgID(int orgId)
		throws com.liferay.portal.SystemException;

	public void removeByFullName(java.lang.String fullName)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByRootID(int rootId)
		throws com.liferay.portal.SystemException;

	public int countByUserId(int userId)
		throws com.liferay.portal.SystemException;

	public int countByOrgID(int orgId)
		throws com.liferay.portal.SystemException;

	public int countByFullName(java.lang.String fullName)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}