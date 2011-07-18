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

import java.util.List;



import org.apache.commons.collections.ListUtils;


import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

import larion.progate.lmis.model.LmisAbsenceApprovals;
import larion.progate.lmis.model.LmisAbsenceRequests;
import larion.progate.lmis.model.LmisAbsenceSettings;
import larion.progate.lmis.model.LmisAttendanceDaily;
import larion.progate.lmis.model.LmisGeneralSettings;
import larion.progate.lmis.service.LmisAbsenceApprovalsLocalServiceUtil;
import larion.progate.lmis.service.LmisAbsenceRequestsLocalServiceUtil;
import larion.progate.lmis.service.LmisAbsenceSettingsLocalServiceUtil;
import larion.progate.lmis.service.LmisGeneralSettingsLocalServiceUtil;
import larion.progate.service.ViewOrgUsersPermissionsLocalServiceUtil;
import larion.progate.lmis.service.base.LmisAbsenceRequestsLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisAbsenceApprovalsUtil;
import larion.progate.lmis.service.persistence.LmisAbsenceRequestsFinderUtil;
import larion.progate.lmis.service.persistence.LmisAbsenceRequestsUtil;
import larion.progate.lmis.service.persistence.LmisAbsenceSettingsUtil;
import larion.progate.lmis.service.persistence.LmisAttendanceDailyFinderUtil;
import larion.progate.lmis.service.persistence.LmisAttendanceDailyUtil;
import larion.progate.lmis.service.persistence.LmisGeneralSettingsFinderUtil;
import larion.progate.lmis.service.persistence.LmisViewWorkingCalendarUtil;
import larion.progate.lmis.service.utils.LmisConst;
import larion.progate.lmis.service.utils.LmisUtils;

