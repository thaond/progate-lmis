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
 * <a href="ViewPerformanceAppraisalSlotsModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface ViewPerformanceAppraisalSlotsModel extends BaseModel<ViewPerformanceAppraisalSlots> {
	public String getPrimaryKey();

	public void setPrimaryKey(String pk);

	public String getId();

	public void setId(String id);

	public int getSlotId();

	public void setSlotId(int slotId);

	public int getLevelId();

	public void setLevelId(int levelId);

	public int getCompetencyId();

	public void setCompetencyId(int competencyId);

	public int getRootId();

	public void setRootId(int rootId);

	public String getSlotName();

	public void setSlotName(String slotName);

	public String getAliasName();

	public void setAliasName(String aliasName);

	public String getDescription();

	public void setDescription(String description);

	public int getPaId();

	public void setPaId(int paId);

	public int getSlotNumberOrder();

	public void setSlotNumberOrder(int slotNumberOrder);

	public int getLevelNumberOrder();

	public void setLevelNumberOrder(int levelNumberOrder);

	public int getCompetencyNumberOrder();

	public void setCompetencyNumberOrder(int competencyNumberOrder);

	public int getUserId();

	public void setUserId(int userId);

	public int getPeriodId();

	public void setPeriodId(int periodId);

	public String getPeriodName();

	public void setPeriodName(String periodName);

	public Date getFromDate();

	public void setFromDate(Date fromDate);

	public Date getToDate();

	public void setToDate(Date toDate);

	public int getBodUid();

	public void setBodUid(int bodUid);

	public int getPmUid();

	public void setPmUid(int pmUid);

	public int getRatingOrgId();

	public void setRatingOrgId(int ratingOrgId);

	public int getRatingStatus();

	public void setRatingStatus(int ratingStatus);

	public int getRatingStatusBod();

	public void setRatingStatusBod(int ratingStatusBod);

	public int getRatingStatusPm();

	public void setRatingStatusPm(int ratingStatusPm);

	public String getPointName();

	public void setPointName(String pointName);

	public String getMaxPointName();

	public void setMaxPointName(String maxPointName);

	public int getPointValue();

	public void setPointValue(int pointValue);

	public int getMaxPointValue();

	public void setMaxPointValue(int maxPointValue);

	public boolean getIsPassed();

	public boolean isIsPassed();

	public void setIsPassed(boolean isPassed);

	public ViewPerformanceAppraisalSlots toEscapedModel();
}