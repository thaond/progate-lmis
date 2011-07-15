package larion.progate.cds.service.persistence;

import java.util.List;

import larion.progate.cds.model.ViewEmployeesInProjects;
import larion.progate.cds.model.impl.ViewEmployeesInProjectsImpl;
import larion.progate.cds.service.utils.Constants;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class ViewEmployeesInProjectsFinderImpl extends BasePersistenceImpl
		implements ViewEmployeesInProjectsFinder {

	public static String GET_ALL_PA_EMPLOYEES_OF_PM = "AllPAEmployeesOfPM";
	public static String GET_PA_EMPLOYEES_OF_PM = "PAEmployeesOfPM";
	public static String GET_ALL_PA_EMPLOYEES_OF_BOD = "AllPAEmployeesOfBOD";
	public static String GET_PA_EMPLOYEES_OF_BOD = "PAEmployeesOfBOD";
	public static String GET_ALL_APPROVAL_OF_BOD = "AllApprovalOfBOD";
	public static String GET_APPROVAL_OF_BOD = "ApprovalOfBOD";
	public static String GET_ALL_PA_EMPLOYEES_OF_PM_ALL_ORG = "AllPAEmployeesOfPMAllOrg";
	public static String GET_ALL_PA_EMPLOYEES_OF_PM_ALL_ORG_STATUS = "AllPAEmployeesOfPMAllOrgStatus";
	public static String GET_ALL_PA_EMPLOYEES_OF_BOD_ALL_ORG = "AllPAEmployeesOfBODAllOrg";
	public static String GET_ALL_PA_EMPLOYEES_OF_BOD_ALL_ORG_STATUS = "AllPAEmployeesOfBODAllOrgStatus";
	public static String GET_ALL_PA_EMPLOYEES_OF_BOD_ALL_ORG_PM = "AllPAEmployeesOfBODAllOrgPM";
	public static String GET_ALL_PA_EMPLOYEES_OF_BOD_ALL_ORG_STATUS_PM = "AllPAEmployeesOfBODAllOrgStatusPM";
	public static String GET_STAFFREPORT = "StaffReport";
	public static String GET_LEVELMAPPINGREPORT = "LevelMappingReport";
	public static String GET_EMPLOYEEINFOCDP = "EmployeeInfoCDP";
	// Bao cao thong ke tinh trang nhan vien
	public static String GET_EmployeeStateReportInAllOrgOfPM = "EmployeeStateReportInAllOrgOfPM";
	public static String GET_EmployeeStateReportInOrgOfPMAndBOD = "EmployeeStateReportInOrgOfPMAndBOD";
	public static String GET_EmployeeStateReportInAllOrgOfBOD = "EmployeeStateReportInAllOrgOfBOD";
	//Cdp
	public static String GET_ALL_EMPLOYEES_BOD_IN_CDP_ALL_ORG = "AllPAEmployeesBODInCdpAllOrg";
	public static String GET_ALL_EMPLOYEES_BOD_IN_CDP = "AllPAEmployeesBODInCdp";
	public static String GET_ALL_EMPLOYEES_PM_IN_CDP_ALL_ORG = "AllPAEmployeesPMInCdpAllOrg";
	public static String GET_ALL_EMPLOYEES_PM_IN_CDP = "AllPAEmployeesPMInCdp";
	
	// Lay list nhan vien khi PM vao phe duyet
	public List<ViewEmployeesInProjects> getEmployees(int periodId, int orgId,
			int ratingStatusPm, int pmUid) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			// orgId = 0, rating StatusPm != 3 la loc theo tat ca du an, 1 trang
			// thai
			if (orgId == 0 && ratingStatusPm != 3) {
				String sql = CustomSQLUtil
						.get(GET_ALL_PA_EMPLOYEES_OF_PM_ALL_ORG_STATUS);
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity("ViewEmployeesInProjects",
						ViewEmployeesInProjectsImpl.class);
				QueryPos qPos = QueryPos.getInstance(query);
				qPos.add(periodId);
				qPos.add(pmUid);
				qPos.add(Constants.ROLE_ID_MANAGER); // roleId cua PM la 5
				qPos.add(ratingStatusPm);
				qPos.add(pmUid);
				return (List) query.list();
			}
			// orgId = 0, rating StatusPm == 3 la loc theo tat ca du an, tat ca
			// trang thai
			else if (orgId == 0 && ratingStatusPm == 3) {
				String sql = CustomSQLUtil
						.get(GET_ALL_PA_EMPLOYEES_OF_PM_ALL_ORG);
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity("ViewEmployeesInProjects",
						ViewEmployeesInProjectsImpl.class);
				QueryPos qPos = QueryPos.getInstance(query);
				qPos.add(periodId);
				qPos.add(pmUid);
				qPos.add(Constants.ROLE_ID_MANAGER); // roleId cua PM la 5
				qPos.add(pmUid);
				return (List) query.list();
			}
			// loc theo 1 du an
			else {
				// loc theo 1 du an khi chon tat ca trang thai
				if (ratingStatusPm == 3) {
					String sql = CustomSQLUtil.get(GET_ALL_PA_EMPLOYEES_OF_PM);
					SQLQuery query = session.createSQLQuery(sql);
					query.addEntity("ViewEmployeesInProjects",
							ViewEmployeesInProjectsImpl.class);
					QueryPos qPos = QueryPos.getInstance(query);
					qPos.add(periodId);
					qPos.add(orgId);
					qPos.add(pmUid);
					return (List) query.list();
				}
				// loc theo 1 du an khi chon 1 trang thai
				else {
					String sql = CustomSQLUtil.get(GET_PA_EMPLOYEES_OF_PM);
					SQLQuery query = session.createSQLQuery(sql);
					query.addEntity("ViewEmployeesInProjects",
							ViewEmployeesInProjectsImpl.class);
					QueryPos qPos = QueryPos.getInstance(query);
					qPos.add(periodId);
					qPos.add(orgId);
					qPos.add(ratingStatusPm);
					qPos.add(pmUid);
					return (List) query.list();
				}
			}
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewEmployeesInProjectsFinderImpl.getEmployees "
							+ e.toString());
			return null;
		}
	}

	// --------------------------------------------------------------------------------------------
	// Lay list nhan vien + PM khi BOD vao phe duyet ca nhan
	public List<ViewEmployeesInProjects> getEmployeesBOD(int periodId,
			int orgId, int ratingStatusBod, int rootId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			// loc theo tat ca cac du an va 1 trang thai
			if (orgId == 0 && ratingStatusBod != 3) {
				String sql = CustomSQLUtil
						.get(GET_ALL_PA_EMPLOYEES_OF_BOD_ALL_ORG_STATUS);
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity("ViewEmployeesInProjects",
						ViewEmployeesInProjectsImpl.class);
				QueryPos qPos = QueryPos.getInstance(query);
				qPos.add(periodId);
				// qPos.add(bodUid); Ko cho hien ten BOD
				qPos.add(Constants.ROLE_ID_BOD); // roleId cua BOD la 9
				qPos.add(rootId);
				qPos.add(ratingStatusBod);
				qPos.add(periodId);
				return (List) query.list();
			}
			// loc theo tat ca du an, tat ca trang thai
			else if (orgId == 0 && ratingStatusBod == 3) {
				String sql = CustomSQLUtil
						.get(GET_ALL_PA_EMPLOYEES_OF_BOD_ALL_ORG);
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity("ViewEmployeesInProjects",
						ViewEmployeesInProjectsImpl.class);
				QueryPos qPos = QueryPos.getInstance(query);
				qPos.add(periodId);
				// qPos.add(bodUid); Ko cho hien ten BOD
				qPos.add(Constants.ROLE_ID_BOD); // roleId cua BOD la 9
				qPos.add(rootId);
				qPos.add(periodId);
				return (List) query.list();
			} else {
				// loc theo 1 du an
				if (ratingStatusBod == 3) {
					String sql = CustomSQLUtil.get(GET_ALL_PA_EMPLOYEES_OF_BOD);
					SQLQuery query = session.createSQLQuery(sql);
					query.addEntity("ViewEmployeesInProjects",
							ViewEmployeesInProjectsImpl.class);
					QueryPos qPos = QueryPos.getInstance(query);
					qPos.add(periodId);
					qPos.add(orgId);
					// qPos.add(bodUid); Ko cho hien ten BOD
					return (List) query.list();
				} else {
					String sql = CustomSQLUtil.get(GET_PA_EMPLOYEES_OF_BOD);
					SQLQuery query = session.createSQLQuery(sql);
					query.addEntity("ViewEmployeesInProjects",
							ViewEmployeesInProjectsImpl.class);
					QueryPos qPos = QueryPos.getInstance(query);
					qPos.add(periodId);
					qPos.add(orgId);
					qPos.add(ratingStatusBod);
					// qPos.add(bodUid); Ko cho hien ten BOD
					return (List) query.list();
				}
			}
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewEmployeesInProjectsFinderImpl.getEmployeesBOD "
							+ e.toString());
			return null;
		}
	}

	// Lay list nhan vien + PM khi BOD vao phe duyet toan bo
	public List<ViewEmployeesInProjects> getAllEmplApprovalBOD(int periodId,
			int orgId, int ratingStatusBod, int rootId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			// loc theo tat ca cac du an va 1 trang thai
			if (orgId == 0 && ratingStatusBod != 3) {
				String sql = CustomSQLUtil
						.get(GET_ALL_PA_EMPLOYEES_OF_BOD_ALL_ORG_STATUS_PM);
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity("ViewEmployeesInProjects",
						ViewEmployeesInProjectsImpl.class);
				QueryPos qPos = QueryPos.getInstance(query);
				qPos.add(periodId);
				// qPos.add(bodUid); Ko cho hien ten BOD
				qPos.add(Constants.ROLE_ID_BOD); // roleId cua BOD la 9
				qPos.add(rootId);
				qPos.add(ratingStatusBod);
				qPos.add(2); // lay slot da duoc PM phe duyet
				qPos.add(periodId);
				return (List) query.list();
			}
			// loc theo tat ca du an, tat ca trang thai
			else if (orgId == 0 && ratingStatusBod == 3) {
				String sql = CustomSQLUtil
						.get(GET_ALL_PA_EMPLOYEES_OF_BOD_ALL_ORG_PM);
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity("ViewEmployeesInProjects",
						ViewEmployeesInProjectsImpl.class);
				QueryPos qPos = QueryPos.getInstance(query);
				qPos.add(periodId);
				// qPos.add(bodUid); Ko cho hien ten BOD
				qPos.add(Constants.ROLE_ID_BOD); // roleId cua BOD la 9
				qPos.add(rootId);
				qPos.add(2); // chi lay nhung nhan vien da dc PM phe duyet het
								// nen rating_status_pm la 2
				qPos.add(periodId);
				return (List) query.list();
			} else {
				if (ratingStatusBod == 3) {
					String sql = CustomSQLUtil.get(GET_ALL_APPROVAL_OF_BOD);
					SQLQuery query = session.createSQLQuery(sql);
					query.addEntity("ViewEmployeesInProjects",
							ViewEmployeesInProjectsImpl.class);
					QueryPos qPos = QueryPos.getInstance(query);
					qPos.add(periodId);
					qPos.add(orgId);
					// qPos.add(bodUid); Ko cho hien ten BOD
					qPos.add(2);
					return (List) query.list();
				} else {
					String sql = CustomSQLUtil.get(GET_APPROVAL_OF_BOD);
					SQLQuery query = session.createSQLQuery(sql);
					query.addEntity("ViewEmployeesInProjects",
							ViewEmployeesInProjectsImpl.class);
					QueryPos qPos = QueryPos.getInstance(query);
					qPos.add(periodId);
					qPos.add(orgId);
					qPos.add(ratingStatusBod);
					// qPos.add(bodUid); Ko cho hien ten BOD
					qPos.add(2); // Lay nhung slot da duoc PM phe duyet roi
					return (List) query.list();
				}
			}
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewEmployeesInProjectsFinderImpl.getAllEmplApprovalBOD "
							+ e.toString());
			return null;
		}
	}

	public static String CHECK_EMPLOYEE_IN_ORG = "CheckEmployeeInOrg";

	// Kiem tra nhan vien thuoc org nao
	public List<ViewEmployeesInProjects> checkEmployeeInOrg(int periodId,
			int userId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(CHECK_EMPLOYEE_IN_ORG);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ViewEmployeesInProjects",
					ViewEmployeesInProjectsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(periodId);
			qPos.add(userId);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewEmployeesInProjectsFinderImpl.checkEmployeeInOrg "
							+ e.toString());
			return null;
		}
	}

	// Bao cao tinh trang CDS cua nhan vien o tat ca cac dot
	public List<ViewEmployeesInProjects> getStaffReport(int rootId, int userId)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_STAFFREPORT);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ViewEmployeesInProjects",
					ViewEmployeesInProjectsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(userId);
			qPos.add(rootId);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewEmployeesInProjectsFinderImpl.getStaffReport() "
							+ e.toString());
			return null;
		}
	}

	// Bao cao Level mapping
	public List<ViewEmployeesInProjects> getLevelMappingReport(int rootId,
			int userId, int periodId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_LEVELMAPPINGREPORT);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ViewEmployeesInProjects",
					ViewEmployeesInProjectsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(userId);
			qPos.add(rootId);
			qPos.add(periodId);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewEmployeesInProjectsFinderImpl.getLevelMappingReport() "
							+ e.toString());
			return null;
		}
	}

	// Lay thong tin nhan vien theo tung dot cho CDP
	public List<ViewEmployeesInProjects> getEmployeeInformationCDP(int rootId,
			int userId, int periodId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_EMPLOYEEINFOCDP);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ViewEmployeesInProjects",
					ViewEmployeesInProjectsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(rootId);
			qPos.add(userId);
			qPos.add(periodId);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewEmployeesInProjectsFinderImpl.getEmployeeInformationCDP() "
							+ e.toString());
			return null;
		}
	}

	// --------------------------------------------------------------------------------
	// Bao cao thong ke tinh trang nhan vien
	// Lay nhan vien trong tat ca cac Org cua PM
	public List<ViewEmployeesInProjects> getEmployeeStateReportInAllOrgOfPM(
			int userId, int periodId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_EmployeeStateReportInAllOrgOfPM);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ViewEmployeesInProjects",
					ViewEmployeesInProjectsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);

			qPos.add(periodId);
			qPos.add(userId);
			qPos.add(Constants.ROLE_ID_MANAGER);
			qPos.add(periodId);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewEmployeesInProjectsFinderImpl.getEmployeeStateReportInAllOrgOfPM() "
							+ e.toString());
			return null;
		}
	}

	// Lay nhan vien trong tung Org cua PM/BOD
	public List<ViewEmployeesInProjects> getEmployeeStateReportInOrgOfPMAndBOD(
			int userId, int periodId, int orgId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil
					.get(GET_EmployeeStateReportInOrgOfPMAndBOD);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ViewEmployeesInProjects",
					ViewEmployeesInProjectsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);

			qPos.add(periodId);
			qPos.add(orgId);

			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewEmployeesInProjectsFinderImpl.getEmployeeStateReportInOrgOfPMAndBOD() "
							+ e.toString());
			return null;
		}
	}

	// // Lay nhan vien trong tat ca cac Org cua BOD
	public List<ViewEmployeesInProjects> getEmployeeStateReportInAllOrgOfBOD(
			int rootId, int userId, int periodId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil
					.get(GET_EmployeeStateReportInAllOrgOfBOD);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ViewEmployeesInProjects",
					ViewEmployeesInProjectsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);

			qPos.add(periodId);
			qPos.add(Constants.ROLE_ID_BOD);
			qPos.add(rootId);
			qPos.add(periodId);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewEmployeesInProjectsFinderImpl.getEmployeeStateReportInAllOrgOfBOD() "
							+ e.toString());
			return null;
		}
	}
	//-------------------------------------
	// Lay list nhan vien + PM khi BOD vao phe duyet Cdp
	public List<ViewEmployeesInProjects> getEmployeesCdpBOD(int periodId,
			int orgId, int rootId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			// loc theo tat ca cac du an
			if (orgId == 0) {
				String sql = CustomSQLUtil
						.get(GET_ALL_EMPLOYEES_BOD_IN_CDP_ALL_ORG);
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity("ViewEmployeesInProjects",
						ViewEmployeesInProjectsImpl.class);
				QueryPos qPos = QueryPos.getInstance(query);
				qPos.add(periodId);
				qPos.add(Constants.ROLE_ID_BOD); // roleId cua BOD la 9
				qPos.add(rootId);
				qPos.add(periodId);
				return (List) query.list();
			//Loc theo 1 du an
			} else {
				String sql = CustomSQLUtil.get(GET_ALL_EMPLOYEES_BOD_IN_CDP);
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity("ViewEmployeesInProjects",
						ViewEmployeesInProjectsImpl.class);
				QueryPos qPos = QueryPos.getInstance(query);
				qPos.add(periodId);
				qPos.add(orgId);
				return (List) query.list();
			}
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewEmployeesInProjectsFinderImpl.getEmployeesCdpBOD "
							+ e.toString());
			return null;
		}
	}

	//Lay list nhan vien khi PM vao phe duyet Cdp
	public List<ViewEmployeesInProjects> getEmployeesCdp(int periodId, int orgId,
			int pmUid) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			//Loc tat ca du an
			if (orgId == 0) {
				String sql = CustomSQLUtil
						.get(GET_ALL_EMPLOYEES_PM_IN_CDP_ALL_ORG);
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity("ViewEmployeesInProjects",
						ViewEmployeesInProjectsImpl.class);
				QueryPos qPos = QueryPos.getInstance(query);
				qPos.add(periodId);
				qPos.add(pmUid);
				qPos.add(Constants.ROLE_ID_MANAGER); // roleId cua PM la 5
				qPos.add(pmUid);
				return (List) query.list();
			}
			// loc theo 1 du an
			else {
				String sql = CustomSQLUtil.get(GET_ALL_EMPLOYEES_PM_IN_CDP);
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity("ViewEmployeesInProjects",
						ViewEmployeesInProjectsImpl.class);
				QueryPos qPos = QueryPos.getInstance(query);
				qPos.add(periodId);
				qPos.add(orgId);
				qPos.add(pmUid);
				return (List) query.list();
			}
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewEmployeesInProjectsFinderImpl.getEmployeesCdp "
							+ e.toString());
			return null;
		}
	}
}