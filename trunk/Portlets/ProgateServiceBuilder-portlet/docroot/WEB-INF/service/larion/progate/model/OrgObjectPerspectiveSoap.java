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
import java.util.List;

/**
 * <a href="OrgObjectPerspectiveSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectPerspectiveSoap implements Serializable {
	public static OrgObjectPerspectiveSoap toSoapModel(
		OrgObjectPerspective model) {
		OrgObjectPerspectiveSoap soapModel = new OrgObjectPerspectiveSoap();

		soapModel.setOrgObjectPerspectiveId(model.getOrgObjectPerspectiveId());
		soapModel.setOrgObjectListId(model.getOrgObjectListId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setWeight_percent(model.getWeight_percent());
		soapModel.setEntering_percent(model.getEntering_percent());
		soapModel.setCompletion_percent(model.getCompletion_percent());
		soapModel.setObjective_count(model.getObjective_count());
		soapModel.setValidweight(model.getValidweight());
		soapModel.setPertype(model.getPertype());
		soapModel.setCurrent_cost(model.getCurrent_cost());
		soapModel.setNext_cost(model.getNext_cost());
		soapModel.setNext_cost2(model.getNext_cost2());
		soapModel.setConsistency_ratio(model.getConsistency_ratio());
		soapModel.setWeight_percent_suggested(model.getWeight_percent_suggested());

		return soapModel;
	}

	public static OrgObjectPerspectiveSoap[] toSoapModels(
		OrgObjectPerspective[] models) {
		OrgObjectPerspectiveSoap[] soapModels = new OrgObjectPerspectiveSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrgObjectPerspectiveSoap[][] toSoapModels(
		OrgObjectPerspective[][] models) {
		OrgObjectPerspectiveSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OrgObjectPerspectiveSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrgObjectPerspectiveSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrgObjectPerspectiveSoap[] toSoapModels(
		List<OrgObjectPerspective> models) {
		List<OrgObjectPerspectiveSoap> soapModels = new ArrayList<OrgObjectPerspectiveSoap>(models.size());

		for (OrgObjectPerspective model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OrgObjectPerspectiveSoap[soapModels.size()]);
	}

	public OrgObjectPerspectiveSoap() {
	}

	public Integer getPrimaryKey() {
		return _orgObjectPerspectiveId;
	}

	public void setPrimaryKey(Integer pk) {
		setOrgObjectPerspectiveId(pk);
	}

	public Integer getOrgObjectPerspectiveId() {
		return _orgObjectPerspectiveId;
	}

	public void setOrgObjectPerspectiveId(Integer orgObjectPerspectiveId) {
		_orgObjectPerspectiveId = orgObjectPerspectiveId;
	}

	public int getOrgObjectListId() {
		return _orgObjectListId;
	}

	public void setOrgObjectListId(int orgObjectListId) {
		_orgObjectListId = orgObjectListId;
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

	public double getObjective_count() {
		return _objective_count;
	}

	public void setObjective_count(double objective_count) {
		_objective_count = objective_count;
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

	public int getPertype() {
		return _pertype;
	}

	public void setPertype(int pertype) {
		_pertype = pertype;
	}

	public double getCurrent_cost() {
		return _current_cost;
	}

	public void setCurrent_cost(double current_cost) {
		_current_cost = current_cost;
	}

	public double getNext_cost() {
		return _next_cost;
	}

	public void setNext_cost(double next_cost) {
		_next_cost = next_cost;
	}

	public double getNext_cost2() {
		return _next_cost2;
	}

	public void setNext_cost2(double next_cost2) {
		_next_cost2 = next_cost2;
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

	private Integer _orgObjectPerspectiveId;
	private int _orgObjectListId;
	private String _name;
	private String _description;
	private double _weight_percent;
	private double _entering_percent;
	private double _completion_percent;
	private double _objective_count;
	private boolean _validweight;
	private int _pertype;
	private double _current_cost;
	private double _next_cost;
	private double _next_cost2;
	private double _consistency_ratio;
	private double _weight_percent_suggested;
}