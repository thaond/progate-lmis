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

import org.apache.commons.collections.ListUtils;

import com.liferay.portal.SystemException;

import larion.progate.lmis.model.LmisOverTimeReports;
import larion.progate.lmis.model.LmisOvertimeApprovals;
import larion.progate.lmis.model.LmisViewReportOvertime;
import larion.progate.lmis.service.LmisViewRegistrationOvertimeLocalServiceUtil;
import larion.progate.lmis.service.LmisViewReportOvertimeLocalServiceUtil;
import larion.progate.lmis.service.base.LmisViewReportOvertimeLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisOverTimeReportsUtil;
import larion.progate.lmis.service.persistence.LmisOvertimeApprovalsUtil;
import larion.progate.lmis.service.persistence.LmisViewReportOvertimeFinderUtil;
import larion.progate.lmis.service.persistence.LmisViewReportOvertimeUtil;
import larion.progate.lmis.service.utils.LmisConst;


/**
 * <a href="LmisViewReportOvertimeLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewReportOvertimeLocalServiceImpl
	extends LmisViewReportOvertimeLocalServiceBaseImpl {
	

	
	public int countReportPending(int rootId) throws SystemException{
		List<LmisViewReportOvertime> lsRoot = LmisViewReportOvertimeUtil.findByRootID(rootId);
		List<LmisViewReportOvertime> lsStatus = LmisViewReportOvertimeUtil.findByreportedStatus(LmisConst.OverTimeReport_Status_Pending);		
		List<LmisViewReportOvertime> ls=  ListUtils.intersection(lsRoot, lsStatus);
		return ls.size();
	}

	public List<LmisViewReportOvertime> getListOverTimeRepRoleSpec(
			int rootId) throws com.liferay.portal.SystemException {
		try {		
		List<LmisViewReportOvertime> result = LmisViewReportOvertimeFinderUtil.getListOtRepRoleSpecs(rootId);
		System.out.println("success LmisViewReportOvertime.getListOverTimeRepRoleSpec "+ result.toString());
		return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<LmisViewReportOvertime> getListOverTimeRepRoleSpec(
			int rootId,int orgId) throws com.liferay.portal.SystemException {
		try {
		System.out.println("rootId "+ rootId);
		List<LmisViewReportOvertime> ls= LmisViewReportOvertimeFinderUtil.getListOtRepRoleSpecs(rootId);
		System.out.println("orgId "+ orgId);
		List<LmisViewReportOvertime> lsOrg = LmisViewReportOvertimeUtil.findByOrgID(orgId);
		System.out.println("lsOrg "+lsOrg.toString());
		
		List<LmisViewReportOvertime> result = ListUtils.intersection(ls, lsOrg);
		System.out.println("success LmisViewReportOvertime.getListOverTimeRepRoleSpecFilter "+ result.toString());
		return result;
		} catch (Exception e) {
			System.out.println("Error in LmisViewReportOvertime.getListOverTimeRepRoleSpecFilter "+ e.toString());
		}
		return null;
	}
	
	

	public List<LmisViewReportOvertime> getListOverTimeRepRolePM(int rootId,int reportBy) throws com.liferay.portal.SystemException {
		try {
			

			List<larion.progate.lmis.model.LmisViewReportOvertime> lsResult  = LmisViewReportOvertimeFinderUtil.getListOverTimeRepByRole(rootId, reportBy);
			
			System.out.println("Success:LmisViewReportOvertime.getListOverTimeRepRolePM");
			return lsResult;
		} catch (SystemException e) {
			System.out
					.println("Error in LmisViewReportOvertime.getListOverTimeRepRolePM  reportBy has id ="
							+ reportBy);
			e.printStackTrace();
		}
		return null;
	}
	
	

	public List<LmisViewReportOvertime> getListOverTimeRepRoleBOD(int rootId,int reportBy) throws com.liferay.portal.SystemException {
		try {
					
			List<larion.progate.lmis.model.LmisViewReportOvertime> lsResult = LmisViewReportOvertimeFinderUtil.getListOverTimeRepByRole(rootId, reportBy);
			
			System.out.println("Success:LmisViewReportOvertime.getListOverTimeRepRoleBOD");
			return lsResult;
		} catch (SystemException e) {
			System.out
					.println("Error in LmisViewReportOvertime.getListOverTimeRepRoleBOD reportBy has id ="
							+ reportBy);
			e.printStackTrace();
		}
		return null;
	}
	

	public List<LmisViewReportOvertime> getListOverTimeRepDetail(int orgId,int reportId) throws com.liferay.portal.SystemException {	
		List<LmisViewReportOvertime> lsReq = LmisViewReportOvertimeUtil.findByReportID(reportId);
		List<LmisViewReportOvertime> lsOrg = LmisViewReportOvertimeUtil.findByOrgID(orgId);		
		List<LmisViewReportOvertime> lsResult = ListUtils.intersection(lsOrg, lsReq);		
		return lsResult;
	}	 
	
	

	public int findIdRep(int rootId, int approvedBy, int reportId)
			throws SystemException {
		int idRep = -1;

		try {
			List<LmisOvertimeApprovals> lsReportId = LmisOvertimeApprovalsUtil.findByReportID(reportId);
			Iterator<LmisOvertimeApprovals> T = lsReportId.iterator();
			while (T.hasNext() && idRep < 0) {
				LmisOvertimeApprovals item = T.next();
				if (item.getApprovedBy() == approvedBy&& item.getRootId() == rootId	&& item.getReportId() == reportId)
				{
					idRep = item.getPrimaryKey();
					System.out.println("Success:  LmisViewReportOvertimeLocalServiceImpl.findIdApprovalBy");
					return idRep;
				}
			}
		} catch (Exception e) {
			System.out
					.println("Error in  LmisViewReportOvertimeLocalServiceImpl.findIdApprovalBy"
							+ e.toString());
		}
		return idRep;
	}

	
	public boolean doApprove(int rootId, int orgId, int approvedBy,
			int reportId, boolean isApproved,boolean approvedStatus, String reason)
			throws SystemException {

		try {
			System.out.println("Errorddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd reportID :"+reportId);
			Date now = new Date();
			List<LmisOvertimeApprovals> objApprove = LmisOvertimeApprovalsUtil.findByReportID(reportId);			
			Iterator<LmisOvertimeApprovals > T = objApprove.iterator();
			while (T.hasNext()) {
				LmisOvertimeApprovals  item = T.next();
				item.setApprovedAt(now);
				item.setReportId(reportId);
				item.setApprovedStatus(true);
				item.setIsApproved(isApproved);
				item.setApprovedStatus(approvedStatus);
				item.setReaSon(reason);
				LmisOvertimeApprovalsUtil.update(item, false);
			}
			System.out
					.println("Success: LmisViewReportOvertimeLocalServiceImpl.doApprove");
			return true;
		} catch (SystemException e) {
			System.out
					.println("Error in LmisViewReportOvertimeLocalServiceImpl.doApprove"
							+ e.toString());
		}

		return false;

	}

	public boolean doApproveIt(int rootId, int orgId, int approvedBy,
			int reportId, boolean isApproved, String reason)
			throws SystemException {
		try {
			System.out.println("Errorddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd reportID :"+reportId);
			int idRep = LmisViewReportOvertimeLocalServiceUtil.findIdRep(
					rootId, approvedBy, reportId);
			if (idRep >= 0) {
				boolean flag = LmisViewReportOvertimeLocalServiceUtil.doApprove(rootId, orgId, approvedBy, reportId, isApproved, true, reason);
				if (flag == true) {
					try {
						Date now = new Date();
						LmisOverTimeReports objApp = LmisOverTimeReportsUtil.fetchByPrimaryKey(reportId);								
						objApp.setUpdatedAt(now);
						if (isApproved == true) {
							objApp.setReportedStatus(LmisConst.OverTimeReport_Status_Accepted);
						} else {
							objApp.setReportedStatus(LmisConst.OverTimeReport_Status_NotAccept);
						}
						LmisOverTimeReportsUtil.update(objApp, flag);
						System.out.println("Success change status LmisViewReportOvertime ");

						
						System.out
								.println("Success: LmisViewReportOvertimeLocalServiceImplLocalServiceImpl.doApproveIt");
						return true;
					} catch (SystemException e) {
						System.out
								.println("Error in LmisViewReportOvertimeOvertimeLocalServiceImpl.doApproveIt, report id="
										+ reportId	);
						e.printStackTrace();
						return false;
					}
				} else {
					System.out
							.println("Error in LmisViewReportOvertimeLocalServiceImpl.doApproveIt.doApprove");
					return false;
				}
			} else {
				System.out
						.println("Call LmisViewReportOvertimeLocalServiceImpl.findidRep, but not match rootId, requestId, approvedId");
				return false;
			}
		} catch (SystemException e) {
			System.out
					.println("Error in LmisViewReportOvertimeLocalServiceImpl.doApproveIt"
							+ e.toString());
		}
		return false;
	}
	
}