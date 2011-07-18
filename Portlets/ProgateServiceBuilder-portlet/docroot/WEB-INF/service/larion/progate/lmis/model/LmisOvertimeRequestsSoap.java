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
 * <a href="LmisOvertimeRequestsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOvertimeRequestsSoap implements Serializable {
	public static LmisOvertimeRequestsSoap toSoapModel(
		LmisOvertimeRequests model) {
		LmisOvertimeRequestsSoap soapModel = new LmisOvertimeRequestsSoap();

		soapModel.setLmisOvertimeRequestsId(model.getLmisOvertimeRequestsId());
		soapModel.setRootId(model.getRootId());
		soapModel.setRequestedBy(model.getRequestedBy());
		soapModel.setRequestedAt(model.getRequestedAt());
		soapModel.setRequestedReason(model.getRequestedReason());
		soapModel.setRequestedStatus(model.getRequestedStatus());
		soapModel.setCreatedAt(model.getCreatedAt());
		soapModel.setUpdatedAt(model.getUpdatedAt());
		soapModel.setOrgId(model.getOrgId());

		return soapModel;
	}

	public static LmisOvertimeRequestsSoap[] toSoapModels(
		LmisOvertimeRequests[] models) {
		LmisOvertimeRequestsSoap[] soapModels = new LmisOvertimeRequestsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisOvertimeRequestsSoap[][] toSoapModels(
		LmisOvertimeRequests[][] models) {
		LmisOvertimeRequestsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisOvertimeRequestsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisOvertimeRequestsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisOvertimeRequestsSoap[] toSoapModels(
		List<LmisOvertimeRequests> models) {
		List<LmisOvertimeRequestsSoap> soapModels = new ArrayList<LmisOvertimeRequestsSoap>(models.size());

		for (LmisOvertimeRequests model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisOvertimeRequestsSoap[soapModels.size()]);
	}

	public LmisOvertimeRequestsSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisOvertimeRequestsId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisOvertimeRequestsId(pk);
	}

	public Integer getLmisOvertimeRequestsId() {
		return _lmisOvertimeRequestsId;
	}

	public void setLmisOvertimeRequestsId(Integer lmisOvertimeRequestsId) {
		_lmisOvertimeRequestsId = lmisOvertimeRequestsId;
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

	private Integer _lmisOvertimeRequestsId;
	private int _rootId;
	private int _requestedBy;
	private Date _requestedAt;
	private String _requestedReason;
	private int _requestedStatus;
	private Date _createdAt;
	private Date _updatedAt;
	private int _orgId;
}