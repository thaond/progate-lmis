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

import larion.progate.model.ProGateOrgsUsersPermissions;
import larion.progate.model.ProGateOrgsUsersPermissionsSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="ProGateOrgsUsersPermissionsModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateOrgsUsersPermissionsModelImpl extends BaseModelImpl<ProGateOrgsUsersPermissions> {
	public static final String TABLE_NAME = "progate_organizations_users_permissions";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "org_id", new Integer(Types.INTEGER) },
			

			{ "user_id", new Integer(Types.INTEGER) },
			

			{ "per_id", new Integer(Types.VARCHAR) },
			

			{ "value", new Integer(Types.INTEGER) },
			

			{ "is_grant", new Integer(Types.BOOLEAN) },
			

			{ "pm_id", new Integer(Types.INTEGER) }
		};
	public static final String TABLE_SQL_CREATE = "create table progate_organizations_users_permissions (id INTEGER not null primary key,org_id INTEGER,user_id INTEGER,per_id VARCHAR(75) null,value INTEGER,is_grant BOOLEAN,pm_id INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table progate_organizations_users_permissions";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.model.ProGateOrgsUsersPermissions"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.model.ProGateOrgsUsersPermissions"),
			false);

	public static ProGateOrgsUsersPermissions toModel(
		ProGateOrgsUsersPermissionsSoap soapModel) {
		ProGateOrgsUsersPermissions model = new ProGateOrgsUsersPermissionsImpl();

		model.setProGateOrgsUsersPermissionsId(soapModel.getProGateOrgsUsersPermissionsId());
		model.setOrgId(soapModel.getOrgId());
		model.setUserId(soapModel.getUserId());
		model.setPermissionId(soapModel.getPermissionId());
		model.setValue(soapModel.getValue());
		model.setIsGrant(soapModel.getIsGrant());
		model.setPmId(soapModel.getPmId());

		return model;
	}

	public static List<ProGateOrgsUsersPermissions> toModels(
		ProGateOrgsUsersPermissionsSoap[] soapModels) {
		List<ProGateOrgsUsersPermissions> models = new ArrayList<ProGateOrgsUsersPermissions>(soapModels.length);

		for (ProGateOrgsUsersPermissionsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.model.ProGateOrgsUsersPermissions"));

	public ProGateOrgsUsersPermissionsModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _ProGateOrgsUsersPermissionsId;
	}

	public void setPrimaryKey(Integer pk) {
		setProGateOrgsUsersPermissionsId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _ProGateOrgsUsersPermissionsId;
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
		return GetterUtil.getString(_permissionId);
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

	public ProGateOrgsUsersPermissions toEscapedModel() {
		if (isEscapedModel()) {
			return (ProGateOrgsUsersPermissions)this;
		}
		else {
			ProGateOrgsUsersPermissions model = new ProGateOrgsUsersPermissionsImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setProGateOrgsUsersPermissionsId(getProGateOrgsUsersPermissionsId());
			model.setOrgId(getOrgId());
			model.setUserId(getUserId());
			model.setPermissionId(HtmlUtil.escape(getPermissionId()));
			model.setValue(getValue());
			model.setIsGrant(getIsGrant());
			model.setPmId(getPmId());

			model = (ProGateOrgsUsersPermissions)Proxy.newProxyInstance(ProGateOrgsUsersPermissions.class.getClassLoader(),
					new Class[] { ProGateOrgsUsersPermissions.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ProGateOrgsUsersPermissionsImpl clone = new ProGateOrgsUsersPermissionsImpl();

		clone.setProGateOrgsUsersPermissionsId(getProGateOrgsUsersPermissionsId());
		clone.setOrgId(getOrgId());
		clone.setUserId(getUserId());
		clone.setPermissionId(getPermissionId());
		clone.setValue(getValue());
		clone.setIsGrant(getIsGrant());
		clone.setPmId(getPmId());

		return clone;
	}

	public int compareTo(
		ProGateOrgsUsersPermissions proGateOrgsUsersPermissions) {
		Integer pk = proGateOrgsUsersPermissions.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ProGateOrgsUsersPermissions proGateOrgsUsersPermissions = null;

		try {
			proGateOrgsUsersPermissions = (ProGateOrgsUsersPermissions)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = proGateOrgsUsersPermissions.getPrimaryKey();

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

		sb.append("{ProGateOrgsUsersPermissionsId=");
		sb.append(getProGateOrgsUsersPermissionsId());
		sb.append(", orgId=");
		sb.append(getOrgId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", permissionId=");
		sb.append(getPermissionId());
		sb.append(", value=");
		sb.append(getValue());
		sb.append(", isGrant=");
		sb.append(getIsGrant());
		sb.append(", pmId=");
		sb.append(getPmId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.ProGateOrgsUsersPermissions");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ProGateOrgsUsersPermissionsId</column-name><column-value><![CDATA[");
		sb.append(getProGateOrgsUsersPermissionsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgId</column-name><column-value><![CDATA[");
		sb.append(getOrgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>permissionId</column-name><column-value><![CDATA[");
		sb.append(getPermissionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>value</column-name><column-value><![CDATA[");
		sb.append(getValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isGrant</column-name><column-value><![CDATA[");
		sb.append(getIsGrant());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pmId</column-name><column-value><![CDATA[");
		sb.append(getPmId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _ProGateOrgsUsersPermissionsId;
	private int _orgId;
	private int _userId;
	private String _permissionId;
	private int _value;
	private boolean _isGrant;
	private int _pmId;
}