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
 * <a href="UserModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface UserModel extends BaseModel<User> {
	public Integer getPrimaryKey();

	public void setPrimaryKey(Integer pk);

	public Integer getUserid();

	public void setUserid(Integer userid);

	public String getUuid_();

	public void setUuid_(String uuid_);

	public int getCompanyid();

	public void setCompanyid(int companyid);

	public Date getCreatedate();

	public void setCreatedate(Date createdate);

	public Date getModifieddate();

	public void setModifieddate(Date modifieddate);

	public boolean getDefaultuser();

	public boolean isDefaultuser();

	public void setDefaultuser(boolean defaultuser);

	public int getContactid();

	public void setContactid(int contactid);

	public String getPassword_();

	public void setPassword_(String password_);

	public boolean getPasswordencrypted();

	public boolean isPasswordencrypted();

	public void setPasswordencrypted(boolean passwordencrypted);

	public boolean getPasswordreset();

	public boolean isPasswordreset();

	public void setPasswordreset(boolean passwordreset);

	public Date getPasswordmodifieddate();

	public void setPasswordmodifieddate(Date passwordmodifieddate);

	public String getReminderqueryquestion();

	public void setReminderqueryquestion(String reminderqueryquestion);

	public String getReminderqueryanswer();

	public void setReminderqueryanswer(String reminderqueryanswer);

	public int getGracelogincount();

	public void setGracelogincount(int gracelogincount);

	public String getScreenname();

	public void setScreenname(String screenname);

	public String getEmailaddress();

	public void setEmailaddress(String emailaddress);

	public String getOpenid();

	public void setOpenid(String openid);

	public String getLanguageid();

	public void setLanguageid(String languageid);

	public String getTimezoneid();

	public void setTimezoneid(String timezoneid);

	public String getGreeting();

	public void setGreeting(String greeting);

	public String getComments();

	public void setComments(String comments);

	public String getFirstname();

	public void setFirstname(String firstname);

	public String getMiddlename();

	public void setMiddlename(String middlename);

	public String getLastname();

	public void setLastname(String lastname);

	public String getJobtitle();

	public void setJobtitle(String jobtitle);

	public Date getLogindate();

	public void setLogindate(Date logindate);

	public String getLoginip();

	public void setLoginip(String loginip);

	public Date getLastlogindate();

	public void setLastlogindate(Date lastlogindate);

	public String getLastloginip();

	public void setLastloginip(String lastloginip);

	public Date getLastfailedlogindate();

	public void setLastfailedlogindate(Date lastfailedlogindate);

	public int getFailedloginattempts();

	public void setFailedloginattempts(int failedloginattempts);

	public boolean getLockout();

	public boolean isLockout();

	public void setLockout(boolean lockout);

	public Date getLockoutdate();

	public void setLockoutdate(Date lockoutdate);

	public boolean getAgreedtotermsofuse();

	public boolean isAgreedtotermsofuse();

	public void setAgreedtotermsofuse(boolean agreedtotermsofuse);

	public boolean getActive();

	public boolean isActive();

	public void setActive(boolean active);

	public boolean getIsProActive();

	public boolean isIsProActive();

	public void setIsProActive(boolean isProActive);

	public boolean getStatus();

	public boolean isStatus();

	public void setStatus(boolean status);

	public User toEscapedModel();
}