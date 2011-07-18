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

/**
 * <a href="LmisViewStaffMappingUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewStaffMappingUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisViewStaffMapping lmisViewStaffMapping) {
		getPersistence().cacheResult(lmisViewStaffMapping);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> lmisViewStaffMappings) {
		getPersistence().cacheResult(lmisViewStaffMappings);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisViewStaffMapping create(
		java.lang.Integer lmisViewStaffMappingId) {
		return getPersistence().create(lmisViewStaffMappingId);
	}

	public static larion.progate.lmis.model.LmisViewStaffMapping remove(
		java.lang.Integer lmisViewStaffMappingId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingException {
		return getPersistence().remove(lmisViewStaffMappingId);
	}

	public static larion.progate.lmis.model.LmisViewStaffMapping remove(
		larion.progate.lmis.model.LmisViewStaffMapping lmisViewStaffMapping)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisViewStaffMapping);
	}

	public static larion.progate.lmis.model.LmisViewStaffMapping update(
		larion.progate.lmis.model.LmisViewStaffMapping lmisViewStaffMapping)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewStaffMapping);
	}

	public static larion.progate.lmis.model.LmisViewStaffMapping update(
		larion.progate.lmis.model.LmisViewStaffMapping lmisViewStaffMapping,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewStaffMapping, merge);
	}

	public static larion.progate.lmis.model.LmisViewStaffMapping updateImpl(
		larion.progate.lmis.model.LmisViewStaffMapping lmisViewStaffMapping,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisViewStaffMapping, merge);
	}

	public static larion.progate.lmis.model.LmisViewStaffMapping findByPrimaryKey(
		java.lang.Integer lmisViewStaffMappingId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingException {
		return getPersistence().findByPrimaryKey(lmisViewStaffMappingId);
	}

	public static larion.progate.lmis.model.LmisViewStaffMapping fetchByPrimaryKey(
		java.lang.Integer lmisViewStaffMappingId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisViewStaffMappingId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> findByStaffUID(
		int staffUID) throws com.liferay.portal.SystemException {
		return getPersistence().findByStaffUID(staffUID);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> findByStaffUID(
		int staffUID, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByStaffUID(staffUID, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> findByStaffUID(
		int staffUID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByStaffUID(staffUID, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffMapping findByStaffUID_First(
		int staffUID, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingException {
		return getPersistence().findByStaffUID_First(staffUID, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffMapping findByStaffUID_Last(
		int staffUID, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingException {
		return getPersistence().findByStaffUID_Last(staffUID, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffMapping[] findByStaffUID_PrevAndNext(
		java.lang.Integer lmisViewStaffMappingId, int staffUID,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingException {
		return getPersistence()
				   .findByStaffUID_PrevAndNext(lmisViewStaffMappingId,
			staffUID, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> findByRootID(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffMapping findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingException {
		return getPersistence().findByRootID_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffMapping findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingException {
		return getPersistence().findByRootID_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffMapping[] findByRootID_PrevAndNext(
		java.lang.Integer lmisViewStaffMappingId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingException {
		return getPersistence()
				   .findByRootID_PrevAndNext(lmisViewStaffMappingId, rootId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> findByPmUID(
		int pmUID) throws com.liferay.portal.SystemException {
		return getPersistence().findByPmUID(pmUID);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> findByPmUID(
		int pmUID, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByPmUID(pmUID, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> findByPmUID(
		int pmUID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByPmUID(pmUID, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffMapping findByPmUID_First(
		int pmUID, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingException {
		return getPersistence().findByPmUID_First(pmUID, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffMapping findByPmUID_Last(
		int pmUID, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingException {
		return getPersistence().findByPmUID_Last(pmUID, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffMapping[] findByPmUID_PrevAndNext(
		java.lang.Integer lmisViewStaffMappingId, int pmUID,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingException {
		return getPersistence()
				   .findByPmUID_PrevAndNext(lmisViewStaffMappingId, pmUID, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> findByBodId(
		int bodId) throws com.liferay.portal.SystemException {
		return getPersistence().findByBodId(bodId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> findByBodId(
		int bodId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByBodId(bodId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> findByBodId(
		int bodId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByBodId(bodId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffMapping findByBodId_First(
		int bodId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingException {
		return getPersistence().findByBodId_First(bodId, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffMapping findByBodId_Last(
		int bodId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingException {
		return getPersistence().findByBodId_Last(bodId, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffMapping[] findByBodId_PrevAndNext(
		java.lang.Integer lmisViewStaffMappingId, int bodId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingException {
		return getPersistence()
				   .findByBodId_PrevAndNext(lmisViewStaffMappingId, bodId, obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByStaffUID(int staffUID)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByStaffUID(staffUID);
	}

	public static void removeByRootID(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRootID(rootId);
	}

	public static void removeByPmUID(int pmUID)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByPmUID(pmUID);
	}

	public static void removeByBodId(int bodId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByBodId(bodId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByStaffUID(int staffUID)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByStaffUID(staffUID);
	}

	public static int countByRootID(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRootID(rootId);
	}

	public static int countByPmUID(int pmUID)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByPmUID(pmUID);
	}

	public static int countByBodId(int bodId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByBodId(bodId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static LmisViewStaffMappingPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisViewStaffMappingPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisViewStaffMappingPersistence _persistence;
}