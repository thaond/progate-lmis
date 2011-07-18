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
 * <a href="ProgatePortalMenuSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgatePortalMenuSoap implements Serializable {
	public static ProgatePortalMenuSoap toSoapModel(ProgatePortalMenu model) {
		ProgatePortalMenuSoap soapModel = new ProgatePortalMenuSoap();

		soapModel.setPortalMenuId(model.getPortalMenuId());
		soapModel.setName(model.getName());
		soapModel.setLayoutId(model.getLayoutId());
		soapModel.setRoleId(model.getRoleId());
		soapModel.setOrgId(model.getOrgId());
		soapModel.setMenuOrder(model.getMenuOrder());

		return soapModel;
	}

	public static ProgatePortalMenuSoap[] toSoapModels(
		ProgatePortalMenu[] models) {
		ProgatePortalMenuSoap[] soapModels = new ProgatePortalMenuSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProgatePortalMenuSoap[][] toSoapModels(
		ProgatePortalMenu[][] models) {
		ProgatePortalMenuSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProgatePortalMenuSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProgatePortalMenuSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProgatePortalMenuSoap[] toSoapModels(
		List<ProgatePortalMenu> models) {
		List<ProgatePortalMenuSoap> soapModels = new ArrayList<ProgatePortalMenuSoap>(models.size());

		for (ProgatePortalMenu model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProgatePortalMenuSoap[soapModels.size()]);
	}

	public ProgatePortalMenuSoap() {
	}

	public Integer getPrimaryKey() {
		return _portalMenuId;
	}

	public void setPrimaryKey(Integer pk) {
		setPortalMenuId(pk);
	}

	public Integer getPortalMenuId() {
		return _portalMenuId;
	}

	public void setPortalMenuId(Integer portalMenuId) {
		_portalMenuId = portalMenuId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getLayoutId() {
		return _layoutId;
	}

	public void setLayoutId(int layoutId) {
		_layoutId = layoutId;
	}

	public int getRoleId() {
		return _roleId;
	}

	public void setRoleId(int roleId) {
		_roleId = roleId;
	}

	public int getOrgId() {
		return _orgId;
	}

	public void setOrgId(int orgId) {
		_orgId = orgId;
	}

	public int getMenuOrder() {
		return _menuOrder;
	}

	public void setMenuOrder(int menuOrder) {
		_menuOrder = menuOrder;
	}

	private Integer _portalMenuId;
	private String _name;
	private int _layoutId;
	private int _roleId;
	private int _orgId;
	private int _menuOrder;
}