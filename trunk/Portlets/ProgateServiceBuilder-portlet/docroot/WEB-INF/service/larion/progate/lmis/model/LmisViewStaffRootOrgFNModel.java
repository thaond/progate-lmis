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
 * <a href="LmisViewStaffRootOrgFNModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface LmisViewStaffRootOrgFNModel extends BaseModel<LmisViewStaffRootOrgFN> {
	public Integer getPrimaryKey();

	public void setPrimaryKey(Integer pk);

	public Integer getLmisViewStaffRootOrgFNId();

	public void setLmisViewStaffRootOrgFNId(Integer lmisViewStaffRootOrgFNId);

	public int getUserId();

	public void setUserId(int userId);

	public int getRootId();

	public void setRootId(int rootId);

	public int getOrgId();

	public void setOrgId(int orgId);

	public int getBodId();

	public void setBodId(int bodId);

	public String getStaffCode();

	public void setStaffCode(String staffCode);

	public String getScannerCode();

	public void setScannerCode(String scannerCode);

	public String getScreenName();

	public void setScreenName(String screenName);

	public String getFullName();

	public void setFullName(String fullName);

	public String getEmailAddress();

	public void setEmailAddress(String emailAddress);

	public LmisViewStaffRootOrgFN toEscapedModel();
}