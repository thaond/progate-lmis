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

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

import larion.progate.lmis.NoSuchLmisOvertimeRequestDetailsException;
import larion.progate.lmis.model.LmisOverTimeReportDetails;
import larion.progate.lmis.model.LmisOverTimeReports;
import larion.progate.lmis.model.LmisOvertimeApprovals;
import larion.progate.lmis.model.LmisOvertimeRequestDetails;
import larion.progate.lmis.model.LmisOvertimeRequests;
import larion.progate.lmis.model.LmisViewRegistrationOvertime;
import larion.progate.lmis.service.LmisGeneralSettingsLocalServiceUtil;
import larion.progate.lmis.service.LmisOverTimeReportsLocalServiceUtil;
import larion.progate.lmis.service.LmisOvertimeApprovalsLocalServiceUtil;
import larion.progate.lmis.service.LmisOvertimeRequestDetailsLocalServiceUtil;
import larion.progate.lmis.service.LmisOvertimeRequestsLocalServiceUtil;
import larion.progate.lmis.service.base.LmisOvertimeRequestsLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisOverTimeReportDetailsUtil;
import larion.progate.lmis.service.persistence.LmisOvertimeRequestDetailsUtil;
import larion.progate.lmis.service.persistence.LmisOvertimeRequestsUtil;
import larion.progate.lmis.service.persistence.LmisViewRegistrationOvertimeFinderUtil;
import larion.progate.lmis.service.utils.LmisConst;
import larion.progate.lmis.service.utils.LmisUtils;

