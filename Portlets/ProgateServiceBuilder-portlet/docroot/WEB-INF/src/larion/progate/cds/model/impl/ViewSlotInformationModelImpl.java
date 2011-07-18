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

import larion.progate.cds.model.ViewSlotInformation;
import larion.progate.cds.model.ViewSlotInformationSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="ViewSlotInformationModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewSlotInformationModelImpl extends BaseModelImpl<ViewSlotInformation> {
	public static final String TABLE_NAME = "v_slot_information";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "user_id", new Integer(Types.INTEGER) },
			

			{ "slot_id", new Integer(Types.INTEGER) },
			

			{ "point_name", new Integer(Types.VARCHAR) },
			

			{ "max_point_name", new Integer(Types.VARCHAR) },
			

			{ "is_passed", new Integer(Types.BOOLEAN) },
			

			{ "period_name", new Integer(Types.VARCHAR) },
			

			{ "from_date", new Integer(Types.TIMESTAMP) },
			

			{ "to_date", new Integer(Types.TIMESTAMP) },
			

			{ "pm_name", new Integer(Types.VARCHAR) },
			

			{ "org_name", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table v_slot_information (id INTEGER not null primary key,root_id INTEGER,user_id INTEGER,slot_id INTEGER,point_name VARCHAR(75) null,max_point_name VARCHAR(75) null,is_passed BOOLEAN,period_name VARCHAR(75) null,from_date DATE null,to_date DATE null,pm_name VARCHAR(75) null,org_name VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table v_slot_information";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.cds.model.ViewSlotInformation"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.cds.model.ViewSlotInformation"),
			false);

	public static ViewSlotInformation toModel(ViewSlotInformationSoap soapModel) {
		ViewSlotInformation model = new ViewSlotInformationImpl();

		model.setViewSlotInformationId(soapModel.getViewSlotInformationId());
		model.setRootId(soapModel.getRootId());
		model.setUserId(soapModel.getUserId());
		model.setSlotId(soapModel.getSlotId());
		model.setPointName(soapModel.getPointName());
		model.setMaxPointName(soapModel.getMaxPointName());
		model.setIsPassed(soapModel.getIsPassed());
		model.setPeriodName(soapModel.getPeriodName());
		model.setFromDate(soapModel.getFromDate());
		model.setToDate(soapModel.getToDate());
		model.setPmName(soapModel.getPmName());
		model.setOrgName(soapModel.getOrgName());

		return model;
	}

	public static List<ViewSlotInformation> toModels(
		ViewSlotInformationSoap[] soapModels) {
		List<ViewSlotInformation> models = new ArrayList<ViewSlotInformation>(soapModels.length);

		for (ViewSlotInformationSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.cds.model.ViewSlotInformation"));

	public ViewSlotInformationModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _viewSlotInformationId;
	}

	public void setPrimaryKey(Integer pk) {
		setViewSlotInformationId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _viewSlotInformationId;
	}

	public Integer getViewSlotInformationId() {
		return _viewSlotInformationId;
	}

	public void setViewSlotInformationId(Integer viewSlotInformationId) {
		_viewSlotInformationId = viewSlotInformationId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public int getSlotId() {
		return _slotId;
	}

	public void setSlotId(int slotId) {
		_slotId = slotId;
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

	public boolean getIsPassed() {
		return _isPassed;
	}

	public boolean isIsPassed() {
		return _isPassed;
	}

	public void setIsPassed(boolean isPassed) {
		_isPassed = isPassed;
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

	public String getPmName() {
		return GetterUtil.getString(_pmName);
	}

	public void setPmName(String pmName) {
		_pmName = pmName;
	}

	public String getOrgName() {
		return GetterUtil.getString(_orgName);
	}

	public void setOrgName(String orgName) {
		_orgName = orgName;
	}

	public ViewSlotInformation toEscapedModel() {
		if (isEscapedModel()) {
			return (ViewSlotInformation)this;
		}
		else {
			ViewSlotInformation model = new ViewSlotInformationImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setViewSlotInformationId(getViewSlotInformationId());
			model.setRootId(getRootId());
			model.setUserId(getUserId());
			model.setSlotId(getSlotId());
			model.setPointName(HtmlUtil.escape(getPointName()));
			model.setMaxPointName(HtmlUtil.escape(getMaxPointName()));
			model.setIsPassed(getIsPassed());
			model.setPeriodName(HtmlUtil.escape(getPeriodName()));
			model.setFromDate(getFromDate());
			model.setToDate(getToDate());
			model.setPmName(HtmlUtil.escape(getPmName()));
			model.setOrgName(HtmlUtil.escape(getOrgName()));

			model = (ViewSlotInformation)Proxy.newProxyInstance(ViewSlotInformation.class.getClassLoader(),
					new Class[] { ViewSlotInformation.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ViewSlotInformationImpl clone = new ViewSlotInformationImpl();

		clone.setViewSlotInformationId(getViewSlotInformationId());
		clone.setRootId(getRootId());
		clone.setUserId(getUserId());
		clone.setSlotId(getSlotId());
		clone.setPointName(getPointName());
		clone.setMaxPointName(getMaxPointName());
		clone.setIsPassed(getIsPassed());
		clone.setPeriodName(getPeriodName());
		clone.setFromDate(getFromDate());
		clone.setToDate(getToDate());
		clone.setPmName(getPmName());
		clone.setOrgName(getOrgName());

		return clone;
	}

	public int compareTo(ViewSlotInformation viewSlotInformation) {
		int value = 0;

		value = DateUtil.compareTo(getToDate(), viewSlotInformation.getToDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ViewSlotInformation viewSlotInformation = null;

		try {
			viewSlotInformation = (ViewSlotInformation)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = viewSlotInformation.getPrimaryKey();

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

		sb.append("{viewSlotInformationId=");
		sb.append(getViewSlotInformationId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", slotId=");
		sb.append(getSlotId());
		sb.append(", pointName=");
		sb.append(getPointName());
		sb.append(", maxPointName=");
		sb.append(getMaxPointName());
		sb.append(", isPassed=");
		sb.append(getIsPassed());
		sb.append(", periodName=");
		sb.append(getPeriodName());
		sb.append(", fromDate=");
		sb.append(getFromDate());
		sb.append(", toDate=");
		sb.append(getToDate());
		sb.append(", pmName=");
		sb.append(getPmName());
		sb.append(", orgName=");
		sb.append(getOrgName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.cds.model.ViewSlotInformation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>viewSlotInformationId</column-name><column-value><![CDATA[");
		sb.append(getViewSlotInformationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>slotId</column-name><column-value><![CDATA[");
		sb.append(getSlotId());
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
			"<column><column-name>isPassed</column-name><column-value><![CDATA[");
		sb.append(getIsPassed());
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
			"<column><column-name>pmName</column-name><column-value><![CDATA[");
		sb.append(getPmName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgName</column-name><column-value><![CDATA[");
		sb.append(getOrgName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _viewSlotInformationId;
	private int _rootId;
	private int _userId;
	private int _slotId;
	private String _pointName;
	private String _maxPointName;
	private boolean _isPassed;
	private String _periodName;
	private Date _fromDate;
	private Date _toDate;
	private String _pmName;
	private String _orgName;
}