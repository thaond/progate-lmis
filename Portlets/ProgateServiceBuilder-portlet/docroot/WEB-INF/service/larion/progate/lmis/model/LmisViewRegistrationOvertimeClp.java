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
 * <a href="LmisViewRegistrationOvertimeClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewRegistrationOvertimeClp extends BaseModelImpl<LmisViewRegistrationOvertime>
	implements LmisViewRegistrationOvertime {
	public LmisViewRegistrationOvertimeClp() {
	}

	public Integer getPrimaryKey() {
		return _lmisViewRegistrationOvertimeId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisViewRegistrationOvertimeId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisViewRegistrationOvertimeId;
	}

	public Integer getLmisViewRegistrationOvertimeId() {
		return _lmisViewRegistrationOvertimeId;
	}

	public void setLmisViewRegistrationOvertimeId(
		Integer lmisViewRegistrationOvertimeId) {
		_lmisViewRegistrationOvertimeId = lmisViewRegistrationOvertimeId;
	}

	public int getOtReqsId() {
		return _otReqsId;
	}

	public void setOtReqsId(int otReqsId) {
		_otReqsId = otReqsId;
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

	public int getRequestId() {
		return _requestId;
	}

	public void setRequestId(int requestId) {
		_requestId = requestId;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
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

	public String getReasonDetail() {
		return _reasonDetail;
	}

	public void setReasonDetail(String reasonDetail) {
		_reasonDetail = reasonDetail;
	}

	public double getRequestedHour() {
		return _requestedHour;
	}

	public void setRequestedHour(double requestedHour) {
		_requestedHour = requestedHour;
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

	public String getReaSon() {
		return _reaSon;
	}

	public void setReaSon(String reaSon) {
		_reaSon = reaSon;
	}

	public String getOrgName() {
		return _orgName;
	}

	public void setOrgName(String orgName) {
		_orgName = orgName;
	}

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getMiddleName() {
		return _middleName;
	}

	public void setMiddleName(String middleName) {
		_middleName = middleName;
	}

	public String getLastName() {
		return _LastName;
	}

	public void setLastName(String LastName) {
		_LastName = LastName;
	}

	public String getReqFirstName() {
		return _reqFirstName;
	}

	public void setReqFirstName(String reqFirstName) {
		_reqFirstName = reqFirstName;
	}

	public String getReqMiddleName() {
		return _reqMiddleName;
	}

	public void setReqMiddleName(String reqMiddleName) {
		_reqMiddleName = reqMiddleName;
	}

	public String getReqLastName() {
		return _reqLastName;
	}

	public void setReqLastName(String reqLastName) {
		_reqLastName = reqLastName;
	}

	public LmisViewRegistrationOvertime toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			LmisViewRegistrationOvertime model = new LmisViewRegistrationOvertimeClp();

			model.setEscapedModel(true);

			model.setLmisViewRegistrationOvertimeId(getLmisViewRegistrationOvertimeId());
			model.setOtReqsId(getOtReqsId());
			model.setRootId(getRootId());
			model.setRequestedBy(getRequestedBy());
			model.setRequestedAt(getRequestedAt());
			model.setRequestedReason(HtmlUtil.escape(getRequestedReason()));
			model.setRequestedStatus(getRequestedStatus());
			model.setCreatedAt(getCreatedAt());
			model.setUpdatedAt(getUpdatedAt());
			model.setOrgId(getOrgId());
			model.setRequestId(getRequestId());
			model.setUserId(getUserId());
			model.setStartTime(getStartTime());
			model.setEndTime(getEndTime());
			model.setReasonDetail(HtmlUtil.escape(getReasonDetail()));
			model.setRequestedHour(getRequestedHour());
			model.setApprovedBy(getApprovedBy());
			model.setApprovedAt(getApprovedAt());
			model.setIsApproved(getIsApproved());
			model.setApprovedStatus(getApprovedStatus());
			model.setReaSon(HtmlUtil.escape(getReaSon()));
			model.setOrgName(HtmlUtil.escape(getOrgName()));
			model.setFullName(HtmlUtil.escape(getFullName()));
			model.setFirstName(HtmlUtil.escape(getFirstName()));
			model.setMiddleName(HtmlUtil.escape(getMiddleName()));
			model.setLastName(HtmlUtil.escape(getLastName()));
			model.setReqFirstName(HtmlUtil.escape(getReqFirstName()));
			model.setReqMiddleName(HtmlUtil.escape(getReqMiddleName()));
			model.setReqLastName(HtmlUtil.escape(getReqLastName()));

			model = (LmisViewRegistrationOvertime)Proxy.newProxyInstance(LmisViewRegistrationOvertime.class.getClassLoader(),
					new Class[] { LmisViewRegistrationOvertime.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisViewRegistrationOvertimeClp clone = new LmisViewRegistrationOvertimeClp();

		clone.setLmisViewRegistrationOvertimeId(getLmisViewRegistrationOvertimeId());
		clone.setOtReqsId(getOtReqsId());
		clone.setRootId(getRootId());
		clone.setRequestedBy(getRequestedBy());
		clone.setRequestedAt(getRequestedAt());
		clone.setRequestedReason(getRequestedReason());
		clone.setRequestedStatus(getRequestedStatus());
		clone.setCreatedAt(getCreatedAt());
		clone.setUpdatedAt(getUpdatedAt());
		clone.setOrgId(getOrgId());
		clone.setRequestId(getRequestId());
		clone.setUserId(getUserId());
		clone.setStartTime(getStartTime());
		clone.setEndTime(getEndTime());
		clone.setReasonDetail(getReasonDetail());
		clone.setRequestedHour(getRequestedHour());
		clone.setApprovedBy(getApprovedBy());
		clone.setApprovedAt(getApprovedAt());
		clone.setIsApproved(getIsApproved());
		clone.setApprovedStatus(getApprovedStatus());
		clone.setReaSon(getReaSon());
		clone.setOrgName(getOrgName());
		clone.setFullName(getFullName());
		clone.setFirstName(getFirstName());
		clone.setMiddleName(getMiddleName());
		clone.setLastName(getLastName());
		clone.setReqFirstName(getReqFirstName());
		clone.setReqMiddleName(getReqMiddleName());
		clone.setReqLastName(getReqLastName());

		return clone;
	}

	public int compareTo(
		LmisViewRegistrationOvertime lmisViewRegistrationOvertime) {
		int value = 0;

		if (getRequestedStatus() < lmisViewRegistrationOvertime.getRequestedStatus()) {
			value = -1;
		}
		else if (getRequestedStatus() > lmisViewRegistrationOvertime.getRequestedStatus()) {
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

		LmisViewRegistrationOvertimeClp lmisViewRegistrationOvertime = null;

		try {
			lmisViewRegistrationOvertime = (LmisViewRegistrationOvertimeClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisViewRegistrationOvertime.getPrimaryKey();

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

		sb.append("{lmisViewRegistrationOvertimeId=");
		sb.append(getLmisViewRegistrationOvertimeId());
		sb.append(", otReqsId=");
		sb.append(getOtReqsId());
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
		sb.append(", requestId=");
		sb.append(getRequestId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append(", reasonDetail=");
		sb.append(getReasonDetail());
		sb.append(", requestedHour=");
		sb.append(getRequestedHour());
		sb.append(", approvedBy=");
		sb.append(getApprovedBy());
		sb.append(", approvedAt=");
		sb.append(getApprovedAt());
		sb.append(", isApproved=");
		sb.append(getIsApproved());
		sb.append(", approvedStatus=");
		sb.append(getApprovedStatus());
		sb.append(", reaSon=");
		sb.append(getReaSon());
		sb.append(", orgName=");
		sb.append(getOrgName());
		sb.append(", fullName=");
		sb.append(getFullName());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", middleName=");
		sb.append(getMiddleName());
		sb.append(", LastName=");
		sb.append(getLastName());
		sb.append(", reqFirstName=");
		sb.append(getReqFirstName());
		sb.append(", reqMiddleName=");
		sb.append(getReqMiddleName());
		sb.append(", reqLastName=");
		sb.append(getReqLastName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisViewRegistrationOvertime");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisViewRegistrationOvertimeId</column-name><column-value><![CDATA[");
		sb.append(getLmisViewRegistrationOvertimeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>otReqsId</column-name><column-value><![CDATA[");
		sb.append(getOtReqsId());
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
			"<column><column-name>requestId</column-name><column-value><![CDATA[");
		sb.append(getRequestId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
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
			"<column><column-name>reasonDetail</column-name><column-value><![CDATA[");
		sb.append(getReasonDetail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requestedHour</column-name><column-value><![CDATA[");
		sb.append(getRequestedHour());
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
			"<column><column-name>reaSon</column-name><column-value><![CDATA[");
		sb.append(getReaSon());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgName</column-name><column-value><![CDATA[");
		sb.append(getOrgName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fullName</column-name><column-value><![CDATA[");
		sb.append(getFullName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>middleName</column-name><column-value><![CDATA[");
		sb.append(getMiddleName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>LastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reqFirstName</column-name><column-value><![CDATA[");
		sb.append(getReqFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reqMiddleName</column-name><column-value><![CDATA[");
		sb.append(getReqMiddleName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reqLastName</column-name><column-value><![CDATA[");
		sb.append(getReqLastName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisViewRegistrationOvertimeId;
	private int _otReqsId;
	private int _rootId;
	private int _requestedBy;
	private Date _requestedAt;
	private String _requestedReason;
	private int _requestedStatus;
	private Date _createdAt;
	private Date _updatedAt;
	private int _orgId;
	private int _requestId;
	private int _userId;
	private Date _startTime;
	private Date _endTime;
	private String _reasonDetail;
	private double _requestedHour;
	private int _approvedBy;
	private Date _approvedAt;
	private boolean _isApproved;
	private boolean _approvedStatus;
	private String _reaSon;
	private String _orgName;
	private String _fullName;
	private String _firstName;
	private String _middleName;
	private String _LastName;
	private String _reqFirstName;
	private String _reqMiddleName;
	private String _reqLastName;
}