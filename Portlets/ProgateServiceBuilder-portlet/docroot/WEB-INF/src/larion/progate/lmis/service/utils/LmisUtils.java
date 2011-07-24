/**
 * 
 * @author phatnt
 *
 */

package larion.progate.lmis.service.utils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.ecs.storage.Array;

import com.csvreader.CsvReader;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import larion.progate.lmis.model.LmisDataImportDetails;
import larion.progate.lmis.model.LmisDataImports;
import larion.progate.lmis.model.LmisGeneralSettings;
import larion.progate.lmis.model.LmisViewStaffMapping;
import larion.progate.lmis.model.LmisViewStaffRootOrgFN;
import larion.progate.lmis.model.LmisWorkingTimes;
import larion.progate.model.Organization;
import larion.progate.model.User;

import larion.progate.lmis.service.LmisDataImportDetailsLocalServiceUtil;
import larion.progate.lmis.service.LmisDataImportsLocalServiceUtil;
import larion.progate.lmis.service.LmisGeneralSettingsLocalServiceUtil;
import larion.progate.lmis.service.LmisViewStaffRootOrgFNLocalServiceUtil;
import larion.progate.lmis.service.LmisWorkingTimesLocalServiceUtil;
import larion.progate.service.OrganizationLocalServiceUtil;
import larion.progate.service.ProgateOrganizationParticipantsLocalServiceUtil;
import larion.progate.service.UserLocalServiceUtil;
import larion.progate.lmis.service.persistence.LmisViewEmailSettingDetailOrgUtil;
import larion.progate.lmis.service.persistence.LmisViewEmailSettingDetailUserUtil;
import larion.progate.lmis.service.persistence.LmisViewStaffMappingUtil;
import larion.progate.lmis.service.utils.LmisConst;

//import larion.progate.lmis.model.LmisViewEmailSettingDetailUser;

/**
 * @author NGTHPHAT
 *
 */
/**
 * List<LmisViewOrgUserRoles> getListOrgByUserIdPM(int userId) : lay danh sach
 * cac to chuc pm quan ly
 * 
 */
public class LmisUtils {
	public static String getFullNameByUID(int userId) {
		try {

			User u = UserLocalServiceUtil.getUser(userId);
			return (u.getFirstname() + " " + u.getMiddlename() + u
					.getLastname());
		} catch (PortalException e) {
			System.out
					.println("Error in LmisUtils.getFullNameByUID with param:"
							+ userId);
			e.printStackTrace();
			return null;
		} catch (SystemException e) {
			System.out
					.println("Error in LmisUtils.getFullNameByUID with param: "+ userId +" ");
			return null;
		}
	}
	
	public static String getOrgNameByUID(int orgId) {
		try {

			Organization u = OrganizationLocalServiceUtil.getOrganization(orgId);
			return u.getName();
		} catch (PortalException e) {
			System.out
			.println("Error in LmisUtils.getOrgNameByUIDD with param:"
					+ orgId +" e:"+e.toString());
			return null;
		} catch (SystemException e) {
			System.out
					.println("Error in LmisUtils.getOrgNameByUIDD with param:"
							+ orgId +" e:"+e.toString());
		
			return null;
		}
	}

	public static Set<Integer> getArrayListPmUID(
			List<LmisViewStaffMapping> ls, int userId) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Set<Integer> s = new HashSet<Integer>();

