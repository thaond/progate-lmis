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

package larion.progate.lmis.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import larion.progate.lmis.model.LmisAttMonthly;
import larion.progate.lmis.model.LmisAttMonthlySoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisAttMonthlyModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAttMonthlyModelImpl extends BaseModelImpl<LmisAttMonthly> {
	public static final String TABLE_NAME = "lmis_attendance_monthly";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "year_value", new Integer(Types.INTEGER) },
			

			{ "month_value", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "user_id", new Integer(Types.INTEGER) },
			

			{ "total_working_day", new Integer(Types.INTEGER) },
			

			{ "num_day_award", new Integer(Types.DOUBLE) },
			

			{ "total_dayoff", new Integer(Types.DOUBLE) },
			

			{ "total_day_compensation", new Integer(Types.DOUBLE) },
			

			{ "total_dayoff_compensation", new Integer(Types.DOUBLE) },
			

			{ "start_time_average", new Integer(Types.TIMESTAMP) },
			

			{ "end_time_average", new Integer(Types.TIMESTAMP) },
			

			{ "total_time_late", new Integer(Types.INTEGER) },
			

			{ "total_time_late_penalty", new Integer(Types.INTEGER) },
			

			{ "total_time_early", new Integer(Types.INTEGER) },
			

			{ "total_time_early_penalty", new Integer(Types.INTEGER) },
			

			{ "total_day_overtime", new Integer(Types.INTEGER) },
			

			{ "total_time_late_final", new Integer(Types.DOUBLE) },
			

			{ "total_time_early_final", new Integer(Types.DOUBLE) },
			

			{ "total_working_time", new Integer(Types.DOUBLE) },
			

			{ "total_overtime", new Integer(Types.DOUBLE) },
			

			{ "total_overtime_final", new Integer(Types.DOUBLE) },
			

			{ "total_day_compensation_next_month", new Integer(Types.DOUBLE) },
			

			{ "total_time_final", new Integer(Types.DOUBLE) },
			

			{ "total_overtime_requested", new Integer(Types.DOUBLE) },
			

			{ "total_dayoff_permissive", new Integer(Types.DOUBLE) }
		};
	public static final String TABLE_SQL_CREATE = "create table lmis_attendance_monthly (id INTEGER not null primary key,year_value INTEGER,month_value INTEGER,root_id INTEGER,user_id INTEGER,total_working_day INTEGER,num_day_award DOUBLE,total_dayoff DOUBLE,total_day_compensation DOUBLE,total_dayoff_compensation DOUBLE,start_time_average DATE null,end_time_average DATE null,total_time_late INTEGER,total_time_late_penalty INTEGER,total_time_early INTEGER,total_time_early_penalty INTEGER,total_day_overtime INTEGER,total_time_late_final DOUBLE,total_time_early_final DOUBLE,total_working_time DOUBLE,total_overtime DOUBLE,total_overtime_final DOUBLE,total_day_compensation_next_month DOUBLE,total_time_final DOUBLE,total_overtime_requested DOUBLE,total_dayoff_permissive DOUBLE)";
	public static final String TABLE_SQL_DROP = "drop table lmis_attendance_monthly";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.lmis.model.LmisAttMonthly"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.lmis.model.LmisAttMonthly"),
			false);

	public static LmisAttMonthly toModel(LmisAttMonthlySoap soapModel) {
		LmisAttMonthly model = new LmisAttMonthlyImpl();

		model.setLmisAttMonthlysId(soapModel.getLmisAttMonthlysId());
		model.setYearValue(soapModel.getYearValue());
		model.setMonthValue(soapModel.getMonthValue());
		model.setRootId(soapModel.getRootId());
		model.setUserId(soapModel.getUserId());
		model.setTotalWorkingDay(soapModel.getTotalWorkingDay());
		model.setNumDayAward(soapModel.getNumDayAward());
		model.setTotalDayOff(soapModel.getTotalDayOff());
		model.setTotalDayCompensation(soapModel.getTotalDayCompensation());
		model.setTotalDayOffCompensation(soapModel.getTotalDayOffCompensation());
		model.setStartTimeAverage(soapModel.getStartTimeAverage());
		model.setEndTimeAverage(soapModel.getEndTimeAverage());
		model.setTotalTimeLate(soapModel.getTotalTimeLate());
		model.setTotalTimeLatePenalty(soapModel.getTotalTimeLatePenalty());
		model.setTotalTimeEarly(soapModel.getTotalTimeEarly());
		model.setTotalTimeEarlyPenalty(soapModel.getTotalTimeEarlyPenalty());
		model.setTotalDayOvertime(soapModel.getTotalDayOvertime());
		model.setTotalTimeLateFinal(soapModel.getTotalTimeLateFinal());
		model.setTotalTimeEarlyFinal(soapModel.getTotalTimeEarlyFinal());
		model.setTotalWorkingTime(soapModel.getTotalWorkingTime());
		model.setTotalOvertime(soapModel.getTotalOvertime());
		model.setTotalOvertimeFinal(soapModel.getTotalOvertimeFinal());
		model.setTotalDayCompensationNextMonth(soapModel.getTotalDayCompensationNextMonth());
		model.setTotalTimeFinal(soapModel.getTotalTimeFinal());
		model.setTotalOvertimeRequested(soapModel.getTotalOvertimeRequested());
		model.setTotalDayoffPermissive(soapModel.getTotalDayoffPermissive());

		return model;
	}

	public static List<LmisAttMonthly> toModels(LmisAttMonthlySoap[] soapModels) {
		List<LmisAttMonthly> models = new ArrayList<LmisAttMonthly>(soapModels.length);

		for (LmisAttMonthlySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.lmis.model.LmisAttMonthly"));

	public LmisAttMonthlyModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _lmisAttMonthlysId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisAttMonthlysId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisAttMonthlysId;
	}

	public Integer getLmisAttMonthlysId() {
		return _lmisAttMonthlysId;
	}

	public void setLmisAttMonthlysId(Integer lmisAttMonthlysId) {
		_lmisAttMonthlysId = lmisAttMonthlysId;
	}

	public int getYearValue() {
		return _yearValue;
	}

	public void setYearValue(int yearValue) {
		_yearValue = yearValue;
	}

	public int getMonthValue() {
		return _monthValue;
	}

	public void setMonthValue(int monthValue) {
		_monthValue = monthValue;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public int getTotalWorkingDay() {
		return _totalWorkingDay;
	}

	public void setTotalWorkingDay(int totalWorkingDay) {
		_totalWorkingDay = totalWorkingDay;
	}

	public double getNumDayAward() {
		return _numDayAward;
	}

	public void setNumDayAward(double numDayAward) {
		_numDayAward = numDayAward;
	}

	public double getTotalDayOff() {
		return _totalDayOff;
	}

	public void setTotalDayOff(double totalDayOff) {
		_totalDayOff = totalDayOff;
	}

	public double getTotalDayCompensation() {
		return _totalDayCompensation;
	}

	public void setTotalDayCompensation(double totalDayCompensation) {
		_totalDayCompensation = totalDayCompensation;
	}

	public double getTotalDayOffCompensation() {
		return _totalDayOffCompensation;
	}

	public void setTotalDayOffCompensation(double totalDayOffCompensation) {
		_totalDayOffCompensation = totalDayOffCompensation;
	}

	public Date getStartTimeAverage() {
		return _startTimeAverage;
	}

	public void setStartTimeAverage(Date startTimeAverage) {
		_startTimeAverage = startTimeAverage;
	}

	public Date getEndTimeAverage() {
		return _endTimeAverage;
	}

	public void setEndTimeAverage(Date endTimeAverage) {
		_endTimeAverage = endTimeAverage;
	}

	public int getTotalTimeLate() {
		return _totalTimeLate;
	}

	public void setTotalTimeLate(int totalTimeLate) {
		_totalTimeLate = totalTimeLate;
	}

	public int getTotalTimeLatePenalty() {
		return _totalTimeLatePenalty;
	}

	public void setTotalTimeLatePenalty(int totalTimeLatePenalty) {
		_totalTimeLatePenalty = totalTimeLatePenalty;
	}

	public int getTotalTimeEarly() {
		return _totalTimeEarly;
	}

	public void setTotalTimeEarly(int totalTimeEarly) {
		_totalTimeEarly = totalTimeEarly;
	}

	public int getTotalTimeEarlyPenalty() {
		return _totalTimeEarlyPenalty;
	}

	public void setTotalTimeEarlyPenalty(int totalTimeEarlyPenalty) {
		_totalTimeEarlyPenalty = totalTimeEarlyPenalty;
	}

	public int getTotalDayOvertime() {
		return _totalDayOvertime;
	}

	public void setTotalDayOvertime(int totalDayOvertime) {
		_totalDayOvertime = totalDayOvertime;
	}

	public double getTotalTimeLateFinal() {
		return _totalTimeLateFinal;
	}

	public void setTotalTimeLateFinal(double totalTimeLateFinal) {
		_totalTimeLateFinal = totalTimeLateFinal;
	}

	public double getTotalTimeEarlyFinal() {
		return _totalTimeEarlyFinal;
	}

	public void setTotalTimeEarlyFinal(double totalTimeEarlyFinal) {
		_totalTimeEarlyFinal = totalTimeEarlyFinal;
	}

	public double getTotalWorkingTime() {
		return _totalWorkingTime;
	}

	public void setTotalWorkingTime(double totalWorkingTime) {
		_totalWorkingTime = totalWorkingTime;
	}

	public double getTotalOvertime() {
		return _totalOvertime;
	}

	public void setTotalOvertime(double totalOvertime) {
		_totalOvertime = totalOvertime;
	}

	public double getTotalOvertimeFinal() {
		return _totalOvertimeFinal;
	}

	public void setTotalOvertimeFinal(double totalOvertimeFinal) {
		_totalOvertimeFinal = totalOvertimeFinal;
	}

	public double getTotalDayCompensationNextMonth() {
		return _totalDayCompensationNextMonth;
	}

	public void setTotalDayCompensationNextMonth(
		double totalDayCompensationNextMonth) {
		_totalDayCompensationNextMonth = totalDayCompensationNextMonth;
	}

	public double getTotalTimeFinal() {
		return _totalTimeFinal;
	}

	public void setTotalTimeFinal(double totalTimeFinal) {
		_totalTimeFinal = totalTimeFinal;
	}

	public double getTotalOvertimeRequested() {
		return _totalOvertimeRequested;
	}

	public void setTotalOvertimeRequested(double totalOvertimeRequested) {
		_totalOvertimeRequested = totalOvertimeRequested;
	}

	public double getTotalDayoffPermissive() {
		return _totalDayoffPermissive;
	}

	public void setTotalDayoffPermissive(double totalDayoffPermissive) {
		_totalDayoffPermissive = totalDayoffPermissive;
	}

	public LmisAttMonthly toEscapedModel() {
		if (isEscapedModel()) {
			return (LmisAttMonthly)this;
		}
		else {
			LmisAttMonthly model = new LmisAttMonthlyImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setLmisAttMonthlysId(getLmisAttMonthlysId());
			model.setYearValue(getYearValue());
			model.setMonthValue(getMonthValue());
			model.setRootId(getRootId());
			model.setUserId(getUserId());
			model.setTotalWorkingDay(getTotalWorkingDay());
			model.setNumDayAward(getNumDayAward());
			model.setTotalDayOff(getTotalDayOff());
			model.setTotalDayCompensation(getTotalDayCompensation());
			model.setTotalDayOffCompensation(getTotalDayOffCompensation());
			model.setStartTimeAverage(getStartTimeAverage());
			model.setEndTimeAverage(getEndTimeAverage());
			model.setTotalTimeLate(getTotalTimeLate());
			model.setTotalTimeLatePenalty(getTotalTimeLatePenalty());
			model.setTotalTimeEarly(getTotalTimeEarly());
			model.setTotalTimeEarlyPenalty(getTotalTimeEarlyPenalty());
			model.setTotalDayOvertime(getTotalDayOvertime());
			model.setTotalTimeLateFinal(getTotalTimeLateFinal());
			model.setTotalTimeEarlyFinal(getTotalTimeEarlyFinal());
			model.setTotalWorkingTime(getTotalWorkingTime());
			model.setTotalOvertime(getTotalOvertime());
			model.setTotalOvertimeFinal(getTotalOvertimeFinal());
			model.setTotalDayCompensationNextMonth(getTotalDayCompensationNextMonth());
			model.setTotalTimeFinal(getTotalTimeFinal());
			model.setTotalOvertimeRequested(getTotalOvertimeRequested());
			model.setTotalDayoffPermissive(getTotalDayoffPermissive());

			model = (LmisAttMonthly)Proxy.newProxyInstance(LmisAttMonthly.class.getClassLoader(),
					new Class[] { LmisAttMonthly.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisAttMonthlyImpl clone = new LmisAttMonthlyImpl();

		clone.setLmisAttMonthlysId(getLmisAttMonthlysId());
		clone.setYearValue(getYearValue());
		clone.setMonthValue(getMonthValue());
		clone.setRootId(getRootId());
		clone.setUserId(getUserId());
		clone.setTotalWorkingDay(getTotalWorkingDay());
		clone.setNumDayAward(getNumDayAward());
		clone.setTotalDayOff(getTotalDayOff());
		clone.setTotalDayCompensation(getTotalDayCompensation());
		clone.setTotalDayOffCompensation(getTotalDayOffCompensation());
		clone.setStartTimeAverage(getStartTimeAverage());
		clone.setEndTimeAverage(getEndTimeAverage());
		clone.setTotalTimeLate(getTotalTimeLate());
		clone.setTotalTimeLatePenalty(getTotalTimeLatePenalty());
		clone.setTotalTimeEarly(getTotalTimeEarly());
		clone.setTotalTimeEarlyPenalty(getTotalTimeEarlyPenalty());
		clone.setTotalDayOvertime(getTotalDayOvertime());
		clone.setTotalTimeLateFinal(getTotalTimeLateFinal());
		clone.setTotalTimeEarlyFinal(getTotalTimeEarlyFinal());
		clone.setTotalWorkingTime(getTotalWorkingTime());
		clone.setTotalOvertime(getTotalOvertime());
		clone.setTotalOvertimeFinal(getTotalOvertimeFinal());
		clone.setTotalDayCompensationNextMonth(getTotalDayCompensationNextMonth());
		clone.setTotalTimeFinal(getTotalTimeFinal());
		clone.setTotalOvertimeRequested(getTotalOvertimeRequested());
		clone.setTotalDayoffPermissive(getTotalDayoffPermissive());

		return clone;
	}

	public int compareTo(LmisAttMonthly lmisAttMonthly) {
		Integer pk = lmisAttMonthly.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisAttMonthly lmisAttMonthly = null;

		try {
			lmisAttMonthly = (LmisAttMonthly)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisAttMonthly.getPrimaryKey();

		if (getPrimaryKey().equals(pk)) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("{lmisAttMonthlysId=");
		sb.append(getLmisAttMonthlysId());
		sb.append(", yearValue=");
		sb.append(getYearValue());
		sb.append(", monthValue=");
		sb.append(getMonthValue());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", totalWorkingDay=");
		sb.append(getTotalWorkingDay());
		sb.append(", numDayAward=");
		sb.append(getNumDayAward());
		sb.append(", totalDayOff=");
		sb.append(getTotalDayOff());
		sb.append(", totalDayCompensation=");
		sb.append(getTotalDayCompensation());
		sb.append(", totalDayOffCompensation=");
		sb.append(getTotalDayOffCompensation());
		sb.append(", startTimeAverage=");
		sb.append(getStartTimeAverage());
		sb.append(", endTimeAverage=");
		sb.append(getEndTimeAverage());
		sb.append(", totalTimeLate=");
		sb.append(getTotalTimeLate());
		sb.append(", totalTimeLatePenalty=");
		sb.append(getTotalTimeLatePenalty());
		sb.append(", totalTimeEarly=");
		sb.append(getTotalTimeEarly());
		sb.append(", totalTimeEarlyPenalty=");
		sb.append(getTotalTimeEarlyPenalty());
		sb.append(", totalDayOvertime=");
		sb.append(getTotalDayOvertime());
		sb.append(", totalTimeLateFinal=");
		sb.append(getTotalTimeLateFinal());
		sb.append(", totalTimeEarlyFinal=");
		sb.append(getTotalTimeEarlyFinal());
		sb.append(", totalWorkingTime=");
		sb.append(getTotalWorkingTime());
		sb.append(", totalOvertime=");
		sb.append(getTotalOvertime());
		sb.append(", totalOvertimeFinal=");
		sb.append(getTotalOvertimeFinal());
		sb.append(", totalDayCompensationNextMonth=");
		sb.append(getTotalDayCompensationNextMonth());
		sb.append(", totalTimeFinal=");
		sb.append(getTotalTimeFinal());
		sb.append(", totalOvertimeRequested=");
		sb.append(getTotalOvertimeRequested());
		sb.append(", totalDayoffPermissive=");
		sb.append(getTotalDayoffPermissive());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisAttMonthly");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisAttMonthlysId</column-name><column-value><![CDATA[");
		sb.append(getLmisAttMonthlysId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yearValue</column-name><column-value><![CDATA[");
		sb.append(getYearValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>monthValue</column-name><column-value><![CDATA[");
		sb.append(getMonthValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalWorkingDay</column-name><column-value><![CDATA[");
		sb.append(getTotalWorkingDay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numDayAward</column-name><column-value><![CDATA[");
		sb.append(getNumDayAward());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalDayOff</column-name><column-value><![CDATA[");
		sb.append(getTotalDayOff());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalDayCompensation</column-name><column-value><![CDATA[");
		sb.append(getTotalDayCompensation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalDayOffCompensation</column-name><column-value><![CDATA[");
		sb.append(getTotalDayOffCompensation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startTimeAverage</column-name><column-value><![CDATA[");
		sb.append(getStartTimeAverage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endTimeAverage</column-name><column-value><![CDATA[");
		sb.append(getEndTimeAverage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalTimeLate</column-name><column-value><![CDATA[");
		sb.append(getTotalTimeLate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalTimeLatePenalty</column-name><column-value><![CDATA[");
		sb.append(getTotalTimeLatePenalty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalTimeEarly</column-name><column-value><![CDATA[");
		sb.append(getTotalTimeEarly());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalTimeEarlyPenalty</column-name><column-value><![CDATA[");
		sb.append(getTotalTimeEarlyPenalty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalDayOvertime</column-name><column-value><![CDATA[");
		sb.append(getTotalDayOvertime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalTimeLateFinal</column-name><column-value><![CDATA[");
		sb.append(getTotalTimeLateFinal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalTimeEarlyFinal</column-name><column-value><![CDATA[");
		sb.append(getTotalTimeEarlyFinal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalWorkingTime</column-name><column-value><![CDATA[");
		sb.append(getTotalWorkingTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalOvertime</column-name><column-value><![CDATA[");
		sb.append(getTotalOvertime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalOvertimeFinal</column-name><column-value><![CDATA[");
		sb.append(getTotalOvertimeFinal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalDayCompensationNextMonth</column-name><column-value><![CDATA[");
		sb.append(getTotalDayCompensationNextMonth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalTimeFinal</column-name><column-value><![CDATA[");
		sb.append(getTotalTimeFinal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalOvertimeRequested</column-name><column-value><![CDATA[");
		sb.append(getTotalOvertimeRequested());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalDayoffPermissive</column-name><column-value><![CDATA[");
		sb.append(getTotalDayoffPermissive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisAttMonthlysId;
	private int _yearValue;
	private int _monthValue;
	private int _rootId;
	private int _userId;
	private int _totalWorkingDay;
	private double _numDayAward;
	private double _totalDayOff;
	private double _totalDayCompensation;
	private double _totalDayOffCompensation;
	private Date _startTimeAverage;
	private Date _endTimeAverage;
	private int _totalTimeLate;
	private int _totalTimeLatePenalty;
	private int _totalTimeEarly;
	private int _totalTimeEarlyPenalty;
	private int _totalDayOvertime;
	private double _totalTimeLateFinal;
	private double _totalTimeEarlyFinal;
	private double _totalWorkingTime;
	private double _totalOvertime;
	private double _totalOvertimeFinal;
	private double _totalDayCompensationNextMonth;
	private double _totalTimeFinal;
	private double _totalOvertimeRequested;
	private double _totalDayoffPermissive;
}