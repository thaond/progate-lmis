package com.larion.progate.cds.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import larion.progate.model.Organization;
import larion.progate.model.ProGateOrgsUsersPermissions;
import larion.progate.model.ProGatePermissions;
import larion.progate.model.ProgateOrganizationsStaffs;
import larion.progate.model.ViewOrgUsersPermissions;
import larion.progate.model.ViewProGatePermissionsRoles;
import larion.progate.model.impl.ProGateOrgsUsersPermissionsImpl;
import larion.progate.service.OrganizationLocalServiceUtil;
import larion.progate.service.ProGateOrgsUsersPermissionsLocalServiceUtil;
import larion.progate.service.ProGatePermissionsLocalServiceUtil;
import larion.progate.service.ProgateOrganizationsStaffsLocalServiceUtil;
import larion.progate.service.ViewOrgUsersPermissionsLocalServiceUtil;
import larion.progate.service.ViewProGatePermissionsRolesLocalServiceUtil;

import com.larion.progate.cds.constant.RequestConst;
import com.larion.progate.cds.utils.PermissionAndRole;
import com.larion.progate.common.action.ParameterizableViewAction;
import com.larion.progate.common.constants.Request;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;

public class BuildingPermitAction extends ParameterizableViewAction {

	private PermissionAndRole perAndRoleOnTab1 = new PermissionAndRole();
	private PermissionAndRole perAndRoleOnTab2 = new PermissionAndRole();

	@Override
	public void handleActionRequestInternal(ActionRequest request,
			ActionResponse response, Map<String, Object> bean) throws Exception {

		int userId = ParamUtil.getInteger(request, "userId");
		int rootId = ParamUtil.getInteger(request, Request.ORG_ID);
		String[] listPerId = request.getParameterValues("listPerId");
		if (listPerId == null) {
			boolean b = ProGateOrgsUsersPermissionsLocalServiceUtil
					.deleteProGateOrgsUsersPermission(
							RequestConst.APPLICATION_ID,
							RequestConst.CATEGORY_ID, rootId, userId);
			System.out.println(b);
		}
		if (listPerId != null) {
			List<ProGateOrgsUsersPermissions> listId = new ArrayList<ProGateOrgsUsersPermissions>();
			for (int i = 0; i < listPerId.length; i++) {
				ProGateOrgsUsersPermissions a = new ProGateOrgsUsersPermissionsImpl();
				a.setPermissionId(listPerId[i]);
				listId.add(a);
			}
			boolean a = ProGateOrgsUsersPermissionsLocalServiceUtil
					.addProGateOrgsUsersPermission(RequestConst.APPLICATION_ID,
							RequestConst.CATEGORY_ID, rootId, userId, listId,
							1, false);
			System.out.println(a);
		}
	}

	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {

		try {

			int rootId = ParamUtil.getInteger(request, Request.ORG_ID);
			if (rootId == 0) {
				HttpServletRequest orgReq = PortalUtil
						.getOriginalServletRequest(PortalUtil
								.getHttpServletRequest(request));
				rootId = ParamUtil.getInteger(orgReq, Request.ORG_ID);
			}
			bean.put("orgId", rootId);

			ServiceContext sc = ServiceContextFactory.getInstance(this
					.getClass().getName(), request);
			int user = (int) sc.getUserId();

			perAndRoleOnTab1.check(rootId, user,
					RequestConst.PERMISSION_ROLE_PER);
			perAndRoleOnTab2.check(rootId, user,
					RequestConst.PERMISSION_USER_PER);

			bean.put("hasPermissionOnTab1", perAndRoleOnTab1.isPermitted());
			bean.put("hasPermissionOnTab2", perAndRoleOnTab2.isPermitted());

			String tab = ParamUtil.getString(request, RequestConst.TAB);
			if (tab == null || tab.equals("")) {
				if (perAndRoleOnTab1.isPermitted()) {
					tab = RequestConst.TAB_BUILDING_PERMIT_1;
				} else if (perAndRoleOnTab2.isPermitted()) {
					tab = RequestConst.TAB_BUILDING_PERMIT_2;
				} else {
					tab = RequestConst.TAB_BUILDING_PERMIT_1;
				}
			}

			if (RequestConst.TAB_BUILDING_PERMIT_1.equals(tab)) {
				if (perAndRoleOnTab1.isPermitted()) {
				int roleId = ParamUtil.getInteger(request, "roleId", RequestConst.ROLE_EMPLOYEE);
					bean.put("roleId", roleId);
					List<ProGatePermissions> fullPer = ProGatePermissionsLocalServiceUtil
						.findProGatePermissions(RequestConst.APPLICATION_ID,
								RequestConst.CATEGORY_ID);
					bean.put("fullPer", fullPer);
					List<ViewProGatePermissionsRoles> rolePer = ViewProGatePermissionsRolesLocalServiceUtil
						.findProGatePermissionsRoles(
								RequestConst.APPLICATION_ID,
								RequestConst.CATEGORY_ID, roleId);
					bean.put("rolePer", rolePer);
				}
			}

			if (RequestConst.TAB_BUILDING_PERMIT_2.equals(tab)) {
				if (perAndRoleOnTab2.isPermitted()) {
					List<Organization> listOrg = OrganizationLocalServiceUtil
							.getProjectOfBOD(rootId);
					bean.put("listOrg", listOrg);
					int org = ParamUtil.getInteger(request, "org", 0);
					if (org == 0) {
						org = listOrg.get(0).getOrgId();
					}
					bean.put("org", org);

					List<ProgateOrganizationsStaffs> listUserId = ProgateOrganizationsStaffsLocalServiceUtil
							.getEmployeesInPermissions(rootId, org);
					bean.put("listUserId", listUserId);
					bean.put("datasize", listUserId.size());
					int userId = ParamUtil.getInteger(request, "userId", 0);
					if (userId == 0 && listUserId.size() != 0) {
						userId = listUserId.get(0).getUserId();
					}
					bean.put("userId", userId);

					if (userId != 0) {
						List<ProGatePermissions> fullPer = ProGatePermissionsLocalServiceUtil
							.findProGatePermissions(
									RequestConst.APPLICATION_ID,
									RequestConst.CATEGORY_ID);
						bean.put("fullPer", fullPer);
						boolean delegate = false;
						List<ViewOrgUsersPermissions> userPer = ViewOrgUsersPermissionsLocalServiceUtil
							.findUsersPermissions(rootId, userId,
									RequestConst.APPLICATION_ID,
									RequestConst.CATEGORY_ID, 2, delegate);
						bean.put("userPer", userPer);
					}
				}
			}

			bean.put("activedTab", tab);
			bean.put("TAB_BUILDING_PERMIT_1",
					RequestConst.TAB_BUILDING_PERMIT_1);
			bean.put("TAB_BUILDING_PERMIT_2",
					RequestConst.TAB_BUILDING_PERMIT_2);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
