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
 * <a href="OrganizationUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrganizationUtil {
	public static void cacheResult(
		larion.progate.model.Organization organization) {
		getPersistence().cacheResult(organization);
	}

	public static void cacheResult(
		java.util.List<larion.progate.model.Organization> organizations) {
		getPersistence().cacheResult(organizations);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.model.Organization create(
		java.lang.Integer orgId) {
		return getPersistence().create(orgId);
	}

	public static larion.progate.model.Organization remove(
		java.lang.Integer orgId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException {
		return getPersistence().remove(orgId);
	}

	public static larion.progate.model.Organization remove(
		larion.progate.model.Organization organization)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(organization);
	}

	public static larion.progate.model.Organization update(
		larion.progate.model.Organization organization)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(organization);
	}

	public static larion.progate.model.Organization update(
		larion.progate.model.Organization organization, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(organization, merge);
	}

	public static larion.progate.model.Organization updateImpl(
		larion.progate.model.Organization organization, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(organization, merge);
	}

	public static larion.progate.model.Organization findByPrimaryKey(
		java.lang.Integer orgId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException {
		return getPersistence().findByPrimaryKey(orgId);
	}

	public static larion.progate.model.Organization fetchByPrimaryKey(
		java.lang.Integer orgId) throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(orgId);
	}

	public static java.util.List<larion.progate.model.Organization> findBylevelSharing(
		int levelSharing) throws com.liferay.portal.SystemException {
		return getPersistence().findBylevelSharing(levelSharing);
	}

	public static java.util.List<larion.progate.model.Organization> findBylevelSharing(
		int levelSharing, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBylevelSharing(levelSharing, start, end);
	}

	public static java.util.List<larion.progate.model.Organization> findBylevelSharing(
		int levelSharing, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBylevelSharing(levelSharing, start, end, obc);
	}

	public static larion.progate.model.Organization findBylevelSharing_First(
		int levelSharing, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException {
		return getPersistence().findBylevelSharing_First(levelSharing, obc);
	}

	public static larion.progate.model.Organization findBylevelSharing_Last(
		int levelSharing, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException {
		return getPersistence().findBylevelSharing_Last(levelSharing, obc);
	}

	public static larion.progate.model.Organization[] findBylevelSharing_PrevAndNext(
		java.lang.Integer orgId, int levelSharing,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException {
		return getPersistence()
				   .findBylevelSharing_PrevAndNext(orgId, levelSharing, obc);
	}

	public static java.util.List<larion.progate.model.Organization> findByisProactive(
		boolean isProactive) throws com.liferay.portal.SystemException {
		return getPersistence().findByisProactive(isProactive);
	}

	public static java.util.List<larion.progate.model.Organization> findByisProactive(
		boolean isProactive, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByisProactive(isProactive, start, end);
	}

	public static java.util.List<larion.progate.model.Organization> findByisProactive(
		boolean isProactive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByisProactive(isProactive, start, end, obc);
	}

	public static larion.progate.model.Organization findByisProactive_First(
		boolean isProactive,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException {
		return getPersistence().findByisProactive_First(isProactive, obc);
	}

	public static larion.progate.model.Organization findByisProactive_Last(
		boolean isProactive,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException {
		return getPersistence().findByisProactive_Last(isProactive, obc);
	}

	public static larion.progate.model.Organization[] findByisProactive_PrevAndNext(
		java.lang.Integer orgId, boolean isProactive,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException {
		return getPersistence()
				   .findByisProactive_PrevAndNext(orgId, isProactive, obc);
	}

	public static java.util.List<larion.progate.model.Organization> findByisPrivateProfile(
		boolean isPrivateProfile) throws com.liferay.portal.SystemException {
		return getPersistence().findByisPrivateProfile(isPrivateProfile);
	}

	public static java.util.List<larion.progate.model.Organization> findByisPrivateProfile(
		boolean isPrivateProfile, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByisPrivateProfile(isPrivateProfile, start, end);
	}

	public static java.util.List<larion.progate.model.Organization> findByisPrivateProfile(
		boolean isPrivateProfile, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByisPrivateProfile(isPrivateProfile, start, end, obc);
	}

	public static larion.progate.model.Organization findByisPrivateProfile_First(
		boolean isPrivateProfile,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException {
		return getPersistence()
				   .findByisPrivateProfile_First(isPrivateProfile, obc);
	}

	public static larion.progate.model.Organization findByisPrivateProfile_Last(
		boolean isPrivateProfile,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException {
		return getPersistence()
				   .findByisPrivateProfile_Last(isPrivateProfile, obc);
	}

	public static larion.progate.model.Organization[] findByisPrivateProfile_PrevAndNext(
		java.lang.Integer orgId, boolean isPrivateProfile,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException {
		return getPersistence()
				   .findByisPrivateProfile_PrevAndNext(orgId, isPrivateProfile,
			obc);
	}

	public static java.util.List<larion.progate.model.Organization> findByOrgName(
		java.lang.String name) throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgName(name);
	}

	public static java.util.List<larion.progate.model.Organization> findByOrgName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgName(name, start, end);
	}

	public static java.util.List<larion.progate.model.Organization> findByOrgName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgName(name, start, end, obc);
	}

	public static larion.progate.model.Organization findByOrgName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException {
		return getPersistence().findByOrgName_First(name, obc);
	}

	public static larion.progate.model.Organization findByOrgName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException {
		return getPersistence().findByOrgName_Last(name, obc);
	}

	public static larion.progate.model.Organization[] findByOrgName_PrevAndNext(
		java.lang.Integer orgId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException {
		return getPersistence().findByOrgName_PrevAndNext(orgId, name, obc);
	}

	public static java.util.List<larion.progate.model.Organization> findByorgParent(
		int orgParent) throws com.liferay.portal.SystemException {
		return getPersistence().findByorgParent(orgParent);
	}

	public static java.util.List<larion.progate.model.Organization> findByorgParent(
		int orgParent, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByorgParent(orgParent, start, end);
	}

	public static java.util.List<larion.progate.model.Organization> findByorgParent(
		int orgParent, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByorgParent(orgParent, start, end, obc);
	}

	public static larion.progate.model.Organization findByorgParent_First(
		int orgParent, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException {
		return getPersistence().findByorgParent_First(orgParent, obc);
	}

	public static larion.progate.model.Organization findByorgParent_Last(
		int orgParent, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException {
		return getPersistence().findByorgParent_Last(orgParent, obc);
	}

	public static larion.progate.model.Organization[] findByorgParent_PrevAndNext(
		java.lang.Integer orgId, int orgParent,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException {
		return getPersistence()
				   .findByorgParent_PrevAndNext(orgId, orgParent, obc);
	}

	public static java.util.List<larion.progate.model.Organization> findByorgType(
		java.lang.String orgType) throws com.liferay.portal.SystemException {
		return getPersistence().findByorgType(orgType);
	}

	public static java.util.List<larion.progate.model.Organization> findByorgType(
		java.lang.String orgType, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByorgType(orgType, start, end);
	}

	public static java.util.List<larion.progate.model.Organization> findByorgType(
		java.lang.String orgType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByorgType(orgType, start, end, obc);
	}

	public static larion.progate.model.Organization findByorgType_First(
		java.lang.String orgType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException {
		return getPersistence().findByorgType_First(orgType, obc);
	}

	public static larion.progate.model.Organization findByorgType_Last(
		java.lang.String orgType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException {
		return getPersistence().findByorgType_Last(orgType, obc);
	}

	public static larion.progate.model.Organization[] findByorgType_PrevAndNext(
		java.lang.Integer orgId, java.lang.String orgType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException {
		return getPersistence().findByorgType_PrevAndNext(orgId, orgType, obc);
	}

	public static java.util.List<larion.progate.model.Organization> findByorgStatus(
		boolean orgStatus) throws com.liferay.portal.SystemException {
		return getPersistence().findByorgStatus(orgStatus);
	}

	public static java.util.List<larion.progate.model.Organization> findByorgStatus(
		boolean orgStatus, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByorgStatus(orgStatus, start, end);
	}

	public static java.util.List<larion.progate.model.Organization> findByorgStatus(
		boolean orgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByorgStatus(orgStatus, start, end, obc);
	}

	public static larion.progate.model.Organization findByorgStatus_First(
		boolean orgStatus, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException {
		return getPersistence().findByorgStatus_First(orgStatus, obc);
	}

	public static larion.progate.model.Organization findByorgStatus_Last(
		boolean orgStatus, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException {
		return getPersistence().findByorgStatus_Last(orgStatus, obc);
	}

	public static larion.progate.model.Organization[] findByorgStatus_PrevAndNext(
		java.lang.Integer orgId, boolean orgStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException {
		return getPersistence()
				   .findByorgStatus_PrevAndNext(orgId, orgStatus, obc);
	}

	public static java.util.List<larion.progate.model.Organization> findByrootId(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByrootId(rootId);
	}

	public static java.util.List<larion.progate.model.Organization> findByrootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByrootId(rootId, start, end);
	}

	public static java.util.List<larion.progate.model.Organization> findByrootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByrootId(rootId, start, end, obc);
	}

	public static larion.progate.model.Organization findByrootId_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException {
		return getPersistence().findByrootId_First(rootId, obc);
	}

	public static larion.progate.model.Organization findByrootId_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException {
		return getPersistence().findByrootId_Last(rootId, obc);
	}

	public static larion.progate.model.Organization[] findByrootId_PrevAndNext(
		java.lang.Integer orgId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException {
		return getPersistence().findByrootId_PrevAndNext(orgId, rootId, obc);
	}

	public static java.util.List<larion.progate.model.Organization> findBybodId(
		int bodId) throws com.liferay.portal.SystemException {
		return getPersistence().findBybodId(bodId);
	}

	public static java.util.List<larion.progate.model.Organization> findBybodId(
		int bodId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBybodId(bodId, start, end);
	}

	public static java.util.List<larion.progate.model.Organization> findBybodId(
		int bodId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBybodId(bodId, start, end, obc);
	}

	public static larion.progate.model.Organization findBybodId_First(
		int bodId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException {
		return getPersistence().findBybodId_First(bodId, obc);
	}

	public static larion.progate.model.Organization findBybodId_Last(
		int bodId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException {
		return getPersistence().findBybodId_Last(bodId, obc);
	}

	public static larion.progate.model.Organization[] findBybodId_PrevAndNext(
		java.lang.Integer orgId, int bodId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException {
		return getPersistence().findBybodId_PrevAndNext(orgId, bodId, obc);
	}

	public static java.util.List<larion.progate.model.Organization> findBylevel(
		boolean orgStatus) throws com.liferay.portal.SystemException {
		return getPersistence().findBylevel(orgStatus);
	}

	public static java.util.List<larion.progate.model.Organization> findBylevel(
		boolean orgStatus, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBylevel(orgStatus, start, end);
	}

	public static java.util.List<larion.progate.model.Organization> findBylevel(
		boolean orgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBylevel(orgStatus, start, end, obc);
	}

	public static larion.progate.model.Organization findBylevel_First(
		boolean orgStatus, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException {
		return getPersistence().findBylevel_First(orgStatus, obc);
	}

	public static larion.progate.model.Organization findBylevel_Last(
		boolean orgStatus, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException {
		return getPersistence().findBylevel_Last(orgStatus, obc);
	}

	public static larion.progate.model.Organization[] findBylevel_PrevAndNext(
		java.lang.Integer orgId, boolean orgStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException {
		return getPersistence().findBylevel_PrevAndNext(orgId, orgStatus, obc);
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

	public static java.util.List<larion.progate.model.Organization> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.model.Organization> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.model.Organization> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeBylevelSharing(int levelSharing)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBylevelSharing(levelSharing);
	}

	public static void removeByisProactive(boolean isProactive)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByisProactive(isProactive);
	}

	public static void removeByisPrivateProfile(boolean isPrivateProfile)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByisPrivateProfile(isPrivateProfile);
	}

	public static void removeByOrgName(java.lang.String name)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByOrgName(name);
	}

	public static void removeByorgParent(int orgParent)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByorgParent(orgParent);
	}

	public static void removeByorgType(java.lang.String orgType)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByorgType(orgType);
	}

	public static void removeByorgStatus(boolean orgStatus)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByorgStatus(orgStatus);
	}

	public static void removeByrootId(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByrootId(rootId);
	}

	public static void removeBybodId(int bodId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBybodId(bodId);
	}

	public static void removeBylevel(boolean orgStatus)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBylevel(orgStatus);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countBylevelSharing(int levelSharing)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBylevelSharing(levelSharing);
	}

	public static int countByisProactive(boolean isProactive)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByisProactive(isProactive);
	}

	public static int countByisPrivateProfile(boolean isPrivateProfile)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByisPrivateProfile(isPrivateProfile);
	}

	public static int countByOrgName(java.lang.String name)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByOrgName(name);
	}

	public static int countByorgParent(int orgParent)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByorgParent(orgParent);
	}

	public static int countByorgType(java.lang.String orgType)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByorgType(orgType);
	}

	public static int countByorgStatus(boolean orgStatus)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByorgStatus(orgStatus);
	}

	public static int countByrootId(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByrootId(rootId);
	}

	public static int countBybodId(int bodId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBybodId(bodId);
	}

	public static int countBylevel(boolean orgStatus)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBylevel(orgStatus);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static java.util.List<larion.progate.model.OrgObjectList> getOrgObjectLists(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getOrgObjectLists(pk);
	}

	public static java.util.List<larion.progate.model.OrgObjectList> getOrgObjectLists(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getOrgObjectLists(pk, start, end);
	}

	public static java.util.List<larion.progate.model.OrgObjectList> getOrgObjectLists(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().getOrgObjectLists(pk, start, end, obc);
	}

	public static int getOrgObjectListsSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().getOrgObjectListsSize(pk);
	}

	public static boolean containsOrgObjectList(java.lang.Integer pk,
		java.lang.Integer orgObjectListPK)
		throws com.liferay.portal.SystemException {
		return getPersistence().containsOrgObjectList(pk, orgObjectListPK);
	}

	public static boolean containsOrgObjectLists(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().containsOrgObjectLists(pk);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> getProGateOrgCustomers(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getProGateOrgCustomers(pk);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> getProGateOrgCustomers(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getProGateOrgCustomers(pk, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> getProGateOrgCustomers(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().getProGateOrgCustomers(pk, start, end, obc);
	}

	public static int getProGateOrgCustomersSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().getProGateOrgCustomersSize(pk);
	}

	public static boolean containsProGateOrgCustomer(java.lang.Integer pk,
		java.lang.Integer proGateOrgCustomerPK)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .containsProGateOrgCustomer(pk, proGateOrgCustomerPK);
	}

	public static boolean containsProGateOrgCustomers(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().containsProGateOrgCustomers(pk);
	}

	public static OrganizationPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(OrganizationPersistence persistence) {
		_persistence = persistence;
	}

	private static OrganizationPersistence _persistence;
}