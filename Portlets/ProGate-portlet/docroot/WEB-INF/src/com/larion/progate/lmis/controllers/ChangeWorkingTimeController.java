package com.larion.progate.lmis.controllers;

import com.larion.progate.common.constants.Request;
import com.larion.progate.lmis.util.SendMailUtils;

import com.liferay.ibm.icu.text.SimpleDateFormat;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;


import java.text.ParseException;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;

import larion.progate.lmis.model.LmisTimeChangeRequests;
import larion.progate.lmis.service.LmisGeneralSettingsLocalServiceUtil;
import larion.progate.lmis.service.LmisTimeChangeRequestsLocalServiceUtil;
import larion.progate.service.ViewOrgUsersPermissionsLocalServiceUtil;
import larion.progate.lmis.service.utils.LmisConst;
import larion.progate.lmis.service.utils.LmisUtils;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.mvc.ParameterizableViewController;

public class ChangeWorkingTimeController extends ParameterizableViewController {

	@Override
	protected ModelAndView handleRenderRequestInternal(RenderRequest request,
			RenderResponse response) throws Exception {

		HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
		HttpServletRequest orgReq = PortalUtil.getOriginalServletRequest(req);
		Map<String,Object>bean = new HashMap<String,Object>();
		//System.out.println("dfrsdf" + request.getParameter("cancelChangeID"));
		try{
			String cmd=ParamUtil.getString(request,Constants.CMD,null);
			System.out.println("-----------cmd:----"+cmd);
			bean.put("cmd",cmd);
			String tabAction=ParamUtil.getString(request, Request.TAB_ACT,null);
			System.out.println(tabAction);
			bean.put("tabAction",tabAction);
			String currentHander=ParamUtil.getString(request, Request.CURRENT_HANDER,null);
			bean.put("currentHander",currentHander);
			System.out.println("-------pass01---");
			//get UserId
			ServiceContext sc = ServiceContextFactory.getInstance(this.getClass().getName(), request);
			User user = UserLocalServiceUtil.getUser(sc.getUserId());
			Long userIdTemp = user.getUserId();
			Integer userId = userIdTemp.intValue();
			System.out.println(userId);
			String userName= LmisUtils.getFullNameByUID(userId);
			System.out.println(userName);
			bean.put("userName", userName);
			int orgId=ParamUtil.getInteger(request, Request.ORG_ID);
			bean.put("orgId",orgId);
			System.out.println("orgId: "+orgId);
			int selectedChangeTimeID=ParamUtil.getInteger(request, Request.SELECTED_ID,-1);
			bean.put("selectedID",selectedChangeTimeID);
			System.out.println("id duoc hcon la: "+selectedChangeTimeID);
			//check if user is permited or not
			int appId = LmisConst.App_Id;
			String appName = LmisConst.App_Name;
			int categoryId =  LmisConst.Pers_Att;
			String viewTimeChangeReqId = LmisConst.Manage_TimeChange_Request; //tab persion
			String approveTimeChangeReqId = LmisConst.Approve_TimeChange_Request; //tab manager
			String viewOrgTimeChangeReqId = LmisConst.View_Org_TimeChange_Request; //tab other
			int tabPersion = ViewOrgUsersPermissionsLocalServiceUtil.checkUserSpecialPermission(appName, categoryId, orgId, (int)userId, viewTimeChangeReqId);
			int tabManager = ViewOrgUsersPermissionsLocalServiceUtil.checkUserSpecialPermission(appName, categoryId, orgId,(int) userId, approveTimeChangeReqId);
			int tabOther = ViewOrgUsersPermissionsLocalServiceUtil.checkUserSpecialPermission(appName, categoryId, orgId, (int)userId, viewOrgTimeChangeReqId);
			System.out.println("----------------------debug---Quyen------------------------");
			System.out.println("tab ca nhan: "+ tabPersion);
			System.out.println("tab quan ly: "+ tabManager);
			System.out.println("tab khac: "+ tabOther);
			System.out.println("---------------------end debug--------------------------------");
			bean.put("tabPersion", tabPersion);
			bean.put("tabManager", tabManager);
			bean.put("tabOther", tabOther);

			if (cmd.equals(Constants.EDIT) || cmd.equals(Constants.VIEW)){
				int currentID=selectedChangeTimeID;

				LmisTimeChangeRequests timeChangeDetail=LmisTimeChangeRequestsLocalServiceUtil
						.getLmisTimeChangeRequests(selectedChangeTimeID);
				System.out.println(timeChangeDetail);
				bean.put("timeChangeDetail",timeChangeDetail);
				bean.put("currentID", currentID);

				String str = LmisTimeChangeRequestsLocalServiceUtil.getContentApprovals(orgId, selectedChangeTimeID);
				bean.put("contentApproval", str);

			}else if (cmd.equals(Constants.UPDATE)){
				Date [] hourStart = new Date[6];
				SimpleDateFormat df=new SimpleDateFormat("dd/MM/yy");
				System.out.println("---------------------debug------"+ selectedChangeTimeID);
				String startDateStr=ParamUtil.getString(request, "dateBegin");
				Date startDate=df.parse(startDateStr);
				System.out.println(startDate);

				String endDateStr=ParamUtil.getString(request, "dateEnd");
				Date endDate=df.parse(endDateStr);
				String requestReason=ParamUtil.getString(request, "reason");

				String monHour=ParamUtil.getString(request, "monHour");
				String monMin=ParamUtil.getString(request, "monMin");
				Date monStartTime=mergeHourMin(monHour,monMin);
				hourStart[0]=monStartTime;
				Date monEndTime=addHour(monHour, monMin);

				String tueHour=ParamUtil.getString(request, "tueHour");
				String tueMin=ParamUtil.getString(request, "tueMin");
				Date tueStartTime=mergeHourMin(tueHour,tueMin);
				hourStart[1]=tueStartTime;
				Date tueEndTime=addHour(tueHour, tueMin);

				String wedHour=ParamUtil.getString(request, "wedHour");
				String wedMin=ParamUtil.getString(request, "wedMin");
				Date wedStartTime=mergeHourMin(wedHour,wedMin);
				hourStart[2]=wedStartTime;
				Date wedEndTime=addHour(wedHour, wedMin);

				String thuHour=ParamUtil.getString(request, "thuHour");
				String thuMin=ParamUtil.getString(request, "thuMin");
				Date thuStartTime=mergeHourMin(thuHour,thuMin);
				hourStart[3]=thuStartTime;
				Date thuEndTime=addHour(thuHour, thuMin);

				String friHour=ParamUtil.getString(request, "friHour");
				String friMin=ParamUtil.getString(request, "friMin");
				Date friStartTime=mergeHourMin(friHour,friMin);
				hourStart[4]=friStartTime;
				Date friEndTime=addHour(friHour, friMin);

				String satHour=ParamUtil.getString(request, "satHour");
				String satMin=ParamUtil.getString(request, "satMin");
				Date satStartTime=mergeHourMin(satHour,satMin);
				hourStart[5]=satStartTime;
				Date satEndTime=addHour(satHour, satMin);

				if (currentHander.equals(Constants.EDIT)){
					LmisTimeChangeRequestsLocalServiceUtil.editRequestTimeChange
						(orgId, selectedChangeTimeID, startDate, endDate, monStartTime, monEndTime,
							tueStartTime, tueEndTime, wedStartTime, wedEndTime,
							thuStartTime, thuEndTime, friStartTime, friEndTime,
							satStartTime, satEndTime, requestReason);
					LmisTimeChangeRequests timeChangeDetail=LmisTimeChangeRequestsLocalServiceUtil
						.getLmisTimeChangeRequests(selectedChangeTimeID);
					bean.put("timeChangeDetail",timeChangeDetail);
					bean.put("isSuccess","yes");
				}else{//currentHander add
					LmisTimeChangeRequestsLocalServiceUtil.addRequestTimeChange
						(orgId, userId, startDate, endDate, monStartTime, monEndTime, tueStartTime,
							tueEndTime, wedStartTime, wedEndTime, thuStartTime, thuEndTime,
							friStartTime, friEndTime, satStartTime, satEndTime, requestReason);
					sendMail(userId,orgId,userName,startDateStr,endDateStr,requestReason,hourStart);
					bean.put("isSuccess","yes");
				}
			}else if (cmd.equals(Constants.ADD)){
				Date date= DateUtils.addDays(new Date(), 1);
				String hour = "8";
				String min="00";
				Date startTime=mergeHourMin(hour,min);
				Date endTime=addHour(hour, min);
				bean.put("startTime",startTime);
				bean.put("endTime", endTime);
				bean.put("dateCurrent", date);
			}else if (cmd.equals(Constants.DELETE)){
				System.out.println("id delete: "+selectedChangeTimeID);
				LmisTimeChangeRequestsLocalServiceUtil.deleteChangeTimeReq(orgId, userId,selectedChangeTimeID);
				bean.put("isSuccess","yes");
			}
			/*List<LmisTimeChangeRequests> timeChangeRequestList = LmisTimeChangeRequestsLocalServiceUtil
			.getListRequestTimeChangeOf(orgId, userId);
			bean.put("timeChangeRequest",timeChangeRequestList);
*/
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		bean.put("CMD", Constants.CMD);
		bean.put("VIEW",Constants.VIEW);
		bean.put("ADD", Constants.ADD);
		bean.put("EDIT", Constants.EDIT);
		bean.put("DELETE", Constants.DELETE);
		bean.put("UPDATE",Constants.UPDATE);
		bean.put("TAB_PERSONAL", Request.TAB_PERSONAL);
		bean.put("TAB_MANAGER", Request.TAB_MANAGER);
		bean.put("TAB_OTHER", Request.TAB_OTHER);
		bean.put("UNDO_HANDER", Request.UNDO_HANDER);

		return new ModelAndView(this.getViewName(),"bean",bean);
	}

	public Date mergeHourMin(String hour,String min){
		SimpleDateFormat df=new SimpleDateFormat("HH:mm");
		String mergeStr=hour + ":" + min;
		try{
			return(Date)df.parse(mergeStr);
		}catch(ParseException e){
			System.out.println("Error in Function.mergeHourMin" +e.toString());
		}
		return null;
	}

	public Date addHour(String hour,String min){
		Date date;
		int _hour = Integer.parseInt(hour);
		int _min=Integer.parseInt(min);
		int minAdd=_min+30;
		int hourAdd=_hour+9;
		if (minAdd >=60){
			hourAdd=hourAdd + minAdd/60;
			minAdd= minAdd % 60;
		}
		if (hourAdd >= 24){
			hourAdd=hourAdd%24;
		}
		String hourS = Integer.toString(hourAdd);
		String minS=Integer.toString(minAdd);
		date = mergeHourMin(hourS,minS);
		System.out.println("gio da cong them:"+date);
		return date;
	}
	
	public void sendMail(int userId, int orgId,String userName, String dateStart, String dateEnd,String reason,Date[] hourStart ){
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat hf = new SimpleDateFormat("HH:mm");
		Date dateValue = new Date();
		String date = df.format(dateValue);
		String []hour = new String[6];
		for(int i = 0 ; i<6;i++){
			hour[i] = hf.format(hourStart[i]);
		}
		String subject="Đơn xin thay đổi thời gian làm việc";
		String content = "<html> Chào bạn! " +
						   "<p> Bạn "+ userName +" mong muốn thay đổi thời gian làm việc với thông tin chi tiết như sau: </p>" +
						   "<p>Ngày tạo: "+ date +"</p>"+
						   "<p>Ngày bắt đầu: "+ 	dateStart +"</p>"+
						   "<p>Ngày kết thúc: "+ dateEnd + "</p>"+
						   "<p>Lý do: "+ reason +"</p>"+
						   "<p><table border='1'><thead><tr><th>Thứ</th><th>Giờ bắt đầu</th></tr></thead>"+
						   "<tbody><tr><td>2</td><td>"+hour[0]+"</td></tr>"+  
						   "<tr><td>3</td><td>"+hour[1]+"</td></tr>"+
						   "<tr><td>4</td><td>"+hour[2]+"</td></tr>"+
						   "<tr><td>5</td><td>"+hour[3]+"</td></tr>"+
						   "<tr><td>6</td><td>"+hour[4]+"</td></tr>"+
						   "<tr><td>7</td><td>"+hour[5]+"</td></tr>"+
						   "</tbody>"+
				"</html>";
		List<String> lsMail = LmisGeneralSettingsLocalServiceUtil.getListEmailByEmailType(orgId, userId, 1);
		int countMail = lsMail.size();
		System.out.println("fdsfs: "+countMail);
		System.out.println("list mail: "+ lsMail);
		String [] receiver = (String[])lsMail.toArray(new String[0]);
		SendMailUtils mail = new SendMailUtils();
		mail.setReceiver(receiver);
		mail.setSubject(subject);
		mail.setContent(content);
		try{
			mail.postMail();
			System.out.println("Gui thanh cong");
		}catch (javax.mail.SendFailedException f) {
			// TODO: handle exception
			System.out.println("dia chi mail ko ton tai");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Loi khi gui mail");
		}
		
	}

}