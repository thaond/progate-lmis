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
 * <a href="LmisAbsenceApprovalsUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAbsenceApprovalsUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisAbsenceApprovals lmisAbsenceApprovals) {
		getPersistence().cacheResult(lmisAbsenceApprovals);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisAbsenceApprovals> lmisAbsenceApprovalses) {
		getPersistence().cacheResult(lmisAbsenceApprovalses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisAbsenceApprovals create(
		java.lang.Integer lmisAbsenceApprovalsId) {
		return getPersistence().create(lmisAbsenceApprovalsId);
	}

	public static larion.progate.lmis.model.LmisAbsenceApprovals remove(
		java.lang.Integer lmisAbsenceApprovalsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceApprovalsException {
		return getPersistence().remove(lmisAbsenceApprovalsId);
	}

	public static larion.progate.lmis.model.LmisAbsenceApprovals remove(
		larion.progate.lmis.model.LmisAbsenceApprovals lmisAbsenceApprovals)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisAbsenceApprovals);
	}

	public static larion.progate.lmis.model.LmisAbsenceApprovals update(
		larion.progate.lmis.model.LmisAbsenceApprovals lmisAbsenceApprovals)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisAbsenceApprovals);
	}

	public static larion.progate.lmis.model.LmisAbsenceApprovals update(
		larion.progate.lmis.model.LmisAbsenceApprovals lmisAbsenceApprovals,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisAbsenceApprovals, merge);
	}

	public static larion.progate.lmis.model.LmisAbsenceApprovals updateImpl(
		larion.progate.lmis.model.LmisAbsenceApprovals lmisAbsenceApprovals,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisAbsenceApprovals, merge);
	}

	public static larion.progate.lmis.model.LmisAbsenceApprovals findByPrimaryKey(
		java.lang.Integer lmisAbsenceApprovalsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceApprovalsException {
		return getPersistence().findByPrimaryKey(lmisAbsenceApprovalsId);
	}

	public static larion.progate.lmis.model.LmisAbsenceApprovals fetchByPrimaryKey(
		java.lang.Integer lmisAbsenceApprovalsId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisAbsenceApprovalsId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceApprovals> findByRootID(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceApprovals> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceApprovals> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootID(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceApprovals findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceApprovalsException {
		return getPersistence().findByRootID_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceApprovals findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceApprovalsException {
		return getPersistence().findByRootID_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceApprovals[] findByRootID_PrevAndNext(
		java.lang.Integer lmisAbsenceApprovalsId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceApprovalsException {
		return getPersistence()
				   .findByRootID_PrevAndNext(lmisAbsenceApprovalsId, rootId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceApprovals> findByRequestID(
		int requestId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestID(requestId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceApprovals> findByRequestID(
		int requestId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestID(requestId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceApprovals> findByRequestID(
		int requestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestID(requestId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceApprovals findByRequestID_First(
		int requestId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceApprovalsException {
		return getPersistence().findByRequestID_First(requestId, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceApprovals findByRequestID_Last(
		int requestId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceApprovalsException {
		return getPersistence().findByRequestID_Last(requestId, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceApprovals[] findByRequestID_PrevAndNext(
		java.lang.Integer lmisAbsenceApprovalsId, int requestId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceApprovalsException {
		return getPersistence()
				   .findByRequestID_PrevAndNext(lmisAbsenceApprovalsId,
			requestId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceApprovals> findByApprovedBy(
		int approvedBy) throws com.liferay.portal.SystemException {
		return getPersistence().findByApprovedBy(approvedBy);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceApprovals> findByApprovedBy(
		int approvedBy, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByApprovedBy(approvedBy, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceApprovals> findByApprovedBy(
		int approvedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByApprovedBy(approvedBy, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceApprovals findByApprovedBy_First(
		int approvedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceApprovalsException {
		return getPersistence().findByApprovedBy_First(approvedBy, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceApprovals findByApprovedBy_Last(
		int approvedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceApprovalsException {
		return getPersistence().findByApprovedBy_Last(approvedBy, obc);
	}

	public static larion.progate.lmis.model.LmisAbsenceApprovals[] findByApprovedBy_PrevAndNext(
		java.lang.Integer lmisAbsenceApprovalsId, int approvedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisAbsenceApprovalsException {
		return getPersistence()
				   .findByApprovedBy_PrevAndNext(lmisAbsenceApprovalsId,
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

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceApprovals> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceApprovals> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisAbsenceApprovals> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByRootID(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRootID(rootId);
	}

	public static void removeByRequestID(int requestId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRequestID(requestId);
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

	public static int countByRequestID(int requestId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRequestID(requestId);
	}

	public static int countByApprovedBy(int approvedBy)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByApprovedBy(approvedBy);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static LmisAbsenceApprovalsPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(LmisAbsenceApprovalsPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisAbsenceApprovalsPersistence _persistence;
}