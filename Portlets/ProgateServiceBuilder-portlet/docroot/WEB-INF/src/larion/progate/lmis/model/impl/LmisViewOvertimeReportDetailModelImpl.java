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

import larion.progate.lmis.model.LmisViewOvertimeReportDetail;
import larion.progate.lmis.model.LmisViewOvertimeReportDetailSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisViewOvertimeReportDetailModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewOvertimeReportDetailModelImpl extends BaseModelImpl<LmisViewOvertimeReportDetail> {
	public static final String TABLE_NAME = "vw_overtime_report_detail";
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
			

			{ "user_id", new Integer(Types.INTEGER) },
			

			{ "total_hour", new Integer(Types.DOUBLE) },
			

			{ "start_time", new Integer(Types.TIMESTAMP) },
			

			{ "end_time", new Integer(Types.TIMESTAMP) },
			

			{ "full_name", new Integer(Types.VARCHAR) },
			

			{ "requested_hour", new Integer(Types.DOUBLE) },
			

			{ "req_start_time", new Integer(Types.TIMESTAMP) },
			

			{ "req_end_time", new Integer(Types.TIMESTAMP) }
		};
	public static final String TABLE_SQL_CREATE = "create table vw_overtime_report_detail (id INTEGER not null primary key,ot_rep_id INTEGER,root_id INTEGER,org_id INTEGER,request_id INTEGER,reported_by INTEGER,reported_at DATE null,reported_reason VARCHAR(75) null,reported_status INTEGER,created_at DATE null,updated_at DATE null,user_id INTEGER,total_hour DOUBLE,start_time DATE null,end_time DATE null,full_name VARCHAR(75) null,requested_hour DOUBLE,req_start_time DATE null,req_end_time DATE null)";
	public static final String TABLE_SQL_DROP = "drop table vw_overtime_report_detail";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.lmis.model.LmisViewOvertimeReportDetail"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.lmis.model.LmisViewOvertimeReportDetail"),
			false);

	public static LmisViewOvertimeReportDetail toModel(
		LmisViewOvertimeReportDetailSoap soapModel) {
		LmisViewOvertimeReportDetail model = new LmisViewOvertimeReportDetailImpl();

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
		model.setUserId(soapModel.getUserId());
		model.setTotalHour(soapModel.getTotalHour());
		model.setStartTime(soapModel.getStartTime());
		model.setEndTime(soapModel.getEndTime());
		model.setFullName(soapModel.getFullName());
		model.setReqRequestedHour(soapModel.getReqRequestedHour());
		model.setReqStartTime(soapModel.getReqStartTime());
		model.setReqEndTime(soapModel.getReqEndTime());

		return model;
	}

	public static List<LmisViewOvertimeReportDetail> toModels(
		LmisViewOvertimeReportDetailSoap[] soapModels) {
		List<LmisViewOvertimeReportDetail> models = new ArrayList<LmisViewOvertimeReportDetail>(soapModels.length);

		for (LmisViewOvertimeReportDetailSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.lmis.model.LmisViewOvertimeReportDetail"));

	public LmisViewOvertimeReportDetailModelImpl() {
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
		return GetterUtil.getString(_fullName);
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
			return (LmisViewOvertimeReportDetail)this;
		}
		else {
			LmisViewOvertimeReportDetail model = new LmisViewOvertimeReportDetailImpl();

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
		LmisViewOvertimeReportDetailImpl clone = new LmisViewOvertimeReportDetailImpl();

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

		LmisViewOvertimeReportDetail lmisViewOvertimeReportDetail = null;

		try {
			lmisViewOvertimeReportDetail = (LmisViewOvertimeReportDetail)obj;
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