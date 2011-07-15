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
 * <a href="ProgateOrganizationParticipantsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgateOrganizationParticipantsSoap implements Serializable {
	public static ProgateOrganizationParticipantsSoap toSoapModel(
		ProgateOrganizationParticipants model) {
		ProgateOrganizationParticipantsSoap soapModel = new ProgateOrganizationParticipantsSoap();

		soapModel.setProgateOrganizationParticipantsId(model.getProgateOrganizationParticipantsId());
		soapModel.setUserId(model.getUserId());
		soapModel.setOrgId(model.getOrgId());
		soapModel.setRoleId(model.getRoleId());
		soapModel.setRootId(model.getRootId());
		soapModel.setBodId(model.getBodId());
		soapModel.setRequestedBy(model.getRequestedBy());
		soapModel.setRequestedAt(model.getRequestedAt());
		soapModel.setRequestedReason(model.getRequestedReason());
		soapModel.setApprovedBy(model.getApprovedBy());
		soapModel.setApprovedAt(model.getApprovedAt());
		soapModel.setApprovedReason(model.getApprovedReason());
		soapModel.setStatus(model.getStatus());
		soapModel.setIsCurrent(model.getIsCurrent());

		return soapModel;
	}

	public static ProgateOrganizationParticipantsSoap[] toSoapModels(
		ProgateOrganizationParticipants[] models) {
		ProgateOrganizationParticipantsSoap[] soapModels = new ProgateOrganizationParticipantsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProgateOrganizationParticipantsSoap[][] toSoapModels(
		ProgateOrganizationParticipants[][] models) {
		ProgateOrganizationParticipantsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProgateOrganizationParticipantsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProgateOrganizationParticipantsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProgateOrganizationParticipantsSoap[] toSoapModels(
		List<ProgateOrganizationParticipants> models) {
		List<ProgateOrganizationParticipantsSoap> soapModels = new ArrayList<ProgateOrganizationParticipantsSoap>(models.size());

		for (ProgateOrganizationParticipants model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProgateOrganizationParticipantsSoap[soapModels.size()]);
	}

	public ProgateOrganizationParticipantsSoap() {
	}

	public Integer getPrimaryKey() {
		return _ProgateOrganizationParticipantsId;
	}

	public void setPrimaryKey(Integer pk) {
		setProgateOrganizationParticipantsId(pk);
	}

	public Integer getProgateOrganizationParticipantsId() {
		return _ProgateOrganizationParticipantsId;
	}

	public void setProgateOrganizationParticipantsId(
		Integer ProgateOrganizationParticipantsId) {
		_ProgateOrganizationParticipantsId = ProgateOrganizationParticipantsId;
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

	public int getRoleId() {
		return _roleId;
	}

	public void setRoleId(int roleId) {
		_roleId = roleId;
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

	public String getApprovedReason() {
		return _approvedReason;
	}

	public void setApprovedReason(String approvedReason) {
		_approvedReason = approvedReason;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public boolean getIsCurrent() {
		return _isCurrent;
	}

	public boolean isIsCurrent() {
		return _isCurrent;
	}

	public void setIsCurrent(boolean isCurrent) {
		_isCurrent = isCurrent;
	}

	private Integer _ProgateOrganizationParticipantsId;
	private int _userId;
	private int _orgId;
	private int _roleId;
	private int _rootId;
	private int _bodId;
	private int _requestedBy;
	private Date _requestedAt;
	private String _requestedReason;
	private int _approvedBy;
	private Date _approvedAt;
	private String _approvedReason;
	private int _status;
	private boolean _isCurrent;
}