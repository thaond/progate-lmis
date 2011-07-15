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
 * <a href="CdsPASlotsPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface CdsPASlotsPersistence extends BasePersistence {
	public void cacheResult(larion.progate.cds.model.CdsPASlots cdsPASlots);

	public void cacheResult(
		java.util.List<larion.progate.cds.model.CdsPASlots> cdsPASlotses);

	public void clearCache();

	public larion.progate.cds.model.CdsPASlots create(
		java.lang.Integer CdsPASlotsId);

	public larion.progate.cds.model.CdsPASlots remove(
		java.lang.Integer CdsPASlotsId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPASlotsException;

	public larion.progate.cds.model.CdsPASlots remove(
		larion.progate.cds.model.CdsPASlots cdsPASlots)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsPASlots update(
		larion.progate.cds.model.CdsPASlots cdsPASlots)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsPASlots update(
		larion.progate.cds.model.CdsPASlots cdsPASlots, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsPASlots updateImpl(
		larion.progate.cds.model.CdsPASlots cdsPASlots, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsPASlots findByPrimaryKey(
		java.lang.Integer CdsPASlotsId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPASlotsException;

	public larion.progate.cds.model.CdsPASlots fetchByPrimaryKey(
		java.lang.Integer CdsPASlotsId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsPASlots> findByPeriodId(
		int periodId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsPASlots> findByPeriodId(
		int periodId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsPASlots> findByPeriodId(
		int periodId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsPASlots findByPeriodId_First(
		int periodId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPASlotsException;

	public larion.progate.cds.model.CdsPASlots findByPeriodId_Last(
		int periodId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPASlotsException;

	public larion.progate.cds.model.CdsPASlots[] findByPeriodId_PrevAndNext(
		java.lang.Integer CdsPASlotsId, int periodId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPASlotsException;

	public java.util.List<larion.progate.cds.model.CdsPASlots> findByUserId(
		int userId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsPASlots> findByUserId(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsPASlots> findByUserId(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.CdsPASlots findByUserId_First(int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPASlotsException;

	public larion.progate.cds.model.CdsPASlots findByUserId_Last(int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPASlotsException;

	public larion.progate.cds.model.CdsPASlots[] findByUserId_PrevAndNext(
		java.lang.Integer CdsPASlotsId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchCdsPASlotsException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsPASlots> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsPASlots> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.CdsPASlots> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByPeriodId(int periodId)
		throws com.liferay.portal.SystemException;

	public void removeByUserId(int userId)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByPeriodId(int periodId)
		throws com.liferay.portal.SystemException;

	public int countByUserId(int userId)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}