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
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * <a href="LmisOverTimeSettingsClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOverTimeSettingsClp extends BaseModelImpl<LmisOverTimeSettings>
	implements LmisOverTimeSettings {
	public LmisOverTimeSettingsClp() {
	}

	public Integer getPrimaryKey() {
		return _lmisOverTimeSettingsId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisOverTimeSettingsId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisOverTimeSettingsId;
	}

	public Integer getLmisOverTimeSettingsId() {
		return _lmisOverTimeSettingsId;
	}

	public void setLmisOverTimeSettingsId(Integer lmisOverTimeSettingsId) {
		_lmisOverTimeSettingsId = lmisOverTimeSettingsId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getOtId() {
		return _otId;
	}

	public void setOtId(int otId) {
		_otId = otId;
	}

	public int getDayType() {
		return _dayType;
	}

	public void setDayType(int dayType) {
		_dayType = dayType;
	}

	public double getCoEfficient() {
		return _coEfficient;
	}

	public void setCoEfficient(double coEfficient) {
		_coEfficient = coEfficient;
	}

	public LmisOverTimeSettings toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			LmisOverTimeSettings model = new LmisOverTimeSettingsClp();

			model.setEscapedModel(true);

			model.setLmisOverTimeSettingsId(getLmisOverTimeSettingsId());
			model.setRootId(getRootId());
			model.setOtId(getOtId());
			model.setDayType(getDayType());
			model.setCoEfficient(getCoEfficient());

			model = (LmisOverTimeSettings)Proxy.newProxyInstance(LmisOverTimeSettings.class.getClassLoader(),
					new Class[] { LmisOverTimeSettings.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisOverTimeSettingsClp clone = new LmisOverTimeSettingsClp();

		clone.setLmisOverTimeSettingsId(getLmisOverTimeSettingsId());
		clone.setRootId(getRootId());
		clone.setOtId(getOtId());
		clone.setDayType(getDayType());
		clone.setCoEfficient(getCoEfficient());

		return clone;
	}

	public int compareTo(LmisOverTimeSettings lmisOverTimeSettings) {
		Integer pk = lmisOverTimeSettings.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisOverTimeSettingsClp lmisOverTimeSettings = null;

		try {
			lmisOverTimeSettings = (LmisOverTimeSettingsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisOverTimeSettings.getPrimaryKey();

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

		sb.append("{lmisOverTimeSettingsId=");
		sb.append(getLmisOverTimeSettingsId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", otId=");
		sb.append(getOtId());
		sb.append(", dayType=");
		sb.append(getDayType());
		sb.append(", coEfficient=");
		sb.append(getCoEfficient());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisOverTimeSettings");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisOverTimeSettingsId</column-name><column-value><![CDATA[");
		sb.append(getLmisOverTimeSettingsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>otId</column-name><column-value><![CDATA[");
		sb.append(getOtId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dayType</column-name><column-value><![CDATA[");
		sb.append(getDayType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>coEfficient</column-name><column-value><![CDATA[");
		sb.append(getCoEfficient());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisOverTimeSettingsId;
	private int _rootId;
	private int _otId;
	private int _dayType;
	private double _coEfficient;
}