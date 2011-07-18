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
 * <a href="OrgObjectTargetsUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectTargetsUtil {
	public static void cacheResult(
		larion.progate.model.OrgObjectTargets orgObjectTargets) {
		getPersistence().cacheResult(orgObjectTargets);
	}

	public static void cacheResult(
		java.util.List<larion.progate.model.OrgObjectTargets> orgObjectTargetses) {
		getPersistence().cacheResult(orgObjectTargetses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.model.OrgObjectTargets create(
		java.lang.Integer orgObjectTargetId) {
		return getPersistence().create(orgObjectTargetId);
	}

	public static larion.progate.model.OrgObjectTargets remove(
		java.lang.Integer orgObjectTargetId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectTargetsException {
		return getPersistence().remove(orgObjectTargetId);
	}

	public static larion.progate.model.OrgObjectTargets remove(
		larion.progate.model.OrgObjectTargets orgObjectTargets)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(orgObjectTargets);
	}

	public static larion.progate.model.OrgObjectTargets update(
		larion.progate.model.OrgObjectTargets orgObjectTargets)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(orgObjectTargets);
	}

	public static larion.progate.model.OrgObjectTargets update(
		larion.progate.model.OrgObjectTargets orgObjectTargets, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(orgObjectTargets, merge);
	}

	public static larion.progate.model.OrgObjectTargets updateImpl(
		larion.progate.model.OrgObjectTargets orgObjectTargets, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(orgObjectTargets, merge);
	}

	public static larion.progate.model.OrgObjectTargets findByPrimaryKey(
		java.lang.Integer orgObjectTargetId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectTargetsException {
		return getPersistence().findByPrimaryKey(orgObjectTargetId);
	}

	public static larion.progate.model.OrgObjectTargets fetchByPrimaryKey(
		java.lang.Integer orgObjectTargetId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(orgObjectTargetId);
	}

	public static java.util.List<larion.progate.model.OrgObjectTargets> findByOrgObjTargetName(
		java.lang.String name) throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgObjTargetName(name);
	}

	public static java.util.List<larion.progate.model.OrgObjectTargets> findByOrgObjTargetName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgObjTargetName(name, start, end);
	}

	public static java.util.List<larion.progate.model.OrgObjectTargets> findByOrgObjTargetName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgObjTargetName(name, start, end, obc);
	}

	public static larion.progate.model.OrgObjectTargets findByOrgObjTargetName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectTargetsException {
		return getPersistence().findByOrgObjTargetName_First(name, obc);
	}

	public static larion.progate.model.OrgObjectTargets findByOrgObjTargetName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectTargetsException {
		return getPersistence().findByOrgObjTargetName_Last(name, obc);
	}

	public static larion.progate.model.OrgObjectTargets[] findByOrgObjTargetName_PrevAndNext(
		java.lang.Integer orgObjectTargetId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectTargetsException {
		return getPersistence()
				   .findByOrgObjTargetName_PrevAndNext(orgObjectTargetId, name,
			obc);
	}

	public static java.util.List<larion.progate.model.OrgObjectTargets> findByorgObjectMeasureId(
		int orgObjectMeasureId) throws com.liferay.portal.SystemException {
		return getPersistence().findByorgObjectMeasureId(orgObjectMeasureId);
	}

	public static java.util.List<larion.progate.model.OrgObjectTargets> findByorgObjectMeasureId(
		int orgObjectMeasureId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByorgObjectMeasureId(orgObjectMeasureId, start, end);
	}

	public static java.util.List<larion.progate.model.OrgObjectTargets> findByorgObjectMeasureId(
		int orgObjectMeasureId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByorgObjectMeasureId(orgObjectMeasureId, start, end, obc);
	}

	public static larion.progate.model.OrgObjectTargets findByorgObjectMeasureId_First(
		int orgObjectMeasureId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectTargetsException {
		return getPersistence()
				   .findByorgObjectMeasureId_First(orgObjectMeasureId, obc);
	}

	public static larion.progate.model.OrgObjectTargets findByorgObjectMeasureId_Last(
		int orgObjectMeasureId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectTargetsException {
		return getPersistence()
				   .findByorgObjectMeasureId_Last(orgObjectMeasureId, obc);
	}

	public static larion.progate.model.OrgObjectTargets[] findByorgObjectMeasureId_PrevAndNext(
		java.lang.Integer orgObjectTargetId, int orgObjectMeasureId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrgObjectTargetsException {
		return getPersistence()
				   .findByorgObjectMeasureId_PrevAndNext(orgObjectTargetId,
			orgObjectMeasureId, obc);
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

	public static java.util.List<larion.progate.model.OrgObjectTargets> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.model.OrgObjectTargets> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.model.OrgObjectTargets> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByOrgObjTargetName(java.lang.String name)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByOrgObjTargetName(name);
	}

	public static void removeByorgObjectMeasureId(int orgObjectMeasureId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByorgObjectMeasureId(orgObjectMeasureId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByOrgObjTargetName(java.lang.String name)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByOrgObjTargetName(name);
	}

	public static int countByorgObjectMeasureId(int orgObjectMeasureId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByorgObjectMeasureId(orgObjectMeasureId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static OrgObjectTargetsPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(OrgObjectTargetsPersistence persistence) {
		_persistence = persistence;
	}

	private static OrgObjectTargetsPersistence _persistence;
}