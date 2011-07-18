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

import larion.progate.model.ProGateJournalArticleTypes;
import larion.progate.model.ProGateJournalArticleTypesSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="ProGateJournalArticleTypesModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateJournalArticleTypesModelImpl extends BaseModelImpl<ProGateJournalArticleTypes> {
	public static final String TABLE_NAME = "progate_journalarticle_types";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "name", new Integer(Types.VARCHAR) },
			

			{ "description", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table progate_journalarticle_types (id INTEGER not null primary key,name VARCHAR(75) null,description VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table progate_journalarticle_types";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.model.ProGateJournalArticleTypes"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.model.ProGateJournalArticleTypes"),
			false);

	public static ProGateJournalArticleTypes toModel(
		ProGateJournalArticleTypesSoap soapModel) {
		ProGateJournalArticleTypes model = new ProGateJournalArticleTypesImpl();

		model.setJournalArticleTypesId(soapModel.getJournalArticleTypesId());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());

		return model;
	}

	public static List<ProGateJournalArticleTypes> toModels(
		ProGateJournalArticleTypesSoap[] soapModels) {
		List<ProGateJournalArticleTypes> models = new ArrayList<ProGateJournalArticleTypes>(soapModels.length);

		for (ProGateJournalArticleTypesSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.model.ProGateJournalArticleTypes"));

	public ProGateJournalArticleTypesModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _journalArticleTypesId;
	}

	public void setPrimaryKey(Integer pk) {
		setJournalArticleTypesId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _journalArticleTypesId;
	}

	public Integer getJournalArticleTypesId() {
		return _journalArticleTypesId;
	}

	public void setJournalArticleTypesId(Integer journalArticleTypesId) {
		_journalArticleTypesId = journalArticleTypesId;
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

	public ProGateJournalArticleTypes toEscapedModel() {
		if (isEscapedModel()) {
			return (ProGateJournalArticleTypes)this;
		}
		else {
			ProGateJournalArticleTypes model = new ProGateJournalArticleTypesImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setJournalArticleTypesId(getJournalArticleTypesId());
			model.setName(HtmlUtil.escape(getName()));
			model.setDescription(HtmlUtil.escape(getDescription()));

			model = (ProGateJournalArticleTypes)Proxy.newProxyInstance(ProGateJournalArticleTypes.class.getClassLoader(),
					new Class[] { ProGateJournalArticleTypes.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ProGateJournalArticleTypesImpl clone = new ProGateJournalArticleTypesImpl();

		clone.setJournalArticleTypesId(getJournalArticleTypesId());
		clone.setName(getName());
		clone.setDescription(getDescription());

		return clone;
	}

	public int compareTo(ProGateJournalArticleTypes proGateJournalArticleTypes) {
		Integer pk = proGateJournalArticleTypes.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ProGateJournalArticleTypes proGateJournalArticleTypes = null;

		try {
			proGateJournalArticleTypes = (ProGateJournalArticleTypes)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = proGateJournalArticleTypes.getPrimaryKey();

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

		sb.append("{journalArticleTypesId=");
		sb.append(getJournalArticleTypesId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.ProGateJournalArticleTypes");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>journalArticleTypesId</column-name><column-value><![CDATA[");
		sb.append(getJournalArticleTypesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _journalArticleTypesId;
	private String _name;
	private String _description;
}