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

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

import larion.progate.model.Organization;
import larion.progate.model.ProGateRoles;
import larion.progate.model.ProgateOrganizationParticipants;
import larion.progate.model.ProgateOrganizationsStaffs;
import larion.progate.model.User;
import larion.progate.service.base.ProgateOrganizationsStaffsLocalServiceBaseImpl;
import larion.progate.service.persistence.OrganizationUtil;
import larion.progate.service.persistence.ProGateRolesUtil;
import larion.progate.service.persistence.ProgateOrganizationParticipantsUtil;
import larion.progate.service.persistence.ProgateOrganizationsStaffsFinderUtil;
import larion.progate.service.persistence.ProgateOrganizationsStaffsUtil;
import larion.progate.service.persistence.UserFinderUtil;
import larion.progate.service.utils.Constants;

/**
 * <a href="ProgateOrganizationsStaffsLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class ProgateOrganizationsStaffsLocalServiceImpl extends
		ProgateOrganizationsStaffsLocalServiceBaseImpl {

	@SuppressWarnings("unchecked")
	public ProgateOrganizationsStaffs createStaffs(int orgId, int userId,
			int participantId, Date beginDate, Date endDate,
			String staffCode, String scanCode) throws Exception {
		try {
			// check userId, orgId, isActive = true
			List<ProgateOrganizationsStaffs> checkExistedStaff = ListUtils
					.intersection(ProgateOrganizationsStaffsUtil
							.findByorgId(orgId),
							ListUtils.intersection(
									ProgateOrganizationsStaffsUtil
											.findByisActive(true),
									ProgateOrganizationsStaffsUtil
											.findByuserId(userId)));
			if (checkExistedStaff != null && checkExistedStaff.size() != 0) {
				System.out.println("Staff existed");
				return checkExistedStaff.get(Constants.FIRST_ELEMENT);
			} else {
				Organization org = OrganizationUtil.findByPrimaryKey(orgId);
				ProgateOrganizationParticipants part = ProgateOrganizationParticipantsUtil
						.findByPrimaryKey(participantId);
				ProGateRoles roles = ProGateRolesUtil.findByPrimaryKey(part
						.getRoleId());
				ProgateOrganizationsStaffs object = ProgateOrganizationsStaffsUtil
						.create(null);
				object.setAvailability(100);
				object.setBeginTime(beginDate);
				object.setBodId(org.getBodId());
				object.setCreatedAt(new Date());
				object.setIsActive(true);
				object.setIsRemoved(false);
				object.setOrgId(orgId);
				object.setParticipantId(participantId);
				object.setPosition(roles.getName());
				object.setRootId(org.getRootId());
				object.setScannerCode(scanCode);
				object.setStaffCode(staffCode);
				object.setUserId(userId);
				object.setUpdatedAt(new Date());
				ProgateOrganizationsStaffsUtil.update(object, false);
				return object;
			}

		} catch (Exception e) {
			System.out
					.println("ERROR in ProgateOrganizationsStaffsLocalServiceImpl.createStaffs "
							+ e.toString());
			return null;
		}
	}

	public ProgateOrganizationsStaffs getStaffDetails(int orgId, int userId)
			throws SystemException, PortalException {
		try {
			List<ProgateOrganizationsStaffs> orgList = ProgateOrganizationsStaffsUtil
					.findByorgId(orgId);
			List<ProgateOrganizationsStaffs> userList = ProgateOrganizationsStaffsUtil
					.findByuserId(userId);
			@SuppressWarnings("unchecked")
			List<ProgateOrganizationsStaffs> staffDetails = ListUtils
					.intersection(orgList, userList);
			if (staffDetails.size() == 0) {
				ProgateOrganizationsStaffs tmp = createProgateOrganizationsStaffs(null);
				return tmp;
			}
			return staffDetails.get(0);
		} catch (Exception e) {
			System.out
					.println("ERROR in ProgateOrganizationsStaffsLocalServiceImpl.getStaffDetails "
							+ e.toString());

			ProgateOrganizationsStaffs tmp1 = createProgateOrganizationsStaffs(null);
			return tmp1;
		}
	}

	// Lay ra thong tin hien tai cua nhan vien
	public List<ProgateOrganizationsStaffs> getEmployeeInformations(int rootId,
			int userId) throws SystemException, PortalException {
		try {
			List<ProgateOrganizationsStaffs> listEmployeeInfo = ProgateOrganizationsStaffsFinderUtil
					.getEmployeeInformations(rootId, userId);
			if (listEmployeeInfo == null)
				listEmployeeInfo = new ArrayList<ProgateOrganizationsStaffs>();
			return listEmployeeInfo;
		} catch (Exception e) {
			System.out
					.println("ERROR in ProgateOrganizationsStaffsLocalServiceImpl.getEmployeeInformations() "
							+ e.toString());
			List<ProgateOrganizationsStaffs> listEmployee = new ArrayList<ProgateOrganizationsStaffs>();
			return listEmployee;
		}
	}

	// Lay tat ca nhan vien trong cong ty
	public List<ProgateOrganizationsStaffs> getEmployeesInCompany(int rootId,
			int orgId) throws SystemException, PortalException {
		try {
			List<ProgateOrganizationsStaffs> listRoot = ProgateOrganizationsStaffsUtil
					.findByrootId(rootId);
			List<ProgateOrganizationsStaffs> listOrg = ProgateOrganizationsStaffsUtil
					.findByorgId(orgId);
			List<ProgateOrganizationsStaffs> listEmployees = ListUtils
					.intersection(listRoot, listOrg);
			return listEmployees;
		} catch (Exception e) {
			System.out
					.println("ERROR in ProgateOrganizationsStaffsLocalServiceImpl.getEmployeesInCompany "
							+ e.toString());
			List<ProgateOrganizationsStaffs> tmp = new ArrayList<ProgateOrganizationsStaffs>();
			return tmp;
		}
	}

	// Lay nhan vien theo du an o man hinh phan quyen
	public List<ProgateOrganizationsStaffs> getEmployeesInPermissions(
			int rootId, int orgId) throws SystemException, PortalException {
		try {
			List<ProgateOrganizationsStaffs> listUsers = ProgateOrganizationsStaffsFinderUtil
					.getEmployeesInPermissions(rootId, orgId);
			if (listUsers == null)
				listUsers = new ArrayList<ProgateOrganizationsStaffs>();
			return listUsers;
		} catch (Exception e) {
			System.out
					.println("ERROR in ProgateOrganizationsStaffsLocalServiceImpl.getEmployeesInPermissions "
							+ e.toString());
			List<ProgateOrganizationsStaffs> listNull = new ArrayList<ProgateOrganizationsStaffs>();
			return listNull;
		}
	}

	// Lay danh sach BOD ung voi cong ty
	public List<Integer> getBODInCompany(int rootId) throws SystemException,
			PortalException {
		try {
			List<Integer> bods = new ArrayList<Integer>();
			List<ProgateOrganizationsStaffs> listBod = ProgateOrganizationsStaffsFinderUtil
					.getBODInCompany(rootId);
			if (listBod == null)
				listBod = new ArrayList<ProgateOrganizationsStaffs>();
			for (ProgateOrganizationsStaffs bod : listBod) {
				bods.add(bod.getUserId());
			}
			return bods;
		} catch (Exception e) {
			System.out
					.println("ERROR in ProgateOrganizationsStaffsLocalServiceImpl.getBODInCompany "
							+ e.toString());
			List<Integer> listNull = new ArrayList<Integer>();
			return listNull;
		}
	}
}