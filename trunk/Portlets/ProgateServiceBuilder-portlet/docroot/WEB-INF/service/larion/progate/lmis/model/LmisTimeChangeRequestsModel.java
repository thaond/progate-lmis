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
 * <a href="LmisTimeChangeRequestsModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisTimeChangeRequestsModel extends BaseModel<LmisTimeChangeRequests> {
	public Integer getPrimaryKey();

	public void setPrimaryKey(Integer pk);

	public Integer getLmisTimeChangeRequestId();

	public void setLmisTimeChangeRequestId(Integer lmisTimeChangeRequestId);

	public int getRootId();

	public void setRootId(int rootId);

	public int getRequestedBy();

	public void setRequestedBy(int requestedBy);

	public Date getStartDate();

	public void setStartDate(Date startDate);

	public Date getEndDate();

	public void setEndDate(Date endDate);

	public boolean getMonSelected();

	public boolean isMonSelected();

	public void setMonSelected(boolean monSelected);

	public Date getMonStartTime();

	public void setMonStartTime(Date monStartTime);

	public Date getMonEndTime();

	public void setMonEndTime(Date monEndTime);

	public boolean getTueSelected();

	public boolean isTueSelected();

	public void setTueSelected(boolean tueSelected);

	public Date getTueStartTime();

	public void setTueStartTime(Date tueStartTime);

	public Date getTueEndTime();

	public void setTueEndTime(Date tueEndTime);

	public boolean getWedSelected();

	public boolean isWedSelected();

	public void setWedSelected(boolean wedSelected);

	public Date getWedStartTime();

	public void setWedStartTime(Date wedStartTime);

	public Date getWedEndTime();

	public void setWedEndTime(Date wedEndTime);

	public boolean getThuSelected();

	public boolean isThuSelected();

	public void setThuSelected(boolean thuSelected);

	public Date getThuStartTime();

	public void setThuStartTime(Date thuStartTime);

	public Date getThuEndTime();

	public void setThuEndTime(Date thuEndTime);

	public boolean getFriSelected();

	public boolean isFriSelected();

	public void setFriSelected(boolean friSelected);

	public Date getFriStartTime();

	public void setFriStartTime(Date friStartTime);

	public Date getFriEndTime();

	public void setFriEndTime(Date friEndTime);

	public boolean getSatSelected();

	public boolean isSatSelected();

	public void setSatSelected(boolean satSelected);

	public Date getSatStartTime();

	public void setSatStartTime(Date satStartTime);

	public Date getSatEndTime();

	public void setSatEndTime(Date satEndTime);

	public String getRequestedReason();

	public void setRequestedReason(String requestedReason);

	public int getRequestedStatus();

	public void setRequestedStatus(int requestedStatus);

	public Date getCreatedAt();

	public void setCreatedAt(Date createdAt);

	public Date getUpdatedAt();

	public void setUpdatedAt(Date updatedAt);

	public LmisTimeChangeRequests toEscapedModel();
}