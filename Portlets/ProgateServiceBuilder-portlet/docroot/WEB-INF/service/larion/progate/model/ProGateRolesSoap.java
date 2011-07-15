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
 * <a href="ProGateRolesSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateRolesSoap implements Serializable {
	public static ProGateRolesSoap toSoapModel(ProGateRoles model) {
		ProGateRolesSoap soapModel = new ProGateRolesSoap();

		soapModel.setRoleId(model.getRoleId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setRoleType(model.getRoleType());
		soapModel.setPriority(model.getPriority());

		return soapModel;
	}

	public static ProGateRolesSoap[] toSoapModels(ProGateRoles[] models) {
		ProGateRolesSoap[] soapModels = new ProGateRolesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProGateRolesSoap[][] toSoapModels(ProGateRoles[][] models) {
		ProGateRolesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProGateRolesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProGateRolesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProGateRolesSoap[] toSoapModels(List<ProGateRoles> models) {
		List<ProGateRolesSoap> soapModels = new ArrayList<ProGateRolesSoap>(models.size());

		for (ProGateRoles model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProGateRolesSoap[soapModels.size()]);
	}

	public ProGateRolesSoap() {
	}

	public Integer getPrimaryKey() {
		return _roleId;
	}

	public void setPrimaryKey(Integer pk) {
		setRoleId(pk);
	}

	public Integer getRoleId() {
		return _roleId;
	}

	public void setRoleId(Integer roleId) {
		_roleId = roleId;
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

	public int getRoleType() {
		return _roleType;
	}

	public void setRoleType(int roleType) {
		_roleType = roleType;
	}

	public int getPriority() {
		return _priority;
	}

	public void setPriority(int priority) {
		_priority = priority;
	}

	private Integer _roleId;
	private String _name;
	private String _description;
	private int _roleType;
	private int _priority;
}