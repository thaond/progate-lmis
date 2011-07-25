package com.larion.progate.cds.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import larion.progate.cds.model.CdsEvaluationPeriods;
import larion.progate.cds.service.CdsEvaluationPeriodsLocalServiceUtil;
import larion.progate.lmis.model.LmisWorkingCalendars;
import larion.progate.lmis.service.LmisWorkingCalendarsLocalServiceUtil;
import larion.progate.lmis.service.utils.LmisUtils;
import larion.progate.service.OrganizationLocalServiceUtil;
import larion.progate.service.ProgateOrganizationsStaffsLocalServiceUtil;

import org.apache.commons.lang.time.DateUtils;

import com.larion.progate.cds.constant.RequestConst;
import com.liferay.ibm.icu.util.Calendar;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.job.IntervalJob;
import com.liferay.portal.kernel.job.JobExecutionContext;
import com.liferay.portal.kernel.job.JobExecutionException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.Time;

public class JobExcution implements IntervalJob {
	public JobExcution() {
		_interval = Time.DAY;
	}

	public long getInterval() {
		return _interval;
	}

	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		try {
			System.out.println("THIS IS THE ACTUAL TASK!");
			
			Date currentDate = new Date();
			currentDate = DateUtils.addHours(currentDate, 7);

			List<Integer> listOfRootIds = OrganizationLocalServiceUtil
					.getCompany();
			//System.out.println("getList roodit"+listOfRootIds);
			//Lmis
			Calendar cal = Calendar.getInstance();

			int next3month = cal.get(Calendar.MONTH) + 4;
			int year = cal.get(Calendar.YEAR);
			if(next3month>12){
				next3month-=12;
				year++;
			}
			//cal.set(year, cal.get(Calendar.MONTH)+1 );
			//System.out.println("getActualMaximum");
			//int lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			System.out.println("LmisScheduler Started!");
			//System.out.println("next4firstday "+year+"/"+next3month+"/"+"01");
			//System.out.println("next4lastday " +year+"/"+next3month+"/"+"30");
			Date next3firstday = LmisUtils.convertStrtoDate(year+"/"+next3month+"/"+"01","yyyy/MM/dd");
			Date next3lastday = LmisUtils.convertStrtoDate(year+"/"+next3month+"/"+"30","yyyy/MM/dd");
			
			for (int rootId : listOfRootIds) {
				// LMIS
				DynamicQuery Q = DynamicQueryFactoryUtil.forClass(LmisWorkingCalendars.class,PortletClassLoaderUtil.getClassLoader());
				Q.add(PropertyFactoryUtil.forName("rootId").eq(rootId));
				Q.add(PropertyFactoryUtil.forName("dayValue").ge(next3firstday));
				Q.add(PropertyFactoryUtil.forName("dayValue").le(next3lastday));
				
				
				List<Object> lsO = LmisWorkingCalendarsLocalServiceUtil.dynamicQuery(Q);
				System.out.println("LmisWorkingCalendarsLocalServiceUtil: "+lsO);
				if(lsO.size() ==0 || lsO ==null){
					LmisWorkingCalendarsLocalServiceUtil.workingcalendar(rootId, year, next3month);
				}
				//CDS
				List<CdsEvaluationPeriods> periods = CdsEvaluationPeriodsLocalServiceUtil
						.getPeriodByRootId(rootId);

				for (CdsEvaluationPeriods period : periods) {

					if (period.getStatus() == 1) {
						long compare = daysBetween2Dates(currentDate,
								period.getFromDate());

						if (compare <= 7 && compare > 0) {
							System.out.println("OK-GUI MAIL NHAC MO DOT");
							sendMailToBods(rootId, period.getName(), 1,
									period.getFromDate(), period.getToDate());
						}
					}

					if (period.getStatus() == 2) {

						long compare = daysBetween2Dates(period.getToDate(),
								currentDate);

						if (compare <= 7 && compare > 0) {
							System.out.println("OK-GUI MAIL NHAC DONG DOT");
							sendMailToBods(rootId, period.getName(), 2,
									period.getFromDate(), period.getToDate());
						}
					}

				}
			}

		} catch (Exception e) {
			System.out.println("Error in JobExcution: "+e.toString());
		}
	}

	private long _interval;

	public static long daysBetween2Dates(Date d1, Date d2) {
		return (d2.getTime() - d1.getTime()) / (24 * 3600 * 1000);
	}

	public static long minutesBetween2Dates(Date d1, Date d2) {
		System.out.println("ms of currentDate = " + d1.getTime());
		Date d = new Date(d1.getTime());
		System.out.println("currentDate= " + d);

		System.out.println("ms of fromDate = " + d2.getTime());
		Date e = new Date(d2.getTime());
		System.out.println("fromDate= " + e);

		long kq = (d2.getTime() - d1.getTime()) / (60 * 1000);
		System.out.println("KQ=" + kq);

		return kq;
	}

	private void sendMailToBods(int rootId, String periodName, int newStatus,
			Date fromDate, Date toDate) throws PortalException, SystemException {
		List<Integer> listOfBodIds = ProgateOrganizationsStaffsLocalServiceUtil
				.getBODInCompany(rootId);

		for (int userId : listOfBodIds) {
			com.liferay.portal.model.User userLiferay = com.liferay.portal.service.UserLocalServiceUtil
					.getUser(userId);
			if (userLiferay != null) {
				StringBuffer subject = new StringBuffer();
				StringBuffer content = new StringBuffer();
				StringBuffer url = new StringBuffer();

				SendMailUtil mail = new SendMailUtil();

				String recipients[] = new String[1];
				recipients[0] = userLiferay.getEmailAddress();
				mail.setReceiver(recipients);

				url.append("http://");
				// url.append(RequestConst.PROGATE_HOST);
				url.append(":");
				// url.append(RequestConst.PROGATE_PORT);
				url.append("/tochuc/ungdung/danhgia/cds?orgId=");
				url.append(rootId);

				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				if (newStatus == 1) { // Nhac mo dot
					subject.append("[LARION_CDS]Nhac nho: mo dot CDS ");
					subject.append(periodName);

					content.append("<p>Chào bạn ");
					content.append(userLiferay.getFullName());
					content.append(",</p>");
					content.append("<p>Hiện tại tổ chức <strong>");
					content.append(OrganizationLocalServiceUtil
							.getOrganization(rootId).getName());
					content.append("</strong> có đợt CDS<strong> ");
					content.append(periodName);
					content.append(" </strong>co  ngay bat dau danh gia từ ngày<strong> ");
					content.append(sdf.format(fromDate));
					content.append("</strong> tới ngày<strong> ");
					content.append(sdf.format(toDate));
					content.append("</strong>.</p>");
					content.append("<p>Bạn có thể nhấp vào link bên dưới để vào ứng dụng và mo dot đánh giá CDS:<br /><a href='");
					content.append(url);
					content.append("'>");
					content.append(url);
					content.append("</a></p><p>Trân trọng cảm ơn! <br />ProGate Portal</p><p><hr /> <strong>Lưu ý: </strong> Đây là hệ thống email tự động, vui lòng không trả lời email này</p><p style='padding-top: 20px'>ProGate Portal phát triển bởi LARION Computing, 2011</p>");
				} else if (newStatus == 2) { // Nhac dong dot
					subject.append("[LARION_CDS]Thông Báo: Hiện tại đã đóng đợt CDS ");
					subject.append(periodName);

					content.append("<p>Chào bạn ");
					content.append(userLiferay.getFullName());
					content.append("<p>Hiện tại tổ chức <strong>");
					content.append(OrganizationLocalServiceUtil
							.getOrganization(rootId).getName());
					content.append("</strong> đã đóng đợt CDS<strong> ");
					content.append(periodName);
					content.append(" </strong></p><p><hr /> <strong>Lưu ý: </strong> Đây là hệ thống email tự động, vui lòng không trả lời email này</p><p style='padding-top: 20px'>ProGate Portal phát triển bởi LARION Computing, 2011</p>");
				}

				mail.setSubject(subject.toString());
				mail.setContent(content.toString());

				try {
					mail.postMail();
					System.out.println("PVA: Đã gửi mail thành công");
				} catch (javax.mail.SendFailedException f) {
					System.out.println("PVA: Địa chỉ email không tồn tại - "
							+ f);
				} catch (Exception e) {
					System.out.println("PVA: Có lỗi khi gửi email - " + e);
				}
			}
		}

	}
}