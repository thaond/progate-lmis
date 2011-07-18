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
 * <a href="ProGateMenuViewClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateMenuViewClp extends BaseModelImpl<ProGateMenuView>
	implements ProGateMenuView {
	public ProGateMenuViewClp() {
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
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getMenus() {
		return _menus;
	}

	public void setMenus(String menus) {
		_menus = menus;
	}

	public ProGateMenuView toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			ProGateMenuView model = new ProGateMenuViewClp();

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
		ProGateMenuViewClp clone = new ProGateMenuViewClp();

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

		ProGateMenuViewClp proGateMenuView = null;

		try {
			proGateMenuView = (ProGateMenuViewClp)obj;
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