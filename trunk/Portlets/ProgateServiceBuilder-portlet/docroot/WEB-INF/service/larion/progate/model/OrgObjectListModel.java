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

package larion.progate.model;

import com.liferay.portal.model.BaseModel;

import java.util.Date;

/**
 * <a href="OrgObjectListModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface OrgObjectListModel extends BaseModel<OrgObjectList> {
	public Integer getPrimaryKey();

	public void setPrimaryKey(Integer pk);

	public Integer getOrgObjectListId();

	public void setOrgObjectListId(Integer orgObjectListId);

	public int getOrg_id();

	public void setOrg_id(int org_id);

	public String getName();

	public void setName(String name);

	public String getDescription();

	public void setDescription(String description);

	public Date getCreated_date();

	public void setCreated_date(Date created_date);

	public int getYear();

	public void setYear(int year);

	public int getObjtype();

	public void setObjtype(int objtype);

	public double getEntering_percent();

	public void setEntering_percent(double entering_percent);

	public double getCompletion_percent();

	public void setCompletion_percent(double completion_percent);

	public boolean getIsapproved();

	public boolean isIsapproved();

	public void setIsapproved(boolean isapproved);

	public int getMonth_hash();

	public void setMonth_hash(int month_hash);

	public boolean getValidweight();

	public boolean isValidweight();

	public void setValidweight(boolean validweight);

	public double getCurrent_total_cost();

	public void setCurrent_total_cost(double current_total_cost);

	public double getExpected_completion();

	public void setExpected_completion(double expected_completion);

	public double getNext_total_cost();

	public void setNext_total_cost(double next_total_cost);

	public double getConsistency_ratio();

	public void setConsistency_ratio(double consistency_ratio);

	public int getParentid();

	public void setParentid(int parentid);

	public OrgObjectList toEscapedModel();
}