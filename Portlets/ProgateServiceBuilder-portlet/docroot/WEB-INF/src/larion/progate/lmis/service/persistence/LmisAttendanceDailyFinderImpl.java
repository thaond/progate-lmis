package larion.progate.lmis.service.persistence;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import larion.progate.lmis.model.LmisAttendanceDaily;
import larion.progate.lmis.model.impl.LmisAttendanceDailyImpl;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class LmisAttendanceDailyFinderImpl extends BasePersistenceImpl implements  LmisAttendanceDailyFinder{

	public List<LmisAttendanceDaily> getListStaffDayOff(int rootId, Date dayValue) throws Exception{
		Session session = null;
		try {
			session = openSession();
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");		
			String dateStr = df.format(dayValue);
			
			String sql = "select * FROM lmis_attendance_daily " 
						+ " WHERE root_id=" +rootId + " AND absence_value > 0 AND day_value=date('"+dateStr +"')";
			System.out.println("sql: " + sql);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("LmisAttendanceDaily", LmisAttendanceDailyImpl.class);
			return q.list();
		} catch (Exception e) {
			System.out.println("Error in LmisAttendanceDailyFinderImpl.getListStaffDayOff");
			return new ArrayList<LmisAttendanceDaily>();
		}
	}
	
	
	public double getTotalDayOffInMonth_(int userId, int rootId) throws Exception{
		Session session = null;
		try {
			session = openSession();						
			String sql = "select sum(absence_value) from lmis_attendance_daily " 
						+ " WHERE absence_value >0  and root_id=" +rootId +  " and user_id=" +userId + " and day_value <= now() and extract(month from day_value) = extract(month from now()) ";
			System.out.println("sql: " + sql);
			SQLQuery q = session.createSQLQuery(sql);
//			q.addEntity("LmisAttendanceDaily", LmisAttendanceDailyImpl.class);
			System.out.println("q.list().size() "+ q.list().size() );
			if(q.list().size() >0){
				String sa=  q.list().get(0).toString();				
				return Double.parseDouble(sa);
			}
			else
				return 0;			
			
		} catch (Exception e) {
			System.out.println("Error in LmisAttendanceDailyFinderImpl.getTotalDayOffInMonth_");
			return 0;
		}
	}

	public double caculateTotalDayOffDontHavePermission_(int userId, int rootId) throws Exception{
		Session session = null;
		try {
			session = openSession();						
			String sql = "select sum(absence_value) from lmis_attendance_daily " 
						+ " WHERE absence_value >0  and root_id=" +rootId +  " and user_id=" +userId + " and day_value <= now() and extract(month from day_value) = extract(month from now()) and  is_permissive =false ";
			System.out.println("sql: " + sql);
			SQLQuery q = session.createSQLQuery(sql);
//			q.addEntity("LmisAttendanceDaily", LmisAttendanceDailyImpl.class);
			System.out.println("q.list().size() "+ q.list().size() );
			if(q.list().size() >0){
				String sa=  q.list().get(0).toString();				
				return Double.parseDouble(sa);
			}
			else
				return 0;	
		} catch (Exception e) {
			System.out.println("Error in LmisAttendanceDailyFinderImpl.getTotalDayOffInMonth_");
			return 0;
		}
	}
	
	public double caculateTotalDayOffHavePermission_(int userId, int rootId) throws Exception{
		Session session = null;
		try {
			session = openSession();						
			String sql = "select sum(absence_value) from lmis_attendance_daily " 
						+ " WHERE absence_value >0  and root_id=" +rootId +  " and user_id=" +userId + " and day_value <= now() and extract(month from day_value) = extract(month from now()) and  is_permissive =true ";
			System.out.println("sql: " + sql);
			SQLQuery q = session.createSQLQuery(sql);
//			q.addEntity("LmisAttendanceDaily", LmisAttendanceDailyImpl.class);
			System.out.println("q.list().size() "+ q.list().size() );
			if(q.list().size() >0){
				String sa=  q.list().get(0).toString();				
				return Double.parseDouble(sa);
			}
			else
				return 0;	
		} catch (Exception e) {
			System.out.println("Error in LmisAttendanceDailyFinderImpl.caculateTotalDayOffHavePermission_");
			return 0;
		}
	}
	
	
}


	

