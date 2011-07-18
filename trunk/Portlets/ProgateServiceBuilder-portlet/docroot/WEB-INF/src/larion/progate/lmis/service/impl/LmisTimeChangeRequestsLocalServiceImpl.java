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
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.ListUtils;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

import larion.progate.lmis.model.LmisTimeChangeApprovals;
import larion.progate.lmis.model.LmisTimeChangeRequests;
import larion.progate.lmis.model.LmisViewTimeChangeReqs;

import larion.progate.lmis.service.LmisTimeChangeApprovalsLocalServiceUtil;
import larion.progate.lmis.service.LmisTimeChangeRequestsLocalServiceUtil;
import larion.progate.lmis.service.LmisViewTimeChangeReqsLocalServiceUtil;
import larion.progate.lmis.service.base.LmisTimeChangeRequestsLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisAbsenceRequestsFinderUtil;
import larion.progate.lmis.service.persistence.LmisGeneralSettingsFinderUtil;
import larion.progate.lmis.service.persistence.LmisTimeChangeApprovalsUtil;
import larion.progate.lmis.service.persistence.LmisTimeChangeRequestsUtil;
import larion.progate.lmis.service.persistence.LmisViewTimeChangeReqsUtil;
import larion.progate.lmis.service.utils.LmisConst;
import larion.progate.lmis.service.utils.LmisUtils;

