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
 * <a href="LmisEmailSettingsClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisEmailSettingsClp extends BaseModelImpl<LmisEmailSettings>
	implements LmisEmailSettings {
	public LmisEmailSettingsClp() {
	}

	public Integer getPrimaryKey() {
		return _lmisEmailSettingId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisEmailSettingId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisEmailSettingId;
	}

	public Integer getLmisEmailSettingId() {
		return _lmisEmailSettingId;
	}

	public void setLmisEmailSettingId(Integer lmisEmailSettingId) {
		_lmisEmailSettingId = lmisEmailSettingId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public String getEmailName() {
		return _emailName;
	}

	public void setEmailName(String emailName) {
		_emailName = emailName;
	}

	public String getEmailDescription() {
		return _emailDescription;
	}

	public void setEmailDescription(String emailDescription) {
		_emailDescription = emailDescription;
	}

	public String getEmailTemplate() {
		return _emailTemplate;
	}

	public void setEmailTemplate(String emailTemplate) {
		_emailTemplate = emailTemplate;
	}

	public String getEmailType() {
		return _emailType;
	}

	public void setEmailType(String emailType) {
		_emailType = emailType;
	}

	public int getCategory() {
		return _category;
	}

	public void setCategory(int category) {
		_category = category;
	}

	public boolean getToSender() {
		return _toSender;
	}

	public boolean isToSender() {
		return _toSender;
	}

	public void setToSender(boolean toSender) {
		_toSender = toSender;
	}

	public boolean getToPm() {
		return _toPm;
	}

	public boolean isToPm() {
		return _toPm;
	}

	public void setToPm(boolean toPm) {
		_toPm = toPm;
	}

	public boolean getToBod() {
		return _toBod;
	}

	public boolean isToBod() {
		return _toBod;
	}

	public void setToBod(boolean toBod) {
		_toBod = toBod;
	}

	public LmisEmailSettings toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			LmisEmailSettings model = new LmisEmailSettingsClp();

			model.setEscapedModel(true);

			model.setLmisEmailSettingId(getLmisEmailSettingId());
			model.setRootId(getRootId());
			model.setEmailName(HtmlUtil.escape(getEmailName()));
			model.setEmailDescription(HtmlUtil.escape(getEmailDescription()));
			model.setEmailTemplate(HtmlUtil.escape(getEmailTemplate()));
			model.setEmailType(HtmlUtil.escape(getEmailType()));
			model.setCategory(getCategory());
			model.setToSender(getToSender());
			model.setToPm(getToPm());
			model.setToBod(getToBod());

			model = (LmisEmailSettings)Proxy.newProxyInstance(LmisEmailSettings.class.getClassLoader(),
					new Class[] { LmisEmailSettings.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisEmailSettingsClp clone = new LmisEmailSettingsClp();

		clone.setLmisEmailSettingId(getLmisEmailSettingId());
		clone.setRootId(getRootId());
		clone.setEmailName(getEmailName());
		clone.setEmailDescription(getEmailDescription());
		clone.setEmailTemplate(getEmailTemplate());
		clone.setEmailType(getEmailType());
		clone.setCategory(getCategory());
		clone.setToSender(getToSender());
		clone.setToPm(getToPm());
		clone.setToBod(getToBod());

		return clone;
	}

	public int compareTo(LmisEmailSettings lmisEmailSettings) {
		int value = 0;

		value = getEmailType().compareTo(lmisEmailSettings.getEmailType());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisEmailSettingsClp lmisEmailSettings = null;

		try {
			lmisEmailSettings = (LmisEmailSettingsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisEmailSettings.getPrimaryKey();

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

		sb.append("{lmisEmailSettingId=");
		sb.append(getLmisEmailSettingId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", emailName=");
		sb.append(getEmailName());
		sb.append(", emailDescription=");
		sb.append(getEmailDescription());
		sb.append(", emailTemplate=");
		sb.append(getEmailTemplate());
		sb.append(", emailType=");
		sb.append(getEmailType());
		sb.append(", category=");
		sb.append(getCategory());
		sb.append(", toSender=");
		sb.append(getToSender());
		sb.append(", toPm=");
		sb.append(getToPm());
		sb.append(", toBod=");
		sb.append(getToBod());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisEmailSettings");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisEmailSettingId</column-name><column-value><![CDATA[");
		sb.append(getLmisEmailSettingId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailName</column-name><column-value><![CDATA[");
		sb.append(getEmailName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailDescription</column-name><column-value><![CDATA[");
		sb.append(getEmailDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailTemplate</column-name><column-value><![CDATA[");
		sb.append(getEmailTemplate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailType</column-name><column-value><![CDATA[");
		sb.append(getEmailType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>category</column-name><column-value><![CDATA[");
		sb.append(getCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toSender</column-name><column-value><![CDATA[");
		sb.append(getToSender());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toPm</column-name><column-value><![CDATA[");
		sb.append(getToPm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toBod</column-name><column-value><![CDATA[");
		sb.append(getToBod());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisEmailSettingId;
	private int _rootId;
	private String _emailName;
	private String _emailDescription;
	private String _emailTemplate;
	private String _emailType;
	private int _category;
	private boolean _toSender;
	private boolean _toPm;
	private boolean _toBod;
}