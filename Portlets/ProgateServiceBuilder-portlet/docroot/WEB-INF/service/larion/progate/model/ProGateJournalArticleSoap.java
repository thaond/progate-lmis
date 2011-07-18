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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="ProGateJournalArticleSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateJournalArticleSoap implements Serializable {
	public static ProGateJournalArticleSoap toSoapModel(
		ProGateJournalArticle model) {
		ProGateJournalArticleSoap soapModel = new ProGateJournalArticleSoap();

		soapModel.setJournalArticleId(model.getJournalArticleId());
		soapModel.setOrgId(model.getOrgId());
		soapModel.setArticleType(model.getArticleType());
		soapModel.setTitle(model.getTitle());
		soapModel.setResourceUrl(model.getResourceUrl());
		soapModel.setDescription(model.getDescription());
		soapModel.setContent(model.getContent());
		soapModel.setPriority(model.getPriority());
		soapModel.setSmallImageUrl(model.getSmallImageUrl());
		soapModel.setBigImageUrl(model.getBigImageUrl());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreatedAt(model.getCreatedAt());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedAt(model.getUpdatedAt());
		soapModel.setAddInfo(model.getAddInfo());
		soapModel.setArticleOrder(model.getArticleOrder());

		return soapModel;
	}

	public static ProGateJournalArticleSoap[] toSoapModels(
		ProGateJournalArticle[] models) {
		ProGateJournalArticleSoap[] soapModels = new ProGateJournalArticleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProGateJournalArticleSoap[][] toSoapModels(
		ProGateJournalArticle[][] models) {
		ProGateJournalArticleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProGateJournalArticleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProGateJournalArticleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProGateJournalArticleSoap[] toSoapModels(
		List<ProGateJournalArticle> models) {
		List<ProGateJournalArticleSoap> soapModels = new ArrayList<ProGateJournalArticleSoap>(models.size());

		for (ProGateJournalArticle model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProGateJournalArticleSoap[soapModels.size()]);
	}

	public ProGateJournalArticleSoap() {
	}

	public Integer getPrimaryKey() {
		return _journalArticleId;
	}

	public void setPrimaryKey(Integer pk) {
		setJournalArticleId(pk);
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