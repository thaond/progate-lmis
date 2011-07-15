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

import org.apache.commons.collections.ListUtils;

import larion.progate.lmis.model.LmisViewStaffRootOrgFN;
import larion.progate.model.ProgateOrganizationsStaffs;

import larion.progate.lmis.service.base.LmisViewStaffRootOrgFNLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisViewStaffRootOrgFNFinderUtil;
import larion.progate.lmis.service.persistence.LmisViewStaffRootOrgFNUtil;
import larion.progate.service.persistence.ProgateOrganizationsStaffsUtil;
import larion.progate.lmis.service.utils.LmisConst;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

/**
 * <a href="LmisViewStaffRootOrgFNLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class LmisViewStaffRootOrgFNLocalServiceImpl extends
		LmisViewStaffRootOrgFNLocalServiceBaseImpl {

	
	public java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgFN> findByRootID(
			int rootId) throws com.liferay.portal.SystemException {
		return LmisViewStaffRootOrgFNUtil.findByRootID(rootId);
	}


	public java.util.List<larion.progate.lmis.model.LmisViewStaffRootOrgFN> findByOrgID(
			int orgId) throws com.liferay.portal.SystemException {
		return LmisViewStaffRootOrgFNUtil.findByOrgID(orgId);
	}

	
	public List<LmisViewStaffRootOrgFN> findstaff(int rootid)
			throws PortalException, SystemException {
		return LmisViewStaffRootOrgFNFinderUtil.findstaffs(rootid);
	}

	
	public int editScanncerCode(int rootId, int userId, String newcode)
	throws PortalException, SystemException
	{
		try{
			List<LmisViewStaffRootOrgFN> lsRoot = LmisViewStaffRootOrgFNUtil.findByRootID(rootId);
			List<LmisViewStaffRootOrgFN> lsUser = LmisViewStaffRootOrgFNUtil.findByUserId(userId);
			List<LmisViewStaffRootOrgFN> lsResutl = ListUtils.intersection(lsRoot, lsUser);
			if(lsResutl.isEmpty())
			{
				System.out.println("Null return intersection: LmisViewStaffRootOrgFNLocalServiceImpl.editScanncerCode");
				return LmisConst.Config_Code_Null;
			}
			else{
				Iterator<LmisViewStaffRootOrgFN> iCheck = lsRoot.iterator();
				while(iCheck.hasNext())
				{
					LmisViewStaffRootOrgFN itemCheck = iCheck.next();
					System.out.println(itemCheck.getScannerCode());
					if(newcode.equals(itemCheck.getScannerCode()))
					{
						if(itemCheck.getUserId()==userId){
							System.out.println("Duplicate: userId has newcode = oldcode "+userId+"|"+newcode);
							return LmisConst.Config_Code_Success;
						}
						else{
							System.out.println("Duplicate: scanner code with "+userId+"|"+newcode);
							return LmisConst.Config_Code_Duplicate;
						}
						
						
						
					}
				}
					ArrayList<Integer> arrPK = new ArrayList<Integer>();
					Iterator<LmisViewStaffRootOrgFN> iter = lsResutl.iterator();
					while(iter.hasNext())
					{
						LmisViewStaffRootOrgFN item = iter.next();
						arrPK.add(item.getPrimaryKey());
					}
					System.out.println("Success: get List PK in lsResult, step 2: update newcode");
					int max = arrPK.size();
					for(int i : arrPK)
					{
						ProgateOrganizationsStaffs item = ProgateOrganizationsStaffsUtil.findByPrimaryKey(i);
						item.setScannerCode(newcode);
						ProgateOrganizationsStaffsUtil.update(item, false);
					}
					return LmisConst.Config_Code_Success;
			}
		}catch (Exception e) {
			System.out.println("Error in : LmisViewStaffRootOrgFNLocalServiceImpl.editScanncerCode" );
			e.printStackTrace();
			return LmisConst.Config_Code_FALSE;
		}
	
	}
	
}
