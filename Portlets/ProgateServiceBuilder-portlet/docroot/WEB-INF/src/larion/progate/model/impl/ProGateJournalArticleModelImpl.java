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

import larion.progate.model.ProGateJournalArticle;
import larion.progate.model.ProGateJournalArticleSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="ProGateJournalArticleModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateJournalArticleModelImpl extends BaseModelImpl<ProGateJournalArticle> {
	public static final String TABLE_NAME = "progate_journalarticle";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "orgid", new Integer(Types.VARCHAR) },
			

			{ "articletype", new Integer(Types.INTEGER) },
			

			{ "title", new Integer(Types.VARCHAR) },
			

			{ "titleurl", new Integer(Types.VARCHAR) },
			

			{ "description", new Integer(Types.VARCHAR) },
			

			{ "content", new Integer(Types.VARCHAR) },
			

			{ "priority", new Integer(Types.INTEGER) },
			

			{ "smallimageurl", new Integer(Types.VARCHAR) },
			

			{ "bigimageurl", new Integer(Types.VARCHAR) },
			

			{ "created_by", new Integer(Types.INTEGER) },
			

			{ "created_at", new Integer(Types.TIMESTAMP) },
			

			{ "updated_by", new Integer(Types.INTEGER) },
			

			{ "updated_at", new Integer(Types.TIMESTAMP) },
			

			{ "addInfo", new Integer(Types.VARCHAR) },
			

			{ "article_order", new Integer(Types.INTEGER) }
		};
	public static final String TABLE_SQL_CREATE = "create table progate_journalarticle (id INTEGER not null primary key,orgid VARCHAR(75) null,articletype INTEGER,title VARCHAR(75) null,titleurl VARCHAR(75) null,description VARCHAR(75) null,content VARCHAR(75) null,priority INTEGER,smallimageurl VARCHAR(75) null,bigimageurl VARCHAR(75) null,created_by INTEGER,created_at DATE null,updated_by INTEGER,updated_at DATE null,addInfo VARCHAR(75) null,article_order INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table progate_journalarticle";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.model.ProGateJournalArticle"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.model.ProGateJournalArticle"),
			false);

	public static ProGateJournalArticle toModel(
		ProGateJournalArticleSoap soapModel) {
		ProGateJournalArticle model = new ProGateJournalArticleImpl();

		model.setJournalArticleId(soapModel.getJournalArticleId());
		model.setOrgId(soapModel.getOrgId());
		model.setArticleType(soapModel.getArticleType());
		model.setTitle(soapModel.getTitle());
		model.setResourceUrl(soapModel.getResourceUrl());
		model.setDescription(soapModel.getDescription());
		model.setContent(soapModel.getContent());
		model.setPriority(soapModel.getPriority());
		model.setSmallImageUrl(soapModel.getSmallImageUrl());
		model.setBigImageUrl(soapModel.getBigImageUrl());
		model.setCreatedBy(soapModel.getCreatedBy());
		model.setCreatedAt(soapModel.getCreatedAt());
		model.setUpdatedBy(soapModel.getUpdatedBy());
		model.setUpdatedAt(soapModel.getUpdatedAt());
		model.setAddInfo(soapModel.getAddInfo());
		model.setArticleOrder(soapModel.getArticleOrder());

		return model;
	}

	public static List<ProGateJournalArticle> toModels(
		ProGateJournalArticleSoap[] soapModels) {
		List<ProGateJournalArticle> models = new ArrayList<ProGateJournalArticle>(soapModels.length);

		for (ProGateJournalArticleSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.model.ProGateJournalArticle"));

	public ProGateJournalArticleModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _journalArticleId;
	}

	public void setPrimaryKey(Integer pk) {
		setJournalArticleId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _journalArticleId;
	}

	public Integer getJournalArticleId() {
		return _journalArticleId;
	}

	public void setJournalArticleId(Integer journalArticleId) {
		_journalArticleId = journalArticleId;
	}

	public String getOrgId() {
		return GetterUtil.getString(_orgId);
	}

	public void setOrgId(String orgId) {
		_orgId = orgId;
	}

	public int getArticleType() {
		return _articleType;
	}

	public void setArticleType(int articleType) {
		_articleType = articleType;
	}

	public String getTitle() {
		return GetterUtil.getString(_title);
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getResourceUrl() {
		return GetterUtil.getString(_resourceUrl);
	}

	public void setResourceUrl(String resourceUrl) {
		_resourceUrl = resourceUrl;
	}

	public String getDescription() {
		return GetterUtil.getString(_description);
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getContent() {
		return GetterUtil.getString(_content);
	}

	public void setContent(String content) {
		_content = content;
	}

	public int getPriority() {
		return _priority;
	}

	public void setPriority(int priority) {
		_priority = priority;
	}

	public String getSmallImageUrl() {
		return GetterUtil.getString(_smallImageUrl);
	}

	public void setSmallImageUrl(String smallImageUrl) {
		_smallImageUrl = smallImageUrl;
	}

	public String getBigImageUrl() {
		return GetterUtil.getString(_bigImageUrl);
	}

	public void setBigImageUrl(String bigImageUrl) {
		_bigImageUrl = bigImageUrl;
	}

	public int getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(int createdBy) {
		_createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return _createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		_createdAt = createdAt;
	}

	public int getUpdatedBy() {
		return _updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		_updatedBy = updatedBy;
	}

	public Date getUpdatedAt() {
		return _updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		_updatedAt = updatedAt;
	}

	public String getAddInfo() {
		return GetterUtil.getString(_addInfo);
	}

	public void setAddInfo(String addInfo) {
		_addInfo = addInfo;
	}

	public int getArticleOrder() {
		return _articleOrder;
	}

	public void setArticleOrder(int articleOrder) {
		_articleOrder = articleOrder;
	}

	public ProGateJournalArticle toEscapedModel() {
		if (isEscapedModel()) {
			return (ProGateJournalArticle)this;
		}
		else {
			ProGateJournalArticle model = new ProGateJournalArticleImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setJournalArticleId(getJournalArticleId());
			model.setOrgId(HtmlUtil.escape(getOrgId()));
			model.setArticleType(getArticleType());
			model.setTitle(HtmlUtil.escape(getTitle()));
			model.setResourceUrl(HtmlUtil.escape(getResourceUrl()));
			model.setDescription(HtmlUtil.escape(getDescription()));
			model.setContent(HtmlUtil.escape(getContent()));
			model.setPriority(getPriority());
			model.setSmallImageUrl(HtmlUtil.escape(getSmallImageUrl()));
			model.setBigImageUrl(HtmlUtil.escape(getBigImageUrl()));
			model.setCreatedBy(getCreatedBy());
			model.setCreatedAt(getCreatedAt());
			model.setUpdatedBy(getUpdatedBy());
			model.setUpdatedAt(getUpdatedAt());
			model.setAddInfo(HtmlUtil.escape(getAddInfo()));
			model.setArticleOrder(getArticleOrder());

			model = (ProGateJournalArticle)Proxy.newProxyInstance(ProGateJournalArticle.class.getClassLoader(),
					new Class[] { ProGateJournalArticle.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ProGateJournalArticleImpl clone = new ProGateJournalArticleImpl();

		clone.setJournalArticleId(getJournalArticleId());
		clone.setOrgId(getOrgId());
		clone.setArticleType(getArticleType());
		clone.setTitle(getTitle());
		clone.setResourceUrl(getResourceUrl());
		clone.setDescription(getDescription());
		clone.setContent(getContent());
		clone.setPriority(getPriority());
		clone.setSmallImageUrl(getSmallImageUrl());
		clone.setBigImageUrl(getBigImageUrl());
		clone.setCreatedBy(getCreatedBy());
		clone.setCreatedAt(getCreatedAt());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedAt(getUpdatedAt());
		clone.setAddInfo(getAddInfo());
		clone.setArticleOrder(getArticleOrder());

		return clone;
	}

	public int compareTo(ProGateJournalArticle proGateJournalArticle) {
		int value = 0;

		if (getArticleOrder() < proGateJournalArticle.getArticleOrder()) {
			value = -1;
		}
		else if (getArticleOrder() > proGateJournalArticle.getArticleOrder()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getUpdatedAt(),
				proGateJournalArticle.getUpdatedAt());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		if (getPriority() < proGateJournalArticle.getPriority()) {
			value = -1;
		}
		else if (getPriority() > proGateJournalArticle.getPriority()) {
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

		ProGateJournalArticle proGateJournalArticle = null;

		try {
			proGateJournalArticle = (ProGateJournalArticle)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = proGateJournalArticle.getPrimaryKey();

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

		sb.append("{journalArticleId=");
		sb.append(getJournalArticleId());
		sb.append(", orgId=");
		sb.append(getOrgId());
		sb.append(", articleType=");
		sb.append(getArticleType());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", resourceUrl=");
		sb.append(getResourceUrl());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", priority=");
		sb.append(getPriority());
		sb.append(", smallImageUrl=");
		sb.append(getSmallImageUrl());
		sb.append(", bigImageUrl=");
		sb.append(getBigImageUrl());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", createdAt=");
		sb.append(getCreatedAt());
		sb.append(", updatedBy=");
		sb.append(getUpdatedBy());
		sb.append(", updatedAt=");
		sb.append(getUpdatedAt());
		sb.append(", addInfo=");
		sb.append(getAddInfo());
		sb.append(", articleOrder=");
		sb.append(getArticleOrder());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.ProGateJournalArticle");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>journalArticleId</column-name><column-value><![CDATA[");
		sb.append(getJournalArticleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgId</column-name><column-value><![CDATA[");
		sb.append(getOrgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>articleType</column-name><column-value><![CDATA[");
		sb.append(getArticleType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resourceUrl</column-name><column-value><![CDATA[");
		sb.append(getResourceUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>priority</column-name><column-value><![CDATA[");
		sb.append(getPriority());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>smallImageUrl</column-name><column-value><![CDATA[");
		sb.append(getSmallImageUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bigImageUrl</column-name><column-value><![CDATA[");
		sb.append(getBigImageUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdAt</column-name><column-value><![CDATA[");
		sb.append(getCreatedAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updatedBy</column-name><column-value><![CDATA[");
		sb.append(getUpdatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updatedAt</column-name><column-value><![CDATA[");
		sb.append(getUpdatedAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>addInfo</column-name><column-value><![CDATA[");
		sb.append(getAddInfo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>articleOrder</column-name><column-value><![CDATA[");
		sb.append(getArticleOrder());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _journalArticleId;
	private String _orgId;
	private int _articleType;
	private String _title;
	private String _resourceUrl;
	private String _description;
	private String _content;
	private int _priority;
	private String _smallImageUrl;
	private String _bigImageUrl;
	private int _createdBy;
	private Date _createdAt;
	private int _updatedBy;
	private Date _updatedAt;
	private String _addInfo;
	private int _articleOrder;
}