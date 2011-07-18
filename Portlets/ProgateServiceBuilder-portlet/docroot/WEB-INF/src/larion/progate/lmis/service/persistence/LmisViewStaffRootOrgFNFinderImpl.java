package larion.progate.lmis.service.persistence;

import java.util.List;

import larion.progate.lmis.model.LmisViewStaffRootOrgFN;
import larion.progate.lmis.model.impl.LmisViewStaffRootOrgFNImpl;

import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl; 
import com.liferay.portal.kernel.dao.orm.QueryPos; 
import com.liferay.portal.kernel.dao.orm.SQLQuery; 
import com.liferay.portal.kernel.dao.orm.Session; 
import com.liferay.util.dao.orm.CustomSQLUtil;

import com.liferay.portal.SystemException;

public class LmisViewStaffRootOrgFNFinderImpl extends BasePersistenceImpl implements LmisViewStaffRootOrgFNFinder {
	 public static String FIND_STAFF = "findstaff";

	    public List<LmisViewStaffRootOrgFN> findstaffs(int rootid) throws SystemException { 
	        Session session = null; 
	        try { 
	        	
	            session = openSession(); 
	            System.out.println("open sesion");
	            String sql = CustomSQLUtil.get(FIND_STAFF); 
	            System.out.println(sql.toString());
	            SQLQuery query = session.createSQLQuery(sql); 
	            System.out.println("query : " + query);
	            query.addEntity("LmisViewStaffRootOrgFN", LmisViewStaffRootOrgFNImpl.class); 
	            System.out.println("test entity");
	            QueryPos qPos = QueryPos.getInstance(query); 
	            System.out.println(sql.toString());
	            qPos.add(rootid); 
	            System.out.println(" tra ve rootid " + rootid );
	            return query.list(); 	            
	        } catch (Exception e) { 
	        } 
	        return null; 
	    }

	}

	 
