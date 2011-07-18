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
 * <a href="LmisViewOvertimeReportSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewOvertimeReportSoap implements Serializable {
	public static LmisViewOvertimeReportSoap toSoapModel(
		LmisViewOvertimeReport model) {
		LmisViewOvertimeReportSoap soapModel = new LmisViewOvertimeReportSoap();

		soapModel.setLmisViewOvertimeReportId(model.getLmisViewOvertimeReportId());
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

		return soapModel;
	}

	public static LmisViewOvertimeReportSoap[] toSoapModels(
		LmisViewOvertimeReport[] models) {
		LmisViewOvertimeReportSoap[] soapModels = new LmisViewOvertimeReportSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisViewOvertimeReportSoap[][] toSoapModels(
		LmisViewOvertimeReport[][] models) {
		LmisViewOvertimeReportSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisViewOvertimeReportSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisViewOvertimeReportSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisViewOvertimeReportSoap[] toSoapModels(
		List<LmisViewOvertimeReport> models) {
		List<LmisViewOvertimeReportSoap> soapModels = new ArrayList<LmisViewOvertimeReportSoap>(models.size());

		for (LmisViewOvertimeReport model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisViewOvertimeReportSoap[soapModels.size()]);
	}

	public LmisViewOvertimeReportSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisViewOvertimeReportId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisViewOvertimeReportId(pk);
	}

	public Integer getLmisViewOvertimeReportId() {
		return _lmisViewOvertimeReportId;
	}

	public void setLmisViewOvertimeReportId(Integer lmisViewOvertimeReportId) {
		_lmisViewOvertimeReportId = lmisViewOvertimeReportId;
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

	private Integer _lmisViewOvertimeReportId;
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
}