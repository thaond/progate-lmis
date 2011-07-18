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

import larion.progate.cds.model.ViewEmployeesSlotsRating;
import larion.progate.cds.model.ViewEmployeesSlotsRatingSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="ViewEmployeesSlotsRatingModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewEmployeesSlotsRatingModelImpl extends BaseModelImpl<ViewEmployeesSlotsRating> {
	public static final String TABLE_NAME = "v_performance_appraisal_slots";
	public static final Object[][] TABLE_COLUMNS = {
			{ "view_id", new Integer(Types.VARCHAR) },
			

			{ "alias_name", new Integer(Types.VARCHAR) },
			

			{ "description", new Integer(Types.VARCHAR) },
			

			{ "number_order", new Integer(Types.INTEGER) },
			

			{ "user_id", new Integer(Types.INTEGER) },
			

			{ "period_id", new Integer(Types.INTEGER) },
			

			{ "period_name", new Integer(Types.VARCHAR) },
			

			{ "from_date", new Integer(Types.TIMESTAMP) },
			

			{ "to_date", new Integer(Types.TIMESTAMP) },
			

			{ "rating_org_id", new Integer(Types.INTEGER) },
			

			{ "rating_status", new Integer(Types.INTEGER) },
			

			{ "rating_status_bod", new Integer(Types.INTEGER) },
			

			{ "rating_status_pm", new Integer(Types.INTEGER) }
		};
	public static final String TABLE_SQL_CREATE = "create table v_performance_appraisal_slots (view_id VARCHAR(75) not null primary key,alias_name VARCHAR(75) null,description VARCHAR(75) null,number_order INTEGER,user_id INTEGER,period_id INTEGER,period_name VARCHAR(75) null,from_date DATE null,to_date DATE null,rating_org_id INTEGER,rating_status INTEGER,rating_status_bod INTEGER,rating_status_pm INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table v_performance_appraisal_slots";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.cds.model.ViewEmployeesSlotsRating"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.cds.model.ViewEmployeesSlotsRating"),
			false);

	public static ViewEmployeesSlotsRating toModel(
		ViewEmployeesSlotsRatingSoap soapModel) {
		ViewEmployeesSlotsRating model = new ViewEmployeesSlotsRatingImpl();

		model.setId(soapModel.getId());
		model.setAliasName(soapModel.getAliasName());
		model.setDescription(soapModel.getDescription());
		model.setNumberOrder(soapModel.getNumberOrder());
		model.setUserId(soapModel.getUserId());
		model.setPeriodId(soapModel.getPeriodId());
		model.setPeriodName(soapModel.getPeriodName());
		model.setFromDate(soapModel.getFromDate());
		model.setToDate(soapModel.getToDate());
		model.setRatingOrgId(soapModel.getRatingOrgId());
		model.setRatingStatus(soapModel.getRatingStatus());
		model.setRatingStatusBod(soapModel.getRatingStatusBod());
		model.setRatingStatusPm(soapModel.getRatingStatusPm());

		return model;
	}

	public static List<ViewEmployeesSlotsRating> toModels(
		ViewEmployeesSlotsRatingSoap[] soapModels) {
		List<ViewEmployeesSlotsRating> models = new ArrayList<ViewEmployeesSlotsRating>(soapModels.length);

		for (ViewEmployeesSlotsRatingSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.cds.model.ViewEmployeesSlotsRating"));

	public ViewEmployeesSlotsRatingModelImpl() {
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

	public int getNumberOrder() {
		return _numberOrder;
	}

	public void setNumberOrder(int numberOrder) {
		_numberOrder = numberOrder;
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

	public ViewEmployeesSlotsRating toEscapedModel() {
		if (isEscapedModel()) {
			return (ViewEmployeesSlotsRating)this;
		}
		else {
			ViewEmployeesSlotsRating model = new ViewEmployeesSlotsRatingImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setId(HtmlUtil.escape(getId()));
			model.setAliasName(HtmlUtil.escape(getAliasName()));
			model.setDescription(HtmlUtil.escape(getDescription()));
			model.setNumberOrder(getNumberOrder());
			model.setUserId(getUserId());
			model.setPeriodId(getPeriodId());
			model.setPeriodName(HtmlUtil.escape(getPeriodName()));
			model.setFromDate(getFromDate());
			model.setToDate(getToDate());
			model.setRatingOrgId(getRatingOrgId());
			model.setRatingStatus(getRatingStatus());
			model.setRatingStatusBod(getRatingStatusBod());
			model.setRatingStatusPm(getRatingStatusPm());

			model = (ViewEmployeesSlotsRating)Proxy.newProxyInstance(ViewEmployeesSlotsRating.class.getClassLoader(),
					new Class[] { ViewEmployeesSlotsRating.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ViewEmployeesSlotsRatingImpl clone = new ViewEmployeesSlotsRatingImpl();

		clone.setId(getId());
		clone.setAliasName(getAliasName());
		clone.setDescription(getDescription());
		clone.setNumberOrder(getNumberOrder());
		clone.setUserId(getUserId());
		clone.setPeriodId(getPeriodId());
		clone.setPeriodName(getPeriodName());
		clone.setFromDate(getFromDate());
		clone.setToDate(getToDate());
		clone.setRatingOrgId(getRatingOrgId());
		clone.setRatingStatus(getRatingStatus());
		clone.setRatingStatusBod(getRatingStatusBod());
		clone.setRatingStatusPm(getRatingStatusPm());

		return clone;
	}

	public int compareTo(ViewEmployeesSlotsRating viewEmployeesSlotsRating) {
		String pk = viewEmployeesSlotsRating.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ViewEmployeesSlotsRating viewEmployeesSlotsRating = null;

		try {
			viewEmployeesSlotsRating = (ViewEmployeesSlotsRating)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String pk = viewEmployeesSlotsRating.getPrimaryKey();

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
		sb.append(", aliasName=");
		sb.append(getAliasName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", numberOrder=");
		sb.append(getNumberOrder());
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
		sb.append(", ratingOrgId=");
		sb.append(getRatingOrgId());
		sb.append(", ratingStatus=");
		sb.append(getRatingStatus());
		sb.append(", ratingStatusBod=");
		sb.append(getRatingStatusBod());
		sb.append(", ratingStatusPm=");
		sb.append(getRatingStatusPm());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.cds.model.ViewEmployeesSlotsRating");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
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
			"<column><column-name>numberOrder</column-name><column-value><![CDATA[");
		sb.append(getNumberOrder());
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

		sb.append("</model>");

		return sb.toString();
	}

	private String _id;
	private String _aliasName;
	private String _description;
	private int _numberOrder;
	private int _userId;
	private int _periodId;
	private String _periodName;
	private Date _fromDate;
	private Date _toDate;
	private int _ratingOrgId;
	private int _ratingStatus;
	private int _ratingStatusBod;
	private int _ratingStatusPm;
}