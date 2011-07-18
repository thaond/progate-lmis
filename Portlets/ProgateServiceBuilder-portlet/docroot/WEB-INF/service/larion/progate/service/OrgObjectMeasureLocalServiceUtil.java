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
 * <a href="OrgObjectMeasureLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectMeasureLocalServiceUtil {
	public static larion.progate.model.OrgObjectMeasure addOrgObjectMeasure(
		larion.progate.model.OrgObjectMeasure orgObjectMeasure)
		throws com.liferay.portal.SystemException {
		return getService().addOrgObjectMeasure(orgObjectMeasure);
	}

	public static larion.progate.model.OrgObjectMeasure createOrgObjectMeasure(
		java.lang.Integer orgObjectMeasureId) {
		return getService().createOrgObjectMeasure(orgObjectMeasureId);
	}

	public static void deleteOrgObjectMeasure(
		java.lang.Integer orgObjectMeasureId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteOrgObjectMeasure(orgObjectMeasureId);
	}

	public static void deleteOrgObjectMeasure(
		larion.progate.model.OrgObjectMeasure orgObjectMeasure)
		throws com.liferay.portal.SystemException {
		getService().deleteOrgObjectMeasure(orgObjectMeasure);
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

	public static larion.progate.model.OrgObjectMeasure getOrgObjectMeasure(
		java.lang.Integer orgObjectMeasureId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getOrgObjectMeasure(orgObjectMeasureId);
	}

	public static java.util.List<larion.progate.model.OrgObjectMeasure> getOrgObjectMeasures(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getOrgObjectMeasures(start, end);
	}

	public static int getOrgObjectMeasuresCount()
		throws com.liferay.portal.SystemException {
		return getService().getOrgObjectMeasuresCount();
	}

	public static larion.progate.model.OrgObjectMeasure updateOrgObjectMeasure(
		larion.progate.model.OrgObjectMeasure orgObjectMeasure)
		throws com.liferay.portal.SystemException {
		return getService().updateOrgObjectMeasure(orgObjectMeasure);
	}

	public static larion.progate.model.OrgObjectMeasure updateOrgObjectMeasure(
		larion.progate.model.OrgObjectMeasure orgObjectMeasure, boolean merge)
		throws com.liferay.portal.SystemException {
		return getService().updateOrgObjectMeasure(orgObjectMeasure, merge);
	}

	public static java.util.List<larion.progate.model.OrgObjectMeasure> getListObjMsrs(
		int objId) {
		return getService().getListObjMsrs(objId);
	}

	public static boolean editObjMsr(
		larion.progate.model.OrgObjectMeasure orgObjectMeasure) {
		return getService().editObjMsr(orgObjectMeasure);
	}

	public static boolean createObjMsr(int objId, java.lang.String msrName,
		double msrWeight, double result, java.lang.String formula,
		java.lang.String description) {
		return getService()
				   .createObjMsr(objId, msrName, msrWeight, result, formula,
			description);
	}

	public static boolean deleteObjMsr(int msrId) {
		return getService().deleteObjMsr(msrId);
	}

	public static boolean createObjMsr(int arg0, java.lang.String arg1,
		int arg2, java.lang.String arg3, java.lang.String arg4) {
		return getService().createObjMsr(arg0, arg1, arg2, arg3, arg4);
	}

	public static void clearService() {
		_service = null;
	}

	public static OrgObjectMeasureLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					OrgObjectMeasureLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new OrgObjectMeasureLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(OrgObjectMeasureLocalService service) {
		_service = service;
	}

	private static OrgObjectMeasureLocalService _service;
}