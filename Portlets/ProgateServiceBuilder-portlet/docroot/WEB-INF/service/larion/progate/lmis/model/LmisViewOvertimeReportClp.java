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
 * <a href="LmisViewOvertimeReportClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewOvertimeReportClp extends BaseModelImpl<LmisViewOvertimeReport>
	implements LmisViewOvertimeReport {
	public LmisViewOvertimeReportClp() {
	}

	public Integer getPrimaryKey() {
		return _lmisViewOvertimeReportId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisViewOvertimeReportId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisViewOvertimeReportId;
	}

	public Integer getLmisViewOvertimeReportId() {
		return _lmisViewOvertimeReportId;
	}

	public void setLmisViewOvertimeReportId(Integer lmisViewOvertimeReportId) {
		_lmisViewOvertimeReportId = lmisViewOvertimeReportId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getOrgId() {
		return _orgId;
	}

	public void setOrgId(int orgId) {
		_orgId = orgId;
	}

	public int getRequestId() {
		return _requestId;
	}

	public void setRequestId(int requestId) {
		_requestId = requestId;
	}

	public int getReportedBy() {
		return _reportedBy;
	}

	public void setReportedBy(int reportedBy) {
		_reportedBy = reportedBy;
	}

	public Date getReportedAt() {
		return _reportedAt;
	}

	public void setReportedAt(Date reportedAt) {
		_reportedAt = reportedAt;
	}

	public String getReportedReason() {
		return _reportedReason;
	}

	public void setReportedReason(String reportedReason) {
		_reportedReason = reportedReason;
	}

	public int getReportedStatus() {
		return _reportedStatus;
	}

	public void setReportedStatus(int reportedStatus) {
		_reportedStatus = reportedStatus;
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

	public String getOrgName() {
		return _orgName;
	}

	public void setOrgName(String orgName) {
		_orgName = orgName;
	}

	public LmisViewOvertimeReport toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			LmisViewOvertimeReport model = new LmisViewOvertimeReportClp();

			model.setEscapedModel(true);

			model.setLmisViewOvertimeReportId(getLmisViewOvertimeReportId());
			model.setRootId(getRootId());
			model.setOrgId(getOrgId());
			model.setRequestId(getRequestId());
			model.setReportedBy(getReportedBy());
			model.setReportedAt(getReportedAt());
			model.setReportedReason(HtmlUtil.escape(getReportedReason()));
			model.setReportedStatus(getReportedStatus());
			model.setCreatedAt(getCreatedAt());
			model.setUpdatedAt(getUpdatedAt());
			model.setOrgName(HtmlUtil.escape(getOrgName()));

			model = (LmisViewOvertimeReport)Proxy.newProxyInstance(LmisViewOvertimeReport.class.getClassLoader(),
					new Class[] { LmisViewOvertimeReport.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisViewOvertimeReportClp clone = new LmisViewOvertimeReportClp();

		clone.setLmisViewOvertimeReportId(getLmisViewOvertimeReportId());
		clone.setRootId(getRootId());
		clone.setOrgId(getOrgId());
		clone.setRequestId(getRequestId());
		clone.setReportedBy(getReportedBy());
		clone.setReportedAt(getReportedAt());
		clone.setReportedReason(getReportedReason());
		clone.setReportedStatus(getReportedStatus());
		clone.setCreatedAt(getCreatedAt());
		clone.setUpdatedAt(getUpdatedAt());
		clone.setOrgName(getOrgName());

		return clone;
	}

	public int compareTo(LmisViewOvertimeReport lmisViewOvertimeReport) {
		int value = 0;

		if (getReportedStatus() < lmisViewOvertimeReport.getReportedStatus()) {
			value = -1;
		}
		else if (getReportedStatus() > lmisViewOvertimeReport.getReportedStatus()) {
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

		LmisViewOvertimeReportClp lmisViewOvertimeReport = null;

		try {
			lmisViewOvertimeReport = (LmisViewOvertimeReportClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisViewOvertimeReport.getPrimaryKey();

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

		sb.append("{lmisViewOvertimeReportId=");
		sb.append(getLmisViewOvertimeReportId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", orgId=");
		sb.append(getOrgId());
		sb.append(", requestId=");
		sb.append(getRequestId());
		sb.append(", reportedBy=");
		sb.append(getReportedBy());
		sb.append(", reportedAt=");
		sb.append(getReportedAt());
		sb.append(", reportedReason=");
		sb.append(getReportedReason());
		sb.append(", reportedStatus=");
		sb.append(getReportedStatus());
		sb.append(", createdAt=");
		sb.append(getCreatedAt());
		sb.append(", updatedAt=");
		sb.append(getUpdatedAt());
		sb.append(", orgName=");
		sb.append(getOrgName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisViewOvertimeReport");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisViewOvertimeReportId</column-name><column-value><![CDATA[");
		sb.append(getLmisViewOvertimeReportId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgId</column-name><column-value><![CDATA[");
		sb.append(getOrgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requestId</column-name><column-value><![CDATA[");
		sb.append(getRequestId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reportedBy</column-name><column-value><![CDATA[");
		sb.append(getReportedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reportedAt</column-name><column-value><![CDATA[");
		sb.append(getReportedAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reportedReason</column-name><column-value><![CDATA[");
		sb.append(getReportedReason());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reportedStatus</column-name><column-value><![CDATA[");
		sb.append(getReportedStatus());
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
			"<column><column-name>orgName</column-name><column-value><![CDATA[");
		sb.append(getOrgName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisViewOvertimeReportId;
	private int _rootId;
	private int _orgId;
	private int _requestId;
	private int _reportedBy;
	private Date _reportedAt;
	private String _reportedReason;
	private int _reportedStatus;
	private Date _createdAt;
	private Date _updatedAt;
	private String _orgName;
}