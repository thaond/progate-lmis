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

import larion.progate.model.ProGateJournalArticleSlideShow;
import larion.progate.model.ProGateJournalArticleSlideShowSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="ProGateJournalArticleSlideShowModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateJournalArticleSlideShowModelImpl extends BaseModelImpl<ProGateJournalArticleSlideShow> {
	public static final String TABLE_NAME = "progate_products_slideshow";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "orgid", new Integer(Types.INTEGER) },
			

			{ "productid", new Integer(Types.INTEGER) },
			

			{ "imageurl", new Integer(Types.VARCHAR) },
			

			{ "title", new Integer(Types.VARCHAR) },
			

			{ "titleurl", new Integer(Types.VARCHAR) },
			

			{ "slideindex", new Integer(Types.INTEGER) },
			

			{ "isservice", new Integer(Types.BOOLEAN) },
			

			{ "created_by", new Integer(Types.INTEGER) },
			

			{ "created_at", new Integer(Types.TIMESTAMP) },
			

			{ "updated_by", new Integer(Types.INTEGER) },
			

			{ "updated_at", new Integer(Types.TIMESTAMP) }
		};
	public static final String TABLE_SQL_CREATE = "create table progate_products_slideshow (id INTEGER not null primary key,orgid INTEGER,productid INTEGER,imageurl VARCHAR(75) null,title VARCHAR(75) null,titleurl VARCHAR(75) null,slideindex INTEGER,isservice BOOLEAN,created_by INTEGER,created_at DATE null,updated_by INTEGER,updated_at DATE null)";
	public static final String TABLE_SQL_DROP = "drop table progate_products_slideshow";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.model.ProGateJournalArticleSlideShow"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.model.ProGateJournalArticleSlideShow"),
			false);

	public static ProGateJournalArticleSlideShow toModel(
		ProGateJournalArticleSlideShowSoap soapModel) {
		ProGateJournalArticleSlideShow model = new ProGateJournalArticleSlideShowImpl();

		model.setJournalArticleSlideShowId(soapModel.getJournalArticleSlideShowId());
		model.setOrgId(soapModel.getOrgId());
		model.setProductId(soapModel.getProductId());
		model.setImageUrl(soapModel.getImageUrl());
		model.setTitle(soapModel.getTitle());
		model.setTitleUrl(soapModel.getTitleUrl());
		model.setSlideIndex(soapModel.getSlideIndex());
		model.setIsService(soapModel.getIsService());
		model.setCreatedBy(soapModel.getCreatedBy());
		model.setCreatedAt(soapModel.getCreatedAt());
		model.setUpdatedBy(soapModel.getUpdatedBy());
		model.setUpdatedAt(soapModel.getUpdatedAt());

		return model;
	}

	public static List<ProGateJournalArticleSlideShow> toModels(
		ProGateJournalArticleSlideShowSoap[] soapModels) {
		List<ProGateJournalArticleSlideShow> models = new ArrayList<ProGateJournalArticleSlideShow>(soapModels.length);

		for (ProGateJournalArticleSlideShowSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.model.ProGateJournalArticleSlideShow"));

	public ProGateJournalArticleSlideShowModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _journalArticleSlideShowId;
	}

	public void setPrimaryKey(Integer pk) {
		setJournalArticleSlideShowId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _journalArticleSlideShowId;
	}

	public Integer getJournalArticleSlideShowId() {
		return _journalArticleSlideShowId;
	}

	public void setJournalArticleSlideShowId(Integer journalArticleSlideShowId) {
		_journalArticleSlideShowId = journalArticleSlideShowId;
	}

	public int getOrgId() {
		return _orgId;
	}

	public void setOrgId(int orgId) {
		_orgId = orgId;
	}

	public int getProductId() {
		return _productId;
	}

	public void setProductId(int productId) {
		_productId = productId;
	}

	public String getImageUrl() {
		return GetterUtil.getString(_imageUrl);
	}

	public void setImageUrl(String imageUrl) {
		_imageUrl = imageUrl;
	}

	public String getTitle() {
		return GetterUtil.getString(_title);
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getTitleUrl() {
		return GetterUtil.getString(_titleUrl);
	}

	public void setTitleUrl(String titleUrl) {
		_titleUrl = titleUrl;
	}

	public int getSlideIndex() {
		return _slideIndex;
	}

	public void setSlideIndex(int slideIndex) {
		_slideIndex = slideIndex;
	}

	public boolean getIsService() {
		return _isService;
	}

	public boolean isIsService() {
		return _isService;
	}

	public void setIsService(boolean isService) {
		_isService = isService;
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

	public ProGateJournalArticleSlideShow toEscapedModel() {
		if (isEscapedModel()) {
			return (ProGateJournalArticleSlideShow)this;
		}
		else {
			ProGateJournalArticleSlideShow model = new ProGateJournalArticleSlideShowImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setJournalArticleSlideShowId(getJournalArticleSlideShowId());
			model.setOrgId(getOrgId());
			model.setProductId(getProductId());
			model.setImageUrl(HtmlUtil.escape(getImageUrl()));
			model.setTitle(HtmlUtil.escape(getTitle()));
			model.setTitleUrl(HtmlUtil.escape(getTitleUrl()));
			model.setSlideIndex(getSlideIndex());
			model.setIsService(getIsService());
			model.setCreatedBy(getCreatedBy());
			model.setCreatedAt(getCreatedAt());
			model.setUpdatedBy(getUpdatedBy());
			model.setUpdatedAt(getUpdatedAt());

			model = (ProGateJournalArticleSlideShow)Proxy.newProxyInstance(ProGateJournalArticleSlideShow.class.getClassLoader(),
					new Class[] { ProGateJournalArticleSlideShow.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ProGateJournalArticleSlideShowImpl clone = new ProGateJournalArticleSlideShowImpl();

		clone.setJournalArticleSlideShowId(getJournalArticleSlideShowId());
		clone.setOrgId(getOrgId());
		clone.setProductId(getProductId());
		clone.setImageUrl(getImageUrl());
		clone.setTitle(getTitle());
		clone.setTitleUrl(getTitleUrl());
		clone.setSlideIndex(getSlideIndex());
		clone.setIsService(getIsService());
		clone.setCreatedBy(getCreatedBy());
		clone.setCreatedAt(getCreatedAt());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedAt(getUpdatedAt());

		return clone;
	}

	public int compareTo(
		ProGateJournalArticleSlideShow proGateJournalArticleSlideShow) {
		int value = 0;

		if (getSlideIndex() < proGateJournalArticleSlideShow.getSlideIndex()) {
			value = -1;
		}
		else if (getSlideIndex() > proGateJournalArticleSlideShow.getSlideIndex()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getUpdatedAt(),
				proGateJournalArticleSlideShow.getUpdatedAt());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getCreatedAt(),
				proGateJournalArticleSlideShow.getCreatedAt());

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

		ProGateJournalArticleSlideShow proGateJournalArticleSlideShow = null;

		try {
			proGateJournalArticleSlideShow = (ProGateJournalArticleSlideShow)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = proGateJournalArticleSlideShow.getPrimaryKey();

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

		sb.append("{journalArticleSlideShowId=");
		sb.append(getJournalArticleSlideShowId());
		sb.append(", orgId=");
		sb.append(getOrgId());
		sb.append(", productId=");
		sb.append(getProductId());
		sb.append(", imageUrl=");
		sb.append(getImageUrl());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", titleUrl=");
		sb.append(getTitleUrl());
		sb.append(", slideIndex=");
		sb.append(getSlideIndex());
		sb.append(", isService=");
		sb.append(getIsService());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", createdAt=");
		sb.append(getCreatedAt());
		sb.append(", updatedBy=");
		sb.append(getUpdatedBy());
		sb.append(", updatedAt=");
		sb.append(getUpdatedAt());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.ProGateJournalArticleSlideShow");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>journalArticleSlideShowId</column-name><column-value><![CDATA[");
		sb.append(getJournalArticleSlideShowId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgId</column-name><column-value><![CDATA[");
		sb.append(getOrgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productId</column-name><column-value><![CDATA[");
		sb.append(getProductId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageUrl</column-name><column-value><![CDATA[");
		sb.append(getImageUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>titleUrl</column-name><column-value><![CDATA[");
		sb.append(getTitleUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>slideIndex</column-name><column-value><![CDATA[");
		sb.append(getSlideIndex());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isService</column-name><column-value><![CDATA[");
		sb.append(getIsService());
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

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _journalArticleSlideShowId;
	private int _orgId;
	private int _productId;
	private String _imageUrl;
	private String _title;
	private String _titleUrl;
	private int _slideIndex;
	private boolean _isService;
	private int _createdBy;
	private Date _createdAt;
	private int _updatedBy;
	private Date _updatedAt;
}