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

package larion.progate.model;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * <a href="ProGateJournalArticleClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateJournalArticleClp extends BaseModelImpl<ProGateJournalArticle>
	implements ProGateJournalArticle {
	public ProGateJournalArticleClp() {
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
		return _orgId;
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
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getResourceUrl() {
		return _resourceUrl;
	}

	public void setResourceUrl(String resourceUrl) {
		_resourceUrl = resourceUrl;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getContent() {
		return _content;
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
		return _smallImageUrl;
	}

	public void setSmallImageUrl(String smallImageUrl) {
		_smallImageUrl = smallImageUrl;
	}

	public String getBigImageUrl() {
		return _bigImageUrl;
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
		return _addInfo;
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
			return this;
		}
		else {
			ProGateJournalArticle model = new ProGateJournalArticleClp();

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
		ProGateJournalArticleClp clone = new ProGateJournalArticleClp();

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

		ProGateJournalArticleClp proGateJournalArticle = null;

		try {
			proGateJournalArticle = (ProGateJournalArticleClp)obj;
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