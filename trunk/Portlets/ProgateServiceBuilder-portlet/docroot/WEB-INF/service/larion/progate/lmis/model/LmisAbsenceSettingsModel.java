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
 * <a href="LmisAbsenceSettingsModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisAbsenceSettingsModel extends BaseModel<LmisAbsenceSettings> {
	public Integer getPrimaryKey();

	public void setPrimaryKey(Integer pk);

	public Integer getLmisAbsenceSettingsId();

	public void setLmisAbsenceSettingsId(Integer lmisAbsenceSettingsId);

	public int getRootId();

	public void setRootId(int rootId);

	public String getName_();

	public void setName_(String name_);

	public String getDesCription();

	public void setDesCription(String desCription);

	public boolean getIsSubtract();

	public boolean isIsSubtract();

	public void setIsSubtract(boolean isSubtract);

	public boolean getIsModified();

	public boolean isIsModified();

	public void setIsModified(boolean isModified);

	public boolean getAbsencePermissive();

	public boolean isAbsencePermissive();

	public void setAbsencePermissive(boolean absencePermissive);

	public LmisAbsenceSettings toEscapedModel();
}