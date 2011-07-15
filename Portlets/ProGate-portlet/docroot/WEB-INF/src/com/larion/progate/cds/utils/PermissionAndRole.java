package com.larion.progate.cds.utils;

import larion.progate.service.ViewOrgUsersPermissionsLocalServiceUtil;

import com.larion.progate.cds.constant.RequestConst;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

public class PermissionAndRole {
	boolean isPermitted;
	int userRole;

	public boolean isPermitted() {
		return isPermitted;
	}

	public void setPermitted(boolean isPermitted) {
		this.isPermitted = isPermitted;
	}

	public int getUserRole() {
		return userRole;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

	public void check(int rootId, int userId, String perId) throws PortalException, SystemException{
		int checkPermission = ViewOrgUsersPermissionsLocalServiceUtil.checkUserSpecialPermission(RequestConst.APPLICATION_ID, RequestConst.CATEGORY_ID, rootId, userId, perId);
//		int checkPermission = ViewOrgUsersPermissionsLocalServiceUtil.checkUserSpecialPermission("", 0, rootId, userId, perId);
		System.out.println("--------------------------");
		System.out.println("rootId="+rootId);
		System.out.println("userId="+userId);
		System.out.println("perId="+perId);
		System.out.println("checkPermission="+checkPermission);
		
		if (checkPermission == 0){
			setPermitted(false);
		} else {
			setPermitted(true);
			if (checkPermission == 1){
				setUserRole(RequestConst.ROLE_EMPLOYEE);
			}
			
			if (checkPermission == 2){
				setUserRole(RequestConst.ROLE_PM);
			}
			
			if (checkPermission == 3){
				setUserRole(RequestConst.ROLE_BOD);
			}
		}
	}
}
