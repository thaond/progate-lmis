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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * <a href="ProgateOrganizationParticipantsPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface ProgateOrganizationParticipantsPersistence
	extends BasePersistence {
	public void cacheResult(
		larion.progate.model.ProgateOrganizationParticipants progateOrganizationParticipants);

	public void cacheResult(
		java.util.List<larion.progate.model.ProgateOrganizationParticipants> progateOrganizationParticipantses);

	public void clearCache();

	public larion.progate.model.ProgateOrganizationParticipants create(
		java.lang.Integer ProgateOrganizationParticipantsId);

	public larion.progate.model.ProgateOrganizationParticipants remove(
		java.lang.Integer ProgateOrganizationParticipantsId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException;

	public larion.progate.model.ProgateOrganizationParticipants remove(
		larion.progate.model.ProgateOrganizationParticipants progateOrganizationParticipants)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateOrganizationParticipants update(
		larion.progate.model.ProgateOrganizationParticipants progateOrganizationParticipants)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateOrganizationParticipants update(
		larion.progate.model.ProgateOrganizationParticipants progateOrganizationParticipants,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateOrganizationParticipants updateImpl(
		larion.progate.model.ProgateOrganizationParticipants progateOrganizationParticipants,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateOrganizationParticipants findByPrimaryKey(
		java.lang.Integer ProgateOrganizationParticipantsId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException;

	public larion.progate.model.ProgateOrganizationParticipants fetchByPrimaryKey(
		java.lang.Integer ProgateOrganizationParticipantsId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByuserId(
		int userId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByuserId(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByuserId(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateOrganizationParticipants findByuserId_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException;

	public larion.progate.model.ProgateOrganizationParticipants findByuserId_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException;

	public larion.progate.model.ProgateOrganizationParticipants[] findByuserId_PrevAndNext(
		java.lang.Integer ProgateOrganizationParticipantsId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException;

	public java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByorgId(
		int orgId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByorgId(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByorgId(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateOrganizationParticipants findByorgId_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException;

	public larion.progate.model.ProgateOrganizationParticipants findByorgId_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException;

	public larion.progate.model.ProgateOrganizationParticipants[] findByorgId_PrevAndNext(
		java.lang.Integer ProgateOrganizationParticipantsId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException;

	public java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByroleId(
		int roleId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByroleId(
		int roleId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByroleId(
		int roleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateOrganizationParticipants findByroleId_First(
		int roleId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException;

	public larion.progate.model.ProgateOrganizationParticipants findByroleId_Last(
		int roleId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException;

	public larion.progate.model.ProgateOrganizationParticipants[] findByroleId_PrevAndNext(
		java.lang.Integer ProgateOrganizationParticipantsId, int roleId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException;

	public java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByrequestedBy(
		int requestedBy) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByrequestedBy(
		int requestedBy, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByrequestedBy(
		int requestedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateOrganizationParticipants findByrequestedBy_First(
		int requestedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException;

	public larion.progate.model.ProgateOrganizationParticipants findByrequestedBy_Last(
		int requestedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException;

	public larion.progate.model.ProgateOrganizationParticipants[] findByrequestedBy_PrevAndNext(
		java.lang.Integer ProgateOrganizationParticipantsId, int requestedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException;

	public java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByrequestedAt(
		java.util.Date requestedAt) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByrequestedAt(
		java.util.Date requestedAt, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByrequestedAt(
		java.util.Date requestedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateOrganizationParticipants findByrequestedAt_First(
		java.util.Date requestedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException;

	public larion.progate.model.ProgateOrganizationParticipants findByrequestedAt_Last(
		java.util.Date requestedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException;

	public larion.progate.model.ProgateOrganizationParticipants[] findByrequestedAt_PrevAndNext(
		java.lang.Integer ProgateOrganizationParticipantsId,
		java.util.Date requestedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException;

	public java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByapprovedBy(
		int approvedBy) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByapprovedBy(
		int approvedBy, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByapprovedBy(
		int approvedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateOrganizationParticipants findByapprovedBy_First(
		int approvedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException;

	public larion.progate.model.ProgateOrganizationParticipants findByapprovedBy_Last(
		int approvedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException;

	public larion.progate.model.ProgateOrganizationParticipants[] findByapprovedBy_PrevAndNext(
		java.lang.Integer ProgateOrganizationParticipantsId, int approvedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException;

	public java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByapprovedAt(
		java.util.Date approvedAt) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByapprovedAt(
		java.util.Date approvedAt, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByapprovedAt(
		java.util.Date approvedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateOrganizationParticipants findByapprovedAt_First(
		java.util.Date approvedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException;

	public larion.progate.model.ProgateOrganizationParticipants findByapprovedAt_Last(
		java.util.Date approvedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException;

	public larion.progate.model.ProgateOrganizationParticipants[] findByapprovedAt_PrevAndNext(
		java.lang.Integer ProgateOrganizationParticipantsId,
		java.util.Date approvedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException;

	public java.util.List<larion.progate.model.ProgateOrganizationParticipants> findBystatus(
		int status) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationParticipants> findBystatus(
		int status, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationParticipants> findBystatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateOrganizationParticipants findBystatus_First(
		int status, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException;

	public larion.progate.model.ProgateOrganizationParticipants findBystatus_Last(
		int status, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException;

	public larion.progate.model.ProgateOrganizationParticipants[] findBystatus_PrevAndNext(
		java.lang.Integer ProgateOrganizationParticipantsId, int status,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException;

	public java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByisCurrent(
		boolean isCurrent) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByisCurrent(
		boolean isCurrent, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationParticipants> findByisCurrent(
		boolean isCurrent, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateOrganizationParticipants findByisCurrent_First(
		boolean isCurrent, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException;

	public larion.progate.model.ProgateOrganizationParticipants findByisCurrent_Last(
		boolean isCurrent, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException;

	public larion.progate.model.ProgateOrganizationParticipants[] findByisCurrent_PrevAndNext(
		java.lang.Integer ProgateOrganizationParticipantsId, boolean isCurrent,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationParticipantsException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationParticipants> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationParticipants> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationParticipants> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByuserId(int userId)
		throws com.liferay.portal.SystemException;

	public void removeByorgId(int orgId)
		throws com.liferay.portal.SystemException;

	public void removeByroleId(int roleId)
		throws com.liferay.portal.SystemException;

	public void removeByrequestedBy(int requestedBy)
		throws com.liferay.portal.SystemException;

	public void removeByrequestedAt(java.util.Date requestedAt)
		throws com.liferay.portal.SystemException;

	public void removeByapprovedBy(int approvedBy)
		throws com.liferay.portal.SystemException;

	public void removeByapprovedAt(java.util.Date approvedAt)
		throws com.liferay.portal.SystemException;

	public void removeBystatus(int status)
		throws com.liferay.portal.SystemException;

	public void removeByisCurrent(boolean isCurrent)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByuserId(int userId)
		throws com.liferay.portal.SystemException;

	public int countByorgId(int orgId)
		throws com.liferay.portal.SystemException;

	public int countByroleId(int roleId)
		throws com.liferay.portal.SystemException;

	public int countByrequestedBy(int requestedBy)
		throws com.liferay.portal.SystemException;

	public int countByrequestedAt(java.util.Date requestedAt)
		throws com.liferay.portal.SystemException;

	public int countByapprovedBy(int approvedBy)
		throws com.liferay.portal.SystemException;

	public int countByapprovedAt(java.util.Date approvedAt)
		throws com.liferay.portal.SystemException;

	public int countBystatus(int status)
		throws com.liferay.portal.SystemException;

	public int countByisCurrent(boolean isCurrent)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}