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
 * <a href="LmisAttendanceDailyModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisAttendanceDailyModel extends BaseModel<LmisAttendanceDaily> {
	public Integer getPrimaryKey();

	public void setPrimaryKey(Integer pk);

	public Integer getLmisAttendanceDailyId();

	public void setLmisAttendanceDailyId(Integer lmisAttendanceDailyId);

	public Date getDayValue();

	public void setDayValue(Date dayValue);

	public int getRootId();

	public void setRootId(int rootId);

	public int getUserId();

	public void setUserId(int userId);

	public double getAbsenceValue();

	public void setAbsenceValue(double absenceValue);

	public boolean getIsPermissive();

	public boolean isIsPermissive();

	public void setIsPermissive(boolean isPermissive);

	public String getAbsenceReason();

	public void setAbsenceReason(String absenceReason);

	public int getAbsenceReasonId();

	public void setAbsenceReasonId(int absenceReasonId);

	public Date getPlanStartTime();

	public void setPlanStartTime(Date planStartTime);

	public Date getRealStartTime();

	public void setRealStartTime(Date realStartTime);

	public int getTimeLate();

	public void setTimeLate(int timeLate);

	public int getTimeLatePenalty();

	public void setTimeLatePenalty(int timeLatePenalty);

	public double getTimeLateFinal();

	public void setTimeLateFinal(double timeLateFinal);

	public Date getPlanEndTime();

	public void setPlanEndTime(Date planEndTime);

	public Date getRealEndTime();

	public void setRealEndTime(Date realEndTime);

	public int getTimeEarly();

	public void setTimeEarly(int timeEarly);

	public int getTimeEarlyPenalty();

	public void setTimeEarlyPenalty(int timeEarlyPenalty);

	public double getTimeEarlyFinal();

	public void setTimeEarlyFinal(double timeEarlyFinal);

	public String getOvertimeValue();

	public void setOvertimeValue(String overtimeValue);

	public double getTotalWorkingTime();

	public void setTotalWorkingTime(double totalWorkingTime);

	public double getTotalOvertime();

	public void setTotalOvertime(double totalOvertime);

	public double getTotalOvertimeFinal();

	public void setTotalOvertimeFinal(double totalOvertimeFinal);

	public double getTotalTimeFinal();

	public void setTotalTimeFinal(double totalTimeFinal);

	public String getComMent();

	public void setComMent(String comMent);

	public Date getCreatedAt();

	public void setCreatedAt(Date createdAt);

	public int getCreatedBy();

	public void setCreatedBy(int createdBy);

	public Date getUpdatedAt();

	public void setUpdatedAt(Date updatedAt);

	public int getUpdated_by();

	public void setUpdated_by(int updated_by);

	public double getTotalOvertimeRequested();

	public void setTotalOvertimeRequested(double totalOvertimeRequested);

	public int getAbsence_();

	public void setAbsence_(int absence_);

	public LmisAttendanceDaily toEscapedModel();
}