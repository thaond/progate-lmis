package larion.progate.service.persistence;



import java.util.List;

import larion.progate.model.ProGateOrgsUsersPermissions;
import larion.progate.model.impl.ProGateOrgsUsersPermissionsImpl;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class ProGateOrgsUsersPermissionsFinderImpl extends BasePersistenceImpl
		implements ProGateOrgsUsersPermissionsFinder {
	public static String GET_SPECIAL_PERMISSIONS = "SpecialPermissions";
	public static String GET_ORGS_USERS_PERMISSIONS = "OrgsUsersPermission";
	public static String GET_GRANT_PERMISSIONS = "GrantPermissions"; 
	public static String GET_LIST_GRANT_PERMISSIONS = "ListGrantPermissions";
	
	public List<ProGateOrgsUsersPermissions> getGrantPermissions(int appId,
			int category, int orgId, int userId, String perId)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_GRANT_PERMISSIONS);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ProGateOrgsUsersPermissions",
					ProGateOrgsUsersPermissionsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(appId);
			qPos.add(category);
			qPos.add(orgId);
			qPos.add(userId);		
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in ProGateOrgsUsersPermissionsFinderImpl.getGrantPermissions "
							+ e.toString());
			return null;
		}
	}

	public List<ProGateOrgsUsersPermissions> getSpecialPermissions(int appId,
			int category, int orgId, int userId, String perId)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_SPECIAL_PERMISSIONS);
			System.out.println("getSpecialPermissions " + sql);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ProGateOrgsUsersPermissions",
					ProGateOrgsUsersPermissionsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(appId);
			qPos.add(category);
			qPos.add(orgId);
			qPos.add(userId);
			qPos.add(perId);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in ProGateOrgsUsersPermissionsFinderImpl.getSpecialPermissions "
							+ e.toString());
			return null;
		}
	}

	public List<ProGateOrgsUsersPermissions> getOrgsUsersPermissions(int appId,
			int category, int orgId, int userId)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_ORGS_USERS_PERMISSIONS);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ProGateOrgsUsersPermissions",
					ProGateOrgsUsersPermissionsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(orgId);
			qPos.add(userId);
			qPos.add(appId);
			qPos.add(category);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in ProGateOrgsUsersPermissionsFinderImpl.getOrgsUsersPermissions "
							+ e.toString());
			return null;
		}
	}
	
	public List<ProGateOrgsUsersPermissions> getListGrantPermissions(int appId,
			int category, int orgId, int userId, int PmId)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_LIST_GRANT_PERMISSIONS);
			System.out.println("sql getListGrantPermissions  "+ sql);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ProGateOrgsUsersPermissions",
					ProGateOrgsUsersPermissionsImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(appId);
			qPos.add(category);
			qPos.add(orgId);
			qPos.add(userId);	
			qPos.add(PmId);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in ProGateOrgsUsersPermissionsFinderImpl.getListGrantPermissions "
							+ e.toString());
			return null;
		}
	}
}
