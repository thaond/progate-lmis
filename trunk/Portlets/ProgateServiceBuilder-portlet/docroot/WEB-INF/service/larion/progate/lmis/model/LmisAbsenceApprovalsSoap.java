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
 * <a href="LmisAbsenceApprovalsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAbsenceApprovalsSoap implements Serializable {
	public static LmisAbsenceApprovalsSoap toSoapModel(
		LmisAbsenceApprovals model) {
		LmisAbsenceApprovalsSoap soapModel = new LmisAbsenceApprovalsSoap();

		soapModel.setLmisAbsenceApprovalsId(model.getLmisAbsenceApprovalsId());
		soapModel.setRootId(model.getRootId());
		soapModel.setRequestId(model.getRequestId());
		soapModel.setApprovedBy(model.getApprovedBy());
		soapModel.setApprovedAt(model.getApprovedAt());
		soapModel.setIsApproved(model.getIsApproved());
		soapModel.setApprovedStatus(model.getApprovedStatus());
		soapModel.setReasonApproval(model.getReasonApproval());

		return soapModel;
	}

	public static LmisAbsenceApprovalsSoap[] toSoapModels(
		LmisAbsenceApprovals[] models) {
		LmisAbsenceApprovalsSoap[] soapModels = new LmisAbsenceApprovalsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisAbsenceApprovalsSoap[][] toSoapModels(
		LmisAbsenceApprovals[][] models) {
		LmisAbsenceApprovalsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisAbsenceApprovalsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisAbsenceApprovalsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisAbsenceApprovalsSoap[] toSoapModels(
		List<LmisAbsenceApprovals> models) {
		List<LmisAbsenceApprovalsSoap> soapModels = new ArrayList<LmisAbsenceApprovalsSoap>(models.size());

		for (LmisAbsenceApprovals model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisAbsenceApprovalsSoap[soapModels.size()]);
	}

	public LmisAbsenceApprovalsSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisAbsenceApprovalsId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisAbsenceApprovalsId(pk);
	}

	public Integer getLmisAbsenceApprovalsId() {
		return _lmisAbsenceApprovalsId;
	}

	public void setLmisAbsenceApprovalsId(Integer lmisAbsenceApprovalsId) {
		_lmisAbsenceApprovalsId = lmisAbsenceApprovalsId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getRequestId() {
		return _requestId;
	}

	public void setRequestId(int requestId) {
		_requestId = requestId;
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

	public String getReasonApproval() {
		return _reasonApproval;
	}

	public void setReasonApproval(String reasonApproval) {
		_reasonApproval = reasonApproval;
	}

	private Integer _lmisAbsenceApprovalsId;
	private int _rootId;
	private int _requestId;
	private int _approvedBy;
	private Date _approvedAt;
	private boolean _isApproved;
	private boolean _approvedStatus;
	private String _reasonApproval;
}