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
 * <a href="CdsTitlesModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface CdsTitlesModel extends BaseModel<CdsTitles> {
	public Integer getPrimaryKey();

	public void setPrimaryKey(Integer pk);

	public Integer getCdsTitleId();

	public void setCdsTitleId(Integer cdsTitleId);

	public int getRootId();

	public void setRootId(int rootId);

	public String getName();

	public void setName(String name);

	public String getAbbreviation();

	public void setAbbreviation(String abbreviation);

	public int getNumberOrder();

	public void setNumberOrder(int numberOrder);

	public int getCreatedBy();

	public void setCreatedBy(int createdBy);

	public Date getCreatedAt();

	public void setCreatedAt(Date createdAt);

	public int getUpdatedBy();

	public void setUpdatedBy(int updatedBy);

	public Date getUpdatedAt();

	public void setUpdatedAt(Date updatedAt);

	public CdsTitles toEscapedModel();
}