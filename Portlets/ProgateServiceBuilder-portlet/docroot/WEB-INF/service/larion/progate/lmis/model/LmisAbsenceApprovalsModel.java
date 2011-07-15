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
 * <a href="LmisAbsenceApprovalsModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisAbsenceApprovalsModel extends BaseModel<LmisAbsenceApprovals> {
	public Integer getPrimaryKey();

	public void setPrimaryKey(Integer pk);

	public Integer getLmisAbsenceApprovalsId();

	public void setLmisAbsenceApprovalsId(Integer lmisAbsenceApprovalsId);

	public int getRootId();

	public void setRootId(int rootId);

	public int getRequestId();

	public void setRequestId(int requestId);

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

	public String getReasonApproval();

	public void setReasonApproval(String reasonApproval);

	public LmisAbsenceApprovals toEscapedModel();
}