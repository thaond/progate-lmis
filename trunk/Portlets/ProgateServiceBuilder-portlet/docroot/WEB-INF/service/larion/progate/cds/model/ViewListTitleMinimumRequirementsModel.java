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
 * <a href="ViewListTitleMinimumRequirementsModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface ViewListTitleMinimumRequirementsModel extends BaseModel<ViewListTitleMinimumRequirements> {
	public String getPrimaryKey();

	public void setPrimaryKey(String pk);

	public String getId();

	public void setId(String id);

	public int getTitleId();

	public void setTitleId(int titleId);

	public int getRootId();

	public void setRootId(int rootId);

	public String getTitleName();

	public void setTitleName(String titleName);

	public String getAbbreviation();

	public void setAbbreviation(String abbreviation);

	public int getMinimumRequirementId();

	public void setMinimumRequirementId(int minimumRequirementId);

	public String getMinimumRequirementName();

	public void setMinimumRequirementName(String minimumRequirementName);

	public int getMinimumRequirementNumberOrder();

	public void setMinimumRequirementNumberOrder(
		int minimumRequirementNumberOrder);

	public int getLevelId();

	public void setLevelId(int levelId);

	public String getLevel();

	public void setLevel(String level);

	public ViewListTitleMinimumRequirements toEscapedModel();
}