package larion.progate.lmis.service.persistence;


import java.util.ArrayList;
import java.util.List;

import larion.progate.lmis.model.LmisViewReportOvertimeApproval;
import larion.progate.lmis.model.impl.LmisViewReportOvertimeApprovalImpl;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;



public class LmisViewReportOvertimeApprovalFinderImpl extends BasePersistenceImpl
		implements LmisViewReportOvertimeApprovalFinder {
	
	public List<LmisViewReportOvertimeApproval> getListApprovals(int rootId,
			int approvedBy) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder sql = new StringBuilder();

			sql.append(" SELECT a.id, a.root_id, a.org_id, a.request_id, a.reported_by, a.reported_at, a.reported_reason, a.reported_status, a.created_at, a.updated_at, e.name AS org_name,(((u.firstname || ' ') || u.middlename) || ' ') || u.lastname AS full_name    FROM lmis_overtime_reports a    FULL JOIN user_ u ON a.reported_by = u.userid     JOIN organizations e ON a.org_id = e.id      inner join lmis_overtime_approvals p on a.id =p.report_id where p.approved_by =  "
					+ approvedBy + " AND p.root_id =  " + rootId + " ");
			sql.append("  ORDER BY  a.reported_status,org_name ");
			System.out .println("SQL content LmisViewReportOvertimeFinderImpl.getListApprovals: "		+ sql.toString());
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.addEntity("LmisViewReportOvertimeApproval",	LmisViewReportOvertimeApprovalImpl.class);
			System.out.println(q.list());
			return q.list();

		} catch (Exception e) {
			System.out
					.println("Error in LmisViewReportOvertimeApprovalinderImpl.getListApprovals : "
							+ e.toString());
			return new ArrayList<LmisViewReportOvertimeApproval>();
		}

	}
	
}
