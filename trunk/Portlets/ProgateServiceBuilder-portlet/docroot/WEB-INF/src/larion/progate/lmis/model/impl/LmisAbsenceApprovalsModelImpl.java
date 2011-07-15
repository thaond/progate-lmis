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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import larion.progate.lmis.model.LmisAbsenceApprovals;
import larion.progate.lmis.model.LmisAbsenceApprovalsSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisAbsenceApprovalsModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAbsenceApprovalsModelImpl extends BaseModelImpl<LmisAbsenceApprovals> {
	public static final String TABLE_NAME = "lmis_absence_approvals";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "request_id", new Integer(Types.INTEGER) },
			

			{ "approved_by", new Integer(Types.INTEGER) },
			

			{ "approved_at", new Integer(Types.TIMESTAMP) },
			

			{ "is_approved", new Integer(Types.BOOLEAN) },
			

			{ "approved_status", new Integer(Types.BOOLEAN) },
			

			{ "reason", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table lmis_absence_approvals (id INTEGER not null primary key,root_id INTEGER,request_id INTEGER,approved_by INTEGER,approved_at DATE null,is_approved BOOLEAN,approved_status BOOLEAN,reason VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table lmis_absence_approvals";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.lmis.model.LmisAbsenceApprovals"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.lmis.model.LmisAbsenceApprovals"),
			false);

	public static LmisAbsenceApprovals toModel(
		LmisAbsenceApprovalsSoap soapModel) {
		LmisAbsenceApprovals model = new LmisAbsenceApprovalsImpl();

		model.setLmisAbsenceApprovalsId(soapModel.getLmisAbsenceApprovalsId());
		model.setRootId(soapModel.getRootId());
		model.setRequestId(soapModel.getRequestId());
		model.setApprovedBy(soapModel.getApprovedBy());
		model.setApprovedAt(soapModel.getApprovedAt());
		model.setIsApproved(soapModel.getIsApproved());
		model.setApprovedStatus(soapModel.getApprovedStatus());
		model.setReasonApproval(soapModel.getReasonApproval());

		return model;
	}

	public static List<LmisAbsenceApprovals> toModels(
		LmisAbsenceApprovalsSoap[] soapModels) {
		List<LmisAbsenceApprovals> models = new ArrayList<LmisAbsenceApprovals>(soapModels.length);

		for (LmisAbsenceApprovalsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.lmis.model.LmisAbsenceApprovals"));

	public LmisAbsenceApprovalsModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _lmisAbsenceApprovalsId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisAbsenceApprovalsId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisAbsenceApprovalsId;
	}

	public Integer getLmisAbsenceApprovalsId() {
		return _lmisAbsenceApprovalsId;
	}

	public void setLmisAbsenceApprovalsId(Integer lmisAbsenceApprovalsId) {
		_lmisAbsenceApprovalsId = lmisAbsenceApprovalsId;
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

	public String getReasonApproval() {
		return GetterUtil.getString(_reasonApproval);
	}

	public void setReasonApproval(String reasonApproval) {
		_reasonApproval = reasonApproval;
	}

	public LmisAbsenceApprovals toEscapedModel() {
		if (isEscapedModel()) {
			return (LmisAbsenceApprovals)this;
		}
		else {
			LmisAbsenceApprovals model = new LmisAbsenceApprovalsImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setLmisAbsenceApprovalsId(getLmisAbsenceApprovalsId());
			model.setRootId(getRootId());
			model.setRequestId(getRequestId());
			model.setApprovedBy(getApprovedBy());
			model.setApprovedAt(getApprovedAt());
			model.setIsApproved(getIsApproved());
			model.setApprovedStatus(getApprovedStatus());
			model.setReasonApproval(HtmlUtil.escape(getReasonApproval()));

			model = (LmisAbsenceApprovals)Proxy.newProxyInstance(LmisAbsenceApprovals.class.getClassLoader(),
					new Class[] { LmisAbsenceApprovals.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisAbsenceApprovalsImpl clone = new LmisAbsenceApprovalsImpl();

		clone.setLmisAbsenceApprovalsId(getLmisAbsenceApprovalsId());
		clone.setRootId(getRootId());
		clone.setRequestId(getRequestId());
		clone.setApprovedBy(getApprovedBy());
		clone.setApprovedAt(getApprovedAt());
		clone.setIsApproved(getIsApproved());
		clone.setApprovedStatus(getApprovedStatus());
		clone.setReasonApproval(getReasonApproval());

		return clone;
	}

	public int compareTo(LmisAbsenceApprovals lmisAbsenceApprovals) {
		int value = 0;

		if (getApprovedStatus() == lmisAbsenceApprovals.getApprovedStatus()) {
			value = -1;
		}
		else if (getApprovedStatus() != lmisAbsenceApprovals.getApprovedStatus()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getApprovedAt(),
				lmisAbsenceApprovals.getApprovedAt());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisAbsenceApprovals lmisAbsenceApprovals = null;

		try {
			lmisAbsenceApprovals = (LmisAbsenceApprovals)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisAbsenceApprovals.getPrimaryKey();

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

		sb.append("{lmisAbsenceApprovalsId=");
		sb.append(getLmisAbsenceApprovalsId());
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
		sb.append(", reasonApproval=");
		sb.append(getReasonApproval());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisAbsenceApprovals");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisAbsenceApprovalsId</column-name><column-value><![CDATA[");
		sb.append(getLmisAbsenceApprovalsId());
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
			"<column><column-name>reasonApproval</column-name><column-value><![CDATA[");
		sb.append(getReasonApproval());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisAbsenceApprovalsId;
	private int _rootId;
	private int _requestId;
	private int _approvedBy;
	private Date _approvedAt;
	private boolean _isApproved;
	private boolean _approvedStatus;
	private String _reasonApproval;
}