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
 * <a href="LmisAttYearlySoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAttYearlySoap implements Serializable {
	public static LmisAttYearlySoap toSoapModel(LmisAttYearly model) {
		LmisAttYearlySoap soapModel = new LmisAttYearlySoap();

		soapModel.setLmisAttYearlyId(model.getLmisAttYearlyId());
		soapModel.setYearValue(model.getYearValue());
		soapModel.setRootId(model.getRootId());
		soapModel.setUserId(model.getUserId());
		soapModel.setTotalWorkingDay(model.getTotalWorkingDay());
		soapModel.setTotalDayAwardPrevYear(model.getTotalDayAwardPrevYear());
		soapModel.setTotalDayOff(model.getTotalDayOff());
		soapModel.setTotalDayAward(model.getTotalDayAward());
		soapModel.setTotalDayRemaining(model.getTotalDayRemaining());
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
		soapModel.setTotalTimeFinal(model.getTotalTimeFinal());
		soapModel.setTotalOvertimeRequested(model.getTotalOvertimeRequested());
		soapModel.setTotalDayoffPermissive(model.getTotalDayoffPermissive());

		return soapModel;
	}

	public static LmisAttYearlySoap[] toSoapModels(LmisAttYearly[] models) {
		LmisAttYearlySoap[] soapModels = new LmisAttYearlySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LmisAttYearlySoap[][] toSoapModels(LmisAttYearly[][] models) {
		LmisAttYearlySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LmisAttYearlySoap[models.length][models[0].length];
		}
		else {
			soapModels = new LmisAttYearlySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LmisAttYearlySoap[] toSoapModels(List<LmisAttYearly> models) {
		List<LmisAttYearlySoap> soapModels = new ArrayList<LmisAttYearlySoap>(models.size());

		for (LmisAttYearly model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LmisAttYearlySoap[soapModels.size()]);
	}

	public LmisAttYearlySoap() {
	}

	public Integer getPrimaryKey() {
		return _lmisAttYearlyId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisAttYearlyId(pk);
	}

	public Integer getLmisAttYearlyId() {
		return _lmisAttYearlyId;
	}

	public void setLmisAttYearlyId(Integer lmisAttYearlyId) {
		_lmisAttYearlyId = lmisAttYearlyId;
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

	public int getTotalWorkingDay() {
		return _totalWorkingDay;
	}

	public void setTotalWorkingDay(int totalWorkingDay) {
		_totalWorkingDay = totalWorkingDay;
	}

	public double getTotalDayAwardPrevYear() {
		return _totalDayAwardPrevYear;
	}

	public void setTotalDayAwardPrevYear(double totalDayAwardPrevYear) {
		_totalDayAwardPrevYear = totalDayAwardPrevYear;
	}

	public double getTotalDayOff() {
		return _totalDayOff;
	}

	public void setTotalDayOff(double totalDayOff) {
		_totalDayOff = totalDayOff;
	}

	public double getTotalDayAward() {
		return _totalDayAward;
	}

	public void setTotalDayAward(double totalDayAward) {
		_totalDayAward = totalDayAward;
	}

	public double getTotalDayRemaining() {
		return _totalDayRemaining;
	}

	public void setTotalDayRemaining(double totalDayRemaining) {
		_totalDayRemaining = totalDayRemaining;
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

	private Integer _lmisAttYearlyId;
	private int _yearValue;
	private int _rootId;
	private int _userId;
	private int _totalWorkingDay;
	private double _totalDayAwardPrevYear;
	private double _totalDayOff;
	private double _totalDayAward;
	private double _totalDayRemaining;
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
	private double _totalTimeFinal;
	private double _totalOvertimeRequested;
	private double _totalDayoffPermissive;
}