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
 * <a href="LevelUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LevelUtil {
	public static void cacheResult(larion.progate.cds.model.Level level) {
		getPersistence().cacheResult(level);
	}

	public static void cacheResult(
		java.util.List<larion.progate.cds.model.Level> levels) {
		getPersistence().cacheResult(levels);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.cds.model.Level create(
		java.lang.Integer levelId) {
		return getPersistence().create(levelId);
	}

	public static larion.progate.cds.model.Level remove(
		java.lang.Integer levelId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchLevelException {
		return getPersistence().remove(levelId);
	}

	public static larion.progate.cds.model.Level remove(
		larion.progate.cds.model.Level level)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(level);
	}

	public static larion.progate.cds.model.Level update(
		larion.progate.cds.model.Level level)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(level);
	}

	public static larion.progate.cds.model.Level update(
		larion.progate.cds.model.Level level, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(level, merge);
	}

	public static larion.progate.cds.model.Level updateImpl(
		larion.progate.cds.model.Level level, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(level, merge);
	}

	public static larion.progate.cds.model.Level findByPrimaryKey(
		java.lang.Integer levelId)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchLevelException {
		return getPersistence().findByPrimaryKey(levelId);
	}

	public static larion.progate.cds.model.Level fetchByPrimaryKey(
		java.lang.Integer levelId) throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(levelId);
	}

	public static java.util.List<larion.progate.cds.model.Level> findBycompetencyId(
		int competencyId) throws com.liferay.portal.SystemException {
		return getPersistence().findBycompetencyId(competencyId);
	}

	public static java.util.List<larion.progate.cds.model.Level> findBycompetencyId(
		int competencyId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycompetencyId(competencyId, start, end);
	}

	public static java.util.List<larion.progate.cds.model.Level> findBycompetencyId(
		int competencyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycompetencyId(competencyId, start, end, obc);
	}

	public static larion.progate.cds.model.Level findBycompetencyId_First(
		int competencyId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchLevelException {
		return getPersistence().findBycompetencyId_First(competencyId, obc);
	}

	public static larion.progate.cds.model.Level findBycompetencyId_Last(
		int competencyId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchLevelException {
		return getPersistence().findBycompetencyId_Last(competencyId, obc);
	}

	public static larion.progate.cds.model.Level[] findBycompetencyId_PrevAndNext(
		java.lang.Integer levelId, int competencyId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchLevelException {
		return getPersistence()
				   .findBycompetencyId_PrevAndNext(levelId, competencyId, obc);
	}

	public static java.util.List<larion.progate.cds.model.Level> findByname(
		java.lang.String name) throws com.liferay.portal.SystemException {
		return getPersistence().findByname(name);
	}

	public static java.util.List<larion.progate.cds.model.Level> findByname(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByname(name, start, end);
	}

	public static java.util.List<larion.progate.cds.model.Level> findByname(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByname(name, start, end, obc);
	}

	public static larion.progate.cds.model.Level findByname_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchLevelException {
		return getPersistence().findByname_First(name, obc);
	}

	public static larion.progate.cds.model.Level findByname_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchLevelException {
		return getPersistence().findByname_Last(name, obc);
	}

	public static larion.progate.cds.model.Level[] findByname_PrevAndNext(
		java.lang.Integer levelId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchLevelException {
		return getPersistence().findByname_PrevAndNext(levelId, name, obc);
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

	public static java.util.List<larion.progate.cds.model.Level> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.cds.model.Level> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.cds.model.Level> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeBycompetencyId(int competencyId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBycompetencyId(competencyId);
	}

	public static void removeByname(java.lang.String name)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByname(name);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countBycompetencyId(int competencyId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBycompetencyId(competencyId);
	}

	public static int countByname(java.lang.String name)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByname(name);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static java.util.List<larion.progate.cds.model.Slot> getSlots(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getSlots(pk);
	}

	public static java.util.List<larion.progate.cds.model.Slot> getSlots(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getSlots(pk, start, end);
	}

	public static java.util.List<larion.progate.cds.model.Slot> getSlots(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().getSlots(pk, start, end, obc);
	}

	public static int getSlotsSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().getSlotsSize(pk);
	}

	public static boolean containsSlot(java.lang.Integer pk,
		java.lang.Integer slotPK) throws com.liferay.portal.SystemException {
		return getPersistence().containsSlot(pk, slotPK);
	}

	public static boolean containsSlots(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().containsSlots(pk);
	}

	public static LevelPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LevelPersistence persistence) {
		_persistence = persistence;
	}

	private static LevelPersistence _persistence;
}