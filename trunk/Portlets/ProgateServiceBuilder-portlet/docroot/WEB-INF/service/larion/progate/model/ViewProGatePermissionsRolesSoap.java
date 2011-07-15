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
 * <a href="ViewProGatePermissionsRolesSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewProGatePermissionsRolesSoap implements Serializable {
	public static ViewProGatePermissionsRolesSoap toSoapModel(
		ViewProGatePermissionsRoles model) {
		ViewProGatePermissionsRolesSoap soapModel = new ViewProGatePermissionsRolesSoap();

		soapModel.setProGatePermissionsRolesId(model.getProGatePermissionsRolesId());
		soapModel.setApplicationId(model.getApplicationId());
		soapModel.setCategory(model.getCategory());
		soapModel.setRoleId(model.getRoleId());
		soapModel.setPerId(model.getPerId());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static ViewProGatePermissionsRolesSoap[] toSoapModels(
		ViewProGatePermissionsRoles[] models) {
		ViewProGatePermissionsRolesSoap[] soapModels = new ViewProGatePermissionsRolesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ViewProGatePermissionsRolesSoap[][] toSoapModels(
		ViewProGatePermissionsRoles[][] models) {
		ViewProGatePermissionsRolesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ViewProGatePermissionsRolesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ViewProGatePermissionsRolesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ViewProGatePermissionsRolesSoap[] toSoapModels(
		List<ViewProGatePermissionsRoles> models) {
		List<ViewProGatePermissionsRolesSoap> soapModels = new ArrayList<ViewProGatePermissionsRolesSoap>(models.size());

		for (ViewProGatePermissionsRoles model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ViewProGatePermissionsRolesSoap[soapModels.size()]);
	}

	public ViewProGatePermissionsRolesSoap() {
	}

	public String getPrimaryKey() {
		return _ProGatePermissionsRolesId;
	}

	public void setPrimaryKey(String pk) {
		setProGatePermissionsRolesId(pk);
	}

	public String getProGatePermissionsRolesId() {
		return _ProGatePermissionsRolesId;
	}

	public void setProGatePermissionsRolesId(String ProGatePermissionsRolesId) {
		_ProGatePermissionsRolesId = ProGatePermissionsRolesId;
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

	public int getRoleId() {
		return _roleId;
	}

	public void setRoleId(int roleId) {
		_roleId = roleId;
	}

	public String getPerId() {
		return _perId;
	}

	public void setPerId(String perId) {
		_perId = perId;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private String _ProGatePermissionsRolesId;
	private int _applicationId;
	private int _category;
	private int _roleId;
	private String _perId;
	private String _description;
}