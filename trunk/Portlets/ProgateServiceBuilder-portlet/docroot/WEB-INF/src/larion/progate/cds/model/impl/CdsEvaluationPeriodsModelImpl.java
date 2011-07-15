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

package larion.progate.cds.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import larion.progate.cds.model.CdsEvaluationPeriods;
import larion.progate.cds.model.CdsEvaluationPeriodsSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="CdsEvaluationPeriodsModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsEvaluationPeriodsModelImpl extends BaseModelImpl<CdsEvaluationPeriods> {
	public static final String TABLE_NAME = "cds_evaluation_periods";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "name", new Integer(Types.VARCHAR) },
			

			{ "from_date", new Integer(Types.TIMESTAMP) },
			

			{ "to_date", new Integer(Types.TIMESTAMP) },
			

			{ "start_date", new Integer(Types.TIMESTAMP) },
			

			{ "end_date", new Integer(Types.TIMESTAMP) },
			

			{ "status", new Integer(Types.INTEGER) },
			

			{ "created_by", new Integer(Types.INTEGER) },
			

			{ "created_at", new Integer(Types.TIMESTAMP) },
			

			{ "updated_by", new Integer(Types.INTEGER) },
			

			{ "updated_at", new Integer(Types.TIMESTAMP) },
			

			{ "is_modified", new Integer(Types.BOOLEAN) }
		};
	public static final String TABLE_SQL_CREATE = "create table cds_evaluation_periods (id INTEGER not null primary key,root_id INTEGER,name VARCHAR(75) null,from_date DATE null,to_date DATE null,start_date DATE null,end_date DATE null,status INTEGER,created_by INTEGER,created_at DATE null,updated_by INTEGER,updated_at DATE null,is_modified BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table cds_evaluation_periods";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.cds.model.CdsEvaluationPeriods"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.cds.model.CdsEvaluationPeriods"),
			false);

	public static CdsEvaluationPeriods toModel(
		CdsEvaluationPeriodsSoap soapModel) {
		CdsEvaluationPeriods model = new CdsEvaluationPeriodsImpl();

		model.setCdsEvaluationPeriodsId(soapModel.getCdsEvaluationPeriodsId());
		model.setRootId(soapModel.getRootId());
		model.setName(soapModel.getName());
		model.setFromDate(soapModel.getFromDate());
		model.setToDate(soapModel.getToDate());
		model.setStartDate(soapModel.getStartDate());
		model.setEndDate(soapModel.getEndDate());
		model.setStatus(soapModel.getStatus());
		model.setCreatedBy(soapModel.getCreatedBy());
		model.setCreatedAt(soapModel.getCreatedAt());
		model.setUpdatedBy(soapModel.getUpdatedBy());
		model.setUpdatedAt(soapModel.getUpdatedAt());
		model.setIsModified(soapModel.getIsModified());

		return model;
	}

	public static List<CdsEvaluationPeriods> toModels(
		CdsEvaluationPeriodsSoap[] soapModels) {
		List<CdsEvaluationPeriods> models = new ArrayList<CdsEvaluationPeriods>(soapModels.length);

		for (CdsEvaluationPeriodsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.cds.model.CdsEvaluationPeriods"));

	public CdsEvaluationPeriodsModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _CdsEvaluationPeriodsId;
	}

	public void setPrimaryKey(Integer pk) {
		setCdsEvaluationPeriodsId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _CdsEvaluationPeriodsId;
	}

	public Integer getCdsEvaluationPeriodsId() {
		return _CdsEvaluationPeriodsId;
	}

	public void setCdsEvaluationPeriodsId(Integer CdsEvaluationPeriodsId) {
		_CdsEvaluationPeriodsId = CdsEvaluationPeriodsId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public String getName() {
		return GetterUtil.getString(_name);
	}

	public void setName(String name) {
		_name = name;
	}

	public Date getFromDate() {
		return _fromDate;
	}

	public void setFromDate(Date fromDate) {
		_fromDate = fromDate;
	}

	public Date getToDate() {
		return _toDate;
	}

	public void setToDate(Date toDate) {
		_toDate = toDate;
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

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public int getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(int createdBy) {
		_createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return _createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		_createdAt = createdAt;
	}

	public int getUpdatedBy() {
		return _updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		_updatedBy = updatedBy;
	}

	public Date getUpdatedAt() {
		return _updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		_updatedAt = updatedAt;
	}

	public boolean getIsModified() {
		return _isModified;
	}

	public boolean isIsModified() {
		return _isModified;
	}

	public void setIsModified(boolean isModified) {
		_isModified = isModified;
	}

	public CdsEvaluationPeriods toEscapedModel() {
		if (isEscapedModel()) {
			return (CdsEvaluationPeriods)this;
		}
		else {
			CdsEvaluationPeriods model = new CdsEvaluationPeriodsImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setCdsEvaluationPeriodsId(getCdsEvaluationPeriodsId());
			model.setRootId(getRootId());
			model.setName(HtmlUtil.escape(getName()));
			model.setFromDate(getFromDate());
			model.setToDate(getToDate());
			model.setStartDate(getStartDate());
			model.setEndDate(getEndDate());
			model.setStatus(getStatus());
			model.setCreatedBy(getCreatedBy());
			model.setCreatedAt(getCreatedAt());
			model.setUpdatedBy(getUpdatedBy());
			model.setUpdatedAt(getUpdatedAt());
			model.setIsModified(getIsModified());

			model = (CdsEvaluationPeriods)Proxy.newProxyInstance(CdsEvaluationPeriods.class.getClassLoader(),
					new Class[] { CdsEvaluationPeriods.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		CdsEvaluationPeriodsImpl clone = new CdsEvaluationPeriodsImpl();

		clone.setCdsEvaluationPeriodsId(getCdsEvaluationPeriodsId());
		clone.setRootId(getRootId());
		clone.setName(getName());
		clone.setFromDate(getFromDate());
		clone.setToDate(getToDate());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());
		clone.setStatus(getStatus());
		clone.setCreatedBy(getCreatedBy());
		clone.setCreatedAt(getCreatedAt());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedAt(getUpdatedAt());
		clone.setIsModified(getIsModified());

		return clone;
	}

	public int compareTo(CdsEvaluationPeriods cdsEvaluationPeriods) {
		int value = 0;

		value = DateUtil.compareTo(getFromDate(),
				cdsEvaluationPeriods.getFromDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CdsEvaluationPeriods cdsEvaluationPeriods = null;

		try {
			cdsEvaluationPeriods = (CdsEvaluationPeriods)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = cdsEvaluationPeriods.getPrimaryKey();

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

		sb.append("{CdsEvaluationPeriodsId=");
		sb.append(getCdsEvaluationPeriodsId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", fromDate=");
		sb.append(getFromDate());
		sb.append(", toDate=");
		sb.append(getToDate());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", createdAt=");
		sb.append(getCreatedAt());
		sb.append(", updatedBy=");
		sb.append(getUpdatedBy());
		sb.append(", updatedAt=");
		sb.append(getUpdatedAt());
		sb.append(", isModified=");
		sb.append(getIsModified());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.cds.model.CdsEvaluationPeriods");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>CdsEvaluationPeriodsId</column-name><column-value><![CDATA[");
		sb.append(getCdsEvaluationPeriodsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fromDate</column-name><column-value><![CDATA[");
		sb.append(getFromDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toDate</column-name><column-value><![CDATA[");
		sb.append(getToDate());
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
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdAt</column-name><column-value><![CDATA[");
		sb.append(getCreatedAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updatedBy</column-name><column-value><![CDATA[");
		sb.append(getUpdatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updatedAt</column-name><column-value><![CDATA[");
		sb.append(getUpdatedAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isModified</column-name><column-value><![CDATA[");
		sb.append(getIsModified());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _CdsEvaluationPeriodsId;
	private int _rootId;
	private String _name;
	private Date _fromDate;
	private Date _toDate;
	private Date _startDate;
	private Date _endDate;
	private int _status;
	private int _createdBy;
	private Date _createdAt;
	private int _updatedBy;
	private Date _updatedAt;
	private boolean _isModified;
}