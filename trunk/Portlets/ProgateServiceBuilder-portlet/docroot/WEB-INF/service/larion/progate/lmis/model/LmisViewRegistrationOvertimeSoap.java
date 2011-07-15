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
 * <a href="LmisViewRegistrationOvertimeSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewRegistrationOvertimeSoap implements Serializable {
	public static LmisViewRegistrationOvertimeSoap toSoapModel(
		LmisViewRegistrationOvertime model) {
		LmisViewRegistrationOvertimeSoap soapModel = new LmisViewRegistrationOvertimeSoap();

		soapModel.setLmisViewRegistrationOvertimeId(model.getLmisViewRegistrationOvertimeId());
		soapModel.setOtReqsId(model.getOtReqsId());
		soapModel.setRootId(model.getRootId());
		soapModel.setRequestedBy(model.getRequestedBy());
		soapModel.setRequestedAt(model.getRequestedAt());
		soapModel.setRequestedReason(model.getRequestedReason());
		soapModel.setRequestedStatus(model.getRequestedStatus());
		soapModel.setCreatedAt(model.getCreatedAt());
		soapModel.setUpdatedAt(model.getUpdatedAt());
		soapModel.setOrgId(model.getOrgId());
		soapModel.setRequestId(model.getRequestId());
		soapModel.setUserId(model.getUserId());
		soapModel.setStartTime(model.getStartTime());
		soapModel.setEndTime(model.getEndTime());
		soapModel.setReasonDetail(model.getReasonDetail());
		soapModel.setRequestedHour(model.getRequestedHour());
		soapModel.setApprovedBy(model.getApprovedBy());
		soapModel.setApprovedAt(model.getApprovedAt());
		soapModel.setIsApproved(model.getIsApproved());
		soapModel.setApprovedStatus(model.getApprovedStatus());
		soapModel.setReaSon(model.getReaSon());
		soapModel.setOrgName(model.getOrgName());
		soapModel.setFullName(model.getFullName());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setMiddleName(model.getMiddleName());
		soapModel.setLastName(model.getLastName());
		soapModel.setReqFirstName(model.getReqFirstName());
		soapModel.setReqMiddleName(model.getReqMiddleName());
		soapModel.setReqLastName(model.getReqLastName());

		return soapModel;
	}

	public static LmisViewRegistrationOvertimeSoap[] toSoapModels(
		LmisViewRegistrationOvertime[] models) {
		LmisViewRegistrationOvertimeSoap[] soapModels = new LmisViewRegistrationOvertimeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisViewRegistrationOvertimeSoap[][] toSoapModels(
		LmisViewRegistrationOvertime[][] models) {
		LmisViewRegistrationOvertimeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisViewRegistrationOvertimeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisViewRegistrationOvertimeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisViewRegistrationOvertimeSoap[] toSoapModels(
		List<LmisViewRegistrationOvertime> models) {
		List<LmisViewRegistrationOvertimeSoap> soapModels = new ArrayList<LmisViewRegistrationOvertimeSoap>(models.size());

		for (LmisViewRegistrationOvertime model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisViewRegistrationOvertimeSoap[soapModels.size()]);
	}

	public LmisViewRegistrationOvertimeSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisViewRegistrationOvertimeId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisViewRegistrationOvertimeId(pk);
	}

	public Integer getLmisViewRegistrationOvertimeId() {
		return _lmisViewRegistrationOvertimeId;
	}

	public void setLmisViewRegistrationOvertimeId(
		Integer lmisViewRegistrationOvertimeId) {
		_lmisViewRegistrationOvertimeId = lmisViewRegistrationOvertimeId;
	}

	public int getOtReqsId() {
		return _otReqsId;
	}

	public void setOtReqsId(int otReqsId) {
		_otReqsId = otReqsId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getRequestedBy() {
		return _requestedBy;
	}

	public void setRequestedBy(int requestedBy) {
		_requestedBy = requestedBy;
	}

	public Date getRequestedAt() {
		return _requestedAt;
	}

	public void setRequestedAt(Date requestedAt) {
		_requestedAt = requestedAt;
	}

	public String getRequestedReason() {
		return _requestedReason;
	}

	public void setRequestedReason(String requestedReason) {
		_requestedReason = requestedReason;
	}

	public int getRequestedStatus() {
		return _requestedStatus;
	}

	public void setRequestedStatus(int requestedStatus) {
		_requestedStatus = requestedStatus;
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

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
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

	public String getReasonDetail() {
		return _reasonDetail;
	}

	public void setReasonDetail(String reasonDetail) {
		_reasonDetail = reasonDetail;
	}

	public double getRequestedHour() {
		return _requestedHour;
	}

	public void setRequestedHour(double requestedHour) {
		_requestedHour = requestedHour;
	}

	public int getApprovedBy() {
		return _approvedBy;
	}

	public void setApprovedBy(int approvedBy) {
		_approvedBy = approvedBy;
	}

	public Date getApprovedAt() {
		return _approvedAt;
	}

	public void setApprovedAt(Date approvedAt) {
		_approvedAt = approvedAt;
	}

	public boolean getIsApproved() {
		return _isApproved;
	}

	public boolean isIsApproved() {
		return _isApproved;
	}

	public void setIsApproved(boolean isApproved) {
		_isApproved = isApproved;
	}

	public boolean getApprovedStatus() {
		return _approvedStatus;
	}

	public boolean isApprovedStatus() {
		return _approvedStatus;
	}

	public void setApprovedStatus(boolean approvedStatus) {
		_approvedStatus = approvedStatus;
	}

	public String getReaSon() {
		return _reaSon;
	}

	public void setReaSon(String reaSon) {
		_reaSon = reaSon;
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

	public String getReqFirstName() {
		return _reqFirstName;
	}

	public void setReqFirstName(String reqFirstName) {
		_reqFirstName = reqFirstName;
	}

	public String getReqMiddleName() {
		return _reqMiddleName;
	}

	public void setReqMiddleName(String reqMiddleName) {
		_reqMiddleName = reqMiddleName;
	}

	public String getReqLastName() {
		return _reqLastName;
	}

	public void setReqLastName(String reqLastName) {
		_reqLastName = reqLastName;
	}

	private Integer _lmisViewRegistrationOvertimeId;
	private int _otReqsId;
	private int _rootId;
	private int _requestedBy;
	private Date _requestedAt;
	private String _requestedReason;
	private int _requestedStatus;
	private Date _createdAt;
	private Date _updatedAt;
	private int _orgId;
	private int _requestId;
	private int _userId;
	private Date _startTime;
	private Date _endTime;
	private String _reasonDetail;
	private double _requestedHour;
	private int _approvedBy;
	private Date _approvedAt;
	private boolean _isApproved;
	private boolean _approvedStatus;
	private String _reaSon;
	private String _orgName;
	private String _fullName;
	private String _firstName;
	private String _middleName;
	private String _LastName;
	private String _reqFirstName;
	private String _reqMiddleName;
	private String _reqLastName;
}