package com.larion.progate.common.utils;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import com.liferay.ibm.icu.text.SimpleDateFormat;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.util.StringUtils;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.image.ImageProcessorUtil;
import com.liferay.portal.kernel.servlet.ImageServletTokenUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.upload.UploadServletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.upload.LiferayFileItem;
import com.liferay.portal.upload.LiferayFileItemFactory;
import com.liferay.portal.upload.LiferayFileUpload;
import com.liferay.portal.upload.LiferayServletRequest;
import com.liferay.portal.upload.UploadServletRequestImpl;
import com.liferay.portal.util.ContentTypeUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PrefsPropsUtil;
import com.liferay.portal.util.PropsKeys;
import com.liferay.portal.util.PropsUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.permission.DLFolderPermission;
import com.liferay.portlet.imagegallery.ImageNameException;
import com.liferay.portlet.imagegallery.ImageSizeException;
import com.liferay.portlet.imagegallery.NoSuchFolderException;
import com.liferay.portlet.imagegallery.model.IGFolder;
import com.liferay.portlet.imagegallery.model.IGImage;
import com.liferay.portlet.imagegallery.service.IGFolderLocalServiceUtil;
import com.liferay.portlet.imagegallery.service.IGImageServiceUtil;
import com.liferay.util.SystemProperties;

import java.awt.image.RenderedImage;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

import java.text.Format;
import java.text.ParseException;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import larion.progate.lmis.service.LmisAbsenceRequestsLocalServiceUtil;
import larion.progate.lmis.service.LmisAbsenceSettingsLocalServiceUtil;
import larion.progate.lmis.service.LmisAttMonthlyLocalServiceUtil;
import larion.progate.lmis.service.LmisAttYearlyLocalServiceUtil;
import larion.progate.lmis.service.LmisGeneralSettingsLocalServiceUtil;
import larion.progate.lmis.service.utils.LmisUtils;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import org.springframework.util.StringUtils;

public class Functions {

	public static final int DEFAULT_SIZE_MAX = GetterUtil.getInteger(PropsUtil
			.get(UploadServletRequestImpl.class.getName() + ".max.size"));

	public static final File DEFAULT_TEMP_DIR = new File(GetterUtil.getString(
			PropsUtil.get(UploadServletRequestImpl.class.getName()
					+ ".temp.dir"),
			SystemProperties.get(SystemProperties.TMP_DIR)));

	public static final String DATE_FORMAT = "dd-MM-yyyy";
	// *****************TVNA*************************
	public static String getHour(Date date) {
		Format formatter = new SimpleDateFormat("HH:mm");
		try {
			String[] temp;
			String hourStr = formatter.format(date);
			temp = hourStr.split(":");
			String hour = temp[0];
			return hour;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			return ("");
		}
	}

	public static String getMin(Date date) {
		Format formatter = new SimpleDateFormat("HH:mm");
		try {
			String[] temp;
			String minStr = formatter.format(date);
			temp = minStr.split(":");
			String min = temp[1];
			return min;
		} catch (Exception e) {
			return ("" );
			// TODO: handle exception
		}

	}
	
	
	
	public static Date addHourMin(Date date) {
		Date dates = null;
		Format formatter = new SimpleDateFormat("H:mm");
		String dateStr = formatter.format(date);
		System.out.println(dateStr);
		return dates;
	}

	public static String getFullName(int userId){
		String fullName = LmisUtils.getFullNameByUID(userId);
		return fullName;
	}
	public static String getAbsenceName(int absenceId){
		try{
			String name = LmisAbsenceRequestsLocalServiceUtil.funcNameAbsence(absenceId);
			return name;
		}catch(Exception e){
			return (e.toString()); 
		}
	}
	
