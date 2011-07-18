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
 * <a href="LmisViewStaffRootOrgFNPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisViewStaffRootOrgFNPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisViewStaffRootOrgFN lmisViewStaffRootOrgFN);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgFN> lmisViewStaffRootOrgFNs);

	public void clearCache();

	public larion.progate.lmis.model.LmisViewStaffRootOrgFN create(
		java.lang.Integer lmisViewStaffRootOrgFNId);

	public larion.progate.lmis.model.LmisViewStaffRootOrgFN remove(
		java.lang.Integer lmisViewStaffRootOrgFNId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgFNException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgFN remove(
		larion.progate.lmis.model.LmisViewStaffRootOrgFN lmisViewStaffRootOrgFN)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgFN update(
		larion.progate.lmis.model.LmisViewStaffRootOrgFN lmisViewStaffRootOrgFN)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgFN update(
		larion.progate.lmis.model.LmisViewStaffRootOrgFN lmisViewStaffRootOrgFN,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgFN updateImpl(
		larion.progate.lmis.model.LmisViewStaffRootOrgFN lmisViewStaffRootOrgFN,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgFN findByPrimaryKey(
		java.lang.Integer lmisViewStaffRootOrgFNId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgFNException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgFN fetchByPrimaryKey(
		java.lang.Integer lmisViewStaffRootOrgFNId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgFN> findByRootID(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgFN> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgFN> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgFN findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgFNException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgFN findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgFNException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgFN[] findByRootID_PrevAndNext(
		java.lang.Integer lmisViewStaffRootOrgFNId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgFNException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgFN> findByUserId(
		int userId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgFN> findByUserId(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgFN> findByUserId(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgFN findByUserId_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgFNException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgFN findByUserId_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgFNException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgFN[] findByUserId_PrevAndNext(
		java.lang.Integer lmisViewStaffRootOrgFNId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgFNException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgFN> findByOrgID(
		int orgId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgFN> findByOrgID(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgFN> findByOrgID(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgFN findByOrgID_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgFNException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgFN findByOrgID_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgFNException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgFN[] findByOrgID_PrevAndNext(
		java.lang.Integer lmisViewStaffRootOrgFNId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgFNException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgFN> findByFullName(
		java.lang.String fullName) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgFN> findByFullName(
		java.lang.String fullName, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgFN> findByFullName(
		java.lang.String fullName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgFN findByFullName_First(
		java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgFNException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgFN findByFullName_Last(
		java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgFNException;

	public larion.progate.lmis.model.LmisViewStaffRootOrgFN[] findByFullName_PrevAndNext(
		java.lang.Integer lmisViewStaffRootOrgFNId, java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgFNException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgFN> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgFN> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgFN> findAll(
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