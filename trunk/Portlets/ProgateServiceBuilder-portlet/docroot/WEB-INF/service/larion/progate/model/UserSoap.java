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
 * <a href="UserSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class UserSoap implements Serializable {
	public static UserSoap toSoapModel(User model) {
		UserSoap soapModel = new UserSoap();

		soapModel.setUserid(model.getUserid());
		soapModel.setUuid_(model.getUuid_());
		soapModel.setCompanyid(model.getCompanyid());
		soapModel.setCreatedate(model.getCreatedate());
		soapModel.setModifieddate(model.getModifieddate());
		soapModel.setDefaultuser(model.getDefaultuser());
		soapModel.setContactid(model.getContactid());
		soapModel.setPassword_(model.getPassword_());
		soapModel.setPasswordencrypted(model.getPasswordencrypted());
		soapModel.setPasswordreset(model.getPasswordreset());
		soapModel.setPasswordmodifieddate(model.getPasswordmodifieddate());
		soapModel.setReminderqueryquestion(model.getReminderqueryquestion());
		soapModel.setReminderqueryanswer(model.getReminderqueryanswer());
		soapModel.setGracelogincount(model.getGracelogincount());
		soapModel.setScreenname(model.getScreenname());
		soapModel.setEmailaddress(model.getEmailaddress());
		soapModel.setOpenid(model.getOpenid());
		soapModel.setLanguageid(model.getLanguageid());
		soapModel.setTimezoneid(model.getTimezoneid());
		soapModel.setGreeting(model.getGreeting());
		soapModel.setComments(model.getComments());
		soapModel.setFirstname(model.getFirstname());
		soapModel.setMiddlename(model.getMiddlename());
		soapModel.setLastname(model.getLastname());
		soapModel.setJobtitle(model.getJobtitle());
		soapModel.setLogindate(model.getLogindate());
		soapModel.setLoginip(model.getLoginip());
		soapModel.setLastlogindate(model.getLastlogindate());
		soapModel.setLastloginip(model.getLastloginip());
		soapModel.setLastfailedlogindate(model.getLastfailedlogindate());
		soapModel.setFailedloginattempts(model.getFailedloginattempts());
		soapModel.setLockout(model.getLockout());
		soapModel.setLockoutdate(model.getLockoutdate());
		soapModel.setAgreedtotermsofuse(model.getAgreedtotermsofuse());
		soapModel.setActive(model.getActive());
		soapModel.setIsProActive(model.getIsProActive());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static UserSoap[] toSoapModels(User[] models) {
		UserSoap[] soapModels = new UserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserSoap[][] toSoapModels(User[][] models) {
		UserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserSoap[] toSoapModels(List<User> models) {
		List<UserSoap> soapModels = new ArrayList<UserSoap>(models.size());

		for (User model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserSoap[soapModels.size()]);
	}

	public UserSoap() {
	}

	public Integer getPrimaryKey() {
		return _userid;
	}

	public void setPrimaryKey(Integer pk) {
		setUserid(pk);
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