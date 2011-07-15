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
 * <a href="ProgateLayoutsMenusPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface ProgateLayoutsMenusPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.model.ProgateLayoutsMenus progateLayoutsMenus);

	public void cacheResult(
		java.util.List<larion.progate.model.ProgateLayoutsMenus> progateLayoutsMenuses);

	public void clearCache();

	public larion.progate.model.ProgateLayoutsMenus create(
		int ProgateLayoutsMenusId);

	public larion.progate.model.ProgateLayoutsMenus remove(
		int ProgateLayoutsMenusId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateLayoutsMenusException;

	public larion.progate.model.ProgateLayoutsMenus remove(
		larion.progate.model.ProgateLayoutsMenus progateLayoutsMenus)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateLayoutsMenus update(
		larion.progate.model.ProgateLayoutsMenus progateLayoutsMenus)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateLayoutsMenus update(
		larion.progate.model.ProgateLayoutsMenus progateLayoutsMenus,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateLayoutsMenus updateImpl(
		larion.progate.model.ProgateLayoutsMenus progateLayoutsMenus,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateLayoutsMenus findByPrimaryKey(
		int ProgateLayoutsMenusId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateLayoutsMenusException;

	public larion.progate.model.ProgateLayoutsMenus fetchByPrimaryKey(
		int ProgateLayoutsMenusId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateLayoutsMenus> findBylayoutId(
		int layoutId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateLayoutsMenus> findBylayoutId(
		int layoutId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateLayoutsMenus> findBylayoutId(
		int layoutId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProgateLayoutsMenus findBylayoutId_First(
		int layoutId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateLayoutsMenusException;

	public larion.progate.model.ProgateLayoutsMenus findBylayoutId_Last(
		int layoutId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateLayoutsMenusException;

	public larion.progate.model.ProgateLayoutsMenus[] findBylayoutId_PrevAndNext(
		int ProgateLayoutsMenusId, int layoutId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateLayoutsMenusException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateLayoutsMenus> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateLayoutsMenus> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProgateLayoutsMenus> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeBylayoutId(int layoutId)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countBylayoutId(int layoutId)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}