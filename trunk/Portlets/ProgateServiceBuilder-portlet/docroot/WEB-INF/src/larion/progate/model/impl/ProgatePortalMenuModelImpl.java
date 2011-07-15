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

package larion.progate.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import larion.progate.model.ProgatePortalMenu;
import larion.progate.model.ProgatePortalMenuSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="ProgatePortalMenuModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgatePortalMenuModelImpl extends BaseModelImpl<ProgatePortalMenu> {
	public static final String TABLE_NAME = "progate_portal_menu";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "menu_name", new Integer(Types.VARCHAR) },
			

			{ "layout_id", new Integer(Types.INTEGER) },
			

			{ "role_id", new Integer(Types.INTEGER) },
			

			{ "org_id", new Integer(Types.INTEGER) },
			

			{ "menu_order", new Integer(Types.INTEGER) }
		};
	public static final String TABLE_SQL_CREATE = "create table progate_portal_menu (id INTEGER not null primary key,menu_name VARCHAR(75) null,layout_id INTEGER,role_id INTEGER,org_id INTEGER,menu_order INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table progate_portal_menu";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.model.ProgatePortalMenu"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.model.ProgatePortalMenu"),
			false);

	public static ProgatePortalMenu toModel(ProgatePortalMenuSoap soapModel) {
		ProgatePortalMenu model = new ProgatePortalMenuImpl();

		model.setPortalMenuId(soapModel.getPortalMenuId());
		model.setName(soapModel.getName());
		model.setLayoutId(soapModel.getLayoutId());
		model.setRoleId(soapModel.getRoleId());
		model.setOrgId(soapModel.getOrgId());
		model.setMenuOrder(soapModel.getMenuOrder());

		return model;
	}

	public static List<ProgatePortalMenu> toModels(
		ProgatePortalMenuSoap[] soapModels) {
		List<ProgatePortalMenu> models = new ArrayList<ProgatePortalMenu>(soapModels.length);

		for (ProgatePortalMenuSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.model.ProgatePortalMenu"));

	public ProgatePortalMenuModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _portalMenuId;
	}

	public void setPrimaryKey(Integer pk) {
		setPortalMenuId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _portalMenuId;
	}

	public Integer getPortalMenuId() {
		return _portalMenuId;
	}

	public void setPortalMenuId(Integer portalMenuId) {
		_portalMenuId = portalMenuId;
	}

	public String getName() {
		return GetterUtil.getString(_name);
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

	public ProgatePortalMenu toEscapedModel() {
		if (isEscapedModel()) {
			return (ProgatePortalMenu)this;
		}
		else {
			ProgatePortalMenu model = new ProgatePortalMenuImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setPortalMenuId(getPortalMenuId());
			model.setName(HtmlUtil.escape(getName()));
			model.setLayoutId(getLayoutId());
			model.setRoleId(getRoleId());
			model.setOrgId(getOrgId());
			model.setMenuOrder(getMenuOrder());

			model = (ProgatePortalMenu)Proxy.newProxyInstance(ProgatePortalMenu.class.getClassLoader(),
					new Class[] { ProgatePortalMenu.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ProgatePortalMenuImpl clone = new ProgatePortalMenuImpl();

		clone.setPortalMenuId(getPortalMenuId());
		clone.setName(getName());
		clone.setLayoutId(getLayoutId());
		clone.setRoleId(getRoleId());
		clone.setOrgId(getOrgId());
		clone.setMenuOrder(getMenuOrder());

		return clone;
	}

	public int compareTo(ProgatePortalMenu progatePortalMenu) {
		Integer pk = progatePortalMenu.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ProgatePortalMenu progatePortalMenu = null;

		try {
			progatePortalMenu = (ProgatePortalMenu)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = progatePortalMenu.getPrimaryKey();

		if (getPrimaryKey().equals(pk)) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("{portalMenuId=");
		sb.append(getPortalMenuId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", layoutId=");
		sb.append(getLayoutId());
		sb.append(", roleId=");
		sb.append(getRoleId());
		sb.append(", orgId=");
		sb.append(getOrgId());
		sb.append(", menuOrder=");
		sb.append(getMenuOrder());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.ProgatePortalMenu");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>portalMenuId</column-name><column-value><![CDATA[");
		sb.append(getPortalMenuId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>layoutId</column-name><column-value><![CDATA[");
		sb.append(getLayoutId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>roleId</column-name><column-value><![CDATA[");
		sb.append(getRoleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgId</column-name><column-value><![CDATA[");
		sb.append(getOrgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>menuOrder</column-name><column-value><![CDATA[");
		sb.append(getMenuOrder());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _portalMenuId;
	private String _name;
	private int _layoutId;
	private int _roleId;
	private int _orgId;
	private int _menuOrder;
}