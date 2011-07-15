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
 * <a href="LmisViewOTAppSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewOTAppSoap implements Serializable {
	public static LmisViewOTAppSoap toSoapModel(LmisViewOTApp model) {
		LmisViewOTAppSoap soapModel = new LmisViewOTAppSoap();

		soapModel.setLmisViewOTAppId(model.getLmisViewOTAppId());
		soapModel.setRootId(model.getRootId());
		soapModel.setOrgId(model.getOrgId());
		soapModel.setRequestedBy(model.getRequestedBy());
		soapModel.setRequestedAt(model.getRequestedAt());
		soapModel.setRequestedReason(model.getRequestedReason());
		soapModel.setRequestedStatus(model.getRequestedStatus());
		soapModel.setCreatedAt(model.getCreatedAt());
		soapModel.setUpdatedAt(model.getUpdatedAt());
		soapModel.setApprovedBy(model.getApprovedBy());
		soapModel.setApprovedAt(model.getApprovedAt());
		soapModel.setIsApproved(model.getIsApproved());
		soapModel.setApprovedStatus(model.getApprovedStatus());
		soapModel.setApprovedReason(model.getApprovedReason());

		return soapModel;
	}

	public static LmisViewOTAppSoap[] toSoapModels(LmisViewOTApp[] models) {
		LmisViewOTAppSoap[] soapModels = new LmisViewOTAppSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisViewOTAppSoap[][] toSoapModels(LmisViewOTApp[][] models) {
		LmisViewOTAppSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisViewOTAppSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisViewOTAppSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisViewOTAppSoap[] toSoapModels(List<LmisViewOTApp> models) {
		List<LmisViewOTAppSoap> soapModels = new ArrayList<LmisViewOTAppSoap>(models.size());

		for (LmisViewOTApp model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisViewOTAppSoap[soapModels.size()]);
	}

	public LmisViewOTAppSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisViewOTAppId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisViewOTAppId(pk);
	}

	public Integer getLmisViewOTAppId() {
		return _lmisViewOTAppId;
	}

	public void setLmisViewOTAppId(Integer lmisViewOTAppId) {
		_lmisViewOTAppId = lmisViewOTAppId;
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

	public String getApprovedReason() {
		return _approvedReason;
	}

	public void setApprovedReason(String approvedReason) {
		_approvedReason = approvedReason;
	}

	private Integer _lmisViewOTAppId;
	private int _rootId;
	private int _orgId;
	private int _requestedBy;
	private Date _requestedAt;
	private String _requestedReason;
	private int _requestedStatus;
	private Date _createdAt;
	private Date _updatedAt;
	private int _approvedBy;
	private Date _approvedAt;
	private boolean _isApproved;
	private boolean _approvedStatus;
	private String _approvedReason;
}