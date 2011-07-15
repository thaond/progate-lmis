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
import java.util.Date;
import java.util.List;

/**
 * <a href="LmisViewWorkingCalendarSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewWorkingCalendarSoap implements Serializable {
	public static LmisViewWorkingCalendarSoap toSoapModel(
		LmisViewWorkingCalendar model) {
		LmisViewWorkingCalendarSoap soapModel = new LmisViewWorkingCalendarSoap();

		soapModel.setLmisViewWorkingCalendarId(model.getLmisViewWorkingCalendarId());
		soapModel.setRootId(model.getRootId());
		soapModel.setDayValue(model.getDayValue());
		soapModel.setDayType(model.getDayType());
		soapModel.setIsModified(model.getIsModified());
		soapModel.setTotalWorkingTime(model.getTotalWorkingTime());
		soapModel.setIsRelatedSession(model.getIsRelatedSession());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static LmisViewWorkingCalendarSoap[] toSoapModels(
		LmisViewWorkingCalendar[] models) {
		LmisViewWorkingCalendarSoap[] soapModels = new LmisViewWorkingCalendarSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisViewWorkingCalendarSoap[][] toSoapModels(
		LmisViewWorkingCalendar[][] models) {
		LmisViewWorkingCalendarSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisViewWorkingCalendarSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisViewWorkingCalendarSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisViewWorkingCalendarSoap[] toSoapModels(
		List<LmisViewWorkingCalendar> models) {
		List<LmisViewWorkingCalendarSoap> soapModels = new ArrayList<LmisViewWorkingCalendarSoap>(models.size());

		for (LmisViewWorkingCalendar model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisViewWorkingCalendarSoap[soapModels.size()]);
	}

	public LmisViewWorkingCalendarSoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisViewWorkingCalendarId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisViewWorkingCalendarId(pk);
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