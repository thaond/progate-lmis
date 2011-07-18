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
 * <a href="LevelLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LevelLocalServiceUtil {
	public static larion.progate.cds.model.Level addLevel(
		larion.progate.cds.model.Level level)
		throws com.liferay.portal.SystemException {
		return getService().addLevel(level);
	}

	public static larion.progate.cds.model.Level createLevel(
		java.lang.Integer levelId) {
		return getService().createLevel(levelId);
	}

	public static void deleteLevel(java.lang.Integer levelId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		getService().deleteLevel(levelId);
	}

	public static void deleteLevel(larion.progate.cds.model.Level level)
		throws com.liferay.portal.SystemException {
		getService().deleteLevel(level);
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

	public static larion.progate.cds.model.Level getLevel(
		java.lang.Integer levelId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLevel(levelId);
	}

	public static java.util.List<larion.progate.cds.model.Level> getLevels(
		int start, int end) throws com.liferay.portal.SystemException {
		return getService().getLevels(start, end);
	}

	public static int getLevelsCount()
		throws com.liferay.portal.SystemException {
		return getService().getLevelsCount();
	}

	public static larion.progate.cds.model.Level updateLevel(
		larion.progate.cds.model.Level level)
		throws com.liferay.portal.SystemException {
		return getService().updateLevel(level);
	}

	public static larion.progate.cds.model.Level updateLevel(
		larion.progate.cds.model.Level level, boolean merge)
		throws com.liferay.portal.SystemException {
		return getService().updateLevel(level, merge);
	}

	public static boolean deleteCdsLevel(int levelId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().deleteCdsLevel(levelId);
	}

	public static boolean addCdsLevel(int competencyId, java.lang.String name,
		int numberOrder, int createdBy)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService()
				   .addCdsLevel(competencyId, name, numberOrder, createdBy);
	}

	public static boolean setAliasNameOfSlots(int levelId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().setAliasNameOfSlots(levelId);
	}

	public static boolean updateCdsLevel(int levelId, java.lang.String name,
		int numberOrder, int updateBy)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().updateCdsLevel(levelId, name, numberOrder, updateBy);
	}

	public static java.util.List<larion.progate.cds.model.Level> getLevelListByCompetencyId(
		int competencyId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLevelListByCompetencyId(competencyId);
	}

	public static java.util.List<larion.progate.cds.model.Level> getLevelListByLevelName(
		java.lang.String levelName)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().getLevelListByLevelName(levelName);
	}

	public static boolean checkLevelName(int rootId,
		java.lang.String levelName, int competencyId)
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException {
		return getService().checkLevelName(rootId, levelName, competencyId);
	}

	public static void clearService() {
		_service = null;
	}

	public static LevelLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					LevelLocalServiceUtil.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new LevelLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(LevelLocalService service) {
		_service = service;
	}

	private static LevelLocalService _service;
}