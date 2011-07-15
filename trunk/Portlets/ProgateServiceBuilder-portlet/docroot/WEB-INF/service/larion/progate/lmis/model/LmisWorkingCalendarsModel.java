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
 * <a href="LmisWorkingCalendarsModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisWorkingCalendarsModel extends BaseModel<LmisWorkingCalendars> {
	public Integer getPrimaryKey();

	public void setPrimaryKey(Integer pk);

	public Integer getLmisWorkingCalendarId();

	public void setLmisWorkingCalendarId(Integer lmisWorkingCalendarId);

	public int getRootId();

	public void setRootId(int rootId);

	public Date getDayValue();

	public void setDayValue(Date dayValue);

	public int getDayType();

	public void setDayType(int dayType);

	public String getDescription();

	public void setDescription(String description);

	public boolean getIsModified();

	public boolean isIsModified();

	public void setIsModified(boolean isModified);

	public double getTotalWorkingTime();

	public void setTotalWorkingTime(double totalWorkingTime);

	public boolean getIsRelatedSession();

	public boolean isIsRelatedSession();

	public void setIsRelatedSession(boolean isRelatedSession);

	public LmisWorkingCalendars toEscapedModel();
}