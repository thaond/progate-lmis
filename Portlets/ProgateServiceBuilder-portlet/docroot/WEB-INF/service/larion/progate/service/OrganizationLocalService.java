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

package larion.progate.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;

/**
 * <a href="OrganizationLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface OrganizationLocalService {
	public larion.progate.model.Organization addOrganization(
		larion.progate.model.Organization organization)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.Organization createOrganization(
		java.lang.Integer orgId);

	public void deleteOrganization(java.lang.Integer orgId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	public void deleteOrganization(
		larion.progate.model.Organization organization)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public larion.progate.model.Organization getOrganization(
		java.lang.Integer orgId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.Organization> getOrganizations(
		int start, int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getOrganizationsCount()
		throws com.liferay.portal.SystemException;

	public larion.progate.model.Organization updateOrganization(
		larion.progate.model.Organization organization)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.Organization updateOrganization(
		larion.progate.model.Organization organization, boolean merge)
		throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.Organization> getListAllSubOrganizations(
		int orgId) throws com.liferay.portal.SystemException;

	public int countOrganizations() throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.Organization> getSubOrganizations(
		int orgParentId, int start, int end)
		throws com.liferay.portal.SystemException;

	public int countSubOrganizations(int orgParentId)
		throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.Organization> getRepresentOrganizations(
		boolean typeRepresent, java.lang.String searchPhrase, int start, int end)
		throws com.liferay.portal.SystemException;

	public int countRepresentOrganizations(boolean typeRepresent,
		java.lang.String searchPhrase)
		throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.Organization> getListOrgByType(
		int orgParent, java.lang.String orgType, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.Organization> searchOrgName(
		java.lang.String orgName, int start, int end)
		throws com.liferay.portal.SystemException;

	public int countSearchOrgName(java.lang.String orgName)
		throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.Organization> searchOrganizations(
		long userId, int roleView, java.lang.String searchPharse, int start,
		int end) throws com.liferay.portal.SystemException;

	public int countsearchOrganizations(long userId, int roleView,
		java.lang.String searchPharse)
		throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public larion.progate.model.Organization getOrgObjectFromOrgId(int orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.Organization> getOrganizations(
		int userId, int type, int start, int end);

	public int countOrganizations(int userId, int type);

	public larion.progate.model.Organization createOrganization(long userId,
		java.lang.String orgName, java.lang.String orgNameAbbreviate,
		java.lang.String description, java.lang.String orgType,
		java.lang.String country, java.lang.String city,
		java.lang.String telephone, java.lang.String address, int maxUser,
		java.util.Date expirationDate, boolean status, int levelSharing,
		java.lang.String orgEmail);

	public larion.progate.model.Organization createSubOrganization(
		int orgParentId, long userId, java.lang.String orgName,
		java.lang.String orgNameAbbreviate, java.lang.String description,
		java.lang.String orgType, java.lang.String country,
		java.lang.String city, java.lang.String telephone,
		java.lang.String address, int maxUser, java.util.Date expirationDate,
		boolean status);

	public larion.progate.model.Organization createSubOrganization(
		int orgParentId, long userId, java.lang.String orgName,
		java.lang.String orgNameAbbreviate, java.lang.String description,
		java.lang.String orgType, java.lang.String country,
		java.lang.String city, java.lang.String telephone,
		java.lang.String address, int maxUser, java.util.Date expirationDate,
		boolean status, int levelSharing, java.lang.String orgEmail);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.Organization> getPathOrg(
		int orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.util.HashMap<Integer, java.lang.String>> getListSubOrgsOfRootOrg(
		int orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.util.HashMap<Integer, java.lang.String>> getListSubOrgsOfRootOrg(
		int orgId, int userId);

	public java.util.List<larion.progate.model.Organization> findOrganization(
		int rootId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.Organization> getProjectOfPM(
		int rootId, int pmUId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.model.Organization> getProjectOfBOD(
		int rootId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<Integer> getCompany()
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;
}