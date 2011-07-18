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

package larion.progate.lmis.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import larion.progate.lmis.model.LmisEmailSettings;
import larion.progate.lmis.model.LmisEmailSettingsSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="LmisEmailSettingsModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisEmailSettingsModelImpl extends BaseModelImpl<LmisEmailSettings> {
	public static final String TABLE_NAME = "lmis_email_settings";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "email_name", new Integer(Types.VARCHAR) },
			

			{ "email_desciption", new Integer(Types.VARCHAR) },
			

			{ "email_template", new Integer(Types.VARCHAR) },
			

			{ "email_type", new Integer(Types.VARCHAR) },
			

			{ "category", new Integer(Types.INTEGER) },
			

			{ "to_sender", new Integer(Types.BOOLEAN) },
			

			{ "to_pm", new Integer(Types.BOOLEAN) },
			

			{ "to_bod", new Integer(Types.BOOLEAN) }
		};
	public static final String TABLE_SQL_CREATE = "create table lmis_email_settings (id INTEGER not null primary key,root_id INTEGER,email_name VARCHAR(75) null,email_desciption VARCHAR(75) null,email_template VARCHAR(75) null,email_type VARCHAR(75) null,category INTEGER,to_sender BOOLEAN,to_pm BOOLEAN,to_bod BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table lmis_email_settings";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.lmis.model.LmisEmailSettings"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.lmis.model.LmisEmailSettings"),
			false);

	public static LmisEmailSettings toModel(LmisEmailSettingsSoap soapModel) {
		LmisEmailSettings model = new LmisEmailSettingsImpl();

		model.setLmisEmailSettingId(soapModel.getLmisEmailSettingId());
		model.setRootId(soapModel.getRootId());
		model.setEmailName(soapModel.getEmailName());
		model.setEmailDescription(soapModel.getEmailDescription());
		model.setEmailTemplate(soapModel.getEmailTemplate());
		model.setEmailType(soapModel.getEmailType());
		model.setCategory(soapModel.getCategory());
		model.setToSender(soapModel.getToSender());
		model.setToPm(soapModel.getToPm());
		model.setToBod(soapModel.getToBod());

		return model;
	}

	public static List<LmisEmailSettings> toModels(
		LmisEmailSettingsSoap[] soapModels) {
		List<LmisEmailSettings> models = new ArrayList<LmisEmailSettings>(soapModels.length);

		for (LmisEmailSettingsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.lmis.model.LmisEmailSettings"));

	public LmisEmailSettingsModelImpl() {
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
		return GetterUtil.getString(_emailName);
	}

	public void setEmailName(String emailName) {
		_emailName = emailName;
	}

	public String getEmailDescription() {
		return GetterUtil.getString(_emailDescription);
	}

	public void setEmailDescription(String emailDescription) {
		_emailDescription = emailDescription;
	}

	public String getEmailTemplate() {
		return GetterUtil.getString(_emailTemplate);
	}

	public void setEmailTemplate(String emailTemplate) {
		_emailTemplate = emailTemplate;
	}

	public String getEmailType() {
		return GetterUtil.getString(_emailType);
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
			return (LmisEmailSettings)this;
		}
		else {
			LmisEmailSettings model = new LmisEmailSettingsImpl();

			model.setNew(isNew());
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
		LmisEmailSettingsImpl clone = new LmisEmailSettingsImpl();

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

		LmisEmailSettings lmisEmailSettings = null;

		try {
			lmisEmailSettings = (LmisEmailSettings)obj;
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