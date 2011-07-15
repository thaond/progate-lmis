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

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * <a href="LmisViewOrgUserRolesClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewOrgUserRolesClp extends BaseModelImpl<LmisViewOrgUserRoles>
	implements LmisViewOrgUserRoles {
	public LmisViewOrgUserRolesClp() {
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
		return _orgName;
	}

	public void setOrgName(String orgName) {
		_orgName = orgName;
	}

	public LmisViewOrgUserRoles toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			LmisViewOrgUserRoles model = new LmisViewOrgUserRolesClp();

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
		LmisViewOrgUserRolesClp clone = new LmisViewOrgUserRolesClp();

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

		LmisViewOrgUserRolesClp lmisViewOrgUserRoles = null;

		try {
			lmisViewOrgUserRoles = (LmisViewOrgUserRolesClp)obj;
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