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
 * <a href="OrganizationViewPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface OrganizationViewPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.model.OrganizationView organizationView);

	public void cacheResult(
		java.util.List<larion.progate.model.OrganizationView> organizationViews);

	public void clearCache();

	public larion.progate.model.OrganizationView create(int orgId);

	public larion.progate.model.OrganizationView remove(int orgId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationViewException;

	public larion.progate.model.OrganizationView remove(
		larion.progate.model.OrganizationView organizationView)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrganizationView update(
		larion.progate.model.OrganizationView organizationView)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrganizationView update(
		larion.progate.model.OrganizationView organizationView, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrganizationView updateImpl(
		larion.progate.model.OrganizationView organizationView, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrganizationView findByPrimaryKey(int orgId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationViewException;

	public larion.progate.model.OrganizationView fetchByPrimaryKey(int orgId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrganizationView> findByorgName(
		java.lang.String orgName) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrganizationView> findByorgName(
		java.lang.String orgName, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrganizationView> findByorgName(
		java.lang.String orgName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrganizationView findByorgName_First(
		java.lang.String orgName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationViewException;

	public larion.progate.model.OrganizationView findByorgName_Last(
		java.lang.String orgName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationViewException;

	public larion.progate.model.OrganizationView[] findByorgName_PrevAndNext(
		int orgId, java.lang.String orgName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationViewException;

	public java.util.List<larion.progate.model.OrganizationView> findByorgNameLower(
		java.lang.String orgNameLower)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrganizationView> findByorgNameLower(
		java.lang.String orgNameLower, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrganizationView> findByorgNameLower(
		java.lang.String orgNameLower, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrganizationView findByorgNameLower_First(
		java.lang.String orgNameLower,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationViewException;

	public larion.progate.model.OrganizationView findByorgNameLower_Last(
		java.lang.String orgNameLower,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationViewException;

	public larion.progate.model.OrganizationView[] findByorgNameLower_PrevAndNext(
		int orgId, java.lang.String orgNameLower,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationViewException;

	public java.util.List<larion.progate.model.OrganizationView> findBycountProduct(
		int countProduct) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrganizationView> findBycountProduct(
		int countProduct, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrganizationView> findBycountProduct(
		int countProduct, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.OrganizationView findBycountProduct_First(
		int countProduct, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationViewException;

	public larion.progate.model.OrganizationView findBycountProduct_Last(
		int countProduct, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationViewException;

	public larion.progate.model.OrganizationView[] findBycountProduct_PrevAndNext(
		int orgId, int countProduct,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchOrganizationViewException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrganizationView> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrganizationView> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.OrganizationView> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByorgName(java.lang.String orgName)
		throws com.liferay.portal.SystemException;

	public void removeByorgNameLower(java.lang.String orgNameLower)
		throws com.liferay.portal.SystemException;

	public void removeBycountProduct(int countProduct)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByorgName(java.lang.String orgName)
		throws com.liferay.portal.SystemException;

	public int countByorgNameLower(java.lang.String orgNameLower)
		throws com.liferay.portal.SystemException;

	public int countBycountProduct(int countProduct)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}