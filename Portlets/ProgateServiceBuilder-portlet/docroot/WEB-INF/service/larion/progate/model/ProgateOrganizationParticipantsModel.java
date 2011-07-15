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

package larion.progate.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;

/**
 * <a href="ProgateOrganizationParticipantsModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface ProgateOrganizationParticipantsModel extends BaseModel<ProgateOrganizationParticipants> {
	public Integer getPrimaryKey();

	public void setPrimaryKey(Integer pk);

	public Integer getProgateOrganizationParticipantsId();

	public void setProgateOrganizationParticipantsId(
		Integer ProgateOrganizationParticipantsId);

	public int getUserId();

	public void setUserId(int userId);

	public int getOrgId();

	public void setOrgId(int orgId);

	public int getRoleId();

	public void setRoleId(int roleId);

	public int getRootId();

	public void setRootId(int rootId);

	public int getBodId();

	public void setBodId(int bodId);

	public int getRequestedBy();

	public void setRequestedBy(int requestedBy);

	public Date getRequestedAt();

	public void setRequestedAt(Date requestedAt);

	public String getRequestedReason();

	public void setRequestedReason(String requestedReason);

	public int getApprovedBy();

	public void setApprovedBy(int approvedBy);

	public Date getApprovedAt();

	public void setApprovedAt(Date approvedAt);

	public String getApprovedReason();

	public void setApprovedReason(String approvedReason);

	public int getStatus();

	public void setStatus(int status);

	public boolean getIsCurrent();

	public boolean isIsCurrent();

	public void setIsCurrent(boolean isCurrent);

	public ProgateOrganizationParticipants toEscapedModel();
}