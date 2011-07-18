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
 * <a href="ProGateMenuViewUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateMenuViewUtil {
	public static void cacheResult(
		larion.progate.model.ProGateMenuView proGateMenuView) {
		getPersistence().cacheResult(proGateMenuView);
	}

	public static void cacheResult(
		java.util.List<larion.progate.model.ProGateMenuView> proGateMenuViews) {
		getPersistence().cacheResult(proGateMenuViews);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.model.ProGateMenuView create(
		java.lang.String name) {
		return getPersistence().create(name);
	}

	public static larion.progate.model.ProGateMenuView remove(
		java.lang.String name)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateMenuViewException {
		return getPersistence().remove(name);
	}

	public static larion.progate.model.ProGateMenuView remove(
		larion.progate.model.ProGateMenuView proGateMenuView)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(proGateMenuView);
	}

	public static larion.progate.model.ProGateMenuView update(
		larion.progate.model.ProGateMenuView proGateMenuView)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(proGateMenuView);
	}

	public static larion.progate.model.ProGateMenuView update(
		larion.progate.model.ProGateMenuView proGateMenuView, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(proGateMenuView, merge);
	}

	public static larion.progate.model.ProGateMenuView updateImpl(
		larion.progate.model.ProGateMenuView proGateMenuView, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(proGateMenuView, merge);
	}

	public static larion.progate.model.ProGateMenuView findByPrimaryKey(
		java.lang.String name)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateMenuViewException {
		return getPersistence().findByPrimaryKey(name);
	}

	public static larion.progate.model.ProGateMenuView fetchByPrimaryKey(
		java.lang.String name) throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(name);
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

	public static java.util.List<larion.progate.model.ProGateMenuView> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.model.ProGateMenuView> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.model.ProGateMenuView> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static ProGateMenuViewPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(ProGateMenuViewPersistence persistence) {
		_persistence = persistence;
	}

	private static ProGateMenuViewPersistence _persistence;
}