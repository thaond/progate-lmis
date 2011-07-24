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

package larion.progate.cds.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * <a href="CdsPAFinalSlotsPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface CdsPAFinalSlotsPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.cds.model.CdsPAFinalSlots cdsPAFinalSlots);

	public void cacheResult(
		java.util.List<larion.progate.cds.model.CdsPAFinalSlots> cdsPAFinalSlotses);

	public void clearCache();

	public larion.progate.cds.model.CdsPAFinalSlots create(
		java.lang.Integer CdsPAFinalSlotsId);

	public larion.progate.cds.model.CdsPAFinalSlots remove(
		java.lang.Integer CdsPAFinalSlotsId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPAFinalSlotsException;

	public larion.progate.cds.model.CdsPAFinalSlots remove(
		larion.progate.cds.model.CdsPAFinalSlots cdsPAFinalSlots)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsPAFinalSlots update(
		larion.progate.cds.model.CdsPAFinalSlots cdsPAFinalSlots)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsPAFinalSlots update(
		larion.progate.cds.model.CdsPAFinalSlots cdsPAFinalSlots, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsPAFinalSlots updateImpl(
		larion.progate.cds.model.CdsPAFinalSlots cdsPAFinalSlots, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsPAFinalSlots findByPrimaryKey(
		java.lang.Integer CdsPAFinalSlotsId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPAFinalSlotsException;

	public larion.progate.cds.model.CdsPAFinalSlots fetchByPrimaryKey(
		java.lang.Integer CdsPAFinalSlotsId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsPAFinalSlots> findByRootId(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsPAFinalSlots> findByRootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsPAFinalSlots> findByRootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsPAFinalSlots findByRootId_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPAFinalSlotsException;

	public larion.progate.cds.model.CdsPAFinalSlots findByRootId_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPAFinalSlotsException;

	public larion.progate.cds.model.CdsPAFinalSlots[] findByRootId_PrevAndNext(
		java.lang.Integer CdsPAFinalSlotsId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPAFinalSlotsException;

	public java.util.List<larion.progate.cds.model.CdsPAFinalSlots> findByUserId(
		int userId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsPAFinalSlots> findByUserId(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsPAFinalSlots> findByUserId(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsPAFinalSlots findByUserId_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPAFinalSlotsException;

	public larion.progate.cds.model.CdsPAFinalSlots findByUserId_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPAFinalSlotsException;

	public larion.progate.cds.model.CdsPAFinalSlots[] findByUserId_PrevAndNext(
		java.lang.Integer CdsPAFinalSlotsId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPAFinalSlotsException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsPAFinalSlots> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsPAFinalSlots> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsPAFinalSlots> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByRootId(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeByUserId(int userId)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByRootId(int rootId)
		throws com.liferay.portal.SystemException;

	public int countByUserId(int userId)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}