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
 * <a href="LmisOvertimeRequestDetailsPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisOvertimeRequestDetailsPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisOvertimeRequestDetails lmisOvertimeRequestDetails);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisOvertimeRequestDetails> lmisOvertimeRequestDetailses);

	public void clearCache();

	public larion.progate.lmis.model.LmisOvertimeRequestDetails create(
		java.lang.Integer lmisOvertimeRequestDetailsId);

	public larion.progate.lmis.model.LmisOvertimeRequestDetails remove(
		java.lang.Integer lmisOvertimeRequestDetailsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestDetailsException;

	public larion.progate.lmis.model.LmisOvertimeRequestDetails remove(
		larion.progate.lmis.model.LmisOvertimeRequestDetails lmisOvertimeRequestDetails)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeRequestDetails update(
		larion.progate.lmis.model.LmisOvertimeRequestDetails lmisOvertimeRequestDetails)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeRequestDetails update(
		larion.progate.lmis.model.LmisOvertimeRequestDetails lmisOvertimeRequestDetails,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeRequestDetails updateImpl(
		larion.progate.lmis.model.LmisOvertimeRequestDetails lmisOvertimeRequestDetails,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeRequestDetails findByPrimaryKey(
		java.lang.Integer lmisOvertimeRequestDetailsId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestDetailsException;

	public larion.progate.lmis.model.LmisOvertimeRequestDetails fetchByPrimaryKey(
		java.lang.Integer lmisOvertimeRequestDetailsId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeRequestDetails> findByOvertimeRequestDetailsOf(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeRequestDetails> findByOvertimeRequestDetailsOf(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeRequestDetails> findByOvertimeRequestDetailsOf(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeRequestDetails findByOvertimeRequestDetailsOf_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestDetailsException;

	public larion.progate.lmis.model.LmisOvertimeRequestDetails findByOvertimeRequestDetailsOf_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestDetailsException;

	public larion.progate.lmis.model.LmisOvertimeRequestDetails[] findByOvertimeRequestDetailsOf_PrevAndNext(
		java.lang.Integer lmisOvertimeRequestDetailsId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestDetailsException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeRequestDetails> findByRequestedID(
		int requestId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeRequestDetails> findByRequestedID(
		int requestId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeRequestDetails> findByRequestedID(
		int requestId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeRequestDetails findByRequestedID_First(
		int requestId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestDetailsException;

	public larion.progate.lmis.model.LmisOvertimeRequestDetails findByRequestedID_Last(
		int requestId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestDetailsException;

	public larion.progate.lmis.model.LmisOvertimeRequestDetails[] findByRequestedID_PrevAndNext(
		java.lang.Integer lmisOvertimeRequestDetailsId, int requestId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestDetailsException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeRequestDetails> findByUserID(
		int userId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeRequestDetails> findByUserID(
		int userId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeRequestDetails> findByUserID(
		int userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisOvertimeRequestDetails findByUserID_First(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestDetailsException;

	public larion.progate.lmis.model.LmisOvertimeRequestDetails findByUserID_Last(
		int userId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestDetailsException;

	public larion.progate.lmis.model.LmisOvertimeRequestDetails[] findByUserID_PrevAndNext(
		java.lang.Integer lmisOvertimeRequestDetailsId, int userId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisOvertimeRequestDetailsException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeRequestDetails> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeRequestDetails> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisOvertimeRequestDetails> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByOvertimeRequestDetailsOf(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeByRequestedID(int requestId)
		throws com.liferay.portal.SystemException;

	public void removeByUserID(int userId)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByOvertimeRequestDetailsOf(int rootId)
		throws com.liferay.portal.SystemException;

	public int countByRequestedID(int requestId)
		throws com.liferay.portal.SystemException;

	public int countByUserID(int userId)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}