package larion.progate.lmis.service.utils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import larion.progate.lmis.model.LmisDataImportDetails;
import larion.progate.lmis.model.LmisDataImports;
import larion.progate.lmis.model.LmisGeneralSettings;
import larion.progate.lmis.model.LmisViewStaffRootOrgFN;
import larion.progate.lmis.model.LmisWorkingTimes;
import larion.progate.lmis.service.LmisDataImportDetailsLocalServiceUtil;
import larion.progate.lmis.service.LmisDataImportsLocalServiceUtil;
import larion.progate.lmis.service.LmisGeneralSettingsLocalServiceUtil;
import larion.progate.lmis.service.LmisViewStaffRootOrgFNLocalServiceUtil;
import larion.progate.lmis.service.LmisWorkingTimesLocalServiceUtil;
import larion.progate.lmis.service.persistence.LmisGeneralSettingsFinderUtil;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.StringUtils;


import com.csvreader.CsvReader;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

public class UpdateAttInfo {
	private boolean hasError;
	private String codeError;
	
	private int rootId;
	private int userId;
	private Date imp;
	private Date now;
	private int impType;
	private int importId;
	private boolean isSessionRelated;
	private InputStream input;
	private int flag ;
	private String pattern;
	private Set<String> setCode;
	private List<String> lsExcessive;
	private List<LmisViewStaffRootOrgFN> lsStaff;
	private HashMap<String, Integer> hm;
	private String Code; //Cot ma cham cong
	private String Name; //Cot ma nhan vien
	private String ChkIn; //Cot gio vao
	private String ChkOut; //Cot gio ra
	private Date goHomeEarlyMor;
	private Date goHomeEarlyAfter;
	private SimpleDateFormat df;
	
