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

package larion.progate.lmis.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="LmisViewOrgUserRolesSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewOrgUserRolesSoap implements Serializable {
	public static LmisViewOrgUserRolesSoap toSoapModel(
		LmisViewOrgUserRoles model) {
		LmisViewOrgUserRolesSoap soapModel = new LmisViewOrgUserRolesSoap();

		soapModel.setLmisViewOrgUserRolesId(model.getLmisViewOrgUserRolesId());
		soapModel.setRootId(model.getRootId());
		soapModel.setOrgId(model.getOrgId());
		soapModel.setUserId(model.getUserId());
		soapModel.setRoleId(model.getRoleId());
		soapModel.setOrgName(model.getOrgName());

		return soapModel;
	}

	public static LmisViewOrgUserRolesSoap[] toSoapModels(
		LmisViewOrgUserRoles[] models) {
		LmisViewOrgUserRolesSoap[] soapModels = new LmisViewOrgUserRolesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisViewOrgUserRolesSoap[][] toSoapModels(
		LmisViewOrgUserRoles[][] models) {
		LmisViewOrgUserRolesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisViewOrgUserRolesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisViewOrgUserRolesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisViewOrgUserRolesSoap[] toSoapModels(
		List<LmisViewOrgUserRoles> models) {
		List<LmisViewOrgUserRolesSoap> soapModels = new ArrayList<LmisViewOrgUserRolesSoap>(models.size());

		for (LmisViewOrgUserRoles model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisViewOrgUserRolesSoap[soapModels.size()]);
	}

	public LmisViewOrgUserRolesSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisViewOrgUserRolesId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisViewOrgUserRolesId(pk);
	}

	public Integer getLmisViewOrgUserRolesId() {
		return _lmisViewOrgUserRolesId;
	}

	public void setLmisViewOrgUserRolesId(Integer lmisViewOrgUserRolesId) {
		_lmisViewOrgUserRolesId = lmisViewOrgUserRolesId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
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

	public int getRoleId() {
		return _roleId;
	}

	public void setRoleId(int roleId) {
		_roleId = roleId;
	}

	public String getOrgName() {
		return _orgName;
	}

	public void setOrgName(String orgName) {
		_orgName = orgName;
	}

	private Integer _lmisViewOrgUserRolesId;
	private int _rootId;
	private int _orgId;
	private int _userId;
	private int _roleId;
	private String _orgName;
}