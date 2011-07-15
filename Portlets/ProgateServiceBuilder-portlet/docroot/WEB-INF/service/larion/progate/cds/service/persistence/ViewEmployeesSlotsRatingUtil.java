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
 * <a href="ViewEmployeesSlotsRatingUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewEmployeesSlotsRatingUtil {
	public static void cacheResult(
		larion.progate.cds.model.ViewEmployeesSlotsRating viewEmployeesSlotsRating) {
		getPersistence().cacheResult(viewEmployeesSlotsRating);
	}

	public static void cacheResult(
		java.util.List<larion.progate.cds.model.ViewEmployeesSlotsRating> viewEmployeesSlotsRatings) {
		getPersistence().cacheResult(viewEmployeesSlotsRatings);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.cds.model.ViewEmployeesSlotsRating create(
		java.lang.String id) {
		return getPersistence().create(id);
	}

	public static larion.progate.cds.model.ViewEmployeesSlotsRating remove(
		java.lang.String id)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchViewEmployeesSlotsRatingException {
		return getPersistence().remove(id);
	}

	public static larion.progate.cds.model.ViewEmployeesSlotsRating remove(
		larion.progate.cds.model.ViewEmployeesSlotsRating viewEmployeesSlotsRating)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(viewEmployeesSlotsRating);
	}

	public static larion.progate.cds.model.ViewEmployeesSlotsRating update(
		larion.progate.cds.model.ViewEmployeesSlotsRating viewEmployeesSlotsRating)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(viewEmployeesSlotsRating);
	}

	public static larion.progate.cds.model.ViewEmployeesSlotsRating update(
		larion.progate.cds.model.ViewEmployeesSlotsRating viewEmployeesSlotsRating,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(viewEmployeesSlotsRating, merge);
	}

	public static larion.progate.cds.model.ViewEmployeesSlotsRating updateImpl(
		larion.progate.cds.model.ViewEmployeesSlotsRating viewEmployeesSlotsRating,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(viewEmployeesSlotsRating, merge);
	}

	public static larion.progate.cds.model.ViewEmployeesSlotsRating findByPrimaryKey(
		java.lang.String id)
		throws com.liferay.portal.SystemException,
			larion.progate.cds.NoSuchViewEmployeesSlotsRatingException {
		return getPersistence().findByPrimaryKey(id);
	}

	public static larion.progate.cds.model.ViewEmployeesSlotsRating fetchByPrimaryKey(
		java.lang.String id) throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
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

	public static java.util.List<larion.progate.cds.model.ViewEmployeesSlotsRating> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.cds.model.ViewEmployeesSlotsRating> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.cds.model.ViewEmployeesSlotsRating> findAll(
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

	public static ViewEmployeesSlotsRatingPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(ViewEmployeesSlotsRatingPersistence persistence) {
		_persistence = persistence;
	}

	private static ViewEmployeesSlotsRatingPersistence _persistence;
}