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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisAttendanceDailySoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAttendanceDailySoap implements Serializable {
	public static LmisAttendanceDailySoap toSoapModel(LmisAttendanceDaily model) {
		LmisAttendanceDailySoap soapModel = new LmisAttendanceDailySoap();

		soapModel.setLmisAttendanceDailyId(model.getLmisAttendanceDailyId());
		soapModel.setDayValue(model.getDayValue());
		soapModel.setRootId(model.getRootId());
		soapModel.setUserId(model.getUserId());
		soapModel.setAbsenceValue(model.getAbsenceValue());
		soapModel.setIsPermissive(model.getIsPermissive());
		soapModel.setAbsenceReason(model.getAbsenceReason());
		soapModel.setAbsenceReasonId(model.getAbsenceReasonId());
		soapModel.setPlanStartTime(model.getPlanStartTime());
		soapModel.setRealStartTime(model.getRealStartTime());
		soapModel.setTimeLate(model.getTimeLate());
		soapModel.setTimeLatePenalty(model.getTimeLatePenalty());
		soapModel.setTimeLateFinal(model.getTimeLateFinal());
		soapModel.setPlanEndTime(model.getPlanEndTime());
		soapModel.setRealEndTime(model.getRealEndTime());
		soapModel.setTimeEarly(model.getTimeEarly());
		soapModel.setTimeEarlyPenalty(model.getTimeEarlyPenalty());
		soapModel.setTimeEarlyFinal(model.getTimeEarlyFinal());
		soapModel.setOvertimeValue(model.getOvertimeValue());
		soapModel.setTotalWorkingTime(model.getTotalWorkingTime());
		soapModel.setTotalOvertime(model.getTotalOvertime());
		soapModel.setTotalOvertimeFinal(model.getTotalOvertimeFinal());
		soapModel.setTotalTimeFinal(model.getTotalTimeFinal());
		soapModel.setComMent(model.getComMent());
		soapModel.setCreatedAt(model.getCreatedAt());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setUpdatedAt(model.getUpdatedAt());
		soapModel.setUpdated_by(model.getUpdated_by());
		soapModel.setTotalOvertimeRequested(model.getTotalOvertimeRequested());
		soapModel.setAbsence_(model.getAbsence_());

		return soapModel;
	}

	public static LmisAttendanceDailySoap[] toSoapModels(
		LmisAttendanceDaily[] models) {
		LmisAttendanceDailySoap[] soapModels = new LmisAttendanceDailySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisAttendanceDailySoap[][] toSoapModels(
		LmisAttendanceDaily[][] models) {
		LmisAttendanceDailySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisAttendanceDailySoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisAttendanceDailySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisAttendanceDailySoap[] toSoapModels(
		List<LmisAttendanceDaily> models) {
		List<LmisAttendanceDailySoap> soapModels = new ArrayList<LmisAttendanceDailySoap>(models.size());

		for (LmisAttendanceDaily model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisAttendanceDailySoap[soapModels.size()]);
	}

	public LmisAttendanceDailySoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisAttendanceDailyId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisAttendanceDailyId(pk);
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
		return _absenceReason;
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
		return _overtimeValue;
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
		return _comMent;
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