package larion.progate.service.persistence;

import java.util.List;

import larion.progate.model.ProgateOrganizationsStaffs;
import larion.progate.model.impl.ProgateOrganizationsStaffsImpl;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class ProgateOrganizationsStaffsFinderImpl extends BasePersistenceImpl
		implements ProgateOrganizationsStaffsFinder {
	public static String GET_EMPLOYEEINFOREPORT = "EmployeeInfoReport";
	public static String GET_EMPLOYEES_IN_PERMISSIONS = "EmployeesInPermissions";
	public static String GET_BOD_IN_COMPANY = "BODInCompany";

	public List<ProgateOrganizationsStaffs> getEmployeeInformations(int rootId,
			int userId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_EMPLOYEEINFOREPORT);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ProgateOrganizationsStaffs",
					ProgateOrganizationsStaffsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(rootId);
			qPos.add(userId);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in ProgateOrganizationsStaffsFinderImpl.getEmployeeInformations() "
							+ e.toString());
			return null;
		}
	}

	public List<ProgateOrganizationsStaffs> getEmployeesInPermissions(
			int rootId, int orgId) throws SystemException, PortalException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_EMPLOYEES_IN_PERMISSIONS);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ProgateOrganizationsStaffs",
					ProgateOrganizationsStaffsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(rootId);
			qPos.add(orgId);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in ProgateOrganizationsStaffsFinderImpl.getEmployeesInPermissions "
							+ e.toString());
			return null;
		}
	}

	public List<ProgateOrganizationsStaffs> getBODInCompany(int rootId)
			throws SystemException, PortalException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_BOD_IN_COMPANY);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ProgateOrganizationsStaffs",
					ProgateOrganizationsStaffsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(rootId);
			qPos.add(9); //Role 9 la BOD
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in ProgateOrganizationsStaffsFinderImpl.getBODInCompany "
							+ e.toString());
			return null;
		}
	}

}