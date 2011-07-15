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
 * <a href="LmisViewReportOvertimeModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisViewReportOvertimeModel extends BaseModel<LmisViewReportOvertime> {
	public Integer getPrimaryKey();

	public void setPrimaryKey(Integer pk);

	public Integer getLmisViewReportOvertimeId();

	public void setLmisViewReportOvertimeId(Integer lmisViewReportOvertimeId);

	public int getOtRepId();

	public void setOtRepId(int otRepId);

	public int getRootId();

	public void setRootId(int rootId);

	public int getOrgId();

	public void setOrgId(int orgId);

	public int getRequestId();

	public void setRequestId(int requestId);

	public int getReportedBy();

	public void setReportedBy(int reportedBy);

	public Date getReportedAt();

	public void setReportedAt(Date reportedAt);

	public String getReportedReason();

	public void setReportedReason(String reportedReason);

	public int getReportedStatus();

	public void setReportedStatus(int reportedStatus);

	public Date getCreatedAt();

	public void setCreatedAt(Date createdAt);

	public Date getUpdatedAt();

	public void setUpdatedAt(Date updatedAt);

	public int getReportId();

	public void setReportId(int reportId);

	public int getUserId();

	public void setUserId(int userId);

	public double getTotalHour();

	public void setTotalHour(double totalHour);

	public Date getStartTime();

	public void setStartTime(Date startTime);

	public Date getEndTime();

	public void setEndTime(Date endTime);

	public int getDetailId();

	public void setDetailId(int detailId);

	public String getOtType();

	public void setOtType(String otType);

	public double getOtHour();

	public void setOtHour(double otHour);

	public double getOtCoefficient();

	public void setOtCoefficient(double otCoefficient);

	public int getOtId();

	public void setOtId(int otId);

	public String getOrgName();

	public void setOrgName(String orgName);

	public String getFullName();

	public void setFullName(String fullName);

	public String getFirstName();

	public void setFirstName(String firstName);

	public String getMiddleName();

	public void setMiddleName(String middleName);

	public String getLastName();

	public void setLastName(String LastName);

	public String getRepFirstName();

	public void setRepFirstName(String repFirstName);

	public String getRepLastName();

	public void setRepLastName(String repLastName);

	public String getRepMiddleName();

	public void setRepMiddleName(String repMiddleName);

	public double getRegRequestedHour();

	public void setRegRequestedHour(double regRequestedHour);

	public Date getRegStartTime();

	public void setRegStartTime(Date regStartTime);

	public Date getRegEndTime();

	public void setRegEndTime(Date regEndTime);

	public LmisViewReportOvertime toEscapedModel();
}