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
 * <a href="OrganizationSoap.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class OrganizationSoap implements Serializable {
	public static OrganizationSoap toSoapModel(Organization model) {
		OrganizationSoap soapModel = new OrganizationSoap();

		soapModel.setOrgId(model.getOrgId());
		soapModel.setName(model.getName());
		soapModel.setAbbreviation(model.getAbbreviation());
		soapModel.setDescription(model.getDescription());
		soapModel.setMaxUserCount(model.getMaxUserCount());
		soapModel.setExpiredDate(model.getExpiredDate());
		soapModel.setAddress1(model.getAddress1());
		soapModel.setAddress2(model.getAddress2());
		soapModel.setCity(model.getCity());
		soapModel.setState(model.getState());
		soapModel.setStateId(model.getStateId());
		soapModel.setCountry(model.getCountry());
		soapModel.setPhone(model.getPhone());
		soapModel.setOrgType(model.getOrgType());
		soapModel.setOrgTypeId(model.getOrgTypeId());
		soapModel.setOrgStatus(model.getOrgStatus());
		soapModel.setShowLogo(model.getShowLogo());
		soapModel.setLogoId(model.getLogoId());
		soapModel.setSlogan(model.getSlogan());
		soapModel.setBannerId(model.getBannerId());
		soapModel.setVideorUrl(model.getVideorUrl());
		soapModel.setWebsite(model.getWebsite());
		soapModel.setOrgSize(model.getOrgSize());
		soapModel.setOrgFounded(model.getOrgFounded());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreatedAt(model.getCreatedAt());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedAt(model.getUpdatedAt());
		soapModel.setFounderList(model.getFounderList());
		soapModel.setOrgParent(model.getOrgParent());
		soapModel.setRootId(model.getRootId());
		soapModel.setBodId(model.getBodId());
		soapModel.setBeginTime(model.getBeginTime());
		soapModel.setEndTime(model.getEndTime());
		soapModel.setEmail(model.getEmail());
		soapModel.setIsProactive(model.getIsProactive());
		soapModel.setLevelSharing(model.getLevelSharing());
		soapModel.setIsPrivateProfile(model.getIsPrivateProfile());
		soapModel.setProfileUrl(model.getProfileUrl());
		soapModel.setMaxLevel(model.getMaxLevel());
		soapModel.setLevel(model.getLevel());

		return soapModel;
	}

	public static OrganizationSoap[] toSoapModels(Organization[] models) {
		OrganizationSoap[] soapModels = new OrganizationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrganizationSoap[][] toSoapModels(Organization[][] models) {
		OrganizationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OrganizationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrganizationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrganizationSoap[] toSoapModels(List<Organization> models) {
		List<OrganizationSoap> soapModels = new ArrayList<OrganizationSoap>(models.size());

		for (Organization model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OrganizationSoap[soapModels.size()]);
	}

	public OrganizationSoap() {
	}

	public Integer getPrimaryKey() {
		return _orgId;
	}

	public void setPrimaryKey(Integer pk) {
		setOrgId(pk);
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