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
 * <a href="LmisViewStaffRootOrgOrderedUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewStaffRootOrgOrderedUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered) {
		getPersistence().cacheResult(lmisViewStaffRootOrgOrdered);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> lmisViewStaffRootOrgOrdereds) {
		getPersistence().cacheResult(lmisViewStaffRootOrgOrdereds);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrgOrdered create(
		java.lang.Integer lmisViewStaffRootOrgOrderedId) {
		return getPersistence().create(lmisViewStaffRootOrgOrderedId);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrgOrdered remove(
		java.lang.Integer lmisViewStaffRootOrgOrderedId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgOrderedException {
		return getPersistence().remove(lmisViewStaffRootOrgOrderedId);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrgOrdered remove(
		larion.progate.lmis.model.LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisViewStaffRootOrgOrdered);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrgOrdered update(
		larion.progate.lmis.model.LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewStaffRootOrgOrdered);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrgOrdered update(
		larion.progate.lmis.model.LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewStaffRootOrgOrdered, merge);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrgOrdered updateImpl(
		larion.progate.lmis.model.LmisViewStaffRootOrgOrdered lmisViewStaffRootOrgOrdered,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisViewStaffRootOrgOrdered, merge);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrgOrdered findByPrimaryKey(
		java.lang.Integer lmisViewStaffRootOrgOrderedId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgOrderedException {
		return getPersistence().findByPrimaryKey(lmisViewStaffRootOrgOrderedId);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrgOrdered fetchByPrimaryKey(
		java.lang.Integer lmisViewStaffRootOrgOrderedId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisViewStaffRootOrgOrderedId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> findByRootID(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrgOrdered findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgOrderedException {
		return getPersistence().findByRootID_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrgOrdered findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgOrderedException {
		return getPersistence().findByRootID_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrgOrdered[] findByRootID_PrevAndNext(
		java.lang.Integer lmisViewStaffRootOrgOrderedId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgOrderedException {
		return getPersistence()
				   .findByRootID_PrevAndNext(lmisViewStaffRootOrgOrderedId,
			rootId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> findByUserId(
		int userId) throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> findByUserId(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> findByUserId(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(userId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrgOrdered findByUserId_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgOrderedException {
		return getPersistence().findByUserId_First(userId, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrgOrdered findByUserId_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgOrderedException {
		return getPersistence().findByUserId_Last(userId, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrgOrdered[] findByUserId_PrevAndNext(
		java.lang.Integer lmisViewStaffRootOrgOrderedId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgOrderedException {
		return getPersistence()
				   .findByUserId_PrevAndNext(lmisViewStaffRootOrgOrderedId,
			userId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> findByOrgID(
		int orgId) throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> findByOrgID(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> findByOrgID(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrgOrdered findByOrgID_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgOrderedException {
		return getPersistence().findByOrgID_First(orgId, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrgOrdered findByOrgID_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgOrderedException {
		return getPersistence().findByOrgID_Last(orgId, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrgOrdered[] findByOrgID_PrevAndNext(
		java.lang.Integer lmisViewStaffRootOrgOrderedId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgOrderedException {
		return getPersistence()
				   .findByOrgID_PrevAndNext(lmisViewStaffRootOrgOrderedId,
			orgId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> findByFullName(
		java.lang.String fullName) throws com.liferay.portal.SystemException {
		return getPersistence().findByFullName(fullName);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> findByFullName(
		java.lang.String fullName, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByFullName(fullName, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> findByFullName(
		java.lang.String fullName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByFullName(fullName, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrgOrdered findByFullName_First(
		java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgOrderedException {
		return getPersistence().findByFullName_First(fullName, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrgOrdered findByFullName_Last(
		java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgOrderedException {
		return getPersistence().findByFullName_Last(fullName, obc);
	}

	public static larion.progate.lmis.model.LmisViewStaffRootOrgOrdered[] findByFullName_PrevAndNext(
		java.lang.Integer lmisViewStaffRootOrgOrderedId,
		java.lang.String fullName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewStaffRootOrgOrderedException {
		return getPersistence()
				   .findByFullName_PrevAndNext(lmisViewStaffRootOrgOrderedId,
			fullName, obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgOrdered> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByRootID(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRootID(rootId);
	}

	public static void removeByUserId(int userId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByUserId(userId);
	}

	public static void removeByOrgID(int orgId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByOrgID(orgId);
	}

	public static void removeByFullName(java.lang.String fullName)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByFullName(fullName);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByRootID(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRootID(rootId);
	}

	public static int countByUserId(int userId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByUserId(userId);
	}

	public static int countByOrgID(int orgId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByOrgID(orgId);
	}

	public static int countByFullName(java.lang.String fullName)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByFullName(fullName);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static LmisViewStaffRootOrgOrderedPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(
		LmisViewStaffRootOrgOrderedPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisViewStaffRootOrgOrderedPersistence _persistence;
}