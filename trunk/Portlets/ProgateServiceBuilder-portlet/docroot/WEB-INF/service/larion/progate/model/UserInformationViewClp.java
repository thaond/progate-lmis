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

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * <a href="UserInformationViewClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class UserInformationViewClp extends BaseModelImpl<UserInformationView>
	implements UserInformationView {
	public UserInformationViewClp() {
	}

	public String getPrimaryKey() {
		return _UserInformationViewId;
	}

	public void setPrimaryKey(String pk) {
		setUserInformationViewId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _UserInformationViewId;
	}

	public String getUserInformationViewId() {
		return _UserInformationViewId;
	}

	public void setUserInformationViewId(String UserInformationViewId) {
		_UserInformationViewId = UserInformationViewId;
	}

	public int getUserId() {
		return _userId;
	}

	public void setUserId(int userId) {
		_userId = userId;
	}

	public String getScreenName() {
		return _screenName;
	}

	public void setScreenName(String screenName) {
		_screenName = screenName;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public Date getLastLoginDate() {
		return _lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		_lastLoginDate = lastLoginDate;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public int getIsProActive() {
		return _isProActive;
	}

	public void setIsProActive(int isProActive) {
		_isProActive = isProActive;
	}

	public int getOrgId() {
		return _orgId;
	}

	public void setOrgId(int orgId) {
		_orgId = orgId;
	}

	public String getOrgName() {
		return _orgName;
	}

	public void setOrgName(String orgName) {
		_orgName = orgName;
	}

	public int getParentId() {
		return _parentId;
	}

	public void setParentId(int parentId) {
		_parentId = parentId;
	}

	public String getJoiningDesc() {
		return _joiningDesc;
	}

	public void setJoiningDesc(String joiningDesc) {
		_joiningDesc = joiningDesc;
	}

	public int getJoiningStatus() {
		return _joiningStatus;
	}

	public void setJoiningStatus(int joiningStatus) {
		_joiningStatus = joiningStatus;
	}

	public Date getRequestAt() {
		return _requestAt;
	}

	public void setRequestAt(Date requestAt) {
		_requestAt = requestAt;
	}

	public Date getApprovedAt() {
		return _approvedAt;
	}

	public void setApprovedAt(Date approvedAt) {
		_approvedAt = approvedAt;
	}

	public int getRoleId() {
		return _roleId;
	}

	public void setRoleId(int roleId) {
		_roleId = roleId;
	}

	public String getRolename() {
		return _rolename;
	}

	public void setRolename(String rolename) {
		_rolename = rolename;
	}

	public int getRolePriority() {
		return _rolePriority;
	}

	public void setRolePriority(int rolePriority) {
		_rolePriority = rolePriority;
	}

	public boolean getIsCurrent() {
		return _isCurrent;
	}

	public boolean isIsCurrent() {
		return _isCurrent;
	}

	public void setIsCurrent(boolean isCurrent) {
		_isCurrent = isCurrent;
	}

	public String getSearchInformation() {
		return _searchInformation;
	}

	public void setSearchInformation(String searchInformation) {
		_searchInformation = searchInformation;
	}

	public UserInformationView toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			UserInformationView model = new UserInformationViewClp();

			model.setEscapedModel(true);

			model.setUserInformationViewId(HtmlUtil.escape(
					getUserInformationViewId()));
			model.setUserId(getUserId());
			model.setScreenName(HtmlUtil.escape(getScreenName()));
			model.setEmailAddress(HtmlUtil.escape(getEmailAddress()));
			model.setFirstName(HtmlUtil.escape(getFirstName()));
			model.setLastName(HtmlUtil.escape(getLastName()));
			model.setLastLoginDate(getLastLoginDate());
			model.setCreateDate(getCreateDate());
			model.setModifiedDate(getModifiedDate());
			model.setStatus(getStatus());
			model.setIsProActive(getIsProActive());
			model.setOrgId(getOrgId());
			model.setOrgName(HtmlUtil.escape(getOrgName()));
			model.setParentId(getParentId());
			model.setJoiningDesc(HtmlUtil.escape(getJoiningDesc()));
			model.setJoiningStatus(getJoiningStatus());
			model.setRequestAt(getRequestAt());
			model.setApprovedAt(getApprovedAt());
			model.setRoleId(getRoleId());
			model.setRolename(HtmlUtil.escape(getRolename()));
			model.setRolePriority(getRolePriority());
			model.setIsCurrent(getIsCurrent());
			model.setSearchInformation(HtmlUtil.escape(getSearchInformation()));

			model = (UserInformationView)Proxy.newProxyInstance(UserInformationView.class.getClassLoader(),
					new Class[] { UserInformationView.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		UserInformationViewClp clone = new UserInformationViewClp();

		clone.setUserInformationViewId(getUserInformationViewId());
		clone.setUserId(getUserId());
		clone.setScreenName(getScreenName());
		clone.setEmailAddress(getEmailAddress());
		clone.setFirstName(getFirstName());
		clone.setLastName(getLastName());
		clone.setLastLoginDate(getLastLoginDate());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setStatus(getStatus());
		clone.setIsProActive(getIsProActive());
		clone.setOrgId(getOrgId());
		clone.setOrgName(getOrgName());
		clone.setParentId(getParentId());
		clone.setJoiningDesc(getJoiningDesc());
		clone.setJoiningStatus(getJoiningStatus());
		clone.setRequestAt(getRequestAt());
		clone.setApprovedAt(getApprovedAt());
		clone.setRoleId(getRoleId());
		clone.setRolename(getRolename());
		clone.setRolePriority(getRolePriority());
		clone.setIsCurrent(getIsCurrent());
		clone.setSearchInformation(getSearchInformation());

		return clone;
	}

	public int compareTo(UserInformationView userInformationView) {
		int value = 0;

		value = getScreenName().compareTo(userInformationView.getScreenName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		UserInformationViewClp userInformationView = null;

		try {
			userInformationView = (UserInformationViewClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String pk = userInformationView.getPrimaryKey();

		if (getPrimaryKey().equals(pk)) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("{UserInformationViewId=");
		sb.append(getUserInformationViewId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", screenName=");
		sb.append(getScreenName());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", lastLoginDate=");
		sb.append(getLastLoginDate());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", isProActive=");
		sb.append(getIsProActive());
		sb.append(", orgId=");
		sb.append(getOrgId());
		sb.append(", orgName=");
		sb.append(getOrgName());
		sb.append(", parentId=");
		sb.append(getParentId());
		sb.append(", joiningDesc=");
		sb.append(getJoiningDesc());
		sb.append(", joiningStatus=");
		sb.append(getJoiningStatus());
		sb.append(", requestAt=");
		sb.append(getRequestAt());
		sb.append(", approvedAt=");
		sb.append(getApprovedAt());
		sb.append(", roleId=");
		sb.append(getRoleId());
		sb.append(", rolename=");
		sb.append(getRolename());
		sb.append(", rolePriority=");
		sb.append(getRolePriority());
		sb.append(", isCurrent=");
		sb.append(getIsCurrent());
		sb.append(", searchInformation=");
		sb.append(getSearchInformation());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.UserInformationView");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>UserInformationViewId</column-name><column-value><![CDATA[");
		sb.append(getUserInformationViewId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>screenName</column-name><column-value><![CDATA[");
		sb.append(getScreenName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailAddress</column-name><column-value><![CDATA[");
		sb.append(getEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastLoginDate</column-name><column-value><![CDATA[");
		sb.append(getLastLoginDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isProActive</column-name><column-value><![CDATA[");
		sb.append(getIsProActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgId</column-name><column-value><![CDATA[");
		sb.append(getOrgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgName</column-name><column-value><![CDATA[");
		sb.append(getOrgName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentId</column-name><column-value><![CDATA[");
		sb.append(getParentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>joiningDesc</column-name><column-value><![CDATA[");
		sb.append(getJoiningDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>joiningStatus</column-name><column-value><![CDATA[");
		sb.append(getJoiningStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requestAt</column-name><column-value><![CDATA[");
		sb.append(getRequestAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approvedAt</column-name><column-value><![CDATA[");
		sb.append(getApprovedAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>roleId</column-name><column-value><![CDATA[");
		sb.append(getRoleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rolename</column-name><column-value><![CDATA[");
		sb.append(getRolename());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rolePriority</column-name><column-value><![CDATA[");
		sb.append(getRolePriority());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isCurrent</column-name><column-value><![CDATA[");
		sb.append(getIsCurrent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>searchInformation</column-name><column-value><![CDATA[");
		sb.append(getSearchInformation());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _UserInformationViewId;
	private int _userId;
	private String _screenName;
	private String _emailAddress;
	private String _firstName;
	private String _lastName;
	private Date _lastLoginDate;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private int _isProActive;
	private int _orgId;
	private String _orgName;
	private int _parentId;
	private String _joiningDesc;
	private int _joiningStatus;
	private Date _requestAt;
	private Date _approvedAt;
	private int _roleId;
	private String _rolename;
	private int _rolePriority;
	private boolean _isCurrent;
	private String _searchInformation;
}