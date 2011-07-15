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
 * <a href="LmisTimeChangeRequestsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisTimeChangeRequestsSoap implements Serializable {
	public static LmisTimeChangeRequestsSoap toSoapModel(
		LmisTimeChangeRequests model) {
		LmisTimeChangeRequestsSoap soapModel = new LmisTimeChangeRequestsSoap();

		soapModel.setLmisTimeChangeRequestId(model.getLmisTimeChangeRequestId());
		soapModel.setRootId(model.getRootId());
		soapModel.setRequestedBy(model.getRequestedBy());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setMonSelected(model.getMonSelected());
		soapModel.setMonStartTime(model.getMonStartTime());
		soapModel.setMonEndTime(model.getMonEndTime());
		soapModel.setTueSelected(model.getTueSelected());
		soapModel.setTueStartTime(model.getTueStartTime());
		soapModel.setTueEndTime(model.getTueEndTime());
		soapModel.setWedSelected(model.getWedSelected());
		soapModel.setWedStartTime(model.getWedStartTime());
		soapModel.setWedEndTime(model.getWedEndTime());
		soapModel.setThuSelected(model.getThuSelected());
		soapModel.setThuStartTime(model.getThuStartTime());
		soapModel.setThuEndTime(model.getThuEndTime());
		soapModel.setFriSelected(model.getFriSelected());
		soapModel.setFriStartTime(model.getFriStartTime());
		soapModel.setFriEndTime(model.getFriEndTime());
		soapModel.setSatSelected(model.getSatSelected());
		soapModel.setSatStartTime(model.getSatStartTime());
		soapModel.setSatEndTime(model.getSatEndTime());
		soapModel.setRequestedReason(model.getRequestedReason());
		soapModel.setRequestedStatus(model.getRequestedStatus());
		soapModel.setCreatedAt(model.getCreatedAt());
		soapModel.setUpdatedAt(model.getUpdatedAt());

		return soapModel;
	}

	public static LmisTimeChangeRequestsSoap[] toSoapModels(
		LmisTimeChangeRequests[] models) {
		LmisTimeChangeRequestsSoap[] soapModels = new LmisTimeChangeRequestsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisTimeChangeRequestsSoap[][] toSoapModels(
		LmisTimeChangeRequests[][] models) {
		LmisTimeChangeRequestsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisTimeChangeRequestsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisTimeChangeRequestsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisTimeChangeRequestsSoap[] toSoapModels(
		List<LmisTimeChangeRequests> models) {
		List<LmisTimeChangeRequestsSoap> soapModels = new ArrayList<LmisTimeChangeRequestsSoap>(models.size());

		for (LmisTimeChangeRequests model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisTimeChangeRequestsSoap[soapModels.size()]);
	}

	public LmisTimeChangeRequestsSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisTimeChangeRequestId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisTimeChangeRequestId(pk);
	}

	public Integer getLmisTimeChangeRequestId() {
		return _lmisTimeChangeRequestId;
	}

	public void setLmisTimeChangeRequestId(Integer lmisTimeChangeRequestId) {
		_lmisTimeChangeRequestId = lmisTimeChangeRequestId;
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

	public boolean getMonSelected() {
		return _monSelected;
	}

	public boolean isMonSelected() {
		return _monSelected;
	}

	public void setMonSelected(boolean monSelected) {
		_monSelected = monSelected;
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

	public boolean getTueSelected() {
		return _tueSelected;
	}

	public boolean isTueSelected() {
		return _tueSelected;
	}

	public void setTueSelected(boolean tueSelected) {
		_tueSelected = tueSelected;
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

	public boolean getWedSelected() {
		return _wedSelected;
	}

	public boolean isWedSelected() {
		return _wedSelected;
	}

	public void setWedSelected(boolean wedSelected) {
		_wedSelected = wedSelected;
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

	public boolean getThuSelected() {
		return _thuSelected;
	}

	public boolean isThuSelected() {
		return _thuSelected;
	}

	public void setThuSelected(boolean thuSelected) {
		_thuSelected = thuSelected;
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

	public boolean getFriSelected() {
		return _friSelected;
	}

	public boolean isFriSelected() {
		return _friSelected;
	}

	public void setFriSelected(boolean friSelected) {
		_friSelected = friSelected;
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

	public boolean getSatSelected() {
		return _satSelected;
	}

	public boolean isSatSelected() {
		return _satSelected;
	}

	public void setSatSelected(boolean satSelected) {
		_satSelected = satSelected;
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

	public Date getUpdatedAt() {
		return _updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		_updatedAt = updatedAt;
	}

	private Integer _lmisTimeChangeRequestId;
	private int _rootId;
	private int _requestedBy;
	private Date _startDate;
	private Date _endDate;
	private boolean _monSelected;
	private Date _monStartTime;
	private Date _monEndTime;
	private boolean _tueSelected;
	private Date _tueStartTime;
	private Date _tueEndTime;
	private boolean _wedSelected;
	private Date _wedStartTime;
	private Date _wedEndTime;
	private boolean _thuSelected;
	private Date _thuStartTime;
	private Date _thuEndTime;
	private boolean _friSelected;
	private Date _friStartTime;
	private Date _friEndTime;
	private boolean _satSelected;
	private Date _satStartTime;
	private Date _satEndTime;
	private String _requestedReason;
	private int _requestedStatus;
	private Date _createdAt;
	private Date _updatedAt;
}