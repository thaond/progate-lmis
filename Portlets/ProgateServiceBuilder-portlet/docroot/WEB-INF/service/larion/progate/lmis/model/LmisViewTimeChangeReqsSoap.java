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
 * <a href="LmisViewTimeChangeReqsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewTimeChangeReqsSoap implements Serializable {
	public static LmisViewTimeChangeReqsSoap toSoapModel(
		LmisViewTimeChangeReqs model) {
		LmisViewTimeChangeReqsSoap soapModel = new LmisViewTimeChangeReqsSoap();

		soapModel.setLmisViewTimeChangeReqId(model.getLmisViewTimeChangeReqId());
		soapModel.setRootId(model.getRootId());
		soapModel.setRequestedBy(model.getRequestedBy());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setFullName(model.getFullName());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setMonStartTime(model.getMonStartTime());
		soapModel.setMonEndTime(model.getMonEndTime());
		soapModel.setTueStartTime(model.getTueStartTime());
		soapModel.setTueEndTime(model.getTueEndTime());
		soapModel.setWedStartTime(model.getWedStartTime());
		soapModel.setWedEndTime(model.getWedEndTime());
		soapModel.setThuStartTime(model.getThuStartTime());
		soapModel.setThuEndTime(model.getThuEndTime());
		soapModel.setFriStartTime(model.getFriStartTime());
		soapModel.setFriEndTime(model.getFriEndTime());
		soapModel.setSatStartTime(model.getSatStartTime());
		soapModel.setSatEndTime(model.getSatEndTime());
		soapModel.setRequestedReason(model.getRequestedReason());
		soapModel.setRequestedStatus(model.getRequestedStatus());
		soapModel.setCreatedAt(model.getCreatedAt());

		return soapModel;
	}

	public static LmisViewTimeChangeReqsSoap[] toSoapModels(
		LmisViewTimeChangeReqs[] models) {
		LmisViewTimeChangeReqsSoap[] soapModels = new LmisViewTimeChangeReqsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisViewTimeChangeReqsSoap[][] toSoapModels(
		LmisViewTimeChangeReqs[][] models) {
		LmisViewTimeChangeReqsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisViewTimeChangeReqsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisViewTimeChangeReqsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisViewTimeChangeReqsSoap[] toSoapModels(
		List<LmisViewTimeChangeReqs> models) {
		List<LmisViewTimeChangeReqsSoap> soapModels = new ArrayList<LmisViewTimeChangeReqsSoap>(models.size());

		for (LmisViewTimeChangeReqs model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisViewTimeChangeReqsSoap[soapModels.size()]);
	}

	public LmisViewTimeChangeReqsSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisViewTimeChangeReqId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisViewTimeChangeReqId(pk);
	}

	public Integer getLmisViewTimeChangeReqId() {
		return _lmisViewTimeChangeReqId;
	}

	public void setLmisViewTimeChangeReqId(Integer lmisViewTimeChangeReqId) {
		_lmisViewTimeChangeReqId = lmisViewTimeChangeReqId;
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

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
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

	public Date getMonStartTime() {
		return _monStartTime;
	}

	public void setMonStartTime(Date monStartTime) {
		_monStartTime = monStartTime;
	}

	public Date getMonEndTime() {
		return _monEndTime;
	}

	public void setMonEndTime(Date monEndTime) {
		_monEndTime = monEndTime;
	}

	public Date getTueStartTime() {
		return _tueStartTime;
	}

	public void setTueStartTime(Date tueStartTime) {
		_tueStartTime = tueStartTime;
	}

	public Date getTueEndTime() {
		return _tueEndTime;
	}

	public void setTueEndTime(Date tueEndTime) {
		_tueEndTime = tueEndTime;
	}

	public Date getWedStartTime() {
		return _wedStartTime;
	}

	public void setWedStartTime(Date wedStartTime) {
		_wedStartTime = wedStartTime;
	}

	public Date getWedEndTime() {
		return _wedEndTime;
	}

	public void setWedEndTime(Date wedEndTime) {
		_wedEndTime = wedEndTime;
	}

	public Date getThuStartTime() {
		return _thuStartTime;
	}

	public void setThuStartTime(Date thuStartTime) {
		_thuStartTime = thuStartTime;
	}

	public Date getThuEndTime() {
		return _thuEndTime;
	}

	public void setThuEndTime(Date thuEndTime) {
		_thuEndTime = thuEndTime;
	}

	public Date getFriStartTime() {
		return _friStartTime;
	}

	public void setFriStartTime(Date friStartTime) {
		_friStartTime = friStartTime;
	}

	public Date getFriEndTime() {
		return _friEndTime;
	}

	public void setFriEndTime(Date friEndTime) {
		_friEndTime = friEndTime;
	}

	public Date getSatStartTime() {
		return _satStartTime;
	}

	public void setSatStartTime(Date satStartTime) {
		_satStartTime = satStartTime;
	}

	public Date getSatEndTime() {
		return _satEndTime;
	}

	public void setSatEndTime(Date satEndTime) {
		_satEndTime = satEndTime;
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

	private Integer _lmisViewTimeChangeReqId;
	private int _rootId;
	private int _requestedBy;
	private String _firstName;
	private String _lastName;
	private String _fullName;
	private Date _startDate;
	private Date _endDate;
	private Date _monStartTime;
	private Date _monEndTime;
	private Date _tueStartTime;
	private Date _tueEndTime;
	private Date _wedStartTime;
	private Date _wedEndTime;
	private Date _thuStartTime;
	private Date _thuEndTime;
	private Date _friStartTime;
	private Date _friEndTime;
	private Date _satStartTime;
	private Date _satEndTime;
	private String _requestedReason;
	private int _requestedStatus;
	private Date _createdAt;
}