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

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.ListUtils;

import com.liferay.portal.SystemException;


import larion.progate.lmis.model.LmisOverTimeReports;
import larion.progate.lmis.model.LmisOvertimeApprovals;
import larion.progate.lmis.model.LmisOvertimeRequestDetails;
import larion.progate.lmis.model.LmisOvertimeRequests;
import larion.progate.lmis.model.LmisViewRegistrationOvertime;
import larion.progate.lmis.service.LmisOverTimeReportsLocalServiceUtil;
import larion.progate.lmis.service.LmisOvertimeApprovalsLocalServiceUtil;
import larion.progate.lmis.service.LmisOvertimeRequestDetailsLocalServiceUtil;
import larion.progate.lmis.service.LmisViewRegistrationOvertimeLocalServiceUtil;
import larion.progate.lmis.service.base.LmisViewRegistrationOvertimeLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisOverTimeReportsUtil;
import larion.progate.lmis.service.persistence.LmisOvertimeApprovalsUtil;
import larion.progate.lmis.service.persistence.LmisOvertimeRequestDetailsUtil;
import larion.progate.lmis.service.persistence.LmisOvertimeRequestsUtil;
import larion.progate.lmis.service.persistence.LmisViewRegistrationOvertimeFinderUtil;

import larion.progate.lmis.service.persistence.LmisViewRegistrationOvertimeUtil;
import larion.progate.lmis.service.utils.LmisConst;
import larion.progate.lmis.service.utils.LmisUtils;

