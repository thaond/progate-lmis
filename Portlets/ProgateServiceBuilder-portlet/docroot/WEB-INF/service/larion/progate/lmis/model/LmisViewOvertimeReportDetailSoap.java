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
 * <a href="LmisViewOvertimeReportDetailSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewOvertimeReportDetailSoap implements Serializable {
	public static LmisViewOvertimeReportDetailSoap toSoapModel(
		LmisViewOvertimeReportDetail model) {
		LmisViewOvertimeReportDetailSoap soapModel = new LmisViewOvertimeReportDetailSoap();

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
		soapModel.setUserId(model.getUserId());
		soapModel.setTotalHour(model.getTotalHour());
		soapModel.setStartTime(model.getStartTime());
		soapModel.setEndTime(model.getEndTime());
		soapModel.setFullName(model.getFullName());
		soapModel.setReqRequestedHour(model.getReqRequestedHour());
		soapModel.setReqStartTime(model.getReqStartTime());
		soapModel.setReqEndTime(model.getReqEndTime());

		return soapModel;
	}

	public static LmisViewOvertimeReportDetailSoap[] toSoapModels(
		LmisViewOvertimeReportDetail[] models) {
		LmisViewOvertimeReportDetailSoap[] soapModels = new LmisViewOvertimeReportDetailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisViewOvertimeReportDetailSoap[][] toSoapModels(
		LmisViewOvertimeReportDetail[][] models) {
		LmisViewOvertimeReportDetailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisViewOvertimeReportDetailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisViewOvertimeReportDetailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisViewOvertimeReportDetailSoap[] toSoapModels(
		List<LmisViewOvertimeReportDetail> models) {
		List<LmisViewOvertimeReportDetailSoap> soapModels = new ArrayList<LmisViewOvertimeReportDetailSoap>(models.size());

		for (LmisViewOvertimeReportDetail model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisViewOvertimeReportDetailSoap[soapModels.size()]);
	}

	public LmisViewOvertimeReportDetailSoap() {
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

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public double getReqRequestedHour() {
		return _reqRequestedHour;
	}

	public void setReqRequestedHour(double reqRequestedHour) {
		_reqRequestedHour = reqRequestedHour;
	}

	public Date getReqStartTime() {
		return _reqStartTime;
	}

	public void setReqStartTime(Date reqStartTime) {
		_reqStartTime = reqStartTime;
	}

	public Date getReqEndTime() {
		return _reqEndTime;
	}

	public void setReqEndTime(Date reqEndTime) {
		_reqEndTime = reqEndTime;
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
	private int _userId;
	private double _totalHour;
	private Date _startTime;
	private Date _endTime;
	private String _fullName;
	private double _reqRequestedHour;
	private Date _reqStartTime;
	private Date _reqEndTime;
}