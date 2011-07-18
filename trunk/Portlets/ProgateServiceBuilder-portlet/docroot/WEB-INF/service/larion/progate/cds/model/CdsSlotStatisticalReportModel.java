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
 * <a href="CdsSlotStatisticalReportModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface CdsSlotStatisticalReportModel extends BaseModel<CdsSlotStatisticalReport> {
	public Integer getPrimaryKey();

	public void setPrimaryKey(Integer pk);

	public Integer getSlotId();

	public void setSlotId(Integer slotId);

	public int getRootId();

	public void setRootId(int rootId);

	public int getLevelId();

	public void setLevelId(int levelId);

	public String getName();

	public void setName(String name);

	public String getDescription();

	public void setDescription(String description);

	public int getPeriodId();

	public void setPeriodId(int periodId);

	public int getUserId();

	public void setUserId(int userId);

	public int getPmId();

	public void setPmId(int pmId);

	public String getFirstName();

	public void setFirstName(String firstName);

	public String getLastName();

	public void setLastName(String lastName);

	public int getRatingStatusPm();

	public void setRatingStatusPm(int ratingStatusPm);

	public int getRatingStatusBod();

	public void setRatingStatusBod(int ratingStatusBod);

	public String getPointName();

	public void setPointName(String pointName);

	public int getPointValue();

	public void setPointValue(int pointValue);

	public String getMaxPointName();

	public void setMaxPointName(String maxPointName);

	public int getMaxPointValue();

	public void setMaxPointValue(int maxPointValue);

	public Date getToDate();

	public void setToDate(Date toDate);

	public int getStatus();

	public void setStatus(int status);

	public CdsSlotStatisticalReport toEscapedModel();
}