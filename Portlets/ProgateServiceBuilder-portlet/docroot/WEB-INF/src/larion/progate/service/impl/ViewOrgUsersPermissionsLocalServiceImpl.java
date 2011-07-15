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

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

import larion.progate.model.ProGateOrgsUsersPermissions;
import larion.progate.model.ViewOrgUsersPermissions;
import larion.progate.model.ViewProGatePermissionsRoles;
import larion.progate.service.base.ViewOrgUsersPermissionsLocalServiceBaseImpl;
import larion.progate.service.persistence.ProGateApplicationsUtil;
import larion.progate.service.persistence.ProGateOrgsUsersPermissionsFinderUtil;
import larion.progate.service.persistence.ProGateOrgsUsersPermissionsUtil;
import larion.progate.service.persistence.ViewOrgUsersPermissionsFinderUtil;
import larion.progate.service.persistence.ViewOrgUsersPermissionsUtil;
import larion.progate.service.persistence.ViewProGatePermissionsRolesFinderUtil;
import larion.progate.service.persistence.ViewProGatePermissionsRolesUtil;
import larion.progate.service.utils.Constants;

/**
 * <a href="ViewOrgUsersPermissionsLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class ViewOrgUsersPermissionsLocalServiceImpl extends
		ViewOrgUsersPermissionsLocalServiceBaseImpl {
	public List<ViewOrgUsersPermissions> findOrgPermissions(int rootId,
			int roleId, String appName, int category) throws SystemException,
			PortalException {
		try {
			int appId = ProGateApplicationsUtil.findByname(appName).get(0)
					.getProGateApplicationsId();
			return ViewOrgUsersPermissionsFinderUtil.findOrgPermissions(rootId,
					roleId, appId, category);
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewOrgUsersPermissionsLocalServiceImpl.findOrgPermissions "
							+ e.toString());
			List<ViewOrgUsersPermissions> listNull = new ArrayList<ViewOrgUsersPermissions>();
			return listNull;
		}
	}

	public List<ViewOrgUsersPermissions> findUsersPermissions(int rootId,
			int userId, String appName, int category, int priority,
			boolean delegate) throws SystemException, PortalException {
		try {
			int appId = ProGateApplicationsUtil.findByname(appName).get(0)
					.getProGateApplicationsId();
			return ViewOrgUsersPermissionsFinderUtil.findUsersPermissions(
					rootId, userId, appId, category, priority, delegate);
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewOrgUsersPermissionsLocalServiceImpl.findUsersPermissions "
							+ e.toString());
			List<ViewOrgUsersPermissions> listNull = new ArrayList<ViewOrgUsersPermissions>();
			return listNull;
		}
	}

	public int getRoleIdByUserId(String appName, int category, int rootId,
			int orgId, int userId) throws SystemException, PortalException {
		try {
			int appId = ProGateApplicationsUtil.findByname(appName).get(0)
					.getProGateApplicationsId();
			List<ViewOrgUsersPermissions> orgUsersPermissions = ViewOrgUsersPermissionsFinderUtil
					.findRoleByUserId(appId, category, rootId, orgId, userId);
			if (orgUsersPermissions == null)
				return 0;
			else {
				// Lay role cao nhat
				for (ViewOrgUsersPermissions per : orgUsersPermissions) {
					if (per.getRoleId() == Constants.ROLE_ID_BOD)
						return Constants.ROLE_ID_BOD; // Role cua BOD
				}
				for (ViewOrgUsersPermissions per : orgUsersPermissions) {
					if (per.getRoleId() == Constants.ROLE_ID_MANAGER)
						return Constants.ROLE_ID_MANAGER; // Role cua PM
				}
				for (ViewOrgUsersPermissions per : orgUsersPermissions) {
					if (per.getRoleId() == Constants.ROLE_ID_STAFF_OF)
						return Constants.ROLE_ID_STAFF_OF; // Role cua NV
				}
				return 0;
			}
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewOrgUsersPermissionsLocalServiceImpl.getRoleIdByUserId "
							+ e.toString());
			return 0;
		}
	}

	public List<Integer> getListRoleIdByUserId(String appName, int category,
			int rootId, int orgId, int userId) throws SystemException,
			PortalException {
		try {
			List<Integer> listRoles = new ArrayList<Integer>();
			int appId = ProGateApplicationsUtil.findByname(appName).get(0)
					.getProGateApplicationsId();
			List<ViewOrgUsersPermissions> orgUsersPermissions = ViewOrgUsersPermissionsFinderUtil
					.findRoleByUserId(appId, category, rootId, orgId, userId);
			if (orgUsersPermissions != null) {
				for (ViewOrgUsersPermissions role : orgUsersPermissions) {
					listRoles.add(role.getRoleId());
				}
				return listRoles;
			}
			return listRoles;
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewOrgUsersPermissionsLocalServiceImpl.getListRoleIdByUserId "
							+ e.toString());
			List<Integer> listNull = new ArrayList<Integer>();
			return listNull;
		}
	}

	// Lay danh sach quyen cua user
	public List<ViewOrgUsersPermissions> getListPermissions(String appName,
			int category, int rootId, int orgId, int userId, boolean isRoot)
			throws SystemException, PortalException {
		try {
			int appId = ProGateApplicationsUtil.findByname(appName).get(0)
					.getProGateApplicationsId();
			return ViewOrgUsersPermissionsFinderUtil.getListPermissions(appId,
					category, rootId, orgId, userId, isRoot);
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewOrgUsersPermissionsLocalServiceImpl.getListPermissions "
							+ e.toString());
			List<ViewOrgUsersPermissions> listNull = new ArrayList<ViewOrgUsersPermissions>();
			return listNull;
		}
	}

	// Kiem tra user co quyen khong
	public boolean checkPermissions(String appName, int category, int rootId,
			int orgId, int userId, boolean isRoot, String perId)
			throws SystemException, PortalException {
		try {
			int appId = ProGateApplicationsUtil.findByname(appName).get(0)
					.getProGateApplicationsId();
			return ViewOrgUsersPermissionsFinderUtil.checkPermissions(appId,
					category, rootId, orgId, userId, isRoot, perId);
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewOrgUsersPermissionsLocalServiceImpl.checkPermissions "
							+ e.toString());
			return false;
		}
	}

	// Kiem tra quyen cua user co phai la quyen dac biet hay ko, neu ko thi lay
	// quyen theo role

	public int checkUserSpecialPermission(String appName, int category,
			int rootId, int userId, String perId) throws SystemException,
			PortalException {
		// Lay appId
		int appId = ProGateApplicationsUtil.findByname(appName).get(0)
				.getProGateApplicationsId();
		// Lay list quyen dac biet cua user do
		List<ProGateOrgsUsersPermissions> specialPer = ProGateOrgsUsersPermissionsFinderUtil
				.getSpecialPermissions(appId, category, rootId, userId, perId);

		// Tranh truong hop tra ve list quyen null
		if (specialPer == null)
			specialPer = new ArrayList<ProGateOrgsUsersPermissions>();

		// User co quyen dac biet thi specialPer se co 1 record
		if (specialPer.size() != 0)
			return 3; // 3 la quyen thuoc BOD

		// Neu ko kiem tra tiep co quyen tren role ko
		// Goi ham lay list role theo userId
		List<Integer> listRoles = getListRoleIdByUserId(appName, category,
				rootId, 0, userId);
		if (listRoles.size() != 0) {
			for (Integer role : listRoles) {
				List<ViewProGatePermissionsRoles> rolesPer = ViewProGatePermissionsRolesFinderUtil
						.getRolePermissions(appId, category, role, perId);
				if (rolesPer.size() != 0) {
					int roleId = rolesPer.get(0).getRoleId();
					if (roleId == Constants.ROLE_ID_BOD)
						return 3; // La BOD
					if (roleId == Constants.ROLE_ID_MANAGER)
						return 2;// La PM
					if (roleId == Constants.ROLE_ID_STAFF_OF)
						return 1; // La NV
				}

			}
		}
		return 0;
	}
}