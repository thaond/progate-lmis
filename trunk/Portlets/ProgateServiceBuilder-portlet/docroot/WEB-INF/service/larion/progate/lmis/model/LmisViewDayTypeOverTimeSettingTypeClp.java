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

package larion.progate.lmis.model;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * <a href="LmisViewDayTypeOverTimeSettingTypeClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewDayTypeOverTimeSettingTypeClp extends BaseModelImpl<LmisViewDayTypeOverTimeSettingType>
	implements LmisViewDayTypeOverTimeSettingType {
	public LmisViewDayTypeOverTimeSettingTypeClp() {
	}

	public Integer getPrimaryKey() {
		return _lmisViewDayTypeOverTimeSettingTypeId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisViewDayTypeOverTimeSettingTypeId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisViewDayTypeOverTimeSettingTypeId;
	}

	public Integer getLmisViewDayTypeOverTimeSettingTypeId() {
		return _lmisViewDayTypeOverTimeSettingTypeId;
	}

	public void setLmisViewDayTypeOverTimeSettingTypeId(
		Integer lmisViewDayTypeOverTimeSettingTypeId) {
		_lmisViewDayTypeOverTimeSettingTypeId = lmisViewDayTypeOverTimeSettingTypeId;
	}

	public int getOtTypeId() {
		return _otTypeId;
	}

	public void setOtTypeId(int otTypeId) {
		_otTypeId = otTypeId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getDayType() {
		return _dayType;
	}

	public void setDayType(int dayType) {
		_dayType = dayType;
	}

	public int getOtId() {
		return _otId;
	}

	public void setOtId(int otId) {
		_otId = otId;
	}

	public double getCoefficient() {
		return _coefficient;
	}

	public void setCoefficient(double coefficient) {
		_coefficient = coefficient;
	}

	public String getNameOvertimeType() {
		return _nameOvertimeType;
	}

	public void setNameOvertimeType(String nameOvertimeType) {
		_nameOvertimeType = nameOvertimeType;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public LmisViewDayTypeOverTimeSettingType toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			LmisViewDayTypeOverTimeSettingType model = new LmisViewDayTypeOverTimeSettingTypeClp();

			model.setEscapedModel(true);

			model.setLmisViewDayTypeOverTimeSettingTypeId(getLmisViewDayTypeOverTimeSettingTypeId());
			model.setOtTypeId(getOtTypeId());
			model.setRootId(getRootId());
			model.setName(HtmlUtil.escape(getName()));
			model.setDayType(getDayType());
			model.setOtId(getOtId());
			model.setCoefficient(getCoefficient());
			model.setNameOvertimeType(HtmlUtil.escape(getNameOvertimeType()));
			model.setDescription(HtmlUtil.escape(getDescription()));

			model = (LmisViewDayTypeOverTimeSettingType)Proxy.newProxyInstance(LmisViewDayTypeOverTimeSettingType.class.getClassLoader(),
					new Class[] { LmisViewDayTypeOverTimeSettingType.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisViewDayTypeOverTimeSettingTypeClp clone = new LmisViewDayTypeOverTimeSettingTypeClp();

		clone.setLmisViewDayTypeOverTimeSettingTypeId(getLmisViewDayTypeOverTimeSettingTypeId());
		clone.setOtTypeId(getOtTypeId());
		clone.setRootId(getRootId());
		clone.setName(getName());
		clone.setDayType(getDayType());
		clone.setOtId(getOtId());
		clone.setCoefficient(getCoefficient());
		clone.setNameOvertimeType(getNameOvertimeType());
		clone.setDescription(getDescription());

		return clone;
	}

	public int compareTo(
		LmisViewDayTypeOverTimeSettingType lmisViewDayTypeOverTimeSettingType) {
		int value = 0;

		if (getOtTypeId() < lmisViewDayTypeOverTimeSettingType.getOtTypeId()) {
			value = -1;
		}
		else if (getOtTypeId() > lmisViewDayTypeOverTimeSettingType.getOtTypeId()) {
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

		LmisViewDayTypeOverTimeSettingTypeClp lmisViewDayTypeOverTimeSettingType =
			null;

		try {
			lmisViewDayTypeOverTimeSettingType = (LmisViewDayTypeOverTimeSettingTypeClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisViewDayTypeOverTimeSettingType.getPrimaryKey();

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

		sb.append("{lmisViewDayTypeOverTimeSettingTypeId=");
		sb.append(getLmisViewDayTypeOverTimeSettingTypeId());
		sb.append(", otTypeId=");
		sb.append(getOtTypeId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", dayType=");
		sb.append(getDayType());
		sb.append(", otId=");
		sb.append(getOtId());
		sb.append(", coefficient=");
		sb.append(getCoefficient());
		sb.append(", nameOvertimeType=");
		sb.append(getNameOvertimeType());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append(
			"larion.progate.lmis.model.LmisViewDayTypeOverTimeSettingType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisViewDayTypeOverTimeSettingTypeId</column-name><column-value><![CDATA[");
		sb.append(getLmisViewDayTypeOverTimeSettingTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>otTypeId</column-name><column-value><![CDATA[");
		sb.append(getOtTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dayType</column-name><column-value><![CDATA[");
		sb.append(getDayType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>otId</column-name><column-value><![CDATA[");
		sb.append(getOtId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>coefficient</column-name><column-value><![CDATA[");
		sb.append(getCoefficient());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nameOvertimeType</column-name><column-value><![CDATA[");
		sb.append(getNameOvertimeType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisViewDayTypeOverTimeSettingTypeId;
	private int _otTypeId;
	private int _rootId;
	private String _name;
	private int _dayType;
	private int _otId;
	private double _coefficient;
	private String _nameOvertimeType;
	private String _description;
}