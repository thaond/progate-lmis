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
 * <a href="LevelPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LevelPersistence extends BasePersistence {
	public void cacheResult(larion.progate.cds.model.Level level);

	public void cacheResult(
		java.util.List<larion.progate.cds.model.Level> levels);

	public void clearCache();

	public larion.progate.cds.model.Level create(java.lang.Integer levelId);

	public larion.progate.cds.model.Level remove(java.lang.Integer levelId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchLevelException;

	public larion.progate.cds.model.Level remove(
		larion.progate.cds.model.Level level)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.Level update(
		larion.progate.cds.model.Level level)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.Level update(
		larion.progate.cds.model.Level level, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.Level updateImpl(
		larion.progate.cds.model.Level level, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.Level findByPrimaryKey(
		java.lang.Integer levelId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchLevelException;

	public larion.progate.cds.model.Level fetchByPrimaryKey(
		java.lang.Integer levelId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.Level> findBycompetencyId(
		int competencyId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.Level> findBycompetencyId(
		int competencyId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.Level> findBycompetencyId(
		int competencyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.Level findBycompetencyId_First(
		int competencyId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchLevelException;

	public larion.progate.cds.model.Level findBycompetencyId_Last(
		int competencyId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchLevelException;

	public larion.progate.cds.model.Level[] findBycompetencyId_PrevAndNext(
		java.lang.Integer levelId, int competencyId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchLevelException;

	public java.util.List<larion.progate.cds.model.Level> findByname(
		java.lang.String name) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.Level> findByname(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.Level> findByname(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.Level findByname_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchLevelException;

	public larion.progate.cds.model.Level findByname_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchLevelException;

	public larion.progate.cds.model.Level[] findByname_PrevAndNext(
		java.lang.Integer levelId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchLevelException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.Level> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.Level> findAll(int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.Level> findAll(int start,
		int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeBycompetencyId(int competencyId)
		throws com.liferay.portal.SystemException;

	public void removeByname(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countBycompetencyId(int competencyId)
		throws com.liferay.portal.SystemException;

	public int countByname(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.Slot> getSlots(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.Slot> getSlots(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.Slot> getSlots(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getSlotsSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsSlot(java.lang.Integer pk, java.lang.Integer slotPK)
		throws com.liferay.portal.SystemException;

	public boolean containsSlots(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;
}