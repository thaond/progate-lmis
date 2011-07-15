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
 * <a href="ProGateOrgCustomerUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateOrgCustomerUtil {
	public static void cacheResult(
		larion.progate.model.ProGateOrgCustomer proGateOrgCustomer) {
		getPersistence().cacheResult(proGateOrgCustomer);
	}

	public static void cacheResult(
		java.util.List<larion.progate.model.ProGateOrgCustomer> proGateOrgCustomers) {
		getPersistence().cacheResult(proGateOrgCustomers);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.model.ProGateOrgCustomer create(
		java.lang.Integer ProGateOrgCustomerId) {
		return getPersistence().create(ProGateOrgCustomerId);
	}

	public static larion.progate.model.ProGateOrgCustomer remove(
		java.lang.Integer ProGateOrgCustomerId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence().remove(ProGateOrgCustomerId);
	}

	public static larion.progate.model.ProGateOrgCustomer remove(
		larion.progate.model.ProGateOrgCustomer proGateOrgCustomer)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(proGateOrgCustomer);
	}

	public static larion.progate.model.ProGateOrgCustomer update(
		larion.progate.model.ProGateOrgCustomer proGateOrgCustomer)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(proGateOrgCustomer);
	}

	public static larion.progate.model.ProGateOrgCustomer update(
		larion.progate.model.ProGateOrgCustomer proGateOrgCustomer,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(proGateOrgCustomer, merge);
	}

	public static larion.progate.model.ProGateOrgCustomer updateImpl(
		larion.progate.model.ProGateOrgCustomer proGateOrgCustomer,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(proGateOrgCustomer, merge);
	}

	public static larion.progate.model.ProGateOrgCustomer findByPrimaryKey(
		java.lang.Integer ProGateOrgCustomerId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence().findByPrimaryKey(ProGateOrgCustomerId);
	}

	public static larion.progate.model.ProGateOrgCustomer fetchByPrimaryKey(
		java.lang.Integer ProGateOrgCustomerId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(ProGateOrgCustomerId);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findBycustomerName(
		java.lang.String customerName)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycustomerName(customerName);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findBycustomerName(
		java.lang.String customerName, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycustomerName(customerName, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findBycustomerName(
		java.lang.String customerName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycustomerName(customerName, start, end, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer findBycustomerName_First(
		java.lang.String customerName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence().findBycustomerName_First(customerName, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer findBycustomerName_Last(
		java.lang.String customerName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence().findBycustomerName_Last(customerName, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer[] findBycustomerName_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerId, java.lang.String customerName,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence()
				   .findBycustomerName_PrevAndNext(ProGateOrgCustomerId,
			customerName, obc);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findBycustomerTypeEqual(
		int customerType) throws com.liferay.portal.SystemException {
		return getPersistence().findBycustomerTypeEqual(customerType);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findBycustomerTypeEqual(
		int customerType, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycustomerTypeEqual(customerType, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findBycustomerTypeEqual(
		int customerType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findBycustomerTypeEqual(customerType, start, end, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer findBycustomerTypeEqual_First(
		int customerType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence().findBycustomerTypeEqual_First(customerType, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer findBycustomerTypeEqual_Last(
		int customerType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence().findBycustomerTypeEqual_Last(customerType, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer[] findBycustomerTypeEqual_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerId, int customerType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence()
				   .findBycustomerTypeEqual_PrevAndNext(ProGateOrgCustomerId,
			customerType, obc);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findBycustomerTypeGreater(
		int customerType) throws com.liferay.portal.SystemException {
		return getPersistence().findBycustomerTypeGreater(customerType);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findBycustomerTypeGreater(
		int customerType, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findBycustomerTypeGreater(customerType, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findBycustomerTypeGreater(
		int customerType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findBycustomerTypeGreater(customerType, start, end, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer findBycustomerTypeGreater_First(
		int customerType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence()
				   .findBycustomerTypeGreater_First(customerType, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer findBycustomerTypeGreater_Last(
		int customerType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence().findBycustomerTypeGreater_Last(customerType, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer[] findBycustomerTypeGreater_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerId, int customerType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence()
				   .findBycustomerTypeGreater_PrevAndNext(ProGateOrgCustomerId,
			customerType, obc);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findBycustomerTypeLower(
		int customerType) throws com.liferay.portal.SystemException {
		return getPersistence().findBycustomerTypeLower(customerType);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findBycustomerTypeLower(
		int customerType, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycustomerTypeLower(customerType, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findBycustomerTypeLower(
		int customerType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findBycustomerTypeLower(customerType, start, end, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer findBycustomerTypeLower_First(
		int customerType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence().findBycustomerTypeLower_First(customerType, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer findBycustomerTypeLower_Last(
		int customerType, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence().findBycustomerTypeLower_Last(customerType, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer[] findBycustomerTypeLower_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerId, int customerType,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence()
				   .findBycustomerTypeLower_PrevAndNext(ProGateOrgCustomerId,
			customerType, obc);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findByorgId(
		int orgId) throws com.liferay.portal.SystemException {
		return getPersistence().findByorgId(orgId);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findByorgId(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByorgId(orgId, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findByorgId(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByorgId(orgId, start, end, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer findByorgId_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence().findByorgId_First(orgId, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer findByorgId_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence().findByorgId_Last(orgId, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer[] findByorgId_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence()
				   .findByorgId_PrevAndNext(ProGateOrgCustomerId, orgId, obc);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findBycreatedDateEqual(
		java.util.Date createdDate) throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedDateEqual(createdDate);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findBycreatedDateEqual(
		java.util.Date createdDate, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedDateEqual(createdDate, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findBycreatedDateEqual(
		java.util.Date createdDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findBycreatedDateEqual(createdDate, start, end, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer findBycreatedDateEqual_First(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence().findBycreatedDateEqual_First(createdDate, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer findBycreatedDateEqual_Last(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence().findBycreatedDateEqual_Last(createdDate, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer[] findBycreatedDateEqual_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerId, java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence()
				   .findBycreatedDateEqual_PrevAndNext(ProGateOrgCustomerId,
			createdDate, obc);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findBycreatedDateGreater(
		java.util.Date createdDate) throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedDateGreater(createdDate);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findBycreatedDateGreater(
		java.util.Date createdDate, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedDateGreater(createdDate, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findBycreatedDateGreater(
		java.util.Date createdDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findBycreatedDateGreater(createdDate, start, end, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer findBycreatedDateGreater_First(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence().findBycreatedDateGreater_First(createdDate, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer findBycreatedDateGreater_Last(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence().findBycreatedDateGreater_Last(createdDate, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer[] findBycreatedDateGreater_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerId, java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence()
				   .findBycreatedDateGreater_PrevAndNext(ProGateOrgCustomerId,
			createdDate, obc);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findBycreatedDateLower(
		java.util.Date createdDate) throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedDateLower(createdDate);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findBycreatedDateLower(
		java.util.Date createdDate, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedDateLower(createdDate, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findBycreatedDateLower(
		java.util.Date createdDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findBycreatedDateLower(createdDate, start, end, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer findBycreatedDateLower_First(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence().findBycreatedDateLower_First(createdDate, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer findBycreatedDateLower_Last(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence().findBycreatedDateLower_Last(createdDate, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer[] findBycreatedDateLower_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerId, java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence()
				   .findBycreatedDateLower_PrevAndNext(ProGateOrgCustomerId,
			createdDate, obc);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findBymodifiedDateEqual(
		java.util.Date modifiedDate) throws com.liferay.portal.SystemException {
		return getPersistence().findBymodifiedDateEqual(modifiedDate);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findBymodifiedDateEqual(
		java.util.Date modifiedDate, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBymodifiedDateEqual(modifiedDate, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findBymodifiedDateEqual(
		java.util.Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findBymodifiedDateEqual(modifiedDate, start, end, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer findBymodifiedDateEqual_First(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence().findBymodifiedDateEqual_First(modifiedDate, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer findBymodifiedDateEqual_Last(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence().findBymodifiedDateEqual_Last(modifiedDate, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer[] findBymodifiedDateEqual_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence()
				   .findBymodifiedDateEqual_PrevAndNext(ProGateOrgCustomerId,
			modifiedDate, obc);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findBymodifiedDateGreater(
		java.util.Date modifiedDate) throws com.liferay.portal.SystemException {
		return getPersistence().findBymodifiedDateGreater(modifiedDate);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findBymodifiedDateGreater(
		java.util.Date modifiedDate, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findBymodifiedDateGreater(modifiedDate, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findBymodifiedDateGreater(
		java.util.Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findBymodifiedDateGreater(modifiedDate, start, end, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer findBymodifiedDateGreater_First(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence()
				   .findBymodifiedDateGreater_First(modifiedDate, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer findBymodifiedDateGreater_Last(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence().findBymodifiedDateGreater_Last(modifiedDate, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer[] findBymodifiedDateGreater_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence()
				   .findBymodifiedDateGreater_PrevAndNext(ProGateOrgCustomerId,
			modifiedDate, obc);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findBymodifiedDateLower(
		java.util.Date modifiedDate) throws com.liferay.portal.SystemException {
		return getPersistence().findBymodifiedDateLower(modifiedDate);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findBymodifiedDateLower(
		java.util.Date modifiedDate, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBymodifiedDateLower(modifiedDate, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findBymodifiedDateLower(
		java.util.Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findBymodifiedDateLower(modifiedDate, start, end, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer findBymodifiedDateLower_First(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence().findBymodifiedDateLower_First(modifiedDate, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer findBymodifiedDateLower_Last(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence().findBymodifiedDateLower_Last(modifiedDate, obc);
	}

	public static larion.progate.model.ProGateOrgCustomer[] findBymodifiedDateLower_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerException {
		return getPersistence()
				   .findBymodifiedDateLower_PrevAndNext(ProGateOrgCustomerId,
			modifiedDate, obc);
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

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomer> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeBycustomerName(java.lang.String customerName)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBycustomerName(customerName);
	}

	public static void removeBycustomerTypeEqual(int customerType)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBycustomerTypeEqual(customerType);
	}

	public static void removeBycustomerTypeGreater(int customerType)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBycustomerTypeGreater(customerType);
	}

	public static void removeBycustomerTypeLower(int customerType)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBycustomerTypeLower(customerType);
	}

	public static void removeByorgId(int orgId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByorgId(orgId);
	}

	public static void removeBycreatedDateEqual(java.util.Date createdDate)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBycreatedDateEqual(createdDate);
	}

	public static void removeBycreatedDateGreater(java.util.Date createdDate)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBycreatedDateGreater(createdDate);
	}

	public static void removeBycreatedDateLower(java.util.Date createdDate)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBycreatedDateLower(createdDate);
	}

	public static void removeBymodifiedDateEqual(java.util.Date modifiedDate)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBymodifiedDateEqual(modifiedDate);
	}

	public static void removeBymodifiedDateGreater(java.util.Date modifiedDate)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBymodifiedDateGreater(modifiedDate);
	}

	public static void removeBymodifiedDateLower(java.util.Date modifiedDate)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBymodifiedDateLower(modifiedDate);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countBycustomerName(java.lang.String customerName)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBycustomerName(customerName);
	}

	public static int countBycustomerTypeEqual(int customerType)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBycustomerTypeEqual(customerType);
	}

	public static int countBycustomerTypeGreater(int customerType)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBycustomerTypeGreater(customerType);
	}

	public static int countBycustomerTypeLower(int customerType)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBycustomerTypeLower(customerType);
	}

	public static int countByorgId(int orgId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByorgId(orgId);
	}

	public static int countBycreatedDateEqual(java.util.Date createdDate)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBycreatedDateEqual(createdDate);
	}

	public static int countBycreatedDateGreater(java.util.Date createdDate)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBycreatedDateGreater(createdDate);
	}

	public static int countBycreatedDateLower(java.util.Date createdDate)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBycreatedDateLower(createdDate);
	}

	public static int countBymodifiedDateEqual(java.util.Date modifiedDate)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBymodifiedDateEqual(modifiedDate);
	}

	public static int countBymodifiedDateGreater(java.util.Date modifiedDate)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBymodifiedDateGreater(modifiedDate);
	}

	public static int countBymodifiedDateLower(java.util.Date modifiedDate)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBymodifiedDateLower(modifiedDate);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> getProGateOrgCustomerRepresenters(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getProGateOrgCustomerRepresenters(pk);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> getProGateOrgCustomerRepresenters(
		java.lang.Integer pk, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().getProGateOrgCustomerRepresenters(pk, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> getProGateOrgCustomerRepresenters(
		java.lang.Integer pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .getProGateOrgCustomerRepresenters(pk, start, end, obc);
	}

	public static int getProGateOrgCustomerRepresentersSize(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().getProGateOrgCustomerRepresentersSize(pk);
	}

	public static boolean containsProGateOrgCustomerRepresenter(
		java.lang.Integer pk, java.lang.Integer proGateOrgCustomerRepresenterPK)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .containsProGateOrgCustomerRepresenter(pk,
			proGateOrgCustomerRepresenterPK);
	}

	public static boolean containsProGateOrgCustomerRepresenters(
		java.lang.Integer pk) throws com.liferay.portal.SystemException {
		return getPersistence().containsProGateOrgCustomerRepresenters(pk);
	}

	public static ProGateOrgCustomerPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(ProGateOrgCustomerPersistence persistence) {
		_persistence = persistence;
	}

	private static ProGateOrgCustomerPersistence _persistence;
}