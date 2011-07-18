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
 * <a href="ProGateApplicationsPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface ProGateApplicationsPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.model.ProGateApplications proGateApplications);

	public void cacheResult(
		java.util.List<larion.progate.model.ProGateApplications> proGateApplicationses);

	public void clearCache();

	public larion.progate.model.ProGateApplications create(
		java.lang.Integer ProGateApplicationsId);

	public larion.progate.model.ProGateApplications remove(
		java.lang.Integer ProGateApplicationsId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException;

	public larion.progate.model.ProGateApplications remove(
		larion.progate.model.ProGateApplications proGateApplications)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateApplications update(
		larion.progate.model.ProGateApplications proGateApplications)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateApplications update(
		larion.progate.model.ProGateApplications proGateApplications,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateApplications updateImpl(
		larion.progate.model.ProGateApplications proGateApplications,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateApplications findByPrimaryKey(
		java.lang.Integer ProGateApplicationsId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException;

	public larion.progate.model.ProGateApplications fetchByPrimaryKey(
		java.lang.Integer ProGateApplicationsId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateApplications> findBylayoutId(
		int layoutId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateApplications> findBylayoutId(
		int layoutId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateApplications> findBylayoutId(
		int layoutId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateApplications findBylayoutId_First(
		int layoutId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException;

	public larion.progate.model.ProGateApplications findBylayoutId_Last(
		int layoutId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException;

	public larion.progate.model.ProGateApplications[] findBylayoutId_PrevAndNext(
		java.lang.Integer ProGateApplicationsId, int layoutId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException;

	public java.util.List<larion.progate.model.ProGateApplications> findByname(
		java.lang.String name) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateApplications> findByname(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateApplications> findByname(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateApplications findByname_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException;

	public larion.progate.model.ProGateApplications findByname_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException;

	public larion.progate.model.ProGateApplications[] findByname_PrevAndNext(
		java.lang.Integer ProGateApplicationsId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException;

	public java.util.List<larion.progate.model.ProGateApplications> findByisHidden(
		boolean isHidden) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateApplications> findByisHidden(
		boolean isHidden, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateApplications> findByisHidden(
		boolean isHidden, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateApplications findByisHidden_First(
		boolean isHidden, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException;

	public larion.progate.model.ProGateApplications findByisHidden_Last(
		boolean isHidden, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException;

	public larion.progate.model.ProGateApplications[] findByisHidden_PrevAndNext(
		java.lang.Integer ProGateApplicationsId, boolean isHidden,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException;

	public java.util.List<larion.progate.model.ProGateApplications> findBycreatedDateEqual(
		java.util.Date createdDate) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateApplications> findBycreatedDateEqual(
		java.util.Date createdDate, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateApplications> findBycreatedDateEqual(
		java.util.Date createdDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateApplications findBycreatedDateEqual_First(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException;

	public larion.progate.model.ProGateApplications findBycreatedDateEqual_Last(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException;

	public larion.progate.model.ProGateApplications[] findBycreatedDateEqual_PrevAndNext(
		java.lang.Integer ProGateApplicationsId, java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException;

	public java.util.List<larion.progate.model.ProGateApplications> findBycreatedDateGreater(
		java.util.Date createdDate) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateApplications> findBycreatedDateGreater(
		java.util.Date createdDate, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateApplications> findBycreatedDateGreater(
		java.util.Date createdDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateApplications findBycreatedDateGreater_First(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException;

	public larion.progate.model.ProGateApplications findBycreatedDateGreater_Last(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException;

	public larion.progate.model.ProGateApplications[] findBycreatedDateGreater_PrevAndNext(
		java.lang.Integer ProGateApplicationsId, java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException;

	public java.util.List<larion.progate.model.ProGateApplications> findBycreatedDateLower(
		java.util.Date createdDate) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateApplications> findBycreatedDateLower(
		java.util.Date createdDate, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateApplications> findBycreatedDateLower(
		java.util.Date createdDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateApplications findBycreatedDateLower_First(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException;

	public larion.progate.model.ProGateApplications findBycreatedDateLower_Last(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException;

	public larion.progate.model.ProGateApplications[] findBycreatedDateLower_PrevAndNext(
		java.lang.Integer ProGateApplicationsId, java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException;

	public java.util.List<larion.progate.model.ProGateApplications> findBymodifiedDateEqual(
		java.util.Date modifiedDate) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateApplications> findBymodifiedDateEqual(
		java.util.Date modifiedDate, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateApplications> findBymodifiedDateEqual(
		java.util.Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateApplications findBymodifiedDateEqual_First(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException;

	public larion.progate.model.ProGateApplications findBymodifiedDateEqual_Last(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException;

	public larion.progate.model.ProGateApplications[] findBymodifiedDateEqual_PrevAndNext(
		java.lang.Integer ProGateApplicationsId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException;

	public java.util.List<larion.progate.model.ProGateApplications> findBymodifiedDateGreater(
		java.util.Date modifiedDate) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateApplications> findBymodifiedDateGreater(
		java.util.Date modifiedDate, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateApplications> findBymodifiedDateGreater(
		java.util.Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateApplications findBymodifiedDateGreater_First(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException;

	public larion.progate.model.ProGateApplications findBymodifiedDateGreater_Last(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException;

	public larion.progate.model.ProGateApplications[] findBymodifiedDateGreater_PrevAndNext(
		java.lang.Integer ProGateApplicationsId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException;

	public java.util.List<larion.progate.model.ProGateApplications> findBymodifiedDateLower(
		java.util.Date modifiedDate) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateApplications> findBymodifiedDateLower(
		java.util.Date modifiedDate, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateApplications> findBymodifiedDateLower(
		java.util.Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateApplications findBymodifiedDateLower_First(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException;

	public larion.progate.model.ProGateApplications findBymodifiedDateLower_Last(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException;

	public larion.progate.model.ProGateApplications[] findBymodifiedDateLower_PrevAndNext(
		java.lang.Integer ProGateApplicationsId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateApplications> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateApplications> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateApplications> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeBylayoutId(int layoutId)
		throws com.liferay.portal.SystemException;

	public void removeByname(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public void removeByisHidden(boolean isHidden)
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

	public int countBylayoutId(int layoutId)
		throws com.liferay.portal.SystemException;

	public int countByname(java.lang.String name)
		throws com.liferay.portal.SystemException;

	public int countByisHidden(boolean isHidden)
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