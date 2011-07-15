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

import larion.progate.model.ProGateJournalArticlePriorities;
import larion.progate.model.ProGateJournalArticlePrioritiesSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="ProGateJournalArticlePrioritiesModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateJournalArticlePrioritiesModelImpl extends BaseModelImpl<ProGateJournalArticlePriorities> {
	public static final String TABLE_NAME = "progate_journalarticle_priorities";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "name", new Integer(Types.VARCHAR) },
			

			{ "description", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table progate_journalarticle_priorities (id INTEGER not null primary key,name VARCHAR(75) null,description VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table progate_journalarticle_priorities";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.model.ProGateJournalArticlePriorities"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.model.ProGateJournalArticlePriorities"),
			false);

	public static ProGateJournalArticlePriorities toModel(
		ProGateJournalArticlePrioritiesSoap soapModel) {
		ProGateJournalArticlePriorities model = new ProGateJournalArticlePrioritiesImpl();

		model.setJournalArticlePrioritiesId(soapModel.getJournalArticlePrioritiesId());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());

		return model;
	}

	public static List<ProGateJournalArticlePriorities> toModels(
		ProGateJournalArticlePrioritiesSoap[] soapModels) {
		List<ProGateJournalArticlePriorities> models = new ArrayList<ProGateJournalArticlePriorities>(soapModels.length);

		for (ProGateJournalArticlePrioritiesSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.model.ProGateJournalArticlePriorities"));

	public ProGateJournalArticlePrioritiesModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _journalArticlePrioritiesId;
	}

	public void setPrimaryKey(Integer pk) {
		setJournalArticlePrioritiesId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _journalArticlePrioritiesId;
	}

	public Integer getJournalArticlePrioritiesId() {
		return _journalArticlePrioritiesId;
	}

	public void setJournalArticlePrioritiesId(
		Integer journalArticlePrioritiesId) {
		_journalArticlePrioritiesId = journalArticlePrioritiesId;
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

	public ProGateJournalArticlePriorities toEscapedModel() {
		if (isEscapedModel()) {
			return (ProGateJournalArticlePriorities)this;
		}
		else {
			ProGateJournalArticlePriorities model = new ProGateJournalArticlePrioritiesImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setJournalArticlePrioritiesId(getJournalArticlePrioritiesId());
			model.setName(HtmlUtil.escape(getName()));
			model.setDescription(HtmlUtil.escape(getDescription()));

			model = (ProGateJournalArticlePriorities)Proxy.newProxyInstance(ProGateJournalArticlePriorities.class.getClassLoader(),
					new Class[] { ProGateJournalArticlePriorities.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ProGateJournalArticlePrioritiesImpl clone = new ProGateJournalArticlePrioritiesImpl();

		clone.setJournalArticlePrioritiesId(getJournalArticlePrioritiesId());
		clone.setName(getName());
		clone.setDescription(getDescription());

		return clone;
	}

	public int compareTo(
		ProGateJournalArticlePriorities proGateJournalArticlePriorities) {
		Integer pk = proGateJournalArticlePriorities.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ProGateJournalArticlePriorities proGateJournalArticlePriorities = null;

		try {
			proGateJournalArticlePriorities = (ProGateJournalArticlePriorities)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = proGateJournalArticlePriorities.getPrimaryKey();

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

		sb.append("{journalArticlePrioritiesId=");
		sb.append(getJournalArticlePrioritiesId());
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
		sb.append("larion.progate.model.ProGateJournalArticlePriorities");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>journalArticlePrioritiesId</column-name><column-value><![CDATA[");
		sb.append(getJournalArticlePrioritiesId());
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

	private Integer _journalArticlePrioritiesId;
	private String _name;
	private String _description;
}