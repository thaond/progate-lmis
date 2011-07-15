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

package larion.progate.cds.service.persistence;

/**
 * <a href="ViewEmployeesInProjectsUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewEmployeesInProjectsUtil {
	public static void cacheResult(
		larion.progate.cds.model.ViewEmployeesInProjects viewEmployeesInProjects) {
		getPersistence().cacheResult(viewEmployeesInProjects);
	}

	public static void cacheResult(
		java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> viewEmployeesInProjectses) {
		getPersistence().cacheResult(viewEmployeesInProjectses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.cds.model.ViewEmployeesInProjects create(
		java.lang.String id) {
		return getPersistence().create(id);
	}

	public static larion.progate.cds.model.ViewEmployeesInProjects remove(
		java.lang.String id)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchViewEmployeesInProjectsException {
		return getPersistence().remove(id);
	}

	public static larion.progate.cds.model.ViewEmployeesInProjects remove(
		larion.progate.cds.model.ViewEmployeesInProjects viewEmployeesInProjects)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(viewEmployeesInProjects);
	}

	public static larion.progate.cds.model.ViewEmployeesInProjects update(
		larion.progate.cds.model.ViewEmployeesInProjects viewEmployeesInProjects)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(viewEmployeesInProjects);
	}

	public static larion.progate.cds.model.ViewEmployeesInProjects update(
		larion.progate.cds.model.ViewEmployeesInProjects viewEmployeesInProjects,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(viewEmployeesInProjects, merge);
	}

	public static larion.progate.cds.model.ViewEmployeesInProjects updateImpl(
		larion.progate.cds.model.ViewEmployeesInProjects viewEmployeesInProjects,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(viewEmployeesInProjects, merge);
	}

	public static larion.progate.cds.model.ViewEmployeesInProjects findByPrimaryKey(
		java.lang.String id)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchViewEmployeesInProjectsException {
		return getPersistence().findByPrimaryKey(id);
	}

	public static larion.progate.cds.model.ViewEmployeesInProjects fetchByPrimaryKey(
		java.lang.String id) throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> findByRootId(
		int rootId) throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId);
	}

	public static java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> findByRootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId, start, end);
	}

	public static java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> findByRootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByRootId(rootId, start, end, obc);
	}

	public static larion.progate.cds.model.ViewEmployeesInProjects findByRootId_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchViewEmployeesInProjectsException {
		return getPersistence().findByRootId_First(rootId, obc);
	}

	public static larion.progate.cds.model.ViewEmployeesInProjects findByRootId_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchViewEmployeesInProjectsException {
		return getPersistence().findByRootId_Last(rootId, obc);
	}

	public static larion.progate.cds.model.ViewEmployeesInProjects[] findByRootId_PrevAndNext(
		java.lang.String id, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchViewEmployeesInProjectsException {
		return getPersistence().findByRootId_PrevAndNext(id, rootId, obc);
	}

	public static java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> findByOrgId(
		int orgId) throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgId(orgId);
	}

	public static java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> findByOrgId(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgId(orgId, start, end);
	}

	public static java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> findByOrgId(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByOrgId(orgId, start, end, obc);
	}

	public static larion.progate.cds.model.ViewEmployeesInProjects findByOrgId_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchViewEmployeesInProjectsException {
		return getPersistence().findByOrgId_First(orgId, obc);
	}

	public static larion.progate.cds.model.ViewEmployeesInProjects findByOrgId_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchViewEmployeesInProjectsException {
		return getPersistence().findByOrgId_Last(orgId, obc);
	}

	public static larion.progate.cds.model.ViewEmployeesInProjects[] findByOrgId_PrevAndNext(
		java.lang.String id, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchViewEmployeesInProjectsException {
		return getPersistence().findByOrgId_PrevAndNext(id, orgId, obc);
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

	public static java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByRootId(int rootId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByRootId(rootId);
	}

	public static void removeByOrgId(int orgId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByOrgId(orgId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByRootId(int rootId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByRootId(rootId);
	}

	public static int countByOrgId(int orgId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByOrgId(orgId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static ViewEmployeesInProjectsPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(ViewEmployeesInProjectsPersistence persistence) {
		_persistence = persistence;
	}

	private static ViewEmployeesInProjectsPersistence _persistence;
}