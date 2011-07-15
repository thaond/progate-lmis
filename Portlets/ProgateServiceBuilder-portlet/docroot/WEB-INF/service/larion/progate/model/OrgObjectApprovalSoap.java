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
 * <a href="OrgObjectApprovalSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectApprovalSoap implements Serializable {
	public static OrgObjectApprovalSoap toSoapModel(OrgObjectApproval model) {
		OrgObjectApprovalSoap soapModel = new OrgObjectApprovalSoap();

		soapModel.setOrgObjectApprovalId(model.getOrgObjectApprovalId());
		soapModel.setStatus(model.getStatus());
		soapModel.setApproved_at(model.getApproved_at());
		soapModel.setApproved_by(model.getApproved_by());
		soapModel.setReason(model.getReason());
		soapModel.setOrgObjectListId(model.getOrgObjectListId());

		return soapModel;
	}

	public static OrgObjectApprovalSoap[] toSoapModels(
		OrgObjectApproval[] models) {
		OrgObjectApprovalSoap[] soapModels = new OrgObjectApprovalSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrgObjectApprovalSoap[][] toSoapModels(
		OrgObjectApproval[][] models) {
		OrgObjectApprovalSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OrgObjectApprovalSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrgObjectApprovalSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrgObjectApprovalSoap[] toSoapModels(
		List<OrgObjectApproval> models) {
		List<OrgObjectApprovalSoap> soapModels = new ArrayList<OrgObjectApprovalSoap>(models.size());

		for (OrgObjectApproval model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OrgObjectApprovalSoap[soapModels.size()]);
	}

	public OrgObjectApprovalSoap() {
	}

	public Integer getPrimaryKey() {
		return _orgObjectApprovalId;
	}

	public void setPrimaryKey(Integer pk) {
		setOrgObjectApprovalId(pk);
	}

	public Integer getOrgObjectApprovalId() {
		return _orgObjectApprovalId;
	}

	public void setOrgObjectApprovalId(Integer orgObjectApprovalId) {
		_orgObjectApprovalId = orgObjectApprovalId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public Date getApproved_at() {
		return _approved_at;
	}

	public void setApproved_at(Date approved_at) {
		_approved_at = approved_at;
	}

	public int getApproved_by() {
		return _approved_by;
	}

	public void setApproved_by(int approved_by) {
		_approved_by = approved_by;
	}

	public String getReason() {
		return _reason;
	}

	public void setReason(String reason) {
		_reason = reason;
	}

	public int getOrgObjectListId() {
		return _orgObjectListId;
	}

	public void setOrgObjectListId(int orgObjectListId) {
		_orgObjectListId = orgObjectListId;
	}

	private Integer _orgObjectApprovalId;
	private int _status;
	private Date _approved_at;
	private int _approved_by;
	private String _reason;
	private int _orgObjectListId;
}