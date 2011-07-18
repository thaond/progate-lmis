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
 * <a href="ProgatePortalMenuClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgatePortalMenuClp extends BaseModelImpl<ProgatePortalMenu>
	implements ProgatePortalMenu {
	public ProgatePortalMenuClp() {
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

	public ProgatePortalMenu toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			ProgatePortalMenu model = new ProgatePortalMenuClp();

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
		ProgatePortalMenuClp clone = new ProgatePortalMenuClp();

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

		ProgatePortalMenuClp progatePortalMenu = null;

		try {
			progatePortalMenu = (ProgatePortalMenuClp)obj;
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