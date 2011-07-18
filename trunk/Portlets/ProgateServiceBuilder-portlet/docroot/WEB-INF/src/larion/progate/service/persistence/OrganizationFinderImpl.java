package larion.progate.service.persistence;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import larion.progate.lmis.model.LmisViewAttdance;
import larion.progate.lmis.model.impl.LmisViewAttdanceImpl;
import larion.progate.model.Organization;
import larion.progate.model.impl.OrganizationImpl;
import larion.progate.service.utils.Constants;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class OrganizationFinderImpl extends BasePersistenceImpl implements
		OrganizationFinder {
	public static String GET_PROJECTS_OF_PM = "ProjectsOfPM";
	public static String GET_PROJECTS_OF_BOD = "ProjectsOfBOD";
	public static String GET_COMPANY = "Company";

	public List<Organization> getProjectOfPM(int rootId, int userId)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_PROJECTS_OF_PM);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("Organization", OrganizationImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(rootId);
			qPos.add(userId); // userID cua PM
			qPos.add(Constants.ROLE_ID_MANAGER); // role PM la 5
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in OrganizationFinderImpl.getProjectOfPM "
							+ e.toString());
			return null;
		}
	}

	public List<Organization> getProjectOfBOD(int rootId)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_PROJECTS_OF_BOD);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("Organization", OrganizationImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(9); // role cua BDD la 9
			qPos.add(rootId);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in OrganizationFinderImpl.getProjectOfBOD "
							+ e.toString());
			return null;
		}
	}

	public List<Organization> getCompany() throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_COMPANY);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("Organization", OrganizationImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			return (List) query.list();
		} catch (Exception e) {
			System.out.println("ERROR in OrganizationFinderImpl.getCompany "
					+ e.toString());
			return null;
		}
	}
	
	public List<Organization> getOrganizationByRootId(int rootId){
		Session session = null;
		try {			
		
			session = openSession();
			StringBuilder sql = new StringBuilder();		
			sql.append("select * from  organizations where root_id= "
					+ rootId );
		    sql.append(" order by  name asc ");
			System.out.println("SQL content OrganizationImpl.getOrganizationByRootId: "
							+ sql.toString());
			SQLQuery q = session.createSQLQuery(sql.toString());
			System.out.println("Success in OrganizationFinderImpl.getOrganizationByRootId    ");
			System.out.println(sql.toString());
			q.addEntity("Organization",
					OrganizationImpl.class);
			return q.list();

		} catch (Exception e) {
			System.out
					.println("Error in OrganizationFinderImpl.getOrganizationByRootId: "
							+ e.toString());
			return new ArrayList<Organization>();
		}
	}
}