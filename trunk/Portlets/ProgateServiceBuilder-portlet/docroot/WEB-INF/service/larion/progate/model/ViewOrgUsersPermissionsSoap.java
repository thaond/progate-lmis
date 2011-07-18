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
 * <a href="ViewOrgUsersPermissionsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewOrgUsersPermissionsSoap implements Serializable {
	public static ViewOrgUsersPermissionsSoap toSoapModel(
		ViewOrgUsersPermissions model) {
		ViewOrgUsersPermissionsSoap soapModel = new ViewOrgUsersPermissionsSoap();

		soapModel.setId(model.getId());
		soapModel.setOrgId(model.getOrgId());
		soapModel.setRootId(model.getRootId());
		soapModel.setUserId(model.getUserId());
		soapModel.setRoleId(model.getRoleId());
		soapModel.setPermissionId(model.getPermissionId());
		soapModel.setApplicationId(model.getApplicationId());
		soapModel.setCategory(model.getCategory());
		soapModel.setDescription(model.getDescription());
		soapModel.setValue(model.getValue());
		soapModel.setPriority(model.getPriority());

		return soapModel;
	}

	public static ViewOrgUsersPermissionsSoap[] toSoapModels(
		ViewOrgUsersPermissions[] models) {
		ViewOrgUsersPermissionsSoap[] soapModels = new ViewOrgUsersPermissionsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ViewOrgUsersPermissionsSoap[][] toSoapModels(
		ViewOrgUsersPermissions[][] models) {
		ViewOrgUsersPermissionsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ViewOrgUsersPermissionsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ViewOrgUsersPermissionsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ViewOrgUsersPermissionsSoap[] toSoapModels(
		List<ViewOrgUsersPermissions> models) {
		List<ViewOrgUsersPermissionsSoap> soapModels = new ArrayList<ViewOrgUsersPermissionsSoap>(models.size());

		for (ViewOrgUsersPermissions model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ViewOrgUsersPermissionsSoap[soapModels.size()]);
	}

	public ViewOrgUsersPermissionsSoap() {
	}

	public String getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(String pk) {
		setId(pk);
	}

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		_id = id;
	}

	public int getOrgId() {
		return _orgId;
	}

	public void setOrgId(int orgId) {
		_orgId = orgId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public int getRoleId() {
		return _roleId;
	}

	public void setRoleId(int roleId) {
		_roleId = roleId;
	}

	public String getPermissionId() {
		return _permissionId;
	}

	public void setPermissionId(String permissionId) {
		_permissionId = permissionId;
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

	public int getValue() {
		return _value;
	}

	public void setValue(int value) {
		_value = value;
	}

	public int getPriority() {
		return _priority;
	}

	public void setPriority(int priority) {
		_priority = priority;
	}

	private String _id;
	private int _orgId;
	private int _rootId;
	private int _userId;
	private int _roleId;
	private String _permissionId;
	private int _applicationId;
	private int _category;
	private String _description;
	private int _value;
	private int _priority;
}