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
 * <a href="ProgateLayoutsMenusClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgateLayoutsMenusClp extends BaseModelImpl<ProgateLayoutsMenus>
	implements ProgateLayoutsMenus {
	public ProgateLayoutsMenusClp() {
	}

	public int getPrimaryKey() {
		return _ProgateLayoutsMenusId;
	}

	public void setPrimaryKey(int pk) {
		setProgateLayoutsMenusId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_ProgateLayoutsMenusId);
	}

	public int getProgateLayoutsMenusId() {
		return _ProgateLayoutsMenusId;
	}

	public void setProgateLayoutsMenusId(int ProgateLayoutsMenusId) {
		_ProgateLayoutsMenusId = ProgateLayoutsMenusId;
	}

	public int getLayoutId() {
		return _layoutId;
	}

	public void setLayoutId(int layoutId) {
		_layoutId = layoutId;
	}

	public String getMenuName() {
		return _menuName;
	}

	public void setMenuName(String menuName) {
		_menuName = menuName;
	}

	public ProgateLayoutsMenus toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			ProgateLayoutsMenus model = new ProgateLayoutsMenusClp();

			model.setEscapedModel(true);

			model.setProgateLayoutsMenusId(getProgateLayoutsMenusId());
			model.setLayoutId(getLayoutId());
			model.setMenuName(HtmlUtil.escape(getMenuName()));

			model = (ProgateLayoutsMenus)Proxy.newProxyInstance(ProgateLayoutsMenus.class.getClassLoader(),
					new Class[] { ProgateLayoutsMenus.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ProgateLayoutsMenusClp clone = new ProgateLayoutsMenusClp();

		clone.setProgateLayoutsMenusId(getProgateLayoutsMenusId());
		clone.setLayoutId(getLayoutId());
		clone.setMenuName(getMenuName());

		return clone;
	}

	public int compareTo(ProgateLayoutsMenus progateLayoutsMenus) {
		int pk = progateLayoutsMenus.getPrimaryKey();

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

		ProgateLayoutsMenusClp progateLayoutsMenus = null;

		try {
			progateLayoutsMenus = (ProgateLayoutsMenusClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int pk = progateLayoutsMenus.getPrimaryKey();

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

		sb.append("{ProgateLayoutsMenusId=");
		sb.append(getProgateLayoutsMenusId());
		sb.append(", layoutId=");
		sb.append(getLayoutId());
		sb.append(", menuName=");
		sb.append(getMenuName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.ProgateLayoutsMenus");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ProgateLayoutsMenusId</column-name><column-value><![CDATA[");
		sb.append(getProgateLayoutsMenusId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>layoutId</column-name><column-value><![CDATA[");
		sb.append(getLayoutId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>menuName</column-name><column-value><![CDATA[");
		sb.append(getMenuName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _ProgateLayoutsMenusId;
	private int _layoutId;
	private String _menuName;
}