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

package larion.progate.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModel;

import larion.progate.model.CountryClp;
import larion.progate.model.OrgObjectApprovalClp;
import larion.progate.model.OrgObjectListClp;
import larion.progate.model.OrgObjectMeasureClp;
import larion.progate.model.OrgObjectObjectiveClp;
import larion.progate.model.OrgObjectPerspectiveClp;
import larion.progate.model.OrgObjectTargetsClp;
import larion.progate.model.OrganizationClp;
import larion.progate.model.OrganizationViewClp;
import larion.progate.model.ProGateApplicationsClp;
import larion.progate.model.ProGateCurrencyTypesClp;
import larion.progate.model.ProGateJournalArticleClp;
import larion.progate.model.ProGateJournalArticlePrioritiesClp;
import larion.progate.model.ProGateJournalArticleSlideShowClp;
import larion.progate.model.ProGateJournalArticleTypesClp;
import larion.progate.model.ProGateJournalArticleViewClp;
import larion.progate.model.ProGateMenuViewClp;
import larion.progate.model.ProGateOrgCustomerClp;
import larion.progate.model.ProGateOrgCustomerRepresenterClp;
import larion.progate.model.ProGateOrgTypeClp;
import larion.progate.model.ProGateOrgsUsersPermissionsClp;
import larion.progate.model.ProGatePermissionsClp;
import larion.progate.model.ProGateProductsServicesClp;
import larion.progate.model.ProGateRolesClp;
import larion.progate.model.ProGateUserApplicationsClp;
import larion.progate.model.ProgateApplicationsSettingClp;
import larion.progate.model.ProgateLayoutsMenusClp;
import larion.progate.model.ProgateLayoutsRolesClp;
import larion.progate.model.ProgateMenusClp;
import larion.progate.model.ProgateOrganizationParticipantsClp;
import larion.progate.model.ProgateOrganizationsStaffsClp;
import larion.progate.model.ProgatePortalMenuClp;
import larion.progate.model.RegionClp;
import larion.progate.model.UserClp;
import larion.progate.model.UserInformationViewClp;
import larion.progate.model.ViewOrgUsersPermissionsClp;
import larion.progate.model.ViewProGatePermissionsRolesClp;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="ClpSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ClpSerializer {
	public static final String SERVLET_CONTEXT_NAME = "ProgateServiceBuilder-portlet";

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(UserClp.class.getName())) {
			UserClp oldCplModel = (UserClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.UserImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setUserid",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getUserid();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setUuid_",
							new Class[] { String.class });

					String value1 = oldCplModel.getUuid_();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setCompanyid",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getCompanyid());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setCreatedate",
							new Class[] { Date.class });

					Date value3 = oldCplModel.getCreatedate();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setModifieddate",
							new Class[] { Date.class });

					Date value4 = oldCplModel.getModifieddate();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setDefaultuser",
							new Class[] { Boolean.TYPE });

					Boolean value5 = new Boolean(oldCplModel.getDefaultuser());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setContactid",
							new Class[] { Integer.TYPE });

					Integer value6 = new Integer(oldCplModel.getContactid());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setPassword_",
							new Class[] { String.class });

					String value7 = oldCplModel.getPassword_();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setPasswordencrypted",
							new Class[] { Boolean.TYPE });

					Boolean value8 = new Boolean(oldCplModel.getPasswordencrypted());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setPasswordreset",
							new Class[] { Boolean.TYPE });

					Boolean value9 = new Boolean(oldCplModel.getPasswordreset());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setPasswordmodifieddate",
							new Class[] { Date.class });

					Date value10 = oldCplModel.getPasswordmodifieddate();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setReminderqueryquestion",
							new Class[] { String.class });

					String value11 = oldCplModel.getReminderqueryquestion();

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setReminderqueryanswer",
							new Class[] { String.class });

					String value12 = oldCplModel.getReminderqueryanswer();

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setGracelogincount",
							new Class[] { Integer.TYPE });

					Integer value13 = new Integer(oldCplModel.getGracelogincount());

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setScreenname",
							new Class[] { String.class });

					String value14 = oldCplModel.getScreenname();

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setEmailaddress",
							new Class[] { String.class });

					String value15 = oldCplModel.getEmailaddress();

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setOpenid",
							new Class[] { String.class });

					String value16 = oldCplModel.getOpenid();

					method16.invoke(newModel, value16);

					Method method17 = newModelClass.getMethod("setLanguageid",
							new Class[] { String.class });

					String value17 = oldCplModel.getLanguageid();

					method17.invoke(newModel, value17);

					Method method18 = newModelClass.getMethod("setTimezoneid",
							new Class[] { String.class });

					String value18 = oldCplModel.getTimezoneid();

					method18.invoke(newModel, value18);

					Method method19 = newModelClass.getMethod("setGreeting",
							new Class[] { String.class });

					String value19 = oldCplModel.getGreeting();

					method19.invoke(newModel, value19);

					Method method20 = newModelClass.getMethod("setComments",
							new Class[] { String.class });

					String value20 = oldCplModel.getComments();

					method20.invoke(newModel, value20);

					Method method21 = newModelClass.getMethod("setFirstname",
							new Class[] { String.class });

					String value21 = oldCplModel.getFirstname();

					method21.invoke(newModel, value21);

					Method method22 = newModelClass.getMethod("setMiddlename",
							new Class[] { String.class });

					String value22 = oldCplModel.getMiddlename();

					method22.invoke(newModel, value22);

					Method method23 = newModelClass.getMethod("setLastname",
							new Class[] { String.class });

					String value23 = oldCplModel.getLastname();

					method23.invoke(newModel, value23);

					Method method24 = newModelClass.getMethod("setJobtitle",
							new Class[] { String.class });

					String value24 = oldCplModel.getJobtitle();

					method24.invoke(newModel, value24);

					Method method25 = newModelClass.getMethod("setLogindate",
							new Class[] { Date.class });

					Date value25 = oldCplModel.getLogindate();

					method25.invoke(newModel, value25);

					Method method26 = newModelClass.getMethod("setLoginip",
							new Class[] { String.class });

					String value26 = oldCplModel.getLoginip();

					method26.invoke(newModel, value26);

					Method method27 = newModelClass.getMethod("setLastlogindate",
							new Class[] { Date.class });

					Date value27 = oldCplModel.getLastlogindate();

					method27.invoke(newModel, value27);

					Method method28 = newModelClass.getMethod("setLastloginip",
							new Class[] { String.class });

					String value28 = oldCplModel.getLastloginip();

					method28.invoke(newModel, value28);

					Method method29 = newModelClass.getMethod("setLastfailedlogindate",
							new Class[] { Date.class });

					Date value29 = oldCplModel.getLastfailedlogindate();

					method29.invoke(newModel, value29);

					Method method30 = newModelClass.getMethod("setFailedloginattempts",
							new Class[] { Integer.TYPE });

					Integer value30 = new Integer(oldCplModel.getFailedloginattempts());

					method30.invoke(newModel, value30);

					Method method31 = newModelClass.getMethod("setLockout",
							new Class[] { Boolean.TYPE });

					Boolean value31 = new Boolean(oldCplModel.getLockout());

					method31.invoke(newModel, value31);

					Method method32 = newModelClass.getMethod("setLockoutdate",
							new Class[] { Date.class });

					Date value32 = oldCplModel.getLockoutdate();

					method32.invoke(newModel, value32);

					Method method33 = newModelClass.getMethod("setAgreedtotermsofuse",
							new Class[] { Boolean.TYPE });

					Boolean value33 = new Boolean(oldCplModel.getAgreedtotermsofuse());

					method33.invoke(newModel, value33);

					Method method34 = newModelClass.getMethod("setActive",
							new Class[] { Boolean.TYPE });

					Boolean value34 = new Boolean(oldCplModel.getActive());

					method34.invoke(newModel, value34);

					Method method35 = newModelClass.getMethod("setIsProActive",
							new Class[] { Boolean.TYPE });

					Boolean value35 = new Boolean(oldCplModel.getIsProActive());

					method35.invoke(newModel, value35);

					Method method36 = newModelClass.getMethod("setStatus",
							new Class[] { Boolean.TYPE });

					Boolean value36 = new Boolean(oldCplModel.getStatus());

					method36.invoke(newModel, value36);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(UserInformationViewClp.class.getName())) {
			UserInformationViewClp oldCplModel = (UserInformationViewClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.UserInformationViewImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setUserInformationViewId",
							new Class[] { String.class });

					String value0 = oldCplModel.getUserInformationViewId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getUserId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setScreenName",
							new Class[] { String.class });

					String value2 = oldCplModel.getScreenName();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setEmailAddress",
							new Class[] { String.class });

					String value3 = oldCplModel.getEmailAddress();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setFirstName",
							new Class[] { String.class });

					String value4 = oldCplModel.getFirstName();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setLastName",
							new Class[] { String.class });

					String value5 = oldCplModel.getLastName();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setLastLoginDate",
							new Class[] { Date.class });

					Date value6 = oldCplModel.getLastLoginDate();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setCreateDate",
							new Class[] { Date.class });

					Date value7 = oldCplModel.getCreateDate();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setModifiedDate",
							new Class[] { Date.class });

					Date value8 = oldCplModel.getModifiedDate();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setStatus",
							new Class[] { Integer.TYPE });

					Integer value9 = new Integer(oldCplModel.getStatus());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setIsProActive",
							new Class[] { Integer.TYPE });

					Integer value10 = new Integer(oldCplModel.getIsProActive());

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setOrgId",
							new Class[] { Integer.TYPE });

					Integer value11 = new Integer(oldCplModel.getOrgId());

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setOrgName",
							new Class[] { String.class });

					String value12 = oldCplModel.getOrgName();

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setParentId",
							new Class[] { Integer.TYPE });

					Integer value13 = new Integer(oldCplModel.getParentId());

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setJoiningDesc",
							new Class[] { String.class });

					String value14 = oldCplModel.getJoiningDesc();

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setJoiningStatus",
							new Class[] { Integer.TYPE });

					Integer value15 = new Integer(oldCplModel.getJoiningStatus());

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setRequestAt",
							new Class[] { Date.class });

					Date value16 = oldCplModel.getRequestAt();

					method16.invoke(newModel, value16);

					Method method17 = newModelClass.getMethod("setApprovedAt",
							new Class[] { Date.class });

					Date value17 = oldCplModel.getApprovedAt();

					method17.invoke(newModel, value17);

					Method method18 = newModelClass.getMethod("setRoleId",
							new Class[] { Integer.TYPE });

					Integer value18 = new Integer(oldCplModel.getRoleId());

					method18.invoke(newModel, value18);

					Method method19 = newModelClass.getMethod("setRolename",
							new Class[] { String.class });

					String value19 = oldCplModel.getRolename();

					method19.invoke(newModel, value19);

					Method method20 = newModelClass.getMethod("setRolePriority",
							new Class[] { Integer.TYPE });

					Integer value20 = new Integer(oldCplModel.getRolePriority());

					method20.invoke(newModel, value20);

					Method method21 = newModelClass.getMethod("setIsCurrent",
							new Class[] { Boolean.TYPE });

					Boolean value21 = new Boolean(oldCplModel.getIsCurrent());

					method21.invoke(newModel, value21);

					Method method22 = newModelClass.getMethod("setSearchInformation",
							new Class[] { String.class });

					String value22 = oldCplModel.getSearchInformation();

					method22.invoke(newModel, value22);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(OrganizationClp.class.getName())) {
			OrganizationClp oldCplModel = (OrganizationClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.OrganizationImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setOrgId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getOrgId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value1 = oldCplModel.getName();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setAbbreviation",
							new Class[] { String.class });

					String value2 = oldCplModel.getAbbreviation();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value3 = oldCplModel.getDescription();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setMaxUserCount",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getMaxUserCount());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setExpiredDate",
							new Class[] { Date.class });

					Date value5 = oldCplModel.getExpiredDate();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setAddress1",
							new Class[] { String.class });

					String value6 = oldCplModel.getAddress1();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setAddress2",
							new Class[] { String.class });

					String value7 = oldCplModel.getAddress2();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setCity",
							new Class[] { String.class });

					String value8 = oldCplModel.getCity();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setState",
							new Class[] { String.class });

					String value9 = oldCplModel.getState();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setStateId",
							new Class[] { Integer.TYPE });

					Integer value10 = new Integer(oldCplModel.getStateId());

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setCountry",
							new Class[] { String.class });

					String value11 = oldCplModel.getCountry();

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setPhone",
							new Class[] { String.class });

					String value12 = oldCplModel.getPhone();

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setOrgType",
							new Class[] { String.class });

					String value13 = oldCplModel.getOrgType();

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setOrgTypeId",
							new Class[] { Integer.TYPE });

					Integer value14 = new Integer(oldCplModel.getOrgTypeId());

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setOrgStatus",
							new Class[] { Boolean.TYPE });

					Boolean value15 = new Boolean(oldCplModel.getOrgStatus());

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setShowLogo",
							new Class[] { Boolean.TYPE });

					Boolean value16 = new Boolean(oldCplModel.getShowLogo());

					method16.invoke(newModel, value16);

					Method method17 = newModelClass.getMethod("setLogoId",
							new Class[] { String.class });

					String value17 = oldCplModel.getLogoId();

					method17.invoke(newModel, value17);

					Method method18 = newModelClass.getMethod("setSlogan",
							new Class[] { String.class });

					String value18 = oldCplModel.getSlogan();

					method18.invoke(newModel, value18);

					Method method19 = newModelClass.getMethod("setBannerId",
							new Class[] { String.class });

					String value19 = oldCplModel.getBannerId();

					method19.invoke(newModel, value19);

					Method method20 = newModelClass.getMethod("setVideorUrl",
							new Class[] { String.class });

					String value20 = oldCplModel.getVideorUrl();

					method20.invoke(newModel, value20);

					Method method21 = newModelClass.getMethod("setWebsite",
							new Class[] { String.class });

					String value21 = oldCplModel.getWebsite();

					method21.invoke(newModel, value21);

					Method method22 = newModelClass.getMethod("setOrgSize",
							new Class[] { Integer.TYPE });

					Integer value22 = new Integer(oldCplModel.getOrgSize());

					method22.invoke(newModel, value22);

					Method method23 = newModelClass.getMethod("setOrgFounded",
							new Class[] { Date.class });

					Date value23 = oldCplModel.getOrgFounded();

					method23.invoke(newModel, value23);

					Method method24 = newModelClass.getMethod("setCreatedBy",
							new Class[] { Long.TYPE });

					Long value24 = new Long(oldCplModel.getCreatedBy());

					method24.invoke(newModel, value24);

					Method method25 = newModelClass.getMethod("setCreatedAt",
							new Class[] { Date.class });

					Date value25 = oldCplModel.getCreatedAt();

					method25.invoke(newModel, value25);

					Method method26 = newModelClass.getMethod("setUpdatedBy",
							new Class[] { Long.TYPE });

					Long value26 = new Long(oldCplModel.getUpdatedBy());

					method26.invoke(newModel, value26);

					Method method27 = newModelClass.getMethod("setUpdatedAt",
							new Class[] { Date.class });

					Date value27 = oldCplModel.getUpdatedAt();

					method27.invoke(newModel, value27);

					Method method28 = newModelClass.getMethod("setFounderList",
							new Class[] { String.class });

					String value28 = oldCplModel.getFounderList();

					method28.invoke(newModel, value28);

					Method method29 = newModelClass.getMethod("setOrgParent",
							new Class[] { Integer.TYPE });

					Integer value29 = new Integer(oldCplModel.getOrgParent());

					method29.invoke(newModel, value29);

					Method method30 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value30 = new Integer(oldCplModel.getRootId());

					method30.invoke(newModel, value30);

					Method method31 = newModelClass.getMethod("setBodId",
							new Class[] { Integer.TYPE });

					Integer value31 = new Integer(oldCplModel.getBodId());

					method31.invoke(newModel, value31);

					Method method32 = newModelClass.getMethod("setBeginTime",
							new Class[] { Date.class });

					Date value32 = oldCplModel.getBeginTime();

					method32.invoke(newModel, value32);

					Method method33 = newModelClass.getMethod("setEndTime",
							new Class[] { Date.class });

					Date value33 = oldCplModel.getEndTime();

					method33.invoke(newModel, value33);

					Method method34 = newModelClass.getMethod("setEmail",
							new Class[] { String.class });

					String value34 = oldCplModel.getEmail();

					method34.invoke(newModel, value34);

					Method method35 = newModelClass.getMethod("setIsProactive",
							new Class[] { Boolean.TYPE });

					Boolean value35 = new Boolean(oldCplModel.getIsProactive());

					method35.invoke(newModel, value35);

					Method method36 = newModelClass.getMethod("setLevelSharing",
							new Class[] { Integer.TYPE });

					Integer value36 = new Integer(oldCplModel.getLevelSharing());

					method36.invoke(newModel, value36);

					Method method37 = newModelClass.getMethod("setIsPrivateProfile",
							new Class[] { Boolean.TYPE });

					Boolean value37 = new Boolean(oldCplModel.getIsPrivateProfile());

					method37.invoke(newModel, value37);

					Method method38 = newModelClass.getMethod("setProfileUrl",
							new Class[] { String.class });

					String value38 = oldCplModel.getProfileUrl();

					method38.invoke(newModel, value38);

					Method method39 = newModelClass.getMethod("setMaxLevel",
							new Class[] { Integer.TYPE });

					Integer value39 = new Integer(oldCplModel.getMaxLevel());

					method39.invoke(newModel, value39);

					Method method40 = newModelClass.getMethod("setLevel",
							new Class[] { Integer.TYPE });

					Integer value40 = new Integer(oldCplModel.getLevel());

					method40.invoke(newModel, value40);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(OrganizationViewClp.class.getName())) {
			OrganizationViewClp oldCplModel = (OrganizationViewClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.OrganizationViewImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setOrgId",
							new Class[] { Integer.TYPE });

					Integer value0 = new Integer(oldCplModel.getOrgId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setOrgName",
							new Class[] { String.class });

					String value1 = oldCplModel.getOrgName();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setCountProduct",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getCountProduct());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setOrgNameLower",
							new Class[] { String.class });

					String value3 = oldCplModel.getOrgNameLower();

					method3.invoke(newModel, value3);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(OrgObjectListClp.class.getName())) {
			OrgObjectListClp oldCplModel = (OrgObjectListClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.OrgObjectListImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setOrgObjectListId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getOrgObjectListId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setOrg_id",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getOrg_id());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value2 = oldCplModel.getName();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value3 = oldCplModel.getDescription();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setCreated_date",
							new Class[] { Date.class });

					Date value4 = oldCplModel.getCreated_date();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setYear",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getYear());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setObjtype",
							new Class[] { Integer.TYPE });

					Integer value6 = new Integer(oldCplModel.getObjtype());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setEntering_percent",
							new Class[] { Double.TYPE });

					Double value7 = new Double(oldCplModel.getEntering_percent());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setCompletion_percent",
							new Class[] { Double.TYPE });

					Double value8 = new Double(oldCplModel.getCompletion_percent());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setIsapproved",
							new Class[] { Boolean.TYPE });

					Boolean value9 = new Boolean(oldCplModel.getIsapproved());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setMonth_hash",
							new Class[] { Integer.TYPE });

					Integer value10 = new Integer(oldCplModel.getMonth_hash());

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setValidweight",
							new Class[] { Boolean.TYPE });

					Boolean value11 = new Boolean(oldCplModel.getValidweight());

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setCurrent_total_cost",
							new Class[] { Double.TYPE });

					Double value12 = new Double(oldCplModel.getCurrent_total_cost());

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setExpected_completion",
							new Class[] { Double.TYPE });

					Double value13 = new Double(oldCplModel.getExpected_completion());

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setNext_total_cost",
							new Class[] { Double.TYPE });

					Double value14 = new Double(oldCplModel.getNext_total_cost());

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setConsistency_ratio",
							new Class[] { Double.TYPE });

					Double value15 = new Double(oldCplModel.getConsistency_ratio());

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setParentid",
							new Class[] { Integer.TYPE });

					Integer value16 = new Integer(oldCplModel.getParentid());

					method16.invoke(newModel, value16);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(OrgObjectApprovalClp.class.getName())) {
			OrgObjectApprovalClp oldCplModel = (OrgObjectApprovalClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.OrgObjectApprovalImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setOrgObjectApprovalId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getOrgObjectApprovalId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setStatus",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getStatus());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setApproved_at",
							new Class[] { Date.class });

					Date value2 = oldCplModel.getApproved_at();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setApproved_by",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getApproved_by());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setReason",
							new Class[] { String.class });

					String value4 = oldCplModel.getReason();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setOrgObjectListId",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getOrgObjectListId());

					method5.invoke(newModel, value5);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(OrgObjectPerspectiveClp.class.getName())) {
			OrgObjectPerspectiveClp oldCplModel = (OrgObjectPerspectiveClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.OrgObjectPerspectiveImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setOrgObjectPerspectiveId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getOrgObjectPerspectiveId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setOrgObjectListId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getOrgObjectListId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value2 = oldCplModel.getName();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value3 = oldCplModel.getDescription();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setWeight_percent",
							new Class[] { Double.TYPE });

					Double value4 = new Double(oldCplModel.getWeight_percent());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setEntering_percent",
							new Class[] { Double.TYPE });

					Double value5 = new Double(oldCplModel.getEntering_percent());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setCompletion_percent",
							new Class[] { Double.TYPE });

					Double value6 = new Double(oldCplModel.getCompletion_percent());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setObjective_count",
							new Class[] { Double.TYPE });

					Double value7 = new Double(oldCplModel.getObjective_count());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setValidweight",
							new Class[] { Boolean.TYPE });

					Boolean value8 = new Boolean(oldCplModel.getValidweight());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setPertype",
							new Class[] { Integer.TYPE });

					Integer value9 = new Integer(oldCplModel.getPertype());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setCurrent_cost",
							new Class[] { Double.TYPE });

					Double value10 = new Double(oldCplModel.getCurrent_cost());

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setNext_cost",
							new Class[] { Double.TYPE });

					Double value11 = new Double(oldCplModel.getNext_cost());

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setNext_cost2",
							new Class[] { Double.TYPE });

					Double value12 = new Double(oldCplModel.getNext_cost2());

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setConsistency_ratio",
							new Class[] { Double.TYPE });

					Double value13 = new Double(oldCplModel.getConsistency_ratio());

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setWeight_percent_suggested",
							new Class[] { Double.TYPE });

					Double value14 = new Double(oldCplModel.getWeight_percent_suggested());

					method14.invoke(newModel, value14);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(OrgObjectObjectiveClp.class.getName())) {
			OrgObjectObjectiveClp oldCplModel = (OrgObjectObjectiveClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.OrgObjectObjectiveImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setOrgObjectObjectiveId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getOrgObjectObjectiveId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setOrgObjectPerspectiveId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getOrgObjectPerspectiveId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value2 = oldCplModel.getName();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value3 = oldCplModel.getDescription();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setCreated_date",
							new Class[] { Date.class });

					Date value4 = oldCplModel.getCreated_date();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setWeight_percent",
							new Class[] { Double.TYPE });

					Double value5 = new Double(oldCplModel.getWeight_percent());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setEntering_percent",
							new Class[] { Double.TYPE });

					Double value6 = new Double(oldCplModel.getEntering_percent());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setCompletion_percent",
							new Class[] { Double.TYPE });

					Double value7 = new Double(oldCplModel.getCompletion_percent());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setMeasure_count",
							new Class[] { Integer.TYPE });

					Integer value8 = new Integer(oldCplModel.getMeasure_count());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setValidweight",
							new Class[] { Boolean.TYPE });

					Boolean value9 = new Boolean(oldCplModel.getValidweight());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setConsistency_ratio",
							new Class[] { Double.TYPE });

					Double value10 = new Double(oldCplModel.getConsistency_ratio());

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setWeight_percent_suggested",
							new Class[] { Double.TYPE });

					Double value11 = new Double(oldCplModel.getWeight_percent_suggested());

					method11.invoke(newModel, value11);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(OrgObjectMeasureClp.class.getName())) {
			OrgObjectMeasureClp oldCplModel = (OrgObjectMeasureClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.OrgObjectMeasureImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setOrgObjectMeasureId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getOrgObjectMeasureId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setOrgObjectObjectiveId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getOrgObjectObjectiveId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value2 = oldCplModel.getName();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value3 = oldCplModel.getDescription();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setCreated_date",
							new Class[] { Date.class });

					Date value4 = oldCplModel.getCreated_date();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setWeight_percent",
							new Class[] { Double.TYPE });

					Double value5 = new Double(oldCplModel.getWeight_percent());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setIsassessed",
							new Class[] { Boolean.TYPE });

					Boolean value6 = new Boolean(oldCplModel.getIsassessed());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setResult",
							new Class[] { Double.TYPE });

					Double value7 = new Double(oldCplModel.getResult());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setEntering_percent",
							new Class[] { Double.TYPE });

					Double value8 = new Double(oldCplModel.getEntering_percent());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setCompletion_percent",
							new Class[] { Double.TYPE });

					Double value9 = new Double(oldCplModel.getCompletion_percent());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setFormula",
							new Class[] { String.class });

					String value10 = oldCplModel.getFormula();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setTarget_count",
							new Class[] { Integer.TYPE });

					Integer value11 = new Integer(oldCplModel.getTarget_count());

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setInterpretation",
							new Class[] { String.class });

					String value12 = oldCplModel.getInterpretation();

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setWeight_percent_suggested",
							new Class[] { Double.TYPE });

					Double value13 = new Double(oldCplModel.getWeight_percent_suggested());

					method13.invoke(newModel, value13);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(OrgObjectTargetsClp.class.getName())) {
			OrgObjectTargetsClp oldCplModel = (OrgObjectTargetsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.OrgObjectTargetsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setOrgObjectTargetId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getOrgObjectTargetId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setOrgObjectMeasureId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getOrgObjectMeasureId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value2 = oldCplModel.getName();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value3 = oldCplModel.getDescription();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setCreated_date",
							new Class[] { Date.class });

					Date value4 = oldCplModel.getCreated_date();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setValue",
							new Class[] { Double.TYPE });

					Double value5 = new Double(oldCplModel.getValue());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setMinMax",
							new Class[] { Boolean.TYPE });

					Boolean value6 = new Boolean(oldCplModel.getMinMax());

					method6.invoke(newModel, value6);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ProgatePortalMenuClp.class.getName())) {
			ProgatePortalMenuClp oldCplModel = (ProgatePortalMenuClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.ProgatePortalMenuImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setPortalMenuId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getPortalMenuId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value1 = oldCplModel.getName();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setLayoutId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getLayoutId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setRoleId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getRoleId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setOrgId",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getOrgId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setMenuOrder",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getMenuOrder());

					method5.invoke(newModel, value5);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ProGateRolesClp.class.getName())) {
			ProGateRolesClp oldCplModel = (ProGateRolesClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.ProGateRolesImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setRoleId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getRoleId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value1 = oldCplModel.getName();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value2 = oldCplModel.getDescription();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setRoleType",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getRoleType());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setPriority",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getPriority());

					method4.invoke(newModel, value4);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ProGateOrgTypeClp.class.getName())) {
			ProGateOrgTypeClp oldCplModel = (ProGateOrgTypeClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.ProGateOrgTypeImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setOrgTypeId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getOrgTypeId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value1 = oldCplModel.getName();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value2 = oldCplModel.getDescription();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setStatus",
							new Class[] { Boolean.TYPE });

					Boolean value3 = new Boolean(oldCplModel.getStatus());

					method3.invoke(newModel, value3);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ProGateJournalArticleClp.class.getName())) {
			ProGateJournalArticleClp oldCplModel = (ProGateJournalArticleClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.ProGateJournalArticleImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setJournalArticleId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getJournalArticleId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setOrgId",
							new Class[] { String.class });

					String value1 = oldCplModel.getOrgId();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setArticleType",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getArticleType());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setTitle",
							new Class[] { String.class });

					String value3 = oldCplModel.getTitle();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setResourceUrl",
							new Class[] { String.class });

					String value4 = oldCplModel.getResourceUrl();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value5 = oldCplModel.getDescription();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setContent",
							new Class[] { String.class });

					String value6 = oldCplModel.getContent();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setPriority",
							new Class[] { Integer.TYPE });

					Integer value7 = new Integer(oldCplModel.getPriority());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setSmallImageUrl",
							new Class[] { String.class });

					String value8 = oldCplModel.getSmallImageUrl();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setBigImageUrl",
							new Class[] { String.class });

					String value9 = oldCplModel.getBigImageUrl();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setCreatedBy",
							new Class[] { Integer.TYPE });

					Integer value10 = new Integer(oldCplModel.getCreatedBy());

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setCreatedAt",
							new Class[] { Date.class });

					Date value11 = oldCplModel.getCreatedAt();

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setUpdatedBy",
							new Class[] { Integer.TYPE });

					Integer value12 = new Integer(oldCplModel.getUpdatedBy());

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setUpdatedAt",
							new Class[] { Date.class });

					Date value13 = oldCplModel.getUpdatedAt();

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setAddInfo",
							new Class[] { String.class });

					String value14 = oldCplModel.getAddInfo();

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setArticleOrder",
							new Class[] { Integer.TYPE });

					Integer value15 = new Integer(oldCplModel.getArticleOrder());

					method15.invoke(newModel, value15);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ProGateProductsServicesClp.class.getName())) {
			ProGateProductsServicesClp oldCplModel = (ProGateProductsServicesClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.ProGateProductsServicesImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setProductsServicesId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getProductsServicesId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setArticleId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getArticleId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setOrgId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getOrgId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setDiscount",
							new Class[] { Double.TYPE });

					Double value3 = new Double(oldCplModel.getDiscount());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setPrice",
							new Class[] { Double.TYPE });

					Double value4 = new Double(oldCplModel.getPrice());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setCurrencyId",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getCurrencyId());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setProductType",
							new Class[] { Integer.TYPE });

					Integer value6 = new Integer(oldCplModel.getProductType());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setIsHot",
							new Class[] { Boolean.TYPE });

					Boolean value7 = new Boolean(oldCplModel.getIsHot());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setIsService",
							new Class[] { Boolean.TYPE });

					Boolean value8 = new Boolean(oldCplModel.getIsService());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setProgateCategory",
							new Class[] { Integer.TYPE });

					Integer value9 = new Integer(oldCplModel.getProgateCategory());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setExpiredDate",
							new Class[] { Date.class });

					Date value10 = oldCplModel.getExpiredDate();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setAmount",
							new Class[] { Integer.TYPE });

					Integer value11 = new Integer(oldCplModel.getAmount());

					method11.invoke(newModel, value11);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ProGateCurrencyTypesClp.class.getName())) {
			ProGateCurrencyTypesClp oldCplModel = (ProGateCurrencyTypesClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.ProGateCurrencyTypesImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setCurrencyId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getCurrencyId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setCode",
							new Class[] { String.class });

					String value1 = oldCplModel.getCode();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value2 = oldCplModel.getDescription();

					method2.invoke(newModel, value2);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					ProGateJournalArticlePrioritiesClp.class.getName())) {
			ProGateJournalArticlePrioritiesClp oldCplModel = (ProGateJournalArticlePrioritiesClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.ProGateJournalArticlePrioritiesImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setJournalArticlePrioritiesId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getJournalArticlePrioritiesId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value1 = oldCplModel.getName();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value2 = oldCplModel.getDescription();

					method2.invoke(newModel, value2);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					ProGateJournalArticleTypesClp.class.getName())) {
			ProGateJournalArticleTypesClp oldCplModel = (ProGateJournalArticleTypesClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.ProGateJournalArticleTypesImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setJournalArticleTypesId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getJournalArticleTypesId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value1 = oldCplModel.getName();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value2 = oldCplModel.getDescription();

					method2.invoke(newModel, value2);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(RegionClp.class.getName())) {
			RegionClp oldCplModel = (RegionClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.RegionImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setRegionId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getRegionId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value1 = oldCplModel.getName();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRegionCode",
							new Class[] { String.class });

					String value2 = oldCplModel.getRegionCode();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setCountryId",
							new Class[] { String.class });

					String value3 = oldCplModel.getCountryId();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setActive",
							new Class[] { Boolean.TYPE });

					Boolean value4 = new Boolean(oldCplModel.getActive());

					method4.invoke(newModel, value4);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(CountryClp.class.getName())) {
			CountryClp oldCplModel = (CountryClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.CountryImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setCountryId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getCountryId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value1 = oldCplModel.getName();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setActive",
							new Class[] { Boolean.TYPE });

					Boolean value2 = new Boolean(oldCplModel.getActive());

					method2.invoke(newModel, value2);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					ProGateJournalArticleViewClp.class.getName())) {
			ProGateJournalArticleViewClp oldCplModel = (ProGateJournalArticleViewClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.ProGateJournalArticleViewImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setJournalArticleId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getJournalArticleId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setOrgId",
							new Class[] { String.class });

					String value1 = oldCplModel.getOrgId();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setOrgName",
							new Class[] { String.class });

					String value2 = oldCplModel.getOrgName();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setArticleType",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getArticleType());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setTitle",
							new Class[] { String.class });

					String value4 = oldCplModel.getTitle();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setResourceUrl",
							new Class[] { String.class });

					String value5 = oldCplModel.getResourceUrl();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value6 = oldCplModel.getDescription();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setContent",
							new Class[] { String.class });

					String value7 = oldCplModel.getContent();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setPriority",
							new Class[] { Integer.TYPE });

					Integer value8 = new Integer(oldCplModel.getPriority());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setSmallImageUrl",
							new Class[] { String.class });

					String value9 = oldCplModel.getSmallImageUrl();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setBigImageUrl",
							new Class[] { String.class });

					String value10 = oldCplModel.getBigImageUrl();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setCreatedBy",
							new Class[] { Integer.TYPE });

					Integer value11 = new Integer(oldCplModel.getCreatedBy());

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setCreatedAt",
							new Class[] { Date.class });

					Date value12 = oldCplModel.getCreatedAt();

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setUpdatedBy",
							new Class[] { Integer.TYPE });

					Integer value13 = new Integer(oldCplModel.getUpdatedBy());

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setUpdatedAt",
							new Class[] { Date.class });

					Date value14 = oldCplModel.getUpdatedAt();

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setDiscount",
							new Class[] { Double.TYPE });

					Double value15 = new Double(oldCplModel.getDiscount());

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setPrice",
							new Class[] { Double.TYPE });

					Double value16 = new Double(oldCplModel.getPrice());

					method16.invoke(newModel, value16);

					Method method17 = newModelClass.getMethod("setCurrencyId",
							new Class[] { Integer.TYPE });

					Integer value17 = new Integer(oldCplModel.getCurrencyId());

					method17.invoke(newModel, value17);

					Method method18 = newModelClass.getMethod("setProductType",
							new Class[] { Integer.TYPE });

					Integer value18 = new Integer(oldCplModel.getProductType());

					method18.invoke(newModel, value18);

					Method method19 = newModelClass.getMethod("setIsHot",
							new Class[] { Boolean.TYPE });

					Boolean value19 = new Boolean(oldCplModel.getIsHot());

					method19.invoke(newModel, value19);

					Method method20 = newModelClass.getMethod("setIsService",
							new Class[] { Boolean.TYPE });

					Boolean value20 = new Boolean(oldCplModel.getIsService());

					method20.invoke(newModel, value20);

					Method method21 = newModelClass.getMethod("setExpiredDate",
							new Class[] { Date.class });

					Date value21 = oldCplModel.getExpiredDate();

					method21.invoke(newModel, value21);

					Method method22 = newModelClass.getMethod("setAmount",
							new Class[] { Integer.TYPE });

					Integer value22 = new Integer(oldCplModel.getAmount());

					method22.invoke(newModel, value22);

					Method method23 = newModelClass.getMethod("setCurrencyCode",
							new Class[] { String.class });

					String value23 = oldCplModel.getCurrencyCode();

					method23.invoke(newModel, value23);

					Method method24 = newModelClass.getMethod("setJournalArticleTypesName",
							new Class[] { String.class });

					String value24 = oldCplModel.getJournalArticleTypesName();

					method24.invoke(newModel, value24);

					Method method25 = newModelClass.getMethod("setProgateCategory",
							new Class[] { Integer.TYPE });

					Integer value25 = new Integer(oldCplModel.getProgateCategory());

					method25.invoke(newModel, value25);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					ProGateJournalArticleSlideShowClp.class.getName())) {
			ProGateJournalArticleSlideShowClp oldCplModel = (ProGateJournalArticleSlideShowClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.ProGateJournalArticleSlideShowImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setJournalArticleSlideShowId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getJournalArticleSlideShowId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setOrgId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getOrgId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setProductId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getProductId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setImageUrl",
							new Class[] { String.class });

					String value3 = oldCplModel.getImageUrl();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setTitle",
							new Class[] { String.class });

					String value4 = oldCplModel.getTitle();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setTitleUrl",
							new Class[] { String.class });

					String value5 = oldCplModel.getTitleUrl();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setSlideIndex",
							new Class[] { Integer.TYPE });

					Integer value6 = new Integer(oldCplModel.getSlideIndex());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setIsService",
							new Class[] { Boolean.TYPE });

					Boolean value7 = new Boolean(oldCplModel.getIsService());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setCreatedBy",
							new Class[] { Integer.TYPE });

					Integer value8 = new Integer(oldCplModel.getCreatedBy());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setCreatedAt",
							new Class[] { Date.class });

					Date value9 = oldCplModel.getCreatedAt();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setUpdatedBy",
							new Class[] { Integer.TYPE });

					Integer value10 = new Integer(oldCplModel.getUpdatedBy());

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setUpdatedAt",
							new Class[] { Date.class });

					Date value11 = oldCplModel.getUpdatedAt();

					method11.invoke(newModel, value11);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ProGateOrgCustomerClp.class.getName())) {
			ProGateOrgCustomerClp oldCplModel = (ProGateOrgCustomerClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.ProGateOrgCustomerImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setProGateOrgCustomerId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getProGateOrgCustomerId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setCustomerType",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getCustomerType());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setCustomerName",
							new Class[] { String.class });

					String value2 = oldCplModel.getCustomerName();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setOrgId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getOrgId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setHasOrgMap",
							new Class[] { Boolean.TYPE });

					Boolean value4 = new Boolean(oldCplModel.getHasOrgMap());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setUrlOrgMap",
							new Class[] { String.class });

					String value5 = oldCplModel.getUrlOrgMap();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setLogo",
							new Class[] { String.class });

					String value6 = oldCplModel.getLogo();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setWebsite",
							new Class[] { String.class });

					String value7 = oldCplModel.getWebsite();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value8 = oldCplModel.getDescription();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setCreatedDate",
							new Class[] { Date.class });

					Date value9 = oldCplModel.getCreatedDate();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setModifiedDate",
							new Class[] { Date.class });

					Date value10 = oldCplModel.getModifiedDate();

					method10.invoke(newModel, value10);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					ProGateOrgCustomerRepresenterClp.class.getName())) {
			ProGateOrgCustomerRepresenterClp oldCplModel = (ProGateOrgCustomerRepresenterClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.ProGateOrgCustomerRepresenterImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setProGateOrgCustomerRepresenterId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getProGateOrgCustomerRepresenterId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setFirstName",
							new Class[] { String.class });

					String value1 = oldCplModel.getFirstName();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setLastName",
							new Class[] { String.class });

					String value2 = oldCplModel.getLastName();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setDisplayName",
							new Class[] { String.class });

					String value3 = oldCplModel.getDisplayName();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setRole",
							new Class[] { String.class });

					String value4 = oldCplModel.getRole();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setCustomerId",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getCustomerId());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setOrgId",
							new Class[] { Integer.TYPE });

					Integer value6 = new Integer(oldCplModel.getOrgId());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value7 = oldCplModel.getDescription();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setCreatedDate",
							new Class[] { Date.class });

					Date value8 = oldCplModel.getCreatedDate();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setModifiedDate",
							new Class[] { Date.class });

					Date value9 = oldCplModel.getModifiedDate();

					method9.invoke(newModel, value9);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ProGateApplicationsClp.class.getName())) {
			ProGateApplicationsClp oldCplModel = (ProGateApplicationsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.ProGateApplicationsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setProGateApplicationsId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getProGateApplicationsId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setLayoutId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getLayoutId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value2 = oldCplModel.getName();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setTitle",
							new Class[] { String.class });

					String value3 = oldCplModel.getTitle();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value4 = oldCplModel.getDescription();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setIsHidden",
							new Class[] { Boolean.TYPE });

					Boolean value5 = new Boolean(oldCplModel.getIsHidden());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setFriendlyUrl",
							new Class[] { String.class });

					String value6 = oldCplModel.getFriendlyUrl();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setImageUrl",
							new Class[] { String.class });

					String value7 = oldCplModel.getImageUrl();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setIconUrl",
							new Class[] { String.class });

					String value8 = oldCplModel.getIconUrl();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setCreatedDate",
							new Class[] { Date.class });

					Date value9 = oldCplModel.getCreatedDate();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setModifiedDate",
							new Class[] { Date.class });

					Date value10 = oldCplModel.getModifiedDate();

					method10.invoke(newModel, value10);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ProGateUserApplicationsClp.class.getName())) {
			ProGateUserApplicationsClp oldCplModel = (ProGateUserApplicationsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.ProGateUserApplicationsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setProGateUserApplicationsId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getProGateUserApplicationsId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getUserId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setAppsId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getAppsId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setOrgId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getOrgId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setPosition",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getPosition());

					method4.invoke(newModel, value4);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					ProgateOrganizationParticipantsClp.class.getName())) {
			ProgateOrganizationParticipantsClp oldCplModel = (ProgateOrganizationParticipantsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.ProgateOrganizationParticipantsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setProgateOrganizationParticipantsId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getProgateOrganizationParticipantsId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getUserId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setOrgId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getOrgId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setRoleId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getRoleId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getRootId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setBodId",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getBodId());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setRequestedBy",
							new Class[] { Integer.TYPE });

					Integer value6 = new Integer(oldCplModel.getRequestedBy());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setRequestedAt",
							new Class[] { Date.class });

					Date value7 = oldCplModel.getRequestedAt();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setRequestedReason",
							new Class[] { String.class });

					String value8 = oldCplModel.getRequestedReason();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setApprovedBy",
							new Class[] { Integer.TYPE });

					Integer value9 = new Integer(oldCplModel.getApprovedBy());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setApprovedAt",
							new Class[] { Date.class });

					Date value10 = oldCplModel.getApprovedAt();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setApprovedReason",
							new Class[] { String.class });

					String value11 = oldCplModel.getApprovedReason();

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setStatus",
							new Class[] { Integer.TYPE });

					Integer value12 = new Integer(oldCplModel.getStatus());

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setIsCurrent",
							new Class[] { Boolean.TYPE });

					Boolean value13 = new Boolean(oldCplModel.getIsCurrent());

					method13.invoke(newModel, value13);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					ProgateOrganizationsStaffsClp.class.getName())) {
			ProgateOrganizationsStaffsClp oldCplModel = (ProgateOrganizationsStaffsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.ProgateOrganizationsStaffsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setProgateOrganizationsStaffsId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getProgateOrganizationsStaffsId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getUserId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setOrgId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getOrgId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getRootId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setBodId",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getBodId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setParticipantId",
							new Class[] { Integer.TYPE });

					Integer value5 = new Integer(oldCplModel.getParticipantId());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setPosition",
							new Class[] { String.class });

					String value6 = oldCplModel.getPosition();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setAvailability",
							new Class[] { Double.TYPE });

					Double value7 = new Double(oldCplModel.getAvailability());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setBeginTime",
							new Class[] { Date.class });

					Date value8 = oldCplModel.getBeginTime();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setEndTime",
							new Class[] { Date.class });

					Date value9 = oldCplModel.getEndTime();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setIsActive",
							new Class[] { Boolean.TYPE });

					Boolean value10 = new Boolean(oldCplModel.getIsActive());

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setIsRemoved",
							new Class[] { Boolean.TYPE });

					Boolean value11 = new Boolean(oldCplModel.getIsRemoved());

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setStaffCode",
							new Class[] { String.class });

					String value12 = oldCplModel.getStaffCode();

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setScannerCode",
							new Class[] { String.class });

					String value13 = oldCplModel.getScannerCode();

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setCreatedAt",
							new Class[] { Date.class });

					Date value14 = oldCplModel.getCreatedAt();

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setUpdatedAt",
							new Class[] { Date.class });

					Date value15 = oldCplModel.getUpdatedAt();

					method15.invoke(newModel, value15);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					ProgateApplicationsSettingClp.class.getName())) {
			ProgateApplicationsSettingClp oldCplModel = (ProgateApplicationsSettingClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.ProgateApplicationsSettingImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setProgateApplicationsSettingId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getProgateApplicationsSettingId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setAppId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getAppId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRoleId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRoleId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setDefaultPosition",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getDefaultPosition());

					method3.invoke(newModel, value3);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ProgateMenusClp.class.getName())) {
			ProgateMenusClp oldCplModel = (ProgateMenusClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.ProgateMenusImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setProgateMenusId",
							new Class[] { Integer.TYPE });

					Integer value0 = new Integer(oldCplModel.getProgateMenusId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value1 = oldCplModel.getName();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setLayoutId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getLayoutId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setNumberOrder",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getNumberOrder());

					method3.invoke(newModel, value3);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ProgateLayoutsRolesClp.class.getName())) {
			ProgateLayoutsRolesClp oldCplModel = (ProgateLayoutsRolesClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.ProgateLayoutsRolesImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setProgateLayoutsRolesId",
							new Class[] { Integer.TYPE });

					Integer value0 = new Integer(oldCplModel.getProgateLayoutsRolesId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setLayoutId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getLayoutId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setMinRolePriority",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getMinRolePriority());

					method2.invoke(newModel, value2);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ProgateLayoutsMenusClp.class.getName())) {
			ProgateLayoutsMenusClp oldCplModel = (ProgateLayoutsMenusClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.ProgateLayoutsMenusImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setProgateLayoutsMenusId",
							new Class[] { Integer.TYPE });

					Integer value0 = new Integer(oldCplModel.getProgateLayoutsMenusId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setLayoutId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getLayoutId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setMenuName",
							new Class[] { String.class });

					String value2 = oldCplModel.getMenuName();

					method2.invoke(newModel, value2);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ProGateMenuViewClp.class.getName())) {
			ProGateMenuViewClp oldCplModel = (ProGateMenuViewClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.ProGateMenuViewImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value0 = oldCplModel.getName();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setMenus",
							new Class[] { String.class });

					String value1 = oldCplModel.getMenus();

					method1.invoke(newModel, value1);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					ProGateOrgsUsersPermissionsClp.class.getName())) {
			ProGateOrgsUsersPermissionsClp oldCplModel = (ProGateOrgsUsersPermissionsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.ProGateOrgsUsersPermissionsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setProGateOrgsUsersPermissionsId",
							new Class[] { Integer.class });

					Integer value0 = oldCplModel.getProGateOrgsUsersPermissionsId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setOrgId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getOrgId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getUserId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setPermissionId",
							new Class[] { String.class });

					String value3 = oldCplModel.getPermissionId();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setValue",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getValue());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setIsGrant",
							new Class[] { Boolean.TYPE });

					Boolean value5 = new Boolean(oldCplModel.getIsGrant());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setPmId",
							new Class[] { Integer.TYPE });

					Integer value6 = new Integer(oldCplModel.getPmId());

					method6.invoke(newModel, value6);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ProGatePermissionsClp.class.getName())) {
			ProGatePermissionsClp oldCplModel = (ProGatePermissionsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.ProGatePermissionsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setProGatePermissionsId",
							new Class[] { String.class });

					String value0 = oldCplModel.getProGatePermissionsId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setApplicationId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getApplicationId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setCategory",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getCategory());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value3 = oldCplModel.getDescription();

					method3.invoke(newModel, value3);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ViewOrgUsersPermissionsClp.class.getName())) {
			ViewOrgUsersPermissionsClp oldCplModel = (ViewOrgUsersPermissionsClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.ViewOrgUsersPermissionsImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setId",
							new Class[] { String.class });

					String value0 = oldCplModel.getId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setOrgId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getOrgId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setRootId",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getRootId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setUserId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getUserId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setRoleId",
							new Class[] { Integer.TYPE });

					Integer value4 = new Integer(oldCplModel.getRoleId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setPermissionId",
							new Class[] { String.class });

					String value5 = oldCplModel.getPermissionId();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setApplicationId",
							new Class[] { Integer.TYPE });

					Integer value6 = new Integer(oldCplModel.getApplicationId());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setCategory",
							new Class[] { Integer.TYPE });

					Integer value7 = new Integer(oldCplModel.getCategory());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value8 = oldCplModel.getDescription();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setValue",
							new Class[] { Integer.TYPE });

					Integer value9 = new Integer(oldCplModel.getValue());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setPriority",
							new Class[] { Integer.TYPE });

					Integer value10 = new Integer(oldCplModel.getPriority());

					method10.invoke(newModel, value10);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					ViewProGatePermissionsRolesClp.class.getName())) {
			ViewProGatePermissionsRolesClp oldCplModel = (ViewProGatePermissionsRolesClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("larion.progate.model.impl.ViewProGatePermissionsRolesImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setProGatePermissionsRolesId",
							new Class[] { String.class });

					String value0 = oldCplModel.getProGatePermissionsRolesId();

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setApplicationId",
							new Class[] { Integer.TYPE });

					Integer value1 = new Integer(oldCplModel.getApplicationId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setCategory",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getCategory());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setRoleId",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getRoleId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setPerId",
							new Class[] { String.class });

					String value4 = oldCplModel.getPerId();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value5 = oldCplModel.getDescription();

					method5.invoke(newModel, value5);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel) {
			return translateInput((BaseModel)obj);
		}
		else if (obj instanceof List) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals("larion.progate.model.impl.UserImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					UserClp newModel = new UserClp();

					Method method0 = oldModelClass.getMethod("getUserid");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setUserid(value0);

					Method method1 = oldModelClass.getMethod("getUuid_");

					String value1 = (String)method1.invoke(oldModel,
							(Object[])null);

					newModel.setUuid_(value1);

					Method method2 = oldModelClass.getMethod("getCompanyid");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setCompanyid(value2.intValue());

					Method method3 = oldModelClass.getMethod("getCreatedate");

					Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

					newModel.setCreatedate(value3);

					Method method4 = oldModelClass.getMethod("getModifieddate");

					Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

					newModel.setModifieddate(value4);

					Method method5 = oldModelClass.getMethod("getDefaultuser");

					Boolean value5 = (Boolean)method5.invoke(oldModel,
							(Object[])null);

					newModel.setDefaultuser(value5.booleanValue());

					Method method6 = oldModelClass.getMethod("getContactid");

					Integer value6 = (Integer)method6.invoke(oldModel,
							(Object[])null);

					newModel.setContactid(value6.intValue());

					Method method7 = oldModelClass.getMethod("getPassword_");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setPassword_(value7);

					Method method8 = oldModelClass.getMethod(
							"getPasswordencrypted");

					Boolean value8 = (Boolean)method8.invoke(oldModel,
							(Object[])null);

					newModel.setPasswordencrypted(value8.booleanValue());

					Method method9 = oldModelClass.getMethod("getPasswordreset");

					Boolean value9 = (Boolean)method9.invoke(oldModel,
							(Object[])null);

					newModel.setPasswordreset(value9.booleanValue());

					Method method10 = oldModelClass.getMethod(
							"getPasswordmodifieddate");

					Date value10 = (Date)method10.invoke(oldModel,
							(Object[])null);

					newModel.setPasswordmodifieddate(value10);

					Method method11 = oldModelClass.getMethod(
							"getReminderqueryquestion");

					String value11 = (String)method11.invoke(oldModel,
							(Object[])null);

					newModel.setReminderqueryquestion(value11);

					Method method12 = oldModelClass.getMethod(
							"getReminderqueryanswer");

					String value12 = (String)method12.invoke(oldModel,
							(Object[])null);

					newModel.setReminderqueryanswer(value12);

					Method method13 = oldModelClass.getMethod(
							"getGracelogincount");

					Integer value13 = (Integer)method13.invoke(oldModel,
							(Object[])null);

					newModel.setGracelogincount(value13.intValue());

					Method method14 = oldModelClass.getMethod("getScreenname");

					String value14 = (String)method14.invoke(oldModel,
							(Object[])null);

					newModel.setScreenname(value14);

					Method method15 = oldModelClass.getMethod("getEmailaddress");

					String value15 = (String)method15.invoke(oldModel,
							(Object[])null);

					newModel.setEmailaddress(value15);

					Method method16 = oldModelClass.getMethod("getOpenid");

					String value16 = (String)method16.invoke(oldModel,
							(Object[])null);

					newModel.setOpenid(value16);

					Method method17 = oldModelClass.getMethod("getLanguageid");

					String value17 = (String)method17.invoke(oldModel,
							(Object[])null);

					newModel.setLanguageid(value17);

					Method method18 = oldModelClass.getMethod("getTimezoneid");

					String value18 = (String)method18.invoke(oldModel,
							(Object[])null);

					newModel.setTimezoneid(value18);

					Method method19 = oldModelClass.getMethod("getGreeting");

					String value19 = (String)method19.invoke(oldModel,
							(Object[])null);

					newModel.setGreeting(value19);

					Method method20 = oldModelClass.getMethod("getComments");

					String value20 = (String)method20.invoke(oldModel,
							(Object[])null);

					newModel.setComments(value20);

					Method method21 = oldModelClass.getMethod("getFirstname");

					String value21 = (String)method21.invoke(oldModel,
							(Object[])null);

					newModel.setFirstname(value21);

					Method method22 = oldModelClass.getMethod("getMiddlename");

					String value22 = (String)method22.invoke(oldModel,
							(Object[])null);

					newModel.setMiddlename(value22);

					Method method23 = oldModelClass.getMethod("getLastname");

					String value23 = (String)method23.invoke(oldModel,
							(Object[])null);

					newModel.setLastname(value23);

					Method method24 = oldModelClass.getMethod("getJobtitle");

					String value24 = (String)method24.invoke(oldModel,
							(Object[])null);

					newModel.setJobtitle(value24);

					Method method25 = oldModelClass.getMethod("getLogindate");

					Date value25 = (Date)method25.invoke(oldModel,
							(Object[])null);

					newModel.setLogindate(value25);

					Method method26 = oldModelClass.getMethod("getLoginip");

					String value26 = (String)method26.invoke(oldModel,
							(Object[])null);

					newModel.setLoginip(value26);

					Method method27 = oldModelClass.getMethod(
							"getLastlogindate");

					Date value27 = (Date)method27.invoke(oldModel,
							(Object[])null);

					newModel.setLastlogindate(value27);

					Method method28 = oldModelClass.getMethod("getLastloginip");

					String value28 = (String)method28.invoke(oldModel,
							(Object[])null);

					newModel.setLastloginip(value28);

					Method method29 = oldModelClass.getMethod(
							"getLastfailedlogindate");

					Date value29 = (Date)method29.invoke(oldModel,
							(Object[])null);

					newModel.setLastfailedlogindate(value29);

					Method method30 = oldModelClass.getMethod(
							"getFailedloginattempts");

					Integer value30 = (Integer)method30.invoke(oldModel,
							(Object[])null);

					newModel.setFailedloginattempts(value30.intValue());

					Method method31 = oldModelClass.getMethod("getLockout");

					Boolean value31 = (Boolean)method31.invoke(oldModel,
							(Object[])null);

					newModel.setLockout(value31.booleanValue());

					Method method32 = oldModelClass.getMethod("getLockoutdate");

					Date value32 = (Date)method32.invoke(oldModel,
							(Object[])null);

					newModel.setLockoutdate(value32);

					Method method33 = oldModelClass.getMethod(
							"getAgreedtotermsofuse");

					Boolean value33 = (Boolean)method33.invoke(oldModel,
							(Object[])null);

					newModel.setAgreedtotermsofuse(value33.booleanValue());

					Method method34 = oldModelClass.getMethod("getActive");

					Boolean value34 = (Boolean)method34.invoke(oldModel,
							(Object[])null);

					newModel.setActive(value34.booleanValue());

					Method method35 = oldModelClass.getMethod("getIsProActive");

					Boolean value35 = (Boolean)method35.invoke(oldModel,
							(Object[])null);

					newModel.setIsProActive(value35.booleanValue());

					Method method36 = oldModelClass.getMethod("getStatus");

					Boolean value36 = (Boolean)method36.invoke(oldModel,
							(Object[])null);

					newModel.setStatus(value36.booleanValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.UserInformationViewImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					UserInformationViewClp newModel = new UserInformationViewClp();

					Method method0 = oldModelClass.getMethod(
							"getUserInformationViewId");

					String value0 = (String)method0.invoke(oldModel,
							(Object[])null);

					newModel.setUserInformationViewId(value0);

					Method method1 = oldModelClass.getMethod("getUserId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getScreenName");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setScreenName(value2);

					Method method3 = oldModelClass.getMethod("getEmailAddress");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setEmailAddress(value3);

					Method method4 = oldModelClass.getMethod("getFirstName");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setFirstName(value4);

					Method method5 = oldModelClass.getMethod("getLastName");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setLastName(value5);

					Method method6 = oldModelClass.getMethod("getLastLoginDate");

					Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

					newModel.setLastLoginDate(value6);

					Method method7 = oldModelClass.getMethod("getCreateDate");

					Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

					newModel.setCreateDate(value7);

					Method method8 = oldModelClass.getMethod("getModifiedDate");

					Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

					newModel.setModifiedDate(value8);

					Method method9 = oldModelClass.getMethod("getStatus");

					Integer value9 = (Integer)method9.invoke(oldModel,
							(Object[])null);

					newModel.setStatus(value9.intValue());

					Method method10 = oldModelClass.getMethod("getIsProActive");

					Integer value10 = (Integer)method10.invoke(oldModel,
							(Object[])null);

					newModel.setIsProActive(value10.intValue());

					Method method11 = oldModelClass.getMethod("getOrgId");

					Integer value11 = (Integer)method11.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value11.intValue());

					Method method12 = oldModelClass.getMethod("getOrgName");

					String value12 = (String)method12.invoke(oldModel,
							(Object[])null);

					newModel.setOrgName(value12);

					Method method13 = oldModelClass.getMethod("getParentId");

					Integer value13 = (Integer)method13.invoke(oldModel,
							(Object[])null);

					newModel.setParentId(value13.intValue());

					Method method14 = oldModelClass.getMethod("getJoiningDesc");

					String value14 = (String)method14.invoke(oldModel,
							(Object[])null);

					newModel.setJoiningDesc(value14);

					Method method15 = oldModelClass.getMethod(
							"getJoiningStatus");

					Integer value15 = (Integer)method15.invoke(oldModel,
							(Object[])null);

					newModel.setJoiningStatus(value15.intValue());

					Method method16 = oldModelClass.getMethod("getRequestAt");

					Date value16 = (Date)method16.invoke(oldModel,
							(Object[])null);

					newModel.setRequestAt(value16);

					Method method17 = oldModelClass.getMethod("getApprovedAt");

					Date value17 = (Date)method17.invoke(oldModel,
							(Object[])null);

					newModel.setApprovedAt(value17);

					Method method18 = oldModelClass.getMethod("getRoleId");

					Integer value18 = (Integer)method18.invoke(oldModel,
							(Object[])null);

					newModel.setRoleId(value18.intValue());

					Method method19 = oldModelClass.getMethod("getRolename");

					String value19 = (String)method19.invoke(oldModel,
							(Object[])null);

					newModel.setRolename(value19);

					Method method20 = oldModelClass.getMethod("getRolePriority");

					Integer value20 = (Integer)method20.invoke(oldModel,
							(Object[])null);

					newModel.setRolePriority(value20.intValue());

					Method method21 = oldModelClass.getMethod("getIsCurrent");

					Boolean value21 = (Boolean)method21.invoke(oldModel,
							(Object[])null);

					newModel.setIsCurrent(value21.booleanValue());

					Method method22 = oldModelClass.getMethod(
							"getSearchInformation");

					String value22 = (String)method22.invoke(oldModel,
							(Object[])null);

					newModel.setSearchInformation(value22);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.OrganizationImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					OrganizationClp newModel = new OrganizationClp();

					Method method0 = oldModelClass.getMethod("getOrgId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value0);

					Method method1 = oldModelClass.getMethod("getName");

					String value1 = (String)method1.invoke(oldModel,
							(Object[])null);

					newModel.setName(value1);

					Method method2 = oldModelClass.getMethod("getAbbreviation");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setAbbreviation(value2);

					Method method3 = oldModelClass.getMethod("getDescription");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value3);

					Method method4 = oldModelClass.getMethod("getMaxUserCount");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setMaxUserCount(value4.intValue());

					Method method5 = oldModelClass.getMethod("getExpiredDate");

					Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

					newModel.setExpiredDate(value5);

					Method method6 = oldModelClass.getMethod("getAddress1");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setAddress1(value6);

					Method method7 = oldModelClass.getMethod("getAddress2");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setAddress2(value7);

					Method method8 = oldModelClass.getMethod("getCity");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setCity(value8);

					Method method9 = oldModelClass.getMethod("getState");

					String value9 = (String)method9.invoke(oldModel,
							(Object[])null);

					newModel.setState(value9);

					Method method10 = oldModelClass.getMethod("getStateId");

					Integer value10 = (Integer)method10.invoke(oldModel,
							(Object[])null);

					newModel.setStateId(value10.intValue());

					Method method11 = oldModelClass.getMethod("getCountry");

					String value11 = (String)method11.invoke(oldModel,
							(Object[])null);

					newModel.setCountry(value11);

					Method method12 = oldModelClass.getMethod("getPhone");

					String value12 = (String)method12.invoke(oldModel,
							(Object[])null);

					newModel.setPhone(value12);

					Method method13 = oldModelClass.getMethod("getOrgType");

					String value13 = (String)method13.invoke(oldModel,
							(Object[])null);

					newModel.setOrgType(value13);

					Method method14 = oldModelClass.getMethod("getOrgTypeId");

					Integer value14 = (Integer)method14.invoke(oldModel,
							(Object[])null);

					newModel.setOrgTypeId(value14.intValue());

					Method method15 = oldModelClass.getMethod("getOrgStatus");

					Boolean value15 = (Boolean)method15.invoke(oldModel,
							(Object[])null);

					newModel.setOrgStatus(value15.booleanValue());

					Method method16 = oldModelClass.getMethod("getShowLogo");

					Boolean value16 = (Boolean)method16.invoke(oldModel,
							(Object[])null);

					newModel.setShowLogo(value16.booleanValue());

					Method method17 = oldModelClass.getMethod("getLogoId");

					String value17 = (String)method17.invoke(oldModel,
							(Object[])null);

					newModel.setLogoId(value17);

					Method method18 = oldModelClass.getMethod("getSlogan");

					String value18 = (String)method18.invoke(oldModel,
							(Object[])null);

					newModel.setSlogan(value18);

					Method method19 = oldModelClass.getMethod("getBannerId");

					String value19 = (String)method19.invoke(oldModel,
							(Object[])null);

					newModel.setBannerId(value19);

					Method method20 = oldModelClass.getMethod("getVideorUrl");

					String value20 = (String)method20.invoke(oldModel,
							(Object[])null);

					newModel.setVideorUrl(value20);

					Method method21 = oldModelClass.getMethod("getWebsite");

					String value21 = (String)method21.invoke(oldModel,
							(Object[])null);

					newModel.setWebsite(value21);

					Method method22 = oldModelClass.getMethod("getOrgSize");

					Integer value22 = (Integer)method22.invoke(oldModel,
							(Object[])null);

					newModel.setOrgSize(value22.intValue());

					Method method23 = oldModelClass.getMethod("getOrgFounded");

					Date value23 = (Date)method23.invoke(oldModel,
							(Object[])null);

					newModel.setOrgFounded(value23);

					Method method24 = oldModelClass.getMethod("getCreatedBy");

					Long value24 = (Long)method24.invoke(oldModel,
							(Object[])null);

					newModel.setCreatedBy(value24.longValue());

					Method method25 = oldModelClass.getMethod("getCreatedAt");

					Date value25 = (Date)method25.invoke(oldModel,
							(Object[])null);

					newModel.setCreatedAt(value25);

					Method method26 = oldModelClass.getMethod("getUpdatedBy");

					Long value26 = (Long)method26.invoke(oldModel,
							(Object[])null);

					newModel.setUpdatedBy(value26.longValue());

					Method method27 = oldModelClass.getMethod("getUpdatedAt");

					Date value27 = (Date)method27.invoke(oldModel,
							(Object[])null);

					newModel.setUpdatedAt(value27);

					Method method28 = oldModelClass.getMethod("getFounderList");

					String value28 = (String)method28.invoke(oldModel,
							(Object[])null);

					newModel.setFounderList(value28);

					Method method29 = oldModelClass.getMethod("getOrgParent");

					Integer value29 = (Integer)method29.invoke(oldModel,
							(Object[])null);

					newModel.setOrgParent(value29.intValue());

					Method method30 = oldModelClass.getMethod("getRootId");

					Integer value30 = (Integer)method30.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value30.intValue());

					Method method31 = oldModelClass.getMethod("getBodId");

					Integer value31 = (Integer)method31.invoke(oldModel,
							(Object[])null);

					newModel.setBodId(value31.intValue());

					Method method32 = oldModelClass.getMethod("getBeginTime");

					Date value32 = (Date)method32.invoke(oldModel,
							(Object[])null);

					newModel.setBeginTime(value32);

					Method method33 = oldModelClass.getMethod("getEndTime");

					Date value33 = (Date)method33.invoke(oldModel,
							(Object[])null);

					newModel.setEndTime(value33);

					Method method34 = oldModelClass.getMethod("getEmail");

					String value34 = (String)method34.invoke(oldModel,
							(Object[])null);

					newModel.setEmail(value34);

					Method method35 = oldModelClass.getMethod("getIsProactive");

					Boolean value35 = (Boolean)method35.invoke(oldModel,
							(Object[])null);

					newModel.setIsProactive(value35.booleanValue());

					Method method36 = oldModelClass.getMethod("getLevelSharing");

					Integer value36 = (Integer)method36.invoke(oldModel,
							(Object[])null);

					newModel.setLevelSharing(value36.intValue());

					Method method37 = oldModelClass.getMethod(
							"getIsPrivateProfile");

					Boolean value37 = (Boolean)method37.invoke(oldModel,
							(Object[])null);

					newModel.setIsPrivateProfile(value37.booleanValue());

					Method method38 = oldModelClass.getMethod("getProfileUrl");

					String value38 = (String)method38.invoke(oldModel,
							(Object[])null);

					newModel.setProfileUrl(value38);

					Method method39 = oldModelClass.getMethod("getMaxLevel");

					Integer value39 = (Integer)method39.invoke(oldModel,
							(Object[])null);

					newModel.setMaxLevel(value39.intValue());

					Method method40 = oldModelClass.getMethod("getLevel");

					Integer value40 = (Integer)method40.invoke(oldModel,
							(Object[])null);

					newModel.setLevel(value40.intValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.OrganizationViewImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					OrganizationViewClp newModel = new OrganizationViewClp();

					Method method0 = oldModelClass.getMethod("getOrgId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value0.intValue());

					Method method1 = oldModelClass.getMethod("getOrgName");

					String value1 = (String)method1.invoke(oldModel,
							(Object[])null);

					newModel.setOrgName(value1);

					Method method2 = oldModelClass.getMethod("getCountProduct");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setCountProduct(value2.intValue());

					Method method3 = oldModelClass.getMethod("getOrgNameLower");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setOrgNameLower(value3);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.OrgObjectListImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					OrgObjectListClp newModel = new OrgObjectListClp();

					Method method0 = oldModelClass.getMethod(
							"getOrgObjectListId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setOrgObjectListId(value0);

					Method method1 = oldModelClass.getMethod("getOrg_id");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setOrg_id(value1.intValue());

					Method method2 = oldModelClass.getMethod("getName");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setName(value2);

					Method method3 = oldModelClass.getMethod("getDescription");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value3);

					Method method4 = oldModelClass.getMethod("getCreated_date");

					Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

					newModel.setCreated_date(value4);

					Method method5 = oldModelClass.getMethod("getYear");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setYear(value5.intValue());

					Method method6 = oldModelClass.getMethod("getObjtype");

					Integer value6 = (Integer)method6.invoke(oldModel,
							(Object[])null);

					newModel.setObjtype(value6.intValue());

					Method method7 = oldModelClass.getMethod(
							"getEntering_percent");

					Double value7 = (Double)method7.invoke(oldModel,
							(Object[])null);

					newModel.setEntering_percent(value7.doubleValue());

					Method method8 = oldModelClass.getMethod(
							"getCompletion_percent");

					Double value8 = (Double)method8.invoke(oldModel,
							(Object[])null);

					newModel.setCompletion_percent(value8.doubleValue());

					Method method9 = oldModelClass.getMethod("getIsapproved");

					Boolean value9 = (Boolean)method9.invoke(oldModel,
							(Object[])null);

					newModel.setIsapproved(value9.booleanValue());

					Method method10 = oldModelClass.getMethod("getMonth_hash");

					Integer value10 = (Integer)method10.invoke(oldModel,
							(Object[])null);

					newModel.setMonth_hash(value10.intValue());

					Method method11 = oldModelClass.getMethod("getValidweight");

					Boolean value11 = (Boolean)method11.invoke(oldModel,
							(Object[])null);

					newModel.setValidweight(value11.booleanValue());

					Method method12 = oldModelClass.getMethod(
							"getCurrent_total_cost");

					Double value12 = (Double)method12.invoke(oldModel,
							(Object[])null);

					newModel.setCurrent_total_cost(value12.doubleValue());

					Method method13 = oldModelClass.getMethod(
							"getExpected_completion");

					Double value13 = (Double)method13.invoke(oldModel,
							(Object[])null);

					newModel.setExpected_completion(value13.doubleValue());

					Method method14 = oldModelClass.getMethod(
							"getNext_total_cost");

					Double value14 = (Double)method14.invoke(oldModel,
							(Object[])null);

					newModel.setNext_total_cost(value14.doubleValue());

					Method method15 = oldModelClass.getMethod(
							"getConsistency_ratio");

					Double value15 = (Double)method15.invoke(oldModel,
							(Object[])null);

					newModel.setConsistency_ratio(value15.doubleValue());

					Method method16 = oldModelClass.getMethod("getParentid");

					Integer value16 = (Integer)method16.invoke(oldModel,
							(Object[])null);

					newModel.setParentid(value16.intValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.OrgObjectApprovalImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					OrgObjectApprovalClp newModel = new OrgObjectApprovalClp();

					Method method0 = oldModelClass.getMethod(
							"getOrgObjectApprovalId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setOrgObjectApprovalId(value0);

					Method method1 = oldModelClass.getMethod("getStatus");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setStatus(value1.intValue());

					Method method2 = oldModelClass.getMethod("getApproved_at");

					Date value2 = (Date)method2.invoke(oldModel, (Object[])null);

					newModel.setApproved_at(value2);

					Method method3 = oldModelClass.getMethod("getApproved_by");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setApproved_by(value3.intValue());

					Method method4 = oldModelClass.getMethod("getReason");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setReason(value4);

					Method method5 = oldModelClass.getMethod(
							"getOrgObjectListId");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setOrgObjectListId(value5.intValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.OrgObjectPerspectiveImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					OrgObjectPerspectiveClp newModel = new OrgObjectPerspectiveClp();

					Method method0 = oldModelClass.getMethod(
							"getOrgObjectPerspectiveId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setOrgObjectPerspectiveId(value0);

					Method method1 = oldModelClass.getMethod(
							"getOrgObjectListId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setOrgObjectListId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getName");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setName(value2);

					Method method3 = oldModelClass.getMethod("getDescription");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value3);

					Method method4 = oldModelClass.getMethod(
							"getWeight_percent");

					Double value4 = (Double)method4.invoke(oldModel,
							(Object[])null);

					newModel.setWeight_percent(value4.doubleValue());

					Method method5 = oldModelClass.getMethod(
							"getEntering_percent");

					Double value5 = (Double)method5.invoke(oldModel,
							(Object[])null);

					newModel.setEntering_percent(value5.doubleValue());

					Method method6 = oldModelClass.getMethod(
							"getCompletion_percent");

					Double value6 = (Double)method6.invoke(oldModel,
							(Object[])null);

					newModel.setCompletion_percent(value6.doubleValue());

					Method method7 = oldModelClass.getMethod(
							"getObjective_count");

					Double value7 = (Double)method7.invoke(oldModel,
							(Object[])null);

					newModel.setObjective_count(value7.doubleValue());

					Method method8 = oldModelClass.getMethod("getValidweight");

					Boolean value8 = (Boolean)method8.invoke(oldModel,
							(Object[])null);

					newModel.setValidweight(value8.booleanValue());

					Method method9 = oldModelClass.getMethod("getPertype");

					Integer value9 = (Integer)method9.invoke(oldModel,
							(Object[])null);

					newModel.setPertype(value9.intValue());

					Method method10 = oldModelClass.getMethod("getCurrent_cost");

					Double value10 = (Double)method10.invoke(oldModel,
							(Object[])null);

					newModel.setCurrent_cost(value10.doubleValue());

					Method method11 = oldModelClass.getMethod("getNext_cost");

					Double value11 = (Double)method11.invoke(oldModel,
							(Object[])null);

					newModel.setNext_cost(value11.doubleValue());

					Method method12 = oldModelClass.getMethod("getNext_cost2");

					Double value12 = (Double)method12.invoke(oldModel,
							(Object[])null);

					newModel.setNext_cost2(value12.doubleValue());

					Method method13 = oldModelClass.getMethod(
							"getConsistency_ratio");

					Double value13 = (Double)method13.invoke(oldModel,
							(Object[])null);

					newModel.setConsistency_ratio(value13.doubleValue());

					Method method14 = oldModelClass.getMethod(
							"getWeight_percent_suggested");

					Double value14 = (Double)method14.invoke(oldModel,
							(Object[])null);

					newModel.setWeight_percent_suggested(value14.doubleValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.OrgObjectObjectiveImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					OrgObjectObjectiveClp newModel = new OrgObjectObjectiveClp();

					Method method0 = oldModelClass.getMethod(
							"getOrgObjectObjectiveId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setOrgObjectObjectiveId(value0);

					Method method1 = oldModelClass.getMethod(
							"getOrgObjectPerspectiveId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setOrgObjectPerspectiveId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getName");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setName(value2);

					Method method3 = oldModelClass.getMethod("getDescription");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value3);

					Method method4 = oldModelClass.getMethod("getCreated_date");

					Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

					newModel.setCreated_date(value4);

					Method method5 = oldModelClass.getMethod(
							"getWeight_percent");

					Double value5 = (Double)method5.invoke(oldModel,
							(Object[])null);

					newModel.setWeight_percent(value5.doubleValue());

					Method method6 = oldModelClass.getMethod(
							"getEntering_percent");

					Double value6 = (Double)method6.invoke(oldModel,
							(Object[])null);

					newModel.setEntering_percent(value6.doubleValue());

					Method method7 = oldModelClass.getMethod(
							"getCompletion_percent");

					Double value7 = (Double)method7.invoke(oldModel,
							(Object[])null);

					newModel.setCompletion_percent(value7.doubleValue());

					Method method8 = oldModelClass.getMethod("getMeasure_count");

					Integer value8 = (Integer)method8.invoke(oldModel,
							(Object[])null);

					newModel.setMeasure_count(value8.intValue());

					Method method9 = oldModelClass.getMethod("getValidweight");

					Boolean value9 = (Boolean)method9.invoke(oldModel,
							(Object[])null);

					newModel.setValidweight(value9.booleanValue());

					Method method10 = oldModelClass.getMethod(
							"getConsistency_ratio");

					Double value10 = (Double)method10.invoke(oldModel,
							(Object[])null);

					newModel.setConsistency_ratio(value10.doubleValue());

					Method method11 = oldModelClass.getMethod(
							"getWeight_percent_suggested");

					Double value11 = (Double)method11.invoke(oldModel,
							(Object[])null);

					newModel.setWeight_percent_suggested(value11.doubleValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.OrgObjectMeasureImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					OrgObjectMeasureClp newModel = new OrgObjectMeasureClp();

					Method method0 = oldModelClass.getMethod(
							"getOrgObjectMeasureId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setOrgObjectMeasureId(value0);

					Method method1 = oldModelClass.getMethod(
							"getOrgObjectObjectiveId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setOrgObjectObjectiveId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getName");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setName(value2);

					Method method3 = oldModelClass.getMethod("getDescription");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value3);

					Method method4 = oldModelClass.getMethod("getCreated_date");

					Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

					newModel.setCreated_date(value4);

					Method method5 = oldModelClass.getMethod(
							"getWeight_percent");

					Double value5 = (Double)method5.invoke(oldModel,
							(Object[])null);

					newModel.setWeight_percent(value5.doubleValue());

					Method method6 = oldModelClass.getMethod("getIsassessed");

					Boolean value6 = (Boolean)method6.invoke(oldModel,
							(Object[])null);

					newModel.setIsassessed(value6.booleanValue());

					Method method7 = oldModelClass.getMethod("getResult");

					Double value7 = (Double)method7.invoke(oldModel,
							(Object[])null);

					newModel.setResult(value7.doubleValue());

					Method method8 = oldModelClass.getMethod(
							"getEntering_percent");

					Double value8 = (Double)method8.invoke(oldModel,
							(Object[])null);

					newModel.setEntering_percent(value8.doubleValue());

					Method method9 = oldModelClass.getMethod(
							"getCompletion_percent");

					Double value9 = (Double)method9.invoke(oldModel,
							(Object[])null);

					newModel.setCompletion_percent(value9.doubleValue());

					Method method10 = oldModelClass.getMethod("getFormula");

					String value10 = (String)method10.invoke(oldModel,
							(Object[])null);

					newModel.setFormula(value10);

					Method method11 = oldModelClass.getMethod("getTarget_count");

					Integer value11 = (Integer)method11.invoke(oldModel,
							(Object[])null);

					newModel.setTarget_count(value11.intValue());

					Method method12 = oldModelClass.getMethod(
							"getInterpretation");

					String value12 = (String)method12.invoke(oldModel,
							(Object[])null);

					newModel.setInterpretation(value12);

					Method method13 = oldModelClass.getMethod(
							"getWeight_percent_suggested");

					Double value13 = (Double)method13.invoke(oldModel,
							(Object[])null);

					newModel.setWeight_percent_suggested(value13.doubleValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.OrgObjectTargetsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					OrgObjectTargetsClp newModel = new OrgObjectTargetsClp();

					Method method0 = oldModelClass.getMethod(
							"getOrgObjectTargetId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setOrgObjectTargetId(value0);

					Method method1 = oldModelClass.getMethod(
							"getOrgObjectMeasureId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setOrgObjectMeasureId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getName");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setName(value2);

					Method method3 = oldModelClass.getMethod("getDescription");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value3);

					Method method4 = oldModelClass.getMethod("getCreated_date");

					Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

					newModel.setCreated_date(value4);

					Method method5 = oldModelClass.getMethod("getValue");

					Double value5 = (Double)method5.invoke(oldModel,
							(Object[])null);

					newModel.setValue(value5.doubleValue());

					Method method6 = oldModelClass.getMethod("getMinMax");

					Boolean value6 = (Boolean)method6.invoke(oldModel,
							(Object[])null);

					newModel.setMinMax(value6.booleanValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.ProgatePortalMenuImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ProgatePortalMenuClp newModel = new ProgatePortalMenuClp();

					Method method0 = oldModelClass.getMethod("getPortalMenuId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setPortalMenuId(value0);

					Method method1 = oldModelClass.getMethod("getName");

					String value1 = (String)method1.invoke(oldModel,
							(Object[])null);

					newModel.setName(value1);

					Method method2 = oldModelClass.getMethod("getLayoutId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setLayoutId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getRoleId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setRoleId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getOrgId");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value4.intValue());

					Method method5 = oldModelClass.getMethod("getMenuOrder");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setMenuOrder(value5.intValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.ProGateRolesImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ProGateRolesClp newModel = new ProGateRolesClp();

					Method method0 = oldModelClass.getMethod("getRoleId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setRoleId(value0);

					Method method1 = oldModelClass.getMethod("getName");

					String value1 = (String)method1.invoke(oldModel,
							(Object[])null);

					newModel.setName(value1);

					Method method2 = oldModelClass.getMethod("getDescription");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value2);

					Method method3 = oldModelClass.getMethod("getRoleType");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setRoleType(value3.intValue());

					Method method4 = oldModelClass.getMethod("getPriority");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setPriority(value4.intValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.ProGateOrgTypeImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ProGateOrgTypeClp newModel = new ProGateOrgTypeClp();

					Method method0 = oldModelClass.getMethod("getOrgTypeId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setOrgTypeId(value0);

					Method method1 = oldModelClass.getMethod("getName");

					String value1 = (String)method1.invoke(oldModel,
							(Object[])null);

					newModel.setName(value1);

					Method method2 = oldModelClass.getMethod("getDescription");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value2);

					Method method3 = oldModelClass.getMethod("getStatus");

					Boolean value3 = (Boolean)method3.invoke(oldModel,
							(Object[])null);

					newModel.setStatus(value3.booleanValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.ProGateJournalArticleImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ProGateJournalArticleClp newModel = new ProGateJournalArticleClp();

					Method method0 = oldModelClass.getMethod(
							"getJournalArticleId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setJournalArticleId(value0);

					Method method1 = oldModelClass.getMethod("getOrgId");

					String value1 = (String)method1.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value1);

					Method method2 = oldModelClass.getMethod("getArticleType");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setArticleType(value2.intValue());

					Method method3 = oldModelClass.getMethod("getTitle");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setTitle(value3);

					Method method4 = oldModelClass.getMethod("getResourceUrl");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setResourceUrl(value4);

					Method method5 = oldModelClass.getMethod("getDescription");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value5);

					Method method6 = oldModelClass.getMethod("getContent");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setContent(value6);

					Method method7 = oldModelClass.getMethod("getPriority");

					Integer value7 = (Integer)method7.invoke(oldModel,
							(Object[])null);

					newModel.setPriority(value7.intValue());

					Method method8 = oldModelClass.getMethod("getSmallImageUrl");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setSmallImageUrl(value8);

					Method method9 = oldModelClass.getMethod("getBigImageUrl");

					String value9 = (String)method9.invoke(oldModel,
							(Object[])null);

					newModel.setBigImageUrl(value9);

					Method method10 = oldModelClass.getMethod("getCreatedBy");

					Integer value10 = (Integer)method10.invoke(oldModel,
							(Object[])null);

					newModel.setCreatedBy(value10.intValue());

					Method method11 = oldModelClass.getMethod("getCreatedAt");

					Date value11 = (Date)method11.invoke(oldModel,
							(Object[])null);

					newModel.setCreatedAt(value11);

					Method method12 = oldModelClass.getMethod("getUpdatedBy");

					Integer value12 = (Integer)method12.invoke(oldModel,
							(Object[])null);

					newModel.setUpdatedBy(value12.intValue());

					Method method13 = oldModelClass.getMethod("getUpdatedAt");

					Date value13 = (Date)method13.invoke(oldModel,
							(Object[])null);

					newModel.setUpdatedAt(value13);

					Method method14 = oldModelClass.getMethod("getAddInfo");

					String value14 = (String)method14.invoke(oldModel,
							(Object[])null);

					newModel.setAddInfo(value14);

					Method method15 = oldModelClass.getMethod("getArticleOrder");

					Integer value15 = (Integer)method15.invoke(oldModel,
							(Object[])null);

					newModel.setArticleOrder(value15.intValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.ProGateProductsServicesImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ProGateProductsServicesClp newModel = new ProGateProductsServicesClp();

					Method method0 = oldModelClass.getMethod(
							"getProductsServicesId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setProductsServicesId(value0);

					Method method1 = oldModelClass.getMethod("getArticleId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setArticleId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getOrgId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getDiscount");

					Double value3 = (Double)method3.invoke(oldModel,
							(Object[])null);

					newModel.setDiscount(value3.doubleValue());

					Method method4 = oldModelClass.getMethod("getPrice");

					Double value4 = (Double)method4.invoke(oldModel,
							(Object[])null);

					newModel.setPrice(value4.doubleValue());

					Method method5 = oldModelClass.getMethod("getCurrencyId");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setCurrencyId(value5.intValue());

					Method method6 = oldModelClass.getMethod("getProductType");

					Integer value6 = (Integer)method6.invoke(oldModel,
							(Object[])null);

					newModel.setProductType(value6.intValue());

					Method method7 = oldModelClass.getMethod("getIsHot");

					Boolean value7 = (Boolean)method7.invoke(oldModel,
							(Object[])null);

					newModel.setIsHot(value7.booleanValue());

					Method method8 = oldModelClass.getMethod("getIsService");

					Boolean value8 = (Boolean)method8.invoke(oldModel,
							(Object[])null);

					newModel.setIsService(value8.booleanValue());

					Method method9 = oldModelClass.getMethod(
							"getProgateCategory");

					Integer value9 = (Integer)method9.invoke(oldModel,
							(Object[])null);

					newModel.setProgateCategory(value9.intValue());

					Method method10 = oldModelClass.getMethod("getExpiredDate");

					Date value10 = (Date)method10.invoke(oldModel,
							(Object[])null);

					newModel.setExpiredDate(value10);

					Method method11 = oldModelClass.getMethod("getAmount");

					Integer value11 = (Integer)method11.invoke(oldModel,
							(Object[])null);

					newModel.setAmount(value11.intValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.ProGateCurrencyTypesImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ProGateCurrencyTypesClp newModel = new ProGateCurrencyTypesClp();

					Method method0 = oldModelClass.getMethod("getCurrencyId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setCurrencyId(value0);

					Method method1 = oldModelClass.getMethod("getCode");

					String value1 = (String)method1.invoke(oldModel,
							(Object[])null);

					newModel.setCode(value1);

					Method method2 = oldModelClass.getMethod("getDescription");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value2);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.ProGateJournalArticlePrioritiesImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ProGateJournalArticlePrioritiesClp newModel = new ProGateJournalArticlePrioritiesClp();

					Method method0 = oldModelClass.getMethod(
							"getJournalArticlePrioritiesId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setJournalArticlePrioritiesId(value0);

					Method method1 = oldModelClass.getMethod("getName");

					String value1 = (String)method1.invoke(oldModel,
							(Object[])null);

					newModel.setName(value1);

					Method method2 = oldModelClass.getMethod("getDescription");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value2);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.ProGateJournalArticleTypesImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ProGateJournalArticleTypesClp newModel = new ProGateJournalArticleTypesClp();

					Method method0 = oldModelClass.getMethod(
							"getJournalArticleTypesId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setJournalArticleTypesId(value0);

					Method method1 = oldModelClass.getMethod("getName");

					String value1 = (String)method1.invoke(oldModel,
							(Object[])null);

					newModel.setName(value1);

					Method method2 = oldModelClass.getMethod("getDescription");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value2);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals("larion.progate.model.impl.RegionImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					RegionClp newModel = new RegionClp();

					Method method0 = oldModelClass.getMethod("getRegionId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setRegionId(value0);

					Method method1 = oldModelClass.getMethod("getName");

					String value1 = (String)method1.invoke(oldModel,
							(Object[])null);

					newModel.setName(value1);

					Method method2 = oldModelClass.getMethod("getRegionCode");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRegionCode(value2);

					Method method3 = oldModelClass.getMethod("getCountryId");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setCountryId(value3);

					Method method4 = oldModelClass.getMethod("getActive");

					Boolean value4 = (Boolean)method4.invoke(oldModel,
							(Object[])null);

					newModel.setActive(value4.booleanValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals("larion.progate.model.impl.CountryImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					CountryClp newModel = new CountryClp();

					Method method0 = oldModelClass.getMethod("getCountryId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setCountryId(value0);

					Method method1 = oldModelClass.getMethod("getName");

					String value1 = (String)method1.invoke(oldModel,
							(Object[])null);

					newModel.setName(value1);

					Method method2 = oldModelClass.getMethod("getActive");

					Boolean value2 = (Boolean)method2.invoke(oldModel,
							(Object[])null);

					newModel.setActive(value2.booleanValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.ProGateJournalArticleViewImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ProGateJournalArticleViewClp newModel = new ProGateJournalArticleViewClp();

					Method method0 = oldModelClass.getMethod(
							"getJournalArticleId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setJournalArticleId(value0);

					Method method1 = oldModelClass.getMethod("getOrgId");

					String value1 = (String)method1.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value1);

					Method method2 = oldModelClass.getMethod("getOrgName");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setOrgName(value2);

					Method method3 = oldModelClass.getMethod("getArticleType");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setArticleType(value3.intValue());

					Method method4 = oldModelClass.getMethod("getTitle");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setTitle(value4);

					Method method5 = oldModelClass.getMethod("getResourceUrl");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setResourceUrl(value5);

					Method method6 = oldModelClass.getMethod("getDescription");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value6);

					Method method7 = oldModelClass.getMethod("getContent");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setContent(value7);

					Method method8 = oldModelClass.getMethod("getPriority");

					Integer value8 = (Integer)method8.invoke(oldModel,
							(Object[])null);

					newModel.setPriority(value8.intValue());

					Method method9 = oldModelClass.getMethod("getSmallImageUrl");

					String value9 = (String)method9.invoke(oldModel,
							(Object[])null);

					newModel.setSmallImageUrl(value9);

					Method method10 = oldModelClass.getMethod("getBigImageUrl");

					String value10 = (String)method10.invoke(oldModel,
							(Object[])null);

					newModel.setBigImageUrl(value10);

					Method method11 = oldModelClass.getMethod("getCreatedBy");

					Integer value11 = (Integer)method11.invoke(oldModel,
							(Object[])null);

					newModel.setCreatedBy(value11.intValue());

					Method method12 = oldModelClass.getMethod("getCreatedAt");

					Date value12 = (Date)method12.invoke(oldModel,
							(Object[])null);

					newModel.setCreatedAt(value12);

					Method method13 = oldModelClass.getMethod("getUpdatedBy");

					Integer value13 = (Integer)method13.invoke(oldModel,
							(Object[])null);

					newModel.setUpdatedBy(value13.intValue());

					Method method14 = oldModelClass.getMethod("getUpdatedAt");

					Date value14 = (Date)method14.invoke(oldModel,
							(Object[])null);

					newModel.setUpdatedAt(value14);

					Method method15 = oldModelClass.getMethod("getDiscount");

					Double value15 = (Double)method15.invoke(oldModel,
							(Object[])null);

					newModel.setDiscount(value15.doubleValue());

					Method method16 = oldModelClass.getMethod("getPrice");

					Double value16 = (Double)method16.invoke(oldModel,
							(Object[])null);

					newModel.setPrice(value16.doubleValue());

					Method method17 = oldModelClass.getMethod("getCurrencyId");

					Integer value17 = (Integer)method17.invoke(oldModel,
							(Object[])null);

					newModel.setCurrencyId(value17.intValue());

					Method method18 = oldModelClass.getMethod("getProductType");

					Integer value18 = (Integer)method18.invoke(oldModel,
							(Object[])null);

					newModel.setProductType(value18.intValue());

					Method method19 = oldModelClass.getMethod("getIsHot");

					Boolean value19 = (Boolean)method19.invoke(oldModel,
							(Object[])null);

					newModel.setIsHot(value19.booleanValue());

					Method method20 = oldModelClass.getMethod("getIsService");

					Boolean value20 = (Boolean)method20.invoke(oldModel,
							(Object[])null);

					newModel.setIsService(value20.booleanValue());

					Method method21 = oldModelClass.getMethod("getExpiredDate");

					Date value21 = (Date)method21.invoke(oldModel,
							(Object[])null);

					newModel.setExpiredDate(value21);

					Method method22 = oldModelClass.getMethod("getAmount");

					Integer value22 = (Integer)method22.invoke(oldModel,
							(Object[])null);

					newModel.setAmount(value22.intValue());

					Method method23 = oldModelClass.getMethod("getCurrencyCode");

					String value23 = (String)method23.invoke(oldModel,
							(Object[])null);

					newModel.setCurrencyCode(value23);

					Method method24 = oldModelClass.getMethod(
							"getJournalArticleTypesName");

					String value24 = (String)method24.invoke(oldModel,
							(Object[])null);

					newModel.setJournalArticleTypesName(value24);

					Method method25 = oldModelClass.getMethod(
							"getProgateCategory");

					Integer value25 = (Integer)method25.invoke(oldModel,
							(Object[])null);

					newModel.setProgateCategory(value25.intValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.ProGateJournalArticleSlideShowImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ProGateJournalArticleSlideShowClp newModel = new ProGateJournalArticleSlideShowClp();

					Method method0 = oldModelClass.getMethod(
							"getJournalArticleSlideShowId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setJournalArticleSlideShowId(value0);

					Method method1 = oldModelClass.getMethod("getOrgId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getProductId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setProductId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getImageUrl");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setImageUrl(value3);

					Method method4 = oldModelClass.getMethod("getTitle");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setTitle(value4);

					Method method5 = oldModelClass.getMethod("getTitleUrl");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setTitleUrl(value5);

					Method method6 = oldModelClass.getMethod("getSlideIndex");

					Integer value6 = (Integer)method6.invoke(oldModel,
							(Object[])null);

					newModel.setSlideIndex(value6.intValue());

					Method method7 = oldModelClass.getMethod("getIsService");

					Boolean value7 = (Boolean)method7.invoke(oldModel,
							(Object[])null);

					newModel.setIsService(value7.booleanValue());

					Method method8 = oldModelClass.getMethod("getCreatedBy");

					Integer value8 = (Integer)method8.invoke(oldModel,
							(Object[])null);

					newModel.setCreatedBy(value8.intValue());

					Method method9 = oldModelClass.getMethod("getCreatedAt");

					Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

					newModel.setCreatedAt(value9);

					Method method10 = oldModelClass.getMethod("getUpdatedBy");

					Integer value10 = (Integer)method10.invoke(oldModel,
							(Object[])null);

					newModel.setUpdatedBy(value10.intValue());

					Method method11 = oldModelClass.getMethod("getUpdatedAt");

					Date value11 = (Date)method11.invoke(oldModel,
							(Object[])null);

					newModel.setUpdatedAt(value11);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.ProGateOrgCustomerImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ProGateOrgCustomerClp newModel = new ProGateOrgCustomerClp();

					Method method0 = oldModelClass.getMethod(
							"getProGateOrgCustomerId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setProGateOrgCustomerId(value0);

					Method method1 = oldModelClass.getMethod("getCustomerType");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setCustomerType(value1.intValue());

					Method method2 = oldModelClass.getMethod("getCustomerName");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setCustomerName(value2);

					Method method3 = oldModelClass.getMethod("getOrgId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getHasOrgMap");

					Boolean value4 = (Boolean)method4.invoke(oldModel,
							(Object[])null);

					newModel.setHasOrgMap(value4.booleanValue());

					Method method5 = oldModelClass.getMethod("getUrlOrgMap");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setUrlOrgMap(value5);

					Method method6 = oldModelClass.getMethod("getLogo");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setLogo(value6);

					Method method7 = oldModelClass.getMethod("getWebsite");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setWebsite(value7);

					Method method8 = oldModelClass.getMethod("getDescription");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value8);

					Method method9 = oldModelClass.getMethod("getCreatedDate");

					Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

					newModel.setCreatedDate(value9);

					Method method10 = oldModelClass.getMethod("getModifiedDate");

					Date value10 = (Date)method10.invoke(oldModel,
							(Object[])null);

					newModel.setModifiedDate(value10);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.ProGateOrgCustomerRepresenterImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ProGateOrgCustomerRepresenterClp newModel = new ProGateOrgCustomerRepresenterClp();

					Method method0 = oldModelClass.getMethod(
							"getProGateOrgCustomerRepresenterId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setProGateOrgCustomerRepresenterId(value0);

					Method method1 = oldModelClass.getMethod("getFirstName");

					String value1 = (String)method1.invoke(oldModel,
							(Object[])null);

					newModel.setFirstName(value1);

					Method method2 = oldModelClass.getMethod("getLastName");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setLastName(value2);

					Method method3 = oldModelClass.getMethod("getDisplayName");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setDisplayName(value3);

					Method method4 = oldModelClass.getMethod("getRole");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setRole(value4);

					Method method5 = oldModelClass.getMethod("getCustomerId");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setCustomerId(value5.intValue());

					Method method6 = oldModelClass.getMethod("getOrgId");

					Integer value6 = (Integer)method6.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value6.intValue());

					Method method7 = oldModelClass.getMethod("getDescription");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value7);

					Method method8 = oldModelClass.getMethod("getCreatedDate");

					Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

					newModel.setCreatedDate(value8);

					Method method9 = oldModelClass.getMethod("getModifiedDate");

					Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

					newModel.setModifiedDate(value9);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.ProGateApplicationsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ProGateApplicationsClp newModel = new ProGateApplicationsClp();

					Method method0 = oldModelClass.getMethod(
							"getProGateApplicationsId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setProGateApplicationsId(value0);

					Method method1 = oldModelClass.getMethod("getLayoutId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setLayoutId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getName");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setName(value2);

					Method method3 = oldModelClass.getMethod("getTitle");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setTitle(value3);

					Method method4 = oldModelClass.getMethod("getDescription");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value4);

					Method method5 = oldModelClass.getMethod("getIsHidden");

					Boolean value5 = (Boolean)method5.invoke(oldModel,
							(Object[])null);

					newModel.setIsHidden(value5.booleanValue());

					Method method6 = oldModelClass.getMethod("getFriendlyUrl");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setFriendlyUrl(value6);

					Method method7 = oldModelClass.getMethod("getImageUrl");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setImageUrl(value7);

					Method method8 = oldModelClass.getMethod("getIconUrl");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setIconUrl(value8);

					Method method9 = oldModelClass.getMethod("getCreatedDate");

					Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

					newModel.setCreatedDate(value9);

					Method method10 = oldModelClass.getMethod("getModifiedDate");

					Date value10 = (Date)method10.invoke(oldModel,
							(Object[])null);

					newModel.setModifiedDate(value10);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.ProGateUserApplicationsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ProGateUserApplicationsClp newModel = new ProGateUserApplicationsClp();

					Method method0 = oldModelClass.getMethod(
							"getProGateUserApplicationsId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setProGateUserApplicationsId(value0);

					Method method1 = oldModelClass.getMethod("getUserId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getAppsId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setAppsId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getOrgId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getPosition");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setPosition(value4.intValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.ProgateOrganizationParticipantsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ProgateOrganizationParticipantsClp newModel = new ProgateOrganizationParticipantsClp();

					Method method0 = oldModelClass.getMethod(
							"getProgateOrganizationParticipantsId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setProgateOrganizationParticipantsId(value0);

					Method method1 = oldModelClass.getMethod("getUserId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getOrgId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getRoleId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setRoleId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getRootId");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value4.intValue());

					Method method5 = oldModelClass.getMethod("getBodId");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setBodId(value5.intValue());

					Method method6 = oldModelClass.getMethod("getRequestedBy");

					Integer value6 = (Integer)method6.invoke(oldModel,
							(Object[])null);

					newModel.setRequestedBy(value6.intValue());

					Method method7 = oldModelClass.getMethod("getRequestedAt");

					Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

					newModel.setRequestedAt(value7);

					Method method8 = oldModelClass.getMethod(
							"getRequestedReason");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setRequestedReason(value8);

					Method method9 = oldModelClass.getMethod("getApprovedBy");

					Integer value9 = (Integer)method9.invoke(oldModel,
							(Object[])null);

					newModel.setApprovedBy(value9.intValue());

					Method method10 = oldModelClass.getMethod("getApprovedAt");

					Date value10 = (Date)method10.invoke(oldModel,
							(Object[])null);

					newModel.setApprovedAt(value10);

					Method method11 = oldModelClass.getMethod(
							"getApprovedReason");

					String value11 = (String)method11.invoke(oldModel,
							(Object[])null);

					newModel.setApprovedReason(value11);

					Method method12 = oldModelClass.getMethod("getStatus");

					Integer value12 = (Integer)method12.invoke(oldModel,
							(Object[])null);

					newModel.setStatus(value12.intValue());

					Method method13 = oldModelClass.getMethod("getIsCurrent");

					Boolean value13 = (Boolean)method13.invoke(oldModel,
							(Object[])null);

					newModel.setIsCurrent(value13.booleanValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.ProgateOrganizationsStaffsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ProgateOrganizationsStaffsClp newModel = new ProgateOrganizationsStaffsClp();

					Method method0 = oldModelClass.getMethod(
							"getProgateOrganizationsStaffsId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setProgateOrganizationsStaffsId(value0);

					Method method1 = oldModelClass.getMethod("getUserId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getOrgId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getRootId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getBodId");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setBodId(value4.intValue());

					Method method5 = oldModelClass.getMethod("getParticipantId");

					Integer value5 = (Integer)method5.invoke(oldModel,
							(Object[])null);

					newModel.setParticipantId(value5.intValue());

					Method method6 = oldModelClass.getMethod("getPosition");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setPosition(value6);

					Method method7 = oldModelClass.getMethod("getAvailability");

					Double value7 = (Double)method7.invoke(oldModel,
							(Object[])null);

					newModel.setAvailability(value7.doubleValue());

					Method method8 = oldModelClass.getMethod("getBeginTime");

					Date value8 = (Date)method8.invoke(oldModel, (Object[])null);

					newModel.setBeginTime(value8);

					Method method9 = oldModelClass.getMethod("getEndTime");

					Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

					newModel.setEndTime(value9);

					Method method10 = oldModelClass.getMethod("getIsActive");

					Boolean value10 = (Boolean)method10.invoke(oldModel,
							(Object[])null);

					newModel.setIsActive(value10.booleanValue());

					Method method11 = oldModelClass.getMethod("getIsRemoved");

					Boolean value11 = (Boolean)method11.invoke(oldModel,
							(Object[])null);

					newModel.setIsRemoved(value11.booleanValue());

					Method method12 = oldModelClass.getMethod("getStaffCode");

					String value12 = (String)method12.invoke(oldModel,
							(Object[])null);

					newModel.setStaffCode(value12);

					Method method13 = oldModelClass.getMethod("getScannerCode");

					String value13 = (String)method13.invoke(oldModel,
							(Object[])null);

					newModel.setScannerCode(value13);

					Method method14 = oldModelClass.getMethod("getCreatedAt");

					Date value14 = (Date)method14.invoke(oldModel,
							(Object[])null);

					newModel.setCreatedAt(value14);

					Method method15 = oldModelClass.getMethod("getUpdatedAt");

					Date value15 = (Date)method15.invoke(oldModel,
							(Object[])null);

					newModel.setUpdatedAt(value15);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.ProgateApplicationsSettingImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ProgateApplicationsSettingClp newModel = new ProgateApplicationsSettingClp();

					Method method0 = oldModelClass.getMethod(
							"getProgateApplicationsSettingId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setProgateApplicationsSettingId(value0);

					Method method1 = oldModelClass.getMethod("getAppId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setAppId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRoleId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRoleId(value2.intValue());

					Method method3 = oldModelClass.getMethod(
							"getDefaultPosition");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setDefaultPosition(value3.intValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.ProgateMenusImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ProgateMenusClp newModel = new ProgateMenusClp();

					Method method0 = oldModelClass.getMethod(
							"getProgateMenusId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setProgateMenusId(value0.intValue());

					Method method1 = oldModelClass.getMethod("getName");

					String value1 = (String)method1.invoke(oldModel,
							(Object[])null);

					newModel.setName(value1);

					Method method2 = oldModelClass.getMethod("getLayoutId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setLayoutId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getNumberOrder");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setNumberOrder(value3.intValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.ProgateLayoutsRolesImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ProgateLayoutsRolesClp newModel = new ProgateLayoutsRolesClp();

					Method method0 = oldModelClass.getMethod(
							"getProgateLayoutsRolesId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setProgateLayoutsRolesId(value0.intValue());

					Method method1 = oldModelClass.getMethod("getLayoutId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setLayoutId(value1.intValue());

					Method method2 = oldModelClass.getMethod(
							"getMinRolePriority");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setMinRolePriority(value2.intValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.ProgateLayoutsMenusImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ProgateLayoutsMenusClp newModel = new ProgateLayoutsMenusClp();

					Method method0 = oldModelClass.getMethod(
							"getProgateLayoutsMenusId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setProgateLayoutsMenusId(value0.intValue());

					Method method1 = oldModelClass.getMethod("getLayoutId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setLayoutId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getMenuName");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setMenuName(value2);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.ProGateMenuViewImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ProGateMenuViewClp newModel = new ProGateMenuViewClp();

					Method method0 = oldModelClass.getMethod("getName");

					String value0 = (String)method0.invoke(oldModel,
							(Object[])null);

					newModel.setName(value0);

					Method method1 = oldModelClass.getMethod("getMenus");

					String value1 = (String)method1.invoke(oldModel,
							(Object[])null);

					newModel.setMenus(value1);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.ProGateOrgsUsersPermissionsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ProGateOrgsUsersPermissionsClp newModel = new ProGateOrgsUsersPermissionsClp();

					Method method0 = oldModelClass.getMethod(
							"getProGateOrgsUsersPermissionsId");

					Integer value0 = (Integer)method0.invoke(oldModel,
							(Object[])null);

					newModel.setProGateOrgsUsersPermissionsId(value0);

					Method method1 = oldModelClass.getMethod("getOrgId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getUserId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getPermissionId");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setPermissionId(value3);

					Method method4 = oldModelClass.getMethod("getValue");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setValue(value4.intValue());

					Method method5 = oldModelClass.getMethod("getIsGrant");

					Boolean value5 = (Boolean)method5.invoke(oldModel,
							(Object[])null);

					newModel.setIsGrant(value5.booleanValue());

					Method method6 = oldModelClass.getMethod("getPmId");

					Integer value6 = (Integer)method6.invoke(oldModel,
							(Object[])null);

					newModel.setPmId(value6.intValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.ProGatePermissionsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ProGatePermissionsClp newModel = new ProGatePermissionsClp();

					Method method0 = oldModelClass.getMethod(
							"getProGatePermissionsId");

					String value0 = (String)method0.invoke(oldModel,
							(Object[])null);

					newModel.setProGatePermissionsId(value0);

					Method method1 = oldModelClass.getMethod("getApplicationId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setApplicationId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getCategory");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setCategory(value2.intValue());

					Method method3 = oldModelClass.getMethod("getDescription");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value3);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.ViewOrgUsersPermissionsImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ViewOrgUsersPermissionsClp newModel = new ViewOrgUsersPermissionsClp();

					Method method0 = oldModelClass.getMethod("getId");

					String value0 = (String)method0.invoke(oldModel,
							(Object[])null);

					newModel.setId(value0);

					Method method1 = oldModelClass.getMethod("getOrgId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setOrgId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getRootId");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setRootId(value2.intValue());

					Method method3 = oldModelClass.getMethod("getUserId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setUserId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getRoleId");

					Integer value4 = (Integer)method4.invoke(oldModel,
							(Object[])null);

					newModel.setRoleId(value4.intValue());

					Method method5 = oldModelClass.getMethod("getPermissionId");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setPermissionId(value5);

					Method method6 = oldModelClass.getMethod("getApplicationId");

					Integer value6 = (Integer)method6.invoke(oldModel,
							(Object[])null);

					newModel.setApplicationId(value6.intValue());

					Method method7 = oldModelClass.getMethod("getCategory");

					Integer value7 = (Integer)method7.invoke(oldModel,
							(Object[])null);

					newModel.setCategory(value7.intValue());

					Method method8 = oldModelClass.getMethod("getDescription");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value8);

					Method method9 = oldModelClass.getMethod("getValue");

					Integer value9 = (Integer)method9.invoke(oldModel,
							(Object[])null);

					newModel.setValue(value9.intValue());

					Method method10 = oldModelClass.getMethod("getPriority");

					Integer value10 = (Integer)method10.invoke(oldModel,
							(Object[])null);

					newModel.setPriority(value10.intValue());

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"larion.progate.model.impl.ViewProGatePermissionsRolesImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ViewProGatePermissionsRolesClp newModel = new ViewProGatePermissionsRolesClp();

					Method method0 = oldModelClass.getMethod(
							"getProGatePermissionsRolesId");

					String value0 = (String)method0.invoke(oldModel,
							(Object[])null);

					newModel.setProGatePermissionsRolesId(value0);

					Method method1 = oldModelClass.getMethod("getApplicationId");

					Integer value1 = (Integer)method1.invoke(oldModel,
							(Object[])null);

					newModel.setApplicationId(value1.intValue());

					Method method2 = oldModelClass.getMethod("getCategory");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setCategory(value2.intValue());

					Method method3 = oldModelClass.getMethod("getRoleId");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setRoleId(value3.intValue());

					Method method4 = oldModelClass.getMethod("getPerId");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setPerId(value4);

					Method method5 = oldModelClass.getMethod("getDescription");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value5);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel) {
			return translateOutput((BaseModel)obj);
		}
		else if (obj instanceof List) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
}