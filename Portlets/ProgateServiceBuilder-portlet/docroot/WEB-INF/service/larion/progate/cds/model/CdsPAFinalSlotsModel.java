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
 * <a href="CdsPAFinalSlotsModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface CdsPAFinalSlotsModel extends BaseModel<CdsPAFinalSlots> {
	public Integer getPrimaryKey();

	public void setPrimaryKey(Integer pk);

	public Integer getCdsPAFinalSlotsId();

	public void setCdsPAFinalSlotsId(Integer CdsPAFinalSlotsId);

	public int getPaId();

	public void setPaId(int paId);

	public int getRootId();

	public void setRootId(int rootId);

	public int getUserId();

	public void setUserId(int userId);

	public int getSlotId();

	public void setSlotId(int slotId);

	public boolean getRatingStatus();

	public boolean isRatingStatus();

	public void setRatingStatus(boolean ratingStatus);

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

	public CdsPAFinalSlots toEscapedModel();
}