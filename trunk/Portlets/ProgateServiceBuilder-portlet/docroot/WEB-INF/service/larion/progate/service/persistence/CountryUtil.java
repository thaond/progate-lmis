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
 * <a href="CountryUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CountryUtil {
	public static void cacheResult(larion.progate.model.Country country) {
		getPersistence().cacheResult(country);
	}

	public static void cacheResult(
		java.util.List<larion.progate.model.Country> countries) {
		getPersistence().cacheResult(countries);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.model.Country create(
		java.lang.Integer countryId) {
		return getPersistence().create(countryId);
	}

	public static larion.progate.model.Country remove(
		java.lang.Integer countryId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchCountryException {
		return getPersistence().remove(countryId);
	}

	public static larion.progate.model.Country remove(
		larion.progate.model.Country country)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(country);
	}

	public static larion.progate.model.Country update(
		larion.progate.model.Country country)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(country);
	}

	public static larion.progate.model.Country update(
		larion.progate.model.Country country, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(country, merge);
	}

	public static larion.progate.model.Country updateImpl(
		larion.progate.model.Country country, boolean merge)
		throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(country, merge);
	}

	public static larion.progate.model.Country findByPrimaryKey(
		java.lang.Integer countryId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchCountryException {
		return getPersistence().findByPrimaryKey(countryId);
	}

	public static larion.progate.model.Country fetchByPrimaryKey(
		java.lang.Integer countryId) throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(countryId);
	}

	public static java.util.List<larion.progate.model.Country> findByname(
		java.lang.String name) throws com.liferay.portal.SystemException {
		return getPersistence().findByname(name);
	}

	public static java.util.List<larion.progate.model.Country> findByname(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByname(name, start, end);
	}

	public static java.util.List<larion.progate.model.Country> findByname(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByname(name, start, end, obc);
	}

	public static larion.progate.model.Country findByname_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchCountryException {
		return getPersistence().findByname_First(name, obc);
	}

	public static larion.progate.model.Country findByname_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchCountryException {
		return getPersistence().findByname_Last(name, obc);
	}

	public static larion.progate.model.Country[] findByname_PrevAndNext(
		java.lang.Integer countryId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchCountryException {
		return getPersistence().findByname_PrevAndNext(countryId, name, obc);
	}

	public static java.util.List<larion.progate.model.Country> findByactive(
		boolean active) throws com.liferay.portal.SystemException {
		return getPersistence().findByactive(active);
	}

	public static java.util.List<larion.progate.model.Country> findByactive(
		boolean active, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByactive(active, start, end);
	}

	public static java.util.List<larion.progate.model.Country> findByactive(
		boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByactive(active, start, end, obc);
	}

	public static larion.progate.model.Country findByactive_First(
		boolean active, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchCountryException {
		return getPersistence().findByactive_First(active, obc);
	}

	public static larion.progate.model.Country findByactive_Last(
		boolean active, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchCountryException {
		return getPersistence().findByactive_Last(active, obc);
	}

	public static larion.progate.model.Country[] findByactive_PrevAndNext(
		java.lang.Integer countryId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchCountryException {
		return getPersistence().findByactive_PrevAndNext(countryId, active, obc);
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

	public static java.util.List<larion.progate.model.Country> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.model.Country> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.model.Country> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByname(java.lang.String name)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByname(name);
	}

	public static void removeByactive(boolean active)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByactive(active);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByname(java.lang.String name)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByname(name);
	}

	public static int countByactive(boolean active)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByactive(active);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static java.util.List<larion.progate.model.Region> getRegions(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getRegions(pk);
	}

	public static java.util.List<larion.progate.model.Region> getRegions(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getRegions(pk, start, end);
	}

	public static java.util.List<larion.progate.model.Region> getRegions(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().getRegions(pk, start, end, obc);
	}

	public static int getRegionsSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().getRegionsSize(pk);
	}

	public static boolean containsRegion(java.lang.Integer pk,
		java.lang.Integer regionPK) throws com.liferay.portal.SystemException {
		return getPersistence().containsRegion(pk, regionPK);
	}

	public static boolean containsRegions(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().containsRegions(pk);
	}

	public static CountryPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(CountryPersistence persistence) {
		_persistence = persistence;
	}

	private static CountryPersistence _persistence;
}