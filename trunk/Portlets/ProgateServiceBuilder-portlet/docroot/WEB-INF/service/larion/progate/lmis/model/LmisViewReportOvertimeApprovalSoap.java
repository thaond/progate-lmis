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
 * <a href="LmisViewReportOvertimeApprovalSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewReportOvertimeApprovalSoap implements Serializable {
	public static LmisViewReportOvertimeApprovalSoap toSoapModel(
		LmisViewReportOvertimeApproval model) {
		LmisViewReportOvertimeApprovalSoap soapModel = new LmisViewReportOvertimeApprovalSoap();

		soapModel.setLmisViewReportOvertimeApprovalId(model.getLmisViewReportOvertimeApprovalId());
		soapModel.setRootId(model.getRootId());
		soapModel.setOrgId(model.getOrgId());
		soapModel.setRequestId(model.getRequestId());
		soapModel.setReportedBy(model.getReportedBy());
		soapModel.setReportedAt(model.getReportedAt());
		soapModel.setReportedReason(model.getReportedReason());
		soapModel.setReportedStatus(model.getReportedStatus());
		soapModel.setCreatedAt(model.getCreatedAt());
		soapModel.setUpdatedAt(model.getUpdatedAt());
		soapModel.setOrgName(model.getOrgName());
		soapModel.setFullName(model.getFullName());

		return soapModel;
	}

	public static LmisViewReportOvertimeApprovalSoap[] toSoapModels(
		LmisViewReportOvertimeApproval[] models) {
		LmisViewReportOvertimeApprovalSoap[] soapModels = new LmisViewReportOvertimeApprovalSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisViewReportOvertimeApprovalSoap[][] toSoapModels(
		LmisViewReportOvertimeApproval[][] models) {
		LmisViewReportOvertimeApprovalSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisViewReportOvertimeApprovalSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisViewReportOvertimeApprovalSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisViewReportOvertimeApprovalSoap[] toSoapModels(
		List<LmisViewReportOvertimeApproval> models) {
		List<LmisViewReportOvertimeApprovalSoap> soapModels = new ArrayList<LmisViewReportOvertimeApprovalSoap>(models.size());

		for (LmisViewReportOvertimeApproval model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisViewReportOvertimeApprovalSoap[soapModels.size()]);
	}

	public LmisViewReportOvertimeApprovalSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisViewReportOvertimeApprovalId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisViewReportOvertimeApprovalId(pk);
	}

	public Integer getLmisViewReportOvertimeApprovalId() {
		return _lmisViewReportOvertimeApprovalId;
	}

	public void setLmisViewReportOvertimeApprovalId(
		Integer lmisViewReportOvertimeApprovalId) {
		_lmisViewReportOvertimeApprovalId = lmisViewReportOvertimeApprovalId;
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

	private Integer _lmisViewReportOvertimeApprovalId;
	private int _rootId;
	private int _orgId;
	private int _requestId;
	private int _reportedBy;
	private Date _reportedAt;
	private String _reportedReason;
	private int _reportedStatus;
	private Date _createdAt;
	private Date _updatedAt;
	private String _orgName;
	private String _fullName;
}