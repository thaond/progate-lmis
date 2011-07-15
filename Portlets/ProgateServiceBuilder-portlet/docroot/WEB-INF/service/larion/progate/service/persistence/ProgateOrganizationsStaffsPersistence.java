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
 * <a href="ProgateOrganizationsStaffsPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface ProgateOrganizationsStaffsPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.model.ProgateOrganizationsStaffs progateOrganizationsStaffs);

	public void cacheResult(
		java.util.List<larion.progate.model.ProgateOrganizationsStaffs> progateOrganizationsStaffses);

	public void clearCache();

	public larion.progate.model.ProgateOrganizationsStaffs create(
		java.lang.Integer ProgateOrganizationsStaffsId);

	public larion.progate.model.ProgateOrganizationsStaffs remove(
		java.lang.Integer ProgateOrganizationsStaffsId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException;

	public larion.progate.model.ProgateOrganizationsStaffs remove(
		larion.progate.model.ProgateOrganizationsStaffs progateOrganizationsStaffs)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateOrganizationsStaffs update(
		larion.progate.model.ProgateOrganizationsStaffs progateOrganizationsStaffs)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateOrganizationsStaffs update(
		larion.progate.model.ProgateOrganizationsStaffs progateOrganizationsStaffs,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateOrganizationsStaffs updateImpl(
		larion.progate.model.ProgateOrganizationsStaffs progateOrganizationsStaffs,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateOrganizationsStaffs findByPrimaryKey(
		java.lang.Integer ProgateOrganizationsStaffsId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException;

	public larion.progate.model.ProgateOrganizationsStaffs fetchByPrimaryKey(
		java.lang.Integer ProgateOrganizationsStaffsId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByorgId(
		int orgId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByorgId(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByorgId(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateOrganizationsStaffs findByorgId_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException;

	public larion.progate.model.ProgateOrganizationsStaffs findByorgId_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException;

	public larion.progate.model.ProgateOrganizationsStaffs[] findByorgId_PrevAndNext(
		java.lang.Integer ProgateOrganizationsStaffsId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException;

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByrootId(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByrootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByrootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateOrganizationsStaffs findByrootId_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException;

	public larion.progate.model.ProgateOrganizationsStaffs findByrootId_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException;

	public larion.progate.model.ProgateOrganizationsStaffs[] findByrootId_PrevAndNext(
		java.lang.Integer ProgateOrganizationsStaffsId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException;

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findBybodId(
		int bodId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findBybodId(
		int bodId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findBybodId(
		int bodId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateOrganizationsStaffs findBybodId_First(
		int bodId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException;

	public larion.progate.model.ProgateOrganizationsStaffs findBybodId_Last(
		int bodId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException;

	public larion.progate.model.ProgateOrganizationsStaffs[] findBybodId_PrevAndNext(
		java.lang.Integer ProgateOrganizationsStaffsId, int bodId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException;

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByparticipantId(
		int participantId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByparticipantId(
		int participantId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByparticipantId(
		int participantId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateOrganizationsStaffs findByparticipantId_First(
		int participantId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException;

	public larion.progate.model.ProgateOrganizationsStaffs findByparticipantId_Last(
		int participantId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException;

	public larion.progate.model.ProgateOrganizationsStaffs[] findByparticipantId_PrevAndNext(
		java.lang.Integer ProgateOrganizationsStaffsId, int participantId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException;

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByisActive(
		boolean isActive) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByisActive(
		boolean isActive, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByisActive(
		boolean isActive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateOrganizationsStaffs findByisActive_First(
		boolean isActive, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException;

	public larion.progate.model.ProgateOrganizationsStaffs findByisActive_Last(
		boolean isActive, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException;

	public larion.progate.model.ProgateOrganizationsStaffs[] findByisActive_PrevAndNext(
		java.lang.Integer ProgateOrganizationsStaffsId, boolean isActive,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException;

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByisRemoved(
		boolean isRemoved) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByisRemoved(
		boolean isRemoved, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByisRemoved(
		boolean isRemoved, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateOrganizationsStaffs findByisRemoved_First(
		boolean isRemoved, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException;

	public larion.progate.model.ProgateOrganizationsStaffs findByisRemoved_Last(
		boolean isRemoved, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException;

	public larion.progate.model.ProgateOrganizationsStaffs[] findByisRemoved_PrevAndNext(
		java.lang.Integer ProgateOrganizationsStaffsId, boolean isRemoved,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException;

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByscannerCode(
		java.lang.String scannerCode) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByscannerCode(
		java.lang.String scannerCode, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByscannerCode(
		java.lang.String scannerCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateOrganizationsStaffs findByscannerCode_First(
		java.lang.String scannerCode,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException;

	public larion.progate.model.ProgateOrganizationsStaffs findByscannerCode_Last(
		java.lang.String scannerCode,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException;

	public larion.progate.model.ProgateOrganizationsStaffs[] findByscannerCode_PrevAndNext(
		java.lang.Integer ProgateOrganizationsStaffsId,
		java.lang.String scannerCode,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException;

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findBystaffCode(
		java.lang.String staffCode) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findBystaffCode(
		java.lang.String staffCode, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findBystaffCode(
		java.lang.String staffCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateOrganizationsStaffs findBystaffCode_First(
		java.lang.String staffCode,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException;

	public larion.progate.model.ProgateOrganizationsStaffs findBystaffCode_Last(
		java.lang.String staffCode,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException;

	public larion.progate.model.ProgateOrganizationsStaffs[] findBystaffCode_PrevAndNext(
		java.lang.Integer ProgateOrganizationsStaffsId,
		java.lang.String staffCode,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException;

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByuserId(
		int userId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByuserId(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findByuserId(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateOrganizationsStaffs findByuserId_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException;

	public larion.progate.model.ProgateOrganizationsStaffs findByuserId_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException;

	public larion.progate.model.ProgateOrganizationsStaffs[] findByuserId_PrevAndNext(
		java.lang.Integer ProgateOrganizationsStaffsId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateOrganizationsStaffsException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByorgId(int orgId)
		throws com.liferay.portal.SystemException;

	public void removeByrootId(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeBybodId(int bodId)
		throws com.liferay.portal.SystemException;

	public void removeByparticipantId(int participantId)
		throws com.liferay.portal.SystemException;

	public void removeByisActive(boolean isActive)
		throws com.liferay.portal.SystemException;

	public void removeByisRemoved(boolean isRemoved)
		throws com.liferay.portal.SystemException;

	public void removeByscannerCode(java.lang.String scannerCode)
		throws com.liferay.portal.SystemException;

	public void removeBystaffCode(java.lang.String staffCode)
		throws com.liferay.portal.SystemException;

	public void removeByuserId(int userId)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByorgId(int orgId)
		throws com.liferay.portal.SystemException;

	public int countByrootId(int rootId)
		throws com.liferay.portal.SystemException;

	public int countBybodId(int bodId)
		throws com.liferay.portal.SystemException;

	public int countByparticipantId(int participantId)
		throws com.liferay.portal.SystemException;

	public int countByisActive(boolean isActive)
		throws com.liferay.portal.SystemException;

	public int countByisRemoved(boolean isRemoved)
		throws com.liferay.portal.SystemException;

	public int countByscannerCode(java.lang.String scannerCode)
		throws com.liferay.portal.SystemException;

	public int countBystaffCode(java.lang.String staffCode)
		throws com.liferay.portal.SystemException;

	public int countByuserId(int userId)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}