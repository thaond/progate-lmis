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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import larion.progate.model.ProGateOrgCustomerRepresenter;
import larion.progate.model.ProGateOrgCustomerRepresenterSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="ProGateOrgCustomerRepresenterModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateOrgCustomerRepresenterModelImpl extends BaseModelImpl<ProGateOrgCustomerRepresenter> {
	public static final String TABLE_NAME = "progate_org_customer_representer";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "first_name", new Integer(Types.VARCHAR) },
			

			{ "last_name", new Integer(Types.VARCHAR) },
			

			{ "display_name", new Integer(Types.VARCHAR) },
			

			{ "role", new Integer(Types.VARCHAR) },
			

			{ "customer_id", new Integer(Types.INTEGER) },
			

			{ "org_id", new Integer(Types.INTEGER) },
			

			{ "description", new Integer(Types.VARCHAR) },
			

			{ "created_date", new Integer(Types.TIMESTAMP) },
			

			{ "modified_date", new Integer(Types.TIMESTAMP) }
		};
	public static final String TABLE_SQL_CREATE = "create table progate_org_customer_representer (id INTEGER not null primary key,first_name VARCHAR(75) null,last_name VARCHAR(75) null,display_name VARCHAR(75) null,role VARCHAR(75) null,customer_id INTEGER,org_id INTEGER,description VARCHAR(75) null,created_date DATE null,modified_date DATE null)";
	public static final String TABLE_SQL_DROP = "drop table progate_org_customer_representer";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.model.ProGateOrgCustomerRepresenter"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.model.ProGateOrgCustomerRepresenter"),
			false);

	public static ProGateOrgCustomerRepresenter toModel(
		ProGateOrgCustomerRepresenterSoap soapModel) {
		ProGateOrgCustomerRepresenter model = new ProGateOrgCustomerRepresenterImpl();

		model.setProGateOrgCustomerRepresenterId(soapModel.getProGateOrgCustomerRepresenterId());
		model.setFirstName(soapModel.getFirstName());
		model.setLastName(soapModel.getLastName());
		model.setDisplayName(soapModel.getDisplayName());
		model.setRole(soapModel.getRole());
		model.setCustomerId(soapModel.getCustomerId());
		model.setOrgId(soapModel.getOrgId());
		model.setDescription(soapModel.getDescription());
		model.setCreatedDate(soapModel.getCreatedDate());
		model.setModifiedDate(soapModel.getModifiedDate());

		return model;
	}

	public static List<ProGateOrgCustomerRepresenter> toModels(
		ProGateOrgCustomerRepresenterSoap[] soapModels) {
		List<ProGateOrgCustomerRepresenter> models = new ArrayList<ProGateOrgCustomerRepresenter>(soapModels.length);

		for (ProGateOrgCustomerRepresenterSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.model.ProGateOrgCustomerRepresenter"));

	public ProGateOrgCustomerRepresenterModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _ProGateOrgCustomerRepresenterId;
	}

	public void setPrimaryKey(Integer pk) {
		setProGateOrgCustomerRepresenterId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _ProGateOrgCustomerRepresenterId;
	}

	public Integer getProGateOrgCustomerRepresenterId() {
		return _ProGateOrgCustomerRepresenterId;
	}

	public void setProGateOrgCustomerRepresenterId(
		Integer ProGateOrgCustomerRepresenterId) {
		_ProGateOrgCustomerRepresenterId = ProGateOrgCustomerRepresenterId;
	}

	public String getFirstName() {
		return GetterUtil.getString(_firstName);
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return GetterUtil.getString(_lastName);
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getDisplayName() {
		return GetterUtil.getString(_displayName);
	}

	public void setDisplayName(String displayName) {
		_displayName = displayName;
	}

	public String getRole() {
		return GetterUtil.getString(_role);
	}

	public void setRole(String role) {
		_role = role;
	}

	public int getCustomerId() {
		return _customerId;
	}

	public void setCustomerId(int customerId) {
		_customerId = customerId;
	}

	public int getOrgId() {
		return _orgId;
	}

	public void setOrgId(int orgId) {
		_orgId = orgId;
	}

	public String getDescription() {
		return GetterUtil.getString(_description);
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public ProGateOrgCustomerRepresenter toEscapedModel() {
		if (isEscapedModel()) {
			return (ProGateOrgCustomerRepresenter)this;
		}
		else {
			ProGateOrgCustomerRepresenter model = new ProGateOrgCustomerRepresenterImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setProGateOrgCustomerRepresenterId(getProGateOrgCustomerRepresenterId());
			model.setFirstName(HtmlUtil.escape(getFirstName()));
			model.setLastName(HtmlUtil.escape(getLastName()));
			model.setDisplayName(HtmlUtil.escape(getDisplayName()));
			model.setRole(HtmlUtil.escape(getRole()));
			model.setCustomerId(getCustomerId());
			model.setOrgId(getOrgId());
			model.setDescription(HtmlUtil.escape(getDescription()));
			model.setCreatedDate(getCreatedDate());
			model.setModifiedDate(getModifiedDate());

			model = (ProGateOrgCustomerRepresenter)Proxy.newProxyInstance(ProGateOrgCustomerRepresenter.class.getClassLoader(),
					new Class[] { ProGateOrgCustomerRepresenter.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ProGateOrgCustomerRepresenterImpl clone = new ProGateOrgCustomerRepresenterImpl();

		clone.setProGateOrgCustomerRepresenterId(getProGateOrgCustomerRepresenterId());
		clone.setFirstName(getFirstName());
		clone.setLastName(getLastName());
		clone.setDisplayName(getDisplayName());
		clone.setRole(getRole());
		clone.setCustomerId(getCustomerId());
		clone.setOrgId(getOrgId());
		clone.setDescription(getDescription());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	public int compareTo(
		ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				proGateOrgCustomerRepresenter.getModifiedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getCreatedDate(),
				proGateOrgCustomerRepresenter.getCreatedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = getDisplayName()
					.compareTo(proGateOrgCustomerRepresenter.getDisplayName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter = null;

		try {
			proGateOrgCustomerRepresenter = (ProGateOrgCustomerRepresenter)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = proGateOrgCustomerRepresenter.getPrimaryKey();

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

		sb.append("{ProGateOrgCustomerRepresenterId=");
		sb.append(getProGateOrgCustomerRepresenterId());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", displayName=");
		sb.append(getDisplayName());
		sb.append(", role=");
		sb.append(getRole());
		sb.append(", customerId=");
		sb.append(getCustomerId());
		sb.append(", orgId=");
		sb.append(getOrgId());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.ProGateOrgCustomerRepresenter");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ProGateOrgCustomerRepresenterId</column-name><column-value><![CDATA[");
		sb.append(getProGateOrgCustomerRepresenterId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayName</column-name><column-value><![CDATA[");
		sb.append(getDisplayName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>role</column-name><column-value><![CDATA[");
		sb.append(getRole());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customerId</column-name><column-value><![CDATA[");
		sb.append(getCustomerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgId</column-name><column-value><![CDATA[");
		sb.append(getOrgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _ProGateOrgCustomerRepresenterId;
	private String _firstName;
	private String _lastName;
	private String _displayName;
	private String _role;
	private int _customerId;
	private int _orgId;
	private String _description;
	private Date _createdDate;
	private Date _modifiedDate;
}