/**
 * <a href="LmisOvertimeRequestsLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class LmisOvertimeRequestsLocalServiceImpl extends
		LmisOvertimeRequestsLocalServiceBaseImpl {

	public int addOtRequest(int rootId, int orgId, int userId, String otReason,
			Date regDate, Date reqDate, int[] arrUID, List arrReason,
			double[] arrTotal, List arrHM, List arrEndTime) {
		try {
			System.out.println("Call addOtRequest, step 1: add request");
			Date today = new Date();
			LmisOvertimeRequests objReq = LmisOvertimeRequestsLocalServiceUtil
					.createLmisOvertimeRequests(null);
			objReq.setRootId(rootId);
			objReq.setOrgId(orgId);
			objReq.setRequestedBy(userId);
			objReq.setRequestedAt(reqDate);
			objReq.setRequestedReason(otReason);
			objReq.setRequestedStatus(LmisConst.OverTimeReport_Status_Pending);
			objReq.setCreatedAt(today);
			LmisOvertimeRequestsLocalServiceUtil.updateLmisOvertimeRequests(
					objReq, false);
			int reqId = objReq.getPrimaryKey();
			System.out
					.println("Success: LmisOverTimeReportsLocalServiceImpl.addOtRequest, add request");
			// Add to request detail;

			for (int i = 0; i < arrUID.length; i++) {
				LmisOvertimeRequestDetails obj = LmisOvertimeRequestDetailsLocalServiceUtil
						.createLmisOvertimeRequestDetails(null);
				obj.setRootId(rootId);
				obj.setRequestId(reqId);
				obj.setUserId(arrUID[i]);
				try {
					obj.setStartTime(LmisUtils.convertStrtoDate(arrHM.get(i)
							.toString(), "HH/mm"));
					obj.setEndTime(LmisUtils.convertStrtoDate(arrEndTime.get(i)
							.toString(), "HH/mm"));
				} catch (ParseException e) {
					System.out
							.println("Error in LmisOvertimeRequestsLocalServiceImpl.addOtRequest, parse");
					e.printStackTrace();
				}
				obj.setRequestedReason(arrReason.get(i).toString());
				obj.setRequestedHour(arrTotal[i]);
				LmisOvertimeRequestDetailsLocalServiceUtil
						.updateLmisOvertimeRequestDetails(obj, false);
			}
			System.out
					.println("Success: LmisOverTimeReportsLocalServiceImpl.addOtRequest, add request detail");

			ArrayList<Integer> arrBOD = LmisGeneralSettingsLocalServiceUtil
					.getListBodUIDbyRootId(rootId);
			System.out.println("Content arrBOD:" + arrBOD);

			for (int i : arrBOD) {
				LmisOvertimeApprovals appReq = LmisOvertimeApprovalsLocalServiceUtil
						.createLmisOvertimeApprovals(null);
				appReq.setRootId(rootId);
				appReq.setRequestId(reqId);
				appReq.setApprovedBy(i);
				LmisOvertimeApprovalsLocalServiceUtil
						.updateLmisOvertimeApprovals(appReq, false);
			}

			System.out
					.println("Success: LmisOverTimeReportsLocalServiceImpl.addOtRequest");
			return LmisConst.OverTimeReq_Delete_Success;
		} catch (SystemException e) {
			System.out
					.println("Error in LmisOverTimeReportsLocalServiceImpl.addOtRequest "
							+ e.toString());
			e.printStackTrace();
		}
		return 0;
	}

	public int editOtRequest(int rootId, int reqId, String otReason,
			Date reqDate, int[] arrUID, List arrReason, double[] arrTotal,
			List arrHM, List arrEndTime) {
		try {
			List<LmisOvertimeRequestDetails> lsRemove = LmisOvertimeRequestDetailsUtil
					.findByRequestedID(reqId);
			for (LmisOvertimeRequestDetails i : lsRemove) {
				try{
					LmisOvertimeRequestDetailsLocalServiceUtil.deleteLmisOvertimeRequestDetails(i.getPrimaryKey());
				}catch (PortalException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Removed requests detail have requestId="
					+ reqId);
			System.out.println("ReqId + Date :"+ reqId + "/"+ reqDate);
			try{
			LmisOvertimeRequests objReq = LmisOvertimeRequestsLocalServiceUtil.getLmisOvertimeRequests(reqId);
			objReq.setRequestedReason(otReason);
			objReq.setRequestedAt(reqDate);
			LmisOvertimeRequestsLocalServiceUtil.updateLmisOvertimeRequests(objReq, false);
			}catch (PortalException e) {
				e.printStackTrace();
			}
			
			System.out.println("Updated requests have requestId=" + reqId);

			for (int i = 0; i < arrUID.length; i++) {
				LmisOvertimeRequestDetails obj = LmisOvertimeRequestDetailsLocalServiceUtil
						.createLmisOvertimeRequestDetails(null);
				obj.setRootId(rootId);
				obj.setRequestId(reqId);
				obj.setUserId(arrUID[i]);
				try {
					obj.setStartTime(LmisUtils.convertStrtoDate(arrHM.get(i)
							.toString(), "HH/mm"));
					obj.setEndTime(LmisUtils.convertStrtoDate(arrEndTime.get(i)
							.toString(), "HH/mm"));
				} catch (ParseException e) {
					System.out
							.println("Error in LmisOvertimeRequestsLocalServiceImpl.editOtRequest, parse");
					e.printStackTrace();
				}
				obj.setRequestedReason(arrReason.get(i).toString());
				obj.setRequestedHour(arrTotal[i]);
				LmisOvertimeRequestDetailsLocalServiceUtil
						.updateLmisOvertimeRequestDetails(obj, false);
			}
			System.out
					.println("Success: LmisOverTimeReportsLocalServiceImpl.editOtRequest, add request detail");

			System.out
					.println("Success: LmisOverTimeReportsLocalServiceImpl.editOtRequest");
			return LmisConst.OverTimeReq_Delete_Success;
		} catch (SystemException e) {
			System.out
					.println("Error in LmisOverTimeReportsLocalServiceImpl.editOtRequest "
							+ e.toString());
			e.printStackTrace();
		}
		return 0;
	}
	public List<LmisViewRegistrationOvertime> filterTabManager(int rootId, int orgId,int userId, int status){
		try {
			return LmisViewRegistrationOvertimeFinderUtil.filterTabManager(rootId, orgId, userId, status);
		} catch (Exception e) {
			System.out.println("Error in LmisOverTimeReportsLocalServiceImpl.filterTabManager");
			return new ArrayList<LmisViewRegistrationOvertime>();
		}
	}
	public List<LmisViewRegistrationOvertime> filterTabOther(int rootId, int orgId, int status){
		try {
			return LmisViewRegistrationOvertimeFinderUtil.filterTabOther(rootId, orgId, status);
		} catch (Exception e) {
			System.out.println("Error in LmisOverTimeReportsLocalServiceImpl.filterTabManager");
			return new ArrayList<LmisViewRegistrationOvertime>();
		}
	}
	public List<LmisViewRegistrationOvertime> filterAll(int rootId,Date day,int userId,int status){
		try {
			if(userId == -1){
				return LmisViewRegistrationOvertimeFinderUtil.filterByDateTabManager(rootId, day, -1, status);
			}
			else{
				return LmisViewRegistrationOvertimeFinderUtil.filterByDateTabManager(rootId, day, userId, status);
			}
		} catch (Exception e) {
			System.out.println("Error in LmisOverTimeReportsLocalServiceImpl.filterAll: "+e.toString());
			return new ArrayList<LmisViewRegistrationOvertime>();
		}
		
	}
	
}