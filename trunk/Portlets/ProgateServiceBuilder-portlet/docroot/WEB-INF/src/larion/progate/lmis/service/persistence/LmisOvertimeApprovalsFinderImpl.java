package larion.progate.lmis.service.persistence;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;


public class LmisOvertimeApprovalsFinderImpl extends BasePersistenceImpl
		implements LmisOvertimeApprovalsFinder {
	
	public  ArrayList<Integer> getListOverTimeApproval(int rootId, int approvedBy) throws SystemException { 
        Session session = null; 
        try { 
        	
            session = openSession(); 
            System.out.println("open sesion");	   
            String sql = "select report_id " 
				+" from lmis_overtime_approvals "			 				
				+ "where report_id> 0 and root_id =" + rootId + " AND approved_by=" + approvedBy ;
            
        	System.out
			.println("SQL content LmisOvertimeApprovalsFinderImpl.getListOverTimeApproval: "
					+ sql.toString());     
            SQLQuery query = session.createSQLQuery(sql); 	    
          
            ArrayList<Integer> lsInt = new ArrayList<Integer>();
           List ls = query.list();     
            System.out.println("ls content:"+ls);
			Set<Integer> s = new HashSet<Integer>();
			if(ls.size() >0){
				for(Object i: ls){
					Integer tmp = Integer.parseInt(i.toString());
					System.out.println("tmp "+ tmp);
					if(s.add(tmp)){
						lsInt.add(tmp);
					}
					
				}
			}
			return lsInt;
		} catch (Exception e) {
			System.out.println("Error in LmisOvertimeApprovals.getListOverTimeApproval");
			return new ArrayList<Integer>();
		}
		
	}
	
}
