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
import com.liferay.portal.model.impl.BaseModelImpl;

import larion.progate.lmis.model.LmisOverTimeReportDetails;
import larion.progate.lmis.model.LmisOverTimeReportDetailsSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisOverTimeReportDetailsModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOverTimeReportDetailsModelImpl extends BaseModelImpl<LmisOverTimeReportDetails> {
	public static final String TABLE_NAME = "lmis_overtime_report_details";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "report_id", new Integer(Types.INTEGER) },
			

			{ "user_id", new Integer(Types.INTEGER) },
			

			{ "start_time", new Integer(Types.TIMESTAMP) },
			

			{ "end_time", new Integer(Types.TIMESTAMP) },
			

			{ "total_hour", new Integer(Types.DOUBLE) }
		};
	public static final String TABLE_SQL_CREATE = "create table lmis_overtime_report_details (id INTEGER not null primary key,root_id INTEGER,report_id INTEGER,user_id INTEGER,start_time DATE null,end_time DATE null,total_hour DOUBLE)";
	public static final String TABLE_SQL_DROP = "drop table lmis_overtime_report_details";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.lmis.model.LmisOverTimeReportDetails"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.lmis.model.LmisOverTimeReportDetails"),
			false);

	public static LmisOverTimeReportDetails toModel(
		LmisOverTimeReportDetailsSoap soapModel) {
		LmisOverTimeReportDetails model = new LmisOverTimeReportDetailsImpl();

		model.setLmisOverTimeReportDetailsId(soapModel.getLmisOverTimeReportDetailsId());
		model.setRootId(soapModel.getRootId());
		model.setReportId(soapModel.getReportId());
		model.setUserId(soapModel.getUserId());
		model.setStartTime(soapModel.getStartTime());
		model.setEndTime(soapModel.getEndTime());
		model.setTotalHour(soapModel.getTotalHour());

		return model;
	}

	public static List<LmisOverTimeReportDetails> toModels(
		LmisOverTimeReportDetailsSoap[] soapModels) {
		List<LmisOverTimeReportDetails> models = new ArrayList<LmisOverTimeReportDetails>(soapModels.length);

		for (LmisOverTimeReportDetailsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.lmis.model.LmisOverTimeReportDetails"));

	public LmisOverTimeReportDetailsModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _lmisOverTimeReportDetailsId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisOverTimeReportDetailsId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisOverTimeReportDetailsId;
	}

	public Integer getLmisOverTimeReportDetailsId() {
		return _lmisOverTimeReportDetailsId;
	}

	public void setLmisOverTimeReportDetailsId(
		Integer lmisOverTimeReportDetailsId) {
		_lmisOverTimeReportDetailsId = lmisOverTimeReportDetailsId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
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

	public double getTotalHour() {
		return _totalHour;
	}

	public void setTotalHour(double totalHour) {
		_totalHour = totalHour;
	}

	public LmisOverTimeReportDetails toEscapedModel() {
		if (isEscapedModel()) {
			return (LmisOverTimeReportDetails)this;
		}
		else {
			LmisOverTimeReportDetails model = new LmisOverTimeReportDetailsImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setLmisOverTimeReportDetailsId(getLmisOverTimeReportDetailsId());
			model.setRootId(getRootId());
			model.setReportId(getReportId());
			model.setUserId(getUserId());
			model.setStartTime(getStartTime());
			model.setEndTime(getEndTime());
			model.setTotalHour(getTotalHour());

			model = (LmisOverTimeReportDetails)Proxy.newProxyInstance(LmisOverTimeReportDetails.class.getClassLoader(),
					new Class[] { LmisOverTimeReportDetails.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisOverTimeReportDetailsImpl clone = new LmisOverTimeReportDetailsImpl();

		clone.setLmisOverTimeReportDetailsId(getLmisOverTimeReportDetailsId());
		clone.setRootId(getRootId());
		clone.setReportId(getReportId());
		clone.setUserId(getUserId());
		clone.setStartTime(getStartTime());
		clone.setEndTime(getEndTime());
		clone.setTotalHour(getTotalHour());

		return clone;
	}

	public int compareTo(LmisOverTimeReportDetails lmisOverTimeReportDetails) {
		Integer pk = lmisOverTimeReportDetails.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisOverTimeReportDetails lmisOverTimeReportDetails = null;

		try {
			lmisOverTimeReportDetails = (LmisOverTimeReportDetails)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisOverTimeReportDetails.getPrimaryKey();

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

		sb.append("{lmisOverTimeReportDetailsId=");
		sb.append(getLmisOverTimeReportDetailsId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", reportId=");
		sb.append(getReportId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append(", totalHour=");
		sb.append(getTotalHour());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisOverTimeReportDetails");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisOverTimeReportDetailsId</column-name><column-value><![CDATA[");
		sb.append(getLmisOverTimeReportDetailsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
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
			"<column><column-name>startTime</column-name><column-value><![CDATA[");
		sb.append(getStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endTime</column-name><column-value><![CDATA[");
		sb.append(getEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalHour</column-name><column-value><![CDATA[");
		sb.append(getTotalHour());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisOverTimeReportDetailsId;
	private int _rootId;
	private int _reportId;
	private int _userId;
	private Date _startTime;
	private Date _endTime;
	private double _totalHour;
}