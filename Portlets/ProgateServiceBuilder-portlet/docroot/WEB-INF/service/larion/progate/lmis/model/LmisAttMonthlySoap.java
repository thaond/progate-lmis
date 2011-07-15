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
 * <a href="LmisAttMonthlySoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAttMonthlySoap implements Serializable {
	public static LmisAttMonthlySoap toSoapModel(LmisAttMonthly model) {
		LmisAttMonthlySoap soapModel = new LmisAttMonthlySoap();

		soapModel.setLmisAttMonthlysId(model.getLmisAttMonthlysId());
		soapModel.setYearValue(model.getYearValue());
		soapModel.setMonthValue(model.getMonthValue());
		soapModel.setRootId(model.getRootId());
		soapModel.setUserId(model.getUserId());
		soapModel.setTotalWorkingDay(model.getTotalWorkingDay());
		soapModel.setNumDayAward(model.getNumDayAward());
		soapModel.setTotalDayOff(model.getTotalDayOff());
		soapModel.setTotalDayCompensation(model.getTotalDayCompensation());
		soapModel.setTotalDayOffCompensation(model.getTotalDayOffCompensation());
		soapModel.setStartTimeAverage(model.getStartTimeAverage());
		soapModel.setEndTimeAverage(model.getEndTimeAverage());
		soapModel.setTotalTimeLate(model.getTotalTimeLate());
		soapModel.setTotalTimeLatePenalty(model.getTotalTimeLatePenalty());
		soapModel.setTotalTimeEarly(model.getTotalTimeEarly());
		soapModel.setTotalTimeEarlyPenalty(model.getTotalTimeEarlyPenalty());
		soapModel.setTotalDayOvertime(model.getTotalDayOvertime());
		soapModel.setTotalTimeLateFinal(model.getTotalTimeLateFinal());
		soapModel.setTotalTimeEarlyFinal(model.getTotalTimeEarlyFinal());
		soapModel.setTotalWorkingTime(model.getTotalWorkingTime());
		soapModel.setTotalOvertime(model.getTotalOvertime());
		soapModel.setTotalOvertimeFinal(model.getTotalOvertimeFinal());
		soapModel.setTotalDayCompensationNextMonth(model.getTotalDayCompensationNextMonth());
		soapModel.setTotalTimeFinal(model.getTotalTimeFinal());
		soapModel.setTotalOvertimeRequested(model.getTotalOvertimeRequested());
		soapModel.setTotalDayoffPermissive(model.getTotalDayoffPermissive());

		return soapModel;
	}

	public static LmisAttMonthlySoap[] toSoapModels(LmisAttMonthly[] models) {
		LmisAttMonthlySoap[] soapModels = new LmisAttMonthlySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisAttMonthlySoap[][] toSoapModels(LmisAttMonthly[][] models) {
		LmisAttMonthlySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisAttMonthlySoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisAttMonthlySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisAttMonthlySoap[] toSoapModels(List<LmisAttMonthly> models) {
		List<LmisAttMonthlySoap> soapModels = new ArrayList<LmisAttMonthlySoap>(models.size());

		for (LmisAttMonthly model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisAttMonthlySoap[soapModels.size()]);
	}

	public LmisAttMonthlySoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisAttMonthlysId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisAttMonthlysId(pk);
	}

	public Integer getLmisAttMonthlysId() {
		return _lmisAttMonthlysId;
	}

	public void setLmisAttMonthlysId(Integer lmisAttMonthlysId) {
		_lmisAttMonthlysId = lmisAttMonthlysId;
	}

	public int getYearValue() {
		return _yearValue;
	}

	public void setYearValue(int yearValue) {
		_yearValue = yearValue;
	}

	public int getMonthValue() {
		return _monthValue;
	}

	public void setMonthValue(int monthValue) {
		_monthValue = monthValue;
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

	public int getTotalWorkingDay() {
		return _totalWorkingDay;
	}

	public void setTotalWorkingDay(int totalWorkingDay) {
		_totalWorkingDay = totalWorkingDay;
	}

	public double getNumDayAward() {
		return _numDayAward;
	}

	public void setNumDayAward(double numDayAward) {
		_numDayAward = numDayAward;
	}

	public double getTotalDayOff() {
		return _totalDayOff;
	}

	public void setTotalDayOff(double totalDayOff) {
		_totalDayOff = totalDayOff;
	}

	public double getTotalDayCompensation() {
		return _totalDayCompensation;
	}

	public void setTotalDayCompensation(double totalDayCompensation) {
		_totalDayCompensation = totalDayCompensation;
	}

	public double getTotalDayOffCompensation() {
		return _totalDayOffCompensation;
	}

	public void setTotalDayOffCompensation(double totalDayOffCompensation) {
		_totalDayOffCompensation = totalDayOffCompensation;
	}

	public Date getStartTimeAverage() {
		return _startTimeAverage;
	}

	public void setStartTimeAverage(Date startTimeAverage) {
		_startTimeAverage = startTimeAverage;
	}

	public Date getEndTimeAverage() {
		return _endTimeAverage;
	}

	public void setEndTimeAverage(Date endTimeAverage) {
		_endTimeAverage = endTimeAverage;
	}

	public int getTotalTimeLate() {
		return _totalTimeLate;
	}

	public void setTotalTimeLate(int totalTimeLate) {
		_totalTimeLate = totalTimeLate;
	}

	public int getTotalTimeLatePenalty() {
		return _totalTimeLatePenalty;
	}

	public void setTotalTimeLatePenalty(int totalTimeLatePenalty) {
		_totalTimeLatePenalty = totalTimeLatePenalty;
	}

	public int getTotalTimeEarly() {
		return _totalTimeEarly;
	}

	public void setTotalTimeEarly(int totalTimeEarly) {
		_totalTimeEarly = totalTimeEarly;
	}

	public int getTotalTimeEarlyPenalty() {
		return _totalTimeEarlyPenalty;
	}

	public void setTotalTimeEarlyPenalty(int totalTimeEarlyPenalty) {
		_totalTimeEarlyPenalty = totalTimeEarlyPenalty;
	}

	public int getTotalDayOvertime() {
		return _totalDayOvertime;
	}

	public void setTotalDayOvertime(int totalDayOvertime) {
		_totalDayOvertime = totalDayOvertime;
	}

	public double getTotalTimeLateFinal() {
		return _totalTimeLateFinal;
	}

	public void setTotalTimeLateFinal(double totalTimeLateFinal) {
		_totalTimeLateFinal = totalTimeLateFinal;
	}

	public double getTotalTimeEarlyFinal() {
		return _totalTimeEarlyFinal;
	}

	public void setTotalTimeEarlyFinal(double totalTimeEarlyFinal) {
		_totalTimeEarlyFinal = totalTimeEarlyFinal;
	}

	public double getTotalWorkingTime() {
		return _totalWorkingTime;
	}

	public void setTotalWorkingTime(double totalWorkingTime) {
		_totalWorkingTime = totalWorkingTime;
	}

	public double getTotalOvertime() {
		return _totalOvertime;
	}

	public void setTotalOvertime(double totalOvertime) {
		_totalOvertime = totalOvertime;
	}

	public double getTotalOvertimeFinal() {
		return _totalOvertimeFinal;
	}

	public void setTotalOvertimeFinal(double totalOvertimeFinal) {
		_totalOvertimeFinal = totalOvertimeFinal;
	}

	public double getTotalDayCompensationNextMonth() {
		return _totalDayCompensationNextMonth;
	}

	public void setTotalDayCompensationNextMonth(
		double totalDayCompensationNextMonth) {
		_totalDayCompensationNextMonth = totalDayCompensationNextMonth;
	}

	public double getTotalTimeFinal() {
		return _totalTimeFinal;
	}

	public void setTotalTimeFinal(double totalTimeFinal) {
		_totalTimeFinal = totalTimeFinal;
	}

	public double getTotalOvertimeRequested() {
		return _totalOvertimeRequested;
	}

	public void setTotalOvertimeRequested(double totalOvertimeRequested) {
		_totalOvertimeRequested = totalOvertimeRequested;
	}

	public double getTotalDayoffPermissive() {
		return _totalDayoffPermissive;
	}

	public void setTotalDayoffPermissive(double totalDayoffPermissive) {
		_totalDayoffPermissive = totalDayoffPermissive;
	}

	private Integer _lmisAttMonthlysId;
	private int _yearValue;
	private int _monthValue;
	private int _rootId;
	private int _userId;
	private int _totalWorkingDay;
	private double _numDayAward;
	private double _totalDayOff;
	private double _totalDayCompensation;
	private double _totalDayOffCompensation;
	private Date _startTimeAverage;
	private Date _endTimeAverage;
	private int _totalTimeLate;
	private int _totalTimeLatePenalty;
	private int _totalTimeEarly;
	private int _totalTimeEarlyPenalty;
	private int _totalDayOvertime;
	private double _totalTimeLateFinal;
	private double _totalTimeEarlyFinal;
	private double _totalWorkingTime;
	private double _totalOvertime;
	private double _totalOvertimeFinal;
	private double _totalDayCompensationNextMonth;
	private double _totalTimeFinal;
	private double _totalOvertimeRequested;
	private double _totalDayoffPermissive;
}