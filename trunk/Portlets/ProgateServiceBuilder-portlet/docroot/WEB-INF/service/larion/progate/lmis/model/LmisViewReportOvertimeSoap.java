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
 * <a href="LmisViewReportOvertimeSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewReportOvertimeSoap implements Serializable {
	public static LmisViewReportOvertimeSoap toSoapModel(
		LmisViewReportOvertime model) {
		LmisViewReportOvertimeSoap soapModel = new LmisViewReportOvertimeSoap();

		soapModel.setLmisViewReportOvertimeId(model.getLmisViewReportOvertimeId());
		soapModel.setOtRepId(model.getOtRepId());
		soapModel.setRootId(model.getRootId());
		soapModel.setOrgId(model.getOrgId());
		soapModel.setRequestId(model.getRequestId());
		soapModel.setReportedBy(model.getReportedBy());
		soapModel.setReportedAt(model.getReportedAt());
		soapModel.setReportedReason(model.getReportedReason());
		soapModel.setReportedStatus(model.getReportedStatus());
		soapModel.setCreatedAt(model.getCreatedAt());
		soapModel.setUpdatedAt(model.getUpdatedAt());
		soapModel.setReportId(model.getReportId());
		soapModel.setUserId(model.getUserId());
		soapModel.setTotalHour(model.getTotalHour());
		soapModel.setStartTime(model.getStartTime());
		soapModel.setEndTime(model.getEndTime());
		soapModel.setDetailId(model.getDetailId());
		soapModel.setOtType(model.getOtType());
		soapModel.setOtHour(model.getOtHour());
		soapModel.setOtCoefficient(model.getOtCoefficient());
		soapModel.setOtId(model.getOtId());
		soapModel.setOrgName(model.getOrgName());
		soapModel.setFullName(model.getFullName());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setMiddleName(model.getMiddleName());
		soapModel.setLastName(model.getLastName());
		soapModel.setRepFirstName(model.getRepFirstName());
		soapModel.setRepLastName(model.getRepLastName());
		soapModel.setRepMiddleName(model.getRepMiddleName());
		soapModel.setRegRequestedHour(model.getRegRequestedHour());
		soapModel.setRegStartTime(model.getRegStartTime());
		soapModel.setRegEndTime(model.getRegEndTime());

		return soapModel;
	}

	public static LmisViewReportOvertimeSoap[] toSoapModels(
		LmisViewReportOvertime[] models) {
		LmisViewReportOvertimeSoap[] soapModels = new LmisViewReportOvertimeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisViewReportOvertimeSoap[][] toSoapModels(
		LmisViewReportOvertime[][] models) {
		LmisViewReportOvertimeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisViewReportOvertimeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisViewReportOvertimeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisViewReportOvertimeSoap[] toSoapModels(
		List<LmisViewReportOvertime> models) {
		List<LmisViewReportOvertimeSoap> soapModels = new ArrayList<LmisViewReportOvertimeSoap>(models.size());

		for (LmisViewReportOvertime model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisViewReportOvertimeSoap[soapModels.size()]);
	}

	public LmisViewReportOvertimeSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisViewReportOvertimeId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisViewReportOvertimeId(pk);
	}

	public Integer getLmisViewReportOvertimeId() {
		return _lmisViewReportOvertimeId;
	}

	public void setLmisViewReportOvertimeId(Integer lmisViewReportOvertimeId) {
		_lmisViewReportOvertimeId = lmisViewReportOvertimeId;
	}

	public int getOtRepId() {
		return _otRepId;
	}

	public void setOtRepId(int otRepId) {
		_otRepId = otRepId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getOrgId() {
		return _orgId;
	}

	public void setOrgId(int orgId) {
		_orgId = orgId;
	}

	public int getRequestId() {
		return _requestId;
	}

	public void setRequestId(int requestId) {
		_requestId = requestId;
	}

	public int getReportedBy() {
		return _reportedBy;
	}

	public void setReportedBy(int reportedBy) {
		_reportedBy = reportedBy;
	}

	public Date getReportedAt() {
		return _reportedAt;
	}

	public void setReportedAt(Date reportedAt) {
		_reportedAt = reportedAt;
	}

	public String getReportedReason() {
		return _reportedReason;
	}

	public void setReportedReason(String reportedReason) {
		_reportedReason = reportedReason;
	}

	public int getReportedStatus() {
		return _reportedStatus;
	}

	public void setReportedStatus(int reportedStatus) {
		_reportedStatus = reportedStatus;
	}

	public Date getCreatedAt() {
		return _createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		_createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return _updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		_updatedAt = updatedAt;
	}

	public int getReportId() {
		return _reportId;
	}

	public void setReportId(int reportId) {
		_reportId = reportId;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public double getTotalHour() {
		return _totalHour;
	}

	public void setTotalHour(double totalHour) {
		_totalHour = totalHour;
	}

	public Date getStartTime() {
		return _startTime;
	}

	public void setStartTime(Date startTime) {
		_startTime = startTime;
	}

	public Date getEndTime() {
		return _endTime;
	}

	public void setEndTime(Date endTime) {
		_endTime = endTime;
	}

	public int getDetailId() {
		return _detailId;
	}

	public void setDetailId(int detailId) {
		_detailId = detailId;
	}

	public String getOtType() {
		return _otType;
	}

	public void setOtType(String otType) {
		_otType = otType;
	}

	public double getOtHour() {
		return _otHour;
	}

	public void setOtHour(double otHour) {
		_otHour = otHour;
	}

	public double getOtCoefficient() {
		return _otCoefficient;
	}

	public void setOtCoefficient(double otCoefficient) {
		_otCoefficient = otCoefficient;
	}

	public int getOtId() {
		return _otId;
	}

	public void setOtId(int otId) {
		_otId = otId;
	}

	public String getOrgName() {
		return _orgName;
	}

	public void setOrgName(String orgName) {
		_orgName = orgName;
	}

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getMiddleName() {
		return _middleName;
	}

	public void setMiddleName(String middleName) {
		_middleName = middleName;
	}

	public String getLastName() {
		return _LastName;
	}

	public void setLastName(String LastName) {
		_LastName = LastName;
	}

	public String getRepFirstName() {
		return _repFirstName;
	}

	public void setRepFirstName(String repFirstName) {
		_repFirstName = repFirstName;
	}

	public String getRepLastName() {
		return _repLastName;
	}

	public void setRepLastName(String repLastName) {
		_repLastName = repLastName;
	}

	public String getRepMiddleName() {
		return _repMiddleName;
	}

	public void setRepMiddleName(String repMiddleName) {
		_repMiddleName = repMiddleName;
	}

	public double getRegRequestedHour() {
		return _regRequestedHour;
	}

	public void setRegRequestedHour(double regRequestedHour) {
		_regRequestedHour = regRequestedHour;
	}

	public Date getRegStartTime() {
		return _regStartTime;
	}

	public void setRegStartTime(Date regStartTime) {
		_regStartTime = regStartTime;
	}

	public Date getRegEndTime() {
		return _regEndTime;
	}

	public void setRegEndTime(Date regEndTime) {
		_regEndTime = regEndTime;
	}

	private Integer _lmisViewReportOvertimeId;
	private int _otRepId;
	private int _rootId;
	private int _orgId;
	private int _requestId;
	private int _reportedBy;
	private Date _reportedAt;
	private String _reportedReason;
	private int _reportedStatus;
	private Date _createdAt;
	private Date _updatedAt;
	private int _reportId;
	private int _userId;
	private double _totalHour;
	private Date _startTime;
	private Date _endTime;
	private int _detailId;
	private String _otType;
	private double _otHour;
	private double _otCoefficient;
	private int _otId;
	private String _orgName;
	private String _fullName;
	private String _firstName;
	private String _middleName;
	private String _LastName;
	private String _repFirstName;
	private String _repLastName;
	private String _repMiddleName;
	private double _regRequestedHour;
	private Date _regStartTime;
	private Date _regEndTime;
}