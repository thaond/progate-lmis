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

package larion.progate.lmis.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import larion.progate.lmis.model.LmisViewOrgUserRoles;
import larion.progate.lmis.model.LmisViewOrgUserRolesSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="LmisViewOrgUserRolesModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewOrgUserRolesModelImpl extends BaseModelImpl<LmisViewOrgUserRoles> {
	public static final String TABLE_NAME = "vw_org_user_roles";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "org_id", new Integer(Types.INTEGER) },
			

			{ "user_id", new Integer(Types.INTEGER) },
			

			{ "role_id", new Integer(Types.INTEGER) },
			

			{ "org_name", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table vw_org_user_roles (id INTEGER not null primary key,root_id INTEGER,org_id INTEGER,user_id INTEGER,role_id INTEGER,org_name VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table vw_org_user_roles";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.lmis.model.LmisViewOrgUserRoles"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.lmis.model.LmisViewOrgUserRoles"),
			false);

	public static LmisViewOrgUserRoles toModel(
		LmisViewOrgUserRolesSoap soapModel) {
		LmisViewOrgUserRoles model = new LmisViewOrgUserRolesImpl();

		model.setLmisViewOrgUserRolesId(soapModel.getLmisViewOrgUserRolesId());
		model.setRootId(soapModel.getRootId());
		model.setOrgId(soapModel.getOrgId());
		model.setUserId(soapModel.getUserId());
		model.setRoleId(soapModel.getRoleId());
		model.setOrgName(soapModel.getOrgName());

		return model;
	}

	public static List<LmisViewOrgUserRoles> toModels(
		LmisViewOrgUserRolesSoap[] soapModels) {
		List<LmisViewOrgUserRoles> models = new ArrayList<LmisViewOrgUserRoles>(soapModels.length);

		for (LmisViewOrgUserRolesSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.lmis.model.LmisViewOrgUserRoles"));

	public LmisViewOrgUserRolesModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _lmisViewOrgUserRolesId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisViewOrgUserRolesId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisViewOrgUserRolesId;
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
		return GetterUtil.getString(_orgName);
	}

	public void setOrgName(String orgName) {
		_orgName = orgName;
	}

	public LmisViewOrgUserRoles toEscapedModel() {
		if (isEscapedModel()) {
			return (LmisViewOrgUserRoles)this;
		}
		else {
			LmisViewOrgUserRoles model = new LmisViewOrgUserRolesImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setLmisViewOrgUserRolesId(getLmisViewOrgUserRolesId());
			model.setRootId(getRootId());
			model.setOrgId(getOrgId());
			model.setUserId(getUserId());
			model.setRoleId(getRoleId());
			model.setOrgName(HtmlUtil.escape(getOrgName()));

			model = (LmisViewOrgUserRoles)Proxy.newProxyInstance(LmisViewOrgUserRoles.class.getClassLoader(),
					new Class[] { LmisViewOrgUserRoles.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisViewOrgUserRolesImpl clone = new LmisViewOrgUserRolesImpl();

		clone.setLmisViewOrgUserRolesId(getLmisViewOrgUserRolesId());
		clone.setRootId(getRootId());
		clone.setOrgId(getOrgId());
		clone.setUserId(getUserId());
		clone.setRoleId(getRoleId());
		clone.setOrgName(getOrgName());

		return clone;
	}

	public int compareTo(LmisViewOrgUserRoles lmisViewOrgUserRoles) {
		int value = 0;

		value = getOrgName().compareTo(lmisViewOrgUserRoles.getOrgName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisViewOrgUserRoles lmisViewOrgUserRoles = null;

		try {
			lmisViewOrgUserRoles = (LmisViewOrgUserRoles)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisViewOrgUserRoles.getPrimaryKey();

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

		sb.append("{lmisViewOrgUserRolesId=");
		sb.append(getLmisViewOrgUserRolesId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", orgId=");
		sb.append(getOrgId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", roleId=");
		sb.append(getRoleId());
		sb.append(", orgName=");
		sb.append(getOrgName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisViewOrgUserRoles");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisViewOrgUserRolesId</column-name><column-value><![CDATA[");
		sb.append(getLmisViewOrgUserRolesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
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
			"<column><column-name>roleId</column-name><column-value><![CDATA[");
		sb.append(getRoleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgName</column-name><column-value><![CDATA[");
		sb.append(getOrgName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisViewOrgUserRolesId;
	private int _rootId;
	private int _orgId;
	private int _userId;
	private int _roleId;
	private String _orgName;
}