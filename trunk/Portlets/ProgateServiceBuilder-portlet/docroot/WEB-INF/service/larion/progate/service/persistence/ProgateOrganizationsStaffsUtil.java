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
 * <a href="ProgateOrganizationsStaffsUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgateOrganizationsStaffsUtil {
	public static void cacheResult(
		larion.progate.model.ProgateOrganizationsStaffs progateOrganizationsStaffs) {
		getPersistence().cacheResult(progateOrganizationsStaffs);
	}

	public static void cacheResult(
		java.util.List<larion.progate.model.ProgateOrganizationsStaffs> progateOrganizationsStaffses) {
		getPersistence().cacheResult(progateOrganizationsStaffses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.model.ProgateOrganizationsStaffs create(
		java.lang.Integer ProgateOrganizationsStaffsId) {
		return getPersistence().create(ProgateOrganizationsStaffsId);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs remove(
		java.lang.Integer ProgateOrganizationsStaffsId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException {
		return getPersistence().remove(ProgateOrganizationsStaffsId);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs remove(
		larion.progate.model.ProgateOrganizationsStaffs progateOrganizationsStaffs)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(progateOrganizationsStaffs);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs update(
		larion.progate.model.ProgateOrganizationsStaffs progateOrganizationsStaffs)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(progateOrganizationsStaffs);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs update(
		larion.progate.model.ProgateOrganizationsStaffs progateOrganizationsStaffs,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(progateOrganizationsStaffs, merge);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs updateImpl(
		larion.progate.model.ProgateOrganizationsStaffs progateOrganizationsStaffs,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(progateOrganizationsStaffs, merge);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs findByPrimaryKey(
		java.lang.Integer ProgateOrganizationsStaffsId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException {
		return getPersistence().findByPrimaryKey(ProgateOrganizationsStaffsId);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs fetchByPrimaryKey(
		java.lang.Integer ProgateOrganizationsStaffsId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(ProgateOrganizationsStaffsId);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByorgId(
		int orgId) throws com.liferay.portal.SystemException {
		return getPersistence().findByorgId(orgId);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByorgId(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByorgId(orgId, start, end);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByorgId(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByorgId(orgId, start, end, obc);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs findByorgId_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException {
		return getPersistence().findByorgId_First(orgId, obc);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs findByorgId_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException {
		return getPersistence().findByorgId_Last(orgId, obc);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs[] findByorgId_PrevAndNext(
		java.lang.Integer ProgateOrganizationsStaffsId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException {
		return getPersistence()
				   .findByorgId_PrevAndNext(ProgateOrganizationsStaffsId,
			orgId, obc);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByrootId(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByrootId(rootId);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByrootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByrootId(rootId, start, end);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByrootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByrootId(rootId, start, end, obc);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs findByrootId_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException {
		return getPersistence().findByrootId_First(rootId, obc);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs findByrootId_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException {
		return getPersistence().findByrootId_Last(rootId, obc);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs[] findByrootId_PrevAndNext(
		java.lang.Integer ProgateOrganizationsStaffsId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException {
		return getPersistence()
				   .findByrootId_PrevAndNext(ProgateOrganizationsStaffsId,
			rootId, obc);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findBybodId(
		int bodId) throws com.liferay.portal.SystemException {
		return getPersistence().findBybodId(bodId);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findBybodId(
		int bodId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBybodId(bodId, start, end);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findBybodId(
		int bodId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBybodId(bodId, start, end, obc);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs findBybodId_First(
		int bodId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException {
		return getPersistence().findBybodId_First(bodId, obc);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs findBybodId_Last(
		int bodId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException {
		return getPersistence().findBybodId_Last(bodId, obc);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs[] findBybodId_PrevAndNext(
		java.lang.Integer ProgateOrganizationsStaffsId, int bodId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException {
		return getPersistence()
				   .findBybodId_PrevAndNext(ProgateOrganizationsStaffsId,
			bodId, obc);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByparticipantId(
		int participantId) throws com.liferay.portal.SystemException {
		return getPersistence().findByparticipantId(participantId);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByparticipantId(
		int participantId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByparticipantId(participantId, start, end);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByparticipantId(
		int participantId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByparticipantId(participantId, start, end, obc);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs findByparticipantId_First(
		int participantId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException {
		return getPersistence().findByparticipantId_First(participantId, obc);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs findByparticipantId_Last(
		int participantId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException {
		return getPersistence().findByparticipantId_Last(participantId, obc);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs[] findByparticipantId_PrevAndNext(
		java.lang.Integer ProgateOrganizationsStaffsId, int participantId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException {
		return getPersistence()
				   .findByparticipantId_PrevAndNext(ProgateOrganizationsStaffsId,
			participantId, obc);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByisActive(
		boolean isActive) throws com.liferay.portal.SystemException {
		return getPersistence().findByisActive(isActive);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByisActive(
		boolean isActive, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByisActive(isActive, start, end);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByisActive(
		boolean isActive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByisActive(isActive, start, end, obc);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs findByisActive_First(
		boolean isActive, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException {
		return getPersistence().findByisActive_First(isActive, obc);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs findByisActive_Last(
		boolean isActive, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException {
		return getPersistence().findByisActive_Last(isActive, obc);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs[] findByisActive_PrevAndNext(
		java.lang.Integer ProgateOrganizationsStaffsId, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException {
		return getPersistence()
				   .findByisActive_PrevAndNext(ProgateOrganizationsStaffsId,
			isActive, obc);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByisRemoved(
		boolean isRemoved) throws com.liferay.portal.SystemException {
		return getPersistence().findByisRemoved(isRemoved);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByisRemoved(
		boolean isRemoved, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByisRemoved(isRemoved, start, end);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByisRemoved(
		boolean isRemoved, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByisRemoved(isRemoved, start, end, obc);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs findByisRemoved_First(
		boolean isRemoved, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException {
		return getPersistence().findByisRemoved_First(isRemoved, obc);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs findByisRemoved_Last(
		boolean isRemoved, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException {
		return getPersistence().findByisRemoved_Last(isRemoved, obc);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs[] findByisRemoved_PrevAndNext(
		java.lang.Integer ProgateOrganizationsStaffsId, boolean isRemoved,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException {
		return getPersistence()
				   .findByisRemoved_PrevAndNext(ProgateOrganizationsStaffsId,
			isRemoved, obc);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByscannerCode(
		java.lang.String scannerCode) throws com.liferay.portal.SystemException {
		return getPersistence().findByscannerCode(scannerCode);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByscannerCode(
		java.lang.String scannerCode, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByscannerCode(scannerCode, start, end);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByscannerCode(
		java.lang.String scannerCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByscannerCode(scannerCode, start, end, obc);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs findByscannerCode_First(
		java.lang.String scannerCode,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException {
		return getPersistence().findByscannerCode_First(scannerCode, obc);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs findByscannerCode_Last(
		java.lang.String scannerCode,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException {
		return getPersistence().findByscannerCode_Last(scannerCode, obc);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs[] findByscannerCode_PrevAndNext(
		java.lang.Integer ProgateOrganizationsStaffsId,
		java.lang.String scannerCode,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException {
		return getPersistence()
				   .findByscannerCode_PrevAndNext(ProgateOrganizationsStaffsId,
			scannerCode, obc);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findBystaffCode(
		java.lang.String staffCode) throws com.liferay.portal.SystemException {
		return getPersistence().findBystaffCode(staffCode);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findBystaffCode(
		java.lang.String staffCode, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBystaffCode(staffCode, start, end);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findBystaffCode(
		java.lang.String staffCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBystaffCode(staffCode, start, end, obc);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs findBystaffCode_First(
		java.lang.String staffCode,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException {
		return getPersistence().findBystaffCode_First(staffCode, obc);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs findBystaffCode_Last(
		java.lang.String staffCode,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException {
		return getPersistence().findBystaffCode_Last(staffCode, obc);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs[] findBystaffCode_PrevAndNext(
		java.lang.Integer ProgateOrganizationsStaffsId,
		java.lang.String staffCode,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException {
		return getPersistence()
				   .findBystaffCode_PrevAndNext(ProgateOrganizationsStaffsId,
			staffCode, obc);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByuserId(
		int userId) throws com.liferay.portal.SystemException {
		return getPersistence().findByuserId(userId);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByuserId(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByuserId(userId, start, end);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByuserId(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByuserId(userId, start, end, obc);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs findByuserId_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException {
		return getPersistence().findByuserId_First(userId, obc);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs findByuserId_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException {
		return getPersistence().findByuserId_Last(userId, obc);
	}

	public static larion.progate.model.ProgateOrganizationsStaffs[] findByuserId_PrevAndNext(
		java.lang.Integer ProgateOrganizationsStaffsId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException {
		return getPersistence()
				   .findByuserId_PrevAndNext(ProgateOrganizationsStaffsId,
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

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByorgId(int orgId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByorgId(orgId);
	}

	public static void removeByrootId(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByrootId(rootId);
	}

	public static void removeBybodId(int bodId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBybodId(bodId);
	}

	public static void removeByparticipantId(int participantId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByparticipantId(participantId);
	}

	public static void removeByisActive(boolean isActive)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByisActive(isActive);
	}

	public static void removeByisRemoved(boolean isRemoved)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByisRemoved(isRemoved);
	}

	public static void removeByscannerCode(java.lang.String scannerCode)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByscannerCode(scannerCode);
	}

	public static void removeBystaffCode(java.lang.String staffCode)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBystaffCode(staffCode);
	}

	public static void removeByuserId(int userId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByuserId(userId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByorgId(int orgId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByorgId(orgId);
	}

	public static int countByrootId(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByrootId(rootId);
	}

	public static int countBybodId(int bodId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBybodId(bodId);
	}

	public static int countByparticipantId(int participantId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByparticipantId(participantId);
	}

	public static int countByisActive(boolean isActive)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByisActive(isActive);
	}

	public static int countByisRemoved(boolean isRemoved)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByisRemoved(isRemoved);
	}

	public static int countByscannerCode(java.lang.String scannerCode)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByscannerCode(scannerCode);
	}

	public static int countBystaffCode(java.lang.String staffCode)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBystaffCode(staffCode);
	}

	public static int countByuserId(int userId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByuserId(userId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static ProgateOrganizationsStaffsPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(
		ProgateOrganizationsStaffsPersistence persistence) {
		_persistence = persistence;
	}

	private static ProgateOrganizationsStaffsPersistence _persistence;
}