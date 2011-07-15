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

package larion.progate.cds.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * <a href="SlotLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class SlotLocalServiceUtil {
	public static larion.progate.cds.model.Slot addSlot(
		larion.progate.cds.model.Slot slot)
		throws com.liferay.portal.SystemException {
		return getService().addSlot(slot);
	}

	public static larion.progate.cds.model.Slot createSlot(
		java.lang.Integer slotId) {
		return getService().createSlot(slotId);
	}

	public static void deleteSlot(java.lang.Integer slotId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteSlot(slotId);
	}

	public static void deleteSlot(larion.progate.cds.model.Slot slot)
		throws com.liferay.portal.SystemException {
		getService().deleteSlot(slot);
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

	public static larion.progate.cds.model.Slot getSlot(
		java.lang.Integer slotId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getSlot(slotId);
	}

	public static java.util.List<larion.progate.cds.model.Slot> getSlots(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getSlots(start, end);
	}

	public static int getSlotsCount() throws com.liferay.portal.SystemException {
		return getService().getSlotsCount();
	}

	public static larion.progate.cds.model.Slot updateSlot(
		larion.progate.cds.model.Slot slot)
		throws com.liferay.portal.SystemException {
		return getService().updateSlot(slot);
	}

	public static larion.progate.cds.model.Slot updateSlot(
		larion.progate.cds.model.Slot slot, boolean merge)
		throws com.liferay.portal.SystemException {
		return getService().updateSlot(slot, merge);
	}

	public static boolean deleteCdsSlot(int slotId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().deleteCdsSlot(slotId);
	}

	public static boolean addCdsSlot(int levelId, java.lang.String name,
		int numberOrder, java.lang.String description, int createdBy)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .addCdsSlot(levelId, name, numberOrder, description,
			createdBy);
	}

	public static boolean updateCdsSlot(int slotId, java.lang.String name,
		int numberOrder, java.lang.String description, int updateBy)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .updateCdsSlot(slotId, name, numberOrder, description,
			updateBy);
	}

	public static java.util.List<larion.progate.cds.model.Slot> getSlotListByLevelId(
		int levelId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getSlotListByLevelId(levelId);
	}

	public static java.util.List<larion.progate.cds.model.Slot> getSlotListBySlotName(
		java.lang.String slotName)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getSlotListBySlotName(slotName);
	}

	public static boolean checkSlotName(int rootId, java.lang.String slotName,
		int levelId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().checkSlotName(rootId, slotName, levelId);
	}

	public static void clearService() {
		_service = null;
	}

	public static SlotLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					SlotLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new SlotLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(SlotLocalService service) {
		_service = service;
	}

	private static SlotLocalService _service;
}