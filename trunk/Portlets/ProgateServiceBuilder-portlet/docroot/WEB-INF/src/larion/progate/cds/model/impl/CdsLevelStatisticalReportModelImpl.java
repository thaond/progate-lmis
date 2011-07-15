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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import larion.progate.cds.model.CdsLevelStatisticalReport;
import larion.progate.cds.model.CdsLevelStatisticalReportSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="CdsLevelStatisticalReportModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class CdsLevelStatisticalReportModelImpl extends BaseModelImpl<CdsLevelStatisticalReport> {
	public static final String TABLE_NAME = "cds_level_statistical_report";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "competency_id", new Integer(Types.INTEGER) },
			

			{ "name", new Integer(Types.VARCHAR) },
			

			{ "period_id", new Integer(Types.INTEGER) },
			

			{ "user_id", new Integer(Types.INTEGER) },
			

			{ "total_level_point", new Integer(Types.INTEGER) }
		};
	public static final String TABLE_SQL_CREATE = "create table cds_level_statistical_report (id INTEGER not null primary key,root_id INTEGER,competency_id INTEGER,name VARCHAR(75) null,period_id INTEGER,user_id INTEGER,total_level_point INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table cds_level_statistical_report";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.cds.model.CdsLevelStatisticalReport"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.cds.model.CdsLevelStatisticalReport"),
			false);

	public static CdsLevelStatisticalReport toModel(
		CdsLevelStatisticalReportSoap soapModel) {
		CdsLevelStatisticalReport model = new CdsLevelStatisticalReportImpl();

		model.setLevelId(soapModel.getLevelId());
		model.setRootId(soapModel.getRootId());
		model.setCompetencyId(soapModel.getCompetencyId());
		model.setName(soapModel.getName());
		model.setPeriodId(soapModel.getPeriodId());
		model.setUserId(soapModel.getUserId());
		model.setTotalLevelPoint(soapModel.getTotalLevelPoint());

		return model;
	}

	public static List<CdsLevelStatisticalReport> toModels(
		CdsLevelStatisticalReportSoap[] soapModels) {
		List<CdsLevelStatisticalReport> models = new ArrayList<CdsLevelStatisticalReport>(soapModels.length);

		for (CdsLevelStatisticalReportSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.cds.model.CdsLevelStatisticalReport"));

	public CdsLevelStatisticalReportModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _levelId;
	}

	public void setPrimaryKey(Integer pk) {
		setLevelId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _levelId;
	}

	public Integer getLevelId() {
		return _levelId;
	}

	public void setLevelId(Integer levelId) {
		_levelId = levelId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getCompetencyId() {
		return _competencyId;
	}

	public void setCompetencyId(int competencyId) {
		_competencyId = competencyId;
	}

	public String getName() {
		return GetterUtil.getString(_name);
	}

	public void setName(String name) {
		_name = name;
	}

	public int getPeriodId() {
		return _periodId;
	}

	public void setPeriodId(int periodId) {
		_periodId = periodId;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public int getTotalLevelPoint() {
		return _totalLevelPoint;
	}

	public void setTotalLevelPoint(int totalLevelPoint) {
		_totalLevelPoint = totalLevelPoint;
	}

	public CdsLevelStatisticalReport toEscapedModel() {
		if (isEscapedModel()) {
			return (CdsLevelStatisticalReport)this;
		}
		else {
			CdsLevelStatisticalReport model = new CdsLevelStatisticalReportImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setLevelId(getLevelId());
			model.setRootId(getRootId());
			model.setCompetencyId(getCompetencyId());
			model.setName(HtmlUtil.escape(getName()));
			model.setPeriodId(getPeriodId());
			model.setUserId(getUserId());
			model.setTotalLevelPoint(getTotalLevelPoint());

			model = (CdsLevelStatisticalReport)Proxy.newProxyInstance(CdsLevelStatisticalReport.class.getClassLoader(),
					new Class[] { CdsLevelStatisticalReport.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		CdsLevelStatisticalReportImpl clone = new CdsLevelStatisticalReportImpl();

		clone.setLevelId(getLevelId());
		clone.setRootId(getRootId());
		clone.setCompetencyId(getCompetencyId());
		clone.setName(getName());
		clone.setPeriodId(getPeriodId());
		clone.setUserId(getUserId());
		clone.setTotalLevelPoint(getTotalLevelPoint());

		return clone;
	}

	public int compareTo(CdsLevelStatisticalReport cdsLevelStatisticalReport) {
		Integer pk = cdsLevelStatisticalReport.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		CdsLevelStatisticalReport cdsLevelStatisticalReport = null;

		try {
			cdsLevelStatisticalReport = (CdsLevelStatisticalReport)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = cdsLevelStatisticalReport.getPrimaryKey();

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

		sb.append("{levelId=");
		sb.append(getLevelId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", competencyId=");
		sb.append(getCompetencyId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", periodId=");
		sb.append(getPeriodId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", totalLevelPoint=");
		sb.append(getTotalLevelPoint());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.cds.model.CdsLevelStatisticalReport");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>levelId</column-name><column-value><![CDATA[");
		sb.append(getLevelId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>competencyId</column-name><column-value><![CDATA[");
		sb.append(getCompetencyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>periodId</column-name><column-value><![CDATA[");
		sb.append(getPeriodId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalLevelPoint</column-name><column-value><![CDATA[");
		sb.append(getTotalLevelPoint());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _levelId;
	private int _rootId;
	private int _competencyId;
	private String _name;
	private int _periodId;
	private int _userId;
	private int _totalLevelPoint;
}