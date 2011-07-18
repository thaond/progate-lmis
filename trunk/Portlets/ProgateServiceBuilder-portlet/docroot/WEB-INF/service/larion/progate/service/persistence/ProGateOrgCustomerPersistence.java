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
 * <a href="ProGateOrgCustomerPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface ProGateOrgCustomerPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.model.ProGateOrgCustomer proGateOrgCustomer);

	public void cacheResult(
		java.util.List<larion.progate.model.ProGateOrgCustomer> proGateOrgCustomers);

	public void clearCache();

	public larion.progate.model.ProGateOrgCustomer create(
		java.lang.Integer ProGateOrgCustomerId);

	public larion.progate.model.ProGateOrgCustomer remove(
		java.lang.Integer ProGateOrgCustomerId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public larion.progate.model.ProGateOrgCustomer remove(
		larion.progate.model.ProGateOrgCustomer proGateOrgCustomer)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomer update(
		larion.progate.model.ProGateOrgCustomer proGateOrgCustomer)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomer update(
		larion.progate.model.ProGateOrgCustomer proGateOrgCustomer,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomer updateImpl(
		larion.progate.model.ProGateOrgCustomer proGateOrgCustomer,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomer findByPrimaryKey(
		java.lang.Integer ProGateOrgCustomerId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public larion.progate.model.ProGateOrgCustomer fetchByPrimaryKey(
		java.lang.Integer ProGateOrgCustomerId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findBycustomerName(
		java.lang.String customerName)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findBycustomerName(
		java.lang.String customerName, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findBycustomerName(
		java.lang.String customerName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomer findBycustomerName_First(
		java.lang.String customerName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public larion.progate.model.ProGateOrgCustomer findBycustomerName_Last(
		java.lang.String customerName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public larion.progate.model.ProGateOrgCustomer[] findBycustomerName_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerId, java.lang.String customerName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findBycustomerTypeEqual(
		int customerType) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findBycustomerTypeEqual(
		int customerType, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findBycustomerTypeEqual(
		int customerType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomer findBycustomerTypeEqual_First(
		int customerType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public larion.progate.model.ProGateOrgCustomer findBycustomerTypeEqual_Last(
		int customerType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public larion.progate.model.ProGateOrgCustomer[] findBycustomerTypeEqual_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerId, int customerType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findBycustomerTypeGreater(
		int customerType) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findBycustomerTypeGreater(
		int customerType, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findBycustomerTypeGreater(
		int customerType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomer findBycustomerTypeGreater_First(
		int customerType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public larion.progate.model.ProGateOrgCustomer findBycustomerTypeGreater_Last(
		int customerType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public larion.progate.model.ProGateOrgCustomer[] findBycustomerTypeGreater_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerId, int customerType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findBycustomerTypeLower(
		int customerType) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findBycustomerTypeLower(
		int customerType, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findBycustomerTypeLower(
		int customerType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomer findBycustomerTypeLower_First(
		int customerType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public larion.progate.model.ProGateOrgCustomer findBycustomerTypeLower_Last(
		int customerType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public larion.progate.model.ProGateOrgCustomer[] findBycustomerTypeLower_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerId, int customerType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findByorgId(
		int orgId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findByorgId(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findByorgId(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomer findByorgId_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public larion.progate.model.ProGateOrgCustomer findByorgId_Last(int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public larion.progate.model.ProGateOrgCustomer[] findByorgId_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findBycreatedDateEqual(
		java.util.Date createdDate) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findBycreatedDateEqual(
		java.util.Date createdDate, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findBycreatedDateEqual(
		java.util.Date createdDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomer findBycreatedDateEqual_First(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public larion.progate.model.ProGateOrgCustomer findBycreatedDateEqual_Last(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public larion.progate.model.ProGateOrgCustomer[] findBycreatedDateEqual_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerId, java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findBycreatedDateGreater(
		java.util.Date createdDate) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findBycreatedDateGreater(
		java.util.Date createdDate, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findBycreatedDateGreater(
		java.util.Date createdDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomer findBycreatedDateGreater_First(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public larion.progate.model.ProGateOrgCustomer findBycreatedDateGreater_Last(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public larion.progate.model.ProGateOrgCustomer[] findBycreatedDateGreater_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerId, java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findBycreatedDateLower(
		java.util.Date createdDate) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findBycreatedDateLower(
		java.util.Date createdDate, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findBycreatedDateLower(
		java.util.Date createdDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomer findBycreatedDateLower_First(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public larion.progate.model.ProGateOrgCustomer findBycreatedDateLower_Last(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public larion.progate.model.ProGateOrgCustomer[] findBycreatedDateLower_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerId, java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findBymodifiedDateEqual(
		java.util.Date modifiedDate) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findBymodifiedDateEqual(
		java.util.Date modifiedDate, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findBymodifiedDateEqual(
		java.util.Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomer findBymodifiedDateEqual_First(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public larion.progate.model.ProGateOrgCustomer findBymodifiedDateEqual_Last(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public larion.progate.model.ProGateOrgCustomer[] findBymodifiedDateEqual_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findBymodifiedDateGreater(
		java.util.Date modifiedDate) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findBymodifiedDateGreater(
		java.util.Date modifiedDate, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findBymodifiedDateGreater(
		java.util.Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomer findBymodifiedDateGreater_First(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public larion.progate.model.ProGateOrgCustomer findBymodifiedDateGreater_Last(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public larion.progate.model.ProGateOrgCustomer[] findBymodifiedDateGreater_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findBymodifiedDateLower(
		java.util.Date modifiedDate) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findBymodifiedDateLower(
		java.util.Date modifiedDate, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findBymodifiedDateLower(
		java.util.Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomer findBymodifiedDateLower_First(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public larion.progate.model.ProGateOrgCustomer findBymodifiedDateLower_Last(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public larion.progate.model.ProGateOrgCustomer[] findBymodifiedDateLower_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomer> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeBycustomerName(java.lang.String customerName)
		throws com.liferay.portal.SystemException;

	public void removeBycustomerTypeEqual(int customerType)
		throws com.liferay.portal.SystemException;

	public void removeBycustomerTypeGreater(int customerType)
		throws com.liferay.portal.SystemException;

	public void removeBycustomerTypeLower(int customerType)
		throws com.liferay.portal.SystemException;

	public void removeByorgId(int orgId)
		throws com.liferay.portal.SystemException;

	public void removeBycreatedDateEqual(java.util.Date createdDate)
		throws com.liferay.portal.SystemException;

	public void removeBycreatedDateGreater(java.util.Date createdDate)
		throws com.liferay.portal.SystemException;

	public void removeBycreatedDateLower(java.util.Date createdDate)
		throws com.liferay.portal.SystemException;

	public void removeBymodifiedDateEqual(java.util.Date modifiedDate)
		throws com.liferay.portal.SystemException;

	public void removeBymodifiedDateGreater(java.util.Date modifiedDate)
		throws com.liferay.portal.SystemException;

	public void removeBymodifiedDateLower(java.util.Date modifiedDate)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countBycustomerName(java.lang.String customerName)
		throws com.liferay.portal.SystemException;

	public int countBycustomerTypeEqual(int customerType)
		throws com.liferay.portal.SystemException;

	public int countBycustomerTypeGreater(int customerType)
		throws com.liferay.portal.SystemException;

	public int countBycustomerTypeLower(int customerType)
		throws com.liferay.portal.SystemException;

	public int countByorgId(int orgId)
		throws com.liferay.portal.SystemException;

	public int countBycreatedDateEqual(java.util.Date createdDate)
		throws com.liferay.portal.SystemException;

	public int countBycreatedDateGreater(java.util.Date createdDate)
		throws com.liferay.portal.SystemException;

	public int countBycreatedDateLower(java.util.Date createdDate)
		throws com.liferay.portal.SystemException;

	public int countBymodifiedDateEqual(java.util.Date modifiedDate)
		throws com.liferay.portal.SystemException;

	public int countBymodifiedDateGreater(java.util.Date modifiedDate)
		throws com.liferay.portal.SystemException;

	public int countBymodifiedDateLower(java.util.Date modifiedDate)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> getProGateOrgCustomerRepresenters(
		java.lang.Integer pk) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> getProGateOrgCustomerRepresenters(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> getProGateOrgCustomerRepresenters(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public int getProGateOrgCustomerRepresentersSize(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;

	public boolean containsProGateOrgCustomerRepresenter(java.lang.Integer pk,
		java.lang.Integer proGateOrgCustomerRepresenterPK)
		throws com.liferay.portal.SystemException;

	public boolean containsProGateOrgCustomerRepresenters(java.lang.Integer pk)
		throws com.liferay.portal.SystemException;
}