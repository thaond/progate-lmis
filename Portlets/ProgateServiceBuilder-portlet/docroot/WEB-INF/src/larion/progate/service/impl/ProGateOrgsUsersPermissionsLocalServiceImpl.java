/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package larion.progate.service.impl;



import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.ListUtils;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

import larion.progate.lmis.model.LmisOvertimeRequests;
import larion.progate.model.ProGateOrgsUsersPermissions;
import larion.progate.lmis.service.LmisOvertimeRequestsLocalServiceUtil;
import larion.progate.service.ProGateOrgsUsersPermissionsLocalServiceUtil;
import larion.progate.service.base.ProGateOrgsUsersPermissionsLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisGeneralSettingsFinderUtil;
import larion.progate.service.persistence.ProGateApplicationsUtil;
import larion.progate.service.persistence.ProGateOrgsUsersPermissionsFinderUtil;
import larion.progate.service.persistence.ProGateOrgsUsersPermissionsUtil;
import larion.progate.lmis.service.utils.LmisConst;
import larion.progate.lmis.service.utils.LmisUtils;

/**
 * <a href="ProGateOrgsUsersPermissionsLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class ProGateOrgsUsersPermissionsLocalServiceImpl extends
		ProGateOrgsUsersPermissionsLocalServiceBaseImpl {
	
	public List<ProGateOrgsUsersPermissions> findGrantPermissions (int appId,int category, int orgId, int userId,String perid) throws SystemException, PortalException {
		return ProGateOrgsUsersPermissionsFinderUtil.getGrantPermissions( appId,category, orgId,  userId,perid);
	}
	/* (non-Javadoc)
	 * @see larion.progate.service.ProGateOrgsUsersPermissionsLocalService#getListGrantPermissions(int, int, int, int)
	 * Lay danh sach quyen duoc uy quyen cua user theo category(check)
	 */

	
	public List<ProGateOrgsUsersPermissions> getListGrantPermissions (int appId,int category, int orgId, int userId,int pmId) throws SystemException, PortalException {

		return ProGateOrgsUsersPermissionsFinderUtil.getListGrantPermissions(appId, category, orgId, userId,pmId);
	}
	
	/**
	 * @param appId
	 * @param category
	 * @param orgId
	 * @param userId
	 * @param userPermissions
	 * @param value
	 * @param isGrant
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 * Edit uy quyen
	 */


	public boolean editGrantPermission(int appId, int category,
			int orgId, int userId,
			List<ProGateOrgsUsersPermissions> userPermissions, int value,
			boolean isGrant,int pmId) throws SystemException, PortalException {
		try {
			System.out.println("list init userPermissions  : " + userPermissions.toString());
			// Lay danh sach cac quyen da duoc user them ung voi app va category
			List<ProGateOrgsUsersPermissions> listOrgsUsersPer = ProGateOrgsUsersPermissionsFinderUtil
					.getOrgsUsersPermissions(appId, category, orgId, userId);
			//xoa het then noi
			for (ProGateOrgsUsersPermissions per : listOrgsUsersPer) {
				deleteProGateOrgsUsersPermissions(per);
				System.out.println("check size ProGateOrgsUsersPermissions [ ] = : "+ per.toString());
			}
			
			//check it nhat 1
			if (userPermissions != null) {
				System.out.println("list quyen truyen vao  :"+ userPermissions.size());
				//them moi quyen dc uy quyen
				for (int i = 0; i < userPermissions.size(); i++) {
					ProGateOrgsUsersPermissions permission = userPermissions.get(i);
					ProGateOrgsUsersPermissions orgsUsersPer  = ProGateOrgsUsersPermissionsLocalServiceUtil.createProGateOrgsUsersPermissions(null);
					orgsUsersPer.setOrgId(orgId);
					orgsUsersPer.setUserId(userId);
					orgsUsersPer.setPermissionId(permission.getPermissionId());
					orgsUsersPer.setIsGrant(true);
					orgsUsersPer.setPmId(pmId);				
					ProGateOrgsUsersPermissionsUtil.update(orgsUsersPer, false);
					System.out.println("list quyen sau khi them   :"+ orgsUsersPer.toString());
				}
				// cho user duoc uy quyen tam thoi la pm ngang cap voi pm cua no
				String role = LmisUtils.getUserRoleByUID(userId, orgId);
				if( role ==LmisConst.IS_STAFF)
				{
				String check = LmisGeneralSettingsFinderUtil.updateRoleUser(orgId, userId, LmisConst.Staff, LmisConst.PM);
				System.out.println("Check ok : t= " + check);
				System.out.println("Role user  " + role.toString());
				}
				System.out.println("Role user  " + role.toString());				
			/*	//Lay quyen co san cua nhan vien thuong theo category		
//				List<String> ls2 = new ArrayList<String>();
				List<ViewProGatePermissionsRoles> list= ViewProGatePermissionsRolesLocalServiceUtil.findProGatePermissionsRoles(appId, category, LmisConst.Staff);
				for (ViewProGatePermissionsRoles j : list) {
					ls2.add(j.getPrimaryKey());					
				}
				System.out.println("ls2 step1 "+ ls2.toString());
				
				
				//Cong voi nhung quyen vua duoc uy quyen theo category
				List<ProGateOrgsUsersPermissions> ls= ProGateOrgsUsersPermissionsLocalServiceUtil.getListGrantPermissions(appId, category, orgId, userId, pmId) ;
				
				for (ProGateOrgsUsersPermissions i: ls) {
					ls2.add(i.getPermissionId());
				}
				System.out.println("ls  "+ ls.toString());
				// xet quyen xuong new cho user
				ProGateOrgsUsersPermissionsLocalServiceUtil.addProGateOrgsUsersPermission(appId, category, orgId, userId, ls, 1, true);*/
				
				return true;
			}
			// uncheck all tra ve user(4 quyen ca nhan) duoc uy quyen ve lai nhu cu...
			else{
				// cho user tro ve role 8
				int count = ProGateOrgsUsersPermissionsUtil.countByUserId(userId);
				System.out.println("Count userid: "+ count);
				if(count>=1)
				{
				String checked = LmisGeneralSettingsFinderUtil.updateRoleUser(orgId, userId,  LmisConst.PM,LmisConst.Staff);
				System.out.println("Checked ok : t= " + checked);
				}
				String role = LmisUtils.getUserRoleByUID(userId, orgId);
				System.out.println("Role user  " + role.toString());
				
				return true;
			}		
		} catch (Exception e) {
			String checked = LmisGeneralSettingsFinderUtil.updateRoleUser(orgId, userId,  LmisConst.PM,LmisConst.Staff);
			String role = LmisUtils.getUserRoleByUID(userId, orgId);
			System.out.println("Role user  " + role.toString());
			System.out.println("Checked ok : t= " + checked);
			System.out
					.println("ERROR in ProGateOrgsUsersPermissionsLocalServiceImpl.editGrantPermission "
							+ e.toString());
			return false;
		}
	}
		
	public boolean addProGateOrgsUsersPermission(String appName, int category,
			int orgId, int userId,
			List<ProGateOrgsUsersPermissions> userPermissions, int value,
			boolean isGrant) throws SystemException, PortalException {
		try {
			//Lay appId
			int appId = ProGateApplicationsUtil.findByname(appName).get(0).getProGateApplicationsId();
			// Lay danh sach cac quyen da duoc user them ung voi app va category
			List<ProGateOrgsUsersPermissions> listOrgsUsersPer = ProGateOrgsUsersPermissionsFinderUtil
					.getOrgsUsersPermissions(appId, category, orgId, userId);
			for (ProGateOrgsUsersPermissions per : listOrgsUsersPer) {
				deleteProGateOrgsUsersPermissions(per);
			}
			if (userPermissions != null) {
				for (int i = 0; i < userPermissions.size(); i++) {
					ProGateOrgsUsersPermissions permission = userPermissions
							.get(i);
					ProGateOrgsUsersPermissions orgsUsersPer = createProGateOrgsUsersPermissions(null);
					orgsUsersPer.setOrgId(orgId);
					orgsUsersPer.setUserId(userId);
					orgsUsersPer.setPermissionId(permission.getPermissionId());
					ProGateOrgsUsersPermissions orgsUsersPer1 = addProGateOrgsUsersPermissions(orgsUsersPer);
				}
			}
			return true;
		} catch (Exception e) {
			System.out
					.println("ERROR in ProGateOrgsUsersPermissionsLocalServiceImpl.addProGateOrgsUsersPermission "
							+ e.toString());
			return false;
		}
	}

	public boolean deleteProGateOrgsUsersPermission(String appName, int category, int orgId, int userId)
			throws SystemException, PortalException {
		try {
			//Lay appId
			int appId = ProGateApplicationsUtil.findByname(appName).get(0).getProGateApplicationsId();
			// Lay danh sach cac quyen da duoc user them ung voi app va category
			List<ProGateOrgsUsersPermissions> listOrgsUsersPer = ProGateOrgsUsersPermissionsFinderUtil
					.getOrgsUsersPermissions(appId, category, orgId, userId);
			for (ProGateOrgsUsersPermissions per : listOrgsUsersPer) {
				deleteProGateOrgsUsersPermissions(per);
			}
			return true;
		} catch (Exception e) {
			System.out
					.println("ERROR in ProGateOrgsUsersPermissionsLocalServiceImpl.deleteProGateOrgsUsersPermission "
							+ e.toString());
			return false;
		}
	}
}