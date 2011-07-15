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

package larion.progate.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="ProgateOrganizationsStaffsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgateOrganizationsStaffsSoap implements Serializable {
	public static ProgateOrganizationsStaffsSoap toSoapModel(
		ProgateOrganizationsStaffs model) {
		ProgateOrganizationsStaffsSoap soapModel = new ProgateOrganizationsStaffsSoap();

		soapModel.setProgateOrganizationsStaffsId(model.getProgateOrganizationsStaffsId());
		soapModel.setUserId(model.getUserId());
		soapModel.setOrgId(model.getOrgId());
		soapModel.setRootId(model.getRootId());
		soapModel.setBodId(model.getBodId());
		soapModel.setParticipantId(model.getParticipantId());
		soapModel.setPosition(model.getPosition());
		soapModel.setAvailability(model.getAvailability());
		soapModel.setBeginTime(model.getBeginTime());
		soapModel.setEndTime(model.getEndTime());
		soapModel.setIsActive(model.getIsActive());
		soapModel.setIsRemoved(model.getIsRemoved());
		soapModel.setStaffCode(model.getStaffCode());
		soapModel.setScannerCode(model.getScannerCode());
		soapModel.setCreatedAt(model.getCreatedAt());
		soapModel.setUpdatedAt(model.getUpdatedAt());

		return soapModel;
	}

	public static ProgateOrganizationsStaffsSoap[] toSoapModels(
		ProgateOrganizationsStaffs[] models) {
		ProgateOrganizationsStaffsSoap[] soapModels = new ProgateOrganizationsStaffsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProgateOrganizationsStaffsSoap[][] toSoapModels(
		ProgateOrganizationsStaffs[][] models) {
		ProgateOrganizationsStaffsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProgateOrganizationsStaffsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProgateOrganizationsStaffsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProgateOrganizationsStaffsSoap[] toSoapModels(
		List<ProgateOrganizationsStaffs> models) {
		List<ProgateOrganizationsStaffsSoap> soapModels = new ArrayList<ProgateOrganizationsStaffsSoap>(models.size());

		for (ProgateOrganizationsStaffs model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProgateOrganizationsStaffsSoap[soapModels.size()]);
	}

	public ProgateOrganizationsStaffsSoap() {
	}

	public Integer getPrimaryKey() {
		return _ProgateOrganizationsStaffsId;
	}

	public void setPrimaryKey(Integer pk) {
		setProgateOrganizationsStaffsId(pk);
	}

	public Integer getProgateOrganizationsStaffsId() {
		return _ProgateOrganizationsStaffsId;
	}

	public void setProgateOrganizationsStaffsId(
		Integer ProgateOrganizationsStaffsId) {
		_ProgateOrganizationsStaffsId = ProgateOrganizationsStaffsId;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public int getOrgId() {
		return _orgId;
	}

	public void setOrgId(int orgId) {
		_orgId = orgId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getBodId() {
		return _bodId;
	}

	public void setBodId(int bodId) {
		_bodId = bodId;
	}

	public int getParticipantId() {
		return _participantId;
	}

	public void setParticipantId(int participantId) {
		_participantId = participantId;
	}

	public String getPosition() {
		return _position;
	}

	public void setPosition(String position) {
		_position = position;
	}

	public double getAvailability() {
		return _availability;
	}

	public void setAvailability(double availability) {
		_availability = availability;
	}

	public Date getBeginTime() {
		return _beginTime;
	}

	public void setBeginTime(Date beginTime) {
		_beginTime = beginTime;
	}

	public Date getEndTime() {
		return _endTime;
	}

	public void setEndTime(Date endTime) {
		_endTime = endTime;
	}

	public boolean getIsActive() {
		return _isActive;
	}

	public boolean isIsActive() {
		return _isActive;
	}

	public void setIsActive(boolean isActive) {
		_isActive = isActive;
	}

	public boolean getIsRemoved() {
		return _isRemoved;
	}

	public boolean isIsRemoved() {
		return _isRemoved;
	}

	public void setIsRemoved(boolean isRemoved) {
		_isRemoved = isRemoved;
	}

	public String getStaffCode() {
		return _staffCode;
	}

	public void setStaffCode(String staffCode) {
		_staffCode = staffCode;
	}

	public String getScannerCode() {
		return _scannerCode;
	}

	public void setScannerCode(String scannerCode) {
		_scannerCode = scannerCode;
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

	private Integer _ProgateOrganizationsStaffsId;
	private int _userId;
	private int _orgId;
	private int _rootId;
	private int _bodId;
	private int _participantId;
	private String _position;
	private double _availability;
	private Date _beginTime;
	private Date _endTime;
	private boolean _isActive;
	private boolean _isRemoved;
	private String _staffCode;
	private String _scannerCode;
	private Date _createdAt;
	private Date _updatedAt;
}