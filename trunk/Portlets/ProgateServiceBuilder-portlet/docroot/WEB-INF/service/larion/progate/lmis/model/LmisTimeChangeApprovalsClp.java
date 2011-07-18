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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * <a href="LmisTimeChangeApprovalsClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisTimeChangeApprovalsClp extends BaseModelImpl<LmisTimeChangeApprovals>
	implements LmisTimeChangeApprovals {
	public LmisTimeChangeApprovalsClp() {
	}

	public Integer getPrimaryKey() {
		return _lmisTimeChangeApprovalId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisTimeChangeApprovalId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisTimeChangeApprovalId;
	}

	public Integer getLmisTimeChangeApprovalId() {
		return _lmisTimeChangeApprovalId;
	}

	public void setLmisTimeChangeApprovalId(Integer lmisTimeChangeApprovalId) {
		_lmisTimeChangeApprovalId = lmisTimeChangeApprovalId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getRequestId() {
		return _requestId;
	}

	public void setRequestId(int requestId) {
		_requestId = requestId;
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

	public boolean getIsApproved() {
		return _isApproved;
	}

	public boolean isIsApproved() {
		return _isApproved;
	}

	public void setIsApproved(boolean isApproved) {
		_isApproved = isApproved;
	}

	public boolean getApprovedStatus() {
		return _approvedStatus;
	}

	public boolean isApprovedStatus() {
		return _approvedStatus;
	}

	public void setApprovedStatus(boolean approvedStatus) {
		_approvedStatus = approvedStatus;
	}

	public String getReason() {
		return _Reason;
	}

	public void setReason(String Reason) {
		_Reason = Reason;
	}

	public LmisTimeChangeApprovals toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			LmisTimeChangeApprovals model = new LmisTimeChangeApprovalsClp();

			model.setEscapedModel(true);

			model.setLmisTimeChangeApprovalId(getLmisTimeChangeApprovalId());
			model.setRootId(getRootId());
			model.setRequestId(getRequestId());
			model.setApprovedBy(getApprovedBy());
			model.setApprovedAt(getApprovedAt());
			model.setIsApproved(getIsApproved());
			model.setApprovedStatus(getApprovedStatus());
			model.setReason(HtmlUtil.escape(getReason()));

			model = (LmisTimeChangeApprovals)Proxy.newProxyInstance(LmisTimeChangeApprovals.class.getClassLoader(),
					new Class[] { LmisTimeChangeApprovals.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisTimeChangeApprovalsClp clone = new LmisTimeChangeApprovalsClp();

		clone.setLmisTimeChangeApprovalId(getLmisTimeChangeApprovalId());
		clone.setRootId(getRootId());
		clone.setRequestId(getRequestId());
		clone.setApprovedBy(getApprovedBy());
		clone.setApprovedAt(getApprovedAt());
		clone.setIsApproved(getIsApproved());
		clone.setApprovedStatus(getApprovedStatus());
		clone.setReason(getReason());

		return clone;
	}

	public int compareTo(LmisTimeChangeApprovals lmisTimeChangeApprovals) {
		int value = 0;

		if (getApprovedStatus() == lmisTimeChangeApprovals.getApprovedStatus()) {
			value = -1;
		}
		else if (getApprovedStatus() != lmisTimeChangeApprovals.getApprovedStatus()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getApprovedAt(),
				lmisTimeChangeApprovals.getApprovedAt());

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

		LmisTimeChangeApprovalsClp lmisTimeChangeApprovals = null;

		try {
			lmisTimeChangeApprovals = (LmisTimeChangeApprovalsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisTimeChangeApprovals.getPrimaryKey();

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

		sb.append("{lmisTimeChangeApprovalId=");
		sb.append(getLmisTimeChangeApprovalId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", requestId=");
		sb.append(getRequestId());
		sb.append(", approvedBy=");
		sb.append(getApprovedBy());
		sb.append(", approvedAt=");
		sb.append(getApprovedAt());
		sb.append(", isApproved=");
		sb.append(getIsApproved());
		sb.append(", approvedStatus=");
		sb.append(getApprovedStatus());
		sb.append(", Reason=");
		sb.append(getReason());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisTimeChangeApprovals");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisTimeChangeApprovalId</column-name><column-value><![CDATA[");
		sb.append(getLmisTimeChangeApprovalId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requestId</column-name><column-value><![CDATA[");
		sb.append(getRequestId());
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
			"<column><column-name>isApproved</column-name><column-value><![CDATA[");
		sb.append(getIsApproved());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approvedStatus</column-name><column-value><![CDATA[");
		sb.append(getApprovedStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Reason</column-name><column-value><![CDATA[");
		sb.append(getReason());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisTimeChangeApprovalId;
	private int _rootId;
	private int _requestId;
	private int _approvedBy;
	private Date _approvedAt;
	private boolean _isApproved;
	private boolean _approvedStatus;
	private String _Reason;
}