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

package larion.progate.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import larion.progate.model.ProgateApplicationsSetting;
import larion.progate.model.ProgateApplicationsSettingSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="ProgateApplicationsSettingModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgateApplicationsSettingModelImpl extends BaseModelImpl<ProgateApplicationsSetting> {
	public static final String TABLE_NAME = "progate_applications_setting";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "app_id", new Integer(Types.INTEGER) },
			

			{ "role_id", new Integer(Types.INTEGER) },
			

			{ "default_position", new Integer(Types.INTEGER) }
		};
	public static final String TABLE_SQL_CREATE = "create table progate_applications_setting (id INTEGER not null primary key,app_id INTEGER,role_id INTEGER,default_position INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table progate_applications_setting";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.model.ProgateApplicationsSetting"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.model.ProgateApplicationsSetting"),
			false);

	public static ProgateApplicationsSetting toModel(
		ProgateApplicationsSettingSoap soapModel) {
		ProgateApplicationsSetting model = new ProgateApplicationsSettingImpl();

		model.setProgateApplicationsSettingId(soapModel.getProgateApplicationsSettingId());
		model.setAppId(soapModel.getAppId());
		model.setRoleId(soapModel.getRoleId());
		model.setDefaultPosition(soapModel.getDefaultPosition());

		return model;
	}

	public static List<ProgateApplicationsSetting> toModels(
		ProgateApplicationsSettingSoap[] soapModels) {
		List<ProgateApplicationsSetting> models = new ArrayList<ProgateApplicationsSetting>(soapModels.length);

		for (ProgateApplicationsSettingSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.model.ProgateApplicationsSetting"));

	public ProgateApplicationsSettingModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _ProgateApplicationsSettingId;
	}

	public void setPrimaryKey(Integer pk) {
		setProgateApplicationsSettingId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _ProgateApplicationsSettingId;
	}

	public Integer getProgateApplicationsSettingId() {
		return _ProgateApplicationsSettingId;
	}

	public void setProgateApplicationsSettingId(
		Integer ProgateApplicationsSettingId) {
		_ProgateApplicationsSettingId = ProgateApplicationsSettingId;
	}

	public int getAppId() {
		return _appId;
	}

	public void setAppId(int appId) {
		_appId = appId;
	}

	public int getRoleId() {
		return _roleId;
	}

	public void setRoleId(int roleId) {
		_roleId = roleId;
	}

	public int getDefaultPosition() {
		return _defaultPosition;
	}

	public void setDefaultPosition(int defaultPosition) {
		_defaultPosition = defaultPosition;
	}

	public ProgateApplicationsSetting toEscapedModel() {
		if (isEscapedModel()) {
			return (ProgateApplicationsSetting)this;
		}
		else {
			ProgateApplicationsSetting model = new ProgateApplicationsSettingImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setProgateApplicationsSettingId(getProgateApplicationsSettingId());
			model.setAppId(getAppId());
			model.setRoleId(getRoleId());
			model.setDefaultPosition(getDefaultPosition());

			model = (ProgateApplicationsSetting)Proxy.newProxyInstance(ProgateApplicationsSetting.class.getClassLoader(),
					new Class[] { ProgateApplicationsSetting.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ProgateApplicationsSettingImpl clone = new ProgateApplicationsSettingImpl();

		clone.setProgateApplicationsSettingId(getProgateApplicationsSettingId());
		clone.setAppId(getAppId());
		clone.setRoleId(getRoleId());
		clone.setDefaultPosition(getDefaultPosition());

		return clone;
	}

	public int compareTo(ProgateApplicationsSetting progateApplicationsSetting) {
		int value = 0;

		if (getRoleId() < progateApplicationsSetting.getRoleId()) {
			value = -1;
		}
		else if (getRoleId() > progateApplicationsSetting.getRoleId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		if (getAppId() < progateApplicationsSetting.getAppId()) {
			value = -1;
		}
		else if (getAppId() > progateApplicationsSetting.getAppId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ProgateApplicationsSetting progateApplicationsSetting = null;

		try {
			progateApplicationsSetting = (ProgateApplicationsSetting)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = progateApplicationsSetting.getPrimaryKey();

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

		sb.append("{ProgateApplicationsSettingId=");
		sb.append(getProgateApplicationsSettingId());
		sb.append(", appId=");
		sb.append(getAppId());
		sb.append(", roleId=");
		sb.append(getRoleId());
		sb.append(", defaultPosition=");
		sb.append(getDefaultPosition());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.ProgateApplicationsSetting");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ProgateApplicationsSettingId</column-name><column-value><![CDATA[");
		sb.append(getProgateApplicationsSettingId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>appId</column-name><column-value><![CDATA[");
		sb.append(getAppId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>roleId</column-name><column-value><![CDATA[");
		sb.append(getRoleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>defaultPosition</column-name><column-value><![CDATA[");
		sb.append(getDefaultPosition());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _ProgateApplicationsSettingId;
	private int _appId;
	private int _roleId;
	private int _defaultPosition;
}