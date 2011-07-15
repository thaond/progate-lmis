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
 * <a href="LmisViewOvertimeReportDetailClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewOvertimeReportDetailClp extends BaseModelImpl<LmisViewOvertimeReportDetail>
	implements LmisViewOvertimeReportDetail {
	public LmisViewOvertimeReportDetailClp() {
	}

	public Integer getPrimaryKey() {
		return _lmisViewReportOvertimeId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisViewReportOvertimeId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisViewReportOvertimeId;
	}

	public Integer getLmisViewReportOvertimeId() {
		return _lmisViewReportOvertimeId;
	}

	public void setLmisViewReportOvertimeId(Integer lmisViewReportOvertimeId) {
		_lmisViewReportOvertimeId = lmisViewReportOvertimeId;
	}

	public int getOtRepId() {
		return _otRepId;
	}

	public void setOtRepId(int otRepId) {
		_otRepId = otRepId;
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

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public double getTotalHour() {
		return _totalHour;
	}

	public void setTotalHour(double totalHour) {
		_totalHour = totalHour;
	}

	public Date getStartTime() {
		return _startTime;
	}

	public void setStartTime(Date startTime) {
		_startTime = startTime;
	}

	public Date getEndTime() {
		return _endTime;
	}

	public void setEndTime(Date endTime) {
		_endTime = endTime;
	}

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public double getReqRequestedHour() {
		return _reqRequestedHour;
	}

	public void setReqRequestedHour(double reqRequestedHour) {
		_reqRequestedHour = reqRequestedHour;
	}

	public Date getReqStartTime() {
		return _reqStartTime;
	}

	public void setReqStartTime(Date reqStartTime) {
		_reqStartTime = reqStartTime;
	}

	public Date getReqEndTime() {
		return _reqEndTime;
	}

	public void setReqEndTime(Date reqEndTime) {
		_reqEndTime = reqEndTime;
	}

	public LmisViewOvertimeReportDetail toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			LmisViewOvertimeReportDetail model = new LmisViewOvertimeReportDetailClp();

			model.setEscapedModel(true);

			model.setLmisViewReportOvertimeId(getLmisViewReportOvertimeId());
			model.setOtRepId(getOtRepId());
			model.setRootId(getRootId());
			model.setOrgId(getOrgId());
			model.setRequestId(getRequestId());
			model.setReportedBy(getReportedBy());
			model.setReportedAt(getReportedAt());
			model.setReportedReason(HtmlUtil.escape(getReportedReason()));
			model.setReportedStatus(getReportedStatus());
			model.setCreatedAt(getCreatedAt());
			model.setUpdatedAt(getUpdatedAt());
			model.setUserId(getUserId());
			model.setTotalHour(getTotalHour());
			model.setStartTime(getStartTime());
			model.setEndTime(getEndTime());
			model.setFullName(HtmlUtil.escape(getFullName()));
			model.setReqRequestedHour(getReqRequestedHour());
			model.setReqStartTime(getReqStartTime());
			model.setReqEndTime(getReqEndTime());

			model = (LmisViewOvertimeReportDetail)Proxy.newProxyInstance(LmisViewOvertimeReportDetail.class.getClassLoader(),
					new Class[] { LmisViewOvertimeReportDetail.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisViewOvertimeReportDetailClp clone = new LmisViewOvertimeReportDetailClp();

		clone.setLmisViewReportOvertimeId(getLmisViewReportOvertimeId());
		clone.setOtRepId(getOtRepId());
		clone.setRootId(getRootId());
		clone.setOrgId(getOrgId());
		clone.setRequestId(getRequestId());
		clone.setReportedBy(getReportedBy());
		clone.setReportedAt(getReportedAt());
		clone.setReportedReason(getReportedReason());
		clone.setReportedStatus(getReportedStatus());
		clone.setCreatedAt(getCreatedAt());
		clone.setUpdatedAt(getUpdatedAt());
		clone.setUserId(getUserId());
		clone.setTotalHour(getTotalHour());
		clone.setStartTime(getStartTime());
		clone.setEndTime(getEndTime());
		clone.setFullName(getFullName());
		clone.setReqRequestedHour(getReqRequestedHour());
		clone.setReqStartTime(getReqStartTime());
		clone.setReqEndTime(getReqEndTime());

		return clone;
	}

	public int compareTo(
		LmisViewOvertimeReportDetail lmisViewOvertimeReportDetail) {
		int value = 0;

		if (getReportedStatus() < lmisViewOvertimeReportDetail.getReportedStatus()) {
			value = -1;
		}
		else if (getReportedStatus() > lmisViewOvertimeReportDetail.getReportedStatus()) {
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

		LmisViewOvertimeReportDetailClp lmisViewOvertimeReportDetail = null;

		try {
			lmisViewOvertimeReportDetail = (LmisViewOvertimeReportDetailClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisViewOvertimeReportDetail.getPrimaryKey();

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

		sb.append("{lmisViewReportOvertimeId=");
		sb.append(getLmisViewReportOvertimeId());
		sb.append(", otRepId=");
		sb.append(getOtRepId());
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
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", totalHour=");
		sb.append(getTotalHour());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append(", fullName=");
		sb.append(getFullName());
		sb.append(", reqRequestedHour=");
		sb.append(getReqRequestedHour());
		sb.append(", reqStartTime=");
		sb.append(getReqStartTime());
		sb.append(", reqEndTime=");
		sb.append(getReqEndTime());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisViewOvertimeReportDetail");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisViewReportOvertimeId</column-name><column-value><![CDATA[");
		sb.append(getLmisViewReportOvertimeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>otRepId</column-name><column-value><![CDATA[");
		sb.append(getOtRepId());
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
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalHour</column-name><column-value><![CDATA[");
		sb.append(getTotalHour());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startTime</column-name><column-value><![CDATA[");
		sb.append(getStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endTime</column-name><column-value><![CDATA[");
		sb.append(getEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fullName</column-name><column-value><![CDATA[");
		sb.append(getFullName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reqRequestedHour</column-name><column-value><![CDATA[");
		sb.append(getReqRequestedHour());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reqStartTime</column-name><column-value><![CDATA[");
		sb.append(getReqStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reqEndTime</column-name><column-value><![CDATA[");
		sb.append(getReqEndTime());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisViewReportOvertimeId;
	private int _otRepId;
	private int _rootId;
	private int _orgId;
	private int _requestId;
	private int _reportedBy;
	private Date _reportedAt;
	private String _reportedReason;
	private int _reportedStatus;
	private Date _createdAt;
	private Date _updatedAt;
	private int _userId;
	private double _totalHour;
	private Date _startTime;
	private Date _endTime;
	private String _fullName;
	private double _reqRequestedHour;
	private Date _reqStartTime;
	private Date _reqEndTime;
}