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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.time.DateUtils;

import com.liferay.ibm.icu.text.SimpleDateFormat;
import com.liferay.ibm.icu.util.Calendar;
import larion.progate.model.Organization;
import larion.progate.model.ProGateRoles;
import larion.progate.model.ProgateOrganizationParticipants;
import larion.progate.model.ProgateOrganizationsStaffs;
import larion.progate.model.User;
import larion.progate.service.OrganizationLocalServiceUtil;
import larion.progate.service.ProGateRolesLocalServiceUtil;
import larion.progate.service.ProgateOrganizationParticipantsLocalServiceUtil;
import larion.progate.service.ProgateOrganizationsStaffsLocalServiceUtil;
import larion.progate.service.UserLocalServiceUtil;
import larion.progate.service.base.ProgateOrganizationParticipantsLocalServiceBaseImpl;
import larion.progate.service.persistence.OrganizationUtil;
import larion.progate.service.persistence.ProGateRolesUtil;
import larion.progate.service.persistence.ProgateOrganizationParticipantsUtil;
import larion.progate.service.persistence.ProgateOrganizationsStaffsUtil;
import larion.progate.service.utils.Constants;

/**
 * <a
 * href="ProgateOrganizationParticipantsLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class ProgateOrganizationParticipantsLocalServiceImpl extends
		ProgateOrganizationParticipantsLocalServiceBaseImpl {

	@Override
	public boolean sendRequestToJoin(int userId, int requestUserId, int orgId,
			String reason) {

		try {
			ProgateOrganizationParticipants participant = null;

			Organization org = OrganizationUtil.findByPrimaryKey(orgId);

			if (org != null && org.getLevelSharing() == 0) {
				participant = addParticipant(userId, requestUserId, new Date(),
						requestUserId, new Date(), orgId,
						ProGateRolesLocalServiceUtil.getMemberOfRoleId(),
						Constants.ORG_USER_STATUS_USER_JOIN_ORG, reason);

			} else {
				participant = addParticipant(userId, requestUserId, new Date(),
						Constants.NONE_VALUE, new Date(), orgId,
						Constants.NONE_VALUE,
						Constants.ORG_USER_STATUS_USER_REQUEST, reason);
			}

			if (participant != null) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println("There are some errors in "
					+ this.getClass().getName() + ".sendRequestToJoin "
					+ e.toString());
			return false;
		}
	}

	@Override
	public boolean deleteMemberFromOrganization(int userId, int requestUserId,
			int approveUserId, int orgId, String reason) {

		try {
			List<Organization> orgs = OrganizationUtil.findByrootId(orgId);

			for (Organization organization : orgs) {
				leaveOrganization(userId, requestUserId, approveUserId,
						organization.getOrgId(), reason);
			}

			Organization org = OrganizationUtil.findByPrimaryKey(orgId);
			if (org != null && org.getOrgId() != org.getRootId()) {
				leaveOrganization(userId, requestUserId, approveUserId,
						org.getOrgId(), reason);
			}

			return true;

		} catch (Exception e) {
			System.out.println("There are some errors in "
					+ this.getClass().getName()
					+ ".deleteMemberFromOrganization " + e.toString());
			return false;
		}

	}

	@Override
	public boolean inviteUserToJoin(int userId, int requestUserId, int orgId,
			String reason) {

		try {
			ProgateOrganizationParticipants participant = addParticipant(
					userId, requestUserId, new Date(), Constants.NONE_VALUE,
					new Date(), orgId, Constants.NONE_VALUE,
					Constants.ORG_USER_STATUS_ORG_ADMIN_INVITE, reason);

			if (participant != null) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println("There are some errors in "
					+ this.getClass().getName() + ".inviteUserToJoin "
					+ e.toString());
			return false;
		}
	}

	@Override
	public boolean deleteUserFromInvitedUsers(int userId, int requestUserId,
			int approveUserId, int orgId, String reason) {

		return rejectTheRequest(userId, approveUserId, orgId, reason);
	}

	@Override
	public boolean acceptTheRequest(int userId, int approveUserId, int orgId,
			String reason) {

		try {
			ProgateOrganizationParticipants currentParticipant = getCurrentParticipant(
					userId, orgId);

			ProgateOrganizationParticipants participant = addParticipant(
					userId, currentParticipant.getRequestedBy(),
					currentParticipant.getRequestedAt(), approveUserId,
					new Date(), orgId,
					ProGateRolesLocalServiceUtil.getMemberOfRoleId(),
					Constants.ORG_USER_STATUS_USER_JOIN_ORG, reason);
			if (participant != null) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println("There are some errors in "
					+ this.getClass().getName() + ".acceptTheRequest "
					+ e.toString());
			return false;
		}
	}

	@Override
	public boolean rejectTheRequest(int userId, int approveUserId, int orgId,
			String reason) {

		try {
			ProgateOrganizationParticipants currentParticipant = getCurrentParticipant(
					userId, orgId);

			ProgateOrganizationParticipants participant = addParticipant(
					userId, currentParticipant.getRequestedBy(),
					currentParticipant.getRequestedAt(), approveUserId,
					new Date(), orgId, Constants.NONE_VALUE,
					Constants.ORG_USER_STATUS_REJECT_REQUEST, reason);

			if (participant != null) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println("There are some errors in "
					+ this.getClass().getName() + ".rejectTheRequest "
					+ e.toString());
			return false;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean leaveOrganization(int userId, int requestUserId,
			int approveUserId, int orgId, String reason) {

		try {
			ProgateOrganizationParticipants currentParticipant = getCurrentParticipant(
					userId, orgId);

			ProgateOrganizationParticipants participant = addParticipant(
					userId, currentParticipant.getRequestedBy(),
					currentParticipant.getRequestedAt(), approveUserId,
					new Date(), orgId, currentParticipant.getRoleId(),
					Constants.ORG_USER_STATUS_LEFT_ORG, reason);

			if (participant != null) {
				List<ProgateOrganizationsStaffs> checkExistedStaff = ListUtils
						.intersection(ProgateOrganizationsStaffsUtil
								.findByorgId(orgId), ListUtils.intersection(
								ProgateOrganizationsStaffsUtil
										.findByisActive(true),
								ProgateOrganizationsStaffsUtil
										.findByuserId(userId)));
				if (checkExistedStaff != null && checkExistedStaff.size() != 0) {
					for (ProgateOrganizationsStaffs staff : checkExistedStaff) {
						Date date = new Date();
						date = DateUtils.addHours(date, Constants.UTC_HOURS);
						// Gio lay ra bi cham 7 tieng nen phai cong them
						staff.setIsRemoved(true);
						staff.setIsActive(false);
						staff.setEndTime(date);
						ProgateOrganizationsStaffsUtil.update(staff, false);
					}

				}
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("There are some errors in "
					+ this.getClass().getName() + ".leaveOrganization "
					+ e.toString());
			return false;
		}
	}

	@Override
	public ProgateOrganizationParticipants addParticipant(int userId,
			int requestUserId, Date requestDate, int approveUserId,
			Date approveDate, int orgId, int roleId, int status, String reason)
			throws Exception {
		try {
			System.out.println("addParticipant with userId: " + userId
					+ " - requestUserId: " + requestUserId + " - requestDate: "
					+ requestDate + " - approveUserId: " + approveUserId
					+ " - approveDate: " + approveDate + " - orgId: " + orgId
					+ " - roleId: " + roleId + " - status: " + status
					+ " - reason: " + reason);

			changeStatusCurrentParticipants(userId, orgId, false);

			ProgateOrganizationParticipants object = ProgateOrganizationParticipantsUtil
					.create(null);

			object.setUserId(userId);
			object.setOrgId(orgId);

			Organization org = OrganizationUtil.findByPrimaryKey(orgId);

			object.setRootId(org.getRootId());
			object.setBodId(org.getBodId());

			if (roleId != Constants.NONE_VALUE) {
				object.setRoleId(roleId);
			} else {
				object.setRoleId(ProGateRolesLocalServiceUtil
						.getProGateUserRoleId());
			}

			if (requestUserId != Constants.NONE_VALUE) {
				object.setRequestedAt(requestDate);
				object.setRequestedBy(requestUserId);
			}

			if (approveUserId != Constants.NONE_VALUE) {
				object.setApprovedAt(approveDate);
				object.setApprovedBy(approveUserId);
			}

			object.setRequestedReason(reason);
			object.setStatus(status);
			object.setIsCurrent(true);

			ProgateOrganizationParticipantsUtil.update(object);

			addToStaff(userId, orgId, object.getPrimaryKey());

			System.out.println("new participant with keyId: "
					+ object.getPrimaryKey() + " - userId: "
					+ object.getUserId() + " - requestUserId: "
					+ object.getRequestedBy() + " - requestDate: "
					+ object.getRequestedAt() + " - approveUserId: "
					+ object.getApprovedBy() + " - approveDate: "
					+ object.getApprovedAt() + " - orgId: " + object.getOrgId()
					+ " - roleId: " + object.getRoleId() + " - status: "
					+ object.getStatus() + " - reason: "
					+ object.getRequestedReason() + " - isCurrent: "
					+ object.getIsCurrent());

			return object;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("There are some errors in "
					+ this.getClass().getName() + ".addParticipant "
					+ e.toString());
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public void addToStaff(int userId, int orgId, int participantId)
			throws Exception {
		try {
			Organization org = OrganizationUtil.findByPrimaryKey(orgId);
			if (org != null && org.getRootId() != orgId) {
				// Calendar cal = Calendar.getInstance();
				// int year = cal.get(Calendar.YEAR) + 10;
				// int month = cal.get(Calendar.MONTH);
				// int day = cal.get(Calendar.DATE);
				// String date = year + "/" + month + "/" + day;
				Date endDate = null;
				// SimpleDateFormat formatter = new
				// SimpleDateFormat("yyyy/MM/dd");
				// endDate = formatter.parse(date);
				List<ProgateOrganizationsStaffs> listOrg = ProgateOrganizationsStaffsUtil
						.findByorgId(orgId);
				List<ProgateOrganizationsStaffs> listUser = ProgateOrganizationsStaffsUtil
						.findByuserId(userId);
				List<ProgateOrganizationsStaffs> listStaff = ListUtils
						.intersection(listOrg, listUser);
				if (listStaff.size() != 0) {
					for (ProgateOrganizationsStaffs staff : listStaff) {
						Date beginTime = new Date();
						beginTime = DateUtils.addHours(beginTime,
								Constants.UTC_HOURS);
						// Gio lay ra bi cham 7 tieng nen phai cong them
						staff.setIsRemoved(false);
						staff.setIsActive(true);
						staff.setBeginTime(beginTime);
						staff.setEndTime(endDate);
						staff.setParticipantId(participantId);
						ProgateOrganizationsStaffsUtil.update(staff, false);
					}
				} else
					ProgateOrganizationsStaffsLocalServiceUtil.createStaffs(
							orgId, userId, participantId, new Date(), endDate,
							"", "");

				System.out.println("======================");
				System.out.println("orgId: " + orgId);
				System.out.println("userId: " + userId);
				System.out.println("participantId: " + participantId);
				// System.out.println("endDate: " + endDate);
				System.out.println("======================");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("There are some errors in "
							+ this.getClass().getName() + ".addToStaff "
							+ e.toString());
		}

	}

	@Override
	@SuppressWarnings("unchecked")
	public void changeStatusCurrentParticipants(int userId, int orgId,
			boolean isCurrent) throws Exception {

		List<ProgateOrganizationParticipants> listByOrg = ProgateOrganizationParticipantsUtil
				.findByorgId(orgId);
		List<ProgateOrganizationParticipants> listByUser = ProgateOrganizationParticipantsUtil
				.findByuserId(userId);

		List<ProgateOrganizationParticipants> listIntersect = ListUtils
				.intersection(listByOrg, listByUser);

		for (ProgateOrganizationParticipants participant : listIntersect) {
			participant.setIsCurrent(isCurrent);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public ProgateOrganizationParticipants getCurrentParticipant(int userId,
			int orgId) throws Exception {

		ProgateOrganizationParticipants object = null;

		List<ProgateOrganizationParticipants> listByOrg = ProgateOrganizationParticipantsUtil
				.findByorgId(orgId);

		List<ProgateOrganizationParticipants> listByUser = ProgateOrganizationParticipantsUtil
				.findByuserId(userId);

		List<ProgateOrganizationParticipants> listByIsCurrent = ProgateOrganizationParticipantsUtil
				.findByisCurrent(true);

		List<ProgateOrganizationParticipants> listIntersect = ListUtils
				.intersection(listByOrg,
						ListUtils.intersection(listByUser, listByIsCurrent));

		if (listIntersect != null && listIntersect.size() > 0) {
			object = listIntersect.get(0);
		}

		return object;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ProGateRoles> getRolesOfUserInOrg(int userId, int orgId) {

		try {
			List<ProGateRoles> rolesOfUserInOrg = new ArrayList<ProGateRoles>();

			List<ProgateOrganizationParticipants> participants = ListUtils
					.intersection(ProgateOrganizationParticipantsUtil
							.findByorgId(orgId), ListUtils.intersection(
							ProgateOrganizationParticipantsUtil
									.findByuserId(userId),
							ProgateOrganizationParticipantsUtil
									.findByisCurrent(true)));

			for (ProgateOrganizationParticipants participant : participants) {
				rolesOfUserInOrg.add(ProGateRolesUtil
						.findByPrimaryKey(participant.getRoleId()));
			}

			return rolesOfUserInOrg;
		} catch (Exception e) {
			System.out.println("There are some errors in "
					+ this.getClass().getName() + ".getRolesOfUserInOrg "
					+ e.toString());
			return null;
		}
	}

	public boolean decentralizeRoleOfUserInOrg(int userId, int orgId, int roleId) {

		try {

			Organization org = OrganizationLocalServiceUtil
					.getOrganization(orgId);

			/*
			 * When user is set to manager role, check whether the organization
			 * is level 1 or not by comparing bodId to primaryKey, if yes set
			 * user's role to BOD role
			 */

			if (ProGateRolesLocalServiceUtil.getManagerRoleId() == roleId) {
				if (org.getBodId() == org.getPrimaryKey()) {
					roleId = ProGateRolesLocalServiceUtil.getBodRoleId(); // BOD_ROLE
				}
			}

			User user = null;
			int changedRoleId = 1;

			if (org.getOrgId() == org.getRootId()) {
				if (ProGateRolesLocalServiceUtil.getOwnerRoleId() == roleId) {

					user = getOwnerOfOrganizaton(orgId);
					changedRoleId = ProGateRolesLocalServiceUtil
							.getMemberOfRoleId();
				}
			} else {
				if (ProGateRolesLocalServiceUtil.getManagerRoleId() == roleId
						|| ProGateRolesLocalServiceUtil.getBodRoleId() == roleId) {

					user = getManagerOfOrganizaton(orgId);
					changedRoleId = ProGateRolesLocalServiceUtil
							.getStaffOfRoleId();
				}
			}

			if (user != null) {
				setRoleOfUserInOrg(user.getUserid(), orgId, changedRoleId);
			}

			setRoleOfUserInOrg(userId, orgId, roleId);

			return true;

		} catch (Exception e) {
			System.out.println("There are some errors in "
					+ this.getClass().getName()
					+ ".decentralizeRoleOfUserInOrg " + e.toString());
			return false;
		}
	}

	@Override
	public boolean setRoleOfUserInOrg(int userId, int orgId, int roleId) {

		try {
			ProgateOrganizationParticipants currentParticipant = getCurrentParticipant(
					userId, orgId);

			ProgateOrganizationParticipants participant = addParticipant(
					userId, currentParticipant.getRequestedBy(),
					currentParticipant.getRequestedAt(),
					currentParticipant.getApprovedBy(),
					currentParticipant.getApprovedAt(), orgId, roleId,
					currentParticipant.getStatus(), "Change Role");

			if (participant != null) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println("There are some errors in "
					+ this.getClass().getName() + ".setRoleOfUserInOrg "
					+ e.toString());
			return false;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> getUsersWithSpecificRoleInOrganization(int roleId,
			int orgId) {

		try {
			List<User> users = new ArrayList<User>();

			List<ProgateOrganizationParticipants> participants = ListUtils
					.intersection(ProgateOrganizationParticipantsUtil
							.findByorgId(orgId), ListUtils.intersection(
							ProgateOrganizationParticipantsUtil
									.findByroleId(roleId),
							ProgateOrganizationParticipantsUtil
									.findByisCurrent(true)));

			for (ProgateOrganizationParticipants participant : participants) {
				users.add(UserLocalServiceUtil.getUser(participant.getUserId()));
			}

			return users;
		} catch (Exception e) {
			System.out
					.println("There are some errors in "
							+ this.getClass().getName()
							+ ".getUsersWithSpecificRoleInOrganization "
							+ e.toString());
			return null;
		}
	}

	@Override
	public User getOwnerOfOrganizaton(int orgId) {

		List<User> users = getUsersWithSpecificRoleInOrganization(
				ProGateRolesLocalServiceUtil.getOwnerRoleId(), orgId);

		if (users != null && users.size() > 0) {
			return users.get(0);
		}

		return null;
	}

	@Override
	public User getManagerOfOrganizaton(int orgId) {

		List<User> users = getUsersWithSpecificRoleInOrganization(
				ProGateRolesLocalServiceUtil.getManagerRoleId(), orgId);

		if (users != null && users.size() > 0) 
		{
			return users.get(0);
		} 
		else {
			List<User> listUser = getUsersWithSpecificRoleInOrganization(
					ProGateRolesLocalServiceUtil.getBodRoleId(), orgId);
			if (listUser != null && listUser.size() > 0) {
				return listUser.get(0);
			} 
			else 
			{
				return null;
			}
		}
	}
	public User getAdminOfOrganizaton(int orgId) {

		List<User> users = getUsersWithSpecificRoleInOrganization(
				ProGateRolesLocalServiceUtil.getOrgAdminRoleId(), orgId);

		if (users != null && users.size() > 0) {
			return users.get(0);
		}

		return null;
	}

	public boolean isAdminOfOrganization(int userId, int orgId) {

		try {

			Organization org = OrganizationLocalServiceUtil
					.getOrganization(orgId);

			User user = getOwnerOfOrganizaton(org.getRootId());

			if (user != null) {
				if (user.getUserid() == userId) {
					return true;
				}
			}

			user = getAdminOfOrganizaton(org.getRootId());

			if (user != null) {
				if (user.getUserid() == userId) {
					return true;
				}
			}

			user = getManagerOfOrganizaton(orgId);

			if (user != null) {
				if (user.getUserid() == userId) {
					return true;
				}
			}

			user = getAdminOfOrganizaton(orgId);

			if (user != null) {
				if (user.getUserid() == userId) {
					return true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ProgateOrganizationParticipants getProgateOrganizationParticipantsObjectByUserIdAndOrgId(
			int userId, int orgId) {
		try {
			List<ProgateOrganizationParticipants> listByOrg = ProgateOrganizationParticipantsUtil
					.findByorgId(orgId);
			List<ProgateOrganizationParticipants> listByUser = ProgateOrganizationParticipantsUtil
					.findByuserId(userId);
			List<ProgateOrganizationParticipants> listEnd = ListUtils
					.intersection(listByOrg, listByUser);

			if (listEnd != null && listEnd.size() > 0) {
				return listEnd.get(0);
			} else {
				return null;
			}

		} catch (Exception e) {
			return null;
		}
	}

	/*
	 * This function is used to add a user into an organization based on status
	 * ( add/update a record in progate_organization_participants ) Values of
	 * status are: 0: leave 1: request 2: invite 3: accepted 4: rejected
	 */

	@Override
	public ProgateOrganizationParticipants joinOrganization(long userId,
			int orgId, long requestBy, String reason, int status) {

		ProgateOrganizationParticipants object = null;
		System.out.println("ProgateOrganizationParticipants joinOrganization");
		System.out.println("userId: " + userId + " - orgId: " + orgId
				+ " - requestBy: " + requestBy + " - reason: " + reason
				+ " - status: " + status);

		try {
			Organization org = OrganizationUtil.findByPrimaryKey(orgId);
			if (org != null) {
				if (checkingExistedParticipan(userId, orgId) != null) {
					object = checkingExistedParticipan(userId, orgId);
				} else {
					object = ProgateOrganizationParticipantsUtil.create(null);
					object.setOrgId(orgId);
					object.setUserId((int) userId);
				}

				object.setRequestedAt(new Date());
				object.setRequestedBy((int) requestBy);
				object.setRequestedReason(reason);
				object.setStatus(status);

				ProgateOrganizationParticipantsUtil.update(object, false);

				int roleOfUser = (org.getOrgId() == org.getRootId()) ? ProGateRolesLocalServiceUtil
						.getMemberOfRoleId() : ProGateRolesLocalServiceUtil
						.getStaffOfRoleId();

			}

			return object;
		} catch (Exception e) {
			System.out
					.println("There are some errors in ProgateOrganizationParticipantsLocalServiceImpl.joinOrganization"
							+ e.toString());
			return null;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean appoveRejectJoinOrgRequest(int userId, int orgId,
			long approvedBy, int status, String reason) {

		try {
			List<ProgateOrganizationParticipants> listObj = ListUtils
					.intersection(ProgateOrganizationParticipantsUtil
							.findByuserId(userId),
							ProgateOrganizationParticipantsUtil
									.findByorgId(orgId));

			for (ProgateOrganizationParticipants progateOrganizationParticipants : listObj) {

				progateOrganizationParticipants.setApprovedAt(new Date());
				progateOrganizationParticipants.setApprovedBy((int) approvedBy);
				progateOrganizationParticipants.setApprovedReason(reason);
				progateOrganizationParticipants.setStatus(status);

				ProgateOrganizationParticipantsUtil.update(
						progateOrganizationParticipants, false);

			}
			return true;
		} catch (Exception e) {
			System.out
					.println("There are some errors in ProgateOrganizationParticipantsLocalServiceImpl.appoveRejectJoinOrgRequest: "
							+ e.toString());
			return false;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean deleteJoinOrgRequest(int userId) {

		try {
			List<ProgateOrganizationParticipants> listObj = ListUtils
					.intersection(
							ProgateOrganizationParticipantsUtil
									.findByuserId(userId),
							ProgateOrganizationParticipantsUtil
									.findBystatus(Constants.ORG_USER_STATUS_ORG_ADMIN_INVITE));
			for (ProgateOrganizationParticipants progateOrganizationParticipants : listObj) {
				ProgateOrganizationParticipantsUtil
						.remove(progateOrganizationParticipants);
			}
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("There are some errors in ProgateOrganizationParticipantsLocalServiceImpl.appoveRejectJoinOrgRequest: "
							+ e.toString());
			return false;
		}
	}

	@Override
	public void leaveOrganization(long userId, int orgId, long approvedtBy,
			String reason) {

		try {

			List<Organization> orgList = OrganizationUtil.findByrootId(orgId);

			for (Organization organization : orgList) {
				ProgateOrganizationParticipants userInfo = checkingExistedParticipan(
						userId, organization.getOrgId());

				if (userInfo != null) {

					System.out.println("user: " + userId
							+ " leaveOrganization org: " + orgId);

					userInfo.setApprovedAt(new Date());
					userInfo.setApprovedBy((int) (userId != approvedtBy ? approvedtBy
							: userId));
					userInfo.setRequestedAt(new Date());
					userInfo.setRequestedBy((int) (userId != approvedtBy ? approvedtBy
							: userId));
					userInfo.setApprovedReason(reason);
					userInfo.setStatus(Constants.ORG_USER_STATUS_LEFT_ORG);

					ProgateOrganizationParticipantsUtil.update(userInfo, false);

				} else {
					System.out
							.println("Can't find any user's information in this org");
				}
			}
		} catch (Exception e) {
			System.out
					.println("There are some errors in ProgateOrganizationParticipantsLocalServiceImpl.leaveOrganization"
							+ e.toString());
		}
	}

	private int checkingPendingRequest(long userId, int orgId) {
		try {
			List<ProgateOrganizationParticipants> listOrgByOrgId = ProgateOrganizationParticipantsUtil
					.findByorgId(orgId);
			List<ProgateOrganizationParticipants> listOrgByUserId = ProgateOrganizationParticipantsUtil
					.findByuserId((int) userId);
			List<ProgateOrganizationParticipants> listOrgByStatus1 = ProgateOrganizationParticipantsUtil
					.findBystatus(Constants.ORG_USER_STATUS_USER_REQUEST);
			List<ProgateOrganizationParticipants> listOrgByStatus2 = ProgateOrganizationParticipantsUtil
					.findBystatus(Constants.ORG_USER_STATUS_ORG_ADMIN_INVITE);
			List<ProgateOrganizationParticipants> listOrgByStatus3 = ProgateOrganizationParticipantsUtil
					.findBystatus(Constants.ORG_USER_STATUS_USER_JOIN_ORG);
			@SuppressWarnings("unchecked")
			List<ProgateOrganizationParticipants> checkPendingRequest = ListUtils
					.intersection(listOrgByUserId, ListUtils.intersection(
							listOrgByOrgId, ListUtils.union(listOrgByStatus1,
									ListUtils.union(listOrgByStatus2,
											listOrgByStatus3))));
			if (checkPendingRequest != null && checkPendingRequest.size() > 0) {
				return checkPendingRequest.get(Constants.FIRST_ELEMENT)
						.getPrimaryKey();
			} else {
				return Constants.USER_NOT_HAVE_PARTICIPANT_INFO;
			}

		} catch (Exception e) {
			System.out
					.println("There are some errors in ProgateOrganizationParticipantsLocalServiceImpl.checkingPendingRequest"
							+ e.toString());
			return -1;
		}
	}

	@SuppressWarnings("unchecked")
	private ProgateOrganizationParticipants checkingExistedParticipan(
			long userId, int orgId) {
		try {
			List<ProgateOrganizationParticipants> checkPendingRequest = ListUtils
					.intersection(ProgateOrganizationParticipantsUtil
							.findByorgId(orgId),
							ProgateOrganizationParticipantsUtil
									.findByuserId((int) userId));

			if (checkPendingRequest != null && checkPendingRequest.size() > 0) {
				return checkPendingRequest.get(Constants.FIRST_ELEMENT);
			} else {
				return null;
			}

		} catch (Exception e) {
			System.out
					.println("There are some errors in ProgateOrganizationParticipantsLocalServiceImpl.checkingExistedParticipan"
							+ e.toString());
			return null;
		}
	}

	@Override
	public boolean isPendingRequest(long userId, int orgId) {

		int requestId = checkingPendingRequest(userId, orgId);
		if (requestId > Constants.USER_NOT_HAVE_PARTICIPANT_INFO) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public void removeParticipantsFromOrganization(long userId, int orgId,
			int memberStatus) {

		try {
			List<ProgateOrganizationParticipants> listParticipantsByOrgId = ProgateOrganizationParticipantsUtil
					.findByorgId(orgId);

			List<ProgateOrganizationParticipants> listParticipantsByUserId = ProgateOrganizationParticipantsUtil
					.findByuserId((int) userId);

			List<ProgateOrganizationParticipants> listParticipantsByStatus = ProgateOrganizationParticipantsUtil
					.findBystatus(memberStatus);

			List<ProgateOrganizationParticipants> listParticipantsInterseced = ListUtils
					.intersection(listParticipantsByOrgId,
							listParticipantsByUserId);

			List<ProgateOrganizationParticipants> listParticipants = ListUtils
					.intersection(listParticipantsInterseced,
							listParticipantsByStatus);

			for (ProgateOrganizationParticipants progateOrganizationParticipants : listParticipants) {
				ProgateOrganizationParticipantsUtil
						.remove(progateOrganizationParticipants);
			}

		} catch (Exception e) {
			System.out.println("There are some errors in "
					+ this.getClass().getName()
					+ ".removeParticipantsFromOrganization " + e.toString());
		}
	}

	@Override
	public void deleteParticipantsFromOrganization(int userId, int orgId) {
		try {
			List<Organization> orgList = OrganizationUtil.findByrootId(orgId);

			if (orgList != null && orgList.size() != 0) {
				for (Organization organization : orgList) {

					ProgateOrganizationParticipants participant = getProgateOrganizationParticipantsObjectByUserIdAndOrgId(
							userId, organization.getOrgId());

					if (participant != null) {
						ProgateOrganizationParticipantsLocalServiceUtil
								.deleteProgateOrganizationParticipants(participant);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("There are some errors in "
					+ this.getClass().getName()
					+ ".deleteParticipantsFromOrganization " + e.toString());
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<String> getUserRoles(long userId, int orgId) {
		try {
			List<String> result = new ArrayList<String>();
			List<ProgateOrganizationParticipants> listByPart = ListUtils
					.intersection(ProgateOrganizationParticipantsUtil
							.findByorgId(orgId),
							ProgateOrganizationParticipantsUtil
									.findByuserId((int) userId));
			for (ProgateOrganizationParticipants progateOrganizationParticipants : listByPart) {
				result.add(ProGateRolesUtil.findByPrimaryKey(
						progateOrganizationParticipants.getRoleId()).getName());
			}

			return result;
		} catch (Exception e) {
			System.out.println("There are some errors in "
					+ this.getClass().getName() + ".getUserRoles "
					+ e.toString());
			return new ArrayList<String>();
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<String> getUserRoles(long userId) {
		try {
			List<String> result = new ArrayList<String>();
			List<ProgateOrganizationParticipants> listByPart = ProgateOrganizationParticipantsUtil
					.findByuserId((int) userId);
			for (ProgateOrganizationParticipants progateOrganizationParticipants : listByPart) {
				result.add(ProGateRolesUtil.findByPrimaryKey(
						progateOrganizationParticipants.getRoleId()).getName());
			}
			return result;
		} catch (Exception e) {
			System.out.println("There are some errors in "
					+ this.getClass().getName() + ".getUserRoles "
					+ e.toString());
			return new ArrayList<String>();
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ProGateRoles> getUserRolesId(long userId, int orgId) {
		try {
			List<ProGateRoles> result = new ArrayList<ProGateRoles>();
			List<ProgateOrganizationParticipants> listByPart = ListUtils
					.intersection(ProgateOrganizationParticipantsUtil
							.findByorgId(orgId),
							ProgateOrganizationParticipantsUtil
									.findByuserId((int) userId));
			for (ProgateOrganizationParticipants progateOrganizationParticipants : listByPart) {
				result.add(ProGateRolesUtil
						.findByPrimaryKey(progateOrganizationParticipants
								.getRoleId()));
			}
			return result;
		} catch (Exception e) {
			System.out.println("There are some errors in "
					+ this.getClass().getName() + ".getUserRolesId "
					+ e.toString());
			return new ArrayList<ProGateRoles>();
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public ProgateOrganizationParticipants createRoleMemberWithoutOrg(
			long userId) {
		try {
			ProgateOrganizationParticipants obj = addParticipant((int) userId,
					(int) userId, new Date(), (int) userId, new Date(), 0,
					ProGateRolesLocalServiceUtil.getOrgMemberRoleId(), 3, "");
			return obj;
		} catch (Exception e) {
			System.out.println("There are some errors in "
					+ this.getClass().getName()
					+ ".createRoleMemberWithoutOrg " + e.toString());
			return null;
		}
	}

}