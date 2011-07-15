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
 * <a href="ProgateOrganizationParticipantsClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgateOrganizationParticipantsClp extends BaseModelImpl<ProgateOrganizationParticipants>
	implements ProgateOrganizationParticipants {
	public ProgateOrganizationParticipantsClp() {
	}

	public Integer getPrimaryKey() {
		return _ProgateOrganizationParticipantsId;
	}

	public void setPrimaryKey(Integer pk) {
		setProgateOrganizationParticipantsId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _ProgateOrganizationParticipantsId;
	}

	public Integer getProgateOrganizationParticipantsId() {
		return _ProgateOrganizationParticipantsId;
	}

	public void setProgateOrganizationParticipantsId(
		Integer ProgateOrganizationParticipantsId) {
		_ProgateOrganizationParticipantsId = ProgateOrganizationParticipantsId;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public int getOrgId() {
		return _orgId;
	}

	public void setOrgId(int orgId) {
		_orgId = orgId;
	}

	public int getRoleId() {
		return _roleId;
	}

	public void setRoleId(int roleId) {
		_roleId = roleId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getBodId() {
		return _bodId;
	}

	public void setBodId(int bodId) {
		_bodId = bodId;
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

	public int getApprovedBy() {
		return _approvedBy;
	}

	public void setApprovedBy(int approvedBy) {
		_approvedBy = approvedBy;
	}

	public Date getApprovedAt() {
		return _approvedAt;
	}

	public void setApprovedAt(Date approvedAt) {
		_approvedAt = approvedAt;
	}

	public String getApprovedReason() {
		return _approvedReason;
	}

	public void setApprovedReason(String approvedReason) {
		_approvedReason = approvedReason;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public boolean getIsCurrent() {
		return _isCurrent;
	}

	public boolean isIsCurrent() {
		return _isCurrent;
	}

	public void setIsCurrent(boolean isCurrent) {
		_isCurrent = isCurrent;
	}

	public ProgateOrganizationParticipants toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			ProgateOrganizationParticipants model = new ProgateOrganizationParticipantsClp();

			model.setEscapedModel(true);

			model.setProgateOrganizationParticipantsId(getProgateOrganizationParticipantsId());
			model.setUserId(getUserId());
			model.setOrgId(getOrgId());
			model.setRoleId(getRoleId());
			model.setRootId(getRootId());
			model.setBodId(getBodId());
			model.setRequestedBy(getRequestedBy());
			model.setRequestedAt(getRequestedAt());
			model.setRequestedReason(HtmlUtil.escape(getRequestedReason()));
			model.setApprovedBy(getApprovedBy());
			model.setApprovedAt(getApprovedAt());
			model.setApprovedReason(HtmlUtil.escape(getApprovedReason()));
			model.setStatus(getStatus());
			model.setIsCurrent(getIsCurrent());

			model = (ProgateOrganizationParticipants)Proxy.newProxyInstance(ProgateOrganizationParticipants.class.getClassLoader(),
					new Class[] { ProgateOrganizationParticipants.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ProgateOrganizationParticipantsClp clone = new ProgateOrganizationParticipantsClp();

		clone.setProgateOrganizationParticipantsId(getProgateOrganizationParticipantsId());
		clone.setUserId(getUserId());
		clone.setOrgId(getOrgId());
		clone.setRoleId(getRoleId());
		clone.setRootId(getRootId());
		clone.setBodId(getBodId());
		clone.setRequestedBy(getRequestedBy());
		clone.setRequestedAt(getRequestedAt());
		clone.setRequestedReason(getRequestedReason());
		clone.setApprovedBy(getApprovedBy());
		clone.setApprovedAt(getApprovedAt());
		clone.setApprovedReason(getApprovedReason());
		clone.setStatus(getStatus());
		clone.setIsCurrent(getIsCurrent());

		return clone;
	}

	public int compareTo(
		ProgateOrganizationParticipants progateOrganizationParticipants) {
		int value = 0;

		value = DateUtil.compareTo(getApprovedAt(),
				progateOrganizationParticipants.getApprovedAt());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getRequestedAt(),
				progateOrganizationParticipants.getRequestedAt());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		if (getOrgId() < progateOrganizationParticipants.getOrgId()) {
			value = -1;
		}
		else if (getOrgId() > progateOrganizationParticipants.getOrgId()) {
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

		ProgateOrganizationParticipantsClp progateOrganizationParticipants = null;

		try {
			progateOrganizationParticipants = (ProgateOrganizationParticipantsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = progateOrganizationParticipants.getPrimaryKey();

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

		sb.append("{ProgateOrganizationParticipantsId=");
		sb.append(getProgateOrganizationParticipantsId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", orgId=");
		sb.append(getOrgId());
		sb.append(", roleId=");
		sb.append(getRoleId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", bodId=");
		sb.append(getBodId());
		sb.append(", requestedBy=");
		sb.append(getRequestedBy());
		sb.append(", requestedAt=");
		sb.append(getRequestedAt());
		sb.append(", requestedReason=");
		sb.append(getRequestedReason());
		sb.append(", approvedBy=");
		sb.append(getApprovedBy());
		sb.append(", approvedAt=");
		sb.append(getApprovedAt());
		sb.append(", approvedReason=");
		sb.append(getApprovedReason());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", isCurrent=");
		sb.append(getIsCurrent());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.ProgateOrganizationParticipants");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ProgateOrganizationParticipantsId</column-name><column-value><![CDATA[");
		sb.append(getProgateOrganizationParticipantsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgId</column-name><column-value><![CDATA[");
		sb.append(getOrgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>roleId</column-name><column-value><![CDATA[");
		sb.append(getRoleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bodId</column-name><column-value><![CDATA[");
		sb.append(getBodId());
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
			"<column><column-name>approvedBy</column-name><column-value><![CDATA[");
		sb.append(getApprovedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approvedAt</column-name><column-value><![CDATA[");
		sb.append(getApprovedAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approvedReason</column-name><column-value><![CDATA[");
		sb.append(getApprovedReason());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isCurrent</column-name><column-value><![CDATA[");
		sb.append(getIsCurrent());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _ProgateOrganizationParticipantsId;
	private int _userId;
	private int _orgId;
	private int _roleId;
	private int _rootId;
	private int _bodId;
	private int _requestedBy;
	private Date _requestedAt;
	private String _requestedReason;
	private int _approvedBy;
	private Date _approvedAt;
	private String _approvedReason;
	private int _status;
	private boolean _isCurrent;
}