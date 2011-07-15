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

package larion.progate.cds.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;

/**
 * <a href="ViewEmployeesInProjectsModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface ViewEmployeesInProjectsModel extends BaseModel<ViewEmployeesInProjects> {
	public String getPrimaryKey();

	public void setPrimaryKey(String pk);

	public String getId();

	public void setId(String id);

	public int getRootId();

	public void setRootId(int rootId);

	public int getUserId();

	public void setUserId(int userId);

	public String getFirstName();

	public void setFirstName(String firstName);

	public String getMiddleName();

	public void setMiddleName(String middleName);

	public String getLastName();

	public void setLastName(String lastName);

	public String getPosition();

	public void setPosition(String position);

	public String getTitleAbbreviation();

	public void setTitleAbbreviation(String titleAbbreviation);

	public String getTitleName();

	public void setTitleName(String titleName);

	public int getOrgId();

	public void setOrgId(int orgId);

	public String getOrgList();

	public void setOrgList(String orgList);

	public String getPmList();

	public void setPmList(String pmList);

	public int getPeriodId();

	public void setPeriodId(int periodId);

	public String getPeriodName();

	public void setPeriodName(String periodName);

	public Date getFromDate();

	public void setFromDate(Date fromDate);

	public Date getToDate();

	public void setToDate(Date toDate);

	public int getPeriodStatus();

	public void setPeriodStatus(int periodStatus);

	public int getRatingStatus();

	public void setRatingStatus(int ratingStatus);

	public int getRatingStatusPm();

	public void setRatingStatusPm(int ratingStatusPm);

	public int getRatingStatusBod();

	public void setRatingStatusBod(int ratingStatusBod);

	public boolean getIsActive();

	public boolean isIsActive();

	public void setIsActive(boolean isActive);

	public boolean getIsRemoved();

	public boolean isIsRemoved();

	public void setIsRemoved(boolean isRemoved);

	public boolean getIsLocked();

	public boolean isIsLocked();

	public void setIsLocked(boolean isLocked);

	public Date getBeginTime();

	public void setBeginTime(Date beginTime);

	public Date getEndTime();

	public void setEndTime(Date endTime);

	public boolean getIsTitleUp();

	public boolean isIsTitleUp();

	public void setIsTitleUp(boolean isTitleUp);

	public ViewEmployeesInProjects toEscapedModel();
}