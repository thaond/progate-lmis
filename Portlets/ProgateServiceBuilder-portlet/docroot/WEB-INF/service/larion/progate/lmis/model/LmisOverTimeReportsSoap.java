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
 * <a href="LmisOverTimeReportsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOverTimeReportsSoap implements Serializable {
	public static LmisOverTimeReportsSoap toSoapModel(LmisOverTimeReports model) {
		LmisOverTimeReportsSoap soapModel = new LmisOverTimeReportsSoap();

		soapModel.setLmisOverTimeReportsId(model.getLmisOverTimeReportsId());
		soapModel.setRootId(model.getRootId());
		soapModel.setReportedBy(model.getReportedBy());
		soapModel.setReportedAt(model.getReportedAt());
		soapModel.setReportedReason(model.getReportedReason());
		soapModel.setReportedStatus(model.getReportedStatus());
		soapModel.setCreatedAt(model.getCreatedAt());
		soapModel.setUpdatedAt(model.getUpdatedAt());
		soapModel.setRequestId(model.getRequestId());
		soapModel.setOrgId(model.getOrgId());

		return soapModel;
	}

	public static LmisOverTimeReportsSoap[] toSoapModels(
		LmisOverTimeReports[] models) {
		LmisOverTimeReportsSoap[] soapModels = new LmisOverTimeReportsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisOverTimeReportsSoap[][] toSoapModels(
		LmisOverTimeReports[][] models) {
		LmisOverTimeReportsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisOverTimeReportsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisOverTimeReportsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisOverTimeReportsSoap[] toSoapModels(
		List<LmisOverTimeReports> models) {
		List<LmisOverTimeReportsSoap> soapModels = new ArrayList<LmisOverTimeReportsSoap>(models.size());

		for (LmisOverTimeReports model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisOverTimeReportsSoap[soapModels.size()]);
	}

	public LmisOverTimeReportsSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisOverTimeReportsId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisOverTimeReportsId(pk);
	}

	public Integer getLmisOverTimeReportsId() {
		return _lmisOverTimeReportsId;
	}

	public void setLmisOverTimeReportsId(Integer lmisOverTimeReportsId) {
		_lmisOverTimeReportsId = lmisOverTimeReportsId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
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

	public int getRequestId() {
		return _requestId;
	}

	public void setRequestId(int requestId) {
		_requestId = requestId;
	}

	public int getOrgId() {
		return _orgId;
	}

	public void setOrgId(int orgId) {
		_orgId = orgId;
	}

	private Integer _lmisOverTimeReportsId;
	private int _rootId;
	private int _reportedBy;
	private Date _reportedAt;
	private String _reportedReason;
	private int _reportedStatus;
	private Date _createdAt;
	private Date _updatedAt;
	private int _requestId;
	private int _orgId;
}