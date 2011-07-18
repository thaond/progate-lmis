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

import larion.progate.model.ProGateJournalArticleView;
import larion.progate.model.ProGateJournalArticleViewSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="ProGateJournalArticleViewModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateJournalArticleViewModelImpl extends BaseModelImpl<ProGateJournalArticleView> {
	public static final String TABLE_NAME = "V_ProGateJournalArticle";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "orgid", new Integer(Types.VARCHAR) },
			

			{ "name", new Integer(Types.VARCHAR) },
			

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
			

			{ "discount", new Integer(Types.DOUBLE) },
			

			{ "price", new Integer(Types.DOUBLE) },
			

			{ "currencyid", new Integer(Types.INTEGER) },
			

			{ "producttype", new Integer(Types.INTEGER) },
			

			{ "is_hot", new Integer(Types.BOOLEAN) },
			

			{ "isservice", new Integer(Types.BOOLEAN) },
			

			{ "expired_date", new Integer(Types.TIMESTAMP) },
			

			{ "amount", new Integer(Types.INTEGER) },
			

			{ "currencyCode", new Integer(Types.VARCHAR) },
			

			{ "journalarticleTypesName", new Integer(Types.VARCHAR) },
			

			{ "progate_category", new Integer(Types.INTEGER) }
		};
	public static final String TABLE_SQL_CREATE = "create table V_ProGateJournalArticle (id INTEGER not null primary key,orgid VARCHAR(75) null,name VARCHAR(75) null,articletype INTEGER,title VARCHAR(75) null,titleurl VARCHAR(75) null,description VARCHAR(75) null,content VARCHAR(75) null,priority INTEGER,smallimageurl VARCHAR(75) null,bigimageurl VARCHAR(75) null,created_by INTEGER,created_at DATE null,updated_by INTEGER,updated_at DATE null,discount DOUBLE,price DOUBLE,currencyid INTEGER,producttype INTEGER,is_hot BOOLEAN,isservice BOOLEAN,expired_date DATE null,amount INTEGER,currencyCode VARCHAR(75) null,journalarticleTypesName VARCHAR(75) null,progate_category INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table V_ProGateJournalArticle";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.model.ProGateJournalArticleView"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.model.ProGateJournalArticleView"),
			false);

	public static ProGateJournalArticleView toModel(
		ProGateJournalArticleViewSoap soapModel) {
		ProGateJournalArticleView model = new ProGateJournalArticleViewImpl();

		model.setJournalArticleId(soapModel.getJournalArticleId());
		model.setOrgId(soapModel.getOrgId());
		model.setOrgName(soapModel.getOrgName());
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
		model.setDiscount(soapModel.getDiscount());
		model.setPrice(soapModel.getPrice());
		model.setCurrencyId(soapModel.getCurrencyId());
		model.setProductType(soapModel.getProductType());
		model.setIsHot(soapModel.getIsHot());
		model.setIsService(soapModel.getIsService());
		model.setExpiredDate(soapModel.getExpiredDate());
		model.setAmount(soapModel.getAmount());
		model.setCurrencyCode(soapModel.getCurrencyCode());
		model.setJournalArticleTypesName(soapModel.getJournalArticleTypesName());
		model.setProgateCategory(soapModel.getProgateCategory());

		return model;
	}

	public static List<ProGateJournalArticleView> toModels(
		ProGateJournalArticleViewSoap[] soapModels) {
		List<ProGateJournalArticleView> models = new ArrayList<ProGateJournalArticleView>(soapModels.length);

		for (ProGateJournalArticleViewSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.model.ProGateJournalArticleView"));

	public ProGateJournalArticleViewModelImpl() {
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

	public String getOrgName() {
		return GetterUtil.getString(_orgName);
	}

	public void setOrgName(String orgName) {
		_orgName = orgName;
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

	public double getDiscount() {
		return _discount;
	}

	public void setDiscount(double discount) {
		_discount = discount;
	}

	public double getPrice() {
		return _price;
	}

	public void setPrice(double price) {
		_price = price;
	}

	public int getCurrencyId() {
		return _currencyId;
	}

	public void setCurrencyId(int currencyId) {
		_currencyId = currencyId;
	}

	public int getProductType() {
		return _productType;
	}

	public void setProductType(int productType) {
		_productType = productType;
	}

	public boolean getIsHot() {
		return _isHot;
	}

	public boolean isIsHot() {
		return _isHot;
	}

	public void setIsHot(boolean isHot) {
		_isHot = isHot;
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

	public Date getExpiredDate() {
		return _expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		_expiredDate = expiredDate;
	}

	public int getAmount() {
		return _amount;
	}

	public void setAmount(int amount) {
		_amount = amount;
	}

	public String getCurrencyCode() {
		return GetterUtil.getString(_currencyCode);
	}

	public void setCurrencyCode(String currencyCode) {
		_currencyCode = currencyCode;
	}

	public String getJournalArticleTypesName() {
		return GetterUtil.getString(_journalArticleTypesName);
	}

	public void setJournalArticleTypesName(String journalArticleTypesName) {
		_journalArticleTypesName = journalArticleTypesName;
	}

	public int getProgateCategory() {
		return _progateCategory;
	}

	public void setProgateCategory(int progateCategory) {
		_progateCategory = progateCategory;
	}

	public ProGateJournalArticleView toEscapedModel() {
		if (isEscapedModel()) {
			return (ProGateJournalArticleView)this;
		}
		else {
			ProGateJournalArticleView model = new ProGateJournalArticleViewImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setJournalArticleId(getJournalArticleId());
			model.setOrgId(HtmlUtil.escape(getOrgId()));
			model.setOrgName(HtmlUtil.escape(getOrgName()));
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
			model.setDiscount(getDiscount());
			model.setPrice(getPrice());
			model.setCurrencyId(getCurrencyId());
			model.setProductType(getProductType());
			model.setIsHot(getIsHot());
			model.setIsService(getIsService());
			model.setExpiredDate(getExpiredDate());
			model.setAmount(getAmount());
			model.setCurrencyCode(HtmlUtil.escape(getCurrencyCode()));
			model.setJournalArticleTypesName(HtmlUtil.escape(
					getJournalArticleTypesName()));
			model.setProgateCategory(getProgateCategory());

			model = (ProGateJournalArticleView)Proxy.newProxyInstance(ProGateJournalArticleView.class.getClassLoader(),
					new Class[] { ProGateJournalArticleView.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ProGateJournalArticleViewImpl clone = new ProGateJournalArticleViewImpl();

		clone.setJournalArticleId(getJournalArticleId());
		clone.setOrgId(getOrgId());
		clone.setOrgName(getOrgName());
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
		clone.setDiscount(getDiscount());
		clone.setPrice(getPrice());
		clone.setCurrencyId(getCurrencyId());
		clone.setProductType(getProductType());
		clone.setIsHot(getIsHot());
		clone.setIsService(getIsService());
		clone.setExpiredDate(getExpiredDate());
		clone.setAmount(getAmount());
		clone.setCurrencyCode(getCurrencyCode());
		clone.setJournalArticleTypesName(getJournalArticleTypesName());
		clone.setProgateCategory(getProgateCategory());

		return clone;
	}

	public int compareTo(ProGateJournalArticleView proGateJournalArticleView) {
		int value = 0;

		value = DateUtil.compareTo(getUpdatedAt(),
				proGateJournalArticleView.getUpdatedAt());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getCreatedAt(),
				proGateJournalArticleView.getCreatedAt());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		if (getPriority() < proGateJournalArticleView.getPriority()) {
			value = -1;
		}
		else if (getPriority() > proGateJournalArticleView.getPriority()) {
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

		ProGateJournalArticleView proGateJournalArticleView = null;

		try {
			proGateJournalArticleView = (ProGateJournalArticleView)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = proGateJournalArticleView.getPrimaryKey();

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
		sb.append(", orgName=");
		sb.append(getOrgName());
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
		sb.append(", discount=");
		sb.append(getDiscount());
		sb.append(", price=");
		sb.append(getPrice());
		sb.append(", currencyId=");
		sb.append(getCurrencyId());
		sb.append(", productType=");
		sb.append(getProductType());
		sb.append(", isHot=");
		sb.append(getIsHot());
		sb.append(", isService=");
		sb.append(getIsService());
		sb.append(", expiredDate=");
		sb.append(getExpiredDate());
		sb.append(", amount=");
		sb.append(getAmount());
		sb.append(", currencyCode=");
		sb.append(getCurrencyCode());
		sb.append(", journalArticleTypesName=");
		sb.append(getJournalArticleTypesName());
		sb.append(", progateCategory=");
		sb.append(getProgateCategory());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.ProGateJournalArticleView");
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
			"<column><column-name>orgName</column-name><column-value><![CDATA[");
		sb.append(getOrgName());
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
			"<column><column-name>discount</column-name><column-value><![CDATA[");
		sb.append(getDiscount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>price</column-name><column-value><![CDATA[");
		sb.append(getPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currencyId</column-name><column-value><![CDATA[");
		sb.append(getCurrencyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productType</column-name><column-value><![CDATA[");
		sb.append(getProductType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isHot</column-name><column-value><![CDATA[");
		sb.append(getIsHot());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isService</column-name><column-value><![CDATA[");
		sb.append(getIsService());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expiredDate</column-name><column-value><![CDATA[");
		sb.append(getExpiredDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>amount</column-name><column-value><![CDATA[");
		sb.append(getAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currencyCode</column-name><column-value><![CDATA[");
		sb.append(getCurrencyCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>journalArticleTypesName</column-name><column-value><![CDATA[");
		sb.append(getJournalArticleTypesName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>progateCategory</column-name><column-value><![CDATA[");
		sb.append(getProgateCategory());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _journalArticleId;
	private String _orgId;
	private String _orgName;
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
	private double _discount;
	private double _price;
	private int _currencyId;
	private int _productType;
	private boolean _isHot;
	private boolean _isService;
	private Date _expiredDate;
	private int _amount;
	private String _currencyCode;
	private String _journalArticleTypesName;
	private int _progateCategory;
}