/**
 * <a href="LmisTimeChangeRequestsLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class LmisTimeChangeRequestsLocalServiceImpl extends
		LmisTimeChangeRequestsLocalServiceBaseImpl {

	
	public java.util.List<larion.progate.lmis.model.LmisTimeChangeRequests> getListRequestTimeChangeOf(
			int rootId, int userId) throws com.liferay.portal.SystemException {
		try {
			List<LmisTimeChangeRequests> lsRoot = LmisTimeChangeRequestsUtil
					.findByRootId(rootId);
			List<LmisTimeChangeRequests> lsUser = LmisTimeChangeRequestsUtil
					.findByUserId(userId);
			List<LmisTimeChangeRequests> list = ListUtils.intersection(lsRoot,
					lsUser);
			System.out.println("Call getListRequestTimeChangeOf(" + rootId
					+ "," + userId + ")");
			return list;
		} catch (Exception e) {
			System.out
					.println("Error LmisTimeChangeRequestsLocalServiceImpl.getListRequestTimeChangeOf"
							+ e.toString());
		}
		return null;
	}

	
	public LmisTimeChangeRequests getDetailRequestTimeChange(int rootId,
			int requestId) throws SystemException {
		try {
			LmisTimeChangeRequests result = LmisTimeChangeRequestsUtil
					.fetchByPrimaryKey(requestId);
			if (result.getRootId() == rootId) {
				System.out
						.println("Success: LmisTimeChangeRequestsLocalServiceImpl.getDetailRequestTimeChange with"
								+ result.getRootId());
				return result;
			} else {
				System.out
						.println("Call getRequestTimeChange but not match rootId");
				return null;
			}
		} catch (Exception e) {
			System.out
					.println("Error in LmisTimeChangeRequestsLocalServiceImpl.getRequestTimeChange"
							+ e.toString());
		}
		return null;
	}
	
	public String getContentApprovals(int rootId, int requestId) throws PortalException, SystemException{
		try{
			LmisTimeChangeRequests content = LmisTimeChangeRequestsLocalServiceUtil.getLmisTimeChangeRequests(requestId);
			if(rootId == content.getRootId())
			{
				List<LmisTimeChangeApprovals> ls = LmisTimeChangeApprovalsLocalServiceUtil.getListApprovalByReqId(rootId, requestId);
				return ls.get(0).getReason();
			}
			else{
				System.out.println("Error in LmisTimeChangeRequestsLocalServiceImpl.getContentApprovals, not match rootId");
				return null;
			}
		}
		catch(SystemException e){
			System.out.println("Error in LmisTimeChangeRequestsLocalServiceImpl.getContentApprovals " + e.toString());
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public boolean editRequestTimeChange(int rootId, int requestId,
			Date startDate, Date endDate, Date monStartTime, Date monEndTime,
			Date tueStartDate, Date tueEndTime, Date wedStartTime,
			Date wedEndTime, Date thuStartTime, Date thuEndTime,
			Date friStartTime, Date friEndTime, Date satStartTime,
			Date satEndTime, String requestReason) throws SystemException {
		try {
			LmisTimeChangeRequests objEdit = LmisTimeChangeRequestsUtil
					.fetchByPrimaryKey(requestId);
			if (objEdit.getRootId() == rootId) {

				objEdit.setStartDate(startDate);
				objEdit.setEndDate(endDate);
				objEdit.setMonStartTime(monStartTime);
				objEdit.setMonEndTime(monEndTime);
				objEdit.setTueStartTime(tueStartDate);
				objEdit.setTueEndTime(tueEndTime);
				objEdit.setWedStartTime(wedStartTime);
				objEdit.setWedEndTime(wedEndTime);
				objEdit.setThuStartTime(thuStartTime);
				objEdit.setThuEndTime(thuEndTime);
				objEdit.setFriStartTime(friStartTime);
				objEdit.setFriEndTime(friEndTime);
				objEdit.setSatStartTime(satStartTime);
				objEdit.setSatEndTime(satEndTime);
				objEdit.setRequestedReason(requestReason);
				Date now = new Date();
				objEdit.setUpdatedAt(now);
				LmisTimeChangeRequestsUtil.update(objEdit, false);
				System.out
						.println("Success: in LmisTimeChangeRequestsLocalServiceImpl.editRequestTimeChange");
				return true;
			} else {
				System.out
						.println("Error in LmisTimeChangeRequestsLocalServiceImpl.editRequestTimeChange");
				return false;
			}
		} catch (Exception e) {
			System.out
					.println("Error in LmisTimeChangeRequestsLocalServiceImpl.editRequestTimeChange "
							+ e.toString());
		}
		return false;
	}

	@Override
	public boolean addRequestTimeChange(int rootId, int userId, Date startDate,
			Date endDate, Date monStartTime, Date monEndTime,
			Date tueStartTime, Date tueEndTime, Date wedStartTime,
			Date wedEndTime, Date thuStartTime, Date thuEndTime,
			Date friStartTime, Date friEndTime, Date satStartTime,
			Date satEndTime, String requestReason) throws SystemException {
		try {
			larion.progate.lmis.model.LmisTimeChangeRequests objAdd = LmisTimeChangeRequestsUtil
					.create(null);
			Date now = new Date();

			objAdd.setRootId(rootId);
			objAdd.setRequestedBy(userId);
			objAdd.setStartDate(startDate);
			objAdd.setEndDate(endDate);
			objAdd.setMonSelected(true);
			objAdd.setMonStartTime(monStartTime);
			objAdd.setMonEndTime(monEndTime);
			objAdd.setTueSelected(true);
			objAdd.setTueStartTime(tueStartTime);
			objAdd.setTueEndTime(tueEndTime);
			objAdd.setWedSelected(true);
			objAdd.setWedStartTime(wedStartTime);
			objAdd.setWedEndTime(wedEndTime);
			objAdd.setThuSelected(true);
			objAdd.setThuStartTime(thuStartTime);
			objAdd.setThuEndTime(thuEndTime);
			objAdd.setFriSelected(true);
			objAdd.setFriStartTime(friStartTime);
			objAdd.setFriEndTime(friEndTime);
			objAdd.setSatSelected(true);
			objAdd.setSatStartTime(satStartTime);
			objAdd.setSatEndTime(satEndTime);
			objAdd.setRequestedReason(requestReason);
			objAdd.setRequestedStatus(1);
			objAdd.setCreatedAt(now);
			objAdd.setUpdatedAt(now);

			LmisTimeChangeRequestsUtil.update(objAdd, false);
			int objPkJustAdd = objAdd.getPrimaryKey();
			System.out
					.println("Success: LmisTimeChangeRequestsLocalServiceImpl.addRequestTimeChange, step 2 add Approval");
			List<Integer> arrPmID = LmisUtils.getListPmIdOrBodIdByUserId(rootId,
					userId);
			System.out.println("Content " + arrPmID.toString());
			try {
				for (int i : arrPmID) {
					LmisTimeChangeApprovals iApp = LmisTimeChangeApprovalsUtil
							.create(null);
					iApp.setRootId(rootId);
					iApp.setRequestId(objPkJustAdd);
					iApp.setApprovedBy(i);
					iApp.setApprovedStatus(false);
					
					LmisTimeChangeApprovalsLocalServiceUtil
							.updateLmisTimeChangeApprovals(iApp, false);
				}
				System.out
						.println("Success: LmisTimeChangeRequestsLocalServiceImpl.addRequestTimeChange, just added Approvals has RequestID="
								+ objPkJustAdd);
				return true;
			} catch (SystemException e) {

			}
		} catch (Exception e) {
			System.out
					.println("Error in LmisTimeChangeRequestsLocalServiceImpl.addRequestTimeChange"
							+ e.toString());
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * larion.progate.lmis.service.LmisTimeChangeRequestsLocalService#doApproveIt
	 * (int, int, int, boolean, java.lang.String) Step 1:
	 * LmisTimeChangeApprovalsLocalServiceUtil.findIdReq this method will return
	 * RequestID if parameter correct; Step 2: Change status
	 */
	@Override
	public boolean doApproveIt(int rootId, int approvedBy, int requestId,boolean isApproved, String reason) throws SystemException {
		try {
			int idReq = LmisTimeChangeApprovalsLocalServiceUtil.findIdReq(
					rootId, approvedBy, requestId);
			if (idReq >= 0) {
				boolean flag = LmisTimeChangeApprovalsLocalServiceUtil
						.doApprove(rootId, approvedBy, requestId, isApproved,
								reason);
				if (flag == true) {
					try {
						Date now = new Date();
						LmisTimeChangeRequests objApp = LmisTimeChangeRequestsUtil
								.fetchByPrimaryKey(requestId);
						objApp.setUpdatedAt(now);
						if (isApproved == true) {
							objApp.setRequestedStatus(LmisConst.TimeChgReq_Status_Accepted);
						} else {
							objApp.setRequestedStatus(LmisConst.TimeChgReq_Status_NotAccept);
						}
						LmisTimeChangeRequestsUtil.update(objApp, flag);
						System.out
								.println("Success: LmisTimeChangeRequestsLocalServiceImpl.doApproveIt");
						return true;
					} catch (SystemException e) {
						System.out
								.println("Error in LmisTimeChangeRequestsLocalServiceImpl.doApproveIt, change status of Appovals has id="
										+ requestId
										+ " scuess but change status of Request " + e.toString());
						e.printStackTrace();
						return false;
					}
				} else {
					System.out
							.println("Error in LmisTimeChangeRequestsLocalServiceImpl.doApproveIt.doApprove");
					return false;
				}
			} else {
				System.out
						.println("Call LmisTimeChangeApprovalsLocalServiceImpl.findIdReq, but not match rootId, requestId, approvedId");
				return false;
			}
		} catch (SystemException e) {
			System.out
					.println("Error in LmisTimeChangeRequestsLocalServiceImpl.editApprovalTimeChange"
							+ e.toString());
		}
		return false;
	}

	@Override
	public int deleteChangeTimeReq(int rootId, int userId, int reqId)
			throws SystemException {
		try {
			LmisTimeChangeRequests objDel = LmisTimeChangeRequestsUtil
					.fetchByPrimaryKey(reqId);
			if (objDel.getRootId() != rootId
					|| objDel.getRequestedBy() != userId) {
				System.out
						.println("Error in LmisTimeChangeRequestsLocalServiceImpl.deleteChangeTimeReq, reason not match rootId or userId");
				return LmisConst.TimeChgReq_Delete_NotMatch;
			}
			if (objDel.getRequestedStatus() == LmisConst.TimeChgReq_Status_Accepted) {
				System.out
						.println("Error in LmisTimeChangeRequestsLocalServiceImpl.deleteChangeTimeReq, can't delete a request approved, cause at:parameter");
				return LmisConst.TimeChgReq_Status_Accepted;
			} else {

				List<LmisTimeChangeApprovals> lsApp = LmisTimeChangeApprovalsUtil
						.findByRequestId(reqId);
				Iterator<LmisTimeChangeApprovals> itApp = lsApp.iterator();
				while (itApp.hasNext()) {
					LmisTimeChangeApprovals i = itApp.next();
					System.out.println("Delete TimeChangeApp has ID:"
							+ i.getPrimaryKey());
					LmisTimeChangeApprovalsLocalServiceUtil
							.deleteLmisTimeChangeApprovals(i);
				}
				LmisTimeChangeRequestsLocalServiceUtil
						.deleteLmisTimeChangeRequests(objDel);
				return LmisConst.TimeChgReq_Delete_Success;
			}
		} catch (Exception e) {
			System.out
					.println("Error in LmisTimeChangeRequestsLocalServiceImpl.deleteChangeTimeReq, fata error");
			e.printStackTrace();
		}
		return LmisConst.TimeChgReq_Delete_Fata;
	}
	public int countTimeChangeReqs(int rootId, int userId){
		try{
		List<LmisTimeChangeApprovals> lsA = LmisTimeChangeApprovalsUtil.findByApprovedBy(userId);
		List<LmisTimeChangeApprovals> lsR = LmisTimeChangeApprovalsUtil.findByRootId(rootId);
		List<LmisTimeChangeApprovals> lsRs = ListUtils.intersection(lsA, lsR);
		int c =0;
		if(lsRs.size()>0){
			for (LmisTimeChangeApprovals i : lsRs) {
				if(i.getApprovedStatus()==false && i.getRootId()==rootId){
					LmisTimeChangeRequests r = LmisTimeChangeRequestsUtil.fetchByPrimaryKey(i.getRequestId());
					if(r.getRequestedStatus()==LmisConst.TimeChgReq_Status_Pending){
						c++;
					}
					
				}
			}
		}
		return c;
		}catch(SystemException e){
			System.out.println("Error in LmisTimeChangeRequestsLocalServiceImpl.countTimeChangeReqs:"+e.toString());
			return 0;
			
		}
	}
	public String getMaxTimeChangeReqEndDate(int rootId, int userId) {
		try {
			return LmisGeneralSettingsFinderUtil.getMaxTimeChangeReqEndDate(rootId, userId);
		} catch (Exception e) {
			return null;
		}
		
	}

}