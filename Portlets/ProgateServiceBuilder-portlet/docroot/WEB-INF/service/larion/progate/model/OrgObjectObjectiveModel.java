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
 * <a href="OrgObjectObjectiveModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface OrgObjectObjectiveModel extends BaseModel<OrgObjectObjective> {
	public Integer getPrimaryKey();

	public void setPrimaryKey(Integer pk);

	public Integer getOrgObjectObjectiveId();

	public void setOrgObjectObjectiveId(Integer orgObjectObjectiveId);

	public int getOrgObjectPerspectiveId();

	public void setOrgObjectPerspectiveId(int orgObjectPerspectiveId);

	public String getName();

	public void setName(String name);

	public String getDescription();

	public void setDescription(String description);

	public Date getCreated_date();

	public void setCreated_date(Date created_date);

	public double getWeight_percent();

	public void setWeight_percent(double weight_percent);

	public double getEntering_percent();

	public void setEntering_percent(double entering_percent);

	public double getCompletion_percent();

	public void setCompletion_percent(double completion_percent);

	public int getMeasure_count();

	public void setMeasure_count(int measure_count);

	public boolean getValidweight();

	public boolean isValidweight();

	public void setValidweight(boolean validweight);

	public double getConsistency_ratio();

	public void setConsistency_ratio(double consistency_ratio);

	public double getWeight_percent_suggested();

	public void setWeight_percent_suggested(double weight_percent_suggested);

	public OrgObjectObjective toEscapedModel();
}