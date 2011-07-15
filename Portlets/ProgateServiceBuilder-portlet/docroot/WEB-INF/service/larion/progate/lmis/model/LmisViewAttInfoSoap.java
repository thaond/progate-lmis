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
 * <a href="LmisViewAttInfoSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewAttInfoSoap implements Serializable {
	public static LmisViewAttInfoSoap toSoapModel(LmisViewAttInfo model) {
		LmisViewAttInfoSoap soapModel = new LmisViewAttInfoSoap();

		soapModel.setLmisViewAttInfoId(model.getLmisViewAttInfoId());
		soapModel.setStaffUID(model.getStaffUID());
		soapModel.setPmUID(model.getPmUID());
		soapModel.setDayValue(model.getDayValue());
		soapModel.setRootId(model.getRootId());
		soapModel.setUserId(model.getUserId());
		soapModel.setAbsenceValue(model.getAbsenceValue());
		soapModel.setIsPermissive(model.getIsPermissive());
		soapModel.setAbsenceType(model.getAbsenceType());
		soapModel.setAbsenceTypeId(model.getAbsenceTypeId());
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
		soapModel.setOverTimeValue(model.getOverTimeValue());
		soapModel.setTotalWorkingTime(model.getTotalWorkingTime());
		soapModel.setTotalOverTime(model.getTotalOverTime());
		soapModel.setTotalOverTimeFinal(model.getTotalOverTimeFinal());
		soapModel.setTotalTimeFinal(model.getTotalTimeFinal());
		soapModel.setCreatedAt(model.getCreatedAt());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setUpdatedAt(model.getUpdatedAt());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setTotalOverTimeRequested(model.getTotalOverTimeRequested());
		soapModel.setAbSence(model.getAbSence());
		soapModel.setFullName(model.getFullName());
		soapModel.setStaffCode(model.getStaffCode());

		return soapModel;
	}

	public static LmisViewAttInfoSoap[] toSoapModels(LmisViewAttInfo[] models) {
		LmisViewAttInfoSoap[] soapModels = new LmisViewAttInfoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisViewAttInfoSoap[][] toSoapModels(
		LmisViewAttInfo[][] models) {
		LmisViewAttInfoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisViewAttInfoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisViewAttInfoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisViewAttInfoSoap[] toSoapModels(
		List<LmisViewAttInfo> models) {
		List<LmisViewAttInfoSoap> soapModels = new ArrayList<LmisViewAttInfoSoap>(models.size());

		for (LmisViewAttInfo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisViewAttInfoSoap[soapModels.size()]);
	}

	public LmisViewAttInfoSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisViewAttInfoId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisViewAttInfoId(pk);
	}

	public Integer getLmisViewAttInfoId() {
		return _lmisViewAttInfoId;
	}

	public void setLmisViewAttInfoId(Integer lmisViewAttInfoId) {
		_lmisViewAttInfoId = lmisViewAttInfoId;
	}

	public int getStaffUID() {
		return _staffUID;
	}

	public void setStaffUID(int staffUID) {
		_staffUID = staffUID;
	}

	public int getPmUID() {
		return _pmUID;
	}

	public void setPmUID(int pmUID) {
		_pmUID = pmUID;
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

	private Integer _lmisViewAttInfoId;
	private int _staffUID;
	private int _pmUID;
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
	private double _totalOverTimeRequested;
	private int _abSence;
	private String _fullName;
	private String _staffCode;
}