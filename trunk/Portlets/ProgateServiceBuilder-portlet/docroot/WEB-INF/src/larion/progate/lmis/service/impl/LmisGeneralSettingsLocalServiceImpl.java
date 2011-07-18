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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.sound.midi.SysexMessage;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.time.DateUtils;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactory;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;

import larion.progate.lmis.model.LmisGeneralSettings;
import larion.progate.lmis.model.LmisOverTimeTypes;
import larion.progate.lmis.model.LmisViewEmailSettingDetailOrg;
import larion.progate.lmis.model.LmisViewEmailSettingDetailUser;
import larion.progate.lmis.model.LmisViewOrgUserRoles;
import larion.progate.lmis.model.LmisViewStaffMapping;
import larion.progate.lmis.model.LmisViewStaffMappingPm;
import larion.progate.lmis.model.LmisViewStaffRootOrg;
import larion.progate.lmis.model.LmisWorkingTimes;
import larion.progate.model.Organization;
import larion.progate.model.ProgateOrganizationsStaffs;
import larion.progate.model.User;

import larion.progate.lmis.service.LmisGeneralSettingsLocalServiceUtil;
import larion.progate.lmis.service.LmisViewEmailSettingDetailOrgLocalServiceUtil;
import larion.progate.lmis.service.LmisViewEmailSettingDetailUserLocalServiceUtil;
import larion.progate.lmis.service.LmisWorkingTimesLocalServiceUtil;
import larion.progate.service.ProgateOrganizationParticipantsLocalServiceUtil;
import larion.progate.service.ProgateOrganizationsStaffsLocalServiceUtil;
import larion.progate.lmis.service.base.LmisGeneralSettingsLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisAbsenceYearlyFinderUtil;
import larion.progate.lmis.service.persistence.LmisGeneralSettingsUtil;
import larion.progate.lmis.service.persistence.LmisOverTimeTypesUtil;
import larion.progate.lmis.service.persistence.LmisViewOrgUserRolesUtil;
import larion.progate.lmis.service.persistence.LmisViewStaffMappingPmUtil;
import larion.progate.lmis.service.persistence.LmisViewStaffMappingUtil;
import larion.progate.service.persistence.OrganizationFinderUtil;
import larion.progate.service.persistence.OrganizationUtil;
import larion.progate.service.persistence.ProgateOrganizationsStaffsUtil;
import larion.progate.service.persistence.UserUtil;
import larion.progate.lmis.service.utils.LmisConst;
import larion.progate.lmis.service.persistence.LmisGeneralSettingsFinderUtil;





/**
 * @author tienld
 *
 */
