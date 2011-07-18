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
 * <a href="OrgObjectListUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectListUtil {
	public static void cacheResult(
		larion.progate.model.OrgObjectList orgObjectList) {
		getPersistence().cacheResult(orgObjectList);
	}

	public static void cacheResult(
		java.util.List<larion.progate.model.OrgObjectList> orgObjectLists) {
		getPersistence().cacheResult(orgObjectLists);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.model.OrgObjectList create(
		java.lang.Integer orgObjectListId) {
		return getPersistence().create(orgObjectListId);
	}

	public static larion.progate.model.OrgObjectList remove(
		java.lang.Integer orgObjectListId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectListException {
		return getPersistence().remove(orgObjectListId);
	}

	public static larion.progate.model.OrgObjectList remove(
		larion.progate.model.OrgObjectList orgObjectList)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(orgObjectList);
	}

	public static larion.progate.model.OrgObjectList update(
		larion.progate.model.OrgObjectList orgObjectList)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(orgObjectList);
	}

	public static larion.progate.model.OrgObjectList update(
		larion.progate.model.OrgObjectList orgObjectList, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(orgObjectList, merge);
	}

	public static larion.progate.model.OrgObjectList updateImpl(
		larion.progate.model.OrgObjectList orgObjectList, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(orgObjectList, merge);
	}

	public static larion.progate.model.OrgObjectList findByPrimaryKey(
		java.lang.Integer orgObjectListId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectListException {
		return getPersistence().findByPrimaryKey(orgObjectListId);
	}

	public static larion.progate.model.OrgObjectList fetchByPrimaryKey(
		java.lang.Integer orgObjectListId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(orgObjectListId);
	}

	public static java.util.List<larion.progate.model.OrgObjectList> findByOrgId(
		int org_id) throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgId(org_id);
	}

	public static java.util.List<larion.progate.model.OrgObjectList> findByOrgId(
		int org_id, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgId(org_id, start, end);
	}

	public static java.util.List<larion.progate.model.OrgObjectList> findByOrgId(
		int org_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgId(org_id, start, end, obc);
	}

	public static larion.progate.model.OrgObjectList findByOrgId_First(
		int org_id, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectListException {
		return getPersistence().findByOrgId_First(org_id, obc);
	}

	public static larion.progate.model.OrgObjectList findByOrgId_Last(
		int org_id, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectListException {
		return getPersistence().findByOrgId_Last(org_id, obc);
	}

	public static larion.progate.model.OrgObjectList[] findByOrgId_PrevAndNext(
		java.lang.Integer orgObjectListId, int org_id,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectListException {
		return getPersistence()
				   .findByOrgId_PrevAndNext(orgObjectListId, org_id, obc);
	}

	public static java.util.List<larion.progate.model.OrgObjectList> findByOrgObjName(
		java.lang.String name) throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgObjName(name);
	}

	public static java.util.List<larion.progate.model.OrgObjectList> findByOrgObjName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgObjName(name, start, end);
	}

	public static java.util.List<larion.progate.model.OrgObjectList> findByOrgObjName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgObjName(name, start, end, obc);
	}

	public static larion.progate.model.OrgObjectList findByOrgObjName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectListException {
		return getPersistence().findByOrgObjName_First(name, obc);
	}

	public static larion.progate.model.OrgObjectList findByOrgObjName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectListException {
		return getPersistence().findByOrgObjName_Last(name, obc);
	}

	public static larion.progate.model.OrgObjectList[] findByOrgObjName_PrevAndNext(
		java.lang.Integer orgObjectListId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectListException {
		return getPersistence()
				   .findByOrgObjName_PrevAndNext(orgObjectListId, name, obc);
	}

	public static java.util.List<larion.progate.model.OrgObjectList> findByOrgObjType(
		int objtype) throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgObjType(objtype);
	}

	public static java.util.List<larion.progate.model.OrgObjectList> findByOrgObjType(
		int objtype, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgObjType(objtype, start, end);
	}

	public static java.util.List<larion.progate.model.OrgObjectList> findByOrgObjType(
		int objtype, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgObjType(objtype, start, end, obc);
	}

	public static larion.progate.model.OrgObjectList findByOrgObjType_First(
		int objtype, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectListException {
		return getPersistence().findByOrgObjType_First(objtype, obc);
	}

	public static larion.progate.model.OrgObjectList findByOrgObjType_Last(
		int objtype, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectListException {
		return getPersistence().findByOrgObjType_Last(objtype, obc);
	}

	public static larion.progate.model.OrgObjectList[] findByOrgObjType_PrevAndNext(
		java.lang.Integer orgObjectListId, int objtype,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectListException {
		return getPersistence()
				   .findByOrgObjType_PrevAndNext(orgObjectListId, objtype, obc);
	}

	public static java.util.List<larion.progate.model.OrgObjectList> findByOrgObjYear(
		int year) throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgObjYear(year);
	}

	public static java.util.List<larion.progate.model.OrgObjectList> findByOrgObjYear(
		int year, int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgObjYear(year, start, end);
	}

	public static java.util.List<larion.progate.model.OrgObjectList> findByOrgObjYear(
		int year, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgObjYear(year, start, end, obc);
	}

	public static larion.progate.model.OrgObjectList findByOrgObjYear_First(
		int year, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectListException {
		return getPersistence().findByOrgObjYear_First(year, obc);
	}

	public static larion.progate.model.OrgObjectList findByOrgObjYear_Last(
		int year, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectListException {
		return getPersistence().findByOrgObjYear_Last(year, obc);
	}

	public static larion.progate.model.OrgObjectList[] findByOrgObjYear_PrevAndNext(
		java.lang.Integer orgObjectListId, int year,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectListException {
		return getPersistence()
				   .findByOrgObjYear_PrevAndNext(orgObjectListId, year, obc);
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

	public static java.util.List<larion.progate.model.OrgObjectList> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.model.OrgObjectList> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.model.OrgObjectList> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByOrgId(int org_id)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByOrgId(org_id);
	}

	public static void removeByOrgObjName(java.lang.String name)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByOrgObjName(name);
	}

	public static void removeByOrgObjType(int objtype)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByOrgObjType(objtype);
	}

	public static void removeByOrgObjYear(int year)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByOrgObjYear(year);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByOrgId(int org_id)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByOrgId(org_id);
	}

	public static int countByOrgObjName(java.lang.String name)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByOrgObjName(name);
	}

	public static int countByOrgObjType(int objtype)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByOrgObjType(objtype);
	}

	public static int countByOrgObjYear(int year)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByOrgObjYear(year);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static java.util.List<larion.progate.model.OrgObjectApproval> getOrgObjectApprovals(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getOrgObjectApprovals(pk);
	}

	public static java.util.List<larion.progate.model.OrgObjectApproval> getOrgObjectApprovals(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getOrgObjectApprovals(pk, start, end);
	}

	public static java.util.List<larion.progate.model.OrgObjectApproval> getOrgObjectApprovals(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().getOrgObjectApprovals(pk, start, end, obc);
	}

	public static int getOrgObjectApprovalsSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().getOrgObjectApprovalsSize(pk);
	}

	public static boolean containsOrgObjectApproval(java.lang.Integer pk,
		java.lang.Integer orgObjectApprovalPK)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .containsOrgObjectApproval(pk, orgObjectApprovalPK);
	}

	public static boolean containsOrgObjectApprovals(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().containsOrgObjectApprovals(pk);
	}

	public static java.util.List<larion.progate.model.OrgObjectPerspective> getOrgObjectPerspectives(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getOrgObjectPerspectives(pk);
	}

	public static java.util.List<larion.progate.model.OrgObjectPerspective> getOrgObjectPerspectives(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getOrgObjectPerspectives(pk, start, end);
	}

	public static java.util.List<larion.progate.model.OrgObjectPerspective> getOrgObjectPerspectives(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().getOrgObjectPerspectives(pk, start, end, obc);
	}

	public static int getOrgObjectPerspectivesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().getOrgObjectPerspectivesSize(pk);
	}

	public static boolean containsOrgObjectPerspective(java.lang.Integer pk,
		java.lang.Integer orgObjectPerspectivePK)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .containsOrgObjectPerspective(pk, orgObjectPerspectivePK);
	}

	public static boolean containsOrgObjectPerspectives(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().containsOrgObjectPerspectives(pk);
	}

	public static OrgObjectListPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(OrgObjectListPersistence persistence) {
		_persistence = persistence;
	}

	private static OrgObjectListPersistence _persistence;
}