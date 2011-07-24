package larion.progate.lmis.service.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ecs.storage.Array;

import larion.progate.lmis.model.LmisAbsenceRequests;
import larion.progate.lmis.model.LmisViewTimeChangeReqs;
import larion.progate.lmis.model.impl.LmisAbsenceRequestsImpl;
import larion.progate.lmis.model.impl.LmisViewTimeChangeReqsImpl;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class LmisAbsenceRequestsFinderImpl extends  BasePersistenceImpl implements LmisAbsenceRequestsFinder{
	public static String GETLISTREQUEST = "getListRequestsApp";
	/* (non-Javadoc)
	 * @see larion.progate.lmis.service.persistence.LmisAbsenceRequestsFinder#getListAbsRequestApprovedBy(int, int)
	 * get List ma` sao no cu bao ko biet LmisAbsenceRequests
	 */
	public List<LmisAbsenceRequests> getListAbsRequestApprovedBy(int rootId, int userId)throws Exception{
		Session session = null;
		try {
			System.out.println("Begin ");
			session = openSession();
			String sql = "SELECT lmis_absence_requests.* " 
				+ " FROM lmis_absence_requests JOIN lmis_absence_approvals "
				+ " ON lmis_absence_requests.id = lmis_absence_approvals.request_id "
				+ " WHERE (lmis_absence_requests.root_id=?) AND (approved_by=?) "
				+ " ORDER BY lmis_absence_requests.requested_status ASC, start_date ASC ";
			System.out.println("SQL Content: "+ sql);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("LmisAbsenceRequests", LmisAbsenceRequestsImpl.class); 
			QueryPos pos = QueryPos.getInstance(q);
			pos.add(rootId);
			pos.add(userId);
			return q.list();
		} catch (Exception e) {
			System.out.println("Erron in LmisAbsenceRequestsFinder.getListAbsRequestApprovedBy:"+ e.toString());
			e.printStackTrace();
			return new ArrayList<LmisAbsenceRequests>();
		}
		
	}
	public int checkAbsenceTypeSpec(int rootId, int absenceId) throws Exception{
		Session session = null;
		try{
			session = openSession();
			String sql = "SELECT lmis_check_absence_type_spec("+ rootId+ "," + absenceId +")";
			SQLQuery q = session.createSQLQuery(sql);
			List<Object> ls = q.list();
			System.out.println("Content result LmisAbsenceRequestsFinderImpl.checkAbsenceTypeSpec is:"+ls);
			int r=0;
			if(ls.size()>0){
				r = Integer.parseInt(ls.get(0).toString());
			}
			
			return r;
			
		}catch (Exception e) {
			System.out.println("Error in LmisAbsenceRequestsFinderImpl.checkAbsenceTypeSpec:"+e.toString());
			return 3; //
		}
	}
	//Filter for Thay doi thoi gian lam viec, reason: lazy
	public List<LmisViewTimeChangeReqs> filterByStatusTabManager(int rootId,int userId, int status , ArrayList<Integer> lsArr ){
		Session session = null;
		try {
			session = openSession();
			StringBuilder	sql = new StringBuilder();
			sql.append("SELECT a.* FROM vw_timechange_request_user_ a JOIN lmis_timechange_approvals p ON a.id=p.request_id");
			sql.append(" WHERE (a.root_id="+rootId+" AND a.requested_status="+status+" AND approved_by="+userId+") ");
	
			sql.append("  ORDER BY lastname, firstname;");
			System.out.println("SQL content LmisAbsenceRequestsFinderImpl.filterByStatusTabManager: "+sql.toString());
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.addEntity("LmisViewTimeChangeReqs", LmisViewTimeChangeReqsImpl.class);
			return q.list();
			
		} catch (Exception e) {
			System.out.println("Error in LmisAbsenceRequestsFinderImpl.filterByStatusTabManager: "+e.toString());
			return new ArrayList<LmisViewTimeChangeReqs>();
		}
	}
	//Filter for Thay doi thoi gian lam viec, reason: lazy, tabOther
	public List<LmisViewTimeChangeReqs> filterByStatusTabOther(int rootId, int status ){
		Session session = null;
		try {
			session = openSession();
			StringBuilder	sql = new StringBuilder();
			sql.append("SELECT * FROM vw_timechange_request_user_ WHERE root_id=" +rootId + " AND requested_status=" + status + " ");
			sql.append("  ORDER BY lastname, firstname;");
			System.out.println("SQL content LmisAbsenceRequestsFinderImpl.filterByStatusTabManager: "+sql.toString());
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.addEntity("LmisViewTimeChangeReqs", LmisViewTimeChangeReqsImpl.class);
			return q.list();
			
		} catch (Exception e) {
			System.out.println("Error in LmisAbsenceRequestsFinderImpl.filterByStatusTabManager: "+e.toString());
			return new ArrayList<LmisViewTimeChangeReqs>();
		}
	}
	//getList LmisViewTimeChangeReq co order, approveby
	public List<LmisViewTimeChangeReqs> getListOtReqApproveBy(int rootId, int status ){
		Session s = null;
		try {
			s = openSession();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT DISTINCT s.id, s.root_id, s.requested_by, u.firstname, u.lastname, (((u.firstname || ' ') || u.middlename) || ' ') || u.lastname AS fullname, s.start_date, s.end_date, s.mon_start_time, s.mon_end_time, s.tue_start_time, s.tue_end_time, s.wed_start_time, s.wed_end_time, s.thu_start_time, s.thu_end_time, s.fri_start_time, s.fri_end_time, s.sat_start_time, s.sat_end_time, s.requested_reason, s.requested_status, s.created_at ");
			sql.append(" FROM lmis_timechange_requests s ");
			sql.append("    JOIN user_ u ON u.userid = s.requested_by");
			sql.append(" 	JOIN lmis_timechange_approvals on s.id = lmis_timechange_approvals.request_id");
			sql.append(" WHERE lmis_timechange_approvals.approved_by="+status+" ");
			sql.append(" ORDER BY requested_status,u.lastname, u.firstname;");
			System.out.println("SQL content LmisAbsenceRequestsFinderImpl.getListOtReqApproveBy :"+sql.toString());
			SQLQuery q = s.createSQLQuery(sql.toString());
			q.addEntity("LmisViewTimeChangeReqs", LmisViewTimeChangeReqsImpl.class);
			return q.list();
  
		} catch (Exception e) {
			System.out.println("Error in LmisAbsenceRequestsFinderImpl.getListOtReqApproveBy: "+e.toString());
			return new ArrayList<LmisViewTimeChangeReqs>();
		}
	}
	
	public List<LmisViewTimeChangeReqs> filterByStatusAndUserTabManager(int rootId,int userId, int status , ArrayList<Integer> lsArr, ArrayList<Integer> lsUser ){
		Session session = null;
		try {
			session = openSession();
			StringBuilder	sql = new StringBuilder();
			sql.append("SELECT * FROM vw_timechange_request_user_ WHERE root_id=" +rootId + " AND requested_status=" + status + " ");
			if (lsArr.size() >0){
				for (Integer i : lsArr) {
					sql.append(" OR id="+i.intValue() + " ");
				}
			}
			
			if(lsUser.size() >0){
				for (Integer i : lsUser) {
					sql.append(" OR requested_by="+i.intValue()+ " ");
				}
			}
			sql.append("  ORDER BY firstname, lastname;");
			System.out.println("SQL content LmisAbsenceRequestsFinderImpl.filterByStatusTabManager: "+sql.toString());
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.addEntity("LmisViewTimeChangeReqs", LmisViewTimeChangeReqsImpl.class);
			return q.list();
			
		} catch (Exception e) {
			System.out.println("Error in LmisAbsenceRequestsFinderImpl.filterByStatusTabManager: "+e.toString());
			return new ArrayList<LmisViewTimeChangeReqs>();
		}
	}
	public List<LmisAbsenceRequests> filterTabManager(int rootId, int userId, int absType, int status){
		Session session = null;
		try {
			session = openSession();
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM lmis_absence_requests WHERE root_id="+ rootId + " ");
			if(absType != -1){
				sql.append(" AND absence_type_id="+absType +" ");
			}
			if(status !=-1){
				sql.append(" AND requested_status=" + status+" ");
			}
			sql.append(" ORDER BY requested_status ASC;");
			System.out.println("SQL content LmisAbsenceRequestsFinderImpl.filterTabManager: "+sql);
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.addEntity("LmisAbsenceRequests", LmisAbsenceRequestsImpl.class);
			return q.list();
		} catch (Exception e) {
			System.out.println("Error in LmisAbsenceRequestsFinderImpl.filterTabManager");
			return new ArrayList<LmisAbsenceRequests>();
		}
	}
	//Get absenceId of unexpected type
	public int getAbsenceIdOfUnexpected(int rootId){
		Session session = null;
		try{
			session = openSession();
			String sql = "SELECT lmis_get_absenceid_of_unexpected_type("+ rootId+")";
			SQLQuery q = session.createSQLQuery(sql);
			List<Object> ls = q.list();
			int r=0;
			if(ls.size()>0){
				r = Integer.parseInt(ls.get(0).toString());
			}
			return r;
		}catch (Exception e) {
			System.out.println("Error in LmisAbsenceRequestsFinderImpl.checkAbsenceTypeSpec:"+e.toString());
			return 0;
		}
	}
	public String getAbsenceNameOfUnexpected(int rootId){
		Session session = null;
		try{
			session = openSession();
			String sql = "SELECT lmis_get_absencename_of_unexpected_type("+ rootId+")";
			SQLQuery q = session.createSQLQuery(sql);
			List<Object> ls = q.list();
			if(ls.size()>0){
				return ls.get(0).toString();
			}
			return null;
		}catch (Exception e) {
			System.out.println("Error in LmisAbsenceRequestsFinderImpl.checkAbsenceTypeSpec:"+e.toString());
			return "";
		}
	}


}
