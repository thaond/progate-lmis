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

import larion.progate.lmis.model.LmisViewAttdance;
import larion.progate.lmis.model.LmisViewAttdanceSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisViewAttdanceModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewAttdanceModelImpl extends BaseModelImpl<LmisViewAttdance> {
	public static final String TABLE_NAME = "vw_attendance";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "day_value", new Integer(Types.TIMESTAMP) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "user_id", new Integer(Types.INTEGER) },
			

			{ "absence_value", new Integer(Types.DOUBLE) },
			

			{ "is_permissive", new Integer(Types.BOOLEAN) },
			

			{ "absence_type", new Integer(Types.VARCHAR) },
			

			{ "absence_type_id", new Integer(Types.INTEGER) },
			

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
			

			{ "created_at", new Integer(Types.TIMESTAMP) },
			

			{ "created_by", new Integer(Types.INTEGER) },
			

			{ "updated_at", new Integer(Types.TIMESTAMP) },
			

			{ "updated_by", new Integer(Types.INTEGER) },
			

			{ "last_name", new Integer(Types.VARCHAR) },
			

			{ "total_overtime_requested", new Integer(Types.DOUBLE) },
			

			{ "absence", new Integer(Types.INTEGER) },
			

			{ "full_name", new Integer(Types.VARCHAR) },
			

			{ "staff_code", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table vw_attendance (id INTEGER not null primary key,day_value DATE null,root_id INTEGER,user_id INTEGER,absence_value DOUBLE,is_permissive BOOLEAN,absence_type VARCHAR(75) null,absence_type_id INTEGER,plan_start_time DATE null,real_start_time DATE null,time_late INTEGER,time_late_penalty INTEGER,time_late_final DOUBLE,plan_end_time DATE null,real_end_time DATE null,time_early INTEGER,time_early_penalty INTEGER,time_early_final DOUBLE,overtime_value VARCHAR(75) null,total_working_time DOUBLE,total_overtime DOUBLE,total_overtime_final DOUBLE,total_time_final DOUBLE,created_at DATE null,created_by INTEGER,updated_at DATE null,updated_by INTEGER,last_name VARCHAR(75) null,total_overtime_requested DOUBLE,absence INTEGER,full_name VARCHAR(75) null,staff_code VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table vw_attendance";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.lmis.model.LmisViewAttdance"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.lmis.model.LmisViewAttdance"),
			false);

	public static LmisViewAttdance toModel(LmisViewAttdanceSoap soapModel) {
		LmisViewAttdance model = new LmisViewAttdanceImpl();

		model.setLmisViewAttDailyId(soapModel.getLmisViewAttDailyId());
		model.setDayValue(soapModel.getDayValue());
		model.setRootId(soapModel.getRootId());
		model.setUserId(soapModel.getUserId());
		model.setAbsenceValue(soapModel.getAbsenceValue());
		model.setIsPermissive(soapModel.getIsPermissive());
		model.setAbsenceType(soapModel.getAbsenceType());
		model.setAbsenceTypeId(soapModel.getAbsenceTypeId());
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
		model.setOverTimeValue(soapModel.getOverTimeValue());
		model.setTotalWorkingTime(soapModel.getTotalWorkingTime());
		model.setTotalOverTime(soapModel.getTotalOverTime());
		model.setTotalOverTimeFinal(soapModel.getTotalOverTimeFinal());
		model.setTotalTimeFinal(soapModel.getTotalTimeFinal());
		model.setCreatedAt(soapModel.getCreatedAt());
		model.setCreatedBy(soapModel.getCreatedBy());
		model.setUpdatedAt(soapModel.getUpdatedAt());
		model.setUpdatedBy(soapModel.getUpdatedBy());
		model.setLastname(soapModel.getLastname());
		model.setTotalOverTimeRequested(soapModel.getTotalOverTimeRequested());
		model.setAbSence(soapModel.getAbSence());
		model.setFullName(soapModel.getFullName());
		model.setStaffCode(soapModel.getStaffCode());

		return model;
	}

	public static List<LmisViewAttdance> toModels(
		LmisViewAttdanceSoap[] soapModels) {
		List<LmisViewAttdance> models = new ArrayList<LmisViewAttdance>(soapModels.length);

		for (LmisViewAttdanceSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.lmis.model.LmisViewAttdance"));

	public LmisViewAttdanceModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _lmisViewAttDailyId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisViewAttDailyId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisViewAttDailyId;
	}

	public Integer getLmisViewAttDailyId() {
		return _lmisViewAttDailyId;
	}

	public void setLmisViewAttDailyId(Integer lmisViewAttDailyId) {
		_lmisViewAttDailyId = lmisViewAttDailyId;
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

	public String getAbsenceType() {
		return GetterUtil.getString(_absenceType);
	}

	public void setAbsenceType(String absenceType) {
		_absenceType = absenceType;
	}

	public int getAbsenceTypeId() {
		return _absenceTypeId;
	}

	public void setAbsenceTypeId(int absenceTypeId) {
		_absenceTypeId = absenceTypeId;
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

	public String getOverTimeValue() {
		return GetterUtil.getString(_overTimeValue);
	}

	public void setOverTimeValue(String overTimeValue) {
		_overTimeValue = overTimeValue;
	}

	public double getTotalWorkingTime() {
		return _totalWorkingTime;
	}

	public void setTotalWorkingTime(double totalWorkingTime) {
		_totalWorkingTime = totalWorkingTime;
	}

	public double getTotalOverTime() {
		return _totalOverTime;
	}

	public void setTotalOverTime(double totalOverTime) {
		_totalOverTime = totalOverTime;
	}

	public double getTotalOverTimeFinal() {
		return _totalOverTimeFinal;
	}

	public void setTotalOverTimeFinal(double totalOverTimeFinal) {
		_totalOverTimeFinal = totalOverTimeFinal;
	}

	public double getTotalTimeFinal() {
		return _totalTimeFinal;
	}

	public void setTotalTimeFinal(double totalTimeFinal) {
		_totalTimeFinal = totalTimeFinal;
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

	public int getUpdatedBy() {
		return _updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		_updatedBy = updatedBy;
	}

	public String getLastname() {
		return GetterUtil.getString(_lastname);
	}

	public void setLastname(String lastname) {
		_lastname = lastname;
	}

	public double getTotalOverTimeRequested() {
		return _totalOverTimeRequested;
	}

	public void setTotalOverTimeRequested(double totalOverTimeRequested) {
		_totalOverTimeRequested = totalOverTimeRequested;
	}

	public int getAbSence() {
		return _abSence;
	}

	public void setAbSence(int abSence) {
		_abSence = abSence;
	}

	public String getFullName() {
		return GetterUtil.getString(_fullName);
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public String getStaffCode() {
		return GetterUtil.getString(_staffCode);
	}

	public void setStaffCode(String staffCode) {
		_staffCode = staffCode;
	}

	public LmisViewAttdance toEscapedModel() {
		if (isEscapedModel()) {
			return (LmisViewAttdance)this;
		}
		else {
			LmisViewAttdance model = new LmisViewAttdanceImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setLmisViewAttDailyId(getLmisViewAttDailyId());
			model.setDayValue(getDayValue());
			model.setRootId(getRootId());
			model.setUserId(getUserId());
			model.setAbsenceValue(getAbsenceValue());
			model.setIsPermissive(getIsPermissive());
			model.setAbsenceType(HtmlUtil.escape(getAbsenceType()));
			model.setAbsenceTypeId(getAbsenceTypeId());
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
			model.setOverTimeValue(HtmlUtil.escape(getOverTimeValue()));
			model.setTotalWorkingTime(getTotalWorkingTime());
			model.setTotalOverTime(getTotalOverTime());
			model.setTotalOverTimeFinal(getTotalOverTimeFinal());
			model.setTotalTimeFinal(getTotalTimeFinal());
			model.setCreatedAt(getCreatedAt());
			model.setCreatedBy(getCreatedBy());
			model.setUpdatedAt(getUpdatedAt());
			model.setUpdatedBy(getUpdatedBy());
			model.setLastname(HtmlUtil.escape(getLastname()));
			model.setTotalOverTimeRequested(getTotalOverTimeRequested());
			model.setAbSence(getAbSence());
			model.setFullName(HtmlUtil.escape(getFullName()));
			model.setStaffCode(HtmlUtil.escape(getStaffCode()));

			model = (LmisViewAttdance)Proxy.newProxyInstance(LmisViewAttdance.class.getClassLoader(),
					new Class[] { LmisViewAttdance.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisViewAttdanceImpl clone = new LmisViewAttdanceImpl();

		clone.setLmisViewAttDailyId(getLmisViewAttDailyId());
		clone.setDayValue(getDayValue());
		clone.setRootId(getRootId());
		clone.setUserId(getUserId());
		clone.setAbsenceValue(getAbsenceValue());
		clone.setIsPermissive(getIsPermissive());
		clone.setAbsenceType(getAbsenceType());
		clone.setAbsenceTypeId(getAbsenceTypeId());
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
		clone.setOverTimeValue(getOverTimeValue());
		clone.setTotalWorkingTime(getTotalWorkingTime());
		clone.setTotalOverTime(getTotalOverTime());
		clone.setTotalOverTimeFinal(getTotalOverTimeFinal());
		clone.setTotalTimeFinal(getTotalTimeFinal());
		clone.setCreatedAt(getCreatedAt());
		clone.setCreatedBy(getCreatedBy());
		clone.setUpdatedAt(getUpdatedAt());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setLastname(getLastname());
		clone.setTotalOverTimeRequested(getTotalOverTimeRequested());
		clone.setAbSence(getAbSence());
		clone.setFullName(getFullName());
		clone.setStaffCode(getStaffCode());

		return clone;
	}

	public int compareTo(LmisViewAttdance lmisViewAttdance) {
		int value = 0;

		value = DateUtil.compareTo(getCreatedAt(),
				lmisViewAttdance.getCreatedAt());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisViewAttdance lmisViewAttdance = null;

		try {
			lmisViewAttdance = (LmisViewAttdance)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisViewAttdance.getPrimaryKey();

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

		sb.append("{lmisViewAttDailyId=");
		sb.append(getLmisViewAttDailyId());
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
		sb.append(", absenceType=");
		sb.append(getAbsenceType());
		sb.append(", absenceTypeId=");
		sb.append(getAbsenceTypeId());
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
		sb.append(", overTimeValue=");
		sb.append(getOverTimeValue());
		sb.append(", totalWorkingTime=");
		sb.append(getTotalWorkingTime());
		sb.append(", totalOverTime=");
		sb.append(getTotalOverTime());
		sb.append(", totalOverTimeFinal=");
		sb.append(getTotalOverTimeFinal());
		sb.append(", totalTimeFinal=");
		sb.append(getTotalTimeFinal());
		sb.append(", createdAt=");
		sb.append(getCreatedAt());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", updatedAt=");
		sb.append(getUpdatedAt());
		sb.append(", updatedBy=");
		sb.append(getUpdatedBy());
		sb.append(", lastname=");
		sb.append(getLastname());
		sb.append(", totalOverTimeRequested=");
		sb.append(getTotalOverTimeRequested());
		sb.append(", abSence=");
		sb.append(getAbSence());
		sb.append(", fullName=");
		sb.append(getFullName());
		sb.append(", staffCode=");
		sb.append(getStaffCode());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisViewAttdance");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisViewAttDailyId</column-name><column-value><![CDATA[");
		sb.append(getLmisViewAttDailyId());
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
			"<column><column-name>absenceType</column-name><column-value><![CDATA[");
		sb.append(getAbsenceType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>absenceTypeId</column-name><column-value><![CDATA[");
		sb.append(getAbsenceTypeId());
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
			"<column><column-name>overTimeValue</column-name><column-value><![CDATA[");
		sb.append(getOverTimeValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalWorkingTime</column-name><column-value><![CDATA[");
		sb.append(getTotalWorkingTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalOverTime</column-name><column-value><![CDATA[");
		sb.append(getTotalOverTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalOverTimeFinal</column-name><column-value><![CDATA[");
		sb.append(getTotalOverTimeFinal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalTimeFinal</column-name><column-value><![CDATA[");
		sb.append(getTotalTimeFinal());
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
			"<column><column-name>updatedBy</column-name><column-value><![CDATA[");
		sb.append(getUpdatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastname</column-name><column-value><![CDATA[");
		sb.append(getLastname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalOverTimeRequested</column-name><column-value><![CDATA[");
		sb.append(getTotalOverTimeRequested());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>abSence</column-name><column-value><![CDATA[");
		sb.append(getAbSence());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fullName</column-name><column-value><![CDATA[");
		sb.append(getFullName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>staffCode</column-name><column-value><![CDATA[");
		sb.append(getStaffCode());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisViewAttDailyId;
	private Date _dayValue;
	private int _rootId;
	private int _userId;
	private double _absenceValue;
	private boolean _isPermissive;
	private String _absenceType;
	private int _absenceTypeId;
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
	private String _overTimeValue;
	private double _totalWorkingTime;
	private double _totalOverTime;
	private double _totalOverTimeFinal;
	private double _totalTimeFinal;
	private Date _createdAt;
	private int _createdBy;
	private Date _updatedAt;
	private int _updatedBy;
	private String _lastname;
	private double _totalOverTimeRequested;
	private int _abSence;
	private String _fullName;
	private String _staffCode;
}