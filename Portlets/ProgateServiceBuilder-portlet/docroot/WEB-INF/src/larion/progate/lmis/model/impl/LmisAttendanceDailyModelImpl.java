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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import larion.progate.lmis.model.LmisAttendanceDaily;
import larion.progate.lmis.model.LmisAttendanceDailySoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisAttendanceDailyModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAttendanceDailyModelImpl extends BaseModelImpl<LmisAttendanceDaily> {
	public static final String TABLE_NAME = "lmis_attendance_daily";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "day_value", new Integer(Types.TIMESTAMP) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "user_id", new Integer(Types.INTEGER) },
			

			{ "absence_value", new Integer(Types.DOUBLE) },
			

			{ "is_permissive", new Integer(Types.BOOLEAN) },
			

			{ "absence_reason", new Integer(Types.VARCHAR) },
			

			{ "absence_reason_id", new Integer(Types.INTEGER) },
			

			{ "plan_start_time", new Integer(Types.TIMESTAMP) },
			

			{ "real_start_time", new Integer(Types.TIMESTAMP) },
			

			{ "time_late", new Integer(Types.INTEGER) },
			

			{ "time_late_penalty", new Integer(Types.INTEGER) },
			

			{ "time_late_final", new Integer(Types.DOUBLE) },
			

			{ "plan_end_time", new Integer(Types.TIMESTAMP) },
			

			{ "real_end_time", new Integer(Types.TIMESTAMP) },
			

			{ "time_early", new Integer(Types.INTEGER) },
			

			{ "time_early_penalty", new Integer(Types.INTEGER) },
			

			{ "time_early_final", new Integer(Types.DOUBLE) },
			

			{ "overtime_value", new Integer(Types.VARCHAR) },
			

			{ "total_working_time", new Integer(Types.DOUBLE) },
			

			{ "total_overtime", new Integer(Types.DOUBLE) },
			

			{ "total_overtime_final", new Integer(Types.DOUBLE) },
			

			{ "total_time_final", new Integer(Types.DOUBLE) },
			

			{ "comment", new Integer(Types.VARCHAR) },
			

			{ "created_at", new Integer(Types.TIMESTAMP) },
			

			{ "created_by", new Integer(Types.INTEGER) },
			

			{ "updated_at", new Integer(Types.TIMESTAMP) },
			

			{ "updated_by", new Integer(Types.INTEGER) },
			

			{ "total_overtime_requested", new Integer(Types.DOUBLE) },
			

			{ "absence", new Integer(Types.INTEGER) }
		};
	public static final String TABLE_SQL_CREATE = "create table lmis_attendance_daily (id INTEGER not null primary key,day_value DATE null,root_id INTEGER,user_id INTEGER,absence_value DOUBLE,is_permissive BOOLEAN,absence_reason VARCHAR(75) null,absence_reason_id INTEGER,plan_start_time DATE null,real_start_time DATE null,time_late INTEGER,time_late_penalty INTEGER,time_late_final DOUBLE,plan_end_time DATE null,real_end_time DATE null,time_early INTEGER,time_early_penalty INTEGER,time_early_final DOUBLE,overtime_value VARCHAR(75) null,total_working_time DOUBLE,total_overtime DOUBLE,total_overtime_final DOUBLE,total_time_final DOUBLE,comment VARCHAR(75) null,created_at DATE null,created_by INTEGER,updated_at DATE null,updated_by INTEGER,total_overtime_requested DOUBLE,absence INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table lmis_attendance_daily";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.lmis.model.LmisAttendanceDaily"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.lmis.model.LmisAttendanceDaily"),
			false);

	public static LmisAttendanceDaily toModel(LmisAttendanceDailySoap soapModel) {
		LmisAttendanceDaily model = new LmisAttendanceDailyImpl();

		model.setLmisAttendanceDailyId(soapModel.getLmisAttendanceDailyId());
		model.setDayValue(soapModel.getDayValue());
		model.setRootId(soapModel.getRootId());
		model.setUserId(soapModel.getUserId());
		model.setAbsenceValue(soapModel.getAbsenceValue());
		model.setIsPermissive(soapModel.getIsPermissive());
		model.setAbsenceReason(soapModel.getAbsenceReason());
		model.setAbsenceReasonId(soapModel.getAbsenceReasonId());
		model.setPlanStartTime(soapModel.getPlanStartTime());
		model.setRealStartTime(soapModel.getRealStartTime());
		model.setTimeLate(soapModel.getTimeLate());
		model.setTimeLatePenalty(soapModel.getTimeLatePenalty());
		model.setTimeLateFinal(soapModel.getTimeLateFinal());
		model.setPlanEndTime(soapModel.getPlanEndTime());
		model.setRealEndTime(soapModel.getRealEndTime());
		model.setTimeEarly(soapModel.getTimeEarly());
		model.setTimeEarlyPenalty(soapModel.getTimeEarlyPenalty());
		model.setTimeEarlyFinal(soapModel.getTimeEarlyFinal());
		model.setOvertimeValue(soapModel.getOvertimeValue());
		model.setTotalWorkingTime(soapModel.getTotalWorkingTime());
		model.setTotalOvertime(soapModel.getTotalOvertime());
		model.setTotalOvertimeFinal(soapModel.getTotalOvertimeFinal());
		model.setTotalTimeFinal(soapModel.getTotalTimeFinal());
		model.setComMent(soapModel.getComMent());
		model.setCreatedAt(soapModel.getCreatedAt());
		model.setCreatedBy(soapModel.getCreatedBy());
		model.setUpdatedAt(soapModel.getUpdatedAt());
		model.setUpdated_by(soapModel.getUpdated_by());
		model.setTotalOvertimeRequested(soapModel.getTotalOvertimeRequested());
		model.setAbsence_(soapModel.getAbsence_());

		return model;
	}

	public static List<LmisAttendanceDaily> toModels(
		LmisAttendanceDailySoap[] soapModels) {
		List<LmisAttendanceDaily> models = new ArrayList<LmisAttendanceDaily>(soapModels.length);

		for (LmisAttendanceDailySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.lmis.model.LmisAttendanceDaily"));

	public LmisAttendanceDailyModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _lmisAttendanceDailyId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisAttendanceDailyId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisAttendanceDailyId;
	}

	public Integer getLmisAttendanceDailyId() {
		return _lmisAttendanceDailyId;
	}

	public void setLmisAttendanceDailyId(Integer lmisAttendanceDailyId) {
		_lmisAttendanceDailyId = lmisAttendanceDailyId;
	}

	public Date getDayValue() {
		return _dayValue;
	}

	public void setDayValue(Date dayValue) {
		_dayValue = dayValue;
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

	public double getAbsenceValue() {
		return _absenceValue;
	}

	public void setAbsenceValue(double absenceValue) {
		_absenceValue = absenceValue;
	}

	public boolean getIsPermissive() {
		return _isPermissive;
	}

	public boolean isIsPermissive() {
		return _isPermissive;
	}

	public void setIsPermissive(boolean isPermissive) {
		_isPermissive = isPermissive;
	}

	public String getAbsenceReason() {
		return GetterUtil.getString(_absenceReason);
	}

	public void setAbsenceReason(String absenceReason) {
		_absenceReason = absenceReason;
	}

	public int getAbsenceReasonId() {
		return _absenceReasonId;
	}

	public void setAbsenceReasonId(int absenceReasonId) {
		_absenceReasonId = absenceReasonId;
	}

	public Date getPlanStartTime() {
		return _planStartTime;
	}

	public void setPlanStartTime(Date planStartTime) {
		_planStartTime = planStartTime;
	}

	public Date getRealStartTime() {
		return _realStartTime;
	}

	public void setRealStartTime(Date realStartTime) {
		_realStartTime = realStartTime;
	}

	public int getTimeLate() {
		return _timeLate;
	}

	public void setTimeLate(int timeLate) {
		_timeLate = timeLate;
	}

	public int getTimeLatePenalty() {
		return _timeLatePenalty;
	}

	public void setTimeLatePenalty(int timeLatePenalty) {
		_timeLatePenalty = timeLatePenalty;
	}

	public double getTimeLateFinal() {
		return _timeLateFinal;
	}

	public void setTimeLateFinal(double timeLateFinal) {
		_timeLateFinal = timeLateFinal;
	}

	public Date getPlanEndTime() {
		return _planEndTime;
	}

	public void setPlanEndTime(Date planEndTime) {
		_planEndTime = planEndTime;
	}

	public Date getRealEndTime() {
		return _realEndTime;
	}

	public void setRealEndTime(Date realEndTime) {
		_realEndTime = realEndTime;
	}

	public int getTimeEarly() {
		return _timeEarly;
	}

	public void setTimeEarly(int timeEarly) {
		_timeEarly = timeEarly;
	}

	public int getTimeEarlyPenalty() {
		return _timeEarlyPenalty;
	}

	public void setTimeEarlyPenalty(int timeEarlyPenalty) {
		_timeEarlyPenalty = timeEarlyPenalty;
	}

	public double getTimeEarlyFinal() {
		return _timeEarlyFinal;
	}

	public void setTimeEarlyFinal(double timeEarlyFinal) {
		_timeEarlyFinal = timeEarlyFinal;
	}

	public String getOvertimeValue() {
		return GetterUtil.getString(_overtimeValue);
	}

	public void setOvertimeValue(String overtimeValue) {
		_overtimeValue = overtimeValue;
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

	public double getTotalTimeFinal() {
		return _totalTimeFinal;
	}

	public void setTotalTimeFinal(double totalTimeFinal) {
		_totalTimeFinal = totalTimeFinal;
	}

	public String getComMent() {
		return GetterUtil.getString(_comMent);
	}

	public void setComMent(String comMent) {
		_comMent = comMent;
	}

	public Date getCreatedAt() {
		return _createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		_createdAt = createdAt;
	}

	public int getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(int createdBy) {
		_createdBy = createdBy;
	}

	public Date getUpdatedAt() {
		return _updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		_updatedAt = updatedAt;
	}

	public int getUpdated_by() {
		return _updated_by;
	}

	public void setUpdated_by(int updated_by) {
		_updated_by = updated_by;
	}

	public double getTotalOvertimeRequested() {
		return _totalOvertimeRequested;
	}

	public void setTotalOvertimeRequested(double totalOvertimeRequested) {
		_totalOvertimeRequested = totalOvertimeRequested;
	}

	public int getAbsence_() {
		return _absence_;
	}

	public void setAbsence_(int absence_) {
		_absence_ = absence_;
	}

	public LmisAttendanceDaily toEscapedModel() {
		if (isEscapedModel()) {
			return (LmisAttendanceDaily)this;
		}
		else {
			LmisAttendanceDaily model = new LmisAttendanceDailyImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setLmisAttendanceDailyId(getLmisAttendanceDailyId());
			model.setDayValue(getDayValue());
			model.setRootId(getRootId());
			model.setUserId(getUserId());
			model.setAbsenceValue(getAbsenceValue());
			model.setIsPermissive(getIsPermissive());
			model.setAbsenceReason(HtmlUtil.escape(getAbsenceReason()));
			model.setAbsenceReasonId(getAbsenceReasonId());
			model.setPlanStartTime(getPlanStartTime());
			model.setRealStartTime(getRealStartTime());
			model.setTimeLate(getTimeLate());
			model.setTimeLatePenalty(getTimeLatePenalty());
			model.setTimeLateFinal(getTimeLateFinal());
			model.setPlanEndTime(getPlanEndTime());
			model.setRealEndTime(getRealEndTime());
			model.setTimeEarly(getTimeEarly());
			model.setTimeEarlyPenalty(getTimeEarlyPenalty());
			model.setTimeEarlyFinal(getTimeEarlyFinal());
			model.setOvertimeValue(HtmlUtil.escape(getOvertimeValue()));
			model.setTotalWorkingTime(getTotalWorkingTime());
			model.setTotalOvertime(getTotalOvertime());
			model.setTotalOvertimeFinal(getTotalOvertimeFinal());
			model.setTotalTimeFinal(getTotalTimeFinal());
			model.setComMent(HtmlUtil.escape(getComMent()));
			model.setCreatedAt(getCreatedAt());
			model.setCreatedBy(getCreatedBy());
			model.setUpdatedAt(getUpdatedAt());
			model.setUpdated_by(getUpdated_by());
			model.setTotalOvertimeRequested(getTotalOvertimeRequested());
			model.setAbsence_(getAbsence_());

			model = (LmisAttendanceDaily)Proxy.newProxyInstance(LmisAttendanceDaily.class.getClassLoader(),
					new Class[] { LmisAttendanceDaily.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisAttendanceDailyImpl clone = new LmisAttendanceDailyImpl();

		clone.setLmisAttendanceDailyId(getLmisAttendanceDailyId());
		clone.setDayValue(getDayValue());
		clone.setRootId(getRootId());
		clone.setUserId(getUserId());
		clone.setAbsenceValue(getAbsenceValue());
		clone.setIsPermissive(getIsPermissive());
		clone.setAbsenceReason(getAbsenceReason());
		clone.setAbsenceReasonId(getAbsenceReasonId());
		clone.setPlanStartTime(getPlanStartTime());
		clone.setRealStartTime(getRealStartTime());
		clone.setTimeLate(getTimeLate());
		clone.setTimeLatePenalty(getTimeLatePenalty());
		clone.setTimeLateFinal(getTimeLateFinal());
		clone.setPlanEndTime(getPlanEndTime());
		clone.setRealEndTime(getRealEndTime());
		clone.setTimeEarly(getTimeEarly());
		clone.setTimeEarlyPenalty(getTimeEarlyPenalty());
		clone.setTimeEarlyFinal(getTimeEarlyFinal());
		clone.setOvertimeValue(getOvertimeValue());
		clone.setTotalWorkingTime(getTotalWorkingTime());
		clone.setTotalOvertime(getTotalOvertime());
		clone.setTotalOvertimeFinal(getTotalOvertimeFinal());
		clone.setTotalTimeFinal(getTotalTimeFinal());
		clone.setComMent(getComMent());
		clone.setCreatedAt(getCreatedAt());
		clone.setCreatedBy(getCreatedBy());
		clone.setUpdatedAt(getUpdatedAt());
		clone.setUpdated_by(getUpdated_by());
		clone.setTotalOvertimeRequested(getTotalOvertimeRequested());
		clone.setAbsence_(getAbsence_());

		return clone;
	}

	public int compareTo(LmisAttendanceDaily lmisAttendanceDaily) {
		int value = 0;

		value = DateUtil.compareTo(getDayValue(),
				lmisAttendanceDaily.getDayValue());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisAttendanceDaily lmisAttendanceDaily = null;

		try {
			lmisAttendanceDaily = (LmisAttendanceDaily)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisAttendanceDaily.getPrimaryKey();

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

		sb.append("{lmisAttendanceDailyId=");
		sb.append(getLmisAttendanceDailyId());
		sb.append(", dayValue=");
		sb.append(getDayValue());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", absenceValue=");
		sb.append(getAbsenceValue());
		sb.append(", isPermissive=");
		sb.append(getIsPermissive());
		sb.append(", absenceReason=");
		sb.append(getAbsenceReason());
		sb.append(", absenceReasonId=");
		sb.append(getAbsenceReasonId());
		sb.append(", planStartTime=");
		sb.append(getPlanStartTime());
		sb.append(", realStartTime=");
		sb.append(getRealStartTime());
		sb.append(", timeLate=");
		sb.append(getTimeLate());
		sb.append(", timeLatePenalty=");
		sb.append(getTimeLatePenalty());
		sb.append(", timeLateFinal=");
		sb.append(getTimeLateFinal());
		sb.append(", planEndTime=");
		sb.append(getPlanEndTime());
		sb.append(", realEndTime=");
		sb.append(getRealEndTime());
		sb.append(", timeEarly=");
		sb.append(getTimeEarly());
		sb.append(", timeEarlyPenalty=");
		sb.append(getTimeEarlyPenalty());
		sb.append(", timeEarlyFinal=");
		sb.append(getTimeEarlyFinal());
		sb.append(", overtimeValue=");
		sb.append(getOvertimeValue());
		sb.append(", totalWorkingTime=");
		sb.append(getTotalWorkingTime());
		sb.append(", totalOvertime=");
		sb.append(getTotalOvertime());
		sb.append(", totalOvertimeFinal=");
		sb.append(getTotalOvertimeFinal());
		sb.append(", totalTimeFinal=");
		sb.append(getTotalTimeFinal());
		sb.append(", comMent=");
		sb.append(getComMent());
		sb.append(", createdAt=");
		sb.append(getCreatedAt());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", updatedAt=");
		sb.append(getUpdatedAt());
		sb.append(", updated_by=");
		sb.append(getUpdated_by());
		sb.append(", totalOvertimeRequested=");
		sb.append(getTotalOvertimeRequested());
		sb.append(", absence_=");
		sb.append(getAbsence_());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisAttendanceDaily");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisAttendanceDailyId</column-name><column-value><![CDATA[");
		sb.append(getLmisAttendanceDailyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dayValue</column-name><column-value><![CDATA[");
		sb.append(getDayValue());
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
			"<column><column-name>absenceValue</column-name><column-value><![CDATA[");
		sb.append(getAbsenceValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isPermissive</column-name><column-value><![CDATA[");
		sb.append(getIsPermissive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>absenceReason</column-name><column-value><![CDATA[");
		sb.append(getAbsenceReason());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>absenceReasonId</column-name><column-value><![CDATA[");
		sb.append(getAbsenceReasonId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>planStartTime</column-name><column-value><![CDATA[");
		sb.append(getPlanStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>realStartTime</column-name><column-value><![CDATA[");
		sb.append(getRealStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>timeLate</column-name><column-value><![CDATA[");
		sb.append(getTimeLate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>timeLatePenalty</column-name><column-value><![CDATA[");
		sb.append(getTimeLatePenalty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>timeLateFinal</column-name><column-value><![CDATA[");
		sb.append(getTimeLateFinal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>planEndTime</column-name><column-value><![CDATA[");
		sb.append(getPlanEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>realEndTime</column-name><column-value><![CDATA[");
		sb.append(getRealEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>timeEarly</column-name><column-value><![CDATA[");
		sb.append(getTimeEarly());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>timeEarlyPenalty</column-name><column-value><![CDATA[");
		sb.append(getTimeEarlyPenalty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>timeEarlyFinal</column-name><column-value><![CDATA[");
		sb.append(getTimeEarlyFinal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>overtimeValue</column-name><column-value><![CDATA[");
		sb.append(getOvertimeValue());
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
			"<column><column-name>totalTimeFinal</column-name><column-value><![CDATA[");
		sb.append(getTotalTimeFinal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comMent</column-name><column-value><![CDATA[");
		sb.append(getComMent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdAt</column-name><column-value><![CDATA[");
		sb.append(getCreatedAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updatedAt</column-name><column-value><![CDATA[");
		sb.append(getUpdatedAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updated_by</column-name><column-value><![CDATA[");
		sb.append(getUpdated_by());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalOvertimeRequested</column-name><column-value><![CDATA[");
		sb.append(getTotalOvertimeRequested());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>absence_</column-name><column-value><![CDATA[");
		sb.append(getAbsence_());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisAttendanceDailyId;
	private Date _dayValue;
	private int _rootId;
	private int _userId;
	private double _absenceValue;
	private boolean _isPermissive;
	private String _absenceReason;
	private int _absenceReasonId;
	private Date _planStartTime;
	private Date _realStartTime;
	private int _timeLate;
	private int _timeLatePenalty;
	private double _timeLateFinal;
	private Date _planEndTime;
	private Date _realEndTime;
	private int _timeEarly;
	private int _timeEarlyPenalty;
	private double _timeEarlyFinal;
	private String _overtimeValue;
	private double _totalWorkingTime;
	private double _totalOvertime;
	private double _totalOvertimeFinal;
	private double _totalTimeFinal;
	private String _comMent;
	private Date _createdAt;
	private int _createdBy;
	private Date _updatedAt;
	private int _updated_by;
	private double _totalOvertimeRequested;
	private int _absence_;
}