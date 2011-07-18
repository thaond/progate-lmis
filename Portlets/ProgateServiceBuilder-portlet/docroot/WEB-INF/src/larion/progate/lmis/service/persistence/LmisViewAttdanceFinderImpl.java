package larion.progate.lmis.service.persistence;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import larion.progate.lmis.model.LmisViewAttdance;
import larion.progate.lmis.model.impl.LmisViewAttdanceImpl;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;


public class LmisViewAttdanceFinderImpl extends BasePersistenceImpl implements
		LmisViewAttdanceFinder {

	public List<LmisViewAttdance> getListAttDailyFilterTabPersonal(int rootId,int userId, 
			Date date, int status, int absence) {
		Session session = null;
		try {
			
		
			
			session = openSession();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from vw_attendance where root_id= "
					+ rootId + " AND user_id=" + userId + " ");
			if(absence ==1)	{		
				sql.append(" AND is_permissive=true ");}
			else if(absence ==0){				
				sql.append(" AND is_permissive=false ");}
								
			if (date!=null){
				DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
				String dateStr = df.format(date);
				sql.append(" AND day_value= '" + dateStr + "' ");
			}
			
	  		
	       if(status!=-1){
			sql.append(" AND absence=" + status );					
			}
	       sql.append(" order by day_value desc ");
	       
			System.out
					.println("SQL content LmisViewAttdanceFinderImpl.getListAttDailyFilterTabPersonal: "
							+ sql.toString());
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.addEntity("LmisViewAttdance",
					LmisViewAttdanceImpl.class);
			return q.list();

		} catch (Exception e) {
			System.out
					.println("Error in LmisViewAttdanceFinderImpl.getListAttDailyFilterTabPersonal: "
							+ e.toString());
			return new ArrayList<LmisViewAttdance>();
		}
	}
	
	
	public List<LmisViewAttdance> getListAttDailyFilterTabOther(int rootId,
			Date date, String name) {
		Session session = null;
		try {
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			String dateStr = df.format(date);
			session = openSession();
			StringBuilder sql = new StringBuilder();
			if(name==null){
			sql.append("select * from vw_attendance where root_id= "
					+ rootId + " AND day_value= '" + dateStr + "' ");
			}
			else{
			sql.append("select * from vw_attendance where root_id= "
						+ rootId + " AND day_value='" + dateStr + "'");
			sql.append(" AND full_name like  '%"+name+"%'" );			
			}
			  sql.append(" order by  last_name asc, absence desc ");
			System.out
					.println("SQL content LmisViewAttdanceFinderImpl.getListAttDailyFilterTabOther: "
							+ sql.toString());
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.addEntity("LmisViewAttdance",
					LmisViewAttdanceImpl.class);
			return q.list();

		} catch (Exception e) {
			System.out
					.println("Error in LmisViewAttdanceFinderImpl.getListAttDailyFilterTabOther: "
							+ e.toString());
			return new ArrayList<LmisViewAttdance>();
		}
	}
	

	public List<LmisViewAttdance> getListAttDailyorder(
			int userId,int rootId) {
		Session session = null;
		try {			
			session = openSession();
			StringBuilder sql = new StringBuilder();			
			sql.append("select * from vw_attendance where root_id= "
					+ rootId + " AND user_id= '" + userId+ "' ");	
		    sql.append(" order by day_value desc ");
			System.out
					.println("SQL content LmisViewAttdanceFinderImpl.getListAttDailyorder: "
							+ sql.toString());
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.addEntity("LmisViewAttdance",
					LmisViewAttdanceImpl.class);
			return q.list();

		} catch (Exception e) {
			System.out
					.println("Error in LmisViewAttdanceFinderImpl.getListAttDailyorder: "
							+ e.toString());
			return new ArrayList<LmisViewAttdance>();
		}
	}
	
	
	public List<LmisViewAttdance> getListAttByRootAndDay(
			int rootId, Date dayValue){
		Session session = null;
		try {			
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			String dateStr = df.format(dayValue);
			session = openSession();
			StringBuilder sql = new StringBuilder();		
			sql.append("select * from vw_attendance where root_id= "
					+ rootId + " AND day_value= '" + dateStr + "' ");
		    sql.append(" order by  last_name asc, absence desc ");
			System.out.println("SQL content LmisViewAttdanceFinderImpl.getListAttByRootAndDay: "
							+ sql.toString());
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.addEntity("LmisViewAttdance",
					LmisViewAttdanceImpl.class);
			return q.list();

		} catch (Exception e) {
			System.out
					.println("Error in LmisViewAttdanceFinderImpl.getListAttByRootAndDay: "
							+ e.toString());
			return new ArrayList<LmisViewAttdance>();
		}
	}
}
