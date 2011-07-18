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

/**
 * <a href="LmisViewDayTypeOverTimeSettingTypeModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisViewDayTypeOverTimeSettingTypeModel extends BaseModel<LmisViewDayTypeOverTimeSettingType> {
	public Integer getPrimaryKey();

	public void setPrimaryKey(Integer pk);

	public Integer getLmisViewDayTypeOverTimeSettingTypeId();

	public void setLmisViewDayTypeOverTimeSettingTypeId(
		Integer lmisViewDayTypeOverTimeSettingTypeId);

	public int getOtTypeId();

	public void setOtTypeId(int otTypeId);

	public int getRootId();

	public void setRootId(int rootId);

	public String getName();

	public void setName(String name);

	public int getDayType();

	public void setDayType(int dayType);

	public int getOtId();

	public void setOtId(int otId);

	public double getCoefficient();

	public void setCoefficient(double coefficient);

	public String getNameOvertimeType();

	public void setNameOvertimeType(String nameOvertimeType);

	public String getDescription();

	public void setDescription(String description);

	public LmisViewDayTypeOverTimeSettingType toEscapedModel();
}