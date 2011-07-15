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

/**
 * <a href="SlotUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class SlotUtil {
	public static void cacheResult(larion.progate.cds.model.Slot slot) {
		getPersistence().cacheResult(slot);
	}

	public static void cacheResult(
		java.util.List<larion.progate.cds.model.Slot> slots) {
		getPersistence().cacheResult(slots);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.cds.model.Slot create(java.lang.Integer slotId) {
		return getPersistence().create(slotId);
	}

	public static larion.progate.cds.model.Slot remove(java.lang.Integer slotId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchSlotException {
		return getPersistence().remove(slotId);
	}

	public static larion.progate.cds.model.Slot remove(
		larion.progate.cds.model.Slot slot)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(slot);
	}

	public static larion.progate.cds.model.Slot update(
		larion.progate.cds.model.Slot slot)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(slot);
	}

	public static larion.progate.cds.model.Slot update(
		larion.progate.cds.model.Slot slot, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(slot, merge);
	}

	public static larion.progate.cds.model.Slot updateImpl(
		larion.progate.cds.model.Slot slot, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(slot, merge);
	}

	public static larion.progate.cds.model.Slot findByPrimaryKey(
		java.lang.Integer slotId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchSlotException {
		return getPersistence().findByPrimaryKey(slotId);
	}

	public static larion.progate.cds.model.Slot fetchByPrimaryKey(
		java.lang.Integer slotId) throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(slotId);
	}

	public static java.util.List<larion.progate.cds.model.Slot> findBylevelId(
		int levelId) throws com.liferay.portal.SystemException {
		return getPersistence().findBylevelId(levelId);
	}

	public static java.util.List<larion.progate.cds.model.Slot> findBylevelId(
		int levelId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBylevelId(levelId, start, end);
	}

	public static java.util.List<larion.progate.cds.model.Slot> findBylevelId(
		int levelId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBylevelId(levelId, start, end, obc);
	}

	public static larion.progate.cds.model.Slot findBylevelId_First(
		int levelId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchSlotException {
		return getPersistence().findBylevelId_First(levelId, obc);
	}

	public static larion.progate.cds.model.Slot findBylevelId_Last(
		int levelId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchSlotException {
		return getPersistence().findBylevelId_Last(levelId, obc);
	}

	public static larion.progate.cds.model.Slot[] findBylevelId_PrevAndNext(
		java.lang.Integer slotId, int levelId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchSlotException {
		return getPersistence().findBylevelId_PrevAndNext(slotId, levelId, obc);
	}

	public static java.util.List<larion.progate.cds.model.Slot> findByname(
		java.lang.String name) throws com.liferay.portal.SystemException {
		return getPersistence().findByname(name);
	}

	public static java.util.List<larion.progate.cds.model.Slot> findByname(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByname(name, start, end);
	}

	public static java.util.List<larion.progate.cds.model.Slot> findByname(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByname(name, start, end, obc);
	}

	public static larion.progate.cds.model.Slot findByname_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchSlotException {
		return getPersistence().findByname_First(name, obc);
	}

	public static larion.progate.cds.model.Slot findByname_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchSlotException {
		return getPersistence().findByname_Last(name, obc);
	}

	public static larion.progate.cds.model.Slot[] findByname_PrevAndNext(
		java.lang.Integer slotId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchSlotException {
		return getPersistence().findByname_PrevAndNext(slotId, name, obc);
	}

	public static java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	public static java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	public static java.util.List<larion.progate.cds.model.Slot> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.cds.model.Slot> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.cds.model.Slot> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeBylevelId(int levelId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBylevelId(levelId);
	}

	public static void removeByname(java.lang.String name)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByname(name);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countBylevelId(int levelId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBylevelId(levelId);
	}

	public static int countByname(java.lang.String name)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByname(name);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static SlotPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(SlotPersistence persistence) {
		_persistence = persistence;
	}

	private static SlotPersistence _persistence;
}