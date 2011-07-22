package larion.progate.lmis.service.persistence;

import java.util.ArrayList;
import java.util.List;

import larion.progate.lmis.model.LmisViewReportOvertime;
import larion.progate.lmis.model.impl.LmisViewReportOvertimeImpl;
import larion.progate.lmis.service.persistence.LmisViewReportOvertimeFinderImpl;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;



public class LmisViewReportOvertimeFinderImpl extends BasePersistenceImpl
		implements LmisViewReportOvertimeFinder {

	@Override
	public List<LmisViewReportOvertime> getListOtRepRoleSpecs(int rootId)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT max(b.id) as id, a.id AS ot_rep_id, a.root_id, max(a.org_id) as org_id, max(a.request_id) as request_id, max(a.reported_by) as reported_by,"
					+ " max(a.reported_at) as reported_at, max(a.reported_reason) as reported_reason,max(o.requested_at) as requested_at, max(a.reported_status) as reported_status,"
					+ " max(a.created_at) as created_at, max(a.updated_at) as updated_at, max(b.report_id) as report_id, max(b.user_id) as user_id,"
					+ " max(b.start_time) as start_time, max(b.end_time) as end_time,max(b.total_hour) as total_hour, max(c.detail_id) as detail_id, max(c.ot_type) as ot_type, max(c.ot_hour) as ot_hour,"
					+ " max(c.ot_coefficient) as ot_coefficient, max(c.ot_id) as ot_id, max(e.name) AS org_name,max(s.requested_hour) as reg_requested_hour,max(s.start_time) as reg_start_time, max(s.end_time) as reg_end_time, "
					+ " max(u.firstname) AS first_name, max(u.middlename) AS middle_name, max(u.lastname) AS last_name, max(u.middlename) AS full_name,max(uu.firstname) AS rep_first_name, max(uu.middlename) AS rep_middle_name, max(uu.lastname) AS rep_last_name"
					+ " FROM lmis_overtime_reports a "
					+ "FULL JOIN lmis_overtime_report_details b ON a.id = b.report_id "
					+ "FULL JOIN lmis_overtime_report_hours c ON b.id = c.detail_id "
					+"JOIN lmis_overtime_requests o ON o.id = a.request_id "
					+ "JOIN user_ u ON b.user_id = u.userid "
					+"FULL JOIN user_ uu ON a.reported_by = uu.userid "
					+ "JOIN organizations e ON a.org_id = e.id "
					+"FULL JOIN lmis_overtime_approvals ap ON a.id = ap.report_id "
					+  "JOIN lmis_overtime_request_details s ON o.id = s.request_id "
					+ "GROUP BY ot_rep_id,a.root_id "
					+ "HAVING (a.root_id ="+ rootId + ") ORDER BY max(reported_status) ";
			SQLQuery query = session.createSQLQuery(sql);
			System.out.println("============1");
			System.out.println(sql);
			query.addEntity("LmisViewRegistrationOvertime",
					LmisViewReportOvertimeImpl.class);
			List<LmisViewReportOvertime> result = query.list();
			System.out.println(result);
			System.out.println("============2");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/*public List<LmisViewReportOvertime> getListOtRepRoleSpecsFilter(int rootId,int orgId)
	throws SystemException {
		Session session = null;
		try {
	
			session = openSession();
			StringBuilder sql = new StringBuilder();		
			sql.append("select * from LmisViewReportOvertime where root_id= "
					+ rootId + " AND org_id=" + orgId + " ");
				  sql.append(" order by reported_status asc ");
			
			System.out
					.println("SQL content LmisViewReportOvertimeFinderImpl.getListOtRepRoleSpecsFilter "
							+ sql.toString());
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.addEntity("LmisViewReportOvertime", LmisViewReportOvertimeImpl.class);
			return q.list();

		} catch (Exception e) {
			System.out
					.println("Error in LmisViewReportOvertimeFinderImpl.getListOtRepRoleSpecsFilter: "
							+ e.toString());
			return new ArrayList<LmisViewReportOvertime>();
		}
	}*/

}