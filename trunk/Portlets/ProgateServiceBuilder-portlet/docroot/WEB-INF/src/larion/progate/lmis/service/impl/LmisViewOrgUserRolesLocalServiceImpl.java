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

package larion.progate.lmis.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hsqldb.lib.HashSet;

import com.liferay.portal.SystemException;

import larion.progate.lmis.service.base.LmisViewOrgUserRolesLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisViewOrgUserRolesUtil;
import larion.progate.lmis.service.utils.LmisConst;
import larion.progate.lmis.model.LmisViewOrgUserRoles;

/**
 * <a href="LmisViewOrgUserRolesLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class LmisViewOrgUserRolesLocalServiceImpl
	extends LmisViewOrgUserRolesLocalServiceBaseImpl {
	public  List<LmisViewOrgUserRoles> getListOrgByUserIdPM(int userId,int rootId)		throws com.liferay.portal.SystemException {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		try {
			List<LmisViewOrgUserRoles> lsResult = LmisViewOrgUserRolesUtil.findByUserID(userId);
			if (lsResult.size() != 0) {
				Iterator<larion.progate.lmis.model.LmisViewOrgUserRoles> it = lsResult.iterator();
				while (it.hasNext()) {
					larion.progate.lmis.model.LmisViewOrgUserRoles i = it.next();
					if(i.getRoleId()==LmisConst.PM)		arr.add(i.getPrimaryKey());				
				}	
				System.out.println("content arr "+ arr.toString());
				List<LmisViewOrgUserRoles> ls = new ArrayList<LmisViewOrgUserRoles>();
				for (int i : arr) {
					LmisViewOrgUserRoles obj = LmisViewOrgUserRolesUtil.fetchByPrimaryKey(i);
					ls.add(obj);
				}					
				return ls;
			}
		} catch (SystemException e) {
			System.out
					.println("Error in ProGateOrgsUsersRole.getListOrgByUserIdPM");
			e.printStackTrace();
		}
		return null;
	}
	public List<LmisViewOrgUserRoles> getListOrgByRootId(int rootId) throws SystemException {
		List<LmisViewOrgUserRoles> lsRoot = LmisViewOrgUserRolesUtil.findByRootID(rootId);
		String removed =null;
		if(lsRoot.size() >0){
			for(LmisViewOrgUserRoles i: lsRoot){
				if(i.getOrgId()==rootId){
					removed = i.getOrgName();
					break;
				}
			}
			List<LmisViewOrgUserRoles> lsRemoved = new ArrayList<LmisViewOrgUserRoles>();
			for(LmisViewOrgUserRoles i: lsRoot){
				if(!i.getOrgName().equals(removed)){
					lsRemoved.add(i);
				}
			}
			List<LmisViewOrgUserRoles> lsResult = new ArrayList<LmisViewOrgUserRoles>();
			Set<String> s = new java.util.HashSet<String>();
			for(LmisViewOrgUserRoles i: lsRemoved){
				if(s.add(i.getOrgName())){
					lsResult.add(i);
				}
			}
			System.out.println("list getListOrgByRootId"+lsResult);
			return lsResult;
		}
		else{
			return new ArrayList<LmisViewOrgUserRoles>();
		}
		
	}
}