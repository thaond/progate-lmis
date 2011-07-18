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

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * <a href="ProGateRolesClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateRolesClp extends BaseModelImpl<ProGateRoles>
	implements ProGateRoles {
	public ProGateRolesClp() {
	}

	public Integer getPrimaryKey() {
		return _roleId;
	}

	public void setPrimaryKey(Integer pk) {
		setRoleId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _roleId;
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

	public ProGateRoles toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			ProGateRoles model = new ProGateRolesClp();

			model.setEscapedModel(true);

			model.setRoleId(getRoleId());
			model.setName(HtmlUtil.escape(getName()));
			model.setDescription(HtmlUtil.escape(getDescription()));
			model.setRoleType(getRoleType());
			model.setPriority(getPriority());

			model = (ProGateRoles)Proxy.newProxyInstance(ProGateRoles.class.getClassLoader(),
					new Class[] { ProGateRoles.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ProGateRolesClp clone = new ProGateRolesClp();

		clone.setRoleId(getRoleId());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setRoleType(getRoleType());
		clone.setPriority(getPriority());

		return clone;
	}

	public int compareTo(ProGateRoles proGateRoles) {
		int value = 0;

		if (getPriority() < proGateRoles.getPriority()) {
			value = -1;
		}
		else if (getPriority() > proGateRoles.getPriority()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		if (getRoleType() < proGateRoles.getRoleType()) {
			value = -1;
		}
		else if (getRoleType() > proGateRoles.getRoleType()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getName().compareTo(proGateRoles.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ProGateRolesClp proGateRoles = null;

		try {
			proGateRoles = (ProGateRolesClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = proGateRoles.getPrimaryKey();

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

		sb.append("{roleId=");
		sb.append(getRoleId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", roleType=");
		sb.append(getRoleType());
		sb.append(", priority=");
		sb.append(getPriority());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.ProGateRoles");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>roleId</column-name><column-value><![CDATA[");
		sb.append(getRoleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>roleType</column-name><column-value><![CDATA[");
		sb.append(getRoleType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>priority</column-name><column-value><![CDATA[");
		sb.append(getPriority());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _roleId;
	private String _name;
	private String _description;
	private int _roleType;
	private int _priority;
}