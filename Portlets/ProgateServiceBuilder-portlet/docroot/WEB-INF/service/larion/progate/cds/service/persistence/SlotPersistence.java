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
 * <a href="SlotPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface SlotPersistence extends BasePersistence {
	public void cacheResult(larion.progate.cds.model.Slot slot);

	public void cacheResult(java.util.List<larion.progate.cds.model.Slot> slots);

	public void clearCache();

	public larion.progate.cds.model.Slot create(java.lang.Integer slotId);

	public larion.progate.cds.model.Slot remove(java.lang.Integer slotId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchSlotException;

	public larion.progate.cds.model.Slot remove(
		larion.progate.cds.model.Slot slot)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.Slot update(
		larion.progate.cds.model.Slot slot)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.Slot update(
		larion.progate.cds.model.Slot slot, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.Slot updateImpl(
		larion.progate.cds.model.Slot slot, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.Slot findByPrimaryKey(
		java.lang.Integer slotId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchSlotException;

	public larion.progate.cds.model.Slot fetchByPrimaryKey(
		java.lang.Integer slotId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.Slot> findBylevelId(
		int levelId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.Slot> findBylevelId(
		int levelId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.Slot> findBylevelId(
		int levelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.Slot findBylevelId_First(int levelId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchSlotException;

	public larion.progate.cds.model.Slot findBylevelId_Last(int levelId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchSlotException;

	public larion.progate.cds.model.Slot[] findBylevelId_PrevAndNext(
		java.lang.Integer slotId, int levelId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchSlotException;

	public java.util.List<larion.progate.cds.model.Slot> findByname(
		java.lang.String name) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.Slot> findByname(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.Slot> findByname(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.Slot findByname_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchSlotException;

	public larion.progate.cds.model.Slot findByname_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchSlotException;

	public larion.progate.cds.model.Slot[] findByname_PrevAndNext(
		java.lang.Integer slotId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchSlotException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.Slot> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.Slot> findAll(int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.Slot> findAll(int start,
		int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeBylevelId(int levelId)
		throws com.liferay.portal.SystemException;

	public void removeByname(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countBylevelId(int levelId)
		throws com.liferay.portal.SystemException;

	public int countByname(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}