/**
 * <a href="LmisAbsenceRequestsLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class LmisAbsenceRequestsLocalServiceImpl extends
		LmisAbsenceRequestsLocalServiceBaseImpl {
	/**
	 * @param absenceId
	 * @return
	 * @throws SystemException
	 *             get Name of absenceId, use in JSP
	 */
	public String funcNameAbsence(int absenceId) throws SystemException {
		LmisAbsenceSettings l = LmisAbsenceSettingsUtil
				.fetchByPrimaryKey(absenceId);
		return l.getName_();
	}

	public List<LmisAbsenceRequests> getListAbsenceReqUser(int rootId,
			int userId) {
		List<LmisAbsenceRequests> ls = null;
		try {
			List<LmisAbsenceRequests> lsRoot = LmisAbsenceRequestsUtil
					.findByRootID(rootId);
			List<LmisAbsenceRequests> lsUser = LmisAbsenceRequestsUtil
					.findByRequestedBy(userId);
			ls = ListUtils.intersection(lsRoot, lsUser);
			return ls;
		} catch (SystemException e) {
			System.out
					.println("Error in LmisAbsenceRequestsLocalServiceImpl.getListAbsenceReqRoleStaff "
							+ e.toString());
			return ls;
		}
	}

	public List<LmisAbsenceRequests> getListAbsenceReqRolePmOrBod(int rootId,
			int userId) {
		List<LmisAbsenceRequests> ls = new ArrayList<LmisAbsenceRequests>();
		try {
			ArrayList<Integer> arrReq = new ArrayList<Integer>();
			List<LmisAbsenceApprovals> lsRoot = LmisAbsenceApprovalsUtil
					.findByRootID(rootId);
			List<LmisAbsenceApprovals> lsApp = LmisAbsenceApprovalsUtil
					.findByApprovedBy(userId);
			List<LmisAbsenceApprovals> lsInter = ListUtils.intersection(lsRoot,
					lsApp);
			for (LmisAbsenceApprovals i : lsInter) {
				arrReq.add(i.getRequestId());
			}
			for (int i : arrReq) {
				LmisAbsenceRequests item = LmisAbsenceRequestsUtil
						.fetchByPrimaryKey(i);
				ls.add(item);
			}
			return ls;

		} catch (SystemException e) {
			System.out
					.println("Error in LmisAbsenceRequestsLocalServiceImpl.getListAbsenceReqRolePM "
							+ e.toString());
			return ls;
		}
	}

	public int countRequestPending(int rootId, int userId)
			throws PortalException, SystemException {
		List<LmisAbsenceApprovals> ls = LmisAbsenceApprovalsUtil
				.findByApprovedBy(userId);
		int count = 0;
		if (ls.size() > 0) {
			for (LmisAbsenceApprovals i : ls) {
				if (i.getRootId() == rootId && i.getApprovedStatus() == false) {
					LmisAbsenceRequests a  = LmisAbsenceRequestsUtil.fetchByPrimaryKey(i.getRequestId());
					if(a.getRequestedStatus()==LmisConst.Absence_Stt_Pending){
						count++;
					}
						
				}
			}
		}
		return count;
	}

	public List<LmisAbsenceRequests> getListAbsenceReqRoleSpec(int rootId) {
		List<LmisAbsenceRequests> ls = new ArrayList<LmisAbsenceRequests>();
		try {
			return LmisAbsenceRequestsUtil.findByRootID(rootId);
		} catch (SystemException e) {
			System.out
					.println("Error in LmisAbsenceRequestsLocalServiceImpl.getListAbsenceReqRoleSpec "
							+ e.toString());
			return ls;
		}

	}

	public int addAbsenceReq(int rootId, int userId, Date startDate,
			Date endDate, int startSession, int endSession,
			String requestReason, String absenceType, int absenceId)
			throws SystemException {
		try {
			System.out.println("Dzo addAbsenceReq");
			LmisAbsenceRequests req = LmisAbsenceRequestsUtil.create(null);
			try {
				System.out.println("dzo try lan 1");
				req.setRootId(rootId);
				req.setRequestedBy(userId);
				req.setStartDate(startDate);
				req.setEndDate(endDate);
				req.setStartSession(startSession);
				req.setEndSession(endSession);
				req.setRequestedReason(requestReason);
				req.setAbsenceType(absenceType);
				req.setAbsenceTypeId(absenceId);
				req.setRequestedStatus(LmisConst.Absence_Stt_Pending);
				req.setCreatedAt(new Date());
				LmisAbsenceRequestsUtil.updateImpl(req, false);
			} catch (Exception e) {
				System.out.println("Error in addAbsenceReq: " +e.toString());
				e.printStackTrace();
				return LmisConst.Error;
			}
			
			int reqId = req.getPrimaryKey();
			System.out.println("Success: addAbsenceReq has id:" + reqId
					+ ", step 1");
			List<Integer> arrPmId = new ArrayList<Integer>();
			
			String typeUser = LmisUtils.getUserRoleByUID(userId, 100);
			
			if(typeUser.equals(LmisConst.IS_STAFF)){
				if(  (LmisGeneralSettingsFinderUtil.caculateDayWillOff(rootId, startDate, endDate, startSession, endSession) <3) && ( checkAbsenceTypeSpec(rootId, absenceId)==1) ) {
					//Send to PM, 
					arrPmId = LmisUtils.getListPmIdOrBodIdByUserId(rootId, userId);
				}
				else{
					//Send to BOD
					System.out.println("Send absence to BOD");
					arrPmId = LmisGeneralSettingsLocalServiceUtil.getListBodUIDbyRootId(rootId);
				}
			}
			else{
				System.out.println("Send absence to BOD");
				arrPmId = LmisGeneralSettingsLocalServiceUtil.getListBodUIDbyRootId(rootId);
			}
			
			
			for (int i : arrPmId) {
				LmisAbsenceApprovals item = LmisAbsenceApprovalsUtil
						.create(null);
				item.setRootId(rootId);
				item.setRequestId(reqId);
				item.setApprovedBy(i);
				LmisAbsenceApprovalsUtil.updateImpl(item, false);
			}
			System.out.println("Success: addAbsenceRe Approve, step 2");
			return LmisConst.Success;
			
		} catch (Exception e) {
			System.out
					.println("Error in LmisAbsenceRequestsLocalServiceImpl.addAbsenceReq:"
							+ e.toString());
			e.printStackTrace();
			return LmisConst.Error;
		}
	}

	public int editAbsenceReq(int reqId, Date startDate, Date endDate,
			int startSession, int endSession, String requestReason,
			String absenceType, int absenceId) throws SystemException {
		try {
			// Xoa ben Approval
			List<LmisAbsenceApprovals> lsA = LmisAbsenceApprovalsUtil.findByRequestID(reqId);
			if(lsA.size() >0){
				for (LmisAbsenceApprovals i : lsA) {
					LmisAbsenceApprovalsUtil.remove(i);
				}
			}
			
			LmisAbsenceRequests obj = LmisAbsenceRequestsUtil
					.fetchByPrimaryKey(reqId);
			obj.setStartDate(startDate);
			obj.setEndDate(endDate);
			obj.setAbsenceType(absenceType);
			obj.setAbsenceTypeId(absenceId);
			obj.setRequestedReason(requestReason);
			obj.setStartSession(startSession);
			obj.setEndSession(endSession);
			LmisAbsenceRequestsLocalServiceUtil.updateLmisAbsenceRequests(obj,
					false);
			List<Integer> arrPmId = new ArrayList<Integer>();
			String typeUser = LmisUtils.getUserRoleByUID(obj.getRequestedBy(), 100);
			
			if(typeUser.equals(LmisConst.IS_STAFF)){
				if(  (LmisGeneralSettingsFinderUtil.caculateDayWillOff(obj.getRootId(), startDate, endDate, startSession, endSession) <3) && ( checkAbsenceTypeSpec(obj.getRootId(), absenceId)==1) ) {
					//Send to PM, 
					arrPmId = LmisUtils.getListPmIdOrBodIdByUserId(obj.getRootId(), obj.getRequestedBy());
				}
				else{
					//Send to BOD
					arrPmId = LmisGeneralSettingsLocalServiceUtil.getListBodUIDbyRootId(obj.getRootId());
				}
			}
			else{
				
				arrPmId = LmisGeneralSettingsLocalServiceUtil.getListBodUIDbyRootId(obj.getRootId());
			}
			
			return LmisConst.Success;
		} catch (Exception e) {
			System.out
					.println("Error in LmisAbsenceRequestsLocalServiceImpl.addAbsenceReq:"
							+ e.toString());
			return LmisConst.Error;
		}
	}

	public boolean deleteAbsenceReq(int rootId, int userId, int absenceId)
			throws PortalException, SystemException {
		LmisAbsenceRequests r = LmisAbsenceRequestsUtil
				.fetchByPrimaryKey(absenceId);
		if (r.getRequestedBy() == userId && r.getRootId() == rootId) {
			if (r.getRequestedStatus() == LmisConst.Absence_Stt_Pending) {
				// Xoa' hang~
				/*List<LmisAbsenceApprovals> lsA = LmisAbsenceApprovalsUtil
						.findByRequestID(absenceId);
				for (LmisAbsenceApprovals i : lsA) {
					LmisAbsenceApprovalsUtil.remove(i.getPrimaryKey());
				}

				LmisAbsenceRequestsLocalServiceUtil
						.deleteLmisAbsenceRequests(absenceId);
				return true;*/
				//Doi~ trang thai
				LmisAbsenceRequests i = LmisAbsenceRequestsUtil.fetchByPrimaryKey(absenceId);
				i.setRequestedStatus(LmisConst.Absence_Stt_Disabled); // Vo Hieu hoa
				LmisAbsenceRequestsLocalServiceUtil.updateLmisAbsenceRequests(i, false);
				return true;
			} else {
				System.out.println("Can't delete a request has status is pending");
				return false;
			}
		} else {
			System.out
					.println("Error in LmisAbsenceRequestsLocalServiceImpl.deleteAbsenceReq, not match userid,rootId,absenceId");
			return false;
		}
	}

	public boolean doApprove(int userId, int reqId, boolean isApprove,
			String reasonApprove) throws PortalException, SystemException {
		List<LmisAbsenceApprovals> ls = LmisAbsenceApprovalsUtil
				.findByRequestID(reqId);
		Date now = new Date();
		if (ls.size() > 0) {
			for (LmisAbsenceApprovals i : ls) {
				i.setApprovedAt(now);
				i.setIsApproved(isApprove);
				i.setApprovedStatus(true);
				i.setReasonApproval(reasonApprove);
				LmisAbsenceApprovalsUtil.updateImpl(i, false);
			}
			LmisAbsenceRequests req = LmisAbsenceRequestsUtil
					.fetchByPrimaryKey(reqId);
			if (isApprove) {
				req.setRequestedStatus(LmisConst.Absence_Stt_OK);
			} else {
				req.setRequestedStatus(LmisConst.Absence_Stt_NoOK);
			}
			req.setUpdatedAt(now);
			LmisAbsenceRequestsUtil.updateImpl(req, false);
			return true;
		} else {
			System.out
					.println("Error in LmisAbsenceRequestsLocalServiceImpl.doApprove, no exist absence requestId= "
							+ reqId);
			return false;
		}

	}

	/**
	 * @param rootId
	 * @param userId
	 * @param absenceId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 *             get detail of a absence_request
	 */
	public LmisAbsenceRequests getDetailAbsenceReq(int rootId, int userId,
			int absenceId) throws PortalException, SystemException {
		LmisAbsenceRequests r = LmisAbsenceRequestsUtil
				.fetchByPrimaryKey(absenceId);
		if (r.getRequestedBy() == userId && r.getRootId() == rootId) {
			return r;
		} else {
			return LmisAbsenceRequestsLocalServiceUtil
					.createLmisAbsenceRequests(null);
		}
	}

	/**
	 * @param rootId
	 * @return get List absence type (permissive) of org,
	 */
	public List<LmisAbsenceSettings> getListAbsenceTypeOfRoot(int rootId)
			throws PortalException, SystemException {
		List<LmisAbsenceSettings> lsRoot = LmisAbsenceSettingsUtil
				.findByRootID(rootId);
		List<LmisAbsenceSettings> ls = new ArrayList<LmisAbsenceSettings>();
		if (lsRoot.size() > 0) {
			for (LmisAbsenceSettings i : lsRoot) {
				if (i.getAbsencePermissive() == true) {
					ls.add(i);
				}
			}
		}
		return ls;
	}

	public String getContentApprove(int absenceId) throws SystemException {
		List<LmisAbsenceApprovals> ls = LmisAbsenceApprovalsUtil
				.findByRequestID(absenceId);
		if (ls.size() > 0) {
			return ls.get(0).getReasonApproval();
		} else {
			System.out
					.println("Error in LmisAbsenceRequestsLocalServiceImpl.getContentApprove, not exist absenceId");
			return null;
		}
	
	}
	/**
	 * @param rootId,userId
	 * @return List<LmisAbsenceRequests>
	 * Ham nay dun`g cho tab phe duyet boi cua man hinh Thong Tin Nghi Phep, da duoc order
	 */
	public List<LmisAbsenceRequests> getListRequestApprovedBy(int rootId, int userId){
		try{
			List<LmisAbsenceRequests> lsA = LmisAbsenceRequestsFinderUtil.getListAbsRequestApprovedBy(rootId, userId);
			return lsA;
				
		}catch(Exception e){
			System.out.println("Error in LmisAbsenceRequestsLocalServiceImpl.getListRequestApprovedBy");
			return new ArrayList<LmisAbsenceRequests>();
		}
	}
	public List<LmisAttendanceDaily> getStatisticForms(int rootId, Date dayValue){
		try {
			return LmisAttendanceDailyFinderUtil.getListStaffDayOff(rootId, dayValue);	
		} catch (Exception e) {
			return new ArrayList<LmisAttendanceDaily>();
		}
		
	}
	public int checkAbsenceTypeSpec(int rootId, int absenceId)  {
		try {
			return LmisAbsenceRequestsFinderUtil.checkAbsenceTypeSpec(rootId, absenceId);
		} catch (Exception e) {
			return 3;
		}
	}
	public List<LmisAbsenceSettings> getListAbsenceOfRootId(int rootId){
		try {
			return LmisAbsenceSettingsUtil.findByRootID(rootId);
		} catch (SystemException e) {
			System.out.println("Error in LmisAbsenceRequestsLocalServiceImpl.getListAbsenceOfRootId");
			return new ArrayList<LmisAbsenceSettings>();
		}
	}
	public List<LmisAbsenceRequests> filterTabManager(int rootId, int userId, int absType, int status){
		try {
			return LmisAbsenceRequestsFinderUtil.filterTabManager(rootId, userId, absType, status);
		} catch (Exception e) {
			System.out.println("Error in LmisAbsenceRequestsLocalServiceImpl.filterTabManager");
			return new ArrayList<LmisAbsenceRequests>();
		}
	}
	//Session 1 = All day
	// 2= Mor
	// 3=Aft
	public boolean addUnexpectedAbsenceReq(int rootId, int attendanceId,int session,String requestReason ){
		try {
			int absId = LmisAbsenceRequestsFinderUtil.getAbsenceIdOfUnexpected(rootId);
			String absName = LmisAbsenceRequestsFinderUtil.getAbsenceNameOfUnexpected(rootId);
			LmisAttendanceDaily att = LmisAttendanceDailyUtil.fetchByPrimaryKey(attendanceId);
			if(LmisAbsenceRequestsLocalServiceUtil.addAbsenceReq(rootId, att.getUserId(), att.getDayValue(), att.getDayValue(), session, session, requestReason, absName, absId)==LmisConst.Error){
				return true;
			}else{
				return false;
			}
			
		} catch (Exception e) {
			System.out.println("Error in LmisAbsenceRequestsLocalServiceImpl.addUnexpectedAbsenceReq: "+e.toString());
			return false;
		}
		
	}
}