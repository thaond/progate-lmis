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

import larion.progate.lmis.model.LmisAbsenceSettings;
import larion.progate.lmis.model.LmisAbsenceSettingsSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="LmisAbsenceSettingsModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAbsenceSettingsModelImpl extends BaseModelImpl<LmisAbsenceSettings> {
	public static final String TABLE_NAME = "lmis_absence_settings";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "name", new Integer(Types.VARCHAR) },
			

			{ "description", new Integer(Types.VARCHAR) },
			

			{ "is_subtract", new Integer(Types.BOOLEAN) },
			

			{ "is_modified", new Integer(Types.BOOLEAN) },
			

			{ "absence_permissive", new Integer(Types.BOOLEAN) }
		};
	public static final String TABLE_SQL_CREATE = "create table lmis_absence_settings (id INTEGER not null primary key,root_id INTEGER,name VARCHAR(75) null,description VARCHAR(75) null,is_subtract BOOLEAN,is_modified BOOLEAN,absence_permissive BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table lmis_absence_settings";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.lmis.model.LmisAbsenceSettings"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.lmis.model.LmisAbsenceSettings"),
			false);

	public static LmisAbsenceSettings toModel(LmisAbsenceSettingsSoap soapModel) {
		LmisAbsenceSettings model = new LmisAbsenceSettingsImpl();

		model.setLmisAbsenceSettingsId(soapModel.getLmisAbsenceSettingsId());
		model.setRootId(soapModel.getRootId());
		model.setName_(soapModel.getName_());
		model.setDesCription(soapModel.getDesCription());
		model.setIsSubtract(soapModel.getIsSubtract());
		model.setIsModified(soapModel.getIsModified());
		model.setAbsencePermissive(soapModel.getAbsencePermissive());

		return model;
	}

	public static List<LmisAbsenceSettings> toModels(
		LmisAbsenceSettingsSoap[] soapModels) {
		List<LmisAbsenceSettings> models = new ArrayList<LmisAbsenceSettings>(soapModels.length);

		for (LmisAbsenceSettingsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.lmis.model.LmisAbsenceSettings"));

	public LmisAbsenceSettingsModelImpl() {
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
		return GetterUtil.getString(_name_);
	}

	public void setName_(String name_) {
		_name_ = name_;
	}

	public String getDesCription() {
		return GetterUtil.getString(_desCription);
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
			return (LmisAbsenceSettings)this;
		}
		else {
			LmisAbsenceSettings model = new LmisAbsenceSettingsImpl();

			model.setNew(isNew());
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
		LmisAbsenceSettingsImpl clone = new LmisAbsenceSettingsImpl();

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

		LmisAbsenceSettings lmisAbsenceSettings = null;

		try {
			lmisAbsenceSettings = (LmisAbsenceSettings)obj;
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