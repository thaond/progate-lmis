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

package larion.progate.service.persistence;

/**
 * <a href="OrgObjectApprovalUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectApprovalUtil {
	public static void cacheResult(
		larion.progate.model.OrgObjectApproval orgObjectApproval) {
		getPersistence().cacheResult(orgObjectApproval);
	}

	public static void cacheResult(
		java.util.List<larion.progate.model.OrgObjectApproval> orgObjectApprovals) {
		getPersistence().cacheResult(orgObjectApprovals);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.model.OrgObjectApproval create(
		java.lang.Integer orgObjectApprovalId) {
		return getPersistence().create(orgObjectApprovalId);
	}

	public static larion.progate.model.OrgObjectApproval remove(
		java.lang.Integer orgObjectApprovalId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectApprovalException {
		return getPersistence().remove(orgObjectApprovalId);
	}

	public static larion.progate.model.OrgObjectApproval remove(
		larion.progate.model.OrgObjectApproval orgObjectApproval)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(orgObjectApproval);
	}

	public static larion.progate.model.OrgObjectApproval update(
		larion.progate.model.OrgObjectApproval orgObjectApproval)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(orgObjectApproval);
	}

	public static larion.progate.model.OrgObjectApproval update(
		larion.progate.model.OrgObjectApproval orgObjectApproval, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(orgObjectApproval, merge);
	}

	public static larion.progate.model.OrgObjectApproval updateImpl(
		larion.progate.model.OrgObjectApproval orgObjectApproval, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(orgObjectApproval, merge);
	}

	public static larion.progate.model.OrgObjectApproval findByPrimaryKey(
		java.lang.Integer orgObjectApprovalId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectApprovalException {
		return getPersistence().findByPrimaryKey(orgObjectApprovalId);
	}

	public static larion.progate.model.OrgObjectApproval fetchByPrimaryKey(
		java.lang.Integer orgObjectApprovalId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(orgObjectApprovalId);
	}

	public static java.util.List<larion.progate.model.OrgObjectApproval> findByOrgObjApprovalUserId(
		int approved_by) throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgObjApprovalUserId(approved_by);
	}

	public static java.util.List<larion.progate.model.OrgObjectApproval> findByOrgObjApprovalUserId(
		int approved_by, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByOrgObjApprovalUserId(approved_by, start, end);
	}

	public static java.util.List<larion.progate.model.OrgObjectApproval> findByOrgObjApprovalUserId(
		int approved_by, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByOrgObjApprovalUserId(approved_by, start, end, obc);
	}

	public static larion.progate.model.OrgObjectApproval findByOrgObjApprovalUserId_First(
		int approved_by, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectApprovalException {
		return getPersistence()
				   .findByOrgObjApprovalUserId_First(approved_by, obc);
	}

	public static larion.progate.model.OrgObjectApproval findByOrgObjApprovalUserId_Last(
		int approved_by, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectApprovalException {
		return getPersistence().findByOrgObjApprovalUserId_Last(approved_by, obc);
	}

	public static larion.progate.model.OrgObjectApproval[] findByOrgObjApprovalUserId_PrevAndNext(
		java.lang.Integer orgObjectApprovalId, int approved_by,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectApprovalException {
		return getPersistence()
				   .findByOrgObjApprovalUserId_PrevAndNext(orgObjectApprovalId,
			approved_by, obc);
	}

	public static java.util.List<larion.progate.model.OrgObjectApproval> findByOrgObjApprovalStatus(
		int status) throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgObjApprovalStatus(status);
	}

	public static java.util.List<larion.progate.model.OrgObjectApproval> findByOrgObjApprovalStatus(
		int status, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgObjApprovalStatus(status, start, end);
	}

	public static java.util.List<larion.progate.model.OrgObjectApproval> findByOrgObjApprovalStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByOrgObjApprovalStatus(status, start, end, obc);
	}

	public static larion.progate.model.OrgObjectApproval findByOrgObjApprovalStatus_First(
		int status, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectApprovalException {
		return getPersistence().findByOrgObjApprovalStatus_First(status, obc);
	}

	public static larion.progate.model.OrgObjectApproval findByOrgObjApprovalStatus_Last(
		int status, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectApprovalException {
		return getPersistence().findByOrgObjApprovalStatus_Last(status, obc);
	}

	public static larion.progate.model.OrgObjectApproval[] findByOrgObjApprovalStatus_PrevAndNext(
		java.lang.Integer orgObjectApprovalId, int status,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectApprovalException {
		return getPersistence()
				   .findByOrgObjApprovalStatus_PrevAndNext(orgObjectApprovalId,
			status, obc);
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

	public static java.util.List<larion.progate.model.OrgObjectApproval> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.model.OrgObjectApproval> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.model.OrgObjectApproval> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByOrgObjApprovalUserId(int approved_by)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByOrgObjApprovalUserId(approved_by);
	}

	public static void removeByOrgObjApprovalStatus(int status)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByOrgObjApprovalStatus(status);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByOrgObjApprovalUserId(int approved_by)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByOrgObjApprovalUserId(approved_by);
	}

	public static int countByOrgObjApprovalStatus(int status)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByOrgObjApprovalStatus(status);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static OrgObjectApprovalPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(OrgObjectApprovalPersistence persistence) {
		_persistence = persistence;
	}

	private static OrgObjectApprovalPersistence _persistence;
}