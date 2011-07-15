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
 * <a href="ProgateOrganizationsStaffsModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface ProgateOrganizationsStaffsModel extends BaseModel<ProgateOrganizationsStaffs> {
	public Integer getPrimaryKey();

	public void setPrimaryKey(Integer pk);

	public Integer getProgateOrganizationsStaffsId();

	public void setProgateOrganizationsStaffsId(
		Integer ProgateOrganizationsStaffsId);

	public int getUserId();

	public void setUserId(int userId);

	public int getOrgId();

	public void setOrgId(int orgId);

	public int getRootId();

	public void setRootId(int rootId);

	public int getBodId();

	public void setBodId(int bodId);

	public int getParticipantId();

	public void setParticipantId(int participantId);

	public String getPosition();

	public void setPosition(String position);

	public double getAvailability();

	public void setAvailability(double availability);

	public Date getBeginTime();

	public void setBeginTime(Date beginTime);

	public Date getEndTime();

	public void setEndTime(Date endTime);

	public boolean getIsActive();

	public boolean isIsActive();

	public void setIsActive(boolean isActive);

	public boolean getIsRemoved();

	public boolean isIsRemoved();

	public void setIsRemoved(boolean isRemoved);

	public String getStaffCode();

	public void setStaffCode(String staffCode);

	public String getScannerCode();

	public void setScannerCode(String scannerCode);

	public Date getCreatedAt();

	public void setCreatedAt(Date createdAt);

	public Date getUpdatedAt();

	public void setUpdatedAt(Date updatedAt);

	public ProgateOrganizationsStaffs toEscapedModel();
}