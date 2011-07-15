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
 * <a href="LmisViewTimeChangeReqsPersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisViewTimeChangeReqsPersistence extends BasePersistence {
	public void cacheResult(
		larion.progate.lmis.model.LmisViewTimeChangeReqs lmisViewTimeChangeReqs);

	public void cacheResult(
		java.util.List<larion.progate.lmis.model.LmisViewTimeChangeReqs> lmisViewTimeChangeReqses);

	public void clearCache();

	public larion.progate.lmis.model.LmisViewTimeChangeReqs create(
		java.lang.Integer lmisViewTimeChangeReqId);

	public larion.progate.lmis.model.LmisViewTimeChangeReqs remove(
		java.lang.Integer lmisViewTimeChangeReqId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewTimeChangeReqsException;

	public larion.progate.lmis.model.LmisViewTimeChangeReqs remove(
		larion.progate.lmis.model.LmisViewTimeChangeReqs lmisViewTimeChangeReqs)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewTimeChangeReqs update(
		larion.progate.lmis.model.LmisViewTimeChangeReqs lmisViewTimeChangeReqs)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewTimeChangeReqs update(
		larion.progate.lmis.model.LmisViewTimeChangeReqs lmisViewTimeChangeReqs,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewTimeChangeReqs updateImpl(
		larion.progate.lmis.model.LmisViewTimeChangeReqs lmisViewTimeChangeReqs,
		boolean merge) throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewTimeChangeReqs findByPrimaryKey(
		java.lang.Integer lmisViewTimeChangeReqId)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewTimeChangeReqsException;

	public larion.progate.lmis.model.LmisViewTimeChangeReqs fetchByPrimaryKey(
		java.lang.Integer lmisViewTimeChangeReqId)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewTimeChangeReqs> findByRootId(
		int rootId) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewTimeChangeReqs> findByRootId(
		int rootId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewTimeChangeReqs> findByRootId(
		int rootId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewTimeChangeReqs findByRootId_First(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewTimeChangeReqsException;

	public larion.progate.lmis.model.LmisViewTimeChangeReqs findByRootId_Last(
		int rootId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewTimeChangeReqsException;

	public larion.progate.lmis.model.LmisViewTimeChangeReqs[] findByRootId_PrevAndNext(
		java.lang.Integer lmisViewTimeChangeReqId, int rootId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewTimeChangeReqsException;

	public java.util.List<larion.progate.lmis.model.LmisViewTimeChangeReqs> findByUserId(
		int requestedBy) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewTimeChangeReqs> findByUserId(
		int requestedBy, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewTimeChangeReqs> findByUserId(
		int requestedBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisViewTimeChangeReqs findByUserId_First(
		int requestedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewTimeChangeReqsException;

	public larion.progate.lmis.model.LmisViewTimeChangeReqs findByUserId_Last(
		int requestedBy, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewTimeChangeReqsException;

	public larion.progate.lmis.model.LmisViewTimeChangeReqs[] findByUserId_PrevAndNext(
		java.lang.Integer lmisViewTimeChangeReqId, int requestedBy,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			larion.progate.lmis.NoSuchLmisViewTimeChangeReqsException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewTimeChangeReqs> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewTimeChangeReqs> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<larion.progate.lmis.model.LmisViewTimeChangeReqs> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByRootId(int rootId)
		throws com.liferay.portal.SystemException;

	public void removeByUserId(int requestedBy)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByRootId(int rootId)
		throws com.liferay.portal.SystemException;

	public int countByUserId(int requestedBy)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}