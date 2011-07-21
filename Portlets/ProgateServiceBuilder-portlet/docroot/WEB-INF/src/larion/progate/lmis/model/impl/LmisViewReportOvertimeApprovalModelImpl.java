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

import larion.progate.lmis.model.LmisViewReportOvertimeApproval;
import larion.progate.lmis.model.LmisViewReportOvertimeApprovalSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisViewReportOvertimeApprovalModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewReportOvertimeApprovalModelImpl extends BaseModelImpl<LmisViewReportOvertimeApproval> {
	public static final String TABLE_NAME = "vw_report_overtime_approval";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "org_id", new Integer(Types.INTEGER) },
			

			{ "request_id", new Integer(Types.INTEGER) },
			

			{ "reported_by", new Integer(Types.INTEGER) },
			

			{ "reported_at", new Integer(Types.TIMESTAMP) },
			

			{ "reported_reason", new Integer(Types.VARCHAR) },
			

			{ "reported_status", new Integer(Types.INTEGER) },
			

			{ "created_at", new Integer(Types.TIMESTAMP) },
			

			{ "updated_at", new Integer(Types.TIMESTAMP) },
			

			{ "org_name", new Integer(Types.VARCHAR) },
			

			{ "full_name", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table vw_report_overtime_approval (id INTEGER not null primary key,root_id INTEGER,org_id INTEGER,request_id INTEGER,reported_by INTEGER,reported_at DATE null,reported_reason VARCHAR(75) null,reported_status INTEGER,created_at DATE null,updated_at DATE null,org_name VARCHAR(75) null,full_name VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table vw_report_overtime_approval";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.lmis.model.LmisViewReportOvertimeApproval"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.lmis.model.LmisViewReportOvertimeApproval"),
			false);

	public static LmisViewReportOvertimeApproval toModel(
		LmisViewReportOvertimeApprovalSoap soapModel) {
		LmisViewReportOvertimeApproval model = new LmisViewReportOvertimeApprovalImpl();

		model.setLmisViewReportOvertimeApprovalId(soapModel.getLmisViewReportOvertimeApprovalId());
		model.setRootId(soapModel.getRootId());
		model.setOrgId(soapModel.getOrgId());
		model.setRequestId(soapModel.getRequestId());
		model.setReportedBy(soapModel.getReportedBy());
		model.setReportedAt(soapModel.getReportedAt());
		model.setReportedReason(soapModel.getReportedReason());
		model.setReportedStatus(soapModel.getReportedStatus());
		model.setCreatedAt(soapModel.getCreatedAt());
		model.setUpdatedAt(soapModel.getUpdatedAt());
		model.setOrgName(soapModel.getOrgName());
		model.setFullName(soapModel.getFullName());

		return model;
	}

	public static List<LmisViewReportOvertimeApproval> toModels(
		LmisViewReportOvertimeApprovalSoap[] soapModels) {
		List<LmisViewReportOvertimeApproval> models = new ArrayList<LmisViewReportOvertimeApproval>(soapModels.length);

		for (LmisViewReportOvertimeApprovalSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.lmis.model.LmisViewReportOvertimeApproval"));

	public LmisViewReportOvertimeApprovalModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _lmisViewReportOvertimeApprovalId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisViewReportOvertimeApprovalId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisViewReportOvertimeApprovalId;
	}

	public Integer getLmisViewReportOvertimeApprovalId() {
		return _lmisViewReportOvertimeApprovalId;
	}

	public void setLmisViewReportOvertimeApprovalId(
		Integer lmisViewReportOvertimeApprovalId) {
		_lmisViewReportOvertimeApprovalId = lmisViewReportOvertimeApprovalId;
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

	public LmisViewReportOvertimeApproval toEscapedModel() {
		if (isEscapedModel()) {
			return (LmisViewReportOvertimeApproval)this;
		}
		else {
			LmisViewReportOvertimeApproval model = new LmisViewReportOvertimeApprovalImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setLmisViewReportOvertimeApprovalId(getLmisViewReportOvertimeApprovalId());
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
			model.setFullName(HtmlUtil.escape(getFullName()));

			model = (LmisViewReportOvertimeApproval)Proxy.newProxyInstance(LmisViewReportOvertimeApproval.class.getClassLoader(),
					new Class[] { LmisViewReportOvertimeApproval.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisViewReportOvertimeApprovalImpl clone = new LmisViewReportOvertimeApprovalImpl();

		clone.setLmisViewReportOvertimeApprovalId(getLmisViewReportOvertimeApprovalId());
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
		clone.setFullName(getFullName());

		return clone;
	}

	public int compareTo(
		LmisViewReportOvertimeApproval lmisViewReportOvertimeApproval) {
		int value = 0;

		if (getReportedStatus() < lmisViewReportOvertimeApproval.getReportedStatus()) {
			value = -1;
		}
		else if (getReportedStatus() > lmisViewReportOvertimeApproval.getReportedStatus()) {
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

		LmisViewReportOvertimeApproval lmisViewReportOvertimeApproval = null;

		try {
			lmisViewReportOvertimeApproval = (LmisViewReportOvertimeApproval)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisViewReportOvertimeApproval.getPrimaryKey();

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

		sb.append("{lmisViewReportOvertimeApprovalId=");
		sb.append(getLmisViewReportOvertimeApprovalId());
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
		sb.append(", fullName=");
		sb.append(getFullName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisViewReportOvertimeApproval");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisViewReportOvertimeApprovalId</column-name><column-value><![CDATA[");
		sb.append(getLmisViewReportOvertimeApprovalId());
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
		sb.append(
			"<column><column-name>fullName</column-name><column-value><![CDATA[");
		sb.append(getFullName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisViewReportOvertimeApprovalId;
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
	private String _fullName;
}