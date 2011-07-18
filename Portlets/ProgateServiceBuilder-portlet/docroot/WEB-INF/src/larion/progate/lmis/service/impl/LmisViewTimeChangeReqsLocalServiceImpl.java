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

import larion.progate.lmis.model.LmisTimeChangeApprovals;
import larion.progate.lmis.model.LmisViewTimeChangeReqs;
import larion.progate.lmis.service.LmisTimeChangeRequestsLocalServiceUtil;
import larion.progate.lmis.service.LmisViewTimeChangeReqsLocalServiceUtil;
import larion.progate.lmis.service.base.LmisViewTimeChangeReqsLocalServiceBaseImpl;
import larion.progate.lmis.service.persistence.LmisAbsenceRequestsFinderUtil;
import larion.progate.lmis.service.persistence.LmisTimeChangeApprovalsUtil;
import larion.progate.lmis.service.persistence.LmisTimeChangeRequestsUtil;
import larion.progate.lmis.service.persistence.LmisViewTimeChangeReqsUtil;
import larion.progate.lmis.service.utils.LmisConst;

/**
 * <a href="LmisViewTimeChangeReqsLocalServiceImpl.java.html"><b><i>View
 * Source</i></b></a>
 * 
 * @author Brian Wing Shun Chan
 * 
 */
public class LmisViewTimeChangeReqsLocalServiceImpl extends
		LmisViewTimeChangeReqsLocalServiceBaseImpl {
	public List<larion.progate.lmis.model.LmisViewTimeChangeReqs> getListReqsByRootId(
			int rootId) throws com.liferay.portal.SystemException {
		return LmisViewTimeChangeReqsUtil.findByRootId(rootId);
	}

	public java.util.List<larion.progate.lmis.model.LmisViewTimeChangeReqs> getListTimeChangeReqs(
			int rootId, int approvalBy) throws SystemException {
		List<LmisViewTimeChangeReqs> tmp = new ArrayList<LmisViewTimeChangeReqs>();
		try {
			List<LmisTimeChangeApprovals> lsRoot = LmisTimeChangeApprovalsUtil.findByRootId(rootId);
			List<LmisTimeChangeApprovals> lsApp = LmisTimeChangeApprovalsUtil.findByApprovedBy(approvalBy);
			List<LmisTimeChangeApprovals> lsResult = ListUtils.intersection(lsRoot, lsApp);
			System.out.println(lsRoot.toString());
			System.out.println(lsApp.toString());
			System.out.println(lsResult.toString());
			if(lsResult.isEmpty())
			{
				System.out.println("Return null when do intersec at: LmisViewTimeChangeReqsLocalServiceImpl.getListTimeChangeReqs ");
				
				return tmp;
			}
			Iterator<LmisTimeChangeApprovals> it = lsResult.iterator();
			
			ArrayList<Integer> arrReqPk = new ArrayList<Integer>();
			while(it.hasNext())
			{
				LmisTimeChangeApprovals item = it.next();
				arrReqPk.add(item.getRequestId());
				System.out.println("Add :" + item.getRequestId());
			}
			List<LmisViewTimeChangeReqs> result = new ArrayList<LmisViewTimeChangeReqs>();
			System.out.println("Create new list");
			
			for(int i: arrReqPk)
			{
				LmisViewTimeChangeReqs item = LmisViewTimeChangeReqsUtil.fetchByPrimaryKey(i);
				if(!result.add(item))
				{
					System.out.println("Error in LmisViewTimeChangeReqsLocalServiceImpl.getListTimeChangeReqs, can't add LmisViewTimeChangeReqs to result ");
				}
			}
			return result;
		} catch (Exception e) {
			System.out
					.println("Error in LmisViewTimeChangeReqsLocalServiceImpl.getListRequestTimeChangeOf :"
							+ e.toString());
			e.printStackTrace();
		}
		return tmp;
	}

	public LmisViewTimeChangeReqs getDetailViewReqTimeChange(int rootId,
			int requestId) throws SystemException {
		try {
			LmisViewTimeChangeReqs result = LmisViewTimeChangeReqsUtil
					.fetchByPrimaryKey(requestId);
			if (result.getRootId() == rootId) {
				return result;
			} else {
				System.out
						.println("Error in LmisViewTimeChangeReqsLocalServiceImpl.getDetailRequestTimeChange, not match rootId:"
								+ rootId);
			}
		} catch (Exception e) {
			System.out
					.println("Error in LmisViewTimeChangeReqsLocalServiceImpl.getDetailRequestTimeChange"
							+ e.toString());
		}
		return null;
	}
	public int countRequestOfUID(int rootId, int userId) throws SystemException{
		List<LmisViewTimeChangeReqs> ls = LmisViewTimeChangeReqsUtil.findByUserId(userId);
		return ls.size();
	}
	public List<LmisViewTimeChangeReqs> filterByStatusTabManager(int rootId,int userId, int status ){
		try {
			List<LmisTimeChangeApprovals> lsRoot  = LmisTimeChangeApprovalsUtil.findByRootId(rootId);
			List<LmisTimeChangeApprovals> lsUser  = LmisTimeChangeApprovalsUtil.findByApprovedBy(userId);
			List<LmisTimeChangeApprovals> lsInt = ListUtils.intersection(lsRoot, lsUser);
			if(lsInt.isEmpty() ){
				System.out.println("Error in LmisTimeChangeRequestsLocalServiceImpl.filterByStatus: list is empty when intersect");
				return new ArrayList<LmisViewTimeChangeReqs>();
			}
			ArrayList<Integer> lsArr = new ArrayList<Integer>();
			for (LmisTimeChangeApprovals i : lsInt) {
				lsArr.add(i.getPrimaryKey());
			}
			//LmisAbsenceRequestsFinderImpl
			List<LmisViewTimeChangeReqs> lsR = LmisAbsenceRequestsFinderUtil.filterByStatusTabManager(rootId, userId, status, lsArr);
			return lsR;
			
		} catch (Exception e) {
			System.out.println("Error in LmisTimeChangeRequestsLocalServiceImpl.filterByStatusTabManager" + e.toString());
			return new ArrayList<LmisViewTimeChangeReqs>();
		}
	}
	public List<LmisViewTimeChangeReqs> filterByStatusTabOther(int rootId, int status ){
		try {
					
			return LmisAbsenceRequestsFinderUtil. filterByStatusTabOther(rootId, status);
			
		} catch (Exception e) {
			System.out.println("Error in LmisTimeChangeRequestsLocalServiceImpl.filterByStatusTabOther: "+e.toString());
			return new ArrayList<LmisViewTimeChangeReqs>();
		}
		
	}
}