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

package larion.progate.lmis.model;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * <a href="LmisViewWorkingCalendarClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewWorkingCalendarClp extends BaseModelImpl<LmisViewWorkingCalendar>
	implements LmisViewWorkingCalendar {
	public LmisViewWorkingCalendarClp() {
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
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public LmisViewWorkingCalendar toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			LmisViewWorkingCalendar model = new LmisViewWorkingCalendarClp();

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
		LmisViewWorkingCalendarClp clone = new LmisViewWorkingCalendarClp();

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

		LmisViewWorkingCalendarClp lmisViewWorkingCalendar = null;

		try {
			lmisViewWorkingCalendar = (LmisViewWorkingCalendarClp)obj;
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