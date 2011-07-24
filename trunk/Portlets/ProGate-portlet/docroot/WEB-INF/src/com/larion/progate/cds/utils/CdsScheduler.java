package com.larion.progate.cds.utils;

import com.larion.progate.lmis.util.LmisJobExution;
import com.liferay.portal.kernel.job.Scheduler;

import com.liferay.portal.kernel.job.JobSchedulerUtil;

public class CdsScheduler implements Scheduler {

 public void schedule() {

  JobSchedulerUtil.schedule(_testIntervalJob);
 }

 public void unschedule() {

  JobSchedulerUtil.unschedule(_testIntervalJob);
 }


 private JobExcution _testIntervalJob = new JobExcution();
 private LmisJobExution _lmisIntervalJob = new LmisJobExution();
}