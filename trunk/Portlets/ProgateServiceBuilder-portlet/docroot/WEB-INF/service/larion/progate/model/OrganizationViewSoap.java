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
import java.util.List;

/**
 * <a href="OrganizationViewSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrganizationViewSoap implements Serializable {
	public static OrganizationViewSoap toSoapModel(OrganizationView model) {
		OrganizationViewSoap soapModel = new OrganizationViewSoap();

		soapModel.setOrgId(model.getOrgId());
		soapModel.setOrgName(model.getOrgName());
		soapModel.setCountProduct(model.getCountProduct());
		soapModel.setOrgNameLower(model.getOrgNameLower());

		return soapModel;
	}

	public static OrganizationViewSoap[] toSoapModels(OrganizationView[] models) {
		OrganizationViewSoap[] soapModels = new OrganizationViewSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrganizationViewSoap[][] toSoapModels(
		OrganizationView[][] models) {
		OrganizationViewSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OrganizationViewSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrganizationViewSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrganizationViewSoap[] toSoapModels(
		List<OrganizationView> models) {
		List<OrganizationViewSoap> soapModels = new ArrayList<OrganizationViewSoap>(models.size());

		for (OrganizationView model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OrganizationViewSoap[soapModels.size()]);
	}

	public OrganizationViewSoap() {
	}

	public int getPrimaryKey() {
		return _orgId;
	}

	public void setPrimaryKey(int pk) {
		setOrgId(pk);
	}

	public int getOrgId() {
		return _orgId;
	}

	public void setOrgId(int orgId) {
		_orgId = orgId;
	}

	public String getOrgName() {
		return _orgName;
	}

	public void setOrgName(String orgName) {
		_orgName = orgName;
	}

	public int getCountProduct() {
		return _countProduct;
	}

	public void setCountProduct(int countProduct) {
		_countProduct = countProduct;
	}

	public String getOrgNameLower() {
		return _orgNameLower;
	}

	public void setOrgNameLower(String orgNameLower) {
		_orgNameLower = orgNameLower;
	}

	private int _orgId;
	private String _orgName;
	private int _countProduct;
	private String _orgNameLower;
}