	public static Date getAVGTimeStartMonth(int userId,int month,int year,int orgId){
		try{
			return  LmisAttMonthlyLocalServiceUtil.getMonthStartTimeAvg(userId, month, year, orgId);
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	
	public static Date getAVGTimeStartYear(int userId,int year,int orgId){
		try{
			return  LmisAttYearlyLocalServiceUtil.getYearStartTimeAvg(userId, year, orgId);
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public static Date getAVGTimeEndMonth(int userId,int month,int year,int orgId){
		try{
			return  LmisAttMonthlyLocalServiceUtil.getMonthEndTimeAvg(userId, month, year, orgId);
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public static Date getAVGTimeEndYear(int userId,int year,int orgId){
		try{
			return  LmisAttYearlyLocalServiceUtil.getYearEndTimeAvg(userId, year, orgId);
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public static int getTimeLate(int userId,int month,int year,int orgId){
		try{
			return  LmisAttMonthlyLocalServiceUtil.getTotalStartTimeLately(userId,month, year, orgId);
		}catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}
	
	public static int getTimeLatePernalty(int userId,int month,int year,int orgId){
		try{
			return  LmisAttMonthlyLocalServiceUtil.getTotalStartTimeLatePernalty(userId,month, year, orgId);
		}catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}
	
	public static int getTimeLateFinal(int userId,int month,int year,int orgId){
		try{
			double numDou = LmisAttMonthlyLocalServiceUtil.getTotalStartTimeLateFinal(userId,month, year, orgId);
			numDou = roundNumber(numDou, 0);
			//int num = (int)numDou;
			return  (int)numDou;
		}catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}
	
	public static int getTimeEarly(int userId,int month,int year,int orgId){
		try{
			return  LmisAttMonthlyLocalServiceUtil.getTotalEndTimeEarly(userId,month, year, orgId);
		}catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}
	
	public static int getTimeEarlyPernalty(int userId,int month,int year,int orgId){
		try{
			return  LmisAttMonthlyLocalServiceUtil.getTotalEndTimeEarlyPernalty(userId,month, year, orgId);
		}catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}
	
	public static int getTimeEarlyFinal(int userId,int month,int year,int orgId){
		try{
			double num = LmisAttMonthlyLocalServiceUtil.getTotalEndTimeEarlyFinal(userId,month, year, orgId);
			num = roundNumber(num, 0);
			return  (int)num;
		}catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}
	
	public static double getTotalWorkingTime(int userId,int month,int year,int orgId){
		try{
			double num = LmisGeneralSettingsLocalServiceUtil.getTotalWorkingTimeOfUID(orgId, userId, month, year);
			num = roundNumber(num, 1);
			return  num;
		}catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}
	
	public static double getAbsenceDetail(int userId,int month,int year,int orgId, int absenceId, int type){
		try{
			return  LmisGeneralSettingsLocalServiceUtil.getTypeAbsenceInMonthlyDetail(orgId, userId, month, year, absenceId, type); 
		}catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}
	
	public static double getTotalDayOff(int userId,int month,int year,int orgId){
		try{
			return  LmisGeneralSettingsLocalServiceUtil.getTotalDayOffOfUID(orgId, userId, month, year);
		}catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}
	
	public static double getTotalTimeFinalReward(int userId,int month,int year,int orgId){
		try{
			double num = LmisGeneralSettingsLocalServiceUtil.getTotalTimeFinalRewardOfUID(orgId, userId, month, year);
			num = roundNumber(num, 1);
			return  num;
		}catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}
	
	public static double getTotalHourOT(int userId,int month,int year,int orgId,int otId){
		try{
			double num = LmisGeneralSettingsLocalServiceUtil.getTotalHourOverTimeOfStaffInMonth(orgId, userId, month, year, otId, false);
			num = roundNumber(num, 1);
			return  num;
		}catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}
	
	public static double getOTFinal(int userId,int month,int year,int orgId){
		try{
			double num = LmisGeneralSettingsLocalServiceUtil.getOverTimeHourFinalOfStaffInMonth(orgId, userId, month, year);
			num = roundNumber(num, 1);
			return  num;
		}catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}
	
	public static double getTotalDayAbsenceCompensasion(int userId,int month,int year,int orgId,int type){
		try{
			return  LmisGeneralSettingsLocalServiceUtil.getTotalDayAbsenceCompensasion(orgId, userId, month, year, type);
		}catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}
	
	public static double getDayCompensationNextMonth(int userId,int month,int year,int orgId){
		try{
			return  LmisGeneralSettingsLocalServiceUtil.getDayCompensationNextMonthOfStaffInMonth(orgId, userId, month, year);
		}catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}
	
	public static double getOverTimeHour(int userId,int month,int year,int orgId){
		try{
			double num = LmisGeneralSettingsLocalServiceUtil.getOverTimeHourFinalOfStaffInMonth(orgId, userId, month, year);
			num = roundNumber(num, 1);
			return  num;
		}catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}
	
	public static int getTotalHourOverTimeReward(int userId,int month,int year,int orgId){
		try{
			double num = LmisGeneralSettingsLocalServiceUtil.getTotalHourOverTimeReward(orgId, userId, month, year);
			num = roundNumber(num, 0);
			return  (int)num;
		}catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}
	
	public static double getDetailSummayReportDouble(int userId,int monStart,int monEnd,int year,int orgId,int type){
		try{
			double r = LmisGeneralSettingsLocalServiceUtil.getDetailSummayReportDouble(orgId, userId, year, monStart, monEnd, type);
			
			//BigDecimal bd = new BigDecimal(r);
			//bd = bd.setScale(m, BigDecimal.ROUND_UP);
			//r = bd.doubleValue();
			r = roundNumber(r, 1);
			return  r;
		}catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}
	
	public static Date getDetailSummayReportDate(int userId,int monStart,int monEnd,int year,int orgId,int type){
		try{
			System.out.println("--------------------------gio: "+LmisGeneralSettingsLocalServiceUtil.getDetailSummayReportDate(orgId, userId, year, monStart, monEnd, type));
			return  LmisGeneralSettingsLocalServiceUtil.getDetailSummayReportDate(orgId, userId, year, monStart, monEnd, type);
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public static int getDetailSummayReportInt(int userId,int monStart,int monEnd,int year,int orgId,int type){
		try{
			return  LmisGeneralSettingsLocalServiceUtil.getDetailSummayReportInt(orgId, userId, year, monStart, monEnd, type);
		}catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}
	public static double roundNumber(double num,int m){
		try{
			BigDecimal bd = new BigDecimal(num);
			bd = bd.setScale(m, BigDecimal.ROUND_UP);
			num = bd.doubleValue();
			return  num;
		}catch (Exception e){
			return -1;
		}
	}
	// ***************END TVNA**********************

	// ******************TuyenTN********************
	public static int compareDate( Date d1, Date d2) throws ParseException{
		int cp;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dx = formatter.format(d1);
		String dy = formatter.format(d2);
		d1= formatter.parse(dx);
		d2 = formatter.parse(dy);
		cp = d1.compareTo(d2);
		return cp;
	}
	 public static String getOrgNameByOrgId(int suborgId){
		 System.out.println("subOrgId ... " + suborgId);
		 String orgName= "";
		 try{
			 orgName = LmisUtils.getOrgNameByUID(suborgId);
		 }catch(Exception e){
			 System.out.println("co loi xay ra khi lay orgName");
			 
		 }
		 return orgName;
	 }

	public static String getDayOfWeek(Date date) throws ParseException {
		Date inputDate =date;
		String dateOfWeek;
		//SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendar;
		int weekday;
		calendar = Calendar.getInstance();
		calendar.set(1900 + inputDate.getYear(), inputDate.getMonth(), inputDate.getDate());
		weekday = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(weekday);

		if (weekday == 1)
			dateOfWeek = "CN";
		else
			dateOfWeek = String.valueOf(weekday);

		return dateOfWeek;

	}

	public static boolean  isFutureDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		Date currentDate = calendar.getTime();
		if (date.before(currentDate) || date.equals(currentDate))
			return false;
		return true;

	}
	 public static String getUserNameByUserId(int id) throws PortalException,
	 SystemException {
	 User user = UserLocalServiceUtil.getUser(id);
	 String name = user.getFirstName() + user.getMiddleName() + " "
	 + user.getLastName();
	 return name;
	 }

	// **************** End TuyenTN*****************

	public static Date getDefaultDate() {
		// Gets a calendar using the default time zone and locale.
		Calendar calendar = Calendar.getInstance();

		// Get date with month + 1
		calendar.add(Calendar.MONTH, 1);

		return calendar.getTime();
	}

	public static int getQuarter(int month) {
		int quarter = 0;

		if (month <= 3 && month >= 1) {
			quarter = 1;
		} else if (month <= 6 && month >= 4) {
			quarter = 2;
		} else if (month <= 9 && month >= 7) {
			quarter = 3;
		} else {
			quarter = 4;
		}

		return quarter;
	}

	public static boolean isChecked(int id, List idList) {

		if (idList.indexOf(id) != -1) {
			return true;
		}

		return false;
	}

	public static IGFolder getIGFolder(ServiceContext sc)
			throws PortalException, SystemException {
		IGFolder folder = null;

		try {
			folder = IGFolderLocalServiceUtil.getFolder(sc.getScopeGroupId(),
					DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
					"admin-public-images");
		} catch (NoSuchFolderException e) {
			folder = IGFolderLocalServiceUtil.addFolder(sc.getUserId(),
					DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
					"admin-public-images", "admin-public-images", sc);
		}

		return folder;
	}

	public static IGFolder getIGFolder(User user, ServiceContext sc)
			throws PortalException, SystemException {
		IGFolder folder = null;

		try {
			folder = IGFolderLocalServiceUtil.getFolder(user.getGroupIds()[0],
					DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
					"admin-public-images");
		} catch (NoSuchFolderException e) {
			folder = IGFolderLocalServiceUtil.addFolder(user.getUserId(),
					DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
					"admin-public-images", "admin-public-images", sc);
		}

		return folder;
	}

	public static String getPathOfUploadImage(ActionRequest request,
			ActionResponse response, UploadPortletRequest uploadRequest,
			String fileUpload) {

		try {
			java.io.File file = uploadRequest.getFile(fileUpload);
			String fileName = uploadRequest.getFileName(fileUpload);
			String contentType = Functions.getContentType(uploadRequest, file,
					fileUpload);

			if (contentType.equals("application/octet-stream")) {
				String ext = GetterUtil.getString(
						FileUtil.getExtension(file.getName())).toLowerCase();

				if (Validator.isNotNull(ext)) {
					contentType = ContentTypeUtil.getContentType(ext);
				}
			}

			return Functions.getImageURLOfFile(request, file, fileName,
					contentType);

		} catch (Exception e) {
			return "";
		}
	}

	public static Map<String, String[]> getmultipartParameters(
			PortletRequest request, PortletResponse response) throws Exception {

		Map<String, String[]> multipartParameters = new HashMap<String, String[]>();

		// PortletServletObjectsFactory servletObjectsFactory = new
		// PortletServletObjectsFactory();

		ServletFileUpload servletFileUpload = new LiferayFileUpload(
				new LiferayFileItemFactory(Functions.DEFAULT_TEMP_DIR),
				PortalUtil.getHttpServletRequest(request));
		// servletObjectsFactory.getServletRequest(request));

		servletFileUpload.setSizeMax(Functions.DEFAULT_SIZE_MAX);

		LiferayServletRequest _lsr = new LiferayServletRequest(
				PortalUtil.getHttpServletRequest(request));
		// servletObjectsFactory.getServletRequest(request));

		List<LiferayFileItem> list = servletFileUpload.parseRequest(_lsr);

		System.out.println("LiferayFileItem list: " + list.size());

		// Iterator<LiferayFileItem> iterator = list.iterator();

		for (LiferayFileItem fileItem : list) {
			fileItem.setString("UTF-8");
			// LiferayFileItem fileItem = iterator.next();

			if (fileItem.isFormField()) {

				String fieldName = fileItem.getFieldName();
				String value = GetterUtil.getString(fileItem.getString());
				// new String(.getBytes("UTF-8"), "UTF-8");

				System.out.println("Field form name: " + fieldName
						+ "- Value: " + value + "charSet: "
						+ fileItem.getCharSet() + "UTF-8 value: "
						+ fileItem.getString("UTF-8"));

				String[] curParam = multipartParameters.get(fieldName);
				if (curParam == null) {
					// simple form field
					multipartParameters.put(fileItem.getFieldName(),
							new String[] { value });
				} else {
					// array of simple form fields
					String[] newParam = StringUtils.addStringToArray(curParam,
							value);
					multipartParameters.put(fileItem.getFieldName(), newParam);
				}

			} else {

				File file = fileItem.getStoreLocation();
				String fileName = fileItem.getName();
				String contentType = fileItem.getContentType();
				String fieldName = fileItem.getFieldName();
				String imageURL = "";
				if (!"".equals(fileName) && fileName != null) {
					imageURL = Functions.getImageURLOfFile(request, file,
							fileName, contentType);
				}

				System.out.println("field file name : " + fieldName
						+ "- Value: " + imageURL);
				String[] curParam = multipartParameters.get(fieldName);
				if (curParam == null) {
					// simple form field
					multipartParameters.put(fileItem.getFieldName(),
							new String[] { imageURL });
				} else {
					// array of simple form fields
					String[] newParam = StringUtils.addStringToArray(curParam,
							imageURL);
					multipartParameters.put(fieldName, newParam);
				}
			}
		}

		return multipartParameters;
	}

	public static String getImageURLOfFile(PortletRequest request, File file,
			String fileName, String contentType) throws Exception {
		// File file = fileItem.getStoreLocation();
		// String fileName = fileItem.getName();
		// String contentType = fileItem.getContentType();

		System.out.println("fileName: " + fileName);
		System.out.println("contentType: " + contentType);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				IGImage.class.getName(), request);
		// Make sure the uploaded images can be view by any one;
		serviceContext.setAddCommunityPermissions(true);
		serviceContext.setAddGuestPermissions(true);

		// get current user information
		// User user = UserLocalServiceUtil.getUser(serviceContext.getUserId());

		IGFolder folder = Functions.getIGFolder(serviceContext);

		IGImage image = IGImageServiceUtil.addImage(folder.getFolderId(),
				fileName + "_" + System.currentTimeMillis(), fileName, file,
				contentType, serviceContext);

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		String imageURL = themeDisplay.getPathImage() + "/image_gallery?uuid="
				+ image.getUuid() + "&groupId=" + folder.getGroupId() + "&t="
				+ ImageServletTokenUtil.getToken(image.getSmallImageId());

		return imageURL;
	}

	public static String getContentType(UploadPortletRequest uploadRequest,
			File file, String fileUpload) {

		String contentType = GetterUtil.getString(uploadRequest
				.getContentType(fileUpload));

		if (contentType.equals("application/octet-stream")) {
			String ext = GetterUtil.getString(
					FileUtil.getExtension(file.getName())).toLowerCase();

			if (Validator.isNotNull(ext)) {
				contentType = ContentTypeUtil.getContentType(ext);
			}
		}

		return contentType;
	}

	public static String getContentType(UploadServletRequest uploadRequest,
			File file, String fileUpload) {

		String contentType = GetterUtil.getString(uploadRequest
				.getContentType(fileUpload));

		if (contentType.equals("application/octet-stream")) {
			String ext = GetterUtil.getString(
					FileUtil.getExtension(file.getName())).toLowerCase();

			if (Validator.isNotNull(ext)) {
				contentType = ContentTypeUtil.getContentType(ext);
			}
		}

		return contentType;
	}

	public static void checkValidImage(ActionRequest request,
			UploadPortletRequest uploadRequest, String fileUpload)
			throws Exception {

		java.io.File file = uploadRequest.getFile(fileUpload);
		String fileName = file.getName();
		byte[] bytes = FileUtil.getBytes(file);

		checkValidImage(fileName, bytes);
	}

	public static void checkValidImage(String fileName, byte[] bytes)
			throws Exception {
		validate(fileName);
		validate(bytes);
		RenderedImage renderedImage = ImageProcessorUtil.read(bytes)
				.getRenderedImage();

		if (renderedImage == null) {
			throw new IOException(
					"Unable to retreive rendered image from input stream ");
		}
	}

	public static void validate(long folderId, String nameWithExtension,
			String fileName, byte[] bytes) throws PortalException,
			SystemException {

		if (Validator.isNotNull(fileName)) {
			String extension = FileUtil.getExtension(fileName);

			if (Validator.isNull(nameWithExtension)) {
				nameWithExtension = fileName;
			} else if (!StringUtil.endsWith(nameWithExtension, extension)) {
				throw new ImageNameException();
			}
		}

		validate(nameWithExtension);
		validate(bytes);
	}

	public static void validate(String nameWithExtension)
			throws PortalException, SystemException {

		if ((nameWithExtension.indexOf("\\\\") != -1)
				|| (nameWithExtension.indexOf("//") != -1)
				|| (nameWithExtension.indexOf(":") != -1)
				|| (nameWithExtension.indexOf("*") != -1)
				|| (nameWithExtension.indexOf("?") != -1)
				|| (nameWithExtension.indexOf("\"") != -1)
				|| (nameWithExtension.indexOf("<") != -1)
				|| (nameWithExtension.indexOf(">") != -1)
				|| (nameWithExtension.indexOf("|") != -1)
				|| (nameWithExtension.indexOf("&") != -1)
				|| (nameWithExtension.indexOf("[") != -1)
				|| (nameWithExtension.indexOf("]") != -1)
				|| (nameWithExtension.indexOf("'") != -1)) {

			throw new ImageNameException();
		}

		boolean validImageExtension = false;

		String[] imageExtensions = PrefsPropsUtil.getStringArray(
				PropsKeys.IG_IMAGE_EXTENSIONS, StringPool.COMMA);

		for (int i = 0; i < imageExtensions.length; i++) {
			if (StringPool.STAR.equals(imageExtensions[i])
					|| StringUtil.endsWith(nameWithExtension,
							imageExtensions[i])) {

				validImageExtension = true;

				break;
			}
		}

		if (!validImageExtension) {
			throw new ImageNameException();
		}
	}

	public static void validate(byte[] bytes) throws ImageSizeException,
			SystemException {

		if ((PrefsPropsUtil.getLong(PropsKeys.IG_IMAGE_MAX_SIZE) > 0)
				&& ((bytes == null) || (bytes.length > PrefsPropsUtil
						.getLong(PropsKeys.IG_IMAGE_MAX_SIZE)))) {

			throw new ImageSizeException();
		}
	}

	public static String getPathOfUploadDocument(ActionRequest request,
			ActionResponse response, UploadPortletRequest uploadRequest,
			String fileUpload) throws Exception {

		java.io.File file = uploadRequest.getFile(fileUpload);
		String fileName = uploadRequest.getFileName(fileUpload);

		return Functions.getDocumentUrlOfFile(request, file, fileName);
	}

	public static String getDocumentUrlOfFile(PortletRequest request,
			File file, String fileName) throws Exception {

		System.out.println("fileName: " + fileName);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				DLFolder.class.getName(), request);
		// Make sure the uploaded document can be view by any one;
		serviceContext.setAddCommunityPermissions(true);
		serviceContext.setAddGuestPermissions(true);

		DLFolder folder = Functions.getDLFolder(serviceContext);
		long folderId = folder.getFolderId();

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		DLFolderPermission.check(themeDisplay.getPermissionChecker(),
				folder.getFolderId(), ActionKeys.ADD_DOCUMENT);

		DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.addFileEntry(
				themeDisplay.getUserId(), folderId, fileName, fileName,
				fileName, "", file, serviceContext);
		
		String folderURL = themeDisplay.getPathMain()
				+ "/document_library/get_file?p_l_id=" + themeDisplay.getPlid()
				+ "&folderId=" + folderId + "&name="
				+ HttpUtil.encodeURL(HtmlUtil.unescape(fileEntry.getName()));
		return folderURL;
	}

	public static DLFolder getDLFolder(ServiceContext sc)
			throws PortalException, SystemException {
		DLFolder folder = null;

		try {
			folder = DLFolderLocalServiceUtil.getFolder(sc.getScopeGroupId(),
					DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
					"ProGate-folder");
		} catch (com.liferay.portlet.documentlibrary.NoSuchFolderException e) {

			folder = DLFolderLocalServiceUtil.addFolder(sc.getUserId(),
					sc.getScopeGroupId(),
					DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
					"ProGate-folder", "ProGate-folder", sc);
		}

		return folder;
	}

}
