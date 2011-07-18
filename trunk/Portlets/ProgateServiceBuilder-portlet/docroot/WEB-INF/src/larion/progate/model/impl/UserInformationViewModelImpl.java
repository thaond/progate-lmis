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

package larion.progate.model.impl;

import com.liferay.portal.kernel.bean.ReadOnlyBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import larion.progate.model.UserInformationView;
import larion.progate.model.UserInformationViewSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="UserInformationViewModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class UserInformationViewModelImpl extends BaseModelImpl<UserInformationView> {
	public static final String TABLE_NAME = "v_user_information";
	public static final Object[][] TABLE_COLUMNS = {
			{ "view_id", new Integer(Types.VARCHAR) },
			

			{ "userid", new Integer(Types.INTEGER) },
			

			{ "screenname", new Integer(Types.VARCHAR) },
			

			{ "emailaddress", new Integer(Types.VARCHAR) },
			

			{ "firstname", new Integer(Types.VARCHAR) },
			

			{ "lastname", new Integer(Types.VARCHAR) },
			

			{ "lastlogindate", new Integer(Types.TIMESTAMP) },
			

			{ "createdate", new Integer(Types.TIMESTAMP) },
			

			{ "modifieddate", new Integer(Types.TIMESTAMP) },
			

			{ "status", new Integer(Types.INTEGER) },
			

			{ "is_proactive", new Integer(Types.INTEGER) },
			

			{ "org_id", new Integer(Types.INTEGER) },
			

			{ "org_name", new Integer(Types.VARCHAR) },
			

			{ "parent_id", new Integer(Types.INTEGER) },
			

			{ "joining_desc", new Integer(Types.VARCHAR) },
			

			{ "joining_status", new Integer(Types.INTEGER) },
			

			{ "request_at", new Integer(Types.TIMESTAMP) },
			

			{ "approved_at", new Integer(Types.TIMESTAMP) },
			

			{ "role_id", new Integer(Types.INTEGER) },
			

			{ "role_name", new Integer(Types.VARCHAR) },
			

			{ "role_priority", new Integer(Types.INTEGER) },
			

			{ "is_current", new Integer(Types.BOOLEAN) },
			

			{ "search_information", new Integer(Types.VARCHAR) }
		};
	public static final String TABLE_SQL_CREATE = "create table v_user_information (view_id VARCHAR(75) not null primary key,userid INTEGER,screenname VARCHAR(75) null,emailaddress VARCHAR(75) null,firstname VARCHAR(75) null,lastname VARCHAR(75) null,lastlogindate DATE null,createdate DATE null,modifieddate DATE null,status INTEGER,is_proactive INTEGER,org_id INTEGER,org_name VARCHAR(75) null,parent_id INTEGER,joining_desc VARCHAR(75) null,joining_status INTEGER,request_at DATE null,approved_at DATE null,role_id INTEGER,role_name VARCHAR(75) null,role_priority INTEGER,is_current BOOLEAN,search_information VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table v_user_information";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.model.UserInformationView"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.model.UserInformationView"),
			false);

	public static UserInformationView toModel(UserInformationViewSoap soapModel) {
		UserInformationView model = new UserInformationViewImpl();

		model.setUserInformationViewId(soapModel.getUserInformationViewId());
		model.setUserId(soapModel.getUserId());
		model.setScreenName(soapModel.getScreenName());
		model.setEmailAddress(soapModel.getEmailAddress());
		model.setFirstName(soapModel.getFirstName());
		model.setLastName(soapModel.getLastName());
		model.setLastLoginDate(soapModel.getLastLoginDate());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setStatus(soapModel.getStatus());
		model.setIsProActive(soapModel.getIsProActive());
		model.setOrgId(soapModel.getOrgId());
		model.setOrgName(soapModel.getOrgName());
		model.setParentId(soapModel.getParentId());
		model.setJoiningDesc(soapModel.getJoiningDesc());
		model.setJoiningStatus(soapModel.getJoiningStatus());
		model.setRequestAt(soapModel.getRequestAt());
		model.setApprovedAt(soapModel.getApprovedAt());
		model.setRoleId(soapModel.getRoleId());
		model.setRolename(soapModel.getRolename());
		model.setRolePriority(soapModel.getRolePriority());
		model.setIsCurrent(soapModel.getIsCurrent());
		model.setSearchInformation(soapModel.getSearchInformation());

		return model;
	}

	public static List<UserInformationView> toModels(
		UserInformationViewSoap[] soapModels) {
		List<UserInformationView> models = new ArrayList<UserInformationView>(soapModels.length);

		for (UserInformationViewSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.model.UserInformationView"));

	public UserInformationViewModelImpl() {
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
		return GetterUtil.getString(_UserInformationViewId);
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
		return GetterUtil.getString(_screenName);
	}

	public void setScreenName(String screenName) {
		_screenName = screenName;
	}

	public String getEmailAddress() {
		return GetterUtil.getString(_emailAddress);
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public String getFirstName() {
		return GetterUtil.getString(_firstName);
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return GetterUtil.getString(_lastName);
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
		return GetterUtil.getString(_orgName);
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
		return GetterUtil.getString(_joiningDesc);
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
		return GetterUtil.getString(_rolename);
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
		return GetterUtil.getString(_searchInformation);
	}

	public void setSearchInformation(String searchInformation) {
		_searchInformation = searchInformation;
	}

	public UserInformationView toEscapedModel() {
		if (isEscapedModel()) {
			return (UserInformationView)this;
		}
		else {
			UserInformationView model = new UserInformationViewImpl();

			model.setNew(isNew());
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
		UserInformationViewImpl clone = new UserInformationViewImpl();

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

		UserInformationView userInformationView = null;

		try {
			userInformationView = (UserInformationView)obj;
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