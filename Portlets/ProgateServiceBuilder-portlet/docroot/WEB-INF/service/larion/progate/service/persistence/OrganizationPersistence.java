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
 * <a href="OrganizationPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface OrganizationPersistence extends BasePersistence {
	public void cacheResult(larion.progate.model.Organization organization);

	public void cacheResult(
		java.util.List<larion.progate.model.Organization> organizations);

	public void clearCache();

	public larion.progate.model.Organization create(java.lang.Integer orgId);

	public larion.progate.model.Organization remove(java.lang.Integer orgId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException;

	public larion.progate.model.Organization remove(
		larion.progate.model.Organization organization)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.Organization update(
		larion.progate.model.Organization organization)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.Organization update(
		larion.progate.model.Organization organization, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.Organization updateImpl(
		larion.progate.model.Organization organization, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.Organization findByPrimaryKey(
		java.lang.Integer orgId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException;

	public larion.progate.model.Organization fetchByPrimaryKey(
		java.lang.Integer orgId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Organization> findBylevelSharing(
		int levelSharing) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Organization> findBylevelSharing(
		int levelSharing, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Organization> findBylevelSharing(
		int levelSharing, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.Organization findBylevelSharing_First(
		int levelSharing, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException;

	public larion.progate.model.Organization findBylevelSharing_Last(
		int levelSharing, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException;

	public larion.progate.model.Organization[] findBylevelSharing_PrevAndNext(
		java.lang.Integer orgId, int levelSharing,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException;

	public java.util.List<larion.progate.model.Organization> findByisProactive(
		boolean isProactive) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Organization> findByisProactive(
		boolean isProactive, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Organization> findByisProactive(
		boolean isProactive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.Organization findByisProactive_First(
		boolean isProactive,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException;

	public larion.progate.model.Organization findByisProactive_Last(
		boolean isProactive,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException;

	public larion.progate.model.Organization[] findByisProactive_PrevAndNext(
		java.lang.Integer orgId, boolean isProactive,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException;

	public java.util.List<larion.progate.model.Organization> findByisPrivateProfile(
		boolean isPrivateProfile) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Organization> findByisPrivateProfile(
		boolean isPrivateProfile, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Organization> findByisPrivateProfile(
		boolean isPrivateProfile, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.Organization findByisPrivateProfile_First(
		boolean isPrivateProfile,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException;

	public larion.progate.model.Organization findByisPrivateProfile_Last(
		boolean isPrivateProfile,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException;

	public larion.progate.model.Organization[] findByisPrivateProfile_PrevAndNext(
		java.lang.Integer orgId, boolean isPrivateProfile,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException;

	public java.util.List<larion.progate.model.Organization> findByOrgName(
		java.lang.String name) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Organization> findByOrgName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Organization> findByOrgName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.Organization findByOrgName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException;

	public larion.progate.model.Organization findByOrgName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException;

	public larion.progate.model.Organization[] findByOrgName_PrevAndNext(
		java.lang.Integer orgId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException;

	public java.util.List<larion.progate.model.Organization> findByorgParent(
		int orgParent) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Organization> findByorgParent(
		int orgParent, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Organization> findByorgParent(
		int orgParent, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.Organization findByorgParent_First(
		int orgParent, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException;

	public larion.progate.model.Organization findByorgParent_Last(
		int orgParent, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException;

	public larion.progate.model.Organization[] findByorgParent_PrevAndNext(
		java.lang.Integer orgId, int orgParent,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException;

	public java.util.List<larion.progate.model.Organization> findByorgType(
		java.lang.String orgType) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Organization> findByorgType(
		java.lang.String orgType, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Organization> findByorgType(
		java.lang.String orgType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.Organization findByorgType_First(
		java.lang.String orgType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException;

	public larion.progate.model.Organization findByorgType_Last(
		java.lang.String orgType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException;

	public larion.progate.model.Organization[] findByorgType_PrevAndNext(
		java.lang.Integer orgId, java.lang.String orgType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException;

	public java.util.List<larion.progate.model.Organization> findByorgStatus(
		boolean orgStatus) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Organization> findByorgStatus(
		boolean orgStatus, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Organization> findByorgStatus(
		boolean orgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.Organization findByorgStatus_First(
		boolean orgStatus, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException;

	public larion.progate.model.Organization findByorgStatus_Last(
		boolean orgStatus, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException;

	public larion.progate.model.Organization[] findByorgStatus_PrevAndNext(
		java.lang.Integer orgId, boolean orgStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException;

	public java.util.List<larion.progate.model.Organization> findByrootId(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Organization> findByrootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Organization> findByrootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.Organization findByrootId_First(int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException;

	public larion.progate.model.Organization findByrootId_Last(int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException;

	public larion.progate.model.Organization[] findByrootId_PrevAndNext(
		java.lang.Integer orgId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException;

	public java.util.List<larion.progate.model.Organization> findBybodId(
		int bodId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Organization> findBybodId(
		int bodId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Organization> findBybodId(
		int bodId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.Organization findBybodId_First(int bodId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException;

	public larion.progate.model.Organization findBybodId_Last(int bodId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException;

	public larion.progate.model.Organization[] findBybodId_PrevAndNext(
		java.lang.Integer orgId, int bodId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException;

	public java.util.List<larion.progate.model.Organization> findBylevel(
		boolean orgStatus) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Organization> findBylevel(
		boolean orgStatus, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Organization> findBylevel(
		boolean orgStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.Organization findBylevel_First(
		boolean orgStatus, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException;

	public larion.progate.model.Organization findBylevel_Last(
		boolean orgStatus, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException;

	public larion.progate.model.Organization[] findBylevel_PrevAndNext(
		java.lang.Integer orgId, boolean orgStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Organization> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Organization> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.Organization> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeBylevelSharing(int levelSharing)
		throws com.liferay.portal.SystemException;

	public void removeByisProactive(boolean isProactive)
		throws com.liferay.portal.SystemException;

	public void removeByisPrivateProfile(boolean isPrivateProfile)
		throws com.liferay.portal.SystemException;

	public void removeByOrgName(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public void removeByorgParent(int orgParent)
		throws com.liferay.portal.SystemException;

	public void removeByorgType(java.lang.String orgType)
		throws com.liferay.portal.SystemException;

	public void removeByorgStatus(boolean orgStatus)
		throws com.liferay.portal.SystemException;

	public void removeByrootId(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeBybodId(int bodId)
		throws com.liferay.portal.SystemException;

	public void removeBylevel(boolean orgStatus)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countBylevelSharing(int levelSharing)
		throws com.liferay.portal.SystemException;

	public int countByisProactive(boolean isProactive)
		throws com.liferay.portal.SystemException;

	public int countByisPrivateProfile(boolean isPrivateProfile)
		throws com.liferay.portal.SystemException;

	public int countByOrgName(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public int countByorgParent(int orgParent)
		throws com.liferay.portal.SystemException;

	public int countByorgType(java.lang.String orgType)
		throws com.liferay.portal.SystemException;

	public int countByorgStatus(boolean orgStatus)
		throws com.liferay.portal.SystemException;

	public int countByrootId(int rootId)
		throws com.liferay.portal.SystemException;

	public int countBybodId(int bodId)
		throws com.liferay.portal.SystemException;

	public int countBylevel(boolean orgStatus)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectList> getOrgObjectLists(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectList> getOrgObjectLists(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrgObjectList> getOrgObjectLists(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getOrgObjectListsSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsOrgObjectList(java.lang.Integer pk,
		java.lang.Integer orgObjectListPK)
		throws com.liferay.portal.SystemException;

	public boolean containsOrgObjectLists(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> getProGateOrgCustomers(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> getProGateOrgCustomers(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> getProGateOrgCustomers(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getProGateOrgCustomersSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsProGateOrgCustomer(java.lang.Integer pk,
		java.lang.Integer proGateOrgCustomerPK)
		throws com.liferay.portal.SystemException;

	public boolean containsProGateOrgCustomers(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;
}