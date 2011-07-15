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
 * <a href="LmisGeneralSettingsClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisGeneralSettingsClp extends BaseModelImpl<LmisGeneralSettings>
	implements LmisGeneralSettings {
	public LmisGeneralSettingsClp() {
	}

	public Integer getPrimaryKey() {
		return _lmisGeneralSettingId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisGeneralSettingId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisGeneralSettingId;
	}

	public Integer getLmisGeneralSettingId() {
		return _lmisGeneralSettingId;
	}

	public void setLmisGeneralSettingId(Integer lmisGeneralSettingId) {
		_lmisGeneralSettingId = lmisGeneralSettingId;
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

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getConfType() {
		return _confType;
	}

	public void setConfType(int confType) {
		_confType = confType;
	}

	public double getConfValue() {
		return _confValue;
	}

	public void setConfValue(double confValue) {
		_confValue = confValue;
	}

	public LmisGeneralSettings toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			LmisGeneralSettings model = new LmisGeneralSettingsClp();

			model.setEscapedModel(true);

			model.setLmisGeneralSettingId(getLmisGeneralSettingId());
			model.setRootId(getRootId());
			model.setName(HtmlUtil.escape(getName()));
			model.setDescription(HtmlUtil.escape(getDescription()));
			model.setConfType(getConfType());
			model.setConfValue(getConfValue());

			model = (LmisGeneralSettings)Proxy.newProxyInstance(LmisGeneralSettings.class.getClassLoader(),
					new Class[] { LmisGeneralSettings.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisGeneralSettingsClp clone = new LmisGeneralSettingsClp();

		clone.setLmisGeneralSettingId(getLmisGeneralSettingId());
		clone.setRootId(getRootId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setConfType(getConfType());
		clone.setConfValue(getConfValue());

		return clone;
	}

	public int compareTo(LmisGeneralSettings lmisGeneralSettings) {
		Integer pk = lmisGeneralSettings.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisGeneralSettingsClp lmisGeneralSettings = null;

		try {
			lmisGeneralSettings = (LmisGeneralSettingsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisGeneralSettings.getPrimaryKey();

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

		sb.append("{lmisGeneralSettingId=");
		sb.append(getLmisGeneralSettingId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", confType=");
		sb.append(getConfType());
		sb.append(", confValue=");
		sb.append(getConfValue());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisGeneralSettings");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisGeneralSettingId</column-name><column-value><![CDATA[");
		sb.append(getLmisGeneralSettingId());
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
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>confType</column-name><column-value><![CDATA[");
		sb.append(getConfType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>confValue</column-name><column-value><![CDATA[");
		sb.append(getConfValue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisGeneralSettingId;
	private int _rootId;
	private String _name;
	private String _description;
	private int _confType;
	private double _confValue;
}