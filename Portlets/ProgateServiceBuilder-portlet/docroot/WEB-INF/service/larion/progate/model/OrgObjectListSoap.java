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
 * <a href="OrgObjectListSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectListSoap implements Serializable {
	public static OrgObjectListSoap toSoapModel(OrgObjectList model) {
		OrgObjectListSoap soapModel = new OrgObjectListSoap();

		soapModel.setOrgObjectListId(model.getOrgObjectListId());
		soapModel.setOrg_id(model.getOrg_id());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setCreated_date(model.getCreated_date());
		soapModel.setYear(model.getYear());
		soapModel.setObjtype(model.getObjtype());
		soapModel.setEntering_percent(model.getEntering_percent());
		soapModel.setCompletion_percent(model.getCompletion_percent());
		soapModel.setIsapproved(model.getIsapproved());
		soapModel.setMonth_hash(model.getMonth_hash());
		soapModel.setValidweight(model.getValidweight());
		soapModel.setCurrent_total_cost(model.getCurrent_total_cost());
		soapModel.setExpected_completion(model.getExpected_completion());
		soapModel.setNext_total_cost(model.getNext_total_cost());
		soapModel.setConsistency_ratio(model.getConsistency_ratio());
		soapModel.setParentid(model.getParentid());

		return soapModel;
	}

	public static OrgObjectListSoap[] toSoapModels(OrgObjectList[] models) {
		OrgObjectListSoap[] soapModels = new OrgObjectListSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrgObjectListSoap[][] toSoapModels(OrgObjectList[][] models) {
		OrgObjectListSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OrgObjectListSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrgObjectListSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrgObjectListSoap[] toSoapModels(List<OrgObjectList> models) {
		List<OrgObjectListSoap> soapModels = new ArrayList<OrgObjectListSoap>(models.size());

		for (OrgObjectList model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OrgObjectListSoap[soapModels.size()]);
	}

	public OrgObjectListSoap() {
	}

	public Integer getPrimaryKey() {
		return _orgObjectListId;
	}

	public void setPrimaryKey(Integer pk) {
		setOrgObjectListId(pk);
	}

	public Integer getOrgObjectListId() {
		return _orgObjectListId;
	}

	public void setOrgObjectListId(Integer orgObjectListId) {
		_orgObjectListId = orgObjectListId;
	}

	public int getOrg_id() {
		return _org_id;
	}

	public void setOrg_id(int org_id) {
		_org_id = org_id;
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

	public int getYear() {
		return _year;
	}

	public void setYear(int year) {
		_year = year;
	}

	public int getObjtype() {
		return _objtype;
	}

	public void setObjtype(int objtype) {
		_objtype = objtype;
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

	public boolean getIsapproved() {
		return _isapproved;
	}

	public boolean isIsapproved() {
		return _isapproved;
	}

	public void setIsapproved(boolean isapproved) {
		_isapproved = isapproved;
	}

	public int getMonth_hash() {
		return _month_hash;
	}

	public void setMonth_hash(int month_hash) {
		_month_hash = month_hash;
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

	public double getCurrent_total_cost() {
		return _current_total_cost;
	}

	public void setCurrent_total_cost(double current_total_cost) {
		_current_total_cost = current_total_cost;
	}

	public double getExpected_completion() {
		return _expected_completion;
	}

	public void setExpected_completion(double expected_completion) {
		_expected_completion = expected_completion;
	}

	public double getNext_total_cost() {
		return _next_total_cost;
	}

	public void setNext_total_cost(double next_total_cost) {
		_next_total_cost = next_total_cost;
	}

	public double getConsistency_ratio() {
		return _consistency_ratio;
	}

	public void setConsistency_ratio(double consistency_ratio) {
		_consistency_ratio = consistency_ratio;
	}

	public int getParentid() {
		return _parentid;
	}

	public void setParentid(int parentid) {
		_parentid = parentid;
	}

	private Integer _orgObjectListId;
	private int _org_id;
	private String _name;
	private String _description;
	private Date _created_date;
	private int _year;
	private int _objtype;
	private double _entering_percent;
	private double _completion_percent;
	private boolean _isapproved;
	private int _month_hash;
	private boolean _validweight;
	private double _current_total_cost;
	private double _expected_completion;
	private double _next_total_cost;
	private double _consistency_ratio;
	private int _parentid;
}