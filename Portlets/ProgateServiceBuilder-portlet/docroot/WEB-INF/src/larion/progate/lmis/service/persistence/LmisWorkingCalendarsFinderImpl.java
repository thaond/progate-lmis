package larion.progate.lmis.service.persistence;

import java.util.List;


import larion.progate.lmis.model.LmisWorkingCalendars;


import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class LmisWorkingCalendarsFinderImpl extends BasePersistenceImpl implements LmisWorkingCalendarsFinder {
	
	 public static String GET_LIST_WORKING_CALENDAR= "getlistworkingcalendar";

	 
		@SuppressWarnings("unchecked")
		public  List<LmisWorkingCalendars> workingcalendar(int rootid,int year,int month) throws SystemException { 
	        Session session = null; 
	        try { 
	        	
	            session = openSession(); 
	            System.out.println("open sesion");	     
//	            String sql = "select lmis_check_and_create_working_calendar(100,2011,08)";	 
	            String sql = "select lmis_check_and_create_working_calendar("+rootid+","+year+","+month+")";
	            SQLQuery query = session.createSQLQuery(sql); 	      
	            System.out.println(query.toString());         
	            return query.list();         	            
	        } catch (Exception e) { 
	        } 
	        return null; 
	    }

}