		for (LmisViewStaffMapping i : ls) {
			arr.add((i.getPmUID()));
		}
		for (int i : arr) {
			if (s.add(i)) {
			}
		}
		return s;
	}

	public static Set<Integer> getArrayListBodUID(
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

	/**
	 * @param rootId
	 * @param userId
	 * @return ArrayList<Integer> Return list PMUID or BODUID depend on type
	 *         UserId(isStaff, isBod, isPm)
	 */

	public static List<Integer> getListPmIdOrBodIdByUserId(int rootId,
			int userId) {
		try {
			return LmisGeneralSettingsLocalServiceUtil.getListPmIdOrBodIdByUserId(rootId, userId);
		} catch (Exception e) {
			System.out.println("Error in LmisUtil.getListPmIdOrBodIdByUserId");
			return new ArrayList<Integer>(); 
			
		}
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Integer> getListEmailSettingDetailOrgById(
			int rootId, int id) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		try {
			System.out.println("aaa");
			List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> lsRoot = LmisViewEmailSettingDetailOrgUtil
					.findByRootID(rootId);
			System.out.println("gsgs");
			List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> lsId = LmisViewEmailSettingDetailOrgUtil
					.findByID(id);
			System.out.println("gsgsgsg");
			List<larion.progate.lmis.model.LmisViewEmailSettingDetailOrg> result = ListUtils
					.intersection(lsRoot, lsId);
			for (larion.progate.lmis.model.LmisViewEmailSettingDetailOrg lmisViewEmailSettingDetailOrg : result) {
				arr.add(lmisViewEmailSettingDetailOrg.getOrgRelatedId());
			}
			System.out.println("nvvvn");
			// Iterator<LmisViewEmailSettingDetailOrg> it = result.iterator();
			//
			// while(it.hasNext())
			// {
			// LmisViewEmailSettingDetailOrg i = it.next();
			//
			// if(i.getOrgRelatedId()!=id)
			// {
			// arr.add(i.getOrgRelatedId());
			// }
			// }
			return arr;
		} catch (SystemException e) {
			System.out
					.println("Error in LmisUtils.getListEmailSettingDetailOrgById");
			e.printStackTrace();
		}
		return null;
	}


	public static ArrayList<Integer> getListEmailSettingDetailUserByUserId(
			int rootId, int id) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		try {
			
			List<larion.progate.lmis.model.LmisViewEmailSettingDetailUser> lsRoot = LmisViewEmailSettingDetailUserUtil
					.findByRootID(rootId);
		
			List<larion.progate.lmis.model.LmisViewEmailSettingDetailUser> lsId = LmisViewEmailSettingDetailUserUtil
					.findByID(id);
		
			List<larion.progate.lmis.model.LmisViewEmailSettingDetailUser> result = ListUtils
					.intersection(lsRoot, lsId);
			
			for (larion.progate.lmis.model.LmisViewEmailSettingDetailUser lmisViewEmailSettingDetailUser : result) {
				arr.add(lmisViewEmailSettingDetailUser.getUserRelatedId());
			}			
			return arr;
		} catch (SystemException e) {
			System.out
					.println("Error in LmisUtils. getListEmailSettingDetailUserByUserId");
			e.printStackTrace();
		}
		return null;
	}

	public static Date convertStrtoDate(String strDate, String pattern)
			throws java.text.ParseException {

		DateFormat df = new SimpleDateFormat(pattern);

		try {
			Date today = df.parse(strDate);
			return today;
		} catch (java.text.ParseException e) {
			System.out.println("Error in convertStrtoDate: caused by"+e.toString());
		}
		return null;
	}
	public static Date parseStrToDate(String strDate, String pattern) {
	
		DateFormat df = new SimpleDateFormat(pattern);
		
		try {
			Date today = df.parse(strDate);
			return today;
		} catch (java.text.ParseException e) {
			System.out.println("Error in convertStrtoDate: caused by"+e.toString());
		}
		return null;
	}

	public static int insertDataImport(int rootId, int userId, Date imp,
			int importType, Date now) {
		try {
			int importId = 0;
			List<LmisDataImports> lsImp = LmisDataImportsLocalServiceUtil.findByDataImportOf(rootId);
			List<LmisDataImports> lsDate = LmisDataImportsLocalServiceUtil.findByDateValue(imp);
			List<LmisDataImports> lsResult = ListUtils.intersection(lsImp, lsDate);
			System.out.println("Test: LmisUtil.updateImpInfo: insertDataImport.lsResult :" +lsResult);
			if(lsResult.size()==0){
				List<LmisWorkingTimes> ls = LmisWorkingTimesLocalServiceUtil
						.findByWorkingTimeOf(rootId);
				for (LmisWorkingTimes i : ls) {
					LmisDataImports item = LmisDataImportsLocalServiceUtil
							.createLmisDataImports(null);
					item.setRootId(rootId);
					item.setDateValue(imp);
					item.setImportType(importType);
					item.setImportBy(userId);
					
					item.setImportAt(now);
					item.setSessionId(i.getPrimaryKey());
					LmisDataImportsLocalServiceUtil.updateLmisDataImports(item,
							false);
					importId = item.getPrimaryKey();
				}
				return importId;
			}else{
				return lsResult.get(lsResult.size()-1).getPrimaryKey(); //get PrimaryKey last
			}
		} catch (SystemException e) {
			System.out.println("Error in LmisUtil.insertDataImport");
			e.printStackTrace();
			return -1;
		}
	}

	public static int updateAttInfo(int rootId, int userId, Date imp,
			int importType, boolean isSessionRelated, InputStream input, ArrayList<String> lsG)
			throws SystemException {
		/*
		 * //This is test Entity LmisDataImportDetail
		 * 
		 * LmisDataImportDetails d =
		 * LmisDataImportDetailsLocalServiceUtil.createLmisDataImportDetails
		 * (null); d.setRootId(96); d.setScannerId("20"); d.setImportId(12);
		 * d.setStaffName("Phat for test");
		 * LmisDataImportDetailsLocalServiceUtil.updateLmisDataImportDetails(d,
		 * false); //End test
		 */

		// isSessionRelated=true, cty chi cham cong 1 lan
		// Get List lmis_data_import where rootid=rootI
		Date now = new Date();
		if (isSessionRelated) {
			// Insert to LmisDataImports
			int importId = insertDataImport(rootId, userId, imp, importType,
					now);
			if (importId != -1) {
				// Insert to LmisDataImportDetail
				Charset set = Charset.forName("ISO-8859-1");
				CsvReader reader = new CsvReader(input, set);
				int absenceType = 0;
				int flag = isValFile(reader);
				if (flag == LmisConst.Imp_Chk_IsValFile) {
					try {
						// Insert to DataImportDetail
						String pattern = "HH:mm:ss";
						Set<String> setCode =new HashSet<String>();
						List<String> lsExcessive= new ArrayList<String>(); //List chua' Staff thua`.
						List<LmisViewStaffRootOrgFN> lsStaff= LmisViewStaffRootOrgFNLocalServiceUtil.findByRootID(rootId);
						HashMap<String, Integer> hm = new HashMap<String, Integer>();
						for(LmisViewStaffRootOrgFN i:lsStaff){
							if(setCode.add( i.getScannerCode())){
							 //Set chua danh sach ma cham cong nhan vien,
							 //put dzo hm de de~ lay userId tu` ScannerId
							 	hm.put(i.getScannerCode(), i.getUserId());
							 }
						}
						try{//Xoa trong ImportDetail neu da co'
							List<LmisDataImportDetails> lsDetail = LmisDataImportDetailsLocalServiceUtil.findByImportID(importId);
							if(lsDetail.size()>0){
								for(LmisDataImportDetails i: lsDetail){
									LmisDataImportDetailsLocalServiceUtil.deleteLmisDataImportDetails(i.getPrimaryKey());
								}
							}
						}catch(PortalException e){ e.printStackTrace();}
												 
						while (reader.readRecord()) {
							try {
								String scannerId = reader.get(lsG.get(0).toString());
								String name = reader.get(lsG.get(1).toString());
								String clockIn = reader.get(lsG.get(2).toString());
								String clockOut = reader.get(lsG.get(3).toString());
								System.out.println("Test read Record:"
										+ scannerId + " " + name + " "
										+ clockIn + " " + clockOut);
								//Kiem tra staff code ton tai hay ko
								if( setCode.contains(scannerId)==true ){
											LmisDataImportDetails i = LmisDataImportDetailsLocalServiceUtil
													.createLmisDataImportDetails(null);
											i.setRootId(rootId);
											i.setScannerId(scannerId);
											i.setImportId(importId);
											i.setStaffName(name);
											absenceType = setAbsence(rootId,hm.get(scannerId),clockIn,
												clockOut,imp);
											System.out.println("absenceType :"+ absenceType);
											i.setAbSence(absenceType);
											if(StringUtils.isNotBlank(clockOut) && StringUtils.isNotBlank(clockIn)){
												
												i.setStartTime(convertStrtoDate(clockIn, pattern));
												i.setEndTime(convertStrtoDate(clockOut, pattern));
												
												System.out.println("Both of them not blank:" + clockIn + " " +clockOut);
											}else if(StringUtils.isNotBlank(clockOut)){
												i.setEndTime(convertStrtoDate(clockOut,pattern));
												System.out.println("ClockOut not blank");
											}else if(StringUtils.isNotBlank(clockIn)){
												i.setStartTime(convertStrtoDate(clockIn,pattern));
												System.out.println("ClockIn not blank");
											}
		
											LmisDataImportDetailsLocalServiceUtil.updateLmisDataImportDetails(i,false);
								}else{
									//Ma cham cong khong ton tai trong database
									lsExcessive.add(scannerId);
								}

							} catch (ParseException e) {
								System.out.println("Error, can't parse...");
								// Xoa du lieu moi them
								return LmisConst.Imp_Err_Parse;
							}

						}
					} catch (java.io.IOException e) {
						e.printStackTrace();
					}catch(SystemException e){
						return LmisConst.Imp_Chk_Lt4Col;
					}
				} else {
					return flag;
				}

			} else {
				System.out.println("Can't insert data to LmisDataImport");
				return LmisConst.Imp_Err_InserDataImp;
			}
		} else {
			// not related
		}
		return 0;
	}

	public static int isValFile(CsvReader reader) {
		// Check Header CSV, csv must have AC-No,Name,Clock In,Clock Out
		// column
		try {
			System.out.println(reader.readHeaders());
			System.out.println(reader.getHeaders());
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		int countHeader = reader.getHeaderCount();
		if (countHeader < 4) {
			System.out.println("This Csv file not enough 4 colum:" + countHeader);
			return LmisConst.Imp_Chk_Lt4Col;
		} else {
			try {
				String[] arrHeader = reader.getHeaders();
				if (isValColumn(arrHeader)) {
					return LmisConst.Imp_Chk_IsValFile;
				} else {
					System.out.println("This Csv not match column");
					return LmisConst.Imp_Chk_NotMatch;
				}
			} catch (FileNotFoundException e) {
				System.out
						.println("Error in LmisUtil.updateAttInfo, file not found "
								+ e.toString());
				e.printStackTrace();
				return LmisConst.Imp_Chk_IsNotValFile;
			} catch (java.io.IOException e) {
				System.out
						.println("Error in LmisUtil.updateAttInfo, IOException "
								+ e.toString());
				e.printStackTrace();
				return LmisConst.Imp_Chk_IsNotValFile;
			}
		}
	}

	public static boolean isValColumn(String[] arr) {
		return true;
	}
	public static boolean isExistStaffCode(int rootId, String code){
		return true;
	}
		/**
	 * @param clockIn
	 * @param clockOut
	 * @return absence type depend on clockin and clockout is empty or not <br/>
	 *         Any clockIn or clockOut is null then return 3; <br/>
	 *         
	 *         
	 *   Des:
	 *   	Morning				Afternoon		<br/> 
	 *   	|---------|---|=====|--------|---|	<br/>
	 *	    A.........B...C..........A'.......B'..C'	<br/>
	 *	
	 *  =:relax time  <br/>
	 *   <br/>
	 *	A: blockDownMor <br/>
	 *	B: goHomeEarlyMor <br/>
	 *	C: blockUpMor <br/>
	 *	A' blockDownAft <br/>
	 *	B' goHomeEarlyAfter <br/>
	 *	C' blockUpAft <br/>
	 *   
	 */
	public static int setAbsence(int rootId, int userId,String clockIn, String clockOut,Date imp) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			String dayStr = df.format(imp);
			Date clockInDate;
			Date clockOutDate;
			if(StringUtils.isBlank(clockOut) || StringUtils.isBlank(clockIn)){
				return 3;
			}
			else{ 
				clockInDate = LmisUtils.convertStrtoDate(clockIn, "HH:mm:ss");
				clockOutDate = LmisUtils.convertStrtoDate(clockOut, "HH:mm:ss");
			}
			Date goHomeEarlyMor = LmisGeneralSettingsLocalServiceUtil.getRangeGoHomeEarly(rootId, LmisConst.Morning);
			Date goHomeEarlyAfter = LmisGeneralSettingsLocalServiceUtil.getRangeGoHomeEarly(rootId, LmisConst.Afternoon);
			Date blockDownMor = LmisGeneralSettingsLocalServiceUtil.getBlock(rootId, userId, dayStr, 1, 1);
			Date blockUpMor =LmisGeneralSettingsLocalServiceUtil.getBlock(rootId, userId, dayStr, 1, 2);
			Date blockDownAft =LmisGeneralSettingsLocalServiceUtil.getBlock(rootId, userId, dayStr, 2, 1);
			Date blockUpAft = LmisGeneralSettingsLocalServiceUtil.getBlock(rootId, userId, dayStr, 2, 2);
			//Test data
			System.out.println("Test data setAbsence:goHomeEarlyAfter "+goHomeEarlyAfter);
			System.out.println("Test data setAbsence:goHomeMor "+ goHomeEarlyMor);
			System.out.println("Test blockDownMor "+blockDownMor);
			System.out.println("Test blockUpMor "+blockUpMor);
			System.out.println("Test blockDownAft "+blockDownAft);
			System.out.println("Test blockUpAft "+blockUpAft);
			
			//not yet optimize 
			//Case clockIn > goHomeEarlyAfter
			if(clockInDate.compareTo(goHomeEarlyAfter)>0){
				return 3;
			}
			//Case go home early morning
			if(clockIn!=null && clockOutDate.compareTo(goHomeEarlyMor)<0 ){
				System.out.println("Case go home early morning");
				return 3;
			}
			//Case go home early afternoon off morning
			if(clockInDate.compareTo(goHomeEarlyMor)>0 && clockOutDate.compareTo(goHomeEarlyAfter)<0){
				System.out.println("Case go home early afternoon and off morning");
				return 3;
			}
			//Case off afternoon
			if(clockIn !=null && clockOutDate.compareTo(blockDownAft)<0){
				System.out.println("Case off afternoon");
				return 2;
			}
			//Case off afternoon,and working morning but go home early afternoon 
			if(clockIn !=null && clockOutDate.compareTo(blockDownAft)>0 && clockOutDate.compareTo(goHomeEarlyAfter)<0){
				System.out.println("Case off afternoon,and working morning but go home early afternoon");
				return 2;
			}
			//Case off morning
			if(clockInDate.compareTo(goHomeEarlyMor)>0 && clockOutDate.compareTo(goHomeEarlyAfter)>0){
				System.out.println("Case off morning");
				return 1;
			}else{
				return 0;
			}
		} catch (ParseException e) {
			System.out.println("Error in setAbsence:" + e.toString());
			return 3;
		}

	}

	/**
	 * @param userId
	 * @param orgId -- tham so thua`
	 * @return highest Role of UserID
	 */
	public static String getUserRoleByUID(int userId, int orgId) {
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

	public static List<Organization> getOrganizationByRootId(int rootId) {

		return LmisGeneralSettingsLocalServiceUtil
				.getOrganizationByRootId(rootId);
	}

	public static long DateDiff(Date dMax, Date dMin) {
		Calendar cal1 = Calendar.getInstance();
		cal1.set(dMax.getYear(), dMax.getMonth(), dMax.getDate());
		Calendar cal2 = Calendar.getInstance();
		cal2.set(dMin.getYear(), dMin.getMonth(), dMin.getDate());

		long diff = cal1.getTimeInMillis() - cal2.getTimeInMillis();
		return diff / (24 * 60 * 60 * 1000);
	}
}
