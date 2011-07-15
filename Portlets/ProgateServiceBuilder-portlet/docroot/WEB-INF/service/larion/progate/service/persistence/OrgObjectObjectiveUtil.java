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
 * <a href="OrgObjectObjectiveUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectObjectiveUtil {
	public static void cacheResult(
		larion.progate.model.OrgObjectObjective orgObjectObjective) {
		getPersistence().cacheResult(orgObjectObjective);
	}

	public static void cacheResult(
		java.util.List<larion.progate.model.OrgObjectObjective> orgObjectObjectives) {
		getPersistence().cacheResult(orgObjectObjectives);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.model.OrgObjectObjective create(
		java.lang.Integer orgObjectObjectiveId) {
		return getPersistence().create(orgObjectObjectiveId);
	}

	public static larion.progate.model.OrgObjectObjective remove(
		java.lang.Integer orgObjectObjectiveId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectObjectiveException {
		return getPersistence().remove(orgObjectObjectiveId);
	}

	public static larion.progate.model.OrgObjectObjective remove(
		larion.progate.model.OrgObjectObjective orgObjectObjective)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(orgObjectObjective);
	}

	public static larion.progate.model.OrgObjectObjective update(
		larion.progate.model.OrgObjectObjective orgObjectObjective)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(orgObjectObjective);
	}

	public static larion.progate.model.OrgObjectObjective update(
		larion.progate.model.OrgObjectObjective orgObjectObjective,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(orgObjectObjective, merge);
	}

	public static larion.progate.model.OrgObjectObjective updateImpl(
		larion.progate.model.OrgObjectObjective orgObjectObjective,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(orgObjectObjective, merge);
	}

	public static larion.progate.model.OrgObjectObjective findByPrimaryKey(
		java.lang.Integer orgObjectObjectiveId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectObjectiveException {
		return getPersistence().findByPrimaryKey(orgObjectObjectiveId);
	}

	public static larion.progate.model.OrgObjectObjective fetchByPrimaryKey(
		java.lang.Integer orgObjectObjectiveId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(orgObjectObjectiveId);
	}

	public static java.util.List<larion.progate.model.OrgObjectObjective> findByOrgObjObjectiveName(
		java.lang.String name) throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgObjObjectiveName(name);
	}

	public static java.util.List<larion.progate.model.OrgObjectObjective> findByOrgObjObjectiveName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgObjObjectiveName(name, start, end);
	}

	public static java.util.List<larion.progate.model.OrgObjectObjective> findByOrgObjObjectiveName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgObjObjectiveName(name, start, end, obc);
	}

	public static larion.progate.model.OrgObjectObjective findByOrgObjObjectiveName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectObjectiveException {
		return getPersistence().findByOrgObjObjectiveName_First(name, obc);
	}

	public static larion.progate.model.OrgObjectObjective findByOrgObjObjectiveName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectObjectiveException {
		return getPersistence().findByOrgObjObjectiveName_Last(name, obc);
	}

	public static larion.progate.model.OrgObjectObjective[] findByOrgObjObjectiveName_PrevAndNext(
		java.lang.Integer orgObjectObjectiveId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectObjectiveException {
		return getPersistence()
				   .findByOrgObjObjectiveName_PrevAndNext(orgObjectObjectiveId,
			name, obc);
	}

	public static java.util.List<larion.progate.model.OrgObjectObjective> findByorgObjectPerspectiveId(
		int orgObjectPerspectiveId) throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByorgObjectPerspectiveId(orgObjectPerspectiveId);
	}

	public static java.util.List<larion.progate.model.OrgObjectObjective> findByorgObjectPerspectiveId(
		int orgObjectPerspectiveId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByorgObjectPerspectiveId(orgObjectPerspectiveId, start,
			end);
	}

	public static java.util.List<larion.progate.model.OrgObjectObjective> findByorgObjectPerspectiveId(
		int orgObjectPerspectiveId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByorgObjectPerspectiveId(orgObjectPerspectiveId, start,
			end, obc);
	}

	public static larion.progate.model.OrgObjectObjective findByorgObjectPerspectiveId_First(
		int orgObjectPerspectiveId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectObjectiveException {
		return getPersistence()
				   .findByorgObjectPerspectiveId_First(orgObjectPerspectiveId,
			obc);
	}

	public static larion.progate.model.OrgObjectObjective findByorgObjectPerspectiveId_Last(
		int orgObjectPerspectiveId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectObjectiveException {
		return getPersistence()
				   .findByorgObjectPerspectiveId_Last(orgObjectPerspectiveId,
			obc);
	}

	public static larion.progate.model.OrgObjectObjective[] findByorgObjectPerspectiveId_PrevAndNext(
		java.lang.Integer orgObjectObjectiveId, int orgObjectPerspectiveId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectObjectiveException {
		return getPersistence()
				   .findByorgObjectPerspectiveId_PrevAndNext(orgObjectObjectiveId,
			orgObjectPerspectiveId, obc);
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

	public static java.util.List<larion.progate.model.OrgObjectObjective> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.model.OrgObjectObjective> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.model.OrgObjectObjective> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByOrgObjObjectiveName(java.lang.String name)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByOrgObjObjectiveName(name);
	}

	public static void removeByorgObjectPerspectiveId(
		int orgObjectPerspectiveId) throws com.liferay.portal.SystemException {
		getPersistence().removeByorgObjectPerspectiveId(orgObjectPerspectiveId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByOrgObjObjectiveName(java.lang.String name)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByOrgObjObjectiveName(name);
	}

	public static int countByorgObjectPerspectiveId(int orgObjectPerspectiveId)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .countByorgObjectPerspectiveId(orgObjectPerspectiveId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static java.util.List<larion.progate.model.OrgObjectMeasure> getOrgObjectMeasures(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getOrgObjectMeasures(pk);
	}

	public static java.util.List<larion.progate.model.OrgObjectMeasure> getOrgObjectMeasures(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getOrgObjectMeasures(pk, start, end);
	}

	public static java.util.List<larion.progate.model.OrgObjectMeasure> getOrgObjectMeasures(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().getOrgObjectMeasures(pk, start, end, obc);
	}

	public static int getOrgObjectMeasuresSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().getOrgObjectMeasuresSize(pk);
	}

	public static boolean containsOrgObjectMeasure(java.lang.Integer pk,
		java.lang.Integer orgObjectMeasurePK)
		throws com.liferay.portal.SystemException {
		return getPersistence().containsOrgObjectMeasure(pk, orgObjectMeasurePK);
	}

	public static boolean containsOrgObjectMeasures(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().containsOrgObjectMeasures(pk);
	}

	public static OrgObjectObjectivePersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(OrgObjectObjectivePersistence persistence) {
		_persistence = persistence;
	}

	private static OrgObjectObjectivePersistence _persistence;
}