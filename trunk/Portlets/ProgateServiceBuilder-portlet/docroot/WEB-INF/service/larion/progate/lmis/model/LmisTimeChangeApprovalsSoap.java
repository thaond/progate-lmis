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
 * <a href="LmisTimeChangeApprovalsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisTimeChangeApprovalsSoap implements Serializable {
	public static LmisTimeChangeApprovalsSoap toSoapModel(
		LmisTimeChangeApprovals model) {
		LmisTimeChangeApprovalsSoap soapModel = new LmisTimeChangeApprovalsSoap();

		soapModel.setLmisTimeChangeApprovalId(model.getLmisTimeChangeApprovalId());
		soapModel.setRootId(model.getRootId());
		soapModel.setRequestId(model.getRequestId());
		soapModel.setApprovedBy(model.getApprovedBy());
		soapModel.setApprovedAt(model.getApprovedAt());
		soapModel.setIsApproved(model.getIsApproved());
		soapModel.setApprovedStatus(model.getApprovedStatus());
		soapModel.setReason(model.getReason());

		return soapModel;
	}

	public static LmisTimeChangeApprovalsSoap[] toSoapModels(
		LmisTimeChangeApprovals[] models) {
		LmisTimeChangeApprovalsSoap[] soapModels = new LmisTimeChangeApprovalsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisTimeChangeApprovalsSoap[][] toSoapModels(
		LmisTimeChangeApprovals[][] models) {
		LmisTimeChangeApprovalsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisTimeChangeApprovalsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisTimeChangeApprovalsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisTimeChangeApprovalsSoap[] toSoapModels(
		List<LmisTimeChangeApprovals> models) {
		List<LmisTimeChangeApprovalsSoap> soapModels = new ArrayList<LmisTimeChangeApprovalsSoap>(models.size());

		for (LmisTimeChangeApprovals model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisTimeChangeApprovalsSoap[soapModels.size()]);
	}

	public LmisTimeChangeApprovalsSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisTimeChangeApprovalId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisTimeChangeApprovalId(pk);
	}

	public Integer getLmisTimeChangeApprovalId() {
		return _lmisTimeChangeApprovalId;
	}

	public void setLmisTimeChangeApprovalId(Integer lmisTimeChangeApprovalId) {
		_lmisTimeChangeApprovalId = lmisTimeChangeApprovalId;
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

	public String getReason() {
		return _Reason;
	}

	public void setReason(String Reason) {
		_Reason = Reason;
	}

	private Integer _lmisTimeChangeApprovalId;
	private int _rootId;
	private int _requestId;
	private int _approvedBy;
	private Date _approvedAt;
	private boolean _isApproved;
	private boolean _approvedStatus;
	private String _Reason;
}