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

/**
 * <a href="ProgateLayoutsMenusUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgateLayoutsMenusUtil {
	public static void cacheResult(
		larion.progate.model.ProgateLayoutsMenus progateLayoutsMenus) {
		getPersistence().cacheResult(progateLayoutsMenus);
	}

	public static void cacheResult(
		java.util.List<larion.progate.model.ProgateLayoutsMenus> progateLayoutsMenuses) {
		getPersistence().cacheResult(progateLayoutsMenuses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.model.ProgateLayoutsMenus create(
		int ProgateLayoutsMenusId) {
		return getPersistence().create(ProgateLayoutsMenusId);
	}

	public static larion.progate.model.ProgateLayoutsMenus remove(
		int ProgateLayoutsMenusId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateLayoutsMenusException {
		return getPersistence().remove(ProgateLayoutsMenusId);
	}

	public static larion.progate.model.ProgateLayoutsMenus remove(
		larion.progate.model.ProgateLayoutsMenus progateLayoutsMenus)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(progateLayoutsMenus);
	}

	public static larion.progate.model.ProgateLayoutsMenus update(
		larion.progate.model.ProgateLayoutsMenus progateLayoutsMenus)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(progateLayoutsMenus);
	}

	public static larion.progate.model.ProgateLayoutsMenus update(
		larion.progate.model.ProgateLayoutsMenus progateLayoutsMenus,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(progateLayoutsMenus, merge);
	}

	public static larion.progate.model.ProgateLayoutsMenus updateImpl(
		larion.progate.model.ProgateLayoutsMenus progateLayoutsMenus,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(progateLayoutsMenus, merge);
	}

	public static larion.progate.model.ProgateLayoutsMenus findByPrimaryKey(
		int ProgateLayoutsMenusId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateLayoutsMenusException {
		return getPersistence().findByPrimaryKey(ProgateLayoutsMenusId);
	}

	public static larion.progate.model.ProgateLayoutsMenus fetchByPrimaryKey(
		int ProgateLayoutsMenusId) throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(ProgateLayoutsMenusId);
	}

	public static java.util.List<larion.progate.model.ProgateLayoutsMenus> findBylayoutId(
		int layoutId) throws com.liferay.portal.SystemException {
		return getPersistence().findBylayoutId(layoutId);
	}

	public static java.util.List<larion.progate.model.ProgateLayoutsMenus> findBylayoutId(
		int layoutId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBylayoutId(layoutId, start, end);
	}

	public static java.util.List<larion.progate.model.ProgateLayoutsMenus> findBylayoutId(
		int layoutId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBylayoutId(layoutId, start, end, obc);
	}

	public static larion.progate.model.ProgateLayoutsMenus findBylayoutId_First(
		int layoutId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateLayoutsMenusException {
		return getPersistence().findBylayoutId_First(layoutId, obc);
	}

	public static larion.progate.model.ProgateLayoutsMenus findBylayoutId_Last(
		int layoutId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateLayoutsMenusException {
		return getPersistence().findBylayoutId_Last(layoutId, obc);
	}

	public static larion.progate.model.ProgateLayoutsMenus[] findBylayoutId_PrevAndNext(
		int ProgateLayoutsMenusId, int layoutId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProgateLayoutsMenusException {
		return getPersistence()
				   .findBylayoutId_PrevAndNext(ProgateLayoutsMenusId, layoutId,
			obc);
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

	public static java.util.List<larion.progate.model.ProgateLayoutsMenus> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.model.ProgateLayoutsMenus> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.model.ProgateLayoutsMenus> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeBylayoutId(int layoutId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBylayoutId(layoutId);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countBylayoutId(int layoutId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBylayoutId(layoutId);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static ProgateLayoutsMenusPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(ProgateLayoutsMenusPersistence persistence) {
		_persistence = persistence;
	}

	private static ProgateLayoutsMenusPersistence _persistence;
}