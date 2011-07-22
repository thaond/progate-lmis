package larion.progate.lmis.service.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import larion.progate.lmis.model.LmisViewOTApp;
import larion.progate.lmis.model.LmisViewRegistrationOvertime;
import larion.progate.lmis.model.impl.LmisViewOTAppImpl;
import larion.progate.lmis.model.impl.LmisViewRegistrationOvertimeImpl;
import larion.progate.lmis.service.persistence.LmisViewRegistrationOvertimeFinderImpl;


import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class LmisViewRegistrationOvertimeFinderImpl extends BasePersistenceImpl
		implements LmisViewRegistrationOvertimeFinder {

	@Override
	public List<LmisViewRegistrationOvertime> getListOtReqRoleSpecs(int rootId)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT max(b.id )as id , a.id AS ot_reqs_id, a.root_id, MAX(a.requested_by) as requested_by, max(a.requested_at)as requested_at, max(a.requested_reason) as requested_reason, max(a.requested_status) as requested_status, max(a.created_at) as created_at, max(a.updated_at) as updated_At, max(a.org_id) as org_id , max (b.request_id) as request_id, max(b.user_id) as user_id, max(b.start_time) as start_time, max(b.end_time) as end_time, max(b.requested_reason )AS reason_detail, max(b.requested_hour) as requested_hour, max(c.approved_by) as approve_by, max(c.approved_at) as approved_at, c.is_approved as is_approved, c.approved_status as approved_status,max(c.reason) as reason, max(e.name)as org_name, "
					+ " max(u.firstname) AS first_name, max(u.middlename) AS middle_name, max(u.lastname) AS last_name, max(u.middlename) AS full_name,max(uu.firstname) as req_first_name,max(uu.middlename) as req_middle_name,max(uu.lastname) as req_last_name "
					+ "FROM lmis_overtime_requests a "
					+ "full JOIN lmis_overtime_request_details b ON a.id = b.request_id "
					+ "FULL JOIN lmis_overtime_approvals c ON a.id = c.request_id "
					+ "	FULL JOIN user_ u ON b.user_id = u.userid "
					+"FULL JOIn user_ uu on a.requested_by= uu.userid "
					+ "JOIN organizations e ON a.org_id = e.id "
					+ "	GROUP BY ot_reqs_id,is_approved,approved_status ,a.root_id "
					+ "HAVING (a.root_id =" + rootId + ") ORDER BY requested_status ASC, org_name  ";
			SQLQuery query = session.createSQLQuery(sql);
			System.out.println("SQL content getListOtReqRoleSpecs:"+sql);
			query.addEntity("LmisViewRegistrationOvertime",
					LmisViewRegistrationOvertimeImpl.class);
			List<LmisViewRegistrationOvertime> result = query.list();
			return result;
		} catch (Exception e) {
			System.out.println("Error in LmisViewRegistrationOvertimeFinderImpl.getListOtReqRoleSpecs");
			return new ArrayList<LmisViewRegistrationOvertime>();
		}

	}
	public List<LmisViewRegistrationOvertime> getListOtReqRoleUser(int rootId, int userId){
		Session s = null;
		try{
			s= openSession();
			String sql = "SELECT * from vw_registration_overtime where root_id="+rootId + " AND user_id=" + userId + " Order by requested_status ASC,last_name ASC, first_name ASC";
			System.out.println("SQL content: LmisViewRegistrationOvertimeFinderImpl.getListOtReqRoleUser" + sql);
			SQLQuery query = s.createSQLQuery(sql);
			query.addEntity("LmisViewRegistrationOvertime",LmisViewRegistrationOvertimeImpl.class);
			List<LmisViewRegistrationOvertime> result = query.list();
			return result;
			
		}catch(Exception e){
			System.out.println("Error in LmisViewRegistrationOvertimeFinderImpl.getListOtReqRoleUser");
			return new ArrayList<LmisViewRegistrationOvertime>();
		}
		
		
	}
	public int countOtRequestPending(int rootId, int userId){
		Session s = null;
		try{
			s= openSession();
			String sql = "select count(*) from lmis_overtime_approvals " +
					"where root_id="+rootId+ " AND approved_by="+ userId + " AND request_id!=0 AND approved_at is NULL and approved_status=false ";
			System.out.println("SQL content: LmisViewRegistrationOvertimeFinderImpl.countOtRequestPending" + sql);
			SQLQuery query = s.createSQLQuery(sql);
			List<Object> ls = query.list();
			int r=0;
			if(ls.size()>0){
				r = Integer.parseInt(ls.get(0).toString());
			}
			return r;
			
		}catch(Exception e){
			System.out.println("Error in LmisViewRegistrationOvertimeFinderImpl.countOtRequestPending");
			return 0;
		}
	}
	//Tab other
	public List<LmisViewRegistrationOvertime> filterTabOther(int rootId, int orgId, int status){
		Session session = null;
		try {
			session = openSession();
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM vw_registration_overtime WHERE root_id="+rootId+" ");
			if(orgId!=-1){
				sql.append(" AND org_id="+orgId+" ");
			}
			if(status !=-1){
				sql.append(" AND requested_status="+status+ " ");
			}
			sql.append(" ORDER BY requested_status ASC;");
			System.out.println("SQL content LmisViewRegistrationOvertimeFinderImpl.filterTabManager: "+sql);
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.addEntity("LmisViewRegistrationOvertime", LmisViewRegistrationOvertimeImpl.class);
			return q.list();
			
		} catch (Exception e) {
			System.out.println("Error in LmisViewRegistrationOvertimeFinderImpl.filterTabManager");
			return new ArrayList<LmisViewRegistrationOvertime>();
		}
	}
	//tab Manager
	public List<LmisViewOTApp> filterTabManager(int rootId, int orgId,int userId, int status){
		Session session = null;
		try {
			session = openSession();
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM vw_ot_app WHERE root_id="+rootId+" AND approved_by="+ userId+" ");
			if(orgId!=-1){
				sql.append(" AND org_id="+orgId+" ");
			}
			if(status != -1){
				sql.append(" AND requested_status="+status+  " ");
			}
			sql.append(" OrDER BY requested_status ASC,requested_at DESC;");
			System.out.println("SQL content LmisViewRegistrationOvertimeFinderImpl.filterTabManager: "+sql);
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.addEntity("LmisViewOTApp", LmisViewOTAppImpl.class);
			return q.list();

		} catch (Exception e) {
			System.out.println("Error in LmisViewRegistrationOvertimeFinderImpl.filterTabManager");
			return new ArrayList<LmisViewOTApp>();
		}
	}
	//New userId = -1 :filterTabOther
	//New userId != -1 :filterTabManager
	public List<LmisViewRegistrationOvertime> filterByDateTabManager(int rootId,Date day,int userId,int status){
		Session session	=null;
		try {
			session = openSession();
			StringBuilder sql = new StringBuilder();
			if(userId != -1){
				sql.append("SELECT * FROM vw_registration_overtime WHERE root_id="+rootId+ " AND approved_by="+ userId
								+" AND requested_at=date('"+day.toString()+"') AND requested_status="+ status
								+" ORDER BY requested_status ASC");
			}
			else{
				sql.append("SELECT * FROM vw_registration_overtime WHERE root_id="+rootId
						+" AND requested_at=date('"+day.toString()+"') AND requested_status="+ status
						+" ORDER BY requested_status ASC");
			}
			System.out.println("SQL content: LmisViewRegistrationOvertimeFinderImpl.filterByDateTabManager");
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.addEntity("LmisViewRegistrationOvertime", LmisViewRegistrationOvertimeImpl.class);
			return q.list();
		} catch (Exception e) {
			System.out.println("Error in LmisViewRegistrationOvertimeFinderImpl.filterByDateTabManager: "+e.toString());
			return new ArrayList<LmisViewRegistrationOvertime>();
		} 
	
		
	}
}