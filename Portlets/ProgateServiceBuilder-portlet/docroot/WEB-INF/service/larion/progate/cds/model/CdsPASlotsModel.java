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

/**
 * <a href="CdsPASlotsModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface CdsPASlotsModel extends BaseModel<CdsPASlots> {
	public Integer getPrimaryKey();

	public void setPrimaryKey(Integer pk);

	public Integer getCdsPASlotsId();

	public void setCdsPASlotsId(Integer CdsPASlotsId);

	public int getPaId();

	public void setPaId(int paId);

	public int getRootId();

	public void setRootId(int rootId);

	public int getPeriodId();

	public void setPeriodId(int periodId);

	public int getUserId();

	public void setUserId(int userId);

	public int getSlotId();

	public void setSlotId(int slotId);

	public int getPmUid();

	public void setPmUid(int pmUid);

	public int getBodUid();

	public void setBodUid(int bodUid);

	public int getRatingOrgId();

	public void setRatingOrgId(int ratingOrgId);

	public int getRatingStatus();

	public void setRatingStatus(int ratingStatus);

	public int getRatingStatusPm();

	public void setRatingStatusPm(int ratingStatusPm);

	public int getRatingStatusBod();

	public void setRatingStatusBod(int ratingStatusBod);

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

	public CdsPASlots toEscapedModel();
}