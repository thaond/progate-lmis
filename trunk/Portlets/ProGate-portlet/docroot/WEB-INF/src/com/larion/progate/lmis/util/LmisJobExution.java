package com.larion.progate.lmis.util;

import java.util.Date;
import java.util.List;

import larion.progate.cds.model.CdsEvaluationPeriods;
import larion.progate.cds.service.CdsEvaluationPeriodsLocalServiceUtil;
import larion.progate.lmis.model.LmisWorkingCalendars;
import larion.progate.lmis.service.LmisWorkingCalendarsLocalServiceUtil;
import larion.progate.lmis.service.utils.LmisUtils;
import larion.progate.service.OrganizationLocalServiceUtil;

import org.apache.commons.lang.time.DateUtils;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.job.IntervalJob;
import com.liferay.portal.kernel.job.JobExecutionContext;
import com.liferay.portal.kernel.job.JobExecutionException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.Time;


public class LmisJobExution implements IntervalJob {
	private long _interval;

	public LmisJobExution() {
		_interval = Time.DAY;
	}

	public long getInterval() {
		return _interval;
	}

	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		try {
			
				Date now  = new Date();
				
				List<Integer> listOfRootIds = OrganizationLocalServiceUtil.getCompany();
				int curmonth = now.getMonth();
				int next3month = now.getMonth() +3;
				int year = now.getYear();
				if(next3month>12){
					next3month-=12;
					year++;
				}
				System.out.println("LmisScheduler Started!");
				System.out.println("next3firstday "+year+"/"+next3month+"/"+"01");
				System.out.println("next3lastday " +year+"/"+next3month+"/"+"30");
				Date next3firstday = LmisUtils.convertStrtoDate(year+"/"+next3month+"/"+"01","yyyy/MM/dd");
				Date next3lastday = LmisUtils.convertStrtoDate(year+"/"+next3month+"/"+"30","yyyy/MM/dd");
				
				for (Integer rootid : listOfRootIds) {
					
					DynamicQuery Q = DynamicQueryFactoryUtil.forClass(LmisWorkingCalendars.class,PortletClassLoaderUtil.getClassLoader());
					Q.add(PropertyFactoryUtil.forName("rootId").eq(rootid));
					Q.add(PropertyFactoryUtil.forName("dayValue").ge(next3firstday));
					Q.add(PropertyFactoryUtil.forName("dayValue").le(next3lastday));
					
					
					List<Object> lsO = LmisWorkingCalendarsLocalServiceUtil.dynamicQuery(Q);
					if(lsO.size() ==0 || lsO ==null){
						LmisWorkingCalendarsLocalServiceUtil.workingcalendar(rootid, year, next3month);
					}
				}

		} catch (Exception e) {
		}
	}
}
