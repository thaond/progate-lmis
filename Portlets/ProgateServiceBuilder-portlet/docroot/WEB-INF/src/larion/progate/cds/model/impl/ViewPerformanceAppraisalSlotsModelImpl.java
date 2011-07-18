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

import larion.progate.cds.model.ViewPerformanceAppraisalSlots;
import larion.progate.cds.model.ViewPerformanceAppraisalSlotsSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="ViewPerformanceAppraisalSlotsModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewPerformanceAppraisalSlotsModelImpl extends BaseModelImpl<ViewPerformanceAppraisalSlots> {
	public static final String TABLE_NAME = "v_performance_appraisal_slots";
	public static final Object[][] TABLE_COLUMNS = {
			{ "view_id", new Integer(Types.VARCHAR) },
			

			{ "slot_id", new Integer(Types.INTEGER) },
			

			{ "level_id", new Integer(Types.INTEGER) },
			

			{ "competency_id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "slot_name", new Integer(Types.VARCHAR) },
			

			{ "alias_name", new Integer(Types.VARCHAR) },
			

			{ "description", new Integer(Types.VARCHAR) },
			

			{ "pa_id", new Integer(Types.INTEGER) },
			

			{ "slot_number_order", new Integer(Types.INTEGER) },
			

			{ "level_number_order", new Integer(Types.INTEGER) },
			

			{ "competency_number_order", new Integer(Types.INTEGER) },
			

			{ "user_id", new Integer(Types.INTEGER) },
			

			{ "period_id", new Integer(Types.INTEGER) },
			

			{ "period_name", new Integer(Types.VARCHAR) },
			

			{ "from_date", new Integer(Types.TIMESTAMP) },
			

			{ "to_date", new Integer(Types.TIMESTAMP) },
			

			{ "bod_uid", new Integer(Types.INTEGER) },
			

			{ "pm_uid", new Integer(Types.INTEGER) },
			

			{ "rating_org_id", new Integer(Types.INTEGER) },
			

			{ "rating_status", new Integer(Types.INTEGER) },
			

			{ "rating_status_bod", new Integer(Types.INTEGER) },
			

			{ "rating_status_pm", new Integer(Types.INTEGER) },
			

			{ "point_name", new Integer(Types.VARCHAR) },
			

			{ "max_point_name", new Integer(Types.VARCHAR) },
			

			{ "point_value", new Integer(Types.INTEGER) },
			

			{ "max_point_value", new Integer(Types.INTEGER) },
			

			{ "is_passed", new Integer(Types.BOOLEAN) }
		};
	public static final String TABLE_SQL_CREATE = "create table v_performance_appraisal_slots (view_id VARCHAR(75) not null primary key,slot_id INTEGER,level_id INTEGER,competency_id INTEGER,root_id INTEGER,slot_name VARCHAR(75) null,alias_name VARCHAR(75) null,description VARCHAR(75) null,pa_id INTEGER,slot_number_order INTEGER,level_number_order INTEGER,competency_number_order INTEGER,user_id INTEGER,period_id INTEGER,period_name VARCHAR(75) null,from_date DATE null,to_date DATE null,bod_uid INTEGER,pm_uid INTEGER,rating_org_id INTEGER,rating_status INTEGER,rating_status_bod INTEGER,rating_status_pm INTEGER,point_name VARCHAR(75) null,max_point_name VARCHAR(75) null,point_value INTEGER,max_point_value INTEGER,is_passed BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table v_performance_appraisal_slots";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.cds.model.ViewPerformanceAppraisalSlots"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.cds.model.ViewPerformanceAppraisalSlots"),
			false);

	public static ViewPerformanceAppraisalSlots toModel(
		ViewPerformanceAppraisalSlotsSoap soapModel) {
		ViewPerformanceAppraisalSlots model = new ViewPerformanceAppraisalSlotsImpl();

		model.setId(soapModel.getId());
		model.setSlotId(soapModel.getSlotId());
		model.setLevelId(soapModel.getLevelId());
		model.setCompetencyId(soapModel.getCompetencyId());
		model.setRootId(soapModel.getRootId());
		model.setSlotName(soapModel.getSlotName());
		model.setAliasName(soapModel.getAliasName());
		model.setDescription(soapModel.getDescription());
		model.setPaId(soapModel.getPaId());
		model.setSlotNumberOrder(soapModel.getSlotNumberOrder());
		model.setLevelNumberOrder(soapModel.getLevelNumberOrder());
		model.setCompetencyNumberOrder(soapModel.getCompetencyNumberOrder());
		model.setUserId(soapModel.getUserId());
		model.setPeriodId(soapModel.getPeriodId());
		model.setPeriodName(soapModel.getPeriodName());
		model.setFromDate(soapModel.getFromDate());
		model.setToDate(soapModel.getToDate());
		model.setBodUid(soapModel.getBodUid());
		model.setPmUid(soapModel.getPmUid());
		model.setRatingOrgId(soapModel.getRatingOrgId());
		model.setRatingStatus(soapModel.getRatingStatus());
		model.setRatingStatusBod(soapModel.getRatingStatusBod());
		model.setRatingStatusPm(soapModel.getRatingStatusPm());
		model.setPointName(soapModel.getPointName());
		model.setMaxPointName(soapModel.getMaxPointName());
		model.setPointValue(soapModel.getPointValue());
		model.setMaxPointValue(soapModel.getMaxPointValue());
		model.setIsPassed(soapModel.getIsPassed());

		return model;
	}

	public static List<ViewPerformanceAppraisalSlots> toModels(
		ViewPerformanceAppraisalSlotsSoap[] soapModels) {
		List<ViewPerformanceAppraisalSlots> models = new ArrayList<ViewPerformanceAppraisalSlots>(soapModels.length);

		for (ViewPerformanceAppraisalSlotsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.cds.model.ViewPerformanceAppraisalSlots"));

	public ViewPerformanceAppraisalSlotsModelImpl() {
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

	public int getSlotId() {
		return _slotId;
	}

	public void setSlotId(int slotId) {
		_slotId = slotId;
	}

	public int getLevelId() {
		return _levelId;
	}

	public void setLevelId(int levelId) {
		_levelId = levelId;
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

	public String getSlotName() {
		return GetterUtil.getString(_slotName);
	}

	public void setSlotName(String slotName) {
		_slotName = slotName;
	}

	public String getAliasName() {
		return GetterUtil.getString(_aliasName);
	}

	public void setAliasName(String aliasName) {
		_aliasName = aliasName;
	}

	public String getDescription() {
		return GetterUtil.getString(_description);
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getPaId() {
		return _paId;
	}

	public void setPaId(int paId) {
		_paId = paId;
	}

	public int getSlotNumberOrder() {
		return _slotNumberOrder;
	}

	public void setSlotNumberOrder(int slotNumberOrder) {
		_slotNumberOrder = slotNumberOrder;
	}

	public int getLevelNumberOrder() {
		return _levelNumberOrder;
	}

	public void setLevelNumberOrder(int levelNumberOrder) {
		_levelNumberOrder = levelNumberOrder;
	}

	public int getCompetencyNumberOrder() {
		return _competencyNumberOrder;
	}

	public void setCompetencyNumberOrder(int competencyNumberOrder) {
		_competencyNumberOrder = competencyNumberOrder;
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

	public String getPeriodName() {
		return GetterUtil.getString(_periodName);
	}

	public void setPeriodName(String periodName) {
		_periodName = periodName;
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

	public int getBodUid() {
		return _bodUid;
	}

	public void setBodUid(int bodUid) {
		_bodUid = bodUid;
	}

	public int getPmUid() {
		return _pmUid;
	}

	public void setPmUid(int pmUid) {
		_pmUid = pmUid;
	}

	public int getRatingOrgId() {
		return _ratingOrgId;
	}

	public void setRatingOrgId(int ratingOrgId) {
		_ratingOrgId = ratingOrgId;
	}

	public int getRatingStatus() {
		return _ratingStatus;
	}

	public void setRatingStatus(int ratingStatus) {
		_ratingStatus = ratingStatus;
	}

	public int getRatingStatusBod() {
		return _ratingStatusBod;
	}

	public void setRatingStatusBod(int ratingStatusBod) {
		_ratingStatusBod = ratingStatusBod;
	}

	public int getRatingStatusPm() {
		return _ratingStatusPm;
	}

	public void setRatingStatusPm(int ratingStatusPm) {
		_ratingStatusPm = ratingStatusPm;
	}

	public String getPointName() {
		return GetterUtil.getString(_pointName);
	}

	public void setPointName(String pointName) {
		_pointName = pointName;
	}

	public String getMaxPointName() {
		return GetterUtil.getString(_maxPointName);
	}

	public void setMaxPointName(String maxPointName) {
		_maxPointName = maxPointName;
	}

	public int getPointValue() {
		return _pointValue;
	}

	public void setPointValue(int pointValue) {
		_pointValue = pointValue;
	}

	public int getMaxPointValue() {
		return _maxPointValue;
	}

	public void setMaxPointValue(int maxPointValue) {
		_maxPointValue = maxPointValue;
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

	public ViewPerformanceAppraisalSlots toEscapedModel() {
		if (isEscapedModel()) {
			return (ViewPerformanceAppraisalSlots)this;
		}
		else {
			ViewPerformanceAppraisalSlots model = new ViewPerformanceAppraisalSlotsImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setId(HtmlUtil.escape(getId()));
			model.setSlotId(getSlotId());
			model.setLevelId(getLevelId());
			model.setCompetencyId(getCompetencyId());
			model.setRootId(getRootId());
			model.setSlotName(HtmlUtil.escape(getSlotName()));
			model.setAliasName(HtmlUtil.escape(getAliasName()));
			model.setDescription(HtmlUtil.escape(getDescription()));
			model.setPaId(getPaId());
			model.setSlotNumberOrder(getSlotNumberOrder());
			model.setLevelNumberOrder(getLevelNumberOrder());
			model.setCompetencyNumberOrder(getCompetencyNumberOrder());
			model.setUserId(getUserId());
			model.setPeriodId(getPeriodId());
			model.setPeriodName(HtmlUtil.escape(getPeriodName()));
			model.setFromDate(getFromDate());
			model.setToDate(getToDate());
			model.setBodUid(getBodUid());
			model.setPmUid(getPmUid());
			model.setRatingOrgId(getRatingOrgId());
			model.setRatingStatus(getRatingStatus());
			model.setRatingStatusBod(getRatingStatusBod());
			model.setRatingStatusPm(getRatingStatusPm());
			model.setPointName(HtmlUtil.escape(getPointName()));
			model.setMaxPointName(HtmlUtil.escape(getMaxPointName()));
			model.setPointValue(getPointValue());
			model.setMaxPointValue(getMaxPointValue());
			model.setIsPassed(getIsPassed());

			model = (ViewPerformanceAppraisalSlots)Proxy.newProxyInstance(ViewPerformanceAppraisalSlots.class.getClassLoader(),
					new Class[] { ViewPerformanceAppraisalSlots.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ViewPerformanceAppraisalSlotsImpl clone = new ViewPerformanceAppraisalSlotsImpl();

		clone.setId(getId());
		clone.setSlotId(getSlotId());
		clone.setLevelId(getLevelId());
		clone.setCompetencyId(getCompetencyId());
		clone.setRootId(getRootId());
		clone.setSlotName(getSlotName());
		clone.setAliasName(getAliasName());
		clone.setDescription(getDescription());
		clone.setPaId(getPaId());
		clone.setSlotNumberOrder(getSlotNumberOrder());
		clone.setLevelNumberOrder(getLevelNumberOrder());
		clone.setCompetencyNumberOrder(getCompetencyNumberOrder());
		clone.setUserId(getUserId());
		clone.setPeriodId(getPeriodId());
		clone.setPeriodName(getPeriodName());
		clone.setFromDate(getFromDate());
		clone.setToDate(getToDate());
		clone.setBodUid(getBodUid());
		clone.setPmUid(getPmUid());
		clone.setRatingOrgId(getRatingOrgId());
		clone.setRatingStatus(getRatingStatus());
		clone.setRatingStatusBod(getRatingStatusBod());
		clone.setRatingStatusPm(getRatingStatusPm());
		clone.setPointName(getPointName());
		clone.setMaxPointName(getMaxPointName());
		clone.setPointValue(getPointValue());
		clone.setMaxPointValue(getMaxPointValue());
		clone.setIsPassed(getIsPassed());

		return clone;
	}

	public int compareTo(
		ViewPerformanceAppraisalSlots viewPerformanceAppraisalSlots) {
		String pk = viewPerformanceAppraisalSlots.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ViewPerformanceAppraisalSlots viewPerformanceAppraisalSlots = null;

		try {
			viewPerformanceAppraisalSlots = (ViewPerformanceAppraisalSlots)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String pk = viewPerformanceAppraisalSlots.getPrimaryKey();

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
		sb.append(", slotId=");
		sb.append(getSlotId());
		sb.append(", levelId=");
		sb.append(getLevelId());
		sb.append(", competencyId=");
		sb.append(getCompetencyId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", slotName=");
		sb.append(getSlotName());
		sb.append(", aliasName=");
		sb.append(getAliasName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", paId=");
		sb.append(getPaId());
		sb.append(", slotNumberOrder=");
		sb.append(getSlotNumberOrder());
		sb.append(", levelNumberOrder=");
		sb.append(getLevelNumberOrder());
		sb.append(", competencyNumberOrder=");
		sb.append(getCompetencyNumberOrder());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", periodId=");
		sb.append(getPeriodId());
		sb.append(", periodName=");
		sb.append(getPeriodName());
		sb.append(", fromDate=");
		sb.append(getFromDate());
		sb.append(", toDate=");
		sb.append(getToDate());
		sb.append(", bodUid=");
		sb.append(getBodUid());
		sb.append(", pmUid=");
		sb.append(getPmUid());
		sb.append(", ratingOrgId=");
		sb.append(getRatingOrgId());
		sb.append(", ratingStatus=");
		sb.append(getRatingStatus());
		sb.append(", ratingStatusBod=");
		sb.append(getRatingStatusBod());
		sb.append(", ratingStatusPm=");
		sb.append(getRatingStatusPm());
		sb.append(", pointName=");
		sb.append(getPointName());
		sb.append(", maxPointName=");
		sb.append(getMaxPointName());
		sb.append(", pointValue=");
		sb.append(getPointValue());
		sb.append(", maxPointValue=");
		sb.append(getMaxPointValue());
		sb.append(", isPassed=");
		sb.append(getIsPassed());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.cds.model.ViewPerformanceAppraisalSlots");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>slotId</column-name><column-value><![CDATA[");
		sb.append(getSlotId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>levelId</column-name><column-value><![CDATA[");
		sb.append(getLevelId());
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
			"<column><column-name>slotName</column-name><column-value><![CDATA[");
		sb.append(getSlotName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>aliasName</column-name><column-value><![CDATA[");
		sb.append(getAliasName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paId</column-name><column-value><![CDATA[");
		sb.append(getPaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>slotNumberOrder</column-name><column-value><![CDATA[");
		sb.append(getSlotNumberOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>levelNumberOrder</column-name><column-value><![CDATA[");
		sb.append(getLevelNumberOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>competencyNumberOrder</column-name><column-value><![CDATA[");
		sb.append(getCompetencyNumberOrder());
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
			"<column><column-name>periodName</column-name><column-value><![CDATA[");
		sb.append(getPeriodName());
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
			"<column><column-name>bodUid</column-name><column-value><![CDATA[");
		sb.append(getBodUid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pmUid</column-name><column-value><![CDATA[");
		sb.append(getPmUid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ratingOrgId</column-name><column-value><![CDATA[");
		sb.append(getRatingOrgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ratingStatus</column-name><column-value><![CDATA[");
		sb.append(getRatingStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ratingStatusBod</column-name><column-value><![CDATA[");
		sb.append(getRatingStatusBod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ratingStatusPm</column-name><column-value><![CDATA[");
		sb.append(getRatingStatusPm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pointName</column-name><column-value><![CDATA[");
		sb.append(getPointName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxPointName</column-name><column-value><![CDATA[");
		sb.append(getMaxPointName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pointValue</column-name><column-value><![CDATA[");
		sb.append(getPointValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxPointValue</column-name><column-value><![CDATA[");
		sb.append(getMaxPointValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isPassed</column-name><column-value><![CDATA[");
		sb.append(getIsPassed());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _id;
	private int _slotId;
	private int _levelId;
	private int _competencyId;
	private int _rootId;
	private String _slotName;
	private String _aliasName;
	private String _description;
	private int _paId;
	private int _slotNumberOrder;
	private int _levelNumberOrder;
	private int _competencyNumberOrder;
	private int _userId;
	private int _periodId;
	private String _periodName;
	private Date _fromDate;
	private Date _toDate;
	private int _bodUid;
	private int _pmUid;
	private int _ratingOrgId;
	private int _ratingStatus;
	private int _ratingStatusBod;
	private int _ratingStatusPm;
	private String _pointName;
	private String _maxPointName;
	private int _pointValue;
	private int _maxPointValue;
	private boolean _isPassed;
}