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
import com.liferay.portal.model.impl.BaseModelImpl;

import larion.progate.model.ProGateProductsServices;
import larion.progate.model.ProGateProductsServicesSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="ProGateProductsServicesModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateProductsServicesModelImpl extends BaseModelImpl<ProGateProductsServices> {
	public static final String TABLE_NAME = "progate_products_services";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "articleid", new Integer(Types.INTEGER) },
			

			{ "orgid", new Integer(Types.INTEGER) },
			

			{ "discount", new Integer(Types.DOUBLE) },
			

			{ "price", new Integer(Types.DOUBLE) },
			

			{ "currencyid", new Integer(Types.INTEGER) },
			

			{ "producttype", new Integer(Types.INTEGER) },
			

			{ "is_hot", new Integer(Types.BOOLEAN) },
			

			{ "isservice", new Integer(Types.BOOLEAN) },
			

			{ "progate_category", new Integer(Types.INTEGER) },
			

			{ "expired_date", new Integer(Types.TIMESTAMP) },
			

			{ "amount", new Integer(Types.INTEGER) }
		};
	public static final String TABLE_SQL_CREATE = "create table progate_products_services (id INTEGER not null primary key,articleid INTEGER,orgid INTEGER,discount DOUBLE,price DOUBLE,currencyid INTEGER,producttype INTEGER,is_hot BOOLEAN,isservice BOOLEAN,progate_category INTEGER,expired_date DATE null,amount INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table progate_products_services";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.model.ProGateProductsServices"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.model.ProGateProductsServices"),
			false);

	public static ProGateProductsServices toModel(
		ProGateProductsServicesSoap soapModel) {
		ProGateProductsServices model = new ProGateProductsServicesImpl();

		model.setProductsServicesId(soapModel.getProductsServicesId());
		model.setArticleId(soapModel.getArticleId());
		model.setOrgId(soapModel.getOrgId());
		model.setDiscount(soapModel.getDiscount());
		model.setPrice(soapModel.getPrice());
		model.setCurrencyId(soapModel.getCurrencyId());
		model.setProductType(soapModel.getProductType());
		model.setIsHot(soapModel.getIsHot());
		model.setIsService(soapModel.getIsService());
		model.setProgateCategory(soapModel.getProgateCategory());
		model.setExpiredDate(soapModel.getExpiredDate());
		model.setAmount(soapModel.getAmount());

		return model;
	}

	public static List<ProGateProductsServices> toModels(
		ProGateProductsServicesSoap[] soapModels) {
		List<ProGateProductsServices> models = new ArrayList<ProGateProductsServices>(soapModels.length);

		for (ProGateProductsServicesSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.model.ProGateProductsServices"));

	public ProGateProductsServicesModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _productsServicesId;
	}

	public void setPrimaryKey(Integer pk) {
		setProductsServicesId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _productsServicesId;
	}

	public Integer getProductsServicesId() {
		return _productsServicesId;
	}

	public void setProductsServicesId(Integer productsServicesId) {
		_productsServicesId = productsServicesId;
	}

	public int getArticleId() {
		return _articleId;
	}

	public void setArticleId(int articleId) {
		_articleId = articleId;
	}

	public int getOrgId() {
		return _orgId;
	}

	public void setOrgId(int orgId) {
		_orgId = orgId;
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

	public int getProgateCategory() {
		return _progateCategory;
	}

	public void setProgateCategory(int progateCategory) {
		_progateCategory = progateCategory;
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

	public ProGateProductsServices toEscapedModel() {
		if (isEscapedModel()) {
			return (ProGateProductsServices)this;
		}
		else {
			ProGateProductsServices model = new ProGateProductsServicesImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setProductsServicesId(getProductsServicesId());
			model.setArticleId(getArticleId());
			model.setOrgId(getOrgId());
			model.setDiscount(getDiscount());
			model.setPrice(getPrice());
			model.setCurrencyId(getCurrencyId());
			model.setProductType(getProductType());
			model.setIsHot(getIsHot());
			model.setIsService(getIsService());
			model.setProgateCategory(getProgateCategory());
			model.setExpiredDate(getExpiredDate());
			model.setAmount(getAmount());

			model = (ProGateProductsServices)Proxy.newProxyInstance(ProGateProductsServices.class.getClassLoader(),
					new Class[] { ProGateProductsServices.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ProGateProductsServicesImpl clone = new ProGateProductsServicesImpl();

		clone.setProductsServicesId(getProductsServicesId());
		clone.setArticleId(getArticleId());
		clone.setOrgId(getOrgId());
		clone.setDiscount(getDiscount());
		clone.setPrice(getPrice());
		clone.setCurrencyId(getCurrencyId());
		clone.setProductType(getProductType());
		clone.setIsHot(getIsHot());
		clone.setIsService(getIsService());
		clone.setProgateCategory(getProgateCategory());
		clone.setExpiredDate(getExpiredDate());
		clone.setAmount(getAmount());

		return clone;
	}

	public int compareTo(ProGateProductsServices proGateProductsServices) {
		int value = 0;

		if (getOrgId() < proGateProductsServices.getOrgId()) {
			value = -1;
		}
		else if (getOrgId() > proGateProductsServices.getOrgId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getProductType() < proGateProductsServices.getProductType()) {
			value = -1;
		}
		else if (getProductType() > proGateProductsServices.getProductType()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getDiscount() < proGateProductsServices.getDiscount()) {
			value = -1;
		}
		else if (getDiscount() > proGateProductsServices.getDiscount()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getPrice() < proGateProductsServices.getPrice()) {
			value = -1;
		}
		else if (getPrice() > proGateProductsServices.getPrice()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ProGateProductsServices proGateProductsServices = null;

		try {
			proGateProductsServices = (ProGateProductsServices)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = proGateProductsServices.getPrimaryKey();

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

		sb.append("{productsServicesId=");
		sb.append(getProductsServicesId());
		sb.append(", articleId=");
		sb.append(getArticleId());
		sb.append(", orgId=");
		sb.append(getOrgId());
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
		sb.append(", progateCategory=");
		sb.append(getProgateCategory());
		sb.append(", expiredDate=");
		sb.append(getExpiredDate());
		sb.append(", amount=");
		sb.append(getAmount());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.ProGateProductsServices");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>productsServicesId</column-name><column-value><![CDATA[");
		sb.append(getProductsServicesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>articleId</column-name><column-value><![CDATA[");
		sb.append(getArticleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgId</column-name><column-value><![CDATA[");
		sb.append(getOrgId());
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
			"<column><column-name>progateCategory</column-name><column-value><![CDATA[");
		sb.append(getProgateCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expiredDate</column-name><column-value><![CDATA[");
		sb.append(getExpiredDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>amount</column-name><column-value><![CDATA[");
		sb.append(getAmount());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _productsServicesId;
	private int _articleId;
	private int _orgId;
	private double _discount;
	private double _price;
	private int _currencyId;
	private int _productType;
	private boolean _isHot;
	private boolean _isService;
	private int _progateCategory;
	private Date _expiredDate;
	private int _amount;
}