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
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * <a href="ProgateLayoutsRolesClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgateLayoutsRolesClp extends BaseModelImpl<ProgateLayoutsRoles>
	implements ProgateLayoutsRoles {
	public ProgateLayoutsRolesClp() {
	}

	public int getPrimaryKey() {
		return _ProgateLayoutsRolesId;
	}

	public void setPrimaryKey(int pk) {
		setProgateLayoutsRolesId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_ProgateLayoutsRolesId);
	}

	public int getProgateLayoutsRolesId() {
		return _ProgateLayoutsRolesId;
	}

	public void setProgateLayoutsRolesId(int ProgateLayoutsRolesId) {
		_ProgateLayoutsRolesId = ProgateLayoutsRolesId;
	}

	public int getLayoutId() {
		return _layoutId;
	}

	public void setLayoutId(int layoutId) {
		_layoutId = layoutId;
	}

	public int getMinRolePriority() {
		return _minRolePriority;
	}

	public void setMinRolePriority(int minRolePriority) {
		_minRolePriority = minRolePriority;
	}

	public ProgateLayoutsRoles toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			ProgateLayoutsRoles model = new ProgateLayoutsRolesClp();

			model.setEscapedModel(true);

			model.setProgateLayoutsRolesId(getProgateLayoutsRolesId());
			model.setLayoutId(getLayoutId());
			model.setMinRolePriority(getMinRolePriority());

			model = (ProgateLayoutsRoles)Proxy.newProxyInstance(ProgateLayoutsRoles.class.getClassLoader(),
					new Class[] { ProgateLayoutsRoles.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ProgateLayoutsRolesClp clone = new ProgateLayoutsRolesClp();

		clone.setProgateLayoutsRolesId(getProgateLayoutsRolesId());
		clone.setLayoutId(getLayoutId());
		clone.setMinRolePriority(getMinRolePriority());

		return clone;
	}

	public int compareTo(ProgateLayoutsRoles progateLayoutsRoles) {
		int pk = progateLayoutsRoles.getPrimaryKey();

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

		ProgateLayoutsRolesClp progateLayoutsRoles = null;

		try {
			progateLayoutsRoles = (ProgateLayoutsRolesClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int pk = progateLayoutsRoles.getPrimaryKey();

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

		sb.append("{ProgateLayoutsRolesId=");
		sb.append(getProgateLayoutsRolesId());
		sb.append(", layoutId=");
		sb.append(getLayoutId());
		sb.append(", minRolePriority=");
		sb.append(getMinRolePriority());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.ProgateLayoutsRoles");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ProgateLayoutsRolesId</column-name><column-value><![CDATA[");
		sb.append(getProgateLayoutsRolesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>layoutId</column-name><column-value><![CDATA[");
		sb.append(getLayoutId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>minRolePriority</column-name><column-value><![CDATA[");
		sb.append(getMinRolePriority());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _ProgateLayoutsRolesId;
	private int _layoutId;
	private int _minRolePriority;
}