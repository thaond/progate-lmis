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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * <a href="OrganizationLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrganizationLocalServiceUtil {
	public static larion.progate.model.Organization addOrganization(
		larion.progate.model.Organization organization)
		throws com.liferay.portal.SystemException {
		return getService().addOrganization(organization);
	}

	public static larion.progate.model.Organization createOrganization(
		java.lang.Integer orgId) {
		return getService().createOrganization(orgId);
	}

	public static void deleteOrganization(java.lang.Integer orgId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteOrganization(orgId);
	}

	public static void deleteOrganization(
		larion.progate.model.Organization organization)
		throws com.liferay.portal.SystemException {
		getService().deleteOrganization(organization);
	}

	public static java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	public static java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	public static larion.progate.model.Organization getOrganization(
		java.lang.Integer orgId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getOrganization(orgId);
	}

	public static java.util.List<larion.progate.model.Organization> getOrganizations(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getOrganizations(start, end);
	}

	public static int getOrganizationsCount()
		throws com.liferay.portal.SystemException {
		return getService().getOrganizationsCount();
	}

	public static larion.progate.model.Organization updateOrganization(
		larion.progate.model.Organization organization)
		throws com.liferay.portal.SystemException {
		return getService().updateOrganization(organization);
	}

	public static larion.progate.model.Organization updateOrganization(
		larion.progate.model.Organization organization, boolean merge)
		throws com.liferay.portal.SystemException {
		return getService().updateOrganization(organization, merge);
	}

	public static java.util.List<larion.progate.model.Organization> getListAllSubOrganizations(
		int orgId) throws com.liferay.portal.SystemException {
		return getService().getListAllSubOrganizations(orgId);
	}

	public static int countOrganizations()
		throws com.liferay.portal.SystemException {
		return getService().countOrganizations();
	}

	public static java.util.List<larion.progate.model.Organization> getSubOrganizations(
		int orgParentId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getService().getSubOrganizations(orgParentId, start, end);
	}

	public static int countSubOrganizations(int orgParentId)
		throws com.liferay.portal.SystemException {
		return getService().countSubOrganizations(orgParentId);
	}

	public static java.util.List<larion.progate.model.Organization> getRepresentOrganizations(
		boolean typeRepresent, java.lang.String searchPhrase, int start, int end)
		throws com.liferay.portal.SystemException {
		return getService()
				   .getRepresentOrganizations(typeRepresent, searchPhrase,
			start, end);
	}

	public static int countRepresentOrganizations(boolean typeRepresent,
		java.lang.String searchPhrase)
		throws com.liferay.portal.SystemException {
		return getService()
				   .countRepresentOrganizations(typeRepresent, searchPhrase);
	}

	public static java.util.List<larion.progate.model.Organization> getListOrgByType(
		int orgParent, java.lang.String orgType, int start, int end) {
		return getService().getListOrgByType(orgParent, orgType, start, end);
	}

	public static java.util.List<larion.progate.model.Organization> searchOrgName(
		java.lang.String orgName, int start, int end)
		throws com.liferay.portal.SystemException {
		return getService().searchOrgName(orgName, start, end);
	}

	public static int countSearchOrgName(java.lang.String orgName)
		throws com.liferay.portal.SystemException {
		return getService().countSearchOrgName(orgName);
	}

	public static java.util.List<larion.progate.model.Organization> searchOrganizations(
		long userId, int roleView, java.lang.String searchPharse, int start,
		int end) throws com.liferay.portal.SystemException {
		return getService()
				   .searchOrganizations(userId, roleView, searchPharse, start,
			end);
	}

	public static int countsearchOrganizations(long userId, int roleView,
		java.lang.String searchPharse)
		throws com.liferay.portal.SystemException {
		return getService()
				   .countsearchOrganizations(userId, roleView, searchPharse);
	}

	public static larion.progate.model.Organization getOrgObjectFromOrgId(
		int orgId) {
		return getService().getOrgObjectFromOrgId(orgId);
	}

	public static java.util.List<larion.progate.model.Organization> getOrganizations(
		int userId, int type, int start, int end) {
		return getService().getOrganizations(userId, type, start, end);
	}

	public static int countOrganizations(int userId, int type) {
		return getService().countOrganizations(userId, type);
	}

	public static larion.progate.model.Organization createOrganization(
		long userId, java.lang.String orgName,
		java.lang.String orgNameAbbreviate, java.lang.String description,
		java.lang.String orgType, java.lang.String country,
		java.lang.String city, java.lang.String telephone,
		java.lang.String address, int maxUser, java.util.Date expirationDate,
		boolean status, int levelSharing, java.lang.String orgEmail) {
		return getService()
				   .createOrganization(userId, orgName, orgNameAbbreviate,
			description, orgType, country, city, telephone, address, maxUser,
			expirationDate, status, levelSharing, orgEmail);
	}

	public static larion.progate.model.Organization createSubOrganization(
		int orgParentId, long userId, java.lang.String orgName,
		java.lang.String orgNameAbbreviate, java.lang.String description,
		java.lang.String orgType, java.lang.String country,
		java.lang.String city, java.lang.String telephone,
		java.lang.String address, int maxUser, java.util.Date expirationDate,
		boolean status) {
		return getService()
				   .createSubOrganization(orgParentId, userId, orgName,
			orgNameAbbreviate, description, orgType, country, city, telephone,
			address, maxUser, expirationDate, status);
	}

	public static larion.progate.model.Organization createSubOrganization(
		int orgParentId, long userId, java.lang.String orgName,
		java.lang.String orgNameAbbreviate, java.lang.String description,
		java.lang.String orgType, java.lang.String country,
		java.lang.String city, java.lang.String telephone,
		java.lang.String address, int maxUser, java.util.Date expirationDate,
		boolean status, int levelSharing, java.lang.String orgEmail) {
		return getService()
				   .createSubOrganization(orgParentId, userId, orgName,
			orgNameAbbreviate, description, orgType, country, city, telephone,
			address, maxUser, expirationDate, status, levelSharing, orgEmail);
	}

	public static java.util.List<larion.progate.model.Organization> getPathOrg(
		int orgId) {
		return getService().getPathOrg(orgId);
	}

	public static java.util.List<java.util.HashMap<Integer, java.lang.String>> getListSubOrgsOfRootOrg(
		int orgId) {
		return getService().getListSubOrgsOfRootOrg(orgId);
	}

	public static java.util.List<java.util.HashMap<Integer, java.lang.String>> getListSubOrgsOfRootOrg(
		int orgId, int userId) {
		return getService().getListSubOrgsOfRootOrg(orgId, userId);
	}

	public static java.util.List<larion.progate.model.Organization> findOrganization(
		int rootId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().findOrganization(rootId);
	}

	public static java.util.List<larion.progate.model.Organization> getProjectOfPM(
		int rootId, int pmUId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getProjectOfPM(rootId, pmUId);
	}

	public static java.util.List<larion.progate.model.Organization> getProjectOfBOD(
		int rootId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getProjectOfBOD(rootId);
	}

	public static java.util.List<Integer> getCompany()
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getCompany();
	}

	public static void clearService() {
		_service = null;
	}

	public static OrganizationLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					OrganizationLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new OrganizationLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(OrganizationLocalService service) {
		_service = service;
	}

	private static OrganizationLocalService _service;
}