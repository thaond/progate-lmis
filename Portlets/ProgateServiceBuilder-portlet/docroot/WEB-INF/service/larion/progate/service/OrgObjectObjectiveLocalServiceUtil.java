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
 * <a href="OrgObjectObjectiveLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectObjectiveLocalServiceUtil {
	public static larion.progate.model.OrgObjectObjective addOrgObjectObjective(
		larion.progate.model.OrgObjectObjective orgObjectObjective)
		throws com.liferay.portal.SystemException {
		return getService().addOrgObjectObjective(orgObjectObjective);
	}

	public static larion.progate.model.OrgObjectObjective createOrgObjectObjective(
		java.lang.Integer orgObjectObjectiveId) {
		return getService().createOrgObjectObjective(orgObjectObjectiveId);
	}

	public static void deleteOrgObjectObjective(
		java.lang.Integer orgObjectObjectiveId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteOrgObjectObjective(orgObjectObjectiveId);
	}

	public static void deleteOrgObjectObjective(
		larion.progate.model.OrgObjectObjective orgObjectObjective)
		throws com.liferay.portal.SystemException {
		getService().deleteOrgObjectObjective(orgObjectObjective);
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

	public static larion.progate.model.OrgObjectObjective getOrgObjectObjective(
		java.lang.Integer orgObjectObjectiveId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getOrgObjectObjective(orgObjectObjectiveId);
	}

	public static java.util.List<larion.progate.model.OrgObjectObjective> getOrgObjectObjectives(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getOrgObjectObjectives(start, end);
	}

	public static int getOrgObjectObjectivesCount()
		throws com.liferay.portal.SystemException {
		return getService().getOrgObjectObjectivesCount();
	}

	public static larion.progate.model.OrgObjectObjective updateOrgObjectObjective(
		larion.progate.model.OrgObjectObjective orgObjectObjective)
		throws com.liferay.portal.SystemException {
		return getService().updateOrgObjectObjective(orgObjectObjective);
	}

	public static larion.progate.model.OrgObjectObjective updateOrgObjectObjective(
		larion.progate.model.OrgObjectObjective orgObjectObjective,
		boolean merge) throws com.liferay.portal.SystemException {
		return getService().updateOrgObjectObjective(orgObjectObjective, merge);
	}

	public static java.util.List<larion.progate.model.OrgObjectObjective> getListObjObjs(
		int perId) {
		return getService().getListObjObjs(perId);
	}

	public static boolean editObjObj(
		larion.progate.model.OrgObjectObjective orgObjectObjective) {
		return getService().editObjObj(orgObjectObjective);
	}

	public static boolean createObjObj(int perId, java.lang.String objName,
		double objWeight, java.lang.String description) {
		return getService().createObjObj(perId, objName, objWeight, description);
	}

	public static boolean deletePerObj(int objId) {
		return getService().deletePerObj(objId);
	}

	public static boolean createObjObj(int arg0, java.lang.String arg1,
		int arg2, java.lang.String arg3) {
		return getService().createObjObj(arg0, arg1, arg2, arg3);
	}

	public static void clearService() {
		_service = null;
	}

	public static OrgObjectObjectiveLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					OrgObjectObjectiveLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new OrgObjectObjectiveLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(OrgObjectObjectiveLocalService service) {
		_service = service;
	}

	private static OrgObjectObjectiveLocalService _service;
}