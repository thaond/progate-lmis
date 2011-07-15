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
 * <a href="LmisViewStaffMappingPmPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisViewStaffMappingPmPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisViewStaffMappingPm lmisViewStaffMappingPm);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> lmisViewStaffMappingPms);

	public void clearCache();

	public larion.progate.lmis.model.LmisViewStaffMappingPm create(
		java.lang.Integer lmisViewStaffMappingPmId);

	public larion.progate.lmis.model.LmisViewStaffMappingPm remove(
		java.lang.Integer lmisViewStaffMappingPmId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingPmException;

	public larion.progate.lmis.model.LmisViewStaffMappingPm remove(
		larion.progate.lmis.model.LmisViewStaffMappingPm lmisViewStaffMappingPm)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewStaffMappingPm update(
		larion.progate.lmis.model.LmisViewStaffMappingPm lmisViewStaffMappingPm)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewStaffMappingPm update(
		larion.progate.lmis.model.LmisViewStaffMappingPm lmisViewStaffMappingPm,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewStaffMappingPm updateImpl(
		larion.progate.lmis.model.LmisViewStaffMappingPm lmisViewStaffMappingPm,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewStaffMappingPm findByPrimaryKey(
		java.lang.Integer lmisViewStaffMappingPmId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingPmException;

	public larion.progate.lmis.model.LmisViewStaffMappingPm fetchByPrimaryKey(
		java.lang.Integer lmisViewStaffMappingPmId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> findByStaffUID(
		int staffUID) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> findByStaffUID(
		int staffUID, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> findByStaffUID(
		int staffUID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewStaffMappingPm findByStaffUID_First(
		int staffUID, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingPmException;

	public larion.progate.lmis.model.LmisViewStaffMappingPm findByStaffUID_Last(
		int staffUID, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingPmException;

	public larion.progate.lmis.model.LmisViewStaffMappingPm[] findByStaffUID_PrevAndNext(
		java.lang.Integer lmisViewStaffMappingPmId, int staffUID,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingPmException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> findByRootID(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewStaffMappingPm findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingPmException;

	public larion.progate.lmis.model.LmisViewStaffMappingPm findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingPmException;

	public larion.progate.lmis.model.LmisViewStaffMappingPm[] findByRootID_PrevAndNext(
		java.lang.Integer lmisViewStaffMappingPmId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingPmException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> findByPmUID(
		int pmUID) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> findByPmUID(
		int pmUID, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> findByPmUID(
		int pmUID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewStaffMappingPm findByPmUID_First(
		int pmUID, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingPmException;

	public larion.progate.lmis.model.LmisViewStaffMappingPm findByPmUID_Last(
		int pmUID, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingPmException;

	public larion.progate.lmis.model.LmisViewStaffMappingPm[] findByPmUID_PrevAndNext(
		java.lang.Integer lmisViewStaffMappingPmId, int pmUID,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingPmException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> findByBodId(
		int bodId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> findByBodId(
		int bodId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> findByBodId(
		int bodId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewStaffMappingPm findByBodId_First(
		int bodId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingPmException;

	public larion.progate.lmis.model.LmisViewStaffMappingPm findByBodId_Last(
		int bodId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingPmException;

	public larion.progate.lmis.model.LmisViewStaffMappingPm[] findByBodId_PrevAndNext(
		java.lang.Integer lmisViewStaffMappingPmId, int bodId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingPmException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByStaffUID(int staffUID)
		throws com.liferay.portal.SystemException;

	public void removeByRootID(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeByPmUID(int pmUID)
		throws com.liferay.portal.SystemException;

	public void removeByBodId(int bodId)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByStaffUID(int staffUID)
		throws com.liferay.portal.SystemException;

	public int countByRootID(int rootId)
		throws com.liferay.portal.SystemException;

	public int countByPmUID(int pmUID)
		throws com.liferay.portal.SystemException;

	public int countByBodId(int bodId)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}