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

package larion.progate.cds.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="CdsEvaluationPeriodsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsEvaluationPeriodsSoap implements Serializable {
	public static CdsEvaluationPeriodsSoap toSoapModel(
		CdsEvaluationPeriods model) {
		CdsEvaluationPeriodsSoap soapModel = new CdsEvaluationPeriodsSoap();

		soapModel.setCdsEvaluationPeriodsId(model.getCdsEvaluationPeriodsId());
		soapModel.setRootId(model.getRootId());
		soapModel.setName(model.getName());
		soapModel.setFromDate(model.getFromDate());
		soapModel.setToDate(model.getToDate());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreatedAt(model.getCreatedAt());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedAt(model.getUpdatedAt());
		soapModel.setIsModified(model.getIsModified());

		return soapModel;
	}

	public static CdsEvaluationPeriodsSoap[] toSoapModels(
		CdsEvaluationPeriods[] models) {
		CdsEvaluationPeriodsSoap[] soapModels = new CdsEvaluationPeriodsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CdsEvaluationPeriodsSoap[][] toSoapModels(
		CdsEvaluationPeriods[][] models) {
		CdsEvaluationPeriodsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CdsEvaluationPeriodsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CdsEvaluationPeriodsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CdsEvaluationPeriodsSoap[] toSoapModels(
		List<CdsEvaluationPeriods> models) {
		List<CdsEvaluationPeriodsSoap> soapModels = new ArrayList<CdsEvaluationPeriodsSoap>(models.size());

		for (CdsEvaluationPeriods model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CdsEvaluationPeriodsSoap[soapModels.size()]);
	}

	public CdsEvaluationPeriodsSoap() {
	}

	public Integer getPrimaryKey() {
		return _CdsEvaluationPeriodsId;
	}

	public void setPrimaryKey(Integer pk) {
		setCdsEvaluationPeriodsId(pk);
	}

	public Integer getCdsEvaluationPeriodsId() {
		return _CdsEvaluationPeriodsId;
	}

	public void setCdsEvaluationPeriodsId(Integer CdsEvaluationPeriodsId) {
		_CdsEvaluationPeriodsId = CdsEvaluationPeriodsId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public Date getFromDate() {
		return _fromDate;
	}

	public void setFromDate(Date fromDate) {
		_fromDate = fromDate;
	}

	public Date getToDate() {
		return _toDate;
	}

	public void setToDate(Date toDate) {
		_toDate = toDate;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public int getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(int createdBy) {
		_createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return _createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		_createdAt = createdAt;
	}

	public int getUpdatedBy() {
		return _updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		_updatedBy = updatedBy;
	}

	public Date getUpdatedAt() {
		return _updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		_updatedAt = updatedAt;
	}

	public boolean getIsModified() {
		return _isModified;
	}

	public boolean isIsModified() {
		return _isModified;
	}

	public void setIsModified(boolean isModified) {
		_isModified = isModified;
	}

	private Integer _CdsEvaluationPeriodsId;
	private int _rootId;
	private String _name;
	private Date _fromDate;
	private Date _toDate;
	private Date _startDate;
	private Date _endDate;
	private int _status;
	private int _createdBy;
	private Date _createdAt;
	private int _updatedBy;
	private Date _updatedAt;
	private boolean _isModified;
}