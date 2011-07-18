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
 * <a href="OrganizationModel.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface OrganizationModel extends BaseModel<Organization> {
	public Integer getPrimaryKey();

	public void setPrimaryKey(Integer pk);

	public Integer getOrgId();

	public void setOrgId(Integer orgId);

	public String getName();

	public void setName(String name);

	public String getAbbreviation();

	public void setAbbreviation(String abbreviation);

	public String getDescription();

	public void setDescription(String description);

	public int getMaxUserCount();

	public void setMaxUserCount(int maxUserCount);

	public Date getExpiredDate();

	public void setExpiredDate(Date expiredDate);

	public String getAddress1();

	public void setAddress1(String address1);

	public String getAddress2();

	public void setAddress2(String address2);

	public String getCity();

	public void setCity(String city);

	public String getState();

	public void setState(String state);

	public int getStateId();

	public void setStateId(int stateId);

	public String getCountry();

	public void setCountry(String country);

	public String getPhone();

	public void setPhone(String phone);

	public String getOrgType();

	public void setOrgType(String orgType);

	public int getOrgTypeId();

	public void setOrgTypeId(int orgTypeId);

	public boolean getOrgStatus();

	public boolean isOrgStatus();

	public void setOrgStatus(boolean orgStatus);

	public boolean getShowLogo();

	public boolean isShowLogo();

	public void setShowLogo(boolean showLogo);

	public String getLogoId();

	public void setLogoId(String logoId);

	public String getSlogan();

	public void setSlogan(String slogan);

	public String getBannerId();

	public void setBannerId(String bannerId);

	public String getVideorUrl();

	public void setVideorUrl(String videorUrl);

	public String getWebsite();

	public void setWebsite(String website);

	public int getOrgSize();

	public void setOrgSize(int orgSize);

	public Date getOrgFounded();

	public void setOrgFounded(Date orgFounded);

	public long getCreatedBy();

	public void setCreatedBy(long createdBy);

	public Date getCreatedAt();

	public void setCreatedAt(Date createdAt);

	public long getUpdatedBy();

	public void setUpdatedBy(long updatedBy);

	public Date getUpdatedAt();

	public void setUpdatedAt(Date updatedAt);

	public String getFounderList();

	public void setFounderList(String founderList);

	public int getOrgParent();

	public void setOrgParent(int orgParent);

	public int getRootId();

	public void setRootId(int rootId);

	public int getBodId();

	public void setBodId(int bodId);

	public Date getBeginTime();

	public void setBeginTime(Date beginTime);

	public Date getEndTime();

	public void setEndTime(Date endTime);

	public String getEmail();

	public void setEmail(String email);

	public boolean getIsProactive();

	public boolean isIsProactive();

	public void setIsProactive(boolean isProactive);

	public int getLevelSharing();

	public void setLevelSharing(int levelSharing);

	public boolean getIsPrivateProfile();

	public boolean isIsPrivateProfile();

	public void setIsPrivateProfile(boolean isPrivateProfile);

	public String getProfileUrl();

	public void setProfileUrl(String profileUrl);

	public int getMaxLevel();

	public void setMaxLevel(int maxLevel);

	public int getLevel();

	public void setLevel(int level);

	public Organization toEscapedModel();
}