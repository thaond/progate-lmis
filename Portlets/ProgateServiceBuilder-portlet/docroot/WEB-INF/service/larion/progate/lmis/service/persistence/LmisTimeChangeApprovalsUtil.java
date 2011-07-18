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
 * <a href="LmisTimeChangeApprovalsUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisTimeChangeApprovalsUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisTimeChangeApprovals lmisTimeChangeApprovals) {
		getPersistence().cacheResult(lmisTimeChangeApprovals);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisTimeChangeApprovals> lmisTimeChangeApprovalses) {
		getPersistence().cacheResult(lmisTimeChangeApprovalses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisTimeChangeApprovals create(
		java.lang.Integer lmisTimeChangeApprovalId) {
		return getPersistence().create(lmisTimeChangeApprovalId);
	}

	public static larion.progate.lmis.model.LmisTimeChangeApprovals remove(
		java.lang.Integer lmisTimeChangeApprovalId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisTimeChangeApprovalsException {
		return getPersistence().remove(lmisTimeChangeApprovalId);
	}

	public static larion.progate.lmis.model.LmisTimeChangeApprovals remove(
		larion.progate.lmis.model.LmisTimeChangeApprovals lmisTimeChangeApprovals)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisTimeChangeApprovals);
	}

	public static larion.progate.lmis.model.LmisTimeChangeApprovals update(
		larion.progate.lmis.model.LmisTimeChangeApprovals lmisTimeChangeApprovals)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisTimeChangeApprovals);
	}

	public static larion.progate.lmis.model.LmisTimeChangeApprovals update(
		larion.progate.lmis.model.LmisTimeChangeApprovals lmisTimeChangeApprovals,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisTimeChangeApprovals, merge);
	}

	public static larion.progate.lmis.model.LmisTimeChangeApprovals updateImpl(
		larion.progate.lmis.model.LmisTimeChangeApprovals lmisTimeChangeApprovals,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisTimeChangeApprovals, merge);
	}

	public static larion.progate.lmis.model.LmisTimeChangeApprovals findByPrimaryKey(
		java.lang.Integer lmisTimeChangeApprovalId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisTimeChangeApprovalsException {
		return getPersistence().findByPrimaryKey(lmisTimeChangeApprovalId);
	}

	public static larion.progate.lmis.model.LmisTimeChangeApprovals fetchByPrimaryKey(
		java.lang.Integer lmisTimeChangeApprovalId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisTimeChangeApprovalId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisTimeChangeApprovals> findByRequestId(
		int requestId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestId(requestId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisTimeChangeApprovals> findByRequestId(
		int requestId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestId(requestId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisTimeChangeApprovals> findByRequestId(
		int requestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestId(requestId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisTimeChangeApprovals findByRequestId_First(
		int requestId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisTimeChangeApprovalsException {
		return getPersistence().findByRequestId_First(requestId, obc);
	}

	public static larion.progate.lmis.model.LmisTimeChangeApprovals findByRequestId_Last(
		int requestId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisTimeChangeApprovalsException {
		return getPersistence().findByRequestId_Last(requestId, obc);
	}

	public static larion.progate.lmis.model.LmisTimeChangeApprovals[] findByRequestId_PrevAndNext(
		java.lang.Integer lmisTimeChangeApprovalId, int requestId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisTimeChangeApprovalsException {
		return getPersistence()
				   .findByRequestId_PrevAndNext(lmisTimeChangeApprovalId,
			requestId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisTimeChangeApprovals> findByRootId(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisTimeChangeApprovals> findByRootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisTimeChangeApprovals> findByRootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisTimeChangeApprovals findByRootId_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisTimeChangeApprovalsException {
		return getPersistence().findByRootId_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisTimeChangeApprovals findByRootId_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisTimeChangeApprovalsException {
		return getPersistence().findByRootId_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisTimeChangeApprovals[] findByRootId_PrevAndNext(
		java.lang.Integer lmisTimeChangeApprovalId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisTimeChangeApprovalsException {
		return getPersistence()
				   .findByRootId_PrevAndNext(lmisTimeChangeApprovalId, rootId,
			obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisTimeChangeApprovals> findByApprovedBy(
		int approvedBy) throws com.liferay.portal.SystemException {
		return getPersistence().findByApprovedBy(approvedBy);
	}

	public static java.util.List<larion.progate.lmis.model.LmisTimeChangeApprovals> findByApprovedBy(
		int approvedBy, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByApprovedBy(approvedBy, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisTimeChangeApprovals> findByApprovedBy(
		int approvedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByApprovedBy(approvedBy, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisTimeChangeApprovals findByApprovedBy_First(
		int approvedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisTimeChangeApprovalsException {
		return getPersistence().findByApprovedBy_First(approvedBy, obc);
	}

	public static larion.progate.lmis.model.LmisTimeChangeApprovals findByApprovedBy_Last(
		int approvedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisTimeChangeApprovalsException {
		return getPersistence().findByApprovedBy_Last(approvedBy, obc);
	}

	public static larion.progate.lmis.model.LmisTimeChangeApprovals[] findByApprovedBy_PrevAndNext(
		java.lang.Integer lmisTimeChangeApprovalId, int approvedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisTimeChangeApprovalsException {
		return getPersistence()
				   .findByApprovedBy_PrevAndNext(lmisTimeChangeApprovalId,
			approvedBy, obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisTimeChangeApprovals> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisTimeChangeApprovals> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisTimeChangeApprovals> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByRequestId(int requestId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRequestId(requestId);
	}

	public static void removeByRootId(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRootId(rootId);
	}

	public static void removeByApprovedBy(int approvedBy)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByApprovedBy(approvedBy);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByRequestId(int requestId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRequestId(requestId);
	}

	public static int countByRootId(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRootId(rootId);
	}

	public static int countByApprovedBy(int approvedBy)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByApprovedBy(approvedBy);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static LmisTimeChangeApprovalsPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisTimeChangeApprovalsPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisTimeChangeApprovalsPersistence _persistence;
}