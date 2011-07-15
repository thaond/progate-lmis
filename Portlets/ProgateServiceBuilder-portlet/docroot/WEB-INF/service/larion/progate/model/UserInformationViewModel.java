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
 * <a href="UserInformationViewModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface UserInformationViewModel extends BaseModel<UserInformationView> {
	public String getPrimaryKey();

	public void setPrimaryKey(String pk);

	public String getUserInformationViewId();

	public void setUserInformationViewId(String UserInformationViewId);

	public int getUserId();

	public void setUserId(int userId);

	public String getScreenName();

	public void setScreenName(String screenName);

	public String getEmailAddress();

	public void setEmailAddress(String emailAddress);

	public String getFirstName();

	public void setFirstName(String firstName);

	public String getLastName();

	public void setLastName(String lastName);

	public Date getLastLoginDate();

	public void setLastLoginDate(Date lastLoginDate);

	public Date getCreateDate();

	public void setCreateDate(Date createDate);

	public Date getModifiedDate();

	public void setModifiedDate(Date modifiedDate);

	public int getStatus();

	public void setStatus(int status);

	public int getIsProActive();

	public void setIsProActive(int isProActive);

	public int getOrgId();

	public void setOrgId(int orgId);

	public String getOrgName();

	public void setOrgName(String orgName);

	public int getParentId();

	public void setParentId(int parentId);

	public String getJoiningDesc();

	public void setJoiningDesc(String joiningDesc);

	public int getJoiningStatus();

	public void setJoiningStatus(int joiningStatus);

	public Date getRequestAt();

	public void setRequestAt(Date requestAt);

	public Date getApprovedAt();

	public void setApprovedAt(Date approvedAt);

	public int getRoleId();

	public void setRoleId(int roleId);

	public String getRolename();

	public void setRolename(String rolename);

	public int getRolePriority();

	public void setRolePriority(int rolePriority);

	public boolean getIsCurrent();

	public boolean isIsCurrent();

	public void setIsCurrent(boolean isCurrent);

	public String getSearchInformation();

	public void setSearchInformation(String searchInformation);

	public UserInformationView toEscapedModel();
}