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

package larion.progate.cds.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="CdsTitlesSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsTitlesSoap implements Serializable {
	public static CdsTitlesSoap toSoapModel(CdsTitles model) {
		CdsTitlesSoap soapModel = new CdsTitlesSoap();

		soapModel.setCdsTitleId(model.getCdsTitleId());
		soapModel.setRootId(model.getRootId());
		soapModel.setName(model.getName());
		soapModel.setAbbreviation(model.getAbbreviation());
		soapModel.setNumberOrder(model.getNumberOrder());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreatedAt(model.getCreatedAt());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedAt(model.getUpdatedAt());

		return soapModel;
	}

	public static CdsTitlesSoap[] toSoapModels(CdsTitles[] models) {
		CdsTitlesSoap[] soapModels = new CdsTitlesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CdsTitlesSoap[][] toSoapModels(CdsTitles[][] models) {
		CdsTitlesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CdsTitlesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CdsTitlesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CdsTitlesSoap[] toSoapModels(List<CdsTitles> models) {
		List<CdsTitlesSoap> soapModels = new ArrayList<CdsTitlesSoap>(models.size());

		for (CdsTitles model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CdsTitlesSoap[soapModels.size()]);
	}

	public CdsTitlesSoap() {
	}

	public Integer getPrimaryKey() {
		return _cdsTitleId;
	}

	public void setPrimaryKey(Integer pk) {
		setCdsTitleId(pk);
	}

	public Integer getCdsTitleId() {
		return _cdsTitleId;
	}

	public void setCdsTitleId(Integer cdsTitleId) {
		_cdsTitleId = cdsTitleId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getAbbreviation() {
		return _abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		_abbreviation = abbreviation;
	}

	public int getNumberOrder() {
		return _numberOrder;
	}

	public void setNumberOrder(int numberOrder) {
		_numberOrder = numberOrder;
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

	private Integer _cdsTitleId;
	private int _rootId;
	private String _name;
	private String _abbreviation;
	private int _numberOrder;
	private int _createdBy;
	private Date _createdAt;
	private int _updatedBy;
	private Date _updatedAt;
}