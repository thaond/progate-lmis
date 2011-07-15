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
 * <a href="ProGateCurrencyTypesPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface ProGateCurrencyTypesPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.model.ProGateCurrencyTypes proGateCurrencyTypes);

	public void cacheResult(
		java.util.List<larion.progate.model.ProGateCurrencyTypes> proGateCurrencyTypeses);

	public void clearCache();

	public larion.progate.model.ProGateCurrencyTypes create(
		java.lang.Integer currencyId);

	public larion.progate.model.ProGateCurrencyTypes remove(
		java.lang.Integer currencyId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateCurrencyTypesException;

	public larion.progate.model.ProGateCurrencyTypes remove(
		larion.progate.model.ProGateCurrencyTypes proGateCurrencyTypes)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateCurrencyTypes update(
		larion.progate.model.ProGateCurrencyTypes proGateCurrencyTypes)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateCurrencyTypes update(
		larion.progate.model.ProGateCurrencyTypes proGateCurrencyTypes,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateCurrencyTypes updateImpl(
		larion.progate.model.ProGateCurrencyTypes proGateCurrencyTypes,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateCurrencyTypes findByPrimaryKey(
		java.lang.Integer currencyId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateCurrencyTypesException;

	public larion.progate.model.ProGateCurrencyTypes fetchByPrimaryKey(
		java.lang.Integer currencyId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateCurrencyTypes> findBycode(
		java.lang.String code) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateCurrencyTypes> findBycode(
		java.lang.String code, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateCurrencyTypes> findBycode(
		java.lang.String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateCurrencyTypes findBycode_First(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateCurrencyTypesException;

	public larion.progate.model.ProGateCurrencyTypes findBycode_Last(
		java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateCurrencyTypesException;

	public larion.progate.model.ProGateCurrencyTypes[] findBycode_PrevAndNext(
		java.lang.Integer currencyId, java.lang.String code,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateCurrencyTypesException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateCurrencyTypes> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateCurrencyTypes> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateCurrencyTypes> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeBycode(java.lang.String code)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countBycode(java.lang.String code)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> getProGateProductsServiceses(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> getProGateProductsServiceses(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateProductsServices> getProGateProductsServiceses(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getProGateProductsServicesesSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsProGateProductsServices(java.lang.Integer pk,
		java.lang.Integer proGateProductsServicesPK)
		throws com.liferay.portal.SystemException;

	public boolean containsProGateProductsServiceses(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;
}