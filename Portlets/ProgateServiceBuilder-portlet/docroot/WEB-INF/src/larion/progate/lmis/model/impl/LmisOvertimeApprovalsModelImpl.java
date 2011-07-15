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

import larion.progate.lmis.model.LmisOvertimeApprovals;
import larion.progate.lmis.model.LmisOvertimeApprovalsSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisOvertimeApprovalsModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOvertimeApprovalsModelImpl extends BaseModelImpl<LmisOvertimeApprovals> {
	public static final String TABLE_NAME = "lmis_overtime_approvals";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "request_id", new Integer(Types.INTEGER) },
			

			{ "report_id", new Integer(Types.INTEGER) },
			

			{ "approved_by", new Integer(Types.INTEGER) },
			

			{ "approved_at", new Integer(Types.TIMESTAMP) },
			

			{ "is_approved", new Integer(Types.BOOLEAN) },
			

			{ "approved_status", new Integer(Types.BOOLEAN) },
			

			{ "reason", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table lmis_overtime_approvals (id INTEGER not null primary key,root_id INTEGER,request_id INTEGER,report_id INTEGER,approved_by INTEGER,approved_at DATE null,is_approved BOOLEAN,approved_status BOOLEAN,reason VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table lmis_overtime_approvals";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.lmis.model.LmisOvertimeApprovals"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.lmis.model.LmisOvertimeApprovals"),
			false);

	public static LmisOvertimeApprovals toModel(
		LmisOvertimeApprovalsSoap soapModel) {
		LmisOvertimeApprovals model = new LmisOvertimeApprovalsImpl();

		model.setLmisOvertimeApprovalsId(soapModel.getLmisOvertimeApprovalsId());
		model.setRootId(soapModel.getRootId());
		model.setRequestId(soapModel.getRequestId());
		model.setReportId(soapModel.getReportId());
		model.setApprovedBy(soapModel.getApprovedBy());
		model.setApprovedAt(soapModel.getApprovedAt());
		model.setIsApproved(soapModel.getIsApproved());
		model.setApprovedStatus(soapModel.getApprovedStatus());
		model.setReaSon(soapModel.getReaSon());

		return model;
	}

	public static List<LmisOvertimeApprovals> toModels(
		LmisOvertimeApprovalsSoap[] soapModels) {
		List<LmisOvertimeApprovals> models = new ArrayList<LmisOvertimeApprovals>(soapModels.length);

		for (LmisOvertimeApprovalsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.lmis.model.LmisOvertimeApprovals"));

	public LmisOvertimeApprovalsModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _lmisOvertimeApprovalsId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisOvertimeApprovalsId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisOvertimeApprovalsId;
	}

	public Integer getLmisOvertimeApprovalsId() {
		return _lmisOvertimeApprovalsId;
	}

	public void setLmisOvertimeApprovalsId(Integer lmisOvertimeApprovalsId) {
		_lmisOvertimeApprovalsId = lmisOvertimeApprovalsId;
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

	public int getReportId() {
		return _reportId;
	}

	public void setReportId(int reportId) {
		_reportId = reportId;
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
		return GetterUtil.getString(_reaSon);
	}

	public void setReaSon(String reaSon) {
		_reaSon = reaSon;
	}

	public LmisOvertimeApprovals toEscapedModel() {
		if (isEscapedModel()) {
			return (LmisOvertimeApprovals)this;
		}
		else {
			LmisOvertimeApprovals model = new LmisOvertimeApprovalsImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setLmisOvertimeApprovalsId(getLmisOvertimeApprovalsId());
			model.setRootId(getRootId());
			model.setRequestId(getRequestId());
			model.setReportId(getReportId());
			model.setApprovedBy(getApprovedBy());
			model.setApprovedAt(getApprovedAt());
			model.setIsApproved(getIsApproved());
			model.setApprovedStatus(getApprovedStatus());
			model.setReaSon(HtmlUtil.escape(getReaSon()));

			model = (LmisOvertimeApprovals)Proxy.newProxyInstance(LmisOvertimeApprovals.class.getClassLoader(),
					new Class[] { LmisOvertimeApprovals.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisOvertimeApprovalsImpl clone = new LmisOvertimeApprovalsImpl();

		clone.setLmisOvertimeApprovalsId(getLmisOvertimeApprovalsId());
		clone.setRootId(getRootId());
		clone.setRequestId(getRequestId());
		clone.setReportId(getReportId());
		clone.setApprovedBy(getApprovedBy());
		clone.setApprovedAt(getApprovedAt());
		clone.setIsApproved(getIsApproved());
		clone.setApprovedStatus(getApprovedStatus());
		clone.setReaSon(getReaSon());

		return clone;
	}

	public int compareTo(LmisOvertimeApprovals lmisOvertimeApprovals) {
		int value = 0;

		if (getApprovedStatus() == lmisOvertimeApprovals.getApprovedStatus()) {
			value = -1;
		}
		else if (getApprovedStatus() != lmisOvertimeApprovals.getApprovedStatus()) {
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

		LmisOvertimeApprovals lmisOvertimeApprovals = null;

		try {
			lmisOvertimeApprovals = (LmisOvertimeApprovals)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisOvertimeApprovals.getPrimaryKey();

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

		sb.append("{lmisOvertimeApprovalsId=");
		sb.append(getLmisOvertimeApprovalsId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", requestId=");
		sb.append(getRequestId());
		sb.append(", reportId=");
		sb.append(getReportId());
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
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisOvertimeApprovals");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisOvertimeApprovalsId</column-name><column-value><![CDATA[");
		sb.append(getLmisOvertimeApprovalsId());
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
			"<column><column-name>reportId</column-name><column-value><![CDATA[");
		sb.append(getReportId());
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

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisOvertimeApprovalsId;
	private int _rootId;
	private int _requestId;
	private int _reportId;
	private int _approvedBy;
	private Date _approvedAt;
	private boolean _isApproved;
	private boolean _approvedStatus;
	private String _reaSon;
}