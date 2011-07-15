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
 * <a href="LmisDayTypesClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisDayTypesClp extends BaseModelImpl<LmisDayTypes>
	implements LmisDayTypes {
	public LmisDayTypesClp() {
	}

	public Integer getPrimaryKey() {
		return _LmisDayTypeId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisDayTypeId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _LmisDayTypeId;
	}

	public Integer getLmisDayTypeId() {
		return _LmisDayTypeId;
	}

	public void setLmisDayTypeId(Integer LmisDayTypeId) {
		_LmisDayTypeId = LmisDayTypeId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public String getName() {
		return _Name;
	}

	public void setName(String Name) {
		_Name = Name;
	}

	public String getDescription() {
		return _Description;
	}

	public void setDescription(String Description) {
		_Description = Description;
	}

	public int getDayType() {
		return _dayType;
	}

	public void setDayType(int dayType) {
		_dayType = dayType;
	}

	public LmisDayTypes toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			LmisDayTypes model = new LmisDayTypesClp();

			model.setEscapedModel(true);

			model.setLmisDayTypeId(getLmisDayTypeId());
			model.setRootId(getRootId());
			model.setName(HtmlUtil.escape(getName()));
			model.setDescription(HtmlUtil.escape(getDescription()));
			model.setDayType(getDayType());

			model = (LmisDayTypes)Proxy.newProxyInstance(LmisDayTypes.class.getClassLoader(),
					new Class[] { LmisDayTypes.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisDayTypesClp clone = new LmisDayTypesClp();

		clone.setLmisDayTypeId(getLmisDayTypeId());
		clone.setRootId(getRootId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setDayType(getDayType());

		return clone;
	}

	public int compareTo(LmisDayTypes lmisDayTypes) {
		Integer pk = lmisDayTypes.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisDayTypesClp lmisDayTypes = null;

		try {
			lmisDayTypes = (LmisDayTypesClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisDayTypes.getPrimaryKey();

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

		sb.append("{LmisDayTypeId=");
		sb.append(getLmisDayTypeId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", Name=");
		sb.append(getName());
		sb.append(", Description=");
		sb.append(getDescription());
		sb.append(", dayType=");
		sb.append(getDayType());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisDayTypes");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>LmisDayTypeId</column-name><column-value><![CDATA[");
		sb.append(getLmisDayTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dayType</column-name><column-value><![CDATA[");
		sb.append(getDayType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _LmisDayTypeId;
	private int _rootId;
	private String _Name;
	private String _Description;
	private int _dayType;
}