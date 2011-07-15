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
 * <a href="LmisOvertimeRequestDetailsUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOvertimeRequestDetailsUtil {
	public static void cacheResult(
		larion.progate.lmis.model.LmisOvertimeRequestDetails lmisOvertimeRequestDetails) {
		getPersistence().cacheResult(lmisOvertimeRequestDetails);
	}

	public static void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisOvertimeRequestDetails> lmisOvertimeRequestDetailses) {
		getPersistence().cacheResult(lmisOvertimeRequestDetailses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.lmis.model.LmisOvertimeRequestDetails create(
		java.lang.Integer lmisOvertimeRequestDetailsId) {
		return getPersistence().create(lmisOvertimeRequestDetailsId);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequestDetails remove(
		java.lang.Integer lmisOvertimeRequestDetailsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestDetailsException {
		return getPersistence().remove(lmisOvertimeRequestDetailsId);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequestDetails remove(
		larion.progate.lmis.model.LmisOvertimeRequestDetails lmisOvertimeRequestDetails)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(lmisOvertimeRequestDetails);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequestDetails update(
		larion.progate.lmis.model.LmisOvertimeRequestDetails lmisOvertimeRequestDetails)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisOvertimeRequestDetails);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequestDetails update(
		larion.progate.lmis.model.LmisOvertimeRequestDetails lmisOvertimeRequestDetails,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(lmisOvertimeRequestDetails, merge);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequestDetails updateImpl(
		larion.progate.lmis.model.LmisOvertimeRequestDetails lmisOvertimeRequestDetails,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(lmisOvertimeRequestDetails, merge);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequestDetails findByPrimaryKey(
		java.lang.Integer lmisOvertimeRequestDetailsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestDetailsException {
		return getPersistence().findByPrimaryKey(lmisOvertimeRequestDetailsId);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequestDetails fetchByPrimaryKey(
		java.lang.Integer lmisOvertimeRequestDetailsId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(lmisOvertimeRequestDetailsId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeRequestDetails> findByOvertimeRequestDetailsOf(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByOvertimeRequestDetailsOf(rootId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeRequestDetails> findByOvertimeRequestDetailsOf(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByOvertimeRequestDetailsOf(rootId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeRequestDetails> findByOvertimeRequestDetailsOf(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByOvertimeRequestDetailsOf(rootId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequestDetails findByOvertimeRequestDetailsOf_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestDetailsException {
		return getPersistence().findByOvertimeRequestDetailsOf_First(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequestDetails findByOvertimeRequestDetailsOf_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestDetailsException {
		return getPersistence().findByOvertimeRequestDetailsOf_Last(rootId, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequestDetails[] findByOvertimeRequestDetailsOf_PrevAndNext(
		java.lang.Integer lmisOvertimeRequestDetailsId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestDetailsException {
		return getPersistence()
				   .findByOvertimeRequestDetailsOf_PrevAndNext(lmisOvertimeRequestDetailsId,
			rootId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeRequestDetails> findByRequestedID(
		int requestId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestedID(requestId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeRequestDetails> findByRequestedID(
		int requestId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestedID(requestId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeRequestDetails> findByRequestedID(
		int requestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRequestedID(requestId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequestDetails findByRequestedID_First(
		int requestId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestDetailsException {
		return getPersistence().findByRequestedID_First(requestId, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequestDetails findByRequestedID_Last(
		int requestId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestDetailsException {
		return getPersistence().findByRequestedID_Last(requestId, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequestDetails[] findByRequestedID_PrevAndNext(
		java.lang.Integer lmisOvertimeRequestDetailsId, int requestId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestDetailsException {
		return getPersistence()
				   .findByRequestedID_PrevAndNext(lmisOvertimeRequestDetailsId,
			requestId, obc);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeRequestDetails> findByUserID(
		int userId) throws com.liferay.portal.SystemException {
		return getPersistence().findByUserID(userId);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeRequestDetails> findByUserID(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserID(userId, start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeRequestDetails> findByUserID(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByUserID(userId, start, end, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequestDetails findByUserID_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestDetailsException {
		return getPersistence().findByUserID_First(userId, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequestDetails findByUserID_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestDetailsException {
		return getPersistence().findByUserID_Last(userId, obc);
	}

	public static larion.progate.lmis.model.LmisOvertimeRequestDetails[] findByUserID_PrevAndNext(
		java.lang.Integer lmisOvertimeRequestDetailsId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestDetailsException {
		return getPersistence()
				   .findByUserID_PrevAndNext(lmisOvertimeRequestDetailsId,
			userId, obc);
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

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeRequestDetails> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeRequestDetails> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.lmis.model.LmisOvertimeRequestDetails> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByOvertimeRequestDetailsOf(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByOvertimeRequestDetailsOf(rootId);
	}

	public static void removeByRequestedID(int requestId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRequestedID(requestId);
	}

	public static void removeByUserID(int userId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByUserID(userId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByOvertimeRequestDetailsOf(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByOvertimeRequestDetailsOf(rootId);
	}

	public static int countByRequestedID(int requestId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRequestedID(requestId);
	}

	public static int countByUserID(int userId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByUserID(userId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static LmisOvertimeRequestDetailsPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(
		LmisOvertimeRequestDetailsPersistence persistence) {
		_persistence = persistence;
	}

	private static LmisOvertimeRequestDetailsPersistence _persistence;
}