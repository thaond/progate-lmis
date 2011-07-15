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

package larion.progate.service.impl;

import larion.progate.model.Organization;
import larion.progate.model.OrganizationView;
import larion.progate.model.ProGateOrgType;
import larion.progate.model.ProgateOrganizationParticipants;
import larion.progate.model.User;
import larion.progate.service.OrganizationLocalServiceUtil;
import larion.progate.service.ProGateRolesLocalServiceUtil;
import larion.progate.service.ProgateOrganizationParticipantsLocalServiceUtil;
import larion.progate.service.base.OrganizationLocalServiceBaseImpl;
import larion.progate.service.persistence.OrganizationFinderUtil;
import larion.progate.service.persistence.OrganizationUtil;
import larion.progate.service.persistence.OrganizationViewUtil;
import larion.progate.service.persistence.ProGateOrgTypeUtil;
import larion.progate.service.persistence.ProGateRolesUtil;
import larion.progate.service.persistence.ProgateOrganizationParticipantsUtil;
import larion.progate.service.persistence.UserUtil;
import larion.progate.service.utils.Constants;
import larion.progate.service.utils.OrganizationsUtils;
import larion.progate.service.utils.ProGateOrgUserRoleUtils;

import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.ecs.storage.Array;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

/**
 * <a href="OrganizationLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class OrganizationLocalServiceImpl extends
		OrganizationLocalServiceBaseImpl {

	@SuppressWarnings("unchecked")
	private Organization createOrganizationFullInformation(int orgParentId,
			String orgName, String orgAbbr, String description,
			int maxUserCount, String eid, String orgType, String address1,
			String address2, String city, String state, String country,
			String phone, Date createdAt, Date expiredOn, boolean orgStatus)
			throws com.liferay.portal.SystemException {
		try {
			List<Organization> checkOrg = new ArrayList<Organization>();
			if (orgParentId != Constants.ORG_ROOT_PARENT_ID) {
				checkOrg = ListUtils.intersection(
						OrganizationUtil.findByOrgName(orgName),
						OrganizationUtil.findByorgParent(orgParentId));
			} else {
				checkOrg = OrganizationUtil.findByOrgName(orgName);
			}

			if ((checkOrg != null) && (checkOrg.size() > 0)) {
				System.out.println("OrgName is existed");
				return null;
			} else {
				Organization org = larion.progate.service.persistence.OrganizationUtil
						.create(null);
				org.setName(orgName);
				org.setAbbreviation(orgAbbr);
				org.setDescription(description);
				org.setMaxUserCount(maxUserCount);
				org.setOrgType(orgType);
				org.setOrgTypeId(getOrgTypeIdFromOrgType(orgType));
				org.setAddress1(address1);
				org.setAddress2(address2);
				org.setCity(city);
				org.setState(state);
				org.setCountry(country);
				org.setPhone(phone);
				org.setCreatedAt(createdAt);
				org.setExpiredDate(expiredOn);
				org.setOrgStatus(orgStatus);
				org.setShowLogo(true);
				org.setIsProactive(false);
				org.setIsPrivateProfile(false);
				// org.setLevelSharing(Constants.ORG_USER_STATUS_ORG_ADMIN_INVITE);
				org.setOrgParent(Constants.ORG_ROOT_PARENT_ID);
				OrganizationUtil.update(org, false);
				return org;
			}
		} catch (Exception e) {

			System.out
					.println("There are some errors in OrganizationLocalServiceImpl.createOrganizationFullInformation"
							+ e.toString());
			return null;
		}

	}

	public void deleteOrganization(int orgId) {
		try {
			OrganizationUtil.remove(orgId);
			List<Organization> listSubOrg = OrganizationUtil
					.findByorgParent(orgId);
			for (Organization organization : listSubOrg) {
				deleteOrganization(organization.getPrimaryKey());
			}
		} catch (Exception e) {

			System.out
					.println("There are some errors in OrganizationLocalServiceImpl.deleteOrganization"
							+ e.toString());
		}
	}

	@SuppressWarnings("unchecked")
	public List<Organization> getOrganizations(int start, int end)
			throws com.liferay.portal.SystemException {
		List<Organization> listOrg;
		List<Organization> result = null;
		try {
			listOrg = ListUtils.intersection(OrganizationUtil
					.findByorgParent(Constants.ORG_ROOT_PARENT_ID),
					OrganizationUtil.findAll());

			if (end > listOrg.size()) {
				result = listOrg.subList(start, listOrg.size());
			} else {
				result = listOrg.subList(start, end);
			}

			return result;
		} catch (Exception e) {
			System.out
					.println("There are some errors in OrganizationLocalServiceImpl.getOrganizations"
							+ e.toString());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Organization> getListAllSubOrganizations(int orgId)
			throws com.liferay.portal.SystemException {
		List<Organization> listOrg = new ArrayList<Organization>();
		List<Organization> result = new ArrayList<Organization>();
		try {
			listOrg.add(OrganizationUtil.findByPrimaryKey(orgId));
			result = ListUtils.subtract(OrganizationUtil.findByrootId(orgId),
					listOrg);
			return result;
		} catch (Exception e) {
			System.out
					.println("There are some errors in OrganizationLocalServiceImpl.getOrganizations"
							+ e.toString());
			return null;
		}
	}

	public int countOrganizations() throws com.liferay.portal.SystemException {

		try {
			List<Organization> result = getOrganizations(
					Constants.MIN_COUNT_ORG, Constants.MAX_COUNT_ORG);
			if (result != null) {
				return result.size();
			} else {
				return 0;
			}
		} catch (Exception e) {
			System.out
					.println("There are some errors in OrganizationLocalServiceImpl.countListOrganizations"
							+ e.toString());
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Organization> getSubOrganizations(int orgParentId, int start,
			int end) throws com.liferay.portal.SystemException {
		List<Organization> listOrg;
		List<Organization> result = null;
		try {
			listOrg = ListUtils.intersection(
					OrganizationUtil.findByorgParent(orgParentId),
					OrganizationUtil.findAll());

			if (end > listOrg.size()) {
				result = listOrg.subList(start, listOrg.size());
			} else {
				result = listOrg.subList(start, end);
			}

			return result;
		} catch (Exception e) {
			System.out
					.println("There are some errors in OrganizationLocalServiceImpl.getSubOrganizations"
							+ e.toString());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public int countSubOrganizations(int orgParentId)
			throws com.liferay.portal.SystemException {
		List<Organization> listOrg;
		List<Organization> result = null;
		try {
			listOrg = getSubOrganizations(orgParentId, Constants.MIN_COUNT_ORG,
					Constants.MAX_COUNT_ORG);

			if (listOrg != null) {
				return listOrg.size();
			} else {
				return 0;
			}

		} catch (Exception e) {
			System.out
					.println("There are some errors in OrganizationLocalServiceImpl.countSubOrganizations"
							+ e.toString());
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Organization> getRepresentOrganizations(boolean typeRepresent,
			String searchPhrase, int start, int end)
			throws com.liferay.portal.SystemException {
		List<Organization> listOrg;
		List<Organization> result = null;
		try {
			listOrg = ListUtils.intersection(OrganizationUtil
					.findByorgParent(Constants.ORG_ROOT_PARENT_ID),
					OrganizationUtil.findByisProactive(typeRepresent));

			if (searchPhrase != null) {
				listOrg = ListUtils.intersection(
						listOrg,
						searchOrgName(searchPhrase, Constants.MIN_COUNT_ORG,
								Constants.MAX_COUNT_ORG));
			}

			if (end > listOrg.size()) {
				result = listOrg.subList(start, listOrg.size());
			} else {
				result = listOrg.subList(start, end);
			}

			return result;
		} catch (Exception e) {
			System.out
					.println("There are some errors in OrganizationLocalServiceImpl.getRepresentOrganizations"
							+ e.toString());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public int countRepresentOrganizations(boolean typeRepresent,
			String searchPhrase) throws com.liferay.portal.SystemException {

		try {
			List<Organization> result = getRepresentOrganizations(
					typeRepresent, null, Constants.MIN_COUNT_ORG,
					Constants.MAX_COUNT_ORG);
			if (searchPhrase != null) {
				result = ListUtils.intersection(
						result,
						searchOrgName(searchPhrase, Constants.MIN_COUNT_ORG,
								Constants.MAX_COUNT_ORG));
			}
			if (result != null) {
				return result.size();
			} else {
				return 0;
			}
		} catch (Exception e) {
			System.out
					.println("There are some errors in OrganizationLocalServiceImpl.countRepresentOrganizations"
							+ e.toString());
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	private List<Organization> getOrganizationsPendingInvitation(long userId,
			int start, int end) throws com.liferay.portal.SystemException {
		List<Organization> listOrg = new ArrayList<Organization>();
		List<Organization> result = new ArrayList<Organization>();
		try {
			List<ProgateOrganizationParticipants> listPartByUserId, listPartByOrgId, listPartByStatus1, listPart;

			listPartByUserId = ProgateOrganizationParticipantsUtil
					.findByuserId((int) userId);
			listPartByStatus1 = ProgateOrganizationParticipantsUtil
					.findBystatus(Constants.ORG_USER_STATUS_USER_REQUEST);

			listPart = ListUtils.intersection(listPartByUserId,
					listPartByStatus1);
			listPart = ListUtils.intersection(listPart,
					ProgateOrganizationParticipantsUtil.findByisCurrent(true));

			for (ProgateOrganizationParticipants progateOrganizationParticipants : listPart) {
				int orgId = progateOrganizationParticipants.getOrgId();
				listOrg.add(OrganizationUtil.findByPrimaryKey(orgId));
			}
			result = ListUtils.intersection(
					getOrganizations(Constants.MIN_COUNT_ORG,
							Constants.MAX_COUNT_ORG), listOrg);
			if (end > listOrg.size()) {
				result = listOrg.subList(start, listOrg.size());
			} else {
				result = listOrg.subList(start, end);
			}
			return result;
		} catch (Exception e) {
			System.out
					.println("There are some errors in OrganizationLocalServiceImpl.getOrganizationsPendingInvitation: "
							+ e.toString());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	private List<Organization> getOrganizationsInviteUser(long userId,
			int start, int end) throws com.liferay.portal.SystemException {
		List<Organization> listOrg = new ArrayList<Organization>();
		List<Organization> result = new ArrayList<Organization>();
		try {
			List<ProgateOrganizationParticipants> listPartByUserId, listPartByOrgId, listPartByStatus, listPart;

			listPartByUserId = ProgateOrganizationParticipantsUtil
					.findByuserId((int) userId);
			listPartByStatus = ProgateOrganizationParticipantsUtil
					.findBystatus(Constants.ORG_USER_STATUS_ORG_ADMIN_INVITE);

			listPart = ListUtils.intersection(listPartByUserId,
					listPartByStatus);
			listPart = ListUtils.intersection(listPart,
					ProgateOrganizationParticipantsUtil.findByisCurrent(true));

			for (ProgateOrganizationParticipants progateOrganizationParticipants : listPart) {
				int orgId = progateOrganizationParticipants.getOrgId();
				listOrg.add(OrganizationUtil.findByPrimaryKey(orgId));
			}
			result = ListUtils.intersection(
					getOrganizations(Constants.MIN_COUNT_ORG,
							Constants.MAX_COUNT_ORG), listOrg);
			if (end > listOrg.size()) {
				result = listOrg.subList(start, listOrg.size());
			} else {
				result = listOrg.subList(start, end);
			}
			return result;
		} catch (Exception e) {
			System.out
					.println("There are some errors in OrganizationLocalServiceImpl.getOrganizationsInviteUser: "
							+ e.toString());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Organization> getListOrgByType(int orgParent, String orgType,
			int start, int end) {

		List<Organization> result = null;
		List<Organization> resultTemp = null;
		try {
			List<Organization> listByOrgId = OrganizationUtil
					.findByorgParent(orgParent);
			List<Organization> listByOrgType = OrganizationUtil
					.findByorgType(orgType);
			resultTemp = ListUtils.intersection(listByOrgId, listByOrgType);
			if (end > resultTemp.size()) {
				result = resultTemp.subList(start, resultTemp.size());
			} else {
				result = resultTemp.subList(start, end);
			}
		} catch (Exception e) {
			System.out
					.println("There are some errors in OrganizationLocalServiceImpl.getListOrgByType"
							+ e.toString());
			return null;
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Organization> searchOrgName(String orgName, int start, int end)
			throws com.liferay.portal.SystemException {
		List<Organization> listOrg = new ArrayList<Organization>();
		orgName = "%" + orgName.toLowerCase() + "%";
		try {
			List<OrganizationView> orgView = OrganizationViewUtil
					.findByorgNameLower(orgName, start, end);
			if (orgView != null && orgView.size() > 0) {
				for (int i = 0; i < orgView.size(); i++) {
					listOrg.add(OrganizationUtil.findByPrimaryKey(orgView
							.get(i).getPrimaryKey()));
				}
			}
			return listOrg;
		} catch (Exception e) {
			listOrg = null;
			System.out
					.println("There are some errors in OrganizationLocalServiceImpl.searchOrgName"
							+ e.toString());
		}
		return listOrg;
	}

	@SuppressWarnings("unchecked")
	public int countSearchOrgName(String orgName)
			throws com.liferay.portal.SystemException {
		int result = Constants.MIN_COUNT_ORG;
		try {
			List<Organization> data = searchOrgName(orgName,
					Constants.MIN_COUNT_ORG, Constants.MAX_COUNT_ORG);
			if (data != null) {
				result = data.size();
			}
			return result;
		} catch (Exception e) {
			result = Constants.MIN_COUNT_ORG;
			System.out
					.println("There are some errors in OrganizationLocalServiceImpl.countSearchOrgName"
							+ e.toString());
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Organization> searchOrganizations(long userId, int roleView,
			String searchPharse, int start, int end)
			throws com.liferay.portal.SystemException {
		List<Organization> listOrg = new ArrayList<Organization>();
		searchPharse = "%" + searchPharse.toLowerCase() + "%";
		try {
			List<OrganizationView> orgView = OrganizationViewUtil
					.findByorgNameLower(searchPharse, Constants.MIN_COUNT_ORG,
							Constants.MAX_COUNT_ORG);
			if (orgView != null && orgView.size() > 0) {
				for (int i = 0; i < orgView.size(); i++) {
					listOrg.add(OrganizationUtil.findByPrimaryKey(orgView
							.get(i).getPrimaryKey()));
				}
			}
			List<Organization> orgByRole = getOrganizations((int) userId,
					roleView, Constants.MIN_COUNT_ORG, Constants.MAX_COUNT_ORG);

			listOrg = ListUtils.intersection(orgByRole, listOrg);

			if (end > listOrg.size()) {
				listOrg = listOrg.subList(start, listOrg.size());
			} else {
				listOrg = listOrg.subList(start, end);
			}

			return listOrg;
		} catch (Exception e) {
			listOrg = null;
			System.out
					.println("There are some errors in OrganizationLocalServiceImpl.searchOrganizations"
							+ e.toString());
		}
		return listOrg;
	}

	@SuppressWarnings("unchecked")
	public int countsearchOrganizations(long userId, int roleView,
			String searchPharse) throws com.liferay.portal.SystemException {
		try {
			List<Organization> listOrg = searchOrganizations(userId, roleView,
					searchPharse, Constants.MIN_COUNT_ORG,
					Constants.MAX_COUNT_ORG);
			if (listOrg != null) {
				return listOrg.size();
			} else {
				return 0;
			}
		} catch (Exception e) {
			System.out
					.println("There are some errors in OrganizationLocalServiceImpl.countsearchOrganizations"
							+ e.toString());
			return 0;
		}
	}

	private int getOrgTypeIdFromOrgType(String typeName)
			throws com.liferay.portal.SystemException {
		int orgTypeId = -1;
		try {
			List<ProGateOrgType> result = ProGateOrgTypeUtil
					.findByname(typeName);
			if ((result != null) && (result.size() != 0)) {
				orgTypeId = result.get(Constants.FIRST_ELEMENT).getPrimaryKey();
			}
		} catch (Exception e) {

			System.out
					.println("There are some errors in OrganizationLocalServiceImpl.getOrgTypeIdFromOrgType"
							+ e.toString());
		}
		return orgTypeId;
	}

	public Organization getOrgObjectFromOrgId(int orgId) {

		Organization result = null;
		try {
			result = larion.progate.service.persistence.OrganizationUtil
					.findByPrimaryKey(orgId);
		} catch (Exception e) {

			System.out
					.println("There are some errors in OrganizationLocalServiceImpl.getOrgObjectFromOrgId"
							+ e.toString());
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Organization> getOrganizations(int userId, int type, int start,
			int end) {
		List<Organization> result = new ArrayList<Organization>();
		try {
			ArrayList<Integer> listTemp;
			int orgMemberRolesId = ProGateRolesLocalServiceUtil
					.getMemberOfRoleId();
			int ownerRolesId = ProGateRolesLocalServiceUtil.getOwnerRoleId();
			int adminRolesId = ProGateRolesLocalServiceUtil
					.getProGateAdminRoleId();
			int orgAdminRolesId = ProGateRolesLocalServiceUtil
					.getOrgAdminRoleId();
			List<Organization> listOrgManaged = new ArrayList<Organization>();
			List<Organization> listOrgDisable = OrganizationUtil
					.findByorgStatus(false);
			List<ProgateOrganizationParticipants> listOrgManagedRoles;
			List<Organization> listOrgMembers = new ArrayList<Organization>();
			List<ProgateOrganizationParticipants> listOrgMembersRoles;

			List<Organization> allOrgs = ListUtils.intersection(
					OrganizationUtil.findAll(), OrganizationUtil
							.findByorgParent(Constants.ORG_ROOT_PARENT_ID));
			List<ProgateOrganizationParticipants> listRoles = ProgateOrganizationParticipantsUtil
					.findByuserId(userId);
			int roleId;
			if (listRoles != null && listRoles.size() > 0) {
				roleId = listRoles.get(Constants.FIRST_ELEMENT).getRoleId();
			} else {
				roleId = -1;
			}

			Hashtable<Integer, String> listOrgs = new Hashtable<Integer, String>();

			if (adminRolesId == roleId) {
				result = allOrgs;
			} else {
				switch (type) {
				case Constants.ORG_I_AM_ADMIN: {

					List<ProgateOrganizationParticipants> listByRole = ListUtils
							.union(ProgateOrganizationParticipantsUtil
									.findByroleId(orgAdminRolesId),
									ProgateOrganizationParticipantsUtil
											.findByroleId(ownerRolesId));
					List<ProgateOrganizationParticipants> listByRoleUserId = ListUtils
							.intersection(listByRole,
									ProgateOrganizationParticipantsUtil
											.findByuserId(userId));

					List<ProgateOrganizationParticipants> listByRoleUserIdIsCurrent = ListUtils
							.intersection(listByRoleUserId,
									ProgateOrganizationParticipantsUtil
											.findByisCurrent(true));
					listOrgManagedRoles = ListUtils
							.intersection(
									listByRoleUserIdIsCurrent,
									ProgateOrganizationParticipantsUtil
											.findBystatus(Constants.ORG_USER_STATUS_USER_JOIN_ORG));

					for (ProgateOrganizationParticipants proGateParticipant : listOrgManagedRoles) {
						int orgId = proGateParticipant.getOrgId();
						Organization org = OrganizationUtil
								.findByPrimaryKey(orgId);
						if (org.getOrgParent() == 0) {
							listOrgManaged.add(org);
						}
					}

					result = ListUtils.intersection(allOrgs, listOrgManaged);

					break;
				}
				case Constants.ORG_I_AM_MEMBER: {

					List<ProgateOrganizationParticipants> listByRole = ProgateOrganizationParticipantsUtil
							.findByroleId(orgMemberRolesId);
					List<ProgateOrganizationParticipants> listByRoleUserId = ListUtils
							.intersection(listByRole,
									ProgateOrganizationParticipantsUtil
											.findByuserId(userId));

					List<ProgateOrganizationParticipants> listByRoleUserIdIsCurrent = ListUtils
							.intersection(listByRoleUserId,
									ProgateOrganizationParticipantsUtil
											.findByisCurrent(true));

					listOrgMembersRoles = ListUtils
							.intersection(
									listByRoleUserIdIsCurrent,
									ProgateOrganizationParticipantsUtil
											.findBystatus(Constants.ORG_USER_STATUS_USER_JOIN_ORG));

					for (ProgateOrganizationParticipants proGateParticipant : listOrgMembersRoles) {
						int orgId = proGateParticipant.getOrgId();
						Organization org = OrganizationUtil
								.findByPrimaryKey(orgId);
						if (org.getOrgParent() == 0) {
							listOrgMembers.add(org);
						}
					}

					result = ListUtils.intersection(allOrgs, listOrgMembers);

					break;
				}
				case Constants.ORG_OTHERS: {

					List<ProgateOrganizationParticipants> listParticipants = ListUtils
							.intersection(
									ListUtils
											.union(ProgateOrganizationParticipantsUtil
													.findBystatus(Constants.ORG_USER_STATUS_USER_REQUEST),
													ListUtils.union(
															ProgateOrganizationParticipantsUtil
																	.findBystatus(Constants.ORG_USER_STATUS_ORG_ADMIN_INVITE),
															ProgateOrganizationParticipantsUtil
																	.findBystatus(Constants.ORG_USER_STATUS_USER_JOIN_ORG))),
									ProgateOrganizationParticipantsUtil
											.findByuserId(userId));
					listParticipants = ListUtils.intersection(listParticipants,
							ProgateOrganizationParticipantsUtil
									.findByisCurrent(true));
					for (ProgateOrganizationParticipants participant : listParticipants) {
						listOrgMembers.add(OrganizationUtil
								.findByPrimaryKey(participant.getOrgId()));
					}

					result = ListUtils.subtract(allOrgs, listOrgMembers);

					break;
				}
				case Constants.ORG_INVITE_ME: {
					result = getOrganizationsInviteUser(userId,
							Constants.MIN_COUNT_USER, Constants.MAX_COUNT_USER);
					break;
				}

				case Constants.ORG_I_REQUEST_TO_JOIN: {
					result = getOrganizationsPendingInvitation(userId,
							Constants.MIN_COUNT_USER, Constants.MAX_COUNT_USER);
					break;
				}
				default: {
					System.out
							.println("There are some errors in OrganizationLocalServiceImpl.getOrganizations: wrong type value");
					break;
				}
				}
			}

			if (end > result.size()) {
				result = result.subList(start, result.size());
			} else {
				result = result.subList(start, end);
			}

			return result;
		} catch (Exception e) {
			System.out
					.println("There are some errors in OrganizationLocalServiceImpl.getOrganizations"
							+ e.toString());
			return null;
		}
	}

	public int countOrganizations(int userId, int type) {

		List<Organization> result = new ArrayList<Organization>();
		try {
			result = getOrganizations(userId, type, Constants.MIN_COUNT_ORG,
					Constants.MAX_COUNT_ORG);
			if (result != null && result.size() != 0) {
				return result.size();
			} else {
				return 0;
			}
		} catch (Exception e) {

			System.out
					.println("There are some errors in OrganizationLocalServiceImpl.countOrganizations"
							+ e.toString());
			return 0;
		}
	}

	public Organization createOrganization(long userId, String orgName,
			String orgNameAbbreviate, String description, String orgType,
			String country, String city, String telephone, String address,
			int maxUser, Date expirationDate, boolean status, int levelSharing,
			String orgEmail) {

		try {
			Organization org = createOrganizationFullInformation(
					Constants.ORG_ROOT_PARENT_ID, orgName, orgNameAbbreviate,
					description, maxUser, "", orgType, address, address, city,
					city, country, telephone, new Date(), expirationDate,
					status);
			org.setCreatedBy(userId);
			org.setUpdatedBy(userId);
			org.setRootId(org.getPrimaryKey());
			org.setBodId(Constants.ORG_ROOT_BOD_ID);
			org.setMaxLevel(1);
			org.setLevel(0);
			org.setLevelSharing(levelSharing);
			org.setEmail(orgEmail);
			OrganizationUtil.update(org, false);
			try {
				int progateAdminId = UserUtil.findByscreenname("progateadmin")
						.get(Constants.FIRST_ELEMENT).getPrimaryKey();
				ProgateOrganizationParticipantsLocalServiceUtil.addParticipant(
						progateAdminId, (int) userId, new Date(), (int) userId,
						new Date(), org.getPrimaryKey(),
						ProGateRolesLocalServiceUtil.getOrgAdminRoleId(),
						Constants.ORG_USER_STATUS_USER_JOIN_ORG, "");
			} catch (Exception e) {
				System.out.println("Errors: User progateadmin doesn't exist");
			}

			ProgateOrganizationParticipantsLocalServiceUtil.addParticipant(
					(int) userId, (int) userId, new Date(), (int) userId,
					new Date(), org.getPrimaryKey(),
					ProGateRolesLocalServiceUtil.getOwnerRoleId(),
					Constants.ORG_USER_STATUS_USER_JOIN_ORG, "");
			return org;
		} catch (Exception e) {
			System.out
					.println("There are some errors in OrganizationLocalServiceImpl.createOrganization"
							+ e.toString());
			return null;
		}
	}

	public Organization createSubOrganization(int orgParentId, long userId,
			String orgName, String orgNameAbbreviate, String description,
			String orgType, String country, String city, String telephone,
			String address, int maxUser, Date expirationDate, boolean status) {

		try {

			Organization org = createOrganizationFullInformation(orgParentId,
					orgName, orgNameAbbreviate, description, maxUser, "",
					orgType, address, address, city, city, country, telephone,
					new Date(), expirationDate, status);

			int[] listRelationOrgId = OrganizationsUtils.getListRelationOrgId(
					org.getPrimaryKey(), orgParentId);

			if (listRelationOrgId != null) {
				org.setOrgParent(listRelationOrgId[1]);
				org.setBodId(listRelationOrgId[2]);
				org.setRootId(listRelationOrgId[3]);
				org.setLevel(listRelationOrgId[4]);
			}

			org.setCreatedBy(userId);
			org.setUpdatedBy(userId);
			OrganizationUtil.update(org, false);

			Organization rootObj = OrganizationUtil
					.findByPrimaryKey(listRelationOrgId[3]);
			rootObj.setMaxLevel(OrganizationsUtils
					.getMaxLevel(listRelationOrgId[3]) + 1);
			OrganizationUtil.update(rootObj, false);

			ProgateOrganizationParticipantsLocalServiceUtil.addParticipant(
					(int) userId, (int) userId, new Date(), (int) userId,
					new Date(), org.getPrimaryKey(),
					ProGateRolesLocalServiceUtil.getManagerRoleId(),
					Constants.ORG_USER_STATUS_USER_JOIN_ORG, "");
			return org;
		} catch (Exception e) {

			System.out
					.println("There are some errors in OrganizationLocalServiceImpl.createOrganization"
							+ e.toString());
			return null;
		}
	}

	public Organization createSubOrganization(int orgParentId, long userId,
			String orgName, String orgNameAbbreviate, String description,
			String orgType, String country, String city, String telephone,
			String address, int maxUser, Date expirationDate, boolean status,
			int levelSharing, String orgEmail) {

		try {

			Organization org = createSubOrganization(orgParentId, userId,
					orgName, orgNameAbbreviate, description, orgType, country,
					city, telephone, address, maxUser, expirationDate, status);
			org.setLevelSharing(levelSharing);
			org.setEmail(orgEmail);
			OrganizationUtil.update(org, false);
			return org;
		} catch (Exception e) {

			System.out
					.println("There are some errors in OrganizationLocalServiceImpl.createOrganization"
							+ e.toString());
			return null;
		}
	}

	public List<Organization> getPathOrg(int orgId) {
		List<Organization> result = new ArrayList<Organization>();
		try {
			int i = 0;
			int orgIdTemp = orgId;
			int rootId = OrganizationUtil.findByPrimaryKey(orgId).getRootId();
			result.add(OrganizationUtil.findByPrimaryKey(orgId));
			do {
				i++;
				orgIdTemp = OrganizationsUtils.getParentOrgId(orgIdTemp);
				result.add(OrganizationUtil.findByPrimaryKey(orgIdTemp));
				if (orgIdTemp == 0 || i > 10) {
					break;
				}
			} while (orgIdTemp != rootId);
			// result.add(OrganizationUtil.findByPrimaryKey(orgId));

			Collections.reverse(result);
		} catch (Exception e) {

			System.out
					.println("There are some errors in OrganizationLocalServiceImpl.getPathOrg: "
							+ e.toString());
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<HashMap<Integer, String>> getListSubOrgsOfRootOrg(int orgId) {
		System.out.println(orgId);
		List<HashMap<Integer, String>> result = new ArrayList<HashMap<Integer, String>>();
		try {
			int rootOrgId = OrganizationUtil.findByPrimaryKey(orgId)
					.getRootId();
			System.out.println(rootOrgId);
			Organization rootOrg = OrganizationUtil.findByPrimaryKey(rootOrgId);
			List<Organization> listTemp = new ArrayList<Organization>();
			listTemp.add(rootOrg);
			List<Organization> listSubOrg = ListUtils.subtract(
					OrganizationUtil.findByrootId(rootOrgId), listTemp);
			System.out.println(listSubOrg);
			for (Organization organization : listSubOrg) {
				Organization orgParent = null;
				String orgName = organization.getName();
				String orgNameTemp = "";
				int orgIdParent = 0;
				do {
					if (orgIdParent == 0) {
						orgIdParent = organization.getOrgParent();
					}
					orgParent = OrganizationUtil.findByPrimaryKey(orgIdParent);
					orgNameTemp = orgParent.getName();
					orgName = orgNameTemp + "\\" + orgName;
					orgIdParent = orgParent.getOrgParent();
				} while (orgParent.getPrimaryKey() != rootOrgId);
				HashMap<Integer, String> data = new HashMap<Integer, String>();
				data.put(organization.getPrimaryKey(), orgName);
				result.add(data);
			}
		} catch (Exception e) {

			System.out
					.println("There are some errors in OrganizationLocalServiceImpl.getListSubOrgsOfRootOrg: "
							+ e.toString());
		}
		return result;
	}

	public List<Organization> findOrganization(int rootId)
			throws SystemException, PortalException {
		try {
			List<Organization> listOrgs = OrganizationUtil.findByrootId(rootId);
			return listOrgs;
		} catch (Exception e) {
			System.out
					.println("ERROR in OrganizationLocalServiceImpl.findOrganization "
							+ e.toString());
			return null;
		}
	}

	public List<Organization> getProjectOfPM(int rootId, int pmUId)
			throws SystemException, PortalException {
		try {
			List<Organization> listProjects = OrganizationFinderUtil
					.getProjectOfPM(rootId, pmUId);
			return listProjects;
		} catch (Exception e) {
			System.out
					.println("ERROR in OrganizationLocalServiceImpl.getProjectOfPM"
							+ e.toString());
			return null;
		}
	}

	public List<Organization> getProjectOfBOD(int rootId)
			throws SystemException, PortalException {
		try {
			List<Organization> listProjects = OrganizationFinderUtil
					.getProjectOfBOD(rootId);
			return listProjects;
		} catch (Exception e) {
			System.out
					.println("ERROR in OrganizationLocalServiceImpl.getProjectOfBOD"
							+ e.toString());
			return null;
		}
	}

	public List<Integer> getCompany() throws SystemException, PortalException {
		try {
			List<Integer> companies = new ArrayList<Integer>();
			List<Organization> organizations = OrganizationFinderUtil
					.getCompany();
			if (organizations == null)
				organizations = new ArrayList<Organization>();
			for (Organization org : organizations) {
				companies.add(org.getRootId());
			}
			return companies;
		} catch (Exception e) {
			System.out
					.println("ERROR in OrganizationLocalServiceImpl.getCompany "
							+ e.toString());
			List<Integer> listNull = new ArrayList<Integer>();
			return listNull;
		}
	}

//	public boolean createOrgNew(String name) {
//		try {
//			System.out.println("Start");
//			Organization org = OrganizationUtil.create(null);
//			org.setName(name);
//			OrganizationUtil.updateImpl(org, false);
//			System.out.println("End Org");
//			return true;
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("ERROR in createOrg " + e.toString());
//			return true;
//		}
//	}
}
