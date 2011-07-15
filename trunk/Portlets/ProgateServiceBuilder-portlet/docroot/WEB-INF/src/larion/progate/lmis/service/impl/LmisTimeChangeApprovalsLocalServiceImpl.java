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

package larion.progate.lmis.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import com.liferay.portal.SystemException;

import larion.progate.lmis.model.LmisTimeChangeApprovals;
import larion.progate.lmis.service.base.LmisTimeChangeApprovalsLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisTimeChangeApprovalsUtil;

/**
 * <a href="LmisTimeChangeApprovalsLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class LmisTimeChangeApprovalsLocalServiceImpl extends
		LmisTimeChangeApprovalsLocalServiceBaseImpl {

	// Ham` nay` dung cho phien ban sau, gio chua can xai`

	@Override
	public int findIdReq(int rootId, int approvedBy, int requestId)
			throws SystemException {
		int idReq = -1;

		try {
			List<LmisTimeChangeApprovals> lsRequestId = LmisTimeChangeApprovalsUtil
					.findByRequestId(requestId);

			Iterator<LmisTimeChangeApprovals> T = lsRequestId.iterator();

			while (T.hasNext() && idReq < 0) {
				LmisTimeChangeApprovals item = T.next();
				if (item.getApprovedBy() == approvedBy
						&& item.getRootId() == rootId
						&& item.getRequestId() == requestId) {

					idReq = item.getPrimaryKey();
					System.out
							.println("Success: LmisTimeChangeApprovalsLocalServiceImpl.findIdApprovalBy");
					return idReq;
				}
			}
		} catch (Exception e) {
			System.out.println("Error in LmisTimeChangeApprovalsLocalServiceImpl.findIdApprovalBy" + e.toString());
		}
		return idReq;
	}

	@Override
	public boolean doApprove(int rootId, int approvedBy, int requestId,
			boolean isApproved, String reason) throws SystemException {

		try {
			Date now = new Date();
			List<LmisTimeChangeApprovals> objApprove = LmisTimeChangeApprovalsUtil
					.findByRequestId(requestId);
			Iterator<LmisTimeChangeApprovals> T = objApprove.iterator();
			while (T.hasNext()) {
				LmisTimeChangeApprovals item = T.next();
				item.setApprovedAt(now);
				item.setApprovedStatus(true);
				item.setIsApproved(isApproved);
				item.setReason(reason);
				LmisTimeChangeApprovalsUtil.update(item, false);
			}
			System.out
					.println("Success: LmisTimeChangeApprovalsLocalServiceImpl.doApprove");
			return true;
		} catch (SystemException e) {
			System.out
					.println("Error in LmisTimeChangeApprovalsLocalServiceImpl.doApprove"
							+ e.toString());
		}

		return false;

	}
	@Override
	public List<LmisTimeChangeApprovals> getListApprovalByReqId(int rootId, int requestId) throws SystemException{
		List<LmisTimeChangeApprovals> ls = LmisTimeChangeApprovalsUtil.findByRequestId(requestId);
		System.out.println("getListApprovalByReqId: "+ls);
		return ls;
	}
	
	
}