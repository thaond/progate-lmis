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
 * <a href="ProGateJournalArticleViewSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateJournalArticleViewSoap implements Serializable {
	public static ProGateJournalArticleViewSoap toSoapModel(
		ProGateJournalArticleView model) {
		ProGateJournalArticleViewSoap soapModel = new ProGateJournalArticleViewSoap();

		soapModel.setJournalArticleId(model.getJournalArticleId());
		soapModel.setOrgId(model.getOrgId());
		soapModel.setOrgName(model.getOrgName());
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
		soapModel.setDiscount(model.getDiscount());
		soapModel.setPrice(model.getPrice());
		soapModel.setCurrencyId(model.getCurrencyId());
		soapModel.setProductType(model.getProductType());
		soapModel.setIsHot(model.getIsHot());
		soapModel.setIsService(model.getIsService());
		soapModel.setExpiredDate(model.getExpiredDate());
		soapModel.setAmount(model.getAmount());
		soapModel.setCurrencyCode(model.getCurrencyCode());
		soapModel.setJournalArticleTypesName(model.getJournalArticleTypesName());
		soapModel.setProgateCategory(model.getProgateCategory());

		return soapModel;
	}

	public static ProGateJournalArticleViewSoap[] toSoapModels(
		ProGateJournalArticleView[] models) {
		ProGateJournalArticleViewSoap[] soapModels = new ProGateJournalArticleViewSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProGateJournalArticleViewSoap[][] toSoapModels(
		ProGateJournalArticleView[][] models) {
		ProGateJournalArticleViewSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProGateJournalArticleViewSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProGateJournalArticleViewSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProGateJournalArticleViewSoap[] toSoapModels(
		List<ProGateJournalArticleView> models) {
		List<ProGateJournalArticleViewSoap> soapModels = new ArrayList<ProGateJournalArticleViewSoap>(models.size());

		for (ProGateJournalArticleView model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProGateJournalArticleViewSoap[soapModels.size()]);
	}

	public ProGateJournalArticleViewSoap() {
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

	public String getOrgName() {
		return _orgName;
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
		return _currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		_currencyCode = currencyCode;
	}

	public String getJournalArticleTypesName() {
		return _journalArticleTypesName;
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