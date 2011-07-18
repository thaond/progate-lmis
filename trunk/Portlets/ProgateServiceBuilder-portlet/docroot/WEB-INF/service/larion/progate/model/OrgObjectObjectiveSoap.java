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
 * <a href="OrgObjectObjectiveSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectObjectiveSoap implements Serializable {
	public static OrgObjectObjectiveSoap toSoapModel(OrgObjectObjective model) {
		OrgObjectObjectiveSoap soapModel = new OrgObjectObjectiveSoap();

		soapModel.setOrgObjectObjectiveId(model.getOrgObjectObjectiveId());
		soapModel.setOrgObjectPerspectiveId(model.getOrgObjectPerspectiveId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setCreated_date(model.getCreated_date());
		soapModel.setWeight_percent(model.getWeight_percent());
		soapModel.setEntering_percent(model.getEntering_percent());
		soapModel.setCompletion_percent(model.getCompletion_percent());
		soapModel.setMeasure_count(model.getMeasure_count());
		soapModel.setValidweight(model.getValidweight());
		soapModel.setConsistency_ratio(model.getConsistency_ratio());
		soapModel.setWeight_percent_suggested(model.getWeight_percent_suggested());

		return soapModel;
	}

	public static OrgObjectObjectiveSoap[] toSoapModels(
		OrgObjectObjective[] models) {
		OrgObjectObjectiveSoap[] soapModels = new OrgObjectObjectiveSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrgObjectObjectiveSoap[][] toSoapModels(
		OrgObjectObjective[][] models) {
		OrgObjectObjectiveSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OrgObjectObjectiveSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrgObjectObjectiveSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrgObjectObjectiveSoap[] toSoapModels(
		List<OrgObjectObjective> models) {
		List<OrgObjectObjectiveSoap> soapModels = new ArrayList<OrgObjectObjectiveSoap>(models.size());

		for (OrgObjectObjective model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OrgObjectObjectiveSoap[soapModels.size()]);
	}

	public OrgObjectObjectiveSoap() {
	}

	public Integer getPrimaryKey() {
		return _orgObjectObjectiveId;
	}

	public void setPrimaryKey(Integer pk) {
		setOrgObjectObjectiveId(pk);
	}

	public Integer getOrgObjectObjectiveId() {
		return _orgObjectObjectiveId;
	}

	public void setOrgObjectObjectiveId(Integer orgObjectObjectiveId) {
		_orgObjectObjectiveId = orgObjectObjectiveId;
	}

	public int getOrgObjectPerspectiveId() {
		return _orgObjectPerspectiveId;
	}

	public void setOrgObjectPerspectiveId(int orgObjectPerspectiveId) {
		_orgObjectPerspectiveId = orgObjectPerspectiveId;
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

	public double getWeight_percent() {
		return _weight_percent;
	}

	public void setWeight_percent(double weight_percent) {
		_weight_percent = weight_percent;
	}

	public double getEntering_percent() {
		return _entering_percent;
	}

	public void setEntering_percent(double entering_percent) {
		_entering_percent = entering_percent;
	}

	public double getCompletion_percent() {
		return _completion_percent;
	}

	public void setCompletion_percent(double completion_percent) {
		_completion_percent = completion_percent;
	}

	public int getMeasure_count() {
		return _measure_count;
	}

	public void setMeasure_count(int measure_count) {
		_measure_count = measure_count;
	}

	public boolean getValidweight() {
		return _validweight;
	}

	public boolean isValidweight() {
		return _validweight;
	}

	public void setValidweight(boolean validweight) {
		_validweight = validweight;
	}

	public double getConsistency_ratio() {
		return _consistency_ratio;
	}

	public void setConsistency_ratio(double consistency_ratio) {
		_consistency_ratio = consistency_ratio;
	}

	public double getWeight_percent_suggested() {
		return _weight_percent_suggested;
	}

	public void setWeight_percent_suggested(double weight_percent_suggested) {
		_weight_percent_suggested = weight_percent_suggested;
	}

	private Integer _orgObjectObjectiveId;
	private int _orgObjectPerspectiveId;
	private String _name;
	private String _description;
	private Date _created_date;
	private double _weight_percent;
	private double _entering_percent;
	private double _completion_percent;
	private int _measure_count;
	private boolean _validweight;
	private double _consistency_ratio;
	private double _weight_percent_suggested;
}