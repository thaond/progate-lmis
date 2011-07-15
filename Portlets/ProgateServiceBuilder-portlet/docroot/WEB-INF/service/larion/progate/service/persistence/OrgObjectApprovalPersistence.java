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
 * <a href="OrgObjectApprovalPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface OrgObjectApprovalPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.model.OrgObjectApproval orgObjectApproval);

	public void cacheResult(
		java.util.List<larion.progate.model.OrgObjectApproval> orgObjectApprovals);

	public void clearCache();

	public larion.progate.model.OrgObjectApproval create(
		java.lang.Integer orgObjectApprovalId);

	public larion.progate.model.OrgObjectApproval remove(
		java.lang.Integer orgObjectApprovalId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectApprovalException;

	public larion.progate.model.OrgObjectApproval remove(
		larion.progate.model.OrgObjectApproval orgObjectApproval)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectApproval update(
		larion.progate.model.OrgObjectApproval orgObjectApproval)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectApproval update(
		larion.progate.model.OrgObjectApproval orgObjectApproval, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectApproval updateImpl(
		larion.progate.model.OrgObjectApproval orgObjectApproval, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectApproval findByPrimaryKey(
		java.lang.Integer orgObjectApprovalId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectApprovalException;

	public larion.progate.model.OrgObjectApproval fetchByPrimaryKey(
		java.lang.Integer orgObjectApprovalId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectApproval> findByOrgObjApprovalUserId(
		int approved_by) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectApproval> findByOrgObjApprovalUserId(
		int approved_by, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectApproval> findByOrgObjApprovalUserId(
		int approved_by, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectApproval findByOrgObjApprovalUserId_First(
		int approved_by, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectApprovalException;

	public larion.progate.model.OrgObjectApproval findByOrgObjApprovalUserId_Last(
		int approved_by, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectApprovalException;

	public larion.progate.model.OrgObjectApproval[] findByOrgObjApprovalUserId_PrevAndNext(
		java.lang.Integer orgObjectApprovalId, int approved_by,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectApprovalException;

	public java.util.List<larion.progate.model.OrgObjectApproval> findByOrgObjApprovalStatus(
		int status) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectApproval> findByOrgObjApprovalStatus(
		int status, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectApproval> findByOrgObjApprovalStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectApproval findByOrgObjApprovalStatus_First(
		int status, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectApprovalException;

	public larion.progate.model.OrgObjectApproval findByOrgObjApprovalStatus_Last(
		int status, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectApprovalException;

	public larion.progate.model.OrgObjectApproval[] findByOrgObjApprovalStatus_PrevAndNext(
		java.lang.Integer orgObjectApprovalId, int status,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectApprovalException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectApproval> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectApproval> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectApproval> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByOrgObjApprovalUserId(int approved_by)
		throws com.liferay.portal.SystemException;

	public void removeByOrgObjApprovalStatus(int status)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByOrgObjApprovalUserId(int approved_by)
		throws com.liferay.portal.SystemException;

	public int countByOrgObjApprovalStatus(int status)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}