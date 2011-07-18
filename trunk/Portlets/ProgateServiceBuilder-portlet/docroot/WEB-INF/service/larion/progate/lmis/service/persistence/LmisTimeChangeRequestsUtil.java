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
 * <a href="LmisTimeChangeRequestsUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisTimeChangeRequestsUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisTimeChangeRequests lmisTimeChangeRequests) {
		getPersistence().cacheResult(lmisTimeChangeRequests);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisTimeChangeRequests> lmisTimeChangeRequestses) {
		getPersistence().cacheResult(lmisTimeChangeRequestses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisTimeChangeRequests create(
		java.lang.Integer lmisTimeChangeRequestId) {
		return getPersistence().create(lmisTimeChangeRequestId);
	}

	public static larion.progate.lmis.model.LmisTimeChangeRequests remove(
		java.lang.Integer lmisTimeChangeRequestId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisTimeChangeRequestsException {
		return getPersistence().remove(lmisTimeChangeRequestId);
	}

	public static larion.progate.lmis.model.LmisTimeChangeRequests remove(
		larion.progate.lmis.model.LmisTimeChangeRequests lmisTimeChangeRequests)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisTimeChangeRequests);
	}

	public static larion.progate.lmis.model.LmisTimeChangeRequests update(
		larion.progate.lmis.model.LmisTimeChangeRequests lmisTimeChangeRequests)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisTimeChangeRequests);
	}

	public static larion.progate.lmis.model.LmisTimeChangeRequests update(
		larion.progate.lmis.model.LmisTimeChangeRequests lmisTimeChangeRequests,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisTimeChangeRequests, merge);
	}

	public static larion.progate.lmis.model.LmisTimeChangeRequests updateImpl(
		larion.progate.lmis.model.LmisTimeChangeRequests lmisTimeChangeRequests,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisTimeChangeRequests, merge);
	}

	public static larion.progate.lmis.model.LmisTimeChangeRequests findByPrimaryKey(
		java.lang.Integer lmisTimeChangeRequestId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisTimeChangeRequestsException {
		return getPersistence().findByPrimaryKey(lmisTimeChangeRequestId);
	}

	public static larion.progate.lmis.model.LmisTimeChangeRequests fetchByPrimaryKey(
		java.lang.Integer lmisTimeChangeRequestId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisTimeChangeRequestId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisTimeChangeRequests> findByRootId(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisTimeChangeRequests> findByRootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisTimeChangeRequests> findByRootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisTimeChangeRequests findByRootId_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisTimeChangeRequestsException {
		return getPersistence().findByRootId_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisTimeChangeRequests findByRootId_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisTimeChangeRequestsException {
		return getPersistence().findByRootId_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisTimeChangeRequests[] findByRootId_PrevAndNext(
		java.lang.Integer lmisTimeChangeRequestId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisTimeChangeRequestsException {
		return getPersistence()
				   .findByRootId_PrevAndNext(lmisTimeChangeRequestId, rootId,
			obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisTimeChangeRequests> findByUserId(
		int requestedBy) throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(requestedBy);
	}

	public static java.util.List<larion.progate.lmis.model.LmisTimeChangeRequests> findByUserId(
		int requestedBy, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(requestedBy, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisTimeChangeRequests> findByUserId(
		int requestedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserId(requestedBy, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisTimeChangeRequests findByUserId_First(
		int requestedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisTimeChangeRequestsException {
		return getPersistence().findByUserId_First(requestedBy, obc);
	}

	public static larion.progate.lmis.model.LmisTimeChangeRequests findByUserId_Last(
		int requestedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisTimeChangeRequestsException {
		return getPersistence().findByUserId_Last(requestedBy, obc);
	}

	public static larion.progate.lmis.model.LmisTimeChangeRequests[] findByUserId_PrevAndNext(
		java.lang.Integer lmisTimeChangeRequestId, int requestedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisTimeChangeRequestsException {
		return getPersistence()
				   .findByUserId_PrevAndNext(lmisTimeChangeRequestId,
			requestedBy, obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisTimeChangeRequests> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisTimeChangeRequests> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisTimeChangeRequests> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByRootId(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRootId(rootId);
	}

	public static void removeByUserId(int requestedBy)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByUserId(requestedBy);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByRootId(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRootId(rootId);
	}

	public static int countByUserId(int requestedBy)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByUserId(requestedBy);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisTimeChangeApprovals> getLmisTimeChangeApprovalses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getLmisTimeChangeApprovalses(pk);
	}

	public static java.util.List<larion.progate.lmis.model.LmisTimeChangeApprovals> getLmisTimeChangeApprovalses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisTimeChangeApprovalses(pk, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisTimeChangeApprovals> getLmisTimeChangeApprovalses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisTimeChangeApprovalses(pk, start, end, obc);
	}

	public static int getLmisTimeChangeApprovalsesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().getLmisTimeChangeApprovalsesSize(pk);
	}

	public static boolean containsLmisTimeChangeApprovals(
		java.lang.Integer pk, java.lang.Integer lmisTimeChangeApprovalsPK)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .containsLmisTimeChangeApprovals(pk,
			lmisTimeChangeApprovalsPK);
	}

	public static boolean containsLmisTimeChangeApprovalses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().containsLmisTimeChangeApprovalses(pk);
	}

	public static LmisTimeChangeRequestsPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisTimeChangeRequestsPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisTimeChangeRequestsPersistence _persistence;
}