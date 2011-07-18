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

import larion.progate.model.ProGateUserApplications;
import larion.progate.model.ProGateUserApplicationsSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="ProGateUserApplicationsModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateUserApplicationsModelImpl extends BaseModelImpl<ProGateUserApplications> {
	public static final String TABLE_NAME = "progate_user_applications";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "user_id", new Integer(Types.INTEGER) },
			

			{ "app_id", new Integer(Types.INTEGER) },
			

			{ "org_id", new Integer(Types.INTEGER) },
			

			{ "position", new Integer(Types.INTEGER) }
		};
	public static final String TABLE_SQL_CREATE = "create table progate_user_applications (id INTEGER not null primary key,user_id INTEGER,app_id INTEGER,org_id INTEGER,position INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table progate_user_applications";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.model.ProGateUserApplications"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.model.ProGateUserApplications"),
			false);

	public static ProGateUserApplications toModel(
		ProGateUserApplicationsSoap soapModel) {
		ProGateUserApplications model = new ProGateUserApplicationsImpl();

		model.setProGateUserApplicationsId(soapModel.getProGateUserApplicationsId());
		model.setUserId(soapModel.getUserId());
		model.setAppsId(soapModel.getAppsId());
		model.setOrgId(soapModel.getOrgId());
		model.setPosition(soapModel.getPosition());

		return model;
	}

	public static List<ProGateUserApplications> toModels(
		ProGateUserApplicationsSoap[] soapModels) {
		List<ProGateUserApplications> models = new ArrayList<ProGateUserApplications>(soapModels.length);

		for (ProGateUserApplicationsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.model.ProGateUserApplications"));

	public ProGateUserApplicationsModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _ProGateUserApplicationsId;
	}

	public void setPrimaryKey(Integer pk) {
		setProGateUserApplicationsId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _ProGateUserApplicationsId;
	}

	public Integer getProGateUserApplicationsId() {
		return _ProGateUserApplicationsId;
	}

	public void setProGateUserApplicationsId(Integer ProGateUserApplicationsId) {
		_ProGateUserApplicationsId = ProGateUserApplicationsId;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public int getAppsId() {
		return _appsId;
	}

	public void setAppsId(int appsId) {
		_appsId = appsId;
	}

	public int getOrgId() {
		return _orgId;
	}

	public void setOrgId(int orgId) {
		_orgId = orgId;
	}

	public int getPosition() {
		return _position;
	}

	public void setPosition(int position) {
		_position = position;
	}

	public ProGateUserApplications toEscapedModel() {
		if (isEscapedModel()) {
			return (ProGateUserApplications)this;
		}
		else {
			ProGateUserApplications model = new ProGateUserApplicationsImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setProGateUserApplicationsId(getProGateUserApplicationsId());
			model.setUserId(getUserId());
			model.setAppsId(getAppsId());
			model.setOrgId(getOrgId());
			model.setPosition(getPosition());

			model = (ProGateUserApplications)Proxy.newProxyInstance(ProGateUserApplications.class.getClassLoader(),
					new Class[] { ProGateUserApplications.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ProGateUserApplicationsImpl clone = new ProGateUserApplicationsImpl();

		clone.setProGateUserApplicationsId(getProGateUserApplicationsId());
		clone.setUserId(getUserId());
		clone.setAppsId(getAppsId());
		clone.setOrgId(getOrgId());
		clone.setPosition(getPosition());

		return clone;
	}

	public int compareTo(ProGateUserApplications proGateUserApplications) {
		int value = 0;

		if (getPosition() < proGateUserApplications.getPosition()) {
			value = -1;
		}
		else if (getPosition() > proGateUserApplications.getPosition()) {
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

		ProGateUserApplications proGateUserApplications = null;

		try {
			proGateUserApplications = (ProGateUserApplications)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = proGateUserApplications.getPrimaryKey();

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

		sb.append("{ProGateUserApplicationsId=");
		sb.append(getProGateUserApplicationsId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", appsId=");
		sb.append(getAppsId());
		sb.append(", orgId=");
		sb.append(getOrgId());
		sb.append(", position=");
		sb.append(getPosition());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.ProGateUserApplications");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ProGateUserApplicationsId</column-name><column-value><![CDATA[");
		sb.append(getProGateUserApplicationsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>appsId</column-name><column-value><![CDATA[");
		sb.append(getAppsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgId</column-name><column-value><![CDATA[");
		sb.append(getOrgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>position</column-name><column-value><![CDATA[");
		sb.append(getPosition());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _ProGateUserApplicationsId;
	private int _userId;
	private int _appsId;
	private int _orgId;
	private int _position;
}