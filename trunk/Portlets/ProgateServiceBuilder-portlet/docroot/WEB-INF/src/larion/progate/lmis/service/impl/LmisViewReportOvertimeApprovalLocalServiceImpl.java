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

import com.liferay.portal.SystemException;
import larion.progate.lmis.model.LmisViewReportOvertimeApproval;
import larion.progate.lmis.service.LmisViewReportOvertimeApprovalLocalServiceUtil;
import larion.progate.lmis.service.base.LmisViewReportOvertimeApprovalLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisOvertimeApprovalsFinderUtil;
import larion.progate.lmis.service.persistence.LmisViewReportOvertimeApprovalUtil;
import larion.progate.lmis.service.utils.LmisConst;

/**
 * <a href="LmisViewReportOvertimeApprovalLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class LmisViewReportOvertimeApprovalLocalServiceImpl extends
		LmisViewReportOvertimeApprovalLocalServiceBaseImpl {
	
	public int countReportPending(int rootId) throws SystemException{
		List<LmisViewReportOvertimeApproval> lsRoot = LmisViewReportOvertimeApprovalUtil.findByRootID(rootId);
		List<LmisViewReportOvertimeApproval> ls = LmisViewReportOvertimeApprovalUtil.findByReportedStatus(LmisConst.OverTimeReport_Status_Pending);
		List<LmisViewReportOvertimeApproval> lsfinal= ListUtils.intersection(lsRoot, ls) ;
		return lsfinal.size();
	}	

	public ArrayList<Integer> getListOverTimeApproval(int rootId, int approvedBy)
			throws com.liferay.portal.SystemException {
		try {
		
		ArrayList<Integer> arrPmId = new ArrayList<Integer>();
		arrPmId = LmisOvertimeApprovalsFinderUtil.getListOverTimeApproval(rootId, approvedBy);
		return  arrPmId;
		} catch (SystemException e) {
			System.out
					.println("Error in LmisViewReportOvertimeApproval.getListOverTimeApproval");
			e.printStackTrace();
		}
		return null;
	}

	public List<LmisViewReportOvertimeApproval> getListApproval(
			int rootId, int approvedBy)
			throws com.liferay.portal.SystemException {
		try {
			ArrayList<Integer> arrPmID = LmisViewReportOvertimeApprovalLocalServiceUtil.getListOverTimeApproval(rootId, approvedBy);
			System.out.println("Content " + arrPmID.toString());
			List<LmisViewReportOvertimeApproval> ls = new ArrayList<LmisViewReportOvertimeApproval>();
			for (int i : arrPmID) {
				LmisViewReportOvertimeApproval obj = LmisViewReportOvertimeApprovalUtil.fetchByPrimaryKey(i);
				if(obj.getReportedStatus()!= 4)
				{
				ls.add(obj);
				}
			}			
			System.out
					.println("Success: LmisViewReportOvertimeApproval.getListApproval");
			return ls;
		} catch (SystemException e) {
			System.out
					.println("Error in LmisViewReportOvertimeApproval  approvedBy has id ="
							+ approvedBy);
			e.printStackTrace();
		}
		return null;
	}
	

	
	public List<LmisViewReportOvertimeApproval> getListApprovalForBOD(
			int rootId, int approvedBy,int orgId,int status)
			throws com.liferay.portal.SystemException {
		try {
			ArrayList<Integer> arrPmID = LmisViewReportOvertimeApprovalLocalServiceUtil.getListOverTimeApproval(rootId, approvedBy);
			System.out.println("Content " + arrPmID.toString());
			List<LmisViewReportOvertimeApproval> ls = new ArrayList<LmisViewReportOvertimeApproval>();
			for (int i : arrPmID) {
				LmisViewReportOvertimeApproval obj = LmisViewReportOvertimeApprovalUtil.fetchByPrimaryKey(i);
				if(obj.getReportedStatus()!= 4)
				{
				ls.add(obj);
				}
			}			
			
			List<LmisViewReportOvertimeApproval> lsOrg= LmisViewReportOvertimeApprovalUtil.findByOrgID(orgId);
			System.out.println("lsOrg "+lsOrg.toString());
			if(orgId==-1){
				List<LmisViewReportOvertimeApproval> lsStatus= LmisViewReportOvertimeApprovalUtil.findByReportedStatus(status);
				System.out.println("lsStatus "+ lsStatus.toString());
				List<LmisViewReportOvertimeApproval> lsFinal= ListUtils.intersection(ls,lsStatus);
				System.out.println("lsFinal "+ lsFinal.toString());
				System.out.println("Success: LmisViewReportOvertimeApproval.getListApprovalForBOD");
				return lsFinal;
			}
			
			if(status!=-1)			{
			List<LmisViewReportOvertimeApproval> lsStatus= LmisViewReportOvertimeApprovalUtil.findByReportedStatus(status);
			System.out.println("lsStatus "+ lsStatus.toString());
			List<LmisViewReportOvertimeApproval> lsFinal= ListUtils.intersection(ls,ListUtils.intersection(lsStatus,lsOrg));
			System.out.println("lsFinal "+ lsFinal.toString());
			System.out.println("Success: LmisViewReportOvertimeApproval.getListApprovalForBOD");
			return lsFinal;
			}
			else
			{
				List<LmisViewReportOvertimeApproval> lsFinal= ListUtils.intersection(ls,lsOrg);
				System.out.println("Success: LmisViewReportOvertimeApproval.getListApprovalForBOD");
				System.out.println("lsFinal "+ lsFinal.toString());
				return lsFinal;
			}
	
		} catch (Exception e) {
			System.out
					.println("Error in LmisViewReportOvertimeApproval  approvedBy has id ="
							+ approvedBy);
			e.printStackTrace();
		}
		return null;
	}
	
	public List<LmisViewReportOvertimeApproval> getListApprovalForPM(
			int rootId, int approvedBy,int status)
			throws com.liferay.portal.SystemException {
		try {
			ArrayList<Integer> arrPmID = LmisViewReportOvertimeApprovalLocalServiceUtil.getListOverTimeApproval(rootId, approvedBy);
			System.out.println("Content " + arrPmID.toString());
			List<LmisViewReportOvertimeApproval> ls = new ArrayList<LmisViewReportOvertimeApproval>();
			for (int i : arrPmID) {
				LmisViewReportOvertimeApproval obj = LmisViewReportOvertimeApprovalUtil.fetchByPrimaryKey(i);
				if(obj.getReportedStatus()!= 4)
				{
				ls.add(obj);
				}
			}			
			System.out.println("Success: LmisViewReportOvertimeApproval.getListApproval");			
			if(status!=-1)			{
			List<LmisViewReportOvertimeApproval> lsStatus= LmisViewReportOvertimeApprovalUtil.findByReportedStatus(status);
			List<LmisViewReportOvertimeApproval> lsFinal= ListUtils.intersection(ls,lsStatus);
			return lsFinal;
			}
			else
			{
				
				return ls;
			}
		} catch (SystemException e) {
			System.out
					.println("Error in LmisViewReportOvertimeApproval  approvedBy has id ="
							+ approvedBy);
			e.printStackTrace();
		}
		return null;
	}
}