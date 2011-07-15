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

import java.util.Date;

/**
 * <a href="OrgObjectApprovalClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrgObjectApprovalClp extends BaseModelImpl<OrgObjectApproval>
	implements OrgObjectApproval {
	public OrgObjectApprovalClp() {
	}

	public Integer getPrimaryKey() {
		return _orgObjectApprovalId;
	}

	public void setPrimaryKey(Integer pk) {
		setOrgObjectApprovalId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _orgObjectApprovalId;
	}

	public Integer getOrgObjectApprovalId() {
		return _orgObjectApprovalId;
	}

	public void setOrgObjectApprovalId(Integer orgObjectApprovalId) {
		_orgObjectApprovalId = orgObjectApprovalId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public Date getApproved_at() {
		return _approved_at;
	}

	public void setApproved_at(Date approved_at) {
		_approved_at = approved_at;
	}

	public int getApproved_by() {
		return _approved_by;
	}

	public void setApproved_by(int approved_by) {
		_approved_by = approved_by;
	}

	public String getReason() {
		return _reason;
	}

	public void setReason(String reason) {
		_reason = reason;
	}

	public int getOrgObjectListId() {
		return _orgObjectListId;
	}

	public void setOrgObjectListId(int orgObjectListId) {
		_orgObjectListId = orgObjectListId;
	}

	public OrgObjectApproval toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			OrgObjectApproval model = new OrgObjectApprovalClp();

			model.setEscapedModel(true);

			model.setOrgObjectApprovalId(getOrgObjectApprovalId());
			model.setStatus(getStatus());
			model.setApproved_at(getApproved_at());
			model.setApproved_by(getApproved_by());
			model.setReason(HtmlUtil.escape(getReason()));
			model.setOrgObjectListId(getOrgObjectListId());

			model = (OrgObjectApproval)Proxy.newProxyInstance(OrgObjectApproval.class.getClassLoader(),
					new Class[] { OrgObjectApproval.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		OrgObjectApprovalClp clone = new OrgObjectApprovalClp();

		clone.setOrgObjectApprovalId(getOrgObjectApprovalId());
		clone.setStatus(getStatus());
		clone.setApproved_at(getApproved_at());
		clone.setApproved_by(getApproved_by());
		clone.setReason(getReason());
		clone.setOrgObjectListId(getOrgObjectListId());

		return clone;
	}

	public int compareTo(OrgObjectApproval orgObjectApproval) {
		Integer pk = orgObjectApproval.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		OrgObjectApprovalClp orgObjectApproval = null;

		try {
			orgObjectApproval = (OrgObjectApprovalClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = orgObjectApproval.getPrimaryKey();

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

		sb.append("{orgObjectApprovalId=");
		sb.append(getOrgObjectApprovalId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", approved_at=");
		sb.append(getApproved_at());
		sb.append(", approved_by=");
		sb.append(getApproved_by());
		sb.append(", reason=");
		sb.append(getReason());
		sb.append(", orgObjectListId=");
		sb.append(getOrgObjectListId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.OrgObjectApproval");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>orgObjectApprovalId</column-name><column-value><![CDATA[");
		sb.append(getOrgObjectApprovalId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approved_at</column-name><column-value><![CDATA[");
		sb.append(getApproved_at());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approved_by</column-name><column-value><![CDATA[");
		sb.append(getApproved_by());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reason</column-name><column-value><![CDATA[");
		sb.append(getReason());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgObjectListId</column-name><column-value><![CDATA[");
		sb.append(getOrgObjectListId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _orgObjectApprovalId;
	private int _status;
	private Date _approved_at;
	private int _approved_by;
	private String _reason;
	private int _orgObjectListId;
}