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

/**
 * <a href="OrgObjectPerspectiveModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface OrgObjectPerspectiveModel extends BaseModel<OrgObjectPerspective> {
	public Integer getPrimaryKey();

	public void setPrimaryKey(Integer pk);

	public Integer getOrgObjectPerspectiveId();

	public void setOrgObjectPerspectiveId(Integer orgObjectPerspectiveId);

	public int getOrgObjectListId();

	public void setOrgObjectListId(int orgObjectListId);

	public String getName();

	public void setName(String name);

	public String getDescription();

	public void setDescription(String description);

	public double getWeight_percent();

	public void setWeight_percent(double weight_percent);

	public double getEntering_percent();

	public void setEntering_percent(double entering_percent);

	public double getCompletion_percent();

	public void setCompletion_percent(double completion_percent);

	public double getObjective_count();

	public void setObjective_count(double objective_count);

	public boolean getValidweight();

	public boolean isValidweight();

	public void setValidweight(boolean validweight);

	public int getPertype();

	public void setPertype(int pertype);

	public double getCurrent_cost();

	public void setCurrent_cost(double current_cost);

	public double getNext_cost();

	public void setNext_cost(double next_cost);

	public double getNext_cost2();

	public void setNext_cost2(double next_cost2);

	public double getConsistency_ratio();

	public void setConsistency_ratio(double consistency_ratio);

	public double getWeight_percent_suggested();

	public void setWeight_percent_suggested(double weight_percent_suggested);

	public OrgObjectPerspective toEscapedModel();
}