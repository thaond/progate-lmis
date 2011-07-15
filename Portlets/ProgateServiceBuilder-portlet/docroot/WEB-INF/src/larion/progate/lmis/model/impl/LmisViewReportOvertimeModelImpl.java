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

package larion.progate.lmis.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import larion.progate.lmis.model.LmisViewReportOvertime;
import larion.progate.lmis.model.LmisViewReportOvertimeSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisViewReportOvertimeModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewReportOvertimeModelImpl extends BaseModelImpl<LmisViewReportOvertime> {
	public static final String TABLE_NAME = "vw_report_overtime";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "ot_rep_id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "org_id", new Integer(Types.INTEGER) },
			

			{ "request_id", new Integer(Types.INTEGER) },
			

			{ "reported_by", new Integer(Types.INTEGER) },
			

			{ "reported_at", new Integer(Types.TIMESTAMP) },
			

			{ "reported_reason", new Integer(Types.VARCHAR) },
			

			{ "reported_status", new Integer(Types.INTEGER) },
			

			{ "created_at", new Integer(Types.TIMESTAMP) },
			

			{ "updated_at", new Integer(Types.TIMESTAMP) },
			

			{ "report_id", new Integer(Types.INTEGER) },
			

			{ "user_id", new Integer(Types.INTEGER) },
			

			{ "total_hour", new Integer(Types.DOUBLE) },
			

			{ "start_time", new Integer(Types.TIMESTAMP) },
			

			{ "end_time", new Integer(Types.TIMESTAMP) },
			

			{ "detail_id", new Integer(Types.INTEGER) },
			

			{ "ot_type", new Integer(Types.VARCHAR) },
			

			{ "ot_hour", new Integer(Types.DOUBLE) },
			

			{ "ot_coefficient", new Integer(Types.DOUBLE) },
			

			{ "ot_id", new Integer(Types.INTEGER) },
			

			{ "org_name", new Integer(Types.VARCHAR) },
			

			{ "full_name", new Integer(Types.VARCHAR) },
			

			{ "first_name", new Integer(Types.VARCHAR) },
			

			{ "middle_name", new Integer(Types.VARCHAR) },
			

			{ "last_name", new Integer(Types.VARCHAR) },
			

			{ "rep_first_name", new Integer(Types.VARCHAR) },
			

			{ "rep_last_name", new Integer(Types.VARCHAR) },
			

			{ "rep_middle_name", new Integer(Types.VARCHAR) },
			

			{ "reg_requested_hour", new Integer(Types.DOUBLE) },
			

			{ "reg_start_time", new Integer(Types.TIMESTAMP) },
			

			{ "reg_end_time", new Integer(Types.TIMESTAMP) }
		};
	public static final String TABLE_SQL_CREATE = "create table vw_report_overtime (id INTEGER not null primary key,ot_rep_id INTEGER,root_id INTEGER,org_id INTEGER,request_id INTEGER,reported_by INTEGER,reported_at DATE null,reported_reason VARCHAR(75) null,reported_status INTEGER,created_at DATE null,updated_at DATE null,report_id INTEGER,user_id INTEGER,total_hour DOUBLE,start_time DATE null,end_time DATE null,detail_id INTEGER,ot_type VARCHAR(75) null,ot_hour DOUBLE,ot_coefficient DOUBLE,ot_id INTEGER,org_name VARCHAR(75) null,full_name VARCHAR(75) null,first_name VARCHAR(75) null,middle_name VARCHAR(75) null,last_name VARCHAR(75) null,rep_first_name VARCHAR(75) null,rep_last_name VARCHAR(75) null,rep_middle_name VARCHAR(75) null,reg_requested_hour DOUBLE,reg_start_time DATE null,reg_end_time DATE null)";
	public static final String TABLE_SQL_DROP = "drop table vw_report_overtime";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.lmis.model.LmisViewReportOvertime"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.lmis.model.LmisViewReportOvertime"),
			false);

	public static LmisViewReportOvertime toModel(
		LmisViewReportOvertimeSoap soapModel) {
		LmisViewReportOvertime model = new LmisViewReportOvertimeImpl();

		model.setLmisViewReportOvertimeId(soapModel.getLmisViewReportOvertimeId());
		model.setOtRepId(soapModel.getOtRepId());
		model.setRootId(soapModel.getRootId());
		model.setOrgId(soapModel.getOrgId());
		model.setRequestId(soapModel.getRequestId());
		model.setReportedBy(soapModel.getReportedBy());
		model.setReportedAt(soapModel.getReportedAt());
		model.setReportedReason(soapModel.getReportedReason());
		model.setReportedStatus(soapModel.getReportedStatus());
		model.setCreatedAt(soapModel.getCreatedAt());
		model.setUpdatedAt(soapModel.getUpdatedAt());
		model.setReportId(soapModel.getReportId());
		model.setUserId(soapModel.getUserId());
		model.setTotalHour(soapModel.getTotalHour());
		model.setStartTime(soapModel.getStartTime());
		model.setEndTime(soapModel.getEndTime());
		model.setDetailId(soapModel.getDetailId());
		model.setOtType(soapModel.getOtType());
		model.setOtHour(soapModel.getOtHour());
		model.setOtCoefficient(soapModel.getOtCoefficient());
		model.setOtId(soapModel.getOtId());
		model.setOrgName(soapModel.getOrgName());
		model.setFullName(soapModel.getFullName());
		model.setFirstName(soapModel.getFirstName());
		model.setMiddleName(soapModel.getMiddleName());
		model.setLastName(soapModel.getLastName());
		model.setRepFirstName(soapModel.getRepFirstName());
		model.setRepLastName(soapModel.getRepLastName());
		model.setRepMiddleName(soapModel.getRepMiddleName());
		model.setRegRequestedHour(soapModel.getRegRequestedHour());
		model.setRegStartTime(soapModel.getRegStartTime());
		model.setRegEndTime(soapModel.getRegEndTime());

		return model;
	}

	public static List<LmisViewReportOvertime> toModels(
		LmisViewReportOvertimeSoap[] soapModels) {
		List<LmisViewReportOvertime> models = new ArrayList<LmisViewReportOvertime>(soapModels.length);

		for (LmisViewReportOvertimeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.lmis.model.LmisViewReportOvertime"));

	public LmisViewReportOvertimeModelImpl() {
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
		return GetterUtil.getString(_reportedReason);
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

	public int getReportId() {
		return _reportId;
	}

	public void setReportId(int reportId) {
		_reportId = reportId;
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

	public int getDetailId() {
		return _detailId;
	}

	public void setDetailId(int detailId) {
		_detailId = detailId;
	}

	public String getOtType() {
		return GetterUtil.getString(_otType);
	}

	public void setOtType(String otType) {
		_otType = otType;
	}

	public double getOtHour() {
		return _otHour;
	}

	public void setOtHour(double otHour) {
		_otHour = otHour;
	}

	public double getOtCoefficient() {
		return _otCoefficient;
	}

	public void setOtCoefficient(double otCoefficient) {
		_otCoefficient = otCoefficient;
	}

	public int getOtId() {
		return _otId;
	}

	public void setOtId(int otId) {
		_otId = otId;
	}

	public String getOrgName() {
		return GetterUtil.getString(_orgName);
	}

	public void setOrgName(String orgName) {
		_orgName = orgName;
	}

	public String getFullName() {
		return GetterUtil.getString(_fullName);
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public String getFirstName() {
		return GetterUtil.getString(_firstName);
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getMiddleName() {
		return GetterUtil.getString(_middleName);
	}

	public void setMiddleName(String middleName) {
		_middleName = middleName;
	}

	public String getLastName() {
		return GetterUtil.getString(_LastName);
	}

	public void setLastName(String LastName) {
		_LastName = LastName;
	}

	public String getRepFirstName() {
		return GetterUtil.getString(_repFirstName);
	}

	public void setRepFirstName(String repFirstName) {
		_repFirstName = repFirstName;
	}

	public String getRepLastName() {
		return GetterUtil.getString(_repLastName);
	}

	public void setRepLastName(String repLastName) {
		_repLastName = repLastName;
	}

	public String getRepMiddleName() {
		return GetterUtil.getString(_repMiddleName);
	}

	public void setRepMiddleName(String repMiddleName) {
		_repMiddleName = repMiddleName;
	}

	public double getRegRequestedHour() {
		return _regRequestedHour;
	}

	public void setRegRequestedHour(double regRequestedHour) {
		_regRequestedHour = regRequestedHour;
	}

	public Date getRegStartTime() {
		return _regStartTime;
	}

	public void setRegStartTime(Date regStartTime) {
		_regStartTime = regStartTime;
	}

	public Date getRegEndTime() {
		return _regEndTime;
	}

	public void setRegEndTime(Date regEndTime) {
		_regEndTime = regEndTime;
	}

	public LmisViewReportOvertime toEscapedModel() {
		if (isEscapedModel()) {
			return (LmisViewReportOvertime)this;
		}
		else {
			LmisViewReportOvertime model = new LmisViewReportOvertimeImpl();

			model.setNew(isNew());
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
			model.setReportId(getReportId());
			model.setUserId(getUserId());
			model.setTotalHour(getTotalHour());
			model.setStartTime(getStartTime());
			model.setEndTime(getEndTime());
			model.setDetailId(getDetailId());
			model.setOtType(HtmlUtil.escape(getOtType()));
			model.setOtHour(getOtHour());
			model.setOtCoefficient(getOtCoefficient());
			model.setOtId(getOtId());
			model.setOrgName(HtmlUtil.escape(getOrgName()));
			model.setFullName(HtmlUtil.escape(getFullName()));
			model.setFirstName(HtmlUtil.escape(getFirstName()));
			model.setMiddleName(HtmlUtil.escape(getMiddleName()));
			model.setLastName(HtmlUtil.escape(getLastName()));
			model.setRepFirstName(HtmlUtil.escape(getRepFirstName()));
			model.setRepLastName(HtmlUtil.escape(getRepLastName()));
			model.setRepMiddleName(HtmlUtil.escape(getRepMiddleName()));
			model.setRegRequestedHour(getRegRequestedHour());
			model.setRegStartTime(getRegStartTime());
			model.setRegEndTime(getRegEndTime());

			model = (LmisViewReportOvertime)Proxy.newProxyInstance(LmisViewReportOvertime.class.getClassLoader(),
					new Class[] { LmisViewReportOvertime.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisViewReportOvertimeImpl clone = new LmisViewReportOvertimeImpl();

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
		clone.setReportId(getReportId());
		clone.setUserId(getUserId());
		clone.setTotalHour(getTotalHour());
		clone.setStartTime(getStartTime());
		clone.setEndTime(getEndTime());
		clone.setDetailId(getDetailId());
		clone.setOtType(getOtType());
		clone.setOtHour(getOtHour());
		clone.setOtCoefficient(getOtCoefficient());
		clone.setOtId(getOtId());
		clone.setOrgName(getOrgName());
		clone.setFullName(getFullName());
		clone.setFirstName(getFirstName());
		clone.setMiddleName(getMiddleName());
		clone.setLastName(getLastName());
		clone.setRepFirstName(getRepFirstName());
		clone.setRepLastName(getRepLastName());
		clone.setRepMiddleName(getRepMiddleName());
		clone.setRegRequestedHour(getRegRequestedHour());
		clone.setRegStartTime(getRegStartTime());
		clone.setRegEndTime(getRegEndTime());

		return clone;
	}

	public int compareTo(LmisViewReportOvertime lmisViewReportOvertime) {
		int value = 0;

		if (getReportedStatus() < lmisViewReportOvertime.getReportedStatus()) {
			value = -1;
		}
		else if (getReportedStatus() > lmisViewReportOvertime.getReportedStatus()) {
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

		LmisViewReportOvertime lmisViewReportOvertime = null;

		try {
			lmisViewReportOvertime = (LmisViewReportOvertime)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisViewReportOvertime.getPrimaryKey();

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
		sb.append(", reportId=");
		sb.append(getReportId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", totalHour=");
		sb.append(getTotalHour());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append(", detailId=");
		sb.append(getDetailId());
		sb.append(", otType=");
		sb.append(getOtType());
		sb.append(", otHour=");
		sb.append(getOtHour());
		sb.append(", otCoefficient=");
		sb.append(getOtCoefficient());
		sb.append(", otId=");
		sb.append(getOtId());
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
		sb.append(", repFirstName=");
		sb.append(getRepFirstName());
		sb.append(", repLastName=");
		sb.append(getRepLastName());
		sb.append(", repMiddleName=");
		sb.append(getRepMiddleName());
		sb.append(", regRequestedHour=");
		sb.append(getRegRequestedHour());
		sb.append(", regStartTime=");
		sb.append(getRegStartTime());
		sb.append(", regEndTime=");
		sb.append(getRegEndTime());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisViewReportOvertime");
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
			"<column><column-name>reportId</column-name><column-value><![CDATA[");
		sb.append(getReportId());
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
			"<column><column-name>detailId</column-name><column-value><![CDATA[");
		sb.append(getDetailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>otType</column-name><column-value><![CDATA[");
		sb.append(getOtType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>otHour</column-name><column-value><![CDATA[");
		sb.append(getOtHour());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>otCoefficient</column-name><column-value><![CDATA[");
		sb.append(getOtCoefficient());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>otId</column-name><column-value><![CDATA[");
		sb.append(getOtId());
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
			"<column><column-name>repFirstName</column-name><column-value><![CDATA[");
		sb.append(getRepFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>repLastName</column-name><column-value><![CDATA[");
		sb.append(getRepLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>repMiddleName</column-name><column-value><![CDATA[");
		sb.append(getRepMiddleName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regRequestedHour</column-name><column-value><![CDATA[");
		sb.append(getRegRequestedHour());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regStartTime</column-name><column-value><![CDATA[");
		sb.append(getRegStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regEndTime</column-name><column-value><![CDATA[");
		sb.append(getRegEndTime());
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
	private int _reportId;
	private int _userId;
	private double _totalHour;
	private Date _startTime;
	private Date _endTime;
	private int _detailId;
	private String _otType;
	private double _otHour;
	private double _otCoefficient;
	private int _otId;
	private String _orgName;
	private String _fullName;
	private String _firstName;
	private String _middleName;
	private String _LastName;
	private String _repFirstName;
	private String _repLastName;
	private String _repMiddleName;
	private double _regRequestedHour;
	private Date _regStartTime;
	private Date _regEndTime;
}