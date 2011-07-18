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
 * <a href="ProGateOrgTypeSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateOrgTypeSoap implements Serializable {
	public static ProGateOrgTypeSoap toSoapModel(ProGateOrgType model) {
		ProGateOrgTypeSoap soapModel = new ProGateOrgTypeSoap();

		soapModel.setOrgTypeId(model.getOrgTypeId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static ProGateOrgTypeSoap[] toSoapModels(ProGateOrgType[] models) {
		ProGateOrgTypeSoap[] soapModels = new ProGateOrgTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProGateOrgTypeSoap[][] toSoapModels(ProGateOrgType[][] models) {
		ProGateOrgTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProGateOrgTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProGateOrgTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProGateOrgTypeSoap[] toSoapModels(List<ProGateOrgType> models) {
		List<ProGateOrgTypeSoap> soapModels = new ArrayList<ProGateOrgTypeSoap>(models.size());

		for (ProGateOrgType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProGateOrgTypeSoap[soapModels.size()]);
	}

	public ProGateOrgTypeSoap() {
	}

	public Integer getPrimaryKey() {
		return _orgTypeId;
	}

	public void setPrimaryKey(Integer pk) {
		setOrgTypeId(pk);
	}

	public Integer getOrgTypeId() {
		return _orgTypeId;
	}

	public void setOrgTypeId(Integer orgTypeId) {
		_orgTypeId = orgTypeId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public boolean getStatus() {
		return _status;
	}

	public boolean isStatus() {
		return _status;
	}

	public void setStatus(boolean status) {
		_status = status;
	}

	private Integer _orgTypeId;
	private String _name;
	private String _description;
	private boolean _status;
}