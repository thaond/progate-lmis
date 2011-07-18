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

import larion.progate.lmis.model.LmisViewOTApp;
import larion.progate.lmis.model.LmisViewOTAppSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisViewOTAppModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewOTAppModelImpl extends BaseModelImpl<LmisViewOTApp> {
	public static final String TABLE_NAME = "vw_ot_app";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "org_id", new Integer(Types.INTEGER) },
			

			{ "requested_by", new Integer(Types.INTEGER) },
			

			{ "requested_at", new Integer(Types.TIMESTAMP) },
			

			{ "requested_reason", new Integer(Types.VARCHAR) },
			

			{ "requested_status", new Integer(Types.INTEGER) },
			

			{ "created_at", new Integer(Types.TIMESTAMP) },
			

			{ "updated_at", new Integer(Types.TIMESTAMP) },
			

			{ "approved_by", new Integer(Types.INTEGER) },
			

			{ "approved_at", new Integer(Types.TIMESTAMP) },
			

			{ "is_approved", new Integer(Types.BOOLEAN) },
			

			{ "approved_status", new Integer(Types.BOOLEAN) },
			

			{ "reason", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table vw_ot_app (id INTEGER not null primary key,root_id INTEGER,org_id INTEGER,requested_by INTEGER,requested_at DATE null,requested_reason VARCHAR(75) null,requested_status INTEGER,created_at DATE null,updated_at DATE null,approved_by INTEGER,approved_at DATE null,is_approved BOOLEAN,approved_status BOOLEAN,reason VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table vw_ot_app";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.lmis.model.LmisViewOTApp"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.lmis.model.LmisViewOTApp"),
			false);

	public static LmisViewOTApp toModel(LmisViewOTAppSoap soapModel) {
		LmisViewOTApp model = new LmisViewOTAppImpl();

		model.setLmisViewOTAppId(soapModel.getLmisViewOTAppId());
		model.setRootId(soapModel.getRootId());
		model.setOrgId(soapModel.getOrgId());
		model.setRequestedBy(soapModel.getRequestedBy());
		model.setRequestedAt(soapModel.getRequestedAt());
		model.setRequestedReason(soapModel.getRequestedReason());
		model.setRequestedStatus(soapModel.getRequestedStatus());
		model.setCreatedAt(soapModel.getCreatedAt());
		model.setUpdatedAt(soapModel.getUpdatedAt());
		model.setApprovedBy(soapModel.getApprovedBy());
		model.setApprovedAt(soapModel.getApprovedAt());
		model.setIsApproved(soapModel.getIsApproved());
		model.setApprovedStatus(soapModel.getApprovedStatus());
		model.setApprovedReason(soapModel.getApprovedReason());

		return model;
	}

	public static List<LmisViewOTApp> toModels(LmisViewOTAppSoap[] soapModels) {
		List<LmisViewOTApp> models = new ArrayList<LmisViewOTApp>(soapModels.length);

		for (LmisViewOTAppSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.lmis.model.LmisViewOTApp"));

	public LmisViewOTAppModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _lmisViewOTAppId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisViewOTAppId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisViewOTAppId;
	}

	public Integer getLmisViewOTAppId() {
		return _lmisViewOTAppId;
	}

	public void setLmisViewOTAppId(Integer lmisViewOTAppId) {
		_lmisViewOTAppId = lmisViewOTAppId;
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
		return GetterUtil.getString(_requestedReason);
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

	public String getApprovedReason() {
		return GetterUtil.getString(_approvedReason);
	}

	public void setApprovedReason(String approvedReason) {
		_approvedReason = approvedReason;
	}

	public LmisViewOTApp toEscapedModel() {
		if (isEscapedModel()) {
			return (LmisViewOTApp)this;
		}
		else {
			LmisViewOTApp model = new LmisViewOTAppImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setLmisViewOTAppId(getLmisViewOTAppId());
			model.setRootId(getRootId());
			model.setOrgId(getOrgId());
			model.setRequestedBy(getRequestedBy());
			model.setRequestedAt(getRequestedAt());
			model.setRequestedReason(HtmlUtil.escape(getRequestedReason()));
			model.setRequestedStatus(getRequestedStatus());
			model.setCreatedAt(getCreatedAt());
			model.setUpdatedAt(getUpdatedAt());
			model.setApprovedBy(getApprovedBy());
			model.setApprovedAt(getApprovedAt());
			model.setIsApproved(getIsApproved());
			model.setApprovedStatus(getApprovedStatus());
			model.setApprovedReason(HtmlUtil.escape(getApprovedReason()));

			model = (LmisViewOTApp)Proxy.newProxyInstance(LmisViewOTApp.class.getClassLoader(),
					new Class[] { LmisViewOTApp.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisViewOTAppImpl clone = new LmisViewOTAppImpl();

		clone.setLmisViewOTAppId(getLmisViewOTAppId());
		clone.setRootId(getRootId());
		clone.setOrgId(getOrgId());
		clone.setRequestedBy(getRequestedBy());
		clone.setRequestedAt(getRequestedAt());
		clone.setRequestedReason(getRequestedReason());
		clone.setRequestedStatus(getRequestedStatus());
		clone.setCreatedAt(getCreatedAt());
		clone.setUpdatedAt(getUpdatedAt());
		clone.setApprovedBy(getApprovedBy());
		clone.setApprovedAt(getApprovedAt());
		clone.setIsApproved(getIsApproved());
		clone.setApprovedStatus(getApprovedStatus());
		clone.setApprovedReason(getApprovedReason());

		return clone;
	}

	public int compareTo(LmisViewOTApp lmisViewOTApp) {
		int value = 0;

		if (getRequestedStatus() < lmisViewOTApp.getRequestedStatus()) {
			value = -1;
		}
		else if (getRequestedStatus() > lmisViewOTApp.getRequestedStatus()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getUpdatedAt(), lmisViewOTApp.getUpdatedAt());

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

		LmisViewOTApp lmisViewOTApp = null;

		try {
			lmisViewOTApp = (LmisViewOTApp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisViewOTApp.getPrimaryKey();

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

		sb.append("{lmisViewOTAppId=");
		sb.append(getLmisViewOTAppId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", orgId=");
		sb.append(getOrgId());
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
		sb.append(", approvedBy=");
		sb.append(getApprovedBy());
		sb.append(", approvedAt=");
		sb.append(getApprovedAt());
		sb.append(", isApproved=");
		sb.append(getIsApproved());
		sb.append(", approvedStatus=");
		sb.append(getApprovedStatus());
		sb.append(", approvedReason=");
		sb.append(getApprovedReason());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisViewOTApp");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisViewOTAppId</column-name><column-value><![CDATA[");
		sb.append(getLmisViewOTAppId());
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
			"<column><column-name>approvedReason</column-name><column-value><![CDATA[");
		sb.append(getApprovedReason());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisViewOTAppId;
	private int _rootId;
	private int _orgId;
	private int _requestedBy;
	private Date _requestedAt;
	private String _requestedReason;
	private int _requestedStatus;
	private Date _createdAt;
	private Date _updatedAt;
	private int _approvedBy;
	private Date _approvedAt;
	private boolean _isApproved;
	private boolean _approvedStatus;
	private String _approvedReason;
}