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

import larion.progate.lmis.model.LmisOverTimeReports;
import larion.progate.lmis.model.LmisOverTimeReportsSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisOverTimeReportsModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOverTimeReportsModelImpl extends BaseModelImpl<LmisOverTimeReports> {
	public static final String TABLE_NAME = "lmis_overtime_reports";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "reported_by", new Integer(Types.INTEGER) },
			

			{ "reported_at", new Integer(Types.TIMESTAMP) },
			

			{ "reported_reason", new Integer(Types.VARCHAR) },
			

			{ "reported_status", new Integer(Types.INTEGER) },
			

			{ "created_at", new Integer(Types.TIMESTAMP) },
			

			{ "updated_at", new Integer(Types.TIMESTAMP) },
			

			{ "request_id", new Integer(Types.INTEGER) },
			

			{ "org_id", new Integer(Types.INTEGER) }
		};
	public static final String TABLE_SQL_CREATE = "create table lmis_overtime_reports (id INTEGER not null primary key,root_id INTEGER,reported_by INTEGER,reported_at DATE null,reported_reason VARCHAR(75) null,reported_status INTEGER,created_at DATE null,updated_at DATE null,request_id INTEGER,org_id INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table lmis_overtime_reports";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.lmis.model.LmisOverTimeReports"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.lmis.model.LmisOverTimeReports"),
			false);

	public static LmisOverTimeReports toModel(LmisOverTimeReportsSoap soapModel) {
		LmisOverTimeReports model = new LmisOverTimeReportsImpl();

		model.setLmisOverTimeReportsId(soapModel.getLmisOverTimeReportsId());
		model.setRootId(soapModel.getRootId());
		model.setReportedBy(soapModel.getReportedBy());
		model.setReportedAt(soapModel.getReportedAt());
		model.setReportedReason(soapModel.getReportedReason());
		model.setReportedStatus(soapModel.getReportedStatus());
		model.setCreatedAt(soapModel.getCreatedAt());
		model.setUpdatedAt(soapModel.getUpdatedAt());
		model.setRequestId(soapModel.getRequestId());
		model.setOrgId(soapModel.getOrgId());

		return model;
	}

	public static List<LmisOverTimeReports> toModels(
		LmisOverTimeReportsSoap[] soapModels) {
		List<LmisOverTimeReports> models = new ArrayList<LmisOverTimeReports>(soapModels.length);

		for (LmisOverTimeReportsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.lmis.model.LmisOverTimeReports"));

	public LmisOverTimeReportsModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _lmisOverTimeReportsId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisOverTimeReportsId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisOverTimeReportsId;
	}

	public Integer getLmisOverTimeReportsId() {
		return _lmisOverTimeReportsId;
	}

	public void setLmisOverTimeReportsId(Integer lmisOverTimeReportsId) {
		_lmisOverTimeReportsId = lmisOverTimeReportsId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
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

	public int getRequestId() {
		return _requestId;
	}

	public void setRequestId(int requestId) {
		_requestId = requestId;
	}

	public int getOrgId() {
		return _orgId;
	}

	public void setOrgId(int orgId) {
		_orgId = orgId;
	}

	public LmisOverTimeReports toEscapedModel() {
		if (isEscapedModel()) {
			return (LmisOverTimeReports)this;
		}
		else {
			LmisOverTimeReports model = new LmisOverTimeReportsImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setLmisOverTimeReportsId(getLmisOverTimeReportsId());
			model.setRootId(getRootId());
			model.setReportedBy(getReportedBy());
			model.setReportedAt(getReportedAt());
			model.setReportedReason(HtmlUtil.escape(getReportedReason()));
			model.setReportedStatus(getReportedStatus());
			model.setCreatedAt(getCreatedAt());
			model.setUpdatedAt(getUpdatedAt());
			model.setRequestId(getRequestId());
			model.setOrgId(getOrgId());

			model = (LmisOverTimeReports)Proxy.newProxyInstance(LmisOverTimeReports.class.getClassLoader(),
					new Class[] { LmisOverTimeReports.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisOverTimeReportsImpl clone = new LmisOverTimeReportsImpl();

		clone.setLmisOverTimeReportsId(getLmisOverTimeReportsId());
		clone.setRootId(getRootId());
		clone.setReportedBy(getReportedBy());
		clone.setReportedAt(getReportedAt());
		clone.setReportedReason(getReportedReason());
		clone.setReportedStatus(getReportedStatus());
		clone.setCreatedAt(getCreatedAt());
		clone.setUpdatedAt(getUpdatedAt());
		clone.setRequestId(getRequestId());
		clone.setOrgId(getOrgId());

		return clone;
	}

	public int compareTo(LmisOverTimeReports lmisOverTimeReports) {
		Integer pk = lmisOverTimeReports.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisOverTimeReports lmisOverTimeReports = null;

		try {
			lmisOverTimeReports = (LmisOverTimeReports)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisOverTimeReports.getPrimaryKey();

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

		sb.append("{lmisOverTimeReportsId=");
		sb.append(getLmisOverTimeReportsId());
		sb.append(", rootId=");
		sb.append(getRootId());
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
		sb.append(", requestId=");
		sb.append(getRequestId());
		sb.append(", orgId=");
		sb.append(getOrgId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisOverTimeReports");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisOverTimeReportsId</column-name><column-value><![CDATA[");
		sb.append(getLmisOverTimeReportsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
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
			"<column><column-name>requestId</column-name><column-value><![CDATA[");
		sb.append(getRequestId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgId</column-name><column-value><![CDATA[");
		sb.append(getOrgId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisOverTimeReportsId;
	private int _rootId;
	private int _reportedBy;
	private Date _reportedAt;
	private String _reportedReason;
	private int _reportedStatus;
	private Date _createdAt;
	private Date _updatedAt;
	private int _requestId;
	private int _orgId;
}