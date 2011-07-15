package larion.progate.lmis.service.persistence;

import java.util.ArrayList;
import java.util.List;

import larion.progate.lmis.model.LmisViewStaffRootOrgOrdered;
import larion.progate.lmis.model.impl.LmisViewStaffRootOrgOrderedImpl;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class LmisViewStaffRootOrgOrderedFinderImpl extends BasePersistenceImpl
		implements LmisViewStaffRootOrgOrderedFinder {
	public static String FIND_STAFF_ORDER = "findStaffCode";

	public List<LmisViewStaffRootOrgOrdered> findAttCode(int rootId)	throws SystemException {

		Session session = null;
		try {

			session = openSession();
			// System.out.println("open sesion");
			String sql = "select max(id) as id,user_id,max(root_id)as root_id,max(org_id) as org_id ,max(bod_id) as bod_id,"
					+ " max(staff_code) as staff_code, scanner_code,max(screenname) as screenname,max(fullname) as fullname, "
					+ " max(firstname) as firstname, max(lastname) as lastname,max(emailaddress) as emailaddress"
					+ " from vw_staff_root_org_fn_ordered "
					+ " WHERE (vw_staff_root_org_fn_ordered.root_id =?)"
					+ " group by user_id, scanner_code"
					+ " ORDER BY lastname, firstname;";
			System.out.println("sql : " + sql);
			SQLQuery query = session.createSQLQuery(sql);
			// System.out.println("query : " + query);
			query.addEntity("LmisViewStaffRootOrgOrdered",
					LmisViewStaffRootOrgOrderedImpl.class);
			// System.out.println("test entity");
			QueryPos qPos = QueryPos.getInstance(query);
			// System.out.println("test q");
			qPos.add(rootId);

			return query.list();
		} catch (Exception e) {
			System.out.println("Error in LmisViewStaffRootOrgOrderedFinderImpl.findAttCode:"+e.toString());
		}
		return null;
	}

	public List<LmisViewStaffRootOrgOrdered> findAttCodeOrg(int rootId,int orgId) {

		Session session = null;
		try {

			session = openSession();
			// System.out.println("open sesion");
			String sql = "select max(id) as id,user_id,max(root_id)as root_id,max(org_id) as org_id ,max(bod_id) as bod_id,"
					+ " max(staff_code) as staff_code, scanner_code,max(screenname) as screenname,max(fullname) as fullname, "
					+ " max(firstname) as firstname, max(lastname) as lastname,max(emailaddress) as emailaddress"
					+ " from vw_staff_root_org_fn_ordered "
					+ " WHERE (vw_staff_root_org_fn_ordered.root_id =?) AND (vw_staff_root_org_fn_ordered.org_id = ? )"
					+ " group by user_id, scanner_code"
					+ " ORDER BY lastname, firstname;";
			System.out.println("sql : " + sql);
			SQLQuery query = session.createSQLQuery(sql);
			// System.out.println("query : " + query);
			query.addEntity("LmisViewStaffRootOrgOrdered",
					LmisViewStaffRootOrgOrderedImpl.class);
			// System.out.println("test entity");
			QueryPos qPos = QueryPos.getInstance(query);
			// System.out.println("test q");
			qPos.add(rootId);
			qPos.add(orgId);

			return query.list();
		} catch (Exception e) {
			System.out.println("Error in LmisViewStaffRootOrgOrderedFinderImpl.findAttCodeOrg:"+e.toString());
			return new ArrayList<LmisViewStaffRootOrgOrdered>();
		}
	}
	public List<LmisViewStaffRootOrgOrdered> getListStaffOfOrg(int rootId, int orgId){
		Session session = null;
		try {
			session = openSession(); 
			String sql = "SELECT * FROM vw_staff_root_org_fn_ordered WHERE root_id="+rootId + " AND org_id="+orgId + " ORDER BY lastname, firstname;";
			System.out.println("SQL content: "+sql);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("LmisViewStaffRootOrgOrdered", LmisViewStaffRootOrgOrderedImpl.class);
			return q.list();
		} catch (Exception e) {
			System.out.println("Error LmisViewStaffRootOrgOrderedFinderImpl.getListStaffOfOrg "+e.toString());
			return new ArrayList<LmisViewStaffRootOrgOrdered>();
		}
	}
}
