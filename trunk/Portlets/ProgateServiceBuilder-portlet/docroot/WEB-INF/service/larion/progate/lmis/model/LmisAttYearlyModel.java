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

import com.liferay.portal.model.BaseModel;

import java.util.Date;

/**
 * <a href="LmisAttYearlyModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisAttYearlyModel extends BaseModel<LmisAttYearly> {
	public Integer getPrimaryKey();

	public void setPrimaryKey(Integer pk);

	public Integer getLmisAttYearlyId();

	public void setLmisAttYearlyId(Integer lmisAttYearlyId);

	public int getYearValue();

	public void setYearValue(int yearValue);

	public int getRootId();

	public void setRootId(int rootId);

	public int getUserId();

	public void setUserId(int userId);

	public int getTotalWorkingDay();

	public void setTotalWorkingDay(int totalWorkingDay);

	public double getTotalDayAwardPrevYear();

	public void setTotalDayAwardPrevYear(double totalDayAwardPrevYear);

	public double getTotalDayOff();

	public void setTotalDayOff(double totalDayOff);

	public double getTotalDayAward();

	public void setTotalDayAward(double totalDayAward);

	public double getTotalDayRemaining();

	public void setTotalDayRemaining(double totalDayRemaining);

	public Date getStartTimeAverage();

	public void setStartTimeAverage(Date startTimeAverage);

	public Date getEndTimeAverage();

	public void setEndTimeAverage(Date endTimeAverage);

	public int getTotalTimeLate();

	public void setTotalTimeLate(int totalTimeLate);

	public int getTotalTimeLatePenalty();

	public void setTotalTimeLatePenalty(int totalTimeLatePenalty);

	public int getTotalTimeEarly();

	public void setTotalTimeEarly(int totalTimeEarly);

	public int getTotalTimeEarlyPenalty();

	public void setTotalTimeEarlyPenalty(int totalTimeEarlyPenalty);

	public int getTotalDayOvertime();

	public void setTotalDayOvertime(int totalDayOvertime);

	public double getTotalTimeLateFinal();

	public void setTotalTimeLateFinal(double totalTimeLateFinal);

	public double getTotalTimeEarlyFinal();

	public void setTotalTimeEarlyFinal(double totalTimeEarlyFinal);

	public double getTotalWorkingTime();

	public void setTotalWorkingTime(double totalWorkingTime);

	public double getTotalOvertime();

	public void setTotalOvertime(double totalOvertime);

	public double getTotalOvertimeFinal();

	public void setTotalOvertimeFinal(double totalOvertimeFinal);

	public double getTotalTimeFinal();

	public void setTotalTimeFinal(double totalTimeFinal);

	public double getTotalOvertimeRequested();

	public void setTotalOvertimeRequested(double totalOvertimeRequested);

	public double getTotalDayoffPermissive();

	public void setTotalDayoffPermissive(double totalDayoffPermissive);

	public LmisAttYearly toEscapedModel();
}