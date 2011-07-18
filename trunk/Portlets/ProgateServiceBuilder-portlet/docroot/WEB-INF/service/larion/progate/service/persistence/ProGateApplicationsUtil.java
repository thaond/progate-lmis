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
 * <a href="ProGateApplicationsUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateApplicationsUtil {
	public static void cacheResult(
		larion.progate.model.ProGateApplications proGateApplications) {
		getPersistence().cacheResult(proGateApplications);
	}

	public static void cacheResult(
		java.util.List<larion.progate.model.ProGateApplications> proGateApplicationses) {
		getPersistence().cacheResult(proGateApplicationses);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static larion.progate.model.ProGateApplications create(
		java.lang.Integer ProGateApplicationsId) {
		return getPersistence().create(ProGateApplicationsId);
	}

	public static larion.progate.model.ProGateApplications remove(
		java.lang.Integer ProGateApplicationsId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException {
		return getPersistence().remove(ProGateApplicationsId);
	}

	public static larion.progate.model.ProGateApplications remove(
		larion.progate.model.ProGateApplications proGateApplications)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(proGateApplications);
	}

	public static larion.progate.model.ProGateApplications update(
		larion.progate.model.ProGateApplications proGateApplications)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(proGateApplications);
	}

	public static larion.progate.model.ProGateApplications update(
		larion.progate.model.ProGateApplications proGateApplications,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(proGateApplications, merge);
	}

	public static larion.progate.model.ProGateApplications updateImpl(
		larion.progate.model.ProGateApplications proGateApplications,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(proGateApplications, merge);
	}

	public static larion.progate.model.ProGateApplications findByPrimaryKey(
		java.lang.Integer ProGateApplicationsId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException {
		return getPersistence().findByPrimaryKey(ProGateApplicationsId);
	}

	public static larion.progate.model.ProGateApplications fetchByPrimaryKey(
		java.lang.Integer ProGateApplicationsId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(ProGateApplicationsId);
	}

	public static java.util.List<larion.progate.model.ProGateApplications> findBylayoutId(
		int layoutId) throws com.liferay.portal.SystemException {
		return getPersistence().findBylayoutId(layoutId);
	}

	public static java.util.List<larion.progate.model.ProGateApplications> findBylayoutId(
		int layoutId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBylayoutId(layoutId, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateApplications> findBylayoutId(
		int layoutId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBylayoutId(layoutId, start, end, obc);
	}

	public static larion.progate.model.ProGateApplications findBylayoutId_First(
		int layoutId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException {
		return getPersistence().findBylayoutId_First(layoutId, obc);
	}

	public static larion.progate.model.ProGateApplications findBylayoutId_Last(
		int layoutId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException {
		return getPersistence().findBylayoutId_Last(layoutId, obc);
	}

	public static larion.progate.model.ProGateApplications[] findBylayoutId_PrevAndNext(
		java.lang.Integer ProGateApplicationsId, int layoutId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException {
		return getPersistence()
				   .findBylayoutId_PrevAndNext(ProGateApplicationsId, layoutId,
			obc);
	}

	public static java.util.List<larion.progate.model.ProGateApplications> findByname(
		java.lang.String name) throws com.liferay.portal.SystemException {
		return getPersistence().findByname(name);
	}

	public static java.util.List<larion.progate.model.ProGateApplications> findByname(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByname(name, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateApplications> findByname(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByname(name, start, end, obc);
	}

	public static larion.progate.model.ProGateApplications findByname_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException {
		return getPersistence().findByname_First(name, obc);
	}

	public static larion.progate.model.ProGateApplications findByname_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException {
		return getPersistence().findByname_Last(name, obc);
	}

	public static larion.progate.model.ProGateApplications[] findByname_PrevAndNext(
		java.lang.Integer ProGateApplicationsId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException {
		return getPersistence()
				   .findByname_PrevAndNext(ProGateApplicationsId, name, obc);
	}

	public static java.util.List<larion.progate.model.ProGateApplications> findByisHidden(
		boolean isHidden) throws com.liferay.portal.SystemException {
		return getPersistence().findByisHidden(isHidden);
	}

	public static java.util.List<larion.progate.model.ProGateApplications> findByisHidden(
		boolean isHidden, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByisHidden(isHidden, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateApplications> findByisHidden(
		boolean isHidden, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByisHidden(isHidden, start, end, obc);
	}

	public static larion.progate.model.ProGateApplications findByisHidden_First(
		boolean isHidden, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException {
		return getPersistence().findByisHidden_First(isHidden, obc);
	}

	public static larion.progate.model.ProGateApplications findByisHidden_Last(
		boolean isHidden, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException {
		return getPersistence().findByisHidden_Last(isHidden, obc);
	}

	public static larion.progate.model.ProGateApplications[] findByisHidden_PrevAndNext(
		java.lang.Integer ProGateApplicationsId, boolean isHidden,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException {
		return getPersistence()
				   .findByisHidden_PrevAndNext(ProGateApplicationsId, isHidden,
			obc);
	}

	public static java.util.List<larion.progate.model.ProGateApplications> findBycreatedDateEqual(
		java.util.Date createdDate) throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedDateEqual(createdDate);
	}

	public static java.util.List<larion.progate.model.ProGateApplications> findBycreatedDateEqual(
		java.util.Date createdDate, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedDateEqual(createdDate, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateApplications> findBycreatedDateEqual(
		java.util.Date createdDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findBycreatedDateEqual(createdDate, start, end, obc);
	}

	public static larion.progate.model.ProGateApplications findBycreatedDateEqual_First(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException {
		return getPersistence().findBycreatedDateEqual_First(createdDate, obc);
	}

	public static larion.progate.model.ProGateApplications findBycreatedDateEqual_Last(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException {
		return getPersistence().findBycreatedDateEqual_Last(createdDate, obc);
	}

	public static larion.progate.model.ProGateApplications[] findBycreatedDateEqual_PrevAndNext(
		java.lang.Integer ProGateApplicationsId, java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException {
		return getPersistence()
				   .findBycreatedDateEqual_PrevAndNext(ProGateApplicationsId,
			createdDate, obc);
	}

	public static java.util.List<larion.progate.model.ProGateApplications> findBycreatedDateGreater(
		java.util.Date createdDate) throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedDateGreater(createdDate);
	}

	public static java.util.List<larion.progate.model.ProGateApplications> findBycreatedDateGreater(
		java.util.Date createdDate, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedDateGreater(createdDate, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateApplications> findBycreatedDateGreater(
		java.util.Date createdDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findBycreatedDateGreater(createdDate, start, end, obc);
	}

	public static larion.progate.model.ProGateApplications findBycreatedDateGreater_First(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException {
		return getPersistence().findBycreatedDateGreater_First(createdDate, obc);
	}

	public static larion.progate.model.ProGateApplications findBycreatedDateGreater_Last(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException {
		return getPersistence().findBycreatedDateGreater_Last(createdDate, obc);
	}

	public static larion.progate.model.ProGateApplications[] findBycreatedDateGreater_PrevAndNext(
		java.lang.Integer ProGateApplicationsId, java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException {
		return getPersistence()
				   .findBycreatedDateGreater_PrevAndNext(ProGateApplicationsId,
			createdDate, obc);
	}

	public static java.util.List<larion.progate.model.ProGateApplications> findBycreatedDateLower(
		java.util.Date createdDate) throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedDateLower(createdDate);
	}

	public static java.util.List<larion.progate.model.ProGateApplications> findBycreatedDateLower(
		java.util.Date createdDate, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBycreatedDateLower(createdDate, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateApplications> findBycreatedDateLower(
		java.util.Date createdDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findBycreatedDateLower(createdDate, start, end, obc);
	}

	public static larion.progate.model.ProGateApplications findBycreatedDateLower_First(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException {
		return getPersistence().findBycreatedDateLower_First(createdDate, obc);
	}

	public static larion.progate.model.ProGateApplications findBycreatedDateLower_Last(
		java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException {
		return getPersistence().findBycreatedDateLower_Last(createdDate, obc);
	}

	public static larion.progate.model.ProGateApplications[] findBycreatedDateLower_PrevAndNext(
		java.lang.Integer ProGateApplicationsId, java.util.Date createdDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException {
		return getPersistence()
				   .findBycreatedDateLower_PrevAndNext(ProGateApplicationsId,
			createdDate, obc);
	}

	public static java.util.List<larion.progate.model.ProGateApplications> findBymodifiedDateEqual(
		java.util.Date modifiedDate) throws com.liferay.portal.SystemException {
		return getPersistence().findBymodifiedDateEqual(modifiedDate);
	}

	public static java.util.List<larion.progate.model.ProGateApplications> findBymodifiedDateEqual(
		java.util.Date modifiedDate, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBymodifiedDateEqual(modifiedDate, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateApplications> findBymodifiedDateEqual(
		java.util.Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findBymodifiedDateEqual(modifiedDate, start, end, obc);
	}

	public static larion.progate.model.ProGateApplications findBymodifiedDateEqual_First(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException {
		return getPersistence().findBymodifiedDateEqual_First(modifiedDate, obc);
	}

	public static larion.progate.model.ProGateApplications findBymodifiedDateEqual_Last(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException {
		return getPersistence().findBymodifiedDateEqual_Last(modifiedDate, obc);
	}

	public static larion.progate.model.ProGateApplications[] findBymodifiedDateEqual_PrevAndNext(
		java.lang.Integer ProGateApplicationsId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException {
		return getPersistence()
				   .findBymodifiedDateEqual_PrevAndNext(ProGateApplicationsId,
			modifiedDate, obc);
	}

	public static java.util.List<larion.progate.model.ProGateApplications> findBymodifiedDateGreater(
		java.util.Date modifiedDate) throws com.liferay.portal.SystemException {
		return getPersistence().findBymodifiedDateGreater(modifiedDate);
	}

	public static java.util.List<larion.progate.model.ProGateApplications> findBymodifiedDateGreater(
		java.util.Date modifiedDate, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findBymodifiedDateGreater(modifiedDate, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateApplications> findBymodifiedDateGreater(
		java.util.Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findBymodifiedDateGreater(modifiedDate, start, end, obc);
	}

	public static larion.progate.model.ProGateApplications findBymodifiedDateGreater_First(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException {
		return getPersistence()
				   .findBymodifiedDateGreater_First(modifiedDate, obc);
	}

	public static larion.progate.model.ProGateApplications findBymodifiedDateGreater_Last(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException {
		return getPersistence().findBymodifiedDateGreater_Last(modifiedDate, obc);
	}

	public static larion.progate.model.ProGateApplications[] findBymodifiedDateGreater_PrevAndNext(
		java.lang.Integer ProGateApplicationsId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException {
		return getPersistence()
				   .findBymodifiedDateGreater_PrevAndNext(ProGateApplicationsId,
			modifiedDate, obc);
	}

	public static java.util.List<larion.progate.model.ProGateApplications> findBymodifiedDateLower(
		java.util.Date modifiedDate) throws com.liferay.portal.SystemException {
		return getPersistence().findBymodifiedDateLower(modifiedDate);
	}

	public static java.util.List<larion.progate.model.ProGateApplications> findBymodifiedDateLower(
		java.util.Date modifiedDate, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findBymodifiedDateLower(modifiedDate, start, end);
	}

	public static java.util.List<larion.progate.model.ProGateApplications> findBymodifiedDateLower(
		java.util.Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findBymodifiedDateLower(modifiedDate, start, end, obc);
	}

	public static larion.progate.model.ProGateApplications findBymodifiedDateLower_First(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException {
		return getPersistence().findBymodifiedDateLower_First(modifiedDate, obc);
	}

	public static larion.progate.model.ProGateApplications findBymodifiedDateLower_Last(
		java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException {
		return getPersistence().findBymodifiedDateLower_Last(modifiedDate, obc);
	}

	public static larion.progate.model.ProGateApplications[] findBymodifiedDateLower_PrevAndNext(
		java.lang.Integer ProGateApplicationsId, java.util.Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateApplicationsException {
		return getPersistence()
				   .findBymodifiedDateLower_PrevAndNext(ProGateApplicationsId,
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

	public static java.util.List<larion.progate.model.ProGateApplications> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<larion.progate.model.ProGateApplications> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<larion.progate.model.ProGateApplications> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeBylayoutId(int layoutId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeBylayoutId(layoutId);
	}

	public static void removeByname(java.lang.String name)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByname(name);
	}

	public static void removeByisHidden(boolean isHidden)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByisHidden(isHidden);
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

	public static int countBylayoutId(int layoutId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countBylayoutId(layoutId);
	}

	public static int countByname(java.lang.String name)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByname(name);
	}

	public static int countByisHidden(boolean isHidden)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByisHidden(isHidden);
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

	public static ProGateApplicationsPersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(ProGateApplicationsPersistence persistence) {
		_persistence = persistence;
	}

	private static ProGateApplicationsPersistence _persistence;
}