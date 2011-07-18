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
 * <a href="ProGateOrgsUsersPermissionsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateOrgsUsersPermissionsSoap implements Serializable {
	public static ProGateOrgsUsersPermissionsSoap toSoapModel(
		ProGateOrgsUsersPermissions model) {
		ProGateOrgsUsersPermissionsSoap soapModel = new ProGateOrgsUsersPermissionsSoap();

		soapModel.setProGateOrgsUsersPermissionsId(model.getProGateOrgsUsersPermissionsId());
		soapModel.setOrgId(model.getOrgId());
		soapModel.setUserId(model.getUserId());
		soapModel.setPermissionId(model.getPermissionId());
		soapModel.setValue(model.getValue());
		soapModel.setIsGrant(model.getIsGrant());
		soapModel.setPmId(model.getPmId());

		return soapModel;
	}

	public static ProGateOrgsUsersPermissionsSoap[] toSoapModels(
		ProGateOrgsUsersPermissions[] models) {
		ProGateOrgsUsersPermissionsSoap[] soapModels = new ProGateOrgsUsersPermissionsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProGateOrgsUsersPermissionsSoap[][] toSoapModels(
		ProGateOrgsUsersPermissions[][] models) {
		ProGateOrgsUsersPermissionsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProGateOrgsUsersPermissionsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProGateOrgsUsersPermissionsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProGateOrgsUsersPermissionsSoap[] toSoapModels(
		List<ProGateOrgsUsersPermissions> models) {
		List<ProGateOrgsUsersPermissionsSoap> soapModels = new ArrayList<ProGateOrgsUsersPermissionsSoap>(models.size());

		for (ProGateOrgsUsersPermissions model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProGateOrgsUsersPermissionsSoap[soapModels.size()]);
	}

	public ProGateOrgsUsersPermissionsSoap() {
	}

	public Integer getPrimaryKey() {
		return _ProGateOrgsUsersPermissionsId;
	}

	public void setPrimaryKey(Integer pk) {
		setProGateOrgsUsersPermissionsId(pk);
	}

	public Integer getProGateOrgsUsersPermissionsId() {
		return _ProGateOrgsUsersPermissionsId;
	}

	public void setProGateOrgsUsersPermissionsId(
		Integer ProGateOrgsUsersPermissionsId) {
		_ProGateOrgsUsersPermissionsId = ProGateOrgsUsersPermissionsId;
	}

	public int getOrgId() {
		return _orgId;
	}

	public void setOrgId(int orgId) {
		_orgId = orgId;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public String getPermissionId() {
		return _permissionId;
	}

	public void setPermissionId(String permissionId) {
		_permissionId = permissionId;
	}

	public int getValue() {
		return _value;
	}

	public void setValue(int value) {
		_value = value;
	}

	public boolean getIsGrant() {
		return _isGrant;
	}

	public boolean isIsGrant() {
		return _isGrant;
	}

	public void setIsGrant(boolean isGrant) {
		_isGrant = isGrant;
	}

	public int getPmId() {
		return _pmId;
	}

	public void setPmId(int pmId) {
		_pmId = pmId;
	}

	private Integer _ProGateOrgsUsersPermissionsId;
	private int _orgId;
	private int _userId;
	private String _permissionId;
	private int _value;
	private boolean _isGrant;
	private int _pmId;
}