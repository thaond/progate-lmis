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
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * <a href="LmisWorkingCalendarSessionsClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisWorkingCalendarSessionsClp extends BaseModelImpl<LmisWorkingCalendarSessions>
	implements LmisWorkingCalendarSessions {
	public LmisWorkingCalendarSessionsClp() {
	}

	public Integer getPrimaryKey() {
		return _lmisWorkingCalendarSessionID;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisWorkingCalendarSessionID(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisWorkingCalendarSessionID;
	}

	public Integer getLmisWorkingCalendarSessionID() {
		return _lmisWorkingCalendarSessionID;
	}

	public void setLmisWorkingCalendarSessionID(
		Integer lmisWorkingCalendarSessionID) {
		_lmisWorkingCalendarSessionID = lmisWorkingCalendarSessionID;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getCalendarId() {
		return _calendarId;
	}

	public void setCalendarId(int calendarId) {
		_calendarId = calendarId;
	}

	public int getSessionId() {
		return _sessionId;
	}

	public void setSessionId(int sessionId) {
		_sessionId = sessionId;
	}

	public LmisWorkingCalendarSessions toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			LmisWorkingCalendarSessions model = new LmisWorkingCalendarSessionsClp();

			model.setEscapedModel(true);

			model.setLmisWorkingCalendarSessionID(getLmisWorkingCalendarSessionID());
			model.setRootId(getRootId());
			model.setCalendarId(getCalendarId());
			model.setSessionId(getSessionId());

			model = (LmisWorkingCalendarSessions)Proxy.newProxyInstance(LmisWorkingCalendarSessions.class.getClassLoader(),
					new Class[] { LmisWorkingCalendarSessions.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisWorkingCalendarSessionsClp clone = new LmisWorkingCalendarSessionsClp();

		clone.setLmisWorkingCalendarSessionID(getLmisWorkingCalendarSessionID());
		clone.setRootId(getRootId());
		clone.setCalendarId(getCalendarId());
		clone.setSessionId(getSessionId());

		return clone;
	}

	public int compareTo(
		LmisWorkingCalendarSessions lmisWorkingCalendarSessions) {
		Integer pk = lmisWorkingCalendarSessions.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisWorkingCalendarSessionsClp lmisWorkingCalendarSessions = null;

		try {
			lmisWorkingCalendarSessions = (LmisWorkingCalendarSessionsClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisWorkingCalendarSessions.getPrimaryKey();

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

		sb.append("{lmisWorkingCalendarSessionID=");
		sb.append(getLmisWorkingCalendarSessionID());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", calendarId=");
		sb.append(getCalendarId());
		sb.append(", sessionId=");
		sb.append(getSessionId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisWorkingCalendarSessions");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisWorkingCalendarSessionID</column-name><column-value><![CDATA[");
		sb.append(getLmisWorkingCalendarSessionID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>calendarId</column-name><column-value><![CDATA[");
		sb.append(getCalendarId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sessionId</column-name><column-value><![CDATA[");
		sb.append(getSessionId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _lmisWorkingCalendarSessionID;
	private int _rootId;
	private int _calendarId;
	private int _sessionId;
}