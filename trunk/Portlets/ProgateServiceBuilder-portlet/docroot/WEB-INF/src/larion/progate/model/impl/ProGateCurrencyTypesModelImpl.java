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

import larion.progate.model.ProGateCurrencyTypes;
import larion.progate.model.ProGateCurrencyTypesSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="ProGateCurrencyTypesModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateCurrencyTypesModelImpl extends BaseModelImpl<ProGateCurrencyTypes> {
	public static final String TABLE_NAME = "progate_currencytypes";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "code", new Integer(Types.VARCHAR) },
			

			{ "description", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table progate_currencytypes (id INTEGER not null primary key,code VARCHAR(75) null,description VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table progate_currencytypes";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.model.ProGateCurrencyTypes"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.model.ProGateCurrencyTypes"),
			false);

	public static ProGateCurrencyTypes toModel(
		ProGateCurrencyTypesSoap soapModel) {
		ProGateCurrencyTypes model = new ProGateCurrencyTypesImpl();

		model.setCurrencyId(soapModel.getCurrencyId());
		model.setCode(soapModel.getCode());
		model.setDescription(soapModel.getDescription());

		return model;
	}

	public static List<ProGateCurrencyTypes> toModels(
		ProGateCurrencyTypesSoap[] soapModels) {
		List<ProGateCurrencyTypes> models = new ArrayList<ProGateCurrencyTypes>(soapModels.length);

		for (ProGateCurrencyTypesSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.model.ProGateCurrencyTypes"));

	public ProGateCurrencyTypesModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _currencyId;
	}

	public void setPrimaryKey(Integer pk) {
		setCurrencyId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _currencyId;
	}

	public Integer getCurrencyId() {
		return _currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		_currencyId = currencyId;
	}

	public String getCode() {
		return GetterUtil.getString(_code);
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getDescription() {
		return GetterUtil.getString(_description);
	}

	public void setDescription(String description) {
		_description = description;
	}

	public ProGateCurrencyTypes toEscapedModel() {
		if (isEscapedModel()) {
			return (ProGateCurrencyTypes)this;
		}
		else {
			ProGateCurrencyTypes model = new ProGateCurrencyTypesImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setCurrencyId(getCurrencyId());
			model.setCode(HtmlUtil.escape(getCode()));
			model.setDescription(HtmlUtil.escape(getDescription()));

			model = (ProGateCurrencyTypes)Proxy.newProxyInstance(ProGateCurrencyTypes.class.getClassLoader(),
					new Class[] { ProGateCurrencyTypes.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ProGateCurrencyTypesImpl clone = new ProGateCurrencyTypesImpl();

		clone.setCurrencyId(getCurrencyId());
		clone.setCode(getCode());
		clone.setDescription(getDescription());

		return clone;
	}

	public int compareTo(ProGateCurrencyTypes proGateCurrencyTypes) {
		Integer pk = proGateCurrencyTypes.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ProGateCurrencyTypes proGateCurrencyTypes = null;

		try {
			proGateCurrencyTypes = (ProGateCurrencyTypes)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = proGateCurrencyTypes.getPrimaryKey();

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

		sb.append("{currencyId=");
		sb.append(getCurrencyId());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.ProGateCurrencyTypes");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>currencyId</column-name><column-value><![CDATA[");
		sb.append(getCurrencyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _currencyId;
	private String _code;
	private String _description;
}