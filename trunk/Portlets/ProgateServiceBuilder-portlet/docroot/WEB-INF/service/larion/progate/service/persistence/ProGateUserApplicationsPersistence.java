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
 * <a href="ProGateUserApplicationsPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface ProGateUserApplicationsPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.model.ProGateUserApplications proGateUserApplications);

	public void cacheResult(
		java.util.List<larion.progate.model.ProGateUserApplications> proGateUserApplicationses);

	public void clearCache();

	public larion.progate.model.ProGateUserApplications create(
		java.lang.Integer ProGateUserApplicationsId);

	public larion.progate.model.ProGateUserApplications remove(
		java.lang.Integer ProGateUserApplicationsId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException;

	public larion.progate.model.ProGateUserApplications remove(
		larion.progate.model.ProGateUserApplications proGateUserApplications)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateUserApplications update(
		larion.progate.model.ProGateUserApplications proGateUserApplications)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateUserApplications update(
		larion.progate.model.ProGateUserApplications proGateUserApplications,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateUserApplications updateImpl(
		larion.progate.model.ProGateUserApplications proGateUserApplications,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateUserApplications findByPrimaryKey(
		java.lang.Integer ProGateUserApplicationsId)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException;

	public larion.progate.model.ProGateUserApplications fetchByPrimaryKey(
		java.lang.Integer ProGateUserApplicationsId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateUserApplications> findByuserId(
		int userId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateUserApplications> findByuserId(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateUserApplications> findByuserId(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateUserApplications findByuserId_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException;

	public larion.progate.model.ProGateUserApplications findByuserId_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException;

	public larion.progate.model.ProGateUserApplications[] findByuserId_PrevAndNext(
		java.lang.Integer ProGateUserApplicationsId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException;

	public java.util.List<larion.progate.model.ProGateUserApplications> findByorgId(
		int orgId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateUserApplications> findByorgId(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateUserApplications> findByorgId(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateUserApplications findByorgId_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException;

	public larion.progate.model.ProGateUserApplications findByorgId_Last(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException;

	public larion.progate.model.ProGateUserApplications[] findByorgId_PrevAndNext(
		java.lang.Integer ProGateUserApplicationsId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException;

	public java.util.List<larion.progate.model.ProGateUserApplications> findByappsId(
		int appsId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateUserApplications> findByappsId(
		int appsId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateUserApplications> findByappsId(
		int appsId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateUserApplications findByappsId_First(
		int appsId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException;

	public larion.progate.model.ProGateUserApplications findByappsId_Last(
		int appsId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException;

	public larion.progate.model.ProGateUserApplications[] findByappsId_PrevAndNext(
		java.lang.Integer ProGateUserApplicationsId, int appsId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException;

	public java.util.List<larion.progate.model.ProGateUserApplications> findByindexEqual(
		int position) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateUserApplications> findByindexEqual(
		int position, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateUserApplications> findByindexEqual(
		int position, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateUserApplications findByindexEqual_First(
		int position, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException;

	public larion.progate.model.ProGateUserApplications findByindexEqual_Last(
		int position, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException;

	public larion.progate.model.ProGateUserApplications[] findByindexEqual_PrevAndNext(
		java.lang.Integer ProGateUserApplicationsId, int position,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException;

	public java.util.List<larion.progate.model.ProGateUserApplications> findByindexGreater(
		int position) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateUserApplications> findByindexGreater(
		int position, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateUserApplications> findByindexGreater(
		int position, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateUserApplications findByindexGreater_First(
		int position, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException;

	public larion.progate.model.ProGateUserApplications findByindexGreater_Last(
		int position, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException;

	public larion.progate.model.ProGateUserApplications[] findByindexGreater_PrevAndNext(
		java.lang.Integer ProGateUserApplicationsId, int position,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException;

	public java.util.List<larion.progate.model.ProGateUserApplications> findByindexLower(
		int position) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateUserApplications> findByindexLower(
		int position, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateUserApplications> findByindexLower(
		int position, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.model.ProGateUserApplications findByindexLower_First(
		int position, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException;

	public larion.progate.model.ProGateUserApplications findByindexLower_Last(
		int position, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException;

	public larion.progate.model.ProGateUserApplications[] findByindexLower_PrevAndNext(
		java.lang.Integer ProGateUserApplicationsId, int position,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.NoSuchProGateUserApplicationsException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateUserApplications> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateUserApplications> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.model.ProGateUserApplications> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByuserId(int userId)
		throws com.liferay.portal.SystemException;

	public void removeByorgId(int orgId)
		throws com.liferay.portal.SystemException;

	public void removeByappsId(int appsId)
		throws com.liferay.portal.SystemException;

	public void removeByindexEqual(int position)
		throws com.liferay.portal.SystemException;

	public void removeByindexGreater(int position)
		throws com.liferay.portal.SystemException;

	public void removeByindexLower(int position)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByuserId(int userId)
		throws com.liferay.portal.SystemException;

	public int countByorgId(int orgId)
		throws com.liferay.portal.SystemException;

	public int countByappsId(int appsId)
		throws com.liferay.portal.SystemException;

	public int countByindexEqual(int position)
		throws com.liferay.portal.SystemException;

	public int countByindexGreater(int position)
		throws com.liferay.portal.SystemException;

	public int countByindexLower(int position)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}