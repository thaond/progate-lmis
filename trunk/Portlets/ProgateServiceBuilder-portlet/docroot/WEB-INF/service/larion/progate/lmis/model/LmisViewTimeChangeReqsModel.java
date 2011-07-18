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
 * <a href="LmisViewTimeChangeReqsModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisViewTimeChangeReqsModel extends BaseModel<LmisViewTimeChangeReqs> {
	public Integer getPrimaryKey();

	public void setPrimaryKey(Integer pk);

	public Integer getLmisViewTimeChangeReqId();

	public void setLmisViewTimeChangeReqId(Integer lmisViewTimeChangeReqId);

	public int getRootId();

	public void setRootId(int rootId);

	public int getRequestedBy();

	public void setRequestedBy(int requestedBy);

	public String getFirstName();

	public void setFirstName(String firstName);

	public String getLastName();

	public void setLastName(String lastName);

	public String getFullName();

	public void setFullName(String fullName);

	public Date getStartDate();

	public void setStartDate(Date startDate);

	public Date getEndDate();

	public void setEndDate(Date endDate);

	public Date getMonStartTime();

	public void setMonStartTime(Date monStartTime);

	public Date getMonEndTime();

	public void setMonEndTime(Date monEndTime);

	public Date getTueStartTime();

	public void setTueStartTime(Date tueStartTime);

	public Date getTueEndTime();

	public void setTueEndTime(Date tueEndTime);

	public Date getWedStartTime();

	public void setWedStartTime(Date wedStartTime);

	public Date getWedEndTime();

	public void setWedEndTime(Date wedEndTime);

	public Date getThuStartTime();

	public void setThuStartTime(Date thuStartTime);

	public Date getThuEndTime();

	public void setThuEndTime(Date thuEndTime);

	public Date getFriStartTime();

	public void setFriStartTime(Date friStartTime);

	public Date getFriEndTime();

	public void setFriEndTime(Date friEndTime);

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

	public LmisViewTimeChangeReqs toEscapedModel();
}