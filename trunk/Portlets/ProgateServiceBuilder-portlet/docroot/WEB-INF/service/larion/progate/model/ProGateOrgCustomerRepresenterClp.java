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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * <a href="ProGateOrgCustomerRepresenterClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProGateOrgCustomerRepresenterClp extends BaseModelImpl<ProGateOrgCustomerRepresenter>
	implements ProGateOrgCustomerRepresenter {
	public ProGateOrgCustomerRepresenterClp() {
	}

	public Integer getPrimaryKey() {
		return _ProGateOrgCustomerRepresenterId;
	}

	public void setPrimaryKey(Integer pk) {
		setProGateOrgCustomerRepresenterId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _ProGateOrgCustomerRepresenterId;
	}

	public Integer getProGateOrgCustomerRepresenterId() {
		return _ProGateOrgCustomerRepresenterId;
	}

	public void setProGateOrgCustomerRepresenterId(
		Integer ProGateOrgCustomerRepresenterId) {
		_ProGateOrgCustomerRepresenterId = ProGateOrgCustomerRepresenterId;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getDisplayName() {
		return _displayName;
	}

	public void setDisplayName(String displayName) {
		_displayName = displayName;
	}

	public String getRole() {
		return _role;
	}

	public void setRole(String role) {
		_role = role;
	}

	public int getCustomerId() {
		return _customerId;
	}

	public void setCustomerId(int customerId) {
		_customerId = customerId;
	}

	public int getOrgId() {
		return _orgId;
	}

	public void setOrgId(int orgId) {
		_orgId = orgId;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public ProGateOrgCustomerRepresenter toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			ProGateOrgCustomerRepresenter model = new ProGateOrgCustomerRepresenterClp();

			model.setEscapedModel(true);

			model.setProGateOrgCustomerRepresenterId(getProGateOrgCustomerRepresenterId());
			model.setFirstName(HtmlUtil.escape(getFirstName()));
			model.setLastName(HtmlUtil.escape(getLastName()));
			model.setDisplayName(HtmlUtil.escape(getDisplayName()));
			model.setRole(HtmlUtil.escape(getRole()));
			model.setCustomerId(getCustomerId());
			model.setOrgId(getOrgId());
			model.setDescription(HtmlUtil.escape(getDescription()));
			model.setCreatedDate(getCreatedDate());
			model.setModifiedDate(getModifiedDate());

			model = (ProGateOrgCustomerRepresenter)Proxy.newProxyInstance(ProGateOrgCustomerRepresenter.class.getClassLoader(),
					new Class[] { ProGateOrgCustomerRepresenter.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ProGateOrgCustomerRepresenterClp clone = new ProGateOrgCustomerRepresenterClp();

		clone.setProGateOrgCustomerRepresenterId(getProGateOrgCustomerRepresenterId());
		clone.setFirstName(getFirstName());
		clone.setLastName(getLastName());
		clone.setDisplayName(getDisplayName());
		clone.setRole(getRole());
		clone.setCustomerId(getCustomerId());
		clone.setOrgId(getOrgId());
		clone.setDescription(getDescription());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	public int compareTo(
		ProGateOrgCustomerRepresenter proGateOrgCustomerRepresenter) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				proGateOrgCustomerRepresenter.getModifiedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getCreatedDate(),
				proGateOrgCustomerRepresenter.getCreatedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = getDisplayName()
					.compareTo(proGateOrgCustomerRepresenter.getDisplayName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ProGateOrgCustomerRepresenterClp proGateOrgCustomerRepresenter = null;

		try {
			proGateOrgCustomerRepresenter = (ProGateOrgCustomerRepresenterClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = proGateOrgCustomerRepresenter.getPrimaryKey();

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

		sb.append("{ProGateOrgCustomerRepresenterId=");
		sb.append(getProGateOrgCustomerRepresenterId());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", displayName=");
		sb.append(getDisplayName());
		sb.append(", role=");
		sb.append(getRole());
		sb.append(", customerId=");
		sb.append(getCustomerId());
		sb.append(", orgId=");
		sb.append(getOrgId());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.ProGateOrgCustomerRepresenter");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ProGateOrgCustomerRepresenterId</column-name><column-value><![CDATA[");
		sb.append(getProGateOrgCustomerRepresenterId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayName</column-name><column-value><![CDATA[");
		sb.append(getDisplayName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>role</column-name><column-value><![CDATA[");
		sb.append(getRole());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customerId</column-name><column-value><![CDATA[");
		sb.append(getCustomerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgId</column-name><column-value><![CDATA[");
		sb.append(getOrgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _ProGateOrgCustomerRepresenterId;
	private String _firstName;
	private String _lastName;
	private String _displayName;
	private String _role;
	private int _customerId;
	private int _orgId;
	private String _description;
	private Date _createdDate;
	private Date _modifiedDate;
}