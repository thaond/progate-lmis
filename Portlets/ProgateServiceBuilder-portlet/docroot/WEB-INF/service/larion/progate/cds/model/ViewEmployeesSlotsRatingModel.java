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
 * <a href="ViewEmployeesSlotsRatingModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface ViewEmployeesSlotsRatingModel extends BaseModel<ViewEmployeesSlotsRating> {
	public String getPrimaryKey();

	public void setPrimaryKey(String pk);

	public String getId();

	public void setId(String id);

	public String getAliasName();

	public void setAliasName(String aliasName);

	public String getDescription();

	public void setDescription(String description);

	public int getNumberOrder();

	public void setNumberOrder(int numberOrder);

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

	public int getRatingOrgId();

	public void setRatingOrgId(int ratingOrgId);

	public int getRatingStatus();

	public void setRatingStatus(int ratingStatus);

	public int getRatingStatusBod();

	public void setRatingStatusBod(int ratingStatusBod);

	public int getRatingStatusPm();

	public void setRatingStatusPm(int ratingStatusPm);

	public ViewEmployeesSlotsRating toEscapedModel();
}