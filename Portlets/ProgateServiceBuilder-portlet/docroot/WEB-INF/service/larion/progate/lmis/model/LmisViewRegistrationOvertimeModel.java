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
 * <a href="LmisViewRegistrationOvertimeModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisViewRegistrationOvertimeModel extends BaseModel<LmisViewRegistrationOvertime> {
	public Integer getPrimaryKey();

	public void setPrimaryKey(Integer pk);

	public Integer getLmisViewRegistrationOvertimeId();

	public void setLmisViewRegistrationOvertimeId(
		Integer lmisViewRegistrationOvertimeId);

	public int getOtReqsId();

	public void setOtReqsId(int otReqsId);

	public int getRootId();

	public void setRootId(int rootId);

	public int getRequestedBy();

	public void setRequestedBy(int requestedBy);

	public Date getRequestedAt();

	public void setRequestedAt(Date requestedAt);

	public String getRequestedReason();

	public void setRequestedReason(String requestedReason);

	public int getRequestedStatus();

	public void setRequestedStatus(int requestedStatus);

	public Date getCreatedAt();

	public void setCreatedAt(Date createdAt);

	public Date getUpdatedAt();

	public void setUpdatedAt(Date updatedAt);

	public int getOrgId();

	public void setOrgId(int orgId);

	public int getRequestId();

	public void setRequestId(int requestId);

	public int getUserId();

	public void setUserId(int userId);

	public Date getStartTime();

	public void setStartTime(Date startTime);

	public Date getEndTime();

	public void setEndTime(Date endTime);

	public String getReasonDetail();

	public void setReasonDetail(String reasonDetail);

	public double getRequestedHour();

	public void setRequestedHour(double requestedHour);

	public int getApprovedBy();

	public void setApprovedBy(int approvedBy);

	public Date getApprovedAt();

	public void setApprovedAt(Date approvedAt);

	public boolean getIsApproved();

	public boolean isIsApproved();

	public void setIsApproved(boolean isApproved);

	public boolean getApprovedStatus();

	public boolean isApprovedStatus();

	public void setApprovedStatus(boolean approvedStatus);

	public String getReaSon();

	public void setReaSon(String reaSon);

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

	public String getReqFirstName();

	public void setReqFirstName(String reqFirstName);

	public String getReqMiddleName();

	public void setReqMiddleName(String reqMiddleName);

	public String getReqLastName();

	public void setReqLastName(String reqLastName);

	public LmisViewRegistrationOvertime toEscapedModel();
}