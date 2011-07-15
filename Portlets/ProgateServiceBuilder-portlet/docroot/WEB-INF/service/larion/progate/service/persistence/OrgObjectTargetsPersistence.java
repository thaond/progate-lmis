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
 * <a href="OrgObjectTargetsPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface OrgObjectTargetsPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.model.OrgObjectTargets orgObjectTargets);

	public void cacheResult(
		java.util.List<larion.progate.model.OrgObjectTargets> orgObjectTargetses);

	public void clearCache();

	public larion.progate.model.OrgObjectTargets create(
		java.lang.Integer orgObjectTargetId);

	public larion.progate.model.OrgObjectTargets remove(
		java.lang.Integer orgObjectTargetId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectTargetsException;

	public larion.progate.model.OrgObjectTargets remove(
		larion.progate.model.OrgObjectTargets orgObjectTargets)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectTargets update(
		larion.progate.model.OrgObjectTargets orgObjectTargets)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectTargets update(
		larion.progate.model.OrgObjectTargets orgObjectTargets, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectTargets updateImpl(
		larion.progate.model.OrgObjectTargets orgObjectTargets, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectTargets findByPrimaryKey(
		java.lang.Integer orgObjectTargetId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectTargetsException;

	public larion.progate.model.OrgObjectTargets fetchByPrimaryKey(
		java.lang.Integer orgObjectTargetId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectTargets> findByOrgObjTargetName(
		java.lang.String name) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectTargets> findByOrgObjTargetName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectTargets> findByOrgObjTargetName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectTargets findByOrgObjTargetName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectTargetsException;

	public larion.progate.model.OrgObjectTargets findByOrgObjTargetName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectTargetsException;

	public larion.progate.model.OrgObjectTargets[] findByOrgObjTargetName_PrevAndNext(
		java.lang.Integer orgObjectTargetId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectTargetsException;

	public java.util.List<larion.progate.model.OrgObjectTargets> findByorgObjectMeasureId(
		int orgObjectMeasureId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectTargets> findByorgObjectMeasureId(
		int orgObjectMeasureId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectTargets> findByorgObjectMeasureId(
		int orgObjectMeasureId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrgObjectTargets findByorgObjectMeasureId_First(
		int orgObjectMeasureId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectTargetsException;

	public larion.progate.model.OrgObjectTargets findByorgObjectMeasureId_Last(
		int orgObjectMeasureId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectTargetsException;

	public larion.progate.model.OrgObjectTargets[] findByorgObjectMeasureId_PrevAndNext(
		java.lang.Integer orgObjectTargetId, int orgObjectMeasureId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectTargetsException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectTargets> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectTargets> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectTargets> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByOrgObjTargetName(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public void removeByorgObjectMeasureId(int orgObjectMeasureId)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByOrgObjTargetName(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public int countByorgObjectMeasureId(int orgObjectMeasureId)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}