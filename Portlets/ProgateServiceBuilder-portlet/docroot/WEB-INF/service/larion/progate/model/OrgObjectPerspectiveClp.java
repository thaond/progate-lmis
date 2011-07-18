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

/**
 * <a href="OrgObjectPerspectiveClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectPerspectiveClp extends BaseModelImpl<OrgObjectPerspective>
	implements OrgObjectPerspective {
	public OrgObjectPerspectiveClp() {
	}

	public Integer getPrimaryKey() {
		return _orgObjectPerspectiveId;
	}

	public void setPrimaryKey(Integer pk) {
		setOrgObjectPerspectiveId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _orgObjectPerspectiveId;
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

	public OrgObjectPerspective toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			OrgObjectPerspective model = new OrgObjectPerspectiveClp();

			model.setEscapedModel(true);

			model.setOrgObjectPerspectiveId(getOrgObjectPerspectiveId());
			model.setOrgObjectListId(getOrgObjectListId());
			model.setName(HtmlUtil.escape(getName()));
			model.setDescription(HtmlUtil.escape(getDescription()));
			model.setWeight_percent(getWeight_percent());
			model.setEntering_percent(getEntering_percent());
			model.setCompletion_percent(getCompletion_percent());
			model.setObjective_count(getObjective_count());
			model.setValidweight(getValidweight());
			model.setPertype(getPertype());
			model.setCurrent_cost(getCurrent_cost());
			model.setNext_cost(getNext_cost());
			model.setNext_cost2(getNext_cost2());
			model.setConsistency_ratio(getConsistency_ratio());
			model.setWeight_percent_suggested(getWeight_percent_suggested());

			model = (OrgObjectPerspective)Proxy.newProxyInstance(OrgObjectPerspective.class.getClassLoader(),
					new Class[] { OrgObjectPerspective.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		OrgObjectPerspectiveClp clone = new OrgObjectPerspectiveClp();

		clone.setOrgObjectPerspectiveId(getOrgObjectPerspectiveId());
		clone.setOrgObjectListId(getOrgObjectListId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setWeight_percent(getWeight_percent());
		clone.setEntering_percent(getEntering_percent());
		clone.setCompletion_percent(getCompletion_percent());
		clone.setObjective_count(getObjective_count());
		clone.setValidweight(getValidweight());
		clone.setPertype(getPertype());
		clone.setCurrent_cost(getCurrent_cost());
		clone.setNext_cost(getNext_cost());
		clone.setNext_cost2(getNext_cost2());
		clone.setConsistency_ratio(getConsistency_ratio());
		clone.setWeight_percent_suggested(getWeight_percent_suggested());

		return clone;
	}

	public int compareTo(OrgObjectPerspective orgObjectPerspective) {
		int value = 0;

		if (getOrgObjectListId() < orgObjectPerspective.getOrgObjectListId()) {
			value = -1;
		}
		else if (getOrgObjectListId() > orgObjectPerspective.getOrgObjectListId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getPertype() < orgObjectPerspective.getPertype()) {
			value = -1;
		}
		else if (getPertype() > orgObjectPerspective.getPertype()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		OrgObjectPerspectiveClp orgObjectPerspective = null;

		try {
			orgObjectPerspective = (OrgObjectPerspectiveClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = orgObjectPerspective.getPrimaryKey();

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

		sb.append("{orgObjectPerspectiveId=");
		sb.append(getOrgObjectPerspectiveId());
		sb.append(", orgObjectListId=");
		sb.append(getOrgObjectListId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", weight_percent=");
		sb.append(getWeight_percent());
		sb.append(", entering_percent=");
		sb.append(getEntering_percent());
		sb.append(", completion_percent=");
		sb.append(getCompletion_percent());
		sb.append(", objective_count=");
		sb.append(getObjective_count());
		sb.append(", validweight=");
		sb.append(getValidweight());
		sb.append(", pertype=");
		sb.append(getPertype());
		sb.append(", current_cost=");
		sb.append(getCurrent_cost());
		sb.append(", next_cost=");
		sb.append(getNext_cost());
		sb.append(", next_cost2=");
		sb.append(getNext_cost2());
		sb.append(", consistency_ratio=");
		sb.append(getConsistency_ratio());
		sb.append(", weight_percent_suggested=");
		sb.append(getWeight_percent_suggested());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.OrgObjectPerspective");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>orgObjectPerspectiveId</column-name><column-value><![CDATA[");
		sb.append(getOrgObjectPerspectiveId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgObjectListId</column-name><column-value><![CDATA[");
		sb.append(getOrgObjectListId());
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
			"<column><column-name>weight_percent</column-name><column-value><![CDATA[");
		sb.append(getWeight_percent());
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
			"<column><column-name>objective_count</column-name><column-value><![CDATA[");
		sb.append(getObjective_count());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>validweight</column-name><column-value><![CDATA[");
		sb.append(getValidweight());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pertype</column-name><column-value><![CDATA[");
		sb.append(getPertype());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>current_cost</column-name><column-value><![CDATA[");
		sb.append(getCurrent_cost());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>next_cost</column-name><column-value><![CDATA[");
		sb.append(getNext_cost());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>next_cost2</column-name><column-value><![CDATA[");
		sb.append(getNext_cost2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>consistency_ratio</column-name><column-value><![CDATA[");
		sb.append(getConsistency_ratio());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>weight_percent_suggested</column-name><column-value><![CDATA[");
		sb.append(getWeight_percent_suggested());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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