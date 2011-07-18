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
 * <a href="ProGateJournalArticleSlideShowSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateJournalArticleSlideShowSoap implements Serializable {
	public static ProGateJournalArticleSlideShowSoap toSoapModel(
		ProGateJournalArticleSlideShow model) {
		ProGateJournalArticleSlideShowSoap soapModel = new ProGateJournalArticleSlideShowSoap();

		soapModel.setJournalArticleSlideShowId(model.getJournalArticleSlideShowId());
		soapModel.setOrgId(model.getOrgId());
		soapModel.setProductId(model.getProductId());
		soapModel.setImageUrl(model.getImageUrl());
		soapModel.setTitle(model.getTitle());
		soapModel.setTitleUrl(model.getTitleUrl());
		soapModel.setSlideIndex(model.getSlideIndex());
		soapModel.setIsService(model.getIsService());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreatedAt(model.getCreatedAt());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedAt(model.getUpdatedAt());

		return soapModel;
	}

	public static ProGateJournalArticleSlideShowSoap[] toSoapModels(
		ProGateJournalArticleSlideShow[] models) {
		ProGateJournalArticleSlideShowSoap[] soapModels = new ProGateJournalArticleSlideShowSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProGateJournalArticleSlideShowSoap[][] toSoapModels(
		ProGateJournalArticleSlideShow[][] models) {
		ProGateJournalArticleSlideShowSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProGateJournalArticleSlideShowSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProGateJournalArticleSlideShowSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProGateJournalArticleSlideShowSoap[] toSoapModels(
		List<ProGateJournalArticleSlideShow> models) {
		List<ProGateJournalArticleSlideShowSoap> soapModels = new ArrayList<ProGateJournalArticleSlideShowSoap>(models.size());

		for (ProGateJournalArticleSlideShow model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProGateJournalArticleSlideShowSoap[soapModels.size()]);
	}

	public ProGateJournalArticleSlideShowSoap() {
	}

	public Integer getPrimaryKey() {
		return _journalArticleSlideShowId;
	}

	public void setPrimaryKey(Integer pk) {
		setJournalArticleSlideShowId(pk);
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
		return _imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		_imageUrl = imageUrl;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getTitleUrl() {
		return _titleUrl;
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