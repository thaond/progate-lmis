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
 * <a href="ProgateMenusClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgateMenusClp extends BaseModelImpl<ProgateMenus>
	implements ProgateMenus {
	public ProgateMenusClp() {
	}

	public int getPrimaryKey() {
		return _ProgateMenusId;
	}

	public void setPrimaryKey(int pk) {
		setProgateMenusId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_ProgateMenusId);
	}

	public int getProgateMenusId() {
		return _ProgateMenusId;
	}

	public void setProgateMenusId(int ProgateMenusId) {
		_ProgateMenusId = ProgateMenusId;
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

	public int getNumberOrder() {
		return _numberOrder;
	}

	public void setNumberOrder(int numberOrder) {
		_numberOrder = numberOrder;
	}

	public ProgateMenus toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			ProgateMenus model = new ProgateMenusClp();

			model.setEscapedModel(true);

			model.setProgateMenusId(getProgateMenusId());
			model.setName(HtmlUtil.escape(getName()));
			model.setLayoutId(getLayoutId());
			model.setNumberOrder(getNumberOrder());

			model = (ProgateMenus)Proxy.newProxyInstance(ProgateMenus.class.getClassLoader(),
					new Class[] { ProgateMenus.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ProgateMenusClp clone = new ProgateMenusClp();

		clone.setProgateMenusId(getProgateMenusId());
		clone.setName(getName());
		clone.setLayoutId(getLayoutId());
		clone.setNumberOrder(getNumberOrder());

		return clone;
	}

	public int compareTo(ProgateMenus progateMenus) {
		int value = 0;

		if (getNumberOrder() < progateMenus.getNumberOrder()) {
			value = -1;
		}
		else if (getNumberOrder() > progateMenus.getNumberOrder()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ProgateMenusClp progateMenus = null;

		try {
			progateMenus = (ProgateMenusClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int pk = progateMenus.getPrimaryKey();

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

		sb.append("{ProgateMenusId=");
		sb.append(getProgateMenusId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", layoutId=");
		sb.append(getLayoutId());
		sb.append(", numberOrder=");
		sb.append(getNumberOrder());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.ProgateMenus");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ProgateMenusId</column-name><column-value><![CDATA[");
		sb.append(getProgateMenusId());
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
			"<column><column-name>numberOrder</column-name><column-value><![CDATA[");
		sb.append(getNumberOrder());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _ProgateMenusId;
	private String _name;
	private int _layoutId;
	private int _numberOrder;
}