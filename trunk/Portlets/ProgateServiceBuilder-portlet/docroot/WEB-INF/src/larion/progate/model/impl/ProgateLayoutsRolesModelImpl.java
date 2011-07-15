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
import com.liferay.portal.model.impl.BaseModelImpl;

import larion.progate.model.ProgateLayoutsRoles;
import larion.progate.model.ProgateLayoutsRolesSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="ProgateLayoutsRolesModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgateLayoutsRolesModelImpl extends BaseModelImpl<ProgateLayoutsRoles> {
	public static final String TABLE_NAME = "progate_layouts_roles";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "layout_id", new Integer(Types.INTEGER) },
			

			{ "min_role_priority", new Integer(Types.INTEGER) }
		};
	public static final String TABLE_SQL_CREATE = "create table progate_layouts_roles (id INTEGER not null primary key,layout_id INTEGER,min_role_priority INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table progate_layouts_roles";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.model.ProgateLayoutsRoles"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.model.ProgateLayoutsRoles"),
			false);

	public static ProgateLayoutsRoles toModel(ProgateLayoutsRolesSoap soapModel) {
		ProgateLayoutsRoles model = new ProgateLayoutsRolesImpl();

		model.setProgateLayoutsRolesId(soapModel.getProgateLayoutsRolesId());
		model.setLayoutId(soapModel.getLayoutId());
		model.setMinRolePriority(soapModel.getMinRolePriority());

		return model;
	}

	public static List<ProgateLayoutsRoles> toModels(
		ProgateLayoutsRolesSoap[] soapModels) {
		List<ProgateLayoutsRoles> models = new ArrayList<ProgateLayoutsRoles>(soapModels.length);

		for (ProgateLayoutsRolesSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.model.ProgateLayoutsRoles"));

	public ProgateLayoutsRolesModelImpl() {
	}

	public int getPrimaryKey() {
		return _ProgateLayoutsRolesId;
	}

	public void setPrimaryKey(int pk) {
		setProgateLayoutsRolesId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_ProgateLayoutsRolesId);
	}

	public int getProgateLayoutsRolesId() {
		return _ProgateLayoutsRolesId;
	}

	public void setProgateLayoutsRolesId(int ProgateLayoutsRolesId) {
		_ProgateLayoutsRolesId = ProgateLayoutsRolesId;
	}

	public int getLayoutId() {
		return _layoutId;
	}

	public void setLayoutId(int layoutId) {
		_layoutId = layoutId;
	}

	public int getMinRolePriority() {
		return _minRolePriority;
	}

	public void setMinRolePriority(int minRolePriority) {
		_minRolePriority = minRolePriority;
	}

	public ProgateLayoutsRoles toEscapedModel() {
		if (isEscapedModel()) {
			return (ProgateLayoutsRoles)this;
		}
		else {
			ProgateLayoutsRoles model = new ProgateLayoutsRolesImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setProgateLayoutsRolesId(getProgateLayoutsRolesId());
			model.setLayoutId(getLayoutId());
			model.setMinRolePriority(getMinRolePriority());

			model = (ProgateLayoutsRoles)Proxy.newProxyInstance(ProgateLayoutsRoles.class.getClassLoader(),
					new Class[] { ProgateLayoutsRoles.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ProgateLayoutsRolesImpl clone = new ProgateLayoutsRolesImpl();

		clone.setProgateLayoutsRolesId(getProgateLayoutsRolesId());
		clone.setLayoutId(getLayoutId());
		clone.setMinRolePriority(getMinRolePriority());

		return clone;
	}

	public int compareTo(ProgateLayoutsRoles progateLayoutsRoles) {
		int pk = progateLayoutsRoles.getPrimaryKey();

		if (getPrimaryKey() < pk) {
			return -1;
		}
		else if (getPrimaryKey() > pk) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ProgateLayoutsRoles progateLayoutsRoles = null;

		try {
			progateLayoutsRoles = (ProgateLayoutsRoles)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int pk = progateLayoutsRoles.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return getPrimaryKey();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("{ProgateLayoutsRolesId=");
		sb.append(getProgateLayoutsRolesId());
		sb.append(", layoutId=");
		sb.append(getLayoutId());
		sb.append(", minRolePriority=");
		sb.append(getMinRolePriority());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.ProgateLayoutsRoles");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ProgateLayoutsRolesId</column-name><column-value><![CDATA[");
		sb.append(getProgateLayoutsRolesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>layoutId</column-name><column-value><![CDATA[");
		sb.append(getLayoutId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>minRolePriority</column-name><column-value><![CDATA[");
		sb.append(getMinRolePriority());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _ProgateLayoutsRolesId;
	private int _layoutId;
	private int _minRolePriority;
}