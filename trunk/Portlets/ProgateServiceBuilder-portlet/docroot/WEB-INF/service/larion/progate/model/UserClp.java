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
 * <a href="UserClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class UserClp extends BaseModelImpl<User> implements User {
	public UserClp() {
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
		return _uuid_;
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
		return _password_;
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
		return _reminderqueryquestion;
	}

	public void setReminderqueryquestion(String reminderqueryquestion) {
		_reminderqueryquestion = reminderqueryquestion;
	}

	public String getReminderqueryanswer() {
		return _reminderqueryanswer;
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
		return _screenname;
	}

	public void setScreenname(String screenname) {
		_screenname = screenname;
	}

	public String getEmailaddress() {
		return _emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		_emailaddress = emailaddress;
	}

	public String getOpenid() {
		return _openid;
	}

	public void setOpenid(String openid) {
		_openid = openid;
	}

	public String getLanguageid() {
		return _languageid;
	}

	public void setLanguageid(String languageid) {
		_languageid = languageid;
	}

	public String getTimezoneid() {
		return _timezoneid;
	}

	public void setTimezoneid(String timezoneid) {
		_timezoneid = timezoneid;
	}

	public String getGreeting() {
		return _greeting;
	}

	public void setGreeting(String greeting) {
		_greeting = greeting;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	public String getFirstname() {
		return _firstname;
	}

	public void setFirstname(String firstname) {
		_firstname = firstname;
	}

	public String getMiddlename() {
		return _middlename;
	}

	public void setMiddlename(String middlename) {
		_middlename = middlename;
	}

	public String getLastname() {
		return _lastname;
	}

	public void setLastname(String lastname) {
		_lastname = lastname;
	}

	public String getJobtitle() {
		return _jobtitle;
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
		return _loginip;
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
		return _lastloginip;
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
			return this;
		}
		else {
			User model = new UserClp();

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
		UserClp clone = new UserClp();

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

		UserClp user = null;

		try {
			user = (UserClp)obj;
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