	public UpdateAttInfo(int rootId, int userId, Date imp,int importType, boolean isSessionRelated, InputStream input) {
		try {
			
			this.rootId = rootId;
			this.userId = userId;
			this.impType = importType;
			this.imp = imp;
			this.isSessionRelated = isSessionRelated;
			this.input = input;
			this.pattern = "HH:mm:ss";
			this.now = new Date();
			this.setCode = new HashSet<String>();
			this.lsExcessive  = new ArrayList<String>();
			this.lsStaff = LmisViewStaffRootOrgFNLocalServiceUtil.findByRootID(rootId);
			this.hm  = new HashMap<String, Integer>();
			
			this.hasError = false;
			this.codeError = "";
			
			this.df  = new SimpleDateFormat("yyyy/MM/dd");
			this.goHomeEarlyMor = LmisGeneralSettingsLocalServiceUtil.getRangeGoHomeEarly(rootId, LmisConst.Morning);
			this.goHomeEarlyAfter  = LmisGeneralSettingsLocalServiceUtil.getRangeGoHomeEarly(rootId, LmisConst.Afternoon);
			
			List<LmisGeneralSettings> lstmp =LmisGeneralSettingsFinderUtil.getInfoConfigFileAttendance(this.rootId);
			if (lstmp.size() == 4){
				this.Code = lstmp.get(0).getName();
				this.Name = lstmp.get(1).getName();
				this.ChkIn = lstmp.get(2).getName();
				this.ChkOut = lstmp.get(3).getName();
			}else{
				this.hasError = true;
				this.codeError = LmisConst.Imp_Err_NotEnough4Col;
			}
			this.doUpdate();
			
		} catch (SystemException e) {
			System.out.println("Error in default contruction: UpdateAttInfo"+e.toString());
			this.hasError = true;
			this.codeError = LmisConst.Imp_Err_DefaultConstruction;
		}
		
	}
	public boolean getHasError(){
		return this.hasError;
	}
	public List<String> getListExcessive(){
		return this.lsExcessive;
	}
	public String getCodeError(){
		return this.codeError;
	}
	public void doUpdate(){
		if(this.hasError ==false){
			
			if(this.isSessionRelated){
				
				this.importId = insertDataImport(this.rootId, this.userId, this.imp, this.impType, this.now);
				
				if(this.importId != -1){
					
					Charset set = Charset.forName("ISO-8859-1");
					CsvReader reader = new CsvReader(input, set);
					int absenceType = 0;
					this.flag = isValFile(reader);
					
					if (this.flag == LmisConst.Imp_Chk_IsValFile) {
						try {
							
							for(LmisViewStaffRootOrgFN i:this.lsStaff){
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
							}catch(PortalException e){
								this.hasError=true;
								this.codeError="Error in UpdateAttInfo when insert data to LmisDataImport: paramenter:" +this.rootId; 
								System.out.println("Error in delete exist data in ImportDetail: "+e.toString());
							}
							
							while (reader.readRecord()) {
								try {
									String scannerId = reader.get(this.Code);
									String name = reader.get(this.Name);
									String clockIn = reader.get(this.ChkIn);
									String clockOut = reader.get(this.ChkOut);
									System.out.println("Test read Record:" + scannerId + " " + name + " " + clockIn + " " + clockOut);
									if( this.setCode.contains(scannerId)==true ){
										LmisDataImportDetails i = LmisDataImportDetailsLocalServiceUtil.createLmisDataImportDetails(null);
										i.setRootId(this.rootId);
										i.setScannerId(scannerId);
										i.setImportId(this.importId);
										i.setStaffName(name);
										absenceType = setAbsence(rootId,hm.get(scannerId),clockIn,clockOut,imp);
										System.out.println("absenceType :"+ absenceType);
										i.setAbSence(absenceType);
										if(StringUtils.isNotBlank(clockOut) && StringUtils.isNotBlank(clockIn)){
											
											i.setStartTime(LmisUtils.convertStrtoDate(clockIn, pattern));
											i.setEndTime(LmisUtils.convertStrtoDate(clockOut, pattern));
											
											System.out.println("Both of them not blank:" + clockIn + " " +clockOut);
										}else if(StringUtils.isNotBlank(clockOut)){
											i.setEndTime(LmisUtils.convertStrtoDate(clockOut,pattern));
											System.out.println("ClockOut not blank");
										}else if(StringUtils.isNotBlank(clockIn)){
											i.setStartTime(LmisUtils.convertStrtoDate(clockIn,pattern));
											System.out.println("ClockIn not blank");
										}
										LmisDataImportDetailsLocalServiceUtil.updateLmisDataImportDetails(i,false);
									}else{
										this.lsExcessive.add(name);
									}
								} catch (ParseException e) {
									System.out.println("Can't Parse");
									this.hasError = true;
								}
							}
						} catch (Exception e) {
							// TODO: handle exception
						}
						
					}
				}
			}
		}
	}
	public int insertDataImport(int rootId, int userId, Date imp,
			int importType, Date now) {
		try {
			int importId = 0;
			List<LmisDataImports> lsImp = LmisDataImportsLocalServiceUtil.findByDataImportOf(rootId);
			List<LmisDataImports> lsDate = LmisDataImportsLocalServiceUtil.findByDateValue(imp);
			List<LmisDataImports> lsResult = ListUtils.intersection(lsImp, lsDate);
			//System.out.println("Test: LmisUtil.updateImpInfo: insertDataImport.lsResult :" +lsResult);
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
					LmisDataImportsLocalServiceUtil.updateLmisDataImports(item,	false);
					importId = item.getPrimaryKey();
				}
				return importId;
			}else{
				return lsResult.get(lsResult.size()-1).getPrimaryKey(); //get PrimaryKey last
			}
		} catch (SystemException e) {
			System.out.println("Error in LmisUtil.insertDataImport:"+e.toString());
			
			return -1;
		}
	}
	private int isValFile(CsvReader reader) {
		// Check Header CSV, csv must have AC-No,Name,Clock In,Clock Out
		// column
		try {
			System.out.println(reader.readHeaders());
			System.out.println(reader.getHeaders());
		} catch (java.io.IOException e) {
			this.hasError=true;
			this.codeError="This file not validate";
			return LmisConst.Imp_Chk_IsNotValFile;
		}
		int countHeader = reader.getHeaderCount();
		if (countHeader < 4) {
			System.out.println("This Csv file not enough 4 colum:" + countHeader);
			this.hasError=true;
			return LmisConst.Imp_Chk_Lt4Col;
		} else {
			try {
				String[] arrHeader = reader.getHeaders();
				if (isValColumn(arrHeader)) {
					return LmisConst.Imp_Chk_IsValFile;
				} else {
					System.out.println("This Csv not match column");
					this.hasError = true;
					return LmisConst.Imp_Chk_NotMatch;
				}
			} catch (FileNotFoundException e) {
				System.out.println("Error in LmisUtil.updateAttInfo, file not found: "+ e.toString());
				this.hasError =true;
				return LmisConst.Imp_Chk_IsNotValFile;
			} catch (java.io.IOException e) {
				System.out.println("Error in LmisUtil.updateAttInfo, IOException "+ e.toString());
				this.hasError =true;
				return LmisConst.Imp_Chk_IsNotValFile;
			}
		}
	}
	public boolean isValColumn(String[] arr) {
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
	 *	    A.........B...C.....A'.......B'..C'	<br/>
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
	public int setAbsence(int rootId, int userId,String clockIn, String clockOut,Date imp) {
		try {
			
			String dayStr = this.df.format(imp);
			Date clockInDate;
			Date clockOutDate;
			if(StringUtils.isBlank(clockOut) || StringUtils.isBlank(clockIn)){
				return 3;
			}
			else{ 
				clockInDate = LmisUtils.convertStrtoDate(clockIn, "HH:mm:ss");
				clockOutDate = LmisUtils.convertStrtoDate(clockOut, "HH:mm:ss");
			}
			
			
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
			
		
			//Case go home early morning
			if(clockIn!=null && clockOutDate.compareTo(this.goHomeEarlyMor)<0 ){
				System.out.println("Case go home early morning");
				return 3;
			}
			//Case go home early afternoon off morning
			if(clockInDate.compareTo(this.goHomeEarlyMor)>0 && clockOutDate.compareTo(this.goHomeEarlyAfter)<0){
				System.out.println("Case go home early afternoon and off morning");
				return 3;
			}
			//Case off afternoon
			if(clockIn !=null && clockOutDate.compareTo(blockDownAft)<0){
				System.out.println("Case off afternoon");
				return 2;
			}
			//Case off afternoon,and working morning but go home early afternoon 
			if(clockIn !=null && clockOutDate.compareTo(blockDownAft)>0 && clockOutDate.compareTo(this.goHomeEarlyAfter)<0){
				System.out.println("Case off afternoon,and working morning but go home early afternoon");
				return 2;
			}
			//Case off morning
			if(clockInDate.compareTo(this.goHomeEarlyMor)>0 && clockOutDate.compareTo(this.goHomeEarlyAfter)>0){
				System.out.println("Case off morning");
				return 1;
			}else{
				return 0;
			}
		} catch (ParseException e) {
			System.out.println("Error in setAbsence:" + e.toString());
			this.hasError = true;
			return 3;
		}

	}
	
}
