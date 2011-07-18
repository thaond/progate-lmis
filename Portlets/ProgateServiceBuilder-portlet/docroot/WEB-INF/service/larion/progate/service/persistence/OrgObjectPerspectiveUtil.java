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
 * <a href="OrgObjectPerspectiveUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectPerspectiveUtil {
	public static void cacheResult(
		larion.progate.model.OrgObjectPerspective orgObjectPerspective) {
		getPersistence().cacheResult(orgObjectPerspective);
	}

	public static void cacheResult(
		java.util.List<larion.progate.model.OrgObjectPerspective> orgObjectPerspectives) {
		getPersistence().cacheResult(orgObjectPerspectives);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.model.OrgObjectPerspective create(
		java.lang.Integer orgObjectPerspectiveId) {
		return getPersistence().create(orgObjectPerspectiveId);
	}

	public static larion.progate.model.OrgObjectPerspective remove(
		java.lang.Integer orgObjectPerspectiveId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectPerspectiveException {
		return getPersistence().remove(orgObjectPerspectiveId);
	}

	public static larion.progate.model.OrgObjectPerspective remove(
		larion.progate.model.OrgObjectPerspective orgObjectPerspective)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(orgObjectPerspective);
	}

	public static larion.progate.model.OrgObjectPerspective update(
		larion.progate.model.OrgObjectPerspective orgObjectPerspective)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(orgObjectPerspective);
	}

	public static larion.progate.model.OrgObjectPerspective update(
		larion.progate.model.OrgObjectPerspective orgObjectPerspective,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(orgObjectPerspective, merge);
	}

	public static larion.progate.model.OrgObjectPerspective updateImpl(
		larion.progate.model.OrgObjectPerspective orgObjectPerspective,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(orgObjectPerspective, merge);
	}

	public static larion.progate.model.OrgObjectPerspective findByPrimaryKey(
		java.lang.Integer orgObjectPerspectiveId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectPerspectiveException {
		return getPersistence().findByPrimaryKey(orgObjectPerspectiveId);
	}

	public static larion.progate.model.OrgObjectPerspective fetchByPrimaryKey(
		java.lang.Integer orgObjectPerspectiveId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(orgObjectPerspectiveId);
	}

	public static java.util.List<larion.progate.model.OrgObjectPerspective> findByOrgObjPerspectiveName(
		java.lang.String name) throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgObjPerspectiveName(name);
	}

	public static java.util.List<larion.progate.model.OrgObjectPerspective> findByOrgObjPerspectiveName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgObjPerspectiveName(name, start, end);
	}

	public static java.util.List<larion.progate.model.OrgObjectPerspective> findByOrgObjPerspectiveName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByOrgObjPerspectiveName(name, start, end, obc);
	}

	public static larion.progate.model.OrgObjectPerspective findByOrgObjPerspectiveName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectPerspectiveException {
		return getPersistence().findByOrgObjPerspectiveName_First(name, obc);
	}

	public static larion.progate.model.OrgObjectPerspective findByOrgObjPerspectiveName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectPerspectiveException {
		return getPersistence().findByOrgObjPerspectiveName_Last(name, obc);
	}

	public static larion.progate.model.OrgObjectPerspective[] findByOrgObjPerspectiveName_PrevAndNext(
		java.lang.Integer orgObjectPerspectiveId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectPerspectiveException {
		return getPersistence()
				   .findByOrgObjPerspectiveName_PrevAndNext(orgObjectPerspectiveId,
			name, obc);
	}

	public static java.util.List<larion.progate.model.OrgObjectPerspective> findByOrgObjType(
		int pertype) throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgObjType(pertype);
	}

	public static java.util.List<larion.progate.model.OrgObjectPerspective> findByOrgObjType(
		int pertype, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgObjType(pertype, start, end);
	}

	public static java.util.List<larion.progate.model.OrgObjectPerspective> findByOrgObjType(
		int pertype, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgObjType(pertype, start, end, obc);
	}

	public static larion.progate.model.OrgObjectPerspective findByOrgObjType_First(
		int pertype, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectPerspectiveException {
		return getPersistence().findByOrgObjType_First(pertype, obc);
	}

	public static larion.progate.model.OrgObjectPerspective findByOrgObjType_Last(
		int pertype, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectPerspectiveException {
		return getPersistence().findByOrgObjType_Last(pertype, obc);
	}

	public static larion.progate.model.OrgObjectPerspective[] findByOrgObjType_PrevAndNext(
		java.lang.Integer orgObjectPerspectiveId, int pertype,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectPerspectiveException {
		return getPersistence()
				   .findByOrgObjType_PrevAndNext(orgObjectPerspectiveId,
			pertype, obc);
	}

	public static java.util.List<larion.progate.model.OrgObjectPerspective> findByorgObjectListId(
		int orgObjectListId) throws com.liferay.portal.SystemException {
		return getPersistence().findByorgObjectListId(orgObjectListId);
	}

	public static java.util.List<larion.progate.model.OrgObjectPerspective> findByorgObjectListId(
		int orgObjectListId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByorgObjectListId(orgObjectListId, start, end);
	}

	public static java.util.List<larion.progate.model.OrgObjectPerspective> findByorgObjectListId(
		int orgObjectListId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByorgObjectListId(orgObjectListId, start, end, obc);
	}

	public static larion.progate.model.OrgObjectPerspective findByorgObjectListId_First(
		int orgObjectListId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectPerspectiveException {
		return getPersistence().findByorgObjectListId_First(orgObjectListId, obc);
	}

	public static larion.progate.model.OrgObjectPerspective findByorgObjectListId_Last(
		int orgObjectListId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectPerspectiveException {
		return getPersistence().findByorgObjectListId_Last(orgObjectListId, obc);
	}

	public static larion.progate.model.OrgObjectPerspective[] findByorgObjectListId_PrevAndNext(
		java.lang.Integer orgObjectPerspectiveId, int orgObjectListId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectPerspectiveException {
		return getPersistence()
				   .findByorgObjectListId_PrevAndNext(orgObjectPerspectiveId,
			orgObjectListId, obc);
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

	public static java.util.List<larion.progate.model.OrgObjectPerspective> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.model.OrgObjectPerspective> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.model.OrgObjectPerspective> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByOrgObjPerspectiveName(java.lang.String name)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByOrgObjPerspectiveName(name);
	}

	public static void removeByOrgObjType(int pertype)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByOrgObjType(pertype);
	}

	public static void removeByorgObjectListId(int orgObjectListId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByorgObjectListId(orgObjectListId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByOrgObjPerspectiveName(java.lang.String name)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByOrgObjPerspectiveName(name);
	}

	public static int countByOrgObjType(int pertype)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByOrgObjType(pertype);
	}

	public static int countByorgObjectListId(int orgObjectListId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByorgObjectListId(orgObjectListId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static java.util.List<larion.progate.model.OrgObjectObjective> getOrgObjectObjectives(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getOrgObjectObjectives(pk);
	}

	public static java.util.List<larion.progate.model.OrgObjectObjective> getOrgObjectObjectives(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getOrgObjectObjectives(pk, start, end);
	}

	public static java.util.List<larion.progate.model.OrgObjectObjective> getOrgObjectObjectives(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().getOrgObjectObjectives(pk, start, end, obc);
	}

	public static int getOrgObjectObjectivesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().getOrgObjectObjectivesSize(pk);
	}

	public static boolean containsOrgObjectObjective(java.lang.Integer pk,
		java.lang.Integer orgObjectObjectivePK)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .containsOrgObjectObjective(pk, orgObjectObjectivePK);
	}

	public static boolean containsOrgObjectObjectives(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().containsOrgObjectObjectives(pk);
	}

	public static OrgObjectPerspectivePersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(OrgObjectPerspectivePersistence persistence) {
		_persistence = persistence;
	}

	private static OrgObjectPerspectivePersistence _persistence;
}