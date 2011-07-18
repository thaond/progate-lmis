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

import larion.progate.model.ViewOrgUsersPermissions;
import larion.progate.model.ViewOrgUsersPermissionsSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="ViewOrgUsersPermissionsModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewOrgUsersPermissionsModelImpl extends BaseModelImpl<ViewOrgUsersPermissions> {
	public static final String TABLE_NAME = "vw_organizations_users_permissions";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.VARCHAR) },
			

			{ "org_id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "user_id", new Integer(Types.INTEGER) },
			

			{ "role_id", new Integer(Types.INTEGER) },
			

			{ "per_id", new Integer(Types.VARCHAR) },
			

			{ "app_id", new Integer(Types.INTEGER) },
			

			{ "category", new Integer(Types.INTEGER) },
			

			{ "description", new Integer(Types.VARCHAR) },
			

			{ "value", new Integer(Types.INTEGER) },
			

			{ "priority", new Integer(Types.INTEGER) }
		};
	public static final String TABLE_SQL_CREATE = "create table vw_organizations_users_permissions (id VARCHAR(75) not null primary key,org_id INTEGER,root_id INTEGER,user_id INTEGER,role_id INTEGER,per_id VARCHAR(75) null,app_id INTEGER,category INTEGER,description VARCHAR(75) null,value INTEGER,priority INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table vw_organizations_users_permissions";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.model.ViewOrgUsersPermissions"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.model.ViewOrgUsersPermissions"),
			false);

	public static ViewOrgUsersPermissions toModel(
		ViewOrgUsersPermissionsSoap soapModel) {
		ViewOrgUsersPermissions model = new ViewOrgUsersPermissionsImpl();

		model.setId(soapModel.getId());
		model.setOrgId(soapModel.getOrgId());
		model.setRootId(soapModel.getRootId());
		model.setUserId(soapModel.getUserId());
		model.setRoleId(soapModel.getRoleId());
		model.setPermissionId(soapModel.getPermissionId());
		model.setApplicationId(soapModel.getApplicationId());
		model.setCategory(soapModel.getCategory());
		model.setDescription(soapModel.getDescription());
		model.setValue(soapModel.getValue());
		model.setPriority(soapModel.getPriority());

		return model;
	}

	public static List<ViewOrgUsersPermissions> toModels(
		ViewOrgUsersPermissionsSoap[] soapModels) {
		List<ViewOrgUsersPermissions> models = new ArrayList<ViewOrgUsersPermissions>(soapModels.length);

		for (ViewOrgUsersPermissionsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.model.ViewOrgUsersPermissions"));

	public ViewOrgUsersPermissionsModelImpl() {
	}

	public String getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(String pk) {
		setId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	public String getId() {
		return GetterUtil.getString(_id);
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
		return GetterUtil.getString(_permissionId);
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
		return GetterUtil.getString(_description);
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

	public ViewOrgUsersPermissions toEscapedModel() {
		if (isEscapedModel()) {
			return (ViewOrgUsersPermissions)this;
		}
		else {
			ViewOrgUsersPermissions model = new ViewOrgUsersPermissionsImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setId(HtmlUtil.escape(getId()));
			model.setOrgId(getOrgId());
			model.setRootId(getRootId());
			model.setUserId(getUserId());
			model.setRoleId(getRoleId());
			model.setPermissionId(HtmlUtil.escape(getPermissionId()));
			model.setApplicationId(getApplicationId());
			model.setCategory(getCategory());
			model.setDescription(HtmlUtil.escape(getDescription()));
			model.setValue(getValue());
			model.setPriority(getPriority());

			model = (ViewOrgUsersPermissions)Proxy.newProxyInstance(ViewOrgUsersPermissions.class.getClassLoader(),
					new Class[] { ViewOrgUsersPermissions.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ViewOrgUsersPermissionsImpl clone = new ViewOrgUsersPermissionsImpl();

		clone.setId(getId());
		clone.setOrgId(getOrgId());
		clone.setRootId(getRootId());
		clone.setUserId(getUserId());
		clone.setRoleId(getRoleId());
		clone.setPermissionId(getPermissionId());
		clone.setApplicationId(getApplicationId());
		clone.setCategory(getCategory());
		clone.setDescription(getDescription());
		clone.setValue(getValue());
		clone.setPriority(getPriority());

		return clone;
	}

	public int compareTo(ViewOrgUsersPermissions viewOrgUsersPermissions) {
		String pk = viewOrgUsersPermissions.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ViewOrgUsersPermissions viewOrgUsersPermissions = null;

		try {
			viewOrgUsersPermissions = (ViewOrgUsersPermissions)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String pk = viewOrgUsersPermissions.getPrimaryKey();

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

		sb.append("{id=");
		sb.append(getId());
		sb.append(", orgId=");
		sb.append(getOrgId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", roleId=");
		sb.append(getRoleId());
		sb.append(", permissionId=");
		sb.append(getPermissionId());
		sb.append(", applicationId=");
		sb.append(getApplicationId());
		sb.append(", category=");
		sb.append(getCategory());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", value=");
		sb.append(getValue());
		sb.append(", priority=");
		sb.append(getPriority());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.ViewOrgUsersPermissions");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgId</column-name><column-value><![CDATA[");
		sb.append(getOrgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>roleId</column-name><column-value><![CDATA[");
		sb.append(getRoleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>permissionId</column-name><column-value><![CDATA[");
		sb.append(getPermissionId());
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
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>value</column-name><column-value><![CDATA[");
		sb.append(getValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>priority</column-name><column-value><![CDATA[");
		sb.append(getPriority());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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