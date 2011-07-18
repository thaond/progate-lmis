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

package larion.progate.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import larion.progate.model.ProgateOrganizationParticipants;
import larion.progate.model.ProgateOrganizationParticipantsSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="ProgateOrganizationParticipantsModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ProgateOrganizationParticipantsModelImpl extends BaseModelImpl<ProgateOrganizationParticipants> {
	public static final String TABLE_NAME = "progate_organization_participants";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "user_id", new Integer(Types.INTEGER) },
			

			{ "org_id", new Integer(Types.INTEGER) },
			

			{ "role_id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "bod_id", new Integer(Types.INTEGER) },
			

			{ "requested_by", new Integer(Types.INTEGER) },
			

			{ "requested_at", new Integer(Types.TIMESTAMP) },
			

			{ "requested_reason", new Integer(Types.VARCHAR) },
			

			{ "approved_by", new Integer(Types.INTEGER) },
			

			{ "approved_at", new Integer(Types.TIMESTAMP) },
			

			{ "approved_reason", new Integer(Types.VARCHAR) },
			

			{ "status", new Integer(Types.INTEGER) },
			

			{ "is_current", new Integer(Types.BOOLEAN) }
		};
	public static final String TABLE_SQL_CREATE = "create table progate_organization_participants (id INTEGER not null primary key,user_id INTEGER,org_id INTEGER,role_id INTEGER,root_id INTEGER,bod_id INTEGER,requested_by INTEGER,requested_at DATE null,requested_reason VARCHAR(75) null,approved_by INTEGER,approved_at DATE null,approved_reason VARCHAR(75) null,status INTEGER,is_current BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table progate_organization_participants";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.model.ProgateOrganizationParticipants"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.model.ProgateOrganizationParticipants"),
			false);

	public static ProgateOrganizationParticipants toModel(
		ProgateOrganizationParticipantsSoap soapModel) {
		ProgateOrganizationParticipants model = new ProgateOrganizationParticipantsImpl();

		model.setProgateOrganizationParticipantsId(soapModel.getProgateOrganizationParticipantsId());
		model.setUserId(soapModel.getUserId());
		model.setOrgId(soapModel.getOrgId());
		model.setRoleId(soapModel.getRoleId());
		model.setRootId(soapModel.getRootId());
		model.setBodId(soapModel.getBodId());
		model.setRequestedBy(soapModel.getRequestedBy());
		model.setRequestedAt(soapModel.getRequestedAt());
		model.setRequestedReason(soapModel.getRequestedReason());
		model.setApprovedBy(soapModel.getApprovedBy());
		model.setApprovedAt(soapModel.getApprovedAt());
		model.setApprovedReason(soapModel.getApprovedReason());
		model.setStatus(soapModel.getStatus());
		model.setIsCurrent(soapModel.getIsCurrent());

		return model;
	}

	public static List<ProgateOrganizationParticipants> toModels(
		ProgateOrganizationParticipantsSoap[] soapModels) {
		List<ProgateOrganizationParticipants> models = new ArrayList<ProgateOrganizationParticipants>(soapModels.length);

		for (ProgateOrganizationParticipantsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.model.ProgateOrganizationParticipants"));

	public ProgateOrganizationParticipantsModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _ProgateOrganizationParticipantsId;
	}

	public void setPrimaryKey(Integer pk) {
		setProgateOrganizationParticipantsId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _ProgateOrganizationParticipantsId;
	}

	public Integer getProgateOrganizationParticipantsId() {
		return _ProgateOrganizationParticipantsId;
	}

	public void setProgateOrganizationParticipantsId(
		Integer ProgateOrganizationParticipantsId) {
		_ProgateOrganizationParticipantsId = ProgateOrganizationParticipantsId;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public int getOrgId() {
		return _orgId;
	}

	public void setOrgId(int orgId) {
		_orgId = orgId;
	}

	public int getRoleId() {
		return _roleId;
	}

	public void setRoleId(int roleId) {
		_roleId = roleId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getBodId() {
		return _bodId;
	}

	public void setBodId(int bodId) {
		_bodId = bodId;
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

	public String getApprovedReason() {
		return GetterUtil.getString(_approvedReason);
	}

	public void setApprovedReason(String approvedReason) {
		_approvedReason = approvedReason;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public boolean getIsCurrent() {
		return _isCurrent;
	}

	public boolean isIsCurrent() {
		return _isCurrent;
	}

	public void setIsCurrent(boolean isCurrent) {
		_isCurrent = isCurrent;
	}

	public ProgateOrganizationParticipants toEscapedModel() {
		if (isEscapedModel()) {
			return (ProgateOrganizationParticipants)this;
		}
		else {
			ProgateOrganizationParticipants model = new ProgateOrganizationParticipantsImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setProgateOrganizationParticipantsId(getProgateOrganizationParticipantsId());
			model.setUserId(getUserId());
			model.setOrgId(getOrgId());
			model.setRoleId(getRoleId());
			model.setRootId(getRootId());
			model.setBodId(getBodId());
			model.setRequestedBy(getRequestedBy());
			model.setRequestedAt(getRequestedAt());
			model.setRequestedReason(HtmlUtil.escape(getRequestedReason()));
			model.setApprovedBy(getApprovedBy());
			model.setApprovedAt(getApprovedAt());
			model.setApprovedReason(HtmlUtil.escape(getApprovedReason()));
			model.setStatus(getStatus());
			model.setIsCurrent(getIsCurrent());

			model = (ProgateOrganizationParticipants)Proxy.newProxyInstance(ProgateOrganizationParticipants.class.getClassLoader(),
					new Class[] { ProgateOrganizationParticipants.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ProgateOrganizationParticipantsImpl clone = new ProgateOrganizationParticipantsImpl();

		clone.setProgateOrganizationParticipantsId(getProgateOrganizationParticipantsId());
		clone.setUserId(getUserId());
		clone.setOrgId(getOrgId());
		clone.setRoleId(getRoleId());
		clone.setRootId(getRootId());
		clone.setBodId(getBodId());
		clone.setRequestedBy(getRequestedBy());
		clone.setRequestedAt(getRequestedAt());
		clone.setRequestedReason(getRequestedReason());
		clone.setApprovedBy(getApprovedBy());
		clone.setApprovedAt(getApprovedAt());
		clone.setApprovedReason(getApprovedReason());
		clone.setStatus(getStatus());
		clone.setIsCurrent(getIsCurrent());

		return clone;
	}

	public int compareTo(
		ProgateOrganizationParticipants progateOrganizationParticipants) {
		int value = 0;

		value = DateUtil.compareTo(getApprovedAt(),
				progateOrganizationParticipants.getApprovedAt());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getRequestedAt(),
				progateOrganizationParticipants.getRequestedAt());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		if (getOrgId() < progateOrganizationParticipants.getOrgId()) {
			value = -1;
		}
		else if (getOrgId() > progateOrganizationParticipants.getOrgId()) {
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

		ProgateOrganizationParticipants progateOrganizationParticipants = null;

		try {
			progateOrganizationParticipants = (ProgateOrganizationParticipants)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = progateOrganizationParticipants.getPrimaryKey();

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

		sb.append("{ProgateOrganizationParticipantsId=");
		sb.append(getProgateOrganizationParticipantsId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", orgId=");
		sb.append(getOrgId());
		sb.append(", roleId=");
		sb.append(getRoleId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", bodId=");
		sb.append(getBodId());
		sb.append(", requestedBy=");
		sb.append(getRequestedBy());
		sb.append(", requestedAt=");
		sb.append(getRequestedAt());
		sb.append(", requestedReason=");
		sb.append(getRequestedReason());
		sb.append(", approvedBy=");
		sb.append(getApprovedBy());
		sb.append(", approvedAt=");
		sb.append(getApprovedAt());
		sb.append(", approvedReason=");
		sb.append(getApprovedReason());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", isCurrent=");
		sb.append(getIsCurrent());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.ProgateOrganizationParticipants");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ProgateOrganizationParticipantsId</column-name><column-value><![CDATA[");
		sb.append(getProgateOrganizationParticipantsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgId</column-name><column-value><![CDATA[");
		sb.append(getOrgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>roleId</column-name><column-value><![CDATA[");
		sb.append(getRoleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bodId</column-name><column-value><![CDATA[");
		sb.append(getBodId());
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
			"<column><column-name>approvedBy</column-name><column-value><![CDATA[");
		sb.append(getApprovedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approvedAt</column-name><column-value><![CDATA[");
		sb.append(getApprovedAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approvedReason</column-name><column-value><![CDATA[");
		sb.append(getApprovedReason());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isCurrent</column-name><column-value><![CDATA[");
		sb.append(getIsCurrent());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _ProgateOrganizationParticipantsId;
	private int _userId;
	private int _orgId;
	private int _roleId;
	private int _rootId;
	private int _bodId;
	private int _requestedBy;
	private Date _requestedAt;
	private String _requestedReason;
	private int _approvedBy;
	private Date _approvedAt;
	private String _approvedReason;
	private int _status;
	private boolean _isCurrent;
}