package larion.progate.service.persistence;

import java.util.List;

import larion.progate.model.ProGatePermissions;
import larion.progate.model.ViewOrgUsersPermissions;
import larion.progate.model.ViewProGatePermissionsRoles;
import larion.progate.model.impl.ProGatePermissionsImpl;
import larion.progate.model.impl.ViewOrgUsersPermissionsImpl;
import larion.progate.model.impl.ViewProGatePermissionsRolesImpl;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class ViewOrgUsersPermissionsFinderImpl extends BasePersistenceImpl
		implements ViewOrgUsersPermissionsFinder {
	public List<ViewOrgUsersPermissions> findOrgPermissions(int rootId,
			int roleId, int appId, int category) throws SystemException,
			PortalException {
		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT * "
					+ "FROM vw_organizations_users_permissions "
					+ "WHERE root_id = " + rootId + " AND role_id = " + roleId
					+ " AND app_id = " + appId + " AND category = " + category;
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ViewOrgUsersPermissions",
					ViewOrgUsersPermissionsImpl.class);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewOrgUsersPermissionsFinderImpl.findOrgPermissions"
							+ e.toString());
			return null;
		}
	}

	public List<ViewOrgUsersPermissions> findUsersPermissions(int rootId,
			int userId, int appId, int category, int priority, boolean delegate)
			throws SystemException, PortalException {
		Session session = null;
		try {
			session = openSession();
			String sql;
			if (delegate == false) {
				sql = "SELECT * " + "FROM vw_organizations_users_permissions "
						+ "WHERE root_id = " + rootId + " AND user_id = "
						+ userId + " AND app_id = " + appId
						+ " AND category = " + category + " AND priority <> "
						+ priority;
			} else {
				sql = "SELECT * " + "FROM vw_organizations_users_permissions "
						+ "WHERE root_id = " + rootId + " AND user_id = "
						+ userId + " AND app_id = " + appId
						+ " AND category = " + category + " AND priority = "
						+ priority;
			}

			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ViewOrgUsersPermissions",
					ViewOrgUsersPermissionsImpl.class);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewOrgUsersPermissionsFinderImpl.findUsersPermissions"
							+ e.toString());
			return null;
		}
	}

	public List<ProGatePermissions> findProGatePermissions(int appId,
			int category) throws SystemException, PortalException {
		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT * " + "FROM progate_permissions "
					+ "WHERE app_id = " + appId + " AND category = " + category;
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ProGatePermissions", ProGatePermissionsImpl.class);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewOrgUsersPermissionsFinderImpl.findProGatePermissions"
							+ e.toString());
			return null;
		}
	}

	public List<ViewProGatePermissionsRoles> findProGatePermissionsRoles(
			int appId, int category, int roleId) throws SystemException,
			PortalException {
		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT * " + "FROM v_progate_permissions_roles "
					+ "WHERE app_id = " + appId + " AND category = " + category
					+ " AND role_id = " + roleId;
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ViewProGatePermissionsRoles",
					ViewProGatePermissionsRolesImpl.class);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewOrgUsersPermissionsFinderImpl.findProGatePermissionsRoles"
							+ e.toString());
			return null;
		}
	}

	public List<ViewOrgUsersPermissions> getListPermissions(int appId,
			int category, int rootId, int orgId, int userId, boolean isRoot)
			throws SystemException, PortalException {
		Session session = null;
		try {
			session = openSession();
			String sql;
			if (isRoot == true) {
				sql = "SELECT DISTINCT MAX(id) as id, org_id, root_id, user_id, role_id, per_id, app_id, "
						+ "category, description, MAX(value) as value"
						+ " FROM vw_organizations_users_permissions"
						+ " WHERE app_id = "
						+ appId
						+ " AND category = "
						+ category
						+ " AND user_id = "
						+ userId
						+ " AND root_id = "
						+ rootId
						+ " GROUP BY org_id, root_id, user_id, role_id, per_id, app_id, "
						+ "category, description";
			} else {
				sql = "SELECT DISTINCT MAX(id) as id, org_id, root_id, user_id, role_id, per_id, app_id, "
						+ "category, description, MAX(value) as value"
						+ " FROM vw_organizations_users_permissions"
						+ " WHERE app_id = "
						+ appId
						+ " AND category = "
						+ category
						+ " AND user_id = "
						+ userId
						+ " AND ((org_id = "
						+ orgId
						+ ") OR (root_id = "
						+ rootId
						+ " AND role_id = -1))"
						+ " GROUP BY org_id, root_id, user_id, role_id, per_id, app_id, "
						+ "category, description";
			}
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ViewOrgUsersPermissions",
					ViewOrgUsersPermissionsImpl.class);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewOrgUsersPermissionsFinderImpl.getListPermissions"
							+ e.toString());
			return null;
		}
	}

	public boolean checkPermissions(int appId, int category, int rootId,
			int orgId, int userId, boolean isRoot, String perId)
			throws SystemException, PortalException {
		Session session = null;
		try {
			session = openSession();
			String sql;
			if (isRoot == true) {
				sql = "SELECT MAX(id) as id, org_id, root_id, user_id, role_id, per_id, app_id, "
						+ "category, description, MAX(value) as value"
						+ " FROM vw_organizations_users_permissions"
						+ " WHERE app_id = "
						+ appId
						+ " AND category = "
						+ category
						+ " AND user_id = "
						+ userId
						+ " AND root_id = "
						+ rootId
						+ " AND per_id = '"
						+ perId
						+ "'"
						+ " GROUP BY org_id, root_id, user_id, role_id, per_id, app_id, "
						+ "category, description";
			} else {
				sql = "SELECT MAX(id) as id, org_id, root_id, user_id, role_id, per_id, app_id, "
						+ "category, description, MAX(value) as value"
						+ " FROM vw_organizations_users_permissions"
						+ " WHERE app_id = "
						+ appId
						+ " AND category = "
						+ category
						+ " AND user_id = "
						+ userId
						+ " AND ((org_id = "
						+ orgId
						+ ") OR (root_id = "
						+ rootId
						+ " AND role_id = -1))"
						+ " AND per_id = '"
						+ perId
						+ "'"
						+ " GROUP BY org_id, root_id, user_id, role_id, per_id, app_id, "
						+ "category, description";
			}
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ViewOrgUsersPermissions",
					ViewOrgUsersPermissionsImpl.class);
			List<ViewOrgUsersPermissions> list = (List) query.list();
			if (list != null)
				return true;
			else
				return false;
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewOrgUsersPermissionsFinderImpl.checkPermissions "
							+ e.toString());
			return false;
		}
	}

	public List<ViewOrgUsersPermissions> findRoleByUserId(int appId,
			int category, int rootId, int orgId, int userId)
			throws SystemException, PortalException {
		Session session = null;
		try {
			session = openSession();
			if (orgId != 0) {
				String sql = "SELECT * "
						+ "FROM vw_organizations_users_permissions "
						+ "WHERE app_id = " + appId + " AND category = "
						+ category + " AND root_id = " + rootId
						+ " AND org_id = " + orgId + " AND user_id = " + userId
						+ " ORDER BY role_id DESC";
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity("ViewOrgUsersPermissions",
						ViewOrgUsersPermissionsImpl.class);
				return (List) query.list();
			} else {
				String sql = "SELECT * "
						+ "FROM vw_organizations_users_permissions "
						+ "WHERE app_id = " + appId + " AND category = "
						+ category + " AND root_id = " + rootId
						+ " AND user_id = " + userId + " ORDER BY role_id DESC";
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity("ViewOrgUsersPermissions",
						ViewOrgUsersPermissionsImpl.class);
				return (List) query.list();
			}
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewOrgUsersPermissionsFinderImpl.findRoleByUserId"
							+ e.toString());
			return null;
		}
	}
}