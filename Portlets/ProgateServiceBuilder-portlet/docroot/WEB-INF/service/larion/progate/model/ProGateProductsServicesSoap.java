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
 * <a href="ProGateProductsServicesSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateProductsServicesSoap implements Serializable {
	public static ProGateProductsServicesSoap toSoapModel(
		ProGateProductsServices model) {
		ProGateProductsServicesSoap soapModel = new ProGateProductsServicesSoap();

		soapModel.setProductsServicesId(model.getProductsServicesId());
		soapModel.setArticleId(model.getArticleId());
		soapModel.setOrgId(model.getOrgId());
		soapModel.setDiscount(model.getDiscount());
		soapModel.setPrice(model.getPrice());
		soapModel.setCurrencyId(model.getCurrencyId());
		soapModel.setProductType(model.getProductType());
		soapModel.setIsHot(model.getIsHot());
		soapModel.setIsService(model.getIsService());
		soapModel.setProgateCategory(model.getProgateCategory());
		soapModel.setExpiredDate(model.getExpiredDate());
		soapModel.setAmount(model.getAmount());

		return soapModel;
	}

	public static ProGateProductsServicesSoap[] toSoapModels(
		ProGateProductsServices[] models) {
		ProGateProductsServicesSoap[] soapModels = new ProGateProductsServicesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProGateProductsServicesSoap[][] toSoapModels(
		ProGateProductsServices[][] models) {
		ProGateProductsServicesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProGateProductsServicesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProGateProductsServicesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProGateProductsServicesSoap[] toSoapModels(
		List<ProGateProductsServices> models) {
		List<ProGateProductsServicesSoap> soapModels = new ArrayList<ProGateProductsServicesSoap>(models.size());

		for (ProGateProductsServices model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProGateProductsServicesSoap[soapModels.size()]);
	}

	public ProGateProductsServicesSoap() {
	}

	public Integer getPrimaryKey() {
		return _productsServicesId;
	}

	public void setPrimaryKey(Integer pk) {
		setProductsServicesId(pk);
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