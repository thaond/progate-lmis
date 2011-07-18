package larion.progate.service.persistence;

import java.util.List;

import larion.progate.model.ViewProGatePermissionsRoles;
import larion.progate.model.impl.ViewProGatePermissionsRolesImpl;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class ViewProGatePermissionsRolesFinderImpl extends BasePersistenceImpl
		implements ViewProGatePermissionsRolesFinder {
	public static String GET_ROLES_PERMISSIONS = "RolesPermissions";

	public List<ViewProGatePermissionsRoles> getRolePermissions(int appId,
			int category, int roleId, String perId) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_ROLES_PERMISSIONS);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("ViewProGatePermissionsRoles",
					ViewProGatePermissionsRolesImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(appId);
			qPos.add(category);
			qPos.add(roleId);
			qPos.add(perId);
			return (List) query.list();
		} catch (Exception e) {
			System.out
					.println("ERROR in ViewProGatePermissionsRolesFinderImpl.getRolePermissions "
							+ e.toString());
			return null;
		}
	}
}