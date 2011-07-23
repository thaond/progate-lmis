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

package larion.progate.lmis.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;

/**
 * <a href="LmisTimeChangeApprovalsLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface LmisTimeChangeApprovalsLocalService {
	public larion.progate.lmis.model.LmisTimeChangeApprovals addLmisTimeChangeApprovals(
		larion.progate.lmis.model.LmisTimeChangeApprovals lmisTimeChangeApprovals)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisTimeChangeApprovals createLmisTimeChangeApprovals(
		java.lang.Integer lmisTimeChangeApprovalId);

	public void deleteLmisTimeChangeApprovals(
		java.lang.Integer lmisTimeChangeApprovalId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	public void deleteLmisTimeChangeApprovals(
		larion.progate.lmis.model.LmisTimeChangeApprovals lmisTimeChangeApprovals)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public larion.progate.lmis.model.LmisTimeChangeApprovals getLmisTimeChangeApprovals(
		java.lang.Integer lmisTimeChangeApprovalId)
		throws com.liferay.portal.SystemException,
			com.liferay.portal.PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.lmis.model.LmisTimeChangeApprovals> getLmisTimeChangeApprovalses(
		int start, int end) throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLmisTimeChangeApprovalsesCount()
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisTimeChangeApprovals updateLmisTimeChangeApprovals(
		larion.progate.lmis.model.LmisTimeChangeApprovals lmisTimeChangeApprovals)
		throws com.liferay.portal.SystemException;

	public larion.progate.lmis.model.LmisTimeChangeApprovals updateLmisTimeChangeApprovals(
		larion.progate.lmis.model.LmisTimeChangeApprovals lmisTimeChangeApprovals,
		boolean merge) throws com.liferay.portal.SystemException;

	public int findIdReq(int rootId, int approvedBy, int requestId)
		throws com.liferay.portal.SystemException;

	public boolean doApprove(int rootId, int approvedBy, int requestId,
		boolean isApproved, java.lang.String reason)
		throws com.liferay.portal.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<larion.progate.lmis.model.LmisTimeChangeApprovals> getListApprovalByReqId(
		int rootId, int requestId) throws com.liferay.portal.SystemException;
}