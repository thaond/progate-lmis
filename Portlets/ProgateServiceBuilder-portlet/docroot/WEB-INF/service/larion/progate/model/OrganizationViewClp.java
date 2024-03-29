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
 * <a href="OrganizationViewClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrganizationViewClp extends BaseModelImpl<OrganizationView>
	implements OrganizationView {
	public OrganizationViewClp() {
	}

	public int getPrimaryKey() {
		return _orgId;
	}

	public void setPrimaryKey(int pk) {
		setOrgId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_orgId);
	}

	public int getOrgId() {
		return _orgId;
	}

	public void setOrgId(int orgId) {
		_orgId = orgId;
	}

	public String getOrgName() {
		return _orgName;
	}

	public void setOrgName(String orgName) {
		_orgName = orgName;
	}

	public int getCountProduct() {
		return _countProduct;
	}

	public void setCountProduct(int countProduct) {
		_countProduct = countProduct;
	}

	public String getOrgNameLower() {
		return _orgNameLower;
	}

	public void setOrgNameLower(String orgNameLower) {
		_orgNameLower = orgNameLower;
	}

	public OrganizationView toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			OrganizationView model = new OrganizationViewClp();

			model.setEscapedModel(true);

			model.setOrgId(getOrgId());
			model.setOrgName(HtmlUtil.escape(getOrgName()));
			model.setCountProduct(getCountProduct());
			model.setOrgNameLower(HtmlUtil.escape(getOrgNameLower()));

			model = (OrganizationView)Proxy.newProxyInstance(OrganizationView.class.getClassLoader(),
					new Class[] { OrganizationView.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		OrganizationViewClp clone = new OrganizationViewClp();

		clone.setOrgId(getOrgId());
		clone.setOrgName(getOrgName());
		clone.setCountProduct(getCountProduct());
		clone.setOrgNameLower(getOrgNameLower());

		return clone;
	}

	public int compareTo(OrganizationView organizationView) {
		int value = 0;

		if (getCountProduct() < organizationView.getCountProduct()) {
			value = -1;
		}
		else if (getCountProduct() > organizationView.getCountProduct()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = getOrgName().compareTo(organizationView.getOrgName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		OrganizationViewClp organizationView = null;

		try {
			organizationView = (OrganizationViewClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int pk = organizationView.getPrimaryKey();

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

		sb.append("{orgId=");
		sb.append(getOrgId());
		sb.append(", orgName=");
		sb.append(getOrgName());
		sb.append(", countProduct=");
		sb.append(getCountProduct());
		sb.append(", orgNameLower=");
		sb.append(getOrgNameLower());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.OrganizationView");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>orgId</column-name><column-value><![CDATA[");
		sb.append(getOrgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgName</column-name><column-value><![CDATA[");
		sb.append(getOrgName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countProduct</column-name><column-value><![CDATA[");
		sb.append(getCountProduct());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgNameLower</column-name><column-value><![CDATA[");
		sb.append(getOrgNameLower());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _orgId;
	private String _orgName;
	private int _countProduct;
	private String _orgNameLower;
}