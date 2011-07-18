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

import larion.progate.cds.model.ViewEmployeesInProjects;
import larion.progate.cds.model.ViewEmployeesInProjectsSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="ViewEmployeesInProjectsModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ViewEmployeesInProjectsModelImpl extends BaseModelImpl<ViewEmployeesInProjects> {
	public static final String TABLE_NAME = "v_employees_in_projects";
	public static final Object[][] TABLE_COLUMNS = {
			{ "view_id", new Integer(Types.VARCHAR) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "user_id", new Integer(Types.INTEGER) },
			

			{ "firstname", new Integer(Types.VARCHAR) },
			

			{ "middlename", new Integer(Types.VARCHAR) },
			

			{ "lastname", new Integer(Types.VARCHAR) },
			

			{ "position", new Integer(Types.VARCHAR) },
			

			{ "title_abbreviation", new Integer(Types.VARCHAR) },
			

			{ "title_name", new Integer(Types.VARCHAR) },
			

			{ "org_id", new Integer(Types.INTEGER) },
			

			{ "org_list", new Integer(Types.VARCHAR) },
			

			{ "pm_list", new Integer(Types.VARCHAR) },
			

			{ "period_id", new Integer(Types.INTEGER) },
			

			{ "period_name", new Integer(Types.VARCHAR) },
			

			{ "from_date", new Integer(Types.TIMESTAMP) },
			

			{ "to_date", new Integer(Types.TIMESTAMP) },
			

			{ "period_status", new Integer(Types.INTEGER) },
			

			{ "rating_status", new Integer(Types.INTEGER) },
			

			{ "rating_status_pm", new Integer(Types.INTEGER) },
			

			{ "rating_status_bod", new Integer(Types.INTEGER) },
			

			{ "is_active", new Integer(Types.BOOLEAN) },
			

			{ "is_removed", new Integer(Types.BOOLEAN) },
			

			{ "is_locked", new Integer(Types.BOOLEAN) },
			

			{ "begin_time", new Integer(Types.TIMESTAMP) },
			

			{ "end_time", new Integer(Types.TIMESTAMP) },
			

			{ "is_title_up", new Integer(Types.BOOLEAN) }
		};
	public static final String TABLE_SQL_CREATE = "create table v_employees_in_projects (view_id VARCHAR(75) not null primary key,root_id INTEGER,user_id INTEGER,firstname VARCHAR(75) null,middlename VARCHAR(75) null,lastname VARCHAR(75) null,position VARCHAR(75) null,title_abbreviation VARCHAR(75) null,title_name VARCHAR(75) null,org_id INTEGER,org_list VARCHAR(75) null,pm_list VARCHAR(75) null,period_id INTEGER,period_name VARCHAR(75) null,from_date DATE null,to_date DATE null,period_status INTEGER,rating_status INTEGER,rating_status_pm INTEGER,rating_status_bod INTEGER,is_active BOOLEAN,is_removed BOOLEAN,is_locked BOOLEAN,begin_time DATE null,end_time DATE null,is_title_up BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table v_employees_in_projects";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.cds.model.ViewEmployeesInProjects"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.cds.model.ViewEmployeesInProjects"),
			false);

	public static ViewEmployeesInProjects toModel(
		ViewEmployeesInProjectsSoap soapModel) {
		ViewEmployeesInProjects model = new ViewEmployeesInProjectsImpl();

		model.setId(soapModel.getId());
		model.setRootId(soapModel.getRootId());
		model.setUserId(soapModel.getUserId());
		model.setFirstName(soapModel.getFirstName());
		model.setMiddleName(soapModel.getMiddleName());
		model.setLastName(soapModel.getLastName());
		model.setPosition(soapModel.getPosition());
		model.setTitleAbbreviation(soapModel.getTitleAbbreviation());
		model.setTitleName(soapModel.getTitleName());
		model.setOrgId(soapModel.getOrgId());
		model.setOrgList(soapModel.getOrgList());
		model.setPmList(soapModel.getPmList());
		model.setPeriodId(soapModel.getPeriodId());
		model.setPeriodName(soapModel.getPeriodName());
		model.setFromDate(soapModel.getFromDate());
		model.setToDate(soapModel.getToDate());
		model.setPeriodStatus(soapModel.getPeriodStatus());
		model.setRatingStatus(soapModel.getRatingStatus());
		model.setRatingStatusPm(soapModel.getRatingStatusPm());
		model.setRatingStatusBod(soapModel.getRatingStatusBod());
		model.setIsActive(soapModel.getIsActive());
		model.setIsRemoved(soapModel.getIsRemoved());
		model.setIsLocked(soapModel.getIsLocked());
		model.setBeginTime(soapModel.getBeginTime());
		model.setEndTime(soapModel.getEndTime());
		model.setIsTitleUp(soapModel.getIsTitleUp());

		return model;
	}

	public static List<ViewEmployeesInProjects> toModels(
		ViewEmployeesInProjectsSoap[] soapModels) {
		List<ViewEmployeesInProjects> models = new ArrayList<ViewEmployeesInProjects>(soapModels.length);

		for (ViewEmployeesInProjectsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.cds.model.ViewEmployeesInProjects"));

	public ViewEmployeesInProjectsModelImpl() {
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

	public String getFirstName() {
		return GetterUtil.getString(_firstName);
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getMiddleName() {
		return GetterUtil.getString(_middleName);
	}

	public void setMiddleName(String middleName) {
		_middleName = middleName;
	}

	public String getLastName() {
		return GetterUtil.getString(_lastName);
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getPosition() {
		return GetterUtil.getString(_position);
	}

	public void setPosition(String position) {
		_position = position;
	}

	public String getTitleAbbreviation() {
		return GetterUtil.getString(_titleAbbreviation);
	}

	public void setTitleAbbreviation(String titleAbbreviation) {
		_titleAbbreviation = titleAbbreviation;
	}

	public String getTitleName() {
		return GetterUtil.getString(_titleName);
	}

	public void setTitleName(String titleName) {
		_titleName = titleName;
	}

	public int getOrgId() {
		return _orgId;
	}

	public void setOrgId(int orgId) {
		_orgId = orgId;
	}

	public String getOrgList() {
		return GetterUtil.getString(_orgList);
	}

	public void setOrgList(String orgList) {
		_orgList = orgList;
	}

	public String getPmList() {
		return GetterUtil.getString(_pmList);
	}

	public void setPmList(String pmList) {
		_pmList = pmList;
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

	public int getPeriodStatus() {
		return _periodStatus;
	}

	public void setPeriodStatus(int periodStatus) {
		_periodStatus = periodStatus;
	}

	public int getRatingStatus() {
		return _ratingStatus;
	}

	public void setRatingStatus(int ratingStatus) {
		_ratingStatus = ratingStatus;
	}

	public int getRatingStatusPm() {
		return _ratingStatusPm;
	}

	public void setRatingStatusPm(int ratingStatusPm) {
		_ratingStatusPm = ratingStatusPm;
	}

	public int getRatingStatusBod() {
		return _ratingStatusBod;
	}

	public void setRatingStatusBod(int ratingStatusBod) {
		_ratingStatusBod = ratingStatusBod;
	}

	public boolean getIsActive() {
		return _isActive;
	}

	public boolean isIsActive() {
		return _isActive;
	}

	public void setIsActive(boolean isActive) {
		_isActive = isActive;
	}

	public boolean getIsRemoved() {
		return _isRemoved;
	}

	public boolean isIsRemoved() {
		return _isRemoved;
	}

	public void setIsRemoved(boolean isRemoved) {
		_isRemoved = isRemoved;
	}

	public boolean getIsLocked() {
		return _isLocked;
	}

	public boolean isIsLocked() {
		return _isLocked;
	}

	public void setIsLocked(boolean isLocked) {
		_isLocked = isLocked;
	}

	public Date getBeginTime() {
		return _beginTime;
	}

	public void setBeginTime(Date beginTime) {
		_beginTime = beginTime;
	}

	public Date getEndTime() {
		return _endTime;
	}

	public void setEndTime(Date endTime) {
		_endTime = endTime;
	}

	public boolean getIsTitleUp() {
		return _isTitleUp;
	}

	public boolean isIsTitleUp() {
		return _isTitleUp;
	}

	public void setIsTitleUp(boolean isTitleUp) {
		_isTitleUp = isTitleUp;
	}

	public ViewEmployeesInProjects toEscapedModel() {
		if (isEscapedModel()) {
			return (ViewEmployeesInProjects)this;
		}
		else {
			ViewEmployeesInProjects model = new ViewEmployeesInProjectsImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setId(HtmlUtil.escape(getId()));
			model.setRootId(getRootId());
			model.setUserId(getUserId());
			model.setFirstName(HtmlUtil.escape(getFirstName()));
			model.setMiddleName(HtmlUtil.escape(getMiddleName()));
			model.setLastName(HtmlUtil.escape(getLastName()));
			model.setPosition(HtmlUtil.escape(getPosition()));
			model.setTitleAbbreviation(HtmlUtil.escape(getTitleAbbreviation()));
			model.setTitleName(HtmlUtil.escape(getTitleName()));
			model.setOrgId(getOrgId());
			model.setOrgList(HtmlUtil.escape(getOrgList()));
			model.setPmList(HtmlUtil.escape(getPmList()));
			model.setPeriodId(getPeriodId());
			model.setPeriodName(HtmlUtil.escape(getPeriodName()));
			model.setFromDate(getFromDate());
			model.setToDate(getToDate());
			model.setPeriodStatus(getPeriodStatus());
			model.setRatingStatus(getRatingStatus());
			model.setRatingStatusPm(getRatingStatusPm());
			model.setRatingStatusBod(getRatingStatusBod());
			model.setIsActive(getIsActive());
			model.setIsRemoved(getIsRemoved());
			model.setIsLocked(getIsLocked());
			model.setBeginTime(getBeginTime());
			model.setEndTime(getEndTime());
			model.setIsTitleUp(getIsTitleUp());

			model = (ViewEmployeesInProjects)Proxy.newProxyInstance(ViewEmployeesInProjects.class.getClassLoader(),
					new Class[] { ViewEmployeesInProjects.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		ViewEmployeesInProjectsImpl clone = new ViewEmployeesInProjectsImpl();

		clone.setId(getId());
		clone.setRootId(getRootId());
		clone.setUserId(getUserId());
		clone.setFirstName(getFirstName());
		clone.setMiddleName(getMiddleName());
		clone.setLastName(getLastName());
		clone.setPosition(getPosition());
		clone.setTitleAbbreviation(getTitleAbbreviation());
		clone.setTitleName(getTitleName());
		clone.setOrgId(getOrgId());
		clone.setOrgList(getOrgList());
		clone.setPmList(getPmList());
		clone.setPeriodId(getPeriodId());
		clone.setPeriodName(getPeriodName());
		clone.setFromDate(getFromDate());
		clone.setToDate(getToDate());
		clone.setPeriodStatus(getPeriodStatus());
		clone.setRatingStatus(getRatingStatus());
		clone.setRatingStatusPm(getRatingStatusPm());
		clone.setRatingStatusBod(getRatingStatusBod());
		clone.setIsActive(getIsActive());
		clone.setIsRemoved(getIsRemoved());
		clone.setIsLocked(getIsLocked());
		clone.setBeginTime(getBeginTime());
		clone.setEndTime(getEndTime());
		clone.setIsTitleUp(getIsTitleUp());

		return clone;
	}

	public int compareTo(ViewEmployeesInProjects viewEmployeesInProjects) {
		int value = 0;

		value = getFirstName().compareTo(viewEmployeesInProjects.getFirstName());

		if (value != 0) {
			return value;
		}

		value = getLastName().compareTo(viewEmployeesInProjects.getLastName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ViewEmployeesInProjects viewEmployeesInProjects = null;

		try {
			viewEmployeesInProjects = (ViewEmployeesInProjects)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String pk = viewEmployeesInProjects.getPrimaryKey();

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
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", middleName=");
		sb.append(getMiddleName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", position=");
		sb.append(getPosition());
		sb.append(", titleAbbreviation=");
		sb.append(getTitleAbbreviation());
		sb.append(", titleName=");
		sb.append(getTitleName());
		sb.append(", orgId=");
		sb.append(getOrgId());
		sb.append(", orgList=");
		sb.append(getOrgList());
		sb.append(", pmList=");
		sb.append(getPmList());
		sb.append(", periodId=");
		sb.append(getPeriodId());
		sb.append(", periodName=");
		sb.append(getPeriodName());
		sb.append(", fromDate=");
		sb.append(getFromDate());
		sb.append(", toDate=");
		sb.append(getToDate());
		sb.append(", periodStatus=");
		sb.append(getPeriodStatus());
		sb.append(", ratingStatus=");
		sb.append(getRatingStatus());
		sb.append(", ratingStatusPm=");
		sb.append(getRatingStatusPm());
		sb.append(", ratingStatusBod=");
		sb.append(getRatingStatusBod());
		sb.append(", isActive=");
		sb.append(getIsActive());
		sb.append(", isRemoved=");
		sb.append(getIsRemoved());
		sb.append(", isLocked=");
		sb.append(getIsLocked());
		sb.append(", beginTime=");
		sb.append(getBeginTime());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append(", isTitleUp=");
		sb.append(getIsTitleUp());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.cds.model.ViewEmployeesInProjects");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
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
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>middleName</column-name><column-value><![CDATA[");
		sb.append(getMiddleName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>position</column-name><column-value><![CDATA[");
		sb.append(getPosition());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>titleAbbreviation</column-name><column-value><![CDATA[");
		sb.append(getTitleAbbreviation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>titleName</column-name><column-value><![CDATA[");
		sb.append(getTitleName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgId</column-name><column-value><![CDATA[");
		sb.append(getOrgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgList</column-name><column-value><![CDATA[");
		sb.append(getOrgList());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pmList</column-name><column-value><![CDATA[");
		sb.append(getPmList());
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
			"<column><column-name>periodStatus</column-name><column-value><![CDATA[");
		sb.append(getPeriodStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ratingStatus</column-name><column-value><![CDATA[");
		sb.append(getRatingStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ratingStatusPm</column-name><column-value><![CDATA[");
		sb.append(getRatingStatusPm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ratingStatusBod</column-name><column-value><![CDATA[");
		sb.append(getRatingStatusBod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isActive</column-name><column-value><![CDATA[");
		sb.append(getIsActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isRemoved</column-name><column-value><![CDATA[");
		sb.append(getIsRemoved());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isLocked</column-name><column-value><![CDATA[");
		sb.append(getIsLocked());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>beginTime</column-name><column-value><![CDATA[");
		sb.append(getBeginTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endTime</column-name><column-value><![CDATA[");
		sb.append(getEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isTitleUp</column-name><column-value><![CDATA[");
		sb.append(getIsTitleUp());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _id;
	private int _rootId;
	private int _userId;
	private String _firstName;
	private String _middleName;
	private String _lastName;
	private String _position;
	private String _titleAbbreviation;
	private String _titleName;
	private int _orgId;
	private String _orgList;
	private String _pmList;
	private int _periodId;
	private String _periodName;
	private Date _fromDate;
	private Date _toDate;
	private int _periodStatus;
	private int _ratingStatus;
	private int _ratingStatusPm;
	private int _ratingStatusBod;
	private boolean _isActive;
	private boolean _isRemoved;
	private boolean _isLocked;
	private Date _beginTime;
	private Date _endTime;
	private boolean _isTitleUp;
}