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
 * <a href="OrgObjectMeasurePersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface OrgObjectMeasurePersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.model.OrgObjectMeasure orgObjectMeasure);

	public void cacheResult(
		java.util.List<larion.progate.model.OrgObjectMeasure> orgObjectMeasures);

	public void clearCache();

	public larion.progate.model.OrgObjectMeasure create(
		java.lang.Integer orgObjectMeasureId);

	public larion.progate.model.OrgObjectMeasure remove(
		java.lang.Integer orgObjectMeasureId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectMeasureException;

	public larion.progate.model.OrgObjectMeasure remove(
		larion.progate.model.OrgObjectMeasure orgObjectMeasure)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectMeasure update(
		larion.progate.model.OrgObjectMeasure orgObjectMeasure)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectMeasure update(
		larion.progate.model.OrgObjectMeasure orgObjectMeasure, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectMeasure updateImpl(
		larion.progate.model.OrgObjectMeasure orgObjectMeasure, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectMeasure findByPrimaryKey(
		java.lang.Integer orgObjectMeasureId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectMeasureException;

	public larion.progate.model.OrgObjectMeasure fetchByPrimaryKey(
		java.lang.Integer orgObjectMeasureId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectMeasure> findByOrgObjMeasureName(
		java.lang.String name) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectMeasure> findByOrgObjMeasureName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectMeasure> findByOrgObjMeasureName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectMeasure findByOrgObjMeasureName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectMeasureException;

	public larion.progate.model.OrgObjectMeasure findByOrgObjMeasureName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectMeasureException;

	public larion.progate.model.OrgObjectMeasure[] findByOrgObjMeasureName_PrevAndNext(
		java.lang.Integer orgObjectMeasureId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectMeasureException;

	public java.util.List<larion.progate.model.OrgObjectMeasure> findByOrgObjectObjectiveId(
		int OrgObjectObjectiveId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectMeasure> findByOrgObjectObjectiveId(
		int OrgObjectObjectiveId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectMeasure> findByOrgObjectObjectiveId(
		int OrgObjectObjectiveId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectMeasure findByOrgObjectObjectiveId_First(
		int OrgObjectObjectiveId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectMeasureException;

	public larion.progate.model.OrgObjectMeasure findByOrgObjectObjectiveId_Last(
		int OrgObjectObjectiveId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectMeasureException;

	public larion.progate.model.OrgObjectMeasure[] findByOrgObjectObjectiveId_PrevAndNext(
		java.lang.Integer orgObjectMeasureId, int OrgObjectObjectiveId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectMeasureException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectMeasure> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectMeasure> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectMeasure> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByOrgObjMeasureName(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public void removeByOrgObjectObjectiveId(int OrgObjectObjectiveId)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByOrgObjMeasureName(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public int countByOrgObjectObjectiveId(int OrgObjectObjectiveId)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectTargets> getOrgObjectTargetses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectTargets> getOrgObjectTargetses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectTargets> getOrgObjectTargetses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getOrgObjectTargetsesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsOrgObjectTargets(java.lang.Integer pk,
		java.lang.Integer orgObjectTargetsPK)
		throws com.liferay.portal.SystemException;

	public boolean containsOrgObjectTargetses(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;
}