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
 * <a href="CdsPointsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsPointsSoap implements Serializable {
	public static CdsPointsSoap toSoapModel(CdsPoints model) {
		CdsPointsSoap soapModel = new CdsPointsSoap();

		soapModel.setPointId(model.getPointId());
		soapModel.setRootId(model.getRootId());
		soapModel.setPointName(model.getPointName());
		soapModel.setPointValue(model.getPointValue());
		soapModel.setDescription(model.getDescription());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreatedAt(model.getCreatedAt());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedAt(model.getUpdatedAt());

		return soapModel;
	}

	public static CdsPointsSoap[] toSoapModels(CdsPoints[] models) {
		CdsPointsSoap[] soapModels = new CdsPointsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CdsPointsSoap[][] toSoapModels(CdsPoints[][] models) {
		CdsPointsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CdsPointsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CdsPointsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CdsPointsSoap[] toSoapModels(List<CdsPoints> models) {
		List<CdsPointsSoap> soapModels = new ArrayList<CdsPointsSoap>(models.size());

		for (CdsPoints model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CdsPointsSoap[soapModels.size()]);
	}

	public CdsPointsSoap() {
	}

	public Integer getPrimaryKey() {
		return _pointId;
	}

	public void setPrimaryKey(Integer pk) {
		setPointId(pk);
	}

	public Integer getPointId() {
		return _pointId;
	}

	public void setPointId(Integer pointId) {
		_pointId = pointId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public String getPointName() {
		return _pointName;
	}

	public void setPointName(String pointName) {
		_pointName = pointName;
	}

	public int getPointValue() {
		return _pointValue;
	}

	public void setPointValue(int pointValue) {
		_pointValue = pointValue;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
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

	private Integer _pointId;
	private int _rootId;
	private String _pointName;
	private int _pointValue;
	private String _description;
	private int _createdBy;
	private Date _createdAt;
	private int _updatedBy;
	private Date _updatedAt;
}