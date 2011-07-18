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
import java.util.List;

import org.apache.commons.collections.ListUtils;

import larion.progate.model.Organization;
import larion.progate.model.User;
import larion.progate.model.UserInformationView;
import larion.progate.service.base.UserInformationViewLocalServiceBaseImpl;
import larion.progate.service.persistence.OrganizationUtil;
import larion.progate.service.persistence.UserInformationViewFinderUtil;
import larion.progate.service.persistence.UserInformationViewUtil;
import larion.progate.service.utils.Constants;

/**
 * <a href="UserInformationViewLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class UserInformationViewLocalServiceImpl extends
		UserInformationViewLocalServiceBaseImpl {

	@Override
	public List<UserInformationView> getMembersOfOrganization(int orgId,
			int roleId, String searchPhrase, int start, int end) {

		return getListUsersByFilter(orgId, roleId,
				Constants.ORG_USER_STATUS_USER_JOIN_ORG, searchPhrase, start,
				end);
	}

	@Override
	public int getNumberOfMembersOfOrganization(int orgId, int roleId,
			String searchPhrase) {

		List<UserInformationView> result = getMembersOfOrganization(orgId,
				roleId, searchPhrase, Constants.MIN_COUNT_USER,
				Constants.MAX_COUNT_USER);

		return (result == null ? 0 : result.size());
	}

	@Override
	public List<User> getUsersToInvite(int orgId, String searchPhrase,
			int start, int end) {

		try {
			List<User> result = UserInformationViewFinderUtil
					.findUsersToInvite(orgId, searchPhrase);

			if (end > result.size()) {
				result = result.subList(start, result.size());
			} else {
				result = result.subList(start, end);
			}

			return result;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getNumberOfUsersToInvite(int orgId, String searchPhrase) {

		List<User> result = getUsersToInvite(orgId, searchPhrase,
				Constants.MIN_COUNT_USER, Constants.MAX_COUNT_USER);

		return (result == null ? 0 : result.size());
	}

	@Override
	public List<UserInformationView> getInvitedUsers(int orgId,
			String searchPhrase, int start, int end) {

		return getListUsersByFilter(orgId, Constants.NONE_FILTER_ROLEID,
				Constants.ORG_USER_STATUS_ORG_ADMIN_INVITE, searchPhrase,
				start, end);
	}

	@Override
	public int getNumberOfInvitedUsers(int orgId, String searchPhrase) {

		List<UserInformationView> result = getInvitedUsers(orgId, searchPhrase,
				Constants.MIN_COUNT_USER, Constants.MAX_COUNT_USER);

		return (result == null ? 0 : result.size());
	}

	@Override
	public List<UserInformationView> getWaitingUsers(int orgId, int start,
			int end) {

		return getListUsersByFilter(orgId, Constants.NONE_FILTER_ROLEID,
				Constants.ORG_USER_STATUS_USER_REQUEST,
				Constants.NONE_FILTER_SEARCH, start, end);
	}

	@Override
	public int getNumberOfWaitingUsers(int orgId) {

		List<UserInformationView> result = getWaitingUsers(orgId,
				Constants.MIN_COUNT_USER, Constants.MAX_COUNT_USER);

		return (result == null ? 0 : result.size());
	}

	@Override
	public List<UserInformationView> getOldMembers(int orgId, int roleId,
			String searchPhrase, int start, int end) {

		List<UserInformationView> result = new ArrayList<UserInformationView>();

		try {
			result = UserInformationViewFinderUtil.findOldMembers(orgId,
					roleId, searchPhrase);

			if (end > result.size()) {
				result = result.subList(start, result.size());
			} else {
				result = result.subList(start, end);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = null;
		}

		return result;
	}

	@Override
	public int getNumberOfOldMembers(int orgId, int roleId, String searchPhrase) {

		List<UserInformationView> result = getOldMembers(orgId, roleId,
				searchPhrase, Constants.MIN_COUNT_USER,
				Constants.MAX_COUNT_USER);

		return (result == null ? 0 : result.size());
	}

	@Override
	public List<UserInformationView> getListUsersByFilter(int orgId,
			int roleId, int joiningStatus, String searchPhrase, int start,
			int end) {
		List<UserInformationView> result = new ArrayList<UserInformationView>();

		try {
			result = getListUsersByFilter(orgId, roleId, joiningStatus,
					searchPhrase);

			if (end > result.size()) {
				result = result.subList(start, result.size());
			} else {
				result = result.subList(start, end);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = null;
		}

		return result;
	}

	@Override
	public List<UserInformationView> getListUsersByFilter(int orgId,
			int roleId, int joiningStatus, String searchPhrase) {

		return getListUsersByFilter(orgId, roleId, joiningStatus, true,
				searchPhrase);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<UserInformationView> getListUsersByFilter(int orgId,
			int roleId, int joiningStatus, Boolean isCurrent,
			String searchPhrase) {
		List<UserInformationView> result = new ArrayList<UserInformationView>();

		try {
			System.out.println("getListUsersByFilter with orgId: " + orgId
					+ " - roleId: " + roleId + " - joiningStatus: "
					+ joiningStatus + " - searchPhrase: " + searchPhrase);

			List<UserInformationView> listDataByOrgId = UserInformationViewUtil
					.findByorgId(orgId);

			if (listDataByOrgId != null) {
				result = listDataByOrgId;
			}

			List<UserInformationView> listDataByRoleId = new ArrayList<UserInformationView>();

			if (roleId != Constants.NONE_FILTER_ROLEID) {
				listDataByRoleId = UserInformationViewUtil.findByroleId(roleId);

				if (listDataByRoleId != null) {
					result = ListUtils.intersection(result, listDataByRoleId);
				}
			}

			List<UserInformationView> listDataByJoiningStatus = new ArrayList<UserInformationView>();

			if (joiningStatus != Constants.NONE_FILTER_MEMBER_STATUS) {
				listDataByJoiningStatus = UserInformationViewUtil
						.findByjoiningStatus(joiningStatus);

				if (listDataByJoiningStatus != null) {
					result = ListUtils.intersection(result,
							listDataByJoiningStatus);
				}
			}

			if (isCurrent != null) {
				List<UserInformationView> listDataByIsCurrent = UserInformationViewUtil
						.findByisCurrent(isCurrent);

				if (listDataByIsCurrent != null) {
					result = ListUtils
							.intersection(result, listDataByIsCurrent);
				}
			}

			if (!"".equals(searchPhrase)) {

				result = ListUtils
						.intersection(
								result,
								ListUtils.union(
										UserInformationViewUtil
												.findByscreenName(searchPhrase),
										ListUtils.union(
												UserInformationViewUtil
														.findByemailAddress(searchPhrase),
												ListUtils.union(
														UserInformationViewUtil
																.findByfirstName(searchPhrase),
														UserInformationViewUtil
																.findBylastName(searchPhrase)))));
			}

			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
			result = null;
		}
		return result;
	}

	@Override
	public List<User> getListUsers(int isProactive, int status,
			String searchPhrase, int start, int end) {
		List<User> result = new ArrayList<User>();

		try {
			result = UserInformationViewFinderUtil.findListUsers(isProactive,
					status, searchPhrase);
			if (end > result.size()) {
				result = result.subList(start, result.size());
			} else {
				result = result.subList(start, end);
			}

		} catch (Exception e) {
			e.printStackTrace();
			result = null;
		}
		return result;
	}

	@Override
	public int getNumberOfListUsers(int isProactive, int status,
			String searchPhrase) {
		int result = 0;

		try {
			List<User> listUser = getListUsers(isProactive, status,
					searchPhrase, Constants.MIN_COUNT_USER,
					Constants.MAX_COUNT_USER);
			if (listUser != null) {
				result = listUser.size();
			}

		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<UserInformationView> getDetailInformationUser(int userId,
			int roleId, String searchPhrase, int start, int end) {

		try {
			List<UserInformationView> result = new ArrayList<UserInformationView>();

			result = ListUtils.intersection(
					UserInformationViewUtil.findByuserId(userId),
					UserInformationViewUtil.findByisCurrent(true));

			if (roleId != Constants.NONE_FILTER_ROLEID) {
				result = ListUtils.intersection(result,
						UserInformationViewUtil.findByroleId(roleId));
			}

			if (!"".equals(searchPhrase)) {

				result = ListUtils
						.intersection(
								result,
								ListUtils.union(
										UserInformationViewUtil
												.findByscreenName(searchPhrase),
										ListUtils.union(
												UserInformationViewUtil
														.findByemailAddress(searchPhrase),
												ListUtils.union(
														UserInformationViewUtil
																.findByfirstName(searchPhrase),
														UserInformationViewUtil
																.findBylastName(searchPhrase)))));
			}

			if (end > result.size()) {
				result = result.subList(start, result.size());
			} else {
				result = result.subList(start, end);
			}

			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getNumberOfDetailInformationUser(int userId, int roleId,
			String searchPhrase) {
		int result = 0;

		try {
			List<UserInformationView> listUser = getDetailInformationUser(
					userId, roleId, searchPhrase, Constants.MIN_COUNT_USER,
					Constants.MAX_COUNT_USER);
			if (listUser != null) {
				result = listUser.size();
			}

		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	@Override
	public boolean updateUserRole(int userId, int orgId, int oldRoleId,
			int newRoleId) {
		boolean result = true;
		//
		// try {
		// Organization org = OrganizationLocalServiceUtil
		// .getOrganization(orgId);
		//
		// User user = null;
		// int roleId = 0;
		//
		// if (org.getOrgId() == org.getRootId()) {
		// if (ProGateRolesLocalServiceUtil.getOwnerRoleId() == newRoleId) {
		//
		// user = ProGateOrgsUsersRolesLocalServiceUtil
		// .getOwnerOfOrg(orgId);
		// roleId = ProGateRolesLocalServiceUtil.getMemberOfRoleId();
		// }
		// } else {
		// if (ProGateRolesLocalServiceUtil.getManagerRoleId() == newRoleId
		// || ProGateRolesLocalServiceUtil.getBodRoleId() == newRoleId) {
		//
		// user = ProGateOrgsUsersRolesLocalServiceUtil
		// .getManagerOfOrg(orgId);
		// roleId = ProGateRolesLocalServiceUtil.getStaffOfRoleId();
		// }
		// }
		//
		// if (user != null) {
		// ProGateOrgUserRoleUtils.createOrgUserRole(orgId,
		// user.getUserid(), roleId);
		// }
		//
		// ProGateOrgUserRoleUtils.createOrgUserRole(orgId, userId, newRoleId);
		// } catch (Exception e) {
		// e.printStackTrace();
		// result = false;
		// }
		return result;
	}
	public List<UserInformationView> getRootOrgsOfUser(int userId,
			int roleId, String searchPhrase, int start, int end) {

		try {
			List<UserInformationView> result = getDetailInformationUser(userId, roleId, searchPhrase, start, end);
			List<UserInformationView> lsFinaly =null;
			
			for (UserInformationView userInformationView : result) {
				Organization org = OrganizationUtil.fetchByPrimaryKey(userInformationView.getOrgId());
				if(org.getRootId()==0){
				lsFinaly.add(userInformationView);
				}
			}			
			return lsFinaly;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}