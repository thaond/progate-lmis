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
 * <a href="LmisViewStaffMappingPmUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewStaffMappingPmUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisViewStaffMappingPm lmisViewStaffMappingPm) {
		getPersistence().cacheResult(lmisViewStaffMappingPm);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> lmisViewStaffMappingPms) {
		getPersistence().cacheResult(lmisViewStaffMappingPms);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisViewStaffMappingPm create(
		java.lang.Integer lmisViewStaffMappingPmId) {
		return getPersistence().create(lmisViewStaffMappingPmId);
	}

	public static larion.progate.lmis.model.LmisViewStaffMappingPm remove(
		java.lang.Integer lmisViewStaffMappingPmId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingPmException {
		return getPersistence().remove(lmisViewStaffMappingPmId);
	}

	public static larion.progate.lmis.model.LmisViewStaffMappingPm remove(
		larion.progate.lmis.model.LmisViewStaffMappingPm lmisViewStaffMappingPm)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisViewStaffMappingPm);
	}

	public static larion.progate.lmis.model.LmisViewStaffMappingPm update(
		larion.progate.lmis.model.LmisViewStaffMappingPm lmisViewStaffMappingPm)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewStaffMappingPm);
	}

	public static larion.progate.lmis.model.LmisViewStaffMappingPm update(
		larion.progate.lmis.model.LmisViewStaffMappingPm lmisViewStaffMappingPm,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewStaffMappingPm, merge);
	}

	public static larion.progate.lmis.model.LmisViewStaffMappingPm updateImpl(
		larion.progate.lmis.model.LmisViewStaffMappingPm lmisViewStaffMappingPm,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisViewStaffMappingPm, merge);
	}

	public static larion.progate.lmis.model.LmisViewStaffMappingPm findByPrimaryKey(
		java.lang.Integer lmisViewStaffMappingPmId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingPmException {
		return getPersistence().findByPrimaryKey(lmisViewStaffMappingPmId);
	}

	public static larion.progate.lmis.model.LmisViewStaffMappingPm fetchByPrimaryKey(
		java.lang.Integer lmisViewStaffMappingPmId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisViewStaffMappingPmId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> findByStaffUID(
		int staffUID) throws com.liferay.portal.SystemException {
		return getPersistence().findByStaffUID(staffUID);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> findByStaffUID(
		int staffUID, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByStaffUID(staffUID, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> findByStaffUID(
		int staffUID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByStaffUID(staffUID, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffMappingPm findByStaffUID_First(
		int staffUID, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingPmException {
		return getPersistence().findByStaffUID_First(staffUID, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffMappingPm findByStaffUID_Last(
		int staffUID, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingPmException {
		return getPersistence().findByStaffUID_Last(staffUID, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffMappingPm[] findByStaffUID_PrevAndNext(
		java.lang.Integer lmisViewStaffMappingPmId, int staffUID,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingPmException {
		return getPersistence()
				   .findByStaffUID_PrevAndNext(lmisViewStaffMappingPmId,
			staffUID, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> findByRootID(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffMappingPm findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingPmException {
		return getPersistence().findByRootID_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffMappingPm findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingPmException {
		return getPersistence().findByRootID_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffMappingPm[] findByRootID_PrevAndNext(
		java.lang.Integer lmisViewStaffMappingPmId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingPmException {
		return getPersistence()
				   .findByRootID_PrevAndNext(lmisViewStaffMappingPmId, rootId,
			obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> findByPmUID(
		int pmUID) throws com.liferay.portal.SystemException {
		return getPersistence().findByPmUID(pmUID);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> findByPmUID(
		int pmUID, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByPmUID(pmUID, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> findByPmUID(
		int pmUID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByPmUID(pmUID, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffMappingPm findByPmUID_First(
		int pmUID, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingPmException {
		return getPersistence().findByPmUID_First(pmUID, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffMappingPm findByPmUID_Last(
		int pmUID, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingPmException {
		return getPersistence().findByPmUID_Last(pmUID, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffMappingPm[] findByPmUID_PrevAndNext(
		java.lang.Integer lmisViewStaffMappingPmId, int pmUID,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingPmException {
		return getPersistence()
				   .findByPmUID_PrevAndNext(lmisViewStaffMappingPmId, pmUID, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> findByBodId(
		int bodId) throws com.liferay.portal.SystemException {
		return getPersistence().findByBodId(bodId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> findByBodId(
		int bodId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByBodId(bodId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> findByBodId(
		int bodId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByBodId(bodId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffMappingPm findByBodId_First(
		int bodId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingPmException {
		return getPersistence().findByBodId_First(bodId, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffMappingPm findByBodId_Last(
		int bodId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingPmException {
		return getPersistence().findByBodId_Last(bodId, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffMappingPm[] findByBodId_PrevAndNext(
		java.lang.Integer lmisViewStaffMappingPmId, int bodId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffMappingPmException {
		return getPersistence()
				   .findByBodId_PrevAndNext(lmisViewStaffMappingPmId, bodId, obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffMappingPm> findAll(
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

	public static LmisViewStaffMappingPmPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisViewStaffMappingPmPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisViewStaffMappingPmPersistence _persistence;
}