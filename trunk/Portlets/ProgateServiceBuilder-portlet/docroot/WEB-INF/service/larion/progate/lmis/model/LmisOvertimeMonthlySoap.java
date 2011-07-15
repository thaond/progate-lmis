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
 * <a href="LmisOvertimeMonthlySoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisOvertimeMonthlySoap implements Serializable {
	public static LmisOvertimeMonthlySoap toSoapModel(LmisOvertimeMonthly model) {
		LmisOvertimeMonthlySoap soapModel = new LmisOvertimeMonthlySoap();

		soapModel.setLmisOvertimeMonthlyId(model.getLmisOvertimeMonthlyId());
		soapModel.setMonthValue(model.getMonthValue());
		soapModel.setYearValue(model.getYearValue());
		soapModel.setRootId(model.getRootId());
		soapModel.setUserId(model.getUserId());
		soapModel.setOtType(model.getOtType());
		soapModel.setOtId(model.getOtId());
		soapModel.setTotalHour(model.getTotalHour());
		soapModel.setTotalHourFinal(model.getTotalHourFinal());
		soapModel.setOrgId(model.getOrgId());

		return soapModel;
	}

	public static LmisOvertimeMonthlySoap[] toSoapModels(
		LmisOvertimeMonthly[] models) {
		LmisOvertimeMonthlySoap[] soapModels = new LmisOvertimeMonthlySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisOvertimeMonthlySoap[][] toSoapModels(
		LmisOvertimeMonthly[][] models) {
		LmisOvertimeMonthlySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisOvertimeMonthlySoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisOvertimeMonthlySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisOvertimeMonthlySoap[] toSoapModels(
		List<LmisOvertimeMonthly> models) {
		List<LmisOvertimeMonthlySoap> soapModels = new ArrayList<LmisOvertimeMonthlySoap>(models.size());

		for (LmisOvertimeMonthly model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisOvertimeMonthlySoap[soapModels.size()]);
	}

	public LmisOvertimeMonthlySoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisOvertimeMonthlyId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisOvertimeMonthlyId(pk);
	}

	public Integer getLmisOvertimeMonthlyId() {
		return _lmisOvertimeMonthlyId;
	}

	public void setLmisOvertimeMonthlyId(Integer lmisOvertimeMonthlyId) {
		_lmisOvertimeMonthlyId = lmisOvertimeMonthlyId;
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

	public String getOtType() {
		return _otType;
	}

	public void setOtType(String otType) {
		_otType = otType;
	}

	public int getOtId() {
		return _otId;
	}

	public void setOtId(int otId) {
		_otId = otId;
	}

	public double getTotalHour() {
		return _totalHour;
	}

	public void setTotalHour(double totalHour) {
		_totalHour = totalHour;
	}

	public double getTotalHourFinal() {
		return _totalHourFinal;
	}

	public void setTotalHourFinal(double totalHourFinal) {
		_totalHourFinal = totalHourFinal;
	}

	public int getOrgId() {
		return _orgId;
	}

	public void setOrgId(int orgId) {
		_orgId = orgId;
	}

	private Integer _lmisOvertimeMonthlyId;
	private int _monthValue;
	private int _yearValue;
	private int _rootId;
	private int _userId;
	private String _otType;
	private int _otId;
	private double _totalHour;
	private double _totalHourFinal;
	private int _orgId;
}