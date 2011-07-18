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

import larion.progate.model.Country;
import larion.progate.model.CountrySoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="CountryModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CountryModelImpl extends BaseModelImpl<Country> {
	public static final String TABLE_NAME = "country";
	public static final Object[][] TABLE_COLUMNS = {
			{ "countryid", new Integer(Types.INTEGER) },
			

			{ "name", new Integer(Types.VARCHAR) },
			

			{ "active_", new Integer(Types.BOOLEAN) }
		};
	public static final String TABLE_SQL_CREATE = "create table country (countryid INTEGER not null primary key,name VARCHAR(75) null,active_ BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table country";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.model.Country"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.model.Country"),
			false);

	public static Country toModel(CountrySoap soapModel) {
		Country model = new CountryImpl();

		model.setCountryId(soapModel.getCountryId());
		model.setName(soapModel.getName());
		model.setActive(soapModel.getActive());

		return model;
	}

	public static List<Country> toModels(CountrySoap[] soapModels) {
		List<Country> models = new ArrayList<Country>(soapModels.length);

		for (CountrySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.model.Country"));

	public CountryModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _countryId;
	}

	public void setPrimaryKey(Integer pk) {
		setCountryId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _countryId;
	}

	public Integer getCountryId() {
		return _countryId;
	}

	public void setCountryId(Integer countryId) {
		_countryId = countryId;
	}

	public String getName() {
		return GetterUtil.getString(_name);
	}

	public void setName(String name) {
		_name = name;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public Country toEscapedModel() {
		if (isEscapedModel()) {
			return (Country)this;
		}
		else {
			Country model = new CountryImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setCountryId(getCountryId());
			model.setName(HtmlUtil.escape(getName()));
			model.setActive(getActive());

			model = (Country)Proxy.newProxyInstance(Country.class.getClassLoader(),
					new Class[] { Country.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		CountryImpl clone = new CountryImpl();

		clone.setCountryId(getCountryId());
		clone.setName(getName());
		clone.setActive(getActive());

		return clone;
	}

	public int compareTo(Country country) {
		Integer pk = country.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		Country country = null;

		try {
			country = (Country)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = country.getPrimaryKey();

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

		sb.append("{countryId=");
		sb.append(getCountryId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", active=");
		sb.append(getActive());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.Country");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>countryId</column-name><column-value><![CDATA[");
		sb.append(getCountryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _countryId;
	private String _name;
	private boolean _active;
}