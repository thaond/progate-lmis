/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.arrReason
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

import larion.progate.lmis.model.LmisOverTimeReportDetails;
import larion.progate.lmis.model.LmisOverTimeReports;
import larion.progate.lmis.model.LmisOvertimeApprovals;
import larion.progate.lmis.model.LmisOvertimeRequests;
import larion.progate.lmis.service.LmisGeneralSettingsLocalServiceUtil;
import larion.progate.lmis.service.LmisOverTimeReportDetailsLocalServiceUtil;
import larion.progate.lmis.service.LmisOverTimeReportsLocalServiceUtil;
import larion.progate.lmis.service.LmisOvertimeApprovalsLocalServiceUtil;
import larion.progate.lmis.service.LmisOvertimeRequestsLocalServiceUtil;
import larion.progate.lmis.service.base.LmisOverTimeReportsLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisOverTimeReportDetailsUtil;
import larion.progate.lmis.service.persistence.LmisOverTimeReportsUtil;
import larion.progate.lmis.service.persistence.LmisOvertimeApprovalsUtil;
import larion.progate.lmis.service.persistence.LmisOvertimeRequestsUtil;
import larion.progate.lmis.service.utils.LmisConst;
import larion.progate.lmis.service.utils.LmisUtils;

/**
 * <a href="LmisOverTimeReportsLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class LmisOverTimeReportsLocalServiceImpl extends
		LmisOverTimeReportsLocalServiceBaseImpl {
	

	/* (non-Javadoc)
	 * @see larion.progate.lmis.service.LmisOverTimeReportsLocalService#addOtReport(int, int, int, int, java.lang.String, java.util.Date, java.util.Date, int[], java.util.List, java.util.List)
	 */
	
	public int addOtReport(int reportId, int rootId, int orgId, int userId,
			String otReason, Date regDate, Date repDate, int[] arrUID,
			double[] arrTotal, List arrHM, List arrEndTime) {
		try {

			Date today = new Date();
			LmisOverTimeReports objRep = LmisOverTimeReportsUtil
					.fetchByPrimaryKey(reportId);
			objRep.setRootId(rootId);
			objRep.setOrgId(orgId);
			objRep.setReportedBy(userId);
			objRep.setReportedAt(today);
			objRep.setReportedReason(otReason);
			objRep.setReportedStatus(LmisConst.OverTimeReport_Status_Pending);
//			objRep.setCreatedAt(regDate);
			objRep.setUpdatedAt(today);
			LmisOverTimeReportsLocalServiceUtil.updateLmisOverTimeReports(
					objRep, false);
			int repId = objRep.getPrimaryKey();
			int reqId = objRep.getRequestId();
			System.out
					.println("Success: LmisOverTimeReportsLocalServiceImpl.addOtReport, add report");

			// Add to report detail;
			for (int i = 0; i < arrUID.length; i++) {
				LmisOverTimeReportDetails objDetail = LmisOverTimeReportDetailsLocalServiceUtil
						.createLmisOverTimeReportDetails(null);
				objDetail.setRootId(rootId);
				objDetail.setReportId(repId);
				objDetail.setUserId(arrUID[i]);

				try {
					objDetail.setStartTime(LmisUtils.convertStrtoDate(arrHM
							.get(i).toString(), "HH/mm"));
					objDetail.setEndTime(LmisUtils.convertStrtoDate(arrEndTime
							.get(i).toString(), "HH/mm"));
					System.out.println("Success set startTime, EndTime");
				} catch (ParseException e) {
					System.out
							.println("Error in LmisOverTimeReportssLocalServiceImpl.addOtReport, parse");
					e.printStackTrace();
				}
				objDetail.setTotalHour(arrTotal[i]);
				LmisOverTimeReportDetailsLocalServiceUtil
						.updateLmisOverTimeReportDetails(objDetail, false);
			}
			System.out
					.println("Success: LmisOverTimeReportsLocalServiceImpl.addOtReport, add report detail");

			LmisOvertimeRequests objAdd = LmisOvertimeRequestsUtil
					.fetchByPrimaryKey(reqId);
			objAdd.setRequestedStatus(LmisConst.OverTimeReq_Status_Created_Report);
			LmisOvertimeRequestsLocalServiceUtil.updateLmisOvertimeRequests(
					objAdd, false);
			System.out
					.println("Success: LmisOvertimeRequestsLocalServiceImpl.addOtReport, update status LmisOvertimeRequest");

			ArrayList<Integer> arrBOD = LmisGeneralSettingsLocalServiceUtil
					.getListBodUIDbyRootId(rootId);
			System.out.println("Content arrBOD:" + arrBOD);
			System.out.println("BAT DAU THEM APPROVALLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLll:"+reportId);
			for (int i : arrBOD) {
				LmisOvertimeApprovals appReq = LmisOvertimeApprovalsLocalServiceUtil
						.createLmisOvertimeApprovals(null);
				appReq.setRootId(rootId);
				System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE"+reportId);
				appReq.setReportId(reportId);
				System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEESSSSSSSSSSSSSS"+reportId);
				appReq.setApprovedBy(i);
				
				LmisOvertimeApprovals appReq_ = LmisOvertimeApprovalsUtil.update(appReq, false);
				
				System.out.println("appReq_  "+ appReq_.getReportId());
			}
			System.out
					.println("Success: LmisOvertimeRequestsLocalServiceImpl.addOtReport, update status LmisOvertimeApproval");
			System.out
					.println("Success: LmisOverTimeReportsLocalServiceImpl.addOtReport");
			return LmisConst.OverTimeReport_Add_Success;
		} catch (SystemException e) {
			System.out
					.println("Error in LmisOverTimeReportsLocalServiceImpl.addOtRequest "
							+ e.toString());
			e.printStackTrace();
		}
		return 0;
	}
	

	public int editOtReport(int rootId,int reportId, String otReason,
			 Date repDate, int[] arrUID,double[] arrTotal, List arrHM, List arrEndTime) {
		
		
		try {
			Date today = new Date();
			List<LmisOverTimeReportDetails> lsRemove = LmisOverTimeReportDetailsUtil.findByreportID(reportId);				
			for (LmisOverTimeReportDetails i : lsRemove) {
				try{
					LmisOverTimeReportDetailsLocalServiceUtil.deleteLmisOverTimeReportDetails(i.getPrimaryKey());
				}catch (PortalException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Removed report  detail have reportId="		+ reportId);
			System.out.println("RepId + Date :"+ reportId + "/"+ repDate);
			try{
			LmisOverTimeReports objReq = LmisOverTimeReportsLocalServiceUtil.getLmisOverTimeReports(reportId);
			objReq.setReportedReason(otReason);
			objReq.setReportedAt(repDate);
			objReq.setReportedStatus(LmisConst.OverTimeReport_Status_Pending);
			objReq.setUpdatedAt(today);
			LmisOverTimeReportsLocalServiceUtil.updateLmisOverTimeReports(objReq, false);
			}catch (PortalException e) {
				e.printStackTrace();
			}
			
			System.out.println("Updated report have reportId=" + reportId);

			for (int i = 0; i < arrUID.length; i++) {
				LmisOverTimeReportDetails obj = LmisOverTimeReportDetailsLocalServiceUtil
						.createLmisOverTimeReportDetails(null);
				obj.setRootId(rootId);
				obj.setReportId(reportId);
				obj.setUserId(arrUID[i]);
				try {
					obj.setStartTime(LmisUtils.convertStrtoDate(arrHM.get(i)
							.toString(), "HH/mm"));
					obj.setEndTime(LmisUtils.convertStrtoDate(arrEndTime.get(i)
							.toString(), "HH/mm"));
				} catch (ParseException e) {
					System.out
							.println("Error in LmisOverTimeReportsLocalServiceImpl.editOtReport, parse");
					e.printStackTrace();
				}
				obj.setTotalHour(arrTotal[i]);
				LmisOverTimeReportDetailsLocalServiceUtil
						.updateLmisOverTimeReportDetails(obj, false);
			}
			System.out
					.println("Success: LmisOverTimeReportsLocalServiceImpl.editOtReport, add report detail");

			System.out
					.println("Success: LmisOverTimeReportsLocalServiceImpl.editOtReport");
			return LmisConst.OverTimeReport_Add_Success;
		} catch (SystemException e) {
			System.out
					.println("Error in LmisOverTimeReportsLocalServiceImpl.editOtReport "
							+ e.toString());
			e.printStackTrace();
		}
		return 0;
	}
		
	
}