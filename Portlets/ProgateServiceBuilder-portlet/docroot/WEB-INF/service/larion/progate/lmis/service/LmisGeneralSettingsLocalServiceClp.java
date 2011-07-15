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

package larion.progate.lmis.service;

import com.liferay.portal.kernel.util.BooleanWrapper;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.NullWrapper;

/**
 * <a href="LmisGeneralSettingsLocalServiceClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisGeneralSettingsLocalServiceClp
	implements LmisGeneralSettingsLocalService {
	public LmisGeneralSettingsLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;
	}

	public larion.progate.lmis.model.LmisGeneralSettings addLmisGeneralSettings(
		larion.progate.lmis.model.LmisGeneralSettings lmisGeneralSettings)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisGeneralSettings);

		if (lmisGeneralSettings == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.lmis.model.LmisGeneralSettings");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("addLmisGeneralSettings",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.lmis.model.LmisGeneralSettings)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.lmis.model.LmisGeneralSettings createLmisGeneralSettings(
		java.lang.Integer lmisGeneralSettingId) {
		Object paramObj0 = ClpSerializer.translateInput(lmisGeneralSettingId);

		if (lmisGeneralSettingId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("createLmisGeneralSettings",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.lmis.model.LmisGeneralSettings)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteLmisGeneralSettings(
		java.lang.Integer lmisGeneralSettingId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisGeneralSettingId);

		if (lmisGeneralSettingId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		try {
			_classLoaderProxy.invoke("deleteLmisGeneralSettings",
				new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.PortalException) {
				throw (com.liferay.portal.PortalException)t;
			}

			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteLmisGeneralSettings(
		larion.progate.lmis.model.LmisGeneralSettings lmisGeneralSettings)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisGeneralSettings);

		if (lmisGeneralSettings == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.lmis.model.LmisGeneralSettings");
		}

		try {
			_classLoaderProxy.invoke("deleteLmisGeneralSettings",
				new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(dynamicQuery);

		if (dynamicQuery == null) {
			paramObj0 = new NullWrapper(
					"com.liferay.portal.kernel.dao.orm.DynamicQuery");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("dynamicQuery",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<Object>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(dynamicQuery);

		if (dynamicQuery == null) {
			paramObj0 = new NullWrapper(
					"com.liferay.portal.kernel.dao.orm.DynamicQuery");
		}

		Object paramObj1 = new IntegerWrapper(start);

		Object paramObj2 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("dynamicQuery",
					new Object[] { paramObj0, paramObj1, paramObj2 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<Object>)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.lmis.model.LmisGeneralSettings getLmisGeneralSettings(
		java.lang.Integer lmisGeneralSettingId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisGeneralSettingId);

		if (lmisGeneralSettingId == null) {
			paramObj0 = new NullWrapper("java.lang.Integer");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getLmisGeneralSettings",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.PortalException) {
				throw (com.liferay.portal.PortalException)t;
			}

			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.lmis.model.LmisGeneralSettings)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.lmis.model.LmisGeneralSettings> getLmisGeneralSettingses(
		int start, int end) throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(start);

		Object paramObj1 = new IntegerWrapper(end);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getLmisGeneralSettingses",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<larion.progate.lmis.model.LmisGeneralSettings>)ClpSerializer.translateOutput(returnObj);
	}

	public int getLmisGeneralSettingsesCount()
		throws com.liferay.portal.SystemException {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getLmisGeneralSettingsesCount",
					new Object[0]);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public larion.progate.lmis.model.LmisGeneralSettings updateLmisGeneralSettings(
		larion.progate.lmis.model.LmisGeneralSettings lmisGeneralSettings)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisGeneralSettings);

		if (lmisGeneralSettings == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.lmis.model.LmisGeneralSettings");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateLmisGeneralSettings",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.lmis.model.LmisGeneralSettings)ClpSerializer.translateOutput(returnObj);
	}

	public larion.progate.lmis.model.LmisGeneralSettings updateLmisGeneralSettings(
		larion.progate.lmis.model.LmisGeneralSettings lmisGeneralSettings,
		boolean merge) throws com.liferay.portal.SystemException {
		Object paramObj0 = ClpSerializer.translateInput(lmisGeneralSettings);

		if (lmisGeneralSettings == null) {
			paramObj0 = new NullWrapper(
					"larion.progate.lmis.model.LmisGeneralSettings");
		}

		Object paramObj1 = new BooleanWrapper(merge);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateLmisGeneralSettings",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (larion.progate.lmis.model.LmisGeneralSettings)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.Set<Integer> getArrayListPmUID(
		java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> ls,
		int userId) {
		Object paramObj0 = ClpSerializer.translateInput(ls);

		if (ls == null) {
			paramObj0 = new NullWrapper("java.util.List");
		}

		Object paramObj1 = new IntegerWrapper(userId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getArrayListPmUID",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Set<Integer>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<Integer> getListBodUIDofUID(int rootId, int userId) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getListBodUIDofUID",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<Integer>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<Integer> getListPmIdOrBodIdByUserId(int rootId,
		int userId) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getListPmIdOrBodIdByUserId",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<Integer>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.Set<Integer> getArrayListBodUID(
		java.util.List<larion.progate.lmis.model.LmisViewStaffMapping> ls,
		int userId) {
		Object paramObj0 = ClpSerializer.translateInput(ls);

		if (ls == null) {
			paramObj0 = new NullWrapper("java.util.List");
		}

		Object paramObj1 = new IntegerWrapper(userId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getArrayListBodUID",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Set<Integer>)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getUserRoleByUID(int userId, int orgId) {
		Object paramObj0 = new IntegerWrapper(userId);

		Object paramObj1 = new IntegerWrapper(orgId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getUserRoleByUID",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<Integer> getListPmAndBodOfUser(int rootId, int userId) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getListPmAndBodOfUser",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<Integer>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.Date GetToday() throws com.liferay.portal.SystemException {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("GetToday", new Object[0]);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Date)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.Date GetYesterdayDate()
		throws com.liferay.portal.SystemException {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("GetYesterdayDate",
					new Object[0]);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Date)ClpSerializer.translateOutput(returnObj);
	}

	public long getTimeDiff(java.util.Date hour1, java.util.Date hour2) {
		Object paramObj0 = ClpSerializer.translateInput(hour1);

		if (hour1 == null) {
			paramObj0 = new NullWrapper("java.util.Date");
		}

		Object paramObj1 = ClpSerializer.translateInput(hour2);

		if (hour2 == null) {
			paramObj1 = new NullWrapper("java.util.Date");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getTimeDiff",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	public java.lang.String getEmailUser(int userId, int rootId) {
		Object paramObj0 = new IntegerWrapper(userId);

		Object paramObj1 = new IntegerWrapper(rootId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getEmailUser",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getEmailOrg(int orgId) {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getEmailOrg",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.Organization> getOrganizationByRootId(
		int rootId) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getOrganizationByRootId",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<larion.progate.model.Organization>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.ArrayList<Integer> getListBodUIDbyRootId(int rootId) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getListBodUIDbyRootId",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.ArrayList<Integer>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.ArrayList<Integer> getListUserMangeByPM(int rootId,
		int pmId) throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(pmId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getListUserMangeByPM",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.ArrayList<Integer>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.Date getBlock(int rootId, int userId,
		java.lang.String dayStr, int sessiontype, int blocktype) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = ClpSerializer.translateInput(dayStr);

		if (dayStr == null) {
			paramObj2 = new NullWrapper("java.lang.String");
		}

		Object paramObj3 = new IntegerWrapper(sessiontype);

		Object paramObj4 = new IntegerWrapper(blocktype);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getBlock",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4
					});
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Date)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getBlockStr(int rootId, int userId,
		java.lang.String dayStr, int sessiontype, int blocktype) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = ClpSerializer.translateInput(dayStr);

		if (dayStr == null) {
			paramObj2 = new NullWrapper("java.lang.String");
		}

		Object paramObj3 = new IntegerWrapper(sessiontype);

		Object paramObj4 = new IntegerWrapper(blocktype);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getBlockStr",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4
					});
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.Date getRangeGoHomeEarly(int rootId,
		java.lang.String sessionName) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = ClpSerializer.translateInput(sessionName);

		if (sessionName == null) {
			paramObj1 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getRangeGoHomeEarly",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Date)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<larion.progate.model.ProgateOrganizationsStaffs> loadListProGateOrgStaff(
		int orgId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(orgId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("loadListProGateOrgStaff",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.PortalException) {
				throw (com.liferay.portal.PortalException)t;
			}

			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<larion.progate.model.ProgateOrganizationsStaffs>)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String caculateTotalDayOffHavePermission(int userid,
		int month, int year, int rootid)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(userid);

		Object paramObj1 = new IntegerWrapper(month);

		Object paramObj2 = new IntegerWrapper(year);

		Object paramObj3 = new IntegerWrapper(rootid);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("caculateTotalDayOffHavePermission",
					new Object[] { paramObj0, paramObj1, paramObj2, paramObj3 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String caculateTotalDayOffDontHavePermission(int userid,
		int month, int year, int rootid)
		throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(userid);

		Object paramObj1 = new IntegerWrapper(month);

		Object paramObj2 = new IntegerWrapper(year);

		Object paramObj3 = new IntegerWrapper(rootid);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("caculateTotalDayOffDontHavePermission",
					new Object[] { paramObj0, paramObj1, paramObj2, paramObj3 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String caculateTimeRemainTimeChangeRequest(int userid,
		int rootid) throws com.liferay.portal.SystemException {
		Object paramObj0 = new IntegerWrapper(userid);

		Object paramObj1 = new IntegerWrapper(rootid);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("caculateTimeRemainTimeChangeRequest",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.SystemException) {
				throw (com.liferay.portal.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<String> getListEmailByEmailType(int rootId,
		int userId, int emailType) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = new IntegerWrapper(emailType);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getListEmailByEmailType",
					new Object[] { paramObj0, paramObj1, paramObj2 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<String>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<String> getListEmail(
		java.util.List<Integer> user_Ids, int userId, int rootId, int id) {
		Object paramObj0 = ClpSerializer.translateInput(user_Ids);

		if (user_Ids == null) {
			paramObj0 = new NullWrapper("java.util.List");
		}

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = new IntegerWrapper(rootId);

		Object paramObj3 = new IntegerWrapper(id);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getListEmail",
					new Object[] { paramObj0, paramObj1, paramObj2, paramObj3 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<String>)ClpSerializer.translateOutput(returnObj);
	}

	public long DateDiff(java.util.Date dMax, java.util.Date dMin) {
		Object paramObj0 = ClpSerializer.translateInput(dMax);

		if (dMax == null) {
			paramObj0 = new NullWrapper("java.util.Date");
		}

		Object paramObj1 = ClpSerializer.translateInput(dMin);

		if (dMin == null) {
			paramObj1 = new NullWrapper("java.util.Date");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("DateDiff",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	public double getTotalDayAwardPrevYear(int rootid, int userId, int year) {
		Object paramObj0 = new IntegerWrapper(rootid);

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = new IntegerWrapper(year);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getTotalDayAwardPrevYear",
					new Object[] { paramObj0, paramObj1, paramObj2 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Double)returnObj).doubleValue();
	}

	public double getTotalDayAward(int rootid, int userId, int year) {
		Object paramObj0 = new IntegerWrapper(rootid);

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = new IntegerWrapper(year);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getTotalDayAward",
					new Object[] { paramObj0, paramObj1, paramObj2 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Double)returnObj).doubleValue();
	}

	public double getTotalDayCompensation(int rootid, int userId, int year,
		int month) {
		Object paramObj0 = new IntegerWrapper(rootid);

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = new IntegerWrapper(year);

		Object paramObj3 = new IntegerWrapper(month);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getTotalDayCompensation",
					new Object[] { paramObj0, paramObj1, paramObj2, paramObj3 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Double)returnObj).doubleValue();
	}

	public double getTotalWorkingTimeOfUID(int rootId, int userId, int month,
		int year) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = new IntegerWrapper(month);

		Object paramObj3 = new IntegerWrapper(year);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getTotalWorkingTimeOfUID",
					new Object[] { paramObj0, paramObj1, paramObj2, paramObj3 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Double)returnObj).doubleValue();
	}

	public double getTypeAbsenceInMonthlyDetail(int rootId, int userId,
		int mon, int year, int absenceId, int type) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = new IntegerWrapper(mon);

		Object paramObj3 = new IntegerWrapper(year);

		Object paramObj4 = new IntegerWrapper(absenceId);

		Object paramObj5 = new IntegerWrapper(type);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getTypeAbsenceInMonthlyDetail",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
						paramObj5
					});
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Double)returnObj).doubleValue();
	}

	public double getTypeAbsenceInYearDetail(int rootId, int userId, int year,
		int absenceId, int type) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = new IntegerWrapper(year);

		Object paramObj3 = new IntegerWrapper(absenceId);

		Object paramObj4 = new IntegerWrapper(type);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getTypeAbsenceInYearDetail",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4
					});
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Double)returnObj).doubleValue();
	}

	public double getTotalDayOffOfUID(int rootId, int userId, int month,
		int year) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = new IntegerWrapper(month);

		Object paramObj3 = new IntegerWrapper(year);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getTotalDayOffOfUID",
					new Object[] { paramObj0, paramObj1, paramObj2, paramObj3 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Double)returnObj).doubleValue();
	}

	public double getTotalTimeFinalRewardOfUID(int rootId, int userId,
		int month, int year) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = new IntegerWrapper(month);

		Object paramObj3 = new IntegerWrapper(year);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getTotalTimeFinalRewardOfUID",
					new Object[] { paramObj0, paramObj1, paramObj2, paramObj3 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Double)returnObj).doubleValue();
	}

	public java.util.List<larion.progate.lmis.model.LmisOverTimeTypes> getListOverTimeTypeOfRootId(
		int rootId) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getListOverTimeTypeOfRootId",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<larion.progate.lmis.model.LmisOverTimeTypes>)ClpSerializer.translateOutput(returnObj);
	}

	public double getTotalHourOverTimeOfStaffInMonth(int rootId, int userId,
		int month, int year, int otId, boolean Eff) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = new IntegerWrapper(month);

		Object paramObj3 = new IntegerWrapper(year);

		Object paramObj4 = new IntegerWrapper(otId);

		Object paramObj5 = new BooleanWrapper(Eff);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getTotalHourOverTimeOfStaffInMonth",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
						paramObj5
					});
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Double)returnObj).doubleValue();
	}

	public double getOverTimeHourFinalOfStaffInMonth(int rootId, int userId,
		int month, int year) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = new IntegerWrapper(month);

		Object paramObj3 = new IntegerWrapper(year);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getOverTimeHourFinalOfStaffInMonth",
					new Object[] { paramObj0, paramObj1, paramObj2, paramObj3 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Double)returnObj).doubleValue();
	}

	public double getTotalDayAbsenceCompensasion(int rootId, int userId,
		int month, int year, int type) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = new IntegerWrapper(month);

		Object paramObj3 = new IntegerWrapper(year);

		Object paramObj4 = new IntegerWrapper(type);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getTotalDayAbsenceCompensasion",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4
					});
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Double)returnObj).doubleValue();
	}

	public double getDayCompensationNextMonthOfStaffInMonth(int rootId,
		int userId, int month, int year) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = new IntegerWrapper(month);

		Object paramObj3 = new IntegerWrapper(year);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getDayCompensationNextMonthOfStaffInMonth",
					new Object[] { paramObj0, paramObj1, paramObj2, paramObj3 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Double)returnObj).doubleValue();
	}

	public double getTotalHourOverTimeReward(int rootId, int userId, int month,
		int year) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = new IntegerWrapper(month);

		Object paramObj3 = new IntegerWrapper(year);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getTotalHourOverTimeReward",
					new Object[] { paramObj0, paramObj1, paramObj2, paramObj3 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Double)returnObj).doubleValue();
	}

	public java.util.Date getDetailSummayReportDate(int rootId, int userId,
		int year, int monStart, int monEnd, int type) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = new IntegerWrapper(year);

		Object paramObj3 = new IntegerWrapper(monStart);

		Object paramObj4 = new IntegerWrapper(monEnd);

		Object paramObj5 = new IntegerWrapper(type);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getDetailSummayReportDate",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
						paramObj5
					});
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Date)ClpSerializer.translateOutput(returnObj);
	}

	public int getDetailSummayReportInt(int rootId, int userId, int year,
		int monStart, int monEnd, int type) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = new IntegerWrapper(year);

		Object paramObj3 = new IntegerWrapper(monStart);

		Object paramObj4 = new IntegerWrapper(monEnd);

		Object paramObj5 = new IntegerWrapper(type);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getDetailSummayReportInt",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
						paramObj5
					});
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public double getDetailSummayReportDouble(int rootId, int userId, int year,
		int monStart, int monEnd, int type) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = new IntegerWrapper(year);

		Object paramObj3 = new IntegerWrapper(monStart);

		Object paramObj4 = new IntegerWrapper(monEnd);

		Object paramObj5 = new IntegerWrapper(type);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getDetailSummayReportDouble",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
						paramObj5
					});
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Double)returnObj).doubleValue();
	}

	public java.util.List<larion.progate.lmis.model.LmisGeneralSettings> getInfoConfigFileAttendance(
		int rootId) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getInfoConfigFileAttendance",
					new Object[] { paramObj0 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<larion.progate.lmis.model.LmisGeneralSettings>)ClpSerializer.translateOutput(returnObj);
	}

	public boolean updateInfoConfigFileAttendance(int rootId,
		java.lang.String code, java.lang.String name, java.lang.String chkIn,
		java.lang.String chkOut) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = ClpSerializer.translateInput(code);

		if (code == null) {
			paramObj1 = new NullWrapper("java.lang.String");
		}

		Object paramObj2 = ClpSerializer.translateInput(name);

		if (name == null) {
			paramObj2 = new NullWrapper("java.lang.String");
		}

		Object paramObj3 = ClpSerializer.translateInput(chkIn);

		if (chkIn == null) {
			paramObj3 = new NullWrapper("java.lang.String");
		}

		Object paramObj4 = ClpSerializer.translateInput(chkOut);

		if (chkOut == null) {
			paramObj4 = new NullWrapper("java.lang.String");
		}

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("updateInfoConfigFileAttendance",
					new Object[] {
						paramObj0, paramObj1, paramObj2, paramObj3, paramObj4
					});
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	public double getTotalDayAwardRemaining(int rootId, int userId, int year) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = new IntegerWrapper(year);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getTotalDayAwardRemaining",
					new Object[] { paramObj0, paramObj1, paramObj2 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Double)returnObj).doubleValue();
	}

	public double getTotalDayAwardPrevYearRemaining(int rootId, int userId,
		int year) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = new IntegerWrapper(year);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getTotalDayAwardPrevYearRemaining",
					new Object[] { paramObj0, paramObj1, paramObj2 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Double)returnObj).doubleValue();
	}

	public double getTotalDayCompensationRemaining(int rootId, int userId,
		int mon, int year) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object paramObj2 = new IntegerWrapper(mon);

		Object paramObj3 = new IntegerWrapper(year);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getTotalDayCompensationRemaining",
					new Object[] { paramObj0, paramObj1, paramObj2, paramObj3 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Double)returnObj).doubleValue();
	}

	public java.lang.String getAppName() {
		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getAppName", new Object[0]);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getStaffCodeByUID(int rootId, int userId) {
		Object paramObj0 = new IntegerWrapper(rootId);

		Object paramObj1 = new IntegerWrapper(userId);

		Object returnObj = null;

		try {
			returnObj = _classLoaderProxy.invoke("getStaffCodeByUID",
					new Object[] { paramObj0, paramObj1 });
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	private ClassLoaderProxy _classLoaderProxy;
}