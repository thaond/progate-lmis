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
 * <a href="LmisViewOTAppUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewOTAppUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisViewOTApp lmisViewOTApp) {
		getPersistence().cacheResult(lmisViewOTApp);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewOTApp> lmisViewOTApps) {
		getPersistence().cacheResult(lmisViewOTApps);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisViewOTApp create(
		java.lang.Integer lmisViewOTAppId) {
		return getPersistence().create(lmisViewOTAppId);
	}

	public static larion.progate.lmis.model.LmisViewOTApp remove(
		java.lang.Integer lmisViewOTAppId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException {
		return getPersistence().remove(lmisViewOTAppId);
	}

	public static larion.progate.lmis.model.LmisViewOTApp remove(
		larion.progate.lmis.model.LmisViewOTApp lmisViewOTApp)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisViewOTApp);
	}

	public static larion.progate.lmis.model.LmisViewOTApp update(
		larion.progate.lmis.model.LmisViewOTApp lmisViewOTApp)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewOTApp);
	}

	public static larion.progate.lmis.model.LmisViewOTApp update(
		larion.progate.lmis.model.LmisViewOTApp lmisViewOTApp, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisViewOTApp, merge);
	}

	public static larion.progate.lmis.model.LmisViewOTApp updateImpl(
		larion.progate.lmis.model.LmisViewOTApp lmisViewOTApp, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisViewOTApp, merge);
	}

	public static larion.progate.lmis.model.LmisViewOTApp findByPrimaryKey(
		java.lang.Integer lmisViewOTAppId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException {
		return getPersistence().findByPrimaryKey(lmisViewOTAppId);
	}

	public static larion.progate.lmis.model.LmisViewOTApp fetchByPrimaryKey(
		java.lang.Integer lmisViewOTAppId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisViewOTAppId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByRootID(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewOTApp findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException {
		return getPersistence().findByRootID_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewOTApp findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException {
		return getPersistence().findByRootID_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisViewOTApp[] findByRootID_PrevAndNext(
		java.lang.Integer lmisViewOTAppId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException {
		return getPersistence()
				   .findByRootID_PrevAndNext(lmisViewOTAppId, rootId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByOrgID(
		int orgId) throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByOrgID(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByOrgID(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgID(orgId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewOTApp findByOrgID_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException {
		return getPersistence().findByOrgID_First(orgId, obc);
	}

	public static larion.progate.lmis.model.LmisViewOTApp findByOrgID_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException {
		return getPersistence().findByOrgID_Last(orgId, obc);
	}

	public static larion.progate.lmis.model.LmisViewOTApp[] findByOrgID_PrevAndNext(
		java.lang.Integer lmisViewOTAppId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException {
		return getPersistence()
				   .findByOrgID_PrevAndNext(lmisViewOTAppId, orgId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByRequestedAt(
		java.util.Date requestedAt) throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestedAt(requestedAt);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByRequestedAt(
		java.util.Date requestedAt, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestedAt(requestedAt, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByRequestedAt(
		java.util.Date requestedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestedAt(requestedAt, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewOTApp findByRequestedAt_First(
		java.util.Date requestedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException {
		return getPersistence().findByRequestedAt_First(requestedAt, obc);
	}

	public static larion.progate.lmis.model.LmisViewOTApp findByRequestedAt_Last(
		java.util.Date requestedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException {
		return getPersistence().findByRequestedAt_Last(requestedAt, obc);
	}

	public static larion.progate.lmis.model.LmisViewOTApp[] findByRequestedAt_PrevAndNext(
		java.lang.Integer lmisViewOTAppId, java.util.Date requestedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException {
		return getPersistence()
				   .findByRequestedAt_PrevAndNext(lmisViewOTAppId, requestedAt,
			obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByRequestedStatus(
		int requestedStatus) throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestedStatus(requestedStatus);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByRequestedStatus(
		int requestedStatus, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByRequestedStatus(requestedStatus, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByRequestedStatus(
		int requestedStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByRequestedStatus(requestedStatus, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewOTApp findByRequestedStatus_First(
		int requestedStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException {
		return getPersistence().findByRequestedStatus_First(requestedStatus, obc);
	}

	public static larion.progate.lmis.model.LmisViewOTApp findByRequestedStatus_Last(
		int requestedStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException {
		return getPersistence().findByRequestedStatus_Last(requestedStatus, obc);
	}

	public static larion.progate.lmis.model.LmisViewOTApp[] findByRequestedStatus_PrevAndNext(
		java.lang.Integer lmisViewOTAppId, int requestedStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException {
		return getPersistence()
				   .findByRequestedStatus_PrevAndNext(lmisViewOTAppId,
			requestedStatus, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByRequestedBy(
		int requestedBy) throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestedBy(requestedBy);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByRequestedBy(
		int requestedBy, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestedBy(requestedBy, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByRequestedBy(
		int requestedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestedBy(requestedBy, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewOTApp findByRequestedBy_First(
		int requestedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException {
		return getPersistence().findByRequestedBy_First(requestedBy, obc);
	}

	public static larion.progate.lmis.model.LmisViewOTApp findByRequestedBy_Last(
		int requestedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException {
		return getPersistence().findByRequestedBy_Last(requestedBy, obc);
	}

	public static larion.progate.lmis.model.LmisViewOTApp[] findByRequestedBy_PrevAndNext(
		java.lang.Integer lmisViewOTAppId, int requestedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException {
		return getPersistence()
				   .findByRequestedBy_PrevAndNext(lmisViewOTAppId, requestedBy,
			obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByApprovedBy(
		int approvedBy) throws com.liferay.portal.SystemException {
		return getPersistence().findByApprovedBy(approvedBy);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByApprovedBy(
		int approvedBy, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByApprovedBy(approvedBy, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByApprovedBy(
		int approvedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByApprovedBy(approvedBy, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisViewOTApp findByApprovedBy_First(
		int approvedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException {
		return getPersistence().findByApprovedBy_First(approvedBy, obc);
	}

	public static larion.progate.lmis.model.LmisViewOTApp findByApprovedBy_Last(
		int approvedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException {
		return getPersistence().findByApprovedBy_Last(approvedBy, obc);
	}

	public static larion.progate.lmis.model.LmisViewOTApp[] findByApprovedBy_PrevAndNext(
		java.lang.Integer lmisViewOTAppId, int approvedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException {
		return getPersistence()
				   .findByApprovedBy_PrevAndNext(lmisViewOTAppId, approvedBy,
			obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisViewOTApp> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOTApp> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisViewOTApp> findAll(
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

	public static void removeByRequestedAt(java.util.Date requestedAt)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRequestedAt(requestedAt);
	}

	public static void removeByRequestedStatus(int requestedStatus)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRequestedStatus(requestedStatus);
	}

	public static void removeByRequestedBy(int requestedBy)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRequestedBy(requestedBy);
	}

	public static void removeByApprovedBy(int approvedBy)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByApprovedBy(approvedBy);
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

	public static int countByRequestedAt(java.util.Date requestedAt)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRequestedAt(requestedAt);
	}

	public static int countByRequestedStatus(int requestedStatus)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRequestedStatus(requestedStatus);
	}

	public static int countByRequestedBy(int requestedBy)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRequestedBy(requestedBy);
	}

	public static int countByApprovedBy(int approvedBy)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByApprovedBy(approvedBy);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static LmisViewOTAppPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisViewOTAppPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisViewOTAppPersistence _persistence;
}