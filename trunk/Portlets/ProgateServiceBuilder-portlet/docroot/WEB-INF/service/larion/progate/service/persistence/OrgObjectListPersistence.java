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
 * <a href="OrgObjectListPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface OrgObjectListPersistence extends BasePersistence {
	public void cacheResult(larion.progate.model.OrgObjectList orgObjectList);

	public void cacheResult(
		java.util.List<larion.progate.model.OrgObjectList> orgObjectLists);

	public void clearCache();

	public larion.progate.model.OrgObjectList create(
		java.lang.Integer orgObjectListId);

	public larion.progate.model.OrgObjectList remove(
		java.lang.Integer orgObjectListId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectListException;

	public larion.progate.model.OrgObjectList remove(
		larion.progate.model.OrgObjectList orgObjectList)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectList update(
		larion.progate.model.OrgObjectList orgObjectList)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectList update(
		larion.progate.model.OrgObjectList orgObjectList, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectList updateImpl(
		larion.progate.model.OrgObjectList orgObjectList, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectList findByPrimaryKey(
		java.lang.Integer orgObjectListId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectListException;

	public larion.progate.model.OrgObjectList fetchByPrimaryKey(
		java.lang.Integer orgObjectListId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectList> findByOrgId(
		int org_id) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectList> findByOrgId(
		int org_id, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectList> findByOrgId(
		int org_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectList findByOrgId_First(int org_id,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectListException;

	public larion.progate.model.OrgObjectList findByOrgId_Last(int org_id,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectListException;

	public larion.progate.model.OrgObjectList[] findByOrgId_PrevAndNext(
		java.lang.Integer orgObjectListId, int org_id,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectListException;

	public java.util.List<larion.progate.model.OrgObjectList> findByOrgObjName(
		java.lang.String name) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectList> findByOrgObjName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectList> findByOrgObjName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectList findByOrgObjName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectListException;

	public larion.progate.model.OrgObjectList findByOrgObjName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectListException;

	public larion.progate.model.OrgObjectList[] findByOrgObjName_PrevAndNext(
		java.lang.Integer orgObjectListId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectListException;

	public java.util.List<larion.progate.model.OrgObjectList> findByOrgObjType(
		int objtype) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectList> findByOrgObjType(
		int objtype, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectList> findByOrgObjType(
		int objtype, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectList findByOrgObjType_First(
		int objtype, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectListException;

	public larion.progate.model.OrgObjectList findByOrgObjType_Last(
		int objtype, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectListException;

	public larion.progate.model.OrgObjectList[] findByOrgObjType_PrevAndNext(
		java.lang.Integer orgObjectListId, int objtype,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectListException;

	public java.util.List<larion.progate.model.OrgObjectList> findByOrgObjYear(
		int year) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectList> findByOrgObjYear(
		int year, int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectList> findByOrgObjYear(
		int year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectList findByOrgObjYear_First(int year,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectListException;

	public larion.progate.model.OrgObjectList findByOrgObjYear_Last(int year,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectListException;

	public larion.progate.model.OrgObjectList[] findByOrgObjYear_PrevAndNext(
		java.lang.Integer orgObjectListId, int year,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectListException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectList> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectList> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectList> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByOrgId(int org_id)
		throws com.liferay.portal.SystemException;

	public void removeByOrgObjName(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public void removeByOrgObjType(int objtype)
		throws com.liferay.portal.SystemException;

	public void removeByOrgObjYear(int year)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByOrgId(int org_id)
		throws com.liferay.portal.SystemException;

	public int countByOrgObjName(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public int countByOrgObjType(int objtype)
		throws com.liferay.portal.SystemException;

	public int countByOrgObjYear(int year)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectApproval> getOrgObjectApprovals(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectApproval> getOrgObjectApprovals(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectApproval> getOrgObjectApprovals(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getOrgObjectApprovalsSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsOrgObjectApproval(java.lang.Integer pk,
		java.lang.Integer orgObjectApprovalPK)
		throws com.liferay.portal.SystemException;

	public boolean containsOrgObjectApprovals(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectPerspective> getOrgObjectPerspectives(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectPerspective> getOrgObjectPerspectives(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectPerspective> getOrgObjectPerspectives(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getOrgObjectPerspectivesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsOrgObjectPerspective(java.lang.Integer pk,
		java.lang.Integer orgObjectPerspectivePK)
		throws com.liferay.portal.SystemException;

	public boolean containsOrgObjectPerspectives(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;
}