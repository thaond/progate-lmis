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

package larion.progate.cds.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.ListUtils;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

import larion.progate.cds.model.ViewEmployeesInProjects;
import larion.progate.cds.service.base.ViewEmployeesInProjectsLocalServiceBaseImpl;
import larion.progate.cds.service.persistence.ViewEmployeesInProjectsFinderUtil;
import larion.progate.cds.service.persistence.ViewEmployeesInProjectsUtil;

/**
 * <a href="ViewEmployeesInProjectsLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class ViewEmployeesInProjectsLocalServiceImpl extends
		ViewEmployeesInProjectsLocalServiceBaseImpl {
	// Lay danh sach nhan vien do PM phe duyet
	public List<ViewEmployeesInProjects> getEmployees(int periodId, int orgId,
			int ratingStatusPm, int pmUid) throws SystemException,
			PortalException {
		try {
			List<ViewEmployeesInProjects> employeesList = ViewEmployeesInProjectsFinderUtil
					.getEmployees(periodId, orgId, ratingStatusPm, pmUid);
			return employeesList;
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewEmployeesInProjectsLocalServiceImpl.getEmployees "
							+ e.toString());
			return null;
		}
	}

	// Kiem tra nhan vien thuoc du an nao trc
	public int checkEmployee(int periodId, int userId) throws SystemException,
			PortalException {
		try {
			// Lay employee dau tien
			List<ViewEmployeesInProjects> listEmployees = ViewEmployeesInProjectsFinderUtil
					.checkEmployeeInOrg(periodId, userId);
			ViewEmployeesInProjects firstEmployee = listEmployees.get(0);
			// Gan min cho begin time de so sanh
			Date min = firstEmployee.getBeginTime();
			// Khoi tao orgId dau tien
			int orgId = firstEmployee.getOrgId();

			// Kiem tra co bao nhieu nhan vien lam trong 2 du an

			// Nhan vien lam 1 du an
			if (listEmployees.size() == 1)
				return orgId;
			else {
				// Nhan vien lam 2 du an
				for (int i = 1; i < listEmployees.size(); i++) {
					ViewEmployeesInProjects nextEmployee = listEmployees.get(i);
					if (nextEmployee.getBeginTime().compareTo(min) <= 0) {
						min = nextEmployee.getBeginTime();
						orgId = nextEmployee.getOrgId();
					}
				}
				return orgId;
			}
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewEmployeesInProjectsLocalServiceImpl.checkEmployee"
							+ e.toString());
			return 0;
		}
	}

	// Lay danh sach nhan vien + PM de BOD phe duyet ca nhan
	public List<ViewEmployeesInProjects> getEmployeesBOD(int periodId,
			int orgId, int ratingStatusBod, int rootId) throws SystemException,
			PortalException {
		try {
			List<ViewEmployeesInProjects> employeesList = ViewEmployeesInProjectsFinderUtil
					.getEmployeesBOD(periodId, orgId, ratingStatusBod, rootId);
			return employeesList;
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewEmployeesInProjectsLocalServiceImpl.getEmployeesBOD "
							+ e.toString());
			return null;
		}
	}

	// Lay danh sach nhan vien + PM de BOD phe duyet toan bo
	public List<ViewEmployeesInProjects> getAllEmplApprovalBOD(int periodId,
			int orgId, int ratingStatusBod, int rootId) throws SystemException,
			PortalException {
		try {
			List<ViewEmployeesInProjects> employeesList = ViewEmployeesInProjectsFinderUtil
					.getAllEmplApprovalBOD(periodId, orgId, ratingStatusBod,
							rootId);
			return employeesList;
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewEmployeesInProjectsLocalServiceImpl.getAllEmplApprovalBOD "
							+ e.toString());
			return null;
		}
	}

	public List<ViewEmployeesInProjects> getEmployeeReportDetails(int rootId,
			int userId, int periodId) throws SystemException, PortalException {
		try {
			if (periodId == 0) {
				List<ViewEmployeesInProjects> listAll = ViewEmployeesInProjectsFinderUtil
						.getStaffReport(rootId, userId);
				if (listAll == null)
					listAll = new ArrayList<ViewEmployeesInProjects>();
				return listAll;
			} else {
				List<ViewEmployeesInProjects> listDetail = ViewEmployeesInProjectsFinderUtil
						.getLevelMappingReport(rootId, userId, periodId);
				if (listDetail == null)
					listDetail = new ArrayList<ViewEmployeesInProjects>();
				return listDetail;
			}
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewEmployeesInProjectsLocalServiceImpl.getEmployeeReportDetail() "
							+ e.toString());
			List<ViewEmployeesInProjects> listtmp = new ArrayList<ViewEmployeesInProjects>();
			return listtmp;
		}
	}

	public List<ViewEmployeesInProjects> getEmployeeDetailsCDP(int rootId,
			int userId, int periodId) throws SystemException, PortalException {
		try {
			List<ViewEmployeesInProjects> listAll = ViewEmployeesInProjectsFinderUtil
					.getEmployeeInformationCDP(rootId, userId, periodId);
			if (listAll == null)
				listAll = new ArrayList<ViewEmployeesInProjects>();
			return listAll;
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewEmployeesInProjectsLocalServiceImpl.getEmployeeDetailsCDP() "
							+ e.toString());
			List<ViewEmployeesInProjects> listtmp = new ArrayList<ViewEmployeesInProjects>();
			return listtmp;
		}
	}

	// ------------------------------------------------------------------------------------------
	// Bao cao thong ke tinh trang Cds cua nhan vien
	public List<ViewEmployeesInProjects> getEmployeeStateReport(int userType,
			int rootId, int orgId, int userId, int periodId)
			throws SystemException, PortalException {
		try {
			List<ViewEmployeesInProjects> list = new ArrayList<ViewEmployeesInProjects>();
			// PM
			if (userType == 1) { // Tat ca Org
				if (orgId == 0)
					list = ViewEmployeesInProjectsFinderUtil
							.getEmployeeStateReportInAllOrgOfPM(userId,
									periodId);
				// Theo tung Org
				else
					list = ViewEmployeesInProjectsFinderUtil
							.getEmployeeStateReportInOrgOfPMAndBOD(userId,
									periodId, orgId);
			}
			// BOD
			else { // Tat ca Org
				if (orgId == 0)
					list = ViewEmployeesInProjectsFinderUtil
							.getEmployeeStateReportInAllOrgOfBOD(rootId,
									userId, periodId);
				// Theo tung Org
				else
					list = ViewEmployeesInProjectsFinderUtil
							.getEmployeeStateReportInOrgOfPMAndBOD(userId,
									periodId, orgId);
			}
			// Kiem tra list lay ra co null khong
			if (list == null)
				list = new ArrayList<ViewEmployeesInProjects>();
			return list;
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewEmployeesInProjectsLocalServiceImpl.getEmployeeStateReport() "
							+ e.toString());
			List<ViewEmployeesInProjects> listtmp = new ArrayList<ViewEmployeesInProjects>();
			return listtmp;
		}
	}

	// Lay danh sach nhan vien cua PM trong Cdp
	public List<ViewEmployeesInProjects> getEmployeesCdp(int periodId,
			int orgId, int pmUid) throws SystemException, PortalException {
		try {
			List<ViewEmployeesInProjects> employeesList = ViewEmployeesInProjectsFinderUtil
					.getEmployeesCdp(periodId, orgId, pmUid);
			return employeesList;
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewEmployeesInProjectsLocalServiceImpl.getEmployeesCdp "
							+ e.toString());
			return null;
		}
	}
	
	//Lay danh sach nhan vien + PM cua BOD trong Cdp
	public List<ViewEmployeesInProjects> getEmployeesCdpBOD(int periodId,
			int orgId, int rootId) throws SystemException,
			PortalException {
		try {
			List<ViewEmployeesInProjects> employeesList = ViewEmployeesInProjectsFinderUtil
					.getEmployeesCdpBOD(periodId, orgId, rootId);
			return employeesList;
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewEmployeesInProjectsLocalServiceImpl.getEmployeesCdpBOD "
							+ e.toString());
			return null;
		}
	}
}