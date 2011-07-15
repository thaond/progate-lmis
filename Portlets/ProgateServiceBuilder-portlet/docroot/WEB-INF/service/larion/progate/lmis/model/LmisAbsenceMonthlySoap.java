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
 * <a href="LmisAbsenceMonthlySoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAbsenceMonthlySoap implements Serializable {
	public static LmisAbsenceMonthlySoap toSoapModel(LmisAbsenceMonthly model) {
		LmisAbsenceMonthlySoap soapModel = new LmisAbsenceMonthlySoap();

		soapModel.setLmisAbsenceMonthlyId(model.getLmisAbsenceMonthlyId());
		soapModel.setRootId(model.getRootId());
		soapModel.setMonthValue(model.getMonthValue());
		soapModel.setYearValue(model.getYearValue());
		soapModel.setUserId(model.getUserId());
		soapModel.setAbsenceType(model.getAbsenceType());
		soapModel.setAbsenceTypeId(model.getAbsenceTypeId());
		soapModel.setTotalDay(model.getTotalDay());
		soapModel.setTotalDayRequested(model.getTotalDayRequested());
		soapModel.setTotalDayApproved(model.getTotalDayApproved());

		return soapModel;
	}

	public static LmisAbsenceMonthlySoap[] toSoapModels(
		LmisAbsenceMonthly[] models) {
		LmisAbsenceMonthlySoap[] soapModels = new LmisAbsenceMonthlySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisAbsenceMonthlySoap[][] toSoapModels(
		LmisAbsenceMonthly[][] models) {
		LmisAbsenceMonthlySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisAbsenceMonthlySoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisAbsenceMonthlySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisAbsenceMonthlySoap[] toSoapModels(
		List<LmisAbsenceMonthly> models) {
		List<LmisAbsenceMonthlySoap> soapModels = new ArrayList<LmisAbsenceMonthlySoap>(models.size());

		for (LmisAbsenceMonthly model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisAbsenceMonthlySoap[soapModels.size()]);
	}

	public LmisAbsenceMonthlySoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisAbsenceMonthlyId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisAbsenceMonthlyId(pk);
	}

	public Integer getLmisAbsenceMonthlyId() {
		return _lmisAbsenceMonthlyId;
	}

	public void setLmisAbsenceMonthlyId(Integer lmisAbsenceMonthlyId) {
		_lmisAbsenceMonthlyId = lmisAbsenceMonthlyId;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getMonthValue() {
		return _monthValue;
	}

	public void setMonthValue(int monthValue) {
		_monthValue = monthValue;
	}

	public int getYearValue() {
		return _yearValue;
	}

	public void setYearValue(int yearValue) {
		_yearValue = yearValue;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public String getAbsenceType() {
		return _absenceType;
	}

	public void setAbsenceType(String absenceType) {
		_absenceType = absenceType;
	}

	public int getAbsenceTypeId() {
		return _absenceTypeId;
	}

	public void setAbsenceTypeId(int absenceTypeId) {
		_absenceTypeId = absenceTypeId;
	}

	public double getTotalDay() {
		return _totalDay;
	}

	public void setTotalDay(double totalDay) {
		_totalDay = totalDay;
	}

	public double getTotalDayRequested() {
		return _totalDayRequested;
	}

	public void setTotalDayRequested(double totalDayRequested) {
		_totalDayRequested = totalDayRequested;
	}

	public double getTotalDayApproved() {
		return _totalDayApproved;
	}

	public void setTotalDayApproved(double totalDayApproved) {
		_totalDayApproved = totalDayApproved;
	}

	private Integer _lmisAbsenceMonthlyId;
	private int _rootId;
	private int _monthValue;
	private int _yearValue;
	private int _userId;
	private String _absenceType;
	private int _absenceTypeId;
	private double _totalDay;
	private double _totalDayRequested;
	private double _totalDayApproved;
}