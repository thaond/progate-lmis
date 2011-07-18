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
 * <a href="LevelModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LevelModel extends BaseModel<Level> {
	public Integer getPrimaryKey();

	public void setPrimaryKey(Integer pk);

	public int getRootId();

	public void setRootId(int rootId);

	public Integer getLevelId();

	public void setLevelId(Integer levelId);

	public int getCompetencyId();

	public void setCompetencyId(int competencyId);

	public String getName();

	public void setName(String name);

	public String getDescription();

	public void setDescription(String description);

	public int getNumberOrder();

	public void setNumberOrder(int numberOrder);

	public String getAliasName();

	public void setAliasName(String aliasName);

	public int getCreatedBy();

	public void setCreatedBy(int createdBy);

	public Date getCreatedAt();

	public void setCreatedAt(Date createdAt);

	public int getUpdatedBy();

	public void setUpdatedBy(int updatedBy);

	public Date getUpdatedAt();

	public void setUpdatedAt(Date updatedAt);

	public Level toEscapedModel();
}