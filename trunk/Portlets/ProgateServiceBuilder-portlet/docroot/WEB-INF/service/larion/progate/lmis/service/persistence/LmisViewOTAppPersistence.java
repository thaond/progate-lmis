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

package larion.progate.lmis.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * <a href="LmisViewOTAppPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisViewOTAppPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisViewOTApp lmisViewOTApp);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewOTApp> lmisViewOTApps);

	public void clearCache();

	public larion.progate.lmis.model.LmisViewOTApp create(
		java.lang.Integer lmisViewOTAppId);

	public larion.progate.lmis.model.LmisViewOTApp remove(
		java.lang.Integer lmisViewOTAppId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException;

	public larion.progate.lmis.model.LmisViewOTApp remove(
		larion.progate.lmis.model.LmisViewOTApp lmisViewOTApp)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewOTApp update(
		larion.progate.lmis.model.LmisViewOTApp lmisViewOTApp)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewOTApp update(
		larion.progate.lmis.model.LmisViewOTApp lmisViewOTApp, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewOTApp updateImpl(
		larion.progate.lmis.model.LmisViewOTApp lmisViewOTApp, boolean merge)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewOTApp findByPrimaryKey(
		java.lang.Integer lmisViewOTAppId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException;

	public larion.progate.lmis.model.LmisViewOTApp fetchByPrimaryKey(
		java.lang.Integer lmisViewOTAppId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByRootID(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByRootID(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByRootID(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewOTApp findByRootID_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException;

	public larion.progate.lmis.model.LmisViewOTApp findByRootID_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException;

	public larion.progate.lmis.model.LmisViewOTApp[] findByRootID_PrevAndNext(
		java.lang.Integer lmisViewOTAppId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException;

	public java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByOrgID(
		int orgId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByOrgID(
		int orgId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByOrgID(
		int orgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewOTApp findByOrgID_First(
		int orgId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException;

	public larion.progate.lmis.model.LmisViewOTApp findByOrgID_Last(int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException;

	public larion.progate.lmis.model.LmisViewOTApp[] findByOrgID_PrevAndNext(
		java.lang.Integer lmisViewOTAppId, int orgId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException;

	public java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByRequestedAt(
		java.util.Date requestedAt) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByRequestedAt(
		java.util.Date requestedAt, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByRequestedAt(
		java.util.Date requestedAt, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewOTApp findByRequestedAt_First(
		java.util.Date requestedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException;

	public larion.progate.lmis.model.LmisViewOTApp findByRequestedAt_Last(
		java.util.Date requestedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException;

	public larion.progate.lmis.model.LmisViewOTApp[] findByRequestedAt_PrevAndNext(
		java.lang.Integer lmisViewOTAppId, java.util.Date requestedAt,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException;

	public java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByRequestedStatus(
		int requestedStatus) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByRequestedStatus(
		int requestedStatus, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByRequestedStatus(
		int requestedStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewOTApp findByRequestedStatus_First(
		int requestedStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException;

	public larion.progate.lmis.model.LmisViewOTApp findByRequestedStatus_Last(
		int requestedStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException;

	public larion.progate.lmis.model.LmisViewOTApp[] findByRequestedStatus_PrevAndNext(
		java.lang.Integer lmisViewOTAppId, int requestedStatus,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException;

	public java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByRequestedBy(
		int requestedBy) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByRequestedBy(
		int requestedBy, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByRequestedBy(
		int requestedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewOTApp findByRequestedBy_First(
		int requestedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException;

	public larion.progate.lmis.model.LmisViewOTApp findByRequestedBy_Last(
		int requestedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException;

	public larion.progate.lmis.model.LmisViewOTApp[] findByRequestedBy_PrevAndNext(
		java.lang.Integer lmisViewOTAppId, int requestedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException;

	public java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByApprovedBy(
		int approvedBy) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByApprovedBy(
		int approvedBy, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOTApp> findByApprovedBy(
		int approvedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewOTApp findByApprovedBy_First(
		int approvedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException;

	public larion.progate.lmis.model.LmisViewOTApp findByApprovedBy_Last(
		int approvedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException;

	public larion.progate.lmis.model.LmisViewOTApp[] findByApprovedBy_PrevAndNext(
		java.lang.Integer lmisViewOTAppId, int approvedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewOTAppException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOTApp> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOTApp> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewOTApp> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByRootID(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeByOrgID(int orgId)
		throws com.liferay.portal.SystemException;

	public void removeByRequestedAt(java.util.Date requestedAt)
		throws com.liferay.portal.SystemException;

	public void removeByRequestedStatus(int requestedStatus)
		throws com.liferay.portal.SystemException;

	public void removeByRequestedBy(int requestedBy)
		throws com.liferay.portal.SystemException;

	public void removeByApprovedBy(int approvedBy)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByRootID(int rootId)
		throws com.liferay.portal.SystemException;

	public int countByOrgID(int orgId)
		throws com.liferay.portal.SystemException;

	public int countByRequestedAt(java.util.Date requestedAt)
		throws com.liferay.portal.SystemException;

	public int countByRequestedStatus(int requestedStatus)
		throws com.liferay.portal.SystemException;

	public int countByRequestedBy(int requestedBy)
		throws com.liferay.portal.SystemException;

	public int countByApprovedBy(int approvedBy)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}