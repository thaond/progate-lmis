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

import java.util.Date;

/**
 * <a href="LmisAttYearlyClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisAttYearlyClp extends BaseModelImpl<LmisAttYearly>
	implements LmisAttYearly {
	public LmisAttYearlyClp() {
	}

	public Integer getPrimaryKey() {
		return _lmisAttYearlyId;
	}

	public void setPrimaryKey(Integer pk) {
		setLmisAttYearlyId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _lmisAttYearlyId;
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

	public LmisAttYearly toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			LmisAttYearly model = new LmisAttYearlyClp();

			model.setEscapedModel(true);

			model.setLmisAttYearlyId(getLmisAttYearlyId());
			model.setYearValue(getYearValue());
			model.setRootId(getRootId());
			model.setUserId(getUserId());
			model.setTotalWorkingDay(getTotalWorkingDay());
			model.setTotalDayAwardPrevYear(getTotalDayAwardPrevYear());
			model.setTotalDayOff(getTotalDayOff());
			model.setTotalDayAward(getTotalDayAward());
			model.setTotalDayRemaining(getTotalDayRemaining());
			model.setStartTimeAverage(getStartTimeAverage());
			model.setEndTimeAverage(getEndTimeAverage());
			model.setTotalTimeLate(getTotalTimeLate());
			model.setTotalTimeLatePenalty(getTotalTimeLatePenalty());
			model.setTotalTimeEarly(getTotalTimeEarly());
			model.setTotalTimeEarlyPenalty(getTotalTimeEarlyPenalty());
			model.setTotalDayOvertime(getTotalDayOvertime());
			model.setTotalTimeLateFinal(getTotalTimeLateFinal());
			model.setTotalTimeEarlyFinal(getTotalTimeEarlyFinal());
			model.setTotalWorkingTime(getTotalWorkingTime());
			model.setTotalOvertime(getTotalOvertime());
			model.setTotalOvertimeFinal(getTotalOvertimeFinal());
			model.setTotalTimeFinal(getTotalTimeFinal());
			model.setTotalOvertimeRequested(getTotalOvertimeRequested());
			model.setTotalDayoffPermissive(getTotalDayoffPermissive());

			model = (LmisAttYearly)Proxy.newProxyInstance(LmisAttYearly.class.getClassLoader(),
					new Class[] { LmisAttYearly.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		LmisAttYearlyClp clone = new LmisAttYearlyClp();

		clone.setLmisAttYearlyId(getLmisAttYearlyId());
		clone.setYearValue(getYearValue());
		clone.setRootId(getRootId());
		clone.setUserId(getUserId());
		clone.setTotalWorkingDay(getTotalWorkingDay());
		clone.setTotalDayAwardPrevYear(getTotalDayAwardPrevYear());
		clone.setTotalDayOff(getTotalDayOff());
		clone.setTotalDayAward(getTotalDayAward());
		clone.setTotalDayRemaining(getTotalDayRemaining());
		clone.setStartTimeAverage(getStartTimeAverage());
		clone.setEndTimeAverage(getEndTimeAverage());
		clone.setTotalTimeLate(getTotalTimeLate());
		clone.setTotalTimeLatePenalty(getTotalTimeLatePenalty());
		clone.setTotalTimeEarly(getTotalTimeEarly());
		clone.setTotalTimeEarlyPenalty(getTotalTimeEarlyPenalty());
		clone.setTotalDayOvertime(getTotalDayOvertime());
		clone.setTotalTimeLateFinal(getTotalTimeLateFinal());
		clone.setTotalTimeEarlyFinal(getTotalTimeEarlyFinal());
		clone.setTotalWorkingTime(getTotalWorkingTime());
		clone.setTotalOvertime(getTotalOvertime());
		clone.setTotalOvertimeFinal(getTotalOvertimeFinal());
		clone.setTotalTimeFinal(getTotalTimeFinal());
		clone.setTotalOvertimeRequested(getTotalOvertimeRequested());
		clone.setTotalDayoffPermissive(getTotalDayoffPermissive());

		return clone;
	}

	public int compareTo(LmisAttYearly lmisAttYearly) {
		Integer pk = lmisAttYearly.getPrimaryKey();

		return getPrimaryKey().compareTo(pk);
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LmisAttYearlyClp lmisAttYearly = null;

		try {
			lmisAttYearly = (LmisAttYearlyClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = lmisAttYearly.getPrimaryKey();

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

		sb.append("{lmisAttYearlyId=");
		sb.append(getLmisAttYearlyId());
		sb.append(", yearValue=");
		sb.append(getYearValue());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", totalWorkingDay=");
		sb.append(getTotalWorkingDay());
		sb.append(", totalDayAwardPrevYear=");
		sb.append(getTotalDayAwardPrevYear());
		sb.append(", totalDayOff=");
		sb.append(getTotalDayOff());
		sb.append(", totalDayAward=");
		sb.append(getTotalDayAward());
		sb.append(", totalDayRemaining=");
		sb.append(getTotalDayRemaining());
		sb.append(", startTimeAverage=");
		sb.append(getStartTimeAverage());
		sb.append(", endTimeAverage=");
		sb.append(getEndTimeAverage());
		sb.append(", totalTimeLate=");
		sb.append(getTotalTimeLate());
		sb.append(", totalTimeLatePenalty=");
		sb.append(getTotalTimeLatePenalty());
		sb.append(", totalTimeEarly=");
		sb.append(getTotalTimeEarly());
		sb.append(", totalTimeEarlyPenalty=");
		sb.append(getTotalTimeEarlyPenalty());
		sb.append(", totalDayOvertime=");
		sb.append(getTotalDayOvertime());
		sb.append(", totalTimeLateFinal=");
		sb.append(getTotalTimeLateFinal());
		sb.append(", totalTimeEarlyFinal=");
		sb.append(getTotalTimeEarlyFinal());
		sb.append(", totalWorkingTime=");
		sb.append(getTotalWorkingTime());
		sb.append(", totalOvertime=");
		sb.append(getTotalOvertime());
		sb.append(", totalOvertimeFinal=");
		sb.append(getTotalOvertimeFinal());
		sb.append(", totalTimeFinal=");
		sb.append(getTotalTimeFinal());
		sb.append(", totalOvertimeRequested=");
		sb.append(getTotalOvertimeRequested());
		sb.append(", totalDayoffPermissive=");
		sb.append(getTotalDayoffPermissive());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.lmis.model.LmisAttYearly");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lmisAttYearlyId</column-name><column-value><![CDATA[");
		sb.append(getLmisAttYearlyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yearValue</column-name><column-value><![CDATA[");
		sb.append(getYearValue());
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
			"<column><column-name>totalWorkingDay</column-name><column-value><![CDATA[");
		sb.append(getTotalWorkingDay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalDayAwardPrevYear</column-name><column-value><![CDATA[");
		sb.append(getTotalDayAwardPrevYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalDayOff</column-name><column-value><![CDATA[");
		sb.append(getTotalDayOff());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalDayAward</column-name><column-value><![CDATA[");
		sb.append(getTotalDayAward());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalDayRemaining</column-name><column-value><![CDATA[");
		sb.append(getTotalDayRemaining());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startTimeAverage</column-name><column-value><![CDATA[");
		sb.append(getStartTimeAverage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endTimeAverage</column-name><column-value><![CDATA[");
		sb.append(getEndTimeAverage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalTimeLate</column-name><column-value><![CDATA[");
		sb.append(getTotalTimeLate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalTimeLatePenalty</column-name><column-value><![CDATA[");
		sb.append(getTotalTimeLatePenalty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalTimeEarly</column-name><column-value><![CDATA[");
		sb.append(getTotalTimeEarly());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalTimeEarlyPenalty</column-name><column-value><![CDATA[");
		sb.append(getTotalTimeEarlyPenalty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalDayOvertime</column-name><column-value><![CDATA[");
		sb.append(getTotalDayOvertime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalTimeLateFinal</column-name><column-value><![CDATA[");
		sb.append(getTotalTimeLateFinal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalTimeEarlyFinal</column-name><column-value><![CDATA[");
		sb.append(getTotalTimeEarlyFinal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalWorkingTime</column-name><column-value><![CDATA[");
		sb.append(getTotalWorkingTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalOvertime</column-name><column-value><![CDATA[");
		sb.append(getTotalOvertime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalOvertimeFinal</column-name><column-value><![CDATA[");
		sb.append(getTotalOvertimeFinal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalTimeFinal</column-name><column-value><![CDATA[");
		sb.append(getTotalTimeFinal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalOvertimeRequested</column-name><column-value><![CDATA[");
		sb.append(getTotalOvertimeRequested());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalDayoffPermissive</column-name><column-value><![CDATA[");
		sb.append(getTotalDayoffPermissive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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