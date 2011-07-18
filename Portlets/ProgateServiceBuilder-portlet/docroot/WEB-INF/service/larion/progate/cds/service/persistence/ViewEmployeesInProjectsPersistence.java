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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * <a href="ViewEmployeesInProjectsPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface ViewEmployeesInProjectsPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.cds.model.ViewEmployeesInProjects viewEmployeesInProjects);

	public void cacheResult(
		java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> viewEmployeesInProjectses);

	public void clearCache();

	public larion.progate.cds.model.ViewEmployeesInProjects create(
		java.lang.String id);

	public larion.progate.cds.model.ViewEmployeesInProjects remove(
		java.lang.String id)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchViewEmployeesInProjectsException;

	public larion.progate.cds.model.ViewEmployeesInProjects remove(
		larion.progate.cds.model.ViewEmployeesInProjects viewEmployeesInProjects)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.ViewEmployeesInProjects update(
		larion.progate.cds.model.ViewEmployeesInProjects viewEmployeesInProjects)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.ViewEmployeesInProjects update(
		larion.progate.cds.model.ViewEmployeesInProjects viewEmployeesInProjects,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.ViewEmployeesInProjects updateImpl(
		larion.progate.cds.model.ViewEmployeesInProjects viewEmployeesInProjects,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.ViewEmployeesInProjects findByPrimaryKey(
		java.lang.String id)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchViewEmployeesInProjectsException;

	public larion.progate.cds.model.ViewEmployeesInProjects fetchByPrimaryKey(
		java.lang.String id) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> findByRootId(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> findByRootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> findByRootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.ViewEmployeesInProjects findByRootId_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchViewEmployeesInProjectsException;

	public larion.progate.cds.model.ViewEmployeesInProjects findByRootId_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchViewEmployeesInProjectsException;

	public larion.progate.cds.model.ViewEmployeesInProjects[] findByRootId_PrevAndNext(
		java.lang.String id, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchViewEmployeesInProjectsException;

	public java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> findByOrgId(
		int orgId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> findByOrgId(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> findByOrgId(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.cds.model.ViewEmployeesInProjects findByOrgId_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchViewEmployeesInProjectsException;

	public larion.progate.cds.model.ViewEmployeesInProjects findByOrgId_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchViewEmployeesInProjectsException;

	public larion.progate.cds.model.ViewEmployeesInProjects[] findByOrgId_PrevAndNext(
		java.lang.String id, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchViewEmployeesInProjectsException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.cds.model.ViewEmployeesInProjects> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByRootId(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeByOrgId(int orgId)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByRootId(int rootId)
		throws com.liferay.portal.SystemException;

	public int countByOrgId(int orgId)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}