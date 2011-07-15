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
 * <a href="LmisViewOvertimeReportDetailModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisViewOvertimeReportDetailModel extends BaseModel<LmisViewOvertimeReportDetail> {
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

	public int getUserId();

	public void setUserId(int userId);

	public double getTotalHour();

	public void setTotalHour(double totalHour);

	public Date getStartTime();

	public void setStartTime(Date startTime);

	public Date getEndTime();

	public void setEndTime(Date endTime);

	public String getFullName();

	public void setFullName(String fullName);

	public double getReqRequestedHour();

	public void setReqRequestedHour(double reqRequestedHour);

	public Date getReqStartTime();

	public void setReqStartTime(Date reqStartTime);

	public Date getReqEndTime();

	public void setReqEndTime(Date reqEndTime);

	public LmisViewOvertimeReportDetail toEscapedModel();
}