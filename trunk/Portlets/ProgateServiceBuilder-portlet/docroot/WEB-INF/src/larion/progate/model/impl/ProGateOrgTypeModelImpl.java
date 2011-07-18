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
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import larion.progate.model.ProGateOrgType;
import larion.progate.model.ProGateOrgTypeSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="ProGateOrgTypeModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateOrgTypeModelImpl extends BaseModelImpl<ProGateOrgType> {
	public static final String TABLE_NAME = "progate_orgtypes";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "name", new Integer(Types.VARCHAR) },
			

			{ "description", new Integer(Types.VARCHAR) },
			

			{ "status", new Integer(Types.BOOLEAN) }
		};
	public static final String TABLE_SQL_CREATE = "create table progate_orgtypes (id INTEGER not null primary key,name VARCHAR(75) null,description VARCHAR(75) null,status BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table progate_orgtypes";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.model.ProGateOrgType"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.model.ProGateOrgType"),
			false);

	public static ProGateOrgType toModel(ProGateOrgTypeSoap soapModel) {
		ProGateOrgType model = new ProGateOrgTypeImpl();

		model.setOrgTypeId(soapModel.getOrgTypeId());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setStatus(soapModel.getStatus());

		return model;
	}

	public static List<ProGateOrgType> toModels(ProGateOrgTypeSoap[] soapModels) {
		List<ProGateOrgType> models = new ArrayList<ProGateOrgType>(soapModels.length);

		for (ProGateOrgTypeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.model.ProGateOrgType"));

	public ProGateOrgTypeModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _orgTypeId;
	}

	public void setPrimaryKey(Integer pk) {
		setOrgTypeId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _orgTypeId;
	}

	public Integer getOrgTypeId() {
		return _orgTypeId;
	}

	public void setOrgTypeId(Integer orgTypeId) {
		_orgTypeId = orgTypeId;
	}

	public String getName() {
		return GetterUtil.getString(_name);
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return GetterUtil.getString(_description);
	}

	public void setDescription(String description) {
		_description = description;
	}

	public boolean getStatus() {
		return _status;
	}

	public boolean isStatus() {
		return _status;
	}

	public void setStatus(boolean status) {
		_status = status;
	}

	public ProGateOrgType toEscapedModel() {
		if (isEscapedModel()) {
			return (ProGateOrgType)this;
		}
		else {
			ProGateOrgType model = new ProGateOrgTypeImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setOrgTypeId(getOrgTypeId());
			model.setName(HtmlUtil.escape(getName()));
			model.setDescription(HtmlUtil.escape(getDescription()));
			model.setStatus(getStatus());

			model = (ProGateOrgType)Proxy.newProxyInstance(ProGateOrgType.class.getClassLoader(),
					new Class[] { ProGateOrgType.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ProGateOrgTypeImpl clone = new ProGateOrgTypeImpl();

		clone.setOrgTypeId(getOrgTypeId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setStatus(getStatus());

		return clone;
	}

	public int compareTo(ProGateOrgType proGateOrgType) {
		int value = 0;

		value = getDescription().compareTo(proGateOrgType.getDescription());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ProGateOrgType proGateOrgType = null;

		try {
			proGateOrgType = (ProGateOrgType)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = proGateOrgType.getPrimaryKey();

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

		sb.append("{orgTypeId=");
		sb.append(getOrgTypeId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.ProGateOrgType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>orgTypeId</column-name><column-value><![CDATA[");
		sb.append(getOrgTypeId());
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
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _orgTypeId;
	private String _name;
	private String _description;
	private boolean _status;
}