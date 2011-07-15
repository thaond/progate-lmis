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
 * <a href="OrgObjectPerspectivePersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface OrgObjectPerspectivePersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.model.OrgObjectPerspective orgObjectPerspective);

	public void cacheResult(
		java.util.List<larion.progate.model.OrgObjectPerspective> orgObjectPerspectives);

	public void clearCache();

	public larion.progate.model.OrgObjectPerspective create(
		java.lang.Integer orgObjectPerspectiveId);

	public larion.progate.model.OrgObjectPerspective remove(
		java.lang.Integer orgObjectPerspectiveId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectPerspectiveException;

	public larion.progate.model.OrgObjectPerspective remove(
		larion.progate.model.OrgObjectPerspective orgObjectPerspective)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectPerspective update(
		larion.progate.model.OrgObjectPerspective orgObjectPerspective)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectPerspective update(
		larion.progate.model.OrgObjectPerspective orgObjectPerspective,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectPerspective updateImpl(
		larion.progate.model.OrgObjectPerspective orgObjectPerspective,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectPerspective findByPrimaryKey(
		java.lang.Integer orgObjectPerspectiveId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectPerspectiveException;

	public larion.progate.model.OrgObjectPerspective fetchByPrimaryKey(
		java.lang.Integer orgObjectPerspectiveId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectPerspective> findByOrgObjPerspectiveName(
		java.lang.String name) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectPerspective> findByOrgObjPerspectiveName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectPerspective> findByOrgObjPerspectiveName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectPerspective findByOrgObjPerspectiveName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectPerspectiveException;

	public larion.progate.model.OrgObjectPerspective findByOrgObjPerspectiveName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectPerspectiveException;

	public larion.progate.model.OrgObjectPerspective[] findByOrgObjPerspectiveName_PrevAndNext(
		java.lang.Integer orgObjectPerspectiveId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectPerspectiveException;

	public java.util.List<larion.progate.model.OrgObjectPerspective> findByOrgObjType(
		int pertype) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectPerspective> findByOrgObjType(
		int pertype, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectPerspective> findByOrgObjType(
		int pertype, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectPerspective findByOrgObjType_First(
		int pertype, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectPerspectiveException;

	public larion.progate.model.OrgObjectPerspective findByOrgObjType_Last(
		int pertype, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectPerspectiveException;

	public larion.progate.model.OrgObjectPerspective[] findByOrgObjType_PrevAndNext(
		java.lang.Integer orgObjectPerspectiveId, int pertype,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectPerspectiveException;

	public java.util.List<larion.progate.model.OrgObjectPerspective> findByorgObjectListId(
		int orgObjectListId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectPerspective> findByorgObjectListId(
		int orgObjectListId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectPerspective> findByorgObjectListId(
		int orgObjectListId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectPerspective findByorgObjectListId_First(
		int orgObjectListId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectPerspectiveException;

	public larion.progate.model.OrgObjectPerspective findByorgObjectListId_Last(
		int orgObjectListId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectPerspectiveException;

	public larion.progate.model.OrgObjectPerspective[] findByorgObjectListId_PrevAndNext(
		java.lang.Integer orgObjectPerspectiveId, int orgObjectListId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectPerspectiveException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectPerspective> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectPerspective> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectPerspective> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByOrgObjPerspectiveName(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public void removeByOrgObjType(int pertype)
		throws com.liferay.portal.SystemException;

	public void removeByorgObjectListId(int orgObjectListId)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByOrgObjPerspectiveName(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public int countByOrgObjType(int pertype)
		throws com.liferay.portal.SystemException;

	public int countByorgObjectListId(int orgObjectListId)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectObjective> getOrgObjectObjectives(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectObjective> getOrgObjectObjectives(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectObjective> getOrgObjectObjectives(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getOrgObjectObjectivesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsOrgObjectObjective(java.lang.Integer pk,
		java.lang.Integer orgObjectObjectivePK)
		throws com.liferay.portal.SystemException;

	public boolean containsOrgObjectObjectives(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;
}