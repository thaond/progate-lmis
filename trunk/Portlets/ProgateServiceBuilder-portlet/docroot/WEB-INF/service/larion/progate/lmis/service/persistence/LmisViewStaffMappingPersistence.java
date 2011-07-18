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
 * <a href="LmisViewStaffMappingPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisViewStaffMappingPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisViewStaffMapping lmisViewStaffMapping);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> lmisViewStaffMappings);

	public void clearCache();

	public larion.progate.lmis.model.LmisViewStaffMapping create(
		java.lang.Integer lmisViewStaffMappingId);

	public larion.progate.lmis.model.LmisViewStaffMapping remove(
		java.lang.Integer lmisViewStaffMappingId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingException;

	public larion.progate.lmis.model.LmisViewStaffMapping remove(
		larion.progate.lmis.model.LmisViewStaffMapping lmisViewStaffMapping)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewStaffMapping update(
		larion.progate.lmis.model.LmisViewStaffMapping lmisViewStaffMapping)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewStaffMapping update(
		larion.progate.lmis.model.LmisViewStaffMapping lmisViewStaffMapping,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewStaffMapping updateImpl(
		larion.progate.lmis.model.LmisViewStaffMapping lmisViewStaffMapping,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewStaffMapping findByPrimaryKey(
		java.lang.Integer lmisViewStaffMappingId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingException;

	public larion.progate.lmis.model.LmisViewStaffMapping fetchByPrimaryKey(
		java.lang.Integer lmisViewStaffMappingId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> findByStaffUID(
		int staffUID) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> findByStaffUID(
		int staffUID, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> findByStaffUID(
		int staffUID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewStaffMapping findByStaffUID_First(
		int staffUID, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingException;

	public larion.progate.lmis.model.LmisViewStaffMapping findByStaffUID_Last(
		int staffUID, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingException;

	public larion.progate.lmis.model.LmisViewStaffMapping[] findByStaffUID_PrevAndNext(
		java.lang.Integer lmisViewStaffMappingId, int staffUID,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> findByRootID(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewStaffMapping findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingException;

	public larion.progate.lmis.model.LmisViewStaffMapping findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingException;

	public larion.progate.lmis.model.LmisViewStaffMapping[] findByRootID_PrevAndNext(
		java.lang.Integer lmisViewStaffMappingId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> findByPmUID(
		int pmUID) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> findByPmUID(
		int pmUID, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> findByPmUID(
		int pmUID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewStaffMapping findByPmUID_First(
		int pmUID, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingException;

	public larion.progate.lmis.model.LmisViewStaffMapping findByPmUID_Last(
		int pmUID, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingException;

	public larion.progate.lmis.model.LmisViewStaffMapping[] findByPmUID_PrevAndNext(
		java.lang.Integer lmisViewStaffMappingId, int pmUID,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> findByBodId(
		int bodId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> findByBodId(
		int bodId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> findByBodId(
		int bodId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewStaffMapping findByBodId_First(
		int bodId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingException;

	public larion.progate.lmis.model.LmisViewStaffMapping findByBodId_Last(
		int bodId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingException;

	public larion.progate.lmis.model.LmisViewStaffMapping[] findByBodId_PrevAndNext(
		java.lang.Integer lmisViewStaffMappingId, int bodId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> findAll(
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