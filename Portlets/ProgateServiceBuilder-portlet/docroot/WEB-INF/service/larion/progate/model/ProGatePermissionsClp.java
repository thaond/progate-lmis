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
 * <a href="ProGatePermissionsClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGatePermissionsClp extends BaseModelImpl<ProGatePermissions>
	implements ProGatePermissions {
	public ProGatePermissionsClp() {
	}

	public String getPrimaryKey() {
		return _ProGatePermissionsId;
	}

	public void setPrimaryKey(String pk) {
		setProGatePermissionsId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _ProGatePermissionsId;
	}

	public String getProGatePermissionsId() {
		return _ProGatePermissionsId;
	}

	public void setProGatePermissionsId(String ProGatePermissionsId) {
		_ProGatePermissionsId = ProGatePermissionsId;
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
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public ProGatePermissions toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			ProGatePermissions model = new ProGatePermissionsClp();

			model.setEscapedModel(true);

			model.setProGatePermissionsId(HtmlUtil.escape(
					getProGatePermissionsId()));
			model.setApplicationId(getApplicationId());
			model.setCategory(getCategory());
			model.setDescription(HtmlUtil.escape(getDescription()));

			model = (ProGatePermissions)Proxy.newProxyInstance(ProGatePermissions.class.getClassLoader(),
					new Class[] { ProGatePermissions.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ProGatePermissionsClp clone = new ProGatePermissionsClp();

		clone.setProGatePermissionsId(getProGatePermissionsId());
		clone.setApplicationId(getApplicationId());
		clone.setCategory(getCategory());
		clone.setDescription(getDescription());

		return clone;
	}

	public int compareTo(ProGatePermissions proGatePermissions) {
		String pk = proGatePermissions.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ProGatePermissionsClp proGatePermissions = null;

		try {
			proGatePermissions = (ProGatePermissionsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String pk = proGatePermissions.getPrimaryKey();

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

		sb.append("{ProGatePermissionsId=");
		sb.append(getProGatePermissionsId());
		sb.append(", applicationId=");
		sb.append(getApplicationId());
		sb.append(", category=");
		sb.append(getCategory());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.ProGatePermissions");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ProGatePermissionsId</column-name><column-value><![CDATA[");
		sb.append(getProGatePermissionsId());
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

		sb.append("</model>");

		return sb.toString();
	}

	private String _ProGatePermissionsId;
	private int _applicationId;
	private int _category;
	private String _description;
}