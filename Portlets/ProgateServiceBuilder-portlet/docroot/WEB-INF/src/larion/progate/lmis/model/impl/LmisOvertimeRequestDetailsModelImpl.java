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

import larion.progate.lmis.model.LmisOvertimeRequestDetails;
import larion.progate.lmis.model.LmisOvertimeRequestDetailsSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisOvertimeRequestDetailsModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOvertimeRequestDetailsModelImpl extends BaseModelImpl<LmisOvertimeRequestDetails> {
	public static final String TABLE_NAME = "lmis_overtime_request_details";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "request_id", new Integer(Types.INTEGER) },
			

			{ "user_id", new Integer(Types.INTEGER) },
			

			{ "start_time", new Integer(Types.TIMESTAMP) },
			

			{ "end_time", new Integer(Types.TIMESTAMP) },
			

			{ "requested_reason", new Integer(Types.VARCHAR) },
			

			{ "requested_hour", new Integer(Types.DOUBLE) }
		};
	public static final String TABLE_SQL_CREATE = "create table lmis_overtime_request_details (id INTEGER not null primary key,root_id INTEGER,request_id INTEGER,user_id INTEGER,start_time DATE null,end_time DATE null,requested_reason VARCHAR(75) null,requested_hour DOUBLE)";
	public static final String TABLE_SQL_DROP = "drop table lmis_overtime_request_details";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.lmis.model.LmisOvertimeRequestDetails"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.lmis.model.LmisOvertimeRequestDetails"),
			false);

	public static LmisOvertimeRequestDetails toModel(
		LmisOvertimeRequestDetailsSoap soapModel) {
		LmisOvertimeRequestDetails model = new LmisOvertimeRequestDetailsImpl();

		model.setLmisOvertimeRequestDetailsId(soapModel.getLmisOvertimeRequestDetailsId());
		model.setRootId(soapModel.getRootId());
		model.setRequestId(soapModel.getRequestId());
		model.setUserId(soapModel.getUserId());
		model.setStartTime(soapModel.getStartTime());
		model.setEndTime(soapModel.getEndTime());
		model.setRequestedReason(soapModel.getRequestedReason());
		model.setRequestedHour(soapModel.getRequestedHour());

		return model;
	}

	public static List<LmisOvertimeRequestDetails> toModels(
		LmisOvertimeRequestDetailsSoap[] soapModels) {
		List<LmisOvertimeRequestDetails> models = new ArrayList<LmisOvertimeRequestDetails>(soapModels.length);

		for (LmisOvertimeRequestDetailsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.lmis.model.LmisOvertimeRequestDetails"));

	public LmisOvertimeRequestDetailsModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _lmisOvertimeRequestDetailsId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisOvertimeRequestDetailsId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisOvertimeRequestDetailsId;
	}

	public Integer getLmisOvertimeRequestDetailsId() {
		return _lmisOvertimeRequestDetailsId;
	}

	public void setLmisOvertimeRequestDetailsId(
		Integer lmisOvertimeRequestDetailsId) {
		_lmisOvertimeRequestDetailsId = lmisOvertimeRequestDetailsId;
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

	public String getRequestedReason() {
		return GetterUtil.getString(_requestedReason);
	}

	public void setRequestedReason(String requestedReason) {
		_requestedReason = requestedReason;
	}

	public double getRequestedHour() {
		return _requestedHour;
	}

	public void setRequestedHour(double requestedHour) {
		_requestedHour = requestedHour;
	}

	public LmisOvertimeRequestDetails toEscapedModel() {
		if (isEscapedModel()) {
			return (LmisOvertimeRequestDetails)this;
		}
		else {
			LmisOvertimeRequestDetails model = new LmisOvertimeRequestDetailsImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setLmisOvertimeRequestDetailsId(getLmisOvertimeRequestDetailsId());
			model.setRootId(getRootId());
			model.setRequestId(getRequestId());
			model.setUserId(getUserId());
			model.setStartTime(getStartTime());
			model.setEndTime(getEndTime());
			model.setRequestedReason(HtmlUtil.escape(getRequestedReason()));
			model.setRequestedHour(getRequestedHour());

			model = (LmisOvertimeRequestDetails)Proxy.newProxyInstance(LmisOvertimeRequestDetails.class.getClassLoader(),
					new Class[] { LmisOvertimeRequestDetails.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisOvertimeRequestDetailsImpl clone = new LmisOvertimeRequestDetailsImpl();

		clone.setLmisOvertimeRequestDetailsId(getLmisOvertimeRequestDetailsId());
		clone.setRootId(getRootId());
		clone.setRequestId(getRequestId());
		clone.setUserId(getUserId());
		clone.setStartTime(getStartTime());
		clone.setEndTime(getEndTime());
		clone.setRequestedReason(getRequestedReason());
		clone.setRequestedHour(getRequestedHour());

		return clone;
	}

	public int compareTo(LmisOvertimeRequestDetails lmisOvertimeRequestDetails) {
		Integer pk = lmisOvertimeRequestDetails.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisOvertimeRequestDetails lmisOvertimeRequestDetails = null;

		try {
			lmisOvertimeRequestDetails = (LmisOvertimeRequestDetails)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisOvertimeRequestDetails.getPrimaryKey();

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

		sb.append("{lmisOvertimeRequestDetailsId=");
		sb.append(getLmisOvertimeRequestDetailsId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", requestId=");
		sb.append(getRequestId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append(", requestedReason=");
		sb.append(getRequestedReason());
		sb.append(", requestedHour=");
		sb.append(getRequestedHour());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisOvertimeRequestDetails");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisOvertimeRequestDetailsId</column-name><column-value><![CDATA[");
		sb.append(getLmisOvertimeRequestDetailsId());
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
			"<column><column-name>requestedReason</column-name><column-value><![CDATA[");
		sb.append(getRequestedReason());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requestedHour</column-name><column-value><![CDATA[");
		sb.append(getRequestedHour());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisOvertimeRequestDetailsId;
	private int _rootId;
	private int _requestId;
	private int _userId;
	private Date _startTime;
	private Date _endTime;
	private String _requestedReason;
	private double _requestedHour;
}