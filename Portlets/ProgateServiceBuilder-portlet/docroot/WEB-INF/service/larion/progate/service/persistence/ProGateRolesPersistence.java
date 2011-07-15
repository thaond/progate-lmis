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

package larion.progate.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * <a href="ProGateRolesPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface ProGateRolesPersistence extends BasePersistence {
	public void cacheResult(larion.progate.model.ProGateRoles proGateRoles);

	public void cacheResult(
		java.util.List<larion.progate.model.ProGateRoles> proGateRoleses);

	public void clearCache();

	public larion.progate.model.ProGateRoles create(java.lang.Integer roleId);

	public larion.progate.model.ProGateRoles remove(java.lang.Integer roleId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateRolesException;

	public larion.progate.model.ProGateRoles remove(
		larion.progate.model.ProGateRoles proGateRoles)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateRoles update(
		larion.progate.model.ProGateRoles proGateRoles)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateRoles update(
		larion.progate.model.ProGateRoles proGateRoles, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateRoles updateImpl(
		larion.progate.model.ProGateRoles proGateRoles, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateRoles findByPrimaryKey(
		java.lang.Integer roleId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateRolesException;

	public larion.progate.model.ProGateRoles fetchByPrimaryKey(
		java.lang.Integer roleId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateRoles> findByroleType(
		int roleType) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateRoles> findByroleType(
		int roleType, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateRoles> findByroleType(
		int roleType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateRoles findByroleType_First(
		int roleType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateRolesException;

	public larion.progate.model.ProGateRoles findByroleType_Last(int roleType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateRolesException;

	public larion.progate.model.ProGateRoles[] findByroleType_PrevAndNext(
		java.lang.Integer roleId, int roleType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateRolesException;

	public java.util.List<larion.progate.model.ProGateRoles> findByname(
		java.lang.String name) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateRoles> findByname(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateRoles> findByname(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateRoles findByname_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateRolesException;

	public larion.progate.model.ProGateRoles findByname_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateRolesException;

	public larion.progate.model.ProGateRoles[] findByname_PrevAndNext(
		java.lang.Integer roleId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateRolesException;

	public java.util.List<larion.progate.model.ProGateRoles> findBypriority(
		int priority) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateRoles> findBypriority(
		int priority, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateRoles> findBypriority(
		int priority, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateRoles findBypriority_First(
		int priority, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateRolesException;

	public larion.progate.model.ProGateRoles findBypriority_Last(int priority,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateRolesException;

	public larion.progate.model.ProGateRoles[] findBypriority_PrevAndNext(
		java.lang.Integer roleId, int priority,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateRolesException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateRoles> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateRoles> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateRoles> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByroleType(int roleType)
		throws com.liferay.portal.SystemException;

	public void removeByname(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public void removeBypriority(int priority)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByroleType(int roleType)
		throws com.liferay.portal.SystemException;

	public int countByname(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public int countBypriority(int priority)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}