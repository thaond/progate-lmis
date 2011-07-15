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

import larion.progate.lmis.model.LmisViewWorkingCalendar;
import larion.progate.lmis.model.LmisViewWorkingCalendarSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisViewWorkingCalendarModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewWorkingCalendarModelImpl extends BaseModelImpl<LmisViewWorkingCalendar> {
	public static final String TABLE_NAME = "vw_working_calendar";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "day_value", new Integer(Types.TIMESTAMP) },
			

			{ "day_type", new Integer(Types.INTEGER) },
			

			{ "is_modified", new Integer(Types.BOOLEAN) },
			

			{ "total_working_time", new Integer(Types.DOUBLE) },
			

			{ "is_related_session", new Integer(Types.BOOLEAN) },
			

			{ "name", new Integer(Types.VARCHAR) },
			

			{ "description", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table vw_working_calendar (id INTEGER not null primary key,root_id INTEGER,day_value DATE null,day_type INTEGER,is_modified BOOLEAN,total_working_time DOUBLE,is_related_session BOOLEAN,name VARCHAR(75) null,description VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table vw_working_calendar";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.lmis.model.LmisViewWorkingCalendar"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.lmis.model.LmisViewWorkingCalendar"),
			false);

	public static LmisViewWorkingCalendar toModel(
		LmisViewWorkingCalendarSoap soapModel) {
		LmisViewWorkingCalendar model = new LmisViewWorkingCalendarImpl();

		model.setLmisViewWorkingCalendarId(soapModel.getLmisViewWorkingCalendarId());
		model.setRootId(soapModel.getRootId());
		model.setDayValue(soapModel.getDayValue());
		model.setDayType(soapModel.getDayType());
		model.setIsModified(soapModel.getIsModified());
		model.setTotalWorkingTime(soapModel.getTotalWorkingTime());
		model.setIsRelatedSession(soapModel.getIsRelatedSession());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());

		return model;
	}

	public static List<LmisViewWorkingCalendar> toModels(
		LmisViewWorkingCalendarSoap[] soapModels) {
		List<LmisViewWorkingCalendar> models = new ArrayList<LmisViewWorkingCalendar>(soapModels.length);

		for (LmisViewWorkingCalendarSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.lmis.model.LmisViewWorkingCalendar"));

	public LmisViewWorkingCalendarModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _lmisViewWorkingCalendarId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisViewWorkingCalendarId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisViewWorkingCalendarId;
	}

	public Integer getLmisViewWorkingCalendarId() {
		return _lmisViewWorkingCalendarId;
	}

	public void setLmisViewWorkingCalendarId(Integer lmisViewWorkingCalendarId) {
		_lmisViewWorkingCalendarId = lmisViewWorkingCalendarId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public Date getDayValue() {
		return _dayValue;
	}

	public void setDayValue(Date dayValue) {
		_dayValue = dayValue;
	}

	public int getDayType() {
		return _dayType;
	}

	public void setDayType(int dayType) {
		_dayType = dayType;
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

	public double getTotalWorkingTime() {
		return _totalWorkingTime;
	}

	public void setTotalWorkingTime(double totalWorkingTime) {
		_totalWorkingTime = totalWorkingTime;
	}

	public boolean getIsRelatedSession() {
		return _isRelatedSession;
	}

	public boolean isIsRelatedSession() {
		return _isRelatedSession;
	}

	public void setIsRelatedSession(boolean isRelatedSession) {
		_isRelatedSession = isRelatedSession;
	}

	public String getName() {
		return GetterUtil.getString(_name);
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return GetterUtil.getString(_description);
	}

	public void setDescription(String description) {
		_description = description;
	}

	public LmisViewWorkingCalendar toEscapedModel() {
		if (isEscapedModel()) {
			return (LmisViewWorkingCalendar)this;
		}
		else {
			LmisViewWorkingCalendar model = new LmisViewWorkingCalendarImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setLmisViewWorkingCalendarId(getLmisViewWorkingCalendarId());
			model.setRootId(getRootId());
			model.setDayValue(getDayValue());
			model.setDayType(getDayType());
			model.setIsModified(getIsModified());
			model.setTotalWorkingTime(getTotalWorkingTime());
			model.setIsRelatedSession(getIsRelatedSession());
			model.setName(HtmlUtil.escape(getName()));
			model.setDescription(HtmlUtil.escape(getDescription()));

			model = (LmisViewWorkingCalendar)Proxy.newProxyInstance(LmisViewWorkingCalendar.class.getClassLoader(),
					new Class[] { LmisViewWorkingCalendar.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisViewWorkingCalendarImpl clone = new LmisViewWorkingCalendarImpl();

		clone.setLmisViewWorkingCalendarId(getLmisViewWorkingCalendarId());
		clone.setRootId(getRootId());
		clone.setDayValue(getDayValue());
		clone.setDayType(getDayType());
		clone.setIsModified(getIsModified());
		clone.setTotalWorkingTime(getTotalWorkingTime());
		clone.setIsRelatedSession(getIsRelatedSession());
		clone.setName(getName());
		clone.setDescription(getDescription());

		return clone;
	}

	public int compareTo(LmisViewWorkingCalendar lmisViewWorkingCalendar) {
		Integer pk = lmisViewWorkingCalendar.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisViewWorkingCalendar lmisViewWorkingCalendar = null;

		try {
			lmisViewWorkingCalendar = (LmisViewWorkingCalendar)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisViewWorkingCalendar.getPrimaryKey();

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

		sb.append("{lmisViewWorkingCalendarId=");
		sb.append(getLmisViewWorkingCalendarId());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", dayValue=");
		sb.append(getDayValue());
		sb.append(", dayType=");
		sb.append(getDayType());
		sb.append(", isModified=");
		sb.append(getIsModified());
		sb.append(", totalWorkingTime=");
		sb.append(getTotalWorkingTime());
		sb.append(", isRelatedSession=");
		sb.append(getIsRelatedSession());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisViewWorkingCalendar");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisViewWorkingCalendarId</column-name><column-value><![CDATA[");
		sb.append(getLmisViewWorkingCalendarId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dayValue</column-name><column-value><![CDATA[");
		sb.append(getDayValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dayType</column-name><column-value><![CDATA[");
		sb.append(getDayType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isModified</column-name><column-value><![CDATA[");
		sb.append(getIsModified());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalWorkingTime</column-name><column-value><![CDATA[");
		sb.append(getTotalWorkingTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isRelatedSession</column-name><column-value><![CDATA[");
		sb.append(getIsRelatedSession());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisViewWorkingCalendarId;
	private int _rootId;
	private Date _dayValue;
	private int _dayType;
	private boolean _isModified;
	private double _totalWorkingTime;
	private boolean _isRelatedSession;
	private String _name;
	private String _description;
}