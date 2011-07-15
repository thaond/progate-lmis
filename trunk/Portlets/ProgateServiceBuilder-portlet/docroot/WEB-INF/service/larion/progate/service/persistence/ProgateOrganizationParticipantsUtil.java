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
 * <a href="ProgateOrganizationParticipantsUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgateOrganizationParticipantsUtil {
	public static void cacheResult(
		larion.progate.model.ProgateOrganizationParticipants progateOrganizationParticipants) {
		getPersistence().cacheResult(progateOrganizationParticipants);
	}

	public static void cacheResult(
		java.util.List<larion.progate.model.ProgateOrganizationParticipants> progateOrganizationParticipantses) {
		getPersistence().cacheResult(progateOrganizationParticipantses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.model.ProgateOrganizationParticipants create(
		java.lang.Integer ProgateOrganizationParticipantsId) {
		return getPersistence().create(ProgateOrganizationParticipantsId);
	}

	public static larion.progate.model.ProgateOrganizationParticipants remove(
		java.lang.Integer ProgateOrganizationParticipantsId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException {
		return getPersistence().remove(ProgateOrganizationParticipantsId);
	}

	public static larion.progate.model.ProgateOrganizationParticipants remove(
		larion.progate.model.ProgateOrganizationParticipants progateOrganizationParticipants)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(progateOrganizationParticipants);
	}

	public static larion.progate.model.ProgateOrganizationParticipants update(
		larion.progate.model.ProgateOrganizationParticipants progateOrganizationParticipants)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(progateOrganizationParticipants);
	}

	public static larion.progate.model.ProgateOrganizationParticipants update(
		larion.progate.model.ProgateOrganizationParticipants progateOrganizationParticipants,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(progateOrganizationParticipants, merge);
	}

	public static larion.progate.model.ProgateOrganizationParticipants updateImpl(
		larion.progate.model.ProgateOrganizationParticipants progateOrganizationParticipants,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence()
				   .updateImpl(progateOrganizationParticipants, merge);
	}

	public static larion.progate.model.ProgateOrganizationParticipants findByPrimaryKey(
		java.lang.Integer ProgateOrganizationParticipantsId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException {
		return getPersistence()
				   .findByPrimaryKey(ProgateOrganizationParticipantsId);
	}

	public static larion.progate.model.ProgateOrganizationParticipants fetchByPrimaryKey(
		java.lang.Integer ProgateOrganizationParticipantsId)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .fetchByPrimaryKey(ProgateOrganizationParticipantsId);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByuserId(
		int userId) throws com.liferay.portal.SystemException {
		return getPersistence().findByuserId(userId);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByuserId(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByuserId(userId, start, end);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByuserId(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByuserId(userId, start, end, obc);
	}

	public static larion.progate.model.ProgateOrganizationParticipants findByuserId_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException {
		return getPersistence().findByuserId_First(userId, obc);
	}

	public static larion.progate.model.ProgateOrganizationParticipants findByuserId_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException {
		return getPersistence().findByuserId_Last(userId, obc);
	}

	public static larion.progate.model.ProgateOrganizationParticipants[] findByuserId_PrevAndNext(
		java.lang.Integer ProgateOrganizationParticipantsId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException {
		return getPersistence()
				   .findByuserId_PrevAndNext(ProgateOrganizationParticipantsId,
			userId, obc);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByorgId(
		int orgId) throws com.liferay.portal.SystemException {
		return getPersistence().findByorgId(orgId);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByorgId(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByorgId(orgId, start, end);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByorgId(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByorgId(orgId, start, end, obc);
	}

	public static larion.progate.model.ProgateOrganizationParticipants findByorgId_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException {
		return getPersistence().findByorgId_First(orgId, obc);
	}

	public static larion.progate.model.ProgateOrganizationParticipants findByorgId_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException {
		return getPersistence().findByorgId_Last(orgId, obc);
	}

	public static larion.progate.model.ProgateOrganizationParticipants[] findByorgId_PrevAndNext(
		java.lang.Integer ProgateOrganizationParticipantsId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException {
		return getPersistence()
				   .findByorgId_PrevAndNext(ProgateOrganizationParticipantsId,
			orgId, obc);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByroleId(
		int roleId) throws com.liferay.portal.SystemException {
		return getPersistence().findByroleId(roleId);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByroleId(
		int roleId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByroleId(roleId, start, end);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByroleId(
		int roleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByroleId(roleId, start, end, obc);
	}

	public static larion.progate.model.ProgateOrganizationParticipants findByroleId_First(
		int roleId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException {
		return getPersistence().findByroleId_First(roleId, obc);
	}

	public static larion.progate.model.ProgateOrganizationParticipants findByroleId_Last(
		int roleId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException {
		return getPersistence().findByroleId_Last(roleId, obc);
	}

	public static larion.progate.model.ProgateOrganizationParticipants[] findByroleId_PrevAndNext(
		java.lang.Integer ProgateOrganizationParticipantsId, int roleId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException {
		return getPersistence()
				   .findByroleId_PrevAndNext(ProgateOrganizationParticipantsId,
			roleId, obc);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByrequestedBy(
		int requestedBy) throws com.liferay.portal.SystemException {
		return getPersistence().findByrequestedBy(requestedBy);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByrequestedBy(
		int requestedBy, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByrequestedBy(requestedBy, start, end);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByrequestedBy(
		int requestedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByrequestedBy(requestedBy, start, end, obc);
	}

	public static larion.progate.model.ProgateOrganizationParticipants findByrequestedBy_First(
		int requestedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException {
		return getPersistence().findByrequestedBy_First(requestedBy, obc);
	}

	public static larion.progate.model.ProgateOrganizationParticipants findByrequestedBy_Last(
		int requestedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException {
		return getPersistence().findByrequestedBy_Last(requestedBy, obc);
	}

	public static larion.progate.model.ProgateOrganizationParticipants[] findByrequestedBy_PrevAndNext(
		java.lang.Integer ProgateOrganizationParticipantsId, int requestedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException {
		return getPersistence()
				   .findByrequestedBy_PrevAndNext(ProgateOrganizationParticipantsId,
			requestedBy, obc);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByrequestedAt(
		java.util.Date requestedAt) throws com.liferay.portal.SystemException {
		return getPersistence().findByrequestedAt(requestedAt);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByrequestedAt(
		java.util.Date requestedAt, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByrequestedAt(requestedAt, start, end);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByrequestedAt(
		java.util.Date requestedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByrequestedAt(requestedAt, start, end, obc);
	}

	public static larion.progate.model.ProgateOrganizationParticipants findByrequestedAt_First(
		java.util.Date requestedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException {
		return getPersistence().findByrequestedAt_First(requestedAt, obc);
	}

	public static larion.progate.model.ProgateOrganizationParticipants findByrequestedAt_Last(
		java.util.Date requestedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException {
		return getPersistence().findByrequestedAt_Last(requestedAt, obc);
	}

	public static larion.progate.model.ProgateOrganizationParticipants[] findByrequestedAt_PrevAndNext(
		java.lang.Integer ProgateOrganizationParticipantsId,
		java.util.Date requestedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException {
		return getPersistence()
				   .findByrequestedAt_PrevAndNext(ProgateOrganizationParticipantsId,
			requestedAt, obc);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByapprovedBy(
		int approvedBy) throws com.liferay.portal.SystemException {
		return getPersistence().findByapprovedBy(approvedBy);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByapprovedBy(
		int approvedBy, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByapprovedBy(approvedBy, start, end);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByapprovedBy(
		int approvedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByapprovedBy(approvedBy, start, end, obc);
	}

	public static larion.progate.model.ProgateOrganizationParticipants findByapprovedBy_First(
		int approvedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException {
		return getPersistence().findByapprovedBy_First(approvedBy, obc);
	}

	public static larion.progate.model.ProgateOrganizationParticipants findByapprovedBy_Last(
		int approvedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException {
		return getPersistence().findByapprovedBy_Last(approvedBy, obc);
	}

	public static larion.progate.model.ProgateOrganizationParticipants[] findByapprovedBy_PrevAndNext(
		java.lang.Integer ProgateOrganizationParticipantsId, int approvedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException {
		return getPersistence()
				   .findByapprovedBy_PrevAndNext(ProgateOrganizationParticipantsId,
			approvedBy, obc);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByapprovedAt(
		java.util.Date approvedAt) throws com.liferay.portal.SystemException {
		return getPersistence().findByapprovedAt(approvedAt);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByapprovedAt(
		java.util.Date approvedAt, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByapprovedAt(approvedAt, start, end);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByapprovedAt(
		java.util.Date approvedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByapprovedAt(approvedAt, start, end, obc);
	}

	public static larion.progate.model.ProgateOrganizationParticipants findByapprovedAt_First(
		java.util.Date approvedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException {
		return getPersistence().findByapprovedAt_First(approvedAt, obc);
	}

	public static larion.progate.model.ProgateOrganizationParticipants findByapprovedAt_Last(
		java.util.Date approvedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException {
		return getPersistence().findByapprovedAt_Last(approvedAt, obc);
	}

	public static larion.progate.model.ProgateOrganizationParticipants[] findByapprovedAt_PrevAndNext(
		java.lang.Integer ProgateOrganizationParticipantsId,
		java.util.Date approvedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException {
		return getPersistence()
				   .findByapprovedAt_PrevAndNext(ProgateOrganizationParticipantsId,
			approvedAt, obc);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationParticipants> findBystatus(
		int status) throws com.liferay.portal.SystemException {
		return getPersistence().findBystatus(status);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationParticipants> findBystatus(
		int status, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBystatus(status, start, end);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationParticipants> findBystatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBystatus(status, start, end, obc);
	}

	public static larion.progate.model.ProgateOrganizationParticipants findBystatus_First(
		int status, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException {
		return getPersistence().findBystatus_First(status, obc);
	}

	public static larion.progate.model.ProgateOrganizationParticipants findBystatus_Last(
		int status, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException {
		return getPersistence().findBystatus_Last(status, obc);
	}

	public static larion.progate.model.ProgateOrganizationParticipants[] findBystatus_PrevAndNext(
		java.lang.Integer ProgateOrganizationParticipantsId, int status,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException {
		return getPersistence()
				   .findBystatus_PrevAndNext(ProgateOrganizationParticipantsId,
			status, obc);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByisCurrent(
		boolean isCurrent) throws com.liferay.portal.SystemException {
		return getPersistence().findByisCurrent(isCurrent);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByisCurrent(
		boolean isCurrent, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByisCurrent(isCurrent, start, end);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByisCurrent(
		boolean isCurrent, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByisCurrent(isCurrent, start, end, obc);
	}

	public static larion.progate.model.ProgateOrganizationParticipants findByisCurrent_First(
		boolean isCurrent, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException {
		return getPersistence().findByisCurrent_First(isCurrent, obc);
	}

	public static larion.progate.model.ProgateOrganizationParticipants findByisCurrent_Last(
		boolean isCurrent, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException {
		return getPersistence().findByisCurrent_Last(isCurrent, obc);
	}

	public static larion.progate.model.ProgateOrganizationParticipants[] findByisCurrent_PrevAndNext(
		java.lang.Integer ProgateOrganizationParticipantsId, boolean isCurrent,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException {
		return getPersistence()
				   .findByisCurrent_PrevAndNext(ProgateOrganizationParticipantsId,
			isCurrent, obc);
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

	public static java.util.List<larion.progate.model.ProgateOrganizationParticipants> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationParticipants> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationParticipants> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByuserId(int userId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByuserId(userId);
	}

	public static void removeByorgId(int orgId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByorgId(orgId);
	}

	public static void removeByroleId(int roleId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByroleId(roleId);
	}

	public static void removeByrequestedBy(int requestedBy)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByrequestedBy(requestedBy);
	}

	public static void removeByrequestedAt(java.util.Date requestedAt)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByrequestedAt(requestedAt);
	}

	public static void removeByapprovedBy(int approvedBy)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByapprovedBy(approvedBy);
	}

	public static void removeByapprovedAt(java.util.Date approvedAt)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByapprovedAt(approvedAt);
	}

	public static void removeBystatus(int status)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBystatus(status);
	}

	public static void removeByisCurrent(boolean isCurrent)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByisCurrent(isCurrent);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByuserId(int userId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByuserId(userId);
	}

	public static int countByorgId(int orgId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByorgId(orgId);
	}

	public static int countByroleId(int roleId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByroleId(roleId);
	}

	public static int countByrequestedBy(int requestedBy)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByrequestedBy(requestedBy);
	}

	public static int countByrequestedAt(java.util.Date requestedAt)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByrequestedAt(requestedAt);
	}

	public static int countByapprovedBy(int approvedBy)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByapprovedBy(approvedBy);
	}

	public static int countByapprovedAt(java.util.Date approvedAt)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByapprovedAt(approvedAt);
	}

	public static int countBystatus(int status)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBystatus(status);
	}

	public static int countByisCurrent(boolean isCurrent)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByisCurrent(isCurrent);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static ProgateOrganizationParticipantsPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(
		ProgateOrganizationParticipantsPersistence persistence) {
		_persistence = persistence;
	}

	private static ProgateOrganizationParticipantsPersistence _persistence;
}