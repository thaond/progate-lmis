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

import larion.progate.cds.model.ViewPerformanceAppraisalLevels;
import larion.progate.cds.model.ViewPerformanceAppraisalLevelsSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="ViewPerformanceAppraisalLevelsModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewPerformanceAppraisalLevelsModelImpl extends BaseModelImpl<ViewPerformanceAppraisalLevels> {
	public static final String TABLE_NAME = "v_performance_appraisal_levels";
	public static final Object[][] TABLE_COLUMNS = {
			{ "view_id", new Integer(Types.VARCHAR) },
			

			{ "level_id", new Integer(Types.INTEGER) },
			

			{ "number_order", new Integer(Types.INTEGER) },
			

			{ "competency_id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "level_name", new Integer(Types.VARCHAR) },
			

			{ "pa_id", new Integer(Types.INTEGER) },
			

			{ "user_id", new Integer(Types.INTEGER) },
			

			{ "period_id", new Integer(Types.INTEGER) },
			

			{ "total_level_point", new Integer(Types.INTEGER) },
			

			{ "is_passed", new Integer(Types.BOOLEAN) }
		};
	public static final String TABLE_SQL_CREATE = "create table v_performance_appraisal_levels (view_id VARCHAR(75) not null primary key,level_id INTEGER,number_order INTEGER,competency_id INTEGER,root_id INTEGER,level_name VARCHAR(75) null,pa_id INTEGER,user_id INTEGER,period_id INTEGER,total_level_point INTEGER,is_passed BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table v_performance_appraisal_levels";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.cds.model.ViewPerformanceAppraisalLevels"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.cds.model.ViewPerformanceAppraisalLevels"),
			false);

	public static ViewPerformanceAppraisalLevels toModel(
		ViewPerformanceAppraisalLevelsSoap soapModel) {
		ViewPerformanceAppraisalLevels model = new ViewPerformanceAppraisalLevelsImpl();

		model.setId(soapModel.getId());
		model.setLevelId(soapModel.getLevelId());
		model.setNumberOrder(soapModel.getNumberOrder());
		model.setCompetencyId(soapModel.getCompetencyId());
		model.setRootId(soapModel.getRootId());
		model.setLevelName(soapModel.getLevelName());
		model.setPaId(soapModel.getPaId());
		model.setUserId(soapModel.getUserId());
		model.setPeriodId(soapModel.getPeriodId());
		model.setTotalLevelPoint(soapModel.getTotalLevelPoint());
		model.setIsPassed(soapModel.getIsPassed());

		return model;
	}

	public static List<ViewPerformanceAppraisalLevels> toModels(
		ViewPerformanceAppraisalLevelsSoap[] soapModels) {
		List<ViewPerformanceAppraisalLevels> models = new ArrayList<ViewPerformanceAppraisalLevels>(soapModels.length);

		for (ViewPerformanceAppraisalLevelsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.cds.model.ViewPerformanceAppraisalLevels"));

	public ViewPerformanceAppraisalLevelsModelImpl() {
	}

	public String getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(String pk) {
		setId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	public String getId() {
		return GetterUtil.getString(_id);
	}

	public void setId(String id) {
		_id = id;
	}

	public int getLevelId() {
		return _levelId;
	}

	public void setLevelId(int levelId) {
		_levelId = levelId;
	}

	public int getNumberOrder() {
		return _numberOrder;
	}

	public void setNumberOrder(int numberOrder) {
		_numberOrder = numberOrder;
	}

	public int getCompetencyId() {
		return _competencyId;
	}

	public void setCompetencyId(int competencyId) {
		_competencyId = competencyId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public String getLevelName() {
		return GetterUtil.getString(_levelName);
	}

	public void setLevelName(String levelName) {
		_levelName = levelName;
	}

	public int getPaId() {
		return _paId;
	}

	public void setPaId(int paId) {
		_paId = paId;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public int getPeriodId() {
		return _periodId;
	}

	public void setPeriodId(int periodId) {
		_periodId = periodId;
	}

	public int getTotalLevelPoint() {
		return _totalLevelPoint;
	}

	public void setTotalLevelPoint(int totalLevelPoint) {
		_totalLevelPoint = totalLevelPoint;
	}

	public boolean getIsPassed() {
		return _isPassed;
	}

	public boolean isIsPassed() {
		return _isPassed;
	}

	public void setIsPassed(boolean isPassed) {
		_isPassed = isPassed;
	}

	public ViewPerformanceAppraisalLevels toEscapedModel() {
		if (isEscapedModel()) {
			return (ViewPerformanceAppraisalLevels)this;
		}
		else {
			ViewPerformanceAppraisalLevels model = new ViewPerformanceAppraisalLevelsImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setId(HtmlUtil.escape(getId()));
			model.setLevelId(getLevelId());
			model.setNumberOrder(getNumberOrder());
			model.setCompetencyId(getCompetencyId());
			model.setRootId(getRootId());
			model.setLevelName(HtmlUtil.escape(getLevelName()));
			model.setPaId(getPaId());
			model.setUserId(getUserId());
			model.setPeriodId(getPeriodId());
			model.setTotalLevelPoint(getTotalLevelPoint());
			model.setIsPassed(getIsPassed());

			model = (ViewPerformanceAppraisalLevels)Proxy.newProxyInstance(ViewPerformanceAppraisalLevels.class.getClassLoader(),
					new Class[] { ViewPerformanceAppraisalLevels.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ViewPerformanceAppraisalLevelsImpl clone = new ViewPerformanceAppraisalLevelsImpl();

		clone.setId(getId());
		clone.setLevelId(getLevelId());
		clone.setNumberOrder(getNumberOrder());
		clone.setCompetencyId(getCompetencyId());
		clone.setRootId(getRootId());
		clone.setLevelName(getLevelName());
		clone.setPaId(getPaId());
		clone.setUserId(getUserId());
		clone.setPeriodId(getPeriodId());
		clone.setTotalLevelPoint(getTotalLevelPoint());
		clone.setIsPassed(getIsPassed());

		return clone;
	}

	public int compareTo(
		ViewPerformanceAppraisalLevels viewPerformanceAppraisalLevels) {
		int value = 0;

		if (getNumberOrder() < viewPerformanceAppraisalLevels.getNumberOrder()) {
			value = -1;
		}
		else if (getNumberOrder() > viewPerformanceAppraisalLevels.getNumberOrder()) {
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

		ViewPerformanceAppraisalLevels viewPerformanceAppraisalLevels = null;

		try {
			viewPerformanceAppraisalLevels = (ViewPerformanceAppraisalLevels)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String pk = viewPerformanceAppraisalLevels.getPrimaryKey();

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

		sb.append("{id=");
		sb.append(getId());
		sb.append(", levelId=");
		sb.append(getLevelId());
		sb.append(", numberOrder=");
		sb.append(getNumberOrder());
		sb.append(", competencyId=");
		sb.append(getCompetencyId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", levelName=");
		sb.append(getLevelName());
		sb.append(", paId=");
		sb.append(getPaId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", periodId=");
		sb.append(getPeriodId());
		sb.append(", totalLevelPoint=");
		sb.append(getTotalLevelPoint());
		sb.append(", isPassed=");
		sb.append(getIsPassed());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.cds.model.ViewPerformanceAppraisalLevels");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>levelId</column-name><column-value><![CDATA[");
		sb.append(getLevelId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numberOrder</column-name><column-value><![CDATA[");
		sb.append(getNumberOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>competencyId</column-name><column-value><![CDATA[");
		sb.append(getCompetencyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>levelName</column-name><column-value><![CDATA[");
		sb.append(getLevelName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paId</column-name><column-value><![CDATA[");
		sb.append(getPaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>periodId</column-name><column-value><![CDATA[");
		sb.append(getPeriodId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalLevelPoint</column-name><column-value><![CDATA[");
		sb.append(getTotalLevelPoint());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isPassed</column-name><column-value><![CDATA[");
		sb.append(getIsPassed());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _id;
	private int _levelId;
	private int _numberOrder;
	private int _competencyId;
	private int _rootId;
	private String _levelName;
	private int _paId;
	private int _userId;
	private int _periodId;
	private int _totalLevelPoint;
	private boolean _isPassed;
}