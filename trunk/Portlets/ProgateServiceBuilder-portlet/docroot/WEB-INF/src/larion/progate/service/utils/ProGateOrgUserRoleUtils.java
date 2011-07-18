package larion.progate.service.utils;

import java.util.List;

import org.apache.commons.collections.ListUtils;

//import larion.progate.model.ProGateOrgsUsersRoles;
//import larion.progate.service.persistence.ProGateOrgsUsersRolesUtil;

public class ProGateOrgUserRoleUtils {
//
//	@SuppressWarnings("unchecked")
//	public static ProGateOrgsUsersRoles createOrgUserRole(int orgId,
//			long userId, int roleId) {
//		try {
//			ProGateOrgsUsersRoles object = null;
//
//			List<ProGateOrgsUsersRoles> result = ListUtils.intersection(
//					ProGateOrgsUsersRolesUtil.findByorgId(orgId),
//					ProGateOrgsUsersRolesUtil.findByuserId((int) userId));
//
//			if (result != null && result.size() > 0) {
//				object = result.get(0);
//			} else {
//				object = ProGateOrgsUsersRolesUtil.create(null);
//				object.setUserId((int) userId);
//				object.setOrgId(orgId);
//			}
//
//			object.setRoleId(roleId);
//			ProGateOrgsUsersRolesUtil.update(object, false);
//			return object;
//		} catch (Exception e) {
//			System.out
//					.println("There are some errors in ProGateOrgUserRoleUtils.createOrgAdmin"
//							+ e.toString());
//			return null;
//		}
//	}
//
//	@SuppressWarnings("unchecked")
//	public static ProGateOrgsUsersRoles deleteOrgUserRole(int orgId,
//			long userId, int roleId) {
//		try {
//			ProGateOrgsUsersRoles object = null;
//
//			List<ProGateOrgsUsersRoles> checkResult = ListUtils.intersection(
//					ProGateOrgsUsersRolesUtil.findByorgId(orgId), ListUtils
//							.intersection(ProGateOrgsUsersRolesUtil
//									.findByroleId(roleId),
//									ProGateOrgsUsersRolesUtil
//											.findByuserId((int) userId)));
//
//			if (checkResult != null && checkResult.size() != 0) {
//				ProGateOrgsUsersRolesUtil.remove(checkResult.get(0));
//			} else {
//				System.out.println("OrgId + UserId + RoleId existed");
//			}
//
//			return object;
//		} catch (Exception e) {
//			System.out
//					.println("There are some errors in ProGateOrgUserRoleUtils.createOrgAdmin"
//							+ e.toString());
//			return null;
//		}
//	}
//
//	@SuppressWarnings("unchecked")
//	public static ProGateOrgsUsersRoles deleteOrgUserRole(int orgId, long userId) {
//		try {
//			ProGateOrgsUsersRoles object = null;
//
//			List<ProGateOrgsUsersRoles> checkResult = ListUtils.intersection(
//					ProGateOrgsUsersRolesUtil.findByorgId(orgId),
//					ProGateOrgsUsersRolesUtil.findByuserId((int) userId));
//
//			if (checkResult != null && checkResult.size() != 0) {
//				ProGateOrgsUsersRolesUtil.remove(checkResult.get(0));
//			} else {
//				System.out.println("OrgId + UserId + RoleId existed");
//			}
//
//			return object;
//		} catch (Exception e) {
//			System.out
//					.println("There are some errors in ProGateOrgUserRoleUtils.createOrgAdmin"
//							+ e.toString());
//			return null;
//		}
//	}
}