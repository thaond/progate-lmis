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
import larion.progate.model.ProGateRoles;
import larion.progate.model.ProgateOrganizationParticipants;
import larion.progate.service.base.ProGateRolesLocalServiceBaseImpl;
import larion.progate.service.persistence.OrganizationUtil;
import larion.progate.service.persistence.ProGateRolesUtil;
import larion.progate.service.persistence.ProgateOrganizationParticipantsUtil;

/**
 * <a href="ProGateRolesLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class ProGateRolesLocalServiceImpl extends
		ProGateRolesLocalServiceBaseImpl {
	
	@SuppressWarnings("unchecked")
	public String getRoleOfUserInOrg(int userId, int orgId) {
		try {
			List<ProgateOrganizationParticipants> listByOrg = ProgateOrganizationParticipantsUtil.findByorgId(orgId);
			List<ProgateOrganizationParticipants> listByUser = ProgateOrganizationParticipantsUtil.findByuserId(userId);
			List<ProgateOrganizationParticipants> listEnd = ListUtils.intersection(listByOrg, listByUser);
			if (listEnd != null && listEnd.size() > 0) {
				return ProGateRolesUtil.findByPrimaryKey(listEnd.get(0).getRoleId()).getName();
			} else {
				return "User";
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("There are some errors in ProGateRolesLocalServiceImpl.getRoleOfUserInOrg: "
							+ e.toString());
			return "";
		}
	}
	
	public int getProGateAdminRoleId() {
		try {
			return ProGateRolesUtil.findByname("Administrator").get(0)
					.getPrimaryKey();
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("There are some errors in ProGateRolesLocalServiceImpl.getProGateAdminRoleId: "
							+ e.toString());
			return -1;
		}
	}

	public int getProGateUserRoleId() {
		try {
			return ProGateRolesUtil.findByname("User").get(0).getPrimaryKey();
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("There are some errors in ProGateRolesLocalServiceImpl.getLiferayAdminRoleId: "
							+ e.toString());
			return -1;
		}
	}

	public int getOrgMemberRoleId() {
		try {
			return ProGateRolesUtil.findByname("OrgMember").get(0)
					.getPrimaryKey();
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("There are some errors in ProGateRolesLocalServiceImpl.getProGateMemberRoleId: "
							+ e.toString());
			return -1;
		}
	}

	public int getOrgAdminRoleId() {
		try {
			return ProGateRolesUtil.findByname("OrgAdmin").get(0)
					.getPrimaryKey();
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("There are some errors in ProGateRolesLocalServiceImpl.getOrgAdminRoleId: "
							+ e.toString());
			return -1;
		}
	}

	public int getGuestRoleId() {
		try {
			return ProGateRolesUtil.findByname("Guest").get(0).getPrimaryKey();
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("There are some errors in ProGateRolesLocalServiceImpl.getGuestRoleId: "
							+ e.toString());
			return -1;
		}
	}

	public int getManagerRoleId() {
		try {
			return ProGateRolesUtil.findByname("Manager").get(0)
					.getPrimaryKey();
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("There are some errors in ProGateRolesLocalServiceImpl.getManagerRoleId: "
							+ e.toString());
			return -1;
		}
	}

	public int getBodRoleId() {
		try {
			return ProGateRolesUtil.findByname("BOD").get(0).getPrimaryKey();
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("There are some errors in ProGateRolesLocalServiceImpl.getBodRoleId: "
							+ e.toString());
			return -1;
		}
	}

	public int getStaffOfRoleId() {
		try {
			return ProGateRolesUtil.findByname("Staff Of").get(0)
					.getPrimaryKey();
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("There are some errors in ProGateRolesLocalServiceImpl.getStaffOfRoleId: "
							+ e.toString());
			return -1;
		}
	}

	public int getMemberOfRoleId() {
		try {
			return ProGateRolesUtil.findByname("Member Of").get(0)
					.getPrimaryKey();
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("There are some errors in ProGateRolesLocalServiceImpl.getMemberOfRoleId: "
							+ e.toString());
			return -1;
		}
	}

	public int getOwnerRoleId() {
		try {
			return ProGateRolesUtil.findByname("Owner").get(0).getPrimaryKey();
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("There are some errors in ProGateRolesLocalServiceImpl.getOwnerRoleId: "
							+ e.toString());
			return -1;
		}
	}

	public List<ProGateRoles> getListRoles(int type) {
		try {
			return ProGateRolesUtil.findByroleType(type);
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("There are some errors in ProGateRolesLocalServiceImpl.getListRoles: "
							+ e.toString());
			return null;
		}
	}

	public List<ProGateRoles> getListRolesOfChildOrg() {
		try {
			List<ProGateRoles> result = new ArrayList<ProGateRoles>();
			List<String> listRoleOfChild = new ArrayList<String>();
			listRoleOfChild.add("Manager");
			listRoleOfChild.add("OrgAdmin");
			listRoleOfChild.add("Staff Of");

			for (String string : listRoleOfChild) {
				List<ProGateRoles> listObjectByName = ProGateRolesUtil
						.findByname(string);
				if (listObjectByName != null && listObjectByName.size() != 0) {
					result.add(listObjectByName.get(0));
				}
			}
			return result;

		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("There are some errors in ProGateRolesLocalServiceImpl.getListRolesOfChildOrg: "
							+ e.toString());
			return null;
		}

	}

	public List<ProGateRoles> getListRolesOfRootOrg() {
		try {
			List<ProGateRoles> result = new ArrayList<ProGateRoles>();
			List<String> listRoleOfRoot = new ArrayList<String>();
			listRoleOfRoot.add("Owner");
			listRoleOfRoot.add("OrgAdmin");
			listRoleOfRoot.add("Member Of");
			for (String string : listRoleOfRoot) {
				List<ProGateRoles> listObjectByName = ProGateRolesUtil
						.findByname(string);
				if (listObjectByName != null && listObjectByName.size() != 0) {
					result.add(listObjectByName.get(0));
				}
			}
			return result;

		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("There are some errors in ProGateRolesLocalServiceImpl.getListRolesOfRootOrg: "
							+ e.toString());
			return null;
		}
	}

	public List<ProGateRoles> getListRolesByOrgId(int orgId) {
		try {
			Organization org = OrganizationUtil.findByPrimaryKey(orgId);
			if (org.getRootId() == orgId) {
				return getListRolesOfRootOrg();
			} else {
				return getListRolesOfChildOrg();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out
					.println("There are some errors in ProGateRolesLocalServiceImpl.getListRolesByOrgId: "
							+ e.toString());
			return null;
		}
	}

}