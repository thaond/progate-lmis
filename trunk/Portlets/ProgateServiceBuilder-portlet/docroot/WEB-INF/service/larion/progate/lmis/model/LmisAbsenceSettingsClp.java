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
 * <a href="LmisAbsenceSettingsClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAbsenceSettingsClp extends BaseModelImpl<LmisAbsenceSettings>
	implements LmisAbsenceSettings {
	public LmisAbsenceSettingsClp() {
	}

	public Integer getPrimaryKey() {
		return _lmisAbsenceSettingsId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisAbsenceSettingsId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisAbsenceSettingsId;
	}

	public Integer getLmisAbsenceSettingsId() {
		return _lmisAbsenceSettingsId;
	}

	public void setLmisAbsenceSettingsId(Integer lmisAbsenceSettingsId) {
		_lmisAbsenceSettingsId = lmisAbsenceSettingsId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public String getName_() {
		return _name_;
	}

	public void setName_(String name_) {
		_name_ = name_;
	}

	public String getDesCription() {
		return _desCription;
	}

	public void setDesCription(String desCription) {
		_desCription = desCription;
	}

	public boolean getIsSubtract() {
		return _isSubtract;
	}

	public boolean isIsSubtract() {
		return _isSubtract;
	}

	public void setIsSubtract(boolean isSubtract) {
		_isSubtract = isSubtract;
	}

	public boolean getIsModified() {
		return _isModified;
	}

	public boolean isIsModified() {
		return _isModified;
	}

	public void setIsModified(boolean isModified) {
		_isModified = isModified;
	}

	public boolean getAbsencePermissive() {
		return _absencePermissive;
	}

	public boolean isAbsencePermissive() {
		return _absencePermissive;
	}

	public void setAbsencePermissive(boolean absencePermissive) {
		_absencePermissive = absencePermissive;
	}

	public LmisAbsenceSettings toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			LmisAbsenceSettings model = new LmisAbsenceSettingsClp();

			model.setEscapedModel(true);

			model.setLmisAbsenceSettingsId(getLmisAbsenceSettingsId());
			model.setRootId(getRootId());
			model.setName_(HtmlUtil.escape(getName_()));
			model.setDesCription(HtmlUtil.escape(getDesCription()));
			model.setIsSubtract(getIsSubtract());
			model.setIsModified(getIsModified());
			model.setAbsencePermissive(getAbsencePermissive());

			model = (LmisAbsenceSettings)Proxy.newProxyInstance(LmisAbsenceSettings.class.getClassLoader(),
					new Class[] { LmisAbsenceSettings.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisAbsenceSettingsClp clone = new LmisAbsenceSettingsClp();

		clone.setLmisAbsenceSettingsId(getLmisAbsenceSettingsId());
		clone.setRootId(getRootId());
		clone.setName_(getName_());
		clone.setDesCription(getDesCription());
		clone.setIsSubtract(getIsSubtract());
		clone.setIsModified(getIsModified());
		clone.setAbsencePermissive(getAbsencePermissive());

		return clone;
	}

	public int compareTo(LmisAbsenceSettings lmisAbsenceSettings) {
		int value = 0;

		value = getName_().compareTo(lmisAbsenceSettings.getName_());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisAbsenceSettingsClp lmisAbsenceSettings = null;

		try {
			lmisAbsenceSettings = (LmisAbsenceSettingsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisAbsenceSettings.getPrimaryKey();

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

		sb.append("{lmisAbsenceSettingsId=");
		sb.append(getLmisAbsenceSettingsId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", name_=");
		sb.append(getName_());
		sb.append(", desCription=");
		sb.append(getDesCription());
		sb.append(", isSubtract=");
		sb.append(getIsSubtract());
		sb.append(", isModified=");
		sb.append(getIsModified());
		sb.append(", absencePermissive=");
		sb.append(getAbsencePermissive());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisAbsenceSettings");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisAbsenceSettingsId</column-name><column-value><![CDATA[");
		sb.append(getLmisAbsenceSettingsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name_</column-name><column-value><![CDATA[");
		sb.append(getName_());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>desCription</column-name><column-value><![CDATA[");
		sb.append(getDesCription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isSubtract</column-name><column-value><![CDATA[");
		sb.append(getIsSubtract());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isModified</column-name><column-value><![CDATA[");
		sb.append(getIsModified());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>absencePermissive</column-name><column-value><![CDATA[");
		sb.append(getAbsencePermissive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisAbsenceSettingsId;
	private int _rootId;
	private String _name_;
	private String _desCription;
	private boolean _isSubtract;
	private boolean _isModified;
	private boolean _absencePermissive;
}