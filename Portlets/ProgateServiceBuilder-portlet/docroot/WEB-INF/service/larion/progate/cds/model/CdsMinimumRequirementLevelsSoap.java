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
 * <a href="CdsMinimumRequirementLevelsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsMinimumRequirementLevelsSoap implements Serializable {
	public static CdsMinimumRequirementLevelsSoap toSoapModel(
		CdsMinimumRequirementLevels model) {
		CdsMinimumRequirementLevelsSoap soapModel = new CdsMinimumRequirementLevelsSoap();

		soapModel.setMinimumRequirementLevelId(model.getMinimumRequirementLevelId());
		soapModel.setMinimumRequirementId(model.getMinimumRequirementId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setNumberOrder(model.getNumberOrder());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreatedAt(model.getCreatedAt());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedAt(model.getUpdatedAt());

		return soapModel;
	}

	public static CdsMinimumRequirementLevelsSoap[] toSoapModels(
		CdsMinimumRequirementLevels[] models) {
		CdsMinimumRequirementLevelsSoap[] soapModels = new CdsMinimumRequirementLevelsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CdsMinimumRequirementLevelsSoap[][] toSoapModels(
		CdsMinimumRequirementLevels[][] models) {
		CdsMinimumRequirementLevelsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CdsMinimumRequirementLevelsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CdsMinimumRequirementLevelsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CdsMinimumRequirementLevelsSoap[] toSoapModels(
		List<CdsMinimumRequirementLevels> models) {
		List<CdsMinimumRequirementLevelsSoap> soapModels = new ArrayList<CdsMinimumRequirementLevelsSoap>(models.size());

		for (CdsMinimumRequirementLevels model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CdsMinimumRequirementLevelsSoap[soapModels.size()]);
	}

	public CdsMinimumRequirementLevelsSoap() {
	}

	public Integer getPrimaryKey() {
		return _minimumRequirementLevelId;
	}

	public void setPrimaryKey(Integer pk) {
		setMinimumRequirementLevelId(pk);
	}

	public Integer getMinimumRequirementLevelId() {
		return _minimumRequirementLevelId;
	}

	public void setMinimumRequirementLevelId(Integer minimumRequirementLevelId) {
		_minimumRequirementLevelId = minimumRequirementLevelId;
	}

	public int getMinimumRequirementId() {
		return _minimumRequirementId;
	}

	public void setMinimumRequirementId(int minimumRequirementId) {
		_minimumRequirementId = minimumRequirementId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getNumberOrder() {
		return _numberOrder;
	}

	public void setNumberOrder(int numberOrder) {
		_numberOrder = numberOrder;
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

	private Integer _minimumRequirementLevelId;
	private int _minimumRequirementId;
	private String _name;
	private String _description;
	private int _numberOrder;
	private int _createdBy;
	private Date _createdAt;
	private int _updatedBy;
	private Date _updatedAt;
}