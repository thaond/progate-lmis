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

import larion.progate.model.ProGateMenuView;
import larion.progate.model.ProGateMenuViewSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="ProGateMenuViewModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateMenuViewModelImpl extends BaseModelImpl<ProGateMenuView> {
	public static final String TABLE_NAME = "vw_progate_menu";
	public static final Object[][] TABLE_COLUMNS = {
			{ "name", new Integer(Types.VARCHAR) },
			

			{ "array_to_string", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table vw_progate_menu (name VARCHAR(75) not null primary key,array_to_string VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table vw_progate_menu";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.model.ProGateMenuView"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.model.ProGateMenuView"),
			false);

	public static ProGateMenuView toModel(ProGateMenuViewSoap soapModel) {
		ProGateMenuView model = new ProGateMenuViewImpl();

		model.setName(soapModel.getName());
		model.setMenus(soapModel.getMenus());

		return model;
	}

	public static List<ProGateMenuView> toModels(
		ProGateMenuViewSoap[] soapModels) {
		List<ProGateMenuView> models = new ArrayList<ProGateMenuView>(soapModels.length);

		for (ProGateMenuViewSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.model.ProGateMenuView"));

	public ProGateMenuViewModelImpl() {
	}

	public String getPrimaryKey() {
		return _name;
	}

	public void setPrimaryKey(String pk) {
		setName(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _name;
	}

	public String getName() {
		return GetterUtil.getString(_name);
	}

	public void setName(String name) {
		_name = name;
	}

	public String getMenus() {
		return GetterUtil.getString(_menus);
	}

	public void setMenus(String menus) {
		_menus = menus;
	}

	public ProGateMenuView toEscapedModel() {
		if (isEscapedModel()) {
			return (ProGateMenuView)this;
		}
		else {
			ProGateMenuView model = new ProGateMenuViewImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setName(HtmlUtil.escape(getName()));
			model.setMenus(HtmlUtil.escape(getMenus()));

			model = (ProGateMenuView)Proxy.newProxyInstance(ProGateMenuView.class.getClassLoader(),
					new Class[] { ProGateMenuView.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ProGateMenuViewImpl clone = new ProGateMenuViewImpl();

		clone.setName(getName());
		clone.setMenus(getMenus());

		return clone;
	}

	public int compareTo(ProGateMenuView proGateMenuView) {
		String pk = proGateMenuView.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ProGateMenuView proGateMenuView = null;

		try {
			proGateMenuView = (ProGateMenuView)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String pk = proGateMenuView.getPrimaryKey();

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

		sb.append("{name=");
		sb.append(getName());
		sb.append(", menus=");
		sb.append(getMenus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.ProGateMenuView");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>menus</column-name><column-value><![CDATA[");
		sb.append(getMenus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _name;
	private String _menus;
}