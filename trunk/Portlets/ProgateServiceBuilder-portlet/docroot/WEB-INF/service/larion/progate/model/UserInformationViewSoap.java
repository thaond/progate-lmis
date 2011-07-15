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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="UserInformationViewSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class UserInformationViewSoap implements Serializable {
	public static UserInformationViewSoap toSoapModel(UserInformationView model) {
		UserInformationViewSoap soapModel = new UserInformationViewSoap();

		soapModel.setUserInformationViewId(model.getUserInformationViewId());
		soapModel.setUserId(model.getUserId());
		soapModel.setScreenName(model.getScreenName());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setLastLoginDate(model.getLastLoginDate());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setIsProActive(model.getIsProActive());
		soapModel.setOrgId(model.getOrgId());
		soapModel.setOrgName(model.getOrgName());
		soapModel.setParentId(model.getParentId());
		soapModel.setJoiningDesc(model.getJoiningDesc());
		soapModel.setJoiningStatus(model.getJoiningStatus());
		soapModel.setRequestAt(model.getRequestAt());
		soapModel.setApprovedAt(model.getApprovedAt());
		soapModel.setRoleId(model.getRoleId());
		soapModel.setRolename(model.getRolename());
		soapModel.setRolePriority(model.getRolePriority());
		soapModel.setIsCurrent(model.getIsCurrent());
		soapModel.setSearchInformation(model.getSearchInformation());

		return soapModel;
	}

	public static UserInformationViewSoap[] toSoapModels(
		UserInformationView[] models) {
		UserInformationViewSoap[] soapModels = new UserInformationViewSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserInformationViewSoap[][] toSoapModels(
		UserInformationView[][] models) {
		UserInformationViewSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserInformationViewSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserInformationViewSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserInformationViewSoap[] toSoapModels(
		List<UserInformationView> models) {
		List<UserInformationViewSoap> soapModels = new ArrayList<UserInformationViewSoap>(models.size());

		for (UserInformationView model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserInformationViewSoap[soapModels.size()]);
	}

	public UserInformationViewSoap() {
	}

	public String getPrimaryKey() {
		return _UserInformationViewId;
	}

	public void setPrimaryKey(String pk) {
		setUserInformationViewId(pk);
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