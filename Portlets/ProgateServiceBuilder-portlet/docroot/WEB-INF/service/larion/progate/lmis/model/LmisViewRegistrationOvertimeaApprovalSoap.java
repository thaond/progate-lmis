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
 * <a href="LmisViewRegistrationOvertimeaApprovalSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewRegistrationOvertimeaApprovalSoap implements Serializable {
	public static LmisViewRegistrationOvertimeaApprovalSoap toSoapModel(
		LmisViewRegistrationOvertimeaApproval model) {
		LmisViewRegistrationOvertimeaApprovalSoap soapModel = new LmisViewRegistrationOvertimeaApprovalSoap();

		soapModel.setLmisViewRegistrationOvertimeaApprovalId(model.getLmisViewRegistrationOvertimeaApprovalId());
		soapModel.setRootId(model.getRootId());
		soapModel.setRequestedBy(model.getRequestedBy());
		soapModel.setRequestedAt(model.getRequestedAt());
		soapModel.setRequestedReason(model.getRequestedReason());
		soapModel.setRequestedStatus(model.getRequestedStatus());
		soapModel.setCreatedAt(model.getCreatedAt());
		soapModel.setUpdatedAt(model.getUpdatedAt());
		soapModel.setOrgId(model.getOrgId());
		soapModel.setName(model.getName());
		soapModel.setFullName(model.getFullName());

		return soapModel;
	}

	public static LmisViewRegistrationOvertimeaApprovalSoap[] toSoapModels(
		LmisViewRegistrationOvertimeaApproval[] models) {
		LmisViewRegistrationOvertimeaApprovalSoap[] soapModels = new LmisViewRegistrationOvertimeaApprovalSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisViewRegistrationOvertimeaApprovalSoap[][] toSoapModels(
		LmisViewRegistrationOvertimeaApproval[][] models) {
		LmisViewRegistrationOvertimeaApprovalSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisViewRegistrationOvertimeaApprovalSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisViewRegistrationOvertimeaApprovalSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisViewRegistrationOvertimeaApprovalSoap[] toSoapModels(
		List<LmisViewRegistrationOvertimeaApproval> models) {
		List<LmisViewRegistrationOvertimeaApprovalSoap> soapModels = new ArrayList<LmisViewRegistrationOvertimeaApprovalSoap>(models.size());

		for (LmisViewRegistrationOvertimeaApproval model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisViewRegistrationOvertimeaApprovalSoap[soapModels.size()]);
	}

	public LmisViewRegistrationOvertimeaApprovalSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisViewRegistrationOvertimeaApprovalId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisViewRegistrationOvertimeaApprovalId(pk);
	}

	public Integer getLmisViewRegistrationOvertimeaApprovalId() {
		return _lmisViewRegistrationOvertimeaApprovalId;
	}

	public void setLmisViewRegistrationOvertimeaApprovalId(
		Integer lmisViewRegistrationOvertimeaApprovalId) {
		_lmisViewRegistrationOvertimeaApprovalId = lmisViewRegistrationOvertimeaApprovalId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	private Integer _lmisViewRegistrationOvertimeaApprovalId;
	private int _rootId;
	private int _requestedBy;
	private Date _requestedAt;
	private String _requestedReason;
	private int _requestedStatus;
	private Date _createdAt;
	private Date _updatedAt;
	private int _orgId;
	private String _name;
	private String _fullName;
}