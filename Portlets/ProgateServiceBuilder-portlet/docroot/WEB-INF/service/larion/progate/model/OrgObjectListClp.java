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

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * <a href="OrgObjectListClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectListClp extends BaseModelImpl<OrgObjectList>
	implements OrgObjectList {
	public OrgObjectListClp() {
	}

	public Integer getPrimaryKey() {
		return _orgObjectListId;
	}

	public void setPrimaryKey(Integer pk) {
		setOrgObjectListId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _orgObjectListId;
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

	public OrgObjectList toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			OrgObjectList model = new OrgObjectListClp();

			model.setEscapedModel(true);

			model.setOrgObjectListId(getOrgObjectListId());
			model.setOrg_id(getOrg_id());
			model.setName(HtmlUtil.escape(getName()));
			model.setDescription(HtmlUtil.escape(getDescription()));
			model.setCreated_date(getCreated_date());
			model.setYear(getYear());
			model.setObjtype(getObjtype());
			model.setEntering_percent(getEntering_percent());
			model.setCompletion_percent(getCompletion_percent());
			model.setIsapproved(getIsapproved());
			model.setMonth_hash(getMonth_hash());
			model.setValidweight(getValidweight());
			model.setCurrent_total_cost(getCurrent_total_cost());
			model.setExpected_completion(getExpected_completion());
			model.setNext_total_cost(getNext_total_cost());
			model.setConsistency_ratio(getConsistency_ratio());
			model.setParentid(getParentid());

			model = (OrgObjectList)Proxy.newProxyInstance(OrgObjectList.class.getClassLoader(),
					new Class[] { OrgObjectList.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		OrgObjectListClp clone = new OrgObjectListClp();

		clone.setOrgObjectListId(getOrgObjectListId());
		clone.setOrg_id(getOrg_id());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setCreated_date(getCreated_date());
		clone.setYear(getYear());
		clone.setObjtype(getObjtype());
		clone.setEntering_percent(getEntering_percent());
		clone.setCompletion_percent(getCompletion_percent());
		clone.setIsapproved(getIsapproved());
		clone.setMonth_hash(getMonth_hash());
		clone.setValidweight(getValidweight());
		clone.setCurrent_total_cost(getCurrent_total_cost());
		clone.setExpected_completion(getExpected_completion());
		clone.setNext_total_cost(getNext_total_cost());
		clone.setConsistency_ratio(getConsistency_ratio());
		clone.setParentid(getParentid());

		return clone;
	}

	public int compareTo(OrgObjectList orgObjectList) {
		int value = 0;

		if (getYear() < orgObjectList.getYear()) {
			value = -1;
		}
		else if (getYear() > orgObjectList.getYear()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		if (getMonth_hash() < orgObjectList.getMonth_hash()) {
			value = -1;
		}
		else if (getMonth_hash() > orgObjectList.getMonth_hash()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getName().compareTo(orgObjectList.getName());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		OrgObjectListClp orgObjectList = null;

		try {
			orgObjectList = (OrgObjectListClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = orgObjectList.getPrimaryKey();

		if (getPrimaryKey().equals(pk)) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("{orgObjectListId=");
		sb.append(getOrgObjectListId());
		sb.append(", org_id=");
		sb.append(getOrg_id());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", created_date=");
		sb.append(getCreated_date());
		sb.append(", year=");
		sb.append(getYear());
		sb.append(", objtype=");
		sb.append(getObjtype());
		sb.append(", entering_percent=");
		sb.append(getEntering_percent());
		sb.append(", completion_percent=");
		sb.append(getCompletion_percent());
		sb.append(", isapproved=");
		sb.append(getIsapproved());
		sb.append(", month_hash=");
		sb.append(getMonth_hash());
		sb.append(", validweight=");
		sb.append(getValidweight());
		sb.append(", current_total_cost=");
		sb.append(getCurrent_total_cost());
		sb.append(", expected_completion=");
		sb.append(getExpected_completion());
		sb.append(", next_total_cost=");
		sb.append(getNext_total_cost());
		sb.append(", consistency_ratio=");
		sb.append(getConsistency_ratio());
		sb.append(", parentid=");
		sb.append(getParentid());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.OrgObjectList");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>orgObjectListId</column-name><column-value><![CDATA[");
		sb.append(getOrgObjectListId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>org_id</column-name><column-value><![CDATA[");
		sb.append(getOrg_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>created_date</column-name><column-value><![CDATA[");
		sb.append(getCreated_date());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>year</column-name><column-value><![CDATA[");
		sb.append(getYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>objtype</column-name><column-value><![CDATA[");
		sb.append(getObjtype());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entering_percent</column-name><column-value><![CDATA[");
		sb.append(getEntering_percent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>completion_percent</column-name><column-value><![CDATA[");
		sb.append(getCompletion_percent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isapproved</column-name><column-value><![CDATA[");
		sb.append(getIsapproved());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>month_hash</column-name><column-value><![CDATA[");
		sb.append(getMonth_hash());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>validweight</column-name><column-value><![CDATA[");
		sb.append(getValidweight());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>current_total_cost</column-name><column-value><![CDATA[");
		sb.append(getCurrent_total_cost());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expected_completion</column-name><column-value><![CDATA[");
		sb.append(getExpected_completion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>next_total_cost</column-name><column-value><![CDATA[");
		sb.append(getNext_total_cost());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>consistency_ratio</column-name><column-value><![CDATA[");
		sb.append(getConsistency_ratio());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentid</column-name><column-value><![CDATA[");
		sb.append(getParentid());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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