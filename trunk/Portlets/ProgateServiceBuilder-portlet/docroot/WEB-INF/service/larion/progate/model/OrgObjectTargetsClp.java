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
 * <a href="OrgObjectTargetsClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectTargetsClp extends BaseModelImpl<OrgObjectTargets>
	implements OrgObjectTargets {
	public OrgObjectTargetsClp() {
	}

	public Integer getPrimaryKey() {
		return _orgObjectTargetId;
	}

	public void setPrimaryKey(Integer pk) {
		setOrgObjectTargetId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _orgObjectTargetId;
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

	public OrgObjectTargets toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			OrgObjectTargets model = new OrgObjectTargetsClp();

			model.setEscapedModel(true);

			model.setOrgObjectTargetId(getOrgObjectTargetId());
			model.setOrgObjectMeasureId(getOrgObjectMeasureId());
			model.setName(HtmlUtil.escape(getName()));
			model.setDescription(HtmlUtil.escape(getDescription()));
			model.setCreated_date(getCreated_date());
			model.setValue(getValue());
			model.setMinMax(getMinMax());

			model = (OrgObjectTargets)Proxy.newProxyInstance(OrgObjectTargets.class.getClassLoader(),
					new Class[] { OrgObjectTargets.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		OrgObjectTargetsClp clone = new OrgObjectTargetsClp();

		clone.setOrgObjectTargetId(getOrgObjectTargetId());
		clone.setOrgObjectMeasureId(getOrgObjectMeasureId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setCreated_date(getCreated_date());
		clone.setValue(getValue());
		clone.setMinMax(getMinMax());

		return clone;
	}

	public int compareTo(OrgObjectTargets orgObjectTargets) {
		int value = 0;

		if (getOrgObjectMeasureId() < orgObjectTargets.getOrgObjectMeasureId()) {
			value = -1;
		}
		else if (getOrgObjectMeasureId() > orgObjectTargets.getOrgObjectMeasureId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getOrgObjectTargetId()
					.compareTo(orgObjectTargets.getOrgObjectTargetId());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		OrgObjectTargetsClp orgObjectTargets = null;

		try {
			orgObjectTargets = (OrgObjectTargetsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = orgObjectTargets.getPrimaryKey();

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

		sb.append("{orgObjectTargetId=");
		sb.append(getOrgObjectTargetId());
		sb.append(", orgObjectMeasureId=");
		sb.append(getOrgObjectMeasureId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", created_date=");
		sb.append(getCreated_date());
		sb.append(", value=");
		sb.append(getValue());
		sb.append(", minMax=");
		sb.append(getMinMax());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.OrgObjectTargets");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>orgObjectTargetId</column-name><column-value><![CDATA[");
		sb.append(getOrgObjectTargetId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgObjectMeasureId</column-name><column-value><![CDATA[");
		sb.append(getOrgObjectMeasureId());
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
			"<column><column-name>value</column-name><column-value><![CDATA[");
		sb.append(getValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>minMax</column-name><column-value><![CDATA[");
		sb.append(getMinMax());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _orgObjectTargetId;
	private int _orgObjectMeasureId;
	private String _name;
	private String _description;
	private Date _created_date;
	private double _value;
	private boolean _minMax;
}