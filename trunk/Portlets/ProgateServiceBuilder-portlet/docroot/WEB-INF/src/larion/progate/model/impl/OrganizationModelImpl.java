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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.impl.BaseModelImpl;

import larion.progate.model.Organization;
import larion.progate.model.OrganizationSoap;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="OrganizationModelImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrganizationModelImpl extends BaseModelImpl<Organization> {
	public static final String TABLE_NAME = "organizations";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", new Integer(Types.INTEGER) },
			

			{ "name", new Integer(Types.VARCHAR) },
			

			{ "abbreviation", new Integer(Types.VARCHAR) },
			

			{ "description", new Integer(Types.VARCHAR) },
			

			{ "max_user_count", new Integer(Types.INTEGER) },
			

			{ "expired_date", new Integer(Types.TIMESTAMP) },
			

			{ "address1", new Integer(Types.VARCHAR) },
			

			{ "address2", new Integer(Types.VARCHAR) },
			

			{ "city", new Integer(Types.VARCHAR) },
			

			{ "state", new Integer(Types.VARCHAR) },
			

			{ "stateid", new Integer(Types.INTEGER) },
			

			{ "country", new Integer(Types.VARCHAR) },
			

			{ "phone", new Integer(Types.VARCHAR) },
			

			{ "org_type", new Integer(Types.VARCHAR) },
			

			{ "org_typeid", new Integer(Types.INTEGER) },
			

			{ "org_status", new Integer(Types.BOOLEAN) },
			

			{ "show_logo", new Integer(Types.BOOLEAN) },
			

			{ "logourl", new Integer(Types.VARCHAR) },
			

			{ "slogan", new Integer(Types.VARCHAR) },
			

			{ "bannerurl", new Integer(Types.VARCHAR) },
			

			{ "videourl", new Integer(Types.VARCHAR) },
			

			{ "website", new Integer(Types.VARCHAR) },
			

			{ "org_size", new Integer(Types.INTEGER) },
			

			{ "org_founded", new Integer(Types.TIMESTAMP) },
			

			{ "created_by", new Integer(Types.BIGINT) },
			

			{ "created_at", new Integer(Types.TIMESTAMP) },
			

			{ "updated_by", new Integer(Types.BIGINT) },
			

			{ "updated_at", new Integer(Types.TIMESTAMP) },
			

			{ "founder_list", new Integer(Types.VARCHAR) },
			

			{ "parent_id", new Integer(Types.INTEGER) },
			

			{ "root_id", new Integer(Types.INTEGER) },
			

			{ "bod_id", new Integer(Types.INTEGER) },
			

			{ "begin_time", new Integer(Types.TIMESTAMP) },
			

			{ "end_time", new Integer(Types.TIMESTAMP) },
			

			{ "email", new Integer(Types.VARCHAR) },
			

			{ "is_proactive", new Integer(Types.BOOLEAN) },
			

			{ "level_sharing", new Integer(Types.INTEGER) },
			

			{ "is_private_profile", new Integer(Types.BOOLEAN) },
			

			{ "profile_url", new Integer(Types.VARCHAR) },
			

			{ "max_level", new Integer(Types.INTEGER) },
			

			{ "level", new Integer(Types.INTEGER) }
		};
	public static final String TABLE_SQL_CREATE = "create table organizations (id INTEGER not null primary key,name VARCHAR(75) null,abbreviation VARCHAR(75) null,description VARCHAR(75) null,max_user_count INTEGER,expired_date DATE null,address1 VARCHAR(75) null,address2 VARCHAR(75) null,city VARCHAR(75) null,state VARCHAR(75) null,stateid INTEGER,country VARCHAR(75) null,phone VARCHAR(75) null,org_type VARCHAR(75) null,org_typeid INTEGER,org_status BOOLEAN,show_logo BOOLEAN,logourl VARCHAR(75) null,slogan VARCHAR(75) null,bannerurl VARCHAR(75) null,videourl VARCHAR(75) null,website VARCHAR(75) null,org_size INTEGER,org_founded DATE null,created_by LONG,created_at DATE null,updated_by LONG,updated_at DATE null,founder_list VARCHAR(75) null,parent_id INTEGER,root_id INTEGER,bod_id INTEGER,begin_time DATE null,end_time DATE null,email VARCHAR(75) null,is_proactive BOOLEAN,level_sharing INTEGER,is_private_profile BOOLEAN,profile_url VARCHAR(75) null,max_level INTEGER,level INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table organizations";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.larion.progate.model.Organization"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.larion.progate.model.Organization"),
			false);

	public static Organization toModel(OrganizationSoap soapModel) {
		Organization model = new OrganizationImpl();

		model.setOrgId(soapModel.getOrgId());
		model.setName(soapModel.getName());
		model.setAbbreviation(soapModel.getAbbreviation());
		model.setDescription(soapModel.getDescription());
		model.setMaxUserCount(soapModel.getMaxUserCount());
		model.setExpiredDate(soapModel.getExpiredDate());
		model.setAddress1(soapModel.getAddress1());
		model.setAddress2(soapModel.getAddress2());
		model.setCity(soapModel.getCity());
		model.setState(soapModel.getState());
		model.setStateId(soapModel.getStateId());
		model.setCountry(soapModel.getCountry());
		model.setPhone(soapModel.getPhone());
		model.setOrgType(soapModel.getOrgType());
		model.setOrgTypeId(soapModel.getOrgTypeId());
		model.setOrgStatus(soapModel.getOrgStatus());
		model.setShowLogo(soapModel.getShowLogo());
		model.setLogoId(soapModel.getLogoId());
		model.setSlogan(soapModel.getSlogan());
		model.setBannerId(soapModel.getBannerId());
		model.setVideorUrl(soapModel.getVideorUrl());
		model.setWebsite(soapModel.getWebsite());
		model.setOrgSize(soapModel.getOrgSize());
		model.setOrgFounded(soapModel.getOrgFounded());
		model.setCreatedBy(soapModel.getCreatedBy());
		model.setCreatedAt(soapModel.getCreatedAt());
		model.setUpdatedBy(soapModel.getUpdatedBy());
		model.setUpdatedAt(soapModel.getUpdatedAt());
		model.setFounderList(soapModel.getFounderList());
		model.setOrgParent(soapModel.getOrgParent());
		model.setRootId(soapModel.getRootId());
		model.setBodId(soapModel.getBodId());
		model.setBeginTime(soapModel.getBeginTime());
		model.setEndTime(soapModel.getEndTime());
		model.setEmail(soapModel.getEmail());
		model.setIsProactive(soapModel.getIsProactive());
		model.setLevelSharing(soapModel.getLevelSharing());
		model.setIsPrivateProfile(soapModel.getIsPrivateProfile());
		model.setProfileUrl(soapModel.getProfileUrl());
		model.setMaxLevel(soapModel.getMaxLevel());
		model.setLevel(soapModel.getLevel());

		return model;
	}

	public static List<Organization> toModels(OrganizationSoap[] soapModels) {
		List<Organization> models = new ArrayList<Organization>(soapModels.length);

		for (OrganizationSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.larion.progate.model.Organization"));

	public OrganizationModelImpl() {
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
		return GetterUtil.getString(_name);
	}

	public void setName(String name) {
		_name = name;
	}

	public String getAbbreviation() {
		return GetterUtil.getString(_abbreviation);
	}

	public void setAbbreviation(String abbreviation) {
		_abbreviation = abbreviation;
	}

	public String getDescription() {
		return GetterUtil.getString(_description);
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
		return GetterUtil.getString(_address1);
	}

	public void setAddress1(String address1) {
		_address1 = address1;
	}

	public String getAddress2() {
		return GetterUtil.getString(_address2);
	}

	public void setAddress2(String address2) {
		_address2 = address2;
	}

	public String getCity() {
		return GetterUtil.getString(_city);
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getState() {
		return GetterUtil.getString(_state);
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
		return GetterUtil.getString(_country);
	}

	public void setCountry(String country) {
		_country = country;
	}

	public String getPhone() {
		return GetterUtil.getString(_phone);
	}

	public void setPhone(String phone) {
		_phone = phone;
	}

	public String getOrgType() {
		return GetterUtil.getString(_orgType);
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
		return GetterUtil.getString(_logoId);
	}

	public void setLogoId(String logoId) {
		_logoId = logoId;
	}

	public String getSlogan() {
		return GetterUtil.getString(_slogan);
	}

	public void setSlogan(String slogan) {
		_slogan = slogan;
	}

	public String getBannerId() {
		return GetterUtil.getString(_bannerId);
	}

	public void setBannerId(String bannerId) {
		_bannerId = bannerId;
	}

	public String getVideorUrl() {
		return GetterUtil.getString(_videorUrl);
	}

	public void setVideorUrl(String videorUrl) {
		_videorUrl = videorUrl;
	}

	public String getWebsite() {
		return GetterUtil.getString(_website);
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
		return GetterUtil.getString(_founderList);
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
		return GetterUtil.getString(_email);
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
		return GetterUtil.getString(_profileUrl);
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
			return (Organization)this;
		}
		else {
			Organization model = new OrganizationImpl();

			model.setNew(isNew());
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
		OrganizationImpl clone = new OrganizationImpl();

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

		Organization organization = null;

		try {
			organization = (Organization)obj;
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