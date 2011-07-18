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
import java.util.List;

import org.apache.commons.collections.ListUtils;

import larion.progate.lmis.model.LmisOvertimeApprovals;
import larion.progate.lmis.service.LmisOvertimeApprovalsLocalServiceUtil;
import larion.progate.lmis.service.base.LmisOvertimeApprovalsLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisOvertimeApprovalsUtil;

/**
 * <a href="LmisOvertimeApprovalsLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOvertimeApprovalsLocalServiceImpl
	extends LmisOvertimeApprovalsLocalServiceBaseImpl {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * larion.progate.lmis.service.LmisOvertimeApprovalsLocalService#getApprovalFeedback
	 * (int, int) lay phan hoi phe duyet bao cao tang ca
	 */
	public String getApprovalFeedback(int reportId, int rootId)
			throws com.liferay.portal.SystemException {
		try {
			List<LmisOvertimeApprovals> lsRoot = LmisOvertimeApprovalsUtil
					.findByOvertimeApprovalsOf(rootId);
			List<LmisOvertimeApprovals> lsRep = LmisOvertimeApprovalsUtil
					.findByReportID(reportId);
			List<LmisOvertimeApprovals> lsResult = ListUtils.intersection(
					lsRoot, lsRep);
			return lsResult.get(0).getReaSon();
		} catch (Exception e) {
			System.out.println("Error at getApprovalFeedback  : " + e.toString());

		}
		return null;
	}
	
	public boolean updateOTapp(int rootId,int reportId,int requestId,int PmId,String reason)
	{
		try {
		
			LmisOvertimeApprovals appReq = LmisOvertimeApprovalsLocalServiceUtil
					.createLmisOvertimeApprovals(null);
			appReq.setRootId(rootId);
			appReq.setReportId(reportId);
			appReq.setRequestId(requestId);
			appReq.setIsApproved(true);
			appReq.setApprovedStatus(true);
			appReq.setApprovedBy(PmId);
			appReq.setReaSon(reason);
			LmisOvertimeApprovalsLocalServiceUtil
					.updateLmisOvertimeApprovals(appReq, false);
			System.out.println("success reportId = "+ reportId);
			return true;
		} catch (Exception e) {
			System.out.println(" error in updateOTapp(int rootId,int reportId,int PmId "+ e.toString());
			return false;
		}
	
	}
}