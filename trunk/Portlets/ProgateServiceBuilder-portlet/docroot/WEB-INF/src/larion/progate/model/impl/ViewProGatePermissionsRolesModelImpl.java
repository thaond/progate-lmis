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

import larion.progate.model.ViewProGatePermissionsRoles;
import larion.progate.model.ViewProGatePermissionsRolesSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="ViewProGatePermissionsRolesModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewProGatePermissionsRolesModelImpl extends BaseModelImpl<ViewProGatePermissionsRoles> {
	public static final String TABLE_NAME = "v_progate_permissions_roles";
	public static final Object[][] TABLE_COLUMNS = {
			{ "progate_permissions_id", new Integer(Types.VARCHAR) },
			

			{ "app_id", new Integer(Types.INTEGER) },
			

			{ "category", new Integer(Types.INTEGER) },
			

			{ "role_id", new Integer(Types.INTEGER) },
			

			{ "per_id", new Integer(Types.VARCHAR) },
			

			{ "description", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table v_progate_permissions_roles (progate_permissions_id VARCHAR(75) not null primary key,app_id INTEGER,category INTEGER,role_id INTEGER,per_id VARCHAR(75) null,description VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table v_progate_permissions_roles";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.model.ViewProGatePermissionsRoles"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.model.ViewProGatePermissionsRoles"),
			false);

	public static ViewProGatePermissionsRoles toModel(
		ViewProGatePermissionsRolesSoap soapModel) {
		ViewProGatePermissionsRoles model = new ViewProGatePermissionsRolesImpl();

		model.setProGatePermissionsRolesId(soapModel.getProGatePermissionsRolesId());
		model.setApplicationId(soapModel.getApplicationId());
		model.setCategory(soapModel.getCategory());
		model.setRoleId(soapModel.getRoleId());
		model.setPerId(soapModel.getPerId());
		model.setDescription(soapModel.getDescription());

		return model;
	}

	public static List<ViewProGatePermissionsRoles> toModels(
		ViewProGatePermissionsRolesSoap[] soapModels) {
		List<ViewProGatePermissionsRoles> models = new ArrayList<ViewProGatePermissionsRoles>(soapModels.length);

		for (ViewProGatePermissionsRolesSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.model.ViewProGatePermissionsRoles"));

	public ViewProGatePermissionsRolesModelImpl() {
	}

	public String getPrimaryKey() {
		return _ProGatePermissionsRolesId;
	}

	public void setPrimaryKey(String pk) {
		setProGatePermissionsRolesId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _ProGatePermissionsRolesId;
	}

	public String getProGatePermissionsRolesId() {
		return GetterUtil.getString(_ProGatePermissionsRolesId);
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
		return GetterUtil.getString(_perId);
	}

	public void setPerId(String perId) {
		_perId = perId;
	}

	public String getDescription() {
		return GetterUtil.getString(_description);
	}

	public void setDescription(String description) {
		_description = description;
	}

	public ViewProGatePermissionsRoles toEscapedModel() {
		if (isEscapedModel()) {
			return (ViewProGatePermissionsRoles)this;
		}
		else {
			ViewProGatePermissionsRoles model = new ViewProGatePermissionsRolesImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setProGatePermissionsRolesId(HtmlUtil.escape(
					getProGatePermissionsRolesId()));
			model.setApplicationId(getApplicationId());
			model.setCategory(getCategory());
			model.setRoleId(getRoleId());
			model.setPerId(HtmlUtil.escape(getPerId()));
			model.setDescription(HtmlUtil.escape(getDescription()));

			model = (ViewProGatePermissionsRoles)Proxy.newProxyInstance(ViewProGatePermissionsRoles.class.getClassLoader(),
					new Class[] { ViewProGatePermissionsRoles.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ViewProGatePermissionsRolesImpl clone = new ViewProGatePermissionsRolesImpl();

		clone.setProGatePermissionsRolesId(getProGatePermissionsRolesId());
		clone.setApplicationId(getApplicationId());
		clone.setCategory(getCategory());
		clone.setRoleId(getRoleId());
		clone.setPerId(getPerId());
		clone.setDescription(getDescription());

		return clone;
	}

	public int compareTo(
		ViewProGatePermissionsRoles viewProGatePermissionsRoles) {
		String pk = viewProGatePermissionsRoles.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ViewProGatePermissionsRoles viewProGatePermissionsRoles = null;

		try {
			viewProGatePermissionsRoles = (ViewProGatePermissionsRoles)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String pk = viewProGatePermissionsRoles.getPrimaryKey();

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

		sb.append("{ProGatePermissionsRolesId=");
		sb.append(getProGatePermissionsRolesId());
		sb.append(", applicationId=");
		sb.append(getApplicationId());
		sb.append(", category=");
		sb.append(getCategory());
		sb.append(", roleId=");
		sb.append(getRoleId());
		sb.append(", perId=");
		sb.append(getPerId());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.ViewProGatePermissionsRoles");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ProGatePermissionsRolesId</column-name><column-value><![CDATA[");
		sb.append(getProGatePermissionsRolesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicationId</column-name><column-value><![CDATA[");
		sb.append(getApplicationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>category</column-name><column-value><![CDATA[");
		sb.append(getCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>roleId</column-name><column-value><![CDATA[");
		sb.append(getRoleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>perId</column-name><column-value><![CDATA[");
		sb.append(getPerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _ProGatePermissionsRolesId;
	private int _applicationId;
	private int _category;
	private int _roleId;
	private String _perId;
	private String _description;
}