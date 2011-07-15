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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="LmisWorkingCalendarSessionsSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisWorkingCalendarSessionsSoap implements Serializable {
	public static LmisWorkingCalendarSessionsSoap toSoapModel(
		LmisWorkingCalendarSessions model) {
		LmisWorkingCalendarSessionsSoap soapModel = new LmisWorkingCalendarSessionsSoap();

		soapModel.setLmisWorkingCalendarSessionID(model.getLmisWorkingCalendarSessionID());
		soapModel.setRootId(model.getRootId());
		soapModel.setCalendarId(model.getCalendarId());
		soapModel.setSessionId(model.getSessionId());

		return soapModel;
	}

	public static LmisWorkingCalendarSessionsSoap[] toSoapModels(
		LmisWorkingCalendarSessions[] models) {
		LmisWorkingCalendarSessionsSoap[] soapModels = new LmisWorkingCalendarSessionsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisWorkingCalendarSessionsSoap[][] toSoapModels(
		LmisWorkingCalendarSessions[][] models) {
		LmisWorkingCalendarSessionsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisWorkingCalendarSessionsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisWorkingCalendarSessionsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisWorkingCalendarSessionsSoap[] toSoapModels(
		List<LmisWorkingCalendarSessions> models) {
		List<LmisWorkingCalendarSessionsSoap> soapModels = new ArrayList<LmisWorkingCalendarSessionsSoap>(models.size());

		for (LmisWorkingCalendarSessions model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisWorkingCalendarSessionsSoap[soapModels.size()]);
	}

	public LmisWorkingCalendarSessionsSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisWorkingCalendarSessionID;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisWorkingCalendarSessionID(pk);
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

	private Integer _lmisWorkingCalendarSessionID;
	private int _rootId;
	private int _calendarId;
	private int _sessionId;
}