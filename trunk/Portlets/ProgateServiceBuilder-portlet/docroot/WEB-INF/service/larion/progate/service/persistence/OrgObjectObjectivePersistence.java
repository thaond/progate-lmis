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
 * <a href="OrgObjectObjectivePersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface OrgObjectObjectivePersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.model.OrgObjectObjective orgObjectObjective);

	public void cacheResult(
		java.util.List<larion.progate.model.OrgObjectObjective> orgObjectObjectives);

	public void clearCache();

	public larion.progate.model.OrgObjectObjective create(
		java.lang.Integer orgObjectObjectiveId);

	public larion.progate.model.OrgObjectObjective remove(
		java.lang.Integer orgObjectObjectiveId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectObjectiveException;

	public larion.progate.model.OrgObjectObjective remove(
		larion.progate.model.OrgObjectObjective orgObjectObjective)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectObjective update(
		larion.progate.model.OrgObjectObjective orgObjectObjective)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectObjective update(
		larion.progate.model.OrgObjectObjective orgObjectObjective,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectObjective updateImpl(
		larion.progate.model.OrgObjectObjective orgObjectObjective,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectObjective findByPrimaryKey(
		java.lang.Integer orgObjectObjectiveId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectObjectiveException;

	public larion.progate.model.OrgObjectObjective fetchByPrimaryKey(
		java.lang.Integer orgObjectObjectiveId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectObjective> findByOrgObjObjectiveName(
		java.lang.String name) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectObjective> findByOrgObjObjectiveName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectObjective> findByOrgObjObjectiveName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectObjective findByOrgObjObjectiveName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectObjectiveException;

	public larion.progate.model.OrgObjectObjective findByOrgObjObjectiveName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectObjectiveException;

	public larion.progate.model.OrgObjectObjective[] findByOrgObjObjectiveName_PrevAndNext(
		java.lang.Integer orgObjectObjectiveId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectObjectiveException;

	public java.util.List<larion.progate.model.OrgObjectObjective> findByorgObjectPerspectiveId(
		int orgObjectPerspectiveId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectObjective> findByorgObjectPerspectiveId(
		int orgObjectPerspectiveId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectObjective> findByorgObjectPerspectiveId(
		int orgObjectPerspectiveId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectObjective findByorgObjectPerspectiveId_First(
		int orgObjectPerspectiveId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectObjectiveException;

	public larion.progate.model.OrgObjectObjective findByorgObjectPerspectiveId_Last(
		int orgObjectPerspectiveId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectObjectiveException;

	public larion.progate.model.OrgObjectObjective[] findByorgObjectPerspectiveId_PrevAndNext(
		java.lang.Integer orgObjectObjectiveId, int orgObjectPerspectiveId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectObjectiveException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectObjective> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectObjective> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectObjective> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByOrgObjObjectiveName(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public void removeByorgObjectPerspectiveId(int orgObjectPerspectiveId)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByOrgObjObjectiveName(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public int countByorgObjectPerspectiveId(int orgObjectPerspectiveId)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectMeasure> getOrgObjectMeasures(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectMeasure> getOrgObjectMeasures(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectMeasure> getOrgObjectMeasures(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getOrgObjectMeasuresSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsOrgObjectMeasure(java.lang.Integer pk,
		java.lang.Integer orgObjectMeasurePK)
		throws com.liferay.portal.SystemException;

	public boolean containsOrgObjectMeasures(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;
}