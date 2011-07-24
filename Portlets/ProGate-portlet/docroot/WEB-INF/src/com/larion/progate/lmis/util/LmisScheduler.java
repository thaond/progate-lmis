package com.larion.progate.lmis.util;

import com.larion.progate.cds.utils.JobExcution;
import com.liferay.portal.kernel.job.JobSchedulerUtil;
import com.liferay.portal.kernel.job.Scheduler;

public class LmisScheduler implements Scheduler {
	 public void schedule() {

		  JobSchedulerUtil.schedule(_testIntervalJob);
		 }

		 public void unschedule() {

		  JobSchedulerUtil.unschedule(_testIntervalJob);
		 }


		 private JobExcution _testIntervalJob = new JobExcution();
}
