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

import larion.progate.model.ProGateOrgCustomer;
import larion.progate.model.ProGateOrgCustomerSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="ProGateOrgCustomerModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateOrgCustomerModelImpl extends BaseModelImpl<ProGateOrgCustomer> {
	public static final String TABLE_NAME = "progate_org_customer";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "customer_type", new Integer(Types.INTEGER) },
			

			{ "customer_name", new Integer(Types.VARCHAR) },
			

			{ "org_id", new Integer(Types.INTEGER) },
			

			{ "has_org_map", new Integer(Types.BOOLEAN) },
			

			{ "url_org_map", new Integer(Types.VARCHAR) },
			

			{ "logo", new Integer(Types.VARCHAR) },
			

			{ "website", new Integer(Types.VARCHAR) },
			

			{ "description", new Integer(Types.VARCHAR) },
			

			{ "created_date", new Integer(Types.TIMESTAMP) },
			

			{ "modified_date", new Integer(Types.TIMESTAMP) }
		};
	public static final String TABLE_SQL_CREATE = "create table progate_org_customer (id INTEGER not null primary key,customer_type INTEGER,customer_name VARCHAR(75) null,org_id INTEGER,has_org_map BOOLEAN,url_org_map VARCHAR(75) null,logo VARCHAR(75) null,website VARCHAR(75) null,description VARCHAR(75) null,created_date DATE null,modified_date DATE null)";
	public static final String TABLE_SQL_DROP = "drop table progate_org_customer";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.model.ProGateOrgCustomer"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.model.ProGateOrgCustomer"),
			false);

	public static ProGateOrgCustomer toModel(ProGateOrgCustomerSoap soapModel) {
		ProGateOrgCustomer model = new ProGateOrgCustomerImpl();

		model.setProGateOrgCustomerId(soapModel.getProGateOrgCustomerId());
		model.setCustomerType(soapModel.getCustomerType());
		model.setCustomerName(soapModel.getCustomerName());
		model.setOrgId(soapModel.getOrgId());
		model.setHasOrgMap(soapModel.getHasOrgMap());
		model.setUrlOrgMap(soapModel.getUrlOrgMap());
		model.setLogo(soapModel.getLogo());
		model.setWebsite(soapModel.getWebsite());
		model.setDescription(soapModel.getDescription());
		model.setCreatedDate(soapModel.getCreatedDate());
		model.setModifiedDate(soapModel.getModifiedDate());

		return model;
	}

	public static List<ProGateOrgCustomer> toModels(
		ProGateOrgCustomerSoap[] soapModels) {
		List<ProGateOrgCustomer> models = new ArrayList<ProGateOrgCustomer>(soapModels.length);

		for (ProGateOrgCustomerSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.model.ProGateOrgCustomer"));

	public ProGateOrgCustomerModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _ProGateOrgCustomerId;
	}

	public void setPrimaryKey(Integer pk) {
		setProGateOrgCustomerId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _ProGateOrgCustomerId;
	}

	public Integer getProGateOrgCustomerId() {
		return _ProGateOrgCustomerId;
	}

	public void setProGateOrgCustomerId(Integer ProGateOrgCustomerId) {
		_ProGateOrgCustomerId = ProGateOrgCustomerId;
	}

	public int getCustomerType() {
		return _customerType;
	}

	public void setCustomerType(int customerType) {
		_customerType = customerType;
	}

	public String getCustomerName() {
		return GetterUtil.getString(_customerName);
	}

	public void setCustomerName(String customerName) {
		_customerName = customerName;
	}

	public int getOrgId() {
		return _orgId;
	}

	public void setOrgId(int orgId) {
		_orgId = orgId;
	}

	public boolean getHasOrgMap() {
		return _hasOrgMap;
	}

	public boolean isHasOrgMap() {
		return _hasOrgMap;
	}

	public void setHasOrgMap(boolean hasOrgMap) {
		_hasOrgMap = hasOrgMap;
	}

	public String getUrlOrgMap() {
		return GetterUtil.getString(_urlOrgMap);
	}

	public void setUrlOrgMap(String urlOrgMap) {
		_urlOrgMap = urlOrgMap;
	}

	public String getLogo() {
		return GetterUtil.getString(_logo);
	}

	public void setLogo(String logo) {
		_logo = logo;
	}

	public String getWebsite() {
		return GetterUtil.getString(_website);
	}

	public void setWebsite(String website) {
		_website = website;
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

	public ProGateOrgCustomer toEscapedModel() {
		if (isEscapedModel()) {
			return (ProGateOrgCustomer)this;
		}
		else {
			ProGateOrgCustomer model = new ProGateOrgCustomerImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setProGateOrgCustomerId(getProGateOrgCustomerId());
			model.setCustomerType(getCustomerType());
			model.setCustomerName(HtmlUtil.escape(getCustomerName()));
			model.setOrgId(getOrgId());
			model.setHasOrgMap(getHasOrgMap());
			model.setUrlOrgMap(HtmlUtil.escape(getUrlOrgMap()));
			model.setLogo(HtmlUtil.escape(getLogo()));
			model.setWebsite(HtmlUtil.escape(getWebsite()));
			model.setDescription(HtmlUtil.escape(getDescription()));
			model.setCreatedDate(getCreatedDate());
			model.setModifiedDate(getModifiedDate());

			model = (ProGateOrgCustomer)Proxy.newProxyInstance(ProGateOrgCustomer.class.getClassLoader(),
					new Class[] { ProGateOrgCustomer.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ProGateOrgCustomerImpl clone = new ProGateOrgCustomerImpl();

		clone.setProGateOrgCustomerId(getProGateOrgCustomerId());
		clone.setCustomerType(getCustomerType());
		clone.setCustomerName(getCustomerName());
		clone.setOrgId(getOrgId());
		clone.setHasOrgMap(getHasOrgMap());
		clone.setUrlOrgMap(getUrlOrgMap());
		clone.setLogo(getLogo());
		clone.setWebsite(getWebsite());
		clone.setDescription(getDescription());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	public int compareTo(ProGateOrgCustomer proGateOrgCustomer) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				proGateOrgCustomer.getModifiedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getCreatedDate(),
				proGateOrgCustomer.getCreatedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = getCustomerName().compareTo(proGateOrgCustomer.getCustomerName());

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

		ProGateOrgCustomer proGateOrgCustomer = null;

		try {
			proGateOrgCustomer = (ProGateOrgCustomer)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = proGateOrgCustomer.getPrimaryKey();

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

		sb.append("{ProGateOrgCustomerId=");
		sb.append(getProGateOrgCustomerId());
		sb.append(", customerType=");
		sb.append(getCustomerType());
		sb.append(", customerName=");
		sb.append(getCustomerName());
		sb.append(", orgId=");
		sb.append(getOrgId());
		sb.append(", hasOrgMap=");
		sb.append(getHasOrgMap());
		sb.append(", urlOrgMap=");
		sb.append(getUrlOrgMap());
		sb.append(", logo=");
		sb.append(getLogo());
		sb.append(", website=");
		sb.append(getWebsite());
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
		sb.append("larion.progate.model.ProGateOrgCustomer");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ProGateOrgCustomerId</column-name><column-value><![CDATA[");
		sb.append(getProGateOrgCustomerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customerType</column-name><column-value><![CDATA[");
		sb.append(getCustomerType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customerName</column-name><column-value><![CDATA[");
		sb.append(getCustomerName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgId</column-name><column-value><![CDATA[");
		sb.append(getOrgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hasOrgMap</column-name><column-value><![CDATA[");
		sb.append(getHasOrgMap());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>urlOrgMap</column-name><column-value><![CDATA[");
		sb.append(getUrlOrgMap());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>logo</column-name><column-value><![CDATA[");
		sb.append(getLogo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>website</column-name><column-value><![CDATA[");
		sb.append(getWebsite());
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

	private Integer _ProGateOrgCustomerId;
	private int _customerType;
	private String _customerName;
	private int _orgId;
	private boolean _hasOrgMap;
	private String _urlOrgMap;
	private String _logo;
	private String _website;
	private String _description;
	private Date _createdDate;
	private Date _modifiedDate;
}