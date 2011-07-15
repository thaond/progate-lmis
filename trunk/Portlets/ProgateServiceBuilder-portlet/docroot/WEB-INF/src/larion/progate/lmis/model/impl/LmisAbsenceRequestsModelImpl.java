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

import larion.progate.lmis.model.LmisAbsenceRequests;
import larion.progate.lmis.model.LmisAbsenceRequestsSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisAbsenceRequestsModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAbsenceRequestsModelImpl extends BaseModelImpl<LmisAbsenceRequests> {
	public static final String TABLE_NAME = "lmis_absence_requests";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "requested_by", new Integer(Types.INTEGER) },
			

			{ "start_date", new Integer(Types.TIMESTAMP) },
			

			{ "end_date", new Integer(Types.TIMESTAMP) },
			

			{ "start_session", new Integer(Types.INTEGER) },
			

			{ "end_session", new Integer(Types.INTEGER) },
			

			{ "requested_reason", new Integer(Types.VARCHAR) },
			

			{ "absence_type", new Integer(Types.VARCHAR) },
			

			{ "absence_type_id", new Integer(Types.INTEGER) },
			

			{ "requested_status", new Integer(Types.INTEGER) },
			

			{ "created_at", new Integer(Types.TIMESTAMP) },
			

			{ "updated_at", new Integer(Types.TIMESTAMP) }
		};
	public static final String TABLE_SQL_CREATE = "create table lmis_absence_requests (id INTEGER not null primary key,root_id INTEGER,requested_by INTEGER,start_date DATE null,end_date DATE null,start_session INTEGER,end_session INTEGER,requested_reason VARCHAR(75) null,absence_type VARCHAR(75) null,absence_type_id INTEGER,requested_status INTEGER,created_at DATE null,updated_at DATE null)";
	public static final String TABLE_SQL_DROP = "drop table lmis_absence_requests";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.lmis.model.LmisAbsenceRequests"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.lmis.model.LmisAbsenceRequests"),
			false);

	public static LmisAbsenceRequests toModel(LmisAbsenceRequestsSoap soapModel) {
		LmisAbsenceRequests model = new LmisAbsenceRequestsImpl();

		model.setLmisAbsenceRequestsId(soapModel.getLmisAbsenceRequestsId());
		model.setRootId(soapModel.getRootId());
		model.setRequestedBy(soapModel.getRequestedBy());
		model.setStartDate(soapModel.getStartDate());
		model.setEndDate(soapModel.getEndDate());
		model.setStartSession(soapModel.getStartSession());
		model.setEndSession(soapModel.getEndSession());
		model.setRequestedReason(soapModel.getRequestedReason());
		model.setAbsenceType(soapModel.getAbsenceType());
		model.setAbsenceTypeId(soapModel.getAbsenceTypeId());
		model.setRequestedStatus(soapModel.getRequestedStatus());
		model.setCreatedAt(soapModel.getCreatedAt());
		model.setUpdatedAt(soapModel.getUpdatedAt());

		return model;
	}

	public static List<LmisAbsenceRequests> toModels(
		LmisAbsenceRequestsSoap[] soapModels) {
		List<LmisAbsenceRequests> models = new ArrayList<LmisAbsenceRequests>(soapModels.length);

		for (LmisAbsenceRequestsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.lmis.model.LmisAbsenceRequests"));

	public LmisAbsenceRequestsModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _lmisAbsenceRequestsId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisAbsenceRequestsId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisAbsenceRequestsId;
	}

	public Integer getLmisAbsenceRequestsId() {
		return _lmisAbsenceRequestsId;
	}

	public void setLmisAbsenceRequestsId(Integer lmisAbsenceRequestsId) {
		_lmisAbsenceRequestsId = lmisAbsenceRequestsId;
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

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public int getStartSession() {
		return _startSession;
	}

	public void setStartSession(int startSession) {
		_startSession = startSession;
	}

	public int getEndSession() {
		return _endSession;
	}

	public void setEndSession(int endSession) {
		_endSession = endSession;
	}

	public String getRequestedReason() {
		return GetterUtil.getString(_requestedReason);
	}

	public void setRequestedReason(String requestedReason) {
		_requestedReason = requestedReason;
	}

	public String getAbsenceType() {
		return GetterUtil.getString(_absenceType);
	}

	public void setAbsenceType(String absenceType) {
		_absenceType = absenceType;
	}

	public int getAbsenceTypeId() {
		return _absenceTypeId;
	}

	public void setAbsenceTypeId(int absenceTypeId) {
		_absenceTypeId = absenceTypeId;
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

	public LmisAbsenceRequests toEscapedModel() {
		if (isEscapedModel()) {
			return (LmisAbsenceRequests)this;
		}
		else {
			LmisAbsenceRequests model = new LmisAbsenceRequestsImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setLmisAbsenceRequestsId(getLmisAbsenceRequestsId());
			model.setRootId(getRootId());
			model.setRequestedBy(getRequestedBy());
			model.setStartDate(getStartDate());
			model.setEndDate(getEndDate());
			model.setStartSession(getStartSession());
			model.setEndSession(getEndSession());
			model.setRequestedReason(HtmlUtil.escape(getRequestedReason()));
			model.setAbsenceType(HtmlUtil.escape(getAbsenceType()));
			model.setAbsenceTypeId(getAbsenceTypeId());
			model.setRequestedStatus(getRequestedStatus());
			model.setCreatedAt(getCreatedAt());
			model.setUpdatedAt(getUpdatedAt());

			model = (LmisAbsenceRequests)Proxy.newProxyInstance(LmisAbsenceRequests.class.getClassLoader(),
					new Class[] { LmisAbsenceRequests.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisAbsenceRequestsImpl clone = new LmisAbsenceRequestsImpl();

		clone.setLmisAbsenceRequestsId(getLmisAbsenceRequestsId());
		clone.setRootId(getRootId());
		clone.setRequestedBy(getRequestedBy());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());
		clone.setStartSession(getStartSession());
		clone.setEndSession(getEndSession());
		clone.setRequestedReason(getRequestedReason());
		clone.setAbsenceType(getAbsenceType());
		clone.setAbsenceTypeId(getAbsenceTypeId());
		clone.setRequestedStatus(getRequestedStatus());
		clone.setCreatedAt(getCreatedAt());
		clone.setUpdatedAt(getUpdatedAt());

		return clone;
	}

	public int compareTo(LmisAbsenceRequests lmisAbsenceRequests) {
		int value = 0;

		if (getRequestedStatus() < lmisAbsenceRequests.getRequestedStatus()) {
			value = -1;
		}
		else if (getRequestedStatus() > lmisAbsenceRequests.getRequestedStatus()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getCreatedAt(),
				lmisAbsenceRequests.getCreatedAt());

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

		LmisAbsenceRequests lmisAbsenceRequests = null;

		try {
			lmisAbsenceRequests = (LmisAbsenceRequests)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisAbsenceRequests.getPrimaryKey();

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

		sb.append("{lmisAbsenceRequestsId=");
		sb.append(getLmisAbsenceRequestsId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", requestedBy=");
		sb.append(getRequestedBy());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", startSession=");
		sb.append(getStartSession());
		sb.append(", endSession=");
		sb.append(getEndSession());
		sb.append(", requestedReason=");
		sb.append(getRequestedReason());
		sb.append(", absenceType=");
		sb.append(getAbsenceType());
		sb.append(", absenceTypeId=");
		sb.append(getAbsenceTypeId());
		sb.append(", requestedStatus=");
		sb.append(getRequestedStatus());
		sb.append(", createdAt=");
		sb.append(getCreatedAt());
		sb.append(", updatedAt=");
		sb.append(getUpdatedAt());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisAbsenceRequests");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisAbsenceRequestsId</column-name><column-value><![CDATA[");
		sb.append(getLmisAbsenceRequestsId());
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
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startSession</column-name><column-value><![CDATA[");
		sb.append(getStartSession());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endSession</column-name><column-value><![CDATA[");
		sb.append(getEndSession());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requestedReason</column-name><column-value><![CDATA[");
		sb.append(getRequestedReason());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>absenceType</column-name><column-value><![CDATA[");
		sb.append(getAbsenceType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>absenceTypeId</column-name><column-value><![CDATA[");
		sb.append(getAbsenceTypeId());
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

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisAbsenceRequestsId;
	private int _rootId;
	private int _requestedBy;
	private Date _startDate;
	private Date _endDate;
	private int _startSession;
	private int _endSession;
	private String _requestedReason;
	private String _absenceType;
	private int _absenceTypeId;
	private int _requestedStatus;
	private Date _createdAt;
	private Date _updatedAt;
}