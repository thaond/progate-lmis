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
 * <a href="ProGateCurrencyTypesUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateCurrencyTypesUtil {
	public static void cacheResult(
		larion.progate.model.ProGateCurrencyTypes proGateCurrencyTypes) {
		getPersistence().cacheResult(proGateCurrencyTypes);
	}

	public static void cacheResult(
		java.util.List<larion.progate.model.ProGateCurrencyTypes> proGateCurrencyTypeses) {
		getPersistence().cacheResult(proGateCurrencyTypeses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.model.ProGateCurrencyTypes create(
		java.lang.Integer currencyId) {
		return getPersistence().create(currencyId);
	}

	public static larion.progate.model.ProGateCurrencyTypes remove(
		java.lang.Integer currencyId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateCurrencyTypesException {
		return getPersistence().remove(currencyId);
	}

	public static larion.progate.model.ProGateCurrencyTypes remove(
		larion.progate.model.ProGateCurrencyTypes proGateCurrencyTypes)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(proGateCurrencyTypes);
	}

	public static larion.progate.model.ProGateCurrencyTypes update(
		larion.progate.model.ProGateCurrencyTypes proGateCurrencyTypes)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(proGateCurrencyTypes);
	}

	public static larion.progate.model.ProGateCurrencyTypes update(
		larion.progate.model.ProGateCurrencyTypes proGateCurrencyTypes,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(proGateCurrencyTypes, merge);
	}

	public static larion.progate.model.ProGateCurrencyTypes updateImpl(
		larion.progate.model.ProGateCurrencyTypes proGateCurrencyTypes,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(proGateCurrencyTypes, merge);
	}

	public static larion.progate.model.ProGateCurrencyTypes findByPrimaryKey(
		java.lang.Integer currencyId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateCurrencyTypesException {
		return getPersistence().findByPrimaryKey(currencyId);
	}

	public static larion.progate.model.ProGateCurrencyTypes fetchByPrimaryKey(
		java.lang.Integer currencyId) throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(currencyId);
	}

	public static java.util.List<larion.progate.model.ProGateCurrencyTypes> findBycode(
		java.lang.String code) throws com.liferay.portal.SystemException {
		return getPersistence().findBycode(code);
	}

	public static java.util.List<larion.progate.model.ProGateCurrencyTypes> findBycode(
		java.lang.String code, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycode(code, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateCurrencyTypes> findBycode(
		java.lang.String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycode(code, start, end, obc);
	}

	public static larion.progate.model.ProGateCurrencyTypes findBycode_First(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateCurrencyTypesException {
		return getPersistence().findBycode_First(code, obc);
	}

	public static larion.progate.model.ProGateCurrencyTypes findBycode_Last(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateCurrencyTypesException {
		return getPersistence().findBycode_Last(code, obc);
	}

	public static larion.progate.model.ProGateCurrencyTypes[] findBycode_PrevAndNext(
		java.lang.Integer currencyId, java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateCurrencyTypesException {
		return getPersistence().findBycode_PrevAndNext(currencyId, code, obc);
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

	public static java.util.List<larion.progate.model.ProGateCurrencyTypes> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.model.ProGateCurrencyTypes> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.model.ProGateCurrencyTypes> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeBycode(java.lang.String code)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBycode(code);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countBycode(java.lang.String code)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBycode(code);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> getProGateProductsServiceses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getProGateProductsServiceses(pk);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> getProGateProductsServiceses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getProGateProductsServiceses(pk, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateProductsServices> getProGateProductsServiceses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().getProGateProductsServiceses(pk, start, end, obc);
	}

	public static int getProGateProductsServicesesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException {
		return getPersistence().getProGateProductsServicesesSize(pk);
	}

	public static boolean containsProGateProductsServices(
		java.lang.Integer pk, java.lang.Integer proGateProductsServicesPK)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .containsProGateProductsServices(pk,
			proGateProductsServicesPK);
	}

	public static boolean containsProGateProductsServiceses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().containsProGateProductsServiceses(pk);
	}

	public static ProGateCurrencyTypesPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(ProGateCurrencyTypesPersistence persistence) {
		_persistence = persistence;
	}

	private static ProGateCurrencyTypesPersistence _persistence;
}