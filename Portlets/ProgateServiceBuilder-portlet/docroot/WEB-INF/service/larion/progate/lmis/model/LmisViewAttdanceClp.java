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

package larion.progate.lmis.model;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * <a href="LmisViewAttdanceClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewAttdanceClp extends BaseModelImpl<LmisViewAttdance>
	implements LmisViewAttdance {
	public LmisViewAttdanceClp() {
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
		return _absenceType;
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
		return _overTimeValue;
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
		return _lastname;
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
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public String getStaffCode() {
		return _staffCode;
	}

	public void setStaffCode(String staffCode) {
		_staffCode = staffCode;
	}

	public LmisViewAttdance toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			LmisViewAttdance model = new LmisViewAttdanceClp();

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
		LmisViewAttdanceClp clone = new LmisViewAttdanceClp();

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

		LmisViewAttdanceClp lmisViewAttdance = null;

		try {
			lmisViewAttdance = (LmisViewAttdanceClp)obj;
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