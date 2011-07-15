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
 * <a href="ProgatePortalMenuPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface ProgatePortalMenuPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.model.ProgatePortalMenu progatePortalMenu);

	public void cacheResult(
		java.util.List<larion.progate.model.ProgatePortalMenu> progatePortalMenus);

	public void clearCache();

	public larion.progate.model.ProgatePortalMenu create(
		java.lang.Integer portalMenuId);

	public larion.progate.model.ProgatePortalMenu remove(
		java.lang.Integer portalMenuId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgatePortalMenuException;

	public larion.progate.model.ProgatePortalMenu remove(
		larion.progate.model.ProgatePortalMenu progatePortalMenu)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgatePortalMenu update(
		larion.progate.model.ProgatePortalMenu progatePortalMenu)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgatePortalMenu update(
		larion.progate.model.ProgatePortalMenu progatePortalMenu, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgatePortalMenu updateImpl(
		larion.progate.model.ProgatePortalMenu progatePortalMenu, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgatePortalMenu findByPrimaryKey(
		java.lang.Integer portalMenuId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgatePortalMenuException;

	public larion.progate.model.ProgatePortalMenu fetchByPrimaryKey(
		java.lang.Integer portalMenuId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgatePortalMenu> findBylayoutId(
		int layoutId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgatePortalMenu> findBylayoutId(
		int layoutId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgatePortalMenu> findBylayoutId(
		int layoutId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgatePortalMenu findBylayoutId_First(
		int layoutId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgatePortalMenuException;

	public larion.progate.model.ProgatePortalMenu findBylayoutId_Last(
		int layoutId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgatePortalMenuException;

	public larion.progate.model.ProgatePortalMenu[] findBylayoutId_PrevAndNext(
		java.lang.Integer portalMenuId, int layoutId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgatePortalMenuException;

	public java.util.List<larion.progate.model.ProgatePortalMenu> findByroleId(
		int roleId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgatePortalMenu> findByroleId(
		int roleId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgatePortalMenu> findByroleId(
		int roleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgatePortalMenu findByroleId_First(
		int roleId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgatePortalMenuException;

	public larion.progate.model.ProgatePortalMenu findByroleId_Last(
		int roleId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgatePortalMenuException;

	public larion.progate.model.ProgatePortalMenu[] findByroleId_PrevAndNext(
		java.lang.Integer portalMenuId, int roleId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgatePortalMenuException;

	public java.util.List<larion.progate.model.ProgatePortalMenu> findByorgId(
		int orgId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgatePortalMenu> findByorgId(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgatePortalMenu> findByorgId(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgatePortalMenu findByorgId_First(int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgatePortalMenuException;

	public larion.progate.model.ProgatePortalMenu findByorgId_Last(int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgatePortalMenuException;

	public larion.progate.model.ProgatePortalMenu[] findByorgId_PrevAndNext(
		java.lang.Integer portalMenuId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgatePortalMenuException;

	public java.util.List<larion.progate.model.ProgatePortalMenu> findByname(
		java.lang.String name) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgatePortalMenu> findByname(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgatePortalMenu> findByname(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgatePortalMenu findByname_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgatePortalMenuException;

	public larion.progate.model.ProgatePortalMenu findByname_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgatePortalMenuException;

	public larion.progate.model.ProgatePortalMenu[] findByname_PrevAndNext(
		java.lang.Integer portalMenuId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgatePortalMenuException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgatePortalMenu> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgatePortalMenu> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgatePortalMenu> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeBylayoutId(int layoutId)
		throws com.liferay.portal.SystemException;

	public void removeByroleId(int roleId)
		throws com.liferay.portal.SystemException;

	public void removeByorgId(int orgId)
		throws com.liferay.portal.SystemException;

	public void removeByname(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countBylayoutId(int layoutId)
		throws com.liferay.portal.SystemException;

	public int countByroleId(int roleId)
		throws com.liferay.portal.SystemException;

	public int countByorgId(int orgId)
		throws com.liferay.portal.SystemException;

	public int countByname(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}