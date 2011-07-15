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
 * <a href="ProGateOrgTypeUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateOrgTypeUtil {
	public static void cacheResult(
		larion.progate.model.ProGateOrgType proGateOrgType) {
		getPersistence().cacheResult(proGateOrgType);
	}

	public static void cacheResult(
		java.util.List<larion.progate.model.ProGateOrgType> proGateOrgTypes) {
		getPersistence().cacheResult(proGateOrgTypes);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.model.ProGateOrgType create(
		java.lang.Integer orgTypeId) {
		return getPersistence().create(orgTypeId);
	}

	public static larion.progate.model.ProGateOrgType remove(
		java.lang.Integer orgTypeId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgTypeException {
		return getPersistence().remove(orgTypeId);
	}

	public static larion.progate.model.ProGateOrgType remove(
		larion.progate.model.ProGateOrgType proGateOrgType)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(proGateOrgType);
	}

	public static larion.progate.model.ProGateOrgType update(
		larion.progate.model.ProGateOrgType proGateOrgType)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(proGateOrgType);
	}

	public static larion.progate.model.ProGateOrgType update(
		larion.progate.model.ProGateOrgType proGateOrgType, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(proGateOrgType, merge);
	}

	public static larion.progate.model.ProGateOrgType updateImpl(
		larion.progate.model.ProGateOrgType proGateOrgType, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(proGateOrgType, merge);
	}

	public static larion.progate.model.ProGateOrgType findByPrimaryKey(
		java.lang.Integer orgTypeId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgTypeException {
		return getPersistence().findByPrimaryKey(orgTypeId);
	}

	public static larion.progate.model.ProGateOrgType fetchByPrimaryKey(
		java.lang.Integer orgTypeId) throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(orgTypeId);
	}

	public static java.util.List<larion.progate.model.ProGateOrgType> findByname(
		java.lang.String name) throws com.liferay.portal.SystemException {
		return getPersistence().findByname(name);
	}

	public static java.util.List<larion.progate.model.ProGateOrgType> findByname(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByname(name, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateOrgType> findByname(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByname(name, start, end, obc);
	}

	public static larion.progate.model.ProGateOrgType findByname_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgTypeException {
		return getPersistence().findByname_First(name, obc);
	}

	public static larion.progate.model.ProGateOrgType findByname_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgTypeException {
		return getPersistence().findByname_Last(name, obc);
	}

	public static larion.progate.model.ProGateOrgType[] findByname_PrevAndNext(
		java.lang.Integer orgTypeId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgTypeException {
		return getPersistence().findByname_PrevAndNext(orgTypeId, name, obc);
	}

	public static java.util.List<larion.progate.model.ProGateOrgType> findBystatus(
		boolean status) throws com.liferay.portal.SystemException {
		return getPersistence().findBystatus(status);
	}

	public static java.util.List<larion.progate.model.ProGateOrgType> findBystatus(
		boolean status, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBystatus(status, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateOrgType> findBystatus(
		boolean status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBystatus(status, start, end, obc);
	}

	public static larion.progate.model.ProGateOrgType findBystatus_First(
		boolean status, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgTypeException {
		return getPersistence().findBystatus_First(status, obc);
	}

	public static larion.progate.model.ProGateOrgType findBystatus_Last(
		boolean status, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgTypeException {
		return getPersistence().findBystatus_Last(status, obc);
	}

	public static larion.progate.model.ProGateOrgType[] findBystatus_PrevAndNext(
		java.lang.Integer orgTypeId, boolean status,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgTypeException {
		return getPersistence().findBystatus_PrevAndNext(orgTypeId, status, obc);
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

	public static java.util.List<larion.progate.model.ProGateOrgType> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.model.ProGateOrgType> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.model.ProGateOrgType> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByname(java.lang.String name)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByname(name);
	}

	public static void removeBystatus(boolean status)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBystatus(status);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByname(java.lang.String name)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByname(name);
	}

	public static int countBystatus(boolean status)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBystatus(status);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static java.util.List<larion.progate.model.Organization> getOrganizations(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getOrganizations(pk);
	}

	public static java.util.List<larion.progate.model.Organization> getOrganizations(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getOrganizations(pk, start, end);
	}

	public static java.util.List<larion.progate.model.Organization> getOrganizations(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().getOrganizations(pk, start, end, obc);
	}

	public static int getOrganizationsSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().getOrganizationsSize(pk);
	}

	public static boolean containsOrganization(java.lang.Integer pk,
		java.lang.Integer organizationPK)
		throws com.liferay.portal.SystemException {
		return getPersistence().containsOrganization(pk, organizationPK);
	}

	public static boolean containsOrganizations(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().containsOrganizations(pk);
	}

	public static ProGateOrgTypePersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(ProGateOrgTypePersistence persistence) {
		_persistence = persistence;
	}

	private static ProGateOrgTypePersistence _persistence;
}