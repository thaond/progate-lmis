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
 * <a href="ProGateOrgCustomerRepresenterUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateOrgCustomerRepresenterUtil {
	public static void cacheResult(
		larion.progate.model.ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter) {
		getPersistence().cacheResult(proGateOrgCustomerRepresenter);
	}

	public static void cacheResult(
		java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> proGateOrgCustomerRepresenters) {
		getPersistence().cacheResult(proGateOrgCustomerRepresenters);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter create(
		java.lang.Integer ProGateOrgCustomerRepresenterId) {
		return getPersistence().create(ProGateOrgCustomerRepresenterId);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter remove(
		java.lang.Integer ProGateOrgCustomerRepresenterId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException {
		return getPersistence().remove(ProGateOrgCustomerRepresenterId);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter remove(
		larion.progate.model.ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(proGateOrgCustomerRepresenter);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter update(
		larion.progate.model.ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(proGateOrgCustomerRepresenter);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter update(
		larion.progate.model.ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(proGateOrgCustomerRepresenter, merge);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter updateImpl(
		larion.progate.model.ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(proGateOrgCustomerRepresenter, merge);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter findByPrimaryKey(
		java.lang.Integer ProGateOrgCustomerRepresenterId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException {
		return getPersistence().findByPrimaryKey(ProGateOrgCustomerRepresenterId);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter fetchByPrimaryKey(
		java.lang.Integer ProGateOrgCustomerRepresenterId)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .fetchByPrimaryKey(ProGateOrgCustomerRepresenterId);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findByrole(
		java.lang.String role) throws com.liferay.portal.SystemException {
		return getPersistence().findByrole(role);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findByrole(
		java.lang.String role, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByrole(role, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findByrole(
		java.lang.String role, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByrole(role, start, end, obc);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter findByrole_First(
		java.lang.String role,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException {
		return getPersistence().findByrole_First(role, obc);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter findByrole_Last(
		java.lang.String role,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException {
		return getPersistence().findByrole_Last(role, obc);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter[] findByrole_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerRepresenterId,
		java.lang.String role,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException {
		return getPersistence()
				   .findByrole_PrevAndNext(ProGateOrgCustomerRepresenterId,
			role, obc);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBycustomerId(
		int customerId) throws com.liferay.portal.SystemException {
		return getPersistence().findBycustomerId(customerId);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBycustomerId(
		int customerId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycustomerId(customerId, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBycustomerId(
		int customerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycustomerId(customerId, start, end, obc);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter findBycustomerId_First(
		int customerId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException {
		return getPersistence().findBycustomerId_First(customerId, obc);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter findBycustomerId_Last(
		int customerId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException {
		return getPersistence().findBycustomerId_Last(customerId, obc);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter[] findBycustomerId_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerRepresenterId, int customerId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException {
		return getPersistence()
				   .findBycustomerId_PrevAndNext(ProGateOrgCustomerRepresenterId,
			customerId, obc);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findByorgId(
		int orgId) throws com.liferay.portal.SystemException {
		return getPersistence().findByorgId(orgId);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findByorgId(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByorgId(orgId, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findByorgId(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByorgId(orgId, start, end, obc);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter findByorgId_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException {
		return getPersistence().findByorgId_First(orgId, obc);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter findByorgId_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException {
		return getPersistence().findByorgId_Last(orgId, obc);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter[] findByorgId_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerRepresenterId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException {
		return getPersistence()
				   .findByorgId_PrevAndNext(ProGateOrgCustomerRepresenterId,
			orgId, obc);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBydescription(
		java.lang.String description) throws com.liferay.portal.SystemException {
		return getPersistence().findBydescription(description);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBydescription(
		java.lang.String description, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBydescription(description, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBydescription(
		java.lang.String description, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBydescription(description, start, end, obc);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter findBydescription_First(
		java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException {
		return getPersistence().findBydescription_First(description, obc);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter findBydescription_Last(
		java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException {
		return getPersistence().findBydescription_Last(description, obc);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter[] findBydescription_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerRepresenterId,
		java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException {
		return getPersistence()
				   .findBydescription_PrevAndNext(ProGateOrgCustomerRepresenterId,
			description, obc);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBycreatedDateEqual(
		java.util.Date createdDate) throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedDateEqual(createdDate);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBycreatedDateEqual(
		java.util.Date createdDate, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedDateEqual(createdDate, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBycreatedDateEqual(
		java.util.Date createdDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findBycreatedDateEqual(createdDate, start, end, obc);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter findBycreatedDateEqual_First(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException {
		return getPersistence().findBycreatedDateEqual_First(createdDate, obc);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter findBycreatedDateEqual_Last(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException {
		return getPersistence().findBycreatedDateEqual_Last(createdDate, obc);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter[] findBycreatedDateEqual_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerRepresenterId,
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException {
		return getPersistence()
				   .findBycreatedDateEqual_PrevAndNext(ProGateOrgCustomerRepresenterId,
			createdDate, obc);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBycreatedDateGreater(
		java.util.Date createdDate) throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedDateGreater(createdDate);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBycreatedDateGreater(
		java.util.Date createdDate, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedDateGreater(createdDate, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBycreatedDateGreater(
		java.util.Date createdDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findBycreatedDateGreater(createdDate, start, end, obc);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter findBycreatedDateGreater_First(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException {
		return getPersistence().findBycreatedDateGreater_First(createdDate, obc);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter findBycreatedDateGreater_Last(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException {
		return getPersistence().findBycreatedDateGreater_Last(createdDate, obc);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter[] findBycreatedDateGreater_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerRepresenterId,
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException {
		return getPersistence()
				   .findBycreatedDateGreater_PrevAndNext(ProGateOrgCustomerRepresenterId,
			createdDate, obc);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBycreatedDateLower(
		java.util.Date createdDate) throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedDateLower(createdDate);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBycreatedDateLower(
		java.util.Date createdDate, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedDateLower(createdDate, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBycreatedDateLower(
		java.util.Date createdDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findBycreatedDateLower(createdDate, start, end, obc);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter findBycreatedDateLower_First(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException {
		return getPersistence().findBycreatedDateLower_First(createdDate, obc);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter findBycreatedDateLower_Last(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException {
		return getPersistence().findBycreatedDateLower_Last(createdDate, obc);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter[] findBycreatedDateLower_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerRepresenterId,
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException {
		return getPersistence()
				   .findBycreatedDateLower_PrevAndNext(ProGateOrgCustomerRepresenterId,
			createdDate, obc);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBymodifiedDateEqual(
		java.util.Date modifiedDate) throws com.liferay.portal.SystemException {
		return getPersistence().findBymodifiedDateEqual(modifiedDate);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBymodifiedDateEqual(
		java.util.Date modifiedDate, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBymodifiedDateEqual(modifiedDate, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBymodifiedDateEqual(
		java.util.Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findBymodifiedDateEqual(modifiedDate, start, end, obc);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter findBymodifiedDateEqual_First(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException {
		return getPersistence().findBymodifiedDateEqual_First(modifiedDate, obc);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter findBymodifiedDateEqual_Last(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException {
		return getPersistence().findBymodifiedDateEqual_Last(modifiedDate, obc);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter[] findBymodifiedDateEqual_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerRepresenterId,
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException {
		return getPersistence()
				   .findBymodifiedDateEqual_PrevAndNext(ProGateOrgCustomerRepresenterId,
			modifiedDate, obc);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBymodifiedDateGreater(
		java.util.Date modifiedDate) throws com.liferay.portal.SystemException {
		return getPersistence().findBymodifiedDateGreater(modifiedDate);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBymodifiedDateGreater(
		java.util.Date modifiedDate, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findBymodifiedDateGreater(modifiedDate, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBymodifiedDateGreater(
		java.util.Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findBymodifiedDateGreater(modifiedDate, start, end, obc);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter findBymodifiedDateGreater_First(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException {
		return getPersistence()
				   .findBymodifiedDateGreater_First(modifiedDate, obc);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter findBymodifiedDateGreater_Last(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException {
		return getPersistence().findBymodifiedDateGreater_Last(modifiedDate, obc);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter[] findBymodifiedDateGreater_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerRepresenterId,
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException {
		return getPersistence()
				   .findBymodifiedDateGreater_PrevAndNext(ProGateOrgCustomerRepresenterId,
			modifiedDate, obc);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBymodifiedDateLower(
		java.util.Date modifiedDate) throws com.liferay.portal.SystemException {
		return getPersistence().findBymodifiedDateLower(modifiedDate);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBymodifiedDateLower(
		java.util.Date modifiedDate, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBymodifiedDateLower(modifiedDate, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBymodifiedDateLower(
		java.util.Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findBymodifiedDateLower(modifiedDate, start, end, obc);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter findBymodifiedDateLower_First(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException {
		return getPersistence().findBymodifiedDateLower_First(modifiedDate, obc);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter findBymodifiedDateLower_Last(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException {
		return getPersistence().findBymodifiedDateLower_Last(modifiedDate, obc);
	}

	public static larion.progate.model.ProGateOrgCustomerRepresenter[] findBymodifiedDateLower_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerRepresenterId,
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException {
		return getPersistence()
				   .findBymodifiedDateLower_PrevAndNext(ProGateOrgCustomerRepresenterId,
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

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByrole(java.lang.String role)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByrole(role);
	}

	public static void removeBycustomerId(int customerId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBycustomerId(customerId);
	}

	public static void removeByorgId(int orgId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByorgId(orgId);
	}

	public static void removeBydescription(java.lang.String description)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBydescription(description);
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

	public static int countByrole(java.lang.String role)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByrole(role);
	}

	public static int countBycustomerId(int customerId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBycustomerId(customerId);
	}

	public static int countByorgId(int orgId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByorgId(orgId);
	}

	public static int countBydescription(java.lang.String description)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBydescription(description);
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

	public static ProGateOrgCustomerRepresenterPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(
		ProGateOrgCustomerRepresenterPersistence persistence) {
		_persistence = persistence;
	}

	private static ProGateOrgCustomerRepresenterPersistence _persistence;
}