public class LmisGeneralSettingsLocalServiceImpl
	extends LmisGeneralSettingsLocalServiceBaseImpl {
	
	public  Set<Integer> getArrayListPmUID(
			List<LmisViewStaffMapping> ls, int userId) {
		/*ArrayList<Integer> arr = new ArrayList<Integer>();
		Set<Integer> s = new HashSet<Integer>();

		for (LmisViewStaffMapping i : ls) {
			arr.add((i.getPmUID()));
		}
		for (int i : arr) {
			if (s.add(i)) {
			}
		}
		return s;*/
		try {
			int rootId=0;
			if(ls.size()>0){
				rootId = ls.get(0).getRootId();
			}else{
				return new HashSet<Integer>();
			}
			List<LmisViewStaffMappingPm> lsRoot = LmisViewStaffMappingPmUtil.findByRootID(rootId);
			List<LmisViewStaffMappingPm> lsStaff = LmisViewStaffMappingPmUtil.findByStaffUID(userId);
			List<LmisViewStaffMappingPm> lsR = ListUtils.intersection(lsRoot, lsStaff);
			if(lsR.size()>0){
				Set<Integer> s = new HashSet<Integer>();
				for (LmisViewStaffMappingPm i : lsR) {
					if(s.add(i.getPmUID())){
						
					}
				}
				return s;
			}else{
				return new HashSet<Integer>();
			}
			
		} catch (Exception e) {
			System.out.println("Error in LmisGeneralSettingsLocalServiceImpl.getArrayListPmUID");
			return new HashSet<Integer>();
		}
		
	}
	public List<Integer> getListBodUIDofUID(int rootId, int userId){
		
		return LmisGeneralSettingsFinderUtil.getListBodUIDofUID(rootId, userId) ;
	}
	public List<Integer> getListPmIdOrBodIdByUserId(int rootId,
			int userId) {
		Set<Integer> s = new HashSet<Integer>();
		try {
			java.util.List<LmisViewStaffMapping> lsRoot = LmisViewStaffMappingUtil.findByRootID(rootId);

			java.util.List<LmisViewStaffMapping> lsUser = LmisViewStaffMappingUtil.findByStaffUID(userId);
			java.util.List<LmisViewStaffMapping> lsResult = ListUtils.intersection(lsRoot, lsUser);

			String typeUser = getUserRoleByUID(userId, 0);
			System.out.println("Test Data with typeuser:" + typeUser);
			System.out.println(lsUser);
			System.out.println(lsResult);

			if (typeUser.equals(LmisConst.IS_PM)
					|| typeUser.equals(LmisConst.IS_BOD)) {
				return getListBodUIDofUID(rootId, userId);
			} else if (typeUser.equals(LmisConst.IS_STAFF)) {
				s = getArrayListPmUID(lsResult, userId);
			}
			List<Integer> lsInt = new ArrayList<Integer>();
			System.out.println("Content Set" +s );
			for (int i : s) {
				System.out.println("add to ls Int" +i);
				lsInt.add(i);
			}

			return lsInt;
		} catch (Exception e) {
			System.out.println("Error in LmisUtils.getListPmIDByUserId,");
			e.printStackTrace();
		}
		return null;
	}
	public  Set<Integer> getArrayListBodUID(
			List<LmisViewStaffMapping> ls, int userId) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Set<Integer> s = new HashSet<Integer>();

		for (LmisViewStaffMapping i : ls) {
			arr.add((i.getBodUID()));
		}
		for (int i : arr) {
			if (s.add(i)) {
			}
		}
		return s;
	}
	public  String getUserRoleByUID(int userId, int orgId) {
		String role = LmisConst.IS_PM;
		try {

			List<String> ls = ProgateOrganizationParticipantsLocalServiceUtil
					.getUserRoles(userId);
			for (String i : ls) {
				if (i.equals(LmisConst.IS_BOD)) {
					return LmisConst.IS_BOD;
				}
			}
			for (String i : ls) {
				if (i.equals(LmisConst.IS_PM)) {
					return LmisConst.IS_PM;
				}
			}
			for (String i : ls) {
				if (i.equals(LmisConst.IS_STAFF)) {
					return LmisConst.IS_STAFF;
				}
			}
			return role;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return role;
	}
	
	public  List<Integer> getListPmAndBodOfUser(int rootId,	int userId) {
		System.out.println("getListPmAndBodOfUser  ( " + rootId +","+ userId + " )");
		List<Integer> s = new ArrayList<Integer>();
		Set<Integer> so = new HashSet<Integer>();
		try {
			java.util.List<LmisViewStaffMapping> lsRoot = LmisViewStaffMappingUtil.findByRootID(rootId);
			java.util.List<LmisViewStaffMapping> lsUser = LmisViewStaffMappingUtil.findByStaffUID(userId);
			java.util.List<LmisViewStaffMapping> lsResult = ListUtils.intersection(lsRoot, lsUser);
			Iterator<LmisViewStaffMapping> it = lsResult.iterator();
			String typeUser = getUserRoleByUID(userId, 0);
			System.out.println("Test Data with typeuser:" + typeUser);
			System.out.println(lsUser);
			System.out.println(lsResult);
			
			s = getListBodUIDofUID(rootId, userId);
			so = getArrayListPmUID(lsResult, userId);		
			List<Integer> lsInt = new ArrayList<Integer>();			
			
			for (int i : s) {
				System.out.println(i);
				lsInt.add(i);
			}
			System.out.println("Content step 1: "+ lsInt.toString());
			
			for (int j : so) {
				System.out.println(j);
				lsInt.add(j);
			}
			System.out.println("Content step 2: "+ lsInt.toString());
			return lsInt;
		} catch (Exception e) {
			System.out.println("Error in LmisUtils.getListPmIDByUserId,");
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Lay ngay hom nay
	 */
	
	@Override
	public Date GetToday() throws com.liferay.portal.SystemException {
		   Calendar cal = Calendar.getInstance();
		   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		   System.out.println("Today's date is "+dateFormat.format(cal.getTime()));
		 return cal.getTime();
		}
	
	/**
	 * Lay ngay hom wa
	 */
	
		@Override
		public Date GetYesterdayDate() throws com.liferay.portal.SystemException {
		   Calendar cal = Calendar.getInstance();
		   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		   System.out.println("Today's date is "+dateFormat.format(cal.getTime()));
		   cal.add(Calendar.DATE, -1);
		   System.out.println("Yesterday's date was "+dateFormat.format(cal.getTime()));  
		   return cal.getTime();
		}
		/**
		 * Tru gio doi sang phut
		 */

	@Override
	public long getTimeDiff(Date hour1, Date hour2) {
	    DateFormat df = DateFormat.getTimeInstance(DateFormat.MEDIUM);
	    long remainder =( hour2.getTime() - hour1.getTime())/60000;
	    System.out.println("Time Difference = "+df.format(remainder));
	    return remainder ;
	}
	

	public String getEmailUser(int userId, int rootId){
		User obj;
		try {
			obj = UserUtil.fetchByPrimaryKey(userId);
			 return obj.getEmailaddress();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(" Error  at getEmailUser"+ e.toString());
			e.printStackTrace();
		}
	    return null;
	}
	
	

	public String getEmailOrg(int orgId){
		Organization obj;
		try {
			obj = OrganizationUtil.fetchByPrimaryKey(orgId);
			 return obj.getEmail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(" Error  at getEmailOrg"+ e.toString());
			e.printStackTrace();
		} 
	    return null;
	}
	
	
	

	public List<Organization> getOrganizationByRootId(int rootId) {
		try {

			List<Organization> result = OrganizationFinderUtil.getOrganizationByRootId(rootId);
			System.out.println("result:  " + result.toString());
			System.out.println("Call getOrganizationByRootId(" + rootId + ")");
			List<Organization> list = new ArrayList<Organization>();
			for (Organization org : result) {
				if (org.getOrgId() != rootId) {
					list.add(org);
				}
			}
			System.out.println(list.toString());
			return list;
		} catch (Exception e) {
			System.out
					.println("Error OrganizationLocalServiceImpl. getOrganization "
							+ e.toString());
		}
		return null;
	}
	/* (non-Javadoc)
	 * @see larion.progate.lmis.service.LmisGeneralSettingsLocalService#getListBodUIDbyRootId(int)
	 * get ListBODUID by rootID
	 */

	public ArrayList<Integer> getListBodUIDbyRootId(int rootId){
		try {
			ArrayList<Integer> arrBod = new ArrayList<Integer>();
			List<LmisViewOrgUserRoles> lsRoot = LmisViewOrgUserRolesUtil.findByRootID(rootId);
			List<LmisViewOrgUserRoles> lsBod = new ArrayList<LmisViewOrgUserRoles>();
			for(LmisViewOrgUserRoles i: lsRoot){
				if(i.getRoleId()==LmisConst.BOD){
					lsBod.add(i);
				}
			}
			for(LmisViewOrgUserRoles i: lsBod){
				arrBod.add(i.getUserId());
			}
			return arrBod;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Lay danh sach user quan ly boi PM
	 */

	public ArrayList<Integer> getListUserMangeByPM(int rootId, int pmId)
			throws com.liferay.portal.SystemException {

		ArrayList<Integer> arrPmId = new ArrayList<Integer>();
		try {
			List<larion.progate.lmis.model.LmisViewStaffMappingPm> lsRoot = LmisViewStaffMappingPmUtil.findByRootID(rootId);					
			List<larion.progate.lmis.model.LmisViewStaffMappingPm> lsPm = LmisViewStaffMappingPmUtil.findByPmUID(pmId);
			List<larion.progate.lmis.model.LmisViewStaffMappingPm> lsResult = ListUtils.intersection(lsRoot, lsPm);
			System.out.println(lsResult.toString());
			if (lsResult.size() != 0 && lsResult != null) {
				Iterator<larion.progate.lmis.model.LmisViewStaffMappingPm> it = lsResult.iterator();
				while (it.hasNext()) {
					larion.progate.lmis.model.LmisViewStaffMappingPm i = it.next();
						arrPmId.add(i.getStaffUID());
						System.out.println(i.getStaffUID());
				}
				System.out.println("Danh sach nhan vien "+ arrPmId.toString());
				return arrPmId;
			}
		} catch (Exception e) {
			System.out
					.println("Error in LmisViewStaffMappingPm.getListUserMangeByPM");
			e.printStackTrace();
		}
		return null;
	}
		/**
	 * Lay chan tren hoac duoi: 
	 * sessiontype =1 : sang <br/>
	 * sessiontype =2 : chieu <br/>
	 * blocktype =1 : chan duoi <br/>
	 * blocktype =2 : chan tren <br/>
	 * dayStr = yyyy/MM/dd
	 */

	public Date getBlock(int rootId, int userId, String dayStr,
			int sessiontype, int blocktype) {
		return LmisGeneralSettingsFinderUtil.getBlock(rootId, userId, dayStr,
				sessiontype, blocktype);
	}


	public String getBlockStr(int rootId, int userId, String dayStr,
			int sessiontype, int blocktype) {
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		return df.format(LmisGeneralSettingsFinderUtil.getBlock(rootId, userId,
				dayStr, sessiontype, blocktype));
	}


	public Date getRangeGoHomeEarly(int rootId, String sessionName) {

		try {
			List<LmisWorkingTimes> ls = LmisWorkingTimesLocalServiceUtil
					.findByWorkingTimeOf(rootId);
			if (ls.size() > 0) {
				for (LmisWorkingTimes i : ls) {
					if (i.getSessionName().equals(sessionName)) {
						Date tmp = DateUtils.addMinutes(i.getStartTime(),
								i.getMaxEarly());
						return tmp;
					}
				}
			} else {
				System.out
						.println("getRangeGoHomeEarly return new date when ls.size =0");
				return new Date();
			}

		} catch (Exception e) {
			System.out
					.println("Error in LmisGeneralSetting.getRangeGoHomeEarly"
							+ e.toString());
			e.printStackTrace();
			return new Date();
		}
		return null;
	}

	public  List<ProgateOrganizationsStaffs> loadListProGateOrgStaff(
			int orgId) throws SystemException, PortalException {
		List<ProgateOrganizationsStaffs> listStaffs = ProgateOrganizationsStaffsUtil
				.findByorgId(orgId);
		return listStaffs;
	}
	
	/* (non-Javadoc)
	 * @see larion.progate.lmis.service.LmisGeneralSettingsLocalService#caculateTotalDayOffHavePermission(int, int, int, int)t
	 * So ngay nghi co phep  trong thang
	 */

	public String caculateTotalDayOffHavePermission(
			int userid, int month, int year, int rootid) throws SystemException {
		try {
			String result = LmisGeneralSettingsFinderUtil
					.caculateTotalDayOffHavePermission(userid, month, year,
							rootid);
			System.out
					.println("Success LmisGeneralSettingsLocalServiceImpl.caculateTotalDayOffHavePermission ");
			return result;

		} catch (Exception e) {
			System.out
					.println("Error LmisGeneralSettingsLocalServiceImpl.caculateTotalDayOffHavePermission "
							+ e.toString());
		}
		return null;
	}
	
	

	public String caculateTotalDayOffDontHavePermission(
			int userid, int month, int year, int rootid) throws SystemException {
		try {
			String result = LmisGeneralSettingsFinderUtil.caculateTotalDayOffDontHavePermission(userid, month, year, rootid);				
			System.out
					.println("Success LmisGeneralSettingsLocalServiceImpl.caculateTotalDayOffDontHavePermission ");
			return result;

		} catch (Exception e) {
			System.out
					.println("Error LmisGeneralSettingsLocalServiceImpl.caculateTotalDayOffDontHavePermission "
							+ e.toString());
		}
		return null;
	}
	
	

	public String caculateTimeRemainTimeChangeRequest(int userid,int rootid) throws SystemException {
		try {
			String result = LmisGeneralSettingsFinderUtil.caculateTimeRemainTimeChangeRequest(userid, rootid)	;	
			System.out
					.println("Success LmisGeneralSettingsLocalServiceImpl.caculateTimeRemainTimeChangeRequest ");
			return result;

		} catch (Exception e) {
			System.out
					.println("Error LmisGeneralSettingsLocalServiceImpl.caculateTimeRemainTimeChangeRequest "
							+ e.toString());
		}
		return null;
	}	


	/* (non-Javadoc)
	 * @see larion.progate.lmis.service.LmisGeneralSettingsLocalService#getListEmail(java.util.List, int, int, int)
	 * Lay danh sach email
	 */
	public List<String> getListEmailByEmailType(int rootId, int userId,int emailType){
		List<Integer> ls = getListPmAndBodOfUser( rootId, userId);
		System.out.println("step 1" + ls.toString() + " size "
				+ ls.size());
		List<String> lsR = getListEmail(ls,userId, rootId, emailType);
		return lsR;
	}
	
	public List<String> getListEmail(List<Integer> user_Ids, int userId,
			int rootId, int id) {
			List<String> lsR = new ArrayList<String>();
		try {
			ArrayList<String> lsFinal = new ArrayList<String>();
			Set<String> result = new HashSet<String>();
			if (user_Ids == null) { // if BOD
				String tmp = getEmailUser(userId, rootId);
				lsFinal.add(tmp);
				System.out.println("success" + lsFinal.toString() + " size "
						+ lsFinal.size());
				for (String i : lsFinal) {
					if (result.add(i)) {
						lsR.add(i);
					}
				}								
		
				return lsR;
			} else { // if not BOD

				String tmp = getEmailUser(
						userId, rootId);
				lsFinal.add(tmp);
				System.out.println("step 1" + lsFinal.toString() + " size "
						+ lsFinal.size());

				for (Integer user_Id : user_Ids) {
					String tmps = getEmailUser(user_Id, rootId);
					lsFinal.add(tmps);
				}
				System.out.println("step 2" + lsFinal.toString() + " size "
						+ lsFinal.size());

					if (id != 9 || id != 10 || id != 11) {

					List<LmisViewEmailSettingDetailUser> result1 = LmisViewEmailSettingDetailUserLocalServiceUtil
							.getListEmailUserRelated(rootId, id);
					for (LmisViewEmailSettingDetailUser objUser : result1) {
						lsFinal.add(objUser.getEmailUser());
					}
					System.out.println("step 3 " + lsFinal.toString()
							+ " size " + lsFinal.size());
					List<LmisViewEmailSettingDetailOrg> result2 = LmisViewEmailSettingDetailOrgLocalServiceUtil
							.getListEmailOrgRelated(rootId, id);
					for (LmisViewEmailSettingDetailOrg objOrg : result2) {
						lsFinal.add(objOrg.getEmailOrg());
					}
					System.out.println("step 4" + lsFinal.toString() + " size "
							+ lsFinal.size());
					
					for (String i : lsFinal) {
								if (result.add(i)) {
									lsR.add(i);
								}
							}								
					
					return lsR;

				}
			}

			return lsR;

		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("Error LmisViewEmailSettingDetailUserLocalServiceImpl.getListEmail"
							+ e.toString());
		}
		return new ArrayList<String>();
	}
	
	public long DateDiff(Date dMax, Date dMin){
		Calendar cal1 = Calendar.getInstance();
		cal1.set(dMax.getYear(), dMax.getMonth(), dMax.getDate());
		Calendar cal2 = Calendar.getInstance();
		cal2.set(dMin.getYear(), dMin.getMonth(), dMin.getDate());
		
		long diff = cal1.getTimeInMillis() - cal2.getTimeInMillis();
		return diff/ (24*60*60*1000);
	}
	/**
	 * @param rootid
	 * @param userId
	 * @param year
	 * @return Tong so ngay nghi thuong nien nam truoc
	 * @throws Exception
	 */
	public double getTotalDayAwardPrevYear(int rootid, int userId,int year){
		try {
			return LmisAbsenceYearlyFinderUtil.getTotalDayAwardPrevYear(rootid, userId, year) ;
		} catch (Exception e) {
			return 0;
		}

	}
	/**
	 * @param rootid
	 * @param userId
	 * @param year
	 * @return Nghi tong ngay nghi thuong nien nam nay 
	 * @throws Exception
	 */
	public double getTotalDayAward(int rootid, int userId,int year){
		return LmisAbsenceYearlyFinderUtil.getTotalDayAward(rootid, userId, year);
	}
	/**
	 * @param rootid
	 * @param userId
	 * @param year
	 * @return Nghi tong ngay nghi bu trang ca trong thang 
	 * @throws Exception
	 */
	public double getTotalDayCompensation(int rootid, int userId,int year, int month) {
		return LmisAbsenceYearlyFinderUtil.getTotalDayCompensation(rootid, userId, year, month);
	}
	/**
	 * @param rootId
	 * @param userId
	 * @param month
	 * @param year
	 * @return total_working_time in tablle lmis_attendance_month
	 */
	public double getTotalWorkingTimeOfUID(int rootId, int userId, int month, int year){
		return LmisGeneralSettingsFinderUtil.getTotalWorkingTimeOfUID(rootId, userId, month, year);
	}
	/* (non-Javadoc)
	 * @see larion.progate.lmis.service.LmisGeneralSettingsLocalService#getTypeAbsenceInMonthlyDetail(int, int, int, int, int, int)
	 */
	public double getTypeAbsenceInMonthlyDetail(int rootId, int userId,int mon, int year, int absenceId, int type ){
		return LmisGeneralSettingsFinderUtil.getTypeAbsenceInMonthlyDetail(rootId, userId, mon, year, absenceId, type);
	}
	/* (non-Javadoc)
	 * @see larion.progate.lmis.service.LmisGeneralSettingsLocalService#getTypeAbsenceInYearDetail(int, int, int, int, int)
	 */
	public double getTypeAbsenceInYearDetail(int rootId, int userId,int year, int absenceId, int type ){
		return LmisGeneralSettingsFinderUtil.getTypeAbsenceInYearDetail(rootId, userId, year, absenceId, type);
	}

	public double getTotalDayOffOfUID(int rootId, int userId, int month,int year){
		return LmisGeneralSettingsFinderUtil.getTotalDayOffOfUID(rootId, userId, month, year);
	}
	/**
	 * @param rootId
	 * @param userId
	 * @param month
	 * @param year
	 * @return get_total_time_final_reward in lmis_attendance_monthly 
	 */
	public double getTotalTimeFinalRewardOfUID(int rootId, int userId, int month,int year){
		return LmisGeneralSettingsFinderUtil.getTotalTimeFinalRewardOfUID(rootId, userId, month, year);
	}
	/**
	 * @param rootId
	 * @return danh sach cac loai tang ca
	 * Bao cao thong ke - thong tin tang ca
	 */
	public List<LmisOverTimeTypes> getListOverTimeTypeOfRootId(int rootId){
		try {
			return LmisOverTimeTypesUtil.findByOverTimeTypesOf(rootId);
		} catch (Exception e) {
			System.out.println("Error in LmisGeneralSettings.getListOverTimeTypeOfRootId:"+e.toString() );
			return new ArrayList<LmisOverTimeTypes>();
		}
	}
	/**
	 * @param rootId
	 * @param userId
	 * @param month
	 * @param year
	 * @param otId
	 * @param isEff
	 * @return total_hour or total_hour_final in lmis_overtime_monthly <br/>
	 * Eff = true =>  total_hour <br/>
	 * Eff = false =>  total_hour_final <br/>
	 */
	public double getTotalHourOverTimeOfStaffInMonth(int rootId, int userId, int month,int year, int otId,boolean Eff){
		return LmisGeneralSettingsFinderUtil.getTotalHourOverTimeOfStaffInMonth(rootId, userId, month, year, otId, !Eff);
	}
	/**
	 * @param rootId
	 * @param userId
	 * @param month
	 * @param year
	 * @return Tong thoi gian tang ca da nhan he so
	 */
	public double getOverTimeHourFinalOfStaffInMonth(int rootId, int userId, int month,int year){
		return LmisGeneralSettingsFinderUtil.getOverTimeHourFinalOfStaffInMonth(rootId, userId, month, year);
	}
	/**
	 * @param rootId
	 * @param userId
	 * @param month
	 * @param year
	 * @param type
	 * @return Tong so ngay nghi bu tang ca <br/>
	 * 1 = So ngay NBTC Tong cong<br/>
	 * 2 = So ngay NBTC da nghi<br/>
	 * 3 = So ngay NBTC con lai<br/>
	 */
	public double getTotalDayAbsenceCompensasion(int rootId, int userId, int month,int year,int type){
		return LmisGeneralSettingsFinderUtil.getTotalDayAbsenceCompensasion(rootId, userId, month, year, type);
	}
	/**
	 * @param rootId
	 * @param userId
	 * @param month
	 * @param year
	 * @return total_day_compensation_next_month
	 */
	public double getDayCompensationNextMonthOfStaffInMonth(int rootId, int userId, int month,int year){
		return LmisGeneralSettingsFinderUtil.getDayCompensationNextMonthOfStaffInMonth(rootId, userId, month, year);
	}

	/**
	 * @param rootId
	 * @param userId
	 * @param month
	 * @param year
	 * @return So gio thuong phat Tang ca
	 */
	public double getTotalHourOverTimeReward(int rootId, int userId, int month,int year){
		return LmisGeneralSettingsFinderUtil.getTotalHourOverTimeReward(rootId, userId, month, year);
	}
	/**
	 * @param rootId
	 * @param userId
	 * @param year
	 * @param monStart
	 * @param monEnd
	 * @param type
	 * @return <a>depend on type </a><br/>
	 * 1 = Thoi gian bat dau trung binh <br/>
	 * 2 = Thoi gian ket thuc trung binh <br/>
	 */
	public Date getDetailSummayReportDate(int rootId, int userId, int year, int monStart,int monEnd, int type){
		return LmisGeneralSettingsFinderUtil.getDetailSummayReportDate(rootId, userId, year, monStart, monEnd, type);
	}
	/**
	 * @param rootId
	 * @param userId
	 * @param year
	 * @param monStart
	 * @param monEnd
	 * @param type
	 * @return <a>depend on type </a><br/>
	 * 1 = Tong thoi gian di tre <br/>
	 * 2 = Tong thoi gian ve som <br/>
	 * 3 = Tong ngay lam viec <br/>
	 * 4 = Tong So ngay nghi phep thuong nien <br/>
	 * >=5 = Tong so ngay nghi phep thuong nien nam truoc <br/>
	 */
	public int getDetailSummayReportInt(int rootId, int userId, int year, int monStart,int monEnd, int type){
		return LmisGeneralSettingsFinderUtil.getDetailSummayReportInt(rootId, userId, year, monStart, monEnd, type);
	}
	/**
	 * @param rootId
	 * @param userId
	 * @param year
	 * @param monStart
	 * @param monEnd
	 * @param type
     * @return <a>depend on type </a><br/>
     * 1 = Tong so gio tang ca <br/>
     * 2 = Tong gio tang ca duoc huong <br/>
     * 3 = Nghi phep thuong nien da nghi <br/>
     * 4 = Tong so ngay nghi phep thuong nien nam truoc da nghi <br/>
     * 5 = Tong so ngay nghi co phep <br/>
     * 6 = Tong so ngay nghi khong phep <br/>
     * 7 = Tong so gio thuong/phat  <br/>
     * 8 = Tong so ngay duoc nghi (nghi bu tang ca + nghi phep thuong nien + thuong nien nam truoc)  <br/>
	 */
	public double getDetailSummayReportDouble(int rootId, int userId, int year, int monStart,int monEnd, int type){
		return LmisGeneralSettingsFinderUtil.getDetailSummayReportDouble(rootId, userId, year, monStart, monEnd, type);
	}
	public List<LmisGeneralSettings> getInfoConfigFileAttendance(int rootId){
		return LmisGeneralSettingsFinderUtil.getInfoConfigFileAttendance(rootId);
	}
	public boolean updateInfoConfigFileAttendance(int rootId,String code, String name, String chkIn, String chkOut){
		return LmisGeneralSettingsFinderUtil.updateInfoConfigFileAttendance(rootId, code, name, chkIn, chkOut);
	}
	public double getTotalDayAwardRemaining(int rootId, int userId, int year){
		return LmisGeneralSettingsFinderUtil.getTotalDayAwardRemaining(rootId, userId, year);
	}
	public double getTotalDayAwardPrevYearRemaining(int rootId, int userId, int year){
		return LmisGeneralSettingsFinderUtil.getTotalDayAwardPrevYearRemaining(rootId, userId, year);
	}
	public double getTotalDayCompensationRemaining(int rootId, int userId, int mon, int year){
		return LmisGeneralSettingsFinderUtil.getTotalDayCompensationRemaining(rootId, userId, mon, year);
	}
	public String getAppName(){
		return LmisGeneralSettingsFinderUtil.getAppName();
	}
	public String getStaffCodeByUID(int rootId, int userId){
		try {
			DynamicQuery Q = DynamicQueryFactoryUtil.forClass(ProgateOrganizationsStaffs.class, PortletClassLoaderUtil.getClassLoader());
			Q.add(PropertyFactoryUtil.forName("rootId").eq(rootId));
			Q.add(PropertyFactoryUtil.forName("userId").eq(userId));
			List<Object> ls = ProgateOrganizationsStaffsLocalServiceUtil.dynamicQuery(Q);
			//Test
			System.out.println("Content : getStaffCodeByUID:"+ls);
			if(ls.size() >0){
				ProgateOrganizationsStaffs p =(ProgateOrganizationsStaffs) ls.get(0);
				return p.getStaffCode();
			}else{
				return "";
			}
		} catch (Exception e) {
			System.out.println("Error in LmisGeneralSettings.getStaffCodeByUID");
			return "";
		}
	}
}