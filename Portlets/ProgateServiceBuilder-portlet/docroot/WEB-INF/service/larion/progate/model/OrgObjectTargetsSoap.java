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
 * <a href="OrgObjectTargetsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectTargetsSoap implements Serializable {
	public static OrgObjectTargetsSoap toSoapModel(OrgObjectTargets model) {
		OrgObjectTargetsSoap soapModel = new OrgObjectTargetsSoap();

		soapModel.setOrgObjectTargetId(model.getOrgObjectTargetId());
		soapModel.setOrgObjectMeasureId(model.getOrgObjectMeasureId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setCreated_date(model.getCreated_date());
		soapModel.setValue(model.getValue());
		soapModel.setMinMax(model.getMinMax());

		return soapModel;
	}

	public static OrgObjectTargetsSoap[] toSoapModels(OrgObjectTargets[] models) {
		OrgObjectTargetsSoap[] soapModels = new OrgObjectTargetsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrgObjectTargetsSoap[][] toSoapModels(
		OrgObjectTargets[][] models) {
		OrgObjectTargetsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OrgObjectTargetsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrgObjectTargetsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrgObjectTargetsSoap[] toSoapModels(
		List<OrgObjectTargets> models) {
		List<OrgObjectTargetsSoap> soapModels = new ArrayList<OrgObjectTargetsSoap>(models.size());

		for (OrgObjectTargets model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OrgObjectTargetsSoap[soapModels.size()]);
	}

	public OrgObjectTargetsSoap() {
	}

	public Integer getPrimaryKey() {
		return _orgObjectTargetId;
	}

	public void setPrimaryKey(Integer pk) {
		setOrgObjectTargetId(pk);
	}

	public Integer getOrgObjectTargetId() {
		return _orgObjectTargetId;
	}

	public void setOrgObjectTargetId(Integer orgObjectTargetId) {
		_orgObjectTargetId = orgObjectTargetId;
	}

	public int getOrgObjectMeasureId() {
		return _orgObjectMeasureId;
	}

	public void setOrgObjectMeasureId(int orgObjectMeasureId) {
		_orgObjectMeasureId = orgObjectMeasureId;
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

	public Date getCreated_date() {
		return _created_date;
	}

	public void setCreated_date(Date created_date) {
		_created_date = created_date;
	}

	public double getValue() {
		return _value;
	}

	public void setValue(double value) {
		_value = value;
	}

	public boolean getMinMax() {
		return _minMax;
	}

	public boolean isMinMax() {
		return _minMax;
	}

	public void setMinMax(boolean minMax) {
		_minMax = minMax;
	}

	private Integer _orgObjectTargetId;
	private int _orgObjectMeasureId;
	private String _name;
	private String _description;
	private Date _created_date;
	private double _value;
	private boolean _minMax;
}