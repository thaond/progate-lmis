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
 * <a href="ProGateOrgCustomerSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateOrgCustomerSoap implements Serializable {
	public static ProGateOrgCustomerSoap toSoapModel(ProGateOrgCustomer model) {
		ProGateOrgCustomerSoap soapModel = new ProGateOrgCustomerSoap();

		soapModel.setProGateOrgCustomerId(model.getProGateOrgCustomerId());
		soapModel.setCustomerType(model.getCustomerType());
		soapModel.setCustomerName(model.getCustomerName());
		soapModel.setOrgId(model.getOrgId());
		soapModel.setHasOrgMap(model.getHasOrgMap());
		soapModel.setUrlOrgMap(model.getUrlOrgMap());
		soapModel.setLogo(model.getLogo());
		soapModel.setWebsite(model.getWebsite());
		soapModel.setDescription(model.getDescription());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static ProGateOrgCustomerSoap[] toSoapModels(
		ProGateOrgCustomer[] models) {
		ProGateOrgCustomerSoap[] soapModels = new ProGateOrgCustomerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProGateOrgCustomerSoap[][] toSoapModels(
		ProGateOrgCustomer[][] models) {
		ProGateOrgCustomerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProGateOrgCustomerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProGateOrgCustomerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProGateOrgCustomerSoap[] toSoapModels(
		List<ProGateOrgCustomer> models) {
		List<ProGateOrgCustomerSoap> soapModels = new ArrayList<ProGateOrgCustomerSoap>(models.size());

		for (ProGateOrgCustomer model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProGateOrgCustomerSoap[soapModels.size()]);
	}

	public ProGateOrgCustomerSoap() {
	}

	public Integer getPrimaryKey() {
		return _ProGateOrgCustomerId;
	}

	public void setPrimaryKey(Integer pk) {
		setProGateOrgCustomerId(pk);
	}

	public Integer getProGateOrgCustomerId() {
		return _ProGateOrgCustomerId;
	}

	public void setProGateOrgCustomerId(Integer ProGateOrgCustomerId) {
		_ProGateOrgCustomerId = ProGateOrgCustomerId;
	}

	public int getCustomerType() {
		return _customerType;
	}

	public void setCustomerType(int customerType) {
		_customerType = customerType;
	}

	public String getCustomerName() {
		return _customerName;
	}

	public void setCustomerName(String customerName) {
		_customerName = customerName;
	}

	public int getOrgId() {
		return _orgId;
	}

	public void setOrgId(int orgId) {
		_orgId = orgId;
	}

	public boolean getHasOrgMap() {
		return _hasOrgMap;
	}

	public boolean isHasOrgMap() {
		return _hasOrgMap;
	}

	public void setHasOrgMap(boolean hasOrgMap) {
		_hasOrgMap = hasOrgMap;
	}

	public String getUrlOrgMap() {
		return _urlOrgMap;
	}

	public void setUrlOrgMap(String urlOrgMap) {
		_urlOrgMap = urlOrgMap;
	}

	public String getLogo() {
		return _logo;
	}

	public void setLogo(String logo) {
		_logo = logo;
	}

	public String getWebsite() {
		return _website;
	}

	public void setWebsite(String website) {
		_website = website;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private Integer _ProGateOrgCustomerId;
	private int _customerType;
	private String _customerName;
	private int _orgId;
	private boolean _hasOrgMap;
	private String _urlOrgMap;
	private String _logo;
	private String _website;
	private String _description;
	private Date _createdDate;
	private Date _modifiedDate;
}