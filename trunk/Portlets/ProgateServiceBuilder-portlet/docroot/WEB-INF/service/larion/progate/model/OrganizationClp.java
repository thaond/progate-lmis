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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * <a href="OrganizationClp.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrganizationClp extends BaseModelImpl<Organization>
	implements Organization {
	public OrganizationClp() {
	}

	public Integer getPrimaryKey() {
		return _orgId;
	}

	public void setPrimaryKey(Integer pk) {
		setOrgId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return _orgId;
	}

	public Integer getOrgId() {
		return _orgId;
	}

	public void setOrgId(Integer orgId) {
		_orgId = orgId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getAbbreviation() {
		return _abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		_abbreviation = abbreviation;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getMaxUserCount() {
		return _maxUserCount;
	}

	public void setMaxUserCount(int maxUserCount) {
		_maxUserCount = maxUserCount;
	}

	public Date getExpiredDate() {
		return _expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		_expiredDate = expiredDate;
	}

	public String getAddress1() {
		return _address1;
	}

	public void setAddress1(String address1) {
		_address1 = address1;
	}

	public String getAddress2() {
		return _address2;
	}

	public void setAddress2(String address2) {
		_address2 = address2;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	public int getStateId() {
		return _stateId;
	}

	public void setStateId(int stateId) {
		_stateId = stateId;
	}

	public String getCountry() {
		return _country;
	}

	public void setCountry(String country) {
		_country = country;
	}

	public String getPhone() {
		return _phone;
	}

	public void setPhone(String phone) {
		_phone = phone;
	}

	public String getOrgType() {
		return _orgType;
	}

	public void setOrgType(String orgType) {
		_orgType = orgType;
	}

	public int getOrgTypeId() {
		return _orgTypeId;
	}

	public void setOrgTypeId(int orgTypeId) {
		_orgTypeId = orgTypeId;
	}

	public boolean getOrgStatus() {
		return _orgStatus;
	}

	public boolean isOrgStatus() {
		return _orgStatus;
	}

	public void setOrgStatus(boolean orgStatus) {
		_orgStatus = orgStatus;
	}

	public boolean getShowLogo() {
		return _showLogo;
	}

	public boolean isShowLogo() {
		return _showLogo;
	}

	public void setShowLogo(boolean showLogo) {
		_showLogo = showLogo;
	}

	public String getLogoId() {
		return _logoId;
	}

	public void setLogoId(String logoId) {
		_logoId = logoId;
	}

	public String getSlogan() {
		return _slogan;
	}

	public void setSlogan(String slogan) {
		_slogan = slogan;
	}

	public String getBannerId() {
		return _bannerId;
	}

	public void setBannerId(String bannerId) {
		_bannerId = bannerId;
	}

	public String getVideorUrl() {
		return _videorUrl;
	}

	public void setVideorUrl(String videorUrl) {
		_videorUrl = videorUrl;
	}

	public String getWebsite() {
		return _website;
	}

	public void setWebsite(String website) {
		_website = website;
	}

	public int getOrgSize() {
		return _orgSize;
	}

	public void setOrgSize(int orgSize) {
		_orgSize = orgSize;
	}

	public Date getOrgFounded() {
		return _orgFounded;
	}

	public void setOrgFounded(Date orgFounded) {
		_orgFounded = orgFounded;
	}

	public long getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return _createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		_createdAt = createdAt;
	}

	public long getUpdatedBy() {
		return _updatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
		_updatedBy = updatedBy;
	}

	public Date getUpdatedAt() {
		return _updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		_updatedAt = updatedAt;
	}

	public String getFounderList() {
		return _founderList;
	}

	public void setFounderList(String founderList) {
		_founderList = founderList;
	}

	public int getOrgParent() {
		return _orgParent;
	}

	public void setOrgParent(int orgParent) {
		_orgParent = orgParent;
	}

	public int getRootId() {
		return _rootId;
	}

	public void setRootId(int rootId) {
		_rootId = rootId;
	}

	public int getBodId() {
		return _bodId;
	}

	public void setBodId(int bodId) {
		_bodId = bodId;
	}

	public Date getBeginTime() {
		return _beginTime;
	}

	public void setBeginTime(Date beginTime) {
		_beginTime = beginTime;
	}

	public Date getEndTime() {
		return _endTime;
	}

	public void setEndTime(Date endTime) {
		_endTime = endTime;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public boolean getIsProactive() {
		return _isProactive;
	}

	public boolean isIsProactive() {
		return _isProactive;
	}

	public void setIsProactive(boolean isProactive) {
		_isProactive = isProactive;
	}

	public int getLevelSharing() {
		return _levelSharing;
	}

	public void setLevelSharing(int levelSharing) {
		_levelSharing = levelSharing;
	}

	public boolean getIsPrivateProfile() {
		return _isPrivateProfile;
	}

	public boolean isIsPrivateProfile() {
		return _isPrivateProfile;
	}

	public void setIsPrivateProfile(boolean isPrivateProfile) {
		_isPrivateProfile = isPrivateProfile;
	}

	public String getProfileUrl() {
		return _profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		_profileUrl = profileUrl;
	}

	public int getMaxLevel() {
		return _maxLevel;
	}

	public void setMaxLevel(int maxLevel) {
		_maxLevel = maxLevel;
	}

	public int getLevel() {
		return _level;
	}

	public void setLevel(int level) {
		_level = level;
	}

	public Organization toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			Organization model = new OrganizationClp();

			model.setEscapedModel(true);

			model.setOrgId(getOrgId());
			model.setName(HtmlUtil.escape(getName()));
			model.setAbbreviation(HtmlUtil.escape(getAbbreviation()));
			model.setDescription(HtmlUtil.escape(getDescription()));
			model.setMaxUserCount(getMaxUserCount());
			model.setExpiredDate(getExpiredDate());
			model.setAddress1(HtmlUtil.escape(getAddress1()));
			model.setAddress2(HtmlUtil.escape(getAddress2()));
			model.setCity(HtmlUtil.escape(getCity()));
			model.setState(HtmlUtil.escape(getState()));
			model.setStateId(getStateId());
			model.setCountry(HtmlUtil.escape(getCountry()));
			model.setPhone(HtmlUtil.escape(getPhone()));
			model.setOrgType(HtmlUtil.escape(getOrgType()));
			model.setOrgTypeId(getOrgTypeId());
			model.setOrgStatus(getOrgStatus());
			model.setShowLogo(getShowLogo());
			model.setLogoId(HtmlUtil.escape(getLogoId()));
			model.setSlogan(HtmlUtil.escape(getSlogan()));
			model.setBannerId(HtmlUtil.escape(getBannerId()));
			model.setVideorUrl(HtmlUtil.escape(getVideorUrl()));
			model.setWebsite(HtmlUtil.escape(getWebsite()));
			model.setOrgSize(getOrgSize());
			model.setOrgFounded(getOrgFounded());
			model.setCreatedBy(getCreatedBy());
			model.setCreatedAt(getCreatedAt());
			model.setUpdatedBy(getUpdatedBy());
			model.setUpdatedAt(getUpdatedAt());
			model.setFounderList(HtmlUtil.escape(getFounderList()));
			model.setOrgParent(getOrgParent());
			model.setRootId(getRootId());
			model.setBodId(getBodId());
			model.setBeginTime(getBeginTime());
			model.setEndTime(getEndTime());
			model.setEmail(HtmlUtil.escape(getEmail()));
			model.setIsProactive(getIsProactive());
			model.setLevelSharing(getLevelSharing());
			model.setIsPrivateProfile(getIsPrivateProfile());
			model.setProfileUrl(HtmlUtil.escape(getProfileUrl()));
			model.setMaxLevel(getMaxLevel());
			model.setLevel(getLevel());

			model = (Organization)Proxy.newProxyInstance(Organization.class.getClassLoader(),
					new Class[] { Organization.class },
					new ReadOnlyBeanHandler(model));

			return model;
		}
	}

	public Object clone() {
		OrganizationClp clone = new OrganizationClp();

		clone.setOrgId(getOrgId());
		clone.setName(getName());
		clone.setAbbreviation(getAbbreviation());
		clone.setDescription(getDescription());
		clone.setMaxUserCount(getMaxUserCount());
		clone.setExpiredDate(getExpiredDate());
		clone.setAddress1(getAddress1());
		clone.setAddress2(getAddress2());
		clone.setCity(getCity());
		clone.setState(getState());
		clone.setStateId(getStateId());
		clone.setCountry(getCountry());
		clone.setPhone(getPhone());
		clone.setOrgType(getOrgType());
		clone.setOrgTypeId(getOrgTypeId());
		clone.setOrgStatus(getOrgStatus());
		clone.setShowLogo(getShowLogo());
		clone.setLogoId(getLogoId());
		clone.setSlogan(getSlogan());
		clone.setBannerId(getBannerId());
		clone.setVideorUrl(getVideorUrl());
		clone.setWebsite(getWebsite());
		clone.setOrgSize(getOrgSize());
		clone.setOrgFounded(getOrgFounded());
		clone.setCreatedBy(getCreatedBy());
		clone.setCreatedAt(getCreatedAt());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedAt(getUpdatedAt());
		clone.setFounderList(getFounderList());
		clone.setOrgParent(getOrgParent());
		clone.setRootId(getRootId());
		clone.setBodId(getBodId());
		clone.setBeginTime(getBeginTime());
		clone.setEndTime(getEndTime());
		clone.setEmail(getEmail());
		clone.setIsProactive(getIsProactive());
		clone.setLevelSharing(getLevelSharing());
		clone.setIsPrivateProfile(getIsPrivateProfile());
		clone.setProfileUrl(getProfileUrl());
		clone.setMaxLevel(getMaxLevel());
		clone.setLevel(getLevel());

		return clone;
	}

	public int compareTo(Organization organization) {
		int value = 0;

		value = DateUtil.compareTo(getUpdatedAt(), organization.getUpdatedAt());

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getCreatedAt(), organization.getCreatedAt());

		if (value != 0) {
			return value;
		}

		value = getName().compareTo(organization.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		OrganizationClp organization = null;

		try {
			organization = (OrganizationClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		Integer pk = organization.getPrimaryKey();

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

		sb.append("{orgId=");
		sb.append(getOrgId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", abbreviation=");
		sb.append(getAbbreviation());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", maxUserCount=");
		sb.append(getMaxUserCount());
		sb.append(", expiredDate=");
		sb.append(getExpiredDate());
		sb.append(", address1=");
		sb.append(getAddress1());
		sb.append(", address2=");
		sb.append(getAddress2());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", state=");
		sb.append(getState());
		sb.append(", stateId=");
		sb.append(getStateId());
		sb.append(", country=");
		sb.append(getCountry());
		sb.append(", phone=");
		sb.append(getPhone());
		sb.append(", orgType=");
		sb.append(getOrgType());
		sb.append(", orgTypeId=");
		sb.append(getOrgTypeId());
		sb.append(", orgStatus=");
		sb.append(getOrgStatus());
		sb.append(", showLogo=");
		sb.append(getShowLogo());
		sb.append(", logoId=");
		sb.append(getLogoId());
		sb.append(", slogan=");
		sb.append(getSlogan());
		sb.append(", bannerId=");
		sb.append(getBannerId());
		sb.append(", videorUrl=");
		sb.append(getVideorUrl());
		sb.append(", website=");
		sb.append(getWebsite());
		sb.append(", orgSize=");
		sb.append(getOrgSize());
		sb.append(", orgFounded=");
		sb.append(getOrgFounded());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", createdAt=");
		sb.append(getCreatedAt());
		sb.append(", updatedBy=");
		sb.append(getUpdatedBy());
		sb.append(", updatedAt=");
		sb.append(getUpdatedAt());
		sb.append(", founderList=");
		sb.append(getFounderList());
		sb.append(", orgParent=");
		sb.append(getOrgParent());
		sb.append(", rootId=");
		sb.append(getRootId());
		sb.append(", bodId=");
		sb.append(getBodId());
		sb.append(", beginTime=");
		sb.append(getBeginTime());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", isProactive=");
		sb.append(getIsProactive());
		sb.append(", levelSharing=");
		sb.append(getLevelSharing());
		sb.append(", isPrivateProfile=");
		sb.append(getIsPrivateProfile());
		sb.append(", profileUrl=");
		sb.append(getProfileUrl());
		sb.append(", maxLevel=");
		sb.append(getMaxLevel());
		sb.append(", level=");
		sb.append(getLevel());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBuilder sb = new StringBuilder();

		sb.append("<model><model-name>");
		sb.append("larion.progate.model.Organization");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>orgId</column-name><column-value><![CDATA[");
		sb.append(getOrgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>abbreviation</column-name><column-value><![CDATA[");
		sb.append(getAbbreviation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxUserCount</column-name><column-value><![CDATA[");
		sb.append(getMaxUserCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expiredDate</column-name><column-value><![CDATA[");
		sb.append(getExpiredDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address1</column-name><column-value><![CDATA[");
		sb.append(getAddress1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address2</column-name><column-value><![CDATA[");
		sb.append(getAddress2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>state</column-name><column-value><![CDATA[");
		sb.append(getState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stateId</column-name><column-value><![CDATA[");
		sb.append(getStateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>country</column-name><column-value><![CDATA[");
		sb.append(getCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phone</column-name><column-value><![CDATA[");
		sb.append(getPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgType</column-name><column-value><![CDATA[");
		sb.append(getOrgType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgTypeId</column-name><column-value><![CDATA[");
		sb.append(getOrgTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgStatus</column-name><column-value><![CDATA[");
		sb.append(getOrgStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>showLogo</column-name><column-value><![CDATA[");
		sb.append(getShowLogo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>logoId</column-name><column-value><![CDATA[");
		sb.append(getLogoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>slogan</column-name><column-value><![CDATA[");
		sb.append(getSlogan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bannerId</column-name><column-value><![CDATA[");
		sb.append(getBannerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videorUrl</column-name><column-value><![CDATA[");
		sb.append(getVideorUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>website</column-name><column-value><![CDATA[");
		sb.append(getWebsite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgSize</column-name><column-value><![CDATA[");
		sb.append(getOrgSize());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgFounded</column-name><column-value><![CDATA[");
		sb.append(getOrgFounded());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdAt</column-name><column-value><![CDATA[");
		sb.append(getCreatedAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updatedBy</column-name><column-value><![CDATA[");
		sb.append(getUpdatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updatedAt</column-name><column-value><![CDATA[");
		sb.append(getUpdatedAt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>founderList</column-name><column-value><![CDATA[");
		sb.append(getFounderList());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgParent</column-name><column-value><![CDATA[");
		sb.append(getOrgParent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rootId</column-name><column-value><![CDATA[");
		sb.append(getRootId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bodId</column-name><column-value><![CDATA[");
		sb.append(getBodId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>beginTime</column-name><column-value><![CDATA[");
		sb.append(getBeginTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endTime</column-name><column-value><![CDATA[");
		sb.append(getEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isProactive</column-name><column-value><![CDATA[");
		sb.append(getIsProactive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>levelSharing</column-name><column-value><![CDATA[");
		sb.append(getLevelSharing());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isPrivateProfile</column-name><column-value><![CDATA[");
		sb.append(getIsPrivateProfile());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>profileUrl</column-name><column-value><![CDATA[");
		sb.append(getProfileUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxLevel</column-name><column-value><![CDATA[");
		sb.append(getMaxLevel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>level</column-name><column-value><![CDATA[");
		sb.append(getLevel());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Integer _orgId;
	private String _name;
	private String _abbreviation;
	private String _description;
	private int _maxUserCount;
	private Date _expiredDate;
	private String _address1;
	private String _address2;
	private String _city;
	private String _state;
	private int _stateId;
	private String _country;
	private String _phone;
	private String _orgType;
	private int _orgTypeId;
	private boolean _orgStatus;
	private boolean _showLogo;
	private String _logoId;
	private String _slogan;
	private String _bannerId;
	private String _videorUrl;
	private String _website;
	private int _orgSize;
	private Date _orgFounded;
	private long _createdBy;
	private Date _createdAt;
	private long _updatedBy;
	private Date _updatedAt;
	private String _founderList;
	private int _orgParent;
	private int _rootId;
	private int _bodId;
	private Date _beginTime;
	private Date _endTime;
	private String _email;
	private boolean _isProactive;
	private int _levelSharing;
	private boolean _isPrivateProfile;
	private String _profileUrl;
	private int _maxLevel;
	private int _level;
}