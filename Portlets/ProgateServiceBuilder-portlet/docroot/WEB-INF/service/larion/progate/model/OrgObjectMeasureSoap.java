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
 * <a href="OrgObjectMeasureSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectMeasureSoap implements Serializable {
	public static OrgObjectMeasureSoap toSoapModel(OrgObjectMeasure model) {
		OrgObjectMeasureSoap soapModel = new OrgObjectMeasureSoap();

		soapModel.setOrgObjectMeasureId(model.getOrgObjectMeasureId());
		soapModel.setOrgObjectObjectiveId(model.getOrgObjectObjectiveId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setCreated_date(model.getCreated_date());
		soapModel.setWeight_percent(model.getWeight_percent());
		soapModel.setIsassessed(model.getIsassessed());
		soapModel.setResult(model.getResult());
		soapModel.setEntering_percent(model.getEntering_percent());
		soapModel.setCompletion_percent(model.getCompletion_percent());
		soapModel.setFormula(model.getFormula());
		soapModel.setTarget_count(model.getTarget_count());
		soapModel.setInterpretation(model.getInterpretation());
		soapModel.setWeight_percent_suggested(model.getWeight_percent_suggested());

		return soapModel;
	}

	public static OrgObjectMeasureSoap[] toSoapModels(OrgObjectMeasure[] models) {
		OrgObjectMeasureSoap[] soapModels = new OrgObjectMeasureSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrgObjectMeasureSoap[][] toSoapModels(
		OrgObjectMeasure[][] models) {
		OrgObjectMeasureSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OrgObjectMeasureSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrgObjectMeasureSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrgObjectMeasureSoap[] toSoapModels(
		List<OrgObjectMeasure> models) {
		List<OrgObjectMeasureSoap> soapModels = new ArrayList<OrgObjectMeasureSoap>(models.size());

		for (OrgObjectMeasure model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OrgObjectMeasureSoap[soapModels.size()]);
	}

	public OrgObjectMeasureSoap() {
	}

	public Integer getPrimaryKey() {
		return _orgObjectMeasureId;
	}

	public void setPrimaryKey(Integer pk) {
		setOrgObjectMeasureId(pk);
	}

	public Integer getOrgObjectMeasureId() {
		return _orgObjectMeasureId;
	}

	public void setOrgObjectMeasureId(Integer orgObjectMeasureId) {
		_orgObjectMeasureId = orgObjectMeasureId;
	}

	public int getOrgObjectObjectiveId() {
		return _OrgObjectObjectiveId;
	}

	public void setOrgObjectObjectiveId(int OrgObjectObjectiveId) {
		_OrgObjectObjectiveId = OrgObjectObjectiveId;
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

	public boolean getIsassessed() {
		return _isassessed;
	}

	public boolean isIsassessed() {
		return _isassessed;
	}

	public void setIsassessed(boolean isassessed) {
		_isassessed = isassessed;
	}

	public double getResult() {
		return _result;
	}

	public void setResult(double result) {
		_result = result;
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

	public String getFormula() {
		return _formula;
	}

	public void setFormula(String formula) {
		_formula = formula;
	}

	public int getTarget_count() {
		return _target_count;
	}

	public void setTarget_count(int target_count) {
		_target_count = target_count;
	}

	public String getInterpretation() {
		return _interpretation;
	}

	public void setInterpretation(String interpretation) {
		_interpretation = interpretation;
	}

	public double getWeight_percent_suggested() {
		return _weight_percent_suggested;
	}

	public void setWeight_percent_suggested(double weight_percent_suggested) {
		_weight_percent_suggested = weight_percent_suggested;
	}

	private Integer _orgObjectMeasureId;
	private int _OrgObjectObjectiveId;
	private String _name;
	private String _description;
	private Date _created_date;
	private double _weight_percent;
	private boolean _isassessed;
	private double _result;
	private double _entering_percent;
	private double _completion_percent;
	private String _formula;
	private int _target_count;
	private String _interpretation;
	private double _weight_percent_suggested;
}