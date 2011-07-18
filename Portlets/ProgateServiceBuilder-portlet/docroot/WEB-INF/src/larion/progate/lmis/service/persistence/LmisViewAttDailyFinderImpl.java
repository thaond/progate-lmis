package larion.progate.lmis.service.persistence;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import larion.progate.lmis.model.LmisViewAttDaily;
import larion.progate.lmis.model.impl.LmisViewAttDailyImpl;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;


public class LmisViewAttDailyFinderImpl extends BasePersistenceImpl implements
		LmisViewAttDailyFinder {
	
	@Override
	public List<LmisViewAttDaily> getListAttByRootAndDay(
			int rootId, Date dayValue,int subOrgId){
		Session session = null;
		try {			
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			String dateStr = df.format(dayValue);
			session = openSession();
			StringBuilder sql = new StringBuilder();		
			sql.append("select * from vw_attendance_daily where root_id= "
					+ rootId + " AND day_value= '" + dateStr + "' ");
		    sql.append(" AND org_id = " + subOrgId  );		  
		    sql.append(" order by  last_name asc, absence desc ");
			System.out
					.println("SQL content LmisViewAttDailyFinderImpl.getListAttByRootAndDay: "
							+ sql.toString());
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.addEntity("LmisViewAttDaily",
					LmisViewAttDailyImpl.class);
			return q.list();

		} catch (Exception e) {
			System.out
					.println("Error in LmisViewAttDailyFinderImpl.getListAttByRootAndDay: "
							+ e.toString());
			return new ArrayList<LmisViewAttDaily>();
		}
	}
	
}
