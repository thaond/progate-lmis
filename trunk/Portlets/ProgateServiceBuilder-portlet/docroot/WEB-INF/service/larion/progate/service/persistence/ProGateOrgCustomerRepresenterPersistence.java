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
 * <a href="ProGateOrgCustomerRepresenterPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface ProGateOrgCustomerRepresenterPersistence
	extends BasePersistence {
	public void cacheResult(
		larion.progate.model.ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter);

	public void cacheResult(
		java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> proGateOrgCustomerRepresenters);

	public void clearCache();

	public larion.progate.model.ProGateOrgCustomerRepresenter create(
		java.lang.Integer ProGateOrgCustomerRepresenterId);

	public larion.progate.model.ProGateOrgCustomerRepresenter remove(
		java.lang.Integer ProGateOrgCustomerRepresenterId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException;

	public larion.progate.model.ProGateOrgCustomerRepresenter remove(
		larion.progate.model.ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomerRepresenter update(
		larion.progate.model.ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomerRepresenter update(
		larion.progate.model.ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomerRepresenter updateImpl(
		larion.progate.model.ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomerRepresenter findByPrimaryKey(
		java.lang.Integer ProGateOrgCustomerRepresenterId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException;

	public larion.progate.model.ProGateOrgCustomerRepresenter fetchByPrimaryKey(
		java.lang.Integer ProGateOrgCustomerRepresenterId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findByrole(
		java.lang.String role) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findByrole(
		java.lang.String role, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findByrole(
		java.lang.String role, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomerRepresenter findByrole_First(
		java.lang.String role,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException;

	public larion.progate.model.ProGateOrgCustomerRepresenter findByrole_Last(
		java.lang.String role,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException;

	public larion.progate.model.ProGateOrgCustomerRepresenter[] findByrole_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerRepresenterId,
		java.lang.String role,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBycustomerId(
		int customerId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBycustomerId(
		int customerId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBycustomerId(
		int customerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomerRepresenter findBycustomerId_First(
		int customerId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException;

	public larion.progate.model.ProGateOrgCustomerRepresenter findBycustomerId_Last(
		int customerId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException;

	public larion.progate.model.ProGateOrgCustomerRepresenter[] findBycustomerId_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerRepresenterId, int customerId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findByorgId(
		int orgId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findByorgId(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findByorgId(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomerRepresenter findByorgId_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException;

	public larion.progate.model.ProGateOrgCustomerRepresenter findByorgId_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException;

	public larion.progate.model.ProGateOrgCustomerRepresenter[] findByorgId_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerRepresenterId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBydescription(
		java.lang.String description) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBydescription(
		java.lang.String description, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBydescription(
		java.lang.String description, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomerRepresenter findBydescription_First(
		java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException;

	public larion.progate.model.ProGateOrgCustomerRepresenter findBydescription_Last(
		java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException;

	public larion.progate.model.ProGateOrgCustomerRepresenter[] findBydescription_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerRepresenterId,
		java.lang.String description,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBycreatedDateEqual(
		java.util.Date createdDate) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBycreatedDateEqual(
		java.util.Date createdDate, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBycreatedDateEqual(
		java.util.Date createdDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomerRepresenter findBycreatedDateEqual_First(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException;

	public larion.progate.model.ProGateOrgCustomerRepresenter findBycreatedDateEqual_Last(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException;

	public larion.progate.model.ProGateOrgCustomerRepresenter[] findBycreatedDateEqual_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerRepresenterId,
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBycreatedDateGreater(
		java.util.Date createdDate) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBycreatedDateGreater(
		java.util.Date createdDate, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBycreatedDateGreater(
		java.util.Date createdDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomerRepresenter findBycreatedDateGreater_First(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException;

	public larion.progate.model.ProGateOrgCustomerRepresenter findBycreatedDateGreater_Last(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException;

	public larion.progate.model.ProGateOrgCustomerRepresenter[] findBycreatedDateGreater_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerRepresenterId,
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBycreatedDateLower(
		java.util.Date createdDate) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBycreatedDateLower(
		java.util.Date createdDate, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBycreatedDateLower(
		java.util.Date createdDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomerRepresenter findBycreatedDateLower_First(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException;

	public larion.progate.model.ProGateOrgCustomerRepresenter findBycreatedDateLower_Last(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException;

	public larion.progate.model.ProGateOrgCustomerRepresenter[] findBycreatedDateLower_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerRepresenterId,
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBymodifiedDateEqual(
		java.util.Date modifiedDate) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBymodifiedDateEqual(
		java.util.Date modifiedDate, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBymodifiedDateEqual(
		java.util.Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomerRepresenter findBymodifiedDateEqual_First(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException;

	public larion.progate.model.ProGateOrgCustomerRepresenter findBymodifiedDateEqual_Last(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException;

	public larion.progate.model.ProGateOrgCustomerRepresenter[] findBymodifiedDateEqual_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerRepresenterId,
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBymodifiedDateGreater(
		java.util.Date modifiedDate) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBymodifiedDateGreater(
		java.util.Date modifiedDate, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBymodifiedDateGreater(
		java.util.Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomerRepresenter findBymodifiedDateGreater_First(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException;

	public larion.progate.model.ProGateOrgCustomerRepresenter findBymodifiedDateGreater_Last(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException;

	public larion.progate.model.ProGateOrgCustomerRepresenter[] findBymodifiedDateGreater_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerRepresenterId,
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBymodifiedDateLower(
		java.util.Date modifiedDate) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBymodifiedDateLower(
		java.util.Date modifiedDate, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findBymodifiedDateLower(
		java.util.Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateOrgCustomerRepresenter findBymodifiedDateLower_First(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException;

	public larion.progate.model.ProGateOrgCustomerRepresenter findBymodifiedDateLower_Last(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException;

	public larion.progate.model.ProGateOrgCustomerRepresenter[] findBymodifiedDateLower_PrevAndNext(
		java.lang.Integer ProGateOrgCustomerRepresenterId,
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateOrgCustomerRepresenterException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateOrgCustomerRepresenter> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByrole(java.lang.String role)
		throws com.liferay.portal.SystemException;

	public void removeBycustomerId(int customerId)
		throws com.liferay.portal.SystemException;

	public void removeByorgId(int orgId)
		throws com.liferay.portal.SystemException;

	public void removeBydescription(java.lang.String description)
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

	public int countByrole(java.lang.String role)
		throws com.liferay.portal.SystemException;

	public int countBycustomerId(int customerId)
		throws com.liferay.portal.SystemException;

	public int countByorgId(int orgId)
		throws com.liferay.portal.SystemException;

	public int countBydescription(java.lang.String description)
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
}