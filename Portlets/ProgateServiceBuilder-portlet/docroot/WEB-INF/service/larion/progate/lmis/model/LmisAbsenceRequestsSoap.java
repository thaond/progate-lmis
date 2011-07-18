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
 * <a href="LmisAbsenceRequestsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAbsenceRequestsSoap implements Serializable {
	public static LmisAbsenceRequestsSoap toSoapModel(LmisAbsenceRequests model) {
		LmisAbsenceRequestsSoap soapModel = new LmisAbsenceRequestsSoap();

		soapModel.setLmisAbsenceRequestsId(model.getLmisAbsenceRequestsId());
		soapModel.setRootId(model.getRootId());
		soapModel.setRequestedBy(model.getRequestedBy());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setStartSession(model.getStartSession());
		soapModel.setEndSession(model.getEndSession());
		soapModel.setRequestedReason(model.getRequestedReason());
		soapModel.setAbsenceType(model.getAbsenceType());
		soapModel.setAbsenceTypeId(model.getAbsenceTypeId());
		soapModel.setRequestedStatus(model.getRequestedStatus());
		soapModel.setCreatedAt(model.getCreatedAt());
		soapModel.setUpdatedAt(model.getUpdatedAt());

		return soapModel;
	}

	public static LmisAbsenceRequestsSoap[] toSoapModels(
		LmisAbsenceRequests[] models) {
		LmisAbsenceRequestsSoap[] soapModels = new LmisAbsenceRequestsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisAbsenceRequestsSoap[][] toSoapModels(
		LmisAbsenceRequests[][] models) {
		LmisAbsenceRequestsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisAbsenceRequestsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisAbsenceRequestsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisAbsenceRequestsSoap[] toSoapModels(
		List<LmisAbsenceRequests> models) {
		List<LmisAbsenceRequestsSoap> soapModels = new ArrayList<LmisAbsenceRequestsSoap>(models.size());

		for (LmisAbsenceRequests model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisAbsenceRequestsSoap[soapModels.size()]);
	}

	public LmisAbsenceRequestsSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisAbsenceRequestsId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisAbsenceRequestsId(pk);
	}

	public Integer getLmisAbsenceRequestsId() {
		return _lmisAbsenceRequestsId;
	}

	public void setLmisAbsenceRequestsId(Integer lmisAbsenceRequestsId) {
		_lmisAbsenceRequestsId = lmisAbsenceRequestsId;
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

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public int getStartSession() {
		return _startSession;
	}

	public void setStartSession(int startSession) {
		_startSession = startSession;
	}

	public int getEndSession() {
		return _endSession;
	}

	public void setEndSession(int endSession) {
		_endSession = endSession;
	}

	public String getRequestedReason() {
		return _requestedReason;
	}

	public void setRequestedReason(String requestedReason) {
		_requestedReason = requestedReason;
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

	private Integer _lmisAbsenceRequestsId;
	private int _rootId;
	private int _requestedBy;
	private Date _startDate;
	private Date _endDate;
	private int _startSession;
	private int _endSession;
	private String _requestedReason;
	private String _absenceType;
	private int _absenceTypeId;
	private int _requestedStatus;
	private Date _createdAt;
	private Date _updatedAt;
}