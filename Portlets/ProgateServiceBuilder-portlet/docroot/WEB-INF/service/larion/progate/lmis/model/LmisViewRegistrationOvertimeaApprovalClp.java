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

import java.util.Date;

/**
 * <a href="LmisViewRegistrationOvertimeaApprovalClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewRegistrationOvertimeaApprovalClp extends BaseModelImpl<LmisViewRegistrationOvertimeaApproval>
	implements LmisViewRegistrationOvertimeaApproval {
	public LmisViewRegistrationOvertimeaApprovalClp() {
	}

	public Integer getPrimaryKey() {
		return _lmisViewRegistrationOvertimeaApprovalId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisViewRegistrationOvertimeaApprovalId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisViewRegistrationOvertimeaApprovalId;
	}

	public Integer getLmisViewRegistrationOvertimeaApprovalId() {
		return _lmisViewRegistrationOvertimeaApprovalId;
	}

	public void setLmisViewRegistrationOvertimeaApprovalId(
		Integer lmisViewRegistrationOvertimeaApprovalId) {
		_lmisViewRegistrationOvertimeaApprovalId = lmisViewRegistrationOvertimeaApprovalId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getRequestedBy() {
		return _requestedBy;
	}

	public void setRequestedBy(int requestedBy) {
		_requestedBy = requestedBy;
	}

	public Date getRequestedAt() {
		return _requestedAt;
	}

	public void setRequestedAt(Date requestedAt) {
		_requestedAt = requestedAt;
	}

	public String getRequestedReason() {
		return _requestedReason;
	}

	public void setRequestedReason(String requestedReason) {
		_requestedReason = requestedReason;
	}

	public int getRequestedStatus() {
		return _requestedStatus;
	}

	public void setRequestedStatus(int requestedStatus) {
		_requestedStatus = requestedStatus;
	}

	public Date getCreatedAt() {
		return _createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		_createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return _updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		_updatedAt = updatedAt;
	}

	public int getOrgId() {
		return _orgId;
	}

	public void setOrgId(int orgId) {
		_orgId = orgId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public LmisViewRegistrationOvertimeaApproval toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			LmisViewRegistrationOvertimeaApproval model = new LmisViewRegistrationOvertimeaApprovalClp();

			model.setEscapedModel(true);

			model.setLmisViewRegistrationOvertimeaApprovalId(getLmisViewRegistrationOvertimeaApprovalId());
			model.setRootId(getRootId());
			model.setRequestedBy(getRequestedBy());
			model.setRequestedAt(getRequestedAt());
			model.setRequestedReason(HtmlUtil.escape(getRequestedReason()));
			model.setRequestedStatus(getRequestedStatus());
			model.setCreatedAt(getCreatedAt());
			model.setUpdatedAt(getUpdatedAt());
			model.setOrgId(getOrgId());
			model.setName(HtmlUtil.escape(getName()));
			model.setFullName(HtmlUtil.escape(getFullName()));

			model = (LmisViewRegistrationOvertimeaApproval)Proxy.newProxyInstance(LmisViewRegistrationOvertimeaApproval.class.getClassLoader(),
					new Class[] { LmisViewRegistrationOvertimeaApproval.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisViewRegistrationOvertimeaApprovalClp clone = new LmisViewRegistrationOvertimeaApprovalClp();

		clone.setLmisViewRegistrationOvertimeaApprovalId(getLmisViewRegistrationOvertimeaApprovalId());
		clone.setRootId(getRootId());
		clone.setRequestedBy(getRequestedBy());
		clone.setRequestedAt(getRequestedAt());
		clone.setRequestedReason(getRequestedReason());
		clone.setRequestedStatus(getRequestedStatus());
		clone.setCreatedAt(getCreatedAt());
		clone.setUpdatedAt(getUpdatedAt());
		clone.setOrgId(getOrgId());
		clone.setName(getName());
		clone.setFullName(getFullName());

		return clone;
	}

	public int compareTo(
		LmisViewRegistrationOvertimeaApproval lmisViewRegistrationOvertimeaApproval) {
		int value = 0;

		if (getRequestedStatus() < lmisViewRegistrationOvertimeaApproval.getRequestedStatus()) {
			value = -1;
		}
		else if (getRequestedStatus() > lmisViewRegistrationOvertimeaApproval.getRequestedStatus()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisViewRegistrationOvertimeaApprovalClp lmisViewRegistrationOvertimeaApproval =
			null;

		try {
			lmisViewRegistrationOvertimeaApproval = (LmisViewRegistrationOvertimeaApprovalClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisViewRegistrationOvertimeaApproval.getPrimaryKey();

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

		sb.append("{lmisViewRegistrationOvertimeaApprovalId=");
		sb.append(getLmisViewRegistrationOvertimeaApprovalId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", requestedBy=");
		sb.append(getRequestedBy());
		sb.append(", requestedAt=");
		sb.append(getRequestedAt());
		sb.append(", requestedReason=");
		sb.append(getRequestedReason());
		sb.append(", requestedStatus=");
		sb.append(getRequestedStatus());
		sb.append(", createdAt=");
		sb.append(getCreatedAt());
		sb.append(", updatedAt=");
		sb.append(getUpdatedAt());
		sb.append(", orgId=");
		sb.append(getOrgId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", fullName=");
		sb.append(getFullName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append(
			"larion.progate.lmis.model.LmisViewRegistrationOvertimeaApproval");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisViewRegistrationOvertimeaApprovalId</column-name><column-value><![CDATA[");
		sb.append(getLmisViewRegistrationOvertimeaApprovalId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requestedBy</column-name><column-value><![CDATA[");
		sb.append(getRequestedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requestedAt</column-name><column-value><![CDATA[");
		sb.append(getRequestedAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requestedReason</column-name><column-value><![CDATA[");
		sb.append(getRequestedReason());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requestedStatus</column-name><column-value><![CDATA[");
		sb.append(getRequestedStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdAt</column-name><column-value><![CDATA[");
		sb.append(getCreatedAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updatedAt</column-name><column-value><![CDATA[");
		sb.append(getUpdatedAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgId</column-name><column-value><![CDATA[");
		sb.append(getOrgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fullName</column-name><column-value><![CDATA[");
		sb.append(getFullName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisViewRegistrationOvertimeaApprovalId;
	private int _rootId;
	private int _requestedBy;
	private Date _requestedAt;
	private String _requestedReason;
	private int _requestedStatus;
	private Date _createdAt;
	private Date _updatedAt;
	private int _orgId;
	private String _name;
	private String _fullName;
}