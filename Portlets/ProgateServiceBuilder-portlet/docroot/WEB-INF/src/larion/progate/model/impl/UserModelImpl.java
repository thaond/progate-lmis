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

import larion.progate.model.User;
import larion.progate.model.UserSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="UserModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class UserModelImpl extends BaseModelImpl<User> {
	public static final String TABLE_NAME = "user_";
	public static final Object[][] TABLE_COLUMNS = {
			{ "userid", new Integer(Types.INTEGER) },
			

			{ "uuid_", new Integer(Types.VARCHAR) },
			

			{ "companyid", new Integer(Types.INTEGER) },
			

			{ "createdate", new Integer(Types.TIMESTAMP) },
			

			{ "modifieddate", new Integer(Types.TIMESTAMP) },
			

			{ "defaultuser", new Integer(Types.BOOLEAN) },
			

			{ "contactid", new Integer(Types.INTEGER) },
			

			{ "password_", new Integer(Types.VARCHAR) },
			

			{ "passwordencrypted", new Integer(Types.BOOLEAN) },
			

			{ "passwordreset", new Integer(Types.BOOLEAN) },
			

			{ "passwordmodifieddate", new Integer(Types.TIMESTAMP) },
			

			{ "reminderqueryquestion", new Integer(Types.VARCHAR) },
			

			{ "reminderqueryanswer", new Integer(Types.VARCHAR) },
			

			{ "gracelogincount", new Integer(Types.INTEGER) },
			

			{ "screenname", new Integer(Types.VARCHAR) },
			

			{ "emailaddress", new Integer(Types.VARCHAR) },
			

			{ "openid", new Integer(Types.VARCHAR) },
			

			{ "languageid", new Integer(Types.VARCHAR) },
			

			{ "timezoneid", new Integer(Types.VARCHAR) },
			

			{ "greeting", new Integer(Types.VARCHAR) },
			

			{ "comments", new Integer(Types.VARCHAR) },
			

			{ "firstname", new Integer(Types.VARCHAR) },
			

			{ "middlename", new Integer(Types.VARCHAR) },
			

			{ "lastname", new Integer(Types.VARCHAR) },
			

			{ "jobtitle", new Integer(Types.VARCHAR) },
			

			{ "logindate", new Integer(Types.TIMESTAMP) },
			

			{ "loginip", new Integer(Types.VARCHAR) },
			

			{ "lastlogindate", new Integer(Types.TIMESTAMP) },
			

			{ "lastloginip", new Integer(Types.VARCHAR) },
			

			{ "lastfailedlogindate", new Integer(Types.TIMESTAMP) },
			

			{ "failedloginattempts", new Integer(Types.INTEGER) },
			

			{ "lockout", new Integer(Types.BOOLEAN) },
			

			{ "lockoutdate", new Integer(Types.TIMESTAMP) },
			

			{ "agreedtotermsofuse", new Integer(Types.BOOLEAN) },
			

			{ "active_", new Integer(Types.BOOLEAN) },
			

			{ "is_proactive", new Integer(Types.BOOLEAN) },
			

			{ "status", new Integer(Types.BOOLEAN) }
		};
	public static final String TABLE_SQL_CREATE = "create table user_ (userid INTEGER not null primary key,uuid_ VARCHAR(75) null,companyid INTEGER,createdate DATE null,modifieddate DATE null,defaultuser BOOLEAN,contactid INTEGER,password_ VARCHAR(75) null,passwordencrypted BOOLEAN,passwordreset BOOLEAN,passwordmodifieddate DATE null,reminderqueryquestion VARCHAR(75) null,reminderqueryanswer VARCHAR(75) null,gracelogincount INTEGER,screenname VARCHAR(75) null,emailaddress VARCHAR(75) null,openid VARCHAR(75) null,languageid VARCHAR(75) null,timezoneid VARCHAR(75) null,greeting VARCHAR(75) null,comments VARCHAR(75) null,firstname VARCHAR(75) null,middlename VARCHAR(75) null,lastname VARCHAR(75) null,jobtitle VARCHAR(75) null,logindate DATE null,loginip VARCHAR(75) null,lastlogindate DATE null,lastloginip VARCHAR(75) null,lastfailedlogindate DATE null,failedloginattempts INTEGER,lockout BOOLEAN,lockoutdate DATE null,agreedtotermsofuse BOOLEAN,active_ BOOLEAN,is_proactive BOOLEAN,status BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table user_";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.model.User"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.model.User"),
			false);

	public static User toModel(UserSoap soapModel) {
		User model = new UserImpl();

		model.setUserid(soapModel.getUserid());
		model.setUuid_(soapModel.getUuid_());
		model.setCompanyid(soapModel.getCompanyid());
		model.setCreatedate(soapModel.getCreatedate());
		model.setModifieddate(soapModel.getModifieddate());
		model.setDefaultuser(soapModel.getDefaultuser());
		model.setContactid(soapModel.getContactid());
		model.setPassword_(soapModel.getPassword_());
		model.setPasswordencrypted(soapModel.getPasswordencrypted());
		model.setPasswordreset(soapModel.getPasswordreset());
		model.setPasswordmodifieddate(soapModel.getPasswordmodifieddate());
		model.setReminderqueryquestion(soapModel.getReminderqueryquestion());
		model.setReminderqueryanswer(soapModel.getReminderqueryanswer());
		model.setGracelogincount(soapModel.getGracelogincount());
		model.setScreenname(soapModel.getScreenname());
		model.setEmailaddress(soapModel.getEmailaddress());
		model.setOpenid(soapModel.getOpenid());
		model.setLanguageid(soapModel.getLanguageid());
		model.setTimezoneid(soapModel.getTimezoneid());
		model.setGreeting(soapModel.getGreeting());
		model.setComments(soapModel.getComments());
		model.setFirstname(soapModel.getFirstname());
		model.setMiddlename(soapModel.getMiddlename());
		model.setLastname(soapModel.getLastname());
		model.setJobtitle(soapModel.getJobtitle());
		model.setLogindate(soapModel.getLogindate());
		model.setLoginip(soapModel.getLoginip());
		model.setLastlogindate(soapModel.getLastlogindate());
		model.setLastloginip(soapModel.getLastloginip());
		model.setLastfailedlogindate(soapModel.getLastfailedlogindate());
		model.setFailedloginattempts(soapModel.getFailedloginattempts());
		model.setLockout(soapModel.getLockout());
		model.setLockoutdate(soapModel.getLockoutdate());
		model.setAgreedtotermsofuse(soapModel.getAgreedtotermsofuse());
		model.setActive(soapModel.getActive());
		model.setIsProActive(soapModel.getIsProActive());
		model.setStatus(soapModel.getStatus());

		return model;
	}

	public static List<User> toModels(UserSoap[] soapModels) {
		List<User> models = new ArrayList<User>(soapModels.length);

		for (UserSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.model.User"));

	public UserModelImpl() {
	}

	public Integer getPrimaryKey() {
		return _userid;
	}

	public void setPrimaryKey(Integer pk) {
		setUserid(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _userid;
	}

	public Integer getUserid() {
		return _userid;
	}

	public void setUserid(Integer userid) {
		_userid = userid;
	}

	public String getUuid_() {
		return GetterUtil.getString(_uuid_);
	}

	public void setUuid_(String uuid_) {
		_uuid_ = uuid_;
	}

	public int getCompanyid() {
		return _companyid;
	}

	public void setCompanyid(int companyid) {
		_companyid = companyid;
	}

	public Date getCreatedate() {
		return _createdate;
	}

	public void setCreatedate(Date createdate) {
		_createdate = createdate;
	}

	public Date getModifieddate() {
		return _modifieddate;
	}

	public void setModifieddate(Date modifieddate) {
		_modifieddate = modifieddate;
	}

	public boolean getDefaultuser() {
		return _defaultuser;
	}

	public boolean isDefaultuser() {
		return _defaultuser;
	}

	public void setDefaultuser(boolean defaultuser) {
		_defaultuser = defaultuser;
	}

	public int getContactid() {
		return _contactid;
	}

	public void setContactid(int contactid) {
		_contactid = contactid;
	}

	public String getPassword_() {
		return GetterUtil.getString(_password_);
	}

	public void setPassword_(String password_) {
		_password_ = password_;
	}

	public boolean getPasswordencrypted() {
		return _passwordencrypted;
	}

	public boolean isPasswordencrypted() {
		return _passwordencrypted;
	}

	public void setPasswordencrypted(boolean passwordencrypted) {
		_passwordencrypted = passwordencrypted;
	}

	public boolean getPasswordreset() {
		return _passwordreset;
	}

	public boolean isPasswordreset() {
		return _passwordreset;
	}

	public void setPasswordreset(boolean passwordreset) {
		_passwordreset = passwordreset;
	}

	public Date getPasswordmodifieddate() {
		return _passwordmodifieddate;
	}

	public void setPasswordmodifieddate(Date passwordmodifieddate) {
		_passwordmodifieddate = passwordmodifieddate;
	}

	public String getReminderqueryquestion() {
		return GetterUtil.getString(_reminderqueryquestion);
	}

	public void setReminderqueryquestion(String reminderqueryquestion) {
		_reminderqueryquestion = reminderqueryquestion;
	}

	public String getReminderqueryanswer() {
		return GetterUtil.getString(_reminderqueryanswer);
	}

	public void setReminderqueryanswer(String reminderqueryanswer) {
		_reminderqueryanswer = reminderqueryanswer;
	}

	public int getGracelogincount() {
		return _gracelogincount;
	}

	public void setGracelogincount(int gracelogincount) {
		_gracelogincount = gracelogincount;
	}

	public String getScreenname() {
		return GetterUtil.getString(_screenname);
	}

	public void setScreenname(String screenname) {
		_screenname = screenname;
	}

	public String getEmailaddress() {
		return GetterUtil.getString(_emailaddress);
	}

	public void setEmailaddress(String emailaddress) {
		_emailaddress = emailaddress;
	}

	public String getOpenid() {
		return GetterUtil.getString(_openid);
	}

	public void setOpenid(String openid) {
		_openid = openid;
	}

	public String getLanguageid() {
		return GetterUtil.getString(_languageid);
	}

	public void setLanguageid(String languageid) {
		_languageid = languageid;
	}

	public String getTimezoneid() {
		return GetterUtil.getString(_timezoneid);
	}

	public void setTimezoneid(String timezoneid) {
		_timezoneid = timezoneid;
	}

	public String getGreeting() {
		return GetterUtil.getString(_greeting);
	}

	public void setGreeting(String greeting) {
		_greeting = greeting;
	}

	public String getComments() {
		return GetterUtil.getString(_comments);
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	public String getFirstname() {
		return GetterUtil.getString(_firstname);
	}

	public void setFirstname(String firstname) {
		_firstname = firstname;
	}

	public String getMiddlename() {
		return GetterUtil.getString(_middlename);
	}

	public void setMiddlename(String middlename) {
		_middlename = middlename;
	}

	public String getLastname() {
		return GetterUtil.getString(_lastname);
	}

	public void setLastname(String lastname) {
		_lastname = lastname;
	}

	public String getJobtitle() {
		return GetterUtil.getString(_jobtitle);
	}

	public void setJobtitle(String jobtitle) {
		_jobtitle = jobtitle;
	}

	public Date getLogindate() {
		return _logindate;
	}

	public void setLogindate(Date logindate) {
		_logindate = logindate;
	}

	public String getLoginip() {
		return GetterUtil.getString(_loginip);
	}

	public void setLoginip(String loginip) {
		_loginip = loginip;
	}

	public Date getLastlogindate() {
		return _lastlogindate;
	}

	public void setLastlogindate(Date lastlogindate) {
		_lastlogindate = lastlogindate;
	}

	public String getLastloginip() {
		return GetterUtil.getString(_lastloginip);
	}

	public void setLastloginip(String lastloginip) {
		_lastloginip = lastloginip;
	}

	public Date getLastfailedlogindate() {
		return _lastfailedlogindate;
	}

	public void setLastfailedlogindate(Date lastfailedlogindate) {
		_lastfailedlogindate = lastfailedlogindate;
	}

	public int getFailedloginattempts() {
		return _failedloginattempts;
	}

	public void setFailedloginattempts(int failedloginattempts) {
		_failedloginattempts = failedloginattempts;
	}

	public boolean getLockout() {
		return _lockout;
	}

	public boolean isLockout() {
		return _lockout;
	}

	public void setLockout(boolean lockout) {
		_lockout = lockout;
	}

	public Date getLockoutdate() {
		return _lockoutdate;
	}

	public void setLockoutdate(Date lockoutdate) {
		_lockoutdate = lockoutdate;
	}

	public boolean getAgreedtotermsofuse() {
		return _agreedtotermsofuse;
	}

	public boolean isAgreedtotermsofuse() {
		return _agreedtotermsofuse;
	}

	public void setAgreedtotermsofuse(boolean agreedtotermsofuse) {
		_agreedtotermsofuse = agreedtotermsofuse;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public boolean getIsProActive() {
		return _isProActive;
	}

	public boolean isIsProActive() {
		return _isProActive;
	}

	public void setIsProActive(boolean isProActive) {
		_isProActive = isProActive;
	}

	public boolean getStatus() {
		return _status;
	}

	public boolean isStatus() {
		return _status;
	}

	public void setStatus(boolean status) {
		_status = status;
	}

	public User toEscapedModel() {
		if (isEscapedModel()) {
			return (User)this;
		}
		else {
			User model = new UserImpl();

			model.setNew(isNew());
			model.setEscapedModel(true);

			model.setUserid(getUserid());
			model.setUuid_(HtmlUtil.escape(getUuid_()));
			model.setCompanyid(getCompanyid());
			model.setCreatedate(getCreatedate());
			model.setModifieddate(getModifieddate());
			model.setDefaultuser(getDefaultuser());
			model.setContactid(getContactid());
			model.setPassword_(HtmlUtil.escape(getPassword_()));
			model.setPasswordencrypted(getPasswordencrypted());
			model.setPasswordreset(getPasswordreset());
			model.setPasswordmodifieddate(getPasswordmodifieddate());
			model.setReminderqueryquestion(HtmlUtil.escape(
					getReminderqueryquestion()));
			model.setReminderqueryanswer(HtmlUtil.escape(
					getReminderqueryanswer()));
			model.setGracelogincount(getGracelogincount());
			model.setScreenname(HtmlUtil.escape(getScreenname()));
			model.setEmailaddress(HtmlUtil.escape(getEmailaddress()));
			model.setOpenid(HtmlUtil.escape(getOpenid()));
			model.setLanguageid(HtmlUtil.escape(getLanguageid()));
			model.setTimezoneid(HtmlUtil.escape(getTimezoneid()));
			model.setGreeting(HtmlUtil.escape(getGreeting()));
			model.setComments(HtmlUtil.escape(getComments()));
			model.setFirstname(HtmlUtil.escape(getFirstname()));
			model.setMiddlename(HtmlUtil.escape(getMiddlename()));
			model.setLastname(HtmlUtil.escape(getLastname()));
			model.setJobtitle(HtmlUtil.escape(getJobtitle()));
			model.setLogindate(getLogindate());
			model.setLoginip(HtmlUtil.escape(getLoginip()));
			model.setLastlogindate(getLastlogindate());
			model.setLastloginip(HtmlUtil.escape(getLastloginip()));
			model.setLastfailedlogindate(getLastfailedlogindate());
			model.setFailedloginattempts(getFailedloginattempts());
			model.setLockout(getLockout());
			model.setLockoutdate(getLockoutdate());
			model.setAgreedtotermsofuse(getAgreedtotermsofuse());
			model.setActive(getActive());
			model.setIsProActive(getIsProActive());
			model.setStatus(getStatus());

			model = (User)Proxy.newProxyInstance(User.class.getClassLoader(),
					new Class[] { User.class }, new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		UserImpl clone = new UserImpl();

		clone.setUserid(getUserid());
		clone.setUuid_(getUuid_());
		clone.setCompanyid(getCompanyid());
		clone.setCreatedate(getCreatedate());
		clone.setModifieddate(getModifieddate());
		clone.setDefaultuser(getDefaultuser());
		clone.setContactid(getContactid());
		clone.setPassword_(getPassword_());
		clone.setPasswordencrypted(getPasswordencrypted());
		clone.setPasswordreset(getPasswordreset());
		clone.setPasswordmodifieddate(getPasswordmodifieddate());
		clone.setReminderqueryquestion(getReminderqueryquestion());
		clone.setReminderqueryanswer(getReminderqueryanswer());
		clone.setGracelogincount(getGracelogincount());
		clone.setScreenname(getScreenname());
		clone.setEmailaddress(getEmailaddress());
		clone.setOpenid(getOpenid());
		clone.setLanguageid(getLanguageid());
		clone.setTimezoneid(getTimezoneid());
		clone.setGreeting(getGreeting());
		clone.setComments(getComments());
		clone.setFirstname(getFirstname());
		clone.setMiddlename(getMiddlename());
		clone.setLastname(getLastname());
		clone.setJobtitle(getJobtitle());
		clone.setLogindate(getLogindate());
		clone.setLoginip(getLoginip());
		clone.setLastlogindate(getLastlogindate());
		clone.setLastloginip(getLastloginip());
		clone.setLastfailedlogindate(getLastfailedlogindate());
		clone.setFailedloginattempts(getFailedloginattempts());
		clone.setLockout(getLockout());
		clone.setLockoutdate(getLockoutdate());
		clone.setAgreedtotermsofuse(getAgreedtotermsofuse());
		clone.setActive(getActive());
		clone.setIsProActive(getIsProActive());
		clone.setStatus(getStatus());

		return clone;
	}

	public int compareTo(User user) {
		int value = 0;

		value = getScreenname().compareTo(user.getScreenname());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		User user = null;

		try {
			user = (User)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = user.getPrimaryKey();

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

		sb.append("{userid=");
		sb.append(getUserid());
		sb.append(", uuid_=");
		sb.append(getUuid_());
		sb.append(", companyid=");
		sb.append(getCompanyid());
		sb.append(", createdate=");
		sb.append(getCreatedate());
		sb.append(", modifieddate=");
		sb.append(getModifieddate());
		sb.append(", defaultuser=");
		sb.append(getDefaultuser());
		sb.append(", contactid=");
		sb.append(getContactid());
		sb.append(", password_=");
		sb.append(getPassword_());
		sb.append(", passwordencrypted=");
		sb.append(getPasswordencrypted());
		sb.append(", passwordreset=");
		sb.append(getPasswordreset());
		sb.append(", passwordmodifieddate=");
		sb.append(getPasswordmodifieddate());
		sb.append(", reminderqueryquestion=");
		sb.append(getReminderqueryquestion());
		sb.append(", reminderqueryanswer=");
		sb.append(getReminderqueryanswer());
		sb.append(", gracelogincount=");
		sb.append(getGracelogincount());
		sb.append(", screenname=");
		sb.append(getScreenname());
		sb.append(", emailaddress=");
		sb.append(getEmailaddress());
		sb.append(", openid=");
		sb.append(getOpenid());
		sb.append(", languageid=");
		sb.append(getLanguageid());
		sb.append(", timezoneid=");
		sb.append(getTimezoneid());
		sb.append(", greeting=");
		sb.append(getGreeting());
		sb.append(", comments=");
		sb.append(getComments());
		sb.append(", firstname=");
		sb.append(getFirstname());
		sb.append(", middlename=");
		sb.append(getMiddlename());
		sb.append(", lastname=");
		sb.append(getLastname());
		sb.append(", jobtitle=");
		sb.append(getJobtitle());
		sb.append(", logindate=");
		sb.append(getLogindate());
		sb.append(", loginip=");
		sb.append(getLoginip());
		sb.append(", lastlogindate=");
		sb.append(getLastlogindate());
		sb.append(", lastloginip=");
		sb.append(getLastloginip());
		sb.append(", lastfailedlogindate=");
		sb.append(getLastfailedlogindate());
		sb.append(", failedloginattempts=");
		sb.append(getFailedloginattempts());
		sb.append(", lockout=");
		sb.append(getLockout());
		sb.append(", lockoutdate=");
		sb.append(getLockoutdate());
		sb.append(", agreedtotermsofuse=");
		sb.append(getAgreedtotermsofuse());
		sb.append(", active=");
		sb.append(getActive());
		sb.append(", isProActive=");
		sb.append(getIsProActive());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.User");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userid</column-name><column-value><![CDATA[");
		sb.append(getUserid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>uuid_</column-name><column-value><![CDATA[");
		sb.append(getUuid_());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyid</column-name><column-value><![CDATA[");
		sb.append(getCompanyid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdate</column-name><column-value><![CDATA[");
		sb.append(getCreatedate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifieddate</column-name><column-value><![CDATA[");
		sb.append(getModifieddate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>defaultuser</column-name><column-value><![CDATA[");
		sb.append(getDefaultuser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactid</column-name><column-value><![CDATA[");
		sb.append(getContactid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>password_</column-name><column-value><![CDATA[");
		sb.append(getPassword_());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>passwordencrypted</column-name><column-value><![CDATA[");
		sb.append(getPasswordencrypted());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>passwordreset</column-name><column-value><![CDATA[");
		sb.append(getPasswordreset());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>passwordmodifieddate</column-name><column-value><![CDATA[");
		sb.append(getPasswordmodifieddate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reminderqueryquestion</column-name><column-value><![CDATA[");
		sb.append(getReminderqueryquestion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reminderqueryanswer</column-name><column-value><![CDATA[");
		sb.append(getReminderqueryanswer());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gracelogincount</column-name><column-value><![CDATA[");
		sb.append(getGracelogincount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>screenname</column-name><column-value><![CDATA[");
		sb.append(getScreenname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailaddress</column-name><column-value><![CDATA[");
		sb.append(getEmailaddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>openid</column-name><column-value><![CDATA[");
		sb.append(getOpenid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>languageid</column-name><column-value><![CDATA[");
		sb.append(getLanguageid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>timezoneid</column-name><column-value><![CDATA[");
		sb.append(getTimezoneid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>greeting</column-name><column-value><![CDATA[");
		sb.append(getGreeting());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comments</column-name><column-value><![CDATA[");
		sb.append(getComments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstname</column-name><column-value><![CDATA[");
		sb.append(getFirstname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>middlename</column-name><column-value><![CDATA[");
		sb.append(getMiddlename());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastname</column-name><column-value><![CDATA[");
		sb.append(getLastname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobtitle</column-name><column-value><![CDATA[");
		sb.append(getJobtitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>logindate</column-name><column-value><![CDATA[");
		sb.append(getLogindate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loginip</column-name><column-value><![CDATA[");
		sb.append(getLoginip());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastlogindate</column-name><column-value><![CDATA[");
		sb.append(getLastlogindate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastloginip</column-name><column-value><![CDATA[");
		sb.append(getLastloginip());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastfailedlogindate</column-name><column-value><![CDATA[");
		sb.append(getLastfailedlogindate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>failedloginattempts</column-name><column-value><![CDATA[");
		sb.append(getFailedloginattempts());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lockout</column-name><column-value><![CDATA[");
		sb.append(getLockout());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lockoutdate</column-name><column-value><![CDATA[");
		sb.append(getLockoutdate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>agreedtotermsofuse</column-name><column-value><![CDATA[");
		sb.append(getAgreedtotermsofuse());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isProActive</column-name><column-value><![CDATA[");
		sb.append(getIsProActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _userid;
	private String _uuid_;
	private int _companyid;
	private Date _createdate;
	private Date _modifieddate;
	private boolean _defaultuser;
	private int _contactid;
	private String _password_;
	private boolean _passwordencrypted;
	private boolean _passwordreset;
	private Date _passwordmodifieddate;
	private String _reminderqueryquestion;
	private String _reminderqueryanswer;
	private int _gracelogincount;
	private String _screenname;
	private String _emailaddress;
	private String _openid;
	private String _languageid;
	private String _timezoneid;
	private String _greeting;
	private String _comments;
	private String _firstname;
	private String _middlename;
	private String _lastname;
	private String _jobtitle;
	private Date _logindate;
	private String _loginip;
	private Date _lastlogindate;
	private String _lastloginip;
	private Date _lastfailedlogindate;
	private int _failedloginattempts;
	private boolean _lockout;
	private Date _lockoutdate;
	private boolean _agreedtotermsofuse;
	private boolean _active;
	private boolean _isProActive;
	private boolean _status;
}