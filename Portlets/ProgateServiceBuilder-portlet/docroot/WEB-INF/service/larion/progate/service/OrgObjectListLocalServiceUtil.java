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
 * <a href="OrgObjectListLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectListLocalServiceUtil {
	public static larion.progate.model.OrgObjectList addOrgObjectList(
		larion.progate.model.OrgObjectList orgObjectList)
		throws com.liferay.portal.SystemException {
		return getService().addOrgObjectList(orgObjectList);
	}

	public static larion.progate.model.OrgObjectList createOrgObjectList(
		java.lang.Integer orgObjectListId) {
		return getService().createOrgObjectList(orgObjectListId);
	}

	public static void deleteOrgObjectList(java.lang.Integer orgObjectListId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteOrgObjectList(orgObjectListId);
	}

	public static void deleteOrgObjectList(
		larion.progate.model.OrgObjectList orgObjectList)
		throws com.liferay.portal.SystemException {
		getService().deleteOrgObjectList(orgObjectList);
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

	public static larion.progate.model.OrgObjectList getOrgObjectList(
		java.lang.Integer orgObjectListId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getOrgObjectList(orgObjectListId);
	}

	public static java.util.List<larion.progate.model.OrgObjectList> getOrgObjectLists(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getOrgObjectLists(start, end);
	}

	public static int getOrgObjectListsCount()
		throws com.liferay.portal.SystemException {
		return getService().getOrgObjectListsCount();
	}

	public static larion.progate.model.OrgObjectList updateOrgObjectList(
		larion.progate.model.OrgObjectList orgObjectList)
		throws com.liferay.portal.SystemException {
		return getService().updateOrgObjectList(orgObjectList);
	}

	public static larion.progate.model.OrgObjectList updateOrgObjectList(
		larion.progate.model.OrgObjectList orgObjectList, boolean merge)
		throws com.liferay.portal.SystemException {
		return getService().updateOrgObjectList(orgObjectList, merge);
	}

	public static boolean checkExistedOrgSet(int orgId) {
		return getService().checkExistedOrgSet(orgId);
	}

	public static boolean createOrgSet(int orgId, int yearValue, int typeValue) {
		return getService().createOrgSet(orgId, yearValue, typeValue);
	}

	public static java.util.List<larion.progate.model.OrgObjectList> getListOrgSetsByYear(
		int orgId) {
		return getService().getListOrgSetsByYear(orgId);
	}

	public static java.util.List<larion.progate.model.OrgObjectList> getListOrgSetsByQuarter(
		int orgId, int yearValue) {
		return getService().getListOrgSetsByQuarter(orgId, yearValue);
	}

	public static java.util.List<larion.progate.model.OrgObjectList> getListOrgSetsByMonth(
		int orgId, int yearValue, int quaterValue) {
		return getService().getListOrgSetsByMonth(orgId, yearValue, quaterValue);
	}

	public static java.util.List<larion.progate.model.OrgObjectList> getAllListOrgSetsInYear(
		int orgId, int yearValue) {
		return getService().getAllListOrgSetsInYear(orgId, yearValue);
	}

	public static java.util.List<larion.progate.model.OrgObjectList> getOrgSetsById(
		int setId) {
		return getService().getOrgSetsById(setId);
	}

	public static java.util.List<larion.progate.model.OrgObjectList> getListOrgSets(
		int orgId, int offset, int count, java.lang.String searchPhrase) {
		return getService().getListOrgSets(orgId, offset, count, searchPhrase);
	}

	public static boolean deleteOrgSets(
		java.util.List<Integer> listDeletedSetId) {
		return getService().deleteOrgSets(listDeletedSetId);
	}

	public static boolean editOrgSets(
		larion.progate.model.OrgObjectList orgObjectList) {
		return getService().editOrgSets(orgObjectList);
	}

	public static void clearService() {
		_service = null;
	}

	public static OrgObjectListLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					OrgObjectListLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new OrgObjectListLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(OrgObjectListLocalService service) {
		_service = service;
	}

	private static OrgObjectListLocalService _service;
}