/**
 * <a href="LmisViewRegistrationOvertimeLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class LmisViewRegistrationOvertimeLocalServiceImpl extends
		LmisViewRegistrationOvertimeLocalServiceBaseImpl {
	
	/**
	 * @param userId
	 * @param requestedAt
	 * @return double
	 * @throws com.liferay.portal.SystemException
	 * getOtHourYesterday
	 */
	public double getOtHourYesterday(int userId, Date requestedAt,int rootId)
			throws com.liferay.portal.SystemException {
		try {
			List<LmisViewRegistrationOvertime> lsUser = LmisViewRegistrationOvertimeUtil.findByuserID(userId);
			List<LmisViewRegistrationOvertime> lsDate = LmisViewRegistrationOvertimeUtil.findByRequestedAt(requestedAt);
			List<LmisViewRegistrationOvertime> lsRoot = LmisViewRegistrationOvertimeUtil.findByRootID(rootId);			
			List<LmisViewRegistrationOvertime> lstmp = ListUtils.intersection(lsUser, lsDate);
			List<LmisViewRegistrationOvertime> lsResult = ListUtils.intersection(lstmp, lsRoot);
			return lsResult.get(0).getRequestedHour();
		} catch (Exception e) {
			System.out.println("Error : " + e.toString());
		}
		return 0;
	}

	@Override
	public List<LmisViewRegistrationOvertime> getListOverTimeReqsByRootId(
			int rootId) throws com.liferay.portal.SystemException {
		return LmisViewRegistrationOvertimeUtil.findByRootID(rootId);
	}

	@Override
	public int countRequestOfUID(int rootId, int userId) throws SystemException {
		List<LmisViewRegistrationOvertime> ls = LmisViewRegistrationOvertimeUtil
				.findByuserID(userId);
		return ls.size();
	}

	@Override
	public List<LmisViewRegistrationOvertime> getListOverTimeReqsByOrgId(
			Date date, int orgId) throws com.liferay.portal.SystemException {
		List<LmisViewRegistrationOvertime> lsOrg = LmisViewRegistrationOvertimeUtil
				.findByOrgID(orgId);
		List<LmisViewRegistrationOvertime> lsDate = LmisViewRegistrationOvertimeUtil
				.findByRequestedAt(date);
		List<LmisViewRegistrationOvertime> lsResult = ListUtils.intersection(
				lsOrg, lsDate);
		return lsResult;
	}

	
	public int countRequestPending(int rootId,int userId) throws SystemException {
		/*List<LmisViewRegistrationOvertime> lsRoot = LmisViewRegistrationOvertimeUtil
				.findByRootID(rootId);
		List<LmisViewRegistrationOvertime> lsApp = LmisViewRegistrationOvertimeUtil.findByApprovedBy(userId);
		List<LmisViewRegistrationOvertime> ls = ListUtils.intersection(lsRoot, lsApp);
		
		int c=0;
		if(ls.size() >0){
			for (LmisViewRegistrationOvertime i : ls) {
				LmisOvertimeRequests t = LmisOvertimeRequestsUtil.fetchByPrimaryKey(i.getRequestId());
				if(t.getRequestedStatus()==LmisConst.OverTimeReq_Status_Pending && t.getRootId()==rootId ){
					c++;
				}
			}
			
		}
		return c;*/
		return LmisViewRegistrationOvertimeFinderUtil.countOtRequestPending(rootId, userId);
		
	}

	@Override
	public List<LmisViewRegistrationOvertime> getListOverTimeReqRoleUser(
			int userId, int rootId) throws com.liferay.portal.SystemException {
		List<LmisViewRegistrationOvertime> ls = LmisViewRegistrationOvertimeFinderUtil.getListOtReqRoleUser(rootId, userId) ;
		return ls;
	}

	@Override
	public List<LmisViewRegistrationOvertime> getListOverTimeReqRoleSpec(
			int rootId) throws com.liferay.portal.SystemException {
		try {
			List<LmisViewRegistrationOvertime> result = LmisViewRegistrationOvertimeFinderUtil
					.getListOtReqRoleSpecs(rootId);
			System.out.println("success" + result.toString());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<LmisViewRegistrationOvertime> getListOverTimeReqDetail(
			int rootId,int requestId)
			throws com.liferay.portal.SystemException {
		List<LmisViewRegistrationOvertime> lsRoot = LmisViewRegistrationOvertimeUtil
				.findByRootID(rootId);
		List<LmisViewRegistrationOvertime> lsReq = LmisViewRegistrationOvertimeUtil
				.findByRequestID(requestId);
		
		List<LmisViewRegistrationOvertime> ls = ListUtils.intersection(lsRoot,
				lsReq);
	
		return ls;
	}

	@Override
	public boolean editOverTimeRequest(int rootId, int requestId,
			int requestBy, Date requestedAt, String requestReason, int orgId,
			int requestDetailId, int userId, Date startTime, Date endTime,
			String reasonDetail, double requestHour) throws SystemException {
		try {
			Date now = new Date();
			LmisOvertimeRequests objEdit = LmisOvertimeRequestsUtil
					.fetchByPrimaryKey(requestId);
			if (objEdit.getRootId() == rootId) {
				objEdit.setRequestedBy(requestBy);
				objEdit.setRequestedAt(requestedAt);
				objEdit.setRequestedReason(requestReason);
				objEdit.setOrgId(orgId);
				objEdit.setUpdatedAt(requestedAt);
				LmisOvertimeRequestsUtil.update(objEdit, false);
				System.out.println(objEdit.toString());
			}
			LmisOvertimeRequestDetails obj = LmisOvertimeRequestDetailsUtil
					.fetchByPrimaryKey(requestDetailId);
			if (obj.getRootId() == rootId) {
				obj.setUserId(userId);
				obj.setStartTime(startTime);
				obj.setEndTime(endTime);
				obj.setRequestedReason(reasonDetail);
				obj.setRequestedHour(requestHour);
				LmisOvertimeRequestDetailsUtil.update(obj, false);
				System.out.println(obj.toString());
			}
			System.out
					.println("Success: in LmisViewRegistrationOvertimeLocalServiceImpl.editOverTimeRequest");

			LmisOverTimeReports overRep = LmisOverTimeReportsUtil.create(null);
			if (overRep.getRootId() == rootId) {
				overRep.setReportedReason(requestReason);
				overRep.setCreatedAt(requestedAt);
				overRep.setReportedBy(requestBy);
				overRep.setUpdatedAt(now);
				overRep.setReportedStatus(LmisConst.OverTimeReport_Status_Pending);
				LmisOverTimeReportsLocalServiceUtil.updateLmisOverTimeReports(
						overRep, false);
				System.out.println("OverRep" + overRep.toString());
			}
			return true;
		} catch (Exception e) {
			System.out
					.println("Error in LmisViewRegistrationOvertimeLocalServiceImpl.editOverTimeRequest "
							+ e.toString());
		}
		return false;
	}

	@Override
	public boolean addOverTimeRequest(int rootId, int requestId, int requestBy,
			Date requestedAt, String requestReason, Date createdAt, int orgId,
			int userId, Date startTime, Date endTime, String reasonDetail,
			double requestHour) throws SystemException {
		try {
			larion.progate.lmis.model.LmisOvertimeRequests objAdd = LmisOvertimeRequestsUtil
					.create(null);
			Date now = new Date();

			objAdd.setRootId(rootId);
			objAdd.setRequestedBy(requestBy);
			objAdd.setRequestedAt(requestedAt);
			objAdd.setRequestedReason(requestReason);
			objAdd.setRequestedStatus(1);
			objAdd.setOrgId(orgId);
			objAdd.setCreatedAt(now);
			objAdd.setUpdatedAt(now);
			LmisOvertimeRequestsUtil.update(objAdd, false);
			int objPkJustAdd = objAdd.getPrimaryKey();
			System.out
					.println("Success step1 in LmisViewRegistrationOvertimeLocalServiceImpl.addOverTimeRequest");

			try {

				LmisOvertimeRequestDetails iOt = LmisOvertimeRequestDetailsUtil
						.create(null);
				iOt.setRootId(rootId);
				iOt.setRequestId(objPkJustAdd);
				iOt.setRequestedReason(reasonDetail);
				iOt.setUserId(userId);
				iOt.setStartTime(startTime);
				iOt.setEndTime(endTime);
				iOt.setRequestedHour(requestHour);
				LmisOvertimeRequestDetailsLocalServiceUtil
						.updateLmisOvertimeRequestDetails(iOt, false);
				System.out
						.println("Success step2 in LmisViewRegistrationOvertimeLocalServiceImpl.addOverTimeRequest");
				List<Integer> arrPmID = LmisUtils
						.getListPmIdOrBodIdByUserId(rootId, userId);
				System.out.println("Content " + arrPmID.toString());

				LmisOverTimeReports overRep = LmisOverTimeReportsUtil
						.create(null);
				overRep.setRequestId(objPkJustAdd);
				overRep.setReportedReason(requestReason);
				overRep.setCreatedAt(requestedAt);
				overRep.setReportedBy(requestBy);
				overRep.setReportedStatus(LmisConst.OverTimeReport_Status_Pending);
				LmisOverTimeReportsLocalServiceUtil.updateLmisOverTimeReports(
						overRep, false);
				int objRep = overRep.getPrimaryKey();
				System.out.println("OverRep" + overRep.toString());
				System.out
						.println("Success step3 in LmisViewRegistrationOvertimeLocalServiceImpl.addOverTimeRequest");

				for (int i = 0; i < arrPmID.size(); i += 2) {
					LmisOvertimeApprovals iApp = LmisOvertimeApprovalsUtil
							.create(null);
					iApp.setRootId(rootId);
					iApp.setRequestId(objPkJustAdd);
					// iApp.setReportId(objRep);
					System.out.println("iApp.setRequestId(objPkJustAdd):");
					iApp.setApprovedBy(i);
					iApp.setApprovedStatus(false);
					LmisOvertimeApprovalsLocalServiceUtil
							.updateLmisOvertimeApprovals(iApp, false);
					System.out.println("iApp" + iApp.toString());
					System.out
							.println("Success step4a in LmisViewRegistrationOvertimeLocalServiceImpl.addOverTimeRequest");

					LmisOvertimeApprovals iApps = LmisOvertimeApprovalsUtil
							.create(null);
					iApps.setRootId(rootId);
					iApps.setReportId(objRep);
					iApps.setApprovedBy(i);
					iApps.setApprovedStatus(false);
					LmisOvertimeApprovalsLocalServiceUtil
							.updateLmisOvertimeApprovals(iApps, false);
					System.out.println("iApps" + iApps.toString());
					System.out
							.println("Success step4b in LmisViewRegistrationOvertimeLocalServiceImpl.addOverTimeRequest");
				}
				System.out
						.println("Success: LmisViewRegistrationOvertimeLocalServiceImpl..addRequestTimeChange, just added Approvals has RequestID="
								+ objPkJustAdd);
				return true;
			} catch (SystemException e) {

			}
		} catch (Exception e) {
			System.out
					.println("Error in LmisViewRegistrationOvertimeLocalServiceImpl.addRequestTimeChange"
							+ e.toString());
		}
		return false;
	}

	@Override
	public List<LmisOvertimeApprovals> getListApprovalByReqId(int rootId,
			int requestId) throws SystemException {
		List<LmisOvertimeApprovals> lsReq = LmisOvertimeApprovalsUtil
				.findByRequestID(requestId);
		List<LmisOvertimeApprovals> lsRoot = LmisOvertimeApprovalsUtil
				.findByOvertimeApprovalsOf(rootId);
		List<LmisOvertimeApprovals> ls = ListUtils.intersection(lsReq, lsRoot);
		return ls;
	}

	@Override
	public int findIdReq(int rootId, int approvedBy, int requestId)
			throws SystemException {
		int idReq = -1;

		try {
			List<LmisOvertimeApprovals> lsRequestId = LmisOvertimeApprovalsUtil
					.findByRequestID(requestId);
			Iterator<LmisOvertimeApprovals> T = lsRequestId.iterator();
			while (T.hasNext() && idReq < 0) {
				LmisOvertimeApprovals item = T.next();
				if (item.getApprovedBy() == approvedBy
						&& item.getRootId() == rootId
						&& item.getRequestId() == requestId) {

					idReq = item.getPrimaryKey();
					System.out
							.println("Success:  LmisViewRegistrationOvertimeLocalServiceImpl.findIdApprovalBy");
					return idReq;
				}
			}
		} catch (Exception e) {
			System.out
					.println("Error in  LmisViewRegistrationOvertimeLocalServiceImpl.findIdApprovalBy"
							+ e.toString());
		}
		return idReq;
	}

	@Override
	public boolean doApprove(int rootId, int orgId, int approvedBy,
			int requestId, boolean isApproved, String reason)
			throws SystemException {

		try {
			System.out.println("content :doApprove:reason: "+ reason);
			Date now = new Date();
			List<LmisOvertimeApprovals> objApprove = LmisOvertimeApprovalsUtil
					.findByRequestID(requestId);
			Iterator<LmisOvertimeApprovals> T = objApprove.iterator();
			while (T.hasNext()) {
				LmisOvertimeApprovals item = T.next();
				item.setApprovedAt(now);
				item.setApprovedStatus(true);
				item.setIsApproved(isApproved);
				item.setReaSon(reason);
				LmisOvertimeApprovalsUtil.update(item, false);
			}
			System.out
					.println("Success: LmisViewRegistrationOvertimeLocalServiceImpl.doApprove");
			return true;
		} catch (SystemException e) {
			System.out
					.println("Error in LmisViewRegistrationOvertimeLocalServiceImpl.doApprove"
							+ e.toString());
		}

		return false;

	}


	@Override
	public boolean doApproveIt(int rootId, int orgId, int approvedBy,
			int requestId, boolean isApproved, String reason)
			throws SystemException {
		try {
			int idReq = LmisViewRegistrationOvertimeLocalServiceUtil.findIdReq(
					rootId, approvedBy, requestId);
			if (idReq >= 0) {
				try {
					if(doApprove(rootId, orgId, approvedBy, requestId, isApproved, reason)){
						Date now = new Date();
						LmisOvertimeRequests objApp = LmisOvertimeRequestsUtil
								.fetchByPrimaryKey(requestId);
						objApp.setUpdatedAt(now);
						if (isApproved == true) {
							objApp.setRequestedStatus(LmisConst.OverTimeReq_Status_Accepted);
						} else {
							objApp.setRequestedStatus(LmisConst.OverTimeReq_Status_NotAccept);
						}
						LmisOvertimeRequestsUtil.update(objApp, false);
						System.out
								.println("Success change status LmisOvertimeRequests ");
						return true;
					}
				} catch (SystemException e) {
					System.out
							.println("Error in LmisViewRegistrationOvertimeLocalServiceImpl.doApproveIt, change status of Appovals has id="
									+ requestId
									+ " succuess but change status of Request ");
					e.printStackTrace();
					return false;
				}
			} else {
				System.out
						.println("Error in LmisViewRegistrationOvertimeLocalServiceImpl.doApproveIt, not match param");
				return false;
			}
		} catch (SystemException e) {
			System.out
					.println("Error in LmisViewRegistrationOvertimeLocalServiceImpl.doApproveIt"
							+ e.toString());
		}
		return false;
	}

	@Override
	public ArrayList<Integer> getListOverTimeReqDetails(int rootId, int userId)
			throws com.liferay.portal.SystemException {

		ArrayList<Integer> arrPmId = new ArrayList<Integer>();
		try {
			List<larion.progate.lmis.model.LmisOvertimeRequestDetails> lsRoot = LmisOvertimeRequestDetailsUtil
					.findByOvertimeRequestDetailsOf(rootId);
			List<larion.progate.lmis.model.LmisOvertimeRequestDetails> lsUser = LmisOvertimeRequestDetailsUtil
					.findByUserID(userId);
			List<larion.progate.lmis.model.LmisOvertimeRequestDetails> lsResult = ListUtils
					.intersection(lsRoot, lsUser);
			if (lsResult.size() != 0 && lsResult != null) {
				Iterator<larion.progate.lmis.model.LmisOvertimeRequestDetails> it = lsResult
						.iterator();
				while (it.hasNext()) {
					larion.progate.lmis.model.LmisOvertimeRequestDetails i = it
							.next();
					if(i.getRequestId() !=0){
					arrPmId.add(i.getRequestId());
					}
				}
				return arrPmId;
			}
		} catch (SystemException e) {
			System.out
					.println("Error in LmisOvertimeRequestsl.getListOverTimeReqDetails");
			e.printStackTrace();
		}
		return null;
	}
	
	

	@Override
	public List<LmisViewRegistrationOvertime> getListOverTimeReqRoleManager(int rootId, int requestBy)			throws com.liferay.portal.SystemException {
		try {
			ArrayList<Integer> arrPmID = LmisViewRegistrationOvertimeLocalServiceUtil
					.getListOverTimeReqDetails(rootId, requestBy);
//			System.out.println("Content arrPmID:" +arrPmID);
			List<larion.progate.lmis.model.LmisViewRegistrationOvertime> lsRoot = LmisViewRegistrationOvertimeUtil.findByRootID(rootId);
			List<larion.progate.lmis.model.LmisViewRegistrationOvertime> lsUser = LmisViewRegistrationOvertimeUtil.findByRequestedBy(requestBy);
			List<larion.progate.lmis.model.LmisViewRegistrationOvertime> lsResult = ListUtils.intersection(lsRoot, lsUser);

			List<LmisViewRegistrationOvertime> ls = new ArrayList<LmisViewRegistrationOvertime>();
			List<LmisViewRegistrationOvertime> temp = new ArrayList<LmisViewRegistrationOvertime>();
			if (arrPmID!=null) {
				for (int i : arrPmID) {
					ls = LmisViewRegistrationOvertimeUtil.findByRequestID(i);						
					temp = ListUtils.union(temp, ls);
				}
			}
			//loai bo nhung phan tu trung
			Set<Integer> sh = new HashSet<Integer>();
			List<larion.progate.lmis.model.LmisViewRegistrationOvertime> tmp = new ArrayList<LmisViewRegistrationOvertime>();
			for(int i=0;i<temp.size();i++){
				if(sh.add(temp.get(i).getOtReqsId())){
					tmp.add(temp.get(i));
				}
			}			
//			System.out.println("Count tmp " + tmp.size());
//			System.out.println("tmp : "+ tmp.toString());
			List<larion.progate.lmis.model.LmisViewRegistrationOvertime> result = ListUtils.union(lsResult, tmp);
//			System.out.println("Count lsResult " + lsResult.size());
//			System.out.println("lsresult "+  lsResult.toString());
//			System.out.println("hoi ne  : "+result.size() + "       "+ result .toString());
			
			//Loai bo phan tu trung
			Set<Integer> s = new HashSet<Integer>();
			List<larion.progate.lmis.model.LmisViewRegistrationOvertime> lsFinal = new ArrayList<LmisViewRegistrationOvertime>();
			for(int i=0;i<result.size();i++){
				if(s.add(result.get(i).getOtReqsId())){
					lsFinal.add(result.get(i));
				}
			}		
//			System.out.println("final ne: " + lsFinal.size());
			
			System.out.println("Success:LmisViewRegistrationOvertime.getListOverTimeReqRoleManager "+ lsFinal);
			List<larion.progate.lmis.model.LmisViewRegistrationOvertime> lsR = new ArrayList<LmisViewRegistrationOvertime>();
			if(lsFinal.size() >0){
				for(int i=0;i <=6; i++){
					for (LmisViewRegistrationOvertime m : lsFinal) {
						if(m.getRequestedStatus()==i){
							lsR.add(m);
						}
					}
				}
			}
			return lsR;
		} catch (SystemException e) {
			System.out
					.println("Error in LmisViewRegistrationOvertime.getListOverTimeReqRoleManager  requestBy has id ="							+ requestBy);
			e.printStackTrace();
		}
		return null;
	}
	public boolean deleteOverTimeReq(int rootId, int reqId){
		try {
			LmisOvertimeRequests req = LmisOvertimeRequestsUtil.fetchByPrimaryKey(reqId);
			if(req.getRootId()==rootId){
				req.setRequestedStatus(LmisConst.OverTimeReq_Status_Ban);
				LmisOvertimeRequestsUtil.update(req, false);
				List<LmisOvertimeApprovals> lsA = LmisOvertimeApprovalsUtil.findByRequestID(reqId);
				Date now = new Date();
				for (LmisOvertimeApprovals i : lsA) {
					i.setApprovedAt(now);
					i.setApprovedStatus(true);
					LmisOvertimeApprovalsUtil.update(i, false);
				}
				return true;
			}
			return true;
		} catch (SystemException e) {
			System.out.println("Error in delete overtime request have id=:"+reqId);
			return false;
		}
		
		
	}
	// Delay
	/*
	 * public int deleteOverTimeReq(int rootId, int userId,int reqBy, int reqId)
	 * throws SystemException { try { LmisOvertimeRequests objDel =
	 * LmisOvertimeRequestsUtil .fetchByPrimaryKey(reqId); if
	 * (objDel.getRootId() != rootId || objDel.getRequestedBy() != reqBy) {
	 * System.out .println(
	 * "Error in LmisViewRegistrationOvertimeLocalServiceImpl.deleteOverTimeReq, reason not match rootId or userId"
	 * ); return LmisConst.OverTimeReq_Delete_NotMatch; } if
	 * (objDel.getRequestedStatus() == LmisConst.OverTimeReq_Status_Accepted) {
	 * System.out .println(
	 * "LmisViewRegistrationOvertimeLocalServiceImpl.deleteChangeTimeReq, can't delete a request approved, cause at:parameter"
	 * ); return LmisConst.OverTimeReq_Status_Accepted; } else {
	 * 
	 * List<LmisOvertimeApprovals> lsApp =
	 * LmisOvertimeApprovalsUtil.findByRequestID(reqId);
	 * Iterator<LmisOvertimeApprovals> itApp = lsApp.iterator(); while
	 * (itApp.hasNext()) { LmisOvertimeApprovals i = itApp.next();
	 * System.out.println("Delete OverTimeApp has ID:" + i.getPrimaryKey());
	 * LmisOvertimeApprovalsLocalServiceUtil .deleteLmisOvertimeApprovals(i); }
	 * LmisOvertimeRequestsLocalServiceUtil .deleteLmisOvertimeRequests(objDel);
	 * 
	 * List<LmisOvertimeRequestDetails> lsReq =
	 * LmisOvertimeRequestDetailsUtil.findByRequestedID(reqId) ;
	 * List<LmisOvertimeRequestDetails> lsUser =
	 * LmisOvertimeRequestDetailsUtil.findByUserID(userId) ;
	 * List<LmisOvertimeRequestDetails> lsDetail = ListUtils.intersection(lsReq,
	 * lsUser); Iterator<LmisOvertimeRequestDetails> itDetail =
	 * lsDetail.iterator(); while (itDetail.hasNext()) {
	 * LmisOvertimeRequestDetails j = itDetail.next();
	 * System.out.println("Delete OverTimeRequestDetail has ID:" +
	 * j.getPrimaryKey()); LmisOvertimeRequestDetailsLocalServiceUtil
	 * .deleteLmisOvertimeRequestDetails(j); }
	 * LmisOvertimeRequestsLocalServiceUtil .deleteLmisOvertimeRequests(objDel);
	 * 
	 * 
	 * return LmisConst.OverTimeReq_Delete_Success; } } catch (Exception e) {
	 * System.out .println(
	 * "LmisViewRegistrationOvertimeLocalServiceImpl.deleteOverTimeReq, fata error"
	 * ); e.printStackTrace(); } return LmisConst.OverTimeReq_Delete_Fata; }
	 */

}