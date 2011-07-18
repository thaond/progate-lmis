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
 * <a href="LmisViewStaffRootOrgUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewStaffRootOrgUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisViewStaffRootOrg lmisViewStaffRootOrg) {
		getPersistence().cacheResult(lmisViewStaffRootOrg);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrg> lmisViewStaffRootOrgs) {
		getPersistence().cacheResult(lmisViewStaffRootOrgs);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrg create(
		java.lang.Integer User_id) {
		return getPersistence().create(User_id);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrg remove(
		java.lang.Integer User_id)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgException {
		return getPersistence().remove(User_id);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrg remove(
		larion.progate.lmis.model.LmisViewStaffRootOrg lmisViewStaffRootOrg)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisViewStaffRootOrg);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrg update(
		larion.progate.lmis.model.LmisViewStaffRootOrg lmisViewStaffRootOrg)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewStaffRootOrg);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrg update(
		larion.progate.lmis.model.LmisViewStaffRootOrg lmisViewStaffRootOrg,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewStaffRootOrg, merge);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrg updateImpl(
		larion.progate.lmis.model.LmisViewStaffRootOrg lmisViewStaffRootOrg,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisViewStaffRootOrg, merge);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrg findByPrimaryKey(
		java.lang.Integer User_id)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgException {
		return getPersistence().findByPrimaryKey(User_id);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrg fetchByPrimaryKey(
		java.lang.Integer User_id) throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(User_id);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrg> findByRootID(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrg> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrg> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrg findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgException {
		return getPersistence().findByRootID_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrg findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgException {
		return getPersistence().findByRootID_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrg[] findByRootID_PrevAndNext(
		java.lang.Integer User_id, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgException {
		return getPersistence().findByRootID_PrevAndNext(User_id, rootId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrg> findByOrgID(
		int orgId) throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrg> findByOrgID(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrg> findByOrgID(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrg findByOrgID_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgException {
		return getPersistence().findByOrgID_First(orgId, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrg findByOrgID_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgException {
		return getPersistence().findByOrgID_Last(orgId, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrg[] findByOrgID_PrevAndNext(
		java.lang.Integer User_id, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgException {
		return getPersistence().findByOrgID_PrevAndNext(User_id, orgId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrg> findByBodID(
		int bodId) throws com.liferay.portal.SystemException {
		return getPersistence().findByBodID(bodId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrg> findByBodID(
		int bodId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByBodID(bodId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrg> findByBodID(
		int bodId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByBodID(bodId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrg findByBodID_First(
		int bodId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgException {
		return getPersistence().findByBodID_First(bodId, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrg findByBodID_Last(
		int bodId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgException {
		return getPersistence().findByBodID_Last(bodId, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrg[] findByBodID_PrevAndNext(
		java.lang.Integer User_id, int bodId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgException {
		return getPersistence().findByBodID_PrevAndNext(User_id, bodId, obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrg> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrg> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrg> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByRootID(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRootID(rootId);
	}

	public static void removeByOrgID(int orgId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByOrgID(orgId);
	}

	public static void removeByBodID(int bodId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByBodID(bodId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByRootID(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRootID(rootId);
	}

	public static int countByOrgID(int orgId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByOrgID(orgId);
	}

	public static int countByBodID(int bodId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByBodID(bodId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static LmisViewStaffRootOrgPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisViewStaffRootOrgPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisViewStaffRootOrgPersistence _persistence;
}