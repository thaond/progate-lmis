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
 * <a href="ProGatePermissionsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGatePermissionsSoap implements Serializable {
	public static ProGatePermissionsSoap toSoapModel(ProGatePermissions model) {
		ProGatePermissionsSoap soapModel = new ProGatePermissionsSoap();

		soapModel.setProGatePermissionsId(model.getProGatePermissionsId());
		soapModel.setApplicationId(model.getApplicationId());
		soapModel.setCategory(model.getCategory());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static ProGatePermissionsSoap[] toSoapModels(
		ProGatePermissions[] models) {
		ProGatePermissionsSoap[] soapModels = new ProGatePermissionsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProGatePermissionsSoap[][] toSoapModels(
		ProGatePermissions[][] models) {
		ProGatePermissionsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProGatePermissionsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProGatePermissionsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProGatePermissionsSoap[] toSoapModels(
		List<ProGatePermissions> models) {
		List<ProGatePermissionsSoap> soapModels = new ArrayList<ProGatePermissionsSoap>(models.size());

		for (ProGatePermissions model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProGatePermissionsSoap[soapModels.size()]);
	}

	public ProGatePermissionsSoap() {
	}

	public String getPrimaryKey() {
		return _ProGatePermissionsId;
	}

	public void setPrimaryKey(String pk) {
		setProGatePermissionsId(pk);
	}

	public String getProGatePermissionsId() {
		return _ProGatePermissionsId;
	}

	public void setProGatePermissionsId(String ProGatePermissionsId) {
		_ProGatePermissionsId = ProGatePermissionsId;
	}

	public int getApplicationId() {
		return _applicationId;
	}

	public void setApplicationId(int applicationId) {
		_applicationId = applicationId;
	}

	public int getCategory() {
		return _category;
	}

	public void setCategory(int category) {
		_category = category;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private String _ProGatePermissionsId;
	private int _applicationId;
	private int _category;
	private String _description;
}